package org.adligo.tests4j_tests.api_trials.mock_functional_trials;

import org.adligo.tests4j.models.shared.BeforeTrial;
import org.adligo.tests4j.models.shared.Test;
import org.adligo.tests4j.models.shared.UseCaseTrial;

public class BeforeTrialHasParamsTrial extends UseCaseTrial {

	
	@BeforeTrial
	public static void beforeTest(String p) {}
	
	@Test
	public void exhibitFoo() {}

}
