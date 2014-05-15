package org.adligo.tests4j_tests;

import org.adligo.tests4j.models.shared.system.Tests4J_Params;
import org.adligo.tests4j.models.shared.system.report.ConsoleReporter;
import org.adligo.tests4j.run.Tests4J;
import org.adligo.tests4j.run.helpers.Tests4J_NotificationManager;
import org.adligo.tests4j.run.helpers.TrialInstancesProcessor;
import org.adligo.tests4j_4jacoco.plugin.Recorder;
import org.adligo.tests4j_4jacoco.plugin.ScopedJacocoPlugin;
import org.adligo.tests4j_tests.models.shared.system.ByteListOutputStreamTrial;

public class RunSingleTrial {

	
	public static void main(String [] args) {
		Tests4J_Params params = new Tests4J_Params();
		params.addTrial(ByteListOutputStreamTrial.class);
		//params.addTrial(Tests4J_ParamsTrial.class);
		//params.addTrial(ByteListOutputStreamTrial.class);
		ConsoleReporter reporter = new ConsoleReporter();
		
		reporter.setLogOn(Tests4J_NotificationManager.class);
		reporter.setLogOn(TrialInstancesProcessor.class);
		//reporter.setLogOn(Tests4J_Memory.class);
		
		//logging from jacoco
		//reporter.setLogOn(AbstractPlugin.class);
		reporter.setLogOn(Recorder.class);
		
		params.setReporter(reporter);
		//SimpleJacocoPlugin plugin = new SimpleJacocoPlugin();
		ScopedJacocoPlugin plugin = new ScopedJacocoPlugin();
		params.setCoveragePlugin(plugin);
		Tests4J.run(params);
	}

}
