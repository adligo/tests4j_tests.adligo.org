package org.adligo.tests4j_tests.system.shared.report.summary;

import org.adligo.tests4j.shared.asserts.reference.AllowedReferences;
import org.adligo.tests4j.shared.i18n.I_Tests4J_AssertionInputMessages;
import org.adligo.tests4j.shared.i18n.I_Tests4J_Constants;
import org.adligo.tests4j.shared.i18n.I_Tests4J_ReportMessages;
import org.adligo.tests4j.shared.output.I_Tests4J_Log;
import org.adligo.tests4j.system.shared.report.summary.TextLineCompareDisplay;
import org.adligo.tests4j.system.shared.trials.AfterTrial;
import org.adligo.tests4j.system.shared.trials.SourceFileScope;
import org.adligo.tests4j.system.shared.trials.Test;
import org.adligo.tests4j_4mockito.MockMethod;
import org.adligo.tests4j_tests.base_trials.I_CountType;
import org.adligo.tests4j_tests.base_trials.SourceFileCountingTrial;
import org.adligo.tests4j_tests.references_groups.Tests4J_Summary_GwtReferenceGroup;

@SourceFileScope (sourceClass=TextLineCompareDisplay.class, minCoverage=84.0)
@AllowedReferences (groups=Tests4J_Summary_GwtReferenceGroup.class)
public class TextLineCompareDisplayTrial extends SourceFileCountingTrial {
  private I_Tests4J_Log logMock_;
  private MockMethod<Void> logRecord_;
  private MockMethod<Void> onThrowableRecord_;
  private I_Tests4J_Constants constantsMock_;
  private I_Tests4J_ReportMessages messageMock_;
	private TextLineCompareDisplay display_;

	@SuppressWarnings("boxing")
  @Override
	public void beforeTests() {
    constantsMock_ = mock(I_Tests4J_Constants.class);
    I_Tests4J_AssertionInputMessages assertionMessages = mock(I_Tests4J_AssertionInputMessages.class);
    when(assertionMessages.getTheActualValueIsNull()).thenReturn("actual is null");
    when(constantsMock_.getAssertionInputMessages()).thenReturn(assertionMessages);
    messageMock_ = mock(I_Tests4J_ReportMessages.class);
    when(constantsMock_.getReportMessages()).thenReturn(messageMock_);
    when(messageMock_.getExpected()).thenReturn(":Expected:");
    when(messageMock_.getActual()).thenReturn(":Actual:");
    when(messageMock_.getDifferences()).thenReturn(":Differences:");
    when(messageMock_.getIndent()).thenReturn("\t");
    when(messageMock_.getTheFollowingExpectedLineNumbersWereMissing()).thenReturn(
        ":The following expected lines are missing:");
    when(messageMock_.getTheFollowingActualLineNumberNotExpected()).thenReturn(
        ":The following actual lines are missing:");
	  logMock_ = mock(I_Tests4J_Log.class);
	  when(logMock_.lineSeparator()).thenReturn("\n");
    logRecord_ = new MockMethod<Void>();
    doAnswer(logRecord_).when(logMock_).log(anyVararg());
    onThrowableRecord_ = new MockMethod<Void>();
    doAnswer(onThrowableRecord_).when(logMock_).onThrowable(any());
    when(logMock_.lineSeparator()).thenReturn("\n");
    
    when(constantsMock_.isLeftToRight()).thenReturn(true);
    display_ = new TextLineCompareDisplay(constantsMock_, logMock_);
	}

	@AfterTrial
	public static void afterTrial() {
	}
	
	@Test
	public void testMethodDisplayStringNulls() {
	  display_.addStringCompare("expected", null);
	  String actual = display_.getDefaultResult();
	  assertEquals("\t:Expected:\n" +
	        "\t'expected'\n" +
	        "\t:Actual:\n" +
	        "\tnull\n", actual);
	  
	}
	 
