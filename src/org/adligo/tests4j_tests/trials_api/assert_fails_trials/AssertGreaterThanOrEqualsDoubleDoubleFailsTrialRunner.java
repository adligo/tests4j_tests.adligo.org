package org.adligo.tests4j_tests.trials_api.assert_fails_trials;

import java.util.List;

import org.adligo.tests4j.models.shared.metadata.I_TestMetadata;
import org.adligo.tests4j.models.shared.metadata.I_TrialMetadata;
import org.adligo.tests4j.models.shared.metadata.I_TrialRunMetadata;
import org.adligo.tests4j.models.shared.results.I_TestResult;
import org.adligo.tests4j.models.shared.results.I_TrialFailure;
import org.adligo.tests4j.models.shared.results.I_TrialResult;
import org.adligo.tests4j.models.shared.results.TestResult;
import org.adligo.tests4j.shared.asserts.common.I_Asserts;
import org.adligo.tests4j.shared.asserts.common.I_TestFailure;
import org.adligo.tests4j.shared.asserts.line_text.TextLines;
import org.adligo.tests4j.shared.en.Tests4J_EnglishConstants;
import org.adligo.tests4j.shared.i18n.I_Tests4J_ResultMessages;
import org.adligo.tests4j_tests.trials_api.common.ExpectedFailureRunner;
import org.adligo.tests4j_tests.trials_api.common.SystemRunnerMock;

public class AssertGreaterThanOrEqualsDoubleDoubleFailsTrialRunner {
	
	@SuppressWarnings("boxing")
  public static void runTestDelegate(I_Asserts asserts)  throws Exception {
		ExpectedFailureRunner runner = new ExpectedFailureRunner();
		runner.run(AssertGreaterThanOrEqualsDoubleDoubleFailsTrial.class);
		
		I_TrialRunMetadata metadata = runner.getMetadata();
		asserts.assertNotNull(metadata);
		List<? extends I_TrialMetadata> trialsMetadata = metadata.getAllTrialMetadata();
		asserts.assertNotNull(trialsMetadata);
		asserts.assertEquals("java.util.Collections$UnmodifiableRandomAccessList", 
				trialsMetadata.getClass().getName());
		asserts.assertEquals(1, trialsMetadata.size());
		I_TrialMetadata trialMeta = trialsMetadata.get(0);
		asserts.assertNotNull(trialMeta);
		asserts.assertEquals(AssertGreaterThanOrEqualsDoubleDoubleFailsTrial.class.getName(), 
				trialMeta.getTrialName());
		asserts.assertEquals(0L, trialMeta.getTimeout());
		asserts.assertFalse(trialMeta.isIgnored());
		
		List<? extends I_TestMetadata> testsMetadata = trialMeta.getTests();
		asserts.assertNotNull(testsMetadata);
		asserts.assertEquals("java.util.Collections$UnmodifiableRandomAccessList", 
				testsMetadata.getClass().getName());
		asserts.assertEquals(1, testsMetadata.size());
		
		I_TestMetadata testMeta = testsMetadata.get(0);
		asserts.assertNotNull(testMeta);
		asserts.assertEquals("testAssertGreaterThanEqualsFailsDoubleDouble", testMeta.getTestName());
		asserts.assertEquals(0L, testMeta.getTimeout());
		
		List<I_TrialResult> results = runner.getResults();
		asserts.assertEquals(1, results.size());
		I_TrialResult result = results.get(0);
		asserts.assertNotNull(result);
		asserts.assertFalse(result.isPassed());
		List<I_TrialFailure> failures = result.getFailures();
		asserts.assertNotNull(failures);
		asserts.assertEquals(0, failures.size());
		
		List<I_TestResult> testResults = result.getResults();
		asserts.assertNotNull(testResults);
		asserts.assertEquals("java.util.Collections$UnmodifiableRandomAccessList", 
				testResults.getClass().getName());
		asserts.assertEquals(1, testResults.size());
		I_TestResult testResult = testResults.get(0);
		asserts.assertNotNull(testResult);
		asserts.assertEquals(TestResult.class.getName(),testResult.getClass().getName());
		asserts.assertFalse(testResult.isPassed());
		asserts.assertFalse(testResult.isIgnored());
		asserts.assertEquals("testAssertGreaterThanEqualsFailsDoubleDouble", testResult.getName());
		asserts.assertEquals(0, testResult.getAssertionCount());
		asserts.assertEquals(0, testResult.getUniqueAssertionCount());
		
		I_TestFailure testFailure = testResult.getFailure();
		asserts.assertNotNull(testFailure);
		I_Tests4J_ResultMessages messages =  Tests4J_EnglishConstants.ENGLISH.getResultMessages();
		asserts.assertEquals(messages.getTheActualShouldBeGreaterThanOrEqualToTheExpected(), testFailure.getFailureMessage());
		
		String failedLocation = testFailure.getFailureDetail();
		TextLines lines = new TextLines(failedLocation);
		asserts.assertEquals("org.adligo.tests4j.shared.asserts.AssertionFailureLocation", lines.getLine(0));
		asserts.assertEquals("\tat org.adligo.tests4j_tests.trials_api.assert_fails_trials."
		    + "AssertGreaterThanOrEqualsDoubleDoubleFailsTrial."
		    + "testAssertGreaterThanEqualsFailsDoubleDouble("
		    + "AssertGreaterThanOrEqualsDoubleDoubleFailsTrial.java:14)", lines.getLine(1));
		
		SystemRunnerMock tracker =  runner.getMockSystem();
		asserts.assertEquals(0, tracker.getLastStatus());
	}
	
	public static int getAsserts() {
		return 34;
	}
}
