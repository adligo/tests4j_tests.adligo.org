package org.adligo.tests4j_tests.models.dependency_groups.gwt.v2_6;

import org.adligo.tests4j.models.shared.dependency.I_ClassAttributes;
import org.adligo.tests4j.models.shared.trials.I_Trial;

public class GWT_2_6_IODelegates extends GWT_2_6_LangDelegates {

	public GWT_2_6_IODelegates(I_Trial p) {
		super(p);
	}


	public void delegateIOExceptionMemberAsserts(I_ClassAttributes result) {
		delegateExceptionMemberAsserts(result);
	}

	public void delegateUnsupportedEncodingExceptionMemberAsserts(I_ClassAttributes result) {
		delegateIOExceptionMemberAsserts(result);
	}
}
