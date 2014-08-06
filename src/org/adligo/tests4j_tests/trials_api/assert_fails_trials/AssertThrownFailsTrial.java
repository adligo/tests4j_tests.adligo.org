package org.adligo.tests4j_tests.trials_api.assert_fails_trials;

import org.adligo.tests4j.models.shared.asserts.common.ExpectedThrownData;
import org.adligo.tests4j.models.shared.asserts.common.I_Thrower;
import org.adligo.tests4j.models.shared.trials.ApiTrial;
import org.adligo.tests4j.models.shared.trials.PackageScope;
import org.adligo.tests4j.models.shared.trials.Test;
import org.adligo.tests4j.models.shared.trials.TrialRecursion;

@TrialRecursion
@PackageScope (packageName="org.adligo.tests4j")
public class AssertThrownFailsTrial extends ApiTrial {
	private boolean called = false;
	@Test
	public void testAssertThrown() {
		called = false;
		assertFalse(called);
		assertThrown(new ExpectedThrownData(new RuntimeException("hey")), 
			new I_Thrower() {
			
			@Override
			public void run() {
				called = true;
			}
		});
		assertTrue(called);
	}
}
