package org.adligo.tests4j_v1_tests.models.dependency_groups.gwt.v2_6;

import java.util.Set;

import org.adligo.tests4j.models.dependency_groups.jse.JSE_Lang;
import org.adligo.tests4j.models.shared.common.ClassMethods;
import org.adligo.tests4j.models.shared.dependency.FieldSignature;
import org.adligo.tests4j.models.shared.dependency.I_ClassAttributes;
import org.adligo.tests4j.models.shared.dependency.I_FieldSignature;
import org.adligo.tests4j.models.shared.dependency.I_MethodSignature;
import org.adligo.tests4j.models.shared.dependency.MethodSignature;
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
	
	public void delegateAnnotationMemberAsserts(I_ClassAttributes result) {
		Set<I_MethodSignature> ms = result.getMethods();
		assertContains(ms, new MethodSignature("equals", 
			new String[] {JSE_Lang.OBJECT}, 
			ClassMethods.BOOLEAN));
		assertContains(ms, new MethodSignature("hashCode", 
			ClassMethods.INT));
		assertContains(ms, new MethodSignature("annotationType", 
			JSE_Lang.CLASS));
		assertContains(ms, new MethodSignature("toString", 
			JSE_Lang.STRING));
	}
	
	public void delegateElementTypeMemberAsserts(I_ClassAttributes result) {
		super.delegateEnumMemberAsserts(result);
		Set<I_FieldSignature> fs = result.getFields();
		assertContains(fs, new FieldSignature("ANNOTATION_TYPE", "java.lang.annotation.ElementType"));
		assertContains(fs, new FieldSignature("CONSTRUCTOR", "java.lang.annotation.ElementType"));
		assertContains(fs, new FieldSignature("FIELD", "java.lang.annotation.ElementType"));
		assertContains(fs, new FieldSignature("LOCAL_VARIABLE", "java.lang.annotation.ElementType"));
		assertContains(fs, new FieldSignature("METHOD", "java.lang.annotation.ElementType"));
		assertContains(fs, new FieldSignature("PACKAGE", "java.lang.annotation.ElementType"));
		assertContains(fs, new FieldSignature("PARAMETER", "java.lang.annotation.ElementType"));
		assertContains(fs, new FieldSignature("TYPE", "java.lang.annotation.ElementType"));
		Set<I_MethodSignature> ms = result.getMethods();
		assertContains(ms, new MethodSignature("values", 
			"[java.lang.annotation.ElementType"));
		assertContains(ms, new MethodSignature("valueOf", 
			new String[] {JSE_Lang.STRING}, 
			"java.lang.annotation.ElementType"));
	}
	
	
	public void delegateRetentionMemberAsserts(I_ClassAttributes result) {
		Set<I_MethodSignature> ms = result.getMethods();
		assertContains(ms, new MethodSignature("value", 
			"java.lang.annotation.RetentionPolicy"));
	}
	public void delegateRetentionPolicyMemberAsserts(I_ClassAttributes result) {
		delegateEnumMemberAsserts(result);
		Set<I_FieldSignature> fs = result.getFields();
		assertContains(fs, new FieldSignature("CLASS", "java.lang.annotation.RetentionPolicy"));
		assertContains(fs, new FieldSignature("RUNTIME", "java.lang.annotation.RetentionPolicy"));
		assertContains(fs, new FieldSignature("SOURCE", "java.lang.annotation.RetentionPolicy"));
		Set<I_MethodSignature> ms = result.getMethods();
		assertContains(ms, new MethodSignature("values", 
			"[java.lang.annotation.RetentionPolicy"));
		assertContains(ms, new MethodSignature("valueOf", 
			new String[] {JSE_Lang.STRING}, 
			"java.lang.annotation.RetentionPolicy"));
	}
	public void delegateTargetMemberAsserts(I_ClassAttributes result) {
		Set<I_MethodSignature> ms = result.getMethods();
		assertContains(ms, new MethodSignature("value", 
			"[java.lang.annotation.ElementType"));
	}
}
