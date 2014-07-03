package org.adligo.tests4j_tests.run.remote.socket_api;

import org.adligo.tests4j.models.shared.coverage.I_SourceFileCoverage;
import org.adligo.tests4j.models.shared.results.feedback.I_SourceFileTrial_TestsResults;
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
	public void afterTrialTests(I_SourceFileTrial_TestsResults p) {
		assertEquals(1L, p.getAssertions());
		assertEquals(1L, p.getUniqueAssertions());
		
		if (p.hasRecordedCoverage()) {
			I_SourceFileCoverage coverage =  p.getCoverage();
			assertGreaterThanOrEquals(96.0, coverage.getPercentageCoveredDouble());
		}
		// TODO Auto-generated method stub
		super.afterTrialTests(p);
	}
	
}
