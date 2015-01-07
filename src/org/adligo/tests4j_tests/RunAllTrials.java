package org.adligo.tests4j_tests;

import org.adligo.tests4j.run.api.Tests4J;
import org.adligo.tests4j.run.helpers.Tests4J_Processor;
import org.adligo.tests4j.run.xml_bindings.io.Tests4J_XmlFileOutputListener;
import org.adligo.tests4j.shared.output.DefaultLog;
import org.adligo.tests4j.shared.output.I_Tests4J_Log;
import org.adligo.tests4j.system.shared.api.Tests4J_DefaultProgressParams;
import org.adligo.tests4j.system.shared.api.Tests4J_Params;
import org.adligo.tests4j.system.shared.report.summary.SetupProcessDisplay;
import org.adligo.tests4j.system.shared.report.summary.SetupProgressDisplay;
import org.adligo.tests4j.system.shared.report.summary.TestDisplay;
import org.adligo.tests4j.system.shared.report.summary.TrialDisplay;
import org.adligo.tests4j.system.shared.report.summary.TrialsProcessDisplay;
import org.adligo.tests4j.system.shared.report.summary.TrialsProgressDisplay;
import org.adligo.tests4j.system.shared.trials.I_MetaTrialParams;
import org.adligo.tests4j_4jacoco.plugin.Recorder;
import org.adligo.tests4j_4jacoco.plugin.factories.MockitoPluginFactory;
import org.adligo.tests4j_tests.base_trials.I_CountingPackageTrials;
import org.adligo.tests4j_tests.base_trials.SimplePackageTrials;
import org.adligo.tests4j_tests.base_trials.TheMetaTrial;
import org.adligo.tests4j_tests.jacoco.api_trials.A_CocoApiPkgTrials;
import org.adligo.tests4j_tests.jacoco.plugin.A_CocoPlugPkgTrials;
import org.adligo.tests4j_tests.mockito.A_MockitoTrials;
import org.adligo.tests4j_tests.models.A_ModelsPkgTrials;
import org.adligo.tests4j_tests.run.A_RunPkgTrials;
import org.adligo.tests4j_tests.shared.A_SharePkgTrials;
import org.adligo.tests4j_tests.system.shared.A_SysPkgTrials;
import org.adligo.tests4j_tests.trials_api.A_ApiPkgTrials;
import org.adligo.tests4j_v1_tests.A_JavaVersionSpecificTrials;

import java.util.ArrayList;

public class RunAllTrials  extends SimplePackageTrials 
implements I_MetaTrialParams<RunAllTrials>, I_CountingPackageTrials {
	
	static long start = System.currentTimeMillis();
	static I_Tests4J_Log logger = new DefaultLog();
	//private static volatile List<String> trialsNotCompleted = new CopyOnWriteArrayList<String>();
	//private static ExecutorService trialsNotCompletedService = Executors.newSingleThreadExecutor();
	private A_ModelsPkgTrials models = new A_ModelsPkgTrials();
	
	private A_SysPkgTrials sys = new A_SysPkgTrials();
	private A_SharePkgTrials share = new A_SharePkgTrials();
	
	private A_CocoApiPkgTrials cocoApi = new A_CocoApiPkgTrials();
	private A_CocoPlugPkgTrials cocoPlug = new A_CocoPlugPkgTrials();
	
	private A_RunPkgTrials run = new A_RunPkgTrials();
	
	private A_JavaVersionSpecificTrials jv = new A_JavaVersionSpecificTrials();
	
	private A_ApiPkgTrials api = new A_ApiPkgTrials();
	private A_MockitoTrials mock = new A_MockitoTrials();
	
	public static void main(String [] args) {
		try {
			Tests4J_Params params = new Tests4J_Params();
			params.setCoveragePluginFactoryClass(MockitoPluginFactory.class);
			params.setMetaTrialClass(TheMetaTrial.class);
			java.util.List<String> additionalNonResultPackages = new ArrayList<String>();
			additionalNonResultPackages.add("org.adligo.tests4j_tests.");
			params.setAdditionalNonResultPackages(additionalNonResultPackages);
			RunAllTrials me = new RunAllTrials();
			//params.setMetaTrialParams(me);
			
			params.setRecommendedSetupThreadCount(16);
			me.setParams(params);
			me.addTrials(params);
			
			params.addTrials(me);
			
			Tests4J_DefaultProgressParams dpm = new Tests4J_DefaultProgressParams();
			dpm.setNotificationInterval(500);
			params.setProgressMonitor(dpm);
		
			params.setLogState(TrialDisplay.class, false);
			params.setLogState(TestDisplay.class, false);
			//params.setLogState(ThreadDisplay.class, true);
			params.setLogState(SetupProcessDisplay.class, false);
			params.setLogState(SetupProgressDisplay.class, true);
			
			params.setLogState(TrialsProcessDisplay.class, false);
			params.setLogState(TrialsProgressDisplay.class, true);
			params.setLogState(Tests4J_Processor.class, true);
			//params.setLogState(Recorder.class, true);
			//params.setLogState(TrialInstrumenter.class, true);
			//params.setLogState(ClassAndDependenciesInstrumenter.class, true);
			//params.setLogState(TrialQueueDecisionTree.class, true);
			//params.setLogState(MultiProbeDataStore.class, true);
			
			//params.setLogState(ReferenceTrackingClassVisitor.class, true);
			//params.setLogState(ClassReferencesDiscovery.class, true);
			//params.setLogState(TrialInstrumenter2.class, true);
			//params.setLogState(ClassInstrumenter.class, true);
			//params.setLogState(ClassParentsDiscovery.class, true);
			//params.setLogState(TrialInstrumenter.class, true);
			
			
			//params.setThreadPoolSize(1);
			//params.setCoveragePlugin(new TieredJacocoPlugin());
			//
			 Tests4J.run(params, new Tests4J_XmlFileOutputListener());
			
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
	
		share.setParams(params);
		share.addTrials();
		add(share.getCountingTrials());
		
		models.setParams(params);
		models.addTrials();
		add(models.getCountingTrials());
		
		sys.setParams(params);
		sys.addTrials();
		add(sys.getCountingTrials());
		
		run.setParams(params);
		run.addTrials();
		add(run.getCountingTrials());
		
		api.setParams(params);
		api.addTrials();
		add(api.getCountingTrials());
		
		cocoPlug.setParams(params);
		cocoPlug.addTrials();
		add(cocoPlug.getCountingTrials());
			
		jv.setParams(params);
		jv.addTrials();
		add(jv.getCountingTrials());
		
		
		cocoApi.setParams(params);
		cocoApi.addTrials();
		add(cocoApi.getCountingTrials());
		
		mock.setParams(params);
		mock.addTrials();
		add(mock.getCountingTrials());
	}

	@Override
	public RunAllTrials getTrialParams() {
		return this;
	}


}
