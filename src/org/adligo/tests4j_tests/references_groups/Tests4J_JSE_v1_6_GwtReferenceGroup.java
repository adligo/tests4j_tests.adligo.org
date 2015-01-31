package org.adligo.tests4j_tests.references_groups;


/**
 * This class limits allowed references
 * to the GWT specific classes and methods,
 * including the tests4j classes in
 * org.adligo.tests4j.models.shared.reference_groups.jse.v1_6
 * and it's dependent packages.
 * @author scott
 *
 */
public class Tests4J_JSE_v1_6_GwtReferenceGroup extends Tests4J_ReferenceGroupGwt {
	public static final Tests4J_JSE_v1_6_GwtReferenceGroup INSTANCE = new Tests4J_JSE_v1_6_GwtReferenceGroup();
	
	private Tests4J_JSE_v1_6_GwtReferenceGroup() {
		super.setupDelegates(Tests4J_JSE_v1_6_ReferenceGroup.INSTANCE.getClassNames());
	}
}
