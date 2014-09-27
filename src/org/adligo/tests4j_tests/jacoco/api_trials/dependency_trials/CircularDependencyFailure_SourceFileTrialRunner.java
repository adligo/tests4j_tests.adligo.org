package org.adligo.tests4j_tests.jacoco.api_trials.dependency_trials;

import java.util.List;
import java.util.Set;

import org.adligo.tests4j.models.shared.metadata.I_TestMetadata;
import org.adligo.tests4j.models.shared.metadata.I_TrialMetadata;
import org.adligo.tests4j.models.shared.metadata.I_TrialRunMetadata;
import org.adligo.tests4j.models.shared.results.I_TestResult;
import org.adligo.tests4j.models.shared.results.I_TrialFailure;
import org.adligo.tests4j.models.shared.results.I_TrialResult;
import org.adligo.tests4j.models.shared.results.TestResult;
import org.adligo.tests4j.models.shared.trials.I_SourceFileTrial;
import org.adligo.tests4j.shared.asserts.common.AssertCompareFailure;
import org.adligo.tests4j.shared.asserts.common.AssertType;
import org.adligo.tests4j.shared.asserts.common.I_Asserts;
import org.adligo.tests4j.shared.asserts.common.I_TestFailure;
import org.adligo.tests4j.shared.asserts.common.TestFailureType;
import org.adligo.tests4j.shared.asserts.dependency.CircularDependencyFailure;
import org.adligo.tests4j.shared.en.Tests4J_EnglishConstants;
import org.adligo.tests4j.shared.i18n.I_Tests4J_ResultMessages;
import org.adligo.tests4j_4jacoco.plugin.CoveragePluginFactory;
import org.adligo.tests4j_tests.trials_api.common.ExpectedFailureRunner;
import org.adligo.tests4j_tests.trials_api.common.SystemRunnerMock;

public class CircularDependencyFailure_SourceFileTrialRunner {

	public static void runTestDelegate(I_Asserts asserts)  throws Exception {
		ExpectedFailureRunner runner = new ExpectedFailureRunner();
		runner.setCoveragPluginFactory(CoveragePluginFactory.class);
		
		runner.run(CircularDependencyFailure_SourceFileTrial.class);
		
		I_TrialRunMetadata metadata = runner.getMetadata();
		asserts.assertNotNull(metadata);
		List<? extends I_TrialMetadata> trialsMetadata = metadata.getAllTrialMetadata();
		asserts.assertNotNull(trialsMetadata);
		asserts.assertEquals("java.util.Collections$UnmodifiableRandomAccessList", 
				trialsMetadata.getClass().getName());
		asserts.assertEquals(1, trialsMetadata.size());
		I_TrialMetadata trialMeta = trialsMetadata.get(0);
		asserts.assertNotNull(trialMeta);
		asserts.assertEquals(CircularDependencyFailure_SourceFileTrial.class.getName(), 
				trialMeta.getTrialName());
		asserts.assertEquals(0L, trialMeta.getTimeout());
		asserts.assertFalse(trialMeta.isIgnored());
		
		List<? extends I_TestMetadata> testsMetadata = trialMeta.getTests();
		asserts.assertNotNull(testsMetadata);
		asserts.assertEquals("java.util.Collections$UnmodifiableRandomAccessList", 
				testsMetadata.getClass().getName());
		I_TestMetadata testMeta = testsMetadata.get(0);
		asserts.assertNotNull(testMeta);
		asserts.assertEquals(I_SourceFileTrial.TEST_MIN_COVERAGE, testMeta.getTestName());
		asserts.assertNull(testMeta.getTimeout());
		
		testMeta = testsMetadata.get(1);
		asserts.assertNotNull(testMeta);
		asserts.assertEquals(I_SourceFileTrial.TEST_DEPENDENCIES, testMeta.getTestName());
		asserts.assertNull(testMeta.getTimeout());
		
		testMeta = testsMetadata.get(2);
		asserts.assertNotNull(testMeta);
		asserts.assertEquals(CircularDependencyFailure_SourceFileTrial.TEST_METHOD_NAME, testMeta.getTestName());
		asserts.assertEquals(0L, testMeta.getTimeout());
		
		asserts.assertEquals(3, testsMetadata.size());
		
		
		
		List<I_TrialResult> results = runner.getResults();
		I_TrialResult result = results.get(0);
		asserts.assertEquals(CircularDependencyFailure_SourceFileTrial.class.getName(),
				result.getName());
		asserts.assertNotNull(result);
		asserts.assertFalse(result.isPassed());
		List<I_TrialFailure> failures = result.getFailures();
		asserts.assertNotNull(failures);
		asserts.assertEquals(0, failures.size());
		
		List<I_TestResult> testResults = result.getResults();
		asserts.assertNotNull(testResults);
		asserts.assertEquals("java.util.Collections$UnmodifiableRandomAccessList", 
				testResults.getClass().getName());
		
		assertMinCoverageResult(asserts,  testResults.get(0));
		assertTestResult(asserts,  testResults.get(1));
		assertDependencyResult(asserts,  testResults.get(2));
		
		asserts.assertEquals(3, testResults.size());
		asserts.assertEquals(1, results.size());
		
		
		SystemRunnerMock tracker =  runner.getMockSystem();
		asserts.assertEquals(0, tracker.getLastStatus());
	}

