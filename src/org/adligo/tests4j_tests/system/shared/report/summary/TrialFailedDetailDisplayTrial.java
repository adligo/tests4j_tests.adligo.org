package org.adligo.tests4j_tests.system.shared.report.summary;

import org.adligo.tests4j.models.shared.results.BaseTrialResultMutant;
import org.adligo.tests4j.models.shared.results.TestResultMutant;
import org.adligo.tests4j.shared.asserts.common.AssertCompareFailureMutant;
import org.adligo.tests4j.shared.asserts.common.AssertType;
import org.adligo.tests4j.shared.asserts.reference.AllowedReferences;
import org.adligo.tests4j.shared.asserts.reference.CircularDependencies;
import org.adligo.tests4j.shared.en.Tests4J_EnglishConstants;
import org.adligo.tests4j.shared.i18n.I_Tests4J_Constants;
import org.adligo.tests4j.shared.i18n.I_Tests4J_ReportMessages;
import org.adligo.tests4j.shared.output.I_Tests4J_Log;
import org.adligo.tests4j.system.shared.report.summary.TrialFailedDetailDisplay;
import org.adligo.tests4j.system.shared.trials.AfterTrial;
import org.adligo.tests4j.system.shared.trials.BeforeTrial;
import org.adligo.tests4j.system.shared.trials.SourceFileScope;
import org.adligo.tests4j.system.shared.trials.Test;
import org.adligo.tests4j_4mockito.MockMethod;
import org.adligo.tests4j_tests.base_trials.I_CountType;
import org.adligo.tests4j_tests.base_trials.SourceFileCountingTrial;
import org.adligo.tests4j_tests.references_groups.Tests4J_Summary_GwtReferenceGroup;

import java.util.Map;

@SourceFileScope (sourceClass=TrialFailedDetailDisplay.class, minCoverage=4.0,
		allowedCircularDependencies=CircularDependencies.AllowInnerOuterClasses)
@AllowedReferences (groups=Tests4J_Summary_GwtReferenceGroup.class)
public class TrialFailedDetailDisplayTrial extends SourceFileCountingTrial {
  private I_Tests4J_Log logMock_;
  private MockMethod<Void> logRecord_;
  private MockMethod<Void> onThrowableRecord_;
  private static I_Tests4J_Constants constantsMock_;
  private static I_Tests4J_ReportMessages messageMock_;
	
  @SuppressWarnings("boxing")
  @BeforeTrial
  public static void beforeTrial(Map<String,Object> params) {
    constantsMock_ = mock(I_Tests4J_Constants.class);
    when(constantsMock_.isLeftToRight()).thenReturn(true);
    messageMock_ = mock(I_Tests4J_ReportMessages.class);
    when(constantsMock_.getReportMessages()).thenReturn(messageMock_);
  }
	@Override
	public void beforeTests() {

	  logMock_ = mock(I_Tests4J_Log.class);
    logRecord_ = new MockMethod<Void>();
    doAnswer(logRecord_).when(logMock_).log(anyVararg());
    onThrowableRecord_ = new MockMethod<Void>();
    doAnswer(onThrowableRecord_).when(logMock_).onThrowable(any());
    when(logMock_.lineSeparator()).thenReturn("\n");
    
	}

	@AfterTrial
	public static void afterTrial() {
	}
	
	@SuppressWarnings("boxing")
  @Test
	public void testProgressReportLogOff() {
		TrialFailedDetailDisplay display = new TrialFailedDetailDisplay(Tests4J_EnglishConstants.ENGLISH, logMock_);
		
		BaseTrialResultMutant btrm = new BaseTrialResultMutant();
		btrm.setTrialName("someTrialName");
		
		display.logTrialFailure(btrm);
		assertEquals(0, logRecord_.count());
		assertEquals(0, onThrowableRecord_.count());
	}
	
