package org.adligo.tests4j_tests.shared.en;

import org.adligo.tests4j.shared.asserts.reference.AllowedReferences;
import org.adligo.tests4j.shared.en.Tests4J_AssertionInputMessages;
import org.adligo.tests4j.shared.en.Tests4J_EnglishConstants;
import org.adligo.tests4j.shared.i18n.I_Tests4J_AssertionInputMessages;
import org.adligo.tests4j.system.shared.trials.SourceFileScope;
import org.adligo.tests4j.system.shared.trials.Test;
import org.adligo.tests4j_tests.base_trials.I_CountType;
import org.adligo.tests4j_tests.base_trials.SourceFileCountingTrial;
import org.adligo.tests4j_tests.references_groups.Tests4J_EN_GwtReferenceGroup;
import org.adligo.tests4j_tests.shared.i18n.I18N_Asserter;

@SourceFileScope (sourceClass=Tests4J_AssertionInputMessages.class)
@AllowedReferences (groups=Tests4J_EN_GwtReferenceGroup.class)
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
		
		asserter.assertConstant("The expected thrown data for a assertThrownUniform method must have a message match type of any, equals or null.",
        messages.getThrownUniformExpectedThrownDataMustBeMatchTypeAnyEqualsOrNull());
		asserter.assertConstant("ExpectedThrownData instances with a MatchType of Equals or Contains require a throwable message.",
        messages.getExpectedThrownDataWithEqualsOrContainMatchTypesRequireAMessage());
		
		asserter.assertConstantsMatchMethods(Tests4J_AssertionInputMessages.class);
	}
	

	@Override
	public int getTests(I_CountType type) {
		return super.getTests(type, 1, true);
	}

	@Override
	public int getAsserts(I_CountType type) {
		int thisAsserts = 28;
		//code coverage and circular dependencies +
		//custom afterTrialTests
		//+ see above
		int thisAfterAsserts = 3;
		if (type.isFromMetaWithCoverage()) {
			return super.getAsserts(type, thisAsserts + thisAfterAsserts);
		} else {
			return super.getAsserts(type, thisAsserts);
		}
	}

	@Override
	public int getUniqueAsserts(I_CountType type) {
		int thisUniqueAsserts = 28;
		//code coverage and circular dependencies +
		//custom afterTrialTests
		//+ see above
		int thisAfterUniqueAsserts = 3;
		if (type.isFromMetaWithCoverage()) {
			//code coverage and circular dependencies +
			//custom afterTrialTests
			return super.getUniqueAsserts(type, thisUniqueAsserts + thisAfterUniqueAsserts);
		} else {
			return super.getUniqueAsserts(type, thisUniqueAsserts);
		}
	}
}
