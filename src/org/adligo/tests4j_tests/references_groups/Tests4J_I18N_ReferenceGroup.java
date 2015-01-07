package org.adligo.tests4j_tests.references_groups;

import org.adligo.tests4j.models.shared.reference_groups.jse.JSE_Lang;
import org.adligo.tests4j.models.shared.reference_groups.jse.JSE_LangAnnot;
import org.adligo.tests4j.models.shared.reference_groups.jse.JSE_Math;
import org.adligo.tests4j.models.shared.reference_groups.jse.JSE_Util;
import org.adligo.tests4j.shared.i18n.I_Tests4J_AnnotationMessages;
import org.adligo.tests4j.shared.i18n.I_Tests4J_AssertionInputMessages;
import org.adligo.tests4j.shared.i18n.I_Tests4J_Constants;
import org.adligo.tests4j.shared.i18n.I_Tests4J_EclipseErrors;
import org.adligo.tests4j.shared.i18n.I_Tests4J_LineDiffTextDisplayMessages;
import org.adligo.tests4j.shared.i18n.I_Tests4J_LogMessages;
import org.adligo.tests4j.shared.i18n.I_Tests4J_ParamsReaderMessages;
import org.adligo.tests4j.shared.i18n.I_Tests4J_ReportMessages;
import org.adligo.tests4j.shared.i18n.I_Tests4J_ResultMessages;

import java.util.HashSet;
import java.util.Set;

/**
 * @diagram_sync with PackageDependencies.class on 10/1/1014
 * 
 * @author scott
 *
 */
public class Tests4J_I18N_ReferenceGroup extends Tests4J_ReferenceGroup {
	public static final Tests4J_I18N_ReferenceGroup INSTANCE = new Tests4J_I18N_ReferenceGroup();
	
	private Tests4J_I18N_ReferenceGroup() {
		Set<String> names = new HashSet<String>();
		
		names.addAll(JSE_Lang.CLASS_NAMES);
    names.addAll(JSE_Util.CLASS_NAMES);
    names.addAll(JSE_Math.CLASS_NAMES);
    names.addAll(JSE_LangAnnot.CLASS_NAMES);
    //DO NOT ALLOW SQL or Logging!
    
		add(names, I_Tests4J_AnnotationMessages.class);
		add(names, I_Tests4J_AssertionInputMessages.class);
		add(names, I_Tests4J_Constants.class);
		add(names, I_Tests4J_EclipseErrors.class);
		add(names, I_Tests4J_LineDiffTextDisplayMessages.class);
		add(names, I_Tests4J_LogMessages.class);
		add(names, I_Tests4J_ParamsReaderMessages.class);
		add(names, I_Tests4J_ReportMessages.class);
		add(names, I_Tests4J_ResultMessages.class);
		super.setupDelegates(names);
	}
	
	private void add(Set<String> names, Class<?> c) {
		names.add(c.getName());
	}
}
