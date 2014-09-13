package org.adligo.tests4j_tests.trials_api;

import org.adligo.tests4j.models.shared.system.Tests4J_Params;
import org.adligo.tests4j.models.shared.trials.I_MetaTrialParams;
import org.adligo.tests4j.run.Tests4J;
import org.adligo.tests4j_4jacoco.plugin.CoveragePluginFactory;
import org.adligo.tests4j_tests.base_trials.I_CountingPackageTrials;
import org.adligo.tests4j_tests.base_trials.SimpleMetaTrial;
import org.adligo.tests4j_tests.base_trials.SimplePackageTrials;

public class A_ApiPkgTrials extends SimplePackageTrials 
implements I_MetaTrialParams<A_ApiPkgTrials>, I_CountingPackageTrials {

	
	public static void main(String [] args) {
		try {
			Tests4J_Params params = new Tests4J_Params();
			params.setCoveragePluginFactoryClass(CoveragePluginFactory.class);
			params.setMetaTrialClass(SimpleMetaTrial.class);
			
			
			A_ApiPkgTrials me = new A_ApiPkgTrials();
			me.setParams(params);
			me.addTrials();
			params.addTrials(me);
			params.setMetaTrialParams(me);
			
			//TieredJacocoPlugin covargePlugin =new TieredJacocoPlugin();
			
			Tests4J.run(params);
		} catch (Exception x) {
			x.printStackTrace();
		}
	}


	public void addTrials() throws Exception {
		add(AssertionsFail_Trial.class);
		
		add(AssertionsPass_Trial.class);
		add(AssertionsWithNullExpectedFail_Trial.class);
		add(BadUseCaseTrials_Trial.class);
		add(BadSourceFileTrials_Trial.class);
		add(BadApiTrials_Trial.class);
		
	}


	@Override
	public A_ApiPkgTrials getTrialParams() {
		return this;
	}

}
