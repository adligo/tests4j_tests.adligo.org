package org.adligo.tests4j_tests.trials_api.assert_fails_trials;

import org.adligo.tests4j.system.shared.trials.ApiTrial;
import org.adligo.tests4j.system.shared.trials.PackageScope;
import org.adligo.tests4j.system.shared.trials.Test;
import org.adligo.tests4j.system.shared.trials.TrialRecursion;

@TrialRecursion
@PackageScope (packageName="org.adligo.tests4j")
public class AssertGreaterThanOrEqualsDoubleFloatWithMessageFailsTrial extends ApiTrial {

	public static final String TEST_ASSERT_FAILS_MESSAGE = "testAsserGreaterThanEqualsDoubleDoubleFailsWithMessage message";

	@Test
	public void testAsserGreaterThanEqualsDoubleFloatFailsWithMessage() {
		assertGreaterThanOrEquals(TEST_ASSERT_FAILS_MESSAGE,1.0, 0.0);
	}
}
