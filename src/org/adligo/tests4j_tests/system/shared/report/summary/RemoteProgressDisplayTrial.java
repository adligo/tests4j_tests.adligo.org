package org.adligo.tests4j_tests.system.shared.report.summary;

import org.adligo.tests4j.models.shared.results.PhaseStateMutant;
import org.adligo.tests4j.run.helpers.Tests4J_PhaseOverseer;
import org.adligo.tests4j.shared.asserts.reference.AllowedReferences;
import org.adligo.tests4j.shared.en.Tests4J_EnglishConstants;
import org.adligo.tests4j.shared.i18n.I_Tests4J_ReportMessages;
import org.adligo.tests4j.system.shared.report.summary.RemoteProgressDisplay;
import org.adligo.tests4j.system.shared.trials.SourceFileScope;
import org.adligo.tests4j.system.shared.trials.Test;
import org.adligo.tests4j_tests.base_trials.I_CountType;
import org.adligo.tests4j_tests.base_trials.SourceFileCountingTrial;
import org.adligo.tests4j_tests.references_groups.Tests4J_Summary_GwtReferenceGroup;
import org.adligo.tests4j_tests.system.shared.mocks.Tests4J_LogMock;

@SourceFileScope (sourceClass=RemoteProgressDisplay.class)
@AllowedReferences (groups=Tests4J_Summary_GwtReferenceGroup.class)
public class RemoteProgressDisplayTrial extends SourceFileCountingTrial {
	private Tests4J_LogMock log = new Tests4J_LogMock();
	private RemoteProgressDisplay reporter = new RemoteProgressDisplay();
	
	@Override
	public void beforeTests() {
		log.clear();
		log.clearStates();
	}

	
	@Test
	public void testProgressReportLogOff() {
	  PhaseStateMutant info = new PhaseStateMutant();
    info.setProcessName("setup");
    info.setThreadCount(1);
    info.setCount(100);
    info.setDoneCount(1);
		reporter.onProgress(log, info);
		assertEquals(0, log.getLogMessagesSize());
		assertEquals(0, log.getExceptionsSize());
		assertEquals(0, log.getStatesSize());
		
	}
	
	
	@Test
	public void testProgressReportPartDone() {
		log.setState(RemoteProgressDisplay.class, true);
		PhaseStateMutant info = new PhaseStateMutant();
    info.setProcessName("setup");
    info.setPercentDone(17.341);
		reporter.onProgress(log, info);
		
		assertEquals(1, log.getLogMessagesSize());
		I_Tests4J_ReportMessages messages = Tests4J_EnglishConstants.ENGLISH.getReportMessages();
		assertEquals("Tests4J: setup 17.34" + messages.getPctComplete(),
				log.getLogMessage(0));
		assertEquals(0, log.getExceptionsSize());
		assertEquals(1, log.getStatesSize());
		assertTrue(log.isLogEnabled(RemoteProgressDisplay.class));
		
	}
	
	@Test
	public void testProgressReportDone() {

		
		log.setState(RemoteProgressDisplay.class, true);
		
		PhaseStateMutant info = new PhaseStateMutant();
    info.setProcessName("setup");
    info.setPercentDone(100.0);
    info.setHasFinishedAll(true);
    reporter.onProgress(log, info);
    
		assertEquals(1, log.getLogMessagesSize());
		I_Tests4J_ReportMessages messages = Tests4J_EnglishConstants.ENGLISH.getReportMessages();
		assertEquals("Tests4J: setup " + messages.getDoneEOS() + log.getLineSeperator(),
				log.getLogMessage(0));
		assertEquals(0, log.getExceptionsSize());
		assertEquals(1, log.getStatesSize());
		assertTrue(log.isLogEnabled(RemoteProgressDisplay.class));
		
	}
	@Override
	public int getTests(I_CountType type) {
		return super.getTests(type, 3, true);
	}

	@Override
	public int getAsserts(I_CountType type) {
		int thisAsserts = 13;
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
		int thisUniqueAsserts = 9;
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
