package org.adligo.tests4j_tests.models.shared.en;

import org.adligo.tests4j.models.shared.en.Tests4J_EclipseErrors;
import org.adligo.tests4j.models.shared.en.Tests4J_EnglishConstants;
import org.adligo.tests4j.models.shared.i18n.I_Tests4J_EclipseErrors;
import org.adligo.tests4j.models.shared.trials.SourceFileScope;
import org.adligo.tests4j.models.shared.trials.Test;
import org.adligo.tests4j_tests.base_abstract_trials.SourceFileCountingTrial;
import org.adligo.tests4j_tests.models.shared.i18n.I18N_Asserter;

@SourceFileScope (sourceClass=Tests4J_EclipseErrors.class, minCoverage=60.0)
public class Tests4J_EclipseMessages_Trial extends SourceFileCountingTrial {

	@Test
	public void testMessages() {
		I_Tests4J_EclipseErrors messages = Tests4J_EnglishConstants.ENGLISH.getEclipseErrors();
		I18N_Asserter asserter = new I18N_Asserter(this);
		asserter.assertConstant(
				"Known issues with running Tests4J_RemoterRunner include;\n" +
				"1) Multiple project selection breaks classpath of launcher @see MultiProjectSelectionLaunchHelper.", 
				messages.getErrorRunningTests4J_RemoteRunner_Message());
		asserter.assertConstant("Error running Test4J_RemoterRunner!", 
				messages.getErrorRunningTests4J_RemoteRunner_Title());
		
		asserter.assertConstantsMatchMethods(Tests4J_EclipseErrors.class);
	}

	@Override
	public int getTests() {
		return 	1;
	}

	@Override
	public int getAsserts() {
		return 7;
	}

	@Override
	public int getUniqueAsserts() {
		return 7;
	}
}
