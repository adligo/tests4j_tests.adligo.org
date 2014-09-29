package org.adligo.tests4j_tests.shared.asserts.uniform;

import org.adligo.tests4j.shared.asserts.common.AssertType;
import org.adligo.tests4j.shared.asserts.common.CompareAssertionData;
import org.adligo.tests4j.shared.asserts.dependency.AllowedDependencies;
import org.adligo.tests4j.shared.asserts.line_text.I_TextLinesCompareResult;
import org.adligo.tests4j.shared.asserts.uniform.I_Evaluation;
import org.adligo.tests4j.shared.asserts.uniform.ThrowableUniformEvaluator;
import org.adligo.tests4j.shared.en.Tests4J_EnglishConstants;
import org.adligo.tests4j.shared.i18n.I_Tests4J_AssertionInputMessages;
import org.adligo.tests4j.shared.i18n.I_Tests4J_ResultMessages;
import org.adligo.tests4j.system.shared.trials.SourceFileScope;
import org.adligo.tests4j.system.shared.trials.Test;
import org.adligo.tests4j_tests.base_trials.I_CountType;
import org.adligo.tests4j_tests.base_trials.SourceFileCountingTrial;
import org.adligo.tests4j_tests.dependency_groups.Tests4J_AssertsUniform_DependencyGroup;

@SourceFileScope (sourceClass=ThrowableUniformEvaluator.class, minCoverage=88.0)
@AllowedDependencies (groups=Tests4J_AssertsUniform_DependencyGroup.class)
public class ThrowableUniformEvaluatorTrial extends SourceFileCountingTrial {

	@Test
	public void testGetters() {
		assertEquals(Throwable.class, 
				new ThrowableUniformEvaluator().getType());
	}
	
	@Test
	public void testIsUniform() {
		ThrowableUniformEvaluator evaluator = new ThrowableUniformEvaluator();
		
		I_Evaluation<I_TextLinesCompareResult> eval = evaluator.isUniform(
				new CompareAssertionData<Throwable>(
						new IllegalArgumentException("hey\nu"), 
						new IllegalArgumentException("hey\nyou"), 
						AssertType.AssertUniform));
		assertFalse(eval.isSuccess());
		I_Tests4J_ResultMessages messages =  Tests4J_EnglishConstants.ENGLISH.getResultMessages();
		assertEquals(messages.getTheTextWasNOT_Uniform(),
				eval.getFailureReason());
		I_TextLinesCompareResult result = eval.getData();
		assertFalse(result.isMatched());
	
		I_Tests4J_AssertionInputMessages inMessages = Tests4J_EnglishConstants.ENGLISH.getAssertionInputMessages();
		
		eval = evaluator.isUniform(
				new CompareAssertionData<Throwable>(
						new IllegalArgumentException("hey\nyou"), 
						null,AssertType.AssertUniform));
		assertFalse(eval.isSuccess());
		assertEquals(inMessages.getTheActualValueIsNull(),
				eval.getFailureReason());
		assertNull(eval.getData());
		
		eval = evaluator.isUniform(
				new CompareAssertionData<Throwable>(
						null, 
						new IllegalStateException("hey\nyou"), AssertType.AssertUniform));
		assertFalse(eval.isSuccess());
		
		assertEquals(inMessages.getTheExpectedValueShouldNeverBeNull(),
				eval.getFailureReason());
		assertNull(eval.getData());
		
		eval = evaluator.isUniform(
				new CompareAssertionData<Throwable>(
						new IllegalArgumentException("hey\nyou"), 
						new IllegalStateException("hey\nyou"),
						AssertType.AssertUniform));
		assertFalse(eval.isSuccess());
		
		assertEquals(inMessages.getTheActualClassIsNotAssignableFromTheExpectedClass(),
				eval.getFailureReason());
		assertNull(eval.getData());
		
		eval = evaluator.isUniform(
				new CompareAssertionData<Throwable>(
						new IllegalArgumentException("hey\nyou"), 
						new IllegalArgumentException("hey\nyou"),
						AssertType.AssertUniform));
		assertTrue(eval.isSuccess());
		assertNull(eval.getFailureReason());
		assertNull(eval.getData());
	}
	
	@Test
	public void testIsNotUniform() {
		ThrowableUniformEvaluator evaluator = new ThrowableUniformEvaluator();
		I_Evaluation<I_TextLinesCompareResult> eval = evaluator.isNotUniform(
				new CompareAssertionData<Throwable>(
						new IllegalArgumentException("hey\nu"), 
						new IllegalArgumentException("hey\nyou"),
						AssertType.AssertUniform));
		assertTrue(eval.isSuccess());
		assertNull(eval.getFailureReason());
		assertNull(eval.getData());
		
		eval = evaluator.isNotUniform(
				new CompareAssertionData<Throwable>(
						new IllegalArgumentException("hey\nyou"), 
						null,AssertType.AssertUniform));
		assertFalse(eval.isSuccess());
		I_Tests4J_AssertionInputMessages messages = Tests4J_EnglishConstants.ENGLISH.getAssertionInputMessages();
		
		assertEquals(messages.getTheActualValueIsNull(),
				eval.getFailureReason());
		assertNull(eval.getData());
		
		eval = evaluator.isNotUniform(
				new CompareAssertionData<Throwable>(
						null, 
						new IllegalStateException("hey\nyou"),
						AssertType.AssertUniform));
		assertFalse(eval.isSuccess());
		
		assertEquals(messages.getTheExpectedValueShouldNeverBeNull(),
				eval.getFailureReason());
		assertNull(eval.getData());
		
		eval = evaluator.isNotUniform(
				new CompareAssertionData<Throwable>(
						new IllegalArgumentException("hey\nyou"), 
						new IllegalStateException("hey\nyou"),
						AssertType.AssertUniform));
		assertTrue(eval.isSuccess());
		assertNull(eval.getFailureReason());
		assertNull(eval.getData());
		
		eval = evaluator.isNotUniform(
				new CompareAssertionData<Throwable>(
						new IllegalArgumentException("hey\nyou"), 
						new IllegalArgumentException("hey\nyou"),
						AssertType.AssertUniform));
		assertFalse(eval.isSuccess());
		
		I_Tests4J_ResultMessages resultMessages =  Tests4J_EnglishConstants.ENGLISH.getResultMessages();
		assertEquals(
				resultMessages.getTheTextWasUniform(),
				eval.getFailureReason());
		I_TextLinesCompareResult result = eval.getData();
		assertTrue(result.isMatched());
	}
	
	@Override
	public int getTests(I_CountType type) {
		return super.getTests(type, 3);
	}
	

	@Override
	public int getAsserts(I_CountType type) {
		int asserts = 31;
		if (type.isFromMetaWithCoverage()) {
			//code coverage and circular dependencies
			return super.getAsserts(type, asserts + 3);
		} else {
			return super.getAsserts(type, asserts);
		}
	}

	@Override
	public int getUniqueAsserts(I_CountType type) {
		int uasserts = 14;
		if (type.isFromMetaWithCoverage()) {
			return super.getUniqueAsserts(type, uasserts + 3);
		} else {
			return super.getUniqueAsserts(type, uasserts);
		}
	}
}
