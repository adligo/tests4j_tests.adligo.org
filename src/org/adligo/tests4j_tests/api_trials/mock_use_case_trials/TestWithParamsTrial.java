package org.adligo.tests4j_tests.api_trials.mock_use_case_trials;

import org.adligo.tests4j.models.shared.Test;
import org.adligo.tests4j.models.shared.UseCaseTrial;

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
public class TestWithParamsTrial extends UseCaseTrial {

	@Test
	public void testFoo(String p) {}
}
