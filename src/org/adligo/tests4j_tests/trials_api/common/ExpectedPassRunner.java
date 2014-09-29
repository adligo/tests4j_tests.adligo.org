package org.adligo.tests4j_tests.trials_api.common;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.CopyOnWriteArrayList;

import org.adligo.tests4j.models.shared.metadata.I_TrialRunMetadata;
import org.adligo.tests4j.models.shared.results.I_TrialResult;
import org.adligo.tests4j.models.shared.results.I_TrialRunResult;
import org.adligo.tests4j.run.Tests4J;
import org.adligo.tests4j.system.shared.I_Tests4J_Controls;
import org.adligo.tests4j.system.shared.I_Tests4J_Listener;
import org.adligo.tests4j.system.shared.I_Tests4J_ProcessInfo;
import org.adligo.tests4j.system.shared.Tests4J_Params;
import org.adligo.tests4j.system.shared.report.summary.SummaryReporter;
import org.adligo.tests4j.system.shared.trials.I_Trial;

public class ExpectedPassRunner implements I_Tests4J_Listener {
	private I_TrialRunMetadata metadata;
	SummaryReporter silentReporter = new SummaryReporter();
	
	private int size = 0;
	private final CopyOnWriteArrayList<I_TrialResult> results = new CopyOnWriteArrayList<I_TrialResult>();
	private SystemRunnerMock mockSystem = new SystemRunnerMock();
	
	public ExpectedPassRunner() {
		
	}
	
	public void run(Class<? extends I_Trial> trial) {
		List<Class<? extends I_Trial>> trials = new ArrayList<>();
		trials.add(trial);
		run(trials);
	}
	
	public void run(List<Class<? extends I_Trial>> trials) {
		Tests4J_Params params = new Tests4J_Params();
		size = trials.size();
		params.setTrials(trials);
		//silentReporter.setLogOff();
		//silentReporter.setLogOn(TrialDescription.class.getName());

		
		Tests4JRunnerMock mock = new Tests4JRunnerMock();
		mock.setSystem(mockSystem);
		
		I_Tests4J_Controls controlls = mock.instanceRun(params, this);
		if (!controlls.isRunning()) {
			throw new RuntimeException("The trial run didn't start.");
		}
		controlls.waitForResults();
	}


	public List<I_TrialResult> getResults() {
		return results;
	}

	
	@Override
	public synchronized void onTrialCompleted(I_TrialResult pResult) {
		//silentReporter.log("Finished test " + pResult.getName() );
		results.add(pResult);
		
	}


	@Override
	public void onRunCompleted(I_TrialRunResult result) {
		
	}


	@Override
	public synchronized void onMetadataCalculated(I_TrialRunMetadata p) {
		metadata = p;
	}


	public I_TrialRunMetadata getMetadata() {
		return metadata;
	}


	@Override
	public void onStartingTrial(String trialName) {
		//silentReporter.log("Starting test " + trialName );
	}


	@Override
	public void onStartingTest(String trialName, String testName) {
		
	}


	@Override
	public void onTestCompleted(String trialName, String testName,
			boolean passed) {
		// TODO Auto-generated method stub
		
	}

	public SystemRunnerMock getMockSystem() {
		return mockSystem;
	}

	@Override
	public void onProccessStateChange(I_Tests4J_ProcessInfo info) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onProgress(I_Tests4J_ProcessInfo info) {
		// TODO Auto-generated method stub
		
	}
	
}
