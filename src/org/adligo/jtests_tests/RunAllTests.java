package org.adligo.jtests_tests;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.adligo.jtests.models.shared.I_AbstractTrial;
import org.adligo.jtests.models.shared.asserts.I_AssertionData;
import org.adligo.jtests.models.shared.asserts.line_text.LineTextCompareResult;
import org.adligo.jtests.models.shared.results.I_TestResult;
import org.adligo.jtests.models.shared.results.I_TestFailure;
import org.adligo.jtests.models.shared.results.I_TrialResult;
import org.adligo.jtests.models.shared.results.I_TestRunResult;
import org.adligo.jtests.models.shared.results.I_TrialFailure;
import org.adligo.jtests.models.shared.system.I_TestRunListener;
import org.adligo.jtests.models.shared.system.RunParameters;
import org.adligo.jtests.reports.console.LineTextComparisonReport;
import org.adligo.jtests.run.JTestUncaughtExceptionHandler;
import org.adligo.jtests.run.JTests;
import org.adligo.jtests_tests.use_case_trials.Assert_PassConditions_Trial;
import org.adligo.jtests_tests.use_case_trials.Run_ClassTrial_Trial;
import org.adligo.jtests_tests.use_case_trials.Run_FunctionalTrial_Trial;
import org.adligo.jtests_tests.use_case_trials.Run_PackageTrial_Trial;

public class RunAllTests implements I_TestRunListener {
	private PrintStream originalOut = System.out;
	private PrintStream originalErr = System.err;
	private int allTests;
	private int passedTrials;
	private int tests;
	private int asserts;
	
	public static void main(String [] args) {
		RunAllTests runAllTests = new RunAllTests();
		runAllTests.go();
		
	}

	public void go() {
		try {
			Thread.currentThread().setUncaughtExceptionHandler(JTestUncaughtExceptionHandler.HANDLER);
			RunParameters params = new RunParameters();
			List<Class<? extends I_AbstractTrial>> tests = new ArrayList<Class<? extends I_AbstractTrial>>();
			
			tests.add(Run_FunctionalTrial_Trial.class);
			tests.add(Run_ClassTrial_Trial.class);
			tests.add(Run_PackageTrial_Trial.class);
		
			tests.add(Assert_PassConditions_Trial.class);
			params.setTests(tests);
			allTests = tests.size();
			
			
			System.out.println("Running all tests ");
			JTests.run(params, this);
			
		} catch (Exception x) {
			x.printStackTrace();
		}
	}

	private void printFailure(I_TestFailure failure) {
		originalOut.println(failure.getMessage());
		
		I_AssertionData data = failure.getData();
		if (data != null) {
			Set<String> keys = data.getKeys();
			if (keys.contains(I_AssertionData.LINE_TEXT_RESULT)) {
				LineTextCompareResult result = (LineTextCompareResult)
						data.getData(I_AssertionData.LINE_TEXT_RESULT);
				LineTextComparisonReport.display(originalOut, originalErr, result);
			} else {
				for (String key: keys) {
					originalOut.println(key + "=" + data.getData(key));
				}
			}
			originalOut.println(failure.getMessage());
		}
		Throwable location = failure.getLocationFailed();
		if (location != null) {
			location.printStackTrace(originalOut);
		} else {
			Throwable exception = failure.getException();
			exception.printStackTrace(originalOut);
		}
	}


	private void printFailure(I_TrialFailure failure) {
		originalOut.println(failure.getMessage());
		Throwable exception = failure.getException();
		exception.printStackTrace(originalOut);
	}
	
	@Override
	public void onRunCompleted(I_TestRunResult result) {
		originalOut.println("Tests completed in " + result.getRunTimeSecs() + " secs");
		int minTests = 14;
		int minAsserts = 70;
		if (tests >= minTests && asserts >= minAsserts) {
			originalOut.println("");
			originalOut.println("All " + allTests + " trials passed sucessfully in " + result.getRunTimeSecs() + " secs");
			originalOut.println("" + tests + " exhibits and " + asserts + " asserts");
		} else if (tests < minTests) {
			originalOut.println("Not enough tests expected at least "
					+ minTests + " and there were " + tests);
		} else {
			originalOut.println("Not enough assert expected at least "
					+ minAsserts + " and there were " + asserts);
		}
		System.exit(0);
	}

	@Override
	public void onTestCompleted(Class<? extends I_AbstractTrial> testClass,
			I_AbstractTrial test, I_TrialResult result) {
		if (result.isPassed()) {
			passedTrials++;
			originalOut.println("The trial " + result.getName() + " passed!");
			tests += result.getExhibitCount();
			asserts += result.getAssertionCount();
			originalOut.println("Tests: " + result.getExhibitCount() + 
					" Assertions: " + result.getAssertionCount());
		} else {
			originalOut.println("The trial " + result.getName() + " FAILED!");
			I_TrialFailure failure = result.getFailure();
			if (failure != null) {
				printFailure(failure);
			} else {
				List<I_TestResult> ers =  result.getResults();
				for (I_TestResult er: ers) {
					if (!er.isPassed()) {
						printFailure(er.getFailure());
					}
				}
			}
		}
	}

}
