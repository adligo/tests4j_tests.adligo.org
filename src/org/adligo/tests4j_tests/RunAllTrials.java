package org.adligo.tests4j_tests;

import java.math.BigDecimal;

import org.adligo.tests4j.models.shared.common.Tests4J_System;
import org.adligo.tests4j.models.shared.metadata.I_TrialRunMetadata;
import org.adligo.tests4j.models.shared.results.I_TrialResult;
import org.adligo.tests4j.models.shared.results.I_TrialRunResult;
import org.adligo.tests4j.models.shared.system.I_Tests4J_Listener;
import org.adligo.tests4j.models.shared.system.I_Tests4J_ProcessInfo;
import org.adligo.tests4j.models.shared.system.Tests4J_DefaultProgressMonitor;
import org.adligo.tests4j.models.shared.system.Tests4J_Params;
import org.adligo.tests4j.models.shared.trials.I_MetaTrialParams;
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
import org.adligo.tests4j_tests.base_trials.I_CountingPackageTrials;
import org.adligo.tests4j_tests.base_trials.SimpleMetaTrial;
import org.adligo.tests4j_tests.base_trials.SimplePackageTrials;
import org.adligo.tests4j_tests.jacoco.api_trials.A_CocoApiPkgTrials;
import org.adligo.tests4j_tests.jacoco.plugin.A_CocoPlugPkgTrials;
import org.adligo.tests4j_tests.models.shared.asserts.A_AssertsPkgTrials;
import org.adligo.tests4j_tests.models.shared.common.A_CmnPkgTrials;
import org.adligo.tests4j_tests.models.shared.dependency.A_DepsPkgTrials;
import org.adligo.tests4j_tests.models.shared.en.A_EnPkgTrials;
import org.adligo.tests4j_tests.models.shared.metadata.A_MetaPkgTrials;
import org.adligo.tests4j_tests.models.shared.results.A_ResultsPkgTrials;
import org.adligo.tests4j_tests.models.shared.system.A_SysPkgTrials;
import org.adligo.tests4j_tests.models.shared.xml.A_XmlPkgTrials;
import org.adligo.tests4j_tests.run.A_RunPkgTrials;
import org.adligo.tests4j_tests.shared.A_SharePkgTrials;
import org.adligo.tests4j_tests.trials_api.A_ApiPkgTrials;
import org.adligo.tests4j_v1_tests.A_JavaVersionSpecificTrials;
import org.adligo.tests4j_v1_tests.jacoco.plugin.A_CocoJavaVersionSpecificTrials;

