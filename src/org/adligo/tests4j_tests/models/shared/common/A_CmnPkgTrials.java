package org.adligo.tests4j_tests.models.shared.common;

import org.adligo.tests4j.models.shared.system.Tests4J_Params;
import org.adligo.tests4j.models.shared.trials.I_TrialParams;
import org.adligo.tests4j.run.Tests4J;
import org.adligo.tests4j.run.helpers.Tests4J_NotificationManager;
import org.adligo.tests4j_4jacoco.plugin.CoveragePluginFactory;
import org.adligo.tests4j_tests.base_trials.I_CountingPackageTrials;
import org.adligo.tests4j_tests.base_trials.SimpleMetaTrial;
import org.adligo.tests4j_tests.base_trials.SimplePackageTrials;

public class A_CmnPkgTrials extends SimplePackageTrials 
	implements I_TrialParams<A_CmnPkgTrials>, I_CountingPackageTrials {

	
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
		add(ClassMethodsTrial.class);
		add(DefaultSystemTrial.class);
		add(I_ImmutableTrial.class);
		add(I_PlatformContainerTrial.class);
		add(I_PlatformTrial.class);
		add(I_SystemTrial.class);
		add(I_TrialTypeTrial.class);
		
		add(MethodBlockerTrial.class);
		add(PlatformTrial.class);
		add(StringMethodsTrial.class);
		add(StackTraceBuilderTrial.class);
		add(Tests4J_SystemTrial.class);
		add(TrialTypeTrial.class);
	}
	
	@Override
	public A_CmnPkgTrials getTrialParams() {
		return this;
	}
}
