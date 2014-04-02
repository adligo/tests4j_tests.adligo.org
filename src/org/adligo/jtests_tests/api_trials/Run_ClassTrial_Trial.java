package org.adligo.jtests_tests.api_trials;

import org.adligo.jtests.models.shared.API_Trial;
import org.adligo.jtests.models.shared.PackageScope;
import org.adligo.jtests.models.shared.Test;
import org.adligo.jtests.models.shared.results.I_TrialFailure;
import org.adligo.jtests.models.shared.results.I_TrialResult;
import org.adligo.jtests_tests.api_trials.mock_class_trials.BadConstructorTrial;
import org.adligo.jtests_tests.api_trials.mock_class_trials.NoClassScopeAnnotationTrial;

@PackageScope (packageName = "org.adligo.jtests")
public class Run_ClassTrial_Trial extends API_Trial {

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
				"org.adligo.jtests_tests.api_trials.mock_class_trials.BadConstructorTrial.<init>()"), 
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
		assertEquals("ClassTrials must be annotated with ClassScope.", failure.getMessage());
		Throwable exception = failure.getException();
		assertUniform(new IllegalArgumentException(
				"org.adligo.jtests_tests.api_trials.mock_class_trials.NoClassScopeAnnotationTrial was not annotated correctly."), 
				exception);
	}
}