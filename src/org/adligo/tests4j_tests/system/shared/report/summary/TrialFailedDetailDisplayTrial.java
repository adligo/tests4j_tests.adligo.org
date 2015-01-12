package org.adligo.tests4j_tests.system.shared.report.summary;

import org.adligo.tests4j.models.shared.results.BaseTrialResultMutant;
import org.adligo.tests4j.shared.asserts.reference.AllowedReferences;
import org.adligo.tests4j.shared.asserts.reference.CircularDependencies;
import org.adligo.tests4j.shared.en.Tests4J_EnglishConstants;
import org.adligo.tests4j.shared.i18n.I_Tests4J_ReportMessages;
import org.adligo.tests4j.shared.output.I_Tests4J_Log;
import org.adligo.tests4j.system.shared.report.summary.TrialFailedDetailDisplay;
import org.adligo.tests4j.system.shared.trials.SourceFileScope;
import org.adligo.tests4j.system.shared.trials.Test;
import org.adligo.tests4j_4mockito.MockMethod;
import org.adligo.tests4j_tests.base_trials.I_CountType;
import org.adligo.tests4j_tests.base_trials.SourceFileCountingTrial;
import org.adligo.tests4j_tests.references_groups.Tests4J_Summary_GwtReferenceGroup;

@SourceFileScope (sourceClass=TrialFailedDetailDisplay.class, minCoverage=4.0,
		allowedCircularDependencies=CircularDependencies.AllowInnerOuterClasses)
@AllowedReferences (groups=Tests4J_Summary_GwtReferenceGroup.class)
public class TrialFailedDetailDisplayTrial extends SourceFileCountingTrial {
  private I_Tests4J_Log logMock_;
  private MockMethod<Void> logRecord_;
  private MockMethod<Void> onThrowableRecord_;
	
	@Override
	public void beforeTests() {
	  logMock_ = mock(I_Tests4J_Log.class);
    logRecord_ = new MockMethod<Void>();
    doAnswer(logRecord_).when(logMock_).log(anyVararg());
    onThrowableRecord_ = new MockMethod<Void>();
    doAnswer(onThrowableRecord_).when(logMock_).onThrowable(any());
    when(logMock_.getLineSeperator()).thenReturn("lineSeperator");
	}

	
	@SuppressWarnings("boxing")
  @Test
	public void testProgressReportLogOff() {
		TrialFailedDetailDisplay display = new TrialFailedDetailDisplay(logMock_);
		
		BaseTrialResultMutant btrm = new BaseTrialResultMutant();
		btrm.setTrialName("someTrialName");
		
		display.logTrialFailure(btrm);
		assertEquals(0, logRecord_.count());
		assertEquals(0, onThrowableRecord_.count());
	}
	
	@SuppressWarnings("boxing")
  @Test
	public void testProgressReportBasicLog() {
		TrialFailedDetailDisplay display = new TrialFailedDetailDisplay(logMock_);
		when(logMock_.isLogEnabled(any())).thenReturn(true);
		
		BaseTrialResultMutant btrm = new BaseTrialResultMutant();
		btrm.setTrialName("someTrialName");
		
		display.logTrialFailure(btrm);
		
		I_Tests4J_ReportMessages messages =  Tests4J_EnglishConstants.ENGLISH.getReportMessages();
		
		assertEquals("someTrialName" + messages.getFailedEOS() + 
				"lineSeperator", logRecord_.getArg(0));
		assertEquals(1, logRecord_.count());
		assertEquals(0, onThrowableRecord_.count());
	}
	
	
	@Override
	public int getTests(I_CountType type) {
		return super.getTests(type, 2, true);
	}

	@Override
	public int getAsserts(I_CountType type) {
		int thisAsserts = 5;
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
		int thisUniqueAsserts = 4;
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
