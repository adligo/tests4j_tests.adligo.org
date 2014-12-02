package org.adligo.tests4j_tests;

import org.adligo.tests4j.run.api.Tests4J;
import org.adligo.tests4j.system.shared.api.Tests4J_Params;
import org.adligo.tests4j_4jacoco.plugin.factories.MockitoPluginFactory;
import org.adligo.tests4j_tests.trials_api.bad_mock_use_case_trials.BeforeTrialHasParamsTrial;

public class RunSingleTrial {
	
	public static void main(String [] args) {
		try {
			Tests4J_Params params = new Tests4J_Params();
			params.setCoveragePluginFactoryClass(MockitoPluginFactory.class);
			
			params.addTrial(BeforeTrialHasParamsTrial.class);
		
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

