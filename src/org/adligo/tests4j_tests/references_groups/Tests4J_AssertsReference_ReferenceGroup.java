package org.adligo.tests4j_tests.references_groups;

import java.util.HashSet;
import java.util.Set;

import org.adligo.tests4j.shared.asserts.reference.AllowedReferences;
import org.adligo.tests4j.shared.asserts.reference.AllowedReferencesFailure;
import org.adligo.tests4j.shared.asserts.reference.AllowedReferencesFailureMutant;
import org.adligo.tests4j.shared.asserts.reference.CircularDependencies;
import org.adligo.tests4j.shared.asserts.reference.CircularDependencyFailure;
import org.adligo.tests4j.shared.asserts.reference.CircularDependencyFailureMutant;
import org.adligo.tests4j.shared.asserts.reference.ClassAlias;
import org.adligo.tests4j.shared.asserts.reference.ClassAliasLocal;
import org.adligo.tests4j.shared.asserts.reference.ClassAttributes;
import org.adligo.tests4j.shared.asserts.reference.ClassAttributesMutant;
import org.adligo.tests4j.shared.asserts.reference.Dependency;
import org.adligo.tests4j.shared.asserts.reference.DependencyMutant;
import org.adligo.tests4j.shared.asserts.reference.FieldSignature;
import org.adligo.tests4j.shared.asserts.reference.I_AllowedReferencesFailure;
import org.adligo.tests4j.shared.asserts.reference.I_CircularDependencies;
import org.adligo.tests4j.shared.asserts.reference.I_CircularDependencyFailure;
import org.adligo.tests4j.shared.asserts.reference.I_ClassAlias;
import org.adligo.tests4j.shared.asserts.reference.I_ClassAliasLocal;
import org.adligo.tests4j.shared.asserts.reference.I_ClassAttributes;
import org.adligo.tests4j.shared.asserts.reference.I_Dependency;
import org.adligo.tests4j.shared.asserts.reference.I_FieldSignature;
import org.adligo.tests4j.shared.asserts.reference.I_MethodSignature;
import org.adligo.tests4j.shared.asserts.reference.I_ReferenceGroup;
import org.adligo.tests4j.shared.asserts.reference.MethodSignature;
import org.adligo.tests4j.shared.asserts.reference.NameOnlyReferenceGroup;
import org.adligo.tests4j.shared.asserts.reference.ReferenceGroup;
import org.adligo.tests4j.shared.asserts.reference.ReferenceGroupAggregate;
import org.adligo.tests4j.shared.asserts.reference.ReferenceGroupBaseDelegate;
import org.adligo.tests4j.shared.asserts.reference.ReferenceGroupMutant;
/**
 * @diagram_sync with PackageDependencies.class on 10/1/1014
 */
public class Tests4J_AssertsReference_ReferenceGroup extends Tests4J_ReferenceGroup {
	public static final Tests4J_AssertsReference_ReferenceGroup INSTANCE = new Tests4J_AssertsReference_ReferenceGroup();
	
	private Tests4J_AssertsReference_ReferenceGroup() {
		Set<String> names = new HashSet<String>();
		
		add(names, AllowedReferences.class);
		add(names, AllowedReferencesFailure.class);
		add(names, AllowedReferencesFailureMutant.class);
		
		
		add(names, CircularDependencies.class);
		add(names, CircularDependencyFailure.class);
		add(names, CircularDependencyFailureMutant.class);
		
		add(names, ClassAlias.class);
		add(names, ClassAliasLocal.class);
		
		add(names, ClassAttributes.class);
		add(names, ClassAttributesMutant.class);
		
		add(names, Dependency.class);
		add(names, DependencyMutant.class);
		
		add(names, ReferenceGroup.class);
		add(names, ReferenceGroupAggregate.class);
		add(names, ReferenceGroupBaseDelegate.class);
		add(names, ReferenceGroupMutant.class);
		
		add(names, FieldSignature.class);
		
		add(names, I_AllowedReferencesFailure.class);
		add(names, I_CircularDependencies.class);
		add(names, I_CircularDependencyFailure.class);
		
		add(names, I_ClassAlias.class);
		add(names, I_ClassAliasLocal.class);
		
		add(names, I_ClassAttributes.class);
		
		add(names, I_Dependency.class);
		add(names, I_ReferenceGroup.class);
		
		add(names, I_FieldSignature.class);
		add(names, I_MethodSignature.class);
		
		add(names, MethodSignature.class);
		add(names, NameOnlyReferenceGroup.class);
		
		names.addAll(Tests4J_AssertsCommon_ReferenceGroup.INSTANCE.getClassNames());
		
		setupDelegates(names);
	}
	
	private void add(Set<String> names, Class<?> c) {
		names.add(c.getName());
	}
}
