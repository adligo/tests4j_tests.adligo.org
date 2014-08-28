package org.adligo.tests4j_tests.models.shared.dependency_groups.gwt.v2_6;

import java.util.Set;

import org.adligo.tests4j.models.shared.common.ClassMethods;
import org.adligo.tests4j.models.shared.dependency.FieldSignature;
import org.adligo.tests4j.models.shared.dependency.I_ClassAttributes;
import org.adligo.tests4j.models.shared.dependency.I_FieldSignature;
import org.adligo.tests4j.models.shared.dependency.I_MethodSignature;
import org.adligo.tests4j.models.shared.dependency.MethodSignature;
import org.adligo.tests4j.models.shared.dependency_groups.jse.JSE_Lang;
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
		assertContains(ms, new MethodSignature("<init>"));
		assertContains(ms, new MethodSignature("toString", 
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
	public void delegateAppendable(Class<?> expectedInstanceClass, I_ClassAttributes attribs) {
		assertEquals(expectedInstanceClass, attribs.getClass());
		assertEquals(Appendable.class.getName(), attribs.getName());
		Set<I_FieldSignature> fields = attribs.getFields();
		assertNotNull(fields);
		assertEquals(0, fields.size());
		
		Set<I_MethodSignature> methods = attribs.getMethods();
		assertContains(methods, new MethodSignature("append", 
				new String[] {"char"}, 
				Appendable.class.getName()));
		assertContains(methods, new MethodSignature("append", 
				new String[] {CharSequence.class.getName()}, 
				Appendable.class.getName()));
		assertContains(methods, new MethodSignature("append", 
				new String[] {CharSequence.class.getName(), "int", "int"}, 
				Appendable.class.getName()));
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
	
	public void delegateArrayStoreException(Class<?> expectedInstanceClass, I_ClassAttributes attribs) {
		assertEquals(expectedInstanceClass, attribs.getClass());
		assertEquals(ArrayStoreException.class.getName(), attribs.getName());
		Set<I_FieldSignature> fields = attribs.getFields();
		assertNotNull(fields);
		assertEquals(0, fields.size());
		
		Set<I_MethodSignature> methods = attribs.getMethods();
		assertContains(methods, new MethodSignature("<init>"));
		assertContains(methods, new MethodSignature("<init>", 
				new String[] {String.class.getName()}));
		
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
	
	public void delegateAutoCloseable(Class<?> expectedInstanceClass, I_ClassAttributes attribs) {
		assertEquals(expectedInstanceClass, attribs.getClass());
		assertEquals(AutoCloseable.class.getName(), attribs.getName());
		Set<I_FieldSignature> fields = attribs.getFields();
		assertNotNull(fields);
		assertEquals(0, fields.size());
		
		Set<I_MethodSignature> methods = attribs.getMethods();
		assertContains(methods, new MethodSignature("close"));
		
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
}
