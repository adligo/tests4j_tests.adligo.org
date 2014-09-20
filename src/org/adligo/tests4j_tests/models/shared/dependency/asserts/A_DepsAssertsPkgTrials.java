package org.adligo.tests4j_tests.models.shared.dependency.asserts;

import org.adligo.tests4j.models.shared.dependency.asserts.AllowedDependencyFailureMutant;
import org.adligo.tests4j.models.shared.system.Tests4J_Params;
import org.adligo.tests4j.models.shared.trials.I_MetaTrialParams;
import org.adligo.tests4j.run.Tests4J;
import org.adligo.tests4j_4jacoco.plugin.CoveragePluginFactory;
import org.adligo.tests4j_tests.base_trials.I_CountingPackageTrials;
import org.adligo.tests4j_tests.base_trials.SimpleMetaTrial;
import org.adligo.tests4j_tests.base_trials.SimplePackageTrials;

public class A_DepsAssertsPkgTrials extends SimplePackageTrials 
implements I_MetaTrialParams<A_DepsAssertsPkgTrials>, I_CountingPackageTrials {

	
	public static void main(String [] args) {
		try {
			Tests4J_Params params = new Tests4J_Params();
			params.setCoveragePluginFactoryClass(CoveragePluginFactory.class);
			params.setMetaTrialClass(SimpleMetaTrial.class);
			
			
			A_DepsAssertsPkgTrials me = new A_DepsAssertsPkgTrials();
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
		add(I_AllowedDependencyFailureTrial.class);
		add(I_CircularDependencyFailureTrial.class);
		add(AllowedDependencyFailureMutantTrial.class);
		add(AllowedDependencyFailureTrial.class);
		add(CircularDependencyFailureMutantTrial.class);
		add(CircularDependencyFailureTrial.class);
	}

	@Override
	public A_DepsAssertsPkgTrials getTrialParams() {
		return this;
	}
}
