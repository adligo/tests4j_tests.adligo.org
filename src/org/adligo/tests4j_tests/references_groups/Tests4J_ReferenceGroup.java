package org.adligo.tests4j_tests.references_groups;

import org.adligo.tests4j.models.shared.reference_groups.jse.JSE_Lang;
import org.adligo.tests4j.models.shared.reference_groups.jse.JSE_LangAnnot;
import org.adligo.tests4j.models.shared.reference_groups.jse.JSE_Math;
import org.adligo.tests4j.models.shared.reference_groups.jse.JSE_Util;
import org.adligo.tests4j.shared.asserts.reference.NameOnlyReferenceGroup;
import org.adligo.tests4j.shared.asserts.reference.ReferenceGroupBaseDelegate;

import java.util.Set;

/**
 * base class for tests4j dependency groups outside of GWT,
 * 
 * @author scott
 *
 */
public class Tests4J_ReferenceGroup extends ReferenceGroupBaseDelegate {
	public static final Tests4J_ReferenceGroup INSTANCE = new Tests4J_ReferenceGroup();
	
	protected Tests4J_ReferenceGroup() {}
	
	protected void setupDelegates(Set<String> names) {
	  
		NameOnlyReferenceGroup dga = new NameOnlyReferenceGroup(names);
		super.setDelegate(dga);
	}
	
}
