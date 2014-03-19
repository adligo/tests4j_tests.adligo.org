package org.adligo.jtests_tests.use_case_trials.mock_functional_trials;

import org.adligo.jtests.models.shared.BeforeTrial;
import org.adligo.jtests.models.shared.Test;
import org.adligo.jtests.models.shared.FunctionalTrial;

public class BeforeTrialHasParamsTrial extends FunctionalTrial {

	
	@BeforeTrial
	public static void beforeTest(String p) {}
	
	@Test
	public void exhibitFoo() {}

}
