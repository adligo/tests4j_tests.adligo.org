package org.adligo.tests4j_tests.references_groups;

import java.util.HashSet;
import java.util.Set;

import org.adligo.tests4j.models.shared.association.I_PackageConstantLookup;
import org.adligo.tests4j.models.shared.reference_groups.jse.JSE_IO;
import org.adligo.tests4j.models.shared.reference_groups.jse.JSE_Lang;
import org.adligo.tests4j.models.shared.reference_groups.jse.JSE_LangAnnot;
import org.adligo.tests4j.models.shared.reference_groups.jse.JSE_Log;
import org.adligo.tests4j.models.shared.reference_groups.jse.JSE_Math;
import org.adligo.tests4j.models.shared.reference_groups.jse.JSE_Sql;
import org.adligo.tests4j.models.shared.reference_groups.jse.JSE_Util;

public class Tests4J_JSE_ReferenceGroup extends Tests4J_ReferenceGroup {
	public static final Tests4J_JSE_ReferenceGroup INSTANCE = new Tests4J_JSE_ReferenceGroup();
	
	private Tests4J_JSE_ReferenceGroup() {
		Set<String> names = new HashSet<String>();
		
		add(names, I_PackageConstantLookup.class);
		
		add(names, JSE_IO.class);
		add(names, JSE_Lang.class);
		add(names, JSE_LangAnnot.class);
		add(names, JSE_Log.class);
		add(names, JSE_Math.class);
		add(names, JSE_Sql.class);
		add(names, JSE_Util.class);
		
		names.addAll(Tests4J_JSE_v1_8_ReferenceGroup.INSTANCE.getClassNames());
		
		super.setupDelegates(names);
	}
	
	private void add(Set<String> names, Class<?> c) {
		names.add(c.getName());
	}
}
