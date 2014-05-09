package org.adligo.tests4j_tests;

import org.adligo.tests4j.models.shared.system.Tests4J_Params;
import org.adligo.tests4j.run.Tests4J;
import org.adligo.tests4j_4jacoco.plugin.OldScopedJacocoPlugin;

public class RunAllTrials {

	
	public static void main(String [] args) {

		Tests4J_Params params = getTests();
		params.setCheckMins(false);
		//params.setLog(new ConsoleLogger(false));
		OldScopedJacocoPlugin plugin = new OldScopedJacocoPlugin();
		params.setCoveragePlugin(plugin);
		//params.setThreadPoolSize(1);
		//params.setCoveragePlugin(new TieredJacocoPlugin());
		Tests4J.run(params);
		
	}

	private static Tests4J_Params getTests() {
		Tests4J_Params toRet = new Tests4J_Params();
		
		toRet.addTrials(new org.adligo.tests4j_tests.models.shared.system.RunPkgTrials());
		toRet.addTrials(new org.adligo.tests4j_tests.api_trials.RunPkgTrials());
		toRet.addTrials(new org.adligo.tests4j_tests.jacoco.api_trials.RunPkgTrials());
		toRet.addTrials(new org.adligo.tests4j_tests.jacoco.plugin.instrumentation.RunPkgTrials());
		return toRet;
	}


}
