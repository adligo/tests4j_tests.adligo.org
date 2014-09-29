package org.adligo.tests4j_tests.dependency_groups;

import java.util.HashSet;
import java.util.Set;

import org.adligo.tests4j.models.shared.dependency_groups.gwt.v2_6.GWT_2_6_Annot;
import org.adligo.tests4j.models.shared.dependency_groups.gwt.v2_6.GWT_2_6_IO;
import org.adligo.tests4j.models.shared.dependency_groups.gwt.v2_6.GWT_2_6_Lang;
import org.adligo.tests4j.models.shared.dependency_groups.gwt.v2_6.GWT_2_6_Log;
import org.adligo.tests4j.models.shared.dependency_groups.gwt.v2_6.GWT_2_6_Math;
import org.adligo.tests4j.models.shared.dependency_groups.gwt.v2_6.GWT_2_6_SQL;
import org.adligo.tests4j.models.shared.dependency_groups.gwt.v2_6.GWT_2_6_Util;
import org.adligo.tests4j.models.shared.dependency_groups.jse.I_PackageConstantLookup;

public class Tests4J_GWT_v2_6_DependencyGroup extends Tests4J_DependencyGroup {

	public Tests4J_GWT_v2_6_DependencyGroup() {
		Set<String> names = new HashSet<String>();
		
		add(names, I_PackageConstantLookup.class);
		
		add(names, GWT_2_6_Annot.class);
		add(names, GWT_2_6_IO.class);
		add(names, GWT_2_6_Lang.class);
		add(names, GWT_2_6_Log.class);
		add(names, GWT_2_6_Math.class);
		add(names, GWT_2_6_SQL.class);
		add(names, GWT_2_6_Util.class);
		
		Tests4J_Dependency_DependencyGroup ddg = new Tests4J_Dependency_DependencyGroup();
		names.addAll(ddg.getClassNames());
				
		Tests4J_JSE_DependencyGroup dg = new Tests4J_JSE_DependencyGroup();
		names.addAll(dg.getClassNames());
		
		super.setupDelegates(names);
	}
	
	private void add(Set<String> names, Class<?> c) {
		names.add(c.getName());
	}
}
