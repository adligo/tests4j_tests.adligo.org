package org.adligo.tests4j_tests.run.helpers;

import org.adligo.tests4j.models.shared.trials.SourceFileScope;
import org.adligo.tests4j.models.shared.trials.Test;
import org.adligo.tests4j.run.helpers.SystemExitTracker;
import org.adligo.tests4j_tests.base_abstract_trials.SourceFileCountingTrial;

@SourceFileScope (sourceClass=SystemExitTracker.class, minCoverage=85.0)
public class SystemExitTrackerTrial extends SourceFileCountingTrial  {
	
	@Test
	public void testMethods() throws Exception  {
		SystemExitTracker tracker = new SystemExitTracker();
		
		tracker.doSystemExit(-1);
		assertEquals(-1, tracker.getLastStatus());
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
