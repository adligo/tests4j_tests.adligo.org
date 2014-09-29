package org.adligo.tests4j_tests.shared.asserts.dependency;

import org.adligo.tests4j.run.Tests4J;
import org.adligo.tests4j.system.shared.Tests4J_Params;
import org.adligo.tests4j.system.shared.trials.I_MetaTrialParams;
import org.adligo.tests4j_4jacoco.plugin.CoveragePluginFactory;
import org.adligo.tests4j_tests.base_trials.I_CountingPackageTrials;
import org.adligo.tests4j_tests.base_trials.SimpleMetaTrial;
import org.adligo.tests4j_tests.base_trials.SimplePackageTrials;
import org.adligo.tests4j_tests.models.shared.dependency.ClassAliasLocalTrial;

public class A_AssertsDepPkgTrials extends SimplePackageTrials 
	implements I_MetaTrialParams<A_AssertsDepPkgTrials>, I_CountingPackageTrials {

	
	public static void main(String [] args) {
		try {
			Tests4J_Params params = new Tests4J_Params();
			params.setCoveragePluginFactoryClass(CoveragePluginFactory.class);
			params.setMetaTrialClass(SimpleMetaTrial.class);
			
			A_AssertsDepPkgTrials me = new A_AssertsDepPkgTrials();
			me.setParams(params);
			me.addTrials();
			params.setMetaTrialParams(me);
			params.addTrials(me);
			params.setRecommendedSetupThreadCount(1);
			
			
			//params.setCoveragePluginConfiguratorClass(ScopedJacocoPluginConfigurator.class);
			Tests4J.run(params);
		} catch (Exception x) {
			x.printStackTrace();
		}
	}

	public void addTrials() throws Exception {
		
		add(I_AllowedDependencyFailureTrial.class);
		add(I_ClassAliasTrial.class);
		add(I_ClassAliasLocalTrial.class);
	
		add(I_ClassAttributesTrial.class);
		
		add(I_FieldSignatureTrial.class);
		add(I_MethodSignatureTrial.class);
		add(I_DependencyTrial.class);
		add(I_DependencyGroupTrial.class);
		
		add(I_CircularDependenciesTrial.class);
		add(I_CircularDependencyFailureTrial.class);
		add(ClassAliasTrial.class);
		add(ClassAliasLocalTrial.class);
		
		add(FieldSignatureTrial.class);
		add(MethodSignatureTrial.class);
		
		add(CircularDependenciesTrial.class);
		add(CircularDependencyFailureMutantTrial.class);
		add(CircularDependencyFailureTrial.class);
		
		add(ClassAttributesTrial.class);
		add(ClassAttributesMutantTrial.class);
		
		
		add(AllowedDependenciesTrial.class);
		
		add(AllowedDependencyFailureMutantTrial.class);
		add(AllowedDependencyFailureTrial.class);
		
		add(DependencyMutantTrial.class);
		add(DependencyTrial.class);
		
		add(DependencyGroupMutantTrial.class);
		add(DependencyGroupTrial.class);
		add(DependencyGroupBaseDelegateTrial.class);
		add(DependencyGroupAggregateTrial.class);
		add(NameOnlyDependencyGroupTrial.class);
	}

	@Override
	public A_AssertsDepPkgTrials getTrialParams() {
		return this;
	}
	
}