	public static void assertDependencyResult(I_Asserts asserts,
			I_TestResult testResult) {
		
		asserts.assertNotNull(testResult);
		asserts.assertEquals(TestResult.class.getName(),testResult.getClass().getName());
		asserts.assertEquals("testDependencies(SourceFileTrialResultMutant trialResultMutant)", testResult.getName());
		asserts.assertFalse(testResult.isPassed());
		asserts.assertFalse(testResult.isIgnored());
		
		asserts.assertEquals(1, testResult.getAssertionCount());
		asserts.assertEquals(1, testResult.getUniqueAssertionCount());
		
		I_TestFailure testFailure = testResult.getFailure();
		asserts.assertNotNull(testFailure);
		I_Tests4J_ResultMessages messages =  Tests4J_EnglishConstants.ENGLISH.getResultMessages();
		asserts.assertEquals(messages.getSourceClassHasCircularDependency(), 
						testFailure.getFailureMessage());
		asserts.assertEquals(CircularDependencyFailure.class.getName(), testFailure.getClass().getName());
		
		CircularDependencyFailure acf = (CircularDependencyFailure) testFailure;
		asserts.assertEquals(AssertType.AssertCircularDependency ,acf.getAssertType());
		
		List<String> names = acf.getClassesOutOfBounds();
		asserts.assertContains(names,"org.adligo.tests4j_tests.run.helpers.class_loading_mocks.MockWithTriangleC");
		asserts.assertContains(names,"org.adligo.tests4j_tests.run.helpers.class_loading_mocks.MockWithTriangleB");
		asserts.assertEquals(2,names.size());
		asserts.assertEquals(TestFailureType.AssertDependencyFailure, acf.getType());
		
		String failedLocation = testFailure.getFailureDetail();
		asserts.assertNull(failedLocation);
	}
	
	public static void assertMinCoverageResult(I_Asserts asserts,
			I_TestResult testResult) {
		
		
		
		asserts.assertNotNull(testResult);
		asserts.assertEquals(TestResult.class.getName(),testResult.getClass().getName());
		asserts.assertEquals(I_SourceFileTrial.TEST_MIN_COVERAGE, testResult.getName());
		asserts.assertTrue(testResult.isPassed());
		asserts.assertFalse(testResult.isIgnored());
		
		asserts.assertEquals(1, testResult.getAssertionCount());
		asserts.assertEquals(1, testResult.getUniqueAssertionCount());
		
		I_TestFailure testFailure = testResult.getFailure();
		asserts.assertNull(testFailure);
		
	}
	
	public static void assertTestResult(I_Asserts asserts,
			I_TestResult testResult) {
		
		
		
		asserts.assertNotNull(testResult);
		asserts.assertEquals(TestResult.class.getName(),testResult.getClass().getName());
		asserts.assertEquals(CircularDependencyFailure_SourceFileTrial.TEST_METHOD_NAME, testResult.getName());
		asserts.assertTrue(testResult.isPassed());
		asserts.assertFalse(testResult.isIgnored());
		
		asserts.assertEquals(1, testResult.getAssertionCount());
		asserts.assertEquals(1, testResult.getUniqueAssertionCount());
		
		I_TestFailure testFailure = testResult.getFailure();
		asserts.assertNull(testFailure);	
	}
	
	public static int getAsserts() {
		return 63;
	}
}
