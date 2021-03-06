package org.adligo.tests4j_tests.shared.en;

import org.adligo.tests4j.shared.asserts.reference.AllowedReferences;
import org.adligo.tests4j.shared.en.Tests4J_EnglishConstants;
import org.adligo.tests4j.shared.en.Tests4J_LineDiffTextDisplayMessages;
import org.adligo.tests4j.shared.i18n.I_Tests4J_LineDiffTextDisplayMessages;
import org.adligo.tests4j.system.shared.trials.SourceFileScope;
import org.adligo.tests4j.system.shared.trials.Test;
import org.adligo.tests4j_tests.base_trials.I_CountType;
import org.adligo.tests4j_tests.base_trials.SourceFileCountingTrial;
import org.adligo.tests4j_tests.references_groups.Tests4J_EN_GwtReferenceGroup;
import org.adligo.tests4j_tests.shared.i18n.I18N_Asserter;

@SourceFileScope (sourceClass=Tests4J_LineDiffTextDisplayMessages.class)
@AllowedReferences (groups=Tests4J_EN_GwtReferenceGroup.class)
public class Tests4J_LineDiffTextDisplayMessages_Trial extends SourceFileCountingTrial {

	@Test
	public void testMessages() {
		I_Tests4J_LineDiffTextDisplayMessages messages = Tests4J_EnglishConstants.ENGLISH.getLineDiffTextDisplayMessages();
		I18N_Asserter asserter = new I18N_Asserter(this);
		asserter.assertConstant("Actual;", messages.getActual());
		asserter.assertConstant("Differences;",messages.getDifferences());
		asserter.assertConstant("There is a Tests4j error reporting text line differences, please submit a test case.",messages.getError());
		
		asserter.assertConstant("Expected;",messages.getExpected());
		asserter.assertConstant("The following actual line of text is missing in the expected lines of text; ",
				messages.getTheFollowingActualLineOfTextIsMissing());
		asserter.assertConstant("The following expected line of text is missing in the actual lines of text; ",
				messages.getTheFollowingExpectedLineOfTextIsMissing());
		asserter.assertConstant("The lines of text are different as follows;",messages.getTheLineOfTextIsDifferent());
		
		asserter.assertConstantsMatchMethods(Tests4J_LineDiffTextDisplayMessages.class);
	}

	@Override
	public int getTests(I_CountType type) {
		return super.getTests(type, 1, true);
	}

	@Override
	public int getAsserts(I_CountType type) {
		int thisAsserts = 22;
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
		int thisUniqueAsserts = 22;
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
