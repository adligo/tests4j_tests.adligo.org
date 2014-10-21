package org.adligo.tests4j_tests.references_groups;


public class Tests4J_EN_GwtReferenceGroup extends Tests4J_ReferenceGroupGwt {
	public static final Tests4J_EN_GwtReferenceGroup INSTANCE = new Tests4J_EN_GwtReferenceGroup();
	
	private Tests4J_EN_GwtReferenceGroup() {
		super.setupDelegates(Tests4J_EN_ReferenceGroup.INSTANCE.getClassNames());
	}
}
