package org.adligo.tests4j_tests.shared.en;

import org.adligo.tests4j.shared.asserts.reference.AllowedReferences;
import org.adligo.tests4j.shared.en.Tests4J_CoveragePluginMessages;
import org.adligo.tests4j.shared.en.Tests4J_EnglishConstants;
import org.adligo.tests4j.shared.en.Tests4J_ReportMessages;
import org.adligo.tests4j.shared.i18n.I_Tests4J_ReportMessages;
import org.adligo.tests4j.system.shared.trials.SourceFileScope;
import org.adligo.tests4j.system.shared.trials.Test;
import org.adligo.tests4j_tests.base_trials.I_CountType;
import org.adligo.tests4j_tests.base_trials.SourceFileCountingTrial;
import org.adligo.tests4j_tests.references_groups.Tests4J_EN_GwtReferenceGroup;
import org.adligo.tests4j_tests.shared.i18n.I18N_Asserter;

@SourceFileScope (sourceClass=Tests4J_CoveragePluginMessages.class)
@AllowedReferences (groups=Tests4J_EN_GwtReferenceGroup.class)
public class Tests4J_CoveragePluginMessages_Trial extends SourceFileCountingTrial {

	private static final int ASSERTS = 16;

	@Test
	public void testMessages() {
	  Tests4J_CoveragePluginMessages messages = Tests4J_CoveragePluginMessages.INSTANCE;
		I18N_Asserter asserter = new I18N_Asserter(this);
		asserter.assertConstant("The dependencies are as follows;", 
        messages.getTheDependenciesAreAsFollows());
		asserter.assertConstant("The following dependencies could NOT be ordered;", 
        messages.getTheFollowingDependenciesCouldNotBeOrdered());
		asserter.assertConstant("The following dependencies were ordered successfully;", 
        messages.getTheFollowingDependenciesWereOrderedSuccessfully());
		asserter.assertConstant("Unable to find dependency order for the following class;", 
        messages.getUnableToFineDependencyOrderForTheFollowingClass());
		asserter.assertConstant("Unable to instrument the following class;", 
        messages.getUnableToInstrumentTheFollowingClass());
		
		asserter.assertConstantsMatchMethods(Tests4J_CoveragePluginMessages.class);
	}

	@Override
	public int getTests(I_CountType type) {
		return super.getTests(type, 1, true);
	}

	@Override
	public int getAsserts(I_CountType type) {
		int thisAsserts = ASSERTS;
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
		int thisUniqueAsserts = ASSERTS;
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
