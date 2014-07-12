package org.adligo.tests4j_tests.trials_api.assert_fails_trials;

import java.util.List;

import org.adligo.tests4j.models.shared.asserts.common.I_Asserts;
import org.adligo.tests4j.models.shared.en.asserts.Tests4J_AssertionResultMessages;
import org.adligo.tests4j.models.shared.metadata.I_TestMetadata;
import org.adligo.tests4j.models.shared.metadata.I_TrialMetadata;
import org.adligo.tests4j.models.shared.metadata.I_TrialRunMetadata;
import org.adligo.tests4j.models.shared.results.I_TestFailure;
import org.adligo.tests4j.models.shared.results.I_TestResult;
import org.adligo.tests4j.models.shared.results.I_TrialFailure;
import org.adligo.tests4j.models.shared.results.I_TrialResult;
import org.adligo.tests4j.models.shared.results.TestResult;
import org.adligo.tests4j.models.shared.trials.AbstractTrial;
import org.adligo.tests4j.models.shared.trials.ApiTrial;
import org.adligo.tests4j.models.shared.trials.PackageScope;
import org.adligo.tests4j.models.shared.trials.Test;
import org.adligo.tests4j.models.shared.trials.TrialRecursion;
import org.adligo.tests4j_tests.trials_api.common.ExpectedFailureRunner;

@TrialRecursion
@PackageScope (packageName="org.adligo.tests4j")
public class AssertNotUniformNoEvaluatorWithMessageFailsTrial extends ApiTrial {

	public static final String TEST_ASSERT_FAILS_MESSAGE = "testAssertNotUniformNoEvaluatorWithMessage message";

	@Test
	public void testAssertNotUniformNoEvaluatorWithMessage() {
		assertNotUniform(TEST_ASSERT_FAILS_MESSAGE, this, this);
	}
	
	public static void runTestDelegate(I_Asserts asserts) {
		ExpectedFailureRunner runner = new ExpectedFailureRunner();
		runner.run(AssertNotUniformNoEvaluatorWithMessageFailsTrial.class);
		
		I_TrialRunMetadata metadata = runner.getMetadata();
		asserts.assertNotNull(metadata);
		List<? extends I_TrialMetadata> trialsMetadata = metadata.getAllTrialMetadata();
		asserts.assertNotNull(trialsMetadata);
		asserts.assertEquals("java.util.Collections$UnmodifiableRandomAccessList", 
				trialsMetadata.getClass().getName());
		asserts.assertEquals(1, trialsMetadata.size());
		I_TrialMetadata trialMeta = trialsMetadata.get(0);
		asserts.assertNotNull(trialMeta);
		asserts.assertEquals(AssertNotUniformNoEvaluatorWithMessageFailsTrial.class.getName(), 
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
		asserts.assertEquals("testAssertNotUniformNoEvaluatorWithMessage", testMeta.getTestName());
		asserts.assertEquals(0L, testMeta.getTimeout());
		
		List<I_TrialResult> results = runner.getResults();
		asserts.assertEquals(1, results.size());
		I_TrialResult result = results.get(0);
		asserts.assertNotNull(result);
		asserts.assertFalse(result.isPassed());
		I_TrialFailure failure = result.getFailure();
		asserts.assertNull(failure);
		
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
		asserts.assertEquals("testAssertNotUniformNoEvaluatorWithMessage", testResult.getName());
		asserts.assertEquals(0, testResult.getAssertionCount());
		asserts.assertEquals(0, testResult.getUniqueAssertionCount());
		
		I_TestFailure testFailure = testResult.getFailure();
		asserts.assertNotNull(testFailure);
		asserts.assertEquals(new Tests4J_AssertionResultMessages().getAnUnexpectedExceptionWasThrown(), testFailure.getMessage());
		
		Throwable locationFailed = testFailure.getLocationFailed();
		StackTraceElement [] elements = locationFailed.getStackTrace();
		asserts.assertGreaterThanOrEquals(1.0, elements.length);
		StackTraceElement topElement = elements[0];
		asserts.assertEquals(AbstractTrial.class.getName(), topElement.getClassName());
		asserts.assertEquals("getEvaluator", topElement.getMethodName());
		
		for (int i = 0; i < elements.length; i++) {
			topElement = elements[i];
			String className = topElement.getClassName();
			if (AssertNotUniformNoEvaluatorWithMessageFailsTrial.class.getName().equals(className)) {
				break;
			}
		}
		asserts.assertNotNull(topElement);
		asserts.assertEquals(AssertNotUniformNoEvaluatorWithMessageFailsTrial.class.getName(), topElement.getClassName());
		asserts.assertEquals("testAssertNotUniformNoEvaluatorWithMessage", topElement.getMethodName());
		asserts.assertEquals(30, topElement.getLineNumber());
		
		Throwable execption = testFailure.getException();
		asserts.assertNotNull(execption);
		asserts.assertUniform(new IllegalStateException(new Tests4J_AssertionResultMessages().getNoEvaluatorFoundForClass() +
				AssertNotUniformNoEvaluatorWithMessageFailsTrial.class.getName()), execption);
	}
	
	public static int getAsserts() {
		return 39;
	}
}
