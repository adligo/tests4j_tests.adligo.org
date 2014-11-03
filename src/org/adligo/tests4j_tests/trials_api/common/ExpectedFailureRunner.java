package org.adligo.tests4j_tests.trials_api.common;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import org.adligo.tests4j.models.shared.metadata.I_TrialRunMetadata;
import org.adligo.tests4j.models.shared.results.I_PhaseState;
import org.adligo.tests4j.models.shared.results.I_TrialResult;
import org.adligo.tests4j.models.shared.results.I_TrialRunResult;
import org.adligo.tests4j.system.shared.api.I_Tests4J_Controls;
import org.adligo.tests4j.system.shared.api.I_Tests4J_CoveragePluginFactory;
import org.adligo.tests4j.system.shared.api.I_Tests4J_Listener;
import org.adligo.tests4j.system.shared.api.Tests4J_Params;
import org.adligo.tests4j.system.shared.trials.I_Trial;

/**
 * simulates a run of tests4j
 *     
 * @author scott
 *
 */
public class ExpectedFailureRunner implements I_Tests4J_Listener {
	private I_TrialRunMetadata metadata;
	
	private int size = 0;
	private final CopyOnWriteArrayList<I_TrialResult> results = new CopyOnWriteArrayList<I_TrialResult>();
	private SystemRunnerMock mockSystem = new SystemRunnerMock();
	private Class<? extends I_Tests4J_CoveragePluginFactory> coveragPluginFactory_ = null;
	
	public ExpectedFailureRunner() {}
	
	public void run(Class<? extends I_Trial> trial) {
		List<Class<? extends I_Trial>> list = new ArrayList<Class<? extends I_Trial>>();
		list.add(trial);
		run(list);
	}
	
	public void run(List<Class<? extends I_Trial>> trials) {
		Tests4J_Params params = new Tests4J_Params();
		size = trials.size();
		params.setTrials(trials);
		if (coveragPluginFactory_ != null) {
			params.setCoveragePluginFactoryClass(coveragPluginFactory_);
		}
		Tests4JRunnerMock mock = new Tests4JRunnerMock();
		mock.setSystem(mockSystem);
		
		final I_Tests4J_Controls controlls = mock.instanceRun(params, this);
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
		// TODO Auto-generated method stub
		
	}


	@Override
	public void onStartingTest(String trialName, String testName) {
		// TODO Auto-generated method stub
		
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
	public void onProccessStateChange(I_PhaseState info) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onProgress(I_PhaseState info) {
		// TODO Auto-generated method stub
		
	}

	public Class<? extends I_Tests4J_CoveragePluginFactory> getCoveragPluginFactory() {
		return coveragPluginFactory_;
	}

	public void setCoveragPluginFactory(Class<? extends I_Tests4J_CoveragePluginFactory> coveragPluginFactory) {
		this.coveragPluginFactory_ = coveragPluginFactory;
	}

}
