package org.adligo.tests4j_tests;

import org.adligo.tests4j.models.shared.metadata.I_TrialRunMetadata;
import org.adligo.tests4j.models.shared.metadata.RelevantClassesWithTrialsCalculator;
import org.adligo.tests4j.models.shared.results.I_TrialRunResult;
import org.adligo.tests4j.models.shared.trials.MetaTrial;

public class TheMetaTrial  extends MetaTrial {
	
	public TheMetaTrial() {
		super(35.0, 13.3);
	}
	

	@Override
	public void afterNonMetaTrialsRun(I_TrialRunResult results) throws Exception {
		super.assertPackageTrialsPassed(results, "org.adligo.tests4j.models.shared.common", 6);
		super.assertPackageTrialsPassed(results, "org.adligo.tests4j.models.shared.asserts", 10);
		super.assertPackageTrialsPassed(results, "org.adligo.tests4j.models.shared.asserts.common", 1);
		
		//this does not include the 3 tests in this TheMetaTrial 
		// afterNonMetaTrialsRun, afterMetadataCalculated and 
		// @Test methods in the MetaTrial implementation.
		assertGreaterThanOrEquals(220.0, 0.0 + results.getTestsPassed());
		
		//does not include assertions from this class yet
		assertGreaterThanOrEquals(19100.0 ,0.0 + results.getAsserts());
		assertGreaterThanOrEquals(4000.0 ,0.0 + results.getUniqueAsserts());
		
		super.afterNonMetaTrialsRun(results);
	}

	@Override
	public void afterMetadataCalculated(I_TrialRunMetadata metadata) throws Exception {
		super.afterMetadataCalculated(metadata);
		RelevantClassesWithTrialsCalculator calc = super.getCalculator();
		
		//this assert is also for the child-packages;
		assertGreaterThanOrEquals(60.0, calc.getPct("org.adligo.tests4j.models.shared.asserts"));
		assertGreaterThanOrEquals(100.0, calc.getPct("org.adligo.tests4j.models.shared.common"));
		
		// includes this
		assertGreaterThanOrEquals(36.0, 0.0 + metadata.getAllTrialsCount());
		//includes three tests in here, from this class
		assertGreaterThanOrEquals(223.0, 0.0 + metadata.getAllTestsCount());
		
		
		
	}
}
