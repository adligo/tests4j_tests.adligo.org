package org.adligo.tests4j_tests.system.shared.report.summary;

import org.adligo.tests4j.shared.asserts.reference.AllowedReferences;
import org.adligo.tests4j.shared.i18n.I_Tests4J_Constants;
import org.adligo.tests4j.shared.i18n.I_Tests4J_ReportMessages;
import org.adligo.tests4j.shared.output.I_Tests4J_Log;
import org.adligo.tests4j.system.shared.report.summary.TextDataDisplay;
import org.adligo.tests4j.system.shared.trials.SourceFileScope;
import org.adligo.tests4j.system.shared.trials.Test;
import org.adligo.tests4j_4mockito.MockMethod;
import org.adligo.tests4j_tests.base_trials.I_CountType;
import org.adligo.tests4j_tests.base_trials.SourceFileCountingTrial;
import org.adligo.tests4j_tests.references_groups.Tests4J_Summary_GwtReferenceGroup;

@SourceFileScope (sourceClass=TextDataDisplay.class, minCoverage=80.0)
@AllowedReferences (groups=Tests4J_Summary_GwtReferenceGroup.class)
public class TextDataDisplayTrial extends SourceFileCountingTrial {
  private I_Tests4J_Log logMock_;
  private MockMethod<Void> logMethod_ = new MockMethod<Void>();
  private MockMethod<Void> onThrowableMethod_  = new MockMethod<Void>();
  private I_Tests4J_Constants constantsMock_;
  private I_Tests4J_ReportMessages messageMock_;
	private TextDataDisplay display_;
	
  @SuppressWarnings("boxing")
  public void beforeTests() {
    constantsMock_ = mock(I_Tests4J_Constants.class);
    when(constantsMock_.isLeftToRight()).thenReturn(true);
    messageMock_ = mock(I_Tests4J_ReportMessages.class);
    when(constantsMock_.getReportMessages()).thenReturn(messageMock_);
    when(messageMock_.getIndent()).thenReturn("\t");
    
    logMock_ = mock(I_Tests4J_Log.class);
    doAnswer(logMethod_).when(logMock_).log(any());
    doAnswer(onThrowableMethod_).when(logMock_).onThrowable(any());
    when(logMock_.lineSeparator()).thenReturn("\n");
    display_ = new TextDataDisplay(constantsMock_, logMock_);
  }
  
	@Test
	public void testMethodDisplaySingleLine() {
	  StringBuilder sb = new StringBuilder();
	  display_.display(sb, "text", "indent ");
	  String actual = sb.toString();
	  assertEquals("indent 'text'\n", actual);
	  
	  sb = new StringBuilder();
	  display_.display(sb, null, "indent ");
	  actual = sb.toString();
    assertEquals("indent null\n", actual);
    
    sb = new StringBuilder();
    display_.display(sb, "", "indent ");
    actual = sb.toString();
    assertEquals("indent ''\n", actual);
	}
	
	@SuppressWarnings("boxing")
  @Test
  public void testMethodDisplaySingleLineRTL() {
	  when(constantsMock_.isLeftToRight()).thenReturn(false);
    StringBuilder sb = new StringBuilder();
    display_.display(sb, "text", " indent");
    String actual = sb.toString();
    assertEquals("'text' indent\n", actual);
    
    sb = new StringBuilder();
    display_.display(sb, null, " indent");
    assertEquals("null indent\n", sb.toString());
    
    sb = new StringBuilder();
    display_.display(sb, "", " indent");
    actual = sb.toString();
    assertEquals("'' indent\n", actual);
  }
	
	@Test
  public void testMethodDisplaySingleLineDefaultIndent() {
	  StringBuilder sb = new StringBuilder();
    display_.display(sb, "text");
    assertEquals("\t'text'\n", sb.toString());
    
    sb = new StringBuilder();
    display_.display(sb, null);
    assertEquals("\tnull\n", sb.toString());
  }

	@SuppressWarnings("boxing")
	@Test
	public void testMethodDisplaySingleLineDefaultIndentRTL() {
	  when(constantsMock_.isLeftToRight()).thenReturn(false);
    StringBuilder sb = new StringBuilder();
    display_.display(sb, "text");
    assertEquals("'text'\t\n", sb.toString());
    
    sb = new StringBuilder();
    display_.display(sb, null);
    assertEquals("null\t\n", sb.toString());
  }
	 
	@Test
  public void testMethodDisplayMultipleLines() {
	  StringBuilder sb = new StringBuilder();
    display_.display(sb, "a\nb\nc", "indent ");
    String actual = sb.toString();
    assertEquals("indent 1: 'a'\n" +
        "indent 2: 'b'\n" +
        "indent 3: 'c'\n", actual);
  }
  
	
	@SuppressWarnings("boxing")
  @Test
  public void testMethodDisplayMultipleLinesRTL() {
	  when(constantsMock_.isLeftToRight()).thenReturn(false);
    StringBuilder sb = new StringBuilder();
    display_.display(sb, "a\nb\nc", " indent");
    String actual = sb.toString();
    assertEquals("'a' :1 indent\n" +
        "'b' :2 indent\n" +
        "'c' :3 indent\n", actual);
  }
	
  @Test
  public void testMethodDisplayMultipleLinesDefaultIndent() {
    StringBuilder sb = new StringBuilder();
    display_.display(sb, "a\nb\nc");
    String actual = sb.toString();
    assertEquals("\t1: 'a'\n" +
        "\t2: 'b'\n" +
        "\t3: 'c'\n", actual);
  }
  
  @SuppressWarnings("boxing")
  @Test
  public void testMethodDisplayMultipleLinesDefaultIndentRTL() {
    when(constantsMock_.isLeftToRight()).thenReturn(false);
    StringBuilder sb = new StringBuilder();
    display_.display(sb, "a\nb\nc");
    String actual = sb.toString();
    assertEquals("'a' :1\t\n" +
        "'b' :2\t\n" +
        "'c' :3\t\n", actual);
  }
  
  @Override
  public int getTests(I_CountType type) {
    return super.getTests(type, 8, true);
  }

  @Override
  public int getAsserts(I_CountType type) {
    int thisAsserts = 14;
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
