package org.adligo.tests4j_tests.system.shared.report.summary;

import org.adligo.tests4j.shared.asserts.reference.AllowedReferences;
import org.adligo.tests4j.shared.common.DefaultSystem;
import org.adligo.tests4j.shared.en.Tests4J_EnglishConstants;
import org.adligo.tests4j.shared.i18n.I_Tests4J_ReportMessages;
import org.adligo.tests4j.shared.output.I_Tests4J_Log;
import org.adligo.tests4j.system.shared.report.summary.TestDisplay;
import org.adligo.tests4j.system.shared.report.summary.ThreadDisplay;
import org.adligo.tests4j.system.shared.trials.SourceFileScope;
import org.adligo.tests4j.system.shared.trials.Test;
import org.adligo.tests4j_4mockito.MethodRecorder;
import org.adligo.tests4j_tests.base_trials.I_CountType;
import org.adligo.tests4j_tests.base_trials.SourceFileCountingTrial;
import org.adligo.tests4j_tests.references_groups.Tests4J_Summary_GwtReferenceGroup;

@SourceFileScope (sourceClass=TestDisplay.class, minCoverage=80.0)
@AllowedReferences (groups=Tests4J_Summary_GwtReferenceGroup.class)
public class TestDisplayTrial extends SourceFileCountingTrial {
  private I_Tests4J_Log logMock_;
  private MethodRecorder<Void> logRecord_;
  private MethodRecorder<Void> onThrowableRecord_;
	private TestDisplay reporter;
	
	@Override
	public void beforeTests() {
	  logMock_ = mock(I_Tests4J_Log.class);
    logRecord_ = new MethodRecorder<Void>();
    doAnswer(logRecord_).when(logMock_).log(anyVararg());
    onThrowableRecord_ = new MethodRecorder<Void>();
    doAnswer(onThrowableRecord_).when(logMock_).onThrowable(any());
    when(logMock_.getLineSeperator()).thenReturn("lineSeperator");
    
	  reporter = new TestDisplay(logMock_, 
	      new ThreadDisplay(logMock_, new DefaultSystem()));
	}

	
	@SuppressWarnings("boxing")
  @Test
	public void testLogOff() {
		
		reporter.onStartingTest("someTrial[0]", "someTest");
		assertEquals(0, logRecord_.count());
		assertEquals(0, onThrowableRecord_.count());
		
	}
	
	@SuppressWarnings("boxing")
  @Test
	public void testStart() {
	  when(logMock_.isLogEnabled(TestDisplay.class)).thenReturn(true);
		
		reporter.onStartingTest("someTrial[0]", "someTest");
		
		assertEquals(1, logRecord_.count());
		I_Tests4J_ReportMessages messages = Tests4J_EnglishConstants.ENGLISH.getReportMessages();
		assertEquals("Tests4J"  + messages.getStartingTest() + "someTrial[0].someTest",
				logRecord_.getArgument(0));
		assertEquals(0, onThrowableRecord_.count());
		
	}
	@SuppressWarnings("boxing")
  @Test
	public void testProgressReportLogOff() {
		
		reporter.onTestCompleted("someTrial", "someTest", false);
		assertEquals(0, logRecord_.count());
		assertEquals(0, onThrowableRecord_.count());
		
	}
	
	@SuppressWarnings("boxing")
  @Test
	public void testSuccess() {
	  when(logMock_.isLogEnabled(eq(TestDisplay.class))).thenReturn(true);
    
		reporter.onTestCompleted("someTrial[0]", "someTest", true);
		
		assertEquals(1, logRecord_.count());
		I_Tests4J_ReportMessages messages = Tests4J_EnglishConstants.ENGLISH.getReportMessages();
		assertEquals("Tests4J"  + messages.getTestHeading() + "someTrial[0].someTest" + messages.getPassedEOS(),
				logRecord_.getArgument(0));
		assertEquals(0, onThrowableRecord_.count());
		
	}
	
	
	@SuppressWarnings("boxing")
  @Test
	public void testFailedDelegate() {
	  when(logMock_.isLogEnabled(any())).thenReturn(true);
    
		reporter.onTestCompleted("someTrial[0]", "someTest", false);
		
		assertEquals(1, logRecord_.count());
		I_Tests4J_ReportMessages messages = Tests4J_EnglishConstants.ENGLISH.getReportMessages();
		assertEquals("Tests4J"  + messages.getTestHeading() + "someTrial[0].someTest" + messages.getFailedEOS(),
				logRecord_.getArgument(0));
		assertEquals(0, onThrowableRecord_.count());
		
	}
	
	@Override
	public int getTests(I_CountType type) {
		return super.getTests(type, 5, true);
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
		int thisUniqueAsserts = 11;
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