	 @Test
	  public void testMethodDisplayStringEmptiles() {
	    display_.addStringCompare("", null);
	    String actual = display_.getDefaultResult();
	    assertEquals("\t:Expected:\n" +
	          "\t''\n" +
	          "\t:Actual:\n" +
	          "\tnull\n", actual);
	    
	    display_.addStringCompare("", "");
      actual = display_.getDefaultResult();
      assertEquals("\t:Expected:\n" +
            "\t''\n" +
            "\t:Actual:\n" +
            "\t''\n", actual);
      
      display_.addStringCompare("a", "");
      actual = display_.getDefaultResult();
      assertEquals("\t:Expected:\n" +
            "\t'a'\n" +
            "\t:Actual:\n" +
            "\t''\n", actual);
      
      display_.addStringCompare("", "a");
      actual = display_.getDefaultResult();
      assertEquals("\t:Expected:\n" +
            "\t''\n" +
            "\t:Actual:\n" +
            "\t'a'\n", actual);
	  }
	 
	@SuppressWarnings("boxing")
  @Test
  public void testMethodDisplayStringNullsRTL() {
	  when(constantsMock_.isLeftToRight()).thenReturn(false);
    display_ = new TextLineCompareDisplay(constantsMock_, logMock_);
    display_.addStringCompare("expected", null);
    String actual = display_.getDefaultResult();
    assertEquals(":Expected:\t\n" +
          "'expected'\t\n" +
          ":Actual:\t\n" +
          "null\t\n", actual);
  }
	
  @Test
  public void testMethodDisplaySingleLineString() {
    display_.addStringCompare("expected", "ect");
    String actual = display_.getDefaultResult();
    assertEquals("\t:Expected:\n" +
          "\t'expected'\n" +
          "\t\t:Differences:\n" +
          "\t\t1: 'exp'*'ed'\n" +
          "\t:Actual:\n" +
          "\t'ect'\n" , actual);
    
    display_.addStringCompare("\t", "");
    actual = display_.getDefaultResult();
    assertEquals("\t:Expected:\n" +
          "\t'\t'\n" +
          "\t:Actual:\n" +
          "\t''\n", actual);
    
    display_.addStringCompare("", "\t");
    actual = display_.getDefaultResult();
    assertEquals("\t:Expected:\n" +
          "\t''\n" +
          "\t:Actual:\n" +
          "\t'\t'\n", actual);
    
    display_.addStringCompare("\t", "a");
    actual = display_.getDefaultResult();
    assertEquals("\t:Expected:\n" +
          "\t'\t'\n" +
          "\t:Actual:\n" +
          "\t'a'\n", actual);
    
    display_.addStringCompare("\t", "\ta");
    actual = display_.getDefaultResult();
    assertEquals("\t:Expected:\n" +
          "\t'\t'\n" +
          "\t:Actual:\n" +
          "\t'\ta'\n" +
          "\t\t:Differences:\n" +
          "\t\t1: 'a'\n", actual);
    
    display_.addStringCompare("\t", "a\t");
    actual = display_.getDefaultResult();
    assertEquals("\t:Expected:\n" +
          "\t'\t'\n" +
          "\t:Actual:\n" +
          "\t'a\t'\n" +
          "\t\t:Differences:\n" +
          "\t\t1: 'a'\n", actual);
    
    display_.addStringCompare("a\t", "\t");
    actual = display_.getDefaultResult();
    assertEquals("\t:Expected:\n" +
          "\t'a\t'\n" +
          "\t\t:Differences:\n" +
          "\t\t1: 'a'\n" +
          "\t:Actual:\n" +
          "\t'\t'\n" , actual);
    
    display_.addStringCompare("\ta", "\t");
    actual = display_.getDefaultResult();
    assertEquals("\t:Expected:\n" +
          "\t'\ta'\n" +
          "\t\t:Differences:\n" +
          "\t\t1: 'a'\n" +
          "\t:Actual:\n" +
          "\t'\t'\n" , actual);
  }
	 
