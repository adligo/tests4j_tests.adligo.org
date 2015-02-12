package org.adligo.tests4j_tests.system.shared.report.summary;

import org.adligo.tests4j.shared.asserts.common.AssertThrownFailureMutant;
import org.adligo.tests4j.shared.asserts.common.MatchType;
import org.adligo.tests4j.shared.asserts.common.ThrowableInfoMutant;
import org.adligo.tests4j.shared.asserts.reference.AllowedReferences;
import org.adligo.tests4j.shared.asserts.reference.CircularDependencies;
import org.adligo.tests4j.shared.i18n.I_Tests4J_Constants;
import org.adligo.tests4j.shared.i18n.I_Tests4J_ReportMessages;
import org.adligo.tests4j.shared.output.I_Tests4J_Log;
import org.adligo.tests4j.system.shared.report.summary.TextDataDisplay;
import org.adligo.tests4j.system.shared.report.summary.ThrownFailureComparisonDisplay;
import org.adligo.tests4j.system.shared.trials.SourceFileScope;
import org.adligo.tests4j.system.shared.trials.Test;
import org.adligo.tests4j_4mockito.MockMethod;
import org.adligo.tests4j_tests.base_trials.I_CountType;
import org.adligo.tests4j_tests.base_trials.SourceFileCountingTrial;
import org.adligo.tests4j_tests.references_groups.Tests4J_Summary_GwtReferenceGroup;

import java.io.IOException;

@SourceFileScope (sourceClass=ThrownFailureComparisonDisplay.class, minCoverage=99.0)
@AllowedReferences (groups=Tests4J_Summary_GwtReferenceGroup.class)
public class ThrownFailureComparisonDisplayTrial extends SourceFileCountingTrial {
  private I_Tests4J_Log logMock_;
  private MockMethod<Void> logMethod_ = new MockMethod<Void>();
  private MockMethod<Void> onThrowableMethod_  = new MockMethod<Void>();
  private I_Tests4J_Constants constantsMock_;
  private I_Tests4J_ReportMessages messageMock_;
	private ThrownFailureComparisonDisplay display_;
	
  @SuppressWarnings("boxing")
  public void beforeTests() {
    constantsMock_ = mock(I_Tests4J_Constants.class);
    when(constantsMock_.isLeftToRight()).thenReturn(true);
    messageMock_ = mock(I_Tests4J_ReportMessages.class);
    when(constantsMock_.getReportMessages()).thenReturn(messageMock_);
    when(messageMock_.getIndent()).thenReturn("\t");
    when(messageMock_.getActual()).thenReturn(":Actual:");
    
    when(messageMock_.getExpected()).thenReturn(":Expected:");
    when(messageMock_.getDifferences()).thenReturn(":Differences:");
    when(messageMock_.getTheFollowingTextWasNotFoundInTheActualText()).thenReturn(
        ":The following text was NOT found in the actual text:");
    when(messageMock_.getTheFollowingExpectedLineNumbersWereMissing()).thenReturn(
        ":The following EXPECTED lines were missing:");
    when(messageMock_.getTheFollowingActualLineNumberNotExpected()).thenReturn(
        ":The following ACTUAL lines were missing:");
    
    logMock_ = mock(I_Tests4J_Log.class);
    doAnswer(logMethod_).when(logMock_).log(any());
    doAnswer(onThrowableMethod_).when(logMock_).onThrowable(any());
    when(logMock_.lineSeparator()).thenReturn("\n");
    display_ = new ThrownFailureComparisonDisplay(constantsMock_, logMock_);
  }
  
  @Test
  public void testMethodAddDisplayFirstThrowableAnyAndNullMatchTypeDiff() {
    AssertThrownFailureMutant atf = new AssertThrownFailureMutant();
   
    ThrowableInfoMutant expected = new ThrowableInfoMutant();
    expected.setClassName(IOException.class.getName());
    expected.setMessage("message");
    atf.setExpected(expected);
    
    StringBuilder sb = new StringBuilder();
    display_.addThrownMessages(atf, sb);
    
    //null match type
    String actualResult = sb.toString();
    assertEquals("\t:Expected:\n" + 
        "\tjava.io.IOException\n" + 
        "\t:Actual:\n" +
        "\tnull\n", actualResult);
    
    expected.setMatchType(MatchType.ANY);
    sb = new StringBuilder();
    display_.addThrownMessages(atf, sb);
    actualResult = sb.toString();
    assertEquals("\t:Expected:\n" + 
        "\tjava.io.IOException\n" + 
        "\t:Actual:\n" +
        "\tnull\n", actualResult);
    
    expected.setMatchType(null);
    ThrowableInfoMutant actual = new ThrowableInfoMutant();
    actual.setClassName(IOException.class.getName());
    
    atf.setActual(actual);
    
    sb = new StringBuilder();
    display_.addThrownMessages(atf, sb);
    actualResult = sb.toString();
    assertEquals("\t:Expected:\n" + 
        "\tjava.io.IOException\n" + 
        "\t\t'message'\n" +
        "\t:Actual:\n" +
        "\tjava.io.IOException\n" +
        "\t\tnull\n",actualResult);
    
    expected.setMatchType(MatchType.ANY);
    sb = new StringBuilder();
    display_.addThrownMessages(atf, sb);
    actualResult = sb.toString();
    assertEquals("\t:Expected:\n" + 
        "\tjava.io.IOException\n" + 
        "\t\t'message'\n" +
        "\t:Actual:\n" +
        "\tjava.io.IOException\n" +
        "\t\tnull\n",actualResult);
    
    expected.setMatchType(null);
    actual.setMessage("message2");
    sb = new StringBuilder();
    display_.addThrownMessages(atf, sb);
    actualResult = sb.toString();
    assertEquals("\t:Expected:\n" + 
        "\tjava.io.IOException\n" + 
        "\t\t:Expected:\n" +
        "\t\t'message'\n" +
        "\t:Actual:\n" +
        "\tjava.io.IOException\n" +
        "\t\t:Actual:\n" +
        "\t\t'message2'\n" + 
        "\t\t\t:Differences:\n" +
        "\t\t\t1: '2'\n"
        ,actualResult);
    
    expected.setMatchType(MatchType.ANY);
    actual.setMessage("message2");
    sb = new StringBuilder();
    display_.addThrownMessages(atf, sb);
    actualResult = sb.toString();
    assertEquals("\t:Expected:\n" + 
        "\tjava.io.IOException\n" + 
        "\t\t:Expected:\n" +
        "\t\t'message'\n" +
        "\t:Actual:\n" +
        "\tjava.io.IOException\n" +
        "\t\t:Actual:\n" +
        "\t\t'message2'\n" + 
        "\t\t\t:Differences:\n" +
        "\t\t\t1: '2'\n"
        ,actualResult);
    
    
    sb = new StringBuilder();
    display_.addThrownMessages(atf, sb);
    actualResult = sb.toString();
    assertEquals("\t:Expected:\n" + 
        "\tjava.io.IOException\n" + 
        "\t\t:Expected:\n" +
        "\t\t'message'\n" +
        "\t:Actual:\n" +
        "\tjava.io.IOException\n" +
        "\t\t:Actual:\n" +
        "\t\t'message2'\n" + 
        "\t\t\t:Differences:\n" +
        "\t\t\t1: '2'\n"
        ,actualResult);
  }

  @SuppressWarnings("boxing")
  @Test
  public void testMethodAddDisplayFirstThrowableAnyAndNullMatchTypeRTL() {

    when(constantsMock_.isLeftToRight()).thenReturn(false);
    display_ = new ThrownFailureComparisonDisplay(constantsMock_, logMock_);
    AssertThrownFailureMutant atf = new AssertThrownFailureMutant();
   
    ThrowableInfoMutant expected = new ThrowableInfoMutant();
    expected.setClassName(IOException.class.getName());
    expected.setMessage("message");
    atf.setExpected(expected);
    
    StringBuilder sb = new StringBuilder();
    display_.addThrownMessages(atf, sb);
    
    //null match type
    String actualResult = sb.toString();
    assertEquals(":Expected:\t\n" + 
        "java.io.IOException\t\n" + 
        ":Actual:\t\n" +
        "null\t\n", actualResult);
    
    expected.setMatchType(MatchType.ANY);
    sb = new StringBuilder();
    display_.addThrownMessages(atf, sb);
    actualResult = sb.toString();
    assertEquals(":Expected:\t\n" + 
        "java.io.IOException\t\n" + 
        ":Actual:\t\n" +
        "null\t\n", actualResult);
    
    ThrowableInfoMutant actual = new ThrowableInfoMutant();
    actual.setClassName(IOException.class.getName());
    
    atf.setActual(actual);
    
    expected.setMatchType(null);
    sb = new StringBuilder();
    display_.addThrownMessages(atf, sb);
    actualResult = sb.toString();
    assertEquals(":Expected:\t\n" + 
        "java.io.IOException\t\n" + 
        "'message'\t\t\n" +
        ":Actual:\t\n" +
        "java.io.IOException\t\n" +
        "null\t\t\n",actualResult);
    
    expected.setMatchType(MatchType.ANY);
    sb = new StringBuilder();
    display_.addThrownMessages(atf, sb);
    actualResult = sb.toString();
    assertEquals(":Expected:\t\n" + 
        "java.io.IOException\t\n" + 
        "'message'\t\t\n" +
        ":Actual:\t\n" +
        "java.io.IOException\t\n" +
        "null\t\t\n",actualResult);
    
    expected.setMatchType(null);
    actual.setMessage("message2");
    sb = new StringBuilder();
    display_.addThrownMessages(atf, sb);
    actualResult = sb.toString();
    assertEquals(":Expected:\t\n" + 
        "java.io.IOException\t\n" + 
        ":Expected:\t\t\n" +
        "'message'\t\t\n" +
        ":Actual:\t\n" +
        "java.io.IOException\t\n" +
        ":Actual:\t\t\n" +
        "'message2'\t\t\n" + 
        ":Differences:\t\t\t\n" +
        "'2' :1\t\t\t\n"
        ,actualResult);
    
    expected.setMatchType(MatchType.ANY);
    actual.setMessage("message2");
    sb = new StringBuilder();
    display_.addThrownMessages(atf, sb);
    actualResult = sb.toString();
    assertEquals(":Expected:\t\n" + 
        "java.io.IOException\t\n" + 
        ":Expected:\t\t\n" +
        "'message'\t\t\n" +
        ":Actual:\t\n" +
        "java.io.IOException\t\n" +
        ":Actual:\t\t\n" +
        "'message2'\t\t\n" + 
        ":Differences:\t\t\t\n" +
        "'2' :1\t\t\t\n"
        ,actualResult);
  }
  
  /**
   * 
   */
	@Test
	public void testMethodAddDisplayFirstThrowableClassDiff() {
	  AssertThrownFailureMutant atf = new AssertThrownFailureMutant();
	 
	  
	  ThrowableInfoMutant expected = new ThrowableInfoMutant();
	  expected.setClassName(IOException.class.getName());
	  
	  
	  atf.setExpected(expected);
	  
	  StringBuilder sb = new StringBuilder();
	  display_.addThrownMessages(atf, sb);
	  
	  String actualResult = sb.toString();
	  assertEquals("\t:Expected:\n" + 
	      "\tjava.io.IOException\n" + 
	      "\t:Actual:\n" +
	      "\tnull\n", actualResult);
	  
	  ThrowableInfoMutant actual = new ThrowableInfoMutant();
    actual.setClassName(IllegalStateException.class.getName());
    
    atf.setActual(actual);
    
    sb = new StringBuilder();
    display_.addThrownMessages(atf, sb);
    actualResult = sb.toString();
    assertEquals("\t:Expected:\n" + 
        "\tjava.io.IOException\n" + 
        "\t:Actual:\n" +
        "\tjava.lang.IllegalStateException\n", actualResult);
  }

	 @SuppressWarnings("boxing")
  @Test
	 public void testMethodAddDisplayFirstThrowableClassDiffRTL() {
	   when(constantsMock_.isLeftToRight()).thenReturn(false);
	   display_ = new ThrownFailureComparisonDisplay(constantsMock_, logMock_);
	   AssertThrownFailureMutant atf = new AssertThrownFailureMutant();
	   
	    
	    ThrowableInfoMutant expected = new ThrowableInfoMutant();
	    expected.setClassName(IOException.class.getName());
	    
	    
	    atf.setExpected(expected);
	    
	    StringBuilder sb = new StringBuilder();
	    display_.addThrownMessages(atf, sb);
	    
	    String actualResult = sb.toString();
	    assertEquals(":Expected:\t\n" + 
	        "java.io.IOException\t\n" + 
	        ":Actual:\t\n" +
	        "null\t\n", actualResult);
	    
	    ThrowableInfoMutant actual = new ThrowableInfoMutant();
	    actual.setClassName(IllegalStateException.class.getName());
	    
	    atf.setActual(actual);
	    
	    sb = new StringBuilder();
	    display_.addThrownMessages(atf, sb);
	    actualResult = sb.toString();
	    assertEquals(":Expected:\t\n" + 
	        "java.io.IOException\t\n" + 
	        ":Actual:\t\n" +
	        "java.lang.IllegalStateException\t\n", actualResult);
	}
	 
