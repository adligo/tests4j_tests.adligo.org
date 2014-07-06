package org.adligo.tests4j_tests.models.shared.common;

import org.adligo.tests4j.models.shared.common.TrialType;
import org.adligo.tests4j.models.shared.coverage.I_SourceFileCoverage;
import org.adligo.tests4j.models.shared.results.I_SourceFileTrialResult;
import org.adligo.tests4j.models.shared.trials.SourceFileScope;
import org.adligo.tests4j.models.shared.trials.SourceFileTrial;
import org.adligo.tests4j.models.shared.trials.Test;

@SourceFileScope (sourceClass=TrialType.class)
public class TrialTypeEnumTrial extends SourceFileTrial {

	@Test
	public void testMethods() {
		assertEquals(5, TrialType.values().length);
		
	}
	

	@Override
	public void afterTrialTests(I_SourceFileTrialResult p) {
		assertEquals(1, p.getTestCount());
		assertGreaterThanOrEquals(1.0, p.getAssertionCount());
		assertGreaterThanOrEquals(1.0, p.getUniqueAssertionCount());
		
		if (p.hasRecordedCoverage()) {
			I_SourceFileCoverage coverage = p.getSourceFileCoverage();
			assertGreaterThanOrEquals(100.0, coverage.getPercentageCoveredDouble());
		}
	}
}
