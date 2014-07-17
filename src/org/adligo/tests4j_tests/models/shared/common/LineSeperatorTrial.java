package org.adligo.tests4j_tests.models.shared.common;

import org.adligo.tests4j.models.shared.asserts.ExpectedThrownData;
import org.adligo.tests4j.models.shared.asserts.common.I_Thrower;
import org.adligo.tests4j.models.shared.common.LineSeperator;
import org.adligo.tests4j.models.shared.coverage.I_SourceFileCoverage;
import org.adligo.tests4j.models.shared.results.I_SourceFileTrialResult;
import org.adligo.tests4j.models.shared.trials.SourceFileScope;
import org.adligo.tests4j.models.shared.trials.SourceFileTrial;
import org.adligo.tests4j.models.shared.trials.Test;
import org.adligo.tests4j_tests.base_abstract_trials.SourceFileCountingTrial;

@SourceFileScope (sourceClass=LineSeperator.class, minCoverage=92.0)
public class LineSeperatorTrial extends SourceFileCountingTrial {

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
	public int getTests() {
		return 1;
	}

	@Override
	public int getAsserts() {
		return 2;
	}

	@Override
	public int getUniqueAsserts() {
		return 2;
	}
}