	@Test
	public void testMethodAddDisplayFirstThrowableContainsDiff() {
	  AssertThrownFailureMutant atf = new AssertThrownFailureMutant();
	   
    ThrowableInfoMutant expected = new ThrowableInfoMutant();
    expected.setClassName(IOException.class.getName());
    expected.setMessage("message");
    expected.setMatchType(MatchType.CONTAINS);
    atf.setExpected(expected);
    
    StringBuilder sb = new StringBuilder();
    display_.addThrownMessages(atf, sb);
    
    //class diff
    String actualResult = sb.toString();
    assertEquals("\t:Expected:\n" + 
        "\tjava.io.IOException\n" + 
        "\t:Actual:\n" +
        "\tnull\n", actualResult);
    
    ThrowableInfoMutant actual = new ThrowableInfoMutant();
    actual.setClassName(IOException.class.getName());
    
    atf.setActual(actual);
    
    sb = new StringBuilder();
    display_.addThrownMessages(atf, sb);
    actualResult = sb.toString();
    assertEquals("\t:Expected:\n" + 
        "\tjava.io.IOException\n" + 
        "\t\t:The following text was NOT found in the actual text:\n" + 
        "\t\t'message'\n" +
        "\t:Actual:\n" +
        "\tjava.io.IOException\n" +
        "\t\tnull\n",actualResult);
    
    actual.setMessage("age2");
    sb = new StringBuilder();
    display_.addThrownMessages(atf, sb);
    actualResult = sb.toString();
    assertEquals("\t:Expected:\n" + 
        "\tjava.io.IOException\n" + 
        "\t\t:The following text was NOT found in the actual text:\n" +
        "\t\t'message'\n" +
        "\t:Actual:\n" +
        "\tjava.io.IOException\n" +
        "\t\t'age2'\n" 
        ,actualResult);
    
    
    expected.setMessage("la\nba\nca");
    sb = new StringBuilder();
    display_.addThrownMessages(atf, sb);
    actualResult = sb.toString();
    assertEquals("\t:Expected:\n" + 
        "\tjava.io.IOException\n" + 
        "\t\t:The following text was NOT found in the actual text:\n" +
        "\t\t1: 'la'\n" +
        "\t\t2: 'ba'\n" +
        "\t\t3: 'ca'\n" +
        "\t:Actual:\n" +
        "\tjava.io.IOException\n" +
        "\t\t'age2'\n" 
        ,actualResult);
    
    expected.setMessage("message");
    actual.setMessage("la\nba\nca\n");
    sb = new StringBuilder();
    display_.addThrownMessages(atf, sb);
    actualResult = sb.toString();
    assertEquals("\t:Expected:\n" + 
        "\tjava.io.IOException\n" + 
        "\t\t:The following text was NOT found in the actual text:\n" +
        "\t\t'message'\n" +
        "\t:Actual:\n" +
        "\tjava.io.IOException\n" +
        "\t\t1: 'la'\n" +
        "\t\t2: 'ba'\n" +
        "\t\t3: 'ca'\n" 
        ,actualResult);
	}
	
	@Test
  public void testMethodAddDisplayFirstThrowableContainsDiffRTL() {
	  when(constantsMock_.isLeftToRight()).thenReturn(false);
    display_ = new ThrownFailureComparisonDisplay(constantsMock_, logMock_);
    
	  AssertThrownFailureMutant atf = new AssertThrownFailureMutant();
     
    ThrowableInfoMutant expected = new ThrowableInfoMutant();
    expected.setClassName(IOException.class.getName());
    expected.setMessage("message");
    expected.setMatchType(MatchType.CONTAINS);
    atf.setExpected(expected);
    
    StringBuilder sb = new StringBuilder();
    display_.addThrownMessages(atf, sb);
    
    //class diff
    String actualResult = sb.toString();
    assertEquals(":Expected:\t\n" + 
        "java.io.IOException\t\n" + 
        ":Actual:\t\n" +
        "null\t\n", actualResult);
    
    ThrowableInfoMutant actual = new ThrowableInfoMutant();
    actual.setClassName(IOException.class.getName());
    
    atf.setActual(actual);
    
    sb = new StringBuilder();
    display_.addThrownMessages(atf, sb);
    actualResult = sb.toString();
    assertEquals(":Expected:\t\n" + 
        "java.io.IOException\t\n" + 
        ":The following text was NOT found in the actual text:\t\t\n" + 
        "'message'\t\t\n" +
        ":Actual:\t\n" +
        "java.io.IOException\t\n" +
        "null\t\t\n",actualResult);
    
    actual.setMessage("age2");
    sb = new StringBuilder();
    display_.addThrownMessages(atf, sb);
    actualResult = sb.toString();
    assertEquals(":Expected:\t\n" + 
        "java.io.IOException\t\n" + 
        ":The following text was NOT found in the actual text:\t\t\n" +
        "'message'\t\t\n" +
        ":Actual:\t\n" +
        "java.io.IOException\t\n" +
        "'age2'\t\t\n" 
        ,actualResult);
    
    
    expected.setMessage("la\nba\nca");
    sb = new StringBuilder();
    display_.addThrownMessages(atf, sb);
    actualResult = sb.toString();
    assertEquals(":Expected:\t\n" + 
        "java.io.IOException\t\n" + 
        ":The following text was NOT found in the actual text:\t\t\n" +
        "'la' :1\t\t\n" +
        "'ba' :2\t\t\n" +
        "'ca' :3\t\t\n" +
        ":Actual:\t\n" +
        "java.io.IOException\t\n" +
        "'age2'\t\t\n" 
        ,actualResult);
    
    expected.setMessage("message");
    actual.setMessage("la\nba\nca\n");
    sb = new StringBuilder();
    display_.addThrownMessages(atf, sb);
    actualResult = sb.toString();
    assertEquals(":Expected:\t\n" + 
        "java.io.IOException\t\n" + 
        ":The following text was NOT found in the actual text:\t\t\n" +
        "'message'\t\t\n" +
        ":Actual:\t\n" +
        "java.io.IOException\t\n" +
        "'la' :1\t\t\n" +
        "'ba' :2\t\t\n" +
        "'ca' :3\t\t\n" 
        ,actualResult);
  }
	
	@Test
  public void testMethodAddDisplayFirstThrowableEqualsDiff() {
    AssertThrownFailureMutant atf = new AssertThrownFailureMutant();
   
    ThrowableInfoMutant expected = new ThrowableInfoMutant();
    expected.setClassName(IOException.class.getName());
    expected.setMessage("message");
    expected.setMatchType(MatchType.EQUALS);
    atf.setExpected(expected);
    
    StringBuilder sb = new StringBuilder();
    display_.addThrownMessages(atf, sb);
    
    String actualResult = sb.toString();
    assertEquals("\t:Expected:\n" + 
        "\tjava.io.IOException\n" + 
        "\t:Actual:\n" +
        "\tnull\n", actualResult);
    
    ThrowableInfoMutant actual = new ThrowableInfoMutant();
    actual.setClassName(IOException.class.getName());
    
    atf.setActual(actual);
    
    sb = new StringBuilder();
    display_.addThrownMessages(atf, sb);
    actualResult = sb.toString();
    assertEquals("\t:Expected:\n" + 
        "\tjava.io.IOException\n" + 
        "\t\t'message'\n" +
        "\t:Actual:\n" +
        "\tjava.io.IOException\n" +
        "\t\tnull\n",actualResult);
    
    actual.setMessage("message2");
    sb = new StringBuilder();
    display_.addThrownMessages(atf, sb);
    actualResult = sb.toString();
    assertEquals("\t:Expected:\n" + 
        "\tjava.io.IOException\n" + 
        "\t\t:Expected:\n" +
        "\t\t'message'\n" +
        "\t:Actual:\n" +
        "\tjava.io.IOException\n" +
        "\t\t:Actual:\n" +
        "\t\t'message2'\n" + 
        "\t\t\t:Differences:\n" +
        "\t\t\t1: '2'\n"
        ,actualResult);
    
    
    sb = new StringBuilder();
    display_.addThrownMessages(atf, sb);
    actualResult = sb.toString();
    assertEquals("\t:Expected:\n" + 
        "\tjava.io.IOException\n" + 
        "\t\t:Expected:\n" +
        "\t\t'message'\n" +
        "\t:Actual:\n" +
        "\tjava.io.IOException\n" +
        "\t\t:Actual:\n" +
        "\t\t'message2'\n" + 
        "\t\t\t:Differences:\n" +
        "\t\t\t1: '2'\n"
        ,actualResult);
  }

	@SuppressWarnings("boxing")
  @Test
  public void testMethodAddDisplayFirstThrowableEqualsDiffRTL() {

    when(constantsMock_.isLeftToRight()).thenReturn(false);
    display_ = new ThrownFailureComparisonDisplay(constantsMock_, logMock_);
    AssertThrownFailureMutant atf = new AssertThrownFailureMutant();
   
    
    ThrowableInfoMutant expected = new ThrowableInfoMutant();
    expected.setClassName(IOException.class.getName());
    expected.setMessage("message");
    expected.setMatchType(MatchType.EQUALS);
    atf.setExpected(expected);
    
    StringBuilder sb = new StringBuilder();
    display_.addThrownMessages(atf, sb);
    
    String actualResult = sb.toString();
    assertEquals(":Expected:\t\n" + 
        "java.io.IOException\t\n" + 
        ":Actual:\t\n" +
        "null\t\n", actualResult);
    
    ThrowableInfoMutant actual = new ThrowableInfoMutant();
    actual.setClassName(IOException.class.getName());
    
    atf.setActual(actual);
    
    sb = new StringBuilder();
    display_.addThrownMessages(atf, sb);
    actualResult = sb.toString();
    assertEquals(":Expected:\t\n" + 
        "java.io.IOException\t\n" + 
        "'message'\t\t\n" +
        ":Actual:\t\n" +
        "java.io.IOException\t\n" +
        "null\t\t\n",actualResult);
    
    actual.setMessage("message2");
    sb = new StringBuilder();
    display_.addThrownMessages(atf, sb);
    actualResult = sb.toString();
    assertEquals(":Expected:\t\n" + 
        "java.io.IOException\t\n" + 
        ":Expected:\t\t\n" +
        "'message'\t\t\n" +
        ":Actual:\t\n" +
        "java.io.IOException\t\n" +
        ":Actual:\t\t\n" +
        "'message2'\t\t\n" + 
        ":Differences:\t\t\t\n" +
        "'2' :1\t\t\t\n"
        ,actualResult);
  }
	
	@Test
  public void testMethodAddDisplayFirstThrowableNullMessageDiff() {
    AssertThrownFailureMutant atf = new AssertThrownFailureMutant();
   
    
    ThrowableInfoMutant expected = new ThrowableInfoMutant();
    expected.setClassName(IOException.class.getName());
    expected.setMatchType(MatchType.NULL);
    atf.setExpected(expected);

    ThrowableInfoMutant actual = new ThrowableInfoMutant();
    actual.setClassName(IOException.class.getName());
    actual.setMessage("message");
    atf.setActual(actual);
    
    StringBuilder sb = new StringBuilder();
    display_.addThrownMessages(atf, sb);
    
    String actualResult = sb.toString();
    assertEquals("\t:Expected:\n" + 
        "\tjava.io.IOException\n" + 
        "\t\tnull\n" +
        "\t:Actual:\n" +
        "\tjava.io.IOException\n" + 
        "\t\t'message'\n", actualResult);
    
    
    actual.setMessage("lineA\nlineB\nlineC");
    sb = new StringBuilder();
    display_.addThrownMessages(atf, sb);
    actualResult = sb.toString();
    assertEquals("\t:Expected:\n" + 
        "\tjava.io.IOException\n" + 
        "\t\tnull\n" +
        "\t:Actual:\n" +
        "\tjava.io.IOException\n" +
        "\t\t1: 'lineA'\n" +
        "\t\t2: 'lineB'\n" +
        "\t\t3: 'lineC'\n" 
        ,actualResult);
  }
	
