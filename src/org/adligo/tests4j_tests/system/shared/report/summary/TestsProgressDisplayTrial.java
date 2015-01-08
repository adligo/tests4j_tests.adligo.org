package org.adligo.tests4j_tests.system.shared.report.summary;

import org.adligo.tests4j.models.shared.results.PhaseStateMutant;
import org.adligo.tests4j.shared.asserts.reference.AllowedReferences;
import org.adligo.tests4j.shared.en.Tests4J_EnglishConstants;
import org.adligo.tests4j.shared.i18n.I_Tests4J_ReportMessages;
import org.adligo.tests4j.shared.output.I_Tests4J_Log;
import org.adligo.tests4j.system.shared.report.summary.TestsProgressDisplay;
import org.adligo.tests4j.system.shared.trials.SourceFileScope;
import org.adligo.tests4j.system.shared.trials.Test;
import org.adligo.tests4j_4mockito.MethodRecorder;
import org.adligo.tests4j_tests.base_trials.I_CountType;
import org.adligo.tests4j_tests.base_trials.SourceFileCountingTrial;
import org.adligo.tests4j_tests.references_groups.Tests4J_Summary_GwtReferenceGroup;

@SourceFileScope (sourceClass=TestsProgressDisplay.class)
@AllowedReferences (groups=Tests4J_Summary_GwtReferenceGroup.class)
public class TestsProgressDisplayTrial extends SourceFileCountingTrial {
  private I_Tests4J_Log logMock_;
  private MethodRecorder<Void> logRecord_;
  private MethodRecorder<Void> logLineRecord_;
  private MethodRecorder<Void> onThrowableRecord_;
	private TestsProgressDisplay reporter_;
	
	@Override
	public void beforeTests() {
	  logMock_ = mock(I_Tests4J_Log.class);
    logRecord_ = new MethodRecorder<Void>();
    doAnswer(logRecord_).when(logMock_).log(any());
    logLineRecord_ = new MethodRecorder<Void>();
    doAnswer(logLineRecord_).when(logMock_).logLine(anyVararg());
    onThrowableRecord_ = new MethodRecorder<Void>();
    doAnswer(onThrowableRecord_).when(logMock_).onThrowable(any());
    when(logMock_.getLineSeperator()).thenReturn("lineSeperator");
    
		reporter_ = new TestsProgressDisplay();
	}

	
	@SuppressWarnings("boxing")
  @Test
	public void testProgressReportLogOff() {
	  PhaseStateMutant info = new PhaseStateMutant();
    info.setProcessName("tests");
    info.setPercentDone(100.0);
    info.setHasFinishedAll(true);
		reporter_.onProgress(logMock_, info);
		
		assertEquals(0, logRecord_.count());
		assertEquals(0, onThrowableRecord_.count());
		
	}
	
	
	@SuppressWarnings("boxing")
  @Test
	public void testProgressReportPartDone() {
	  when(logMock_.isLogEnabled(any())).thenReturn(true);
	  
		PhaseStateMutant info = new PhaseStateMutant();
    info.setProcessName("tests");
    info.setPercentDone(17.343);
		reporter_.onProgress(logMock_, info);
		
		assertEquals(1, logLineRecord_.count());
		Object [] args = logLineRecord_.getArguments(0);
		
		I_Tests4J_ReportMessages messages = Tests4J_EnglishConstants.ENGLISH.getReportMessages();
		assertEquals("Tests4J: ", args[0]);
		assertEquals("tests", args[1]);
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
    info.setProcessName("tests");
    info.setPercentDone(100.0);
    info.setHasFinishedAll(true);
		reporter_.onProgress(logMock_, info);
		
		assertEquals(1, logLineRecord_.count());
		Object [] args = logLineRecord_.getArguments(0);
		assertEquals(4, args.length);
		I_Tests4J_ReportMessages messages = Tests4J_EnglishConstants.ENGLISH.getReportMessages();
		assertEquals("Tests4J: ", args[0]);
		assertEquals("tests", args[1]);
		assertEquals(" ", args[2]);
		assertEquals(messages.getDoneEOS(), args[3]);
		assertEquals(4, args.length);
		assertEquals(0, logRecord_.count());
		assertEquals(0, onThrowableRecord_.count());
	}
	
	@Override
	public int getTests(I_CountType type) {
		return super.getTests(type, 3, true);
	}

	@Override
	public int getAsserts(I_CountType type) {
		int thisAsserts = 19;
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
