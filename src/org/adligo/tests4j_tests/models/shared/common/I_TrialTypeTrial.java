package org.adligo.tests4j_tests.models.shared.common;

import org.adligo.tests4j.models.shared.common.I_TrialType;
import org.adligo.tests4j.models.shared.trials.SourceFileScope;
import org.adligo.tests4j_tests.base_trials.SourceFileCountingTrial;

@SourceFileScope (sourceClass=I_TrialType.class, minCoverage=0)
public class I_TrialTypeTrial extends SourceFileCountingTrial {

	@Override
	public int getTests() {
		return 0;
	}

	@Override
	public int getAsserts() {
		return 0;
	}

	@Override
	public int getUniqueAsserts() {
		return 0;
	}


}
