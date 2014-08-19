package org.adligo.tests4j_tests;

import java.io.File;
import java.io.FileOutputStream;
import java.math.BigDecimal;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.adligo.tests4j.models.shared.metadata.I_TrialRunMetadata;
import org.adligo.tests4j.models.shared.results.I_TrialResult;
import org.adligo.tests4j.models.shared.results.I_TrialRunResult;
import org.adligo.tests4j.models.shared.system.I_Tests4J_CoveragePluginParams;
import org.adligo.tests4j.models.shared.system.I_Tests4J_Listener;
import org.adligo.tests4j.models.shared.system.I_Tests4J_ProcessInfo;
import org.adligo.tests4j.models.shared.system.Tests4J_Params;
import org.adligo.tests4j.models.shared.trials.I_Trial;
import org.adligo.tests4j.run.Tests4J;
import org.adligo.tests4j.shared.output.DefaultLog;
import org.adligo.tests4j.shared.output.I_Tests4J_Log;
import org.adligo.tests4j.shared.report.summary.SetupProcessDisplay;
import org.adligo.tests4j.shared.report.summary.SetupProgressDisplay;
import org.adligo.tests4j.shared.report.summary.TestDisplay;
import org.adligo.tests4j.shared.report.summary.TrialDisplay;
import org.adligo.tests4j.shared.report.summary.TrialsProcessDisplay;
import org.adligo.tests4j.shared.report.summary.TrialsProgressDisplay;
import org.adligo.tests4j_4jacoco.plugin.CoveragePluginFactory;
import org.adligo.tests4j_tests.base_trials.Counts;
import org.adligo.tests4j_tests.base_trials.I_CountingTrial;

public class RunAllTrials implements I_Tests4J_Listener {
	static long start = System.currentTimeMillis();
	static I_Tests4J_Log logger = new DefaultLog();
	private static volatile List<String> trialsNotCompleted = new CopyOnWriteArrayList<String>();
	private static ExecutorService trialsNotCompletedService = Executors.newSingleThreadExecutor();
	
	
	public static void main(String [] args) {
		try {
			//Tests4J_Params params = getTests(SimpleJacocoPluginFactory.class);
			
			Tests4J_Params params = getTests();
			params.setCoveragePluginFactoryClass(CoveragePluginFactory.class);
			setupCounts(params);
			/*
			File file = new File("biglog.log");
			if (file.exists()) {
				file.delete();
			}
			FileOutputStream biglog = new FileOutputStream(file);
			params.addAdditionalReportOutputStreams(biglog);
			*/
			//params.setRecommendedSetupThreadCount(1);
			params.setRecommendedTrialThreadCount(1);
			
			params.setLogState(TrialDisplay.class, false);
			params.setLogState(TestDisplay.class, false);
			//params.setLogState(ThreadDisplay.class, true);
			params.setLogState(SetupProcessDisplay.class, false);
			params.setLogState(SetupProgressDisplay.class, true);
			
			params.setLogState(TrialsProcessDisplay.class, false);
			params.setLogState(TrialsProgressDisplay.class, true);
			//params.setLogState(MultiProbesMap.class, true);
			
			//params.setLogState(Tests4J_NotificationManager.class, true);
			//params.setLogState(ClassReferencesDiscovery.class, true);
			//params.setLogState(TrialInstrumenter2.class, true);
			//params.setLogState(ClassInstrumenter.class, true);
			//params.setLogState(ClassParentsDiscovery.class, true);
			//params.setLogState(TrialInstrumenter.class, true);
			
			params.setMetaTrialClass(TheMetaTrial.class);
			//params.setThreadPoolSize(1);
			//params.setCoveragePlugin(new TieredJacocoPlugin());
			//
			 Tests4J.run(params, new RunAllTrials());
			//I_Tests4J_Controls controls = 
			 /*
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			*/
			//controls.cancel();
			
			//tsh.logAllThreadStates();
			trialsNotCompletedService.submit(new Runnable() {
				
				@Override
				public void run() {
					while (true) {
						if (trialsNotCompleted.size() >= 1) {
							logger.log("The following trials have started but not completed");
							logger.log(trialsNotCompleted.toString());
						}
						try {
							Thread.sleep(1000);
						} catch (InterruptedException x) {
							
						}
					}
				}
			});
		} catch (Throwable x) {
			x.printStackTrace();
		}
	}

