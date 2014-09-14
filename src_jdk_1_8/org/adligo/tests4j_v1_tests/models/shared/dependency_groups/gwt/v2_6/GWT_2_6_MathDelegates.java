package org.adligo.tests4j_v1_tests.models.shared.dependency_groups.gwt.v2_6;

import java.util.Set;

import org.adligo.tests4j.models.shared.common.ClassMethods;
import org.adligo.tests4j.models.shared.dependency.FieldSignature;
import org.adligo.tests4j.models.shared.dependency.I_ClassAttributes;
import org.adligo.tests4j.models.shared.dependency.I_FieldSignature;
import org.adligo.tests4j.models.shared.dependency.I_MethodSignature;
import org.adligo.tests4j.models.shared.dependency.MethodSignature;
import org.adligo.tests4j.models.shared.dependency_groups.jse.JSE_Lang;
import org.adligo.tests4j.models.shared.dependency_groups.jse.JSE_Math;
import org.adligo.tests4j.models.shared.dependency_groups.jse.JSE_Util;
import org.adligo.tests4j.models.shared.trials.I_Trial;

public class GWT_2_6_MathDelegates extends GWT_2_6_LangDelegates {

	public GWT_2_6_MathDelegates(I_Trial p) {
		super(p);
	}

	public void delegateBigDecimalMemberAsserts(I_ClassAttributes result) {
		delegateNumberMemberAsserts(result);
		Set<I_FieldSignature> fs = result.getFields();
		assertContains(fs, new FieldSignature("ONE", JSE_Math.BIG_DECIMAL));
		assertContains(fs, new FieldSignature("TEN", JSE_Math.BIG_DECIMAL));
		assertContains(fs, new FieldSignature("ZERO", JSE_Math.BIG_DECIMAL));
		Set<I_MethodSignature> ms = result.getMethods();
		assertContains(ms, new MethodSignature("divideAndRemainder", 
			new String[] {JSE_Math.BIG_DECIMAL}, 
			"[" + JSE_Math.BIG_DECIMAL));
		assertContains(ms, new MethodSignature("divideAndRemainder", 
			new String[] {JSE_Math.BIG_DECIMAL, JSE_Math.MATH_CONTEXT}, 
			"[" + JSE_Math.BIG_DECIMAL));
		assertContains(ms, new MethodSignature("byteValueExact", 
			ClassMethods.BYTE));
		assertContains(ms, new MethodSignature("doubleValue", 
			ClassMethods.DOUBLE));
		assertContains(ms, new MethodSignature("floatValue", 
			ClassMethods.FLOAT));
		assertContains(ms, new MethodSignature("compareTo", 
			new String[] {JSE_Math.BIG_DECIMAL}, 
			ClassMethods.INT));
		assertContains(ms, new MethodSignature("intValue", 
			ClassMethods.INT));
		assertContains(ms, new MethodSignature("intValueExact", 
			ClassMethods.INT));
		assertContains(ms, new MethodSignature("precision", 
			ClassMethods.INT));
		assertContains(ms, new MethodSignature("scale", 
			ClassMethods.INT));
		assertContains(ms, new MethodSignature("signum", 
			ClassMethods.INT));
		assertContains(ms, new MethodSignature("toEngineeringString", 
			JSE_Lang.STRING));
		assertContains(ms, new MethodSignature("toPlainString", 
			JSE_Lang.STRING));
		assertContains(ms, new MethodSignature("abs", 
			JSE_Math.BIG_DECIMAL));
		assertContains(ms, new MethodSignature("abs", 
			new String[] {JSE_Math.MATH_CONTEXT}, 
			JSE_Math.BIG_DECIMAL));
		assertContains(ms, new MethodSignature("add", 
			new String[] {JSE_Math.BIG_DECIMAL}, 
			JSE_Math.BIG_DECIMAL));
		assertContains(ms, new MethodSignature("add", 
			new String[] {JSE_Math.BIG_DECIMAL, JSE_Math.MATH_CONTEXT}, 
			JSE_Math.BIG_DECIMAL));
		assertContains(ms, new MethodSignature("divide", 
			new String[] {JSE_Math.BIG_DECIMAL}, 
			JSE_Math.BIG_DECIMAL));
		assertContains(ms, new MethodSignature("divide", 
			new String[] {JSE_Math.BIG_DECIMAL, ClassMethods.INT}, 
			JSE_Math.BIG_DECIMAL));
		assertContains(ms, new MethodSignature("divide", 
			new String[] {JSE_Math.BIG_DECIMAL, ClassMethods.INT, ClassMethods.INT}, 
			JSE_Math.BIG_DECIMAL));
		assertContains(ms, new MethodSignature("divide", 
			new String[] {JSE_Math.BIG_DECIMAL, ClassMethods.INT, JSE_Math.ROUNDING_MODE}, 
			JSE_Math.BIG_DECIMAL));
		assertContains(ms, new MethodSignature("divide", 
			new String[] {JSE_Math.BIG_DECIMAL, JSE_Math.MATH_CONTEXT}, 
			JSE_Math.BIG_DECIMAL));
		assertContains(ms, new MethodSignature("divide", 
			new String[] {JSE_Math.BIG_DECIMAL, JSE_Math.ROUNDING_MODE}, 
			JSE_Math.BIG_DECIMAL));
		assertContains(ms, new MethodSignature("divideToIntegralValue", 
			new String[] {JSE_Math.BIG_DECIMAL}, 
			JSE_Math.BIG_DECIMAL));
		assertContains(ms, new MethodSignature("divideToIntegralValue", 
			new String[] {JSE_Math.BIG_DECIMAL, JSE_Math.MATH_CONTEXT}, 
			JSE_Math.BIG_DECIMAL));
		assertContains(ms, new MethodSignature("max", 
			new String[] {JSE_Math.BIG_DECIMAL}, 
			JSE_Math.BIG_DECIMAL));
		assertContains(ms, new MethodSignature("min", 
			new String[] {JSE_Math.BIG_DECIMAL}, 
			JSE_Math.BIG_DECIMAL));
		assertContains(ms, new MethodSignature("movePointLeft", 
			new String[] {ClassMethods.INT}, 
			JSE_Math.BIG_DECIMAL));
		assertContains(ms, new MethodSignature("movePointRight", 
			new String[] {ClassMethods.INT}, 
			JSE_Math.BIG_DECIMAL));
		assertContains(ms, new MethodSignature("multiply", 
			new String[] {JSE_Math.BIG_DECIMAL}, 
			JSE_Math.BIG_DECIMAL));
		assertContains(ms, new MethodSignature("multiply", 
			new String[] {JSE_Math.BIG_DECIMAL, JSE_Math.MATH_CONTEXT}, 
			JSE_Math.BIG_DECIMAL));
		assertContains(ms, new MethodSignature("negate", 
			JSE_Math.BIG_DECIMAL));
		assertContains(ms, new MethodSignature("negate", 
			new String[] {JSE_Math.MATH_CONTEXT}, 
			JSE_Math.BIG_DECIMAL));
		assertContains(ms, new MethodSignature("plus", 
			JSE_Math.BIG_DECIMAL));
		assertContains(ms, new MethodSignature("plus", 
			new String[] {JSE_Math.MATH_CONTEXT}, 
			JSE_Math.BIG_DECIMAL));
		assertContains(ms, new MethodSignature("pow", 
			new String[] {ClassMethods.INT}, 
			JSE_Math.BIG_DECIMAL));
		assertContains(ms, new MethodSignature("pow", 
			new String[] {ClassMethods.INT, JSE_Math.MATH_CONTEXT}, 
			JSE_Math.BIG_DECIMAL));
		assertContains(ms, new MethodSignature("remainder", 
			new String[] {JSE_Math.BIG_DECIMAL}, 
			JSE_Math.BIG_DECIMAL));
		assertContains(ms, new MethodSignature("remainder", 
			new String[] {JSE_Math.BIG_DECIMAL, JSE_Math.MATH_CONTEXT}, 
			JSE_Math.BIG_DECIMAL));
		assertContains(ms, new MethodSignature("round", 
			new String[] {JSE_Math.MATH_CONTEXT}, 
			JSE_Math.BIG_DECIMAL));
		assertContains(ms, new MethodSignature("scaleByPowerOfTen", 
			new String[] {ClassMethods.INT}, 
			JSE_Math.BIG_DECIMAL));
		assertContains(ms, new MethodSignature("setScale", 
			new String[] {ClassMethods.INT}, 
			JSE_Math.BIG_DECIMAL));
		assertContains(ms, new MethodSignature("setScale", 
			new String[] {ClassMethods.INT, ClassMethods.INT}, 
			JSE_Math.BIG_DECIMAL));
		assertContains(ms, new MethodSignature("setScale", 
			new String[] {ClassMethods.INT, JSE_Math.ROUNDING_MODE}, 
			JSE_Math.BIG_DECIMAL));
		assertContains(ms, new MethodSignature("stripTrailingZeros", 
			JSE_Math.BIG_DECIMAL));
		assertContains(ms, new MethodSignature("subtract", 
			new String[] {JSE_Math.BIG_DECIMAL}, 
			JSE_Math.BIG_DECIMAL));
		assertContains(ms, new MethodSignature("subtract", 
			new String[] {JSE_Math.BIG_DECIMAL, JSE_Math.MATH_CONTEXT}, 
			JSE_Math.BIG_DECIMAL));
		assertContains(ms, new MethodSignature("ulp", 
			JSE_Math.BIG_DECIMAL));
		assertContains(ms, new MethodSignature("valueOf", 
			new String[] {ClassMethods.DOUBLE}, 
			JSE_Math.BIG_DECIMAL));
		assertContains(ms, new MethodSignature("valueOf", 
			new String[] {ClassMethods.LONG}, 
			JSE_Math.BIG_DECIMAL));
		assertContains(ms, new MethodSignature("valueOf", 
			new String[] {ClassMethods.LONG, ClassMethods.INT}, 
			JSE_Math.BIG_DECIMAL));
		assertContains(ms, new MethodSignature("toBigInteger", 
			JSE_Math.BIG_INTEGER));
		assertContains(ms, new MethodSignature("toBigIntegerExact", 
			JSE_Math.BIG_INTEGER));
		assertContains(ms, new MethodSignature("unscaledValue", 
			JSE_Math.BIG_INTEGER));
		assertContains(ms, new MethodSignature("longValue", 
			ClassMethods.LONG));
		assertContains(ms, new MethodSignature("longValueExact", 
			ClassMethods.LONG));
		assertContains(ms, new MethodSignature("shortValueExact", 
			ClassMethods.SHORT));
	}
	
	
	public void delegateBigIntegerMemberAsserts(I_ClassAttributes result) {
		delegateNumberMemberAsserts(result);
		Set<I_FieldSignature> fs = result.getFields();
		assertContains(fs, new FieldSignature("ONE", JSE_Math.BIG_INTEGER));
		assertContains(fs, new FieldSignature("TEN", JSE_Math.BIG_INTEGER));
		assertContains(fs, new FieldSignature("ZERO", JSE_Math.BIG_INTEGER));
		Set<I_MethodSignature> ms = result.getMethods();
		assertContains(ms, new MethodSignature("toByteArray", 
			"[" + ClassMethods.BYTE));
		assertContains(ms, new MethodSignature("divideAndRemainder", 
			new String[] {JSE_Math.BIG_INTEGER}, 
			"[" + JSE_Math.BIG_INTEGER));
		assertContains(ms, new MethodSignature("equals", 
			new String[] {JSE_Lang.OBJECT}, 
			ClassMethods.BOOLEAN));
		assertContains(ms, new MethodSignature("isProbablePrime", 
			new String[] {ClassMethods.INT}, 
			ClassMethods.BOOLEAN));
		assertContains(ms, new MethodSignature("testBit", 
			new String[] {ClassMethods.INT}, 
			ClassMethods.BOOLEAN));
		assertContains(ms, new MethodSignature("doubleValue", 
			ClassMethods.DOUBLE));
		assertContains(ms, new MethodSignature("floatValue", 
			ClassMethods.FLOAT));
		assertContains(ms, new MethodSignature("bitCount", 
			ClassMethods.INT));
		assertContains(ms, new MethodSignature("bitLength", 
			ClassMethods.INT));
		assertContains(ms, new MethodSignature("compareTo", 
			new String[] {JSE_Math.BIG_INTEGER}, 
			ClassMethods.INT));
		assertContains(ms, new MethodSignature("getLowestSetBit", 
			ClassMethods.INT));
		assertContains(ms, new MethodSignature("intValue", 
			ClassMethods.INT));
		assertContains(ms, new MethodSignature("signum", 
			ClassMethods.INT));
		assertContains(ms, new MethodSignature("toString", 
			JSE_Lang.STRING));
		assertContains(ms, new MethodSignature("toString", 
			new String[] {ClassMethods.INT}, 
			JSE_Lang.STRING));
		assertContains(ms, new MethodSignature("abs", 
			JSE_Math.BIG_INTEGER));
		assertContains(ms, new MethodSignature("add", 
			new String[] {JSE_Math.BIG_INTEGER}, 
			JSE_Math.BIG_INTEGER));
		assertContains(ms, new MethodSignature("and", 
			new String[] {JSE_Math.BIG_INTEGER}, 
			JSE_Math.BIG_INTEGER));
		assertContains(ms, new MethodSignature("andNot", 
			new String[] {JSE_Math.BIG_INTEGER}, 
			JSE_Math.BIG_INTEGER));
		assertContains(ms, new MethodSignature("clearBit", 
			new String[] {ClassMethods.INT}, 
			JSE_Math.BIG_INTEGER));
		assertContains(ms, new MethodSignature("divide", 
			new String[] {JSE_Math.BIG_INTEGER}, 
			JSE_Math.BIG_INTEGER));
		assertContains(ms, new MethodSignature("flipBit", 
			new String[] {ClassMethods.INT}, 
			JSE_Math.BIG_INTEGER));
		assertContains(ms, new MethodSignature("gcd", 
			new String[] {JSE_Math.BIG_INTEGER}, 
			JSE_Math.BIG_INTEGER));
		assertContains(ms, new MethodSignature("max", 
			new String[] {JSE_Math.BIG_INTEGER}, 
			JSE_Math.BIG_INTEGER));
		assertContains(ms, new MethodSignature("min", 
			new String[] {JSE_Math.BIG_INTEGER}, 
			JSE_Math.BIG_INTEGER));
		assertContains(ms, new MethodSignature("mod", 
			new String[] {JSE_Math.BIG_INTEGER}, 
			JSE_Math.BIG_INTEGER));
		assertContains(ms, new MethodSignature("modInverse", 
			new String[] {JSE_Math.BIG_INTEGER}, 
			JSE_Math.BIG_INTEGER));
		assertContains(ms, new MethodSignature("modPow", 
			new String[] {JSE_Math.BIG_INTEGER, JSE_Math.BIG_INTEGER}, 
			JSE_Math.BIG_INTEGER));
		assertContains(ms, new MethodSignature("multiply", 
			new String[] {JSE_Math.BIG_INTEGER}, 
			JSE_Math.BIG_INTEGER));
		assertContains(ms, new MethodSignature("negate", 
			JSE_Math.BIG_INTEGER));
		assertContains(ms, new MethodSignature("nextProbablePrime", 
			JSE_Math.BIG_INTEGER));
		assertContains(ms, new MethodSignature("not", 
			JSE_Math.BIG_INTEGER));
		assertContains(ms, new MethodSignature("or", 
			new String[] {JSE_Math.BIG_INTEGER}, 
			JSE_Math.BIG_INTEGER));
		assertContains(ms, new MethodSignature("pow", 
			new String[] {ClassMethods.INT}, 
			JSE_Math.BIG_INTEGER));
		assertContains(ms, new MethodSignature("probablePrime", 
			new String[] {ClassMethods.INT, JSE_Util.RANDOM}, 
			JSE_Math.BIG_INTEGER));
		assertContains(ms, new MethodSignature("remainder", 
			new String[] {JSE_Math.BIG_INTEGER}, 
			JSE_Math.BIG_INTEGER));
		assertContains(ms, new MethodSignature("setBit", 
			new String[] {ClassMethods.INT}, 
			JSE_Math.BIG_INTEGER));
		assertContains(ms, new MethodSignature("shiftLeft", 
			new String[] {ClassMethods.INT}, 
			JSE_Math.BIG_INTEGER));
		assertContains(ms, new MethodSignature("shiftRight", 
			new String[] {ClassMethods.INT}, 
			JSE_Math.BIG_INTEGER));
		assertContains(ms, new MethodSignature("subtract", 
			new String[] {JSE_Math.BIG_INTEGER}, 
			JSE_Math.BIG_INTEGER));
		assertContains(ms, new MethodSignature("valueOf", 
			new String[] {ClassMethods.LONG}, 
			JSE_Math.BIG_INTEGER));
		assertContains(ms, new MethodSignature("xor", 
			new String[] {JSE_Math.BIG_INTEGER}, 
			JSE_Math.BIG_INTEGER));
	}
	
	
	public void delegateMathContextMemberAsserts(I_ClassAttributes result) {
		delegateObjectMemberAsserts(result);
		Set<I_FieldSignature> fs = result.getFields();
		assertContains(fs, new FieldSignature("DECIMAL128", JSE_Math.MATH_CONTEXT));
		assertContains(fs, new FieldSignature("DECIMAL32", JSE_Math.MATH_CONTEXT));
		assertContains(fs, new FieldSignature("DECIMAL64", JSE_Math.MATH_CONTEXT));
		assertContains(fs, new FieldSignature("UNLIMITED", JSE_Math.MATH_CONTEXT));
		Set<I_MethodSignature> ms = result.getMethods();
		assertContains(ms, new MethodSignature("getPrecision", 
			ClassMethods.INT));
		assertContains(ms, new MethodSignature("getRoundingMode", 
			JSE_Math.ROUNDING_MODE));
	}
	
