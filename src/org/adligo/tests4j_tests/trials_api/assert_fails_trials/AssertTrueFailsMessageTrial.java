package org.adligo.tests4j_tests.trials_api.assert_fails_trials;

import org.adligo.tests4j.system.shared.trials.ApiTrial;
import org.adligo.tests4j.system.shared.trials.PackageScope;
import org.adligo.tests4j.system.shared.trials.Test;
import org.adligo.tests4j.system.shared.trials.TrialRecursion;

@TrialRecursion
@PackageScope (packageName="org.adligo.tests4j")
public class AssertTrueFailsMessageTrial extends ApiTrial {

	public static final String TRUE_IS_FALSE_MESSAGE = "true is false message";

	@Test
	public void testAssertTrueIsFalseWithMessage() {
		assertTrue(TRUE_IS_FALSE_MESSAGE, false);
	}
}