	@SuppressWarnings("boxing")
  @Test
  public void testMethodAddDisplayFirstThrowableNullMessageDiffRTL() {
    when(constantsMock_.isLeftToRight()).thenReturn(false);
    display_ = new ThrownFailureComparisonDisplay(constantsMock_, logMock_);
    
    AssertThrownFailureMutant atf = new AssertThrownFailureMutant();
   
    
    ThrowableInfoMutant expected = new ThrowableInfoMutant();
    expected.setClassName(IOException.class.getName());
    expected.setMatchType(MatchType.NULL);
    atf.setExpected(expected);

    ThrowableInfoMutant actual = new ThrowableInfoMutant();
    actual.setClassName(IOException.class.getName());
    actual.setMessage("message");
    atf.setActual(actual);
    
    StringBuilder sb = new StringBuilder();
    display_.addThrownMessages(atf, sb);
    
    String actualResult = sb.toString();
    assertEquals(":Expected:\t\n" + 
        "java.io.IOException\t\n" + 
        "null\t\t\n" +
        ":Actual:\t\n" +
        "java.io.IOException\t\n" + 
        "'message'\t\t\n", actualResult);
    
    
    actual.setMessage("lineA\nlineB\nlineC");
    sb = new StringBuilder();
    display_.addThrownMessages(atf, sb);
    actualResult = sb.toString();
    assertEquals(":Expected:\t\n" + 
        "java.io.IOException\t\n" + 
        "null\t\t\n" +
        ":Actual:\t\n" +
        "java.io.IOException\t\n" +
        "'lineA' :1\t\t\n" +
        "'lineB' :2\t\t\n" +
        "'lineC' :3\t\t\n" 
        ,actualResult);
	}
	 
	
	@Test
  public void testMethodAddDisplaySecondThrowableAnyAndNullMatchTypeDiff() {
    AssertThrownFailureMutant atf = new AssertThrownFailureMutant();
   
    ThrowableInfoMutant expected = new ThrowableInfoMutant();
    expected.setClassName(IOException.class.getName());
    expected.setMessage("message");
    
    ThrowableInfoMutant expected2 = new ThrowableInfoMutant();
    expected2.setClassName(IllegalArgumentException.class.getName());
    expected2.setMessage("message");
    expected.setCause(expected2);
    atf.setExpected(expected);
    
    StringBuilder sb = new StringBuilder();
    display_.addThrownMessages(atf, sb);
    
    //null match type, class mismatch
    String actualResult = sb.toString();
    assertEquals("\t:Expected:\n" + 
        "\tjava.io.IOException\n" + 
        "\t:Actual:\n" +
        "\tnull\n", actualResult);
    
    expected.setMatchType(MatchType.ANY);
    sb = new StringBuilder();
    display_.addThrownMessages(atf, sb);
    actualResult = sb.toString();
    assertEquals("\t:Expected:\n" + 
        "\tjava.io.IOException\n" + 
        "\t:Actual:\n" +
        "\tnull\n", actualResult);
    
    expected.setMatchType(null);
    ThrowableInfoMutant actual = new ThrowableInfoMutant();
    actual.setClassName(IOException.class.getName());
    
    atf.setActual(actual);
    atf.setThrowable(2);
    
    sb = new StringBuilder();
    display_.addThrownMessages(atf, sb);
    actualResult = sb.toString();
    assertEquals("\t:Expected:\n" + 
        "\tjava.io.IOException\n" + 
        "\t\tjava.lang.IllegalArgumentException\n" + 
        "\t:Actual:\n" +
        "\tjava.io.IOException\n" +
        "\t\tnull\n",actualResult);
    
    expected.setMatchType(MatchType.ANY);
    sb = new StringBuilder();
    display_.addThrownMessages(atf, sb);
    actualResult = sb.toString();
    assertEquals("\t:Expected:\n" + 
        "\tjava.io.IOException\n" + 
        "\t\tjava.lang.IllegalArgumentException\n" + 
        "\t:Actual:\n" +
        "\tjava.io.IOException\n" +
        "\t\tnull\n",actualResult);
    
    ThrowableInfoMutant actual2 = new ThrowableInfoMutant();
    actual2.setClassName(IllegalArgumentException.class.getName());
    actual2.setMessage("mes2sage");
    actual.setCause(actual2);
    
    expected.setMatchType(null);
    actual.setMessage("message2");
    sb = new StringBuilder();
    display_.addThrownMessages(atf, sb);
    actualResult = sb.toString();
    assertEquals("\t:Expected:\n" + 
        "\tjava.io.IOException\n" + 
        "\t\tjava.lang.IllegalArgumentException\n" + 
        "\t\t\t:Expected:\n" +
        "\t\t\t'message'\n" +
        "\t:Actual:\n" +
        "\tjava.io.IOException\n" +
        "\t\tjava.lang.IllegalArgumentException\n" + 
        "\t\t\t:Actual:\n" +
        "\t\t\t'mes2sage'\n" + 
        "\t\t\t\t:Differences:\n" +
        "\t\t\t\t1: '2'\n"
        ,actualResult);
    
    expected.setMatchType(MatchType.ANY);
    actual.setMessage("message2");
    sb = new StringBuilder();
    display_.addThrownMessages(atf, sb);
    actualResult = sb.toString();
    assertEquals("\t:Expected:\n" + 
        "\tjava.io.IOException\n" + 
        "\t\tjava.lang.IllegalArgumentException\n" + 
        "\t\t\t:Expected:\n" +
        "\t\t\t'message'\n" +
        "\t:Actual:\n" +
        "\tjava.io.IOException\n" +
        "\t\tjava.lang.IllegalArgumentException\n" + 
        "\t\t\t:Actual:\n" +
        "\t\t\t'mes2sage'\n" + 
        "\t\t\t\t:Differences:\n" +
        "\t\t\t\t1: '2'\n"
        ,actualResult);
    
    
    sb = new StringBuilder();
    display_.addThrownMessages(atf, sb);
    actualResult = sb.toString();
    assertEquals("\t:Expected:\n" + 
        "\tjava.io.IOException\n" + 
        "\t\tjava.lang.IllegalArgumentException\n" + 
        "\t\t\t:Expected:\n" +
        "\t\t\t'message'\n" +
        "\t:Actual:\n" +
        "\tjava.io.IOException\n" +
        "\t\tjava.lang.IllegalArgumentException\n" + 
        "\t\t\t:Actual:\n" +
        "\t\t\t'mes2sage'\n" + 
        "\t\t\t\t:Differences:\n" +
        "\t\t\t\t1: '2'\n"
        ,actualResult);
  }

  @SuppressWarnings("boxing")
  @Test
  public void testMethodAddDisplaySecondThrowableAnyAndNullMatchTypeRTL() {

    when(constantsMock_.isLeftToRight()).thenReturn(false);
    display_ = new ThrownFailureComparisonDisplay(constantsMock_, logMock_);
    AssertThrownFailureMutant atf = new AssertThrownFailureMutant();
    atf.setThrowable(2);
    
    ThrowableInfoMutant expected = new ThrowableInfoMutant();
    expected.setClassName(IOException.class.getName());
    expected.setMessage("message");
    atf.setExpected(expected);
    
    ThrowableInfoMutant expected2 = new ThrowableInfoMutant();
    expected2.setClassName(IllegalArgumentException.class.getName());
    expected2.setMessage("message");
    expected.setCause(expected2);
    
    StringBuilder sb = new StringBuilder();
    display_.addThrownMessages(atf, sb);
    
    //null match type
    String actualResult = sb.toString();
    assertEquals(":Expected:\t\n" + 
        "java.io.IOException\t\n" + 
        ":Actual:\t\n" +
        "null\t\n", actualResult);
    
    expected.setMatchType(MatchType.ANY);
    sb = new StringBuilder();
    display_.addThrownMessages(atf, sb);
    actualResult = sb.toString();
    assertEquals(":Expected:\t\n" + 
        "java.io.IOException\t\n" + 
        ":Actual:\t\n" +
        "null\t\n", actualResult);
    
    ThrowableInfoMutant actual = new ThrowableInfoMutant();
    actual.setClassName(IOException.class.getName());
    
    atf.setActual(actual);
    
    expected.setMatchType(null);
    sb = new StringBuilder();
    display_.addThrownMessages(atf, sb);
    actualResult = sb.toString();
    assertEquals(":Expected:\t\n" + 
        "java.io.IOException\t\n" + 
        "java.lang.IllegalArgumentException\t\t\n" +
        ":Actual:\t\n" +
        "java.io.IOException\t\n" +
        "null\t\t\n",actualResult);
    
    expected.setMatchType(MatchType.ANY);
    sb = new StringBuilder();
    display_.addThrownMessages(atf, sb);
    actualResult = sb.toString();
    assertEquals(":Expected:\t\n" + 
        "java.io.IOException\t\n" + 
        "java.lang.IllegalArgumentException\t\t\n" +
        ":Actual:\t\n" +
        "java.io.IOException\t\n" +
        "null\t\t\n",actualResult);
    
    ThrowableInfoMutant actual2 = new ThrowableInfoMutant();
    actual2.setClassName(IllegalArgumentException.class.getName());
    actual2.setMessage("mes2sage");
    actual.setCause(actual2);
    
    expected.setMatchType(null);
    actual.setMessage("message2");
    sb = new StringBuilder();
    display_.addThrownMessages(atf, sb);
    actualResult = sb.toString();
    assertEquals(":Expected:\t\n" + 
        "java.io.IOException\t\n" + 
        "java.lang.IllegalArgumentException\t\t\n" +
        ":Expected:\t\t\t\n" +
        "'message'\t\t\t\n" +
        ":Actual:\t\n" +
        "java.io.IOException\t\n" +
        "java.lang.IllegalArgumentException\t\t\n" +
        ":Actual:\t\t\t\n" +
        "'mes2sage'\t\t\t\n" + 
        ":Differences:\t\t\t\t\n" +
        "'2' :1\t\t\t\t\n"
        ,actualResult);
    

    
    expected.setMatchType(MatchType.ANY);
    sb = new StringBuilder();
    display_.addThrownMessages(atf, sb);
    actualResult = sb.toString();
    assertEquals(":Expected:\t\n" + 
        "java.io.IOException\t\n" + 
        "java.lang.IllegalArgumentException\t\t\n" +
        ":Expected:\t\t\t\n" +
        "'message'\t\t\t\n" +
        ":Actual:\t\n" +
        "java.io.IOException\t\n" +
        "java.lang.IllegalArgumentException\t\t\n" +
        ":Actual:\t\t\t\n" +
        "'mes2sage'\t\t\t\n" + 
        ":Differences:\t\t\t\t\n" +
        "'2' :1\t\t\t\t\n"
        ,actualResult);
  }
  
	@Test
  public void testMethodAddDisplaySecondThrowableClassDiff() {
	  AssertThrownFailureMutant atf = new AssertThrownFailureMutant();
	   
    ThrowableInfoMutant expected = new ThrowableInfoMutant();
    expected.setClassName(IOException.class.getName());
    expected.setMessage("message");
    
    ThrowableInfoMutant expected2 = new ThrowableInfoMutant();
    expected2.setClassName(IllegalArgumentException.class.getName());
    expected2.setMessage("message");
    expected.setCause(expected2);
    atf.setExpected(expected);
    
    StringBuilder sb = new StringBuilder();
    display_.addThrownMessages(atf, sb);
    
    String actualResult = sb.toString();
    assertEquals("\t:Expected:\n" + 
        "\tjava.io.IOException\n" + 
        "\t:Actual:\n" +
        "\tnull\n", actualResult);
    
    expected.setMatchType(null);
    ThrowableInfoMutant actual = new ThrowableInfoMutant();
    actual.setClassName(IOException.class.getName());
    
    atf.setActual(actual);
    atf.setThrowable(2);
    
    sb = new StringBuilder();
    display_.addThrownMessages(atf, sb);
    actualResult = sb.toString();
    assertEquals("\t:Expected:\n" + 
        "\tjava.io.IOException\n" + 
        "\t\tjava.lang.IllegalArgumentException\n" + 
        "\t:Actual:\n" +
        "\tjava.io.IOException\n" +
        "\t\tnull\n",actualResult);
    
    ThrowableInfoMutant actual2 = new ThrowableInfoMutant();
    actual2.setClassName(IllegalStateException.class.getName());
    actual2.setMessage("mes2sage");
    actual.setCause(actual2);
    
    expected.setMatchType(null);
    actual.setMessage("message2");
    sb = new StringBuilder();
    display_.addThrownMessages(atf, sb);
    actualResult = sb.toString();
    assertEquals("\t:Expected:\n" + 
        "\tjava.io.IOException\n" + 
        "\t\tjava.lang.IllegalArgumentException\n" + 
        "\t:Actual:\n" +
        "\tjava.io.IOException\n" +
        "\t\tjava.lang.IllegalStateException\n" 
        ,actualResult);
    
  }
	
	@SuppressWarnings("boxing")
  @Test
  public void testMethodAddDisplaySecondThrowableClassDiffRTL() {
    when(constantsMock_.isLeftToRight()).thenReturn(false);
    display_ = new ThrownFailureComparisonDisplay(constantsMock_, logMock_);
    AssertThrownFailureMutant atf = new AssertThrownFailureMutant();
    atf.setThrowable(2);
    
    ThrowableInfoMutant expected = new ThrowableInfoMutant();
    expected.setClassName(IOException.class.getName());
    expected.setMessage("message");
    atf.setExpected(expected);
    
    ThrowableInfoMutant expected2 = new ThrowableInfoMutant();
    expected2.setClassName(IllegalArgumentException.class.getName());
    expected2.setMessage("message");
    expected.setCause(expected2);
    
    StringBuilder sb = new StringBuilder();
    display_.addThrownMessages(atf, sb);
    
    String actualResult = sb.toString();
    assertEquals(":Expected:\t\n" + 
        "java.io.IOException\t\n" + 
        ":Actual:\t\n" +
        "null\t\n", actualResult);
    
    ThrowableInfoMutant actual = new ThrowableInfoMutant();
    actual.setClassName(IOException.class.getName());
    
    atf.setActual(actual);
    
    expected.setMatchType(null);
    sb = new StringBuilder();
    display_.addThrownMessages(atf, sb);
    actualResult = sb.toString();
    assertEquals(":Expected:\t\n" + 
        "java.io.IOException\t\n" + 
        "java.lang.IllegalArgumentException\t\t\n" +
        ":Actual:\t\n" +
        "java.io.IOException\t\n" +
        "null\t\t\n",actualResult);
    
    ThrowableInfoMutant actual2 = new ThrowableInfoMutant();
    actual2.setClassName(IllegalStateException.class.getName());
    actual.setCause(actual2);
    
    expected.setMatchType(null);
    actual.setMessage("message2");
    sb = new StringBuilder();
    display_.addThrownMessages(atf, sb);
    actualResult = sb.toString();
    assertEquals(":Expected:\t\n" + 
        "java.io.IOException\t\n" + 
        "java.lang.IllegalArgumentException\t\t\n" +
        ":Actual:\t\n" +
        "java.io.IOException\t\n" +
        "java.lang.IllegalStateException\t\t\n" 
        ,actualResult);
  }
	
