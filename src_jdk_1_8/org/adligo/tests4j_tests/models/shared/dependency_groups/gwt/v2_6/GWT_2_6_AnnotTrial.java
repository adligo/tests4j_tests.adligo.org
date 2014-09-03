package org.adligo.tests4j_tests.models.shared.dependency_groups.gwt.v2_6;

import java.util.Set;

import org.adligo.tests4j.models.shared.dependency.I_ClassAttributes;
import org.adligo.tests4j.models.shared.dependency.I_FieldSignature;
import org.adligo.tests4j.models.shared.dependency.I_MethodSignature;
import org.adligo.tests4j.models.shared.dependency.MethodSignature;
import org.adligo.tests4j.models.shared.dependency_groups.gwt.GWT_2_6_Annot;
import org.adligo.tests4j.models.shared.dependency_groups.gwt.GWT_2_6_Lang;
import org.adligo.tests4j.models.shared.dependency_groups.jse.JSE_Lang;
import org.adligo.tests4j.models.shared.trials.SourceFileScope;
import org.adligo.tests4j.models.shared.trials.Test;
import org.adligo.tests4j_tests.base_trials.I_CountType;
import org.adligo.tests4j_tests.base_trials.SourceFileCountingTrial;

//try to keep coverage above 10 for the 0.1 release
@SourceFileScope (sourceClass=GWT_2_6_Annot.class, minCoverage=97.0)
public class GWT_2_6_AnnotTrial extends SourceFileCountingTrial {
	private GWT_2_6_AnnotDelegates delegates;
	
	public GWT_2_6_AnnotTrial() {
		delegates = new GWT_2_6_AnnotDelegates(this);
	}
	
	@Test
	public void testIncompleteAnnotationException() {
		I_ClassAttributes result = GWT_2_6_Annot.getIncompleteAnnotationException();
		assertEquals("java.lang.annotation.IncompleteAnnotationException", result.getName());
		Set<I_FieldSignature> fs = result.getFields();
		Set<I_MethodSignature> ms = result.getMethods();
		assertContains(ms, new MethodSignature("<init>", 
			new String[] {JSE_Lang.CLASS, JSE_Lang.STRING}));
		delegates.delegateIncompleteAnnotationExceptionMemberAsserts(result);
		assertEquals(0, fs.size());
		assertEquals(19, ms.size());
	}

	
	@Test
	public void testAnnotationFormatError() {
		I_ClassAttributes result = GWT_2_6_Annot.getAnnotationFormatError();
		assertEquals("java.lang.annotation.AnnotationFormatError", result.getName());
		Set<I_FieldSignature> fs = result.getFields();
		Set<I_MethodSignature> ms = result.getMethods();
		delegates.delegateAnnotationFormatErrorMemberAsserts(result);
		assertEquals(0, fs.size());
		assertEquals(15, ms.size());
	}

	@Test
	public void testAnnotationTypeMismatchException() {
		I_ClassAttributes result = GWT_2_6_Annot.getAnnotationTypeMismatchException();
		assertEquals("java.lang.annotation.AnnotationTypeMismatchException", result.getName());
		Set<I_FieldSignature> fs = result.getFields();
		Set<I_MethodSignature> ms = result.getMethods();
	
		delegates.delegateAnnotationTypeMismatchExceptionMemberAsserts(result);
		assertEquals(0, fs.size());
		assertEquals(17, ms.size());
	}

	@Override
	public int getTests(I_CountType type) {
		return super.getTests(type, 3);
	}

	@Override
	public int getAsserts(I_CountType type) {
		int thisAsserts = 68;
		if (type.isFromMetaWithCoverage()) {
			//code coverage and circular dependencies +
			//custom afterTrialTests
			return super.getAsserts(type, thisAsserts + 2);
		} else {
			return super.getAsserts(type, thisAsserts);
		}
	}

	@Override
	public int getUniqueAsserts(I_CountType type) {
		int thisUniqueAsserts = 65;
		if (type.isFromMetaWithCoverage()) {
			//code coverage and circular dependencies +
			//custom afterTrialTests
			return super.getUniqueAsserts(type, thisUniqueAsserts + 2);
		}  else {
			return super.getUniqueAsserts(type, thisUniqueAsserts);
		}
	}
}
