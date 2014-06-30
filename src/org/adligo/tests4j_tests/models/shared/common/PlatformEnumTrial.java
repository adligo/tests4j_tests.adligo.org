package org.adligo.tests4j_tests.models.shared.common;

import org.adligo.tests4j.models.shared.common.PlatformEnum;
import org.adligo.tests4j.models.shared.coverage.I_SourceFileCoverage;
import org.adligo.tests4j.models.shared.results.feedback.I_SourceFileTrial_TestsResults;
import org.adligo.tests4j.models.shared.trials.SourceFileScope;
import org.adligo.tests4j.models.shared.trials.SourceFileTrial;
import org.adligo.tests4j.models.shared.trials.Test;

@SourceFileScope (sourceClass=PlatformEnum.class)
public class PlatformEnumTrial extends SourceFileTrial {

	@Test
	public void testEnums() {
		assertEquals(3, PlatformEnum.values().length);
		assertEquals("JSE", PlatformEnum.JSE.toString());
		assertEquals("GWTC", PlatformEnum.GWTC.toString());
		assertEquals("ADFM", PlatformEnum.ADFM.toString());
	}
	
	@Override
	public void afterTrialTests(I_SourceFileTrial_TestsResults p) {
		assertGreaterThanOrEquals(4.0, p.getAssertions());
		assertGreaterThanOrEquals(4.0, p.getUniqueAssertions());
		
		if (p.hasRecordedCoverage()) {
			I_SourceFileCoverage coverage = p.getCoverage();
			assertGreaterThanOrEquals(100.0, coverage.getPercentageCoveredDouble());
		}
	}
}
