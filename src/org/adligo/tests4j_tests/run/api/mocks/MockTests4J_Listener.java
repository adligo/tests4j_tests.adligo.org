package org.adligo.tests4j_tests.run.api.mocks;

import org.adligo.tests4j.models.shared.metadata.I_TrialRunMetadata;
import org.adligo.tests4j.models.shared.results.I_PhaseState;
import org.adligo.tests4j.models.shared.results.I_TrialResult;
import org.adligo.tests4j.models.shared.results.I_TrialRunResult;
import org.adligo.tests4j.system.shared.api.I_Tests4J_Listener;
import org.adligo.tests4j.system.shared.api.I_Tests4J_Params;

public class MockTests4J_Listener implements I_Tests4J_Listener {

	@Override
	public void onMetadataCalculated(I_TrialRunMetadata metadata) {
		
	}

	@Override
	public void onStartingTrial(String trialName) {
		
	}

	@Override
	public void onStartingTest(String trialName, String testName) {
		
	}

	@Override
	public void onTestCompleted(String trialName, String testName,
			boolean passed) {
		
	}

	@Override
	public void onTrialCompleted(I_TrialResult result) {
		
	}

	@Override
	public void onRunCompleted(I_TrialRunResult result) {
		
	}
	
	@Override
	public void onProccessStateChange(I_PhaseState info) {
		
	}

	@Override
	public void onProgress(I_PhaseState info) {
		// TODO Auto-generated method stub
		
	}

  @Override
  public void onStartingSetup(I_Tests4J_Params params) {
    // TODO Auto-generated method stub
    
  }

}
