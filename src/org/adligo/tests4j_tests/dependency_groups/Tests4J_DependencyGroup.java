package org.adligo.tests4j_tests.dependency_groups;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.adligo.tests4j.shared.asserts.dependency.DependencyGroupAggregate;
import org.adligo.tests4j.shared.asserts.dependency.DependencyGroupBaseDelegate;
import org.adligo.tests4j.shared.asserts.dependency.I_DependencyGroup;
import org.adligo.tests4j.shared.asserts.dependency.NameOnlyDependencyGroup;

/**
 * base class for Tests4J_DependencyGroups,
 * 
 * @author scott
 *
 */
public class Tests4J_DependencyGroup extends DependencyGroupBaseDelegate {
	public static final Tests4J_DependencyGroup INSTANCE = new Tests4J_DependencyGroup();
	
	protected Tests4J_DependencyGroup() {}
	
	protected void setupDelegates(Set<String> names) {
		List<I_DependencyGroup> groups = new ArrayList<I_DependencyGroup>();
		groups.add(new NameOnlyDependencyGroup(names));
		groups.add(new AdligoGWT_DependencyGroup());
		DependencyGroupAggregate dga = new DependencyGroupAggregate(groups);
		super.setDelegate(dga);
	}
}
