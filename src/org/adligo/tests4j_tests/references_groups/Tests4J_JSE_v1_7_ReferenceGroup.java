package org.adligo.tests4j_tests.references_groups;

import java.util.HashSet;
import java.util.Set;

import org.adligo.tests4j.models.shared.reference_groups.jse.v1_7.I_JSE_1_7_IO;
import org.adligo.tests4j.models.shared.reference_groups.jse.v1_7.I_JSE_1_7_Lang;
import org.adligo.tests4j.models.shared.reference_groups.jse.v1_7.I_JSE_1_7_LangAnnot;
import org.adligo.tests4j.models.shared.reference_groups.jse.v1_7.I_JSE_1_7_Log;
import org.adligo.tests4j.models.shared.reference_groups.jse.v1_7.I_JSE_1_7_Math;
import org.adligo.tests4j.models.shared.reference_groups.jse.v1_7.I_JSE_1_7_Sql;
import org.adligo.tests4j.models.shared.reference_groups.jse.v1_7.I_JSE_1_7_Util;
import org.adligo.tests4j.models.shared.reference_groups.jse.v1_7.I_JSE_1_7_UtilConcurrent;

public class Tests4J_JSE_v1_7_ReferenceGroup extends Tests4J_ReferenceGroup {
	public static final Tests4J_JSE_v1_7_ReferenceGroup INSTANCE = new Tests4J_JSE_v1_7_ReferenceGroup();
	
	private Tests4J_JSE_v1_7_ReferenceGroup() {
		Set<String> names = new HashSet<String>();
		
		add(names, I_JSE_1_7_IO.class);
		add(names, I_JSE_1_7_Lang.class);
		add(names, I_JSE_1_7_LangAnnot.class);
		add(names, I_JSE_1_7_Log.class);
		add(names, I_JSE_1_7_Math.class);
		add(names, I_JSE_1_7_Sql.class);
		add(names, I_JSE_1_7_Util.class);
		add(names, I_JSE_1_7_UtilConcurrent.class);
		
		names.addAll(Tests4J_JSE_v1_6_ReferenceGroup.INSTANCE.getClassNames());
		
		super.setupDelegates(names);
	}
	
	private void add(Set<String> names, Class<?> c) {
		names.add(c.getName());
	}
}
