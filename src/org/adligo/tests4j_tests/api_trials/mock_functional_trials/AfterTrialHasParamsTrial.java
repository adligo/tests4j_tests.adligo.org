package org.adligo.tests4j_tests.api_trials.mock_functional_trials;

import org.adligo.tests4j.models.shared.AfterTrial;
import org.adligo.tests4j.models.shared.Test;
import org.adligo.tests4j.models.shared.UseCaseTrial;

public class AfterTrialHasParamsTrial extends UseCaseTrial {

	@AfterTrial
	public static void afterTest(String p) {}
	
	@Test
	public void exhibitFoo() {}

}
