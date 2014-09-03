package org.adligo.tests4j_tests.base_trials;

import org.adligo.tests4j.models.shared.trials.I_TrialInputData;


public interface I_CountingPackageTrials extends I_TrialInputData {

	public int getTrialCount();
	
	public int getTestCount();
	
	public long getAssertCount();
	
	public long getUniqueAssertCount();
	
}
