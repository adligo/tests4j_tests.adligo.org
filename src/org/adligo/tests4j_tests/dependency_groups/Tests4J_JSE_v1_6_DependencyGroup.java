package org.adligo.tests4j_tests.dependency_groups;

import java.util.HashSet;
import java.util.Set;

import org.adligo.tests4j.models.shared.dependency_groups.jse.v1_6.I_JSE_1_6_IO;
import org.adligo.tests4j.models.shared.dependency_groups.jse.v1_6.I_JSE_1_6_Lang;
import org.adligo.tests4j.models.shared.dependency_groups.jse.v1_6.I_JSE_1_6_LangAnnot;
import org.adligo.tests4j.models.shared.dependency_groups.jse.v1_6.I_JSE_1_6_Log;
import org.adligo.tests4j.models.shared.dependency_groups.jse.v1_6.I_JSE_1_6_Math;
import org.adligo.tests4j.models.shared.dependency_groups.jse.v1_6.I_JSE_1_6_Sql;
import org.adligo.tests4j.models.shared.dependency_groups.jse.v1_6.I_JSE_1_6_Util;
import org.adligo.tests4j.models.shared.dependency_groups.jse.v1_6.JSE_1_6_IO;
import org.adligo.tests4j.models.shared.dependency_groups.jse.v1_6.JSE_1_6_Lang;
import org.adligo.tests4j.models.shared.dependency_groups.jse.v1_6.JSE_1_6_LangAnnot;
import org.adligo.tests4j.models.shared.dependency_groups.jse.v1_6.JSE_1_6_Log;
import org.adligo.tests4j.models.shared.dependency_groups.jse.v1_6.JSE_1_6_Math;
import org.adligo.tests4j.models.shared.dependency_groups.jse.v1_6.JSE_1_6_Sql;
import org.adligo.tests4j.models.shared.dependency_groups.jse.v1_6.JSE_1_6_Util;
import org.adligo.tests4j.shared.asserts.dependency.NameOnlyDependencyGroup;

public class Tests4J_JSE_v1_6_DependencyGroup extends Tests4J_DependencyGroup {
	public static final Tests4J_JSE_v1_6_DependencyGroup INSTANCE = new Tests4J_JSE_v1_6_DependencyGroup();
	
	private Tests4J_JSE_v1_6_DependencyGroup() {
		Set<String> names = new HashSet<String>();
		
		add(names, I_JSE_1_6_IO.class);
		add(names, I_JSE_1_6_Lang.class);
		add(names, I_JSE_1_6_LangAnnot.class);
		add(names, I_JSE_1_6_Log.class);
		add(names, I_JSE_1_6_Math.class);
		add(names, I_JSE_1_6_Sql.class);
		add(names, I_JSE_1_6_Util.class);
		
		add(names, JSE_1_6_IO.class);
		add(names, JSE_1_6_Lang.class);
		add(names, JSE_1_6_LangAnnot.class);
		add(names, JSE_1_6_Log.class);
		add(names, JSE_1_6_Math.class);
		add(names, JSE_1_6_Sql.class);
		add(names, JSE_1_6_Util.class);
		
		names.addAll(Tests4J_Dependency_DependencyGroup.INSTANCE.getClassNames());
		super.setDelegate(new NameOnlyDependencyGroup(names));
	}
	
	private void add(Set<String> names, Class<?> c) {
		names.add(c.getName());
	}
}
