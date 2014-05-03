package org.adligo.tests4j_tests;

import org.adligo.tests4j.models.shared.system.Tests4J_Params;
import org.adligo.tests4j.models.shared.system.report.ConsoleReporter;
import org.adligo.tests4j.run.Tests4J;
import org.adligo.tests4j.run.helpers.Tests4J_Memory;
import org.adligo.tests4j.run.helpers.Tests4J_NotificationManager;
import org.adligo.tests4j.run.helpers.TrialInstancesProcessor;
import org.adligo.tests4j_4jacoco.plugin.AbstractPlugin;
import org.adligo.tests4j_4jacoco.plugin.OldScopedJacocoPlugin;
import org.adligo.tests4j_4jacoco.plugin.Recorder;
import org.adligo.tests4j_tests.api_trials.Run_UseCaseTrial_ApiTrial;

public class RunSingleTrial {

	
	public static void main(String [] args) {
		Tests4J_Params params = new Tests4J_Params();
		params.addTrial(Run_UseCaseTrial_ApiTrial.class);
		//params.addTrial(Tests4J_ParamsTrial.class);
		//params.addTrial(ByteListOutputStreamTrial.class);
		params.setCheckMins(false);
		ConsoleReporter reporter = new ConsoleReporter();
		reporter.setLogOn(Recorder.class);
		reporter.setLogOn(Tests4J_NotificationManager.class);
		reporter.setLogOn(TrialInstancesProcessor.class);
		reporter.setLogOn(Tests4J_Memory.class);
		reporter.setLogOn(AbstractPlugin.class);
		
		params.setReporter(reporter);
		//SimpleJacocoPlugin plugin = new SimpleJacocoPlugin();
		OldScopedJacocoPlugin plugin = new OldScopedJacocoPlugin();
		params.setCoveragePlugin(plugin);
		Tests4J.run(params);
	}

}
