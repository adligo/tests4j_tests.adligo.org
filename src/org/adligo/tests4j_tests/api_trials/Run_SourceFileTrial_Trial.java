package org.adligo.tests4j_tests.api_trials;

import org.adligo.tests4j.models.shared.ApiTrial;
import org.adligo.tests4j.models.shared.PackageScope;
import org.adligo.tests4j.models.shared.Test;
import org.adligo.tests4j.models.shared.results.I_TrialFailure;
import org.adligo.tests4j.models.shared.results.I_TrialResult;
import org.adligo.tests4j_tests.api_trials.mock_class_trials.BadConstructorTrial;
import org.adligo.tests4j_tests.api_trials.mock_class_trials.NoClassScopeAnnotationTrial;

@PackageScope (packageName = "org.adligo.tests4j")
public class Run_SourceFileTrial_Trial extends ApiTrial {

	@Test
	public void exhibitClassTestWithBadConstructor() {
		ExpectedFailureRunner runner = new ExpectedFailureRunner();
		runner.runExpectedFailure(BadConstructorTrial.class);
		I_TrialResult result = runner.getResult();
		assertNotNull(result);
		assertFalse(result.isPassed());
		I_TrialFailure failure = result.getFailure();
		assertNotNull(failure);
		assertEquals("Classes which implement I_AbstractTrial must have a zero argument constructor.", failure.getMessage());
		Throwable exception = failure.getException();
		assertUniform(new NoSuchMethodException(
				"org.adligo.tests4j_tests.api_trials.mock_class_trials.BadConstructorTrial.<init>()"), 
				exception);
	}
	
	@Test
	public void exhibitClassTestWithNoScopeAnnotation() {
		ExpectedFailureRunner runner = new ExpectedFailureRunner();
		runner.runExpectedFailure(NoClassScopeAnnotationTrial.class);
		I_TrialResult result = runner.getResult();
		assertNotNull(result);
		assertFalse(result.isPassed());
		I_TrialFailure failure = result.getFailure();
		assertNotNull(failure);
		assertEquals("SourceFileTrials must be annotated with SourceFileScope.", failure.getMessage());
		Throwable exception = failure.getException();
		assertUniform(new IllegalArgumentException(
				"org.adligo.tests4j_tests.api_trials.mock_class_trials.NoClassScopeAnnotationTrial was not annotated correctly."), 
				exception);
	}
}
