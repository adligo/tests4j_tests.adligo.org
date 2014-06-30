package org.adligo.tests4j_tests.trials_api.mock_api_trials;

import org.adligo.tests4j.models.shared.trials.ApiTrial;
import org.adligo.tests4j.models.shared.trials.BeforeTrial;
import org.adligo.tests4j.models.shared.trials.PackageScope;
import org.adligo.tests4j.models.shared.trials.Test;
import org.adligo.tests4j.models.shared.trials.TrialRecursion;
import org.adligo.tests4j_tests.trials_api.Run_ApiTrial_ApiTrial;

/**
 * note this test NOT RUN DIRECTLY 
 * as it is suppose to fail!
 * 
 * is run by another test 
 * @see Run_ApiTrial_ApiTrial
 * 
 * @author scott
 *
 */
@PackageScope (packageName = "org.adligo.tests4j.foo")
@TrialRecursion
public class MultipleBeforeTrialTrial extends ApiTrial {

	@BeforeTrial
	public static void beforeTrial() {}

	@BeforeTrial
	public static void beforeTrial2() {}
	
	@Test
	public void testFoo() {}

}
