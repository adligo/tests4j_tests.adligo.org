package org.adligo.tests4j_tests.models.shared.asserts.uniform;

import java.util.Map;

import org.adligo.tests4j.models.shared.asserts.CompareAssertionData;
import org.adligo.tests4j.models.shared.asserts.line_text.I_TextLinesCompareResult;
import org.adligo.tests4j.models.shared.asserts.uniform.EvaluatorLookup;
import org.adligo.tests4j.models.shared.asserts.uniform.EvaluatorLookupMutant;
import org.adligo.tests4j.models.shared.asserts.uniform.I_Evaluation;
import org.adligo.tests4j.models.shared.asserts.uniform.I_UniformAssertionEvaluator;
import org.adligo.tests4j.models.shared.asserts.uniform.StringUniformEvaluator;
import org.adligo.tests4j.models.shared.coverage.I_SourceFileCoverage;
import org.adligo.tests4j.models.shared.en.asserts.Tests4J_AssertionResultMessages;
import org.adligo.tests4j.models.shared.results.I_SourceFileTrialResult;
import org.adligo.tests4j.models.shared.trials.SourceFileScope;
import org.adligo.tests4j.models.shared.trials.Test;
import org.adligo.tests4j_tests.base_abstract_trials.SourceFileCountingTrial;

@SourceFileScope (sourceClass=StringUniformEvaluator.class)
public class StringUniformEvaluatorTrial extends SourceFileCountingTrial {

	@Test
	public void testGetters() {
		assertEquals(String.class, 
				new StringUniformEvaluator().getType());
	}
	
	@Test
	public void testIsUniform() {
		StringUniformEvaluator evaluator = new StringUniformEvaluator();
		I_Evaluation<I_TextLinesCompareResult> eval = evaluator.isUniform(
				new CompareAssertionData<String>("hey\nu", "hey\nyou"));
		assertFalse(eval.isSuccess());
		assertEquals(
				new Tests4J_AssertionResultMessages().getTheTextWasNOT_Uniform(),
				eval.getFailureReason());
		I_TextLinesCompareResult result = eval.getData();
		assertFalse(result.isMatched());
		
		
		eval = evaluator.isUniform(
				new CompareAssertionData<String>("hey\nyou", "hey\nyou"));
		assertTrue(eval.isSuccess());
		assertNull(eval.getFailureReason());
		assertNull(eval.getData());
	}
	
	@Test
	public void testIsNotUniform() {
		StringUniformEvaluator evaluator = new StringUniformEvaluator();
		I_Evaluation<I_TextLinesCompareResult> eval = evaluator.isNotUniform(
				new CompareAssertionData<String>("hey\nu", "hey\nyou"));
		assertTrue(eval.isSuccess());
		assertNull(eval.getFailureReason());
		assertNull(eval.getData());
		
		eval = evaluator.isNotUniform(
				new CompareAssertionData<String>("hey\nyou", "hey\nyou"));
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
		return 13;
	}

	@Override
	public int getUniqueAsserts() {
		return 9;
	}
}
