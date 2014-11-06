package org.adligo.tests4j_tests.references_groups;

import java.util.ArrayList;
import java.util.List;

import org.adligo.gwt_refs.GWT_ReferenceGroup;
import org.adligo.tests4j.shared.asserts.reference.I_ReferenceGroup;
import org.adligo.tests4j.shared.asserts.reference.ReferenceGroupAggregate;
import org.adligo.tests4j.shared.asserts.reference.ReferenceGroupBaseDelegate;

/**
 * this is a little different because we 
 * need to allow the SQL and Logging classes
 * that are in GWT so we want them for the canned
 * dependency, however we don't want them actually 
 * used anywhere else in tests4j.
 * 
 * @author scott
 *
 */
public class Tests4J_Gwt_GwtReferenceGroup extends ReferenceGroupBaseDelegate {
	public static final Tests4J_Gwt_GwtReferenceGroup INSTANCE = new Tests4J_Gwt_GwtReferenceGroup();
	
	private Tests4J_Gwt_GwtReferenceGroup() {
		List<I_ReferenceGroup> groups = new ArrayList<I_ReferenceGroup>();
		groups.add(Tests4J_Gwt_ReferenceGroup.INSTANCE);
		groups.add(GWT_ReferenceGroup.INSTANCE);
		ReferenceGroupAggregate dga = new ReferenceGroupAggregate(groups);
		super.setDelegate(dga);
	}
}
