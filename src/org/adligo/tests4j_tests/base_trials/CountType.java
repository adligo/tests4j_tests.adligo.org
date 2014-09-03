package org.adligo.tests4j_tests.base_trials;

public class CountType implements I_CountType {
	private CountTypeMutant mutant;
	
	
	public CountType(I_CountType type) {
		mutant = new CountTypeMutant(type);
		
	}
	@Override
	public boolean hasCoverage() {
		return mutant.hasCoverage();
	}

	@Override
	public boolean hasFinishedAfterTrialTests() {
		return mutant.hasFinishedAfterTrialTests();
	}
	
	@Override
	public boolean isFromMetaWithCoverage() {
		return mutant.isFromMetaWithCoverage();
	}

}
