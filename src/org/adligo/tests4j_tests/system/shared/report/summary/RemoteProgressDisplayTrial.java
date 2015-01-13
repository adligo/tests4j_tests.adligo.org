package org.adligo.tests4j_tests.system.shared.report.summary;

import org.adligo.tests4j.models.shared.results.PhaseStateMutant;
import org.adligo.tests4j.shared.asserts.reference.AllowedReferences;
import org.adligo.tests4j.shared.en.Tests4J_EnglishConstants;
import org.adligo.tests4j.shared.i18n.I_Tests4J_ReportMessages;
import org.adligo.tests4j.shared.output.I_Tests4J_Log;
import org.adligo.tests4j.system.shared.report.summary.RemoteProgressDisplay;
import org.adligo.tests4j.system.shared.trials.SourceFileScope;
import org.adligo.tests4j.system.shared.trials.Test;
import org.adligo.tests4j_4mockito.MockMethod;
import org.adligo.tests4j_tests.base_trials.I_CountType;
import org.adligo.tests4j_tests.base_trials.SourceFileCountingTrial;
import org.adligo.tests4j_tests.references_groups.Tests4J_Summary_GwtReferenceGroup;

@SourceFileScope (sourceClass=RemoteProgressDisplay.class)
@AllowedReferences (groups=Tests4J_Summary_GwtReferenceGroup.class)
public class RemoteProgressDisplayTrial extends SourceFileCountingTrial {
  private I_Tests4J_Log logMock_;
  private MockMethod<Void> logRecord_;
  private MockMethod<Void> logLineRecord_;
  private MockMethod<Void> onThrowableRecord_;
	private RemoteProgressDisplay reporter = new RemoteProgressDisplay(Tests4J_EnglishConstants.ENGLISH);
	
	@Override
	public void beforeTests() {
	  logMock_ = mock(I_Tests4J_Log.class);
    logRecord_ = new MockMethod<Void>();
    doAnswer(logRecord_).when(logMock_).log(any());
    logLineRecord_ = new MockMethod<Void>();
    doAnswer(logLineRecord_).when(logMock_).logLine(anyVararg());
    onThrowableRecord_ = new MockMethod<Void>();
    doAnswer(onThrowableRecord_).when(logMock_).onThrowable(any());
    when(logMock_.getLineSeperator()).thenReturn("lineSeperator");
	}

	
	@Test
	public void testProgressReportLogOff() {
	  PhaseStateMutant info = new PhaseStateMutant();
    info.setProcessName("setup");
    info.setThreadCount(1);
    info.setCount(100);
    info.setDoneCount(1);
		reporter.onProgress(logMock_, info);
		assertEquals(0, logRecord_.count());
		assertEquals(0, onThrowableRecord_.count());
		
	}
	
	
	@SuppressWarnings("boxing")
  @Test
	public void testProgressReportPartDone() {
	  when(logMock_.isLogEnabled(any())).thenReturn(true);
	  
		PhaseStateMutant info = new PhaseStateMutant();
    info.setProcessName("setup");
    info.setPercentDone(17.341);
		reporter.onProgress(logMock_, info);
		
		assertEquals(1, logLineRecord_.count());
		Object [] args = logLineRecord_.getArgs(0);
		
		I_Tests4J_ReportMessages messages = Tests4J_EnglishConstants.ENGLISH.getReportMessages();
		assertEquals("Tests4J: ", args[0]);
		assertEquals("setup", args[1]);
		assertEquals(" ", args[2]);
		assertEquals("17.34" + messages.getPctComplete(), args[3]);
		assertEquals(4, args.length);
		assertEquals(0, logRecord_.count());
		assertEquals(0, onThrowableRecord_.count());
		
	}
	
	@SuppressWarnings("boxing")
  @Test
	public void testProgressReportDone() {
	  when(logMock_.isLogEnabled(any())).thenReturn(true);
    
		PhaseStateMutant info = new PhaseStateMutant();
    info.setProcessName("setup");
    info.setPercentDone(100.0);
    info.setHasFinishedAll(true);
    reporter.onProgress(logMock_, info);
    
		assertEquals(1, logLineRecord_.count());
		Object [] args = logLineRecord_.getArgs(0);
		
		I_Tests4J_ReportMessages messages = Tests4J_EnglishConstants.ENGLISH.getReportMessages();
		assertEquals("Tests4J: ", args[0]);
		assertEquals("setup", args[1]);
		assertEquals(" ",args[2]);
		assertEquals(messages.getDoneEOS(),args[3]);
		assertEquals(4, args.length);
		assertEquals(0, onThrowableRecord_.count());
		assertEquals(0, logRecord_.count());
		
	}
	@Override
	public int getTests(I_CountType type) {
		return super.getTests(type, 3, true);
	}

	@Override
	public int getAsserts(I_CountType type) {
		int thisAsserts = 18;
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
		int thisUniqueAsserts = 15;
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
