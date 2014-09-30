package org.adligo.tests4j_tests.dependency_groups;

import java.util.HashSet;
import java.util.Set;

import org.adligo.tests4j.models.shared.dependency.I_PackageConstantLookup;
import org.adligo.tests4j.models.shared.dependency_groups.jse.JSE_IO;
import org.adligo.tests4j.models.shared.dependency_groups.jse.JSE_Lang;
import org.adligo.tests4j.models.shared.dependency_groups.jse.JSE_LangAnnot;
import org.adligo.tests4j.models.shared.dependency_groups.jse.JSE_Log;
import org.adligo.tests4j.models.shared.dependency_groups.jse.JSE_Math;
import org.adligo.tests4j.models.shared.dependency_groups.jse.JSE_Sql;
import org.adligo.tests4j.models.shared.dependency_groups.jse.JSE_Util;

public class Tests4J_JSE_DependencyGroup extends Tests4J_DependencyGroup {
	public static final Tests4J_JSE_DependencyGroup INSTANCE = new Tests4J_JSE_DependencyGroup();
	
	private Tests4J_JSE_DependencyGroup() {
		Set<String> names = new HashSet<String>();
		
		add(names, I_PackageConstantLookup.class);
		
		add(names, JSE_IO.class);
		add(names, JSE_Lang.class);
		add(names, JSE_LangAnnot.class);
		add(names, JSE_Log.class);
		add(names, JSE_Math.class);
		add(names, JSE_Sql.class);
		add(names, JSE_Util.class);
		
		names.addAll(Tests4J_JSE_v1_8_DependencyGroup.INSTANCE.getClassNames());
		
		super.setupDelegates(names);
	}
	
	private void add(Set<String> names, Class<?> c) {
		names.add(c.getName());
	}
}
