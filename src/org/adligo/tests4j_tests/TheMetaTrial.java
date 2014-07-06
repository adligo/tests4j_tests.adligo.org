package org.adligo.tests4j_tests;

import org.adligo.tests4j.models.shared.metadata.I_TrialRunMetadata;
import org.adligo.tests4j.models.shared.metadata.RelevantClassesWithTrialsCalculator;
import org.adligo.tests4j.models.shared.results.I_TrialRunResult;
import org.adligo.tests4j.models.shared.trials.MetaTrial;

public class TheMetaTrial  extends MetaTrial {
	
	public TheMetaTrial() {
		//Note when I ignored
		// MultiRecordingTrial I lost 15% main coverage
		//TODO reimpl it vs the ThreadLocals
		super(22.0, 15.4);
	}
	

	@Override
	public void afterNonMetaTrialsRun(I_TrialRunResult results) throws Exception {
		super.assertPackageTrialsPassed(results, "org.adligo.tests4j.models.shared.common", 6);
		super.assertPackageTrialsPassed(results, "org.adligo.tests4j.models.shared.asserts", 10);
		super.assertPackageTrialsPassed(results, "org.adligo.tests4j.models.shared.asserts.common", 1);
		
		//this does not include this test method
		// does include afterMetadataCalculated(I_TrialRunMetadata metadata)
		// - 4 ignored tests in
		// MultiRecordingTrial
		assertGreaterThanOrEquals(232.0, 0.0 + results.getTestsPassed());
		
		//does not include assertions from this class yet
		assertGreaterThanOrEquals(18800.0 ,0.0 + results.getAsserts());
		assertGreaterThanOrEquals(3900.0 ,0.0 + results.getUniqueAsserts());
		
		super.afterNonMetaTrialsRun(results);
	}

	@Override
	public void afterMetadataCalculated(I_TrialRunMetadata metadata) throws Exception {
		super.afterMetadataCalculated(metadata);
		RelevantClassesWithTrialsCalculator calc = super.getCalculator();
		
		//this assert is also for the child-packages;
		assertGreaterThanOrEquals(70.0, calc.getPct("org.adligo.tests4j.models.shared.asserts"));
		assertGreaterThanOrEquals(100.0, calc.getPct("org.adligo.tests4j.models.shared.common"));
		
		// includes this
		assertGreaterThanOrEquals(40.0, 0.0 + metadata.getAllTrialsCount());
		//includes two tests in here, from this class
		assertGreaterThanOrEquals(238.0, 0.0 + metadata.getAllTestsCount());
		
		
		
	}
}
