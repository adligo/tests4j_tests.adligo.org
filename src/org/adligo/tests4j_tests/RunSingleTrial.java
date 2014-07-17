package org.adligo.tests4j_tests;

import org.adligo.tests4j.models.shared.system.Tests4J_Params;
import org.adligo.tests4j.run.Tests4J;
import org.adligo.tests4j.run.helpers.Tests4J_NotificationManager;
import org.adligo.tests4j.run.helpers.TrialInstancesProcessor;
import org.adligo.tests4j.shared.report.summary.SummaryReporter;
import org.adligo.tests4j_4jacoco.plugin.AbstractPlugin;
import org.adligo.tests4j_4jacoco.plugin.Recorder;
import org.adligo.tests4j_4jacoco.plugin.ScopedJacocoPluginFactory;
import org.adligo.tests4j_tests.trials_api.AssertionsFail_Trial;

public class RunSingleTrial {

	
	public static void main(String [] args) {
		Tests4J_Params params = new Tests4J_Params();
		params.addTrial(AssertionsFail_Trial.class);
		/*
		params.addTest(Run_UseCaseTrial_ApiTrial.class.getName() +
				".testNoUseCaseAnnotation");
				*/
		//params.addTrial(Tests4J_ParamsTrial.class);
		SummaryReporter reporter = new SummaryReporter();
		
		params.addLoggingClass(AbstractPlugin.class);
		params.addLoggingClass(Tests4J_NotificationManager.class);
		params.addLoggingClass(TrialInstancesProcessor.class);
		//params.addLoggingClass(TrialsProcessor.class);
		//params.addLoggingClass(Tests4J_Memory.class);
		//params.addLoggingClass(Tests4J_SecurityManager.class);
		
		//logging from jacoco
		//params.addLoggingClass(AbstractPlugin.class);
		params.addLoggingClass(Recorder.class);
		
		params.setReporter(reporter);
		//SimpleJacocoPlugin plugin = new SimpleJacocoPlugin();
		params.setCoveragePluginFactoryClass(ScopedJacocoPluginFactory.class);
		//params.setCoveragePluginConfiguratorClass(RunSingleTrialPluginConfigurator.class);
		Tests4J.run(params);
	}

}

