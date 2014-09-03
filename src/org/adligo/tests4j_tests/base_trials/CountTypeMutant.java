package org.adligo.tests4j_tests.base_trials;

public class CountTypeMutant implements I_CountType {
	private boolean coverage;
	private boolean finishedAfterTrialTests;
	
	public CountTypeMutant() {}
	
	public CountTypeMutant(I_CountType type) {
		coverage = type.hasCoverage();
		finishedAfterTrialTests = type.hasFinishedAfterTrialTests();
	}
	
	public boolean hasCoverage() {
		return coverage;
	}
	public void setCoverage(boolean coverage) {
		this.coverage = coverage;
	}
	public boolean hasFinishedAfterTrialTests() {
		return finishedAfterTrialTests;
	}
	public void setFinishedAfterTrialTests(boolean finishedAfterTrialTests) {
		this.finishedAfterTrialTests = finishedAfterTrialTests;
	}

	@Override
	public boolean isFromMetaWithCoverage() {
		if (coverage && finishedAfterTrialTests) {
			return true;
		}
		return false;
	}
}
