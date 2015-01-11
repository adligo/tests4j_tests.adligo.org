package org.adligo.tests4j_tests.shared.asserts.uniform;

import org.adligo.tests4j.shared.asserts.common.ExpectedThrownData;
import org.adligo.tests4j.shared.asserts.common.I_ThrownAssertionData;
import org.adligo.tests4j.shared.asserts.common.MatchType;
import org.adligo.tests4j.shared.asserts.reference.AllowedReferences;
import org.adligo.tests4j.shared.asserts.uniform.I_Evaluation;
import org.adligo.tests4j.shared.asserts.uniform.UniformThrownAssertionEvaluatorUse;
import org.adligo.tests4j.shared.en.Tests4J_EnglishConstants;
import org.adligo.tests4j.system.shared.trials.SourceFileScope;
import org.adligo.tests4j.system.shared.trials.Test;
import org.adligo.tests4j_tests.base_trials.I_CountType;
import org.adligo.tests4j_tests.base_trials.SourceFileCountingTrial;
import org.adligo.tests4j_tests.references_groups.Tests4J_Asserts_GwtReferenceGroup;

@SourceFileScope (sourceClass=UniformThrownAssertionEvaluatorUse.class, minCoverage=89.0)
@AllowedReferences (groups=Tests4J_Asserts_GwtReferenceGroup.class)
public class UniformThrownAssertionEvaluatorUseTrial extends SourceFileCountingTrial {

  /**
   * tests all MatchTypes
   */
  @SuppressWarnings("boxing")
  @Test
  public void test01_ConstructorSimpleSuccess() {
    //any
    ExpectedThrownData expected = new ExpectedThrownData(NullPointerException.class);
    Throwable actual = new NullPointerException();
    UniformThrownAssertionEvaluatorUse use = new UniformThrownAssertionEvaluatorUse(expected, actual);
    I_Evaluation<I_ThrownAssertionData> result = use.getResult();
    assertTrue(result.isSuccess());
    assertNull(result.getFailureReason());
    I_ThrownAssertionData data = result.getData();
    assertSame(expected, data.getExpected());
    assertSame(actual, data.getActual());
    assertEquals(0, data.getFailureThrowable());
    assertNull(data.getFailureReason());
   
    expected = new ExpectedThrownData(NullPointerException.class, MatchType.NULL);
    use = new UniformThrownAssertionEvaluatorUse(expected, actual);
    result = use.getResult();
    assertTrue(result.isSuccess());
    assertNull(result.getFailureReason());
    data = result.getData();
    assertSame(expected, data.getExpected());
    assertSame(actual, data.getActual());
    assertEquals(0, data.getFailureThrowable());
    assertNull(data.getFailureReason());
    
    actual = new NullPointerException("hey");
    expected = new ExpectedThrownData(new NullPointerException("hey"));
    use = new UniformThrownAssertionEvaluatorUse(expected, actual);
    result = use.getResult();
    assertTrue(result.isSuccess());
    assertNull(result.getFailureReason());
    data = result.getData();
    assertSame(expected, data.getExpected());
    assertSame(actual, data.getActual());
    assertEquals(0, data.getFailureThrowable());
    assertNull(data.getFailureReason());
  }

  @SuppressWarnings("boxing")
  @Test
  public void test02_ConstructorSimpleFailureClass() {
    ExpectedThrownData expected = new ExpectedThrownData(NullPointerException.class);
    Throwable actual = new IllegalStateException();
    UniformThrownAssertionEvaluatorUse use = new UniformThrownAssertionEvaluatorUse(expected, actual);
    I_Evaluation<I_ThrownAssertionData> result = use.getResult();
    assertFalse(result.isSuccess());
    
    String message = Tests4J_EnglishConstants.ENGLISH.getResultMessages().getThrowableClassMismatch();
    assertEquals(message, result.getFailureReason());
    I_ThrownAssertionData data = result.getData();
    assertSame(expected, data.getExpected());
    assertSame(actual, data.getActual());
    assertEquals(1, data.getFailureThrowable());
    assertEquals(message, 
        data.getFailureReason());
  }
  
