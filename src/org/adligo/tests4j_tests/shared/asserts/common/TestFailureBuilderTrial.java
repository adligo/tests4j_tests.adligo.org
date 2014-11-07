package org.adligo.tests4j_tests.shared.asserts.common;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.adligo.tests4j.shared.asserts.BooleanAssertCommand;
import org.adligo.tests4j.shared.asserts.ContainsAssertCommand;
import org.adligo.tests4j.shared.asserts.DoubleAssertCommand;
import org.adligo.tests4j.shared.asserts.IdenticalAssertCommand;
import org.adligo.tests4j.shared.asserts.ThrownAssertCommand;
import org.adligo.tests4j.shared.asserts.UniformAssertCommand;
import org.adligo.tests4j.shared.asserts.UniformThrownAssertCommand;
import org.adligo.tests4j.shared.asserts.common.AssertCompareFailureMutant;
import org.adligo.tests4j.shared.asserts.common.AssertThrownFailureMutant;
import org.adligo.tests4j.shared.asserts.common.AssertType;
import org.adligo.tests4j.shared.asserts.common.CompareAssertionData;
import org.adligo.tests4j.shared.asserts.common.ExpectedThrownData;
import org.adligo.tests4j.shared.asserts.common.I_AssertionData;
import org.adligo.tests4j.shared.asserts.common.I_ExpectedThrownData;
import org.adligo.tests4j.shared.asserts.common.I_ThrowableInfo;
import org.adligo.tests4j.shared.asserts.common.I_Thrower;
import org.adligo.tests4j.shared.asserts.common.I_ThrownAssertionData;
import org.adligo.tests4j.shared.asserts.common.TestFailureBuilder;
import org.adligo.tests4j.shared.asserts.common.TestFailureMutant;
import org.adligo.tests4j.shared.asserts.reference.AllowedReferences;
import org.adligo.tests4j.shared.asserts.uniform.I_Evaluation;
import org.adligo.tests4j.shared.asserts.uniform.I_UniformAssertionEvaluator;
import org.adligo.tests4j.shared.asserts.uniform.I_UniformThrownAssertionEvaluator;
import org.adligo.tests4j.system.shared.trials.SourceFileScope;
import org.adligo.tests4j.system.shared.trials.Test;
import org.adligo.tests4j_tests.base_trials.I_CountType;
import org.adligo.tests4j_tests.base_trials.SourceFileCountingTrial;
import org.adligo.tests4j_tests.references_groups.Tests4J_AssertsCommon_GwtReferenceGroup;

import java.util.Collections;

/**
 * Just to be safe
 * there should be a test in this trial for each assert type
 * @author scott
 *
 * note the following assertion types were ommited since
 * they don't use the TestFailureBuilder;
 * AssertType.AssertCircularDependency;
 * AssertType.AssertReferences;
 */
@SourceFileScope (sourceClass=TestFailureBuilder.class,minCoverage=95.0)
@AllowedReferences (groups=Tests4J_AssertsCommon_GwtReferenceGroup.class)
public class TestFailureBuilderTrial extends SourceFileCountingTrial {
  TestFailureBuilder builder_ = new TestFailureBuilder();
  
  
  @Test
  public void testBuildContains() {
    ContainsAssertCommand bac = new ContainsAssertCommand(
        "hey", Collections.singleton("FailureMessage"), "true");
    TestFailureMutant  tfm = builder_.build(bac, "buildFailureMessage");
    
    assertTrue(tfm instanceof AssertCompareFailureMutant);
    AssertCompareFailureMutant acfm = (AssertCompareFailureMutant) tfm;
    
    assertEquals(AssertType.AssertContains, acfm.getAssertType());
    assertEquals("buildFailureMessage", acfm.getFailureMessage());
    assertEquals(String.class.getName(), acfm.getExpectedClass());
    assertEquals("true", acfm.getExpectedValue());
    assertNull(acfm.getActualClass());
    assertNull(acfm.getActualValue());
    
    
    bac = new ContainsAssertCommand(
        "hey", Collections.singleton("FailureMessage"), "FailureMessage");
    tfm = builder_.build(bac, "buildFailureMessage");
    
    assertTrue(tfm instanceof AssertCompareFailureMutant);
    acfm = (AssertCompareFailureMutant) tfm;
    
    assertEquals(AssertType.AssertContains, acfm.getAssertType());
    assertEquals("buildFailureMessage", acfm.getFailureMessage());
    assertEquals(String.class.getName(), acfm.getExpectedClass());
    assertEquals("FailureMessage", acfm.getExpectedValue());
    assertNull(acfm.getActualClass());
    assertNull(acfm.getActualValue());
  }
  
