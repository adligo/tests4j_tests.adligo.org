package org.adligo.jtests_tests.use_case_tests.mock_test_classes;

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
public class FunctionalTestWithBadConstructor extends FunctionalTest {

	public FunctionalTestWithBadConstructor(String p) {}
}
