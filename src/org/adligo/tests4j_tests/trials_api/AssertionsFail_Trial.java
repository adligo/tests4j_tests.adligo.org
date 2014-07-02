package org.adligo.tests4j_tests.trials_api;

import java.util.List;

import org.adligo.tests4j.models.shared.en.asserts.Tests4J_AssertionResultMessages;
import org.adligo.tests4j.models.shared.metadata.I_TestMetadata;
import org.adligo.tests4j.models.shared.metadata.I_TrialMetadata;
import org.adligo.tests4j.models.shared.metadata.I_TrialRunMetadata;
import org.adligo.tests4j.models.shared.results.I_TestFailure;
import org.adligo.tests4j.models.shared.results.I_TestResult;
import org.adligo.tests4j.models.shared.results.I_TrialFailure;
import org.adligo.tests4j.models.shared.results.I_TrialResult;
import org.adligo.tests4j.models.shared.results.TestResult;
import org.adligo.tests4j.models.shared.trials.ApiTrial;
import org.adligo.tests4j.models.shared.trials.PackageScope;
import org.adligo.tests4j.models.shared.trials.Test;
import org.adligo.tests4j_tests.trials_api.failing_trials.AssertFalseFailsTrial;
import org.adligo.tests4j_tests.trials_api.failing_trials.AssertFalseFailsWithMessageTrial;
import org.adligo.tests4j_tests.trials_api.failing_trials.AssertTrueFailsTrial;
import org.adligo.tests4j_tests.trials_api.failing_trials.AssertTrueIsFailsMessageTrial;

@PackageScope (packageName = "org.adligo.tests4j")
public class AssertionsFail_Trial extends ApiTrial {

