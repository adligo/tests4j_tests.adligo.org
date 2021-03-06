package org.adligo.tests4j_tests.trials_api.asserts_null_expected_trials;

import org.adligo.tests4j.shared.asserts.common.ExpectedThrowable;
import org.adligo.tests4j.system.shared.trials.ApiTrial;
import org.adligo.tests4j.system.shared.trials.PackageScope;
import org.adligo.tests4j.system.shared.trials.Test;
import org.adligo.tests4j.system.shared.trials.TrialRecursion;

@TrialRecursion
@PackageScope (packageName="org.adligo.tests4j")
public class AssertThrownUniformNullThrowerWithMessageFailsTrial extends ApiTrial {
	private boolean called = false;
	@Test
	public void testAssertThrownNull() {
		called = false;
		assertFalse(called);
		assertThrownUniform("custom message is ignored",new ExpectedThrowable(new RuntimeException("hey")), null);
		assertTrue(called);
	}
}
