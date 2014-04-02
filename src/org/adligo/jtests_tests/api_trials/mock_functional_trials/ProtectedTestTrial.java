package org.adligo.jtests_tests.api_trials.mock_functional_trials;

import org.adligo.jtests.models.shared.Test;
import org.adligo.jtests.models.shared.UseCaseTrial;

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
public class ProtectedTestTrial extends UseCaseTrial {

	@Test
	protected void exhibitFoo() {}
}
