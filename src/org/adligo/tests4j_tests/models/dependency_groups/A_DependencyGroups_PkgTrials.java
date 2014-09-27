package org.adligo.tests4j_tests.models.dependency_groups;

import org.adligo.tests4j.models.shared.trials.I_MetaTrialParams;
import org.adligo.tests4j.run.Tests4J;
import org.adligo.tests4j.system.shared.Tests4J_Params;
import org.adligo.tests4j_4jacoco.plugin.CoveragePluginFactory;
import org.adligo.tests4j_tests.base_trials.I_CountingPackageTrials;
import org.adligo.tests4j_tests.base_trials.SimpleMetaTrial;
import org.adligo.tests4j_tests.base_trials.SimplePackageTrials;

public class A_DependencyGroups_PkgTrials extends SimplePackageTrials 
	implements I_MetaTrialParams<A_DependencyGroups_PkgTrials>, I_CountingPackageTrials {

	
	public static void main(String [] args) {
		try {
			Tests4J_Params params = new Tests4J_Params();
			params.setCoveragePluginFactoryClass(CoveragePluginFactory.class);
			params.setMetaTrialClass(SimpleMetaTrial.class);
			
			A_DependencyGroups_PkgTrials me = new A_DependencyGroups_PkgTrials();
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
		add(AdligoGWT_DependencyGroupTrial.class);
		
	}

	@Override
	public A_DependencyGroups_PkgTrials getTrialParams() {
		return this;
	}
	
}
