package org.adligo.tests4j_tests.system.shared.report.summary;

import org.adligo.tests4j.models.shared.results.BaseTrialResultMutant;
import org.adligo.tests4j.models.shared.results.I_TrialResult;
import org.adligo.tests4j.shared.asserts.reference.AllowedReferences;
import org.adligo.tests4j.shared.en.Tests4J_EnglishConstants;
import org.adligo.tests4j.shared.i18n.I_Tests4J_ReportMessages;
import org.adligo.tests4j.shared.output.I_Tests4J_Log;
import org.adligo.tests4j.system.shared.report.summary.TrialFailedDisplay;
import org.adligo.tests4j.system.shared.trials.SourceFileScope;
import org.adligo.tests4j.system.shared.trials.Test;
import org.adligo.tests4j_4mockito.MockMethod;
import org.adligo.tests4j_tests.base_trials.I_CountType;
import org.adligo.tests4j_tests.base_trials.SourceFileCountingTrial;
import org.adligo.tests4j_tests.references_groups.Tests4J_Summary_GwtReferenceGroup;

import java.util.List;

@SourceFileScope (sourceClass=TrialFailedDisplay.class, minCoverage=70.0)
@AllowedReferences (groups=Tests4J_Summary_GwtReferenceGroup.class)
public class TrialFailedDisplayTrial extends SourceFileCountingTrial {
  private I_Tests4J_Log logMock_;
  private MockMethod<Void> logRecord_;
  private MockMethod<Void> logLineRecord_;
  private MockMethod<Void> onThrowableRecord_;
  
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
	}

	
	@SuppressWarnings("boxing")
  @Test
	public void testProgressReportLogOff() {
		TrialFailedDisplay display = new TrialFailedDisplay(Tests4J_EnglishConstants.ENGLISH, logMock_);
		
		BaseTrialResultMutant btrm = new BaseTrialResultMutant();
		btrm.setTrialName("someTrialName");
		
		display.onTrailFailed(btrm);
		assertEquals(0, logRecord_.count());
		assertEquals(0, onThrowableRecord_.count());
		
		List<I_TrialResult> results =  display.getFailedTrials();
		assertNotNull(results);
		assertEquals(1, results.size());
		assertSame(btrm, results.get(0));
	}
	
	
	@SuppressWarnings("boxing")
  @Test
	public void testProgressReportPartDone() {
		TrialFailedDisplay display = new TrialFailedDisplay(
		    Tests4J_EnglishConstants.ENGLISH,logMock_);
		when(logMock_.isLogEnabled(any())).thenReturn(true);
		
		BaseTrialResultMutant btrm = new BaseTrialResultMutant();
		btrm.setTrialName("someOtherTrialName");
		
		
		display.onTrailFailed(btrm);
		
		assertEquals(1, logLineRecord_.count());
		Object [] args = logLineRecord_.getArgs(0);
		I_Tests4J_ReportMessages messages = Tests4J_EnglishConstants.ENGLISH.getReportMessages();
		
		assertEquals("Tests4J" ,args[0]);
		assertEquals(messages.getTrialHeading(),args[1]);
		assertEquals("someOtherTrialName",args[2]);
		assertEquals(messages.getFailedEOS(),args[3]);
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
		return super.getTests(type, 2, true);
	}

	@Override
	public int getAsserts(I_CountType type) {
		int thisAsserts = 16;
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
		int thisUniqueAsserts = 13;
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
