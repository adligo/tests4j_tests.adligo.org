package org.adligo.tests4j_tests;

import org.adligo.tests4j.models.shared.system.Tests4J_Params;
import org.adligo.tests4j.models.shared.system.report.ConsoleReporter;
import org.adligo.tests4j.run.Tests4J;
import org.adligo.tests4j.run.helpers.TrialDescription;
import org.adligo.tests4j_4jacoco.plugin.ScopedJacocoPlugin;
import org.adligo.tests4j_tests.api_trials.Run_UseCaseTrial_Trial;

public class RunSingleTrial {

	
	public static void main(String [] args) {
		Tests4J_Params params = new Tests4J_Params();
		params.addTrial(Run_UseCaseTrial_Trial.class);
		//params.addTrial(Tests4J_ParamsTrial.class);
		params.setCheckMins(false);
		ConsoleReporter reporter = new ConsoleReporter();
		//reporter.setLogOn(TrialDescription.class.getName());
		params.setReporter(reporter);
		//SimpleJacocoPlugin plugin = new SimpleJacocoPlugin();
		ScopedJacocoPlugin plugin = new ScopedJacocoPlugin();
		params.setCoveragePlugin(plugin);
		Tests4J.run(params);
	}

}
