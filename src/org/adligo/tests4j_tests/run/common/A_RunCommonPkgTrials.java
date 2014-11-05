package org.adligo.tests4j_tests.run.common;

import org.adligo.tests4j.run.api.Tests4J;
import org.adligo.tests4j.system.shared.api.Tests4J_Params;
import org.adligo.tests4j.system.shared.trials.I_MetaTrialParams;
import org.adligo.tests4j_4jacoco.plugin.CoveragePluginFactory;
import org.adligo.tests4j_tests.base_trials.I_CountingPackageTrials;
import org.adligo.tests4j_tests.base_trials.SimpleMetaTrial;
import org.adligo.tests4j_tests.base_trials.SimplePackageTrials;

public class A_RunCommonPkgTrials extends SimplePackageTrials 
implements I_MetaTrialParams<A_RunCommonPkgTrials>, I_CountingPackageTrials {
	
	public static void main(String [] args) {
		try {
			Tests4J_Params params = new Tests4J_Params();
			params.setCoveragePluginFactoryClass(CoveragePluginFactory.class);
			params.setMetaTrialClass(SimpleMetaTrial.class);
			

			
			A_RunCommonPkgTrials me = new A_RunCommonPkgTrials();
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

	public void addTrials()  throws Exception {
	  add(I_NotifierTrial.class);
	  add(I_MemoryTrial.class);
	  add(I_RemoteRunnerTrial.class);
	  add(I_RemoteRunnerFactoryTrial.class);
	  add(I_ThreadManagerTrial.class);
	  add(I_ThreadsTrial.class);
	  
	  add(NotifierDelegateTrial.class);
	  add(ThreadsDelegateTrial.class);
	}

	@Override
	public A_RunCommonPkgTrials getTrialParams() {
		return this;
	}

	@Override
	public void setParams(Tests4J_Params params) {
		super.setParams(params);
	}
}
