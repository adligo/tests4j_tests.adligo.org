package org.adligo.tests4j_tests.base_trials;

public interface I_CountType {
	public boolean hasCoverage();
	public boolean hasFinishedAfterTrialTests();
	/**
	 * if hasCoverage and hasFinishedAfterTrialTests
	 * are both true, this returns true
	 * @return
	 */
	public boolean isFromMetaWithCoverage();
}