  @SuppressWarnings("boxing")
  @Test
  public void testMethodDisplaySingleLineStringRTL() {
    when(constantsMock_.isLeftToRight()).thenReturn(false);
    display_ = new TextLineCompareDisplay(constantsMock_, logMock_);
    
    display_.addStringCompare("expected", "ect");
    String actual = display_.getDefaultResult();
    assertEquals(":Expected:\t\n" +
          "'expected'\t\n" +
          ":Differences:\t\t\n" +
          "'exp'*'ed' :1\t\t\n" +
          ":Actual:\t\n" +
          "'ect'\t\n" , actual);
  }
  
  @Test
  public void testMethodDisplayExpectedLinesMissing() {
    display_.addStringCompare("expected\nlineA\nlineB", "ect");
    String actual = display_.getDefaultResult();
    assertEquals("\t:Expected:\n" +
          "\t1: 'expected'\n" +
          "\t2: 'lineA'\n" +
          "\t3: 'lineB'\n" +
          "\t:The following expected lines are missing:\n" +
          "\t\t2: 'lineA'\n" +
          "\t\t3: 'lineB'\n" +
          "\t:Actual:\n" +
          "\t'ect'\n" , actual);
  }
  
  @SuppressWarnings("boxing")
  @Test
  public void testMethodDisplayExpectedLinesMissingRTL() {
    when(constantsMock_.isLeftToRight()).thenReturn(false);
    display_ = new TextLineCompareDisplay(constantsMock_, logMock_);
    
    display_.addStringCompare("expected\nlineA\nlineB", "ect");
    String actual = display_.getDefaultResult();
    assertEquals(":Expected:\t\n" +
          "'expected' :1\t\n" +
          "'lineA' :2\t\n" +
          "'lineB' :3\t\n" +
          ":The following expected lines are missing:\t\n" +
          "'lineA' :2\t\t\n" +
          "'lineB' :3\t\t\n" +
          ":Actual:\t\n" +
          "'ect'\t\n" , actual);
  }
  
  @Test
  public void testMethodDisplayActualLinesMissing() {
    display_.addStringCompare("ect", "expected\nlineA\nlineB");
    String actual = display_.getDefaultResult();
    assertEquals("\t:Expected:\n" +
          "\t'ect'\n" +
          "\t:Actual:\n" +
          "\t1: 'expected'\n" +
          "\t2: 'lineA'\n" +
          "\t3: 'lineB'\n" +
          "\t:The following actual lines are missing:\n" +
          "\t\t2: 'lineA'\n" +
          "\t\t3: 'lineB'\n", actual);
    
    display_.addStringCompare("expected\nlineA\nlineB\t", "expected\nlineA\nlineB");
    actual = display_.getDefaultResult();
    assertEquals("\t:Expected:\n" +
          "\t1: 'expected'\n" +
          "\t2: 'lineA'\n" +
          "\t3: 'lineB\t'\n" +
          "\t:Actual:\n" +
          "\t1: 'expected'\n" +
          "\t2: 'lineA'\n" +
          "\t3: 'lineB'\n" , actual);
  }
  
  @SuppressWarnings("boxing")
  @Test
  public void testMethodDisplayActualLinesMissingRTL() {
    when(constantsMock_.isLeftToRight()).thenReturn(false);
    display_ = new TextLineCompareDisplay(constantsMock_, logMock_);
    
    display_.addStringCompare("ect", "expected\nlineA\nlineB");
    String actual = display_.getDefaultResult();
    assertEquals(":Expected:\t\n" +
          "'ect'\t\n" +
          ":Actual:\t\n" +
          "'expected' :1\t\n" +
          "'lineA' :2\t\n" +
          "'lineB' :3\t\n" +
          ":The following actual lines are missing:\t\n" +
          "'lineA' :2\t\t\n" +
          "'lineB' :3\t\t\n" 
          , actual);
  }
  
	@Override
	public int getTests(I_CountType type) {
		return super.getTests(type, 9, true);
	}

	@Override
	public int getAsserts(I_CountType type) {
		int thisAsserts = 20;
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
		int thisUniqueAsserts = 20;
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
