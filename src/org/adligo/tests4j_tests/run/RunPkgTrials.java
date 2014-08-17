package org.adligo.tests4j_tests.run;

import java.util.ArrayList;
import java.util.List;

import org.adligo.tests4j.models.shared.system.I_Tests4J_TrialList;
import org.adligo.tests4j.models.shared.system.Tests4J_Params;
import org.adligo.tests4j.models.shared.trials.I_Trial;
import org.adligo.tests4j.run.Tests4J;
import org.adligo.tests4j_4jacoco.plugin.CoveragePluginFactory;

public class RunPkgTrials implements I_Tests4J_TrialList {

	
	public static void main(String [] args) {
		Tests4J_Params params = new Tests4J_Params();
		params.addTrials(new RunPkgTrials());
		
		
		//TieredJacocoPlugin covargePlugin =new TieredJacocoPlugin();
		//params.setCoveragePluginFactoryClass(ScopedJacocoPluginFactory.class);
		
		Tests4J.run(params);
	}

	@Override
	public List<Class<? extends I_Trial>> getTrials() {
		List<Class<? extends I_Trial>> trials = new ArrayList<Class<? extends I_Trial>>();
		
		trials.add(Tests4JTrial.class);
		trials.add(Tests4J_UncaughtExceptionHandlerTrial.class);
		trials.addAll(new org.adligo.tests4j_tests.run.discovery.RunPkgTrials().getTrials());
		trials.addAll(new org.adligo.tests4j_tests.run.helpers.RunPkgTrials().getTrials());
		trials.addAll(new org.adligo.tests4j_tests.run.remote.io.RunPkgTrials().getTrials());
		trials.addAll(new org.adligo.tests4j_tests.run.remote.socket_api.RunPkgTrials().getTrials());
		
		return trials;
	}
}
