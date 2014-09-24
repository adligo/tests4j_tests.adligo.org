package org.adligo.tests4j_tests.trials_api.asserts_null_expected_trials;

import org.adligo.tests4j.models.shared.trials.ApiTrial;
import org.adligo.tests4j.models.shared.trials.PackageScope;
import org.adligo.tests4j.models.shared.trials.Test;
import org.adligo.tests4j.models.shared.trials.TrialRecursion;
import org.adligo.tests4j.shared.asserts.common.ExpectedThrownData;

@TrialRecursion
@PackageScope (packageName="org.adligo.tests4j")
public class AssertThrownNullThrowerWithMessageFailsTrial extends ApiTrial {
	private boolean called = false;
	@Test
	public void testAssertThrownNull() {
		called = false;
		assertFalse(called);
		assertThrown("custom message is ignored",new ExpectedThrownData(new RuntimeException("hey")), null);
		assertTrue(called);
	}
}
