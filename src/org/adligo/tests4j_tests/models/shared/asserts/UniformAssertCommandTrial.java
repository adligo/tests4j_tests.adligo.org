package org.adligo.tests4j_tests.models.shared.asserts;

import java.util.Map;

import org.adligo.tests4j.models.shared.asserts.CompareAssertionData;
import org.adligo.tests4j.models.shared.asserts.ExpectedThrownData;
import org.adligo.tests4j.models.shared.asserts.UniformAssertCommand;
import org.adligo.tests4j.models.shared.asserts.common.AssertType;
import org.adligo.tests4j.models.shared.asserts.common.I_Thrower;
import org.adligo.tests4j.models.shared.asserts.line_text.I_TextLinesCompareResult;
import org.adligo.tests4j.models.shared.asserts.uniform.I_Evaluation;
import org.adligo.tests4j.models.shared.asserts.uniform.StringUniformEvaluator;
import org.adligo.tests4j.models.shared.coverage.I_SourceFileCoverage;
import org.adligo.tests4j.models.shared.en.asserts.Tests4J_AssertionResultMessages;
import org.adligo.tests4j.models.shared.results.I_SourceFileTrialResult;
import org.adligo.tests4j.models.shared.trials.SourceFileScope;
import org.adligo.tests4j.models.shared.trials.SourceFileTrial;
import org.adligo.tests4j.models.shared.trials.Test;
import org.adligo.tests4j_tests.base_abstract_trials.SourceFileCountingTrial;

@SourceFileScope (sourceClass=UniformAssertCommand.class)
public class UniformAssertCommandTrial extends SourceFileCountingTrial {

	@Test
	public void testConstructorExceptions() {
		assertThrown(new ExpectedThrownData(new IllegalArgumentException(UniformAssertCommand.BAD_TYPE)), 
				new I_Thrower(){

					@Override
					public void run() {
						new UniformAssertCommand(AssertType.AssertFalse, "failureMessage", null);
					}
		});
			
		assertThrown(new ExpectedThrownData(new IllegalArgumentException(UniformAssertCommand.NULL_DATA)), 
				new I_Thrower(){

					@Override
					public void run() {
						new UniformAssertCommand(AssertType.AssertUniform, "failureMessage", null);
					}
		});
		
		assertThrown(new ExpectedThrownData(new IllegalArgumentException(
				new Tests4J_AssertionResultMessages().getTheExpectedValueShouldNeverBeNull())), 
				new I_Thrower(){

					@Override
					public void run() {
						new UniformAssertCommand(AssertType.AssertUniform, "failureMessage", 
								new CompareAssertionData<String>(null, null));
					}
		});
	}
	
	@Test
	public void testGettersAndEvaluate() {
		UniformAssertCommand uac = new UniformAssertCommand(AssertType.AssertUniform, "failureMessage", 
				new CompareAssertionData<String>("a", "b"));
		assertEquals(AssertType.AssertUniform, uac.getType());
		assertEquals("failureMessage", uac.getFailureMessage());
		assertEquals("a", uac.getExpected());
		assertEquals("b", uac.getActual());
		assertNull(uac.getResult());
		
		assertFalse(uac.evaluate(new StringUniformEvaluator()));
		I_Evaluation eval = uac.getResult();
		assertNotNull(eval);
		assertEquals(new Tests4J_AssertionResultMessages().getTheTextWasNOT_Uniform(), 
				eval.getFailureSubMessage());
		Map<String,Object> data = eval.getData();
		assertNotNull(data);
		
		I_TextLinesCompareResult lt = (I_TextLinesCompareResult) data.get(I_TextLinesCompareResult.DATA_KEY);
		assertFalse(lt.isMatched());
		
	}
	
	@Override
	public void afterTrialTests(I_SourceFileTrialResult p) {
		assertCounts(p);
		
		if (p.hasRecordedCoverage()) {
			I_SourceFileCoverage coverage = p.getSourceFileCoverage();
			assertGreaterThanOrEquals(70.0, coverage.getPercentageCoveredDouble());
		}
	}


	@Override
	public int getTests() {
		return 2;
	}

	@Override
	public int getAsserts() {
		return 13;
	}

	@Override
	public int getUniqueAsserts() {
		return 12;
	}
}
