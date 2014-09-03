package org.adligo.tests4j_tests.models.shared.dependency;

import org.adligo.tests4j.models.shared.system.Tests4J_Params;
import org.adligo.tests4j.models.shared.trials.I_TrialParams;
import org.adligo.tests4j.run.Tests4J;
import org.adligo.tests4j_4jacoco.plugin.CoveragePluginFactory;
import org.adligo.tests4j_tests.base_trials.I_CountingPackageTrials;
import org.adligo.tests4j_tests.base_trials.SimpleMetaTrial;
import org.adligo.tests4j_tests.base_trials.SimplePackageTrials;
import org.adligo.tests4j_tests.models.shared.metadata.A_MetaPkgTrials;

public class A_DepsPkgTrials extends SimplePackageTrials 
implements I_TrialParams<A_DepsPkgTrials>, I_CountingPackageTrials {

	
	public static void main(String [] args) {
		try {
			Tests4J_Params params = new Tests4J_Params();
			params.setCoveragePluginFactoryClass(CoveragePluginFactory.class);
			params.setMetaTrialClass(SimpleMetaTrial.class);
			
			
			A_DepsPkgTrials me = new A_DepsPkgTrials();
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
		add(ClassAliasTrial.class);
		add(ClassAttributesMutantTrial.class);
		add(ClassAttributesTrial.class);
		
		add(ClassDependenciesLocalMutantTrial.class);
		add(ClassDependenciesLocalTrial.class);
		
		add(ClassParentsLocalMutantTrial.class);
		add(ClassParentsLocalTrial.class);
		
		add(DependencyMutantTrial.class);
		add(DependencyTrial.class);
		
		add(MethodSignatureTrial.class);
	}

	@Override
	public A_DepsPkgTrials getTrialParams() {
		return this;
	}
}
