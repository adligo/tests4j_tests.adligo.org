package org.adligo.tests4j_tests;

import org.adligo.tests4j.models.shared.system.Tests4J_Params;
import org.adligo.tests4j.run.Tests4J;
import org.adligo.tests4j_4jacoco.plugin.TieredJacocoPlugin;
import org.adligo.tests4j_tests.api_trials.Run_ApiTrial_Trial;

public class RunSingleTrial {

	
	public static void main(String [] args) {
		Tests4J_Params params = new Tests4J_Params();
		params.addTrial(Run_ApiTrial_Trial.class);
		params.setCheckMins(false);
		//params.setCoveragePlugin(new SimpleJacocoPlugin());
		params.setCoveragePlugin(new TieredJacocoPlugin());
		Tests4J.run(params);
	}

}
