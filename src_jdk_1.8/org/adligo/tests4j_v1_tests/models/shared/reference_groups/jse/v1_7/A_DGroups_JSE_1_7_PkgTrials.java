package org.adligo.tests4j_v1_tests.models.shared.reference_groups.jse.v1_7;

import org.adligo.tests4j.run.api.Tests4J;
import org.adligo.tests4j.system.shared.api.Tests4J_Params;
import org.adligo.tests4j.system.shared.trials.I_MetaTrialParams;
import org.adligo.tests4j_4jacoco.plugin.factories.MockitoPluginFactory;
import org.adligo.tests4j_tests.base_trials.I_CountingPackageTrials;
import org.adligo.tests4j_tests.base_trials.SimpleMetaTrial;
import org.adligo.tests4j_tests.base_trials.SimplePackageTrials;

public class A_DGroups_JSE_1_7_PkgTrials extends SimplePackageTrials 
implements I_MetaTrialParams<A_DGroups_JSE_1_7_PkgTrials>, I_CountingPackageTrials {

	
	public static void main(String [] args) {
		try {
			Tests4J_Params params = new Tests4J_Params();
			params.setCoveragePluginFactoryClass(MockitoPluginFactory.class);
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
		add(I_JSE_1_7_NIOTrial.class);
		add(I_JSE_1_7_NIOFileTrial.class);
		
		add(I_JSE_1_7_SqlTrial.class);
		add(I_JSE_1_7_UtilTrial.class);
		add(I_JSE_1_7_UtilConcurrentTrial.class);
		add(I_JSE_1_7_XmlSaxTrial.class);
		add(I_JSE_1_7_XmlSaxExtTrial.class);
	}

	@Override
	public A_DGroups_JSE_1_7_PkgTrials getTrialParams() {
		return this;
	}
}
