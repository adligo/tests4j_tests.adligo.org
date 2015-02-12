package org.adligo.tests4j_tests.shared.en;

import org.adligo.tests4j.shared.asserts.reference.AllowedReferences;
import org.adligo.tests4j.shared.en.Tests4J_EnglishConstants;
import org.adligo.tests4j.shared.en.Tests4J_ReportMessages;
import org.adligo.tests4j.shared.i18n.I_Tests4J_ReportMessages;
import org.adligo.tests4j.system.shared.trials.SourceFileScope;
import org.adligo.tests4j.system.shared.trials.Test;
import org.adligo.tests4j_tests.base_trials.I_CountType;
import org.adligo.tests4j_tests.base_trials.SourceFileCountingTrial;
import org.adligo.tests4j_tests.references_groups.Tests4J_EN_GwtReferenceGroup;
import org.adligo.tests4j_tests.shared.i18n.I18N_Asserter;

@SourceFileScope (sourceClass=Tests4J_ReportMessages.class)
@AllowedReferences (groups=Tests4J_EN_GwtReferenceGroup.class)
public class Tests4J_ReportMessages_Trial extends SourceFileCountingTrial {

	private static final int ASSERTS = 82;

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
		asserter.assertConstant("The following text was NOT found in the actual text;", 
        messages.getTheFollowingTextWasNotFoundInTheActualText());
		
		asserter.assertConstant("Starting process <X/> with <Y/> threads.", 
				messages.getStartingProcessXWithYThreads());
		asserter.assertConstant("Process <V/> has <X/> runnables running and <Y/> <Z/> done.", 
				messages.getProcessVhasXRunnablesRunningAndYZdone());
		asserter.assertConstant("non-meta trials", 
				messages.getNonMetaTrials());
		asserter.assertConstant("trial descriptions", 
				messages.getTrialDescriptionsInStatement());
		asserter.assertConstant("The stack trace follows;", 
        messages.getTheStackTraceFollows());
		asserter.assertConstant(" on thread <Z/> ", 
				messages.getOnThreadZ());
		
		asserter.assertConstantsMatchMethods(Tests4J_ReportMessages.class);
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