public class RunAllTrials  extends SimplePackageTrials 
implements I_MetaTrialParams<RunAllTrials>, I_CountingPackageTrials, I_Tests4J_Listener {
	
	static long start = System.currentTimeMillis();
	static I_Tests4J_Log logger = new DefaultLog();
	//private static volatile List<String> trialsNotCompleted = new CopyOnWriteArrayList<String>();
	//private static ExecutorService trialsNotCompletedService = Executors.newSingleThreadExecutor();
	private A_EnPkgTrials en = new A_EnPkgTrials();
	private A_CmnPkgTrials cmn = new A_CmnPkgTrials();
	private A_XmlPkgTrials xml = new A_XmlPkgTrials();
	private A_AssertsPkgTrials asserts = new A_AssertsPkgTrials();
	private A_DepsPkgTrials deps = new A_DepsPkgTrials();
	private A_MetaPkgTrials meta = new A_MetaPkgTrials();
	
	private A_ResultsPkgTrials results = new A_ResultsPkgTrials();
	
	private A_SysPkgTrials sys = new A_SysPkgTrials();
	private A_SharePkgTrials share = new A_SharePkgTrials();
	
	private A_CocoApiPkgTrials cocoApi = new A_CocoApiPkgTrials();
	private A_CocoPlugPkgTrials cocoPlug = new A_CocoPlugPkgTrials();
	
	private A_RunPkgTrials run = new A_RunPkgTrials();
	
	private A_JavaVersionSpecificTrials jv = new A_JavaVersionSpecificTrials();
	private A_CocoJavaVersionSpecificTrials cocoJv = new A_CocoJavaVersionSpecificTrials();
	
	private A_ApiPkgTrials api = new A_ApiPkgTrials();
	
	
	public static void main(String [] args) {
		try {
			Tests4J_Params params = new Tests4J_Params();
			params.setCoveragePluginFactoryClass(CoveragePluginFactory.class);
			params.setMetaTrialClass(TheMetaTrial.class);
			//params.setMetaTrialClass(SimpleMetaTrial.class);
			RunAllTrials me = new RunAllTrials();
			//params.setMetaTrialParams(me);
			
			params.setRecommendedSetupThreadCount(16);
			me.setParams(params);
			me.addTrials(params);
			
			params.addTrials(me);
			
			Tests4J_DefaultProgressMonitor dpm = new Tests4J_DefaultProgressMonitor(Tests4J_System.SYSTEM);
			dpm.setSleepTime(500);
			params.setProgressMonitor(dpm);
		
			params.setLogState(TrialDisplay.class, false);
			params.setLogState(TestDisplay.class, false);
			//params.setLogState(ThreadDisplay.class, true);
			params.setLogState(SetupProcessDisplay.class, false);
			params.setLogState(SetupProgressDisplay.class, true);
			
			params.setLogState(TrialsProcessDisplay.class, false);
			params.setLogState(TrialsProgressDisplay.class, true);
			//params.setLogState(Tests4J_Processor.class, true);
			//params.setLogState(TrialQueueDecisionTree.class, true);
			//params.setLogState(MultiProbesMap.class, true);
			
			//params.setLogState(ReferenceTrackingClassVisitor.class, true);
			//params.setLogState(ClassReferencesDiscovery.class, true);
			//params.setLogState(TrialInstrumenter2.class, true);
			//params.setLogState(ClassInstrumenter.class, true);
			//params.setLogState(ClassParentsDiscovery.class, true);
			//params.setLogState(TrialInstrumenter.class, true);
			
			
			//params.setThreadPoolSize(1);
			//params.setCoveragePlugin(new TieredJacocoPlugin());
			//
			 Tests4J.run(params, me);
			
		} catch (Throwable x) {
			x.printStackTrace(ERR);
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
	public void addTrials(Tests4J_Params params) throws Exception {
	
		en.setParams(params);
		en.addTrials();
		add(en.getCountingTrials());
		
		cmn.setParams(params);
		cmn.addTrials();
		add(cmn.getCountingTrials());
	
		xml.setParams(params);
		xml.addTrials();
		add(xml.getCountingTrials());
		
		asserts.setParams(params);
		asserts.addTrials();
		add(asserts.getCountingTrials());
		
		deps.setParams(params);
		deps.addTrials();
		add(deps.getCountingTrials());
		
		meta.setParams(params);
		meta.addTrials();
		add(meta.getCountingTrials());
		
		results.setParams(params);
		results.addTrials();
		add(results.getCountingTrials());
		
		sys.setParams(params);
		sys.addTrials();
		add(sys.getCountingTrials());
		
		share.setParams(params);
		share.addTrials();
		add(share.getCountingTrials());
		
		cocoApi.setParams(params);
		cocoApi.addTrials();
		add(cocoApi.getCountingTrials());
		
		cocoPlug.setParams(params);
		cocoPlug.addTrials();
		add(cocoPlug.getCountingTrials());
		
		run.setParams(params);
		run.addTrials();
		add(run.getCountingTrials());
				
		jv.setParams(params);
		jv.addTrials();
		add(jv.getCountingTrials());
		
		cocoJv.setParams(params);
		cocoJv.addTrials();
		add(cocoJv.getCountingTrials());
		
		api.setParams(params);
		api.addTrials();
		add(api.getCountingTrials());
	}


	@Override
	public void onMetadataCalculated(I_TrialRunMetadata metadata) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStartingTrial(String trialName) {
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

	@Override
	public RunAllTrials getTrialParams() {
		return this;
	}


}
