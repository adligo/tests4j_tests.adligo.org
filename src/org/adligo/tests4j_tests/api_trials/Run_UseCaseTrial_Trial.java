package org.adligo.tests4j_tests.api_trials;

import java.util.List;

import org.adligo.tests4j.models.shared.ApiTrial;
import org.adligo.tests4j.models.shared.PackageScope;
import org.adligo.tests4j.models.shared.Test;
import org.adligo.tests4j.models.shared.metadata.I_TestMetadata;
import org.adligo.tests4j.models.shared.metadata.I_TrialMetadata;
import org.adligo.tests4j.models.shared.metadata.I_TrialRunMetadata;
import org.adligo.tests4j.models.shared.results.I_TrialFailure;
import org.adligo.tests4j.models.shared.results.I_TrialResult;
import org.adligo.tests4j_tests.api_trials.mock_use_case_trials.AbstractTestTrial;
import org.adligo.tests4j_tests.api_trials.mock_use_case_trials.AfterTrialHasParamsTrial;
import org.adligo.tests4j_tests.api_trials.mock_use_case_trials.AfterTrialNotStaticTrial;
import org.adligo.tests4j_tests.api_trials.mock_use_case_trials.BeforeTrialHasParamsTrial;
import org.adligo.tests4j_tests.api_trials.mock_use_case_trials.BeforeTrialNotStaticTrial;
import org.adligo.tests4j_tests.api_trials.mock_use_case_trials.NoTestsTrial;
import org.adligo.tests4j_tests.api_trials.mock_use_case_trials.ProtectedTestTrial;
import org.adligo.tests4j_tests.api_trials.mock_use_case_trials.StaticTestTrial;
import org.adligo.tests4j_tests.api_trials.mock_use_case_trials.TestWithParamsTrial;
import org.adligo.tests4j_tests.api_trials.mock_use_case_trials.UseCaseBadConstructorTrial;

@PackageScope (packageName = "org.adligo.tests4j")
public class Run_UseCaseTrial_Trial extends ApiTrial {

	@Test
	public void testAbstractTest() {
		ExpectedFailureRunner runner = new ExpectedFailureRunner();
		runner.runExpectedFailure(AbstractTestTrial.class);
		
		I_TrialRunMetadata metadata = runner.getMetadata();
		assertNotNull(metadata);
		List<? extends I_TrialMetadata> trialsMetadata = metadata.getTrials();
		assertNotNull(trialsMetadata);
		assertEquals("java.util.Collections$UnmodifiableRandomAccessList", 
				trialsMetadata.getClass().getName());
		assertEquals(1, trialsMetadata.size());
		I_TrialMetadata trialMeta = trialsMetadata.get(0);
		assertNotNull(trialMeta);
		assertEquals("org.adligo.tests4j_tests.api_trials.mock_use_case_trials.AbstractTestTrial", 
				trialMeta.getTrialName());
		assertEquals(0L, trialMeta.getTimeout());
		assertFalse(trialMeta.isSkipped());
		
		List<? extends I_TestMetadata> testsMetadata = trialMeta.getTests();
		assertNotNull(testsMetadata);
		assertEquals("java.util.Collections$UnmodifiableRandomAccessList", 
				testsMetadata.getClass().getName());
		assertEquals(1, testsMetadata.size());
		
		I_TrialResult result = runner.getResult();
		assertNotNull(result);
		assertFalse(result.isPassed());
		I_TrialFailure failure = result.getFailure();
		assertNotNull(failure);
		assertEquals("Methods Annotated with @Test must NOT be abstract.", failure.getMessage());
		Throwable exception = failure.getException();
		assertUniform(new IllegalArgumentException(
				"org.adligo.tests4j_tests.api_trials.mock_use_case_trials.AbstractTestTrial.testFoo was not annotated correctly."), 
				exception);
	}
	