	@Test
  public void testMethodAddDisplaySecondThrowableContainsDiff() {
    AssertThrownFailureMutant atf = new AssertThrownFailureMutant();
    atf.setThrowable(2);
    
    ThrowableInfoMutant expected = new ThrowableInfoMutant();
    expected.setClassName(IOException.class.getName());
    expected.setMessage("message");
    
    ThrowableInfoMutant expected2 = new ThrowableInfoMutant();
    expected2.setClassName(IllegalArgumentException.class.getName());
    expected2.setMessage("message");
    expected2.setMatchType(MatchType.CONTAINS);
    expected.setCause(expected2);
    
    atf.setExpected(expected);
    
    StringBuilder sb = new StringBuilder();
    display_.addThrownMessages(atf, sb);
    
    //null match type, class mismatch
    String actualResult = sb.toString();
    assertEquals("\t:Expected:\n" + 
        "\tjava.io.IOException\n" + 
        "\t:Actual:\n" +
        "\tnull\n", actualResult);
  
    ThrowableInfoMutant actual = new ThrowableInfoMutant();
    actual.setClassName(IOException.class.getName());
    
    ThrowableInfoMutant actual2 = new ThrowableInfoMutant();
    actual2.setClassName(IllegalArgumentException.class.getName());
    
    actual.setCause(actual2);
    
    atf.setActual(actual);
    
    sb = new StringBuilder();
    display_.addThrownMessages(atf, sb);
    actualResult = sb.toString();
    assertEquals("\t:Expected:\n" + 
        "\tjava.io.IOException\n" + 
        "\t\tjava.lang.IllegalArgumentException\n" + 
        "\t\t\t:The following text was NOT found in the actual text:\n" + 
        "\t\t\t'message'\n" + 
        "\t:Actual:\n" +
        "\tjava.io.IOException\n" +
        "\t\tjava.lang.IllegalArgumentException\n" + 
        "\t\t\tnull\n",actualResult);
    
    
    actual2.setMessage("2m2");
    sb = new StringBuilder();
    display_.addThrownMessages(atf, sb);
    actualResult = sb.toString();
    assertEquals("\t:Expected:\n" + 
        "\tjava.io.IOException\n" + 
        "\t\tjava.lang.IllegalArgumentException\n" + 
        "\t\t\t:The following text was NOT found in the actual text:\n" + 
        "\t\t\t'message'\n" + 
        "\t:Actual:\n" +
        "\tjava.io.IOException\n" +
        "\t\tjava.lang.IllegalArgumentException\n" + 
        "\t\t\t'2m2'\n",actualResult);
    
    expected2.setMessage(null);
    sb = new StringBuilder();
    display_.addThrownMessages(atf, sb);
    actualResult = sb.toString();
    assertEquals("\t:Expected:\n" + 
        "\tjava.io.IOException\n" + 
        "\t\tjava.lang.IllegalArgumentException\n" + 
        "\t\t\t:The following text was NOT found in the actual text:\n" + 
        "\t\t\tnull\n" + 
        "\t:Actual:\n" +
        "\tjava.io.IOException\n" +
        "\t\tjava.lang.IllegalArgumentException\n" + 
        "\t\t\t'2m2'\n",actualResult);
    
    expected2.setMessage("ac\nbc\ndf");
    sb = new StringBuilder();
    display_.addThrownMessages(atf, sb);
    actualResult = sb.toString();
    assertEquals("\t:Expected:\n" + 
        "\tjava.io.IOException\n" + 
        "\t\tjava.lang.IllegalArgumentException\n" + 
        "\t\t\t:The following text was NOT found in the actual text:\n" + 
        "\t\t\t1: 'ac'\n" + 
        "\t\t\t2: 'bc'\n" + 
        "\t\t\t3: 'df'\n" + 
        "\t:Actual:\n" +
        "\tjava.io.IOException\n" +
        "\t\tjava.lang.IllegalArgumentException\n" + 
        "\t\t\t'2m2'\n",actualResult);
    
    actual2.setMessage("a\nb\nc");
    sb = new StringBuilder();
    display_.addThrownMessages(atf, sb);
    actualResult = sb.toString();
    assertEquals("\t:Expected:\n" + 
        "\tjava.io.IOException\n" + 
        "\t\tjava.lang.IllegalArgumentException\n" + 
        "\t\t\t:The following text was NOT found in the actual text:\n" + 
        "\t\t\t1: 'ac'\n" + 
        "\t\t\t2: 'bc'\n" + 
        "\t\t\t3: 'df'\n" + 
        "\t:Actual:\n" +
        "\tjava.io.IOException\n" +
        "\t\tjava.lang.IllegalArgumentException\n" + 
        "\t\t\t1: 'a'\n" + 
        "\t\t\t2: 'b'\n" + 
        "\t\t\t3: 'c'\n",actualResult);
  }
  
  @SuppressWarnings("boxing")
  @Test
  public void testMethodAddDisplaySecondThrowableContainsDiffRTL() {
    when(constantsMock_.isLeftToRight()).thenReturn(false);
    display_ = new ThrownFailureComparisonDisplay(constantsMock_, logMock_);
    AssertThrownFailureMutant atf = new AssertThrownFailureMutant();
    atf.setThrowable(2);
    
    ThrowableInfoMutant expected = new ThrowableInfoMutant();
    expected.setClassName(IOException.class.getName());
    expected.setMessage("message");
    
    ThrowableInfoMutant expected2 = new ThrowableInfoMutant();
    expected2.setClassName(IllegalArgumentException.class.getName());
    expected2.setMessage("message");
    expected2.setMatchType(MatchType.CONTAINS);
    expected.setCause(expected2);
    
    atf.setExpected(expected);
    
    StringBuilder sb = new StringBuilder();
    display_.addThrownMessages(atf, sb);
    
    //null match type, class mismatch
    String actualResult = sb.toString();
    assertEquals(":Expected:\t\n" + 
        "java.io.IOException\t\n" + 
        ":Actual:\t\n" +
        "null\t\n", actualResult);
  
    ThrowableInfoMutant actual = new ThrowableInfoMutant();
    actual.setClassName(IOException.class.getName());
    
    ThrowableInfoMutant actual2 = new ThrowableInfoMutant();
    actual2.setClassName(IllegalArgumentException.class.getName());
    
    actual.setCause(actual2);
    
    atf.setActual(actual);
    
    sb = new StringBuilder();
    display_.addThrownMessages(atf, sb);
    actualResult = sb.toString();
    assertEquals(":Expected:\t\n" + 
        "java.io.IOException\t\n" + 
        "java.lang.IllegalArgumentException\t\t\n" + 
        ":The following text was NOT found in the actual text:\t\t\t\n" + 
        "'message'\t\t\t\n" + 
        ":Actual:\t\n" +
        "java.io.IOException\t\n" +
        "java.lang.IllegalArgumentException\t\t\n" + 
        "null\t\t\t\n",actualResult);
    
    
    actual2.setMessage("2m2");
    sb = new StringBuilder();
    display_.addThrownMessages(atf, sb);
    actualResult = sb.toString();
    assertEquals(":Expected:\t\n" + 
        "java.io.IOException\t\n" + 
        "java.lang.IllegalArgumentException\t\t\n" + 
        ":The following text was NOT found in the actual text:\t\t\t\n" + 
        "'message'\t\t\t\n" + 
        ":Actual:\t\n" +
        "java.io.IOException\t\n" +
        "java.lang.IllegalArgumentException\t\t\n" + 
        "'2m2'\t\t\t\n",actualResult);
    
    expected2.setMessage(null);
    sb = new StringBuilder();
    display_.addThrownMessages(atf, sb);
    actualResult = sb.toString();
    assertEquals(":Expected:\t\n" + 
        "java.io.IOException\t\n" + 
        "java.lang.IllegalArgumentException\t\t\n" + 
        ":The following text was NOT found in the actual text:\t\t\t\n" + 
        "null\t\t\t\n" + 
        ":Actual:\t\n" +
        "java.io.IOException\t\n" +
        "java.lang.IllegalArgumentException\t\t\n" + 
        "'2m2'\t\t\t\n",actualResult);
    
    expected2.setMessage("ac\nbc\ndf");
    sb = new StringBuilder();
    display_.addThrownMessages(atf, sb);
    actualResult = sb.toString();
    assertEquals(":Expected:\t\n" + 
        "java.io.IOException\t\n" + 
        "java.lang.IllegalArgumentException\t\t\n" + 
        ":The following text was NOT found in the actual text:\t\t\t\n" + 
        "'ac' :1\t\t\t\n" + 
        "'bc' :2\t\t\t\n" + 
        "'df' :3\t\t\t\n" + 
        ":Actual:\t\n" +
        "java.io.IOException\t\n" +
        "java.lang.IllegalArgumentException\t\t\n" + 
        "'2m2'\t\t\t\n",actualResult);
    
    actual2.setMessage("a\nb\nc");
    sb = new StringBuilder();
    display_.addThrownMessages(atf, sb);
    actualResult = sb.toString();
    assertEquals(":Expected:\t\n" + 
        "java.io.IOException\t\n" + 
        "java.lang.IllegalArgumentException\t\t\n" + 
        ":The following text was NOT found in the actual text:\t\t\t\n" + 
        "'ac' :1\t\t\t\n" + 
        "'bc' :2\t\t\t\n" + 
        "'df' :3\t\t\t\n" + 
        ":Actual:\t\n" +
        "java.io.IOException\t\n" +
        "java.lang.IllegalArgumentException\t\t\n" + 
        "'a' :1\t\t\t\n" + 
        "'b' :2\t\t\t\n" + 
        "'c' :3\t\t\t\n",actualResult);
  }
  
  @Test
  public void testMethodAddDisplaySecondThrowableEqualsDiff() {
    AssertThrownFailureMutant atf = new AssertThrownFailureMutant();
    atf.setThrowable(2);
    
    ThrowableInfoMutant expected = new ThrowableInfoMutant();
    expected.setClassName(IOException.class.getName());
    expected.setMessage("message");
    
    ThrowableInfoMutant expected2 = new ThrowableInfoMutant();
    expected2.setClassName(IllegalArgumentException.class.getName());
    expected2.setMessage("message");
    expected2.setMatchType(MatchType.EQUALS);
    expected.setCause(expected2);
    
    atf.setExpected(expected);
    
    StringBuilder sb = new StringBuilder();
    display_.addThrownMessages(atf, sb);
    
    //null match type, class mismatch
    String actualResult = sb.toString();
    assertEquals("\t:Expected:\n" + 
        "\tjava.io.IOException\n" + 
        "\t:Actual:\n" +
        "\tnull\n", actualResult);
  
    ThrowableInfoMutant actual = new ThrowableInfoMutant();
    actual.setClassName(IOException.class.getName());
    
    ThrowableInfoMutant actual2 = new ThrowableInfoMutant();
    actual2.setClassName(IllegalArgumentException.class.getName());
    
    actual.setCause(actual2);
    
    atf.setActual(actual);
    
    sb = new StringBuilder();
    display_.addThrownMessages(atf, sb);
    actualResult = sb.toString();
    assertEquals("\t:Expected:\n" + 
        "\tjava.io.IOException\n" + 
        "\t\tjava.lang.IllegalArgumentException\n" + 
        "\t\t\t'message'\n" + 
        "\t:Actual:\n" +
        "\tjava.io.IOException\n" +
        "\t\tjava.lang.IllegalArgumentException\n" + 
        "\t\t\tnull\n",actualResult);
    
    
    actual2.setMessage("2m2");
    sb = new StringBuilder();
    display_.addThrownMessages(atf, sb);
    actualResult = sb.toString();
    assertEquals("\t:Expected:\n" + 
        "\tjava.io.IOException\n" + 
        "\t\tjava.lang.IllegalArgumentException\n" + 
        "\t\t\t:Expected:\n" + 
        "\t\t\t'message'\n" + 
        "\t\t\t\t:Differences:\n" +
        "\t\t\t\t1: 'essage'\n" +
        "\t:Actual:\n" +
        "\tjava.io.IOException\n" +
        "\t\tjava.lang.IllegalArgumentException\n" + 
        "\t\t\t:Actual:\n" +
        "\t\t\t'2m2'\n" +
        "\t\t\t\t:Differences:\n" +
        "\t\t\t\t1: '2'*'2'\n",actualResult);
    
    expected2.setMessage(null);
    sb = new StringBuilder();
    display_.addThrownMessages(atf, sb);
    actualResult = sb.toString();
    assertEquals("\t:Expected:\n" + 
        "\tjava.io.IOException\n" + 
        "\t\tjava.lang.IllegalArgumentException\n" +
        "\t\t\tnull\n" + 
        "\t:Actual:\n" +
        "\tjava.io.IOException\n" +
        "\t\tjava.lang.IllegalArgumentException\n" + 
        "\t\t\t'2m2'\n",actualResult);
    
    expected2.setMessage("ac\nbc\ndf\nei\njk");
    sb = new StringBuilder();
    display_.addThrownMessages(atf, sb);
    actualResult = sb.toString();
    assertEquals("\t:Expected:\n" + 
        "\tjava.io.IOException\n" + 
        "\t\tjava.lang.IllegalArgumentException\n" + 
        "\t\t\t:Expected:\n" + 
        "\t\t\t1: 'ac'\n" + 
        "\t\t\t2: 'bc'\n" + 
        "\t\t\t3: 'df'\n" + 
        "\t\t\t4: 'ei'\n" + 
        "\t\t\t5: 'jk'\n" + 
        "\t\t\t:The following EXPECTED lines were missing:\n" +
        "\t\t\t\t1: 'ac'\n" + 
        "\t\t\t\t2: 'bc'\n" + 
        "\t\t\t\t3: 'df'\n" + 
        "\t:Actual:\n" +
        "\tjava.io.IOException\n" +
        "\t\tjava.lang.IllegalArgumentException\n" + 
        "\t\t\t:Actual:\n" +
        "\t\t\t'2m2'\n",actualResult);
    
    actual2.setMessage("a\nb\nc");
    sb = new StringBuilder();
    display_.addThrownMessages(atf, sb);
    actualResult = sb.toString();
    assertEquals("\t:Expected:\n" + 
        "\tjava.io.IOException\n" + 
        "\t\tjava.lang.IllegalArgumentException\n" + 
        "\t\t\t:Expected:\n" +
        "\t\t\t1: 'ac'\n" + 
        "\t\t\t2: 'bc'\n" + 
        "\t\t\t3: 'df'\n" + 
        "\t\t\t4: 'ei'\n" + 
        "\t\t\t5: 'jk'\n" + 
        "\t\t\t:The following EXPECTED lines were missing:\n" +
        "\t\t\t\t3: 'df'\n" + 
        "\t\t\t\t4: 'ei'\n" + 
        "\t\t\t\t5: 'jk'\n" + 
        "\t:Actual:\n" +
        "\tjava.io.IOException\n" +
        "\t\tjava.lang.IllegalArgumentException\n" + 
        "\t\t\t:Actual:\n" +
        "\t\t\t1: 'a'\n" + 
        "\t\t\t2: 'b'\n" + 
        "\t\t\t3: 'c'\n",actualResult);
  }

