package org.adligo.tests4j_tests.trials_api.assert_fails_trials;

import org.adligo.tests4j.system.shared.trials.ApiTrial;
import org.adligo.tests4j.system.shared.trials.PackageScope;
import org.adligo.tests4j.system.shared.trials.Test;
import org.adligo.tests4j.system.shared.trials.TrialRecursion;

@TrialRecursion
@PackageScope (packageName="org.adligo.tests4j")
public class AssertFalseWithMessageFailsTrial extends ApiTrial {

	public static final String FALSE_IS_TRUE_MESSAGE = "false is true message";

	@Test
	public void testAssertFalseIsTrueWithMessage() {
		assertFalse(FALSE_IS_TRUE_MESSAGE, true);
	}
}
