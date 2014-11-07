package org.adligo.tests4j_v1_tests;

import org.adligo.tests4j.run.api.Tests4J;
import org.adligo.tests4j.system.shared.api.Tests4J_Params;
import org.adligo.tests4j.system.shared.trials.I_MetaTrialParams;
import org.adligo.tests4j_4jacoco.plugin.discovery.OrderedClassDiscovery;
import org.adligo.tests4j_4jacoco.plugin.factories.MockitoPluginFactory;
import org.adligo.tests4j_4jacoco.plugin.instrumentation.ClassInstrumenter;
import org.adligo.tests4j_tests.base_trials.I_CountingPackageTrials;
import org.adligo.tests4j_tests.base_trials.SimpleMetaTrial;
import org.adligo.tests4j_tests.base_trials.SimplePackageTrials;
import org.adligo.tests4j_v1_tests.gwt_refs.A_DGroups_GWT_PkgTrials;
import org.adligo.tests4j_v1_tests.jacoco.plugin.A_CocoJavaVersionSpecificTrials;
import org.adligo.tests4j_v1_tests.models.shared.reference_groups.jse.A_DGroups_JSE_PkgTrials;

public class A_JavaVersionSpecificTrials extends SimplePackageTrials 
implements I_MetaTrialParams<A_JavaVersionSpecificTrials>, I_CountingPackageTrials {
	private A_DGroups_GWT_PkgTrials gwt = new A_DGroups_GWT_PkgTrials();
	private A_DGroups_JSE_PkgTrials jse = new A_DGroups_JSE_PkgTrials();
	private A_CocoJavaVersionSpecificTrials coco = new A_CocoJavaVersionSpecificTrials();
	
	public static void main(String [] args) {
		try {
			Tests4J_Params params = new Tests4J_Params();
			params.setCoveragePluginFactoryClass(MockitoPluginFactory.class);
			params.setMetaTrialClass(SimpleMetaTrial.class);
			
			A_JavaVersionSpecificTrials me = new A_JavaVersionSpecificTrials();
			me.setParams(params);
			me.addTrials();
			params.addTrials(me);
			
			params.setMetaTrialParams(me);
			
			params.setLogState(OrderedClassDiscovery.class, true);
			params.setLogState(ClassInstrumenter.class, true);
		
			Tests4J.run(params);
		} catch (Exception x) {
			x.printStackTrace();
		}
	}

	public void addTrials() throws Exception {
		jse.addTrials();
		add(jse.getCountingTrials());
		
		gwt.addTrials();
		add(gwt.getCountingTrials());
		
		coco.addTrials();
		add(coco.getCountingTrials());
	}
	
	@Override
	public A_JavaVersionSpecificTrials getTrialParams() {
		return this;
	}

	@Override
	public void setParams(Tests4J_Params params) {
		super.setParams(params);
		jse.setParams(params);
		gwt.setParams(params);
		coco.setParams(params);
	}

}
