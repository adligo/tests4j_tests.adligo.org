package org.adligo.tests4j_tests.trials_api.asserts_null_expected_trials;

import org.adligo.tests4j.system.shared.trials.ApiTrial;
import org.adligo.tests4j.system.shared.trials.PackageScope;
import org.adligo.tests4j.system.shared.trials.Test;
import org.adligo.tests4j.system.shared.trials.TrialRecursion;

@TrialRecursion
@PackageScope (packageName="org.adligo.tests4j")
public class AssertNotEqualsNullStringWithMessageFailsTrial extends ApiTrial {

	public static final String TEST_ASSERT_FAILS_MESSAGE = "testAssertNotEqualsWithMessage message";

	@Test
	public void testAssertNotEqualsWithMessage() {
		assertNotEquals(TEST_ASSERT_FAILS_MESSAGE, (String) null, (String) null);
	}
}