  @Test
  public void testBuildEquals() {
    AssertType type = AssertType.AssertEquals;
    IdenticalAssertCommand iac = new IdenticalAssertCommand("failureMessage",
        new CompareAssertionData<String>("false", "true", type));
    
    assertDefault(type, iac.getData());
  }
  
  @Test
  public void testBuildError() {
    TestFailureMutant  tfm = builder_.build(null, "buildFailureMessage");
    assertNotNull(tfm);
    assertEquals("buildFailureMessage", tfm.getFailureMessage());
    
    I_AssertionData assMock = mock(I_AssertionData.class);
    when(assMock.getType()).thenReturn(null);
    tfm = builder_.build(assMock, "buildFailureMessage");
    assertNotNull(tfm);
    assertEquals("buildFailureMessage", tfm.getFailureMessage());
    
  }
  
  @SuppressWarnings("boxing")
  @Test
  public void testBuildGreaterThanOrEquals() {
    DoubleAssertCommand dac = new DoubleAssertCommand("failureMessage", 
        new CompareAssertionData<Double>(1.2,1.3, AssertType.AssertGreaterThanOrEquals));
    TestFailureMutant  tfm = builder_.build(dac.getData(), "buildFailureMessage");
    
    assertTrue(tfm instanceof AssertCompareFailureMutant);
    AssertCompareFailureMutant acfm = (AssertCompareFailureMutant) tfm;
    
    assertEquals(AssertType.AssertGreaterThanOrEquals, acfm.getAssertType());
    assertEquals("buildFailureMessage", acfm.getFailureMessage());
    assertEquals(Double.class.getName(), acfm.getExpectedClass());
    assertEquals("1.2", acfm.getExpectedValue());
    assertEquals(Double.class.getName(), acfm.getActualClass());
    assertEquals("1.3", acfm.getActualValue());
  }
  
  @Test
  public void testBuildNotEquals() {
    AssertType type = AssertType.AssertNotEquals;
    IdenticalAssertCommand iac = new IdenticalAssertCommand("failureMessage",
        new CompareAssertionData<String>("false", "true", type));
    
    assertDefault(type, iac.getData());
  }
  
  @Test
  public void testBuildNotNull() {
    BooleanAssertCommand bac = new BooleanAssertCommand(
        AssertType.AssertNotNull, "FailureMessage", "true");
    TestFailureMutant  tfm = builder_.build(bac, "buildFailureMessage");
    
    assertTrue(tfm instanceof AssertCompareFailureMutant);
    AssertCompareFailureMutant acfm = (AssertCompareFailureMutant) tfm;
    
    assertEquals(AssertType.AssertNotNull, acfm.getAssertType());
    assertEquals("buildFailureMessage", acfm.getFailureMessage());
    assertEquals(String.class.getName(), acfm.getExpectedClass());
    assertEquals("", acfm.getExpectedValue());
    assertEquals(String.class.getName(), acfm.getActualClass());
    assertEquals("true", acfm.getActualValue());
    
    
    bac = new BooleanAssertCommand(
        AssertType.AssertNotNull, "FailureMessage", null);
    tfm = builder_.build(bac, "buildFailureMessage");
    
    assertTrue(tfm instanceof AssertCompareFailureMutant);
    acfm = (AssertCompareFailureMutant) tfm;
    
    assertEquals(AssertType.AssertNotNull, acfm.getAssertType());
    assertEquals("buildFailureMessage", acfm.getFailureMessage());
    assertEquals(String.class.getName(), acfm.getExpectedClass());
    assertEquals("", acfm.getExpectedValue());
    assertNull(acfm.getActualClass());
    assertNull(acfm.getActualValue());
  }
  
  @Test
  public void testBuildNotSame() {
    AssertType type = AssertType.AssertNotSame;
    IdenticalAssertCommand iac = new IdenticalAssertCommand("failureMessage",
        new CompareAssertionData<String>("false", "true", type));
    
    assertDefault(type, iac.getData());
  }
  
  @SuppressWarnings("unchecked")
  @Test
  public void testBuildNotUniform() {
    AssertType type = AssertType.AssertNotUniform;
    I_UniformAssertionEvaluator<String, String> uae = mock(I_UniformAssertionEvaluator.class);
    
    UniformAssertCommand<String, String> iac = new UniformAssertCommand<String, String>("failureMessage",
        new CompareAssertionData<String>("false", "true", type), uae);
    
    assertDefault(type, iac.getData());
  }
  
