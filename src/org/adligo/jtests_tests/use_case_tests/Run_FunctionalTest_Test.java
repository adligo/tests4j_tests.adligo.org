package org.adligo.jtests_tests.use_case_tests;

import org.adligo.jtests.base.shared.Exhibit;
import org.adligo.jtests.base.shared.FunctionalTest;
import org.adligo.jtests.models.shared.results.I_TestResult;
import org.adligo.jtests_tests.use_case_tests.mock_test_classes.FunctionalTestWithBadConstructor;

public class Run_FunctionalTest_Test extends FunctionalTest {

	@Exhibit
	public void exhibitFunctionalTestWithBadConstructor() {
		ExpectedFailureRunner runner = new ExpectedFailureRunner();
		runner.runExpectedFailure(FunctionalTestWithBadConstructor.class);
		I_TestResult result = runner.getResult();
		assertNotNull(result);
		assertFalse(result.isPassed());
	}
}
