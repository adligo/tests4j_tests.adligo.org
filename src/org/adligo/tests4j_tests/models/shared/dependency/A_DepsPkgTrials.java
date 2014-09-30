package org.adligo.tests4j_tests.models.shared.dependency;

import org.adligo.tests4j.run.api.Tests4J;
import org.adligo.tests4j.system.shared.api.Tests4J_Params;
import org.adligo.tests4j.system.shared.trials.I_MetaTrialParams;
import org.adligo.tests4j_4jacoco.plugin.CoveragePluginFactory;
import org.adligo.tests4j_tests.base_trials.I_CountingPackageTrials;
import org.adligo.tests4j_tests.base_trials.SimpleMetaTrial;
import org.adligo.tests4j_tests.base_trials.SimplePackageTrials;
import org.adligo.tests4j_tests.shared.asserts.dependency.ClassAttributesMutantTrial;
import org.adligo.tests4j_tests.shared.asserts.dependency.ClassAttributesTrial;
import org.adligo.tests4j_tests.shared.asserts.dependency.DependencyGroupAggregateTrial;
import org.adligo.tests4j_tests.shared.asserts.dependency.DependencyGroupBaseDelegateTrial;
import org.adligo.tests4j_tests.shared.asserts.dependency.DependencyGroupMutantTrial;
import org.adligo.tests4j_tests.shared.asserts.dependency.DependencyGroupTrial;
import org.adligo.tests4j_tests.shared.asserts.dependency.DependencyMutantTrial;
import org.adligo.tests4j_tests.shared.asserts.dependency.DependencyTrial;
import org.adligo.tests4j_tests.shared.asserts.dependency.FieldSignatureTrial;
import org.adligo.tests4j_tests.shared.asserts.dependency.I_ClassAttributesTrial;
import org.adligo.tests4j_tests.shared.asserts.dependency.I_DependencyGroupTrial;
import org.adligo.tests4j_tests.shared.asserts.dependency.I_DependencyTrial;
import org.adligo.tests4j_tests.shared.asserts.dependency.I_FieldSignatureTrial;
import org.adligo.tests4j_tests.shared.asserts.dependency.I_MethodSignatureTrial;
import org.adligo.tests4j_tests.shared.asserts.dependency.MethodSignatureTrial;
import org.adligo.tests4j_tests.shared.asserts.dependency.NameOnlyDependencyGroupTrial;

public class A_DepsPkgTrials extends SimplePackageTrials 
implements I_MetaTrialParams<A_DepsPkgTrials>, I_CountingPackageTrials {
	
	
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
		
		//in dependency order
		
		add(I_ClassDependenciesTrial.class);
		add(I_ClassDependenciesLocalTrial.class);
		add(I_ClassDependenciesCacheTrial.class);
		
		add(I_ClassFilterTrial.class);
		add(I_ClassFilterModelTrial.class);
		
		add(I_ClassParentsTrial.class);
		add(I_ClassParentsLocalTrial.class);
		add(I_ClassParentsCacheTrial.class);
		add(I_PackageConstantLookupTrial.class);
		add(I_PackageConstantLookupModelTrial.class);
		
		add(ClassDependenciesLocalMutantTrial.class);
		add(ClassDependenciesLocalTrial.class);
		
		add(ClassParentsLocalMutantTrial.class);
		add(ClassParentsLocalTrial.class);
		
	}

	@Override
	public A_DepsPkgTrials getTrialParams() {
		return this;
	}

	@Override
	public void setParams(Tests4J_Params params) {
		super.setParams(params);
	}
}
