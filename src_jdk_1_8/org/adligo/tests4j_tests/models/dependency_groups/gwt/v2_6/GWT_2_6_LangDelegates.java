package org.adligo.tests4j_tests.models.dependency_groups.gwt.v2_6;

import java.util.Set;

import org.adligo.tests4j.models.dependency_groups.jse.JSE_Lang;
import org.adligo.tests4j.models.shared.common.ClassMethods;
import org.adligo.tests4j.models.shared.dependency.FieldSignature;
import org.adligo.tests4j.models.shared.dependency.I_ClassAttributes;
import org.adligo.tests4j.models.shared.dependency.I_FieldSignature;
import org.adligo.tests4j.models.shared.dependency.I_MethodSignature;
import org.adligo.tests4j.models.shared.dependency.MethodSignature;
import org.adligo.tests4j.models.shared.trials.I_Trial;
import org.adligo.tests4j.models.shared.trials.TrialDelegate;

public class GWT_2_6_LangDelegates extends TrialDelegate {

	public GWT_2_6_LangDelegates(I_Trial p) {
		super(p);
	}

	public  void delegateObjectMemberAsserts(I_ClassAttributes result) {
		Set<I_FieldSignature> fs = result.getFields();
		assertNotNull(fs);
		
		
		Set<I_MethodSignature> ms = result.getMethods();
		assertNotNull(ms);
		assertContains(ms, new MethodSignature("equals", 
			new String[] {JSE_Lang.OBJECT}, 
			ClassMethods.BOOLEAN));
		assertContains(ms, new MethodSignature("getClass", 
			JSE_Lang.CLASS));
		assertContains(ms, new MethodSignature("hashCode", 
			ClassMethods.INT));
		assertContains(ms, new MethodSignature("toString", 
			JSE_Lang.STRING));

	}
	
	public void delegateStackTraceElementMemberAsserts(I_ClassAttributes result) {
		delegateObjectMemberAsserts(result);
		Set<I_MethodSignature> ms = result.getMethods();
		assertContains(ms, new MethodSignature("getLineNumber", 
			ClassMethods.INT));
		assertContains(ms, new MethodSignature("getClassName", 
			JSE_Lang.STRING));
		assertContains(ms, new MethodSignature("getFileName", 
			JSE_Lang.STRING));
		assertContains(ms, new MethodSignature("getMethodName", 
			JSE_Lang.STRING));
	}
	
	public  void delegateThrowableMemberAsserts(I_ClassAttributes result) {
		delegateObjectMemberAsserts(result);
		Set<I_MethodSignature> ms = result.getMethods();
		assertContains(ms, new MethodSignature("getStackTrace", 
			"[java.lang.StackTraceElement"));
		assertContains(ms, new MethodSignature("getSuppressed", 
			"[java.lang.Throwable"));
		assertContains(ms, new MethodSignature("getLocalizedMessage", 
			JSE_Lang.STRING));
		assertContains(ms, new MethodSignature("getMessage", 
			JSE_Lang.STRING));
		assertContains(ms, new MethodSignature("toString", 
			JSE_Lang.STRING));
		assertContains(ms, new MethodSignature("fillInStackTrace", 
			JSE_Lang.THROWABLE));
		assertContains(ms, new MethodSignature("getCause", 
			JSE_Lang.THROWABLE));
		assertContains(ms, new MethodSignature("initCause", 
			new String[] {JSE_Lang.THROWABLE}, 
			JSE_Lang.THROWABLE));
		assertContains(ms, new MethodSignature("addSuppressed", 
			new String[] {JSE_Lang.THROWABLE}));
		assertContains(ms, new MethodSignature("printStackTrace"));
		assertContains(ms, new MethodSignature("printStackTrace", 
			new String[] {"java.io.PrintStream"}));
		assertContains(ms, new MethodSignature("setStackTrace", 
			new String[] {"[java.lang.StackTraceElement"}));
	}
	
	public void delegateExceptionMemberAsserts(I_ClassAttributes result) {
		delegateThrowableMemberAsserts(result);
	}
	