	@Test
	public void testBadConstructor() {
		ExpectedFailureRunner runner = new ExpectedFailureRunner();
		runner.runExpectedFailure(UseCaseBadConstructorTrial.class);
		
		I_TrialRunMetadata metadata = runner.getMetadata();
		assertNotNull(metadata);
		List<? extends I_TrialMetadata> trialsMetadata = metadata.getTrials();
		assertNotNull(trialsMetadata);
		assertEquals("java.util.Collections$UnmodifiableRandomAccessList", 
				trialsMetadata.getClass().getName());
		assertEquals(1, trialsMetadata.size());
		I_TrialMetadata trialMeta = trialsMetadata.get(0);
		assertNotNull(trialMeta);
		assertEquals("org.adligo.tests4j_tests.api_trials.mock_use_case_trials.UseCaseBadConstructorTrial", 
				trialMeta.getTrialName());
		assertEquals(0L, trialMeta.getTimeout());
		assertFalse(trialMeta.isSkipped());
		
		
		List<? extends I_TestMetadata> testsMetadata = trialMeta.getTests();
		assertNotNull(testsMetadata);
		assertEquals("java.util.Collections$UnmodifiableRandomAccessList", 
				testsMetadata.getClass().getName());
		assertEquals(1, testsMetadata.size());
		I_TestMetadata testMeta = testsMetadata.get(0);
		assertNotNull(testMeta);
		assertEquals("testFoo", testMeta.getTestName());
		assertEquals(0L, testMeta.getTimeout());
		
		I_TrialResult result = runner.getResult();
		assertNotNull(result);
		assertFalse(result.isPassed());
		I_TrialFailure failure = result.getFailure();
		assertNotNull(failure);
		assertEquals("Classes which implement I_AbstractTrial must have a zero argument constructor.", 
				failure.getMessage());
		Throwable exception = failure.getException();
		assertUniform(new NoSuchMethodException(
				"org.adligo.tests4j_tests.api_trials.mock_use_case_trials.UseCaseBadConstructorTrial.<init>()"), 
				exception);
		
	}
	
	@Test
	public void testBeforeTestNotStatic() {
		ExpectedFailureRunner runner = new ExpectedFailureRunner();
		runner.runExpectedFailure(BeforeTrialNotStaticTrial.class);
		

		I_TrialRunMetadata metadata = runner.getMetadata();
		assertNotNull(metadata);
		List<? extends I_TrialMetadata> trialsMetadata = metadata.getTrials();
		assertNotNull(trialsMetadata);
		assertEquals("java.util.Collections$UnmodifiableRandomAccessList", 
				trialsMetadata.getClass().getName());
		assertEquals(1, trialsMetadata.size());
		I_TrialMetadata trialMeta = trialsMetadata.get(0);
		assertNotNull(trialMeta);
		assertEquals("org.adligo.tests4j_tests.api_trials.mock_use_case_trials.BeforeTrialNotStaticTrial", 
				trialMeta.getTrialName());
		assertEquals(0L, trialMeta.getTimeout());
		assertFalse(trialMeta.isSkipped());
		
		
		List<? extends I_TestMetadata> testsMetadata = trialMeta.getTests();
		assertNotNull(testsMetadata);
		assertEquals("java.util.Collections$UnmodifiableRandomAccessList", 
				testsMetadata.getClass().getName());
		assertEquals(1, testsMetadata.size());
		I_TestMetadata testMeta = testsMetadata.get(0);
		assertNotNull(testMeta);
		assertEquals("testFoo", testMeta.getTestName());
		assertEquals(0L, testMeta.getTimeout());
		
		
		I_TrialResult result = runner.getResult();
		assertNotNull(result);
		assertFalse(result.isPassed());
		I_TrialFailure failure = result.getFailure();
		assertNotNull(failure);
		assertEquals("Methods Annotated with @BeforeTrial must be static.", failure.getMessage());
		Throwable exception = failure.getException();
		assertUniform(new IllegalArgumentException(
				"org.adligo.tests4j_tests.api_trials.mock_use_case_trials.BeforeTrialNotStaticTrial was not annotated correctly."), 
				exception);
	}
	
