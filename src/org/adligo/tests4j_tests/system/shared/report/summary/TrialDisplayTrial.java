package org.adligo.tests4j_tests.system.shared.report.summary;

import org.adligo.tests4j.models.shared.results.BaseTrialResultMutant;
import org.adligo.tests4j.models.shared.results.I_TrialResult;
import org.adligo.tests4j.models.shared.results.TestResultMutant;
import org.adligo.tests4j.shared.asserts.reference.AllowedReferences;
import org.adligo.tests4j.shared.common.DefaultSystem;
import org.adligo.tests4j.shared.en.Tests4J_EnglishConstants;
import org.adligo.tests4j.shared.i18n.I_Tests4J_ReportMessages;
import org.adligo.tests4j.shared.output.I_Tests4J_Log;
import org.adligo.tests4j.system.shared.report.summary.ThreadDisplay;
import org.adligo.tests4j.system.shared.report.summary.TrialDisplay;
import org.adligo.tests4j.system.shared.trials.SourceFileScope;
import org.adligo.tests4j.system.shared.trials.Test;
import org.adligo.tests4j_4mockito.MockMethod;
import org.adligo.tests4j_tests.base_trials.I_CountType;
import org.adligo.tests4j_tests.base_trials.SourceFileCountingTrial;
import org.adligo.tests4j_tests.references_groups.Tests4J_Summary_GwtReferenceGroup;

import java.util.List;

@SourceFileScope (sourceClass=TrialDisplay.class, minCoverage=83.0)
@AllowedReferences (groups=Tests4J_Summary_GwtReferenceGroup.class)
public class TrialDisplayTrial extends SourceFileCountingTrial {
  private I_Tests4J_Log logMock_;
  private MockMethod<Void> logRecord_;
  private MockMethod<Void> logLineRecord_;
  private MockMethod<Void> onThrowableRecord_;
	private ThreadDisplay threadDisplay;
	
	@Override
	public void beforeTests() {
	  logMock_ = mock(I_Tests4J_Log.class);
    logRecord_ = new MockMethod<Void>();
    doAnswer(logRecord_).when(logMock_).log(any());
    logLineRecord_ = new MockMethod<Void>();
    doAnswer(logLineRecord_).when(logMock_).logLine(anyVararg());
    onThrowableRecord_ = new MockMethod<Void>();
    doAnswer(onThrowableRecord_).when(logMock_).onThrowable(any());
    when(logMock_.lineSeparator()).thenReturn("lineSeperator");
    
	  threadDisplay = new ThreadDisplay(logMock_, new DefaultSystem());
	}

	
	@SuppressWarnings("boxing")
  @Test
	public void testStartReportLogOff() {
		TrialDisplay display = new TrialDisplay(Tests4J_EnglishConstants.ENGLISH,  logMock_, threadDisplay);
		
		display.onStartingTrial("someTrialName");
		assertEquals(0, logRecord_.count());
		assertEquals(0, onThrowableRecord_.count());
		
		List<I_TrialResult> results =  display.getFailedTrials();
		assertNotNull(results);
		assertEquals(0, results.size());
	}
	
	@SuppressWarnings("boxing")
  @Test
	public void testStartReportLogOn() {
		TrialDisplay display = new TrialDisplay(Tests4J_EnglishConstants.ENGLISH, logMock_, threadDisplay);
		when(logMock_.isLogEnabled(TrialDisplay.class)).thenReturn(true);
		
		display.onStartingTrial("someTrialName");
		assertEquals(1, logRecord_.count());
		I_Tests4J_ReportMessages messages = Tests4J_EnglishConstants.ENGLISH.getReportMessages();
		
		assertEquals("Tests4J" + messages.getStartingTrial() + "someTrialName", logRecord_.getArg(0));
		assertEquals(0, onThrowableRecord_.count());
		
		List<I_TrialResult> results =  display.getFailedTrials();
		assertNotNull(results);
		assertEquals(0, results.size());
	}
	
	
	@SuppressWarnings("boxing")
  @Test
	public void testPassedLogOff() {
		TrialDisplay display = new TrialDisplay(Tests4J_EnglishConstants.ENGLISH, logMock_, threadDisplay);
		
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
		assertEquals(0, logRecord_.count());
		assertEquals(0, onThrowableRecord_.count());
		
		List<I_TrialResult> results =  display.getFailedTrials();
		assertNotNull(results);
		assertEquals(0, results.size());
	}
	
