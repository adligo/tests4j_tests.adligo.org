package org.adligo.tests4j_tests.references_groups;

import java.util.HashSet;
import java.util.Set;

import org.adligo.gwt_refs.GWT_ReferenceGroup;
import org.adligo.tests4j.models.shared.association.I_PackageConstantLookup;
import org.adligo.tests4j.run.helpers.GWT_Classes;

public class Tests4J_Gwt_ReferenceGroup extends Tests4J_ReferenceGroup {
	public static final Tests4J_Gwt_ReferenceGroup INSTANCE = new Tests4J_Gwt_ReferenceGroup();
	
	private Tests4J_Gwt_ReferenceGroup() {
		Set<String> names = new HashSet<String>();
		
		add(names, I_PackageConstantLookup.class);
		
		add(names, GWT_Classes.class);
		add(names, GWT_ReferenceGroup.class);
		
		names.addAll(Tests4J_Gwt_v2_6_ReferenceGroup.INSTANCE.getClassNames());
		
		super.setupDelegates(names);
	}
	
	private void add(Set<String> names, Class<?> c) {
		names.add(c.getName());
	}
}
