package org.adligo.tests4j_v1_tests.models.shared.dependency_groups.gwt.v2_6;

import java.util.Set;

import org.adligo.tests4j.models.shared.dependency_groups.jse.JSE_IO;
import org.adligo.tests4j.models.shared.dependency_groups.jse.JSE_Lang;
import org.adligo.tests4j.models.shared.dependency_groups.jse.JSE_Util;
import org.adligo.tests4j.shared.asserts.dependency.FieldSignature;
import org.adligo.tests4j.shared.asserts.dependency.I_ClassAttributes;
import org.adligo.tests4j.shared.asserts.dependency.I_FieldSignature;
import org.adligo.tests4j.shared.asserts.dependency.I_MethodSignature;
import org.adligo.tests4j.shared.asserts.dependency.MethodSignature;
import org.adligo.tests4j.shared.common.ClassMethods;
import org.adligo.tests4j.system.shared.trials.I_Trial;
import org.adligo.tests4j.system.shared.trials.TrialDelegate;

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
			new String[] {JSE_IO.PRINT_STREAM}));
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
	
	public void delegateRunnableMemberAsserts(I_ClassAttributes result) {
		Set<I_MethodSignature> ms = result.getMethods();
		assertContains(ms, new MethodSignature("run"));
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
	
	public void delegateBooleanMemberAsserts(I_ClassAttributes result) {
		delegateObjectMemberAsserts(result);
		Set<I_FieldSignature> fs = result.getFields();
		assertContains(fs, new FieldSignature("FALSE", JSE_Lang.BOOLEAN));
		assertContains(fs, new FieldSignature("TRUE", JSE_Lang.BOOLEAN));
		assertContains(fs, new FieldSignature("TYPE", JSE_Lang.CLASS));
		Set<I_MethodSignature> ms = result.getMethods();
		assertContains(ms, new MethodSignature("booleanValue", 
			ClassMethods.BOOLEAN));
		assertContains(ms, new MethodSignature("parseBoolean", 
			new String[] {JSE_Lang.STRING}, 
			ClassMethods.BOOLEAN));
		assertContains(ms, new MethodSignature("compare", 
			new String[] {ClassMethods.BOOLEAN, ClassMethods.BOOLEAN}, 
			ClassMethods.INT));
		assertContains(ms, new MethodSignature("compareTo", 
			new String[] {JSE_Lang.BOOLEAN}, 
			ClassMethods.INT));
		assertContains(ms, new MethodSignature("valueOf", 
			new String[] {ClassMethods.BOOLEAN}, 
			JSE_Lang.BOOLEAN));
		assertContains(ms, new MethodSignature("valueOf", 
			new String[] {JSE_Lang.STRING}, 
			JSE_Lang.BOOLEAN));
	}
	
	public void delegateByteMemberAsserts(I_ClassAttributes result) {
		delegateNumberMemberAsserts(result);
		Set<I_FieldSignature> fs = result.getFields();
		/**
		 * note MIN_VALUE, MAX_VALUE and SIZE
		 * are always compiled out
		 */
		assertContains(fs, new FieldSignature("TYPE", JSE_Lang.CLASS));
		Set<I_MethodSignature> ms = result.getMethods();
		assertContains(ms, new MethodSignature("equals", 
			new String[] {JSE_Lang.OBJECT}, 
			ClassMethods.BOOLEAN));
		assertContains(ms, new MethodSignature("byteValue", 
			ClassMethods.BYTE));
		assertContains(ms, new MethodSignature("parseByte", 
			new String[] {JSE_Lang.STRING}, 
			ClassMethods.BYTE));
		assertContains(ms, new MethodSignature("parseByte", 
			new String[] {JSE_Lang.STRING, ClassMethods.INT}, 
			ClassMethods.BYTE));
		assertContains(ms, new MethodSignature("compare", 
			new String[] {ClassMethods.BYTE, ClassMethods.BYTE}, 
			ClassMethods.INT));
		assertContains(ms, new MethodSignature("compareTo", 
			new String[] {JSE_Lang.BYTE}, 
			ClassMethods.INT));
		assertContains(ms, new MethodSignature("decode", 
			new String[] {JSE_Lang.STRING}, 
			JSE_Lang.BYTE));
		assertContains(ms, new MethodSignature("valueOf", 
			new String[] {ClassMethods.BYTE}, 
			JSE_Lang.BYTE));
		assertContains(ms, new MethodSignature("valueOf", 
			new String[] {JSE_Lang.STRING}, 
			JSE_Lang.BYTE));
		assertContains(ms, new MethodSignature("valueOf", 
			new String[] {JSE_Lang.STRING, ClassMethods.INT}, 
			JSE_Lang.BYTE));
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
	
	public void delegateClassMemberAsserts(I_ClassAttributes result) {
		delegateObjectMemberAsserts(result);
		Set<I_MethodSignature> ms = result.getMethods();
		assertContains(ms, new MethodSignature("getEnumConstants", 
			"[" + JSE_Lang.OBJECT));
		assertContains(ms, new MethodSignature("desiredAssertionStatus", 
			ClassMethods.BOOLEAN));
		assertContains(ms, new MethodSignature("isArray", 
			ClassMethods.BOOLEAN));
		assertContains(ms, new MethodSignature("isEnum", 
			ClassMethods.BOOLEAN));
		assertContains(ms, new MethodSignature("isInterface", 
			ClassMethods.BOOLEAN));
		assertContains(ms, new MethodSignature("isPrimitive", 
			ClassMethods.BOOLEAN));
		assertContains(ms, new MethodSignature("getComponentType", 
			JSE_Lang.CLASS));
		assertContains(ms, new MethodSignature("getSuperclass", 
			JSE_Lang.CLASS));
		assertContains(ms, new MethodSignature("getName", 
			JSE_Lang.STRING));
		assertContains(ms, new MethodSignature("getSimpleName", 
			JSE_Lang.STRING));
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

	public void delegateNumberMemberAsserts(I_ClassAttributes result) {
		delegateObjectMemberAsserts(result);
		Set<I_MethodSignature> ms = result.getMethods();
		assertContains(ms, new MethodSignature("byteValue", 
			ClassMethods.BYTE));
		assertContains(ms, new MethodSignature("doubleValue", 
			ClassMethods.DOUBLE));
		assertContains(ms, new MethodSignature("floatValue", 
			ClassMethods.FLOAT));
		assertContains(ms, new MethodSignature("intValue", 
			ClassMethods.INT));
		assertContains(ms, new MethodSignature("longValue", 
			ClassMethods.LONG));
		assertContains(ms, new MethodSignature("shortValue", 
			ClassMethods.SHORT));
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
	
	public void delegateCharacterMemberAsserts(I_ClassAttributes result) {
		delegateObjectMemberAsserts(result);
		Set<I_FieldSignature> fs = result.getFields();
		assertContains(fs, new FieldSignature("TYPE", JSE_Lang.CLASS));
		Set<I_MethodSignature> ms = result.getMethods();
		assertContains(ms, new MethodSignature("toChars", 
			new String[] {ClassMethods.INT}, 
			"[" + ClassMethods.CHAR));
		assertContains(ms, new MethodSignature("isDigit", 
			new String[] {ClassMethods.CHAR}, 
			ClassMethods.BOOLEAN));
		assertContains(ms, new MethodSignature("isHighSurrogate", 
			new String[] {ClassMethods.CHAR}, 
			ClassMethods.BOOLEAN));
		assertContains(ms, new MethodSignature("isLetter", 
			new String[] {ClassMethods.CHAR}, 
			ClassMethods.BOOLEAN));
		assertContains(ms, new MethodSignature("isLetterOrDigit", 
			new String[] {ClassMethods.CHAR}, 
			ClassMethods.BOOLEAN));
		assertContains(ms, new MethodSignature("isLowSurrogate", 
			new String[] {ClassMethods.CHAR}, 
			ClassMethods.BOOLEAN));
		assertContains(ms, new MethodSignature("isLowerCase", 
			new String[] {ClassMethods.CHAR}, 
			ClassMethods.BOOLEAN));
		assertContains(ms, new MethodSignature("isSpace", 
			new String[] {ClassMethods.CHAR}, 
			ClassMethods.BOOLEAN));
		assertContains(ms, new MethodSignature("isSupplementaryCodePoint", 
			new String[] {ClassMethods.INT}, 
			ClassMethods.BOOLEAN));
		assertContains(ms, new MethodSignature("isSurrogatePair", 
			new String[] {ClassMethods.CHAR, ClassMethods.CHAR}, 
			ClassMethods.BOOLEAN));
		assertContains(ms, new MethodSignature("isUpperCase", 
			new String[] {ClassMethods.CHAR}, 
			ClassMethods.BOOLEAN));
		assertContains(ms, new MethodSignature("isValidCodePoint", 
			new String[] {ClassMethods.INT}, 
			ClassMethods.BOOLEAN));
		assertContains(ms, new MethodSignature("charValue", 
			ClassMethods.CHAR));
		assertContains(ms, new MethodSignature("toLowerCase", 
			new String[] {ClassMethods.CHAR}, 
			ClassMethods.CHAR));
		assertContains(ms, new MethodSignature("toUpperCase", 
			new String[] {ClassMethods.CHAR}, 
			ClassMethods.CHAR));
		assertContains(ms, new MethodSignature("charCount", 
			new String[] {ClassMethods.INT}, 
			ClassMethods.INT));
		assertContains(ms, new MethodSignature("codePointAt", 
			new String[] {"[" + ClassMethods.CHAR, ClassMethods.INT}, 
			ClassMethods.INT));
		assertContains(ms, new MethodSignature("codePointAt", 
			new String[] {"[" + ClassMethods.CHAR, ClassMethods.INT, ClassMethods.INT}, 
			ClassMethods.INT));
		assertContains(ms, new MethodSignature("codePointAt", 
			new String[] {JSE_Lang.CHAR_SEQUENCE, ClassMethods.INT}, 
			ClassMethods.INT));
		assertContains(ms, new MethodSignature("codePointBefore", 
			new String[] {"[" + ClassMethods.CHAR, ClassMethods.INT}, 
			ClassMethods.INT));
		assertContains(ms, new MethodSignature("codePointBefore", 
			new String[] {"[" + ClassMethods.CHAR, ClassMethods.INT, ClassMethods.INT}, 
			ClassMethods.INT));
		assertContains(ms, new MethodSignature("codePointBefore", 
			new String[] {JSE_Lang.CHAR_SEQUENCE, ClassMethods.INT}, 
			ClassMethods.INT));
		assertContains(ms, new MethodSignature("codePointCount", 
			new String[] {"[" + ClassMethods.CHAR, ClassMethods.INT, ClassMethods.INT}, 
			ClassMethods.INT));
		assertContains(ms, new MethodSignature("codePointCount", 
			new String[] {JSE_Lang.CHAR_SEQUENCE, ClassMethods.INT, ClassMethods.INT}, 
			ClassMethods.INT));
		assertContains(ms, new MethodSignature("compare", 
			new String[] {ClassMethods.CHAR, ClassMethods.CHAR}, 
			ClassMethods.INT));
		assertContains(ms, new MethodSignature("compareTo", 
			new String[] {JSE_Lang.CHARACTER}, 
			ClassMethods.INT));
		assertContains(ms, new MethodSignature("offsetByCodePoints", 
			new String[] {"[" + ClassMethods.CHAR, ClassMethods.INT, ClassMethods.INT, ClassMethods.INT, ClassMethods.INT}, 
			ClassMethods.INT));
		assertContains(ms, new MethodSignature("offsetByCodePoints", 
			new String[] {JSE_Lang.CHAR_SEQUENCE, ClassMethods.INT, ClassMethods.INT}, 
			ClassMethods.INT));
		assertContains(ms, new MethodSignature("toChars", 
			new String[] {ClassMethods.INT, "[" + ClassMethods.CHAR, ClassMethods.INT}, 
			ClassMethods.INT));
		assertContains(ms, new MethodSignature("toCodePoint", 
			new String[] {ClassMethods.CHAR, ClassMethods.CHAR}, 
			ClassMethods.INT));
		assertContains(ms, new MethodSignature("valueOf", 
			new String[] {ClassMethods.CHAR}, 
			JSE_Lang.CHARACTER));
	}

	public void delegateComparableMemberAsserts(I_ClassAttributes result) {
		Set<I_MethodSignature> ms = result.getMethods();
		assertContains(ms, new MethodSignature("compareTo", 
			new String[] {JSE_Lang.OBJECT}, 
			ClassMethods.INT));
	}
	
	public void delegateSuppressWarningsMemberAsserts(I_ClassAttributes result) {
		Set<I_MethodSignature> ms = result.getMethods();
		assertContains(ms, new MethodSignature("value", 
				"[" + JSE_Lang.STRING));
	}
	
	public void delegateEnumMemberAsserts(I_ClassAttributes result) {
		delegateObjectMemberAsserts(result);
		Set<I_MethodSignature> ms = result.getMethods();
		
		assertContains(ms, new MethodSignature("compareTo", 
			new String[] {JSE_Lang.ENUM}, 
			ClassMethods.INT));
		assertContains(ms, new MethodSignature("ordinal", 
			ClassMethods.INT));
		assertContains(ms, new MethodSignature("getDeclaringClass", 
			JSE_Lang.CLASS));
		assertContains(ms, new MethodSignature("valueOf", 
			new String[] {JSE_Lang.CLASS, JSE_Lang.STRING}, 
			JSE_Lang.ENUM));
		assertContains(ms, new MethodSignature("name", 
			JSE_Lang.STRING));
	}
	
	public void delegateDoubleMemberAsserts(I_ClassAttributes result) {
		delegateNumberMemberAsserts(result);
		Set<I_FieldSignature> fs = result.getFields();

		assertContains(fs, new FieldSignature("TYPE", JSE_Lang.CLASS));
		Set<I_MethodSignature> ms = result.getMethods();
		assertContains(ms, new MethodSignature("isNaN", 
			ClassMethods.BOOLEAN));
		assertContains(ms, new MethodSignature("isNaN", 
			new String[] {ClassMethods.DOUBLE}, 
			ClassMethods.BOOLEAN));
		assertContains(ms, new MethodSignature("byteValue", 
			ClassMethods.BYTE));
		assertContains(ms, new MethodSignature("doubleValue", 
			ClassMethods.DOUBLE));
		assertContains(ms, new MethodSignature("parseDouble", 
			new String[] {JSE_Lang.STRING}, 
			ClassMethods.DOUBLE));
		assertContains(ms, new MethodSignature("floatValue", 
			ClassMethods.FLOAT));
		assertContains(ms, new MethodSignature("compare", 
			new String[] {ClassMethods.DOUBLE, ClassMethods.DOUBLE}, 
			ClassMethods.INT));
		assertContains(ms, new MethodSignature("compareTo", 
			new String[] {JSE_Lang.DOUBLE}, 
			ClassMethods.INT));
		assertContains(ms, new MethodSignature("intValue", 
			ClassMethods.INT));
		assertContains(ms, new MethodSignature("valueOf", 
			new String[] {ClassMethods.DOUBLE}, 
			JSE_Lang.DOUBLE));
		assertContains(ms, new MethodSignature("toString", 
			JSE_Lang.STRING));
		assertContains(ms, new MethodSignature("toString", 
			new String[] {ClassMethods.DOUBLE}, 
			JSE_Lang.STRING));
		assertContains(ms, new MethodSignature("longValue", 
			ClassMethods.LONG));
		assertContains(ms, new MethodSignature("shortValue", 
			ClassMethods.SHORT));
	}
	
	public void delegateFloatMemberAsserts(I_ClassAttributes result) {
		delegateNumberMemberAsserts(result);
		Set<I_FieldSignature> fs = result.getFields();

		assertContains(fs, new FieldSignature("TYPE", JSE_Lang.CLASS));
		Set<I_MethodSignature> ms = result.getMethods();

		assertContains(ms, new MethodSignature("isNaN", 
			ClassMethods.BOOLEAN));
		assertContains(ms, new MethodSignature("isNaN", 
			new String[] {ClassMethods.FLOAT}, 
			ClassMethods.BOOLEAN));
		assertContains(ms, new MethodSignature("byteValue", 
			ClassMethods.BYTE));
		assertContains(ms, new MethodSignature("doubleValue", 
			ClassMethods.DOUBLE));
		assertContains(ms, new MethodSignature("floatValue", 
			ClassMethods.FLOAT));
		assertContains(ms, new MethodSignature("intBitsToFloat", 
			new String[] {ClassMethods.INT}, 
			ClassMethods.FLOAT));
		assertContains(ms, new MethodSignature("parseFloat", 
			new String[] {JSE_Lang.STRING}, 
			ClassMethods.FLOAT));
		assertContains(ms, new MethodSignature("compare", 
			new String[] {ClassMethods.FLOAT, ClassMethods.FLOAT}, 
			ClassMethods.INT));
		assertContains(ms, new MethodSignature("compareTo", 
			new String[] {JSE_Lang.FLOAT}, 
			ClassMethods.INT));
		assertContains(ms, new MethodSignature("floatToIntBits", 
			new String[] {ClassMethods.FLOAT}, 
			ClassMethods.INT));
		assertContains(ms, new MethodSignature("intValue", 
			ClassMethods.INT));
		assertContains(ms, new MethodSignature("valueOf", 
			new String[] {ClassMethods.FLOAT}, 
			JSE_Lang.FLOAT));
		assertContains(ms, new MethodSignature("valueOf", 
			new String[] {JSE_Lang.STRING}, 
			JSE_Lang.FLOAT));
		assertContains(ms, new MethodSignature("toString", 
			JSE_Lang.STRING));
		assertContains(ms, new MethodSignature("toString", 
			new String[] {ClassMethods.FLOAT}, 
			JSE_Lang.STRING));
		assertContains(ms, new MethodSignature("longValue", 
			ClassMethods.LONG));
		assertContains(ms, new MethodSignature("shortValue", 
			ClassMethods.SHORT));
	}
	
	public void delegateIntegerMemberAsserts(I_ClassAttributes result) {
		delegateNumberMemberAsserts(result);
		Set<I_FieldSignature> fs = result.getFields();
		assertContains(fs, new FieldSignature("TYPE", JSE_Lang.CLASS));
		Set<I_MethodSignature> ms = result.getMethods();
		assertContains(ms, new MethodSignature("byteValue", 
			ClassMethods.BYTE));
		assertContains(ms, new MethodSignature("doubleValue", 
			ClassMethods.DOUBLE));
		assertContains(ms, new MethodSignature("floatValue", 
			ClassMethods.FLOAT));
		assertContains(ms, new MethodSignature("bitCount", 
			new String[] {ClassMethods.INT}, 
			ClassMethods.INT));
		assertContains(ms, new MethodSignature("compare", 
			new String[] {ClassMethods.INT, ClassMethods.INT}, 
			ClassMethods.INT));
		assertContains(ms, new MethodSignature("compareTo", 
			new String[] {JSE_Lang.INTEGER}, 
			ClassMethods.INT));
		assertContains(ms, new MethodSignature("hashCode", 
			ClassMethods.INT));
		assertContains(ms, new MethodSignature("highestOneBit", 
			new String[] {ClassMethods.INT}, 
			ClassMethods.INT));
		assertContains(ms, new MethodSignature("intValue", 
			ClassMethods.INT));
		assertContains(ms, new MethodSignature("lowestOneBit", 
			new String[] {ClassMethods.INT}, 
			ClassMethods.INT));
		assertContains(ms, new MethodSignature("numberOfLeadingZeros", 
			new String[] {ClassMethods.INT}, 
			ClassMethods.INT));
		assertContains(ms, new MethodSignature("numberOfTrailingZeros", 
			new String[] {ClassMethods.INT}, 
			ClassMethods.INT));
		assertContains(ms, new MethodSignature("parseInt", 
			new String[] {JSE_Lang.STRING}, 
			ClassMethods.INT));
		assertContains(ms, new MethodSignature("parseInt", 
			new String[] {JSE_Lang.STRING, ClassMethods.INT}, 
			ClassMethods.INT));
		assertContains(ms, new MethodSignature("reverse", 
			new String[] {ClassMethods.INT}, 
			ClassMethods.INT));
		assertContains(ms, new MethodSignature("reverseBytes", 
			new String[] {ClassMethods.INT}, 
			ClassMethods.INT));
		assertContains(ms, new MethodSignature("rotateLeft", 
			new String[] {ClassMethods.INT, ClassMethods.INT}, 
			ClassMethods.INT));
		assertContains(ms, new MethodSignature("rotateRight", 
			new String[] {ClassMethods.INT, ClassMethods.INT}, 
			ClassMethods.INT));
		assertContains(ms, new MethodSignature("signum", 
			new String[] {ClassMethods.INT}, 
			ClassMethods.INT));
		assertContains(ms, new MethodSignature("decode", 
			new String[] {JSE_Lang.STRING}, 
			JSE_Lang.INTEGER));
		assertContains(ms, new MethodSignature("valueOf", 
			new String[] {ClassMethods.INT}, 
			JSE_Lang.INTEGER));
		assertContains(ms, new MethodSignature("valueOf", 
			new String[] {JSE_Lang.STRING}, 
			JSE_Lang.INTEGER));
		assertContains(ms, new MethodSignature("valueOf", 
			new String[] {JSE_Lang.STRING, ClassMethods.INT}, 
			JSE_Lang.INTEGER));
		assertContains(ms, new MethodSignature("toBinaryString", 
			new String[] {ClassMethods.INT}, 
			JSE_Lang.STRING));
		assertContains(ms, new MethodSignature("toHexString", 
			new String[] {ClassMethods.INT}, 
			JSE_Lang.STRING));
		assertContains(ms, new MethodSignature("toOctalString", 
			new String[] {ClassMethods.INT}, 
			JSE_Lang.STRING));
		assertContains(ms, new MethodSignature("toString", 
			JSE_Lang.STRING));
		assertContains(ms, new MethodSignature("toString", 
			new String[] {ClassMethods.INT}, 
			JSE_Lang.STRING));
		assertContains(ms, new MethodSignature("toString", 
			new String[] {ClassMethods.INT, ClassMethods.INT}, 
			JSE_Lang.STRING));
		assertContains(ms, new MethodSignature("longValue", 
			ClassMethods.LONG));
		assertContains(ms, new MethodSignature("shortValue", 
			ClassMethods.SHORT));
	}
	
	public void delegateIterableMemberAsserts(I_ClassAttributes result) {
		Set<I_MethodSignature> ms = result.getMethods();
		assertContains(ms, new MethodSignature("iterator", 
			JSE_Util.ITERATOR));
	}
	
	public void delegateLongMemberAsserts(I_ClassAttributes result) {
		delegateNumberMemberAsserts(result);
		Set<I_FieldSignature> fs = result.getFields();

		assertContains(fs, new FieldSignature("TYPE", JSE_Lang.CLASS));
		Set<I_MethodSignature> ms = result.getMethods();

		assertContains(ms, new MethodSignature("byteValue", 
			ClassMethods.BYTE));
		assertContains(ms, new MethodSignature("doubleValue", 
			ClassMethods.DOUBLE));
		assertContains(ms, new MethodSignature("floatValue", 
			ClassMethods.FLOAT));
		assertContains(ms, new MethodSignature("bitCount", 
			new String[] {ClassMethods.LONG}, 
			ClassMethods.INT));
		assertContains(ms, new MethodSignature("compare", 
			new String[] {ClassMethods.LONG, ClassMethods.LONG}, 
			ClassMethods.INT));
		assertContains(ms, new MethodSignature("compareTo", 
			new String[] {JSE_Lang.LONG}, 
			ClassMethods.INT));
		assertContains(ms, new MethodSignature("intValue", 
			ClassMethods.INT));
		assertContains(ms, new MethodSignature("numberOfLeadingZeros", 
			new String[] {ClassMethods.LONG}, 
			ClassMethods.INT));
		assertContains(ms, new MethodSignature("numberOfTrailingZeros", 
			new String[] {ClassMethods.LONG}, 
			ClassMethods.INT));
		assertContains(ms, new MethodSignature("signum", 
			new String[] {ClassMethods.LONG}, 
			ClassMethods.INT));
		assertContains(ms, new MethodSignature("decode", 
			new String[] {JSE_Lang.STRING}, 
			JSE_Lang.LONG));
		assertContains(ms, new MethodSignature("valueOf", 
			new String[] {JSE_Lang.STRING}, 
			JSE_Lang.LONG));
		assertContains(ms, new MethodSignature("valueOf", 
			new String[] {JSE_Lang.STRING, ClassMethods.INT}, 
			JSE_Lang.LONG));
		assertContains(ms, new MethodSignature("valueOf", 
			new String[] {ClassMethods.LONG}, 
			JSE_Lang.LONG));
		assertContains(ms, new MethodSignature("toBinaryString", 
			new String[] {ClassMethods.LONG}, 
			JSE_Lang.STRING));
		assertContains(ms, new MethodSignature("toHexString", 
			new String[] {ClassMethods.LONG}, 
			JSE_Lang.STRING));
		assertContains(ms, new MethodSignature("toOctalString", 
			new String[] {ClassMethods.LONG}, 
			JSE_Lang.STRING));
		assertContains(ms, new MethodSignature("toString", 
			JSE_Lang.STRING));
		assertContains(ms, new MethodSignature("toString", 
			new String[] {ClassMethods.LONG}, 
			JSE_Lang.STRING));
		assertContains(ms, new MethodSignature("toString", 
			new String[] {ClassMethods.LONG, ClassMethods.INT}, 
			JSE_Lang.STRING));
		assertContains(ms, new MethodSignature("highestOneBit", 
			new String[] {ClassMethods.LONG}, 
			ClassMethods.LONG));
		assertContains(ms, new MethodSignature("longValue", 
			ClassMethods.LONG));
		assertContains(ms, new MethodSignature("lowestOneBit", 
			new String[] {ClassMethods.LONG}, 
			ClassMethods.LONG));
		assertContains(ms, new MethodSignature("parseLong", 
			new String[] {JSE_Lang.STRING}, 
			ClassMethods.LONG));
		assertContains(ms, new MethodSignature("parseLong", 
			new String[] {JSE_Lang.STRING, ClassMethods.INT}, 
			ClassMethods.LONG));
		assertContains(ms, new MethodSignature("reverse", 
			new String[] {ClassMethods.LONG}, 
			ClassMethods.LONG));
		assertContains(ms, new MethodSignature("reverseBytes", 
			new String[] {ClassMethods.LONG}, 
			ClassMethods.LONG));
		assertContains(ms, new MethodSignature("rotateLeft", 
			new String[] {ClassMethods.LONG, ClassMethods.INT}, 
			ClassMethods.LONG));
		assertContains(ms, new MethodSignature("rotateRight", 
			new String[] {ClassMethods.LONG, ClassMethods.INT}, 
			ClassMethods.LONG));
		assertContains(ms, new MethodSignature("shortValue", 
			ClassMethods.SHORT));
	}
	
	
	public void delegateMathMemberAsserts(I_ClassAttributes result) {
		Set<I_MethodSignature> ms = result.getMethods();
		assertContains(ms, new MethodSignature("abs", 
			new String[] {ClassMethods.DOUBLE}, 
			ClassMethods.DOUBLE));
		assertContains(ms, new MethodSignature("acos", 
			new String[] {ClassMethods.DOUBLE}, 
			ClassMethods.DOUBLE));
		assertContains(ms, new MethodSignature("asin", 
			new String[] {ClassMethods.DOUBLE}, 
			ClassMethods.DOUBLE));
		assertContains(ms, new MethodSignature("atan", 
			new String[] {ClassMethods.DOUBLE}, 
			ClassMethods.DOUBLE));
		assertContains(ms, new MethodSignature("atan2", 
			new String[] {ClassMethods.DOUBLE, ClassMethods.DOUBLE}, 
			ClassMethods.DOUBLE));
		assertContains(ms, new MethodSignature("cbrt", 
			new String[] {ClassMethods.DOUBLE}, 
			ClassMethods.DOUBLE));
		assertContains(ms, new MethodSignature("ceil", 
			new String[] {ClassMethods.DOUBLE}, 
			ClassMethods.DOUBLE));
		assertContains(ms, new MethodSignature("copySign", 
			new String[] {ClassMethods.DOUBLE, ClassMethods.DOUBLE}, 
			ClassMethods.DOUBLE));
		assertContains(ms, new MethodSignature("cos", 
			new String[] {ClassMethods.DOUBLE}, 
			ClassMethods.DOUBLE));
		assertContains(ms, new MethodSignature("cosh", 
			new String[] {ClassMethods.DOUBLE}, 
			ClassMethods.DOUBLE));
		assertContains(ms, new MethodSignature("exp", 
			new String[] {ClassMethods.DOUBLE}, 
			ClassMethods.DOUBLE));
		assertContains(ms, new MethodSignature("expm1", 
			new String[] {ClassMethods.DOUBLE}, 
			ClassMethods.DOUBLE));
		assertContains(ms, new MethodSignature("floor", 
			new String[] {ClassMethods.DOUBLE}, 
			ClassMethods.DOUBLE));
		assertContains(ms, new MethodSignature("hypot", 
			new String[] {ClassMethods.DOUBLE, ClassMethods.DOUBLE}, 
			ClassMethods.DOUBLE));
		assertContains(ms, new MethodSignature("log", 
			new String[] {ClassMethods.DOUBLE}, 
			ClassMethods.DOUBLE));
		assertContains(ms, new MethodSignature("log10", 
			new String[] {ClassMethods.DOUBLE}, 
			ClassMethods.DOUBLE));
		assertContains(ms, new MethodSignature("log1p", 
			new String[] {ClassMethods.DOUBLE}, 
			ClassMethods.DOUBLE));
		assertContains(ms, new MethodSignature("max", 
			new String[] {ClassMethods.DOUBLE, ClassMethods.DOUBLE}, 
			ClassMethods.DOUBLE));
		assertContains(ms, new MethodSignature("min", 
			new String[] {ClassMethods.DOUBLE, ClassMethods.DOUBLE}, 
			ClassMethods.DOUBLE));
		assertContains(ms, new MethodSignature("pow", 
			new String[] {ClassMethods.DOUBLE, ClassMethods.DOUBLE}, 
			ClassMethods.DOUBLE));
		assertContains(ms, new MethodSignature("random", 
			ClassMethods.DOUBLE));
		assertContains(ms, new MethodSignature("rint", 
			new String[] {ClassMethods.DOUBLE}, 
			ClassMethods.DOUBLE));
		assertContains(ms, new MethodSignature("scalb", 
			new String[] {ClassMethods.DOUBLE, ClassMethods.INT}, 
			ClassMethods.DOUBLE));
		assertContains(ms, new MethodSignature("signum", 
			new String[] {ClassMethods.DOUBLE}, 
			ClassMethods.DOUBLE));
		assertContains(ms, new MethodSignature("sin", 
			new String[] {ClassMethods.DOUBLE}, 
			ClassMethods.DOUBLE));
		assertContains(ms, new MethodSignature("sinh", 
			new String[] {ClassMethods.DOUBLE}, 
			ClassMethods.DOUBLE));
		assertContains(ms, new MethodSignature("sqrt", 
			new String[] {ClassMethods.DOUBLE}, 
			ClassMethods.DOUBLE));
		assertContains(ms, new MethodSignature("tan", 
			new String[] {ClassMethods.DOUBLE}, 
			ClassMethods.DOUBLE));
		assertContains(ms, new MethodSignature("tanh", 
			new String[] {ClassMethods.DOUBLE}, 
			ClassMethods.DOUBLE));
		assertContains(ms, new MethodSignature("toDegrees", 
			new String[] {ClassMethods.DOUBLE}, 
			ClassMethods.DOUBLE));
		assertContains(ms, new MethodSignature("toRadians", 
			new String[] {ClassMethods.DOUBLE}, 
			ClassMethods.DOUBLE));
		assertContains(ms, new MethodSignature("abs", 
			new String[] {ClassMethods.FLOAT}, 
			ClassMethods.FLOAT));
		assertContains(ms, new MethodSignature("copySign", 
			new String[] {ClassMethods.FLOAT, ClassMethods.FLOAT}, 
			ClassMethods.FLOAT));
		assertContains(ms, new MethodSignature("max", 
			new String[] {ClassMethods.FLOAT, ClassMethods.FLOAT}, 
			ClassMethods.FLOAT));
		assertContains(ms, new MethodSignature("min", 
			new String[] {ClassMethods.FLOAT, ClassMethods.FLOAT}, 
			ClassMethods.FLOAT));
		assertContains(ms, new MethodSignature("scalb", 
			new String[] {ClassMethods.FLOAT, ClassMethods.INT}, 
			ClassMethods.FLOAT));
		assertContains(ms, new MethodSignature("signum", 
			new String[] {ClassMethods.FLOAT}, 
			ClassMethods.FLOAT));
		assertContains(ms, new MethodSignature("abs", 
			new String[] {ClassMethods.INT}, 
			ClassMethods.INT));
		assertContains(ms, new MethodSignature("max", 
			new String[] {ClassMethods.INT, ClassMethods.INT}, 
			ClassMethods.INT));
		assertContains(ms, new MethodSignature("min", 
			new String[] {ClassMethods.INT, ClassMethods.INT}, 
			ClassMethods.INT));
		assertContains(ms, new MethodSignature("round", 
			new String[] {ClassMethods.FLOAT}, 
			ClassMethods.INT));
		assertContains(ms, new MethodSignature("abs", 
			new String[] {ClassMethods.LONG}, 
			ClassMethods.LONG));
		assertContains(ms, new MethodSignature("max", 
			new String[] {ClassMethods.LONG, ClassMethods.LONG}, 
			ClassMethods.LONG));
		assertContains(ms, new MethodSignature("min", 
			new String[] {ClassMethods.LONG, ClassMethods.LONG}, 
			ClassMethods.LONG));
		assertContains(ms, new MethodSignature("round", 
			new String[] {ClassMethods.DOUBLE}, 
			ClassMethods.LONG));
	}
	
	public void delegateShortMemberAsserts(I_ClassAttributes result) {
		delegateNumberMemberAsserts(result);
		Set<I_FieldSignature> fs = result.getFields();
		assertContains(fs, new FieldSignature("TYPE", JSE_Lang.CLASS));
		Set<I_MethodSignature> ms = result.getMethods();
		assertContains(ms, new MethodSignature("byteValue", 
			ClassMethods.BYTE));
		assertContains(ms, new MethodSignature("doubleValue", 
			ClassMethods.DOUBLE));
		assertContains(ms, new MethodSignature("floatValue", 
			ClassMethods.FLOAT));
		assertContains(ms, new MethodSignature("compare", 
			new String[] {ClassMethods.SHORT, ClassMethods.SHORT}, 
			ClassMethods.INT));
		assertContains(ms, new MethodSignature("compareTo", 
			new String[] {JSE_Lang.SHORT}, 
			ClassMethods.INT));
		assertContains(ms, new MethodSignature("intValue", 
			ClassMethods.INT));
		assertContains(ms, new MethodSignature("decode", 
			new String[] {JSE_Lang.STRING}, 
			JSE_Lang.SHORT));
		assertContains(ms, new MethodSignature("valueOf", 
			new String[] {JSE_Lang.STRING}, 
			JSE_Lang.SHORT));
		assertContains(ms, new MethodSignature("valueOf", 
			new String[] {JSE_Lang.STRING, ClassMethods.INT}, 
			JSE_Lang.SHORT));
		assertContains(ms, new MethodSignature("valueOf", 
			new String[] {ClassMethods.SHORT}, 
			JSE_Lang.SHORT));
		assertContains(ms, new MethodSignature("toString", 
			new String[] {ClassMethods.SHORT}, 
			JSE_Lang.STRING));
		assertContains(ms, new MethodSignature("longValue", 
			ClassMethods.LONG));
		assertContains(ms, new MethodSignature("parseShort", 
			new String[] {JSE_Lang.STRING}, 
			ClassMethods.SHORT));
		assertContains(ms, new MethodSignature("parseShort", 
			new String[] {JSE_Lang.STRING, ClassMethods.INT}, 
			ClassMethods.SHORT));
		assertContains(ms, new MethodSignature("reverseBytes", 
			new String[] {ClassMethods.SHORT}, 
			ClassMethods.SHORT));
		assertContains(ms, new MethodSignature("shortValue", 
			ClassMethods.SHORT));
	}
	
	public void delegateStringMemberAsserts(I_ClassAttributes result) {
		delegateObjectMemberAsserts(result);
		Set<I_FieldSignature> fs = result.getFields();
		assertContains(fs, new FieldSignature("CASE_INSENSITIVE_ORDER", 
				"java.util.Comparator"));
		Set<I_MethodSignature> ms = result.getMethods();
		assertContains(ms, new MethodSignature("getBytes", 
			"[" + ClassMethods.BYTE));
		assertContains(ms, new MethodSignature("getBytes", 
			new String[] {JSE_Lang.STRING}, 
			"[" + ClassMethods.BYTE));
		assertContains(ms, new MethodSignature("toCharArray", 
				"[" + ClassMethods.CHAR));
		assertContains(ms, new MethodSignature("split", 
			new String[] {JSE_Lang.STRING}, 
			"[" + JSE_Lang.STRING));
		assertContains(ms, new MethodSignature("split", 
			new String[] {JSE_Lang.STRING, ClassMethods.INT}, 
			"[" + JSE_Lang.STRING));
		assertContains(ms, new MethodSignature("contains", 
			new String[] {JSE_Lang.CHAR_SEQUENCE}, 
			ClassMethods.BOOLEAN));
		assertContains(ms, new MethodSignature("contentEquals", 
			new String[] {JSE_Lang.CHAR_SEQUENCE}, 
			ClassMethods.BOOLEAN));
		assertContains(ms, new MethodSignature("contentEquals", 
			new String[] {JSE_Lang.STRING_BUFFER}, 
			ClassMethods.BOOLEAN));
		assertContains(ms, new MethodSignature("endsWith", 
			new String[] {JSE_Lang.STRING}, 
			ClassMethods.BOOLEAN));
		assertContains(ms, new MethodSignature("equals", 
			new String[] {JSE_Lang.OBJECT}, 
			ClassMethods.BOOLEAN));
		assertContains(ms, new MethodSignature("equalsIgnoreCase", 
			new String[] {JSE_Lang.STRING}, 
			ClassMethods.BOOLEAN));
		assertContains(ms, new MethodSignature("isEmpty", 
			ClassMethods.BOOLEAN));
		assertContains(ms, new MethodSignature("matches", 
			new String[] {JSE_Lang.STRING}, 
			ClassMethods.BOOLEAN));
		assertContains(ms, new MethodSignature("regionMatches", 
			new String[] {ClassMethods.BOOLEAN, ClassMethods.INT,
				JSE_Lang.STRING, ClassMethods.INT, ClassMethods.INT}, 
			ClassMethods.BOOLEAN));
		assertContains(ms, new MethodSignature("regionMatches", 
			new String[] {ClassMethods.INT, JSE_Lang.STRING, 
				ClassMethods.INT, ClassMethods.INT}, 
			ClassMethods.BOOLEAN));
		assertContains(ms, new MethodSignature("startsWith", 
			new String[] {JSE_Lang.STRING}, 
			ClassMethods.BOOLEAN));
		assertContains(ms, new MethodSignature("startsWith", 
			new String[] {JSE_Lang.STRING, ClassMethods.INT}, 
			ClassMethods.BOOLEAN));
		assertContains(ms, new MethodSignature("charAt", 
			new String[] {ClassMethods.INT}, 
			ClassMethods.CHAR));
		assertContains(ms, new MethodSignature("codePointAt", 
			new String[] {ClassMethods.INT}, 
			ClassMethods.INT));
		assertContains(ms, new MethodSignature("codePointBefore", 
			new String[] {ClassMethods.INT}, 
			ClassMethods.INT));
		assertContains(ms, new MethodSignature("codePointCount", 
			new String[] {ClassMethods.INT, ClassMethods.INT}, 
			ClassMethods.INT));
		assertContains(ms, new MethodSignature("compareTo", 
			new String[] {JSE_Lang.STRING}, 
			ClassMethods.INT));
		assertContains(ms, new MethodSignature("compareToIgnoreCase", 
			new String[] {JSE_Lang.STRING}, 
			ClassMethods.INT));
		assertContains(ms, new MethodSignature("indexOf", 
			new String[] {ClassMethods.INT}, 
			ClassMethods.INT));
		assertContains(ms, new MethodSignature("indexOf", 
			new String[] {ClassMethods.INT, ClassMethods.INT}, 
			ClassMethods.INT));
		assertContains(ms, new MethodSignature("indexOf", 
			new String[] {JSE_Lang.STRING}, 
			ClassMethods.INT));
		assertContains(ms, new MethodSignature("indexOf", 
			new String[] {JSE_Lang.STRING, ClassMethods.INT}, 
			ClassMethods.INT));
		assertContains(ms, new MethodSignature("lastIndexOf", 
			new String[] {ClassMethods.INT}, 
			ClassMethods.INT));
		assertContains(ms, new MethodSignature("lastIndexOf", 
			new String[] {ClassMethods.INT, ClassMethods.INT}, 
			ClassMethods.INT));
		assertContains(ms, new MethodSignature("lastIndexOf", 
			new String[] {JSE_Lang.STRING}, 
			ClassMethods.INT));
		assertContains(ms, new MethodSignature("lastIndexOf", 
			new String[] {JSE_Lang.STRING, ClassMethods.INT}, 
			ClassMethods.INT));
		assertContains(ms, new MethodSignature("length", 
			ClassMethods.INT));
		assertContains(ms, new MethodSignature("offsetByCodePoints", 
			new String[] {ClassMethods.INT, ClassMethods.INT}, 
			ClassMethods.INT));
		assertContains(ms, new MethodSignature("subSequence", 
			new String[] {ClassMethods.INT, ClassMethods.INT}, 
			JSE_Lang.CHAR_SEQUENCE));
		assertContains(ms, new MethodSignature("concat", 
			new String[] {JSE_Lang.STRING}, 
			JSE_Lang.STRING));
		assertContains(ms, new MethodSignature("copyValueOf", 
			new String[] {"[" + ClassMethods.CHAR}, 
			JSE_Lang.STRING));
		assertContains(ms, new MethodSignature("copyValueOf", 
			new String[] {"[" + ClassMethods.CHAR, ClassMethods.INT, ClassMethods.INT}, 
			JSE_Lang.STRING));
		assertContains(ms, new MethodSignature("intern", 
			JSE_Lang.STRING));
		assertContains(ms, new MethodSignature("replace", 
			new String[] {ClassMethods.CHAR, ClassMethods.CHAR}, 
			JSE_Lang.STRING));
		assertContains(ms, new MethodSignature("replace", 
			new String[] {JSE_Lang.CHAR_SEQUENCE, JSE_Lang.CHAR_SEQUENCE}, 
			JSE_Lang.STRING));
		assertContains(ms, new MethodSignature("replaceAll", 
			new String[] {JSE_Lang.STRING, JSE_Lang.STRING}, 
			JSE_Lang.STRING));
		assertContains(ms, new MethodSignature("replaceFirst", 
			new String[] {JSE_Lang.STRING, JSE_Lang.STRING}, 
			JSE_Lang.STRING));
		assertContains(ms, new MethodSignature("substring", 
			new String[] {ClassMethods.INT}, 
			JSE_Lang.STRING));
		assertContains(ms, new MethodSignature("substring", 
			new String[] {ClassMethods.INT, ClassMethods.INT}, 
			JSE_Lang.STRING));
		assertContains(ms, new MethodSignature("toLowerCase", 
			JSE_Lang.STRING));
		assertContains(ms, new MethodSignature("toString", 
			JSE_Lang.STRING));
		assertContains(ms, new MethodSignature("toUpperCase", 
			JSE_Lang.STRING));
		assertContains(ms, new MethodSignature("trim", 
			JSE_Lang.STRING));
		assertContains(ms, new MethodSignature("valueOf", 
			new String[] {"[" + ClassMethods.CHAR}, 
			JSE_Lang.STRING));
		assertContains(ms, new MethodSignature("valueOf", 
			new String[] {"[" + ClassMethods.CHAR, ClassMethods.INT, ClassMethods.INT}, 
			JSE_Lang.STRING));
		assertContains(ms, new MethodSignature("valueOf", 
			new String[] {ClassMethods.BOOLEAN}, 
			JSE_Lang.STRING));
		assertContains(ms, new MethodSignature("valueOf", 
			new String[] {ClassMethods.CHAR}, 
			JSE_Lang.STRING));
		assertContains(ms, new MethodSignature("valueOf", 
			new String[] {ClassMethods.DOUBLE}, 
			JSE_Lang.STRING));
		assertContains(ms, new MethodSignature("valueOf", 
			new String[] {ClassMethods.FLOAT}, 
			JSE_Lang.STRING));
		assertContains(ms, new MethodSignature("valueOf", 
			new String[] {ClassMethods.INT}, 
			JSE_Lang.STRING));
		assertContains(ms, new MethodSignature("valueOf", 
			new String[] {JSE_Lang.OBJECT}, 
			JSE_Lang.STRING));
		assertContains(ms, new MethodSignature("valueOf", 
			new String[] {ClassMethods.LONG}, 
			JSE_Lang.STRING));
		assertContains(ms, new MethodSignature("getChars", 
			new String[] {ClassMethods.INT, ClassMethods.INT, 
				"[" + ClassMethods.CHAR, ClassMethods.INT}));
	}
	
	public void delegateStringBufferMemberAsserts(I_ClassAttributes result) {
		delegateObjectMemberAsserts(result);
		Set<I_MethodSignature> ms = result.getMethods();
		assertContains(ms, new MethodSignature("charAt", 
			new String[] {ClassMethods.INT}, 
			ClassMethods.CHAR));
		assertContains(ms, new MethodSignature("capacity", 
			ClassMethods.INT));
		assertContains(ms, new MethodSignature("indexOf", 
			new String[] {JSE_Lang.STRING}, 
			ClassMethods.INT));
		assertContains(ms, new MethodSignature("indexOf", 
			new String[] {JSE_Lang.STRING, ClassMethods.INT}, 
			ClassMethods.INT));
		assertContains(ms, new MethodSignature("lastIndexOf", 
			new String[] {JSE_Lang.STRING}, 
			ClassMethods.INT));
		assertContains(ms, new MethodSignature("lastIndexOf", 
			new String[] {JSE_Lang.STRING, ClassMethods.INT}, 
			ClassMethods.INT));
		assertContains(ms, new MethodSignature("length", 
			ClassMethods.INT));

		assertContains(ms, new MethodSignature("append", 
			new String[] {ClassMethods.CHAR}, 
			JSE_Lang.STRING_BUFFER));
		assertContains(ms, new MethodSignature("append", 
			new String[] {JSE_Lang.CHAR_SEQUENCE}, 
			JSE_Lang.STRING_BUFFER));
		assertContains(ms, new MethodSignature("append", 
			new String[] {JSE_Lang.CHAR_SEQUENCE, ClassMethods.INT, ClassMethods.INT}, 
			JSE_Lang.STRING_BUFFER));
		assertContains(ms, new MethodSignature("subSequence", 
			new String[] {ClassMethods.INT, ClassMethods.INT}, 
			JSE_Lang.CHAR_SEQUENCE));
		assertContains(ms, new MethodSignature("substring", 
			new String[] {ClassMethods.INT}, 
			JSE_Lang.STRING));
		assertContains(ms, new MethodSignature("substring", 
			new String[] {ClassMethods.INT, ClassMethods.INT}, 
			JSE_Lang.STRING));
		assertContains(ms, new MethodSignature("toString", 
			JSE_Lang.STRING));
		assertContains(ms, new MethodSignature("append", 
			new String[] {"[" + ClassMethods.CHAR}, 
			JSE_Lang.STRING_BUFFER));
		assertContains(ms, new MethodSignature("append", 
			new String[] {"[" + ClassMethods.CHAR, ClassMethods.INT, ClassMethods.INT}, 
			JSE_Lang.STRING_BUFFER));
		assertContains(ms, new MethodSignature("append", 
			new String[] {ClassMethods.BOOLEAN}, 
			JSE_Lang.STRING_BUFFER));
		assertContains(ms, new MethodSignature("append", 
			new String[] {ClassMethods.CHAR}, 
			JSE_Lang.STRING_BUFFER));
		assertContains(ms, new MethodSignature("append", 
			new String[] {ClassMethods.DOUBLE}, 
			JSE_Lang.STRING_BUFFER));
		assertContains(ms, new MethodSignature("append", 
			new String[] {ClassMethods.FLOAT}, 
			JSE_Lang.STRING_BUFFER));
		assertContains(ms, new MethodSignature("append", 
			new String[] {ClassMethods.INT}, 
			JSE_Lang.STRING_BUFFER));
		assertContains(ms, new MethodSignature("append", 
			new String[] {JSE_Lang.CHAR_SEQUENCE}, 
			JSE_Lang.STRING_BUFFER));
		assertContains(ms, new MethodSignature("append", 
			new String[] {JSE_Lang.CHAR_SEQUENCE, ClassMethods.INT, ClassMethods.INT}, 
			JSE_Lang.STRING_BUFFER));
		assertContains(ms, new MethodSignature("append", 
			new String[] {JSE_Lang.OBJECT}, 
			JSE_Lang.STRING_BUFFER));
		assertContains(ms, new MethodSignature("append", 
			new String[] {JSE_Lang.STRING}, 
			JSE_Lang.STRING_BUFFER));
		assertContains(ms, new MethodSignature("append", 
			new String[] {JSE_Lang.STRING_BUFFER}, 
			JSE_Lang.STRING_BUFFER));
		assertContains(ms, new MethodSignature("append", 
			new String[] {ClassMethods.LONG}, 
			JSE_Lang.STRING_BUFFER));
		assertContains(ms, new MethodSignature("delete", 
			new String[] {ClassMethods.INT, ClassMethods.INT}, 
			JSE_Lang.STRING_BUFFER));
		assertContains(ms, new MethodSignature("deleteCharAt", 
			new String[] {ClassMethods.INT}, 
			JSE_Lang.STRING_BUFFER));
		assertContains(ms, new MethodSignature("insert", 
			new String[] {ClassMethods.INT, "[" + ClassMethods.CHAR}, 
			JSE_Lang.STRING_BUFFER));
		assertContains(ms, new MethodSignature("insert", 
			new String[] {ClassMethods.INT, "[" + ClassMethods.CHAR
				, ClassMethods.INT, ClassMethods.INT}, 
			JSE_Lang.STRING_BUFFER));
		assertContains(ms, new MethodSignature("insert", 
			new String[] {ClassMethods.INT, ClassMethods.BOOLEAN}, 
			JSE_Lang.STRING_BUFFER));
		assertContains(ms, new MethodSignature("insert", 
			new String[] {ClassMethods.INT, ClassMethods.CHAR}, 
			JSE_Lang.STRING_BUFFER));
		assertContains(ms, new MethodSignature("insert", 
			new String[] {ClassMethods.INT, ClassMethods.DOUBLE}, 
			JSE_Lang.STRING_BUFFER));
		assertContains(ms, new MethodSignature("insert", 
			new String[] {ClassMethods.INT, ClassMethods.FLOAT}, 
			JSE_Lang.STRING_BUFFER));
		assertContains(ms, new MethodSignature("insert", 
			new String[] {ClassMethods.INT, ClassMethods.INT}, 
			JSE_Lang.STRING_BUFFER));
		assertContains(ms, new MethodSignature("insert", 
			new String[] {ClassMethods.INT, JSE_Lang.CHAR_SEQUENCE}, 
			JSE_Lang.STRING_BUFFER));
		assertContains(ms, new MethodSignature("insert", 
			new String[] {ClassMethods.INT, JSE_Lang.CHAR_SEQUENCE, 
				ClassMethods.INT, ClassMethods.INT}, 
			JSE_Lang.STRING_BUFFER));
		assertContains(ms, new MethodSignature("insert", 
			new String[] {ClassMethods.INT, JSE_Lang.OBJECT}, 
			JSE_Lang.STRING_BUFFER));
		assertContains(ms, new MethodSignature("insert", 
			new String[] {ClassMethods.INT, JSE_Lang.STRING}, 
			JSE_Lang.STRING_BUFFER));
		assertContains(ms, new MethodSignature("insert", 
			new String[] {ClassMethods.INT, ClassMethods.LONG}, 
			JSE_Lang.STRING_BUFFER));
		assertContains(ms, new MethodSignature("replace", 
			new String[] {ClassMethods.INT, ClassMethods.INT, JSE_Lang.STRING}, 
			JSE_Lang.STRING_BUFFER));
		assertContains(ms, new MethodSignature("reverse", 
			JSE_Lang.STRING_BUFFER));
		assertContains(ms, new MethodSignature("ensureCapacity", 
			new String[] {ClassMethods.INT}));
		assertContains(ms, new MethodSignature("getChars", 
			new String[] {ClassMethods.INT, ClassMethods.INT, "[" 
				+ ClassMethods.CHAR, ClassMethods.INT}));
		assertContains(ms, new MethodSignature("setCharAt", 
			new String[] {ClassMethods.INT, ClassMethods.CHAR}));
		assertContains(ms, new MethodSignature("setLength", 
			new String[] {ClassMethods.INT}));
		assertContains(ms, new MethodSignature("trimToSize"));
	}
	
	public void delegateStringBuilderMemberAsserts(I_ClassAttributes result) {
		delegateObjectMemberAsserts(result);
		Set<I_MethodSignature> ms = result.getMethods();
		assertContains(ms, new MethodSignature("charAt", 
			new String[] {ClassMethods.INT}, 
			ClassMethods.CHAR));
		assertContains(ms, new MethodSignature("capacity", 
			ClassMethods.INT));
		assertContains(ms, new MethodSignature("indexOf", 
			new String[] {JSE_Lang.STRING}, 
			ClassMethods.INT));
		assertContains(ms, new MethodSignature("indexOf", 
			new String[] {JSE_Lang.STRING, ClassMethods.INT}, 
			ClassMethods.INT));
		assertContains(ms, new MethodSignature("lastIndexOf", 
			new String[] {JSE_Lang.STRING}, 
			ClassMethods.INT));
		assertContains(ms, new MethodSignature("lastIndexOf", 
			new String[] {JSE_Lang.STRING, ClassMethods.INT}, 
			ClassMethods.INT));
		assertContains(ms, new MethodSignature("length", 
			ClassMethods.INT));
		assertContains(ms, new MethodSignature("append", 
			new String[] {ClassMethods.CHAR}, 
			JSE_Lang.STRING_BUILDER));
		assertContains(ms, new MethodSignature("append", 
			new String[] {JSE_Lang.CHAR_SEQUENCE}, 
			JSE_Lang.STRING_BUILDER));
		assertContains(ms, new MethodSignature("append", 
			new String[] {JSE_Lang.CHAR_SEQUENCE, ClassMethods.INT, ClassMethods.INT}, 
			JSE_Lang.STRING_BUILDER));
		assertContains(ms, new MethodSignature("subSequence", 
			new String[] {ClassMethods.INT, ClassMethods.INT}, 
			JSE_Lang.CHAR_SEQUENCE));
		assertContains(ms, new MethodSignature("substring", 
			new String[] {ClassMethods.INT}, 
			JSE_Lang.STRING));
		assertContains(ms, new MethodSignature("substring", 
			new String[] {ClassMethods.INT, ClassMethods.INT}, 
			JSE_Lang.STRING));
		assertContains(ms, new MethodSignature("toString", 
			JSE_Lang.STRING));
		assertContains(ms, new MethodSignature("append", 
			new String[] {"[" + ClassMethods.CHAR}, 
			JSE_Lang.STRING_BUILDER));
		assertContains(ms, new MethodSignature("append", 
			new String[] {"[" + ClassMethods.CHAR, ClassMethods.INT, ClassMethods.INT}, 
			JSE_Lang.STRING_BUILDER));
		assertContains(ms, new MethodSignature("append", 
			new String[] {ClassMethods.BOOLEAN}, 
			JSE_Lang.STRING_BUILDER));
		assertContains(ms, new MethodSignature("append", 
			new String[] {ClassMethods.CHAR}, 
			JSE_Lang.STRING_BUILDER));
		assertContains(ms, new MethodSignature("append", 
			new String[] {ClassMethods.DOUBLE}, 
			JSE_Lang.STRING_BUILDER));
		assertContains(ms, new MethodSignature("append", 
			new String[] {ClassMethods.FLOAT}, 
			JSE_Lang.STRING_BUILDER));
		assertContains(ms, new MethodSignature("append", 
			new String[] {ClassMethods.INT}, 
			JSE_Lang.STRING_BUILDER));
		assertContains(ms, new MethodSignature("append", 
			new String[] {JSE_Lang.CHAR_SEQUENCE}, 
			JSE_Lang.STRING_BUILDER));
		assertContains(ms, new MethodSignature("append", 
			new String[] {JSE_Lang.CHAR_SEQUENCE, ClassMethods.INT, ClassMethods.INT}, 
			JSE_Lang.STRING_BUILDER));
		assertContains(ms, new MethodSignature("append", 
			new String[] {JSE_Lang.OBJECT}, 
			JSE_Lang.STRING_BUILDER));
		assertContains(ms, new MethodSignature("append", 
			new String[] {JSE_Lang.STRING}, 
			JSE_Lang.STRING_BUILDER));
		assertContains(ms, new MethodSignature("append", 
			new String[] {JSE_Lang.STRING_BUFFER}, 
			JSE_Lang.STRING_BUILDER));
		assertContains(ms, new MethodSignature("append", 
			new String[] {ClassMethods.LONG}, 
			JSE_Lang.STRING_BUILDER));
		assertContains(ms, new MethodSignature("appendCodePoint", 
			new String[] {ClassMethods.INT}, 
			JSE_Lang.STRING_BUILDER));
		assertContains(ms, new MethodSignature("delete", 
			new String[] {ClassMethods.INT, ClassMethods.INT}, 
			JSE_Lang.STRING_BUILDER));
		assertContains(ms, new MethodSignature("deleteCharAt", 
			new String[] {ClassMethods.INT}, 
			JSE_Lang.STRING_BUILDER));
		assertContains(ms, new MethodSignature("insert", 
			new String[] {ClassMethods.INT, "[" + ClassMethods.CHAR}, 
			JSE_Lang.STRING_BUILDER));
		assertContains(ms, new MethodSignature("insert", 
			new String[] {ClassMethods.INT, "[" + ClassMethods.CHAR, ClassMethods.INT, ClassMethods.INT}, 
			JSE_Lang.STRING_BUILDER));
		assertContains(ms, new MethodSignature("insert", 
			new String[] {ClassMethods.INT, ClassMethods.BOOLEAN}, 
			JSE_Lang.STRING_BUILDER));
		assertContains(ms, new MethodSignature("insert", 
			new String[] {ClassMethods.INT, ClassMethods.CHAR}, 
			JSE_Lang.STRING_BUILDER));
		assertContains(ms, new MethodSignature("insert", 
			new String[] {ClassMethods.INT, ClassMethods.DOUBLE}, 
			JSE_Lang.STRING_BUILDER));
		assertContains(ms, new MethodSignature("insert", 
			new String[] {ClassMethods.INT, ClassMethods.FLOAT}, 
			JSE_Lang.STRING_BUILDER));
		assertContains(ms, new MethodSignature("insert", 
			new String[] {ClassMethods.INT, ClassMethods.INT}, 
			JSE_Lang.STRING_BUILDER));
		assertContains(ms, new MethodSignature("insert", 
			new String[] {ClassMethods.INT, JSE_Lang.CHAR_SEQUENCE}, 
			JSE_Lang.STRING_BUILDER));
		assertContains(ms, new MethodSignature("insert", 
			new String[] {ClassMethods.INT, JSE_Lang.CHAR_SEQUENCE, 
				ClassMethods.INT, ClassMethods.INT}, 
			JSE_Lang.STRING_BUILDER));
		assertContains(ms, new MethodSignature("insert", 
			new String[] {ClassMethods.INT, JSE_Lang.OBJECT}, 
			JSE_Lang.STRING_BUILDER));
		assertContains(ms, new MethodSignature("insert", 
			new String[] {ClassMethods.INT, JSE_Lang.STRING}, 
			JSE_Lang.STRING_BUILDER));
		assertContains(ms, new MethodSignature("insert", 
			new String[] {ClassMethods.INT, ClassMethods.LONG}, 
			JSE_Lang.STRING_BUILDER));
		assertContains(ms, new MethodSignature("replace", 
			new String[] {ClassMethods.INT, ClassMethods.INT, JSE_Lang.STRING}, 
			JSE_Lang.STRING_BUILDER));
		assertContains(ms, new MethodSignature("reverse", 
			JSE_Lang.STRING_BUILDER));
		assertContains(ms, new MethodSignature("ensureCapacity", 
			new String[] {ClassMethods.INT}));
		assertContains(ms, new MethodSignature("getChars", 
			new String[] {ClassMethods.INT, ClassMethods.INT, 
				"[" + ClassMethods.CHAR, ClassMethods.INT}));
		assertContains(ms, new MethodSignature("setCharAt", 
			new String[] {ClassMethods.INT, ClassMethods.CHAR}));
		assertContains(ms, new MethodSignature("setLength", 
			new String[] {ClassMethods.INT}));
		assertContains(ms, new MethodSignature("trimToSize"));
	}
	
	public void delegateSystemMemberAsserts(I_ClassAttributes result) {
		Set<I_FieldSignature> fs = result.getFields();
		assertContains(fs, new FieldSignature("err", JSE_IO.PRINT_STREAM));
		assertContains(fs, new FieldSignature("out", JSE_IO.PRINT_STREAM));
		Set<I_MethodSignature> ms = result.getMethods();
		assertContains(ms, new MethodSignature("identityHashCode", 
			new String[] {JSE_Lang.OBJECT}, 
			ClassMethods.INT));
		assertContains(ms, new MethodSignature("getProperty", 
			new String[] {JSE_Lang.STRING, JSE_Lang.STRING}, 
			JSE_Lang.STRING));
		assertContains(ms, new MethodSignature("currentTimeMillis", 
			ClassMethods.LONG));
		assertContains(ms, new MethodSignature("arraycopy", 
			new String[] {JSE_Lang.OBJECT, ClassMethods.INT, 
				JSE_Lang.OBJECT, ClassMethods.INT, ClassMethods.INT}));

		assertContains(ms, new MethodSignature("gc"));
		assertContains(ms, new MethodSignature("setErr", 
			new String[] {JSE_IO.PRINT_STREAM}));
		assertContains(ms, new MethodSignature("setOut", 
			new String[] {JSE_IO.PRINT_STREAM}));
	}
	public void delegateVoidMemberAsserts(I_ClassAttributes result) {
		Set<I_FieldSignature> fs = result.getFields();
		assertContains(fs, new FieldSignature("TYPE", JSE_Lang.CLASS));
	}
}
