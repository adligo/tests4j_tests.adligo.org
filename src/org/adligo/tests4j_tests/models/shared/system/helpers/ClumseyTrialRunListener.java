package org.adligo.tests4j_tests.models.shared.system.helpers;

import org.adligo.tests4j.models.shared.metadata.I_TrialRunMetadata;
import org.adligo.tests4j.models.shared.results.I_TrialResult;
import org.adligo.tests4j.models.shared.results.I_TrialRunResult;
import org.adligo.tests4j.models.shared.system.I_TrialRunListener;

public class ClumseyTrialRunListener implements I_TrialRunListener {

	@Override
	public void onMetadataCalculated(I_TrialRunMetadata metadata) {
		throw new RuntimeException("mock from onMetadataCalculated");
	}

	@Override
	public void onStartingTrial(String trialName) {
		throw new RuntimeException("mock from onStartingTrial");
	}

	@Override
	public void onStartingTest(String trialName, String testName) {
		throw new RuntimeException("mock from onStartingTest");
	}

	@Override
	public void onTestCompleted(String trialName, String testName,
			boolean passed) {
		throw new RuntimeException("mock from onTestCompleted");
	}

	@Override
	public void onTrialCompleted(I_TrialResult result) {
		throw new RuntimeException("mock from onTrialCompleted");
	}

	@Override
	public void onRunCompleted(I_TrialRunResult result) {
		throw new RuntimeException("mock from onRunCompleted");
	}

}
