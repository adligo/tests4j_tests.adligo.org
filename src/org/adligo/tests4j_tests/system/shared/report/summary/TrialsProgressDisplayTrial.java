package org.adligo.tests4j_tests.system.shared.report.summary;

import org.adligo.tests4j.models.shared.results.PhaseStateMutant;
import org.adligo.tests4j.run.helpers.Tests4J_PhaseOverseer;
import org.adligo.tests4j.shared.asserts.reference.AllowedReferences;
import org.adligo.tests4j.shared.en.Tests4J_EnglishConstants;
import org.adligo.tests4j.shared.i18n.I_Tests4J_ReportMessages;
import org.adligo.tests4j.system.shared.report.summary.TrialsProgressDisplay;
import org.adligo.tests4j.system.shared.trials.SourceFileScope;
import org.adligo.tests4j.system.shared.trials.Test;
import org.adligo.tests4j_tests.base_trials.I_CountType;
import org.adligo.tests4j_tests.base_trials.SourceFileCountingTrial;
import org.adligo.tests4j_tests.references_groups.Tests4J_Summary_GwtReferenceGroup;
import org.adligo.tests4j_tests.references_groups.Tests4J_Summary_ReferenceGroup;
import org.adligo.tests4j_tests.system.shared.mocks.Tests4J_LogMock;

@SourceFileScope (sourceClass=TrialsProgressDisplay.class)
@AllowedReferences (groups=Tests4J_Summary_GwtReferenceGroup.class)
public class TrialsProgressDisplayTrial extends SourceFileCountingTrial {
	private Tests4J_LogMock log_ = new Tests4J_LogMock();
	private TrialsProgressDisplay reporter_;
	
	@Override
	public void beforeTests() {
		log_.clear();
		log_.clearStates();
		reporter_ = new TrialsProgressDisplay();
	}

	
	@Test
	public void testProgressReportLogOff() {
	  PhaseStateMutant info = new PhaseStateMutant();
    info.setProcessName("trials");
    info.setPercentDone(100.0);
		reporter_.onProgress(log_, info);
		assertEquals(0, log_.getLogMessagesSize());
		assertEquals(0, log_.getExceptionsSize());
		assertEquals(0, log_.getStatesSize());
		
	}
	
	
	@Test
	public void testProgressReportPartDone() {
		log_.setState(TrialsProgressDisplay.class, true);
		PhaseStateMutant info = new PhaseStateMutant();
    info.setProcessName("trials");
    info.setPercentDone(17.17);
		reporter_.onProgress(log_, info);
		
		assertEquals(1, log_.getLogMessagesSize());
		I_Tests4J_ReportMessages messages = Tests4J_EnglishConstants.ENGLISH.getReportMessages();
		assertEquals("Tests4J: trials 17.17" + messages.getPctComplete(),
				log_.getLogMessage(0));
		assertEquals(0, log_.getExceptionsSize());
		assertEquals(1, log_.getStatesSize());
		assertTrue(log_.isLogEnabled(TrialsProgressDisplay.class));
		
	}
	
	@Test
	public void testProgressReportDone() {

		log_.setState(TrialsProgressDisplay.class, true);
		PhaseStateMutant info = new PhaseStateMutant();
    info.setProcessName("trials");
    info.setPercentDone(100.0);
    info.setHasFinishedAll(true);
		reporter_.onProgress(log_, info);
		
		assertEquals(1, log_.getLogMessagesSize());
		I_Tests4J_ReportMessages messages = Tests4J_EnglishConstants.ENGLISH.getReportMessages();
		assertEquals("Tests4J: trials " + messages.getDoneEOS() + log_.getLineSeperator(),
				log_.getLogMessage(0));
		assertEquals(0, log_.getExceptionsSize());
		assertEquals(1, log_.getStatesSize());
		assertTrue(log_.isLogEnabled(TrialsProgressDisplay.class));
		
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
