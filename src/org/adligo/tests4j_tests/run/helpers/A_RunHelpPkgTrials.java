package org.adligo.tests4j_tests.run.helpers;

import org.adligo.tests4j.run.api.Tests4J;
import org.adligo.tests4j.run.helpers.ClassFilterMutant;
import org.adligo.tests4j.system.shared.api.Tests4J_Params;
import org.adligo.tests4j.system.shared.trials.I_MetaTrialParams;
import org.adligo.tests4j_4jacoco.plugin.factories.MockitoPluginFactory;
import org.adligo.tests4j_tests.base_trials.I_CountingPackageTrials;
import org.adligo.tests4j_tests.base_trials.SimpleMetaTrial;
import org.adligo.tests4j_tests.base_trials.SimplePackageTrials;

public class A_RunHelpPkgTrials extends SimplePackageTrials 
implements I_MetaTrialParams<A_RunHelpPkgTrials>, I_CountingPackageTrials {

	
	public static void main(String [] args) {
		try {
			Tests4J_Params params = new Tests4J_Params();
			params.setCoveragePluginFactoryClass(MockitoPluginFactory.class);
			params.setMetaTrialClass(SimpleMetaTrial.class);
			
			
			A_RunHelpPkgTrials me = new A_RunHelpPkgTrials();
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
		add(CachedClassBytesClassLoaderTrial.class);
		add(ClassFilterMutantTrial.class);
	}

	@Override
	public A_RunHelpPkgTrials getTrialParams() {
		return this;
	}
}
