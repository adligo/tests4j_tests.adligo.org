package org.adligo.jtests_tests.use_case_tests.mock_functional;

import org.adligo.jtests.models.shared.BeforeTest;
import org.adligo.jtests.models.shared.Exhibit;
import org.adligo.jtests.models.shared.FunctionalTest;

public class BeforeTestHasParams extends FunctionalTest {

	
	@BeforeTest
	public static void beforeTest(String p) {}
	
	@Exhibit
	public void exhibitFoo() {}

}
