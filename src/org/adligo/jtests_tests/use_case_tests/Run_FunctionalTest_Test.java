package org.adligo.jtests_tests.use_case_tests;

import org.adligo.jtests.models.shared.Exhibit;
import org.adligo.jtests.models.shared.FunctionalTest;
import org.adligo.jtests.models.shared.results.I_TestFailure;
import org.adligo.jtests.models.shared.results.I_TestResult;
import org.adligo.jtests_tests.use_case_tests.mock_functional.BadConstructor;

public class Run_FunctionalTest_Test extends FunctionalTest {

	@Exhibit
	public void exhibitBadConstructor() {
		ExpectedFailureRunner runner = new ExpectedFailureRunner();
		runner.runExpectedFailure(BadConstructor.class);
		I_TestResult result = runner.getResult();
		assertNotNull(result);
		assertFalse(result.isPassed());
		I_TestFailure failure = result.getFailure();
		assertNotNull(failure);
		assertEquals("Classes which implement I_AbstractTest must have a zero argument constructor.", failure.getMessage());
		Throwable exception = failure.getException();
		
	}
	
	
	@Exhibit
	public void exhibitNoExhibits() {
		ExpectedFailureRunner runner = new ExpectedFailureRunner();
		runner.runExpectedFailure(BadConstructor.class);
		I_TestResult result = runner.getResult();
		assertNotNull(result);
		assertFalse(result.isPassed());
		I_TestFailure failure = result.getFailure();
		assertNotNull(failure);
		assertEquals("Classes which implement I_AbstractTest must have a zero argument constructor.", failure.getMessage());
		Throwable exception = failure.getException();
		
	}
}
