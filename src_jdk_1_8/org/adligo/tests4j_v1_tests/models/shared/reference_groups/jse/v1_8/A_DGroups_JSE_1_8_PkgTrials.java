package org.adligo.tests4j_v1_tests.models.shared.reference_groups.jse.v1_8;

import org.adligo.tests4j.run.api.Tests4J;
import org.adligo.tests4j.system.shared.api.Tests4J_Params;
import org.adligo.tests4j.system.shared.trials.I_MetaTrialParams;
import org.adligo.tests4j_4jacoco.plugin.CoveragePluginFactory;
import org.adligo.tests4j_tests.base_trials.I_CountingPackageTrials;
import org.adligo.tests4j_tests.base_trials.SimpleMetaTrial;
import org.adligo.tests4j_tests.base_trials.SimplePackageTrials;

public class A_DGroups_JSE_1_8_PkgTrials extends SimplePackageTrials 
implements I_MetaTrialParams<A_DGroups_JSE_1_8_PkgTrials>, I_CountingPackageTrials {

	
	public static void main(String [] args) {
		try {
			Tests4J_Params params = new Tests4J_Params();
			params.setCoveragePluginFactoryClass(CoveragePluginFactory.class);
			params.setMetaTrialClass(SimpleMetaTrial.class);
			
			
			A_DGroups_JSE_1_8_PkgTrials me = new A_DGroups_JSE_1_8_PkgTrials();
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
		add(I_JSE_1_8_LangTrial.class);
		add(I_JSE_1_8_LangAnnotTrial.class);
		add(I_JSE_1_8_UtilTrial.class);
		add(I_JSE_1_8_MathTrial.class);
		add(I_JSE_1_8_LogTrial.class);
		add(I_JSE_1_8_IOTrial.class);
		add(I_JSE_1_8_SqlTrial.class);
	}

	@Override
	public A_DGroups_JSE_1_8_PkgTrials getTrialParams() {
		return this;
	}
}
