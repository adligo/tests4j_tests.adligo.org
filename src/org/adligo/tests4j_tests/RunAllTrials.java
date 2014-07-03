package org.adligo.tests4j_tests;

import java.math.BigDecimal;

import org.adligo.tests4j.models.shared.metadata.I_TrialRunMetadata;
import org.adligo.tests4j.models.shared.results.I_TrialResult;
import org.adligo.tests4j.models.shared.results.I_TrialRunResult;
import org.adligo.tests4j.models.shared.system.I_Tests4J_Controls;
import org.adligo.tests4j.models.shared.system.I_TrialRunListener;
import org.adligo.tests4j.models.shared.system.Tests4J_Params;
import org.adligo.tests4j.run.Tests4J;
import org.adligo.tests4j.run.helpers.Tests4J_NotificationManager;
import org.adligo.tests4j.run.helpers.ThreadStateHelper;
import org.adligo.tests4j.run.helpers.TrialInstancesProcessor;
import org.adligo.tests4j.run.helpers.TrialProcessorControls;
import org.adligo.tests4j.shared.report.summary.SummaryReporter;
import org.adligo.tests4j_4jacoco.plugin.ScopedJacocoPlugin;

public class RunAllTrials implements I_TrialRunListener {
	static long start = System.currentTimeMillis();
	static SummaryReporter reporter;
	
	public static void main(String [] args) {
		
		
		Tests4J_Params params = getTests();
		reporter = new SummaryReporter();
		//reporter.setListRelevantClassesWithoutTrials(true);
		//reporter.setListRelevantClassesWithoutTrials(true);
		reporter.setLogOn(Tests4J_NotificationManager.class);
		reporter.setLogOn(TrialProcessorControls.class);
		reporter.setLogOn(TrialInstancesProcessor.class);
		
		//reporter.setLogOn(TestRunable.class);
		//reporter.setLogOn(Tests4J_Memory.class);
		
		//logging from jacoco
		//reporter.setLogOn(AbstractPlugin.class);
		//reporter.setLogOn(Recorder.class);
		
		params.setReporter(reporter);
		params.setExitAfterLastNotification(false);
		params.setCoveragePluginClass(ScopedJacocoPlugin.class);
		
		params.setMetaTrialClass(TheMetaTrial.class);
		//params.setThreadPoolSize(1);
		//params.setCoveragePlugin(new TieredJacocoPlugin());
		I_Tests4J_Controls controls =  Tests4J.run(params, new RunAllTrials());
		/*
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
		//controls.cancel();
		
		ThreadStateHelper tsh = new ThreadStateHelper(params.getReporter());
		//tsh.logAllThreadStates();
	}

	public static Tests4J_Params getTests() {
		Tests4J_Params toRet = new Tests4J_Params();
		
		toRet.addTrials(new org.adligo.tests4j_tests.models.shared.asserts.RunPkgTrials());
		toRet.addTrials(new org.adligo.tests4j_tests.models.shared.common.RunPkgTrials());
		toRet.addTrials(new org.adligo.tests4j_tests.models.shared.system.RunPkgTrials());
		toRet.addTrials(new org.adligo.tests4j_tests.models.shared.en.trials.asserts.RunPkgTrials());
		
		toRet.addTrials(new org.adligo.tests4j_tests.jacoco.api_trials.RunPkgTrials());
		toRet.addTrials(new org.adligo.tests4j_tests.jacoco.plugin.instrumentation.RunPkgTrials());
		
		toRet.addTrials(new org.adligo.tests4j_tests.run.discovery.RunPkgTrials());
		toRet.addTrials(new org.adligo.tests4j_tests.run.remote.io.RunPkgTrials());
		toRet.addTrials(new org.adligo.tests4j_tests.run.remote.socket_api.RunPkgTrials());
		
		toRet.addTrials(new org.adligo.tests4j_tests.trials_api.RunPkgTrials());
		
		return toRet;
	}

	@Override
	public void onMetadataCalculated(I_TrialRunMetadata metadata) {
		// TODO Auto-generated method stub
		
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

	@Override
	public void onTrialCompleted(I_TrialResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onRunCompleted(I_TrialRunResult result) {
		long end = System.currentTimeMillis();
		long dur = end - start;
		BigDecimal durD = new BigDecimal(dur).divide(new BigDecimal(1000));
		//use the reporter to log to the original System.out
		reporter.log("Total run time " +durD + " seconds.");
	}


}
