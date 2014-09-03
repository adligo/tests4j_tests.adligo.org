package org.adligo.tests4j_tests.models.shared.dependency_groups.jse;

import org.adligo.tests4j.models.shared.system.Tests4J_Params;
import org.adligo.tests4j.models.shared.trials.I_TrialParams;
import org.adligo.tests4j.run.Tests4J;
import org.adligo.tests4j_4jacoco.plugin.CoveragePluginFactory;
import org.adligo.tests4j_tests.base_trials.I_CountingPackageTrials;
import org.adligo.tests4j_tests.base_trials.SimpleMetaTrial;
import org.adligo.tests4j_tests.base_trials.SimplePackageTrials;

public class A_DGroups_JSE_1_8_PkgTrials extends SimplePackageTrials 
implements I_TrialParams<A_DGroups_JSE_1_8_PkgTrials>, I_CountingPackageTrials {

	
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
		add(JSE_1_6_LangTrial.class);
		
		add(JSE_1_7_IOTrial.class);
		add(JSE_1_7_LangAnnotTrial.class);
		add(JSE_1_7_LangTrial.class);
		add(JSE_1_7_LogTrial.class);
		
		add(JSE_1_7_MathTrial.class);
		add(JSE_1_7_SqlTrial.class);
		add(JSE_1_7_UtilTrial.class);
		
		add(JSE_1_8_LangTrial.class);
		
		add(JSE_IOTrial.class);
		add(JSE_LangAnnotTrial.class);
		add(JSE_LangTrial.class);
		add(JSE_LogTrial.class);
		
		add(JSE_MathTrial.class);
		add(JSE_SqlTrial.class);
		add(JSE_UtilTrial.class);
		
	}

	@Override
	public A_DGroups_JSE_1_8_PkgTrials getTrialParams() {
		return this;
	}
}
