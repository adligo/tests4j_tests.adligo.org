package org.adligo.tests4j_tests.trials_api.assert_fails_trials;

import java.util.HashSet;
import java.util.Set;

import org.adligo.tests4j.system.shared.trials.ApiTrial;
import org.adligo.tests4j.system.shared.trials.PackageScope;
import org.adligo.tests4j.system.shared.trials.Test;
import org.adligo.tests4j.system.shared.trials.TrialRecursion;

@TrialRecursion
@PackageScope (packageName="org.adligo.tests4j")
public class AssertContainsFailsTrial extends ApiTrial {

	@Test
	public void testAssertContainsFails() {
		Set<String> set = new HashSet<String>();
		assertContains(set, "set");
	}
	
		

}
