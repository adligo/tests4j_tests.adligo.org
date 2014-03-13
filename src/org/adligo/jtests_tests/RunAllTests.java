package org.adligo.jtests_tests;

import java.io.PrintStream;
import java.lang.Thread.UncaughtExceptionHandler;
import java.util.ArrayList;
import java.util.List;

import org.adligo.jtests.base.shared.I_AbstractTest;
import org.adligo.jtests.base.shared.asserts.I_AssertData;
import org.adligo.jtests.models.shared.results.I_ExhibitResult;
import org.adligo.jtests.models.shared.results.I_TestFailure;
import org.adligo.jtests.models.shared.results.I_TestResult;
import org.adligo.jtests.models.shared.run.I_AllTestsDoneListener;
import org.adligo.jtests.models.shared.run.I_TestResultsProcessor;
import org.adligo.jtests.models.shared.run.RunParameters;
import org.adligo.jtests.run.JTestUncaughtExceptionHandler;
import org.adligo.jtests.run.JTests;
import org.adligo.jtests_tests.use_case_tests.Run_ClassTest_Test;
import org.adligo.jtests_tests.use_case_tests.Run_FunctionalTest_Test;
import org.adligo.jtests_tests.use_case_tests.Run_NoJTestType_Test;

public class RunAllTests implements I_TestResultsProcessor, I_AllTestsDoneListener {
	private PrintStream originalOut = System.out;
	private PrintStream originalErr = System.err;
	private int allTests;
	private int passedTests;
	private int exhibits;
	private int asserts;
	
	public static void main(String [] args) {
		RunAllTests runAllTests = new RunAllTests();
		runAllTests.go();
		
	}

	public void go() {
		try {
			Thread.currentThread().setUncaughtExceptionHandler(JTestUncaughtExceptionHandler.HANDLER);
			RunParameters params = new RunParameters();
			List<Class<? extends I_AbstractTest>> tests = new ArrayList<Class<? extends I_AbstractTest>>();
			tests.add(Run_FunctionalTest_Test.class);
			//tests.add(Run_ClassTest_Test.class);
			//tests.add(Run_NoJTestType_Test.class);
			params.setTests(tests);
			allTests = tests.size();
			params.setAllTestsDoneListener(this);
			
			
			System.out.println("Running all tests ");
			JTests.run(params, this);
			
		} catch (Exception x) {
			x.printStackTrace();
		}
	}
	@Override
	public void process(I_TestResult result) {
		if (result.isPassed()) {
			passedTests++;
			originalOut.println("The test " + result.getTestName() + " passed!");
			exhibits += result.getExhibitCount();
			asserts += result.getAssertionCount();
			originalOut.println("Exhibits: " + result.getExhibitCount() + 
					" Assertions: " + result.getAssertionCount());
		} else {
			originalOut.println("The test " + result.getTestName() + " FAILED!");
			I_TestFailure failure = result.getFailure();
			if (failure != null) {
				printFailure(failure);
			} else {
				List<I_ExhibitResult> ers =  result.getExhibitResults();
				for (I_ExhibitResult er: ers) {
					if (!er.isPassed()) {
						printFailure(er.getFailure());
					}
				}
			}
		}
	}

	private void printFailure(I_TestFailure failure) {
		originalOut.println(failure.getMessage());
		
		I_AssertData data = failure.getData();
		if (data != null) {
			List<String> keys = data.getKeys();
			for (String key: keys) {
				originalOut.println(key + "=" + data.getData(key));
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

	@Override
	public void whenFinished() {
		int minExhibits = 2;
		int minAsserts = 8;
		if (exhibits >= minExhibits && asserts >= minAsserts) {
			originalOut.println("");
			originalOut.println("All " + allTests + " tests passed sucessfully ");
			originalOut.println("" + exhibits + " exhibits and " + asserts + " asserts");
		} else if (exhibits < minExhibits) {
			originalOut.println("Not enough exhibits expected at least "
					+ minExhibits + " and there were " + exhibits);
		} else {
			originalOut.println("Not enough assert expected at least "
					+ minAsserts + " and there were " + asserts);
		}
		System.exit(0);
	}
}
