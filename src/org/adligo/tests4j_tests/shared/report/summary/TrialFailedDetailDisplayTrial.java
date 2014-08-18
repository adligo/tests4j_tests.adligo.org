package org.adligo.tests4j_tests.shared.report.summary;

import org.adligo.tests4j.models.shared.en.Tests4J_EnglishConstants;
import org.adligo.tests4j.models.shared.i18n.I_Tests4J_ReportMessages;
import org.adligo.tests4j.models.shared.results.BaseTrialResultMutant;
import org.adligo.tests4j.models.shared.trials.SourceFileScope;
import org.adligo.tests4j.models.shared.trials.Test;
import org.adligo.tests4j.shared.report.summary.TrialFailedDetailDisplay;
import org.adligo.tests4j_tests.base_trials.SourceFileCountingTrial;
import org.adligo.tests4j_tests.models.shared.system.mocks.Tests4J_LogMock;

@SourceFileScope (sourceClass=TrialFailedDetailDisplay.class, minCoverage=5.0)
public class TrialFailedDetailDisplayTrial extends SourceFileCountingTrial {
	private Tests4J_LogMock log = new Tests4J_LogMock();
	
	@Override
	public void beforeTests() {
		log.clear();
		log.clearStates();
	}

	
	@Test
	public void testProgressReportLogOff() {
		TrialFailedDetailDisplay display = new TrialFailedDetailDisplay(log);
		
		BaseTrialResultMutant btrm = new BaseTrialResultMutant();
		btrm.setTrialName("someTrialName");
		
		display.logTrialFailure(btrm);
		assertEquals(0, log.getLogMessagesSize());
		assertEquals(0, log.getExceptionsSize());
		assertEquals(0, log.getStatesSize());
	}
	
	@Test
	public void testProgressReportBasicLog() {
		TrialFailedDetailDisplay display = new TrialFailedDetailDisplay(log);
		log.setState(TrialFailedDetailDisplay.class, true);
		
		BaseTrialResultMutant btrm = new BaseTrialResultMutant();
		btrm.setTrialName("someTrialName");
		
		display.logTrialFailure(btrm);
		
		I_Tests4J_ReportMessages messages =  Tests4J_EnglishConstants.ENGLISH.getReportMessages();
		
		assertEquals("someTrialName" + messages.getFailedEOS() + 
				log.getLineSeperator(), log.getLogMessage(0));
		assertEquals(1, log.getLogMessagesSize());
		assertEquals(0, log.getExceptionsSize());
		assertEquals(1, log.getStatesSize());
	}
	
	@Override
	public int getTests() {
		return 2;
	}

	@Override
	public int getAsserts() {
		return 7;
	}

	@Override
	public int getUniqueAsserts() {
		return 4;
	}

	
}
