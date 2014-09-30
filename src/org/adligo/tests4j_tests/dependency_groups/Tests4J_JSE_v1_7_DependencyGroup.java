package org.adligo.tests4j_tests.dependency_groups;

import java.util.HashSet;
import java.util.Set;

import org.adligo.tests4j.models.shared.dependency_groups.jse.v1_6.I_JSE_1_6_IO;
import org.adligo.tests4j.models.shared.dependency_groups.jse.v1_6.I_JSE_1_6_LangAnnot;
import org.adligo.tests4j.models.shared.dependency_groups.jse.v1_6.I_JSE_1_6_Log;
import org.adligo.tests4j.models.shared.dependency_groups.jse.v1_6.I_JSE_1_6_Math;
import org.adligo.tests4j.models.shared.dependency_groups.jse.v1_7.I_JSE_1_7_Lang;
import org.adligo.tests4j.models.shared.dependency_groups.jse.v1_7.I_JSE_1_7_Sql;
import org.adligo.tests4j.models.shared.dependency_groups.jse.v1_7.I_JSE_1_7_Util;

public class Tests4J_JSE_v1_7_DependencyGroup extends Tests4J_DependencyGroup {
	public static final Tests4J_JSE_v1_7_DependencyGroup INSTANCE = new Tests4J_JSE_v1_7_DependencyGroup();
	
	private Tests4J_JSE_v1_7_DependencyGroup() {
		Set<String> names = new HashSet<String>();
		
		add(names, I_JSE_1_6_IO.class);
		add(names, I_JSE_1_7_Lang.class);
		add(names, I_JSE_1_6_LangAnnot.class);
		add(names, I_JSE_1_6_Log.class);
		add(names, I_JSE_1_6_Math.class);
		add(names, I_JSE_1_7_Sql.class);
		add(names, I_JSE_1_7_Util.class);
		
		
		names.addAll(Tests4J_JSE_v1_6_DependencyGroup.INSTANCE.getClassNames());
		
		super.setupDelegates(names);
	}
	
	private void add(Set<String> names, Class<?> c) {
		names.add(c.getName());
	}
}
