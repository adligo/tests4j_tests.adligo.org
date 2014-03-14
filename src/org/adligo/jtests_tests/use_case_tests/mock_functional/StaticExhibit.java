package org.adligo.jtests_tests.use_case_tests.mock_functional;

import org.adligo.jtests.models.shared.Exhibit;
import org.adligo.jtests.models.shared.FunctionalTest;

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
public class StaticExhibit extends FunctionalTest {

	@Exhibit
	public static void exhibitFoo() {}
}
