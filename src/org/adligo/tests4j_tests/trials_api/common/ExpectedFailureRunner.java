package org.adligo.tests4j_tests.trials_api.common;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.CopyOnWriteArrayList;

import org.adligo.tests4j.models.shared.metadata.I_TrialRunMetadata;
import org.adligo.tests4j.models.shared.results.I_TrialResult;
import org.adligo.tests4j.models.shared.results.I_TrialRunResult;
import org.adligo.tests4j.models.shared.system.I_TrialRunListener;
import org.adligo.tests4j.models.shared.system.Tests4J_Params;
import org.adligo.tests4j.models.shared.trials.AbstractTrial;
import org.adligo.tests4j.models.shared.trials.I_Trial;
import org.adligo.tests4j.run.Tests4J;
import org.adligo.tests4j.shared.report.summary.SummaryReporter;

/**
 * simulates a run of tests4j
 *     
 * @author scott
 *
 */
public class ExpectedFailureRunner implements I_TrialRunListener {
	private I_TrialRunMetadata metadata;
	
	private int size = 0;
	private ArrayBlockingQueue<List<I_TrialResult>> block = new ArrayBlockingQueue<List<I_TrialResult>>(1);
	private CopyOnWriteArrayList<I_TrialResult> results = new CopyOnWriteArrayList<I_TrialResult>();
	private ArrayBlockingQueue<I_TrialRunMetadata> metaBlock = new ArrayBlockingQueue<>(1);
	
	public void run(Class<? extends I_Trial> trial) {
		List<Class<? extends I_Trial>> list = new ArrayList<Class<? extends I_Trial>>();
		list.add(trial);
		run(list);
	}
	
	public void run(List<Class<? extends I_Trial>> trials) {
		Tests4J_Params params = new Tests4J_Params();
		size = trials.size();
		params.setTrials(trials);
		SummaryReporter silentReporter = new SummaryReporter();
		silentReporter.setLogOff();
		//silentReporter.setLogOn(TrialDescription.class.getName());
		silentReporter.setRedirect(false);
		
		params.setReporter(silentReporter);
		//params.setLog(new ConsoleLogger( false));
		params.setExitAfterLastNotification(false);
		
		Tests4J.run(params, this);
		try {
			metadata = metaBlock.take();
			block.take();
		} catch (InterruptedException x) {
			throw new RuntimeException(x);
		}
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
		try {
			block.put(results);
		} catch (InterruptedException x) {
			throw new RuntimeException(x);
		}
	}


	@Override
	public synchronized void onMetadataCalculated(I_TrialRunMetadata p) {
		metaBlock.add(p);
	}


	public I_TrialRunMetadata getMetadata() {
		return metadata;
	}


	@Override
	public void onStartingTrail(String trialName) {
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

}
