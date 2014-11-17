package org.adligo.tests4j_tests.references_groups;

import org.adligo.tests4j.models.shared.reference_groups.jse.JSE_Lang;
import org.adligo.tests4j.models.shared.reference_groups.jse.JSE_LangAnnot;
import org.adligo.tests4j.models.shared.reference_groups.jse.JSE_Math;
import org.adligo.tests4j.models.shared.reference_groups.jse.JSE_Util;

import java.util.HashSet;
import java.util.Set;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.bind.annotation.XmlSchema;
import javax.xml.bind.annotation.XmlType;
import javax.xml.namespace.QName;

/**
 * @diagram_sync with PackageDependencies.class on 10/1/1014
 * @author scott
 *
 */
public class Tests4J_JaxB_ReferenceGroup extends Tests4J_ReferenceGroup {
	public static final Tests4J_JaxB_ReferenceGroup INSTANCE = new Tests4J_JaxB_ReferenceGroup();
	
	private Tests4J_JaxB_ReferenceGroup() {
		Set<String> names = new HashSet<String>();
		
    names.addAll(JSE_Lang.CLASS_NAMES);
    names.addAll(JSE_Util.CLASS_NAMES);
    names.addAll(JSE_Math.CLASS_NAMES);
    names.addAll(JSE_LangAnnot.CLASS_NAMES);
    
		add(names, JAXBElement.class);
		add(names, XmlElementDecl.class);
		add(names, XmlRegistry.class);
		add(names, QName.class);
		add(names, XmlSchema.class);
		
		add(names, XmlAccessType.class);
		add(names, XmlAccessorType.class);
		add(names, XmlAttribute.class);
		add(names, XmlElement.class);
		add(names, XmlType.class);
		
		setupDelegates(names);
	}
	
	private void add(Set<String> names, Class<?> c) {
		names.add(c.getName());
	}
}
