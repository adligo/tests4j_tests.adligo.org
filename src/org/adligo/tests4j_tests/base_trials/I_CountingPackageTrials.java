package org.adligo.tests4j_tests.base_trials;

import org.adligo.tests4j.system.shared.trials.I_MetaTrialInputData;


public interface I_CountingPackageTrials extends I_MetaTrialInputData {

	public int getTrialCount();
	
	public int getTestCount();
	
	public long getAssertCount();
	
	public long getUniqueAssertCount();
	
}
