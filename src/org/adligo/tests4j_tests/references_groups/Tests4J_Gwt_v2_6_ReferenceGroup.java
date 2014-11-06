package org.adligo.tests4j_tests.references_groups;

import java.util.HashSet;
import java.util.Set;

import org.adligo.gwt_refs.v2_6.GWT_2_6_Annot;
import org.adligo.gwt_refs.v2_6.GWT_2_6_IO;
import org.adligo.gwt_refs.v2_6.GWT_2_6_Lang;
import org.adligo.gwt_refs.v2_6.GWT_2_6_Log;
import org.adligo.gwt_refs.v2_6.GWT_2_6_Math;
import org.adligo.gwt_refs.v2_6.GWT_2_6_SQL;
import org.adligo.gwt_refs.v2_6.GWT_2_6_Util;
import org.adligo.tests4j.models.shared.association.I_PackageConstantLookup;

public class Tests4J_Gwt_v2_6_ReferenceGroup extends Tests4J_ReferenceGroup {
	public static final Tests4J_Gwt_v2_6_ReferenceGroup INSTANCE = new Tests4J_Gwt_v2_6_ReferenceGroup();
	
	private Tests4J_Gwt_v2_6_ReferenceGroup() {
		Set<String> names = new HashSet<String>();
		
		add(names, I_PackageConstantLookup.class);
		
		add(names, GWT_2_6_Annot.class);
		add(names, GWT_2_6_IO.class);
		add(names, GWT_2_6_Lang.class);
		add(names, GWT_2_6_Log.class);
		add(names, GWT_2_6_Math.class);
		add(names, GWT_2_6_SQL.class);
		add(names, GWT_2_6_Util.class);
		
		names.addAll(Tests4J_Association_ReferenceGroup.INSTANCE.getClassNames());
				
		names.addAll(Tests4J_JSE_ReferenceGroup.INSTANCE.getClassNames());
		
		super.setupDelegates(names);
	}
	
	private void add(Set<String> names, Class<?> c) {
		names.add(c.getName());
	}
}
