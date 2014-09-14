package org.adligo.tests4j_v1_tests.models.shared.dependency_groups.jse.v1_6;

import org.adligo.tests4j.models.shared.system.Tests4J_Params;
import org.adligo.tests4j.models.shared.trials.I_MetaTrialParams;
import org.adligo.tests4j.run.Tests4J;
import org.adligo.tests4j_4jacoco.plugin.CoveragePluginFactory;
import org.adligo.tests4j_tests.base_trials.I_CountingPackageTrials;
import org.adligo.tests4j_tests.base_trials.SimpleMetaTrial;
import org.adligo.tests4j_tests.base_trials.SimplePackageTrials;
import org.adligo.tests4j_v1_tests.models.shared.dependency_groups.jse.v1_6.JSE_1_6_LangTrial;

public class A_DGroups_JSE_1_6_PkgTrials extends SimplePackageTrials 
implements I_MetaTrialParams<A_DGroups_JSE_1_6_PkgTrials>, I_CountingPackageTrials {

	
	public static void main(String [] args) {
		try {
			Tests4J_Params params = new Tests4J_Params();
			params.setCoveragePluginFactoryClass(CoveragePluginFactory.class);
			params.setMetaTrialClass(SimpleMetaTrial.class);
			
			
			A_DGroups_JSE_1_6_PkgTrials me = new A_DGroups_JSE_1_6_PkgTrials();
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
		add(JSE_1_6_LangTrial.class);
	}

	@Override
	public A_DGroups_JSE_1_6_PkgTrials getTrialParams() {
		return this;
	}
}
