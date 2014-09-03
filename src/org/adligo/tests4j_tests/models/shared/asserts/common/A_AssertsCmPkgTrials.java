package org.adligo.tests4j_tests.models.shared.asserts.common;

import org.adligo.tests4j.models.shared.system.Tests4J_Params;
import org.adligo.tests4j.models.shared.trials.I_TrialParams;
import org.adligo.tests4j.run.Tests4J;
import org.adligo.tests4j_4jacoco.plugin.CoveragePluginFactory;
import org.adligo.tests4j_tests.base_trials.I_CountingPackageTrials;
import org.adligo.tests4j_tests.base_trials.SimpleMetaTrial;
import org.adligo.tests4j_tests.base_trials.SimplePackageTrials;

public class A_AssertsCmPkgTrials extends SimplePackageTrials 
	implements I_TrialParams<A_AssertsCmPkgTrials>, I_CountingPackageTrials {

	
	public static void main(String [] args) {
		try {
			Tests4J_Params params = new Tests4J_Params();
			params.setCoveragePluginFactoryClass(CoveragePluginFactory.class);
			params.setMetaTrialClass(SimpleMetaTrial.class);
			
			A_AssertsCmPkgTrials me = new A_AssertsCmPkgTrials();
			me.setParams(params);
			me.addTrials();
			params.setMetaTrialParams(me);
			params.addTrials(me);
			params.setRecommendedSetupThreadCount(1);
			
			
			//params.setCoveragePluginConfiguratorClass(ScopedJacocoPluginConfigurator.class);
			Tests4J.run(params);
		} catch (Exception x) {
			x.printStackTrace();
		}
	}

	public void addTrials() throws Exception {
		add(AssertTypeTrial.class);
		add(CompareAssertionDataTrial.class);
		add(ExpectedThrownDataTrial.class);
		add(ThrownAssertionDataMutantTrial.class);
		add(ThrownAssertionDataTrial.class);
		
	}

	@Override
	public A_AssertsCmPkgTrials getTrialParams() {
		return this;
	}
	
}
