package org.adligo.tests4j_tests.models.shared.dependency_groups.gwt.v2_6;

import java.util.Set;

import org.adligo.tests4j.models.shared.dependency.I_ClassAttributes;
import org.adligo.tests4j.models.shared.dependency.I_MethodSignature;
import org.adligo.tests4j.models.shared.dependency.MethodSignature;
import org.adligo.tests4j.models.shared.dependency_groups.jse.JSE_Lang;
import org.adligo.tests4j.models.shared.trials.I_Trial;

public class GWT_2_6_AnnotDelegates extends GWT_2_6_LangDelegates {

	public GWT_2_6_AnnotDelegates(I_Trial p) {
		super(p);
	}

	public void delegateAnnotationFormatErrorMemberAsserts(I_ClassAttributes result) {
		delegateErrorMemberAsserts(result);
	}

	public void delegateAnnotationTypeMismatchExceptionMemberAsserts(I_ClassAttributes result) {
		delegateRuntimeExceptionMemberAsserts(result);
		Set<I_MethodSignature> ms = result.getMethods();
		assertContains(ms, new MethodSignature("foundType", 
			JSE_Lang.STRING));
		assertContains(ms, new MethodSignature("element", 
			"java.lang.reflect.Method"));
	}


	public void delegateIncompleteAnnotationExceptionMemberAsserts(I_ClassAttributes result) {
		delegateRuntimeExceptionMemberAsserts(result);
		Set<I_MethodSignature> ms = result.getMethods();
		assertContains(ms, new MethodSignature("annotationType", 
			JSE_Lang.CLASS));
		assertContains(ms, new MethodSignature("elementName", 
			JSE_Lang.STRING));
	}
}
