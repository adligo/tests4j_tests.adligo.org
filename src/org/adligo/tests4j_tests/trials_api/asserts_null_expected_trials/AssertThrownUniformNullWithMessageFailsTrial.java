package org.adligo.tests4j_tests.trials_api.asserts_null_expected_trials;

import org.adligo.tests4j.shared.asserts.common.I_Thrower;
import org.adligo.tests4j.system.shared.trials.ApiTrial;
import org.adligo.tests4j.system.shared.trials.PackageScope;
import org.adligo.tests4j.system.shared.trials.Test;
import org.adligo.tests4j.system.shared.trials.TrialRecursion;

@TrialRecursion
@PackageScope (packageName="org.adligo.tests4j")
public class AssertThrownUniformNullWithMessageFailsTrial extends ApiTrial {
	private boolean called = false;
	@Test
	public void testAssertThrownUniformNull() {
		called = false;
		assertFalse(called);
		assertThrownUniform("custom message",null, 
			new I_Thrower() {
			
			@Override
			public void run() {
				called = true;
			}
		});
		assertTrue(called);
	}
}
