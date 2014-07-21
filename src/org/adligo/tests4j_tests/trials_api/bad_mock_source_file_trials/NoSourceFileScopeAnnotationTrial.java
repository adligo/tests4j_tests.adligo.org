package org.adligo.tests4j_tests.trials_api.bad_mock_source_file_trials;

import java.util.List;

import org.adligo.tests4j.models.shared.asserts.common.I_Asserts;
import org.adligo.tests4j.models.shared.metadata.I_TestMetadata;
import org.adligo.tests4j.models.shared.metadata.I_TrialMetadata;
import org.adligo.tests4j.models.shared.metadata.I_TrialRunMetadata;
import org.adligo.tests4j.models.shared.results.I_TrialFailure;
import org.adligo.tests4j.models.shared.results.I_TrialResult;
import org.adligo.tests4j.models.shared.trials.SourceFileTrial;
import org.adligo.tests4j.models.shared.trials.TrialRecursion;
import org.adligo.tests4j_tests.trials_api.common.ExpectedFailureRunner;
import org.adligo.tests4j_tests.trials_api.common.MockSystem;

/**
 * note this test NOT RUN DIRECTLY 
 * as it is suppose to fail!
 * 
 * is run by another test 
 * @see RunClassTestUseCase
 * 
 * @author scott
 *
 */
@TrialRecursion
public class NoSourceFileScopeAnnotationTrial extends SourceFileTrial {

	public static void runTestDelegate(I_Asserts asserts)  throws Exception {
		ExpectedFailureRunner runner = new ExpectedFailureRunner();
		runner.run(NoSourceFileScopeAnnotationTrial.class);
		
		I_TrialRunMetadata metadata = runner.getMetadata();
		asserts.assertNotNull(metadata);
		List<? extends I_TrialMetadata> trialsMetadata = metadata.getAllTrialMetadata();
		asserts.assertNotNull(trialsMetadata);
		asserts.assertEquals("java.util.Collections$UnmodifiableRandomAccessList", 
				trialsMetadata.getClass().getName());
		asserts.assertEquals(1, trialsMetadata.size());
		I_TrialMetadata trialMeta = trialsMetadata.get(0);
		asserts.assertNotNull(trialMeta);
		asserts.assertEquals("org.adligo.tests4j_tests.trials_api.bad_mock_source_file_trials.NoSourceFileScopeAnnotationTrial", 
				trialMeta.getTrialName());
		asserts.assertEquals(0L, trialMeta.getTimeout());
		asserts.assertFalse(trialMeta.isIgnored());
		
		List<? extends I_TestMetadata> testsMetadata = trialMeta.getTests();
		asserts.assertNotNull(testsMetadata);
		asserts.assertEquals("java.util.Collections$UnmodifiableRandomAccessList", 
				testsMetadata.getClass().getName());
		asserts.assertEquals(0, testsMetadata.size());
		
		List<I_TrialResult> results = runner.getResults();
		asserts.assertEquals(1, results.size());
		I_TrialResult result = results.get(0);
		asserts.assertNotNull(result);
		asserts.assertFalse(result.isPassed());
		I_TrialFailure failure = result.getFailure();
		asserts.assertNotNull(failure);
		asserts.assertEquals("SourceFileTrials must be annotated with @SourceFileScope.", failure.getMessage());
		Throwable exception = failure.getException();
		asserts.assertUniform(new IllegalArgumentException(
				"org.adligo.tests4j_tests.trials_api.bad_mock_source_file_trials.NoSourceFileScopeAnnotationTrial was not annotated correctly."), 
				exception);
		
		MockSystem tracker =  runner.getMockSystem();
		asserts.assertEquals(0, tracker.getLastStatus());
	}
	
	public static int getAsserts() {
		return 18;
	}
}
