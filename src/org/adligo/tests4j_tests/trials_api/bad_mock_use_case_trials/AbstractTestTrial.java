package org.adligo.tests4j_tests.trials_api.bad_mock_use_case_trials;

import java.util.List;

import org.adligo.tests4j.models.shared.metadata.I_TestMetadata;
import org.adligo.tests4j.models.shared.metadata.I_TrialMetadata;
import org.adligo.tests4j.models.shared.metadata.I_TrialRunMetadata;
import org.adligo.tests4j.models.shared.results.I_TrialFailure;
import org.adligo.tests4j.models.shared.results.I_TrialResult;
import org.adligo.tests4j.shared.asserts.common.I_Asserts;
import org.adligo.tests4j.shared.en.Tests4J_EnglishConstants;
import org.adligo.tests4j.shared.i18n.I_Tests4J_AnnotationMessages;
import org.adligo.tests4j.system.shared.trials.Test;
import org.adligo.tests4j.system.shared.trials.TrialRecursion;
import org.adligo.tests4j.system.shared.trials.UseCaseScope;
import org.adligo.tests4j.system.shared.trials.UseCaseTrial;
import org.adligo.tests4j_tests.trials_api.common.ExpectedFailureRunner;
import org.adligo.tests4j_tests.trials_api.common.SystemRunnerMock;

/**
 * note this trial is run by the Run_UseCaseTrial_Trial,
 * and is intended to fail.
 * 
 * @author scott
 *
 */
@TrialRecursion
public abstract class AbstractTestTrial extends UseCaseTrial {

	@Test
	@UseCaseScope(name="reveal mistake")
	public abstract void testFoo();
	
	@SuppressWarnings("boxing")
  public static void runTestDelegate(I_Asserts asserts) throws Exception {
		ExpectedFailureRunner runner = new ExpectedFailureRunner();
		runner.run(AbstractTestTrial.class);
		
		I_TrialRunMetadata metadata = runner.getMetadata();
		asserts.assertNotNull(metadata);
		List<? extends I_TrialMetadata> trialsMetadata = metadata.getAllTrialMetadata();
		asserts.assertNotNull(trialsMetadata);
		asserts.assertEquals("java.util.Collections$UnmodifiableRandomAccessList", 
				trialsMetadata.getClass().getName());
		asserts.assertEquals(1, trialsMetadata.size());
		I_TrialMetadata trialMeta = trialsMetadata.get(0);
		asserts.assertNotNull(trialMeta);
		asserts.assertEquals("org.adligo.tests4j_tests.trials_api.bad_mock_use_case_trials.AbstractTestTrial", 
				trialMeta.getTrialName());
		asserts.assertEquals(0L, trialMeta.getTimeout());
		asserts.assertFalse(trialMeta.isIgnored());
		
		List<? extends I_TestMetadata> testsMetadata = trialMeta.getTests();
		asserts.assertNotNull(testsMetadata);
		asserts.assertEquals("java.util.Collections$UnmodifiableRandomAccessList", 
				testsMetadata.getClass().getName());
		asserts.assertEquals(1, testsMetadata.size());
		
		List<I_TrialResult> results = runner.getResults();
		asserts.assertEquals(1, results.size());
		I_TrialResult result = results.get(0);
		asserts.assertNotNull(result);
		asserts.assertFalse(result.isPassed());
		List<I_TrialFailure> failures = result.getFailures();
		asserts.assertNotNull(failures);
		asserts.assertEquals(1, failures.size());
		I_TrialFailure failure = failures.get(0);
		
		I_Tests4J_AnnotationMessages messages =  Tests4J_EnglishConstants.ENGLISH.getAnnotationMessages();
		asserts.assertEquals(messages.getIsAbstract(), failure.getMessage());
		asserts.assertEquals(
				"org.adligo.tests4j_tests.trials_api.bad_mock_use_case_trials.AbstractTestTrial.testFoo was not annotated correctly.", 
				failure.getFailureDetail());
		
		SystemRunnerMock tracker =  runner.getMockSystem();
		asserts.assertEquals(0, tracker.getLastStatus());
	}
	
	public static int getAsserts() {
		return 19;
	}
}
