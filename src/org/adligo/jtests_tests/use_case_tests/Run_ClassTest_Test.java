package org.adligo.jtests_tests.use_case_tests;

import org.adligo.jtests.models.shared.Exhibit;
import org.adligo.jtests.models.shared.FunctionalTest;
import org.adligo.jtests.models.shared.results.I_TrialFailure;
import org.adligo.jtests.models.shared.results.I_TrialResult;
import org.adligo.jtests_tests.use_case_tests.mock_class_tests.BadConstructor;
import org.adligo.jtests_tests.use_case_tests.mock_class_tests.NoClassScopeAnnotation;
import org.adligo.jtests_tests.use_case_tests.mock_functional.StaticExhibit;

public class Run_ClassTest_Test extends FunctionalTest {

	@Exhibit
	public void exhibitClassTestWithBadConstructor() {
		ExpectedFailureRunner runner = new ExpectedFailureRunner();
		runner.runExpectedFailure(BadConstructor.class);
		I_TrialResult result = runner.getResult();
		assertNotNull(result);
		assertFalse(result.isPassed());
		I_TrialFailure failure = result.getFailure();
		assertNotNull(failure);
		assertEquals("Classes which implement I_AbstractTest must have a zero argument constructor.", failure.getMessage());
		Throwable exception = failure.getException();
		assertUniform(new NoSuchMethodException(
				"org.adligo.jtests_tests.use_case_tests.mock_class_tests.BadConstructor.<init>()"), 
				exception);
	}
	
	@Exhibit
	public void exhibitClassTestWithNoScopeAnnotation() {
		ExpectedFailureRunner runner = new ExpectedFailureRunner();
		runner.runExpectedFailure(NoClassScopeAnnotation.class);
		I_TrialResult result = runner.getResult();
		assertNotNull(result);
		assertFalse(result.isPassed());
		I_TrialFailure failure = result.getFailure();
		assertNotNull(failure);
		assertEquals("ClassTests must be annotated with ClassTestScope.", failure.getMessage());
		Throwable exception = failure.getException();
		assertUniform(new IllegalArgumentException(
				"org.adligo.jtests_tests.use_case_tests.mock_class_tests.NoClassScopeAnnotation was not annotated correctly."), 
				exception);
	}
}
