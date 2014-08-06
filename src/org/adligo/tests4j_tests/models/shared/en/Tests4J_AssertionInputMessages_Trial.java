package org.adligo.tests4j_tests.models.shared.en;

import org.adligo.tests4j.models.shared.en.Tests4J_AssertionInputMessages;
import org.adligo.tests4j.models.shared.en.Tests4J_EnglishConstants;
import org.adligo.tests4j.models.shared.i18n.I_Tests4J_AssertionInputMessages;
import org.adligo.tests4j.models.shared.trials.SourceFileScope;
import org.adligo.tests4j.models.shared.trials.Test;
import org.adligo.tests4j_tests.base_abstract_trials.SourceFileCountingTrial;
import org.adligo.tests4j_tests.models.shared.i18n.I18N_Asserter;

@SourceFileScope (sourceClass=Tests4J_AssertionInputMessages.class)
public class Tests4J_AssertionInputMessages_Trial extends SourceFileCountingTrial {

	@Test
	public void testMessages() {
		I_Tests4J_AssertionInputMessages messages = Tests4J_EnglishConstants.ENGLISH.getAssertionInputMessages();
		I18N_Asserter asserter = new I18N_Asserter(this);
		
		asserter.assertConstant("ExpectedThrownData requires a non null throwable class.",
				messages.getExpectedThrownDataRequiresThrowable());
		asserter.assertConstant("I_Thrower is required.",
				messages.getIThrowerIsRequired());
		asserter.assertConstant("No evaluator could be found for the following class; ",
				messages.getNoEvaluatorFoundForClass());
		
		asserter.assertConstant("The class of the actual value is not assignable from the class of the expected value.",
				messages.getTheActualClassIsNotAssignableFromTheExpectedClass());
		asserter.assertConstant("The actual value is null and should NOT be.",
				messages.getTheActualValueIsNull());
		
		asserter.assertConstant("The expected value should never be null, try assertNull().",
				messages.getTheExpectedValueShouldNeverBeNull());
		
		asserter.assertConstant("The uniform thown evaluator is null.",
				messages.getTheUniformThrownEvaluatorIsNull());
		
		asserter.assertConstantsMatchMethods(Tests4J_AssertionInputMessages.class);
	}
	
	@Override
	public int getTests() {
		return 	1;
	}

	@Override
	public int getAsserts() {
		return 22;
	}

	@Override
	public int getUniqueAsserts() {
		return 22;
	}
}
