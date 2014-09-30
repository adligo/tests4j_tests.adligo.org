package org.adligo.tests4j_tests.dependency_groups;

import java.util.HashSet;
import java.util.Set;

import org.adligo.tests4j.shared.xml.I_XML_Builder;
import org.adligo.tests4j.shared.xml.I_XML_Consumer;
import org.adligo.tests4j.shared.xml.I_XML_Producer;
import org.adligo.tests4j.shared.xml.XML_Builder;
import org.adligo.tests4j.shared.xml.XML_Chars;
import org.adligo.tests4j.shared.xml.XML_Parser;

public class Tests4J_XML_DependencyGroup extends Tests4J_DependencyGroup {
	public static final Tests4J_XML_DependencyGroup INSTANCE = new Tests4J_XML_DependencyGroup();
	
	private Tests4J_XML_DependencyGroup() {
		Set<String> names = new HashSet<String>();
		
		add(names, I_XML_Builder.class);
		add(names, I_XML_Consumer.class);
		add(names, I_XML_Producer.class);
		
		add(names, XML_Builder.class);
		add(names, XML_Chars.class);
		add(names, XML_Parser.class);
		
		names.addAll(Tests4J_Common_DependencyGroup.INSTANCE.getClassNames());
		
		setupDelegates(names);
	}
	
	private void add(Set<String> names, Class<?> c) {
		names.add(c.getName());
	}
}
