package org.adligo.tests4j_tests.shared.report.summary;

import org.adligo.tests4j.models.shared.en.Tests4J_EnglishConstants;
import org.adligo.tests4j.models.shared.i18n.I_Tests4J_ReportMessages;
import org.adligo.tests4j.models.shared.trials.AdditionalInstrumentation;
import org.adligo.tests4j.models.shared.trials.SourceFileScope;
import org.adligo.tests4j.models.shared.trials.Test;
import org.adligo.tests4j.run.helpers.Tests4J_ProcessInfo;
import org.adligo.tests4j.shared.report.summary.TestsProgressDisplay;
import org.adligo.tests4j_tests.base_trials.SourceFileCountingTrial;
import org.adligo.tests4j_tests.models.shared.system.mocks.Tests4J_LogMock;

@SourceFileScope (sourceClass=TestsProgressDisplay.class)
public class TestsProgressDisplayTrial extends SourceFileCountingTrial {
	private Tests4J_LogMock log = new Tests4J_LogMock();
	private TestsProgressDisplay reporter = new TestsProgressDisplay();
	
	@Override
	public void beforeTests() {
		log.clear();
		log.clearStates();
	}

	
	@Test
	public void testProgressReportLogOff() {
		Tests4J_ProcessInfo info = new Tests4J_ProcessInfo("setup", 0, 100);
		info.addDone();
		reporter.onProgress(log, info);
		
		assertEquals(0, log.getLogMessagesSize());
		assertEquals(0, log.getExceptionsSize());
		assertEquals(0, log.getStatesSize());
		
	}
	
	
	@Test
	public void testProgressReportPartDone() {
		log.setState(TestsProgressDisplay.class, true);
		Tests4J_ProcessInfo info = new Tests4J_ProcessInfo("tests", 0, 98);
		for (int i = 0; i < 17; i++) {
			info.addDone();
		}
		
		reporter.onProgress(log, info);
		
		assertEquals(1, log.getLogMessagesSize());
		I_Tests4J_ReportMessages messages = Tests4J_EnglishConstants.ENGLISH.getReportMessages();
		assertEquals("Tests4J: tests 17.34" + messages.getPctComplete(),
				log.getLogMessage(0));
		assertEquals(0, log.getExceptionsSize());
		assertEquals(1, log.getStatesSize());
		assertTrue(log.isLogEnabled(TestsProgressDisplay.class));
		
	}
	
	@Test
	public void testProgressReportDone() {

		
		log.setState(TestsProgressDisplay.class, true);
		Tests4J_ProcessInfo info = new Tests4J_ProcessInfo("trials", 0, 1);
		info.addDone();
		reporter.onProgress(log, info);
		
		assertEquals(1, log.getLogMessagesSize());
		I_Tests4J_ReportMessages messages = Tests4J_EnglishConstants.ENGLISH.getReportMessages();
		assertEquals("Tests4J: trials " + messages.getDoneEOS() + log.getLineSeperator(),
				log.getLogMessage(0));
		assertEquals(0, log.getExceptionsSize());
		assertEquals(1, log.getStatesSize());
		assertTrue(log.isLogEnabled(TestsProgressDisplay.class));
		
	}
	@Override
	public int getTests() {
		return 3;
	}

	@Override
	public int getAsserts() {
		return 13;
	}

	@Override
	public int getUniqueAsserts() {
		return 9;
	}

	
}