  @Test
  public void testBuildNull() {
    BooleanAssertCommand bac = new BooleanAssertCommand(
        AssertType.AssertNull, "FailureMessage", "true");
    TestFailureMutant  tfm = builder_.build(bac, "buildFailureMessage");
    
    assertTrue(tfm instanceof AssertCompareFailureMutant);
    AssertCompareFailureMutant acfm = (AssertCompareFailureMutant) tfm;
    
    assertEquals(AssertType.AssertNull, acfm.getAssertType());
    assertEquals("buildFailureMessage", acfm.getFailureMessage());
    assertNull(acfm.getExpectedClass());
    assertNull(acfm.getExpectedValue());
    assertEquals(String.class.getName(), acfm.getActualClass());
    assertEquals("true", acfm.getActualValue());
    
    
    bac = new BooleanAssertCommand(
        AssertType.AssertNull, "FailureMessage", "test");
    tfm = builder_.build(bac, "buildFailureMessage");
    
    assertTrue(tfm instanceof AssertCompareFailureMutant);
    acfm = (AssertCompareFailureMutant) tfm;
    
    assertEquals(AssertType.AssertNull, acfm.getAssertType());
    assertEquals("buildFailureMessage", acfm.getFailureMessage());
    assertNull(acfm.getExpectedClass());
    assertNull(acfm.getExpectedValue());
    assertEquals(String.class.getName(), acfm.getActualClass());
    assertEquals("test", acfm.getActualValue());
  }
  
  @Test
  public void testBuildSame() {
    AssertType type = AssertType.AssertSame;
    IdenticalAssertCommand iac = new IdenticalAssertCommand("failureMessage",
        new CompareAssertionData<String>("false", "true", type));
    
    assertDefault(type, iac.getData());
  }
  
  @Test
  public void testBuildThrown() {
    ThrownAssertCommand bac = new ThrownAssertCommand(
        "FailureMessage", new ExpectedThrownData(NullPointerException.class));
    TestFailureMutant  tfm = builder_.build(bac.getData(), "buildFailureMessage");
    
    assertTrue(tfm instanceof AssertThrownFailureMutant);
    AssertThrownFailureMutant acfm = (AssertThrownFailureMutant) tfm;
    
    assertEquals(AssertType.AssertThrown, acfm.getAssertType());
    assertEquals("buildFailureMessage", acfm.getFailureMessage());
    I_ThrowableInfo expectedInfo = acfm.expected;
    assertEquals(NullPointerException.class.getName(),  expectedInfo.getClassName());
    I_ThrowableInfo actualInfo = acfm.getActual();
    assertNull(actualInfo);
  }
  
  @SuppressWarnings({"rawtypes", "unchecked"})
  @Test
  public void testBuildThrownUniform() throws Throwable {
    I_UniformThrownAssertionEvaluator evalator = mock(I_UniformThrownAssertionEvaluator.class);
    UniformThrownAssertCommand bac = new UniformThrownAssertCommand(
        "FailureMessage", new ExpectedThrownData(NullPointerException.class),
        evalator);
    I_Evaluation<I_ThrownAssertionData> eval = mock(I_Evaluation.class);
    I_ThrownAssertionData data = mock(I_ThrownAssertionData.class);
    when(eval.getData()).thenReturn(data);
    when(data.getType()).thenReturn(AssertType.AssertThrownUniform);
    
    ExpectedThrownData expected = new ExpectedThrownData(NullPointerException.class);
    when(data.getExpected()).thenReturn(expected);
    Throwable actual = new Throwable();
    when(data.getActual()).thenReturn(actual);
    when(eval.getFailureReason()).thenReturn("failureReason");
    when(evalator.isUniform(any(I_ExpectedThrownData.class), any(Throwable.class))).thenReturn(eval);
    I_Thrower thrower = mock(I_Thrower.class);
    doThrow(new IllegalStateException("test")).when(thrower).run();
    bac.evaluate(thrower);
    
    TestFailureMutant tfm = builder_.build(bac.getData(), "buildFailureMessage");
    
    assertTrue(tfm instanceof AssertThrownFailureMutant);
    AssertThrownFailureMutant acfm = (AssertThrownFailureMutant) tfm;
    
    assertEquals(AssertType.AssertThrownUniform, acfm.getAssertType());
    assertEquals("buildFailureMessage", acfm.getFailureMessage());
    I_ThrowableInfo expectedInfo = acfm.expected;
    assertEquals(NullPointerException.class.getName(),  expectedInfo.getClassName());
    I_ThrowableInfo actualInfo = acfm.getActual();
    assertEquals(Throwable.class.getName(), actualInfo.getClassName());
  }
  
