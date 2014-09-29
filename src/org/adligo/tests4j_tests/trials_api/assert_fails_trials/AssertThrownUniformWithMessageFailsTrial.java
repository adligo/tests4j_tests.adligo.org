package org.adligo.tests4j_tests.trials_api.assert_fails_trials;

import org.adligo.tests4j.shared.asserts.common.ExpectedThrownData;
import org.adligo.tests4j.shared.asserts.common.I_Thrower;
import org.adligo.tests4j.system.shared.trials.ApiTrial;
import org.adligo.tests4j.system.shared.trials.PackageScope;
import org.adligo.tests4j.system.shared.trials.Test;
import org.adligo.tests4j.system.shared.trials.TrialRecursion;

@TrialRecursion
@PackageScope (packageName="org.adligo.tests4j")
public class AssertThrownUniformWithMessageFailsTrial extends ApiTrial {
	private boolean called = false;
	public static final String TEST_ASSERT_FAILS_MESSAGE = "testAssertThrownWithMessage message";

	@Test
	public void testAssertThrownUniformWithMessage()  {
		called = false;
		assertFalse(called);
		assertThrownUniform(TEST_ASSERT_FAILS_MESSAGE,
			new ExpectedThrownData(new RuntimeException("hey")), 
			new I_Thrower() {
			
			@Override
			public void run() {
				called = true;
			}
		});
		assertTrue(called);
	}
}
