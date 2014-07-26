package org.adligo.tests4j_tests.models.shared.en;

import org.adligo.tests4j.models.shared.en.Tests4J_EnglishConstants;
import org.adligo.tests4j.models.shared.en.Tests4J_MethodErrors;
import org.adligo.tests4j.models.shared.i18n.I_Tests4J_MethodErrors;
import org.adligo.tests4j.models.shared.trials.SourceFileScope;
import org.adligo.tests4j.models.shared.trials.Test;
import org.adligo.tests4j_tests.base_abstract_trials.SourceFileCountingTrial;
import org.adligo.tests4j_tests.models.shared.i18n.I18N_Asserter;

@SourceFileScope (sourceClass=Tests4J_MethodErrors.class)
public class Tests4J_MethodErrorsTrial extends SourceFileCountingTrial {

	@Test
	public void testConstants() {
		I18N_Asserter asserter = new I18N_Asserter(this);
		I_Tests4J_MethodErrors messages = Tests4J_EnglishConstants.ENGLISH.getMethodErrors();
		
		
		asserter.assertConstant("Methods Annotated with @AfterTrial must NOT take any parameters.",
				messages.getAfterTrialHasParams());
		asserter.assertConstant("Methods Annotated with @AfterTrial must be public.", 
				messages.getAfterTrialNotPublic());
		assertEquals("Methods Annotated with @AfterTrial must be static.", 
				messages.getAfterTrialNotStatic());
		
		
		asserter.assertConstant("Methods Annotated with @BeforeTrial must NOT take any parameters.", 
				messages.getBeforeTrialHasParams());
		asserter.assertConstant("Methods Annotated with @BeforeTrial must be public.", 
				messages.getBeforeTrialNotPublic());
		asserter.assertConstant("Methods Annotated with @BeforeTrial must be static.", 
				messages.getBeforeTrialNotStatic());
		
		asserter.assertConstantsMatchMethods(Tests4J_MethodErrors.class);
	}

	@Override
	public int getTests() {
		return 	1;
	}

	@Override
	public int getAsserts() {
		return 13;
	}

	@Override
	public int getUniqueAsserts() {
		return 13;
	}
}
