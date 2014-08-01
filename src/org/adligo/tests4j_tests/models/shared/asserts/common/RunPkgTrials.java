package org.adligo.tests4j_tests.models.shared.asserts.common;

import java.util.ArrayList;
import java.util.List;

import org.adligo.tests4j.models.shared.system.I_Tests4J_TrialList;
import org.adligo.tests4j.models.shared.system.Tests4J_Params;
import org.adligo.tests4j.models.shared.trials.I_Trial;
import org.adligo.tests4j.run.Tests4J;
import org.adligo.tests4j_4jacoco.plugin.ScopedJacocoPluginFactory;
import org.adligo.tests4j_4jacoco.plugin.TrialInstrumenter;
import org.adligo.tests4j_4jacoco.plugin.discovery.ClassDependenciesDiscovery;

public class RunPkgTrials implements I_Tests4J_TrialList {

	
	public static void main(String [] args) {
		Tests4J_Params params = new Tests4J_Params();
		params.addTrials(new RunPkgTrials());
		
		params.setLogState(TrialInstrumenter.class, true);
		params.setLogState(ClassDependenciesDiscovery.class, true);
		
		//params.setCoveragePluginFactoryClass(SimpleJacocoPluginFactory.class);
		params.setCoveragePluginFactoryClass(ScopedJacocoPluginFactory.class);
		//params.setCoveragePluginConfiguratorClass(ScopedJacocoPluginConfigurator.class);
		Tests4J.run(params);
	}

	@Override
	public List<Class<? extends I_Trial>> getTrials() {
		List<Class<? extends I_Trial>> trials = new ArrayList<Class<? extends I_Trial>>();
		
		trials.add(AssertTypeTrial.class);
		
		return trials;
	}
}
