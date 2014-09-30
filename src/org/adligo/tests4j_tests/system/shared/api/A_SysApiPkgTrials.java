package org.adligo.tests4j_tests.system.shared.api;

import org.adligo.tests4j.run.api.Tests4J;
import org.adligo.tests4j.system.shared.api.Tests4J_Params;
import org.adligo.tests4j.system.shared.api.Tests4J_TrialProgress;
import org.adligo.tests4j.system.shared.trials.I_MetaTrialParams;
import org.adligo.tests4j_4jacoco.plugin.CoveragePluginFactory;
import org.adligo.tests4j_tests.base_trials.I_CountingPackageTrials;
import org.adligo.tests4j_tests.base_trials.SimpleMetaTrial;
import org.adligo.tests4j_tests.base_trials.SimplePackageTrials;

public class A_SysApiPkgTrials extends SimplePackageTrials 
implements I_MetaTrialParams<A_SysApiPkgTrials>, I_CountingPackageTrials {

	
	public static void main(String [] args) {
		try {
			Tests4J_Params params = new Tests4J_Params();
			params.setCoveragePluginFactoryClass(CoveragePluginFactory.class);
			params.setMetaTrialClass(SimpleMetaTrial.class);
			
			
			A_SysApiPkgTrials me = new A_SysApiPkgTrials();
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
		
		add(I_Tests4J_ControlsTrial.class);
		add(I_Tests4J_CoveragePluginFactoryTrial.class);
		add(I_Tests4J_CoveragePluginParamsTrial.class);
		
		add(I_Tests4J_CoveragePluginTrial.class);
		add(I_Tests4J_CoverageRecorderTrial.class);
		
		add(I_Tests4J_CoverageTrialInstrumentationTrial.class);
		add(I_Tests4J_DelegateFactoryTrial.class);
		add(I_Tests4J_DelegateTrial.class);
		
		add(I_Tests4J_DelegateTrial.class);
		add(I_Tests4J_DelegateFactoryTrial.class);
		
		add(I_Tests4J_IDE_Trial.class);
		add(I_Tests4J_ListenerTrial.class);
		
		add(I_Tests4J_ParamsTrial.class);
		add(I_Tests4J_ProcessInfoTrial.class);
		add(I_Tests4J_ProgressMonitorTrial.class);
		
		add(I_Tests4J_RemoteInfoTrial.class);
		add(I_Tests4J_RunnableTrial.class);
		
		add(I_Tests4J_SelectionTrial.class);
		add(I_Tests4J_SourceInfoParamsTrial.class);
		add(I_Tests4J_TestFinishedListenerTrial.class);
		add(I_Tests4J_TrialListTrial.class);
		add(I_Tests4J_TrialProgressTrial.class);
		
		add(Tests4J_SelectionTrial.class);
		add(Tests4J_SourceInfoParamsTrial.class);
		add(Tests4J_SourceInfoParamsDelegateTrial.class);
		
		add(Tests4J_RemoteInfoTrial.class);
		
		add(Tests4J_CoveragePluginParamsTrial.class);
		add(Tests4J_CoverageTrialInstrumentationTrial.class);
		add(Tests4J_DefaultProgressMonitorTrial.class);
		add(Tests4J_DelegateCoveragePluginTrial.class);
		
		add(Tests4J_DelegateProgressMonitorTrial.class);
		
		add(Tests4J_ParamsTrial.class);
		add(Tests4J_ListenerDelegateTrial.class);
		
		add(Tests4J_TrialProgressTrial.class);
	}

	@Override
	public A_SysApiPkgTrials getTrialParams() {
		return this;
	}
}
