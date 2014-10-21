package org.adligo.tests4j_tests.references_groups;


public class Tests4J_Coverage_GwtReferenceGroup extends Tests4J_ReferenceGroupGwt {
	public static final Tests4J_Coverage_GwtReferenceGroup INSTANCE = new Tests4J_Coverage_GwtReferenceGroup();
	
	private Tests4J_Coverage_GwtReferenceGroup() {
		super.setupDelegates(Tests4J_Coverage_ReferenceGroup.INSTANCE.getClassNames());
	}
}
