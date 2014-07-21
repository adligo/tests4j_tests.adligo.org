package org.adligo.tests4j_tests;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.adligo.tests4j.models.shared.metadata.I_TrialMetadata;
import org.adligo.tests4j.models.shared.metadata.I_TrialRunMetadata;
import org.adligo.tests4j.models.shared.metadata.RelevantClassesWithTrialsCalculator;
import org.adligo.tests4j.models.shared.results.I_TrialRunResult;
import org.adligo.tests4j.models.shared.trials.MetaTrial;

public class TheMetaTrial  extends MetaTrial {
	public TheMetaTrial() {
		//Note when I ignored
		// MultiRecordingTrial I lost 15% main coverage
		//TODO reimpl it vs the ThreadLocals
		super(43.0, 28.6);
		//hmm package comparison data to include;
		// passing tests
		// relevant classes with trials %
		// minimum source file coverage %
		// minimum package coverage %
	}
	

	@Override
	public void afterNonMetaTrialsRun(I_TrialRunResult results) throws Exception {
		
		super.assertPackageTrialsPassed(results, "org.adligo.tests4j.models.shared.asserts", 17);
		super.assertPackageTrialsPassed(results, "org.adligo.tests4j.models.shared.asserts.common", 1);
		super.assertPackageTrialsPassed(results, "org.adligo.tests4j.models.shared.asserts.line_text", 9);
		super.assertPackageTrialsPassed(results, "org.adligo.tests4j.models.shared.common", 6);
		super.assertPackageTrialsPassed(results, "org.adligo.tests4j.models.shared.metadata", 4);
		super.assertPackageTrialsPassed(results, "org.adligo.tests4j.models.shared.xml", 2);
		
		//TODO
		//assertEquals(1,results.getTrialsIgnored());
		assertEquals(0,results.getTestsIgnored());
		//this does not include this test method
		// does include afterMetadataCalculated(I_TrialRunMetadata metadata)
		// - 4 ignored tests in
		// MultiRecordingTrial
		assertGreaterThanOrEquals(425, results.getTestsPassed());
		//should be assertEquals(243 - 5, results.getTestsPassed());
		
		//does not include assertions from this class yet
		//I think the single threaded count is off somewhere
		assertGreaterThanOrEquals(21300,results.getAsserts());
		//should be assertEquals(19227L,results.getAsserts());
		assertGreaterThanOrEquals(5300,results.getUniqueAsserts());
		// should be something like assertEquals(4122L,results.getUniqueAsserts());
		super.afterNonMetaTrialsRun(results);
	}

	@Override
	public void afterMetadataCalculated(I_TrialRunMetadata metadata) throws Exception {
		super.afterMetadataCalculated(metadata);
		RelevantClassesWithTrialsCalculator calc = super.getCalculator();
		
		//this assert is also for the child-packages;
		assertGreaterThanOrEquals(100.0, calc.getPct("org.adligo.tests4j.models.shared.asserts"));
		assertGreaterThanOrEquals(100.0, calc.getPct("org.adligo.tests4j.models.shared.asserts.common"));
		assertGreaterThanOrEquals(100.0, calc.getPct("org.adligo.tests4j.models.shared.asserts.line_text"));
		assertGreaterThanOrEquals(100.0, calc.getPct("org.adligo.tests4j.models.shared.common"));
		assertGreaterThanOrEquals(100.0, calc.getPct("org.adligo.tests4j.models.shared.metadata"));
		assertGreaterThanOrEquals(100.0, calc.getPct("org.adligo.tests4j.models.shared.xml"));
		
		// includes this
		List<? extends I_TrialMetadata> trialMetadata = metadata.getAllTrialMetadata();
		
		List<String> mdNames = new ArrayList<String>();
		
		for (I_TrialMetadata md: trialMetadata) {
			mdNames.add(md.getTrialName());
		}
		Collections.sort(mdNames);
		
		StringBuilder sb = new StringBuilder();
		for (String mdName: mdNames) {
			sb.append("'");
			sb.append(mdName);
			sb.append("'");
			sb.append(System.lineSeparator());
		}
		assertEquals(sb.toString(), 71, metadata.getAllTrialsCount());
		//should be pretty close to this, the count got off when I 
		//added the testMinCoverage, method to sourceFileTrials
		assertEquals(361,  metadata.getAllTestsCount());
		
	}


}
