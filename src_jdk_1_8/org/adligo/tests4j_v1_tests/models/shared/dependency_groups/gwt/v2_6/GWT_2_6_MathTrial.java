package org.adligo.tests4j_v1_tests.models.shared.dependency_groups.gwt.v2_6;

import java.util.Set;

import org.adligo.tests4j.models.shared.dependency.I_ClassAttributes;
import org.adligo.tests4j.models.shared.dependency.I_FieldSignature;
import org.adligo.tests4j.models.shared.dependency.I_MethodSignature;
import org.adligo.tests4j.models.shared.dependency.MethodSignature;
import org.adligo.tests4j.models.shared.dependency_groups.gwt.v2_6.GWT_2_6_Math;
import org.adligo.tests4j.models.shared.dependency_groups.jse.JSE_Lang;
import org.adligo.tests4j.models.shared.dependency_groups.jse.JSE_Math;
import org.adligo.tests4j.models.shared.dependency_groups.jse.JSE_Util;
import org.adligo.tests4j.models.shared.trials.SourceFileScope;
import org.adligo.tests4j.models.shared.trials.Test;
import org.adligo.tests4j.shared.common.ClassMethods;
import org.adligo.tests4j_tests.base_trials.I_CountType;
import org.adligo.tests4j_tests.base_trials.SourceFileCountingTrial;

@SourceFileScope (sourceClass=GWT_2_6_Math.class, minCoverage=99.0)
public class GWT_2_6_MathTrial extends SourceFileCountingTrial {

	private GWT_2_6_MathDelegates delegates;
	
	public GWT_2_6_MathTrial() {
		delegates = new GWT_2_6_MathDelegates(this);
	}
	
	@Test
	public void testBigDecimal() {
		I_ClassAttributes result = GWT_2_6_Math.getBigDecimal();
		assertEquals(JSE_Math.BIG_DECIMAL, result.getName());
		Set<I_FieldSignature> fs = result.getFields();
		Set<I_MethodSignature> ms = result.getMethods();
		assertContains(ms, new MethodSignature("<init>", 
			new String[] {"[" + ClassMethods.CHAR}));
		assertContains(ms, new MethodSignature("<init>", 
			new String[] {"[" + ClassMethods.CHAR, ClassMethods.INT, ClassMethods.INT}));
		assertContains(ms, new MethodSignature("<init>", 
			new String[] {"[" + ClassMethods.CHAR, ClassMethods.INT, ClassMethods.INT, JSE_Math.MATH_CONTEXT}));
		assertContains(ms, new MethodSignature("<init>", 
			new String[] {"[" + ClassMethods.CHAR, JSE_Math.MATH_CONTEXT}));
		assertContains(ms, new MethodSignature("<init>", 
			new String[] {ClassMethods.DOUBLE}));
		assertContains(ms, new MethodSignature("<init>", 
			new String[] {ClassMethods.DOUBLE, JSE_Math.MATH_CONTEXT}));
		assertContains(ms, new MethodSignature("<init>", 
			new String[] {ClassMethods.INT}));
		assertContains(ms, new MethodSignature("<init>", 
			new String[] {ClassMethods.INT, JSE_Math.MATH_CONTEXT}));
		assertContains(ms, new MethodSignature("<init>", 
			new String[] {JSE_Lang.STRING}));
		assertContains(ms, new MethodSignature("<init>", 
			new String[] {JSE_Lang.STRING, JSE_Math.MATH_CONTEXT}));
		assertContains(ms, new MethodSignature("<init>", 
			new String[] {JSE_Math.BIG_INTEGER}));
		assertContains(ms, new MethodSignature("<init>", 
			new String[] {JSE_Math.BIG_INTEGER, ClassMethods.INT}));
		assertContains(ms, new MethodSignature("<init>", 
			new String[] {JSE_Math.BIG_INTEGER, ClassMethods.INT, JSE_Math.MATH_CONTEXT}));
		assertContains(ms, new MethodSignature("<init>", 
			new String[] {JSE_Math.BIG_INTEGER, JSE_Math.MATH_CONTEXT}));
		assertContains(ms, new MethodSignature("<init>", 
			new String[] {ClassMethods.LONG}));
		assertContains(ms, new MethodSignature("<init>", 
			new String[] {ClassMethods.LONG, JSE_Math.MATH_CONTEXT}));
		delegates.delegateBigDecimalMemberAsserts(result);
		assertEquals(3, fs.size());
		assertEquals(79, ms.size());
	}

	@Test
	public void testBigInteger() {
		I_ClassAttributes result = GWT_2_6_Math.getBigInteger();
		assertEquals(JSE_Math.BIG_INTEGER, result.getName());
		Set<I_FieldSignature> fs = result.getFields();
		Set<I_MethodSignature> ms = result.getMethods();
		assertContains(ms, new MethodSignature("<init>", 
			new String[] {"[" + ClassMethods.BYTE}));
		assertContains(ms, new MethodSignature("<init>", 
			new String[] {ClassMethods.INT, "[" + ClassMethods.BYTE}));
		assertContains(ms, new MethodSignature("<init>", 
			new String[] {ClassMethods.INT, ClassMethods.INT, JSE_Util.RANDOM}));
		assertContains(ms, new MethodSignature("<init>", 
			new String[] {ClassMethods.INT, JSE_Util.RANDOM}));
		assertContains(ms, new MethodSignature("<init>", 
			new String[] {JSE_Lang.STRING}));
		assertContains(ms, new MethodSignature("<init>", 
			new String[] {JSE_Lang.STRING, ClassMethods.INT}));
		delegates.delegateBigIntegerMemberAsserts(result);
		assertEquals(3, fs.size());
		assertEquals(53, ms.size());
	}

	@Test
	public void testMathContext() {
		I_ClassAttributes result = GWT_2_6_Math.getMathContext();
		assertEquals(JSE_Math.MATH_CONTEXT, result.getName());
		Set<I_FieldSignature> fs = result.getFields();
		Set<I_MethodSignature> ms = result.getMethods();
		assertContains(ms, new MethodSignature("<init>", 
			new String[] {ClassMethods.INT}));
		assertContains(ms, new MethodSignature("<init>", 
			new String[] {ClassMethods.INT, JSE_Math.ROUNDING_MODE}));
		assertContains(ms, new MethodSignature("<init>", 
			new String[] {JSE_Lang.STRING}));
		delegates.delegateMathContextMemberAsserts(result);
		assertEquals(4, fs.size());
		assertEquals(9, ms.size());
	}

	@Test
	public void testRoundingMode() {
		I_ClassAttributes result = GWT_2_6_Math.getRoundingMode();
		assertEquals(JSE_Math.ROUNDING_MODE, result.getName());
		Set<I_FieldSignature> fs = result.getFields();
		Set<I_MethodSignature> ms = result.getMethods();
		delegates.delegateRoundingModeMemberAsserts(result);
		assertEquals(8, fs.size());
		assertEquals(12, ms.size());
	}

	
	/**keep at the bottom of the file
	 * 
	 */
	@Override
	public int getTests(I_CountType type) {
		return super.getTests(type, 4);
	}

	@Override
	public int getAsserts(I_CountType type) {
		int thisAsserts = 200;
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
		int thisUniqueAsserts = 191;
		if (type.isFromMetaWithCoverage()) {
			//code coverage and circular dependencies +
			//custom afterTrialTests
			return super.getUniqueAsserts(type, thisUniqueAsserts + 2);
		}  else {
			return super.getUniqueAsserts(type, thisUniqueAsserts);
		}
	}
}
