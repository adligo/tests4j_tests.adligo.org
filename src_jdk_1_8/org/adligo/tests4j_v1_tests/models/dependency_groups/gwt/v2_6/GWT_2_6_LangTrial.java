package org.adligo.tests4j_v1_tests.models.dependency_groups.gwt.v2_6;

import java.util.Set;

import org.adligo.tests4j.models.dependency_groups.gwt.GWT_2_6_Lang;
import org.adligo.tests4j.models.dependency_groups.jse.JSE_Lang;
import org.adligo.tests4j.models.dependency_groups.jse.JSE_Util;
import org.adligo.tests4j.models.shared.asserts.common.I_Asserts;
import org.adligo.tests4j.models.shared.common.ClassMethods;
import org.adligo.tests4j.models.shared.dependency.ClassAttributes;
import org.adligo.tests4j.models.shared.dependency.ClassAttributesMutant;
import org.adligo.tests4j.models.shared.dependency.I_ClassAttributes;
import org.adligo.tests4j.models.shared.dependency.I_FieldSignature;
import org.adligo.tests4j.models.shared.dependency.I_MethodSignature;
import org.adligo.tests4j.models.shared.dependency.MethodSignature;
import org.adligo.tests4j.models.shared.trials.SourceFileScope;
import org.adligo.tests4j.models.shared.trials.Test;
import org.adligo.tests4j_tests.base_trials.I_CountType;
import org.adligo.tests4j_tests.base_trials.SourceFileCountingTrial;

//try to keep coverage above 10 for the 0.1 release
@SourceFileScope (sourceClass=GWT_2_6_Lang.class, minCoverage=40.0)
public class GWT_2_6_LangTrial extends SourceFileCountingTrial {
	private GWT_2_6_LangDelegates delegates;
	
	public GWT_2_6_LangTrial() {
		delegates = new GWT_2_6_LangDelegates(this);
	}
	@Test
	public void testAppendable() {
		I_ClassAttributes result = GWT_2_6_Lang.getAppendable();
		assertEquals("java.lang.Appendable", result.getName());
		Set<I_FieldSignature> fs = result.getFields();
		Set<I_MethodSignature> ms = result.getMethods();
		delegates.delegateAppendableMemberAsserts(result);
		assertEquals(0, fs.size());
		assertEquals(3, ms.size());
	}
	

	@Test
	public void testAutoCloseable() {
		I_ClassAttributes result = GWT_2_6_Lang.getAutoCloseable();
		assertEquals("java.lang.AutoCloseable", result.getName());
		Set<I_FieldSignature> fs = result.getFields();
		Set<I_MethodSignature> ms = result.getMethods();
		delegates.delegateAutoCloseableMemberAsserts(result);
		assertEquals(0, fs.size());
		assertEquals(1, ms.size());
	}
	
	
	@Test
	public void testBoolean() {
		I_ClassAttributes result = GWT_2_6_Lang.getBoolean();
		assertEquals("java.lang.Boolean", result.getName());
		Set<I_FieldSignature> fs = result.getFields();
		Set<I_MethodSignature> ms = result.getMethods();
		assertContains(ms, new MethodSignature("<init>", 
			new String[] {ClassMethods.BOOLEAN}));
		assertContains(ms, new MethodSignature("<init>", 
			new String[] {JSE_Lang.STRING}));
		delegates.delegateBooleanMemberAsserts(result);
		assertEquals(3, fs.size());
		assertEquals(12, ms.size());
	}

	
	@Test
	public void testObject() {
		I_ClassAttributes result = GWT_2_6_Lang.getObject();
		assertEquals("java.lang.Object", result.getName());
		
		Set<I_MethodSignature> ms = result.getMethods();
		assertNotNull(ms);
		assertContains(ms, new MethodSignature("<init>"));
		delegates.delegateObjectMemberAsserts(result);
		Set<I_FieldSignature> fs = result.getFields();
		assertEquals(0, fs.size());
		assertEquals(5, ms.size());
	}
	
