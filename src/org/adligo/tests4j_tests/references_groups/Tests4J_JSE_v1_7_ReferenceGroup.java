package org.adligo.tests4j_tests.references_groups;

import org.adligo.tests4j.models.shared.reference_groups.jse.v1_7.I_JSE_1_7_IO;
import org.adligo.tests4j.models.shared.reference_groups.jse.v1_7.I_JSE_1_7_Lang;
import org.adligo.tests4j.models.shared.reference_groups.jse.v1_7.I_JSE_1_7_LangAnnot;
import org.adligo.tests4j.models.shared.reference_groups.jse.v1_7.I_JSE_1_7_Log;
import org.adligo.tests4j.models.shared.reference_groups.jse.v1_7.I_JSE_1_7_Math;
import org.adligo.tests4j.models.shared.reference_groups.jse.v1_7.I_JSE_1_7_NIO;
import org.adligo.tests4j.models.shared.reference_groups.jse.v1_7.I_JSE_1_7_NIOFile;
import org.adligo.tests4j.models.shared.reference_groups.jse.v1_7.I_JSE_1_7_Sql;
import org.adligo.tests4j.models.shared.reference_groups.jse.v1_7.I_JSE_1_7_Util;
import org.adligo.tests4j.models.shared.reference_groups.jse.v1_7.I_JSE_1_7_UtilConcurrent;
import org.adligo.tests4j.models.shared.reference_groups.jse.v1_7.I_JSE_1_7_XmlSax;
import org.adligo.tests4j.models.shared.reference_groups.jse.v1_7.I_JSE_1_7_XmlSaxExt;

import java.util.HashSet;
import java.util.Set;

public class Tests4J_JSE_v1_7_ReferenceGroup extends Tests4J_ReferenceGroup {
	public static final Tests4J_JSE_v1_7_ReferenceGroup INSTANCE = new Tests4J_JSE_v1_7_ReferenceGroup();
	
	private Tests4J_JSE_v1_7_ReferenceGroup() {
		Set<String> names = new HashSet<String>();
		
		
		add(names, I_JSE_1_7_IO.class);
		add(names, I_JSE_1_7_Lang.class);
		add(names, I_JSE_1_7_LangAnnot.class);
		add(names, I_JSE_1_7_Log.class);
		add(names, I_JSE_1_7_NIO.class);
		add(names, I_JSE_1_7_NIOFile.class);
		
		add(names, I_JSE_1_7_Math.class);
		add(names, I_JSE_1_7_Sql.class);
		add(names, I_JSE_1_7_Util.class);
		add(names, I_JSE_1_7_UtilConcurrent.class);
		
		add(names, I_JSE_1_7_XmlSax.class);
		add(names, I_JSE_1_7_XmlSaxExt.class);
		
		names.addAll(Tests4J_JSE_v1_6_ReferenceGroup.INSTANCE.getClassNames());
		
		super.setupDelegates(names);
	}
	
	private void add(Set<String> names, Class<?> c) {
		names.add(c.getName());
	}
}
