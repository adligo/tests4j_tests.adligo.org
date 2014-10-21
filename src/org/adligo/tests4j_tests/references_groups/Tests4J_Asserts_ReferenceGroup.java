package org.adligo.tests4j_tests.references_groups;

import java.util.HashSet;
import java.util.Set;

import org.adligo.tests4j.shared.asserts.AbstractAssertCommand;
import org.adligo.tests4j.shared.asserts.AbstractCompareAssertCommand;
import org.adligo.tests4j.shared.asserts.AssertionFailureLocation;
import org.adligo.tests4j.shared.asserts.AssertionProcessor;
import org.adligo.tests4j.shared.asserts.BooleanAssertCommand;
import org.adligo.tests4j.shared.asserts.ContainsAssertCommand;
import org.adligo.tests4j.shared.asserts.DoubleAssertCommand;
import org.adligo.tests4j.shared.asserts.IdenticalAssertCommand;
import org.adligo.tests4j.shared.asserts.IdenticalStringAssertCommand;
import org.adligo.tests4j.shared.asserts.ThrownAssertCommand;
import org.adligo.tests4j.shared.asserts.UniformAssertCommand;
import org.adligo.tests4j.shared.asserts.UniformThrownAssertCommand;

/**
 * @diagram_sync with PackageDependencies.class on 10/1/1014
 * @author scott
 *
 */
public class Tests4J_Asserts_ReferenceGroup extends Tests4J_ReferenceGroup {
	public static final Tests4J_Asserts_ReferenceGroup INSTANCE = new Tests4J_Asserts_ReferenceGroup();
	
	private Tests4J_Asserts_ReferenceGroup() {
		Set<String> names = new HashSet<String>();
		
		add(names, AbstractAssertCommand.class);
		add(names, AbstractCompareAssertCommand.class);
		add(names, AssertionFailureLocation.class);
		add(names, AssertionProcessor.class);
		
		add(names, BooleanAssertCommand.class);
		
		add(names, ContainsAssertCommand.class);
		
		add(names, DoubleAssertCommand.class);
		
		add(names, IdenticalAssertCommand.class);
		add(names, IdenticalStringAssertCommand.class);
		
		add(names, ThrownAssertCommand.class);
		
		add(names, UniformAssertCommand.class);
		add(names, UniformThrownAssertCommand.class);
		
		
		//note if you get a NoSuchFieldError here,
		// it could be because your running different 
		// class versions
		
		names.addAll(Tests4J_AssertsUniform_ReferenceGroup.INSTANCE.getClassNames());
		names.addAll(Tests4J_AssertsReference_ReferenceGroup.INSTANCE.getClassNames());
		
		setupDelegates(names);
	}
	
	private void add(Set<String> names, Class<?> c) {
		names.add(c.getName());
	}
}
