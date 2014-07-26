package org.adligo.tests4j_tests.models.shared.en;

import org.adligo.tests4j.models.shared.en.Tests4J_AssertionResultMessages;
import org.adligo.tests4j.models.shared.en.Tests4J_EnglishConstants;
import org.adligo.tests4j.models.shared.i18n.I_Tests4J_AssertionResultMessages;
import org.adligo.tests4j.models.shared.trials.SourceFileScope;
import org.adligo.tests4j.models.shared.trials.Test;
import org.adligo.tests4j_tests.base_abstract_trials.SourceFileCountingTrial;
import org.adligo.tests4j_tests.models.shared.i18n.I18N_Asserter;

@SourceFileScope (sourceClass=Tests4J_AssertionResultMessages.class, minCoverage=61.0)
public class Tests4J_AssertionResultMessages_Trial extends SourceFileCountingTrial {

	@Test
	public void testMessages() {
		I_Tests4J_AssertionResultMessages messages = Tests4J_EnglishConstants.ENGLISH.getAssertionResultMessages();
		I18N_Asserter asserter = new I18N_Asserter(this);
		
		asserter.assertConstant("The actual Value should be greater than OR equal to the expected Value.",
				messages.getTheActualShouldBeGreaterThanOrEqualToTheExpected());
		
		asserter.assertConstant("The Collection should contain the Value.",
				messages.getTheCollectionShouldContainTheValue());
		
		asserter.assertConstant("Either no Throwable was thrown or the expected Throwable was NOT uniform with the actual Throwable.",
				messages.getTheExpectedThrowableDataDidNotMatchTheActual());
		
		asserter.assertConstant("The Objects should be the same.",
				messages.getTheObjectsShouldBeTheSame());
		
		asserter.assertConstant("The Objects should be uniform.",
				messages.getTheObjectsShouldBeUniform());
		
		asserter.assertConstant("The Objects should NOT be equal.",
				messages.getTheObjectsShould_NOT_BeEqual());
		
		asserter.assertConstant("The Objects should NOT be the same.",
				messages.getTheObjectsShould_NOT_BeTheSame());
		
		asserter.assertConstant("The Objects should NOT be uniform.",
				messages.getTheObjectsShould_NOT_BeUniform());
		
		asserter.assertConstant("The Value should be false.",
				messages.getTheValueShouldBeFalse());
		
		asserter.assertConstant("The Value should be true.",
				messages.getTheValueShouldBeTrue());
		
		
		asserter.assertConstant("The Value should be null.",
				messages.getTheValueShouldBeNull());
		
		asserter.assertConstant("The Value should NOT be null.",
				messages.getTheValueShould_NOT_BeNull());
		
		asserter.assertConstant("The Objects should be equal.",
				messages.getTheObjectsShouldBeEqual());
		
		asserter.assertConstantsMatchMethods(Tests4J_AssertionResultMessages.class);
	}

	@Override
	public int getTests() {
		return 	1;
	}

	@Override
	public int getAsserts() {
		return 26;
	}

	@Override
	public int getUniqueAsserts() {
		return 13;
	}
}