	@Test
	public void testAssertFalseIsTrue() {
		ExpectedFailureRunner runner = new ExpectedFailureRunner();
		runner.run(AssertFalseFailsTrial.class);
		
		I_TrialRunMetadata metadata = runner.getMetadata();
		assertNotNull(metadata);
		List<? extends I_TrialMetadata> trialsMetadata = metadata.getAllTrialMetadata();
		assertNotNull(trialsMetadata);
		assertEquals("java.util.Collections$UnmodifiableRandomAccessList", 
				trialsMetadata.getClass().getName());
		assertEquals(1, trialsMetadata.size());
		I_TrialMetadata trialMeta = trialsMetadata.get(0);
		assertNotNull(trialMeta);
		assertEquals(AssertFalseFailsTrial.class.getName(), 
				trialMeta.getTrialName());
		assertEquals(0L, trialMeta.getTimeout());
		assertFalse(trialMeta.isSkipped());
		
		List<? extends I_TestMetadata> testsMetadata = trialMeta.getTests();
		assertNotNull(testsMetadata);
		assertEquals("java.util.Collections$UnmodifiableRandomAccessList", 
				testsMetadata.getClass().getName());
		assertEquals(1, testsMetadata.size());
		
		I_TestMetadata testMeta = testsMetadata.get(0);
		assertNotNull(testMeta);
		assertEquals("testAssertFalseIsTrue", testMeta.getTestName());
		assertEquals(0L, testMeta.getTimeout());
		
		List<I_TrialResult> results = runner.getResults();
		assertEquals(1, results.size());
		I_TrialResult result = results.get(0);
		assertNotNull(result);
		assertFalse(result.isPassed());
		I_TrialFailure failure = result.getFailure();
		assertNull(failure);
		
		List<I_TestResult> testResults = result.getResults();
		assertNotNull(testResults);
		assertEquals("java.util.Collections$UnmodifiableRandomAccessList", 
				testResults.getClass().getName());
		assertEquals(1, testResults.size());
		I_TestResult testResult = testResults.get(0);
		assertNotNull(testResult);
		assertEquals(TestResult.class.getName(),testResult.getClass().getName());
		assertFalse(testResult.isPassed());
		assertFalse(testResult.isIgnored());
		assertEquals("testAssertFalseIsTrue", testResult.getName());
		assertEquals(0, testResult.getAssertionCount());
		assertEquals(0, testResult.getUniqueAssertionCount());
		
		I_TestFailure testFailure = testResult.getFailure();
		assertNotNull(testFailure);
		assertEquals(new Tests4J_AssertionResultMessages().getTheValueShouldBeFalse(), testFailure.getMessage());
		
		Throwable locationFailed = testFailure.getLocationFailed();
		StackTraceElement [] elements = locationFailed.getStackTrace();
		assertGreaterThanOrEquals(1.0, elements.length);
		StackTraceElement topElement = elements[0];
		assertEquals(AssertFalseFailsTrial.class.getName(), topElement.getClassName());
		assertEquals("testAssertFalseIsTrue", topElement.getMethodName());
		assertEquals(14, topElement.getLineNumber());
	}
	
	
	@Test
	public void testAssertFalseIsTrueWithMessage() {
		ExpectedFailureRunner runner = new ExpectedFailureRunner();
		runner.run(AssertFalseFailsWithMessageTrial.class);
		
		I_TrialRunMetadata metadata = runner.getMetadata();
		assertNotNull(metadata);
		List<? extends I_TrialMetadata> trialsMetadata = metadata.getAllTrialMetadata();
		assertNotNull(trialsMetadata);
		assertEquals("java.util.Collections$UnmodifiableRandomAccessList", 
				trialsMetadata.getClass().getName());
		assertEquals(1, trialsMetadata.size());
		I_TrialMetadata trialMeta = trialsMetadata.get(0);
		assertNotNull(trialMeta);
		assertEquals(AssertFalseFailsWithMessageTrial.class.getName(), 
				trialMeta.getTrialName());
		assertEquals(0L, trialMeta.getTimeout());
		assertFalse(trialMeta.isSkipped());
		
		List<? extends I_TestMetadata> testsMetadata = trialMeta.getTests();
		assertNotNull(testsMetadata);
		assertEquals("java.util.Collections$UnmodifiableRandomAccessList", 
				testsMetadata.getClass().getName());
		assertEquals(1, testsMetadata.size());
		
		I_TestMetadata testMeta = testsMetadata.get(0);
		assertNotNull(testMeta);
		assertEquals("testAssertFalseIsTrueWithMessage", testMeta.getTestName());
		assertEquals(0L, testMeta.getTimeout());
		
		List<I_TrialResult> results = runner.getResults();
		assertEquals(1, results.size());
		I_TrialResult result = results.get(0);
		assertNotNull(result);
		assertFalse(result.isPassed());
		I_TrialFailure failure = result.getFailure();
		assertNull(failure);
		
		List<I_TestResult> testResults = result.getResults();
		assertNotNull(testResults);
		assertEquals("java.util.Collections$UnmodifiableRandomAccessList", 
				testResults.getClass().getName());
		assertEquals(1, testResults.size());
		I_TestResult testResult = testResults.get(0);
		assertNotNull(testResult);
		assertEquals(TestResult.class.getName(),testResult.getClass().getName());
		assertFalse(testResult.isPassed());
		assertFalse(testResult.isIgnored());
		assertEquals("testAssertFalseIsTrueWithMessage", testResult.getName());
		assertEquals(0, testResult.getAssertionCount());
		assertEquals(0, testResult.getUniqueAssertionCount());
		
		I_TestFailure testFailure = testResult.getFailure();
		assertNotNull(testFailure);
		assertEquals(AssertFalseFailsWithMessageTrial.FALSE_IS_TRUE_MESSAGE, testFailure.getMessage());
		
		Throwable locationFailed = testFailure.getLocationFailed();
		StackTraceElement [] elements = locationFailed.getStackTrace();
		assertGreaterThanOrEquals(1.0, elements.length);
		StackTraceElement topElement = elements[0];
		assertEquals(AssertFalseFailsWithMessageTrial.class.getName(), topElement.getClassName());
		assertEquals("testAssertFalseIsTrueWithMessage", topElement.getMethodName());
		assertEquals(16, topElement.getLineNumber());
	}
	
