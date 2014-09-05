package org.adligo.tests4j_v1_tests;

import org.adligo.tests4j.models.shared.system.Tests4J_Params;
import org.adligo.tests4j.models.shared.trials.I_TrialParams;
import org.adligo.tests4j.run.Tests4J;
import org.adligo.tests4j_4jacoco.plugin.CoveragePluginFactory;
import org.adligo.tests4j_4jacoco.plugin.discovery.OrderedClassDiscovery;
import org.adligo.tests4j_4jacoco.plugin.instrumentation.ClassInstrumenter;
import org.adligo.tests4j_tests.base_trials.I_CountingPackageTrials;
import org.adligo.tests4j_tests.base_trials.SimpleMetaTrial;
import org.adligo.tests4j_tests.base_trials.SimplePackageTrials;
import org.adligo.tests4j_v1_tests.jacoco.plugin.discovery.A_8CocoDiscPkgTrials;
import org.adligo.tests4j_v1_tests.models.dependency_groups.gwt.v2_6.A_DGroups_GWT_2_6_PkgTrials;
import org.adligo.tests4j_v1_tests.models.dependency_groups.jse.A_DGroups_JSE_1_8_PkgTrials;

public class A_JavaVersionSpecificTrials extends SimplePackageTrials 
implements I_TrialParams<A_JavaVersionSpecificTrials>, I_CountingPackageTrials {
	private A_DGroups_GWT_2_6_PkgTrials pkg = new A_DGroups_GWT_2_6_PkgTrials();
	private A_DGroups_JSE_1_8_PkgTrials jse = new A_DGroups_JSE_1_8_PkgTrials();
	
	
	public static void main(String [] args) {
		try {
			Tests4J_Params params = new Tests4J_Params();
			params.setCoveragePluginFactoryClass(CoveragePluginFactory.class);
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
		pkg.addTrials();
		add(pkg.getCountingTrials());
	}
	
	@Override
	public A_JavaVersionSpecificTrials getTrialParams() {
		return this;
	}

	@Override
	public void setParams(Tests4J_Params params) {
		super.setParams(params);
		jse.setParams(params);
		pkg.setParams(params);
	}

}
