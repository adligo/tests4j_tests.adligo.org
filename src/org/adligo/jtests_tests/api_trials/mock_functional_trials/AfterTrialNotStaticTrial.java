package org.adligo.jtests_tests.api_trials.mock_functional_trials;

import org.adligo.jtests.models.shared.AfterTrial;
import org.adligo.jtests.models.shared.Test;
import org.adligo.jtests.models.shared.UseCaseTrial;

public class AfterTrialNotStaticTrial extends UseCaseTrial {

	@AfterTrial
	public void afterTest() {}
	
	@Test
	public void exhibitFoo() {}

}
