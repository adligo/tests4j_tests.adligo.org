package org.adligo.tests4j_tests;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.atomic.AtomicBoolean;

import org.adligo.tests4j.models.shared.metadata.I_TrialRunMetadata;
import org.adligo.tests4j.models.shared.metadata.RelevantClassesWithTrialsCalculator;
import org.adligo.tests4j.models.shared.results.I_TrialRunResult;
import org.adligo.tests4j.models.shared.trials.MetaTrial;
import org.adligo.tests4j_tests.base_abstract_trials.Counts;

public class TheMetaTrial  extends MetaTrial {
	public TheMetaTrial() {
		//Note when I ignored
		// MultiRecordingTrial I lost 15% main coverage
		//TODO reimpl it vs the ThreadLocals
		super(27.0, 14.8);
	}
	

	@Override
	public void afterNonMetaTrialsRun(I_TrialRunResult results) throws Exception {
		super.assertPackageTrialsPassed(results, "org.adligo.tests4j.models.shared.common", 6);
		super.assertPackageTrialsPassed(results, "org.adligo.tests4j.models.shared.asserts", 10);
		super.assertPackageTrialsPassed(results, "org.adligo.tests4j.models.shared.asserts.common", 1);
		//TODO
		//assertEquals(1,results.getTrialsIgnored());
		assertEquals(0,results.getTestsIgnored());
		//this does not include this test method
		// does include afterMetadataCalculated(I_TrialRunMetadata metadata)
		// - 4 ignored tests in
		// MultiRecordingTrial
		assertEquals(243 - 5, results.getTestsPassed());
		
		//does not include assertions from this class yet
		//I think the single threaded count is off somewhere
		assertEquals(19227L,results.getAsserts());
		assertEquals(4122L,results.getUniqueAsserts());
		
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
		assertEquals(40, metadata.getAllTrialsCount());
		//includes two tests in here, from this class
		assertGreaterThanOrEquals(199, metadata.getAllTestsCount());
		//should be ....
		//assertEquals(243,  metadata.getAllTestsCount());
		
	}


}
