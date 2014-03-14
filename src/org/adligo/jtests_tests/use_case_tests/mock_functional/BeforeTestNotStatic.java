package org.adligo.jtests_tests.use_case_tests.mock_functional;

import org.adligo.jtests.models.shared.BeforeTest;
import org.adligo.jtests.models.shared.Exhibit;
import org.adligo.jtests.models.shared.FunctionalTest;

public class BeforeTestNotStatic extends FunctionalTest {

	
	@BeforeTest
	public void beforeTest() {}
	
	@Exhibit
	public void exhibitFoo() {}

}
