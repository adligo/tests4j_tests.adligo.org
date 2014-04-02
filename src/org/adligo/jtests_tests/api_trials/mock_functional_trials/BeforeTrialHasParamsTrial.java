package org.adligo.jtests_tests.api_trials.mock_functional_trials;

import org.adligo.jtests.models.shared.BeforeTrial;
import org.adligo.jtests.models.shared.Test;
import org.adligo.jtests.models.shared.UseCaseTrial;

public class BeforeTrialHasParamsTrial extends UseCaseTrial {

	
	@BeforeTrial
	public static void beforeTest(String p) {}
	
	@Test
	public void exhibitFoo() {}

}