	public void delegateRoundingModeMemberAsserts(I_ClassAttributes result) {
		delegateEnumMemberAsserts(result);
		Set<I_FieldSignature> fs = result.getFields();
		assertContains(fs, new FieldSignature("CEILING", JSE_Math.ROUNDING_MODE));
		assertContains(fs, new FieldSignature("DOWN", JSE_Math.ROUNDING_MODE));
		assertContains(fs, new FieldSignature("FLOOR", JSE_Math.ROUNDING_MODE));
		assertContains(fs, new FieldSignature("HALF_DOWN", JSE_Math.ROUNDING_MODE));
		assertContains(fs, new FieldSignature("HALF_EVEN", JSE_Math.ROUNDING_MODE));
		assertContains(fs, new FieldSignature("HALF_UP", JSE_Math.ROUNDING_MODE));
		assertContains(fs, new FieldSignature("UNNECESSARY", JSE_Math.ROUNDING_MODE));
		assertContains(fs, new FieldSignature("UP", JSE_Math.ROUNDING_MODE));
		Set<I_MethodSignature> ms = result.getMethods();
		assertContains(ms, new MethodSignature("values", 
			"[" + JSE_Math.ROUNDING_MODE));
		assertContains(ms, new MethodSignature("valueOf", 
			new String[] {ClassMethods.INT}, 
			JSE_Math.ROUNDING_MODE));
		assertContains(ms, new MethodSignature("valueOf", 
			new String[] {JSE_Lang.STRING}, 
			JSE_Math.ROUNDING_MODE));
	}
}
