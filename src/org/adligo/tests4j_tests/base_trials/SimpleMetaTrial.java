package org.adligo.tests4j_tests.base_trials;

import org.adligo.tests4j.models.shared.metadata.I_TrialRunMetadata;
import org.adligo.tests4j.models.shared.results.I_TrialRunResult;
import org.adligo.tests4j.shared.output.I_Tests4J_Log;
import org.adligo.tests4j.system.shared.trials.I_MetaTrialInputData;
import org.adligo.tests4j.system.shared.trials.I_MetaTrialParams;
import org.adligo.tests4j.system.shared.trials.I_MetaTrialParamsAware;
import org.adligo.tests4j.system.shared.trials.MetaTrial;

public class SimpleMetaTrial extends MetaTrial implements I_MetaTrialParamsAware<I_CountingPackageTrials> {
	private I_CountingPackageTrials countingPkg_;
	
	public SimpleMetaTrial() {
	}
	
	@Override
	public void afterMetadataCalculated(I_TrialRunMetadata metadata)
			throws Exception {
		I_Tests4J_Log log = super.getLog();
		super.afterMetadataCalculated(metadata);
		
		assertEquals("Trials check", countingPkg_.getTrialCount(), metadata.getAllTrialsCount());
		log.log(this.getClass().getName() + " " + metadata.getAllTrialsCount() + " trials check.");
		//note the +2 here is for the two methods in this class :)
		assertEquals("Tests check", countingPkg_.getTestCount() + 2, metadata.getAllTestsCount());
		log.log(this.getClass().getName() + " " + metadata.getAllTestsCount() + " tests check.");
	}

	@Override
	public void afterNonMetaTrialsRun(I_TrialRunResult results)
			throws Exception {
		I_Tests4J_Log log = super.getLog();
		super.afterNonMetaTrialsRun(results);
		
		//reduce for this
		assertEquals("Trials (without MetaTrial) check", countingPkg_.getTrialCount()  - 1, results.getTrials());
		log.log(this.getClass().getName() + " " + results.getTrials() + " trials check.");
		//this the tests with out this
		assertEquals("Tests (without MetaTrial)  check", countingPkg_.getTestCount(), results.getTests());
		log.log(this.getClass().getName() + " " + results.getTests() + " tests check.");
		
		
		String message = "Asserts check";
		if (results.hasCoverage()) {
			message = message + " with coverage";
		}
		assertEquals(message, countingPkg_.getAssertCount(), 
				results.getAsserts());
		log.log(message + " " + results.getAsserts() + " asserts check.");
		
		String uMessage = "Unique asserts check";
		if (results.hasCoverage()) {
			uMessage = uMessage + " with coverage";
		}
		log.log(uMessage + " " + results.getUniqueAsserts() + 
				" unique asserts check.");
		assertEquals(
				uMessage,
				countingPkg_.getUniqueAssertCount(), 
				results.getUniqueAsserts());
		
	}

	@Override
	public void setTrialParams(I_MetaTrialParams<I_CountingPackageTrials> p) {
		countingPkg_ = p.getTrialParams();
	}

}
