package org.adligo.tests4j_tests.references_groups;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.adligo.tests4j.shared.asserts.reference.I_ReferenceGroup;
import org.adligo.tests4j.shared.asserts.reference.NameOnlyReferenceGroup;
import org.adligo.tests4j.shared.asserts.reference.ReferenceGroupAggregate;
import org.adligo.tests4j.shared.asserts.reference.ReferenceGroupBaseDelegate;

/**
 * the basis of the gwt compatible classes in tests4j
 * @author scott
 *
 */
public class Tests4J_ReferenceGroupGwt extends ReferenceGroupBaseDelegate {
	public static final Tests4J_ReferenceGroupGwt INSTANCE = new Tests4J_ReferenceGroupGwt();
	
	protected Tests4J_ReferenceGroupGwt() {}
	
	protected void setupDelegates(Set<String> names) {
		
		List<I_ReferenceGroup> groups = new ArrayList<I_ReferenceGroup>();
		groups.add(new NameOnlyReferenceGroup(names));
		groups.add(new AdligoGWT_ReferenceGroup());
		ReferenceGroupAggregate dga = new ReferenceGroupAggregate(groups);
		super.setDelegate(dga);
	}
}
