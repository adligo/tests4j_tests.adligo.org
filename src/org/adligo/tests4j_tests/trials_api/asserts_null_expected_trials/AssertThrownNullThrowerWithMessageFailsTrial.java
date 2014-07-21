package org.adligo.tests4j_tests.trials_api.asserts_null_expected_trials;

import java.util.List;

import org.adligo.tests4j.models.shared.asserts.ExpectedThrownData;
import org.adligo.tests4j.models.shared.asserts.common.I_Asserts;
import org.adligo.tests4j.models.shared.en.Tests4J_AssertionResultMessages;
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
import org.adligo.tests4j.models.shared.trials.TrialRecursion;
import org.adligo.tests4j_tests.trials_api.common.ExpectedFailureRunner;
import org.adligo.tests4j_tests.trials_api.common.MockSystem;

@TrialRecursion
@PackageScope (packageName="org.adligo.tests4j")
public class AssertThrownNullThrowerWithMessageFailsTrial extends ApiTrial {
	private boolean called = false;
	@Test
	public void testAssertThrownNull() {
		called = false;
		assertFalse(called);
		assertThrown("custom message is ignored",new ExpectedThrownData(new RuntimeException("hey")), null);
		assertTrue(called);
	}
	
	public static void runTestDelegate(I_Asserts asserts) throws Exception  {
		ExpectedFailureRunner runner = new ExpectedFailureRunner();
		runner.run(AssertThrownNullThrowerWithMessageFailsTrial.class);
		
		I_TrialRunMetadata metadata = runner.getMetadata();
		asserts.assertNotNull(metadata);
		List<? extends I_TrialMetadata> trialsMetadata = metadata.getAllTrialMetadata();
		asserts.assertNotNull(trialsMetadata);
		asserts.assertEquals("java.util.Collections$UnmodifiableRandomAccessList", 
				trialsMetadata.getClass().getName());
		asserts.assertEquals(1, trialsMetadata.size());
		I_TrialMetadata trialMeta = trialsMetadata.get(0);
		asserts.assertNotNull(trialMeta);
		asserts.assertEquals(AssertThrownNullThrowerWithMessageFailsTrial.class.getName(), 
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
		asserts.assertEquals("testAssertThrownNull", testMeta.getTestName());
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
		asserts.assertEquals("testAssertThrownNull", testResult.getName());
		asserts.assertEquals(1, testResult.getAssertionCount());
		asserts.assertEquals(1, testResult.getUniqueAssertionCount());
		
		I_TestFailure testFailure = testResult.getFailure();
		asserts.assertNotNull(testFailure);
		asserts.assertEquals(new Tests4J_AssertionResultMessages().getIThrowerIsRequired(), testFailure.getMessage());
		
		Throwable locationFailed = testFailure.getLocationFailed();
		
		StackTraceElement [] elements = locationFailed.getStackTrace();
		asserts.assertGreaterThanOrEquals(1.0, elements.length);
		StackTraceElement topElement = elements[0];
		for (int i = 0; i < elements.length; i++) {
			topElement = elements[i];
			String className = topElement.getClassName();
			if (AssertThrownNullThrowerWithMessageFailsTrial.class.getName().equals(className)) {
				break;
			}
		}
		
		asserts.assertEquals(AssertThrownNullThrowerWithMessageFailsTrial.class.getName(), topElement.getClassName());
		asserts.assertEquals("testAssertThrownNull", topElement.getMethodName());
		asserts.assertEquals(31, topElement.getLineNumber());
		
		Throwable exception = testFailure.getException();
		asserts.assertNull(exception);
		
		MockSystem tracker =  runner.getMockSystem();
		asserts.assertEquals(0, tracker.getLastStatus());
	}
	
	public static int getAsserts() {
		return 36;
	}
}
