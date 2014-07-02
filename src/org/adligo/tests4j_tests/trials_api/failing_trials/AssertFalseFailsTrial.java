package org.adligo.tests4j_tests.trials_api.failing_trials;

import org.adligo.tests4j.models.shared.trials.ApiTrial;
import org.adligo.tests4j.models.shared.trials.PackageScope;
import org.adligo.tests4j.models.shared.trials.Test;
import org.adligo.tests4j.models.shared.trials.TrialRecursion;

@TrialRecursion
@PackageScope (packageName="org.adligo.tests4j")
public class AssertFalseFailsTrial extends ApiTrial {

	@Test
	public void testAssertFalseIsTrue() {
		assertFalse(true);
	}
}
