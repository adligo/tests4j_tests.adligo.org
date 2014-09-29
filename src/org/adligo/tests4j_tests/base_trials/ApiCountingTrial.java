package org.adligo.tests4j_tests.base_trials;

import org.adligo.tests4j.models.shared.results.I_ApiTrialResult;
import org.adligo.tests4j.system.shared.trials.ApiTrial;

public abstract class ApiCountingTrial extends ApiTrial implements I_CountingTrial {
	
	@Override
	public void afterTrialTests(I_ApiTrialResult p) {
		CountTypeMutant actm = new CountTypeMutant();
		actm.setCoverage(p.hasRecordedCoverage());
		actm.setFinishedAfterTrialTests(false);
		CountType act = new CountType(actm);
		assertEquals("The number of Tests is off.", getTests(act), p.getTestCount());
		assertEquals("The number of Asserts is off.",getAsserts(act), p.getAssertionCount());
		assertEquals("The number of Unique Asserts is off.", getUniqueAsserts(act), p.getUniqueAssertionCount());
	}
	
	/**
	 * add the asserts in this class
	 * @param type
	 * @param regularAsserts
	 * @return
	 */
	public int getAsserts(I_CountType type, int regularAsserts) {
		if (type.hasFinishedAfterTrialTests()) {
			return regularAsserts + 3;
		}
		return regularAsserts;
	}
	
	/**
	 * add the asserts in this class
	 * @param type
	 * @param regularAsserts
	 * @return
	 */
	public int getUniqueAsserts(I_CountType type, int regularUniqueAsserts) {
		if (type.hasFinishedAfterTrialTests()) {
			return regularUniqueAsserts + 3;
		}
		return regularUniqueAsserts;
	}
	
	/**
	 * useful method for most source file trials
	 * @param type
	 * @param atTests
	 * @return
	 */
	public int getTests(I_CountType type, int atTests) {
		if (type.hasFinishedAfterTrialTests()) {
			//afterTrialTests, @Tests
			return atTests + 1;
		} else {
			//@Tests
			return atTests;
		}
	}
}
