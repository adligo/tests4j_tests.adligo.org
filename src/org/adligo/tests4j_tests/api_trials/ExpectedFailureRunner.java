package org.adligo.tests4j_tests.api_trials;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;

import org.adligo.tests4j.models.shared.AbstractTrial;
import org.adligo.tests4j.models.shared.I_AbstractTrial;
import org.adligo.tests4j.models.shared.metadata.I_TrialRunMetadata;
import org.adligo.tests4j.models.shared.results.I_TrialResult;
import org.adligo.tests4j.models.shared.results.I_TrialRunResult;
import org.adligo.tests4j.models.shared.system.I_TrialRunListener;
import org.adligo.tests4j.models.shared.system.Tests4J_Params;
import org.adligo.tests4j.models.shared.system.report.ConsoleReporter;
import org.adligo.tests4j.run.Tests4J;
import org.adligo.tests4j.run.helpers.TrialDescription;

public class ExpectedFailureRunner implements I_TrialRunListener {
	private I_TrialRunMetadata metadata;
	private I_TrialResult result;
	
	private ArrayBlockingQueue<I_TrialResult> block = new ArrayBlockingQueue<>(1);
	private ArrayBlockingQueue<I_TrialRunMetadata> metaBlock = new ArrayBlockingQueue<>(1);
	
	public void runExpectedFailure(Class<? extends AbstractTrial> clazz) {
		Tests4J_Params params = new Tests4J_Params();
		List<Class<? extends I_AbstractTrial>> tests = 
				new ArrayList<Class<? extends I_AbstractTrial>>();
		tests.add(clazz);
		params.setTrials(tests);
		ConsoleReporter silentReporter = new ConsoleReporter();
		silentReporter.setLogOff();
		//silentReporter.setLogOn(TrialDescription.class.getName());
		silentReporter.setRedirect(false);
		
		params.setReporter(silentReporter);
		//params.setLog(new ConsoleLogger( false));
		params.setTrialThreads(1);
		params.setExitAfterLastNotification(false);
		
		Tests4J.run(params, this);
		try {
			metadata = metaBlock.take();
			result = block.take();
		} catch (InterruptedException x) {
			throw new RuntimeException(x);
		}
	}


	public I_TrialResult getResult() {
		return result;
	}

	
	@Override
	public synchronized void onTrialCompleted(I_TrialResult pResult) {
		try {
			block.put(pResult);
		} catch (InterruptedException x) {
			throw new RuntimeException(x);
		}
	}


	@Override
	public void onRunCompleted(I_TrialRunResult result) {
		// TODO Auto-generated method stub
		
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
