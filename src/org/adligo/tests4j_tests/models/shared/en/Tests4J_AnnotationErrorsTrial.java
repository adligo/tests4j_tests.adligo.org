package org.adligo.tests4j_tests.models.shared.en;

import org.adligo.tests4j.models.shared.en.Tests4J_AnnotationErrors;
import org.adligo.tests4j.models.shared.en.Tests4J_EnglishConstants;
import org.adligo.tests4j.models.shared.i18n.I_Tests4J_AnnotationErrors;
import org.adligo.tests4j.models.shared.trials.SourceFileScope;
import org.adligo.tests4j.models.shared.trials.Test;
import org.adligo.tests4j_tests.base_abstract_trials.SourceFileCountingTrial;
import org.adligo.tests4j_tests.models.shared.i18n.I18N_Asserter;

@SourceFileScope (sourceClass=Tests4J_AnnotationErrors.class)
public class Tests4J_AnnotationErrorsTrial extends SourceFileCountingTrial {

	@Test
	public void testConstants() {
		I18N_Asserter asserter = new I18N_Asserter(this);
		I_Tests4J_AnnotationErrors messages = Tests4J_EnglishConstants.ENGLISH.getAnnotationErrors();
		
		
		asserter.assertConstant("Methods annotated with @AfterTrial must NOT take any parameters.",
				messages.getAfterTrialHasParams());
		asserter.assertConstant("Methods annotated with @AfterTrial must be public.", 
				messages.getAfterTrialNotPublic());
		asserter.assertConstant("Methods annotated with @AfterTrial must be static.", 
				messages.getAfterTrialNotStatic());
		
		
		asserter.assertConstant("Methods annotated with @BeforeTrial must NOT take any parameters.", 
				messages.getBeforeTrialHasParams());
		asserter.assertConstant("Methods annotated with @BeforeTrial must be public.", 
				messages.getBeforeTrialNotPublic());
		asserter.assertConstant("Methods annotated with @BeforeTrial must be static.", 
				messages.getBeforeTrialNotStatic());
		asserter.assertConstant("Methods annotated with @Test may not have a negative timeout.",
			messages.getHasNegativeTimeout());
		asserter.assertConstant("Methods annotated with @Test must not take any parameters.",
			messages.getHasParams());
		asserter.assertConstant("Methods annotated with @Test must NOT be abstract.",
			messages.getIsAbstract());
		asserter.assertConstant("Methods annotated with @Test must be public.",
			messages.getIsNotPublic());
		asserter.assertConstant("Methods annotated with @Test must NOT be static.",
			messages.getIsStatic());
		asserter.assertConstant(" was not annotated correctly.",
			messages.getWasAnnotatedIncorrectly());
		
		asserter.assertConstantsMatchMethods(Tests4J_AnnotationErrors.class);
	}

	@Override
	public int getTests() {
		return 	1;
	}

	@Override
	public int getAsserts() {
		return 25;
	}

	@Override
	public int getUniqueAsserts() {
		return 25;
	}
}
