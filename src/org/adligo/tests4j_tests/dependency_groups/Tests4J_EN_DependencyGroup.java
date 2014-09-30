package org.adligo.tests4j_tests.dependency_groups;

import java.util.HashSet;
import java.util.Set;

import org.adligo.tests4j.shared.common.Tests4J_Constants;
import org.adligo.tests4j.shared.en.Tests4J_AnnotationMessages;
import org.adligo.tests4j.shared.en.Tests4J_AssertionInputMessages;
import org.adligo.tests4j.shared.en.Tests4J_EclipseErrors;
import org.adligo.tests4j.shared.en.Tests4J_EnglishConstants;
import org.adligo.tests4j.shared.en.Tests4J_LineDiffTextDisplayMessages;
import org.adligo.tests4j.shared.en.Tests4J_ParamsReaderMessages;
import org.adligo.tests4j.shared.en.Tests4J_ReportMessages;
import org.adligo.tests4j.shared.en.Tests4J_ResultMessages;

public class Tests4J_EN_DependencyGroup extends Tests4J_DependencyGroup {
	public static final Tests4J_EN_DependencyGroup INSTANCE = new Tests4J_EN_DependencyGroup();
	
	private Tests4J_EN_DependencyGroup() {
		Set<String> names = new HashSet<String>();
		
		add(names, Tests4J_AnnotationMessages.class);
		add(names, Tests4J_AssertionInputMessages.class);
		add(names, Tests4J_Constants.class);
		add(names, Tests4J_EnglishConstants.class);
		add(names, Tests4J_EclipseErrors.class);
		add(names, Tests4J_LineDiffTextDisplayMessages.class);
		add(names, Tests4J_ParamsReaderMessages.class);
		add(names, Tests4J_ReportMessages.class);
		add(names, Tests4J_ResultMessages.class);
		
		names.addAll(Tests4J_I18N_DependencyGroup.INSTANCE.getClassNames());
		
		setupDelegates(names);
	}
	
	private void add(Set<String> names, Class<?> c) {
		names.add(c.getName());
	}
}
