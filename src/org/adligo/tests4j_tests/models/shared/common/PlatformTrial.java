package org.adligo.tests4j_tests.models.shared.common;

import org.adligo.tests4j.models.shared.common.Platform;
import org.adligo.tests4j.models.shared.coverage.I_SourceFileCoverage;
import org.adligo.tests4j.models.shared.results.I_SourceFileTrialResult;
import org.adligo.tests4j.models.shared.trials.SourceFileScope;
import org.adligo.tests4j.models.shared.trials.SourceFileTrial;
import org.adligo.tests4j.models.shared.trials.Test;
import org.adligo.tests4j_tests.base_abstract_trials.SourceFileCountingTrial;

@SourceFileScope (sourceClass=Platform.class)
public class PlatformTrial extends SourceFileCountingTrial {

	@Test
	public void testEnums() {
		assertEquals(3, Platform.values().length);
		assertEquals("JSE", Platform.JSE.toString());
		assertEquals("GWTC", Platform.GWTC.toString());
		assertEquals("ADFM", Platform.ADFM.toString());
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
		return 4;
	}

	@Override
	public int getUniqueAsserts() {
		return 4;
	}
}