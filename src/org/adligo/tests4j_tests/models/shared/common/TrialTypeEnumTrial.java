package org.adligo.tests4j_tests.models.shared.common;

import org.adligo.tests4j.models.shared.common.TrialType;
import org.adligo.tests4j.models.shared.coverage.I_SourceFileCoverage;
import org.adligo.tests4j.models.shared.results.I_SourceFileTrialResult;
import org.adligo.tests4j.models.shared.trials.SourceFileScope;
import org.adligo.tests4j.models.shared.trials.SourceFileTrial;
import org.adligo.tests4j.models.shared.trials.Test;
import org.adligo.tests4j_tests.base_abstract_trials.SourceFileCountingTrial;

@SourceFileScope (sourceClass=TrialType.class)
public class TrialTypeEnumTrial extends SourceFileCountingTrial {

	@Test
	public void testMethods() {
		assertEquals(5, TrialType.values().length);
		
	}
	

	@Override
	public void afterTrialTests(I_SourceFileTrialResult p) {
		assertCounts(p);
		
		if (p.hasRecordedCoverage()) {
			I_SourceFileCoverage coverage = p.getSourceFileCoverage();
			assertGreaterThanOrEquals(100.0, coverage.getPercentageCoveredDouble());
		}
	}
	
	@Override
	public int getTests() {
		return 1;
	}

	@Override
	public int getAsserts() {
		return 1;
	}

	@Override
	public int getUniqueAsserts() {
		return 1;
	}
}
