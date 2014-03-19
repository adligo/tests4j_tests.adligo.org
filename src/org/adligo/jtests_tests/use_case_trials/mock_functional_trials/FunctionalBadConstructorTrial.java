package org.adligo.jtests_tests.use_case_trials.mock_functional_trials;

import org.adligo.jtests.models.shared.Test;
import org.adligo.jtests.models.shared.FunctionalTrial;

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
public class FunctionalBadConstructorTrial extends FunctionalTrial {

	public FunctionalBadConstructorTrial(String p) {}
	
	@Test
	public void exhibitFoo() {}
}
