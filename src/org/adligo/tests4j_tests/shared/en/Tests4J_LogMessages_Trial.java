package org.adligo.tests4j_tests.shared.en;

import org.adligo.tests4j.shared.asserts.reference.AllowedReferences;
import org.adligo.tests4j.shared.en.Tests4J_EnglishConstants;
import org.adligo.tests4j.shared.en.Tests4J_LogMessages;
import org.adligo.tests4j.shared.i18n.I_Tests4J_LogMessages;
import org.adligo.tests4j.system.shared.trials.SourceFileScope;
import org.adligo.tests4j.system.shared.trials.Test;
import org.adligo.tests4j_tests.base_trials.I_CountType;
import org.adligo.tests4j_tests.base_trials.SourceFileCountingTrial;
import org.adligo.tests4j_tests.references_groups.Tests4J_EN_GwtReferenceGroup;
import org.adligo.tests4j_tests.shared.i18n.I18N_Asserter;

@SourceFileScope (sourceClass=Tests4J_LogMessages.class)
@AllowedReferences (groups=Tests4J_EN_GwtReferenceGroup.class)
public class Tests4J_LogMessages_Trial extends SourceFileCountingTrial {

	@Test
	public void testMessages() {
		I_Tests4J_LogMessages messages = Tests4J_EnglishConstants.ENGLISH.getLogMessages();
		I18N_Asserter asserter = new I18N_Asserter(this);
		asserter.assertConstant("detected the following probe hit;",messages.getDetectedTheFollowingProbeHit());
		asserter.assertConstant("for the following class;",messages.getForTheFollowingClass());
		asserter.assertConstant("is creating new probes for the following class;",messages.getIsCreatingNewProbesForTheFollowingClass());
    asserter.assertConstant("is getting the following probes;",messages.getIsGettingTheFollowingThreadGroupLocalProbes());
		asserter.assertConstant("Thread; ", messages.getThread());
		asserter.assertConstant("Thread/Group; ",messages.getThreadSlashThreadGroup());
		
		
		
		
		asserter.assertConstantsMatchMethods(Tests4J_LogMessages.class);
	}

	@Override
	public int getTests(I_CountType type) {
		return super.getTests(type, 1, true);
	}

	@Override
	public int getAsserts(I_CountType type) {
		int thisAsserts = 19;
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
		int thisUniqueAsserts = 19;
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
