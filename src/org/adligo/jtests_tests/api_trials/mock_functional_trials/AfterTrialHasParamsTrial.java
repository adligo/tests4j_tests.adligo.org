package org.adligo.jtests_tests.api_trials.mock_functional_trials;

import org.adligo.jtests.models.shared.AfterTrial;
import org.adligo.jtests.models.shared.Test;
import org.adligo.jtests.models.shared.UseCaseTrial;

public class AfterTrialHasParamsTrial extends UseCaseTrial {

	@AfterTrial
	public static void afterTest(String p) {}
	
	@Test
	public void exhibitFoo() {}

}
