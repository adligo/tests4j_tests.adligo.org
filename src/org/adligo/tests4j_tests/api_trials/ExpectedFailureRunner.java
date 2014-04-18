package org.adligo.tests4j_tests.api_trials;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;

import org.adligo.tests4j.models.shared.I_AbstractTrial;
import org.adligo.tests4j.models.shared.metadata.I_TrialRunMetadata;
import org.adligo.tests4j.models.shared.results.I_TrialResult;
import org.adligo.tests4j.models.shared.results.I_TrialRunResult;
import org.adligo.tests4j.models.shared.system.I_TrialRunListener;
import org.adligo.tests4j.models.shared.system.Tests4J_Params;
import org.adligo.tests4j.models.shared.system.console.ConsoleLogger;
import org.adligo.tests4j.run.Tests4J;

public class ExpectedFailureRunner implements I_TrialRunListener {
	private I_TrialResult result;
	private ArrayBlockingQueue<Boolean> block = new ArrayBlockingQueue<>(1);

	public void runExpectedFailure(Class<? extends I_AbstractTrial> clazz) {
		Tests4J_Params params = new Tests4J_Params();
		List<Class<? extends I_AbstractTrial>> tests = new ArrayList<Class<? extends I_AbstractTrial>>();
		tests.add(clazz);
		params.setTrials(tests);
		params.setLog(new ConsoleLogger(false));
		params.setThreadPoolSize(1);
		params.setExitAfterLastNotification(false);
		
		Tests4J.run(params, this);
		try {
			block.poll(5, TimeUnit.MINUTES);
		} catch (InterruptedException x) {
			throw new RuntimeException(x);
		}
	}


	public I_TrialResult getResult() {
		return result;
	}

	
	@Override
	public void onTrialCompleted(I_TrialResult pResult) {
		result = pResult;
		try {
			block.put(true);
		} catch (InterruptedException x) {
			throw new RuntimeException(x);
		}
	}


	@Override
	public void onRunCompleted(I_TrialRunResult result) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void onMetadataCalculated(I_TrialRunMetadata metadata) {
		// TODO Auto-generated method stub
		
	}

}
