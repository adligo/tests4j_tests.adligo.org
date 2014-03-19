package org.adligo.jtests_tests.use_case_trials;

import java.util.ArrayList;
import java.util.List;

import org.adligo.jtests.models.shared.I_AbstractTrial;
import org.adligo.jtests.models.shared.results.I_TrialResult;
import org.adligo.jtests.models.shared.results.I_TestRunResult;
import org.adligo.jtests.models.shared.system.I_TestRunListener;
import org.adligo.jtests.models.shared.system.RunParameters;
import org.adligo.jtests.run.JTests;

public class ExpectedFailureRunner implements I_TestRunListener {
	private volatile Thread running;
	private I_TrialResult result;
	

	public void runExpectedFailure(Class<? extends I_AbstractTrial> clazz) {
		RunParameters params = new RunParameters();
		List<Class<? extends I_AbstractTrial>> tests = new ArrayList<Class<? extends I_AbstractTrial>>();
		tests.add(clazz);
		params.setTests(tests);
		params.setSilent(true);
		
		running = JTests.run(params, this);
		waitThis();
	}

	private synchronized void waitThis() {
		try {
			this.wait();
		} catch (InterruptedException x) {
			x.printStackTrace();
		}
	}

	public I_TrialResult getResult() {
		return result;
	}

	@Override
	public void onTestCompleted(Class<? extends I_AbstractTrial> testClass,
			I_AbstractTrial test, I_TrialResult pResult) {
		result = pResult;
	}

	@Override
	public synchronized void onRunCompleted(I_TestRunResult result) {
		try {
			this.notify();
			running.join(1);
		} catch (InterruptedException x) {
			x.printStackTrace();
		}
	}

}