	@Test
	public void testAssertTrueIsFalse() {
		ExpectedFailureRunner runner = new ExpectedFailureRunner();
		runner.run(AssertTrueFailsTrial.class);
		
		I_TrialRunMetadata metadata = runner.getMetadata();
		assertNotNull(metadata);
		List<? extends I_TrialMetadata> trialsMetadata = metadata.getAllTrialMetadata();
		assertNotNull(trialsMetadata);
		assertEquals("java.util.Collections$UnmodifiableRandomAccessList", 
				trialsMetadata.getClass().getName());
		assertEquals(1, trialsMetadata.size());
		I_TrialMetadata trialMeta = trialsMetadata.get(0);
		assertNotNull(trialMeta);
		assertEquals(AssertTrueFailsTrial.class.getName(), 
				trialMeta.getTrialName());
		assertEquals(0L, trialMeta.getTimeout());
		assertFalse(trialMeta.isSkipped());
		
		List<? extends I_TestMetadata> testsMetadata = trialMeta.getTests();
		assertNotNull(testsMetadata);
		assertEquals("java.util.Collections$UnmodifiableRandomAccessList", 
				testsMetadata.getClass().getName());
		assertEquals(1, testsMetadata.size());
		
		I_TestMetadata testMeta = testsMetadata.get(0);
		assertNotNull(testMeta);
		assertEquals("testAssertTrueIsFalse", testMeta.getTestName());
		assertEquals(0L, testMeta.getTimeout());
		
		List<I_TrialResult> results = runner.getResults();
		assertEquals(1, results.size());
		I_TrialResult result = results.get(0);
		assertNotNull(result);
		assertFalse(result.isPassed());
		I_TrialFailure failure = result.getFailure();
		assertNull(failure);
		
		List<I_TestResult> testResults = result.getResults();
		assertNotNull(testResults);
		assertEquals("java.util.Collections$UnmodifiableRandomAccessList", 
				testResults.getClass().getName());
		assertEquals(1, testResults.size());
		I_TestResult testResult = testResults.get(0);
		assertNotNull(testResult);
		assertEquals(TestResult.class.getName(),testResult.getClass().getName());
		assertFalse(testResult.isPassed());
		assertFalse(testResult.isIgnored());
		assertEquals("testAssertTrueIsFalse", testResult.getName());
		assertEquals(0, testResult.getAssertionCount());
		assertEquals(0, testResult.getUniqueAssertionCount());
		
		I_TestFailure testFailure = testResult.getFailure();
		assertNotNull(testFailure);
		assertEquals(new Tests4J_AssertionResultMessages().getTheValueShouldBeTrue(), testFailure.getMessage());
		
		Throwable locationFailed = testFailure.getLocationFailed();
		StackTraceElement [] elements = locationFailed.getStackTrace();
		assertGreaterThanOrEquals(1.0, elements.length);
		StackTraceElement topElement = elements[0];
		assertEquals(AssertTrueFailsTrial.class.getName(), topElement.getClassName());
		assertEquals("testAssertTrueIsFalse", topElement.getMethodName());
		assertEquals(14, topElement.getLineNumber());
	}
	
	@Test
	public void testAssertTrueIsFalseWithMessage() {
		ExpectedFailureRunner runner = new ExpectedFailureRunner();
		runner.run(AssertTrueIsFailsMessageTrial.class);
		
		I_TrialRunMetadata metadata = runner.getMetadata();
		assertNotNull(metadata);
		List<? extends I_TrialMetadata> trialsMetadata = metadata.getAllTrialMetadata();
		assertNotNull(trialsMetadata);
		assertEquals("java.util.Collections$UnmodifiableRandomAccessList", 
				trialsMetadata.getClass().getName());
		assertEquals(1, trialsMetadata.size());
		I_TrialMetadata trialMeta = trialsMetadata.get(0);
		assertNotNull(trialMeta);
		assertEquals(AssertTrueIsFailsMessageTrial.class.getName(), 
				trialMeta.getTrialName());
		assertEquals(0L, trialMeta.getTimeout());
		assertFalse(trialMeta.isSkipped());
		
		List<? extends I_TestMetadata> testsMetadata = trialMeta.getTests();
		assertNotNull(testsMetadata);
		assertEquals("java.util.Collections$UnmodifiableRandomAccessList", 
				testsMetadata.getClass().getName());
		assertEquals(1, testsMetadata.size());
		
		I_TestMetadata testMeta = testsMetadata.get(0);
		assertNotNull(testMeta);
		assertEquals("testAssertTrueIsFalseWithMessage", testMeta.getTestName());
		assertEquals(0L, testMeta.getTimeout());
		
		List<I_TrialResult> results = runner.getResults();
		assertEquals(1, results.size());
		I_TrialResult result = results.get(0);
		assertNotNull(result);
		assertFalse(result.isPassed());
		I_TrialFailure failure = result.getFailure();
		assertNull(failure);
		
		List<I_TestResult> testResults = result.getResults();
		assertNotNull(testResults);
		assertEquals("java.util.Collections$UnmodifiableRandomAccessList", 
				testResults.getClass().getName());
		assertEquals(1, testResults.size());
		I_TestResult testResult = testResults.get(0);
		assertNotNull(testResult);
		assertEquals(TestResult.class.getName(),testResult.getClass().getName());
		assertFalse(testResult.isPassed());
		assertFalse(testResult.isIgnored());
		assertEquals("testAssertTrueIsFalseWithMessage", testResult.getName());
		assertEquals(0, testResult.getAssertionCount());
		assertEquals(0, testResult.getUniqueAssertionCount());
		
		I_TestFailure testFailure = testResult.getFailure();
		assertNotNull(testFailure);
		assertEquals(AssertTrueIsFailsMessageTrial.TRUE_IS_FALSE_MESSAGE, testFailure.getMessage());
		
		Throwable locationFailed = testFailure.getLocationFailed();
		StackTraceElement [] elements = locationFailed.getStackTrace();
		assertGreaterThanOrEquals(1.0, elements.length);
		StackTraceElement topElement = elements[0];
		assertEquals(AssertTrueIsFailsMessageTrial.class.getName(), topElement.getClassName());
		assertEquals("testAssertTrueIsFalseWithMessage", topElement.getMethodName());
		assertEquals(16, topElement.getLineNumber());
	}
}
