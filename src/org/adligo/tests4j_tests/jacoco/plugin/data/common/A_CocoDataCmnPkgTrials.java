package org.adligo.tests4j_tests.jacoco.plugin.data.common;

import org.adligo.tests4j.run.api.Tests4J;
import org.adligo.tests4j.system.shared.api.Tests4J_Params;
import org.adligo.tests4j.system.shared.trials.I_MetaTrialParams;
import org.adligo.tests4j_4jacoco.plugin.factories.MockitoPluginFactory;
import org.adligo.tests4j_tests.base_trials.I_CountingPackageTrials;
import org.adligo.tests4j_tests.base_trials.SimpleMetaTrial;
import org.adligo.tests4j_tests.base_trials.SimplePackageTrials;
import org.adligo.tests4j_tests.models.shared.coverage.ProbesMutantTrial;
import org.adligo.tests4j_tests.models.shared.coverage.ProbesTrial;

public class A_CocoDataCmnPkgTrials extends SimplePackageTrials 
implements I_MetaTrialParams<A_CocoDataCmnPkgTrials>, I_CountingPackageTrials {

	
	public static void main(String [] args) {
		try {
			Tests4J_Params params = new Tests4J_Params();
			params.setCoveragePluginFactoryClass(MockitoPluginFactory.class);
			params.setMetaTrialClass(SimpleMetaTrial.class);
			
			A_CocoDataCmnPkgTrials me = new A_CocoDataCmnPkgTrials();
			me.setParams(params);
			me.addTrials();
			params.addTrials(me);
			params.setMetaTrialParams(me);
		
			//params.addTest(new Tests4J_Selection(ClassReferencesTrial.class, "testGetsSetsAndConstructor"));
			Tests4J.run(params);
		} catch (Exception x) {
			x.printStackTrace();
		}
	}

	public void addTrials() throws Exception {

	}

	@Override
	public A_CocoDataCmnPkgTrials getTrialParams() {
		return this;
	}
}
