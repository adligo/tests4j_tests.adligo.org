package org.adligo.tests4j_tests.shared.asserts.reference;

import org.adligo.tests4j.run.api.Tests4J;
import org.adligo.tests4j.system.shared.api.Tests4J_Params;
import org.adligo.tests4j.system.shared.trials.I_MetaTrialParams;
import org.adligo.tests4j_4jacoco.plugin.CoveragePluginFactory;
import org.adligo.tests4j_tests.base_trials.I_CountingPackageTrials;
import org.adligo.tests4j_tests.base_trials.SimpleMetaTrial;
import org.adligo.tests4j_tests.base_trials.SimplePackageTrials;
import org.adligo.tests4j_tests.models.shared.association.ClassAliasLocalTrial;
import org.adligo.tests4j_tests.models.shared.association.ClassAliasTrial;

public class A_AssertsRefPkgTrials extends SimplePackageTrials 
	implements I_MetaTrialParams<A_AssertsRefPkgTrials>, I_CountingPackageTrials {

	
	public static void main(String [] args) {
		try {
			Tests4J_Params params = new Tests4J_Params();
			params.setCoveragePluginFactoryClass(CoveragePluginFactory.class);
			params.setMetaTrialClass(SimpleMetaTrial.class);
			
			A_AssertsRefPkgTrials me = new A_AssertsRefPkgTrials();
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
		
		add(I_AllowedReferencesFailureTrial.class);
		add(I_ClassAliasTrial.class);
		add(I_ClassAliasLocalTrial.class);
	
		add(I_ClassAttributesTrial.class);
		
		add(I_FieldSignatureTrial.class);
		add(I_MethodSignatureTrial.class);
		add(I_DependencyTrial.class);
		add(I_ReferencesGroupTrial.class);
		
		add(I_CircularDependenciesTrial.class);
		add(I_CircularDependencyFailureTrial.class);
		
		add(FieldSignatureTrial.class);
		add(MethodSignatureTrial.class);
		
		add(CircularDependenciesTrial.class);
		add(CircularDependencyFailureMutantTrial.class);
		add(CircularDependencyFailureTrial.class);
		
		add(ClassAttributesTrial.class);
		add(ClassAttributesMutantTrial.class);
		
		
		add(AllowedReferencesTrial.class);
		
		add(AllowedReferencesFailureMutantTrial.class);
		add(AllowedReferencesFailureTrial.class);
		
		add(DependencyMutantTrial.class);
		add(DependencyTrial.class);
		
		add(ReferenceGroupMutantTrial.class);
		add(ReferenceGroupTrial.class);
		add(ReferenceGroupBaseDelegateTrial.class);
		add(ReferenceGroupAggregateTrial.class);
		add(NameOnlyReferenceGroupTrial.class);
	}

	@Override
	public A_AssertsRefPkgTrials getTrialParams() {
		return this;
	}
	
}