	@Test
	public void testStackTraceElement() {
		I_ClassAttributes result = GWT_2_6_Lang.getStackTraceElement();
		assertEquals("java.lang.StackTraceElement", result.getName());
		Set<I_FieldSignature> fs = result.getFields();
		Set<I_MethodSignature> ms = result.getMethods();
		assertContains(ms, new MethodSignature("<init>", 
			new String[] {JSE_Lang.STRING, JSE_Lang.STRING, JSE_Lang.STRING, ClassMethods.INT}));
		delegates.delegateStackTraceElementMemberAsserts(result);
		assertEquals(0, fs.size());
		assertEquals(10, ms.size());
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
	public void testIndexOutOfBoundsException() {
		I_ClassAttributes result = GWT_2_6_Lang.getIndexOutOfBoundsException();
		assertEquals("java.lang.IndexOutOfBoundsException", result.getName());
		Set<I_FieldSignature> fs = result.getFields();
		Set<I_MethodSignature> ms = result.getMethods();
		assertContains(ms, new MethodSignature("<init>"));
		assertContains(ms, new MethodSignature("<init>", 
			new String[] {JSE_Lang.STRING}));
		delegates.delegateIndexOutOfBoundsExceptionMemberAsserts(result);
		assertEquals(0, fs.size());
		assertEquals(17, ms.size());
	}
	
	@Test
	public void testFloat() {
		I_ClassAttributes result = GWT_2_6_Lang.getFloat();
		assertEquals("java.lang.Float", result.getName());
		Set<I_FieldSignature> fs = result.getFields();
		Set<I_MethodSignature> ms = result.getMethods();
		assertContains(ms, new MethodSignature("<init>", 
			new String[] {ClassMethods.DOUBLE}));
		assertContains(ms, new MethodSignature("<init>", 
			new String[] {ClassMethods.FLOAT}));
		assertContains(ms, new MethodSignature("<init>", 
			new String[] {JSE_Lang.STRING}));
		delegates.delegateFloatMemberAsserts(result);
		assertEquals(1, fs.size());
		assertEquals(23, ms.size());
	}

	@Test
	public void testArrayIndexOutOfBoundsException() {
		I_ClassAttributes result = GWT_2_6_Lang.getArrayIndexOutOfBoundsException();
		assertEquals("java.lang.ArrayIndexOutOfBoundsException", result.getName());
		Set<I_FieldSignature> fs = result.getFields();
		Set<I_MethodSignature> ms = result.getMethods();
		assertContains(ms, new MethodSignature("<init>"));
		assertContains(ms, new MethodSignature("<init>", 
			new String[] {ClassMethods.INT}));
		assertContains(ms, new MethodSignature("<init>", 
			new String[] {JSE_Lang.STRING}));
		delegates.delegateArrayIndexOutOfBoundsExceptionMemberAsserts(result);
		assertEquals(0, fs.size());
		assertEquals(18, ms.size());
	}

	@Test
	public void testArrayStoreException() {
		I_ClassAttributes result = GWT_2_6_Lang.getArrayStoreException();
		assertEquals("java.lang.ArrayStoreException", result.getName());
		Set<I_FieldSignature> fs = result.getFields();
		Set<I_MethodSignature> ms = result.getMethods();
		assertContains(ms, new MethodSignature("<init>"));
		assertContains(ms, new MethodSignature("<init>", 
			new String[] {JSE_Lang.STRING}));
		delegates.delegateArrayStoreExceptionMemberAsserts(result);
		assertEquals(0, fs.size());
		assertEquals(17, ms.size());
	}
	
	@Test
	public void testError() {
		I_ClassAttributes result = GWT_2_6_Lang.getError();
		assertEquals("java.lang.Error", result.getName());
		Set<I_FieldSignature> fs = result.getFields();
		Set<I_MethodSignature> ms = result.getMethods();
		assertContains(ms, new MethodSignature("<init>"));
		assertContains(ms, new MethodSignature("<init>", 
			new String[] {JSE_Lang.STRING}));
		assertContains(ms, new MethodSignature("<init>", 
			new String[] {JSE_Lang.STRING, JSE_Lang.THROWABLE}));
		assertContains(ms, new MethodSignature("<init>", 
			new String[] {JSE_Lang.THROWABLE}));
		delegates.delegateErrorMemberAsserts(result);
		assertEquals(0, fs.size());
		assertEquals(19, ms.size());
	}
	
	@Test
	public void testAssertionError() {
		I_ClassAttributes result = GWT_2_6_Lang.getAssertionError();
		assertEquals("java.lang.AssertionError", result.getName());
		Set<I_FieldSignature> fs = result.getFields();
		Set<I_MethodSignature> ms = result.getMethods();
		assertContains(ms, new MethodSignature("<init>"));
		assertContains(ms, new MethodSignature("<init>", 
			new String[] {ClassMethods.BOOLEAN}));
		assertContains(ms, new MethodSignature("<init>", 
			new String[] {ClassMethods.CHAR}));
		assertContains(ms, new MethodSignature("<init>", 
			new String[] {ClassMethods.DOUBLE}));
		assertContains(ms, new MethodSignature("<init>", 
			new String[] {ClassMethods.FLOAT}));
		assertContains(ms, new MethodSignature("<init>", 
			new String[] {ClassMethods.INT}));
		assertContains(ms, new MethodSignature("<init>", 
			new String[] {JSE_Lang.OBJECT}));
		assertContains(ms, new MethodSignature("<init>", 
			new String[] {ClassMethods.LONG}));
		delegates.delegateAssertionErrorMemberAsserts(result);
		assertEquals(0, fs.size());
		assertEquals(23, ms.size());
	}

	
	@Test
	public void testClassCastException() {
		I_ClassAttributes result = GWT_2_6_Lang.getClassCastException();
		assertEquals("java.lang.ClassCastException", result.getName());
		Set<I_FieldSignature> fs = result.getFields();
		Set<I_MethodSignature> ms = result.getMethods();
		assertContains(ms, new MethodSignature("<init>"));
		assertContains(ms, new MethodSignature("<init>", 
			new String[] {JSE_Lang.STRING}));
		delegates.delegateClassCastExceptionMemberAsserts(result);
		assertEquals(0, fs.size());
		assertEquals(17, ms.size());
	}
	
	
	@Test
	public void testIllegalArgumentException() {
		I_ClassAttributes result = GWT_2_6_Lang.getIllegalArgumentException();
		assertEquals("java.lang.IllegalArgumentException", result.getName());
		Set<I_FieldSignature> fs = result.getFields();
		Set<I_MethodSignature> ms = result.getMethods();
		assertContains(ms, new MethodSignature("<init>"));
		assertContains(ms, new MethodSignature("<init>", 
			new String[] {JSE_Lang.STRING}));
		assertContains(ms, new MethodSignature("<init>", 
			new String[] {JSE_Lang.STRING, JSE_Lang.THROWABLE}));
		assertContains(ms, new MethodSignature("<init>", 
			new String[] {JSE_Lang.THROWABLE}));
		delegates.delegateIllegalArgumentExceptionMemberAsserts(result);
		assertEquals(0, fs.size());
		assertEquals(19, ms.size());
	}
	
	@Test
	public void testIllegalStateException() {
		I_ClassAttributes result = GWT_2_6_Lang.getIllegalStateException();
		assertEquals("java.lang.IllegalStateException", result.getName());
		Set<I_FieldSignature> fs = result.getFields();
		Set<I_MethodSignature> ms = result.getMethods();
		assertContains(ms, new MethodSignature("<init>"));
		assertContains(ms, new MethodSignature("<init>", 
			new String[] {JSE_Lang.STRING}));
		assertContains(ms, new MethodSignature("<init>", 
			new String[] {JSE_Lang.STRING, JSE_Lang.THROWABLE}));
		assertContains(ms, new MethodSignature("<init>", 
			new String[] {JSE_Lang.THROWABLE}));
		delegates.delegateIllegalStateExceptionMemberAsserts(result);
		assertEquals(0, fs.size());
		assertEquals(19, ms.size());
	}
	
	@Test
	public void testNegativeArraySizeException() {
		I_ClassAttributes result = GWT_2_6_Lang.getNegativeArraySizeException();
		assertEquals("java.lang.NegativeArraySizeException", result.getName());
		Set<I_FieldSignature> fs = result.getFields();
		Set<I_MethodSignature> ms = result.getMethods();
		assertContains(ms, new MethodSignature("<init>"));
		assertContains(ms, new MethodSignature("<init>", 
			new String[] {JSE_Lang.STRING}));
		delegates.delegateNegativeArraySizeExceptionMemberAsserts(result);
		assertEquals(0, fs.size());
		assertEquals(17, ms.size());
	}

	
	@Test
	public void testNoSuchMethodException() {
		I_ClassAttributes result = GWT_2_6_Lang.getNoSuchMethodException();
		assertEquals("java.lang.NoSuchMethodException", result.getName());
		Set<I_FieldSignature> fs = result.getFields();
		Set<I_MethodSignature> ms = result.getMethods();
		assertContains(ms, new MethodSignature("<init>"));
		assertContains(ms, new MethodSignature("<init>", 
			new String[] {JSE_Lang.STRING}));
		delegates.delegateNoSuchMethodExceptionMemberAsserts(result);
		assertEquals(0, fs.size());
		assertEquals(17, ms.size());
	}

	@Test
	public void testNullPointerException() {
		I_ClassAttributes result = GWT_2_6_Lang.getNullPointerException();
		assertEquals("java.lang.NullPointerException", result.getName());
		Set<I_FieldSignature> fs = result.getFields();
		Set<I_MethodSignature> ms = result.getMethods();
		assertContains(ms, new MethodSignature("<init>"));
		assertContains(ms, new MethodSignature("<init>", 
			new String[] {JSE_Lang.STRING}));
		delegates.delegateNullPointerExceptionMemberAsserts(result);
		assertEquals(0, fs.size());
		assertEquals(17, ms.size());
	}

	@Test
	public void testNumberFormatException() {
		I_ClassAttributes result = GWT_2_6_Lang.getNumberFormatException();
		assertEquals("java.lang.NumberFormatException", result.getName());
		Set<I_FieldSignature> fs = result.getFields();
		Set<I_MethodSignature> ms = result.getMethods();
		assertContains(ms, new MethodSignature("<init>"));
		assertContains(ms, new MethodSignature("<init>", 
			new String[] {JSE_Lang.STRING}));
		delegates.delegateNumberFormatExceptionMemberAsserts(result);
		assertEquals(0, fs.size());
		assertEquals(17, ms.size());
	}

	@Test
	public void testNumber() {
		I_ClassAttributes result = GWT_2_6_Lang.getNumber();
		assertEquals("java.lang.Number", result.getName());
		Set<I_FieldSignature> fs = result.getFields();
		Set<I_MethodSignature> ms = result.getMethods();
		delegates.delegateNumberMemberAsserts(result);
		assertEquals(0, fs.size());
		assertEquals(10, ms.size());
	}

	
	@Test
	public void testStringIndexOutOfBoundsException() {
		I_ClassAttributes result = GWT_2_6_Lang.getStringIndexOutOfBoundsException();
		assertEquals("java.lang.StringIndexOutOfBoundsException", result.getName());
		Set<I_FieldSignature> fs = result.getFields();
		Set<I_MethodSignature> ms = result.getMethods();
		assertContains(ms, new MethodSignature("<init>"));
		assertContains(ms, new MethodSignature("<init>", 
			new String[] {ClassMethods.INT}));
		assertContains(ms, new MethodSignature("<init>", 
			new String[] {JSE_Lang.STRING}));
		delegates.delegateStringIndexOutOfBoundsExceptionMemberAsserts(result);
		assertEquals(0, fs.size());
		assertEquals(18, ms.size());
	}

	@Test
	public void testUnsupportedOperationException() {
		I_ClassAttributes result = GWT_2_6_Lang.getUnsupportedOperationException();
		assertEquals("java.lang.UnsupportedOperationException", result.getName());
		Set<I_FieldSignature> fs = result.getFields();
		Set<I_MethodSignature> ms = result.getMethods();
		assertContains(ms, new MethodSignature("<init>"));
		assertContains(ms, new MethodSignature("<init>", 
			new String[] {JSE_Lang.STRING}));
		assertContains(ms, new MethodSignature("<init>", 
			new String[] {JSE_Lang.STRING, JSE_Lang.THROWABLE}));
		assertContains(ms, new MethodSignature("<init>", 
			new String[] {JSE_Lang.THROWABLE}));
		delegates.delegateUnsupportedOperationExceptionMemberAsserts(result);
		assertEquals(0, fs.size());
		assertEquals(19, ms.size());
	}

	@Test
	public void testCharSequence() {
		I_ClassAttributes result = GWT_2_6_Lang.getCharSequence();
		assertEquals("java.lang.CharSequence", result.getName());
		Set<I_FieldSignature> fs = result.getFields();
		Set<I_MethodSignature> ms = result.getMethods();
		delegates.delegateCharSequenceMemberAsserts(result);
		assertEquals(0, fs.size());
		assertEquals(4, ms.size());
	}
	
	@Test
	public void testCharacter() {
		I_ClassAttributes result = GWT_2_6_Lang.getCharacter();
		assertEquals("java.lang.Character", result.getName());
		Set<I_FieldSignature> fs = result.getFields();
		Set<I_MethodSignature> ms = result.getMethods();
		assertContains(ms, new MethodSignature("<init>", 
			new String[] {ClassMethods.CHAR}));
		delegates.delegateCharacterMemberAsserts(result);
		assertEquals(1, fs.size());
		assertEquals(39, ms.size());
	}

	@Test
	public void testByte() {
		I_ClassAttributes result = GWT_2_6_Lang.getByte();
		assertEquals("java.lang.Byte", result.getName());
		Set<I_FieldSignature> fs = result.getFields();
		Set<I_MethodSignature> ms = result.getMethods();
		assertContains(ms, new MethodSignature("<init>", 
			new String[] {ClassMethods.BYTE}));
		assertContains(ms, new MethodSignature("<init>", 
			new String[] {JSE_Lang.STRING}));
		delegates.delegateByteMemberAsserts(result);
		assertEquals(1, fs.size());
		assertEquals(20, ms.size());
	}

	@Test
	public void testClass() {
		I_ClassAttributes result = GWT_2_6_Lang.getClassAttributes();
		assertEquals("java.lang.Class", result.getName());
		Set<I_FieldSignature> fs = result.getFields();
		Set<I_MethodSignature> ms = result.getMethods();
		delegates.delegateClassMemberAsserts(result);
		assertEquals(0, fs.size());
		assertEquals(14, ms.size());
	}

	@Test
	public void testCloneable() {
		I_ClassAttributes result = GWT_2_6_Lang.getCloneable();
		assertEquals("java.lang.Cloneable", result.getName());
		Set<I_FieldSignature> fs = result.getFields();
		Set<I_MethodSignature> ms = result.getMethods();
		assertEquals(0, fs.size());
		assertEquals(0, ms.size());
	}
	@Test
	public void testComparable() {
		I_ClassAttributes result = GWT_2_6_Lang.getComparable();
		assertEquals("java.lang.Comparable", result.getName());
		Set<I_FieldSignature> fs = result.getFields();
		Set<I_MethodSignature> ms = result.getMethods();
		delegates.delegateComparableMemberAsserts(result);
		assertEquals(0, fs.size());
		assertEquals(1, ms.size());
	}
	@Test
	public void testDeprecated() {
		I_ClassAttributes result = GWT_2_6_Lang.getDeprecated();
		assertEquals("java.lang.Deprecated", result.getName());
		Set<I_FieldSignature> fs = result.getFields();
		Set<I_MethodSignature> ms = result.getMethods();
		assertEquals(0, fs.size());
		assertEquals(0, ms.size());
	}
	

	
	@Test
	public void testOverride() {
		I_ClassAttributes result = GWT_2_6_Lang.getOverride();
		assertEquals("java.lang.Override", result.getName());
		Set<I_FieldSignature> fs = result.getFields();
		Set<I_MethodSignature> ms = result.getMethods();
		assertEquals(0, fs.size());
		assertEquals(0, ms.size());
	}
	
	@Test
	public void testSuppressWarnings() {
		I_ClassAttributes result = GWT_2_6_Lang.getSuppressWarnings();
		assertEquals("java.lang.SuppressWarnings", result.getName());
		Set<I_FieldSignature> fs = result.getFields();
		Set<I_MethodSignature> ms = result.getMethods();
		delegates.delegateSuppressWarningsMemberAsserts(result);
		assertEquals(0, fs.size());
		assertEquals(1, ms.size());
	}
	
	@Test
	public void testIterable() {
		I_ClassAttributes result = GWT_2_6_Lang.getIterable();
		assertEquals("java.lang.Iterable", result.getName());
		Set<I_FieldSignature> fs = result.getFields();
		Set<I_MethodSignature> ms = result.getMethods();
		delegates.delegateIterableMemberAsserts(result);
		assertEquals(0, fs.size());
		assertEquals(1, ms.size());
	}
	
	@Test
	public void testEnum() {
		I_ClassAttributes result = GWT_2_6_Lang.getEnum();
		assertEquals("java.lang.Enum", result.getName());
		Set<I_FieldSignature> fs = result.getFields();
		Set<I_MethodSignature> ms = result.getMethods();
		delegates.delegateEnumMemberAsserts(result);
		assertEquals(0, fs.size());
		assertEquals(9, ms.size());
	}

	@Test
	public void testDouble() {
		I_ClassAttributes result = GWT_2_6_Lang.getDouble();
		assertEquals("java.lang.Double", result.getName());
		Set<I_FieldSignature> fs = result.getFields();
		Set<I_MethodSignature> ms = result.getMethods();
		assertContains(ms, new MethodSignature("<init>", 
			new String[] {ClassMethods.DOUBLE}));
		assertContains(ms, new MethodSignature("<init>", 
			new String[] {JSE_Lang.STRING}));
		delegates.delegateDoubleMemberAsserts(result);
		assertEquals(1, fs.size());
		assertEquals(20, ms.size());
	}

	@Test
	public void testInteger() {
		I_ClassAttributes result = GWT_2_6_Lang.getInteger();
		assertEquals("java.lang.Integer", result.getName());
		Set<I_FieldSignature> fs = result.getFields();
		Set<I_MethodSignature> ms = result.getMethods();
		assertContains(ms, new MethodSignature("<init>", 
			new String[] {ClassMethods.INT}));
		assertContains(ms, new MethodSignature("<init>", 
			new String[] {JSE_Lang.STRING}));
		delegates.delegateIntegerMemberAsserts(result);
		assertEquals(1, fs.size());
		assertEquals(35, ms.size());
	}

	@Test
	public void testLong() {
		I_ClassAttributes result = GWT_2_6_Lang.getLong();
		assertEquals("java.lang.Long", result.getName());
		Set<I_FieldSignature> fs = result.getFields();
		Set<I_MethodSignature> ms = result.getMethods();
		assertContains(ms, new MethodSignature("<init>", 
			new String[] {JSE_Lang.STRING}));
		assertContains(ms, new MethodSignature("<init>", 
			new String[] {ClassMethods.LONG}));
		delegates.delegateLongMemberAsserts(result);
		assertEquals(1, fs.size());
		assertEquals(35, ms.size());
	}

	@Test
	public void testMath() {
		I_ClassAttributes result = GWT_2_6_Lang.getMath();
		assertEquals("java.lang.Math", result.getName());
		Set<I_FieldSignature> fs = result.getFields();
		Set<I_MethodSignature> ms = result.getMethods();
		delegates.delegateMathMemberAsserts(result);
		assertEquals(0, fs.size());
		assertEquals(45, ms.size());
	}

	
	@Test
	public void testShort() {
		I_ClassAttributes result = GWT_2_6_Lang.getShort();
		assertEquals("java.lang.Short", result.getName());
		Set<I_FieldSignature> fs = result.getFields();
		Set<I_MethodSignature> ms = result.getMethods();
		assertContains(ms, new MethodSignature("<init>", 
			new String[] {JSE_Lang.STRING}));
		assertContains(ms, new MethodSignature("<init>", 
			new String[] {ClassMethods.SHORT}));
		delegates.delegateShortMemberAsserts(result);
		assertEquals(1, fs.size());
		assertEquals(22, ms.size());
	}

	@Test
	public void testString() {
		I_ClassAttributes result = GWT_2_6_Lang.getString();
		assertEquals("java.lang.String", result.getName());
		Set<I_FieldSignature> fs = result.getFields();
		Set<I_MethodSignature> ms = result.getMethods();
		assertContains(ms, new MethodSignature("<init>"));
		assertContains(ms, new MethodSignature("<init>", 
			new String[] {"[" + ClassMethods.BYTE}));
		assertContains(ms, new MethodSignature("<init>", 
			new String[] {"[" + ClassMethods.BYTE, ClassMethods.INT, 
				ClassMethods.INT}));
		assertContains(ms, new MethodSignature("<init>", 
			new String[] {"[" + ClassMethods.BYTE, ClassMethods.INT, 
				ClassMethods.INT, JSE_Lang.STRING}));
		assertContains(ms, new MethodSignature("<init>", 
			new String[] {"[" + ClassMethods.BYTE, JSE_Lang.STRING}));
		assertContains(ms, new MethodSignature("<init>", 
			new String[] {"[" + ClassMethods.CHAR}));
		assertContains(ms, new MethodSignature("<init>", 
			new String[] {"[" + ClassMethods.CHAR, ClassMethods.INT, ClassMethods.INT}));
		assertContains(ms, new MethodSignature("<init>", 
			new String[] {"[" + ClassMethods.INT, ClassMethods.INT, ClassMethods.INT}));
		assertContains(ms, new MethodSignature("<init>", 
			new String[] {JSE_Lang.STRING}));
		assertContains(ms, new MethodSignature("<init>", 
			new String[] {JSE_Lang.STRING_BUFFER}));
		assertContains(ms, new MethodSignature("<init>", 
			new String[] {JSE_Lang.STRING_BUILDER}));
		delegates.delegateStringMemberAsserts(result);
		assertEquals(1, fs.size());
		assertEquals(71, ms.size());
	}

	
	/**keep at the bottom of the file
	 * 
	 */
	@Override
	public int getTests(I_CountType type) {
		return super.getTests(type, 42);
	}

	@Override
	public int getAsserts(I_CountType type) {
		int thisAsserts = 963;
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
		int thisUniqueAsserts = 902;
		if (type.isFromMetaWithCoverage()) {
			//code coverage and circular dependencies +
			//custom afterTrialTests
			return super.getUniqueAsserts(type, thisUniqueAsserts + 2);
		}  else {
			return super.getUniqueAsserts(type, thisUniqueAsserts);
		}
	}
}
