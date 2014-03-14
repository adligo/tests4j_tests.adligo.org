package org.adligo.jtests_tests.use_case_tests;

import java.util.ArrayList;
import java.util.List;

import org.adligo.jtests.models.shared.I_AbstractTest;
import org.adligo.jtests.models.shared.results.I_TestResult;
import org.adligo.jtests.models.shared.results.I_TestRunResult;
import org.adligo.jtests.models.shared.run.I_TestRunListener;
import org.adligo.jtests.models.shared.run.RunParameters;
import org.adligo.jtests.run.JTests;

public class ExpectedFailureRunner implements I_TestRunListener {
	private volatile Thread running;
	private I_TestResult result;
	

	public void runExpectedFailure(Class<? extends I_AbstractTest> clazz) {
		RunParameters params = new RunParameters();
		List<Class<? extends I_AbstractTest>> tests = new ArrayList<Class<? extends I_AbstractTest>>();
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

	public I_TestResult getResult() {
		return result;
	}

	@Override
	public void onTestCompleted(Class<? extends I_AbstractTest> testClass,
			I_AbstractTest test, I_TestResult pResult) {
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
