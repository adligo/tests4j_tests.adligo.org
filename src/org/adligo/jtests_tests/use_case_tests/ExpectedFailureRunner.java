package org.adligo.jtests_tests.use_case_tests;

import java.util.ArrayList;
import java.util.List;

import org.adligo.jtests.base.shared.I_AbstractTest;
import org.adligo.jtests.models.shared.results.I_TestResult;
import org.adligo.jtests.models.shared.run.I_AllTestsDoneListener;
import org.adligo.jtests.models.shared.run.I_TestResultsProcessor;
import org.adligo.jtests.models.shared.run.RunParameters;
import org.adligo.jtests.run.JTests;

public class ExpectedFailureRunner implements I_AllTestsDoneListener, I_TestResultsProcessor {
	private volatile Thread running;
	private I_TestResult result;
	
	@Override
	public synchronized void whenFinished() {
		try {
			this.notify();
			running.join(1);
		} catch (InterruptedException x) {
			x.printStackTrace();
		}
	}

	public void runExpectedFailure(Class<? extends I_AbstractTest> clazz) {
		RunParameters params = new RunParameters();
		List<Class<? extends I_AbstractTest>> tests = new ArrayList<Class<? extends I_AbstractTest>>();
		tests.add(clazz);
		params.setTests(tests);
		params.setAllTestsDoneListener(this);
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

	@Override
	public void process(I_TestResult pResult) {
		result = pResult;
	}

	public I_TestResult getResult() {
		return result;
	}

}
