package org.adligo.tests4j_tests.base_trials;

import org.adligo.tests4j.models.shared.results.I_ApiTrialResult;
import org.adligo.tests4j.models.shared.trials.ApiTrial;

public abstract class ApiCountingTrial extends ApiTrial implements I_CountingTrial {
	
	
	@Override
	public int getATests() {
		return getTests() + 1;
	}
	
	@Override
	public int getAAsserts(boolean coverage) {
		if (coverage) {
			return getAsserts() + 4;
		}
		return getAsserts() + 3;
	}

	@Override
	public int getAUniqueAsserts(boolean coverage) {
		if (coverage) {
			return getUniqueAsserts() + 4;
		}
		return getUniqueAsserts() + 3;
	}

	@Override
	public void afterTrialTests(I_ApiTrialResult p) {
		assertEquals("The number of Tests is off.", getTests(), p.getTestCount());
		assertEquals("The number of Asserts is off.",getAsserts(), p.getAssertionCount());
		assertEquals("The number of Unique Asserts is off.", getUniqueAsserts(), p.getUniqueAssertionCount());
	}
}
