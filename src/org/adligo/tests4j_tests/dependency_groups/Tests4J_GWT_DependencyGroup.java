package org.adligo.tests4j_tests.dependency_groups;

import java.util.HashSet;
import java.util.Set;

import org.adligo.tests4j.models.shared.dependency.I_PackageConstantLookup;
import org.adligo.tests4j.models.shared.dependency_groups.gwt.GWT_Classes;
import org.adligo.tests4j.models.shared.dependency_groups.gwt.GWT_DependencyGroup;

public class Tests4J_GWT_DependencyGroup extends Tests4J_DependencyGroup {
	public static final Tests4J_GWT_DependencyGroup INSTANCE = new Tests4J_GWT_DependencyGroup();
	
	private Tests4J_GWT_DependencyGroup() {
		Set<String> names = new HashSet<String>();
		
		add(names, I_PackageConstantLookup.class);
		
		add(names, GWT_Classes.class);
		add(names, GWT_DependencyGroup.class);
		
		names.addAll(Tests4J_GWT_v2_6_DependencyGroup.INSTANCE.getClassNames());
		
		super.setupDelegates(names);
	}
	
	private void add(Set<String> names, Class<?> c) {
		names.add(c.getName());
	}
}
