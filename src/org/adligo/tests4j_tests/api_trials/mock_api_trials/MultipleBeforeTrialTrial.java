package org.adligo.tests4j_tests.api_trials.mock_api_trials;

import org.adligo.tests4j.models.shared.ApiTrial;
import org.adligo.tests4j.models.shared.BeforeTrial;
import org.adligo.tests4j.models.shared.PackageScope;
import org.adligo.tests4j.models.shared.Test;
import org.adligo.tests4j_tests.api_trials.Run_ApiTrial_Trial;

/**
 * note this test NOT RUN DIRECTLY 
 * as it is suppose to fail!
 * 
 * is run by another test 
 * @see Run_ApiTrial_Trial
 * 
 * @author scott
 *
 */
@PackageScope (packageName = "org.adligo.tests4j.foo")
public class MultipleBeforeTrialTrial extends ApiTrial {

	@BeforeTrial
	public static void beforeTrial() {}

	@BeforeTrial
	public static void beforeTrial2() {}
	
	@Test
	public void testFoo() {}

}
