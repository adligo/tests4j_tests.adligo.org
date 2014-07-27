package org.adligo.tests4j_tests.shared.report.summary;

import java.util.List;

import org.adligo.tests4j.models.shared.en.Tests4J_EnglishConstants;
import org.adligo.tests4j.models.shared.i18n.I_Tests4J_ReportMessages;
import org.adligo.tests4j.models.shared.results.BaseTrialResultMutant;
import org.adligo.tests4j.models.shared.results.I_TrialResult;
import org.adligo.tests4j.models.shared.trials.AdditionalInstrumentation;
import org.adligo.tests4j.models.shared.trials.SourceFileScope;
import org.adligo.tests4j.models.shared.trials.Test;
import org.adligo.tests4j.shared.report.summary.TrialFailedDisplay;
import org.adligo.tests4j_tests.base_abstract_trials.SourceFileCountingTrial;
import org.adligo.tests4j_tests.models.shared.system.mocks.Tests4J_LogMock;

@SourceFileScope (sourceClass=TrialFailedDisplay.class)
@AdditionalInstrumentation (javaPackages="org.adligo.tests4j_tests.shared.report.summary")
public class TrialFailedDisplayTrial extends SourceFileCountingTrial {
	private Tests4J_LogMock log = new Tests4J_LogMock();
	
	@Override
	public void beforeTests() {
		log.clear();
		log.clearStates();
	}

	
	@Test
	public void testProgressReportLogOff() {
		TrialFailedDisplay display = new TrialFailedDisplay(log);
		
		BaseTrialResultMutant btrm = new BaseTrialResultMutant();
		btrm.setTrialName("someTrialName");
		
		display.onTrailFailed(btrm);
		assertEquals(0, log.getLogMessagesSize());
		assertEquals(0, log.getExceptionsSize());
		assertEquals(0, log.getStatesSize());
		
		List<I_TrialResult> results =  display.getFailedTrials();
		assertNotNull(results);
		assertEquals(1, results.size());
		assertSame(btrm, results.get(0));
	}
	
	
	@Test
	public void testProgressReportPartDone() {
		TrialFailedDisplay display = new TrialFailedDisplay(log);
		
		BaseTrialResultMutant btrm = new BaseTrialResultMutant();
		btrm.setTrialName("someOtherTrialName");
		
		log.setState(TrialFailedDisplay.class, true);
		
		display.onTrailFailed(btrm);
		
		assertEquals(1, log.getLogMessagesSize());
		I_Tests4J_ReportMessages messages = Tests4J_EnglishConstants.ENGLISH.getReportMessages();
		assertEquals("Tests4J"  + messages.getTrialHeading() + "someOtherTrialName" + messages.getFailedEOS(),
				log.getLogMessage(0));
		assertEquals(0, log.getExceptionsSize());
		assertEquals(1, log.getStatesSize());
		assertTrue(log.isLogEnabled(TrialFailedDisplay.class));
		
		List<I_TrialResult> results =  display.getFailedTrials();
		assertNotNull(results);
		assertEquals(1, results.size());
		assertSame(btrm, results.get(0));
	}
	
	@Override
	public int getTests() {
		return 2;
	}

	@Override
	public int getAsserts() {
		return 14;
	}

	@Override
	public int getUniqueAsserts() {
		return 10;
	}

	
}
