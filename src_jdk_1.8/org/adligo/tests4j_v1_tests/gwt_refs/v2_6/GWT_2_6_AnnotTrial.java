package org.adligo.tests4j_v1_tests.gwt_refs.v2_6;

import java.util.Set;

import org.adligo.gwt_refs.v2_6.GWT_2_6_Annot;
import org.adligo.tests4j.models.shared.reference_groups.jse.JSE_Lang;
import org.adligo.tests4j.shared.asserts.reference.AllowedReferences;
import org.adligo.tests4j.shared.asserts.reference.I_ClassAttributes;
import org.adligo.tests4j.shared.asserts.reference.I_FieldSignature;
import org.adligo.tests4j.shared.asserts.reference.I_MethodSignature;
import org.adligo.tests4j.shared.asserts.reference.MethodSignature;
import org.adligo.tests4j.system.shared.trials.SourceFileScope;
import org.adligo.tests4j.system.shared.trials.Test;
import org.adligo.tests4j_tests.base_trials.I_CountType;
import org.adligo.tests4j_tests.base_trials.SourceFileCountingTrial;
import org.adligo.tests4j_tests.references_groups.Tests4J_Gwt_v2_6_GwtReferenceGroup;

//try to keep coverage above 10 for the 0.1 release
@SourceFileScope (sourceClass=GWT_2_6_Annot.class, minCoverage=97.0)
@AllowedReferences (groups=Tests4J_Gwt_v2_6_GwtReferenceGroup.class)
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


	@Test
	public void testAnnotation() {
		I_ClassAttributes result = GWT_2_6_Annot.getAnnotation();
		assertEquals("java.lang.annotation.Annotation", result.getName());
		Set<I_FieldSignature> fs = result.getFields();
		Set<I_MethodSignature> ms = result.getMethods();
		delegates.delegateAnnotationMemberAsserts(result);
		assertEquals(0, fs.size());
		assertEquals(4, ms.size());
	}
	
	@Test
	public void testDocumented() {
		I_ClassAttributes result = GWT_2_6_Annot.getDocumented();
		assertEquals("java.lang.annotation.Documented", result.getName());
		Set<I_FieldSignature> fs = result.getFields();
		Set<I_MethodSignature> ms = result.getMethods();
		assertEquals(0, fs.size());
		assertEquals(0, ms.size());
	}
	
	@Test
	public void testElementType() {
		I_ClassAttributes result = GWT_2_6_Annot.getElementType();
		assertEquals("java.lang.annotation.ElementType", result.getName());
		Set<I_FieldSignature> fs = result.getFields();
		Set<I_MethodSignature> ms = result.getMethods();
		delegates.delegateElementTypeMemberAsserts(result);
		assertEquals(8, fs.size());
		assertEquals(11, ms.size());
	}
	
	@Test
	public void testInherited() {
		I_ClassAttributes result = GWT_2_6_Annot.getInherited();
		assertEquals("java.lang.annotation.Inherited", result.getName());
		Set<I_FieldSignature> fs = result.getFields();
		Set<I_MethodSignature> ms = result.getMethods();
		assertEquals(0, fs.size());
		assertEquals(0, ms.size());
	}
	
	@Test
	public void testRetention() {
		I_ClassAttributes result = GWT_2_6_Annot.getRetention();
		assertEquals("java.lang.annotation.Retention", result.getName());
		Set<I_FieldSignature> fs = result.getFields();
		Set<I_MethodSignature> ms = result.getMethods();
		delegates.delegateRetentionMemberAsserts(result);
		assertEquals(0, fs.size());
		assertEquals(1, ms.size());
	}

	@Test
	public void testRetentionPolicy() {
		I_ClassAttributes result = GWT_2_6_Annot.getRetentionPolicy();
		assertEquals("java.lang.annotation.RetentionPolicy", result.getName());
		Set<I_FieldSignature> fs = result.getFields();
		Set<I_MethodSignature> ms = result.getMethods();
		delegates.delegateRetentionPolicyMemberAsserts(result);
		assertEquals(3, fs.size());
		assertEquals(11, ms.size());
	}

	@Test
	public void testTarget() {
		I_ClassAttributes result = GWT_2_6_Annot.getTarget();
		assertEquals("java.lang.annotation.Target", result.getName());
		Set<I_FieldSignature> fs = result.getFields();
		Set<I_MethodSignature> ms = result.getMethods();
		delegates.delegateTargetMemberAsserts(result);
		assertEquals(0, fs.size());
		assertEquals(1, ms.size());
	}

	/**
	 * keep at bottom of file
	 * 
	 */
	@Override
	public int getTests(I_CountType type) {
		return super.getTests(type, 10, true);
	}

	@Override
	public int getAsserts(I_CountType type) {
		int thisAsserts = 132;
		if (type.isFromMetaWithCoverage()) {
			//code coverage and circular dependencies +
			//custom afterTrialTests
			return super.getAsserts(type, thisAsserts + 3);
		} else {
			return super.getAsserts(type, thisAsserts);
		}
	}

	@Override
	public int getUniqueAsserts(I_CountType type) {
		int thisUniqueAsserts = 127;
		if (type.isFromMetaWithCoverage()) {
			//code coverage and circular dependencies +
			//custom afterTrialTests
			return super.getUniqueAsserts(type, thisUniqueAsserts + 3);
		}  else {
			return super.getUniqueAsserts(type, thisUniqueAsserts);
		}
	}
	
}