	/**
	 * Note packages are loaded in dependency order to obvoid weird
	 * code coverage issues, where a static method is called by a class
	 * depending on the class which you are trying to test and sets a probe
	 * which is impossible to get to after it has been executed;
	 * Also this should help the through put of the tests
	 * as dependant code is loaded first.
	 * @return
	 */
	public static synchronized Tests4J_Params getTests() {
		Tests4J_Params toRet = new Tests4J_Params();
		
		toRet.addTrials(new org.adligo.tests4j_tests.models.shared.en.RunPkgTrials());
		
		toRet.addTrials(new org.adligo.tests4j_tests.models.shared.common.RunPkgTrials());
		
		toRet.addTrials(new org.adligo.tests4j_tests.models.shared.xml.RunPkgTrials());
		
		toRet.addTrials(new org.adligo.tests4j_tests.models.shared.asserts.RunPkgTrials());
		
		toRet.addTrials(new org.adligo.tests4j_tests.models.shared.dependency.RunPkgTrials());

		toRet.addTrials(new org.adligo.tests4j_tests.models.shared.metadata.RunPkgTrials());
		
		toRet.addTrials(new org.adligo.tests4j_tests.models.shared.system.RunPkgTrials());
		toRet.addTrials(new org.adligo.tests4j_tests.shared.RunPkgTrials());
		
		toRet.addTrials(new org.adligo.tests4j_tests.jacoco.api_trials.RunPkgTrials());
		toRet.addTrials(new org.adligo.tests4j_tests.jacoco.plugin.RunPkgTrials());
		
		toRet.addTrials(new org.adligo.tests4j_tests.run.RunPkgTrials());
		//toRet.addTrials(new org.adligo.tests4j_tests.trials_api.RunPkgTrials());
		
		return toRet;
	}

	private static void setupCounts(Tests4J_Params params) {
		
		I_Tests4J_CoveragePluginParams coverageParams = params.getCoverageParams();
		
		List<Class<? extends I_Trial>> trials = params.getTrials();
		Counts counts = new Counts();
		for (Class<? extends I_Trial> trialClass: trials) {
			try {
				I_CountingTrial ct = (I_CountingTrial) trialClass.newInstance();
				counts.setTests(counts.getTests() + ct.getTests());
				counts.setAsserts(counts.getAsserts() + ct.getAsserts());
				counts.setUniqueAsserts(counts.getUniqueAsserts() + ct.getUniqueAsserts());
				
				counts.setAfterTests(counts.getAfterTests() + ct.getATests());
				counts.setAfterAsserts(counts.getAfterAsserts()  + 
						ct.getAAsserts(coverageParams.isCanThreadLocalGroupRecord()));
				counts.setAfterUniqueAsserts(counts.getAfterUniqueAsserts()  + 
						ct.getAUniqueAsserts(coverageParams.isCanThreadLocalGroupRecord()));
			} catch (InstantiationException | IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		//NOTE it is to difficult to copy data between classloaders
		// so just print to the console here, and put the values in TheMetaTrial
		System.out.println("Single threaded Counts are as follows" +
				"\ntests " + counts.getTests() + 
				"\nasserts " + counts.getAsserts() +
				"\nuniqueAsserts " + counts.getUniqueAsserts() +
				"\nafterTests " + counts.getAfterTests() +
				"\nafterAsserts " + counts.getAfterAsserts() + 
				"\nafterUniqueAsserts " + counts.getAfterUniqueAsserts());
	}

	@Override
	public void onMetadataCalculated(I_TrialRunMetadata metadata) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStartingTrial(String trialName) {
		trialsNotCompleted.add(trialName);
	}

	@Override
	public void onStartingTest(String trialName, String testName) {
	}

	@Override
	public void onTestCompleted(String trialName, String testName,
			boolean passed) {
		
	}

	@Override
	public synchronized void onTrialCompleted(I_TrialResult result) {
		trialsNotCompleted.remove(result.getName());
	}

	@Override
	public void onRunCompleted(I_TrialRunResult result) {
		
		long end = System.currentTimeMillis();
		long dur = end - start;
		BigDecimal durD = new BigDecimal(dur).divide(new BigDecimal(1000));
		//use the reporter to log to the original System.out
		logger.log("Total run time " +durD + " seconds.");
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