  @SuppressWarnings("unchecked")
  @Test
  public void testBuildUniform() {
    AssertType type = AssertType.AssertUniform;
    I_UniformAssertionEvaluator<String, String> uae = mock(I_UniformAssertionEvaluator.class);
    
    UniformAssertCommand<String, String> iac = new UniformAssertCommand<String, String>("failureMessage",
        new CompareAssertionData<String>("false", "true", type), uae);
    
    assertDefault(type, iac.getData());
  }
  
  
  private void assertDefault(AssertType type, I_AssertionData a) {
    TestFailureMutant  tfm = builder_.build(a, "buildFailureMessage");
    
    assertTrue(tfm instanceof AssertCompareFailureMutant);
    AssertCompareFailureMutant acfm = (AssertCompareFailureMutant) tfm;
    
    assertEquals(type, acfm.getAssertType());
    assertEquals("buildFailureMessage", acfm.getFailureMessage());
    assertEquals(String.class.getName(), acfm.getExpectedClass());
    assertEquals("false", acfm.getExpectedValue());
    assertEquals(String.class.getName(), acfm.getActualClass());
    assertEquals("true", acfm.getActualValue());
    
    
  }
  
  @SuppressWarnings("boxing")
  @Test
  public void testBuildTrue() {
    BooleanAssertCommand bac = new BooleanAssertCommand(
        AssertType.AssertFalse, "FailureMessage", true);
    TestFailureMutant  tfm = builder_.build(bac, "buildFailureMessage");
    
    assertTrue(tfm instanceof AssertCompareFailureMutant);
    AssertCompareFailureMutant acfm = (AssertCompareFailureMutant) tfm;
    
    assertEquals(AssertType.AssertFalse, acfm.getAssertType());
    assertEquals("buildFailureMessage", acfm.getFailureMessage());
    assertEquals(Boolean.class.getName(), acfm.getExpectedClass());
    assertEquals("false", acfm.getExpectedValue());
    assertEquals(Boolean.class.getName(), acfm.getActualClass());
    assertEquals("true", acfm.getActualValue());
    
    
    bac = new BooleanAssertCommand(
        AssertType.AssertFalse, "FailureMessage", false);
    tfm = builder_.build(bac, "buildFailureMessage");
    
    assertTrue(tfm instanceof AssertCompareFailureMutant);
    acfm = (AssertCompareFailureMutant) tfm;
    
    assertEquals(AssertType.AssertFalse, acfm.getAssertType());
    assertEquals("buildFailureMessage", acfm.getFailureMessage());
    assertEquals(Boolean.class.getName(), acfm.getExpectedClass());
    assertEquals("false", acfm.getExpectedValue());
    assertEquals(Boolean.class.getName(), acfm.getActualClass());
    assertEquals("false", acfm.getActualValue());
  }
  
  @SuppressWarnings("boxing")
  @Test
  public void testBuildFalse() {
    BooleanAssertCommand bac = new BooleanAssertCommand(
        AssertType.AssertTrue, "FailureMessage", false);
    TestFailureMutant tfm = builder_.build(bac, "buildFailureMessage");
    assertTrue(tfm instanceof AssertCompareFailureMutant);
    AssertCompareFailureMutant acfm = (AssertCompareFailureMutant) tfm;
    
    assertEquals(AssertType.AssertTrue, acfm.getAssertType());
    assertEquals("buildFailureMessage", acfm.getFailureMessage());
    assertEquals(Boolean.class.getName(), acfm.getExpectedClass());
    assertEquals("true", acfm.getExpectedValue());
    assertEquals(Boolean.class.getName(), acfm.getActualClass());
    assertEquals("false", acfm.getActualValue());
    
    bac = new BooleanAssertCommand(
        AssertType.AssertTrue, "FailureMessage", true);
    tfm = builder_.build(bac, "buildFailureMessage");
    assertTrue(tfm instanceof AssertCompareFailureMutant);
    acfm = (AssertCompareFailureMutant) tfm;
    
    assertEquals(AssertType.AssertTrue, acfm.getAssertType());
    assertEquals("buildFailureMessage", acfm.getFailureMessage());
    assertEquals(Boolean.class.getName(), acfm.getExpectedClass());
    assertEquals("true", acfm.getExpectedValue());
    assertEquals(Boolean.class.getName(), acfm.getActualClass());
    assertEquals("true", acfm.getActualValue());
  }
  
	@Override
	public int getTests(I_CountType type) {
		return super.getTests(type, 15, true);
	}
	@Override
	public int getAsserts(I_CountType type) {
	  int asserts = 133;
		if (type.isFromMetaWithCoverage()) {
			//code coverage and circular dependencies
			return super.getAsserts(type,asserts +3);
		} else {
			return super.getAsserts(type, asserts);
		}
	}

	@Override
	public int getUniqueAsserts(I_CountType type) {
	  int uasserts = 88;
		if (type.isFromMetaWithCoverage()) {
			return super.getUniqueAsserts(type, uasserts + 3);
		} else {
			return super.getUniqueAsserts(type, uasserts);
		}
	}

}
