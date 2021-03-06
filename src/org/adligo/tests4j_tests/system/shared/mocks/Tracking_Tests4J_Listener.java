package org.adligo.tests4j_tests.system.shared.mocks;

import org.adligo.tests4j.models.shared.metadata.I_TrialRunMetadata;
import org.adligo.tests4j.models.shared.results.I_PhaseState;
import org.adligo.tests4j.models.shared.results.I_TrialResult;
import org.adligo.tests4j.models.shared.results.I_TrialRunResult;
import org.adligo.tests4j.system.shared.api.I_Tests4J_Listener;
import org.adligo.tests4j.system.shared.api.I_Tests4J_Params;

public class Tracking_Tests4J_Listener implements I_Tests4J_Listener {
	private I_TrialRunMetadata lastMetadata;
	private String lastTrialName;
	private String lastTestName;
	private Boolean lastPassed;
	private I_TrialResult lastTestResult;
	private I_TrialResult lastTrialResult;
	private I_TrialRunResult lastResult;
	private I_PhaseState lastInfo;
	private I_PhaseState lastProgress;
	private I_Tests4J_Params lastParams;
	
	@Override
	public void onMetadataCalculated(I_TrialRunMetadata metadata) {
		lastMetadata = metadata;
	}

	@Override
	public void onStartingTrial(String trialName) {
		lastTrialName = trialName;
	}

	@Override
	public void onStartingTest(String trialName, String testName) {
		lastTrialName = trialName;
		lastTestName = testName;
	}

	@Override
	public void onTestCompleted(String trialName, String testName,
			boolean passed) {
		
		lastTrialName = trialName;
		lastTestName = testName;
		lastPassed = passed;
	}

	@Override
	public void onTrialCompleted(I_TrialResult result) {
		lastTrialResult = result;
	}

	@Override
	public void onRunCompleted(I_TrialRunResult result) {
		lastResult = result;
	}

	public I_TrialRunMetadata getLastMetadata() {
		return lastMetadata;
	}

	public String getLastTrialName() {
		return lastTrialName;
	}

	public String getLastTestName() {
		return lastTestName;
	}

	public boolean isLastPassed() {
		return lastPassed;
	}

	public I_TrialResult getLastTestResult() {
		return lastTestResult;
	}

	public I_TrialResult getLastTrialResult() {
		return lastTrialResult;
	}

	public I_TrialRunResult getLastResult() {
		return lastResult;
	}
	
	public void clear() {
		lastMetadata = null;
		lastTrialName = null;
		lastTestName = null;
		lastPassed = null;
		lastTestResult = null;
		lastTrialResult = null;
		lastResult = null;
		lastInfo = null;
		lastProgress = null;
		lastParams = null;
	}

	public Boolean getLastPassed() {
		return lastPassed;
	}


	@Override
	public void onProccessStateChange(I_PhaseState info) {
		lastInfo = info;
	}

	@Override
	public void onProgress(I_PhaseState info) {
		lastProgress = info;
	}

  @Override
  public void onStartingSetup(I_Tests4J_Params params) {
    lastParams = params;
  }

  public I_PhaseState getLastInfo() {
    return lastInfo;
  }

  public I_PhaseState getLastProgress() {
    return lastProgress;
  }

  public I_Tests4J_Params getLastParams() {
    return lastParams;
  }

}
