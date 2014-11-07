package org.adligo.tests4j_v1_tests.jacoco.plugin.discovery;

import org.adligo.tests4j.run.api.Tests4J;
import org.adligo.tests4j.system.shared.api.Tests4J_Params;
import org.adligo.tests4j.system.shared.trials.I_MetaTrialParams;
import org.adligo.tests4j_4jacoco.plugin.discovery.OrderedClassDiscovery;
import org.adligo.tests4j_4jacoco.plugin.factories.MockitoPluginFactory;
import org.adligo.tests4j_4jacoco.plugin.instrumentation.ClassInstrumenter;
import org.adligo.tests4j_tests.base_trials.I_CountingPackageTrials;
import org.adligo.tests4j_tests.base_trials.SimpleMetaTrial;
import org.adligo.tests4j_tests.base_trials.SimplePackageTrials;

public class A_8CocoDiscPkgTrials extends SimplePackageTrials 
implements I_MetaTrialParams<A_8CocoDiscPkgTrials>, I_CountingPackageTrials {

	
	public static void main(String [] args) {
		try {
			Tests4J_Params params = new Tests4J_Params();
			params.setCoveragePluginFactoryClass(MockitoPluginFactory.class);
			params.setMetaTrialClass(SimpleMetaTrial.class);
			
			A_8CocoDiscPkgTrials me = new A_8CocoDiscPkgTrials();
			me.setParams(params);
			me.addTrials();
			params.addTrials(me);
			
			params.setMetaTrialParams(me);
			params.addTrials(new A_8CocoDiscPkgTrials());
			//params.setLogState(ReferenceTrackingClassVisitor.class, true);
			//params.setLogState(ReferenceTrackingMethodVisitor.class, true);
			//params.setLogState(ClassDependenciesDiscovery.class, true);
			//TieredJacocoPlugin covargePlugin =new TieredJacocoPlugin();
			
			params.setLogState(OrderedClassDiscovery.class, true);
			params.setLogState(ClassInstrumenter.class, true);
		
			Tests4J.run(params);
		} catch (Exception x) {
			x.printStackTrace();
		}
	}

	public void addTrials() throws Exception {
		add(ReferenceTrackingMethodVisitorTrial.class);
		add(ReferenceTrackingClassVisitorTrial.class);
		add(ClassParentsDiscoveryTrial.class);
		add(DiscoveryApiTrial.class);
	}

	@Override
	public A_8CocoDiscPkgTrials getTrialParams() {
		return this;
	}
	

}
