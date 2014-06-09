package org.adligo.tests4j_tests;

import org.adligo.tests4j.models.shared.MetaTrial;
import org.adligo.tests4j.models.shared.results.I_TrialRunResult;

public class TheMetaTrial  extends MetaTrial {

	public TheMetaTrial() {
		super(40.0, 1.0);
	}

	@Override
	public void afterNonMetaTrialsRun(I_TrialRunResult results) {
		//this does not include the afterNonMetaTrialsRun or 
		// afterMetadataCalculated and @Test methods in the I_MetaTrial implementation.
		assertGreaterThanOrEquals(75.0, 0.0 + results.getTestsPassed());
		assertGreaterThanOrEquals(16259.0 ,0.0 + results.getAsserts());
		assertGreaterThanOrEquals(2123.0 ,0.0 + results.getUniqueAsserts());
		
		super.afterNonMetaTrialsRun(results);
	}
}
