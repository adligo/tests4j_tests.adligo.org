package org.adligo.jtests_tests.api_trials;

import java.util.ArrayList;
import java.util.List;

import org.adligo.jtests.models.shared.I_AbstractTrial;
import org.adligo.jtests.models.shared.results.I_TrialResult;
import org.adligo.jtests.models.shared.results.I_TrialRunResult;
import org.adligo.jtests.models.shared.system.I_TestRunListener;
import org.adligo.jtests.models.shared.system.RunParameters;
import org.adligo.jtests.run.JTests;

public class ExpectedFailureRunner implements I_TestRunListener {
	private I_TrialResult result;
	

	public void runExpectedFailure(Class<? extends I_AbstractTrial> clazz) {
		RunParameters params = new RunParameters();
		List<Class<? extends I_AbstractTrial>> tests = new ArrayList<Class<? extends I_AbstractTrial>>();
		tests.add(clazz);
		params.setTrials(tests);
		params.setSilent(true);
		
		JTests.run(params, this);
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
	public synchronized void onRunCompleted(I_TrialRunResult result) {
		//do nothing
	}

}
