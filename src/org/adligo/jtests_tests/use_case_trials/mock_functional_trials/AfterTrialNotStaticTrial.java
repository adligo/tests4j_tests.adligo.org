package org.adligo.jtests_tests.use_case_trials.mock_functional_trials;

import org.adligo.jtests.models.shared.AfterTrial;
import org.adligo.jtests.models.shared.Test;
import org.adligo.jtests.models.shared.FunctionalTrial;

public class AfterTrialNotStaticTrial extends FunctionalTrial {

	@AfterTrial
	public void afterTest() {}
	
	@Test
	public void exhibitFoo() {}

}
