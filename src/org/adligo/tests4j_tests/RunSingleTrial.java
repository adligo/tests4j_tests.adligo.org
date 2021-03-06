package org.adligo.tests4j_tests;

import org.adligo.tests4j.run.api.Tests4J;
import org.adligo.tests4j.system.shared.api.Tests4J_Params;
import org.adligo.tests4j_4jacoco.plugin.factories.MockitoPluginFactory;
import org.adligo.tests4j_tests.shared.asserts.ThrownAssertCommandTrial;
import org.adligo.tests4j_tests.shared.i18n.I_Tests4J_ConstantsTrial;

public class RunSingleTrial {
	
	public static void main(String [] args) {
		try {
			Tests4J_Params params = new Tests4J_Params();
			params.setCoveragePluginFactoryClass(MockitoPluginFactory.class);
			
			params.addTrial(I_Tests4J_ConstantsTrial.class);
			//params.setLogState(Tests4J_TrialsRunable.class, true);
			//params.setLogState(MultiProbesMap.class, true);
			//params.setLogState(InitialDependenciesDiscovery.class, true);
			//params.setLogState(TrialInstrumenter.class, true);
			
			Tests4J.run(params);
		} catch (Exception x) {
			x.printStackTrace();
		}
	}


}

