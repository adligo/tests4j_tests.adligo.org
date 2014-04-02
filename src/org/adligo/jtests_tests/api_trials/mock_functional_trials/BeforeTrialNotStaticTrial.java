package org.adligo.jtests_tests.api_trials.mock_functional_trials;

import org.adligo.jtests.models.shared.BeforeTrial;
import org.adligo.jtests.models.shared.Test;
import org.adligo.jtests.models.shared.UseCaseTrial;

public class BeforeTrialNotStaticTrial extends UseCaseTrial {

	
	@BeforeTrial
	public void beforeTest() {}
	
	@Test
	public void exhibitFoo() {}

}