  @SuppressWarnings("boxing")
  @Test
  public void testMethodAddDisplaySecondThrowableEqualsDiffRTL() {
    when(constantsMock_.isLeftToRight()).thenReturn(false);
    display_ = new ThrownFailureComparisonDisplay(constantsMock_, logMock_);
    
    AssertThrownFailureMutant atf = new AssertThrownFailureMutant();
    atf.setThrowable(2);
    
    ThrowableInfoMutant expected = new ThrowableInfoMutant();
    expected.setClassName(IOException.class.getName());
    expected.setMessage("message");
    
    ThrowableInfoMutant expected2 = new ThrowableInfoMutant();
    expected2.setClassName(IllegalArgumentException.class.getName());
    expected2.setMessage("message");
    expected2.setMatchType(MatchType.EQUALS);
    expected.setCause(expected2);
    
    atf.setExpected(expected);
    
    StringBuilder sb = new StringBuilder();
    display_.addThrownMessages(atf, sb);
    
    //null match type, class mismatch
    String actualResult = sb.toString();
    assertEquals(":Expected:\t\n" + 
        "java.io.IOException\t\n" + 
        ":Actual:\t\n" +
        "null\t\n", actualResult);
  
    ThrowableInfoMutant actual = new ThrowableInfoMutant();
    actual.setClassName(IOException.class.getName());
    
    ThrowableInfoMutant actual2 = new ThrowableInfoMutant();
    actual2.setClassName(IllegalArgumentException.class.getName());
    
    actual.setCause(actual2);
    
    atf.setActual(actual);
    
    sb = new StringBuilder();
    display_.addThrownMessages(atf, sb);
    actualResult = sb.toString();
    assertEquals(":Expected:\t\n" + 
        "java.io.IOException\t\n" + 
        "java.lang.IllegalArgumentException\t\t\n" + 
        "'message'\t\t\t\n" + 
        ":Actual:\t\n" +
        "java.io.IOException\t\n" +
        "java.lang.IllegalArgumentException\t\t\n" + 
        "null\t\t\t\n",actualResult);
    
    
    actual2.setMessage("2m2");
    sb = new StringBuilder();
    display_.addThrownMessages(atf, sb);
    actualResult = sb.toString();
    assertEquals(":Expected:\t\n" + 
        "java.io.IOException\t\n" + 
        "java.lang.IllegalArgumentException\t\t\n" + 
        ":Expected:\t\t\t\n" + 
        "'message'\t\t\t\n" + 
        ":Differences:\t\t\t\t\n" +
        "'essage' :1\t\t\t\t\n" +
        ":Actual:\t\n" +
        "java.io.IOException\t\n" +
        "java.lang.IllegalArgumentException\t\t\n" + 
        ":Actual:\t\t\t\n" +
        "'2m2'\t\t\t\n" +
        ":Differences:\t\t\t\t\n" +
        "'2'*'2' :1\t\t\t\t\n",actualResult);
    
    expected2.setMessage(null);
    sb = new StringBuilder();
    display_.addThrownMessages(atf, sb);
    actualResult = sb.toString();
    assertEquals(":Expected:\t\n" + 
        "java.io.IOException\t\n" + 
        "java.lang.IllegalArgumentException\t\t\n" +
        "null\t\t\t\n" + 
        ":Actual:\t\n" +
        "java.io.IOException\t\n" +
        "java.lang.IllegalArgumentException\t\t\n" + 
        "'2m2'\t\t\t\n",actualResult);
    
    expected2.setMessage("ac\nbc\ndf\nei\njk");
    sb = new StringBuilder();
    display_.addThrownMessages(atf, sb);
    actualResult = sb.toString();
    assertEquals(":Expected:\t\n" + 
        "java.io.IOException\t\n" + 
        "java.lang.IllegalArgumentException\t\t\n" + 
        ":Expected:\t\t\t\n" + 
        "'ac' :1\t\t\t\n" + 
        "'bc' :2\t\t\t\n" + 
        "'df' :3\t\t\t\n" + 
        "'ei' :4\t\t\t\n" + 
        "'jk' :5\t\t\t\n" + 
        ":The following EXPECTED lines were missing:\t\t\t\n" +
        "'ac' :1\t\t\t\t\n" + 
        "'bc' :2\t\t\t\t\n" + 
        "'df' :3\t\t\t\t\n" + 
        ":Actual:\t\n" +
        "java.io.IOException\t\n" +
        "java.lang.IllegalArgumentException\t\t\n" + 
        ":Actual:\t\t\t\n" +
        "'2m2'\t\t\t\n",actualResult);
    
    actual2.setMessage("a\nb\nc");
    sb = new StringBuilder();
    display_.addThrownMessages(atf, sb);
    actualResult = sb.toString();
    assertEquals(":Expected:\t\n" + 
        "java.io.IOException\t\n" + 
        "java.lang.IllegalArgumentException\t\t\n" + 
        ":Expected:\t\t\t\n" +
        "'ac' :1\t\t\t\n" + 
        "'bc' :2\t\t\t\n" + 
        "'df' :3\t\t\t\n" + 
        "'ei' :4\t\t\t\n" + 
        "'jk' :5\t\t\t\n" + 
        ":The following EXPECTED lines were missing:\t\t\t\n" +
        "'df' :3\t\t\t\t\n" + 
        "'ei' :4\t\t\t\t\n" + 
        "'jk' :5\t\t\t\t\n" + 
        ":Actual:\t\n" +
        "java.io.IOException\t\n" +
        "java.lang.IllegalArgumentException\t\t\n" + 
        ":Actual:\t\t\t\n" +
        "'a' :1\t\t\t\n" + 
        "'b' :2\t\t\t\n" + 
        "'c' :3\t\t\t\n",actualResult);
  }
  
  @Test
  public void testMethodAddDisplaySecondThrowableNullDiff() {
    AssertThrownFailureMutant atf = new AssertThrownFailureMutant();
    atf.setThrowable(2);
    
    ThrowableInfoMutant expected = new ThrowableInfoMutant();
    expected.setClassName(IOException.class.getName());
    expected.setMessage("message");
    
    ThrowableInfoMutant expected2 = new ThrowableInfoMutant();
    expected2.setClassName(IllegalArgumentException.class.getName());
    expected2.setMessage("message");
    expected2.setMatchType(MatchType.NULL);
    expected.setCause(expected2);
    
    atf.setExpected(expected);
    
    StringBuilder sb = new StringBuilder();
    display_.addThrownMessages(atf, sb);
    
    //null match type, class mismatch
    String actualResult = sb.toString();
    assertEquals("\t:Expected:\n" + 
        "\tjava.io.IOException\n" + 
        "\t:Actual:\n" +
        "\tnull\n", actualResult);
  
    ThrowableInfoMutant actual = new ThrowableInfoMutant();
    actual.setClassName(IOException.class.getName());
    
    ThrowableInfoMutant actual2 = new ThrowableInfoMutant();
    actual2.setClassName(IllegalArgumentException.class.getName());
    
    actual.setCause(actual2);
    
    atf.setActual(actual);
    
    sb = new StringBuilder();
    display_.addThrownMessages(atf, sb);
    actualResult = sb.toString();
    assertEquals("\t:Expected:\n" + 
        "\tjava.io.IOException\n" + 
        "\t\tjava.lang.IllegalArgumentException\n" + 
        "\t\t\tnull\n" + 
        "\t:Actual:\n" +
        "\tjava.io.IOException\n" +
        "\t\tjava.lang.IllegalArgumentException\n" + 
        "\t\t\tnull\n",actualResult);
    
    
    actual2.setMessage("2m2");
    sb = new StringBuilder();
    display_.addThrownMessages(atf, sb);
    actualResult = sb.toString();
    assertEquals("\t:Expected:\n" + 
        "\tjava.io.IOException\n" + 
        "\t\tjava.lang.IllegalArgumentException\n" + 
        "\t\t\tnull\n" + 
        "\t:Actual:\n" +
        "\tjava.io.IOException\n" +
        "\t\tjava.lang.IllegalArgumentException\n" + 
        "\t\t\t'2m2'\n" ,actualResult);
    
    expected2.setMessage(null);
    sb = new StringBuilder();
    display_.addThrownMessages(atf, sb);
    actualResult = sb.toString();
    assertEquals("\t:Expected:\n" + 
        "\tjava.io.IOException\n" + 
        "\t\tjava.lang.IllegalArgumentException\n" +
        "\t\t\tnull\n" + 
        "\t:Actual:\n" +
        "\tjava.io.IOException\n" +
        "\t\tjava.lang.IllegalArgumentException\n" + 
        "\t\t\t'2m2'\n",actualResult);
    
    expected2.setMessage("ac\nbc\ndf\nei\njk");
    sb = new StringBuilder();
    display_.addThrownMessages(atf, sb);
    actualResult = sb.toString();
    assertEquals("\t:Expected:\n" + 
        "\tjava.io.IOException\n" + 
        "\t\tjava.lang.IllegalArgumentException\n" + 
        "\t\t\tnull\n" + 
        "\t:Actual:\n" +
        "\tjava.io.IOException\n" +
        "\t\tjava.lang.IllegalArgumentException\n" + 
        "\t\t\t'2m2'\n",actualResult);
    
    actual2.setMessage("a\nb\nc");
    sb = new StringBuilder();
    display_.addThrownMessages(atf, sb);
    actualResult = sb.toString();
    assertEquals("\t:Expected:\n" + 
        "\tjava.io.IOException\n" + 
        "\t\tjava.lang.IllegalArgumentException\n" + 
        "\t\t\tnull\n" +
        "\t:Actual:\n" +
        "\tjava.io.IOException\n" +
        "\t\tjava.lang.IllegalArgumentException\n" + 
        "\t\t\t1: 'a'\n" + 
        "\t\t\t2: 'b'\n" + 
        "\t\t\t3: 'c'\n",actualResult);
  }
	 
  @SuppressWarnings("boxing")
  @Test
  public void testMethodAddDisplaySecondThrowableNullDiffRTL() {
    when(constantsMock_.isLeftToRight()).thenReturn(false);
    display_ = new ThrownFailureComparisonDisplay(constantsMock_, logMock_);
    
    AssertThrownFailureMutant atf = new AssertThrownFailureMutant();
    atf.setThrowable(2);
    
    ThrowableInfoMutant expected = new ThrowableInfoMutant();
    expected.setClassName(IOException.class.getName());
    expected.setMessage("message");
    
    ThrowableInfoMutant expected2 = new ThrowableInfoMutant();
    expected2.setClassName(IllegalArgumentException.class.getName());
    expected2.setMessage("message");
    expected2.setMatchType(MatchType.NULL);
    expected.setCause(expected2);
    
    atf.setExpected(expected);
    
    StringBuilder sb = new StringBuilder();
    display_.addThrownMessages(atf, sb);
    
    //null match type, class mismatch
    String actualResult = sb.toString();
    assertEquals(":Expected:\t\n" + 
        "java.io.IOException\t\n" + 
        ":Actual:\t\n" +
        "null\t\n", actualResult);
  
    ThrowableInfoMutant actual = new ThrowableInfoMutant();
    actual.setClassName(IOException.class.getName());
    
    ThrowableInfoMutant actual2 = new ThrowableInfoMutant();
    actual2.setClassName(IllegalArgumentException.class.getName());
    
    actual.setCause(actual2);
    
    atf.setActual(actual);
    
    sb = new StringBuilder();
    display_.addThrownMessages(atf, sb);
    actualResult = sb.toString();
    assertEquals(":Expected:\t\n" + 
        "java.io.IOException\t\n" + 
        "java.lang.IllegalArgumentException\t\t\n" + 
        "null\t\t\t\n" + 
        ":Actual:\t\n" +
        "java.io.IOException\t\n" +
        "java.lang.IllegalArgumentException\t\t\n" + 
        "null\t\t\t\n",actualResult);
    
    
    actual2.setMessage("2m2");
    sb = new StringBuilder();
    display_.addThrownMessages(atf, sb);
    actualResult = sb.toString();
    assertEquals(":Expected:\t\n" + 
        "java.io.IOException\t\n" + 
        "java.lang.IllegalArgumentException\t\t\n" + 
        "null\t\t\t\n" +
        ":Actual:\t\n" +
        "java.io.IOException\t\n" +
        "java.lang.IllegalArgumentException\t\t\n" + 
        "'2m2'\t\t\t\n" ,actualResult);
    
    expected2.setMessage(null);
    sb = new StringBuilder();
    display_.addThrownMessages(atf, sb);
    actualResult = sb.toString();
    assertEquals(":Expected:\t\n" + 
        "java.io.IOException\t\n" + 
        "java.lang.IllegalArgumentException\t\t\n" +
        "null\t\t\t\n" + 
        ":Actual:\t\n" +
        "java.io.IOException\t\n" +
        "java.lang.IllegalArgumentException\t\t\n" + 
        "'2m2'\t\t\t\n",actualResult);
    
    expected2.setMessage("ac\nbc\ndf\nei\njk");
    sb = new StringBuilder();
    display_.addThrownMessages(atf, sb);
    actualResult = sb.toString();
    assertEquals(":Expected:\t\n" + 
        "java.io.IOException\t\n" + 
        "java.lang.IllegalArgumentException\t\t\n" + 
        "null\t\t\t\n" + 
        ":Actual:\t\n" +
        "java.io.IOException\t\n" +
        "java.lang.IllegalArgumentException\t\t\n" + 
        "'2m2'\t\t\t\n",actualResult);
    
    actual2.setMessage("a\nb\nc");
    sb = new StringBuilder();
    display_.addThrownMessages(atf, sb);
    actualResult = sb.toString();
    assertEquals(":Expected:\t\n" + 
        "java.io.IOException\t\n" + 
        "java.lang.IllegalArgumentException\t\t\n" + 
        "null\t\t\t\n" +
        ":Actual:\t\n" +
        "java.io.IOException\t\n" +
        "java.lang.IllegalArgumentException\t\t\n" + 
        "'a' :1\t\t\t\n" + 
        "'b' :2\t\t\t\n" + 
        "'c' :3\t\t\t\n",actualResult);
  }
  
