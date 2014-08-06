package org.adligo.tests4j_tests.trials_api.assert_fails_trials;

import org.adligo.tests4j.models.shared.trials.ApiTrial;
import org.adligo.tests4j.models.shared.trials.PackageScope;
import org.adligo.tests4j.models.shared.trials.Test;
import org.adligo.tests4j.models.shared.trials.TrialRecursion;

@TrialRecursion
@PackageScope (packageName="org.adligo.tests4j")
public class AssertEqualsWithMessageFailsTrial extends ApiTrial {

	public static final String TEST_ASSERT_FAILS_MESSAGE = "testAssertEqualsFailsWithMessage message";

	@Test
	public void testAssertEqualsFailsWithMessage() {
		assertEquals(TEST_ASSERT_FAILS_MESSAGE,1, 2);
	}
}
