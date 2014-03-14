package org.adligo.jtests_tests.use_case_tests.mock_functional;

import org.adligo.jtests.models.shared.AfterTest;
import org.adligo.jtests.models.shared.Exhibit;
import org.adligo.jtests.models.shared.FunctionalTest;

public class AfterTestHasParams extends FunctionalTest {

	@AfterTest
	public static void afterTest(String p) {}
	
	@Exhibit
	public void exhibitFoo() {}

}
