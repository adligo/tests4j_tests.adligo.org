package org.adligo.jtests_tests.use_case_trials;

import org.adligo.jtests.models.shared.Test;
import org.adligo.jtests.models.shared.FunctionalTrial;
import org.adligo.jtests.models.shared.results.I_TrialFailure;
import org.adligo.jtests.models.shared.results.I_TrialResult;
import org.adligo.jtests_tests.use_case_trials.mock_class_trials.NoClassScopeAnnotationTrial;
import org.adligo.jtests_tests.use_case_trials.mock_package_trials.BadPackageConstructorTrial;
import org.adligo.jtests_tests.use_case_trials.mock_package_trials.NoPackageScopeAnnotationTrial;

public class Run_PackageTrial_Trial extends FunctionalTrial {

	@Test
	public void exhibitPackageTestWithBadConstructor() {
		ExpectedFailureRunner runner = new ExpectedFailureRunner();
		runner.runExpectedFailure(BadPackageConstructorTrial.class);
		I_TrialResult result = runner.getResult();
		assertNotNull(result);
		assertFalse(result.isPassed());
		I_TrialFailure failure = result.getFailure();
		assertNotNull(failure);
		assertEquals("Classes which implement I_AbstractTrial must have a zero argument constructor.", failure.getMessage());
		Throwable exception = failure.getException();
		assertUniform(new NoSuchMethodException(
				"org.adligo.jtests_tests.use_case_trials.mock_package_trials.BadPackageConstructorTrial.<init>()"), 
				exception);
	}
	
	@Test
	public void exhibitPackageTestWithNoScopeAnnotation() {
		ExpectedFailureRunner runner = new ExpectedFailureRunner();
		runner.runExpectedFailure(NoPackageScopeAnnotationTrial.class);
		I_TrialResult result = runner.getResult();
		assertNotNull(result);
		assertFalse(result.isPassed());
		I_TrialFailure failure = result.getFailure();
		assertNotNull(failure);
		assertEquals("PackageTrials must be annotated with a PackageScope annotation.", failure.getMessage());
		Throwable exception = failure.getException();
		assertUniform(new IllegalArgumentException(
				"org.adligo.jtests_tests.use_case_trials.mock_package_trials.NoPackageScopeAnnotationTrial was not annotated correctly."), 
				exception);
	}
}
