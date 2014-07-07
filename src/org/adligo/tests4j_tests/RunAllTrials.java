package org.adligo.tests4j_tests;

import java.math.BigDecimal;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.adligo.tests4j.models.shared.metadata.I_TrialRunMetadata;
import org.adligo.tests4j.models.shared.results.I_TrialResult;
import org.adligo.tests4j.models.shared.results.I_TrialRunResult;
import org.adligo.tests4j.models.shared.system.I_CoveragePlugin;
import org.adligo.tests4j.models.shared.system.I_Tests4J_Controls;
import org.adligo.tests4j.models.shared.system.I_TrialRunListener;
import org.adligo.tests4j.models.shared.system.Tests4J_Params;
import org.adligo.tests4j.models.shared.trials.I_Trial;
import org.adligo.tests4j.run.Tests4J;
import org.adligo.tests4j.run.helpers.Tests4J_NotificationManager;
import org.adligo.tests4j.run.helpers.ThreadStateHelper;
import org.adligo.tests4j.shared.report.summary.SummaryReporter;
import org.adligo.tests4j_4jacoco.plugin.ScopedJacocoPlugin;
import org.adligo.tests4j_tests.base_abstract_trials.Counts;
import org.adligo.tests4j_tests.base_abstract_trials.I_CountingTrial;

public class RunAllTrials implements I_TrialRunListener {
	static long start = System.currentTimeMillis();
	static SummaryReporter reporter;
	private static volatile List<String> trialsNotCompleted = new CopyOnWriteArrayList<String>();
	private static ExecutorService trialsNotCompletedService = Executors.newSingleThreadExecutor();
	
	
	public static void main(String [] args) {
		
		Tests4J_Params params = getTests(ScopedJacocoPlugin.class);
		
		reporter = new SummaryReporter();
		//reporter.setListRelevantClassesWithoutTrials(true);
		//reporter.setListRelevantClassesWithoutTrials(true);
		reporter.setLogOn(Tests4J_NotificationManager.class);
		//reporter.setLogOn(TrialProcessorControls.class);
		//reporter.setLogOn(TrialInstancesProcessor.class);
		
		//reporter.setLogOn(TestRunable.class);
		//reporter.setLogOn(MultiProbesMap.class);
		
		//logging from jacoco
		//reporter.setLogOn(AbstractPlugin.class);
		//reporter.setLogOn(Recorder.class);
		
		params.setReporter(reporter);
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
		
		ThreadStateHelper tsh = new ThreadStateHelper(params.getReporter());
		//tsh.logAllThreadStates();
		trialsNotCompletedService.submit(new Runnable() {
			
			@Override
			public void run() {
				while (true) {
					if (trialsNotCompleted.size() >= 1) {
						reporter.log("The following trials have started but not completed");
						reporter.log(trialsNotCompleted.toString());
					}
					try {
						Thread.sleep(1000);
					} catch (InterruptedException x) {
						
					}
				}
			}
		});
	}

	public static synchronized Tests4J_Params getTests(Class<? extends I_CoveragePlugin> pluginClass) {
		Tests4J_Params toRet = new Tests4J_Params();
		toRet.setCoveragePluginClass(pluginClass);
		
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
		
		I_CoveragePlugin plugin = toRet.getCoveragePlugin();
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
						ct.getAAsserts(plugin.canThreadLocalRecord()));
				counts.setAfterUniqueAsserts(counts.getAfterUniqueAsserts()  + 
						ct.getAUniqueAsserts(plugin.canThreadLocalRecord()));
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
	public void onStartingTrail(String trialName) {
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
		reporter.log("Total run time " +durD + " seconds.");
	}


}