	@SuppressWarnings("boxing")
  @Test
	public void testProgressReportBasicLog() {
		TrialFailedDetailDisplay display = new TrialFailedDetailDisplay(constantsMock_, logMock_);
		when(logMock_.isLogEnabled(any())).thenReturn(true);
		
		BaseTrialResultMutant btrm = new BaseTrialResultMutant();
		btrm.setTrialName("someTrialName");
		
    when(messageMock_.getFailedEOS()).thenReturn(" failed.");
		display.logTrialFailure(btrm);
		
		assertEquals("someTrialName failed.\n", logRecord_.getArg(0));
		assertEquals(1, logRecord_.count());
		assertEquals(0, onThrowableRecord_.count());
	}
	
	
	@SuppressWarnings("boxing")
  @Test
  public void testActualLinesMissing() {
    TrialFailedDetailDisplay display = new TrialFailedDetailDisplay(constantsMock_, logMock_);
    when(logMock_.isLogEnabled(any())).thenReturn(true);
    
    BaseTrialResultMutant btrm = new BaseTrialResultMutant();
    btrm.setTrialName("someTrialName");
    
    AssertCompareFailureMutant failure = new AssertCompareFailureMutant();
    failure.setActualClass(String.class.getName());
    failure.setExpectedClass(String.class.getName());
    failure.setExpectedValue("");
    failure.setActualValue("1\n2\n3\n");
    failure.setAssertType(AssertType.AssertEquals);
    TestResultMutant trm = new TestResultMutant();
    trm.setName("testFoo");
    failure.setFailureMessage("The objects must be equal.");
    trm.setFailure(failure);
    btrm.addResult(trm);
    
    when(messageMock_.getIndent()).thenReturn("indent ");
    when(messageMock_.getFailedEOS()).thenReturn(" failed.");
    when(messageMock_.getExpected()).thenReturn("Expected:");
    when(messageMock_.getActual()).thenReturn("Actual:");
    when(messageMock_.getTheFollowingActualLineNumberNotExpected()).thenReturn("The following actual lines weren't expected;");
    display.logTrialFailure(btrm);
    
    assertEquals("someTrialName failed.\n" +
        "indent someTrialName.testFoo() failed.\n" +
        "indent The objects must be equal.\n" +
        "indent Expected:\n" +
        "indent ''\n" +
        "indent Actual:\n" +
        "indent 1: '1'\n" +
        "indent 2: '2'\n" +
        "indent 3: '3'\n" +
        "indent The following actual lines weren't expected;\n" +
        "indent indent 1: '1'\n" +
        "indent indent 2: '2'\n" +
        "indent indent 3: '3'\n" 
        , logRecord_.getArg(0));
    assertEquals(1, logRecord_.count());
    assertEquals(0, onThrowableRecord_.count());
  }
	
	  @SuppressWarnings("boxing")
	  @Test
	  public void testExpectedLinesMissing() {
	    TrialFailedDetailDisplay display = new TrialFailedDetailDisplay(constantsMock_, logMock_);
	    when(logMock_.isLogEnabled(any())).thenReturn(true);
	    
	    BaseTrialResultMutant btrm = new BaseTrialResultMutant();
	    btrm.setTrialName("someTrialName");
	    
	    AssertCompareFailureMutant failure = new AssertCompareFailureMutant();
	    failure.setActualClass(String.class.getName());
	    failure.setExpectedClass(String.class.getName());
	    failure.setExpectedValue("1\n2\n3\n");
	    failure.setActualValue("");
	    failure.setAssertType(AssertType.AssertEquals);
	    TestResultMutant trm = new TestResultMutant();
	    trm.setName("testFoo");
	    failure.setFailureMessage("The objects must be equal.");
	    trm.setFailure(failure);
	    btrm.addResult(trm);
	    
	    when(messageMock_.getIndent()).thenReturn("indent ");
	    when(messageMock_.getFailedEOS()).thenReturn(" failed.");
	    when(messageMock_.getActual()).thenReturn("Actual:");
	    when(messageMock_.getExpected()).thenReturn("Expected:");
	    when(messageMock_.getTheFollowingExpectedLineNumbersWereMissing()).thenReturn(
	        "The following expected lines were missing;");
	    display.logTrialFailure(btrm);
	    
	    
	    assertEquals("someTrialName failed.\n" +
	        "indent someTrialName.testFoo() failed.\n" +
	        "indent The objects must be equal.\n" +
	        "indent Expected:\n" +
	        "indent 1: '1'\n" +
          "indent 2: '2'\n" +
          "indent 3: '3'\n" +
	        "indent The following expected lines were missing;\n" +
	        "indent indent 1: '1'\n" +
	        "indent indent 2: '2'\n" +
	        "indent indent 3: '3'\n" + 
	        "indent Actual:\n" +
          "indent ''\n", logRecord_.getArg(0));
	    assertEquals(1, logRecord_.count());
	    assertEquals(0, onThrowableRecord_.count());
	  }
	 
	@Override
	public int getTests(I_CountType type) {
		return super.getTests(type, 4, true);
	}

	@Override
	public int getAsserts(I_CountType type) {
		int thisAsserts = 11;
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
		int thisUniqueAsserts = 10;
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
