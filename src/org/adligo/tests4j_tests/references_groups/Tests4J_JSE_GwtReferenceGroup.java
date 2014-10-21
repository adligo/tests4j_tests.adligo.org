package org.adligo.tests4j_tests.references_groups;


public class Tests4J_JSE_GwtReferenceGroup extends Tests4J_ReferenceGroup {
	public static final Tests4J_JSE_GwtReferenceGroup INSTANCE = new Tests4J_JSE_GwtReferenceGroup();

	private Tests4J_JSE_GwtReferenceGroup() {
		super.setupDelegates(Tests4J_JSE_ReferenceGroup.INSTANCE.getClassNames());
	}
}
