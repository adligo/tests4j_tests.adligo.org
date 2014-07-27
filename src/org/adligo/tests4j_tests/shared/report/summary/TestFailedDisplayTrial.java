package org.adligo.tests4j_tests.shared.report.summary;

import org.adligo.tests4j.models.shared.en.Tests4J_EnglishConstants;
import org.adligo.tests4j.models.shared.i18n.I_Tests4J_ReportMessages;
import org.adligo.tests4j.models.shared.trials.SourceFileScope;
import org.adligo.tests4j.models.shared.trials.Test;
import org.adligo.tests4j.shared.report.summary.TestFailedDisplay;
import org.adligo.tests4j_tests.base_abstract_trials.SourceFileCountingTrial;
import org.adligo.tests4j_tests.models.shared.system.mocks.Tests4J_LogMock;

@SourceFileScope (sourceClass=TestFailedDisplay.class)
public class TestFailedDisplayTrial extends SourceFileCountingTrial {
	private Tests4J_LogMock log = new Tests4J_LogMock();
	private TestFailedDisplay reporter = new TestFailedDisplay(log);
	
	@Override
	public void beforeTests() {
		log.clear();
		log.clearStates();
	}

	
	@Test
	public void testProgressReportLogOff() {
		
		reporter.onTestFailed("someTrial", "someTest", false);
		assertEquals(0, log.getLogMessagesSize());
		assertEquals(0, log.getExceptionsSize());
		assertEquals(0, log.getStatesSize());
		
	}
	
	
	@Test
	public void testProgressReportPartDone() {
		log.setState(TestFailedDisplay.class, true);
		
		reporter.onTestFailed("someTrial[0]", "someTest", false);
		
		assertEquals(1, log.getLogMessagesSize());
		I_Tests4J_ReportMessages messages = Tests4J_EnglishConstants.ENGLISH.getReportMessages();
		assertEquals("Tests4J"  + messages.getTestHeading() + "someTrial[0].someTest" + messages.getFailedEOS(),
				log.getLogMessage(0));
		assertEquals(0, log.getExceptionsSize());
		assertEquals(1, log.getStatesSize());
		assertTrue(log.isLogEnabled(TestFailedDisplay.class));
		
	}
	
	@Override
	public int getTests() {
		return 2;
	}

	@Override
	public int getAsserts() {
		return 8;
	}

	@Override
	public int getUniqueAsserts() {
		return 5;
	}

	
}