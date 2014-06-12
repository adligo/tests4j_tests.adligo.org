package org.adligo.tests4j_tests;

import org.adligo.tests4j.models.shared.MetaTrial;
import org.adligo.tests4j.models.shared.metadata.I_TrialRunMetadata;
import org.adligo.tests4j.models.shared.results.I_TrialRunResult;

public class TheMetaTrial  extends MetaTrial {

	public TheMetaTrial() {
		super(38.0, 1.0);
	}

	@Override
	public void afterNonMetaTrialsRun(I_TrialRunResult results) {
		//this does not include the afterNonMetaTrialsRun or 
		// afterMetadataCalculated and @Test methods in the I_MetaTrial implementation.
		assertGreaterThanOrEquals(79.0, 0.0 + results.getTestsPassed());
		assertGreaterThanOrEquals(16630.0 ,0.0 + results.getAsserts());
		assertGreaterThanOrEquals(2152.0 ,0.0 + results.getUniqueAsserts());
		
		super.afterNonMetaTrialsRun(results);
	}

	@Override
	public void afterMetadataCalculated(I_TrialRunMetadata metadata) {
		assertGreaterThanOrEquals(16.0, 0.0 + metadata.getAllTrialsCount());
		assertGreaterThanOrEquals(79.0, 0.0 + metadata.getAllTestsCount());
		//TODO assert percentage of source files with trials
		super.afterMetadataCalculated(metadata);
	}
}
