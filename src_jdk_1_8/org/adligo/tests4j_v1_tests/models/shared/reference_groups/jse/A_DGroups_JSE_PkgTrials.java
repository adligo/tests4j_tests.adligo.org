package org.adligo.tests4j_v1_tests.models.shared.reference_groups.jse;

import org.adligo.tests4j.run.api.Tests4J;
import org.adligo.tests4j.system.shared.api.Tests4J_Params;
import org.adligo.tests4j.system.shared.trials.I_MetaTrialParams;
import org.adligo.tests4j_4jacoco.plugin.CoveragePluginFactory;
import org.adligo.tests4j_tests.base_trials.I_CountingPackageTrials;
import org.adligo.tests4j_tests.base_trials.SimpleMetaTrial;
import org.adligo.tests4j_tests.base_trials.SimplePackageTrials;
import org.adligo.tests4j_tests.models.shared.association.I_PackageConstantLookupTrial;
import org.adligo.tests4j_v1_tests.models.shared.reference_groups.jse.v1_6.A_DGroups_JSE_1_6_PkgTrials;
import org.adligo.tests4j_v1_tests.models.shared.reference_groups.jse.v1_7.A_DGroups_JSE_1_7_PkgTrials;
import org.adligo.tests4j_v1_tests.models.shared.reference_groups.jse.v1_8.A_DGroups_JSE_1_8_PkgTrials;

public class A_DGroups_JSE_PkgTrials extends SimplePackageTrials 
implements I_MetaTrialParams<A_DGroups_JSE_PkgTrials>, I_CountingPackageTrials {
	private A_DGroups_JSE_1_6_PkgTrials v1_6 = new A_DGroups_JSE_1_6_PkgTrials();
	private A_DGroups_JSE_1_7_PkgTrials v1_7 = new A_DGroups_JSE_1_7_PkgTrials();
	private A_DGroups_JSE_1_8_PkgTrials v1_8 = new A_DGroups_JSE_1_8_PkgTrials();
	
	
	public static void main(String [] args) {
		try {
			Tests4J_Params params = new Tests4J_Params();
			params.setCoveragePluginFactoryClass(CoveragePluginFactory.class);
			params.setMetaTrialClass(SimpleMetaTrial.class);
			
			
			A_DGroups_JSE_PkgTrials me = new A_DGroups_JSE_PkgTrials();
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
		v1_6.addTrials();
		add(v1_6.getCountingTrials());
		
		v1_7.addTrials();
		add(v1_7.getCountingTrials());
		
		v1_8.addTrials();
		add(v1_8.getCountingTrials());
		
		add(JSE_IOTrial.class);
		add(JSE_LangAnnotTrial.class);
		add(JSE_LangTrial.class);
		add(JSE_LogTrial.class);
		
		add(JSE_MathTrial.class);
		add(JSE_SqlTrial.class);
		add(JSE_UtilTrial.class);
		add(JSE_UtilConcurrentTrial.class);
	}

	@Override
	public A_DGroups_JSE_PkgTrials getTrialParams() {
		return this;
	}

	@Override
	public void setParams(Tests4J_Params params) {
		super.setParams(params);
		v1_6.setParams(params);
		v1_7.setParams(params);
		v1_8.setParams(params);
	}
}