  @Test
  public void testMethodAddDisplayThridThrowableAnyAndNullMatchTypeDiff() {
    AssertThrownFailureMutant atf = new AssertThrownFailureMutant();
    atf.setThrowable(3);
    
    ThrowableInfoMutant expected = new ThrowableInfoMutant();
    expected.setClassName(IOException.class.getName());
    expected.setMessage("message");
    
    ThrowableInfoMutant expected2 = new ThrowableInfoMutant();
    expected2.setClassName(IllegalArgumentException.class.getName());
    expected2.setMessage("message");
    expected.setCause(expected2);
    
    ThrowableInfoMutant expected3 = new ThrowableInfoMutant();
    expected3.setClassName(IllegalStateException.class.getName());
    expected3.setMessage("message");
    expected2.setCause(expected3);
    
    atf.setExpected(expected);
    
    StringBuilder sb = new StringBuilder();
    display_.addThrownMessages(atf, sb);
    
    //null match type, class mismatch
    String actualResult = sb.toString();
    assertEquals("\t:Expected:\n" + 
        "\tjava.io.IOException\n" + 
        "\t:Actual:\n" +
        "\tnull\n", actualResult);
    
    expected.setMatchType(MatchType.ANY);
    sb = new StringBuilder();
    display_.addThrownMessages(atf, sb);
    actualResult = sb.toString();
    assertEquals("\t:Expected:\n" + 
        "\tjava.io.IOException\n" + 
        "\t:Actual:\n" +
        "\tnull\n", actualResult);
    
    expected.setMatchType(null);
    ThrowableInfoMutant actual = new ThrowableInfoMutant();
    actual.setClassName(IOException.class.getName());
    
    atf.setActual(actual);
    
    ThrowableInfoMutant actual2 = new ThrowableInfoMutant();
    actual2.setClassName(IllegalArgumentException.class.getName());
    actual2.setMessage("message");
    actual.setCause(actual2);
    
    sb = new StringBuilder();
    display_.addThrownMessages(atf, sb);
    actualResult = sb.toString();
    assertEquals("\t:Expected:\n" + 
        "\tjava.io.IOException\n" + 
        "\t\tjava.lang.IllegalArgumentException\n" + 
        "\t\t\tjava.lang.IllegalStateException\n" + 
        "\t:Actual:\n" +
        "\tjava.io.IOException\n" +
        "\t\tjava.lang.IllegalArgumentException\n" + 
        "\t\t\tnull\n",actualResult);
    
    expected.setMatchType(MatchType.ANY);
    sb = new StringBuilder();
    display_.addThrownMessages(atf, sb);
    actualResult = sb.toString();
    assertEquals("\t:Expected:\n" + 
        "\tjava.io.IOException\n" + 
        "\t\tjava.lang.IllegalArgumentException\n" + 
        "\t\t\tjava.lang.IllegalStateException\n" + 
        "\t:Actual:\n" +
        "\tjava.io.IOException\n" +
        "\t\tjava.lang.IllegalArgumentException\n" + 
        "\t\t\tnull\n",actualResult);
    
    
    ThrowableInfoMutant actual3 = new ThrowableInfoMutant();
    actual3.setClassName(IllegalStateException.class.getName());
    actual3.setMessage("2message or not2");
    actual2.setCause(actual3);
    
    expected.setMatchType(null);
    sb = new StringBuilder();
    display_.addThrownMessages(atf, sb);
    actualResult = sb.toString();
    assertEquals("\t:Expected:\n" + 
        "\tjava.io.IOException\n" + 
        "\t\tjava.lang.IllegalArgumentException\n" + 
        "\t\t\tjava.lang.IllegalStateException\n" + 
        "\t\t\t\t:Expected:\n" +
        "\t\t\t\t'message'\n" +
        "\t:Actual:\n" +
        "\tjava.io.IOException\n" +
        "\t\tjava.lang.IllegalArgumentException\n" + 
        "\t\t\tjava.lang.IllegalStateException\n" + 
        "\t\t\t\t:Actual:\n" +
        "\t\t\t\t'2message or not2'\n" + 
        "\t\t\t\t\t:Differences:\n" +
        "\t\t\t\t\t1: '2message '\n"
        ,actualResult);
    
    expected.setMatchType(MatchType.ANY);
    actual.setMessage("message2");
    sb = new StringBuilder();
    display_.addThrownMessages(atf, sb);
    actualResult = sb.toString();
    assertEquals("\t:Expected:\n" + 
        "\tjava.io.IOException\n" + 
        "\t\tjava.lang.IllegalArgumentException\n" + 
        "\t\t\tjava.lang.IllegalStateException\n" + 
        "\t\t\t\t:Expected:\n" +
        "\t\t\t\t'message'\n" +
        "\t:Actual:\n" +
        "\tjava.io.IOException\n" +
        "\t\tjava.lang.IllegalArgumentException\n" + 
        "\t\t\tjava.lang.IllegalStateException\n" + 
        "\t\t\t\t:Actual:\n" +
        "\t\t\t\t'2message or not2'\n" + 
        "\t\t\t\t\t:Differences:\n" +
        "\t\t\t\t\t1: '2message '\n"
        ,actualResult);
    
    
    sb = new StringBuilder();
    display_.addThrownMessages(atf, sb);
    actualResult = sb.toString();
    assertEquals("\t:Expected:\n" + 
        "\tjava.io.IOException\n" + 
        "\t\tjava.lang.IllegalArgumentException\n" + 
        "\t\t\tjava.lang.IllegalStateException\n" + 
        "\t\t\t\t:Expected:\n" +
        "\t\t\t\t'message'\n" +
        "\t:Actual:\n" +
        "\tjava.io.IOException\n" +
        "\t\tjava.lang.IllegalArgumentException\n" + 
        "\t\t\tjava.lang.IllegalStateException\n" + 
        "\t\t\t\t:Actual:\n" +
        "\t\t\t\t'2message or not2'\n" + 
        "\t\t\t\t\t:Differences:\n" +
        "\t\t\t\t\t1: '2message '\n"
        ,actualResult);
  }

  @SuppressWarnings("boxing")
  @Test
  public void testMethodAddDisplayThirdThrowableAnyAndNullMatchTypeRTL() {

    when(constantsMock_.isLeftToRight()).thenReturn(false);
    display_ = new ThrownFailureComparisonDisplay(constantsMock_, logMock_);
    AssertThrownFailureMutant atf = new AssertThrownFailureMutant();
    atf.setThrowable(3);
    
    ThrowableInfoMutant expected = new ThrowableInfoMutant();
    expected.setClassName(IOException.class.getName());
    expected.setMessage("message");
    atf.setExpected(expected);
    
    ThrowableInfoMutant expected2 = new ThrowableInfoMutant();
    expected2.setClassName(IllegalArgumentException.class.getName());
    expected2.setMessage("message");
    expected.setCause(expected2);
    
    ThrowableInfoMutant expected3 = new ThrowableInfoMutant();
    expected3.setClassName(IllegalStateException.class.getName());
    expected3.setMessage("message");
    expected2.setCause(expected3);
    
    StringBuilder sb = new StringBuilder();
    display_.addThrownMessages(atf, sb);
    
    //null match type
    String actualResult = sb.toString();
    assertEquals(":Expected:\t\n" + 
        "java.io.IOException\t\n" + 
        ":Actual:\t\n" +
        "null\t\n", actualResult);
    
    expected3.setMatchType(MatchType.ANY);
    sb = new StringBuilder();
    display_.addThrownMessages(atf, sb);
    actualResult = sb.toString();
    assertEquals(":Expected:\t\n" + 
        "java.io.IOException\t\n" + 
        ":Actual:\t\n" +
        "null\t\n", actualResult);
    
    ThrowableInfoMutant actual = new ThrowableInfoMutant();
    actual.setClassName(IOException.class.getName());
    
    ThrowableInfoMutant actual2 = new ThrowableInfoMutant();
    actual2.setClassName(IllegalArgumentException.class.getName());
    actual2.setMessage("message");
    actual.setCause(actual2);
    
    atf.setActual(actual);
    
    expected3.setMatchType(null);
    sb = new StringBuilder();
    display_.addThrownMessages(atf, sb);
    actualResult = sb.toString();
    assertEquals(":Expected:\t\n" + 
        "java.io.IOException\t\n" + 
        "java.lang.IllegalArgumentException\t\t\n" +
        "java.lang.IllegalStateException\t\t\t\n" +
        ":Actual:\t\n" +
        "java.io.IOException\t\n" +
        "java.lang.IllegalArgumentException\t\t\n" +
        "null\t\t\t\n",actualResult);
    
    expected3.setMatchType(MatchType.ANY);
    sb = new StringBuilder();
    display_.addThrownMessages(atf, sb);
    actualResult = sb.toString();
    assertEquals(":Expected:\t\n" + 
        "java.io.IOException\t\n" + 
        "java.lang.IllegalArgumentException\t\t\n" +
        "java.lang.IllegalStateException\t\t\t\n" +
        ":Actual:\t\n" +
        "java.io.IOException\t\n" +
        "java.lang.IllegalArgumentException\t\t\n" +
        "null\t\t\t\n",actualResult);
    
    ThrowableInfoMutant actual3 = new ThrowableInfoMutant();
    actual3.setClassName(IllegalStateException.class.getName());
    actual3.setMessage("mes2sage");
    actual2.setCause(actual3);
    
    expected3.setMatchType(null);
    actual.setMessage("message2");
    sb = new StringBuilder();
    display_.addThrownMessages(atf, sb);
    actualResult = sb.toString();
    assertEquals(":Expected:\t\n" + 
        "java.io.IOException\t\n" + 
        "java.lang.IllegalArgumentException\t\t\n" +
        "java.lang.IllegalStateException\t\t\t\n" +
        ":Expected:\t\t\t\t\n" +
        "'message'\t\t\t\t\n" +
        ":Actual:\t\n" +
        "java.io.IOException\t\n" +
        "java.lang.IllegalArgumentException\t\t\n" +
        "java.lang.IllegalStateException\t\t\t\n" +
        ":Actual:\t\t\t\t\n" +
        "'mes2sage'\t\t\t\t\n" + 
        ":Differences:\t\t\t\t\t\n" +
        "'2' :1\t\t\t\t\t\n"
        ,actualResult);
    

    
    expected3.setMatchType(MatchType.ANY);
    sb = new StringBuilder();
    display_.addThrownMessages(atf, sb);
    actualResult = sb.toString();
    assertEquals(":Expected:\t\n" + 
        "java.io.IOException\t\n" + 
        "java.lang.IllegalArgumentException\t\t\n" +
        "java.lang.IllegalStateException\t\t\t\n" +
        ":Expected:\t\t\t\t\n" +
        "'message'\t\t\t\t\n" +
        ":Actual:\t\n" +
        "java.io.IOException\t\n" +
        "java.lang.IllegalArgumentException\t\t\n" +
        "java.lang.IllegalStateException\t\t\t\n" +
        ":Actual:\t\t\t\t\n" +
        "'mes2sage'\t\t\t\t\n" + 
        ":Differences:\t\t\t\t\t\n" +
        "'2' :1\t\t\t\t\t\n"
        ,actualResult);
  }
  
  @Test
  public void testMethodAddDisplayThirdThrowableClassDiff() {
    AssertThrownFailureMutant atf = new AssertThrownFailureMutant();
    atf.setThrowable(3);
    
    ThrowableInfoMutant expected = new ThrowableInfoMutant();
    expected.setClassName(IOException.class.getName());
    expected.setMessage("message");
    
    ThrowableInfoMutant expected2 = new ThrowableInfoMutant();
    expected2.setClassName(IllegalArgumentException.class.getName());
    expected2.setMessage("message");
    expected.setCause(expected2);
    
    ThrowableInfoMutant expected3 = new ThrowableInfoMutant();
    expected3.setClassName(IllegalStateException.class.getName());
    expected3.setMessage("message");
    expected2.setCause(expected3);
    
    atf.setExpected(expected);
    
    StringBuilder sb = new StringBuilder();
    display_.addThrownMessages(atf, sb);
    
    //null match type, class mismatch
    String actualResult = sb.toString();
    assertEquals("\t:Expected:\n" + 
        "\tjava.io.IOException\n" + 
        "\t:Actual:\n" +
        "\tnull\n", actualResult);
    
    expected.setMatchType(MatchType.ANY);
    sb = new StringBuilder();
    display_.addThrownMessages(atf, sb);
    actualResult = sb.toString();
    assertEquals("\t:Expected:\n" + 
        "\tjava.io.IOException\n" + 
        "\t:Actual:\n" +
        "\tnull\n", actualResult);
    
    expected.setMatchType(null);
    ThrowableInfoMutant actual = new ThrowableInfoMutant();
    actual.setClassName(IOException.class.getName());
    
    atf.setActual(actual);
    
    ThrowableInfoMutant actual2 = new ThrowableInfoMutant();
    actual2.setClassName(IllegalArgumentException.class.getName());
    actual2.setMessage("message");
    actual.setCause(actual2);
    
    sb = new StringBuilder();
    display_.addThrownMessages(atf, sb);
    actualResult = sb.toString();
    assertEquals("\t:Expected:\n" + 
        "\tjava.io.IOException\n" + 
        "\t\tjava.lang.IllegalArgumentException\n" + 
        "\t\t\tjava.lang.IllegalStateException\n" + 
        "\t:Actual:\n" +
        "\tjava.io.IOException\n" +
        "\t\tjava.lang.IllegalArgumentException\n" + 
        "\t\t\tnull\n",actualResult);
    
    ThrowableInfoMutant actual3 = new ThrowableInfoMutant();
    actual3.setClassName(IllegalArgumentException.class.getName());
    actual3.setMessage("2message or not2");
    actual2.setCause(actual3);
    
    expected.setMatchType(null);
    sb = new StringBuilder();
    display_.addThrownMessages(atf, sb);
    actualResult = sb.toString();
    assertEquals("\t:Expected:\n" + 
        "\tjava.io.IOException\n" + 
        "\t\tjava.lang.IllegalArgumentException\n" + 
        "\t\t\tjava.lang.IllegalStateException\n" + 
        "\t:Actual:\n" +
        "\tjava.io.IOException\n" +
        "\t\tjava.lang.IllegalArgumentException\n" + 
        "\t\t\tjava.lang.IllegalArgumentException\n"
        ,actualResult);
    
  }

