package org.adligo.tests4j_tests.trials_api.assert_fails_trials;

import org.adligo.tests4j.system.shared.trials.ApiTrial;
import org.adligo.tests4j.system.shared.trials.PackageScope;
import org.adligo.tests4j.system.shared.trials.Test;
import org.adligo.tests4j.system.shared.trials.TrialRecursion;

@TrialRecursion
@PackageScope (packageName="org.adligo.tests4j")
public class AssertFalseFailsTrial extends ApiTrial {

	@Test
	public void testAssertFalseIsTrue() {
		assertFalse(true);
	}
}
