package org.adligo.tests4j_tests.trials_api.assert_fails_trials;

import java.util.HashSet;
import java.util.Set;

import org.adligo.tests4j.models.shared.trials.ApiTrial;
import org.adligo.tests4j.models.shared.trials.PackageScope;
import org.adligo.tests4j.models.shared.trials.Test;
import org.adligo.tests4j.models.shared.trials.TrialRecursion;

@TrialRecursion
@PackageScope (packageName="org.adligo.tests4j")
public class AssertContainsWithMessageFailsTrial extends ApiTrial {

	public static final String TEST_ASSERT_CONTAINS_FAILS_MESSAGE = "testAssertContainsFails message";

	@Test
	public void testAssertContainsFailsWithMessage() {
		Set<String> set = new HashSet<String>();
		assertContains(TEST_ASSERT_CONTAINS_FAILS_MESSAGE,set, "set");
	}
}
