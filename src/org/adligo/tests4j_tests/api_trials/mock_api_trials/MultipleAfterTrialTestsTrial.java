package org.adligo.tests4j_tests.api_trials.mock_api_trials;

import org.adligo.tests4j.models.shared.AfterTrialTests;
import org.adligo.tests4j.models.shared.ApiTrial;
import org.adligo.tests4j.models.shared.I_AfterApiTrialCoverage;
import org.adligo.tests4j.models.shared.PackageScope;
import org.adligo.tests4j.models.shared.Test;

/**
 * note this trial is run by the Run_UseCaseTrial_Trial,
 * and is intended to fail.
 * 
 * @author scott
 *
 */
@PackageScope (packageName = "org.adligo.tests4j.foo")
public class MultipleAfterTrialTestsTrial extends ApiTrial {

	@Test
	public void testBar() {}
	
	@AfterTrialTests
	public void afterTrialTests(I_AfterApiTrialCoverage p) {}
	
	@AfterTrialTests
	public void afterTrialTests2(I_AfterApiTrialCoverage p) {}
}
