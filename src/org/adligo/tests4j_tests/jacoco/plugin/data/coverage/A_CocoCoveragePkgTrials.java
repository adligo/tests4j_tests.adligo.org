package org.adligo.tests4j_tests.jacoco.plugin.data.coverage;

import org.adligo.tests4j.run.Tests4J;
import org.adligo.tests4j.system.shared.Tests4J_Params;
import org.adligo.tests4j.system.shared.trials.I_MetaTrialParams;
import org.adligo.tests4j_4jacoco.plugin.CoveragePluginFactory;
import org.adligo.tests4j_tests.base_trials.I_CountingPackageTrials;
import org.adligo.tests4j_tests.base_trials.SimpleMetaTrial;
import org.adligo.tests4j_tests.base_trials.SimplePackageTrials;

public class A_CocoCoveragePkgTrials extends SimplePackageTrials 
implements I_MetaTrialParams<A_CocoCoveragePkgTrials>, I_CountingPackageTrials {

	
	public static void main(String [] args) {
		try {
			Tests4J_Params params = new Tests4J_Params();
			params.setCoveragePluginFactoryClass(CoveragePluginFactory.class);
			params.setMetaTrialClass(SimpleMetaTrial.class);
			
			A_CocoCoveragePkgTrials me = new A_CocoCoveragePkgTrials();
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
		add(LazyPackageCoverageFactoryTrial.class);
	}

	@Override
	public A_CocoCoveragePkgTrials getTrialParams() {
		return this;
	}
}
