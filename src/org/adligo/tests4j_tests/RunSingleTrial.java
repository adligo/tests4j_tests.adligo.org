package org.adligo.tests4j_tests;

import org.adligo.tests4j.models.shared.system.I_CoveragePlugin;
import org.adligo.tests4j.models.shared.system.I_CoveragePluginConfigurator;
import org.adligo.tests4j.models.shared.system.Tests4J_Params;
import org.adligo.tests4j.models.shared.system.report.ConsoleReporter;
import org.adligo.tests4j.run.Tests4J;
import org.adligo.tests4j.run.helpers.Tests4J_Memory;
import org.adligo.tests4j.run.helpers.Tests4J_NotificationManager;
import org.adligo.tests4j.run.helpers.Tests4J_SecurityManager;
import org.adligo.tests4j.run.helpers.TrialInstancesProcessor;
import org.adligo.tests4j.run.helpers.TrialsProcessor;
import org.adligo.tests4j_4jacoco.plugin.Recorder;
import org.adligo.tests4j_4jacoco.plugin.ScopedJacocoPlugin;
import org.adligo.tests4j_tests.run.remote.nio.UTF8_CharacterReaderWithThreadsTrial;

public class RunSingleTrial {

	
	public static void main(String [] args) {
		Tests4J_Params params = new Tests4J_Params();
		params.addTrial(UTF8_CharacterReaderWithThreadsTrial.class);
		/*
		params.addTest(Run_UseCaseTrial_ApiTrial.class.getName() +
				".testNoUseCaseAnnotation");
				*/
		//params.addTrial(Tests4J_ParamsTrial.class);
		ConsoleReporter reporter = new ConsoleReporter();
		
		params.addLoggingClass(Tests4J_NotificationManager.class);
		params.addLoggingClass(TrialInstancesProcessor.class);
		params.addLoggingClass(TrialsProcessor.class);
		params.addLoggingClass(Tests4J_Memory.class);
		params.addLoggingClass(Tests4J_SecurityManager.class);
		
		//logging from jacoco
		//params.addLoggingClass(AbstractPlugin.class);
		params.addLoggingClass(Recorder.class);
		
		params.setReporter(reporter);
		//SimpleJacocoPlugin plugin = new SimpleJacocoPlugin();
		//params.setCoveragePluginClass(ScopedJacocoPlugin.class);
		params.setCoveragePluginConfiguratorClass(RunSingleTrialPluginConfigurator.class);
		Tests4J.run(params);
	}

}

class RunSingleTrialPluginConfigurator implements I_CoveragePluginConfigurator {

	@Override
	public void configure(I_CoveragePlugin p) {
		ScopedJacocoPlugin plugin = (ScopedJacocoPlugin) p;
		plugin.setWriteOutInstrumentedClassFiles(true);
		
	}
	
}
