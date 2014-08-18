package org.adligo.tests4j_tests.models.shared.en;

import org.adligo.tests4j.models.shared.en.Tests4J_EnglishConstants;
import org.adligo.tests4j.models.shared.en.Tests4J_ParamsReaderMessages;
import org.adligo.tests4j.models.shared.en.Tests4J_ReportMessages;
import org.adligo.tests4j.models.shared.i18n.I_Tests4J_ParamReaderMessages;
import org.adligo.tests4j.models.shared.i18n.I_Tests4J_ReportMessages;
import org.adligo.tests4j.models.shared.trials.SourceFileScope;
import org.adligo.tests4j.models.shared.trials.Test;
import org.adligo.tests4j_tests.base_trials.SourceFileCountingTrial;
import org.adligo.tests4j_tests.models.shared.i18n.I18N_Asserter;

@SourceFileScope (sourceClass=Tests4J_ReportMessages.class)
public class Tests4J_ReportMessages_Trial extends SourceFileCountingTrial {

	@Test
	public void testMessages() {
		I_Tests4J_ReportMessages messages = Tests4J_EnglishConstants.ENGLISH.getReportMessages();
		I18N_Asserter asserter = new I18N_Asserter(this);
		asserter.assertConstant("100.0% done.", 
				messages.getDoneEOS());
		
		asserter.assertConstant(" failed.", 
				messages.getFailedEOS());
		asserter.assertConstant("Failed!", 
				messages.getFailedFlag());
		asserter.assertConstant("\t", 
				messages.getIndent());
		
		asserter.assertConstant(" Metadata Calculated: ", 
				messages.getMetadataCalculatedHeading());
		asserter.assertConstant(" passed.", 
				messages.getPassedEOS());
		asserter.assertConstant("Passed!", 
				messages.getPassedFlag());
		
		asserter.assertConstant("% complete...", 
				messages.getPctComplete());
		asserter.assertConstant(" starting Test: ", 
				messages.getStartingTest());
		asserter.assertConstant(" starting Trial: ", 
				messages.getStartingTrial());
		
		asserter.assertConstant(" Test: ", 
				messages.getTestHeading());
		asserter.assertConstant(" Tests: ", 
				messages.getTestsHeading());
		
		asserter.assertConstant(" Trial: ", 
				messages.getTrialHeading());
		asserter.assertConstant(" Trials: ", 
				messages.getTrialsHeading());
		
		asserter.assertConstant("Expected;", 
				messages.getExpected());
		asserter.assertConstant("Actual;", 
				messages.getActual());
		asserter.assertConstant("Class: ", 
				messages.getClassHeadding());
		asserter.assertConstant("Differences;", 
				messages.getDifferences());
		asserter.assertConstant("The following expected line numbers were missing: ", 
				messages.getTheFollowingExpectedLineNumbersWereMissing());
		asserter.assertConstant("The following actual line numbers not in the expected text: ", 
				messages.getTheFollowingActualLineNumberNotExpected());
		
		asserter.assertConstantsMatchMethods(Tests4J_ReportMessages.class);
	}

	@Override
	public int getTests() {
		return 	1;
	}

	@Override
	public int getAsserts() {
		return 61;
	}

	@Override
	public int getUniqueAsserts() {
		return 61;
	}
}