	@SuppressWarnings("boxing")
  @Test
	public void testPassedLogOn() {
		TrialDisplay display = new TrialDisplay(Tests4J_EnglishConstants.ENGLISH, logMock_, threadDisplay);
		when(logMock_.isLogEnabled(any())).thenReturn(true);
		
		BaseTrialResultMutant btrm = new BaseTrialResultMutant();
		btrm.setTrialName("someTrialName");
		
		TestResultMutant trm = new TestResultMutant();
		trm.setPassed(true);
		trm.setName("someTestName");
		
		btrm.setPassed(true);
		btrm.addResult(trm);
		assertTrue(btrm.isPassed());
		
		display.onTrialCompleted(btrm);
		assertEquals(1, logRecord_.count());
		I_Tests4J_ReportMessages messages = Tests4J_EnglishConstants.ENGLISH.getReportMessages();
		assertEquals("Tests4J" + messages.getTrialHeading() + "someTrialName" + messages.getPassedEOS(),
				logRecord_.getArg(0));
		assertEquals(0, onThrowableRecord_.count());
		
		List<I_TrialResult> results =  display.getFailedTrials();
		assertNotNull(results);
		assertEquals(0, results.size());
	}
	
	
	
	@SuppressWarnings("boxing")
  @Test
	public void testFailedLogOff() {
		TrialDisplay display = new TrialDisplay(Tests4J_EnglishConstants.ENGLISH, logMock_, threadDisplay);
		
		BaseTrialResultMutant btrm = new BaseTrialResultMutant();
		btrm.setTrialName("someOtherTrialName");
		btrm.setPassed(false);
		
		display.onTrialCompleted(btrm);
		
		assertEquals(0, logRecord_.count());
		assertEquals(0, onThrowableRecord_.count());
		
		List<I_TrialResult> results =  display.getFailedTrials();
		assertNotNull(results);
		assertEquals(1, results.size());
		assertSame(btrm, results.get(0));
	}
	
	@SuppressWarnings("boxing")
  @Test
	public void testFailedLogOn() {
		TrialDisplay display = new TrialDisplay(Tests4J_EnglishConstants.ENGLISH, logMock_, threadDisplay);
		when(logMock_.isLogEnabled(any())).thenReturn(true);
		
		BaseTrialResultMutant btrm = new BaseTrialResultMutant();
		btrm.setTrialName("someOtherTrialName");
		btrm.setPassed(false);
		
		
		display.onTrialCompleted(btrm);
		
		assertEquals(1, logLineRecord_.count());
		Object [] args = logLineRecord_.getArgs(0);
		I_Tests4J_ReportMessages messages = Tests4J_EnglishConstants.ENGLISH.getReportMessages();
		assertEquals("Tests4J", args[0]);
		assertEquals(messages.getTrialHeading(), args[1]);
		assertEquals("someOtherTrialName", args[2]);
		assertEquals(messages.getFailedEOS(), args[3]);
		assertEquals(4, args.length);
		
		assertEquals(0, logRecord_.count());
		assertEquals(0, onThrowableRecord_.count());
		
		
		List<I_TrialResult> results =  display.getFailedTrials();
		assertNotNull(results);
		assertEquals(1, results.size());
		assertSame(btrm, results.get(0));
	}
	
	
	
	@Override
	public int getTests(I_CountType type) {
		return super.getTests(type, 6, true);
	}

	@Override
	public int getAsserts(I_CountType type) {
		int thisAsserts = 36;
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
		int thisUniqueAsserts = 27;
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
