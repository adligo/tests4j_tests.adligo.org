package org.adligo.tests4j_tests.references_groups;

import org.adligo.tests4j.run.xml.io.use_cases.v1_0.ObjectFactory;
import org.adligo.tests4j.run.xml.io.use_cases.v1_0.SystemUseCasesType;
import org.adligo.tests4j.run.xml.io.use_cases.v1_0.UseCaseNameType;
import org.adligo.tests4j.run.xml.io.use_cases.v1_0.UseCaseType;

import java.util.HashSet;
import java.util.Set;

/**
 * @diagram_sync with PackageDependencies.class on 10/1/1014
 * @author scott
 *
 */
public class Tests4J_XmlUseCases_ReferenceGroup extends Tests4J_ReferenceGroup {
	public static final Tests4J_XmlUseCases_ReferenceGroup INSTANCE = new Tests4J_XmlUseCases_ReferenceGroup();
	
	private Tests4J_XmlUseCases_ReferenceGroup() {
		Set<String> names = new HashSet<String>();
		
		add(names, ObjectFactory.class);
		names.add("org.adligo.tests4j.run.xml.io.use_cases.v1_0.package-info");
		add(names, SystemUseCasesType.class);
		
		add(names, UseCaseNameType.class);
		add(names, UseCaseType.class);
		
		names.addAll(Tests4J_JaxB_ReferenceGroup.INSTANCE.getClassNames());
		
		setupDelegates(names);
	}
	
	private void add(Set<String> names, Class<?> c) {
		names.add(c.getName());
	}
}
