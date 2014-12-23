package org.adligo.tests4j_tests.references_groups;

import java.util.HashSet;
import java.util.Set;

import org.adligo.tests4j.models.shared.association.ClassAssociationsLocal;
import org.adligo.tests4j.models.shared.association.ClassAssociationsLocalMutant;
import org.adligo.tests4j.models.shared.association.ClassParentsLocal;
import org.adligo.tests4j.models.shared.association.ClassParentsLocalMutant;
import org.adligo.tests4j.models.shared.association.I_ClassAssociations;
import org.adligo.tests4j.models.shared.association.I_ClassAssociationsCache;
import org.adligo.tests4j.models.shared.association.I_ClassAssociationsLocal;
import org.adligo.tests4j.models.shared.association.I_ClassParents;
import org.adligo.tests4j.models.shared.association.I_ClassParentsCache;
import org.adligo.tests4j.models.shared.association.I_ClassParentsLocal;
import org.adligo.tests4j.models.shared.association.I_PackageConstantLookup;
import org.adligo.tests4j.models.shared.association.I_PackageConstantLookupModel;
import org.adligo.tests4j.run.helpers.ClassFilter;
import org.adligo.tests4j.run.helpers.ClassFilterMutant;
import org.adligo.tests4j.run.helpers.I_ClassFilter;
import org.adligo.tests4j.run.helpers.I_ClassFilterModel;
/**
 * @diagram_sync with PackageDependencies.class on 10/1/1014
 * @author scott
 *
 */
public class Tests4J_Association_ReferenceGroup extends Tests4J_ReferenceGroup {
	public static final Tests4J_Association_ReferenceGroup INSTANCE = new Tests4J_Association_ReferenceGroup();
	
	private Tests4J_Association_ReferenceGroup() {
		Set<String> names = new HashSet<String>();
		
		
		add(names, ClassAssociationsLocal.class);
		add(names, ClassAssociationsLocalMutant.class);
		add(names, ClassFilter.class);
		add(names, ClassFilterMutant.class);
		add(names, ClassParentsLocal.class);
		add(names, ClassParentsLocalMutant.class);
		
		add(names, I_ClassAssociations.class);
		add(names, I_ClassAssociationsCache.class);
		add(names, I_ClassAssociationsLocal.class);
		add(names, I_ClassFilter.class);
		add(names, I_ClassFilterModel.class);
		add(names, I_ClassParents.class);
		add(names, I_ClassParentsCache.class);
		add(names, I_ClassParentsLocal.class);
		
		add(names, I_PackageConstantLookup.class);
		add(names, I_PackageConstantLookupModel.class);
		
		names.addAll(Tests4J_Asserts_ReferenceGroup.INSTANCE.getClassNames());
		
		setupDelegates(names);
	}
	
	private void add(Set<String> names, Class<?> c) {
		names.add(c.getName());
	}
}
