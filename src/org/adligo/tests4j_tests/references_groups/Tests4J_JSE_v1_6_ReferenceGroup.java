package org.adligo.tests4j_tests.references_groups;

import org.adligo.tests4j.models.shared.reference_groups.jse.v1_6.I_JSE_1_6_IO;
import org.adligo.tests4j.models.shared.reference_groups.jse.v1_6.I_JSE_1_6_Lang;
import org.adligo.tests4j.models.shared.reference_groups.jse.v1_6.I_JSE_1_6_LangAnnot;
import org.adligo.tests4j.models.shared.reference_groups.jse.v1_6.I_JSE_1_6_Log;
import org.adligo.tests4j.models.shared.reference_groups.jse.v1_6.I_JSE_1_6_Math;
import org.adligo.tests4j.models.shared.reference_groups.jse.v1_6.I_JSE_1_6_NIO;
import org.adligo.tests4j.models.shared.reference_groups.jse.v1_6.I_JSE_1_6_Sql;
import org.adligo.tests4j.models.shared.reference_groups.jse.v1_6.I_JSE_1_6_Util;
import org.adligo.tests4j.models.shared.reference_groups.jse.v1_6.I_JSE_1_6_UtilConcurrent;
import org.adligo.tests4j.models.shared.reference_groups.jse.v1_6.I_JSE_1_6_XmlSax;
import org.adligo.tests4j.models.shared.reference_groups.jse.v1_6.I_JSE_1_6_XmlSaxExt;
import org.adligo.tests4j.models.shared.reference_groups.jse.v1_6.JSE_1_6_IO;
import org.adligo.tests4j.models.shared.reference_groups.jse.v1_6.JSE_1_6_Lang;
import org.adligo.tests4j.models.shared.reference_groups.jse.v1_6.JSE_1_6_LangAnnot;
import org.adligo.tests4j.models.shared.reference_groups.jse.v1_6.JSE_1_6_Log;
import org.adligo.tests4j.models.shared.reference_groups.jse.v1_6.JSE_1_6_Math;
import org.adligo.tests4j.models.shared.reference_groups.jse.v1_6.JSE_1_6_NIO;
import org.adligo.tests4j.models.shared.reference_groups.jse.v1_6.JSE_1_6_Sql;
import org.adligo.tests4j.models.shared.reference_groups.jse.v1_6.JSE_1_6_Util;
import org.adligo.tests4j.models.shared.reference_groups.jse.v1_6.JSE_1_6_UtilConcurrent;
import org.adligo.tests4j.models.shared.reference_groups.jse.v1_6.JSE_1_6_XmlSax;
import org.adligo.tests4j.models.shared.reference_groups.jse.v1_6.JSE_1_6_XmlSaxExt;

import java.util.HashSet;
import java.util.Set;

public class Tests4J_JSE_v1_6_ReferenceGroup extends Tests4J_ReferenceGroup {
	public static final Tests4J_JSE_v1_6_ReferenceGroup INSTANCE = new Tests4J_JSE_v1_6_ReferenceGroup();
	
	private Tests4J_JSE_v1_6_ReferenceGroup() {
		Set<String> names = new HashSet<String>();
		
		add(names, I_JSE_1_6_IO.class);
		add(names, I_JSE_1_6_Lang.class);
		add(names, I_JSE_1_6_LangAnnot.class);
		add(names, I_JSE_1_6_Log.class);
		
		add(names, I_JSE_1_6_Math.class);
		add(names, I_JSE_1_6_NIO.class);
		
		add(names, I_JSE_1_6_Sql.class);
		add(names, I_JSE_1_6_Util.class);
		add(names, I_JSE_1_6_UtilConcurrent.class);
		add(names, I_JSE_1_6_XmlSax.class);
		add(names, I_JSE_1_6_XmlSaxExt.class);
		
		add(names, JSE_1_6_IO.class);
		add(names, JSE_1_6_Lang.class);
		add(names, JSE_1_6_LangAnnot.class);
		add(names, JSE_1_6_Log.class);
		add(names, JSE_1_6_Math.class);
		add(names, JSE_1_6_NIO.class);
		add(names, JSE_1_6_Sql.class);
		add(names, JSE_1_6_Util.class);
		add(names, JSE_1_6_UtilConcurrent.class);
		add(names, JSE_1_6_XmlSax.class);
		add(names, JSE_1_6_XmlSaxExt.class);
		
		names.addAll(Tests4J_Association_ReferenceGroup.INSTANCE.getClassNames());
		super.setupDelegates(names);
	}
	
	private void add(Set<String> names, Class<?> c) {
		names.add(c.getName());
	}
}
