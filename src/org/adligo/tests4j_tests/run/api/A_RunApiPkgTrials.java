package org.adligo.tests4j_tests.run.api;

import org.adligo.tests4j.run.api.Tests4J;
import org.adligo.tests4j.system.shared.api.Tests4J_Params;
import org.adligo.tests4j.system.shared.trials.I_MetaTrialParams;
import org.adligo.tests4j_4jacoco.plugin.factories.MockitoPluginFactory;
import org.adligo.tests4j_tests.base_trials.I_CountingPackageTrials;
import org.adligo.tests4j_tests.base_trials.SimpleMetaTrial;
import org.adligo.tests4j_tests.base_trials.SimplePackageTrials;
import org.adligo.tests4j_tests.run.discovery.A_RunDiscPkgTrials;
import org.adligo.tests4j_tests.run.helpers.A_RunHelpPkgTrials;
import org.adligo.tests4j_tests.run.io.A_RemoIoPkgTrials;
import org.adligo.tests4j_tests.run.remote.socket_api.A_SocApiPkgTrials;

public class A_RunApiPkgTrials extends SimplePackageTrials 
implements I_MetaTrialParams<A_RunApiPkgTrials>, I_CountingPackageTrials {
	
	public static void main(String [] args) {
		try {
			Tests4J_Params params = new Tests4J_Params();
			params.setCoveragePluginFactoryClass(MockitoPluginFactory.class);
			params.setMetaTrialClass(SimpleMetaTrial.class);
			

			
			A_RunApiPkgTrials me = new A_RunApiPkgTrials();
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
		add(Tests4JTrial.class);
		add(Tests4J_UncaughtExceptionHandlerTrial.class);
		
	}

	@Override
	public A_RunApiPkgTrials getTrialParams() {
		return this;
	}

	@Override
	public void setParams(Tests4J_Params params) {
		super.setParams(params);
	}
}
