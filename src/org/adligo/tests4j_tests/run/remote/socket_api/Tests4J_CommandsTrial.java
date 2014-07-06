package org.adligo.tests4j_tests.run.remote.socket_api;

import org.adligo.tests4j.models.shared.coverage.I_SourceFileCoverage;
import org.adligo.tests4j.models.shared.results.I_SourceFileTrialResult;
import org.adligo.tests4j.models.shared.trials.SourceFileScope;
import org.adligo.tests4j.models.shared.trials.SourceFileTrial;
import org.adligo.tests4j.models.shared.trials.Test;
import org.adligo.tests4j.run.remote.socket_api.Tests4J_Commands;

@SourceFileScope (sourceClass=Tests4J_Commands.class)
public class Tests4J_CommandsTrial extends SourceFileTrial {

	@Test
	public void testGetMinLength() {
		int minLength = Tests4J_Commands.getMinLength();
		assertEquals(3, minLength);
	}

	@Override
	public void afterTrialTests(I_SourceFileTrialResult p) {
		assertEquals(1, p.getTestCount());
		assertEquals(1, p.getAssertionCount());
		assertEquals(1, p.getUniqueAssertionCount());
		
		if (p.hasRecordedCoverage()) {
			I_SourceFileCoverage coverage =  p.getSourceFileCoverage();
			double pct = coverage.getPercentageCoveredDouble();
			if (pct <= 90.0) {
				System.out.println("wtf");
			}
			assertGreaterThanOrEquals(96.0, pct);
		}
	}
	
}
