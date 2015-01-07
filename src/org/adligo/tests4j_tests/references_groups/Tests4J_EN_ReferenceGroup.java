package org.adligo.tests4j_tests.references_groups;

import org.adligo.tests4j.shared.common.Tests4J_Constants;
import org.adligo.tests4j.shared.en.Tests4J_AnnotationMessages;
import org.adligo.tests4j.shared.en.Tests4J_AssertionInputMessages;
import org.adligo.tests4j.shared.en.Tests4J_EclipseErrors;
import org.adligo.tests4j.shared.en.Tests4J_EnglishConstants;
import org.adligo.tests4j.shared.en.Tests4J_LineDiffTextDisplayMessages;
import org.adligo.tests4j.shared.en.Tests4J_LogMessages;
import org.adligo.tests4j.shared.en.Tests4J_ParamsReaderMessages;
import org.adligo.tests4j.shared.en.Tests4J_ReportMessages;
import org.adligo.tests4j.shared.en.Tests4J_ResultMessages;

import java.util.HashSet;
import java.util.Set;

/**
 * @diagram_sync with PackageDependencies.class on 10/1/1014
 * @author scott
 *
 */
public class Tests4J_EN_ReferenceGroup extends Tests4J_ReferenceGroup {
	public static final Tests4J_EN_ReferenceGroup INSTANCE = new Tests4J_EN_ReferenceGroup();
	
	private Tests4J_EN_ReferenceGroup() {
		Set<String> names = new HashSet<String>();
		
		add(names, Tests4J_AnnotationMessages.class);
		add(names, Tests4J_AssertionInputMessages.class);
		add(names, Tests4J_Constants.class);
		add(names, Tests4J_EnglishConstants.class);
		add(names, Tests4J_EclipseErrors.class);
		add(names, Tests4J_LineDiffTextDisplayMessages.class);
		add(names, Tests4J_LogMessages.class);
		add(names, Tests4J_ParamsReaderMessages.class);
		add(names, Tests4J_ReportMessages.class);
		add(names, Tests4J_ResultMessages.class);
		
		names.addAll(Tests4J_I18N_GwtReferenceGroup.INSTANCE.getClassNames());
		
		setupDelegates(names);
	}
	
	private void add(Set<String> names, Class<?> c) {
		names.add(c.getName());
	}
}
