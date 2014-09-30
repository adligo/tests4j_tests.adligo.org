package org.adligo.tests4j_tests.dependency_groups;

import java.util.HashSet;
import java.util.Set;

import org.adligo.tests4j.models.shared.dependency_groups.jse.v1_8.I_JSE_1_8_Lang;

public class Tests4J_JSE_v1_8_DependencyGroup extends Tests4J_DependencyGroup {
	public static final Tests4J_JSE_v1_8_DependencyGroup INSTANCE = new Tests4J_JSE_v1_8_DependencyGroup();
	
	private Tests4J_JSE_v1_8_DependencyGroup() {
		Set<String> names = new HashSet<String>();
		
		add(names, I_JSE_1_8_Lang.class);
		
		names.addAll(Tests4J_JSE_v1_7_DependencyGroup.INSTANCE.getClassNames());
		
		super.setupDelegates(names);
	}
	
	private void add(Set<String> names, Class<?> c) {
		names.add(c.getName());
	}
}
