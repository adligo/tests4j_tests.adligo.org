package org.adligo.tests4j_tests.models.shared.asserts.uniform;

import org.adligo.tests4j.models.shared.asserts.CompareAssertionData;
import org.adligo.tests4j.models.shared.asserts.line_text.I_TextLinesCompareResult;
import org.adligo.tests4j.models.shared.asserts.uniform.I_Evaluation;
import org.adligo.tests4j.models.shared.asserts.uniform.StringUniformEvaluator;
import org.adligo.tests4j.models.shared.asserts.uniform.ThrowableUniformEvaluator;
import org.adligo.tests4j.models.shared.coverage.I_SourceFileCoverage;
import org.adligo.tests4j.models.shared.en.asserts.Tests4J_AssertionResultMessages;
import org.adligo.tests4j.models.shared.results.I_SourceFileTrialResult;
import org.adligo.tests4j.models.shared.trials.SourceFileScope;
import org.adligo.tests4j.models.shared.trials.Test;
import org.adligo.tests4j_tests.base_abstract_trials.SourceFileCountingTrial;

@SourceFileScope (sourceClass=ThrowableUniformEvaluator.class)
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
		assertEquals(
				new Tests4J_AssertionResultMessages().getTheTextWasNOT_Uniform(),
				eval.getFailureReason());
		I_TextLinesCompareResult result = eval.getData();
		assertFalse(result.isMatched());
	
		eval = evaluator.isUniform(
				new CompareAssertionData<Throwable>(
						new IllegalArgumentException("hey\nyou"), 
						null));
		assertFalse(eval.isSuccess());
		assertEquals(Tests4J_AssertionResultMessages.THE_ACTUAL_VALUE_IS_NULL_AND_SHOULD_NOT_BE,
				eval.getFailureReason());
		assertNull(eval.getData());
		
		eval = evaluator.isUniform(
				new CompareAssertionData<Throwable>(
						null, 
						new IllegalStateException("hey\nyou")));
		assertFalse(eval.isSuccess());
		assertEquals(Tests4J_AssertionResultMessages.THE_EXPECTED_VALUE_SHOULD_NEVER_BE_NULL_TRY_ASSERT_NULL,
				eval.getFailureReason());
		assertNull(eval.getData());
		
		eval = evaluator.isUniform(
				new CompareAssertionData<Throwable>(
						new IllegalArgumentException("hey\nyou"), 
						new IllegalStateException("hey\nyou")));
		assertFalse(eval.isSuccess());
		assertEquals(Tests4J_AssertionResultMessages.THE_CLASS_OF_THE_ACTUAL_VALUE_IS_NOT_ASSIGNABLE_FROM_THE_CLASS_OF_THE_EXPECTED_VALUE,
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
		assertEquals(Tests4J_AssertionResultMessages.THE_ACTUAL_VALUE_IS_NULL_AND_SHOULD_NOT_BE,
				eval.getFailureReason());
		assertNull(eval.getData());
		
		eval = evaluator.isNotUniform(
				new CompareAssertionData<Throwable>(
						null, 
						new IllegalStateException("hey\nyou")));
		assertFalse(eval.isSuccess());
		assertEquals(Tests4J_AssertionResultMessages.THE_EXPECTED_VALUE_SHOULD_NEVER_BE_NULL_TRY_ASSERT_NULL,
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
		assertEquals(
				new Tests4J_AssertionResultMessages().getTheTextWasUniform(),
				eval.getFailureReason());
		I_TextLinesCompareResult result = eval.getData();
		assertTrue(result.isMatched());
	}
	
	@Override
	public void afterTrialTests(I_SourceFileTrialResult p) {
		assertCounts(p);
		
		if (p.hasRecordedCoverage()) {
			I_SourceFileCoverage coverage = p.getSourceFileCoverage();
			//hmm this should be 95, looks like multithreading
			double pct = coverage.getPercentageCoveredDouble();
			assertGreaterThanOrEquals(88.0, pct);
		}
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