	@Test
	public void testBeforeTestHasParams() {
		ExpectedFailureRunner runner = new ExpectedFailureRunner();
		runner.runExpectedFailure(BeforeTrialHasParamsTrial.class);
		
		I_TrialRunMetadata metadata = runner.getMetadata();
		assertNotNull(metadata);
		List<? extends I_TrialMetadata> trialsMetadata = metadata.getTrials();
		assertNotNull(trialsMetadata);
		assertEquals("java.util.Collections$UnmodifiableRandomAccessList", 
				trialsMetadata.getClass().getName());
		assertEquals(1, trialsMetadata.size());
		I_TrialMetadata trialMeta = trialsMetadata.get(0);
		assertNotNull(trialMeta);
		assertEquals("org.adligo.tests4j_tests.api_trials.mock_use_case_trials.BeforeTrialHasParamsTrial", 
				trialMeta.getTrialName());
		assertEquals(0L, trialMeta.getTimeout());
		assertFalse(trialMeta.isSkipped());
		
		
		List<? extends I_TestMetadata> testsMetadata = trialMeta.getTests();
		assertNotNull(testsMetadata);
		assertEquals("java.util.Collections$UnmodifiableRandomAccessList", 
				testsMetadata.getClass().getName());
		assertEquals(1, testsMetadata.size());
		I_TestMetadata testMeta = testsMetadata.get(0);
		assertNotNull(testMeta);
		assertEquals("testFoo", testMeta.getTestName());
		assertEquals(0L, testMeta.getTimeout());
		
		I_TrialResult result = runner.getResult();
		assertNotNull(result);
		assertFalse(result.isPassed());
		I_TrialFailure failure = result.getFailure();
		assertNotNull(failure);
		assertEquals("Methods Annotated with @BeforeTrial must not take any parameters.", failure.getMessage());
		Throwable exception = failure.getException();
		assertUniform(new IllegalArgumentException(
				"org.adligo.tests4j_tests.api_trials.mock_use_case_trials.BeforeTrialHasParamsTrial was not annotated correctly."), 
				exception);
	}
	
	@Test
	public void testAfterTestNotStatic() {
		ExpectedFailureRunner runner = new ExpectedFailureRunner();
		runner.runExpectedFailure(AfterTrialNotStaticTrial.class);
		
		
		I_TrialRunMetadata metadata = runner.getMetadata();
		assertNotNull(metadata);
		List<? extends I_TrialMetadata> trialsMetadata = metadata.getTrials();
		assertNotNull(trialsMetadata);
		assertEquals("java.util.Collections$UnmodifiableRandomAccessList", 
				trialsMetadata.getClass().getName());
		assertEquals(1, trialsMetadata.size());
		I_TrialMetadata trialMeta = trialsMetadata.get(0);
		assertNotNull(trialMeta);
		assertEquals("org.adligo.tests4j_tests.api_trials.mock_use_case_trials.AfterTrialNotStaticTrial", 
				trialMeta.getTrialName());
		assertEquals(0L, trialMeta.getTimeout());
		assertFalse(trialMeta.isSkipped());
		
		
		List<? extends I_TestMetadata> testsMetadata = trialMeta.getTests();
		assertNotNull(testsMetadata);
		assertEquals("java.util.Collections$UnmodifiableRandomAccessList", 
				testsMetadata.getClass().getName());
		assertEquals(1, testsMetadata.size());
		I_TestMetadata testMeta = testsMetadata.get(0);
		assertNotNull(testMeta);
		assertEquals("testFoo", testMeta.getTestName());
		assertEquals(0L, testMeta.getTimeout());
		
		
		I_TrialResult result = runner.getResult();
		assertNotNull(result);
		assertFalse(result.isPassed());
		I_TrialFailure failure = result.getFailure();
		assertNotNull(failure);
		assertEquals("Methods Annotated with @AfterTrial must be static.", failure.getMessage());
		Throwable exception = failure.getException();
		assertUniform(new IllegalArgumentException(
				"org.adligo.tests4j_tests.api_trials.mock_use_case_trials.AfterTrialNotStaticTrial was not annotated correctly."), 
				exception);
	}
	
