package org.adligo.jtests_tests.use_case_tests;

import org.adligo.jtests.models.shared.Exhibit;
import org.adligo.jtests.models.shared.FunctionalTest;
import org.adligo.jtests.models.shared.results.I_TestResult;
import org.adligo.jtests_tests.use_case_tests.mock_test_classes.No_JTestTypeAnnotationTest;

public class Run_NoJTestType_Test extends FunctionalTest {

	@Exhibit
	public void exhibitNullTestType() {
		ExpectedFailureRunner runner = new ExpectedFailureRunner();
		runner.runExpectedFailure(No_JTestTypeAnnotationTest.class);
		I_TestResult result = runner.getResult();
		assertNotNull(result);
		assertFalse(result.isPassed());
	}
}
