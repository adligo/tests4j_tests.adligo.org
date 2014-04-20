package org.adligo.tests4j_tests.api_trials;

import java.util.List;

import org.adligo.tests4j.models.shared.ApiTrial;
import org.adligo.tests4j.models.shared.PackageScope;
import org.adligo.tests4j.models.shared.Test;
import org.adligo.tests4j.models.shared.metadata.I_TestMetadata;
import org.adligo.tests4j.models.shared.metadata.I_TrialMetadata;
import org.adligo.tests4j.models.shared.metadata.I_TrialRunMetadata;
import org.adligo.tests4j.models.shared.results.I_TrialFailure;
import org.adligo.tests4j.models.shared.results.I_TrialResult;
import org.adligo.tests4j_tests.api_trials.mock_source_file_trials.BadConstructorTrial;
import org.adligo.tests4j_tests.api_trials.mock_source_file_trials.NoClassScopeAnnotationTrial;

@PackageScope (packageName = "org.adligo.tests4j")
public class Run_SourceFileTrial_Trial extends ApiTrial {

	@Test
	public void exhibitClassTestWithBadConstructor() {
		ExpectedFailureRunner runner = new ExpectedFailureRunner();
		runner.runExpectedFailure(BadConstructorTrial.class);
		
		I_TrialRunMetadata metadata = runner.getMetadata();
		assertNotNull(metadata);
		List<? extends I_TrialMetadata> trialsMetadata = metadata.getTrials();
		assertNotNull(trialsMetadata);
		assertEquals("java.util.Collections$UnmodifiableRandomAccessList", 
				trialsMetadata.getClass().getName());
		assertEquals(1, trialsMetadata.size());
		I_TrialMetadata trialMeta = trialsMetadata.get(0);
		assertNotNull(trialMeta);
		assertEquals("org.adligo.tests4j_tests.api_trials.mock_source_file_trials.BadConstructorTrial", 
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
		assertEquals("exhibitA", testMeta.getTestName());
		assertEquals(0L, testMeta.getTimeout());
		
		I_TrialResult result = runner.getResult();
		assertNotNull(result);
		assertFalse(result.isPassed());
		I_TrialFailure failure = result.getFailure();
		assertNotNull(failure);
		assertEquals("Classes which implement I_AbstractTrial must have a zero argument constructor.", failure.getMessage());
		Throwable exception = failure.getException();
		assertUniform(new NoSuchMethodException(
				"org.adligo.tests4j_tests.api_trials.mock_source_file_trials.BadConstructorTrial.<init>()"), 
				exception);
	}
	
	@Test
	public void exhibitClassTestWithNoScopeAnnotation() {
		ExpectedFailureRunner runner = new ExpectedFailureRunner();
		runner.runExpectedFailure(NoClassScopeAnnotationTrial.class);
		
		I_TrialRunMetadata metadata = runner.getMetadata();
		assertNotNull(metadata);
		List<? extends I_TrialMetadata> trialsMetadata = metadata.getTrials();
		assertNotNull(trialsMetadata);
		assertEquals("java.util.Collections$UnmodifiableRandomAccessList", 
				trialsMetadata.getClass().getName());
		assertEquals(1, trialsMetadata.size());
		I_TrialMetadata trialMeta = trialsMetadata.get(0);
		assertNotNull(trialMeta);
		assertEquals("org.adligo.tests4j_tests.api_trials.mock_source_file_trials.NoClassScopeAnnotationTrial", 
				trialMeta.getTrialName());
		assertEquals(0L, trialMeta.getTimeout());
		assertFalse(trialMeta.isSkipped());
		
		List<? extends I_TestMetadata> testsMetadata = trialMeta.getTests();
		assertNotNull(testsMetadata);
		assertEquals("java.util.Collections$UnmodifiableRandomAccessList", 
				testsMetadata.getClass().getName());
		assertEquals(0, testsMetadata.size());
		
		I_TrialResult result = runner.getResult();
		assertNotNull(result);
		assertFalse(result.isPassed());
		I_TrialFailure failure = result.getFailure();
		assertNotNull(failure);
		assertEquals("SourceFileTrials must be annotated with SourceFileScope.", failure.getMessage());
		Throwable exception = failure.getException();
		assertUniform(new IllegalArgumentException(
				"org.adligo.tests4j_tests.api_trials.mock_source_file_trials.NoClassScopeAnnotationTrial was not annotated correctly."), 
				exception);
	}
}