	@Test
	public void testAfterTestHasParams() {
		ExpectedFailureRunner runner = new ExpectedFailureRunner();
		runner.runExpectedFailure(AfterTrialHasParamsTrial.class);
		
		
		I_TrialRunMetadata metadata = runner.getMetadata();
		assertNotNull(metadata);
		List<? extends I_TrialMetadata> trialsMetadata = metadata.getTrials();
		assertNotNull(trialsMetadata);
		assertEquals("java.util.Collections$UnmodifiableRandomAccessList", 
				trialsMetadata.getClass().getName());
		assertEquals(1, trialsMetadata.size());
		I_TrialMetadata trialMeta = trialsMetadata.get(0);
		assertNotNull(trialMeta);
		assertEquals("org.adligo.tests4j_tests.api_trials.mock_use_case_trials.AfterTrialHasParamsTrial", 
				trialMeta.getTrialName());
		assertEquals(0L, trialMeta.getTimeout());
		assertFalse(trialMeta.isSkipped());
		
		
		List<? extends I_TestMetadata> testsMetadata = trialMeta.getTests();
		assertNotNull(testsMetadata);
		assertEquals("java.util.Collections$UnmodifiableRandomAccessList", 
				testsMetadata.getClass().getName());
		assertEquals(1, testsMetadata.size());
		I_TestMetadata testMeta = testsMetadata.get(0);
		assertNotNull(testMeta);
		assertEquals("testFoo", testMeta.getTestName());
		assertEquals(0L, testMeta.getTimeout());
		
		
		I_TrialResult result = runner.getResult();
		assertNotNull(result);
		assertFalse(result.isPassed());
		I_TrialFailure failure = result.getFailure();
		assertNotNull(failure);
		assertEquals("Use Case Trial Methods Annotated with @AfterTrial must not take any parameters.", failure.getMessage());
		Throwable exception = failure.getException();
		assertUniform(new IllegalArgumentException(
				"org.adligo.tests4j_tests.api_trials.mock_use_case_trials.AfterTrialHasParamsTrial was not annotated correctly."), 
				exception);
	}
	
	@Test
	public void testtestWithParams() {
		ExpectedFailureRunner runner = new ExpectedFailureRunner();
		runner.runExpectedFailure(TestWithParamsTrial.class);
		I_TrialResult result = runner.getResult();
		assertNotNull(result);
		assertFalse(result.isPassed());
		I_TrialFailure failure = result.getFailure();
		assertNotNull(failure);
		assertEquals("Methods Annotated with @Test must not take any parameters", failure.getMessage());
		Throwable exception = failure.getException();
		assertUniform(new IllegalArgumentException(
				"org.adligo.tests4j_tests.api_trials.mock_use_case_trials.TestWithParamsTrial.testFoo was not annotated correctly."), 
				exception);
	}
	
	
	
	@Test
	public void testNotests() {
		ExpectedFailureRunner runner = new ExpectedFailureRunner();
		runner.runExpectedFailure(NoTestsTrial.class);
		I_TrialResult result = runner.getResult();
		assertNotNull(result);
		assertFalse(result.isPassed());
		I_TrialFailure failure = result.getFailure();
		assertNotNull(failure);
		assertEquals("Trial Classes must have at least one method annotated with @Test.", failure.getMessage());
		Throwable exception = failure.getException();
		assertUniform(new IllegalArgumentException(
				"org.adligo.tests4j_tests.api_trials.mock_use_case_trials.NoTestsTrial was not annotated correctly."), 
				exception);
	}
	
	@Test
	public void testProtectedtest() {
		ExpectedFailureRunner runner = new ExpectedFailureRunner();
		runner.runExpectedFailure(ProtectedTestTrial.class);
		I_TrialResult result = runner.getResult();
		assertNotNull(result);
		assertFalse(result.isPassed());
		I_TrialFailure failure = result.getFailure();
		assertNotNull(failure);
		assertEquals("Trial Classes must have at least one method annotated with @Test.", failure.getMessage());
		Throwable exception = failure.getException();
		assertUniform(new IllegalArgumentException(
				"org.adligo.tests4j_tests.api_trials.mock_use_case_trials.ProtectedTestTrial was not annotated correctly."), 
				exception);
	}
	
	@Test
	public void testStatictest() {
		ExpectedFailureRunner runner = new ExpectedFailureRunner();
		runner.runExpectedFailure(StaticTestTrial.class);
		I_TrialResult result = runner.getResult();
		assertNotNull(result);
		assertFalse(result.isPassed());
		I_TrialFailure failure = result.getFailure();
		assertNotNull(failure);
		assertEquals("Methods Annotated with @Test must NOT be static.", failure.getMessage());
		Throwable exception = failure.getException();
		assertUniform(new IllegalArgumentException(
				"org.adligo.tests4j_tests.api_trials.mock_use_case_trials.StaticTestTrial.testFoo was not annotated correctly."), 
				exception);
	}
	
}
