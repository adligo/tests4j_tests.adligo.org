package org.adligo.tests4j_tests.trials_api.assert_fails_trials;

import org.adligo.tests4j.system.shared.trials.ApiTrial;
import org.adligo.tests4j.system.shared.trials.PackageScope;
import org.adligo.tests4j.system.shared.trials.Test;
import org.adligo.tests4j.system.shared.trials.TrialRecursion;

@TrialRecursion
@PackageScope (packageName="org.adligo.tests4j")
public class AssertNotUniformNoEvaluatorWithMessageFailsTrial extends ApiTrial {

	public static final String TEST_ASSERT_FAILS_MESSAGE = "testAssertNotUniformNoEvaluatorWithMessage message";

	@Test
	public void testAssertNotUniformNoEvaluatorWithMessage() {
		assertNotUniform(TEST_ASSERT_FAILS_MESSAGE, this, this);
	}
}
