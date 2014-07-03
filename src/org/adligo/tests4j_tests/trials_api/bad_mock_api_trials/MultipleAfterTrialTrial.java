package org.adligo.tests4j_tests.trials_api.bad_mock_api_trials;

import org.adligo.tests4j.models.shared.trials.AfterTrial;
import org.adligo.tests4j.models.shared.trials.ApiTrial;
import org.adligo.tests4j.models.shared.trials.PackageScope;
import org.adligo.tests4j.models.shared.trials.Test;
import org.adligo.tests4j.models.shared.trials.TrialRecursion;
import org.adligo.tests4j_tests.trials_api.BadApiTrials_Trial;

/**
 * note this test NOT RUN DIRECTLY 
 * as it is suppose to fail!
 * 
 * is run by another test 
 * @see BadApiTrials_Trial
 * 
 * @author scott
 *
 */
@PackageScope (packageName = "org.adligo.tests4j.foo")
@TrialRecursion
public class MultipleAfterTrialTrial extends ApiTrial {

	@AfterTrial
	public static void afterTrial() {}

	@AfterTrial
	public static void afterTrial2() {}
	
	@Test
	public void testFoo() {}

}