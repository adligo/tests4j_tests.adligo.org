package org.adligo.tests4j_tests;

import org.adligo.tests4j.models.shared.MetaTrial;
import org.adligo.tests4j.models.shared.metadata.I_TrialRunMetadata;
import org.adligo.tests4j.models.shared.metadata.RelevantClassesWithTrialsCalculator;
import org.adligo.tests4j.models.shared.results.I_TrialRunResult;

public class TheMetaTrial  extends MetaTrial {
	
	public TheMetaTrial() {
		super(51.0, 9.2);
	}
	

	@Override
	public void afterNonMetaTrialsRun(I_TrialRunResult results) throws Exception {
		super.assertPackageTrialsPassed(results, "org.adligo.tests4j.models.shared.common", 6);
		super.assertPackageTrialsPassed(results, "org.adligo.tests4j.models.shared.asserts", 5);
		
		//this does not include the 3 tests in this TheMetaTrial 
		// afterNonMetaTrialsRun, afterMetadataCalculated and 
		// @Test methods in the MetaTrial implementation.
		assertGreaterThanOrEquals(98.0, 0.0 + results.getTestsPassed());
		
		assertGreaterThanOrEquals(16700.0 ,0.0 + results.getAsserts());
		assertGreaterThanOrEquals(2550.0 ,0.0 + results.getUniqueAsserts());
		
		super.afterNonMetaTrialsRun(results);
	}

	@Override
	public void afterMetadataCalculated(I_TrialRunMetadata metadata) throws Exception {
		super.afterMetadataCalculated(metadata);
		RelevantClassesWithTrialsCalculator calc = super.getCalculator();
		
		//this assert is also for the child-packages;
		assertGreaterThanOrEquals(100.0, calc.getPct("org.adligo.tests4j.models.shared.common"));
		assertGreaterThanOrEquals(15.0, calc.getPct("org.adligo.tests4j.models.shared.asserts"));
		
		// includes this
		assertGreaterThanOrEquals(29.0, 0.0 + metadata.getAllTrialsCount());
		//includes three tests in here
		assertGreaterThanOrEquals(101.0, 0.0 + metadata.getAllTestsCount());
		
		
		
	}
}
