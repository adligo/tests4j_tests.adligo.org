package org.adligo.tests4j_tests.trials_api.mock_api_trials;

import org.adligo.tests4j.models.shared.ApiTrial;
import org.adligo.tests4j.models.shared.BeforeTrial;
import org.adligo.tests4j.models.shared.PackageScope;
import org.adligo.tests4j.models.shared.Test;
import org.adligo.tests4j.models.shared.TrialRecursion;

/**
 * this trial is run 50 times in a mock test run
 * to make sure that trial description synchronization
 * is working correctly.
 *   Or in other words a specific trial (like this one)
 *   can only be running once in the tests4j runtime,
 *   so if there are 50 of them passed to the
 *   list of trials to run, tests4j makes sure that
 *   it is run 50 times sequentially through thread
 *   synchronization blocks.
 *   
 * @author scott
 *
 */
@PackageScope (packageName = "org.adligo.tests4j.foo")
@TrialRecursion
public class SimpleRerunTrial extends ApiTrial {
	private static boolean success = false;
	
	@BeforeTrial
	public static void beforeTrial() {
		success = false;
	}
	
	@Test
	public void simpleTest() {
		assertFalse(success);
		success = true;
		assertTrue(success);
	}
}
