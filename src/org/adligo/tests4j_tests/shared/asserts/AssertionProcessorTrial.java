package org.adligo.tests4j_tests.shared.asserts;

import org.adligo.tests4j.shared.asserts.AssertionProcessor;
import org.adligo.tests4j.shared.asserts.BooleanAssertCommand;
import org.adligo.tests4j.shared.asserts.ThrownAssertCommand;
import org.adligo.tests4j.shared.asserts.common.AssertType;
import org.adligo.tests4j.shared.asserts.common.ExpectedThrowable;
import org.adligo.tests4j.shared.asserts.common.I_AssertCommand;
import org.adligo.tests4j.shared.asserts.common.I_AssertCompareFailure;
import org.adligo.tests4j.shared.asserts.common.I_AssertListener;
import org.adligo.tests4j.shared.asserts.common.I_AssertThrownFailure;
import org.adligo.tests4j.shared.asserts.common.I_TestFailure;
import org.adligo.tests4j.shared.asserts.common.I_ThrowableInfo;
import org.adligo.tests4j.shared.asserts.common.I_Thrower;
import org.adligo.tests4j.shared.asserts.line_text.TextLines;
import org.adligo.tests4j.shared.asserts.reference.AllowedReferences;
import org.adligo.tests4j.shared.en.Tests4J_EnglishConstants;
import org.adligo.tests4j.system.shared.trials.I_AbstractTrial;
import org.adligo.tests4j.system.shared.trials.SourceFileScope;
import org.adligo.tests4j.system.shared.trials.Test;
import org.adligo.tests4j_tests.base_trials.I_CountType;
import org.adligo.tests4j_tests.base_trials.SourceFileCountingTrial;
import org.adligo.tests4j_tests.references_groups.Tests4J_Asserts_GwtReferenceGroup;

@SourceFileScope (sourceClass=AssertionProcessor.class, minCoverage=80.0)
@AllowedReferences (groups=Tests4J_Asserts_GwtReferenceGroup.class)
public class AssertionProcessorTrial extends SourceFileCountingTrial implements I_AssertListener, I_Thrower {
  private I_AssertCommand lastAssertCommand;
  private I_TestFailure lastTestFailure;
  private RuntimeException throwable;
  
  @Override
  public void beforeTests() {
    lastAssertCommand = null;
    lastTestFailure = null;
    throwable = null;
  }
  
  
  @SuppressWarnings("boxing")
  @Test
  public void testSimple() {
    assertNull(lastAssertCommand);
    assertNull(lastTestFailure);
    BooleanAssertCommand bac = new BooleanAssertCommand(AssertType.AssertTrue, "should be true", 
        true);
    AssertionProcessor.evaluate(this, bac);
    assertSame(bac, lastAssertCommand);
    
    lastAssertCommand = null;
    
    bac = new BooleanAssertCommand(AssertType.AssertTrue, "should be true", 
        false);
    AssertionProcessor.evaluate(this, bac);
    assertNull(lastAssertCommand);
    assertNotNull(lastTestFailure);
    assertEquals("should be true", lastTestFailure.getFailureMessage());
    TextLines lines = new TextLines(lastTestFailure.getFailureDetail(), true);
    assertUniform("org.adligo.tests4j.shared.asserts.AssertionFailureLocation", lines.getLine(0));
    assertUniform("\tat org.adligo.tests4j_tests.shared.asserts."
        + "AssertionProcessorTrial.testSimple(AssertionProcessorTrial.java:54)", lines.getLine(1));
    
    assertTrue(lastTestFailure instanceof I_AssertCompareFailure);
    I_AssertCompareFailure acf = (I_AssertCompareFailure) lastTestFailure;
    assertEquals(AssertType.AssertTrue, acf.getAssertType());
    assertEquals(Boolean.class.getName(),  acf.getExpectedClass());
    assertEquals("true", acf.getExpectedValue());
    assertEquals(Boolean.class.getName(),  acf.getActualClass());
    assertEquals("false", acf.getActualValue());
  }
  
