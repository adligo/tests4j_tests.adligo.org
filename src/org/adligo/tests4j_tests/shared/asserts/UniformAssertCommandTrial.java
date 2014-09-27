package org.adligo.tests4j_tests.shared.asserts;

import org.adligo.tests4j.models.shared.dependency_groups.adligo.Tests4J_Asserts_DependencyGroup;
import org.adligo.tests4j.models.shared.trials.SourceFileScope;
import org.adligo.tests4j.models.shared.trials.Test;
import org.adligo.tests4j.shared.asserts.UniformAssertCommand;
import org.adligo.tests4j.shared.asserts.common.AssertType;
import org.adligo.tests4j.shared.asserts.common.CompareAssertionData;
import org.adligo.tests4j.shared.asserts.common.ExpectedThrownData;
import org.adligo.tests4j.shared.asserts.common.I_Thrower;
import org.adligo.tests4j.shared.asserts.dependency.AllowedDependencies;
import org.adligo.tests4j.shared.asserts.line_text.I_TextLinesCompareResult;
import org.adligo.tests4j.shared.asserts.uniform.I_Evaluation;
import org.adligo.tests4j.shared.asserts.uniform.StringUniformEvaluator;
import org.adligo.tests4j.shared.en.Tests4J_EnglishConstants;
import org.adligo.tests4j.shared.i18n.I_Tests4J_AssertionInputMessages;
import org.adligo.tests4j.shared.i18n.I_Tests4J_ResultMessages;
import org.adligo.tests4j_tests.base_trials.I_CountType;
import org.adligo.tests4j_tests.base_trials.SourceFileCountingTrial;

@SourceFileScope (sourceClass=UniformAssertCommand.class, minCoverage=70.0)
@AllowedDependencies (groups=Tests4J_Asserts_DependencyGroup.class)
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
	public int getTests(I_CountType type) {
		return super.getTests(type, 2);
	}

	@Override
	public int getAsserts(I_CountType type) {
		int thisAsserts = 14;
		if (type.isFromMetaWithCoverage()) {
			//code coverage and circular dependencies +
			//custom afterTrialTests
			return super.getAsserts(type, thisAsserts + 3);
		} else {
			return super.getAsserts(type, thisAsserts);
		}
	}

	@Override
	public int getUniqueAsserts(I_CountType type) {
		int thisUniqueAsserts = 13;
		if (type.isFromMetaWithCoverage()) {
			return super.getUniqueAsserts(type, thisUniqueAsserts + 3);
		}  else {
			return super.getAsserts(type, thisUniqueAsserts);
		}
	}
	
}
