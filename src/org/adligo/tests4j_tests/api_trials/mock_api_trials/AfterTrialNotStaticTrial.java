package org.adligo.tests4j_tests.api_trials.mock_api_trials;

import org.adligo.tests4j.models.shared.AfterTrial;
import org.adligo.tests4j.models.shared.ApiTrial;
import org.adligo.tests4j.models.shared.PackageScope;
import org.adligo.tests4j.models.shared.Test;
import org.adligo.tests4j.models.shared.TrialRecursion;

/**
 * note this trial is run by the Run_UseCaseTrial_Trial,
 * and is intended to fail.
 * 
 * @author scott
 *
 */
@PackageScope (packageName = "org.adligo.tests4j.foo")
@TrialRecursion
public class AfterTrialNotStaticTrial extends ApiTrial {

	@AfterTrial
	public void afterTrial() {}
	
	@Test
	public void testFoo() {}

}
