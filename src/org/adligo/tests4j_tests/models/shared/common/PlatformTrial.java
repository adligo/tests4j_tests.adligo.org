package org.adligo.tests4j_tests.models.shared.common;

import org.adligo.tests4j.models.shared.common.Platform;
import org.adligo.tests4j.models.shared.coverage.I_SourceFileCoverage;
import org.adligo.tests4j.models.shared.results.I_SourceFileTrialResult;
import org.adligo.tests4j.models.shared.trials.SourceFileScope;
import org.adligo.tests4j.models.shared.trials.SourceFileTrial;
import org.adligo.tests4j.models.shared.trials.Test;

@SourceFileScope (sourceClass=Platform.class)
public class PlatformTrial extends SourceFileTrial {

	@Test
	public void testEnums() {
		assertEquals(3, Platform.values().length);
		assertEquals("JSE", Platform.JSE.toString());
		assertEquals("GWTC", Platform.GWTC.toString());
		assertEquals("ADFM", Platform.ADFM.toString());
	}
	
	@Override
	public void afterTrialTests(I_SourceFileTrialResult p) {
		assertEquals(1, p.getTestCount());
		assertGreaterThanOrEquals(4.0, p.getAssertionCount());
		assertGreaterThanOrEquals(4.0, p.getUniqueAssertionCount());
		
		if (p.hasRecordedCoverage()) {
			I_SourceFileCoverage coverage = p.getSourceFileCoverage();
			assertGreaterThanOrEquals(100.0, coverage.getPercentageCoveredDouble());
		}
	}
}
