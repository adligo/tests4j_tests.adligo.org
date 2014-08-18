package org.adligo.tests4j_tests.models.shared.asserts;

import org.adligo.tests4j.models.shared.asserts.UniformAssertCommand;
import org.adligo.tests4j.models.shared.asserts.common.AssertType;
import org.adligo.tests4j.models.shared.asserts.common.CompareAssertionData;
import org.adligo.tests4j.models.shared.asserts.common.ExpectedThrownData;
import org.adligo.tests4j.models.shared.asserts.common.I_Thrower;
import org.adligo.tests4j.models.shared.asserts.line_text.I_TextLinesCompareResult;
import org.adligo.tests4j.models.shared.asserts.uniform.I_Evaluation;
import org.adligo.tests4j.models.shared.asserts.uniform.StringUniformEvaluator;
import org.adligo.tests4j.models.shared.en.Tests4J_EnglishConstants;
import org.adligo.tests4j.models.shared.i18n.I_Tests4J_AssertionInputMessages;
import org.adligo.tests4j.models.shared.i18n.I_Tests4J_ResultMessages;
import org.adligo.tests4j.models.shared.trials.SourceFileScope;
import org.adligo.tests4j.models.shared.trials.Test;
import org.adligo.tests4j_tests.base_trials.SourceFileCountingTrial;

@SourceFileScope (sourceClass=UniformAssertCommand.class, minCoverage=70.0)
public class UniformAssertCommandTrial extends SourceFileCountingTrial {

	@Test
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void testConstructorExceptions() {
		assertThrown(new ExpectedThrownData(new IllegalArgumentException(UniformAssertCommand.BAD_TYPE)), 
				new I_Thrower(){

					
					@Override
					public void run() {
						new UniformAssertCommand("failureMessage", new CompareAssertionData<String>(null,null, AssertType.AssertFalse), null);
					}
		});
			
		assertThrown(new ExpectedThrownData(NullPointerException.class), 
				new I_Thrower(){

					@Override
					public void run() {
						new UniformAssertCommand("failureMessage", null, null);						
					}
		});
		
		I_Tests4J_AssertionInputMessages messages =  Tests4J_EnglishConstants.ENGLISH.getAssertionInputMessages();
		assertThrown(new ExpectedThrownData(new IllegalArgumentException(
				messages.getTheExpectedValueShouldNeverBeNull())), 
				new I_Thrower(){

					@Override
					public void run() {
						new UniformAssertCommand("failureMessage", 
								new CompareAssertionData<String>(null, null, AssertType.AssertUniform), null);
					}
		});
		
		assertThrown(new ExpectedThrownData(new IllegalArgumentException(
				UniformAssertCommand.UNIFORM_ASSERT_COMMAND_REQUIRES_EVAULATOR)), 
				new I_Thrower(){

					@Override
					public void run() {
						new UniformAssertCommand("failureMessage", 
								new CompareAssertionData<String>("1", "2", AssertType.AssertUniform), null);
					}
		});
	}
	
	@SuppressWarnings({"unchecked" })
	@Test
	public void testGettersAndEvaluate() {
		UniformAssertCommand<String, I_TextLinesCompareResult> uac = new UniformAssertCommand
					<String, I_TextLinesCompareResult>(
							 "failureMessage", 
				new CompareAssertionData<String>("a", "b", AssertType.AssertUniform), new StringUniformEvaluator());
		assertEquals(AssertType.AssertUniform, uac.getType());
		assertEquals("failureMessage", uac.getFailureMessage());
		assertEquals("a", uac.getExpected());
		assertEquals("b", uac.getActual());
		assertNull(uac.getEvaluation());
		
		assertFalse(uac.evaluate());
		I_Evaluation<I_TextLinesCompareResult> eval = uac.getEvaluation();
		assertNotNull(eval);
		
		I_Tests4J_ResultMessages messages =  Tests4J_EnglishConstants.ENGLISH.getResultMessages();
		assertEquals(messages.getTheTextWasNOT_Uniform(), 
				eval.getFailureReason());
		I_TextLinesCompareResult data = eval.getData();
		assertNotNull(data);
		
		assertFalse(data.isMatched());
		
	}

	@Override
	public int getTests() {
		return 2;
	}

	@Override
	public int getAsserts() {
		return 14;
	}

	@Override
	public int getUniqueAsserts() {
		return 13;
	}
}
