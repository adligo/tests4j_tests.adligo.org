package org.adligo.tests4j_tests.references_groups;

import java.util.HashSet;
import java.util.Set;

import org.adligo.tests4j.shared.xml.I_XML_Builder;
import org.adligo.tests4j.shared.xml.I_XML_Consumer;
import org.adligo.tests4j.shared.xml.I_XML_Producer;
import org.adligo.tests4j.shared.xml.XML_Builder;
import org.adligo.tests4j.shared.xml.XML_Chars;
import org.adligo.tests4j.shared.xml.XML_Parser;

/**
 * @diagram_sync with PackageDependencies.class on 10/1/1014
 * @author scott
 *
 */
public class Tests4J_XML_ReferenceGroup extends Tests4J_ReferenceGroup {
	public static final Tests4J_XML_ReferenceGroup INSTANCE = new Tests4J_XML_ReferenceGroup();
	
	private Tests4J_XML_ReferenceGroup() {
		Set<String> names = new HashSet<String>();
		
		add(names, I_XML_Builder.class);
		add(names, I_XML_Consumer.class);
		add(names, I_XML_Producer.class);
		
		add(names, XML_Builder.class);
		add(names, XML_Chars.class);
		add(names, XML_Parser.class);
		
		names.addAll(Tests4J_Common_ReferenceGroup.INSTANCE.getClassNames());
		
		setupDelegates(names);
	}
	
	private void add(Set<String> names, Class<?> c) {
		names.add(c.getName());
	}
}
