package org.adligo.tests4j_tests.models.shared.association;

import org.adligo.tests4j.run.api.Tests4J;
import org.adligo.tests4j.system.shared.api.Tests4J_Params;
import org.adligo.tests4j.system.shared.trials.I_MetaTrialParams;
import org.adligo.tests4j_4jacoco.plugin.factories.MockitoPluginFactory;
import org.adligo.tests4j_tests.base_trials.I_CountingPackageTrials;
import org.adligo.tests4j_tests.base_trials.SimpleMetaTrial;
import org.adligo.tests4j_tests.base_trials.SimplePackageTrials;
import org.adligo.tests4j_tests.shared.asserts.reference.ClassAttributesMutantTrial;
import org.adligo.tests4j_tests.shared.asserts.reference.ClassAttributesTrial;
import org.adligo.tests4j_tests.shared.asserts.reference.DependencyMutantTrial;
import org.adligo.tests4j_tests.shared.asserts.reference.DependencyTrial;
import org.adligo.tests4j_tests.shared.asserts.reference.FieldSignatureTrial;
import org.adligo.tests4j_tests.shared.asserts.reference.I_ClassAttributesTrial;
import org.adligo.tests4j_tests.shared.asserts.reference.I_DependencyTrial;
import org.adligo.tests4j_tests.shared.asserts.reference.I_FieldSignatureTrial;
import org.adligo.tests4j_tests.shared.asserts.reference.I_MethodSignatureTrial;
import org.adligo.tests4j_tests.shared.asserts.reference.I_ReferencesGroupTrial;
import org.adligo.tests4j_tests.shared.asserts.reference.MethodSignatureTrial;
import org.adligo.tests4j_tests.shared.asserts.reference.NameOnlyReferenceGroupTrial;
import org.adligo.tests4j_tests.shared.asserts.reference.ReferenceGroupAggregateTrial;
import org.adligo.tests4j_tests.shared.asserts.reference.ReferenceGroupBaseDelegateTrial;
import org.adligo.tests4j_tests.shared.asserts.reference.ReferenceGroupMutantTrial;
import org.adligo.tests4j_tests.shared.asserts.reference.ReferenceGroupTrial;

public class A_AssociationPkgTrials extends SimplePackageTrials 
implements I_MetaTrialParams<A_AssociationPkgTrials>, I_CountingPackageTrials {
	
	
	public static void main(String [] args) {
		try {
			Tests4J_Params params = new Tests4J_Params();
			params.setCoveragePluginFactoryClass(MockitoPluginFactory.class);
			params.setMetaTrialClass(SimpleMetaTrial.class);
			
			
			A_AssociationPkgTrials me = new A_AssociationPkgTrials();
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
		
		add(I_ClassAssociationsTrial.class);
		add(I_ClassAssociationsLocalTrial.class);
		add(I_ClassAssociationsCacheTrial.class);
		
		add(I_ClassFilterTrial.class);
		add(I_ClassFilterModelTrial.class);
		
		add(I_ClassParentsTrial.class);
		add(I_ClassParentsLocalTrial.class);
		add(I_ClassParentsCacheTrial.class);
		add(I_PackageConstantLookupTrial.class);
		add(I_PackageConstantLookupModelTrial.class);
		
		add(ClassAliasLocalTrial.class);
		add(ClassAliasTrial.class);
		
		add(ClassAssociationsLocalMutantTrial.class);
		add(ClassAssociationsLocalTrial.class);
		
		add(ClassParentsLocalMutantTrial.class);
		add(ClassParentsLocalTrial.class);
		
	}

	@Override
	public A_AssociationPkgTrials getTrialParams() {
		return this;
	}

	@Override
	public void setParams(Tests4J_Params params) {
		super.setParams(params);
	}
}
