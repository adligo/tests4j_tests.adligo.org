package org.adligo.tests4j_tests.models.shared.dependency_groups.gwt;

import java.util.Set;

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

	public void delegateAppendable(Class<?> expectedInstanceClass, I_ClassAttributes attribs) {
		assertEquals(expectedInstanceClass, attribs.getClass());
		assertEquals(Appendable.class.getName(), attribs.getClassName());
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
	
	public void delegateArithmeticException(Class<?> expectedInstanceClass, I_ClassAttributes attribs) {
		assertEquals(expectedInstanceClass, attribs.getClass());
		assertEquals(ArithmeticException.class.getName(), attribs.getClassName());
		Set<I_FieldSignature> fields = attribs.getFields();
		assertNotNull(fields);
		assertEquals(0, fields.size());
		
		Set<I_MethodSignature> methods = attribs.getMethods();
		assertContains(methods, new MethodSignature("<init>"));
		assertContains(methods, new MethodSignature("<init>", 
				new String[] {String.class.getName()}));
		
		
	}
	
	
	public void delegateArrayIndexOutOfBoundsException(Class<?> expectedInstanceClass, I_ClassAttributes attribs) {
		assertEquals(expectedInstanceClass, attribs.getClass());
		assertEquals(ArrayIndexOutOfBoundsException.class.getName(), attribs.getClassName());
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
		assertEquals(ArrayStoreException.class.getName(), attribs.getClassName());
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
		assertEquals(AssertionError.class.getName(), attribs.getClassName());
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
		assertEquals(AutoCloseable.class.getName(), attribs.getClassName());
		Set<I_FieldSignature> fields = attribs.getFields();
		assertNotNull(fields);
		assertEquals(0, fields.size());
		
		Set<I_MethodSignature> methods = attribs.getMethods();
		assertContains(methods, new MethodSignature("close"));
		
	}
	
	public void delegateBoolean(Class<?> expectedInstanceClass, I_ClassAttributes attribs) {
		assertEquals(expectedInstanceClass, attribs.getClass());
		assertEquals(Boolean.class.getName(), attribs.getClassName());
		Set<I_FieldSignature> fields = attribs.getFields();
		assertNotNull(fields);
		assertContains(fields, new FieldSignature("FALSE", "boolean"));
		assertContains(fields, new FieldSignature("TRUE", "boolean"));
		assertContains(fields, new FieldSignature("TYPE", Class.class.getName()));
		assertEquals(3, fields.size());
		
		Set<I_MethodSignature> methods = attribs.getMethods();
		assertContains(methods, new MethodSignature("<init>",
				new String[]{"boolean"}));
		assertContains(methods, new MethodSignature("<init>",
				new String[]{String.class.getName()}));
		assertContains(methods, new MethodSignature("compare",
				new String[]{"boolean", "boolean"},
				Integer.class.getName()));
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
				Integer.class.getName()));
		//third lien
		assertContains(methods, new MethodSignature("equals",
				new String[]{Object.class.getName()},
				"boolean"));
		assertContains(methods, new MethodSignature("hashCode",
				Integer.class.getName()));
		assertContains(methods, new MethodSignature("toString",
				String.class.getName()));
	}
}
