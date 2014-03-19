package org.adligo.jtests_tests.use_case_tests;

import org.adligo.jtests.models.shared.Exhibit;
import org.adligo.jtests.models.shared.FunctionalTest;
import org.adligo.jtests.models.shared.results.I_TrialFailure;
import org.adligo.jtests.models.shared.results.I_TrialResult;
import org.adligo.jtests_tests.use_case_tests.mock_class_tests.NoClassScopeAnnotation;
import org.adligo.jtests_tests.use_case_tests.mock_package_tests.BadPackageConstructor;
import org.adligo.jtests_tests.use_case_tests.mock_package_tests.NoPackageScopeAnnotation;

public class Run_PackageTest_Test extends FunctionalTest {

	@Exhibit
	public void exhibitPackageTestWithBadConstructor() {
		ExpectedFailureRunner runner = new ExpectedFailureRunner();
		runner.runExpectedFailure(BadPackageConstructor.class);
		I_TrialResult result = runner.getResult();
		assertNotNull(result);
		assertFalse(result.isPassed());
		I_TrialFailure failure = result.getFailure();
		assertNotNull(failure);
		assertEquals("Classes which implement I_AbstractTest must have a zero argument constructor.", failure.getMessage());
		Throwable exception = failure.getException();
		assertUniform(new NoSuchMethodException(
				"org.adligo.jtests_tests.use_case_tests.mock_package_tests.BadPackageConstructor.<init>()"), 
				exception);
	}
	
	@Exhibit
	public void exhibitPackageTestWithNoScopeAnnotation() {
		ExpectedFailureRunner runner = new ExpectedFailureRunner();
		runner.runExpectedFailure(NoPackageScopeAnnotation.class);
		I_TrialResult result = runner.getResult();
		assertNotNull(result);
		assertFalse(result.isPassed());
		I_TrialFailure failure = result.getFailure();
		assertNotNull(failure);
		assertEquals("PackageTests must be annotated with a PackageTestScope annotation.", failure.getMessage());
		Throwable exception = failure.getException();
		assertUniform(new IllegalArgumentException(
				"org.adligo.jtests_tests.use_case_tests.mock_package_tests.NoPackageScopeAnnotation was not annotated correctly."), 
				exception);
	}
}