	public void delegateRuntimeExceptionMemberAsserts(I_ClassAttributes result) {
		delegateExceptionMemberAsserts(result);
	}
	public void delegateAppendableMemberAsserts(I_ClassAttributes result) {
		Set<I_MethodSignature> ms = result.getMethods();
		assertContains(ms, new MethodSignature("append", 
			new String[] {ClassMethods.CHAR}, 
			JSE_Lang.APPENDABLE));
		assertContains(ms, new MethodSignature("append", 
			new String[] {JSE_Lang.CHAR_SEQUENCE}, 
			JSE_Lang.APPENDABLE));
		assertContains(ms, new MethodSignature("append", 
			new String[] {JSE_Lang.CHAR_SEQUENCE, ClassMethods.INT, ClassMethods.INT}, 
			JSE_Lang.APPENDABLE));
	}
	
	public void delegateArithmeticExceptionMemberAsserts(I_ClassAttributes result) {
		delegateRuntimeExceptionMemberAsserts(result);
	}
	
	
	public void delegateArrayIndexOutOfBoundsException(Class<?> expectedInstanceClass, I_ClassAttributes attribs) {
		assertEquals(expectedInstanceClass, attribs.getClass());
		assertEquals(ArrayIndexOutOfBoundsException.class.getName(), attribs.getName());
		Set<I_FieldSignature> fields = attribs.getFields();
		assertNotNull(fields);
		assertEquals(0, fields.size());
		
		Set<I_MethodSignature> methods = attribs.getMethods();
		assertContains(methods, new MethodSignature("<init>"));
		assertContains(methods, new MethodSignature("<init>", 
				new String[] {String.class.getName()}));
		assertContains(methods, new MethodSignature("<init>", 
				new String[] {"int"}));
		
	}

	
	public void delegateAssertionError(Class<?> expectedInstanceClass, I_ClassAttributes attribs) {
		assertEquals(expectedInstanceClass, attribs.getClass());
		assertEquals(AssertionError.class.getName(), attribs.getName());
		Set<I_FieldSignature> fields = attribs.getFields();
		assertNotNull(fields);
		assertEquals(0, fields.size());
		
		Set<I_MethodSignature> methods = attribs.getMethods();
		assertContains(methods, new MethodSignature("<init>"));
		assertContains(methods, new MethodSignature("<init>", 
				new String[] {"boolean"}));
		assertContains(methods, new MethodSignature("<init>", 
				new String[] {"char"}));
		assertContains(methods, new MethodSignature("<init>", 
				new String[] {"double"}));
		assertContains(methods, new MethodSignature("<init>", 
				new String[] {"float"}));
		assertContains(methods, new MethodSignature("<init>", 
				new String[] {"int"}));
		assertContains(methods, new MethodSignature("<init>", 
				new String[] {"long"}));
		assertContains(methods, new MethodSignature("<init>", 
				new String[] {Object.class.getName()}));
		assertEquals(8, methods.size());
	}
	
	public void delegateAutoCloseableMemberAsserts(I_ClassAttributes result) {
		Set<I_MethodSignature> ms = result.getMethods();
		assertContains(ms, new MethodSignature("close"));
	}
	
	public void delegateBoolean(Class<?> expectedInstanceClass, I_ClassAttributes attribs) {
		assertEquals(expectedInstanceClass, attribs.getClass());
		assertEquals(Boolean.class.getName(), attribs.getName());
		Set<I_FieldSignature> fields = attribs.getFields();
		assertNotNull(fields);
		assertContains(fields, new FieldSignature("FALSE", Boolean.class.getName()));
		assertContains(fields, new FieldSignature("TRUE", Boolean.class.getName()));
		assertContains(fields, new FieldSignature("TYPE", Class.class.getName()));
		assertEquals(3, fields.size());
		
		Set<I_MethodSignature> methods = attribs.getMethods();
		assertContains(methods, new MethodSignature("<init>",
				new String[]{"boolean"}));
		assertContains(methods, new MethodSignature("<init>",
				new String[]{String.class.getName()}));
		assertContains(methods, new MethodSignature("compare",
				new String[]{"boolean", "boolean"},
				"int"));
		assertContains(methods, new MethodSignature("parseBoolean",
				new String[]{String.class.getName()},
				"boolean"));
		assertContains(methods, new MethodSignature("valueOf",
				new String[]{"boolean"},
				Boolean.class.getName()));
		assertContains(methods, new MethodSignature("valueOf",
				new String[]{String.class.getName()},
				Boolean.class.getName()));
		assertContains(methods, new MethodSignature("booleanValue",
				"boolean"));
		assertContains(methods, new MethodSignature("compareTo",
				new String[]{Boolean.class.getName()},
				"int"));
		//third lien
		assertContains(methods, new MethodSignature("equals",
				new String[]{Object.class.getName()},
				"boolean"));
		assertContains(methods, new MethodSignature("hashCode",
				"int"));
		assertContains(methods, new MethodSignature("toString",
				String.class.getName()));
	}
	
