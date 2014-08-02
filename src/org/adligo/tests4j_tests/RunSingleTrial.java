package org.adligo.tests4j_tests;

import org.adligo.tests4j.models.shared.system.Tests4J_Params;
import org.adligo.tests4j.run.Tests4J;
import org.adligo.tests4j.shared.report.summary.TestDisplay;
import org.adligo.tests4j.shared.report.summary.TrialDisplay;
import org.adligo.tests4j_4jacoco.plugin.Recorder;
import org.adligo.tests4j_4jacoco.plugin.ScopedJacocoPluginFactory;
import org.adligo.tests4j_tests.jacoco.plugin.discovery.ClassReferencesDiscoveryTrial;

public class RunSingleTrial {

	
	public static void main(String [] args) {
		Tests4J_Params params = new Tests4J_Params();
		//params.addTrial(DiffIndexesTrial.class);
		params.addTrial(ClassReferencesDiscoveryTrial.class);
	
		//params.setLogState(AbstractPlugin.class, true);
		//params.setLogState(Tests4J_NotificationManager.class, true);
		//params.setLogState(Tests4J_TrialsRunable.class, true);
		//params.setLogState(TrialInstrumenter.class, true);
		//params.addLoggingClass(TrialsProcessor.class);
		//params.addLoggingClass(Tests4J_Memory.class);
		//params.addLoggingClass(Tests4J_SecurityManager.class);
		params.setLogState(TrialDisplay.class, false);
		params.setLogState(TestDisplay.class, false);
		
		//logging from jacoco
		//params.addLoggingClass(AbstractPlugin.class);
		params.setLogState(Recorder.class, true);
		
		//SimpleJacocoPlugin plugin = new SimpleJacocoPlugin();
		params.setCoveragePluginFactoryClass(ScopedJacocoPluginFactory.class);
		//params.setCoveragePluginConfiguratorClass(RunSingleTrialPluginConfigurator.class);
		Tests4J.run(params);
	}

}