  @SuppressWarnings("boxing")
  @Test
  public void testMethodAddDisplayThirdThrowableClassDiffRTL() {

    when(constantsMock_.isLeftToRight()).thenReturn(false);
    display_ = new ThrownFailureComparisonDisplay(constantsMock_, logMock_);
    AssertThrownFailureMutant atf = new AssertThrownFailureMutant();
    atf.setThrowable(3);
    
    ThrowableInfoMutant expected = new ThrowableInfoMutant();
    expected.setClassName(IOException.class.getName());
    expected.setMessage("message");
    atf.setExpected(expected);
    
    ThrowableInfoMutant expected2 = new ThrowableInfoMutant();
    expected2.setClassName(IllegalArgumentException.class.getName());
    expected2.setMessage("message");
    expected.setCause(expected2);
    
    ThrowableInfoMutant expected3 = new ThrowableInfoMutant();
    expected3.setClassName(IllegalStateException.class.getName());
    expected3.setMessage("message");
    expected2.setCause(expected3);
    
    StringBuilder sb = new StringBuilder();
    display_.addThrownMessages(atf, sb);
    
    //null match type
    String actualResult = sb.toString();
    assertEquals(":Expected:\t\n" + 
        "java.io.IOException\t\n" + 
        ":Actual:\t\n" +
        "null\t\n", actualResult);
    
    
    ThrowableInfoMutant actual = new ThrowableInfoMutant();
    actual.setClassName(IOException.class.getName());
    
    ThrowableInfoMutant actual2 = new ThrowableInfoMutant();
    
    actual2.setMessage("message");
    actual.setCause(actual2);
    
    atf.setActual(actual);
    
    expected.setMatchType(null);
    sb = new StringBuilder();
    display_.addThrownMessages(atf, sb);
    actualResult = sb.toString();
    assertEquals(":Expected:\t\n" + 
        "java.io.IOException\t\n" + 
        "java.lang.IllegalArgumentException\t\t\n" +
        ":Actual:\t\n" +
        "java.io.IOException\t\n" +
        "null\t\t\n",actualResult);
        
    actual2.setClassName(IllegalStateException.class.getName());
    sb = new StringBuilder();
    display_.addThrownMessages(atf, sb);
    actualResult = sb.toString();
    assertEquals(":Expected:\t\n" + 
        "java.io.IOException\t\n" + 
        "java.lang.IllegalArgumentException\t\t\n" +
        ":Actual:\t\n" +
        "java.io.IOException\t\n" +
        "java.lang.IllegalStateException\t\t\n",actualResult);
    
    actual2.setClassName(IllegalArgumentException.class.getName());
    expected.setMatchType(null);
    sb = new StringBuilder();
    display_.addThrownMessages(atf, sb);
    actualResult = sb.toString();
    assertEquals(":Expected:\t\n" + 
        "java.io.IOException\t\n" + 
        "java.lang.IllegalArgumentException\t\t\n" +
        "java.lang.IllegalStateException\t\t\t\n" +
        ":Actual:\t\n" +
        "java.io.IOException\t\n" +
        "java.lang.IllegalArgumentException\t\t\n" +
        "null\t\t\t\n",actualResult);
    
    ThrowableInfoMutant actual3 = new ThrowableInfoMutant();
    actual3.setClassName(IllegalArgumentException.class.getName());
    actual3.setMessage("mes2sage");
    actual2.setCause(actual3);
    
    expected.setMatchType(null);
    actual.setMessage("message2");
    sb = new StringBuilder();
    display_.addThrownMessages(atf, sb);
    actualResult = sb.toString();
    assertEquals(":Expected:\t\n" + 
        "java.io.IOException\t\n" + 
        "java.lang.IllegalArgumentException\t\t\n" +
        "java.lang.IllegalStateException\t\t\t\n" +
        ":Actual:\t\n" +
        "java.io.IOException\t\n" +
        "java.lang.IllegalArgumentException\t\t\n" +
        "java.lang.IllegalArgumentException\t\t\t\n"
        ,actualResult);
  }
  
  @Test
  public void testMethodAddDisplayThirdThrowableContainsDiff() {
    AssertThrownFailureMutant atf = new AssertThrownFailureMutant();
    atf.setThrowable(3);
    
    ThrowableInfoMutant expected = new ThrowableInfoMutant();
    expected.setClassName(IOException.class.getName());
    expected.setMessage("message");
    
    ThrowableInfoMutant expected2 = new ThrowableInfoMutant();
    expected2.setClassName(IllegalArgumentException.class.getName());
    expected2.setMessage("message");
    expected.setCause(expected2);
    
    ThrowableInfoMutant expected3 = new ThrowableInfoMutant();
    expected3.setClassName(IllegalStateException.class.getName());
    expected3.setMessage("message");
    expected2.setCause(expected3);
    
    atf.setExpected(expected);
    
    StringBuilder sb = new StringBuilder();
    display_.addThrownMessages(atf, sb);
    
    //null match type, class mismatch
    String actualResult = sb.toString();
    assertEquals("\t:Expected:\n" + 
        "\tjava.io.IOException\n" + 
        "\t:Actual:\n" +
        "\tnull\n", actualResult);
    
    expected3.setMatchType(MatchType.CONTAINS);
    sb = new StringBuilder();
    display_.addThrownMessages(atf, sb);
    actualResult = sb.toString();
    assertEquals("\t:Expected:\n" + 
        "\tjava.io.IOException\n" + 
        "\t:Actual:\n" +
        "\tnull\n", actualResult);
    
    ThrowableInfoMutant actual = new ThrowableInfoMutant();
    actual.setClassName(IOException.class.getName());
    
    atf.setActual(actual);
    
    ThrowableInfoMutant actual2 = new ThrowableInfoMutant();
    actual2.setClassName(IllegalArgumentException.class.getName());
    actual2.setMessage("message");
    actual.setCause(actual2);
    
    sb = new StringBuilder();
    display_.addThrownMessages(atf, sb);
    actualResult = sb.toString();
    assertEquals("\t:Expected:\n" + 
        "\tjava.io.IOException\n" + 
        "\t\tjava.lang.IllegalArgumentException\n" + 
        "\t\t\tjava.lang.IllegalStateException\n" + 
        "\t:Actual:\n" +
        "\tjava.io.IOException\n" +
        "\t\tjava.lang.IllegalArgumentException\n" + 
        "\t\t\tnull\n",actualResult);
    
    ThrowableInfoMutant actual3 = new ThrowableInfoMutant();
    actual3.setClassName(IllegalStateException.class.getName());
    actual3.setMessage("2message or not2");
    actual2.setCause(actual3);
    
    sb = new StringBuilder();
    display_.addThrownMessages(atf, sb);
    actualResult = sb.toString();
    assertEquals("\t:Expected:\n" + 
        "\tjava.io.IOException\n" + 
        "\t\tjava.lang.IllegalArgumentException\n" + 
        "\t\t\tjava.lang.IllegalStateException\n" + 
        "\t\t\t\t:The following text was NOT found in the actual text:\n" +
        "\t\t\t\t'message'\n" +
        "\t:Actual:\n" +
        "\tjava.io.IOException\n" +
        "\t\tjava.lang.IllegalArgumentException\n" + 
        "\t\t\tjava.lang.IllegalStateException\n" +
        "\t\t\t\t'2message or not2'\n"
        ,actualResult);
  }
  
  @SuppressWarnings("boxing")
  @Test
  public void testMethodAddDisplayThirdThrowableContainsDiffRTL() {

    when(constantsMock_.isLeftToRight()).thenReturn(false);
    display_ = new ThrownFailureComparisonDisplay(constantsMock_, logMock_);
    AssertThrownFailureMutant atf = new AssertThrownFailureMutant();
    atf.setThrowable(3);
    
    ThrowableInfoMutant expected = new ThrowableInfoMutant();
    expected.setClassName(IOException.class.getName());
    expected.setMessage("message");
    atf.setExpected(expected);
    
    ThrowableInfoMutant expected2 = new ThrowableInfoMutant();
    expected2.setClassName(IllegalArgumentException.class.getName());
    expected2.setMessage("message");
    expected.setCause(expected2);
    
    ThrowableInfoMutant expected3 = new ThrowableInfoMutant();
    expected3.setClassName(IllegalStateException.class.getName());
    expected3.setMessage("message");
    expected2.setCause(expected3);
    
    StringBuilder sb = new StringBuilder();
    display_.addThrownMessages(atf, sb);
    
    expected3.setMatchType(MatchType.CONTAINS);
    String actualResult = sb.toString();
    assertEquals(":Expected:\t\n" + 
        "java.io.IOException\t\n" + 
        ":Actual:\t\n" +
        "null\t\n", actualResult);
    
    
    ThrowableInfoMutant actual = new ThrowableInfoMutant();
    actual.setClassName(IOException.class.getName());
    
    ThrowableInfoMutant actual2 = new ThrowableInfoMutant();
    
    actual2.setMessage("message");
    actual.setCause(actual2);
    
    atf.setActual(actual);
    
    expected.setMatchType(null);
    sb = new StringBuilder();
    display_.addThrownMessages(atf, sb);
    actualResult = sb.toString();
    assertEquals(":Expected:\t\n" + 
        "java.io.IOException\t\n" + 
        "java.lang.IllegalArgumentException\t\t\n" +
        ":Actual:\t\n" +
        "java.io.IOException\t\n" +
        "null\t\t\n",actualResult);
        
    actual2.setClassName(IllegalStateException.class.getName());
    sb = new StringBuilder();
    display_.addThrownMessages(atf, sb);
    actualResult = sb.toString();
    assertEquals(":Expected:\t\n" + 
        "java.io.IOException\t\n" + 
        "java.lang.IllegalArgumentException\t\t\n" +
        ":Actual:\t\n" +
        "java.io.IOException\t\n" +
        "java.lang.IllegalStateException\t\t\n",actualResult);
    
    actual2.setClassName(IllegalArgumentException.class.getName());
    expected.setMatchType(null);
    sb = new StringBuilder();
    display_.addThrownMessages(atf, sb);
    actualResult = sb.toString();
    assertEquals(":Expected:\t\n" + 
        "java.io.IOException\t\n" + 
        "java.lang.IllegalArgumentException\t\t\n" +
        "java.lang.IllegalStateException\t\t\t\n" +
        ":Actual:\t\n" +
        "java.io.IOException\t\n" +
        "java.lang.IllegalArgumentException\t\t\n" +
        "null\t\t\t\n",actualResult);
    
    ThrowableInfoMutant actual3 = new ThrowableInfoMutant();
    actual3.setClassName(IllegalStateException.class.getName());
    actual3.setMessage("mes2sage");
    actual2.setCause(actual3);
    
    expected.setMatchType(null);
    actual.setMessage("message2");
    sb = new StringBuilder();
    display_.addThrownMessages(atf, sb);
    actualResult = sb.toString();
    assertEquals(":Expected:\t\n" + 
        "java.io.IOException\t\n" + 
        "java.lang.IllegalArgumentException\t\t\n" +
        "java.lang.IllegalStateException\t\t\t\n" +
        ":The following text was NOT found in the actual text:\t\t\t\t\n" +
        "'message'\t\t\t\t\n" +
        ":Actual:\t\n" +
        "java.io.IOException\t\n" +
        "java.lang.IllegalArgumentException\t\t\n" +
        "java.lang.IllegalStateException\t\t\t\n" +
        "'mes2sage'\t\t\t\t\n" 
        ,actualResult);
  }
  
