package org.adligo.tests4j_tests.models.shared.dependency_groups.gwt.v2_6;

import java.util.Set;

import org.adligo.tests4j.models.shared.asserts.common.I_Asserts;
import org.adligo.tests4j.models.shared.common.ClassMethods;
import org.adligo.tests4j.models.shared.dependency.ClassAttributes;
import org.adligo.tests4j.models.shared.dependency.ClassAttributesMutant;
import org.adligo.tests4j.models.shared.dependency.I_ClassAttributes;
import org.adligo.tests4j.models.shared.dependency.I_FieldSignature;
import org.adligo.tests4j.models.shared.dependency.I_MethodSignature;
import org.adligo.tests4j.models.shared.dependency.MethodSignature;
import org.adligo.tests4j.models.shared.dependency_groups.gwt.GWT_2_6_Lang;
import org.adligo.tests4j.models.shared.dependency_groups.jse.JSE_Lang;
import org.adligo.tests4j.models.shared.trials.SourceFileScope;
import org.adligo.tests4j.models.shared.trials.Test;
import org.adligo.tests4j_tests.base_trials.SourceFileCountingTrial;

//try to keep coverage above 10 for the 0.1 release
@SourceFileScope (sourceClass=GWT_2_6_Lang.class, minCoverage=50.0)
public class GWT_2_6_LangTrial extends SourceFileCountingTrial {
	private GWT_2_6_LangDelegates delegates;
	
	public GWT_2_6_LangTrial() {
		delegates = new GWT_2_6_LangDelegates(this);
	}
	@Test
	public void testAppendable() {
		ClassAttributes cam = GWT_2_6_Lang.getAppendable();
		delegates.delegateAppendable(ClassAttributesMutant.class, new ClassAttributesMutant(cam));
		delegates.delegateAppendable(ClassAttributes.class, new ClassAttributes(cam));
	}
	
	@Test
	public void testArrayIndexOutOfBoundsException() {
		ClassAttributes cam = GWT_2_6_Lang.getArrayIndexOutOfBoundsException();
		delegates.delegateArrayIndexOutOfBoundsException(ClassAttributesMutant.class, new ClassAttributesMutant(cam));
		delegates.delegateArrayIndexOutOfBoundsException(ClassAttributes.class, new ClassAttributes(cam));
	}
	
	@Test
	public void testArrayStoreException() {
		ClassAttributes cam = GWT_2_6_Lang.getArrayStoreException();
		delegates.delegateArrayStoreException(ClassAttributesMutant.class, new ClassAttributesMutant(cam));
		delegates.delegateArrayStoreException(ClassAttributes.class, new ClassAttributes(cam));
	}
	
	@Test
	public void testAssertionError() {
		ClassAttributes cam = GWT_2_6_Lang.getAssertionError();
		delegates.delegateAssertionError(ClassAttributesMutant.class, new ClassAttributesMutant(cam));
		delegates.delegateAssertionError(ClassAttributes.class, new ClassAttributes(cam));
	}
	
	@Test
	public void testAutoCloseable() {
		ClassAttributes cam = GWT_2_6_Lang.getAutoCloseable();
		delegates.delegateAutoCloseable(ClassAttributesMutant.class, new ClassAttributesMutant(cam));
		delegates.delegateAutoCloseable(ClassAttributes.class, new ClassAttributes(cam));
	}
	
	@Test
	public void testBoolean() {
		ClassAttributes cam = GWT_2_6_Lang.getBoolean();
		delegates.delegateBoolean(ClassAttributesMutant.class, new ClassAttributesMutant(cam));
		delegates.delegateBoolean(ClassAttributes.class, new ClassAttributes(cam));
	}
	
	@Test
	public void testObject() {
		I_ClassAttributes result = GWT_2_6_Lang.getObject();
		assertEquals("java.lang.Object", result.getName());
		delegates.delegateObjectMemberAsserts(result);
		Set<I_FieldSignature> fs = result.getFields();
		assertEquals(0, fs.size());
		Set<I_MethodSignature> ms = result.getMethods();
		assertEquals(5, ms.size());
	}
	
	
	
	@Test
	public void testThrowable() {
		I_ClassAttributes result = GWT_2_6_Lang.getThrowable();
		assertEquals("java.lang.Throwable", result.getName());
		Set<I_FieldSignature> fs = result.getFields();
		Set<I_MethodSignature> ms = result.getMethods();
		assertContains(ms, new MethodSignature("<init>"));
		assertContains(ms, new MethodSignature("<init>", 
				new String[] {JSE_Lang.STRING, JSE_Lang.THROWABLE}));
		assertContains(ms, new MethodSignature("<init>", 
			new String[] {JSE_Lang.STRING}));
		
		assertContains(ms, new MethodSignature("<init>", 
			new String[] {JSE_Lang.THROWABLE}));
		delegates.delegateThrowableMemberAsserts(result);
		assertEquals(0, fs.size());
		assertEquals(19, ms.size());
	}
	
	@Test
	public void testException() {
		I_ClassAttributes result = GWT_2_6_Lang.getException();
		assertEquals("java.lang.Exception", result.getName());
		Set<I_FieldSignature> fs = result.getFields();
		Set<I_MethodSignature> ms = result.getMethods();
		assertContains(ms, new MethodSignature("<init>"));
		assertContains(ms, new MethodSignature("<init>", 
			new String[] {JSE_Lang.STRING}));
		assertContains(ms, new MethodSignature("<init>", 
			new String[] {JSE_Lang.STRING, JSE_Lang.THROWABLE}));
		assertContains(ms, new MethodSignature("<init>", 
			new String[] {JSE_Lang.THROWABLE}));
		delegates.delegateExceptionMemberAsserts(result);
		assertEquals(0, fs.size());
		assertEquals(19, ms.size());
	}
	
	@Test
	public void testRuntimeException() {
		I_ClassAttributes result = GWT_2_6_Lang.getRuntimeException();
		assertEquals("java.lang.RuntimeException", result.getName());
		Set<I_FieldSignature> fs = result.getFields();
		Set<I_MethodSignature> ms = result.getMethods();
		assertContains(ms, new MethodSignature("<init>"));
		assertContains(ms, new MethodSignature("<init>", 
			new String[] {JSE_Lang.STRING}));
		assertContains(ms, new MethodSignature("<init>", 
			new String[] {JSE_Lang.STRING, JSE_Lang.THROWABLE}));
		assertContains(ms, new MethodSignature("<init>", 
			new String[] {JSE_Lang.THROWABLE}));
		delegates.delegateRuntimeExceptionMemberAsserts(result);
		assertEquals(0, fs.size());
		assertEquals(19, ms.size());
	}

	@Test
	public void testArithmeticException() {
		I_ClassAttributes result = GWT_2_6_Lang.getArithmeticException();
		assertEquals("java.lang.ArithmeticException", result.getName());
		Set<I_FieldSignature> fs = result.getFields();
		Set<I_MethodSignature> ms = result.getMethods();
		assertContains(ms, new MethodSignature("<init>"));
		assertContains(ms, new MethodSignature("<init>", 
			new String[] {JSE_Lang.STRING}));
		delegates.delegateArithmeticExceptionMemberAsserts(result);
		assertEquals(0, fs.size());
		assertEquals(17, ms.size());
	}
	
	@Test
	public void testByte() {
		
	}
	@Override
	public int getTests() {
		return 12;
	}

	@Override
	public int getAsserts() {
		return 224;
	}

	@Override
	public int getUniqueAsserts() {
		return 166;
	}

}
