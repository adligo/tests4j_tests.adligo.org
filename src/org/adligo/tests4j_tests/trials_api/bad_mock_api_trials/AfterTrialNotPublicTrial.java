package org.adligo.tests4j_tests.trials_api.bad_mock_api_trials;

import java.util.List;

import org.adligo.tests4j.models.shared.asserts.common.I_Asserts;
import org.adligo.tests4j.models.shared.metadata.I_TestMetadata;
import org.adligo.tests4j.models.shared.metadata.I_TrialMetadata;
import org.adligo.tests4j.models.shared.metadata.I_TrialRunMetadata;
import org.adligo.tests4j.models.shared.results.I_TrialFailure;
import org.adligo.tests4j.models.shared.results.I_TrialResult;
import org.adligo.tests4j.models.shared.trials.AfterTrial;
import org.adligo.tests4j.models.shared.trials.ApiTrial;
import org.adligo.tests4j.models.shared.trials.PackageScope;
import org.adligo.tests4j.models.shared.trials.Test;
import org.adligo.tests4j.models.shared.trials.TrialRecursion;
import org.adligo.tests4j.run.helpers.SystemExitTracker;
import org.adligo.tests4j_tests.trials_api.common.ExpectedFailureRunner;

/**
 * note this trial is run by the Run_UseCaseTrial_Trial,
 * and is intended to fail.
 * 
 * @author scott
 *
 */
@PackageScope (packageName = "org.adligo.tests4j.foo")
@TrialRecursion
public class AfterTrialNotPublicTrial extends ApiTrial {

	@AfterTrial
	protected static void afterTrial() {}
	
	@Test
	public void testFoo() {}

	public static void runTestDelegate(I_Asserts asserts)  throws Exception  {
		ExpectedFailureRunner runner = new ExpectedFailureRunner();
		runner.run(AfterTrialNotPublicTrial.class);
		
		
		I_TrialRunMetadata metadata = runner.getMetadata();
		asserts.assertNotNull(metadata);
		List<? extends I_TrialMetadata> trialsMetadata = metadata.getAllTrialMetadata();
		asserts.assertNotNull(trialsMetadata);
		asserts.assertEquals("java.util.Collections$UnmodifiableRandomAccessList", 
				trialsMetadata.getClass().getName());
		asserts.assertEquals(1, trialsMetadata.size());
		I_TrialMetadata trialMeta = trialsMetadata.get(0);
		asserts.assertNotNull(trialMeta);
		asserts.assertEquals("org.adligo.tests4j_tests.trials_api.bad_mock_api_trials.AfterTrialNotPublicTrial", 
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
		asserts.assertEquals("testFoo", testMeta.getTestName());
		asserts.assertEquals(0L, testMeta.getTimeout());
		
		
		List<I_TrialResult> results = runner.getResults();
		asserts.assertEquals(1, results.size());
		I_TrialResult result = results.get(0);
		asserts.assertNotNull(result);
		asserts.assertFalse(result.isPassed());
		I_TrialFailure failure = result.getFailure();
		asserts.assertNotNull(failure);
		asserts.assertEquals("Methods Annotated with @AfterTrial must be public.", failure.getMessage());
		Throwable exception = failure.getException();
		asserts.assertUniform(new IllegalArgumentException(
				"org.adligo.tests4j_tests.trials_api.bad_mock_api_trials.AfterTrialNotPublicTrial was not annotated correctly."), 
				exception);
		
		SystemExitTracker tracker =  runner.getSystemExitTracker();
		asserts.assertEquals(0, tracker.getLastStatus());
	}
	
	public static int getAsserts() {
		return 21;
	}
}
