package org.adligo.tests4j_tests.shared.common;

import org.adligo.tests4j.run.api.Tests4J;
import org.adligo.tests4j.run.helpers.Tests4J_NotificationManager;
import org.adligo.tests4j.system.shared.api.Tests4J_Params;
import org.adligo.tests4j.system.shared.trials.I_MetaTrialParams;
import org.adligo.tests4j_4jacoco.plugin.CoveragePluginFactory;
import org.adligo.tests4j_tests.base_trials.I_CountingPackageTrials;
import org.adligo.tests4j_tests.base_trials.SimpleMetaTrial;
import org.adligo.tests4j_tests.base_trials.SimplePackageTrials;

public class A_CmnPkgTrials extends SimplePackageTrials 
	implements I_MetaTrialParams<A_CmnPkgTrials>, I_CountingPackageTrials {

	
	public static void main(String [] args) {
		try {
			Tests4J_Params params = new Tests4J_Params();
			
			params.setCoveragePluginFactoryClass(CoveragePluginFactory.class);
			params.setMetaTrialClass(SimpleMetaTrial.class);
			
			A_CmnPkgTrials me = new A_CmnPkgTrials();
			me.setParams(params);
			me.addTrials();
			params.setMetaTrialParams(me);
			params.addTrials(me);
			params.setLogState(Tests4J_NotificationManager.class, true);
			
			
			Tests4J.run(params);
			//controls.waitForResults();
		} catch (Exception x) {
			x.printStackTrace();
		}
	}

	public void addTrials() throws Exception {
	  add(ArrayUtilsTrial.class);
		add(CacheControlTrial.class);
		add(ClassMethodsTrial.class);
		add(DefaultSystemTrial.class);
		add(DelegateSystemTrial.class);
		
		add(I_CacheControlTrial.class);
		add(I_ImmutableTrial.class);
		add(I_PlatformContainerTrial.class);
		add(I_PlatformTrial.class);
		add(I_TimeTrial.class);
		add(I_SystemTrial.class);
		add(I_TrialTypeTrial.class);
		
		add(JavaAPIVersionTrial.class);
		add(LegacyAPI_IssuesTrial.class);
		
		add(MethodBlockerTrial.class);
		add(PlatformTrial.class);
		add(StackTraceBuilderTrial.class);
		
		add(StringMethodsTrial.class);
		add(SystemWithPrintStreamDelegateTrial.class);
		
		add(Tests4J_ConstantsTrial.class);
		add(Tests4J_ConstantsWrapperTrial.class);
		add(TrialTypeTrial.class);
	}
	
	@Override
	public A_CmnPkgTrials getTrialParams() {
		return this;
	}
}