  @SuppressWarnings("boxing")
  @Test
  public void testThrown() {
    assertNull(lastAssertCommand);
    assertNull(lastTestFailure);
    ThrownAssertCommand tac = new ThrownAssertCommand(Tests4J_EnglishConstants.ENGLISH,
        "should be true", 
        new ExpectedThrowable(new RuntimeException("thrown message")));
    throwable = new RuntimeException();
    AssertionProcessor.evaluate(this, tac, this);
    assertNull(lastAssertCommand);
    
    assertNotNull(lastTestFailure);
    assertEquals("should be true", lastTestFailure.getFailureMessage());
    TextLines lines = new TextLines(lastTestFailure.getFailureDetail(), true);
    assertUniform("org.adligo.tests4j.shared.asserts.AssertionFailureLocation",lines.getLine(0));
    assertUniform("\tat org.adligo.tests4j_tests.shared.asserts."
        + "AssertionProcessorTrial.testThrown(AssertionProcessorTrial.java:81)",lines.getLine(1));
    
    assertEquals(AssertType.AssertThrown, lastTestFailure.getAssertType());
    assertTrue(lastTestFailure instanceof I_AssertThrownFailure);
    I_AssertThrownFailure acf = (I_AssertThrownFailure) lastTestFailure;
    
    assertEquals(1, acf.getThrowable());
    
    I_ThrowableInfo expected = acf.getExpected();
    assertNotNull(expected);
    assertEquals("java.lang.RuntimeException",expected.getClassName());
    assertEquals("thrown message",expected.getMessage());
    assertNull(expected.getStacktrace());
    assertNull(expected.getCause());
    
    I_ThrowableInfo actual = acf.getActual();
    assertNotNull(actual);
    assertEquals("java.lang.RuntimeException",actual.getClassName());
    assertNull(actual.getMessage());
    String stack = actual.getStacktrace();
    assertNotNull(stack);
    lines = new TextLines(stack);
    assertEquals("java.lang.RuntimeException", lines.getLine(0));
    assertEquals("\tat org.adligo.tests4j_tests.shared.asserts."
        + "AssertionProcessorTrial.testThrown("
        + "AssertionProcessorTrial.java:80)", lines.getLine(1));
    assertNull(actual.getCause());
    
    
    lastTestFailure = null;
    throwable = new RuntimeException("thrown message");
    
    AssertionProcessor.evaluate(this, tac, this);
    assertNotNull(lastAssertCommand);
    assertSame(tac, lastAssertCommand);
    assertNull(lastTestFailure);
  }

  
  @Override
  public void assertCompleted(I_AssertCommand cmd) {
    lastAssertCommand = cmd;
  }

  @Override
  public void assertFailed(I_TestFailure failure) {
    lastTestFailure = failure;
  }


  @Override
  public void run() {
    if (throwable != null) {
      throw throwable;
    }
  }

  @Override
  public int getTests(I_CountType type) {
    return super.getTests(type, 2, true);
  }

  @Override
  public int getAsserts(I_CountType type) {
    int thisAsserts = 39;
    if (type.isFromMetaWithCoverage()) {
      //code coverage and circular dependencies +
      //custom afterTrialTests
      return super.getAsserts(type, thisAsserts + 3);
    } else {
      return super.getAsserts(type, thisAsserts);
    }
  }

  @Override
  public int getUniqueAsserts(I_CountType type) {
    int thisUniqueAsserts = 25;
    if (type.isFromMetaWithCoverage()) {
      //code coverage and circular dependencies +
      //custom afterTrialTests
      return super.getUniqueAsserts(type, thisUniqueAsserts + 3);
    }  else {
      return super.getAsserts(type, thisUniqueAsserts);
    }
  }


  @Override
  public I_AbstractTrial getTrialInstance() {
    return null;
  }
  
}
