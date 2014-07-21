package org.adligo.tests4j_tests;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.adligo.tests4j.models.shared.metadata.I_TrialRunMetadata;
import org.adligo.tests4j.models.shared.results.I_TrialResult;
import org.adligo.tests4j.models.shared.results.I_TrialRunResult;
import org.adligo.tests4j.models.shared.system.DefaultLogger;
import org.adligo.tests4j.models.shared.system.I_CoveragePlugin;
import org.adligo.tests4j.models.shared.system.I_CoveragePluginFactory;
import org.adligo.tests4j.models.shared.system.I_Tests4J_Controls;
import org.adligo.tests4j.models.shared.system.I_Tests4J_Logger;
import org.adligo.tests4j.models.shared.system.I_TrialRunListener;
import org.adligo.tests4j.models.shared.system.Tests4J_Params;
import org.adligo.tests4j.models.shared.trials.I_Trial;
import org.adligo.tests4j.run.Tests4J;
import org.adligo.tests4j.run.discovery.Tests4J_ParamsReader;
import org.adligo.tests4j.run.helpers.TrialsProcessor;
import org.adligo.tests4j_4jacoco.plugin.ScopedJacocoPluginFactory;
import org.adligo.tests4j_tests.base_abstract_trials.Counts;
import org.adligo.tests4j_tests.base_abstract_trials.I_CountingTrial;

public class RunAllTrials implements I_TrialRunListener {
	static long start = System.currentTimeMillis();
	static I_Tests4J_Logger logger = new DefaultLogger();
	private static volatile List<String> trialsNotCompleted = new CopyOnWriteArrayList<String>();
	private static ExecutorService trialsNotCompletedService = Executors.newSingleThreadExecutor();
	
	
	public static void main(String [] args) {
		
		//Tests4J_Params params = getTests(SimpleJacocoPluginFactory.class);
		
		Tests4J_Params params = getTests(ScopedJacocoPluginFactory.class);
		//params.setThreadCount(new SimpleThreadCount(1));
		
		
		List<Class<?>> loggingClasses = new ArrayList<Class<?>>(params.getLoggingClasses());
		/*
		loggingClasses.add(Tests4J_ThreadFactory.class);
		loggingClasses.add(MultiProbeDataStore.class);
		loggingClasses.add(MultiProbesMap.class);
		loggingClasses.add(TrialInstancesProcessor.class);
		*/
		loggingClasses.add(TrialsProcessor.class);
		params.setLoggingClasses(loggingClasses);
		//params.setExitAfterLastNotification(false);
		
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
	}

	public static synchronized Tests4J_Params getTests(Class<? extends I_CoveragePluginFactory> factoryClass) {
		Tests4J_Params toRet = new Tests4J_Params();
		toRet.setCoveragePluginFactoryClass(factoryClass);
		
		toRet.addTrials(new org.adligo.tests4j_tests.models.shared.asserts.RunPkgTrials());
		toRet.addTrials(new org.adligo.tests4j_tests.models.shared.common.RunPkgTrials());
		toRet.addTrials(new org.adligo.tests4j_tests.models.shared.system.RunPkgTrials());
		toRet.addTrials(new org.adligo.tests4j_tests.models.shared.en.trials.asserts.RunPkgTrials());
		toRet.addTrials(new org.adligo.tests4j_tests.models.shared.metadata.RunPkgTrials());
		toRet.addTrials(new org.adligo.tests4j_tests.models.shared.xml.RunPkgTrials());
		toRet.addTrials(new org.adligo.tests4j_tests.shared.report.summary.RunPkgTrials());
		
		toRet.addTrials(new org.adligo.tests4j_tests.jacoco.api_trials.RunPkgTrials());
		toRet.addTrials(new org.adligo.tests4j_tests.jacoco.plugin.RunPkgTrials());
		
		toRet.addTrials(new org.adligo.tests4j_tests.run.discovery.RunPkgTrials());
		toRet.addTrials(new org.adligo.tests4j_tests.run.helpers.RunPkgTrials());
		toRet.addTrials(new org.adligo.tests4j_tests.run.remote.io.RunPkgTrials());
		toRet.addTrials(new org.adligo.tests4j_tests.run.remote.socket_api.RunPkgTrials());
		
		toRet.addTrials(new org.adligo.tests4j_tests.trials_api.RunPkgTrials());
		
		Tests4J_ParamsReader reader = new Tests4J_ParamsReader(toRet, new DefaultLogger());
		I_CoveragePlugin plugin = reader.getCoveragePlugin();
		
		List<Class<? extends I_Trial>> trials = toRet.getTrials();
		Counts counts = new Counts();
		for (Class<? extends I_Trial> trialClass: trials) {
			try {
				I_CountingTrial ct = (I_CountingTrial) trialClass.newInstance();
				counts.setTests(counts.getTests() + ct.getTests());
				counts.setAsserts(counts.getAsserts() + ct.getAsserts());
				counts.setUniqueAsserts(counts.getUniqueAsserts() + ct.getUniqueAsserts());
				
				counts.setAfterTests(counts.getAfterTests() + ct.getATests());
				counts.setAfterAsserts(counts.getAfterAsserts()  + 
						ct.getAAsserts(plugin.canThreadGroupLocalRecord()));
				counts.setAfterUniqueAsserts(counts.getAfterUniqueAsserts()  + 
						ct.getAUniqueAsserts(plugin.canThreadGroupLocalRecord()));
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
		return toRet;
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


}
