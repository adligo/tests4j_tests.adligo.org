package org.adligo.tests4j_tests.models.shared.dependency_groups.gwt.v2_6;

import java.util.Set;

import org.adligo.tests4j.models.shared.dependency.I_ClassAttributes;
import org.adligo.tests4j.models.shared.dependency.I_MethodSignature;
import org.adligo.tests4j.models.shared.dependency.MethodSignature;
import org.adligo.tests4j.models.shared.dependency_groups.jse.JSE_Lang;
import org.adligo.tests4j.models.shared.trials.I_Trial;

public class GWT_2_6_UtilDelegates extends GWT_2_6_LangDelegates {

	public GWT_2_6_UtilDelegates(I_Trial p) {
		super(p);
	}

	public void delegateConcurrentModificationExceptionMemberAsserts(I_ClassAttributes result) {
		delegateRuntimeExceptionMemberAsserts(result);
	}

	public void delegateEmptyStackExceptionMemberAsserts(I_ClassAttributes result) {
		delegateRuntimeExceptionMemberAsserts(result);
	}

	public void delegateMissingResourceExceptionMemberAsserts(I_ClassAttributes result) {
		delegateRuntimeExceptionMemberAsserts(result);
		Set<I_MethodSignature> ms = result.getMethods();
		assertContains(ms, new MethodSignature("getClassName", 
			JSE_Lang.STRING));
		assertContains(ms, new MethodSignature("getKey", 
			JSE_Lang.STRING));
	}

	public void delegateNoSuchElementExceptionMemberAsserts(I_ClassAttributes result) {
		delegateRuntimeExceptionMemberAsserts(result);
	}

	public void delegateTooManyListenersExceptionMemberAsserts(I_ClassAttributes result) {
		delegateExceptionMemberAsserts(result);
	}
}
