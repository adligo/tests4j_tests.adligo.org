package org.adligo.tests4j_tests.shared.asserts.uniform;

import org.adligo.tests4j.shared.asserts.common.AssertType;
import org.adligo.tests4j.shared.asserts.common.CompareAssertionData;
import org.adligo.tests4j.shared.asserts.line_text.I_TextLinesCompareResult;
import org.adligo.tests4j.shared.asserts.reference.AllowedReferences;
import org.adligo.tests4j.shared.asserts.uniform.I_Evaluation;
import org.adligo.tests4j.shared.asserts.uniform.StringUniformEvaluator;
import org.adligo.tests4j.shared.en.Tests4J_EnglishConstants;
import org.adligo.tests4j.shared.i18n.I_Tests4J_ResultMessages;
import org.adligo.tests4j.system.shared.trials.SourceFileScope;
import org.adligo.tests4j.system.shared.trials.Test;
import org.adligo.tests4j_tests.base_trials.I_CountType;
import org.adligo.tests4j_tests.base_trials.SourceFileCountingTrial;
import org.adligo.tests4j_tests.references_groups.Tests4J_AssertsUniform_GwtReferenceGroup;

@SourceFileScope (sourceClass=StringUniformEvaluator.class, minCoverage=88.0)
@AllowedReferences (groups=Tests4J_AssertsUniform_GwtReferenceGroup.class)
public class StringUniformEvaluatorTrial extends SourceFileCountingTrial {

	@Test
	public void testGetters() {
		assertEquals(String.class, 
				new StringUniformEvaluator(Tests4J_EnglishConstants.ENGLISH).getType());
	}
	
	@Test
	public void testIsUniform() {
		StringUniformEvaluator evaluator = new StringUniformEvaluator(Tests4J_EnglishConstants.ENGLISH);
		I_Evaluation<I_TextLinesCompareResult> eval = evaluator.isUniform(
				new CompareAssertionData<String>("hey\nu", "hey\nyou", AssertType.AssertUniform));
		assertFalse(eval.isSuccess());
		I_Tests4J_ResultMessages messages =  Tests4J_EnglishConstants.ENGLISH.getResultMessages();
		assertEquals(messages.getTheTextWasNOT_Uniform(),
				eval.getFailureReason());
		I_TextLinesCompareResult result = eval.getData();
		assertFalse(result.isMatched());
		
		
		eval = evaluator.isUniform(
				new CompareAssertionData<String>("hey\nyou", "hey\nyou", AssertType.AssertUniform));
		assertTrue(eval.isSuccess());
		assertNull(eval.getFailureReason());
		assertNull(eval.getData());
	}
	
	@Test
	public void testIsNotUniform() {
		StringUniformEvaluator evaluator = new StringUniformEvaluator(Tests4J_EnglishConstants.ENGLISH);
		I_Evaluation<I_TextLinesCompareResult> eval = evaluator.isNotUniform(
				new CompareAssertionData<String>("hey\nu", "hey\nyou", AssertType.AssertUniform));
		assertTrue(eval.isSuccess());
		assertNull(eval.getFailureReason());
		assertNull(eval.getData());
		
		eval = evaluator.isNotUniform(
				new CompareAssertionData<String>("hey\nyou", "hey\nyou", AssertType.AssertUniform));
		assertFalse(eval.isSuccess());
		
		I_Tests4J_ResultMessages messages =  Tests4J_EnglishConstants.ENGLISH.getResultMessages();
		assertEquals(messages.getTheTextWasUniform(),
				eval.getFailureReason());
		I_TextLinesCompareResult result = eval.getData();
		assertTrue(result.isMatched());
	}
	

	@Override
	public int getTests(I_CountType type) {
		return super.getTests(type, 3, true);
	}

	@Override
	public int getAsserts(I_CountType type) {
		int asserts = 13;
		if (type.isFromMetaWithCoverage()) {
			//code coverage and circular dependencies
			return super.getAsserts(type, asserts + 3);
		} else {
			return super.getAsserts(type, asserts);
		}
	}

	@Override
	public int getUniqueAsserts(I_CountType type) {
		int uasserts = 9;
		if (type.isFromMetaWithCoverage()) {
			return super.getUniqueAsserts(type, uasserts + 3);
		} else {
			return super.getUniqueAsserts(type, uasserts);
		}
	}
}
