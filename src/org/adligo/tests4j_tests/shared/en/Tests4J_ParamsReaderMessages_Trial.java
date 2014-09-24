package org.adligo.tests4j_tests.shared.en;

import org.adligo.tests4j.models.shared.trials.SourceFileScope;
import org.adligo.tests4j.models.shared.trials.Test;
import org.adligo.tests4j.shared.en.Tests4J_EnglishConstants;
import org.adligo.tests4j.shared.en.Tests4J_ParamsReaderMessages;
import org.adligo.tests4j.shared.i18n.I_Tests4J_ParamsReaderMessages;
import org.adligo.tests4j_tests.base_trials.I_CountType;
import org.adligo.tests4j_tests.base_trials.SourceFileCountingTrial;
import org.adligo.tests4j_tests.shared.i18n.I18N_Asserter;

@SourceFileScope (sourceClass=Tests4J_ParamsReaderMessages.class)
public class Tests4J_ParamsReaderMessages_Trial extends SourceFileCountingTrial {

	@Test
	public void testMessages() {
		I_Tests4J_ParamsReaderMessages messages = Tests4J_EnglishConstants.ENGLISH.getParamReaderMessages();
		I18N_Asserter asserter = new I18N_Asserter(this);
		asserter.assertConstant("A auth code, or auth code default is required.", 
				messages.getAuthCodeOrAuthCodeDefaultRequired());
		asserter.assertConstant("A requires a non empty host name/ip address is required.", 
				messages.getHostRequired());
		asserter.assertConstant("There were NO trials or remotes to run.", 
				messages.getNoTrialsOrRemotesToRun());
		asserter.assertConstant("The evaluators are expected to at least contain the default evaluator lookups.", 
				messages.getTheEvaluatorsAreExpectedToContainTheDefaultKeys());
		asserter.assertConstant("Test seletions passed to tests4j MUST have a corresponding trial.", 
				messages.getTestSelectionsMustHaveACorrespondingTrial());
		asserter.assertConstantsMatchMethods(Tests4J_ParamsReaderMessages.class);
	}
	@Override
	public int getTests(I_CountType type) {
		return super.getTests(type, 1);
	}

	@Override
	public int getAsserts(I_CountType type) {
		int thisAsserts = 16;
		//code coverage and circular dependencies +
		//custom afterTrialTests
		//+ see above
		int thisAfterAsserts = 2;
		if (type.isFromMetaWithCoverage()) {
			return super.getAsserts(type, thisAsserts + thisAfterAsserts);
		} else {
			return super.getAsserts(type, thisAsserts);
		}
	}

	@Override
	public int getUniqueAsserts(I_CountType type) {
		int thisUniqueAsserts = 16;
		//code coverage and circular dependencies +
		//custom afterTrialTests
		//+ see above
		int thisAfterUniqueAsserts = 2;
		if (type.isFromMetaWithCoverage()) {
			//code coverage and circular dependencies +
			//custom afterTrialTests
			return super.getUniqueAsserts(type, thisUniqueAsserts + thisAfterUniqueAsserts);
		} else {
			return super.getUniqueAsserts(type, thisUniqueAsserts);
		}
	}
}
