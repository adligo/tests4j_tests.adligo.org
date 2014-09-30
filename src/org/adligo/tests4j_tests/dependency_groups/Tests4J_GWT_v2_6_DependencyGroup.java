package org.adligo.tests4j_tests.dependency_groups;

import java.util.HashSet;
import java.util.Set;

import org.adligo.tests4j.models.shared.dependency.I_PackageConstantLookup;
import org.adligo.tests4j.models.shared.dependency_groups.gwt.v2_6.GWT_2_6_Annot;
import org.adligo.tests4j.models.shared.dependency_groups.gwt.v2_6.GWT_2_6_IO;
import org.adligo.tests4j.models.shared.dependency_groups.gwt.v2_6.GWT_2_6_Lang;
import org.adligo.tests4j.models.shared.dependency_groups.gwt.v2_6.GWT_2_6_Log;
import org.adligo.tests4j.models.shared.dependency_groups.gwt.v2_6.GWT_2_6_Math;
import org.adligo.tests4j.models.shared.dependency_groups.gwt.v2_6.GWT_2_6_SQL;
import org.adligo.tests4j.models.shared.dependency_groups.gwt.v2_6.GWT_2_6_Util;

public class Tests4J_GWT_v2_6_DependencyGroup extends Tests4J_DependencyGroup {
	public static final Tests4J_GWT_v2_6_DependencyGroup INSTANCE = new Tests4J_GWT_v2_6_DependencyGroup();
	
	private Tests4J_GWT_v2_6_DependencyGroup() {
		Set<String> names = new HashSet<String>();
		
		add(names, I_PackageConstantLookup.class);
		
		add(names, GWT_2_6_Annot.class);
		add(names, GWT_2_6_IO.class);
		add(names, GWT_2_6_Lang.class);
		add(names, GWT_2_6_Log.class);
		add(names, GWT_2_6_Math.class);
		add(names, GWT_2_6_SQL.class);
		add(names, GWT_2_6_Util.class);
		
		names.addAll(Tests4J_Dependency_DependencyGroup.INSTANCE.getClassNames());
				
		names.addAll(Tests4J_JSE_DependencyGroup.INSTANCE.getClassNames());
		
		super.setupDelegates(names);
	}
	
	private void add(Set<String> names, Class<?> c) {
		names.add(c.getName());
	}
}