  @Test
  public void testMethodAddDisplayThirdThrowableEqualsDiff() {
    AssertThrownFailureMutant atf = new AssertThrownFailureMutant();
    atf.setThrowable(3);
    
    ThrowableInfoMutant expected = new ThrowableInfoMutant();
    expected.setClassName(IOException.class.getName());
    expected.setMessage("message");
    
    ThrowableInfoMutant expected2 = new ThrowableInfoMutant();
    expected2.setClassName(IllegalArgumentException.class.getName());
    expected2.setMessage("message");
    expected.setCause(expected2);
    
    ThrowableInfoMutant expected3 = new ThrowableInfoMutant();
    expected3.setClassName(IllegalStateException.class.getName());
    expected3.setMessage("message");
    expected2.setCause(expected3);
    
    atf.setExpected(expected);
    
    StringBuilder sb = new StringBuilder();
    display_.addThrownMessages(atf, sb);
    
    //null match type, class mismatch
    String actualResult = sb.toString();
    assertEquals("\t:Expected:\n" + 
        "\tjava.io.IOException\n" + 
        "\t:Actual:\n" +
        "\tnull\n", actualResult);
    
    expected3.setMatchType(MatchType.EQUALS);
    sb = new StringBuilder();
    display_.addThrownMessages(atf, sb);
    actualResult = sb.toString();
    assertEquals("\t:Expected:\n" + 
        "\tjava.io.IOException\n" + 
        "\t:Actual:\n" +
        "\tnull\n", actualResult);
    
    ThrowableInfoMutant actual = new ThrowableInfoMutant();
    actual.setClassName(IOException.class.getName());
    
    atf.setActual(actual);
    
    ThrowableInfoMutant actual2 = new ThrowableInfoMutant();
    actual2.setClassName(IllegalArgumentException.class.getName());
    actual2.setMessage("message");
    actual.setCause(actual2);
    
    sb = new StringBuilder();
    display_.addThrownMessages(atf, sb);
    actualResult = sb.toString();
    assertEquals("\t:Expected:\n" + 
        "\tjava.io.IOException\n" + 
        "\t\tjava.lang.IllegalArgumentException\n" + 
        "\t\t\tjava.lang.IllegalStateException\n" + 
        "\t:Actual:\n" +
        "\tjava.io.IOException\n" +
        "\t\tjava.lang.IllegalArgumentException\n" + 
        "\t\t\tnull\n",actualResult);
    
    ThrowableInfoMutant actual3 = new ThrowableInfoMutant();
    actual3.setClassName(IllegalStateException.class.getName());
    actual3.setMessage("2message or not2");
    actual2.setCause(actual3);
    
    sb = new StringBuilder();
    display_.addThrownMessages(atf, sb);
    actualResult = sb.toString();
    assertEquals("\t:Expected:\n" + 
        "\tjava.io.IOException\n" + 
        "\t\tjava.lang.IllegalArgumentException\n" + 
        "\t\t\tjava.lang.IllegalStateException\n" + 
        "\t\t\t\t:Expected:\n" +
        "\t\t\t\t'message'\n" +
        "\t:Actual:\n" +
        "\tjava.io.IOException\n" +
        "\t\tjava.lang.IllegalArgumentException\n" + 
        "\t\t\tjava.lang.IllegalStateException\n" +
        "\t\t\t\t:Actual:\n" +
        "\t\t\t\t'2message or not2'\n" +
        "\t\t\t\t\t:Differences:\n" +
        "\t\t\t\t\t1: '2message '\n"
        ,actualResult);
  }

  @SuppressWarnings("boxing")
  @Test
  public void testMethodAddDisplayThirdThrowableEqualsDiffRTL() {

    when(constantsMock_.isLeftToRight()).thenReturn(false);
    display_ = new ThrownFailureComparisonDisplay(constantsMock_, logMock_);
    AssertThrownFailureMutant atf = new AssertThrownFailureMutant();
    atf.setThrowable(3);
    
    ThrowableInfoMutant expected = new ThrowableInfoMutant();
    expected.setClassName(IOException.class.getName());
    expected.setMessage("message");
    atf.setExpected(expected);
    
    ThrowableInfoMutant expected2 = new ThrowableInfoMutant();
    expected2.setClassName(IllegalArgumentException.class.getName());
    expected2.setMessage("message");
    expected.setCause(expected2);
    
    ThrowableInfoMutant expected3 = new ThrowableInfoMutant();
    expected3.setClassName(IllegalStateException.class.getName());
    expected3.setMessage("message");
    expected2.setCause(expected3);
    
    StringBuilder sb = new StringBuilder();
    display_.addThrownMessages(atf, sb);
    
    expected3.setMatchType(MatchType.EQUALS);
    String actualResult = sb.toString();
    assertEquals(":Expected:\t\n" + 
        "java.io.IOException\t\n" + 
        ":Actual:\t\n" +
        "null\t\n", actualResult);
    
    
    ThrowableInfoMutant actual = new ThrowableInfoMutant();
    actual.setClassName(IOException.class.getName());
    
    ThrowableInfoMutant actual2 = new ThrowableInfoMutant();
    
    actual2.setMessage("message");
    actual.setCause(actual2);
    
    atf.setActual(actual);
    
    expected.setMatchType(null);
    sb = new StringBuilder();
    display_.addThrownMessages(atf, sb);
    actualResult = sb.toString();
    assertEquals(":Expected:\t\n" + 
        "java.io.IOException\t\n" + 
        "java.lang.IllegalArgumentException\t\t\n" +
        ":Actual:\t\n" +
        "java.io.IOException\t\n" +
        "null\t\t\n",actualResult);
        
    actual2.setClassName(IllegalStateException.class.getName());
    sb = new StringBuilder();
    display_.addThrownMessages(atf, sb);
    actualResult = sb.toString();
    assertEquals(":Expected:\t\n" + 
        "java.io.IOException\t\n" + 
        "java.lang.IllegalArgumentException\t\t\n" +
        ":Actual:\t\n" +
        "java.io.IOException\t\n" +
        "java.lang.IllegalStateException\t\t\n",actualResult);
    
    actual2.setClassName(IllegalArgumentException.class.getName());
    expected.setMatchType(null);
    sb = new StringBuilder();
    display_.addThrownMessages(atf, sb);
    actualResult = sb.toString();
    assertEquals(":Expected:\t\n" + 
        "java.io.IOException\t\n" + 
        "java.lang.IllegalArgumentException\t\t\n" +
        "java.lang.IllegalStateException\t\t\t\n" +
        ":Actual:\t\n" +
        "java.io.IOException\t\n" +
        "java.lang.IllegalArgumentException\t\t\n" +
        "null\t\t\t\n",actualResult);
    
    ThrowableInfoMutant actual3 = new ThrowableInfoMutant();
    actual3.setClassName(IllegalStateException.class.getName());
    actual3.setMessage("mes2sage");
    actual2.setCause(actual3);
    
    expected.setMatchType(null);
    actual.setMessage("message2");
    sb = new StringBuilder();
    display_.addThrownMessages(atf, sb);
    actualResult = sb.toString();
    assertEquals(":Expected:\t\n" + 
        "java.io.IOException\t\n" + 
        "java.lang.IllegalArgumentException\t\t\n" +
        "java.lang.IllegalStateException\t\t\t\n" +
        ":Expected:\t\t\t\t\n" +
        "'message'\t\t\t\t\n" +
        ":Actual:\t\n" +
        "java.io.IOException\t\n" +
        "java.lang.IllegalArgumentException\t\t\n" +
        "java.lang.IllegalStateException\t\t\t\n" +
        ":Actual:\t\t\t\t\n" +
        "'mes2sage'\t\t\t\t\n" +
        ":Differences:\t\t\t\t\t\n" +
        "'2' :1\t\t\t\t\t\n" 
        ,actualResult);
  }
  
  @Test
  public void testMethodAddDisplayThirdThrowableNullDiff() {
    AssertThrownFailureMutant atf = new AssertThrownFailureMutant();
    atf.setThrowable(3);
    
    ThrowableInfoMutant expected = new ThrowableInfoMutant();
    expected.setClassName(IOException.class.getName());
    expected.setMessage("message");
    
    ThrowableInfoMutant expected2 = new ThrowableInfoMutant();
    expected2.setClassName(IllegalArgumentException.class.getName());
    expected2.setMessage("message");
    expected.setCause(expected2);
    
    ThrowableInfoMutant expected3 = new ThrowableInfoMutant();
    expected3.setClassName(IllegalStateException.class.getName());
    expected3.setMessage("message");
    expected2.setCause(expected3);
    
    atf.setExpected(expected);
    
    StringBuilder sb = new StringBuilder();
    display_.addThrownMessages(atf, sb);
    
    //null match type, class mismatch
    String actualResult = sb.toString();
    assertEquals("\t:Expected:\n" + 
        "\tjava.io.IOException\n" + 
        "\t:Actual:\n" +
        "\tnull\n", actualResult);
    
    expected3.setMatchType(MatchType.NULL);
    sb = new StringBuilder();
    display_.addThrownMessages(atf, sb);
    actualResult = sb.toString();
    assertEquals("\t:Expected:\n" + 
        "\tjava.io.IOException\n" + 
        "\t:Actual:\n" +
        "\tnull\n", actualResult);
    
    ThrowableInfoMutant actual = new ThrowableInfoMutant();
    actual.setClassName(IOException.class.getName());
    
    atf.setActual(actual);
    
    ThrowableInfoMutant actual2 = new ThrowableInfoMutant();
    actual2.setClassName(IllegalArgumentException.class.getName());
    actual2.setMessage("message");
    actual.setCause(actual2);
    
    sb = new StringBuilder();
    display_.addThrownMessages(atf, sb);
    actualResult = sb.toString();
    assertEquals("\t:Expected:\n" + 
        "\tjava.io.IOException\n" + 
        "\t\tjava.lang.IllegalArgumentException\n" + 
        "\t\t\tjava.lang.IllegalStateException\n" + 
        "\t:Actual:\n" +
        "\tjava.io.IOException\n" +
        "\t\tjava.lang.IllegalArgumentException\n" + 
        "\t\t\tnull\n",actualResult);
    
    ThrowableInfoMutant actual3 = new ThrowableInfoMutant();
    actual3.setClassName(IllegalStateException.class.getName());
    actual3.setMessage("2message or not2");
    actual2.setCause(actual3);
    
    sb = new StringBuilder();
    display_.addThrownMessages(atf, sb);
    actualResult = sb.toString();
    assertEquals("\t:Expected:\n" + 
        "\tjava.io.IOException\n" + 
        "\t\tjava.lang.IllegalArgumentException\n" + 
        "\t\t\tjava.lang.IllegalStateException\n" + 
        "\t\t\t\tnull\n" +
        "\t:Actual:\n" +
        "\tjava.io.IOException\n" +
        "\t\tjava.lang.IllegalArgumentException\n" + 
        "\t\t\tjava.lang.IllegalStateException\n" +
        "\t\t\t\t'2message or not2'\n" 
        ,actualResult);
  }
  
  @SuppressWarnings("boxing")
  @Test
  public void testMethodAddDisplayThirdThrowableNullDiffRTL() {
    when(constantsMock_.isLeftToRight()).thenReturn(false);
    display_ = new ThrownFailureComparisonDisplay(constantsMock_, logMock_);
    AssertThrownFailureMutant atf = new AssertThrownFailureMutant();
    atf.setThrowable(3);
    
    ThrowableInfoMutant expected = new ThrowableInfoMutant();
    expected.setClassName(IOException.class.getName());
    expected.setMessage("message");
    atf.setExpected(expected);
    
    ThrowableInfoMutant expected2 = new ThrowableInfoMutant();
    expected2.setClassName(IllegalArgumentException.class.getName());
    expected2.setMessage("message");
    expected.setCause(expected2);
    
    ThrowableInfoMutant expected3 = new ThrowableInfoMutant();
    expected3.setClassName(IllegalStateException.class.getName());
    expected3.setMessage("message");
    expected2.setCause(expected3);
    
    StringBuilder sb = new StringBuilder();
    display_.addThrownMessages(atf, sb);
    
    expected3.setMatchType(MatchType.EQUALS);
    String actualResult = sb.toString();
    assertEquals(":Expected:\t\n" + 
        "java.io.IOException\t\n" + 
        ":Actual:\t\n" +
        "null\t\n", actualResult);
    
    
    ThrowableInfoMutant actual = new ThrowableInfoMutant();
    actual.setClassName(IOException.class.getName());
    
    ThrowableInfoMutant actual2 = new ThrowableInfoMutant();
    
    actual2.setMessage("message");
    actual.setCause(actual2);
    
    atf.setActual(actual);
    
    expected.setMatchType(null);
    sb = new StringBuilder();
    display_.addThrownMessages(atf, sb);
    actualResult = sb.toString();
    assertEquals(":Expected:\t\n" + 
        "java.io.IOException\t\n" + 
        "java.lang.IllegalArgumentException\t\t\n" +
        ":Actual:\t\n" +
        "java.io.IOException\t\n" +
        "null\t\t\n",actualResult);
        
    actual2.setClassName(IllegalStateException.class.getName());
    sb = new StringBuilder();
    display_.addThrownMessages(atf, sb);
    actualResult = sb.toString();
    assertEquals(":Expected:\t\n" + 
        "java.io.IOException\t\n" + 
        "java.lang.IllegalArgumentException\t\t\n" +
        ":Actual:\t\n" +
        "java.io.IOException\t\n" +
        "java.lang.IllegalStateException\t\t\n",actualResult);
    
    actual2.setClassName(IllegalArgumentException.class.getName());
    expected.setMatchType(null);
    sb = new StringBuilder();
    display_.addThrownMessages(atf, sb);
    actualResult = sb.toString();
    assertEquals(":Expected:\t\n" + 
        "java.io.IOException\t\n" + 
        "java.lang.IllegalArgumentException\t\t\n" +
        "java.lang.IllegalStateException\t\t\t\n" +
        ":Actual:\t\n" +
        "java.io.IOException\t\n" +
        "java.lang.IllegalArgumentException\t\t\n" +
        "null\t\t\t\n",actualResult);
    
    ThrowableInfoMutant actual3 = new ThrowableInfoMutant();
    actual3.setClassName(IllegalStateException.class.getName());
    actual3.setMessage("mes2sage");
    actual2.setCause(actual3);
    
    expected.setMatchType(null);
    actual.setMessage("message2");
    sb = new StringBuilder();
    display_.addThrownMessages(atf, sb);
    actualResult = sb.toString();
    assertEquals(":Expected:\t\n" + 
        "java.io.IOException\t\n" + 
        "java.lang.IllegalArgumentException\t\t\n" +
        "java.lang.IllegalStateException\t\t\t\n" +
        ":Expected:\t\t\t\t\n" +
        "'message'\t\t\t\t\n" +
        ":Actual:\t\n" +
        "java.io.IOException\t\n" +
        "java.lang.IllegalArgumentException\t\t\n" +
        "java.lang.IllegalStateException\t\t\t\n" +
        ":Actual:\t\t\t\t\n" +
        "'mes2sage'\t\t\t\t\n" +
        ":Differences:\t\t\t\t\t\n" +
        "'2' :1\t\t\t\t\t\n" 
        ,actualResult);
  }
  
  @Override
  public int getTests(I_CountType type) {
    return super.getTests(type, 30, true);
  }

  @Override
  public int getAsserts(I_CountType type) {
    int thisAsserts = 142;
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
    int thisUniqueAsserts = 112;
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
