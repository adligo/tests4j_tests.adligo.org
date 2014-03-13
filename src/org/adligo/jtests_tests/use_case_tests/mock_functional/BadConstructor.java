package org.adligo.jtests_tests.use_case_tests.mock_functional;

import org.adligo.jtests.base.shared.Exhibit;
import org.adligo.jtests.base.shared.FunctionalTest;

/**
 * note this test NOT RUN DIRECTLY 
 * as it is suppose to fail!
 * 
 * is run by another test 
 * @see RunClassTestUseCase
 * 
 * @author scott
 *
 */
public class BadConstructor extends FunctionalTest {

	public BadConstructor(String p) {}
	
	@Exhibit
	public void exhibitFoo() {}
}
