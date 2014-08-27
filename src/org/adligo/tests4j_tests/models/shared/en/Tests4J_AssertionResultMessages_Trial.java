package org.adligo.tests4j_tests.models.shared.en;

import org.adligo.tests4j.models.shared.en.Tests4J_ResultMessages;
import org.adligo.tests4j.models.shared.en.Tests4J_EnglishConstants;
import org.adligo.tests4j.models.shared.i18n.I_Tests4J_ResultMessages;
import org.adligo.tests4j.models.shared.trials.SourceFileScope;
import org.adligo.tests4j.models.shared.trials.Test;
import org.adligo.tests4j_tests.base_trials.SourceFileCountingTrial;
import org.adligo.tests4j_tests.models.shared.i18n.I18N_Asserter;

@SourceFileScope (sourceClass=Tests4J_ResultMessages.class)
public class Tests4J_AssertionResultMessages_Trial extends SourceFileCountingTrial {

	private static final int ASSERT_COUNT = 76;

	@Test
	public void testMessages() {
		I_Tests4J_ResultMessages messages = Tests4J_EnglishConstants.ENGLISH.getResultMessages();
		I18N_Asserter asserter = new I18N_Asserter(this);
		
		asserter.assertConstant("An unexpected exception was thrown.",
				messages.getAnUnexpectedExceptionWasThrown());
		asserter.assertConstant("No throwables were thrown from the I_Thrower.",
				messages.getNothingWasThrown());
		asserter.assertConstant("The actual value should be greater than OR equal to the expected value.",
				messages.getTheActualShouldBeGreaterThanOrEqualToTheExpected());
		
		asserter.assertConstant("The collection should contain the value.",
				messages.getTheCollectionShouldContainTheValue());
		
		asserter.assertConstant("Either no throwable was thrown or the expected throwable was NOT uniform with the actual throwable.",
				messages.getTheExpectedThrowableDataWasNotUniformTheActual());
	
		
		asserter.assertConstant("The objects should NOT be equal.",
				messages.getTheObjectsShould_NOT_BeEqual());
		
		asserter.assertConstant("The objects should NOT be the same.",
				messages.getTheObjectsShould_NOT_BeTheSame());
		
		asserter.assertConstant("The objects should NOT be uniform.",
				messages.getTheObjectsShould_NOT_BeUniform());
		
		asserter.assertConstant("The objects should be equal.",
				messages.getTheObjectsShouldBeEqual());
		asserter.assertConstant("The objects should be the same.",
				messages.getTheObjectsShouldBeTheSame());
		
		asserter.assertConstant("The objects should be uniform.",
				messages.getTheObjectsShouldBeUniform());
		
	
		asserter.assertConstant("The text was NOT uniform.",
				messages.getTheTextWasNOT_Uniform());
		asserter.assertConstant("The text was uniform.",
				messages.getTheTextWasUniform());
		
		asserter.assertConstant("The value should be false.",
				messages.getTheValueShouldBeFalse());
		
		asserter.assertConstant("The value should be true.",
				messages.getTheValueShouldBeTrue());
		
		
		asserter.assertConstant("The value should be null.",
				messages.getTheValueShouldBeNull());
		
		asserter.assertConstant("The value should NOT be null.",
				messages.getTheValueShould_NOT_BeNull());
		
		asserter.assertConstant("The expected thrown class did NOT match the actual thrown class.",
				messages.getThrowableClassMismatch());
		asserter.assertConstant("The expected throwable message was NOT equals to the actual thrown message.",
				messages.getThrowableMessageNotEquals());
		asserter.assertConstant("The expected throwable message was NOT uniform with the actual thrown message.",
				messages.getThrowableMessageNotUniform());
		
		asserter.assertConstant("The expected throwable did not match the actual throwable, or nothing was thrown.",
				messages.getTheExpectedThrowableDidNotMatch());
		
		asserter.assertConstant("The test timed out.",
				messages.getTestTimedOut());
		asserter.assertConstant("The trial timed out.",
				messages.getTrialTimedOut());
		asserter.assertConstant("The code coverage should be above the expected value.",
				messages.getCodeCoveragIsOff());
		asserter.assertConstant("Source class has a circular dependency detected.",
				messages.getSourceClassHasCircularDependency());
		
		asserter.assertConstantsMatchMethods(Tests4J_ResultMessages.class);
	}

	@Override
	public int getTests() {
		return 	1;
	}

	@Override
	public int getAsserts() {
		return ASSERT_COUNT;
	}

	@Override
	public int getUniqueAsserts() {
		return ASSERT_COUNT;
	}
}