  @SuppressWarnings("boxing")
  @Test
  public void test03_ConstructorSimpleFailureMessageNotEquals() {
    ExpectedThrownData expected = new ExpectedThrownData(new NullPointerException("arg"));
    Throwable actual = new NullPointerException("hmm");
    UniformThrownAssertionEvaluatorUse use = new UniformThrownAssertionEvaluatorUse(expected, actual);
    I_Evaluation<I_ThrownAssertionData> result = use.getResult();
    assertFalse(result.isSuccess());
    
    String message = Tests4J_EnglishConstants.ENGLISH.getResultMessages().getThrowableMessageNotUniform();
    assertEquals(message, result.getFailureReason());
    I_ThrownAssertionData data = result.getData();
    assertSame(expected, data.getExpected());
    assertSame(actual, data.getActual());
    assertEquals(1, data.getFailureThrowable());
    assertEquals(message, 
        data.getFailureReason());
  }
  
  @SuppressWarnings("boxing")
  @Test
  public void test04_ConstructorSimpleFailureMessageNotNull() {
    ExpectedThrownData expected = new ExpectedThrownData(NullPointerException.class, MatchType.NULL);
    Throwable actual = new NullPointerException("hmm");
    UniformThrownAssertionEvaluatorUse use = new UniformThrownAssertionEvaluatorUse(expected, actual);
    I_Evaluation<I_ThrownAssertionData> result = use.getResult();
    assertFalse(result.isSuccess());
    
    String message = Tests4J_EnglishConstants.ENGLISH.getResultMessages().getThrowableMessageNotUniform();
    assertEquals(message, result.getFailureReason());
    I_ThrownAssertionData data = result.getData();
    assertSame(expected, data.getExpected());
    assertSame(actual, data.getActual());
    assertEquals(1, data.getFailureThrowable());
    assertEquals(message, 
        data.getFailureReason());
  }
  
  
  @SuppressWarnings("boxing")
  @Test
  public void test05_ConstructorComplexCauseSuccess() {
    //any
    ExpectedThrownData expected = new ExpectedThrownData(NullPointerException.class,
        new ExpectedThrownData(IllegalStateException.class));
    Throwable actual = new NullPointerException();
    Throwable cause = new IllegalStateException();
    actual.initCause(cause);
    
    UniformThrownAssertionEvaluatorUse use = new UniformThrownAssertionEvaluatorUse(expected, actual);
    I_Evaluation<I_ThrownAssertionData> result = use.getResult();
    assertTrue(result.isSuccess());
    assertNull(result.getFailureReason());
    I_ThrownAssertionData data = result.getData();
    assertSame(expected, data.getExpected());
    assertSame(actual, data.getActual());
    assertEquals(0, data.getFailureThrowable());
    assertNull(data.getFailureReason());
   
    expected = new ExpectedThrownData(NullPointerException.class,
        new ExpectedThrownData(IllegalStateException.class, MatchType.NULL));
    use = new UniformThrownAssertionEvaluatorUse(expected, actual);
    result = use.getResult();
    assertTrue(result.isSuccess());
    assertNull(result.getFailureReason());
    data = result.getData();
    assertSame(expected, data.getExpected());
    assertSame(actual, data.getActual());
    assertEquals(0, data.getFailureThrowable());
    assertNull(data.getFailureReason());
    
    actual = new NullPointerException();
    cause = new IllegalStateException("hey");
    actual.initCause(cause);
    
    expected = new ExpectedThrownData(NullPointerException.class,
        new ExpectedThrownData(new IllegalStateException("hey")));
    use = new UniformThrownAssertionEvaluatorUse(expected, actual);
    result = use.getResult();
    assertTrue(result.isSuccess());
    assertNull(result.getFailureReason());
    data = result.getData();
    assertSame(expected, data.getExpected());
    assertSame(actual, data.getActual());
    assertEquals(0, data.getFailureThrowable());
    assertNull(data.getFailureReason());
  }

