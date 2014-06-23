package org.adligo.tests4j_tests;

import java.util.Set;

import org.adligo.tests4j.models.shared.MetaTrial;
import org.adligo.tests4j.models.shared.metadata.I_TrialRunMetadata;
import org.adligo.tests4j.models.shared.metadata.RelevantClassesWithTrialsCalculator;
import org.adligo.tests4j.models.shared.results.I_TrialRunResult;

public class TheMetaTrial  extends MetaTrial {
	private RelevantClassesWithTrialsCalculator calc;
	
	public TheMetaTrial() {
		super(52.0, 9.0);
	}
	

	@Override
	public void afterNonMetaTrialsRun(I_TrialRunResult results) throws Exception {
		Set<String> passingTrials = results.getPassingTrials();
		//this is also the package dependency tree;
		Set<String> trialNames = calc.getSourceFileTrialNames("org.adligo.tests4j.models.shared.common");
		assertEquals(6, trialNames.size());
		for (String trialName: trialNames) {
			assertTrue("The passing trials should include " + trialName, 
					passingTrials.contains(trialName));
		}
		
		//this does not include the 3 tests in this TheMetaTrial 
		// afterNonMetaTrialsRun, afterMetadataCalculated and 
		// @Test methods in the MetaTrial implementation.
		assertGreaterThanOrEquals(95.0, 0.0 + results.getTestsPassed());
		
		assertGreaterThanOrEquals(16700.0 ,0.0 + results.getAsserts());
		assertGreaterThanOrEquals(2550.0 ,0.0 + results.getUniqueAsserts());
		
		super.afterNonMetaTrialsRun(results);
	}

	@Override
	public void afterMetadataCalculated(I_TrialRunMetadata metadata) throws Exception {
		calc = new RelevantClassesWithTrialsCalculator(metadata);
		//this is also the package dependency tree;
		assertGreaterThanOrEquals(100.0, calc.getPct("org.adligo.tests4j.models.shared.common"));
		
		// includes this
		assertGreaterThanOrEquals(28.0, 0.0 + metadata.getAllTrialsCount());
		//includes three tests in here
		assertGreaterThanOrEquals(99.0, 0.0 + metadata.getAllTestsCount());
		//TODO assert percentage of source files with trials
		super.afterMetadataCalculated(metadata);
		
		
	}
}
