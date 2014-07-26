package org.adligo.tests4j_tests.models.shared.asserts.uniform;

import org.adligo.tests4j.models.shared.asserts.CompareAssertionData;
import org.adligo.tests4j.models.shared.asserts.line_text.I_TextLinesCompareResult;
import org.adligo.tests4j.models.shared.asserts.uniform.I_Evaluation;
import org.adligo.tests4j.models.shared.asserts.uniform.ThrowableUniformEvaluator;
import org.adligo.tests4j.models.shared.en.Tests4J_AssertionResultMessages;
import org.adligo.tests4j.models.shared.en.Tests4J_EnglishConstants;
import org.adligo.tests4j.models.shared.i18n.I_Tests4J_AssertionInputMessages;
import org.adligo.tests4j.models.shared.i18n.I_Tests4J_AssertionResultMessages;
import org.adligo.tests4j.models.shared.system.Tests4J_Constants;
import org.adligo.tests4j.models.shared.trials.SourceFileScope;
import org.adligo.tests4j.models.shared.trials.Test;
import org.adligo.tests4j_tests.base_abstract_trials.SourceFileCountingTrial;

@SourceFileScope (sourceClass=ThrowableUniformEvaluator.class, minCoverage=88.0)
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
						new IllegalArgumentException("hey\nyou")));
		assertFalse(eval.isSuccess());
		I_Tests4J_AssertionResultMessages messages =  Tests4J_EnglishConstants.ENGLISH.getAssertionResultMessages();
		assertEquals(messages.getTheTextWasNOT_Uniform(),
				eval.getFailureReason());
		I_TextLinesCompareResult result = eval.getData();
		assertFalse(result.isMatched());
	
		I_Tests4J_AssertionInputMessages inMessages = Tests4J_EnglishConstants.ENGLISH.getAssertionInputMessages();
		
		eval = evaluator.isUniform(
				new CompareAssertionData<Throwable>(
						new IllegalArgumentException("hey\nyou"), 
						null));
		assertFalse(eval.isSuccess());
		assertEquals(inMessages.getTheActualValueIsNull(),
				eval.getFailureReason());
		assertNull(eval.getData());
		
		eval = evaluator.isUniform(
				new CompareAssertionData<Throwable>(
						null, 
						new IllegalStateException("hey\nyou")));
		assertFalse(eval.isSuccess());
		
		assertEquals(inMessages.getTheExpectedValueShouldNeverBeNull(),
				eval.getFailureReason());
		assertNull(eval.getData());
		
		eval = evaluator.isUniform(
				new CompareAssertionData<Throwable>(
						new IllegalArgumentException("hey\nyou"), 
						new IllegalStateException("hey\nyou")));
		assertFalse(eval.isSuccess());
		
		assertEquals(inMessages.getTheActualClassIsNotAssignableFromTheExpectedClass(),
				eval.getFailureReason());
		assertNull(eval.getData());
		
		eval = evaluator.isUniform(
				new CompareAssertionData<Throwable>(
						new IllegalArgumentException("hey\nyou"), 
						new IllegalArgumentException("hey\nyou")));
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
						new IllegalArgumentException("hey\nyou")));
		assertTrue(eval.isSuccess());
		assertNull(eval.getFailureReason());
		assertNull(eval.getData());
		
		eval = evaluator.isNotUniform(
				new CompareAssertionData<Throwable>(
						new IllegalArgumentException("hey\nyou"), 
						null));
		assertFalse(eval.isSuccess());
		I_Tests4J_AssertionInputMessages messages = Tests4J_EnglishConstants.ENGLISH.getAssertionInputMessages();
		
		assertEquals(messages.getTheActualValueIsNull(),
				eval.getFailureReason());
		assertNull(eval.getData());
		
		eval = evaluator.isNotUniform(
				new CompareAssertionData<Throwable>(
						null, 
						new IllegalStateException("hey\nyou")));
		assertFalse(eval.isSuccess());
		
		assertEquals(messages.getTheExpectedValueShouldNeverBeNull(),
				eval.getFailureReason());
		assertNull(eval.getData());
		
		eval = evaluator.isNotUniform(
				new CompareAssertionData<Throwable>(
						new IllegalArgumentException("hey\nyou"), 
						new IllegalStateException("hey\nyou")));
		assertTrue(eval.isSuccess());
		assertNull(eval.getFailureReason());
		assertNull(eval.getData());
		
		eval = evaluator.isNotUniform(
				new CompareAssertionData<Throwable>(
						new IllegalArgumentException("hey\nyou"), 
						new IllegalArgumentException("hey\nyou")));
		assertFalse(eval.isSuccess());
		
		I_Tests4J_AssertionResultMessages resultMessages =  Tests4J_EnglishConstants.ENGLISH.getAssertionResultMessages();
		assertEquals(
				resultMessages.getTheTextWasUniform(),
				eval.getFailureReason());
		I_TextLinesCompareResult result = eval.getData();
		assertTrue(result.isMatched());
	}
	
	@Override
	public int getTests() {
		return 3;
	}

	@Override
	public int getAsserts() {
		return 31;
	}

	@Override
	public int getUniqueAsserts() {
		return 14;
	}
}
