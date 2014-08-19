package org.adligo.tests4j_tests.shared.report.summary;

import java.util.List;

import org.adligo.tests4j.models.shared.en.Tests4J_EnglishConstants;
import org.adligo.tests4j.models.shared.i18n.I_Tests4J_ReportMessages;
import org.adligo.tests4j.models.shared.results.BaseTrialResultMutant;
import org.adligo.tests4j.models.shared.results.I_TrialResult;
import org.adligo.tests4j.models.shared.results.TestResultMutant;
import org.adligo.tests4j.models.shared.trials.SourceFileScope;
import org.adligo.tests4j.models.shared.trials.Test;
import org.adligo.tests4j.shared.report.summary.ThreadDisplay;
import org.adligo.tests4j.shared.report.summary.TrialDisplay;
import org.adligo.tests4j.shared.report.summary.TrialFailedDisplay;
import org.adligo.tests4j_tests.base_trials.SourceFileCountingTrial;
import org.adligo.tests4j_tests.models.shared.system.mocks.Tests4J_LogMock;

@SourceFileScope (sourceClass=TrialDisplay.class, minCoverage=89.0)
public class TrialDisplayTrial extends SourceFileCountingTrial {
	private Tests4J_LogMock log = new Tests4J_LogMock();
	private ThreadDisplay threadDisplay = new ThreadDisplay(log);
	@Override
	public void beforeTests() {
		log.clear();
		log.clearStates();
	}

	
	@Test
	public void testStartReportLogOff() {
		TrialDisplay display = new TrialDisplay(log, threadDisplay);
		
		display.onStartingTrial("someTrialName");
		assertEquals(0, log.getLogMessagesSize());
		assertEquals(0, log.getExceptionsSize());
		assertEquals(0, log.getStatesSize());
		
		List<I_TrialResult> results =  display.getFailedTrials();
		assertNotNull(results);
		assertEquals(0, results.size());
	}
	
	@Test
	public void testStartReportLogOn() {
		TrialDisplay display = new TrialDisplay(log, threadDisplay);
		log.setState(TrialDisplay.class, true);
		
		display.onStartingTrial("someTrialName");
		assertEquals(1, log.getLogMessagesSize());
		I_Tests4J_ReportMessages messages = Tests4J_EnglishConstants.ENGLISH.getReportMessages();
		
		assertEquals("Tests4J" + messages.getStartingTrial() + "someTrialName", log.getLogMessage(0));
		assertEquals(0, log.getExceptionsSize());
		assertEquals(1, log.getStatesSize());
		
		List<I_TrialResult> results =  display.getFailedTrials();
		assertNotNull(results);
		assertEquals(0, results.size());
	}
	
	
	@Test
	public void testPassedLogOff() {
		TrialDisplay display = new TrialDisplay(log, threadDisplay);
		
		BaseTrialResultMutant btrm = new BaseTrialResultMutant();
		btrm.setTrialName("someTrialName");
		btrm.setPassed(true);
		TestResultMutant trm = new TestResultMutant();
		trm.setPassed(true);
		trm.setName("someTestName");
		
		btrm.setPassed(true);
		btrm.addResult(trm);
		
		assertTrue(btrm.isPassed());
		
		display.onTrialCompleted(btrm);
		assertEquals(0, log.getLogMessagesSize());
		assertEquals(0, log.getExceptionsSize());
		assertEquals(0, log.getStatesSize());
		
		List<I_TrialResult> results =  display.getFailedTrials();
		assertNotNull(results);
		assertEquals(0, results.size());
	}
	
	@Test
	public void testPassedLogOn() {
		TrialDisplay display = new TrialDisplay(log, threadDisplay);
		log.setState(TrialDisplay.class, true);
		
		BaseTrialResultMutant btrm = new BaseTrialResultMutant();
		btrm.setTrialName("someTrialName");
		
		TestResultMutant trm = new TestResultMutant();
		trm.setPassed(true);
		trm.setName("someTestName");
		
		btrm.setPassed(true);
		btrm.addResult(trm);
		assertTrue(btrm.isPassed());
		
		display.onTrialCompleted(btrm);
		assertEquals(1, log.getLogMessagesSize());
		I_Tests4J_ReportMessages messages = Tests4J_EnglishConstants.ENGLISH.getReportMessages();
		assertEquals("Tests4J" + messages.getTrialHeading() + "someTrialName" + messages.getPassedEOS(),
				log.getLogMessage(0));
		assertEquals(0, log.getExceptionsSize());
		assertEquals(1, log.getStatesSize());
		
		List<I_TrialResult> results =  display.getFailedTrials();
		assertNotNull(results);
		assertEquals(0, results.size());
	}
	
	
	
	@Test
	public void testFailedLogOff() {
		TrialDisplay display = new TrialDisplay(log, threadDisplay);
		
		BaseTrialResultMutant btrm = new BaseTrialResultMutant();
		btrm.setTrialName("someOtherTrialName");
		btrm.setPassed(false);
		
		display.onTrialCompleted(btrm);
		
		assertEquals(0, log.getLogMessagesSize());
		assertEquals(0, log.getExceptionsSize());
		assertEquals(0, log.getStatesSize());
		
		List<I_TrialResult> results =  display.getFailedTrials();
		assertNotNull(results);
		assertEquals(1, results.size());
		assertSame(btrm, results.get(0));
	}
	
	@Test
	public void testFailedLogOn() {
		TrialDisplay display = new TrialDisplay(log, threadDisplay);
		log.setState(TrialFailedDisplay.class, true);
		
		BaseTrialResultMutant btrm = new BaseTrialResultMutant();
		btrm.setTrialName("someOtherTrialName");
		btrm.setPassed(false);
		
		log.setState(TrialFailedDisplay.class, true);
		
		display.onTrialCompleted(btrm);
		
		assertEquals(1, log.getLogMessagesSize());
		I_Tests4J_ReportMessages messages = Tests4J_EnglishConstants.ENGLISH.getReportMessages();
		assertEquals("Tests4J"  + messages.getTrialHeading() + "someOtherTrialName" + messages.getFailedEOS(),
				log.getLogMessage(0));
		assertEquals(0, log.getExceptionsSize());
		assertEquals(1, log.getStatesSize());
		
		List<I_TrialResult> results =  display.getFailedTrials();
		assertNotNull(results);
		assertEquals(1, results.size());
		assertSame(btrm, results.get(0));
	}
	
	
	@Override
	public int getTests() {
		return 6;
	}

	@Override
	public int getAsserts() {
		return 37;
	}

	@Override
	public int getUniqueAsserts() {
		return 23;
	}

	
}
