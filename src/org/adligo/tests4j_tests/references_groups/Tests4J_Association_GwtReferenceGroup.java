package org.adligo.tests4j_tests.references_groups;


public class Tests4J_Association_GwtReferenceGroup extends Tests4J_ReferenceGroupGwt {
	public static final Tests4J_Association_GwtReferenceGroup INSTANCE = new Tests4J_Association_GwtReferenceGroup();
	
	private Tests4J_Association_GwtReferenceGroup() {
		super.setupDelegates(Tests4J_Association_ReferenceGroup.INSTANCE.getClassNames());
	}
}
