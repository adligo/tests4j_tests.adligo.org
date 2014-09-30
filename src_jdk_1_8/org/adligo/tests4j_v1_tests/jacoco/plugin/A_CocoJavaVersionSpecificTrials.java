package org.adligo.tests4j_v1_tests.jacoco.plugin;

import org.adligo.tests4j.run.api.Tests4J;
import org.adligo.tests4j.system.shared.api.Tests4J_Params;
import org.adligo.tests4j.system.shared.trials.I_MetaTrialParams;
import org.adligo.tests4j_4jacoco.plugin.CoveragePluginFactory;
import org.adligo.tests4j_4jacoco.plugin.discovery.OrderedClassDiscovery;
import org.adligo.tests4j_4jacoco.plugin.instrumentation.ClassInstrumenter;
import org.adligo.tests4j_tests.base_trials.I_CountingPackageTrials;
import org.adligo.tests4j_tests.base_trials.SimpleMetaTrial;
import org.adligo.tests4j_tests.base_trials.SimplePackageTrials;
import org.adligo.tests4j_v1_tests.jacoco.plugin.discovery.A_8CocoDiscPkgTrials;

public class A_CocoJavaVersionSpecificTrials extends SimplePackageTrials 
implements I_MetaTrialParams<A_CocoJavaVersionSpecificTrials>, I_CountingPackageTrials {
	private A_8CocoDiscPkgTrials discovery = new A_8CocoDiscPkgTrials();
	
	public static void main(String [] args) {
		try {
			Tests4J_Params params = new Tests4J_Params();
			params.setCoveragePluginFactoryClass(CoveragePluginFactory.class);
			params.setMetaTrialClass(SimpleMetaTrial.class);
			
			A_CocoJavaVersionSpecificTrials me = new A_CocoJavaVersionSpecificTrials();
			me.setParams(params);
			me.addTrials();
			params.addTrials(me);
			
			params.setMetaTrialParams(me);
			params.addTrials(new A_8CocoDiscPkgTrials());
			
			params.setLogState(OrderedClassDiscovery.class, true);
			params.setLogState(ClassInstrumenter.class, true);
		
			Tests4J.run(params);
		} catch (Exception x) {
			x.printStackTrace();
		}
	}

	public void addTrials() throws Exception {
		discovery.addTrials();
		add(discovery.getCountingTrials());
	}
	
	@Override
	public A_CocoJavaVersionSpecificTrials getTrialParams() {
		return this;
	}

	@Override
	public void setParams(Tests4J_Params params) {
		super.setParams(params);
		discovery.setParams(params);
	}

}
