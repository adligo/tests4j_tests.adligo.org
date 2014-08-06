package org.adligo.tests4j_tests.models.shared.common;

import java.util.Set;

import org.adligo.tests4j.models.shared.metadata.I_TrialRunMetadata;
import org.adligo.tests4j.models.shared.metadata.RelevantClassesWithTrialsCalculator;
import org.adligo.tests4j.models.shared.results.I_TrialRunResult;
import org.adligo.tests4j.models.shared.trials.MetaTrial;

/**
 * note there is usually only one MetaTrial
 * per project, however due to the complexity 
 * of tests4j this class assists in diagnosing
 * issues in MetaTrials.
 * 
 * @author scott
 *
 */
public class CommonPackageMetaTrial  extends MetaTrial {
	private RelevantClassesWithTrialsCalculator calc;
	
	public CommonPackageMetaTrial() {
		super(32.0, 75.0);
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
		assertGreaterThanOrEquals(7.0, 0.0 + results.getTestsPassed());
		
		assertGreaterThanOrEquals(24.0 ,0.0 + results.getAsserts());
		assertGreaterThanOrEquals(19.0 ,0.0 + results.getUniqueAsserts());
		
		super.afterNonMetaTrialsRun(results);
	}

	@Override
	public void afterMetadataCalculated(I_TrialRunMetadata metadata) throws Exception {
		calc = new RelevantClassesWithTrialsCalculator(metadata);
		
		// includes this
		assertGreaterThanOrEquals(6.0, 0.0 + metadata.getAllTrialsCount());
		//includes three tests in here
		assertGreaterThanOrEquals(8.0, 0.0 + metadata.getAllTestsCount());
		//TODO assert percentage of source files with trials
		super.afterMetadataCalculated(metadata);
		
		
	}
}
