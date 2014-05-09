package org.adligo.tests4j_tests;

import java.math.BigDecimal;

import org.adligo.tests4j.models.shared.metadata.I_TrialRunMetadata;
import org.adligo.tests4j.models.shared.results.I_TrialResult;
import org.adligo.tests4j.models.shared.results.I_TrialRunResult;
import org.adligo.tests4j.models.shared.system.I_TrialRunListener;
import org.adligo.tests4j.models.shared.system.Tests4J_Params;
import org.adligo.tests4j.models.shared.system.report.I_Tests4J_Reporter;
import org.adligo.tests4j.run.Tests4J;
import org.adligo.tests4j_4jacoco.plugin.OldScopedJacocoPlugin;

public class RunAllTrials implements I_TrialRunListener {
	static long start = System.currentTimeMillis();
	static I_Tests4J_Reporter reporter;
	
	public static void main(String [] args) {
		
		
		Tests4J_Params params = getTests();
		reporter =  params.getReporter();
		params.setCheckMins(false);
		//params.setLog(new ConsoleLogger(false));
		OldScopedJacocoPlugin plugin = new OldScopedJacocoPlugin();
		params.setCoveragePlugin(plugin);
		//params.setThreadPoolSize(1);
		//params.setCoveragePlugin(new TieredJacocoPlugin());
		Tests4J.run(params, new RunAllTrials());
		
	}

	private static Tests4J_Params getTests() {
		Tests4J_Params toRet = new Tests4J_Params();
		
		toRet.addTrials(new org.adligo.tests4j_tests.models.shared.system.RunPkgTrials());
		toRet.addTrials(new org.adligo.tests4j_tests.api_trials.RunPkgTrials());
		toRet.addTrials(new org.adligo.tests4j_tests.jacoco.api_trials.RunPkgTrials());
		toRet.addTrials(new org.adligo.tests4j_tests.jacoco.plugin.instrumentation.RunPkgTrials());
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
		reporter.log("Total run time " +durD + " Seconds.");
	}


}
