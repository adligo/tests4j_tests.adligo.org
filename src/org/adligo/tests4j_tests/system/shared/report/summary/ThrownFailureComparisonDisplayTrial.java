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

@SourceFileScope (sourceClass=ThrownFailureComparisonDisplay.class, minCoverage=10.0)
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
    
    logMock_ = mock(I_Tests4J_Log.class);
    doAnswer(logMethod_).when(logMock_).log(any());
    doAnswer(onThrowableMethod_).when(logMock_).onThrowable(any());
    when(logMock_.lineSeparator()).thenReturn("\n");
    display_ = new ThrownFailureComparisonDisplay(constantsMock_, logMock_);
  }
  
  /**
   * testMethodAddDisplayFirstThrowableNullDiff should never occur,
   * as any allows null and any string.
   */
  //public void testMethodAddDisplayFirstThrowableNullDiff()
  
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
	   
	}
	
	@Test
  public void testMethodAddDisplayFirstThrowableContainsDiffRTL() {
     
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
        "\t'message'\n" +
        "\t:Actual:\n" +
        "\tjava.io.IOException\n" +
        "\tnull\n",actualResult);
    
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
        "'message'\t\n" +
        ":Actual:\t\n" +
        "java.io.IOException\t\n" +
        "null\t\n",actualResult);
    
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
  public void testMethodAddDisplaySecondThrowableClassDiff() {
    
  }
	@Test
  public void testMethodAddDisplaySecondThrowableClassDiffRTL() {
    
  }
	
	@Test
  public void testMethodAddDisplaySecondThrowableContainsDiff() {
     
  }
  
  @Test
  public void testMethodAddDisplaySecondThrowableContainsDiffRTL() {
     
  }
  
  @Test
  public void testMethodAddDisplaySecondThrowableEqualsDiff() {
    
  }

  @Test
  public void testMethodAddDisplaySecondThrowableEqualsDiffRTL() {
    
  }
  
  @Test
  public void testMethodAddDisplaySecondThrowableNullDiff() {
    
  }
	 
  @Test
  public void testMethodAddDisplaySecondThrowableNullDiffRTL() {
    
  }
  
  @Test
  public void testMethodAddDisplayThirdThrowableClassDiff() {
    
  }

  @Test
  public void testMethodAddDisplayThirdThrowableClassDiffRTL() {
    
  }
  
  @Test
  public void testMethodAddDisplayThirdThrowableContainsDiff() {
     
  }
  
  @Test
  public void testMethodAddDisplayThirdThrowableContainsDiffRTL() {
     
  }
  
  @Test
  public void testMethodAddDisplayThirdThrowableEqualsDiff() {
    
  }

  @Test
  public void testMethodAddDisplayThirdThrowableEqualsDiffRTL() {
    
  }
  
  @Test
  public void testMethodAddDisplayThirdThrowableNullDiff() {
    
  }
  
  @Test
  public void testMethodAddDisplayThirdThrowableNullDiffRTL() {
    
  }
  
  @Override
  public int getTests(I_CountType type) {
    return super.getTests(type, 24, true);
  }

  @Override
  public int getAsserts(I_CountType type) {
    int thisAsserts = 15;
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
    int thisUniqueAsserts = 14;
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
