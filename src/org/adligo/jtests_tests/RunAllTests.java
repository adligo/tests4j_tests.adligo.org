package org.adligo.jtests_tests;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.adligo.jtests.models.shared.I_AbstractTest;
import org.adligo.jtests.models.shared.asserts.I_AssertionData;
import org.adligo.jtests.models.shared.asserts.line_text.LineTextCompareResult;
import org.adligo.jtests.models.shared.results.I_ExhibitResult;
import org.adligo.jtests.models.shared.results.I_TestFailure;
import org.adligo.jtests.models.shared.results.I_TestResult;
import org.adligo.jtests.models.shared.results.I_TestRunResult;
import org.adligo.jtests.models.shared.system.I_TestRunListener;
import org.adligo.jtests.models.shared.system.RunParameters;
import org.adligo.jtests.reports.console.LineTextComparisonReport;
import org.adligo.jtests.run.JTestUncaughtExceptionHandler;
import org.adligo.jtests.run.JTests;
import org.adligo.jtests_tests.use_case_tests.Run_ClassTest_Test;
import org.adligo.jtests_tests.use_case_tests.Run_FunctionalTest_Test;
import org.adligo.jtests_tests.use_case_tests.Run_PackageTest_Test;

public class RunAllTests implements I_TestRunListener {
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
			tests.add(Run_ClassTest_Test.class);
			tests.add(Run_PackageTest_Test.class);
			
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


	@Override
	public void onRunCompleted(I_TestRunResult result) {
		originalOut.println("Tests completed in " + result.getRunTimeSecs() + " secs");
		int minExhibits = 14;
		int minAsserts = 70;
		if (exhibits >= minExhibits && asserts >= minAsserts) {
			originalOut.println("");
			originalOut.println("All " + allTests + " tests passed sucessfully in " + result.getRunTimeSecs() + " secs");
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

	@Override
	public void onTestCompleted(Class<? extends I_AbstractTest> testClass,
			I_AbstractTest test, I_TestResult result) {
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

}