  @SuppressWarnings("boxing")
  @Test
  public void test06_Constructor_ComplexCauseFailureClass() {
    ExpectedThrownData expected = new ExpectedThrownData(NullPointerException.class,
        new ExpectedThrownData(IllegalStateException.class));
    Throwable actual = new NullPointerException();
    Throwable cause = new NullPointerException();
    actual.initCause(cause);
    
    UniformThrownAssertionEvaluatorUse use = new UniformThrownAssertionEvaluatorUse(expected, actual);
    I_Evaluation<I_ThrownAssertionData> result = use.getResult();
    assertFalse(result.isSuccess());
    
    String message = Tests4J_EnglishConstants.ENGLISH.getResultMessages().getThrowableClassMismatch();
    assertEquals(message, result.getFailureReason());
    I_ThrownAssertionData data = result.getData();
    assertSame(expected, data.getExpected());
    assertSame(actual, data.getActual());
    assertEquals(2, data.getFailureThrowable());
    assertEquals(message, 
        data.getFailureReason());
  }
  
  @SuppressWarnings("boxing")
  @Test
  public void test07_ConstructorComplexCauseFailureMessageNotEquals() {
    ExpectedThrownData expected = new ExpectedThrownData(new NullPointerException("hey"),
        new ExpectedThrownData(new IllegalStateException("...\n..")));
    Throwable actual = new NullPointerException("hey");
    Throwable cause = new IllegalStateException("..");
    actual.initCause(cause);
    
    UniformThrownAssertionEvaluatorUse use = new UniformThrownAssertionEvaluatorUse(expected, actual);
    I_Evaluation<I_ThrownAssertionData> result = use.getResult();
    assertFalse(result.isSuccess());
    
    String message = Tests4J_EnglishConstants.ENGLISH.getResultMessages().getThrowableMessageNotUniform();
    assertEquals(message, result.getFailureReason());
    I_ThrownAssertionData data = result.getData();
    assertSame(expected, data.getExpected());
    assertSame(actual, data.getActual());
    assertEquals(2, data.getFailureThrowable());
    assertEquals(message, 
        data.getFailureReason());
  }
  
  @SuppressWarnings("boxing")
  @Test
  public void test08_ConstructorComplexCauseFailureMessageNotNull() {
    ExpectedThrownData expected = new ExpectedThrownData(new NullPointerException("hey"),
        new ExpectedThrownData(IllegalStateException.class, MatchType.NULL));
    Throwable actual = new NullPointerException("hey");
    Throwable cause = new IllegalStateException("..");
    actual.initCause(cause);
    
    UniformThrownAssertionEvaluatorUse use = new UniformThrownAssertionEvaluatorUse(expected, actual);
    I_Evaluation<I_ThrownAssertionData> result = use.getResult();
    assertFalse(result.isSuccess());
    
    String message = Tests4J_EnglishConstants.ENGLISH.getResultMessages().getThrowableMessageNotUniform();
    assertEquals(message, result.getFailureReason());
    I_ThrownAssertionData data = result.getData();
    assertSame(expected, data.getExpected());
    assertSame(actual, data.getActual());
    assertEquals(2, data.getFailureThrowable());
    assertEquals(message, 
        data.getFailureReason());
  }
  
	@Override
	public int getTests(I_CountType type) {
		return super.getTests(type, 8, true);
	}

	@Override
	public int getAsserts(I_CountType type) {
		int thisAsserts = 72;
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
		int thisUniqueAsserts = 46;
		if (type.isFromMetaWithCoverage()) {
			return super.getUniqueAsserts(type, thisUniqueAsserts + 3);
		}  else {
			return super.getAsserts(type, thisUniqueAsserts);
		}
	}
}
