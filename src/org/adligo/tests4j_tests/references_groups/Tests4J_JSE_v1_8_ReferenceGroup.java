package org.adligo.tests4j_tests.references_groups;

import java.util.HashSet;
import java.util.Set;

import org.adligo.tests4j.models.shared.reference_groups.jse.v1_8.I_JSE_1_8_IO;
import org.adligo.tests4j.models.shared.reference_groups.jse.v1_8.I_JSE_1_8_Lang;
import org.adligo.tests4j.models.shared.reference_groups.jse.v1_8.I_JSE_1_8_LangAnnot;
import org.adligo.tests4j.models.shared.reference_groups.jse.v1_8.I_JSE_1_8_Log;
import org.adligo.tests4j.models.shared.reference_groups.jse.v1_8.I_JSE_1_8_Math;
import org.adligo.tests4j.models.shared.reference_groups.jse.v1_8.I_JSE_1_8_Sql;
import org.adligo.tests4j.models.shared.reference_groups.jse.v1_8.I_JSE_1_8_Util;

public class Tests4J_JSE_v1_8_ReferenceGroup extends Tests4J_ReferenceGroup {
	public static final Tests4J_JSE_v1_8_ReferenceGroup INSTANCE = new Tests4J_JSE_v1_8_ReferenceGroup();
	
	private Tests4J_JSE_v1_8_ReferenceGroup() {
		Set<String> names = new HashSet<String>();
		
		add(names, I_JSE_1_8_IO.class);
		add(names, I_JSE_1_8_Lang.class);
		add(names, I_JSE_1_8_LangAnnot.class);
		add(names, I_JSE_1_8_Log.class);
		
		
		add(names, I_JSE_1_8_Math.class);
		add(names, I_JSE_1_8_Sql.class);
		add(names, I_JSE_1_8_Util.class);
		
		names.addAll(Tests4J_JSE_v1_7_ReferenceGroup.INSTANCE.getClassNames());
		
		super.setupDelegates(names);
	}
	
	private void add(Set<String> names, Class<?> c) {
		names.add(c.getName());
	}
}
