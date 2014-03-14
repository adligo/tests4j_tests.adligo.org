package org.adligo.jtests_tests.use_case_tests.mock_functional;

import org.adligo.jtests.models.shared.AfterTest;
import org.adligo.jtests.models.shared.Exhibit;
import org.adligo.jtests.models.shared.FunctionalTest;

public class AfterTestNotStatic extends FunctionalTest {

	@AfterTest
	public void afterTest() {}
	
	@Exhibit
	public void exhibitFoo() {}

}
