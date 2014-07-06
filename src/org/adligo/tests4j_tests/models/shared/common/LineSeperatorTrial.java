package org.adligo.tests4j_tests.models.shared.common;

import org.adligo.tests4j.models.shared.asserts.ExpectedThrownData;
import org.adligo.tests4j.models.shared.asserts.common.I_Thrower;
import org.adligo.tests4j.models.shared.common.LineSeperator;
import org.adligo.tests4j.models.shared.coverage.I_SourceFileCoverage;
import org.adligo.tests4j.models.shared.results.I_SourceFileTrialResult;
import org.adligo.tests4j.models.shared.trials.SourceFileScope;
import org.adligo.tests4j.models.shared.trials.SourceFileTrial;
import org.adligo.tests4j.models.shared.trials.Test;

@SourceFileScope (sourceClass=LineSeperator.class)
public class LineSeperatorTrial extends SourceFileTrial {

	@Test
	public void testMethods() {
		LineSeperator.setLineSeperator("h");
		assertEquals("h", LineSeperator.getLineSeperator());
		final Runnable runner = new Runnable() {
			
			@Override
			public void run() {
				LineSeperator.setLineSeperator("h");
			}
		};
		
		assertThrown(new ExpectedThrownData(new IllegalStateException( 
				"The Method class org.adligo.tests4j.models.shared.common.LineSeperator.setLineSeperator "
				+ "may only be called by [org.adligo.tests4j.run.Tests4J, "
				+ "org.adligo.tests4j_tests.models.shared.common.LineSeperatorTrial]")), new I_Thrower() {
			
			@Override
			public void run() {
				runner.run();
			}
		});
	}
	
	@Override
	public void afterTrialTests(I_SourceFileTrialResult p) {
		assertEquals(1, p.getTestCount());
		assertGreaterThanOrEquals(2.0, p.getAssertionCount());
		assertGreaterThanOrEquals(2.0, p.getUniqueAssertionCount());
		
		if (p.hasRecordedCoverage()) {
			I_SourceFileCoverage coverage = p.getSourceFileCoverage();
			assertGreaterThanOrEquals(91.0, coverage.getPercentageCoveredDouble());
		}
	}
}
