package org.adligo.tests4j_v1_tests.models.shared.dependency_groups.jse.v1_7;

import org.adligo.tests4j.models.shared.trials.I_MetaTrialParams;
import org.adligo.tests4j.run.Tests4J;
import org.adligo.tests4j.system.shared.Tests4J_Params;
import org.adligo.tests4j_4jacoco.plugin.CoveragePluginFactory;
import org.adligo.tests4j_tests.base_trials.I_CountingPackageTrials;
import org.adligo.tests4j_tests.base_trials.SimpleMetaTrial;
import org.adligo.tests4j_tests.base_trials.SimplePackageTrials;
import org.adligo.tests4j_v1_tests.models.shared.dependency_groups.jse.v1_6.I_JSE_1_6_LangTrial;
import org.adligo.tests4j_v1_tests.models.shared.dependency_groups.jse.v1_7.I_JSE_1_7_IOTrial;
import org.adligo.tests4j_v1_tests.models.shared.dependency_groups.jse.v1_7.I_JSE_1_7_LangAnnotTrial;
import org.adligo.tests4j_v1_tests.models.shared.dependency_groups.jse.v1_7.I_JSE_1_7_LangTrial;
import org.adligo.tests4j_v1_tests.models.shared.dependency_groups.jse.v1_7.I_JSE_1_7_LogTrial;
import org.adligo.tests4j_v1_tests.models.shared.dependency_groups.jse.v1_7.I_JSE_1_7_MathTrial;
import org.adligo.tests4j_v1_tests.models.shared.dependency_groups.jse.v1_7.I_JSE_1_7_SqlTrial;
import org.adligo.tests4j_v1_tests.models.shared.dependency_groups.jse.v1_7.I_JSE_1_7_UtilTrial;

public class A_DGroups_JSE_1_7_PkgTrials extends SimplePackageTrials 
implements I_MetaTrialParams<A_DGroups_JSE_1_7_PkgTrials>, I_CountingPackageTrials {

	
	public static void main(String [] args) {
		try {
			Tests4J_Params params = new Tests4J_Params();
			params.setCoveragePluginFactoryClass(CoveragePluginFactory.class);
			params.setMetaTrialClass(SimpleMetaTrial.class);
			
			
			A_DGroups_JSE_1_7_PkgTrials me = new A_DGroups_JSE_1_7_PkgTrials();
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
		add(I_JSE_1_7_IOTrial.class);
		add(I_JSE_1_7_LangAnnotTrial.class);
		add(I_JSE_1_7_LangTrial.class);
		add(I_JSE_1_7_LogTrial.class);
		
		add(I_JSE_1_7_MathTrial.class);
		add(I_JSE_1_7_SqlTrial.class);
		add(I_JSE_1_7_UtilTrial.class);
	}

	@Override
	public A_DGroups_JSE_1_7_PkgTrials getTrialParams() {
		return this;
	}
}
