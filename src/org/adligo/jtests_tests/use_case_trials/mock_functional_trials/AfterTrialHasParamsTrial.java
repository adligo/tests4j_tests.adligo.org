package org.adligo.jtests_tests.use_case_trials.mock_functional_trials;

import org.adligo.jtests.models.shared.AfterTrial;
import org.adligo.jtests.models.shared.Test;
import org.adligo.jtests.models.shared.FunctionalTrial;

public class AfterTrialHasParamsTrial extends FunctionalTrial {

	@AfterTrial
	public static void afterTest(String p) {}
	
	@Test
	public void exhibitFoo() {}

}
