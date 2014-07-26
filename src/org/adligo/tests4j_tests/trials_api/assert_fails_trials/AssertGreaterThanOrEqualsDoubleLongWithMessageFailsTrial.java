package org.adligo.tests4j_tests.trials_api.assert_fails_trials;

import org.adligo.tests4j.models.shared.trials.ApiTrial;
import org.adligo.tests4j.models.shared.trials.PackageScope;
import org.adligo.tests4j.models.shared.trials.Test;
import org.adligo.tests4j.models.shared.trials.TrialRecursion;

@TrialRecursion
@PackageScope (packageName="org.adligo.tests4j")
public class AssertGreaterThanOrEqualsDoubleLongWithMessageFailsTrial extends ApiTrial {

	public static final String TEST_ASSERT_FAILS_MESSAGE = "testAsserGreaterThanEqualsDoubleLongFailsWithMessage message";

	@Test
	public void testAsserGreaterThanEqualsDoubleLongFailsWithMessage() {
		assertGreaterThanOrEquals(TEST_ASSERT_FAILS_MESSAGE,1.0, 0);
	}
}
