package org.adligo.tests4j_tests.base_trials;

import org.adligo.tests4j.system.shared.trials.I_MetaTrialInputData;

import java.math.BigInteger;


public interface I_CountingPackageTrials extends I_MetaTrialInputData {

	public int getTrialCount();
	
	public long getTestCount();
	
	public BigInteger getAssertCount();
	
	public BigInteger getUniqueAssertCount();
	
}