	public void delegateIndexOutOfBoundsExceptionMemberAsserts(I_ClassAttributes result) {
		delegateRuntimeExceptionMemberAsserts(result);
	}
	
	public void delegateArrayIndexOutOfBoundsExceptionMemberAsserts(I_ClassAttributes result) {
		delegateIndexOutOfBoundsExceptionMemberAsserts(result);
	}
	
	public void delegateArrayStoreExceptionMemberAsserts(I_ClassAttributes result) {
		delegateRuntimeExceptionMemberAsserts(result);
	}
	
	public void delegateErrorMemberAsserts(I_ClassAttributes result) {
		delegateThrowableMemberAsserts(result);
	}
	
	public void delegateAssertionErrorMemberAsserts(I_ClassAttributes result) {
		delegateErrorMemberAsserts(result);
	}
	
	public void delegateClassCastExceptionMemberAsserts(I_ClassAttributes result) {
		delegateRuntimeExceptionMemberAsserts(result);
	}
	
	public void delegateIllegalArgumentExceptionMemberAsserts(I_ClassAttributes result) {
		delegateRuntimeExceptionMemberAsserts(result);
	}
	
	public void delegateIllegalStateExceptionMemberAsserts(I_ClassAttributes result) {
		delegateRuntimeExceptionMemberAsserts(result);
	}
	public void delegateNegativeArraySizeExceptionMemberAsserts(I_ClassAttributes result) {
		delegateRuntimeExceptionMemberAsserts(result);
	}
	
	public void delegateReflectiveOperationExceptionMemberAsserts(I_ClassAttributes result) {
		delegateExceptionMemberAsserts(result);
	}
	
	public void delegateNoSuchMethodExceptionMemberAsserts(I_ClassAttributes result) {
		delegateReflectiveOperationExceptionMemberAsserts(result);
	}

	public void delegateNullPointerExceptionMemberAsserts(I_ClassAttributes result) {
		delegateRuntimeExceptionMemberAsserts(result);
	}

	public void delegateNumberFormatExceptionMemberAsserts(I_ClassAttributes result) {
		delegateIllegalArgumentExceptionMemberAsserts(result);
	}

	public void delegateStringIndexOutOfBoundsExceptionMemberAsserts(I_ClassAttributes result) {
		delegateIndexOutOfBoundsExceptionMemberAsserts(result);
	}
	public void delegateUnsupportedOperationExceptionMemberAsserts(I_ClassAttributes result) {
		delegateRuntimeExceptionMemberAsserts(result);
	}
	
	public void delegateCharSequenceMemberAsserts(I_ClassAttributes result) {
		Set<I_MethodSignature> ms = result.getMethods();
		assertContains(ms, new MethodSignature("charAt", 
			new String[] {ClassMethods.INT}, 
			ClassMethods.CHAR));
		assertContains(ms, new MethodSignature("length", 
			ClassMethods.INT));
		assertContains(ms, new MethodSignature("subSequence", 
			new String[] {ClassMethods.INT, ClassMethods.INT}, 
			JSE_Lang.CHAR_SEQUENCE));
		assertContains(ms, new MethodSignature("toString", 
			JSE_Lang.STRING));
	}
}
