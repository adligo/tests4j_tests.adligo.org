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
import org.adligo.tests4j_tests.api_trials.mock_use_case_trials.AfterTrialNotPublicTrial;
import org.adligo.tests4j_tests.api_trials.mock_use_case_trials.AfterTrialNotStaticTrial;
import org.adligo.tests4j_tests.api_trials.mock_use_case_trials.AfterTrialTestsTrial;
import org.adligo.tests4j_tests.api_trials.mock_use_case_trials.BadConstructorTrial;
import org.adligo.tests4j_tests.api_trials.mock_use_case_trials.BeforeTrialHasParamsTrial;
import org.adligo.tests4j_tests.api_trials.mock_use_case_trials.BeforeTrialNotPublicTrial;
import org.adligo.tests4j_tests.api_trials.mock_use_case_trials.BeforeTrialNotStaticTrial;
import org.adligo.tests4j_tests.api_trials.mock_use_case_trials.MultipleAfterTrialTrial;
import org.adligo.tests4j_tests.api_trials.mock_use_case_trials.MultipleBeforeTrialTrial;
import org.adligo.tests4j_tests.api_trials.mock_use_case_trials.NoTestsTrial;
import org.adligo.tests4j_tests.api_trials.mock_use_case_trials.NoUseCaseAnnotationTrial;
import org.adligo.tests4j_tests.api_trials.mock_use_case_trials.ProtectedTestTrial;
import org.adligo.tests4j_tests.api_trials.mock_use_case_trials.StaticTestTrial;
import org.adligo.tests4j_tests.api_trials.mock_use_case_trials.TestWithParamsTrial;
import org.adligo.tests4j_tests.api_trials.mock_use_case_trials.UseCaseAnnotationNoNownTrial;
import org.adligo.tests4j_tests.api_trials.mock_use_case_trials.UseCaseAnnotationNoSystemTrial;
import org.adligo.tests4j_tests.api_trials.mock_use_case_trials.UseCaseAnnotationNoVerbTrial;

@PackageScope (packageName = "org.adligo.tests4j")
public class Run_UseCaseTrial_Trial extends ApiTrial {

	@Test
	public void testNoUseCaseAnnotation() {
		ExpectedFailureRunner runner = new ExpectedFailureRunner();
		runner.runExpectedFailure(NoUseCaseAnnotationTrial.class);
		

		I_TrialRunMetadata metadata = runner.getMetadata();
		assertNotNull(metadata);
		List<? extends I_TrialMetadata> trialsMetadata = metadata.getTrials();
		assertNotNull(trialsMetadata);
		assertEquals("java.util.Collections$UnmodifiableRandomAccessList", 
				trialsMetadata.getClass().getName());
		assertEquals(1, trialsMetadata.size());
		I_TrialMetadata trialMeta = trialsMetadata.get(0);
		assertNotNull(trialMeta);
		assertEquals("org.adligo.tests4j_tests.api_trials.mock_use_case_trials.NoUseCaseAnnotationTrial", 
				trialMeta.getTrialName());
		assertEquals(0L, trialMeta.getTimeout());
		assertFalse(trialMeta.isSkipped());
		
		
		List<? extends I_TestMetadata> testsMetadata = trialMeta.getTests();
		assertNotNull(testsMetadata);
		assertEquals("java.util.Collections$UnmodifiableRandomAccessList", 
				testsMetadata.getClass().getName());
		assertEquals(0, testsMetadata.size());
		
		
		I_TrialResult result = runner.getResult();
		assertNotNull(result);
		assertFalse(result.isPassed());
		I_TrialFailure failure = result.getFailure();
		assertNotNull(failure);
		assertEquals("UseCaseTrials must be annotated with @UseCaseScope.", failure.getMessage());
		Throwable exception = failure.getException();
		assertUniform(new IllegalArgumentException(
				"org.adligo.tests4j_tests.api_trials.mock_use_case_trials.NoUseCaseAnnotationTrial was not annotated correctly."), 
				exception);
	}
	
	@Test
	public void testUseCaseAnnotationNoSystem() {
		ExpectedFailureRunner runner = new ExpectedFailureRunner();
		runner.runExpectedFailure(UseCaseAnnotationNoSystemTrial.class);
		

		I_TrialRunMetadata metadata = runner.getMetadata();
		assertNotNull(metadata);
		List<? extends I_TrialMetadata> trialsMetadata = metadata.getTrials();
		assertNotNull(trialsMetadata);
		assertEquals("java.util.Collections$UnmodifiableRandomAccessList", 
				trialsMetadata.getClass().getName());
		assertEquals(1, trialsMetadata.size());
		I_TrialMetadata trialMeta = trialsMetadata.get(0);
		assertNotNull(trialMeta);
		assertEquals("org.adligo.tests4j_tests.api_trials.mock_use_case_trials.UseCaseAnnotationNoSystemTrial", 
				trialMeta.getTrialName());
		assertEquals(0L, trialMeta.getTimeout());
		assertFalse(trialMeta.isSkipped());
		
		
		List<? extends I_TestMetadata> testsMetadata = trialMeta.getTests();
		assertNotNull(testsMetadata);
		assertEquals("java.util.Collections$UnmodifiableRandomAccessList", 
				testsMetadata.getClass().getName());
		assertEquals(0, testsMetadata.size());
		
		
		I_TrialResult result = runner.getResult();
		assertNotNull(result);
		assertFalse(result.isPassed());
		I_TrialFailure failure = result.getFailure();
		assertNotNull(failure);
		assertEquals("@UseCaseScope annotations must contain a non empty system.", failure.getMessage());
		Throwable exception = failure.getException();
		assertUniform(new IllegalArgumentException(
				"org.adligo.tests4j_tests.api_trials.mock_use_case_trials.UseCaseAnnotationNoSystemTrial was not annotated correctly."), 
				exception);
	}
	
	@Test
	public void testUseCaseAnnotationNoNown() {
		ExpectedFailureRunner runner = new ExpectedFailureRunner();
		runner.runExpectedFailure(UseCaseAnnotationNoNownTrial.class);
		

		I_TrialRunMetadata metadata = runner.getMetadata();
		assertNotNull(metadata);
		List<? extends I_TrialMetadata> trialsMetadata = metadata.getTrials();
		assertNotNull(trialsMetadata);
		assertEquals("java.util.Collections$UnmodifiableRandomAccessList", 
				trialsMetadata.getClass().getName());
		assertEquals(1, trialsMetadata.size());
		I_TrialMetadata trialMeta = trialsMetadata.get(0);
		assertNotNull(trialMeta);
		assertEquals("org.adligo.tests4j_tests.api_trials.mock_use_case_trials.UseCaseAnnotationNoNownTrial", 
				trialMeta.getTrialName());
		assertEquals(0L, trialMeta.getTimeout());
		assertFalse(trialMeta.isSkipped());
		
		
		List<? extends I_TestMetadata> testsMetadata = trialMeta.getTests();
		assertNotNull(testsMetadata);
		assertEquals("java.util.Collections$UnmodifiableRandomAccessList", 
				testsMetadata.getClass().getName());
		assertEquals(0, testsMetadata.size());
		
		
		I_TrialResult result = runner.getResult();
		assertNotNull(result);
		assertFalse(result.isPassed());
		I_TrialFailure failure = result.getFailure();
		assertNotNull(failure);
		assertEquals("@UseCaseScope annotations must contain a non empty nown.", failure.getMessage());
		Throwable exception = failure.getException();
		assertUniform(new IllegalArgumentException(
				"org.adligo.tests4j_tests.api_trials.mock_use_case_trials.UseCaseAnnotationNoNownTrial was not annotated correctly."), 
				exception);
	}
	
	
	@Test
	public void testUseCaseAnnotationNoVerb() {
		ExpectedFailureRunner runner = new ExpectedFailureRunner();
		runner.runExpectedFailure(UseCaseAnnotationNoVerbTrial.class);
		

		I_TrialRunMetadata metadata = runner.getMetadata();
		assertNotNull(metadata);
		List<? extends I_TrialMetadata> trialsMetadata = metadata.getTrials();
		assertNotNull(trialsMetadata);
		assertEquals("java.util.Collections$UnmodifiableRandomAccessList", 
				trialsMetadata.getClass().getName());
		assertEquals(1, trialsMetadata.size());
		I_TrialMetadata trialMeta = trialsMetadata.get(0);
		assertNotNull(trialMeta);
		assertEquals("org.adligo.tests4j_tests.api_trials.mock_use_case_trials.UseCaseAnnotationNoVerbTrial", 
				trialMeta.getTrialName());
		assertEquals(0L, trialMeta.getTimeout());
		assertFalse(trialMeta.isSkipped());
		
		
		List<? extends I_TestMetadata> testsMetadata = trialMeta.getTests();
		assertNotNull(testsMetadata);
		assertEquals("java.util.Collections$UnmodifiableRandomAccessList", 
				testsMetadata.getClass().getName());
		assertEquals(0, testsMetadata.size());
		
		
		I_TrialResult result = runner.getResult();
		assertNotNull(result);
		assertFalse(result.isPassed());
		I_TrialFailure failure = result.getFailure();
		assertNotNull(failure);
		assertEquals("@UseCaseScope annotations must contain a non empty verb.", failure.getMessage());
		Throwable exception = failure.getException();
		assertUniform(new IllegalArgumentException(
				"org.adligo.tests4j_tests.api_trials.mock_use_case_trials.UseCaseAnnotationNoVerbTrial was not annotated correctly."), 
				exception);
	}
	@Test
	public void testBeforeTrialNotStatic() {
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
	public void testBeforeTrialHasParams() {
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
		assertEquals("Methods Annotated with @BeforeTrial must NOT take any parameters.", failure.getMessage());
		Throwable exception = failure.getException();
		assertUniform(new IllegalArgumentException(
				"org.adligo.tests4j_tests.api_trials.mock_use_case_trials.BeforeTrialHasParamsTrial was not annotated correctly."), 
				exception);
	}
	
	@Test
	public void testBeforeTrialNotPublic() {
		ExpectedFailureRunner runner = new ExpectedFailureRunner();
		runner.runExpectedFailure(BeforeTrialNotPublicTrial.class);
		
		I_TrialRunMetadata metadata = runner.getMetadata();
		assertNotNull(metadata);
		List<? extends I_TrialMetadata> trialsMetadata = metadata.getTrials();
		assertNotNull(trialsMetadata);
		assertEquals("java.util.Collections$UnmodifiableRandomAccessList", 
				trialsMetadata.getClass().getName());
		assertEquals(1, trialsMetadata.size());
		I_TrialMetadata trialMeta = trialsMetadata.get(0);
		assertNotNull(trialMeta);
		assertEquals("org.adligo.tests4j_tests.api_trials.mock_use_case_trials.BeforeTrialNotPublicTrial", 
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
		assertEquals("testNada", testMeta.getTestName());
		assertEquals(0L, testMeta.getTimeout());
		
		I_TrialResult result = runner.getResult();
		assertNotNull(result);
		assertFalse(result.isPassed());
		I_TrialFailure failure = result.getFailure();
		assertNotNull(failure);
		assertEquals("Methods Annotated with @BeforeTrial must be public.", failure.getMessage());
		Throwable exception = failure.getException();
		assertUniform(new IllegalArgumentException(
				"org.adligo.tests4j_tests.api_trials.mock_use_case_trials.BeforeTrialNotPublicTrial was not annotated correctly."), 
				exception);
	}
	
	@Test
	public void testMultipleBeforeTrial() {
		ExpectedFailureRunner runner = new ExpectedFailureRunner();
		runner.runExpectedFailure(MultipleBeforeTrialTrial.class);
		
		I_TrialRunMetadata metadata = runner.getMetadata();
		assertNotNull(metadata);
		List<? extends I_TrialMetadata> trialsMetadata = metadata.getTrials();
		assertNotNull(trialsMetadata);
		assertEquals("java.util.Collections$UnmodifiableRandomAccessList", 
				trialsMetadata.getClass().getName());
		assertEquals(1, trialsMetadata.size());
		I_TrialMetadata trialMeta = trialsMetadata.get(0);
		assertNotNull(trialMeta);
		assertEquals("org.adligo.tests4j_tests.api_trials.mock_use_case_trials.MultipleBeforeTrialTrial", 
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
		assertEquals("Trials may only have one method annotated with @BeforeTrial.", failure.getMessage());
		Throwable exception = failure.getException();
		assertUniform(new IllegalArgumentException(
				"org.adligo.tests4j_tests.api_trials.mock_use_case_trials.MultipleBeforeTrialTrial was not annotated correctly."), 
				exception);
	}
	
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
		runner.runExpectedFailure(BadConstructorTrial.class);
		
		I_TrialRunMetadata metadata = runner.getMetadata();
		assertNotNull(metadata);
		List<? extends I_TrialMetadata> trialsMetadata = metadata.getTrials();
		assertNotNull(trialsMetadata);
		assertEquals("java.util.Collections$UnmodifiableRandomAccessList", 
				trialsMetadata.getClass().getName());
		assertEquals(1, trialsMetadata.size());
		I_TrialMetadata trialMeta = trialsMetadata.get(0);
		assertNotNull(trialMeta);
		assertEquals("org.adligo.tests4j_tests.api_trials.mock_use_case_trials.BadConstructorTrial", 
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
				"org.adligo.tests4j_tests.api_trials.mock_use_case_trials.BadConstructorTrial.<init>()"), 
				exception);
		
	}
	
	@Test
	public void testTestWithParams() {
		ExpectedFailureRunner runner = new ExpectedFailureRunner();
		runner.runExpectedFailure(TestWithParamsTrial.class);
		
		I_TrialRunMetadata metadata = runner.getMetadata();
		assertNotNull(metadata);
		List<? extends I_TrialMetadata> trialsMetadata = metadata.getTrials();
		assertNotNull(trialsMetadata);
		assertEquals("java.util.Collections$UnmodifiableRandomAccessList", 
				trialsMetadata.getClass().getName());
		assertEquals(1, trialsMetadata.size());
		I_TrialMetadata trialMeta = trialsMetadata.get(0);
		assertNotNull(trialMeta);
		assertEquals("org.adligo.tests4j_tests.api_trials.mock_use_case_trials.TestWithParamsTrial", 
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
		assertEquals("Methods Annotated with @Test must not take any parameters", failure.getMessage());
		Throwable exception = failure.getException();
		assertUniform(new IllegalArgumentException(
				"org.adligo.tests4j_tests.api_trials.mock_use_case_trials.TestWithParamsTrial.testFoo was not annotated correctly."), 
				exception);
	}
	
	
	
	@Test
	public void testNoTests() {
		ExpectedFailureRunner runner = new ExpectedFailureRunner();
		runner.runExpectedFailure(NoTestsTrial.class);
		I_TrialResult result = runner.getResult();
		
		I_TrialRunMetadata metadata = runner.getMetadata();
		assertNotNull(metadata);
		List<? extends I_TrialMetadata> trialsMetadata = metadata.getTrials();
		assertNotNull(trialsMetadata);
		assertEquals("java.util.Collections$UnmodifiableRandomAccessList", 
				trialsMetadata.getClass().getName());
		assertEquals(1, trialsMetadata.size());
		I_TrialMetadata trialMeta = trialsMetadata.get(0);
		assertNotNull(trialMeta);
		assertEquals("org.adligo.tests4j_tests.api_trials.mock_use_case_trials.NoTestsTrial", 
				trialMeta.getTrialName());
		assertEquals(0L, trialMeta.getTimeout());
		assertFalse(trialMeta.isSkipped());
		
		
		List<? extends I_TestMetadata> testsMetadata = trialMeta.getTests();
		assertNotNull(testsMetadata);
		assertEquals("java.util.Collections$UnmodifiableRandomAccessList", 
				testsMetadata.getClass().getName());
		assertEquals(0, testsMetadata.size());
		
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
	public void testProtectedTest() {
		ExpectedFailureRunner runner = new ExpectedFailureRunner();
		runner.runExpectedFailure(ProtectedTestTrial.class);
		
		I_TrialRunMetadata metadata = runner.getMetadata();
		assertNotNull(metadata);
		List<? extends I_TrialMetadata> trialsMetadata = metadata.getTrials();
		assertNotNull(trialsMetadata);
		assertEquals("java.util.Collections$UnmodifiableRandomAccessList", 
				trialsMetadata.getClass().getName());
		assertEquals(1, trialsMetadata.size());
		I_TrialMetadata trialMeta = trialsMetadata.get(0);
		assertNotNull(trialMeta);
		assertEquals("org.adligo.tests4j_tests.api_trials.mock_use_case_trials.ProtectedTestTrial", 
				trialMeta.getTrialName());
		assertEquals(0L, trialMeta.getTimeout());
		assertFalse(trialMeta.isSkipped());
		
		I_TrialResult result = runner.getResult();
		assertNotNull(result);
		assertFalse(result.isPassed());
		I_TrialFailure failure = result.getFailure();
		assertNotNull(failure);
		assertEquals("Methods Annotated with @Test must be public.", failure.getMessage());
		Throwable exception = failure.getException();
		assertUniform(new IllegalArgumentException(
				"org.adligo.tests4j_tests.api_trials.mock_use_case_trials.ProtectedTestTrial.testFoo was not annotated correctly."), 
				exception);
	}
	
	@Test
	public void testStaticTest() {
		ExpectedFailureRunner runner = new ExpectedFailureRunner();
		runner.runExpectedFailure(StaticTestTrial.class);
		
		I_TrialRunMetadata metadata = runner.getMetadata();
		assertNotNull(metadata);
		List<? extends I_TrialMetadata> trialsMetadata = metadata.getTrials();
		assertNotNull(trialsMetadata);
		assertEquals("java.util.Collections$UnmodifiableRandomAccessList", 
				trialsMetadata.getClass().getName());
		assertEquals(1, trialsMetadata.size());
		I_TrialMetadata trialMeta = trialsMetadata.get(0);
		assertNotNull(trialMeta);
		assertEquals("org.adligo.tests4j_tests.api_trials.mock_use_case_trials.StaticTestTrial", 
				trialMeta.getTrialName());
		assertEquals(0L, trialMeta.getTimeout());
		assertFalse(trialMeta.isSkipped());
		
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
	
	@Test
	public void testHasAfterTrialTests() {
		ExpectedFailureRunner runner = new ExpectedFailureRunner();
		runner.runExpectedFailure(AfterTrialTestsTrial.class);
		
		
		I_TrialRunMetadata metadata = runner.getMetadata();
		assertNotNull(metadata);
		List<? extends I_TrialMetadata> trialsMetadata = metadata.getTrials();
		assertNotNull(trialsMetadata);
		assertEquals("java.util.Collections$UnmodifiableRandomAccessList", 
				trialsMetadata.getClass().getName());
		assertEquals(1, trialsMetadata.size());
		I_TrialMetadata trialMeta = trialsMetadata.get(0);
		assertNotNull(trialMeta);
		assertEquals("org.adligo.tests4j_tests.api_trials.mock_use_case_trials.AfterTrialTestsTrial", 
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
		assertEquals("Use Case Trial Methods may not be Annotated with @AfterTrialTests.", failure.getMessage());
		Throwable exception = failure.getException();
		assertUniform(new IllegalArgumentException(
				"org.adligo.tests4j_tests.api_trials.mock_use_case_trials.AfterTrialTestsTrial was not annotated correctly."), 
				exception);
	}
	
	@Test
	public void testAfterTrialNotStatic() {
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
	public void testAfterTrialNotPublic() {
		ExpectedFailureRunner runner = new ExpectedFailureRunner();
		runner.runExpectedFailure(AfterTrialNotPublicTrial.class);
		
		
		I_TrialRunMetadata metadata = runner.getMetadata();
		assertNotNull(metadata);
		List<? extends I_TrialMetadata> trialsMetadata = metadata.getTrials();
		assertNotNull(trialsMetadata);
		assertEquals("java.util.Collections$UnmodifiableRandomAccessList", 
				trialsMetadata.getClass().getName());
		assertEquals(1, trialsMetadata.size());
		I_TrialMetadata trialMeta = trialsMetadata.get(0);
		assertNotNull(trialMeta);
		assertEquals("org.adligo.tests4j_tests.api_trials.mock_use_case_trials.AfterTrialNotPublicTrial", 
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
		assertEquals("Methods Annotated with @AfterTrial must be public.", failure.getMessage());
		Throwable exception = failure.getException();
		assertUniform(new IllegalArgumentException(
				"org.adligo.tests4j_tests.api_trials.mock_use_case_trials.AfterTrialNotPublicTrial was not annotated correctly."), 
				exception);
	}
	@Test
	public void testAfterTrialHasParams() {
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
		assertEquals("Methods Annotated with @AfterTrial must NOT take any parameters.", failure.getMessage());
		Throwable exception = failure.getException();
		assertUniform(new IllegalArgumentException(
				"org.adligo.tests4j_tests.api_trials.mock_use_case_trials.AfterTrialHasParamsTrial was not annotated correctly."), 
				exception);
	}
	
	@Test
	public void testMultipleAfterTrial() {
		ExpectedFailureRunner runner = new ExpectedFailureRunner();
		runner.runExpectedFailure(MultipleAfterTrialTrial.class);
		
		
		I_TrialRunMetadata metadata = runner.getMetadata();
		assertNotNull(metadata);
		List<? extends I_TrialMetadata> trialsMetadata = metadata.getTrials();
		assertNotNull(trialsMetadata);
		assertEquals("java.util.Collections$UnmodifiableRandomAccessList", 
				trialsMetadata.getClass().getName());
		assertEquals(1, trialsMetadata.size());
		I_TrialMetadata trialMeta = trialsMetadata.get(0);
		assertNotNull(trialMeta);
		assertEquals("org.adligo.tests4j_tests.api_trials.mock_use_case_trials.MultipleAfterTrialTrial", 
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
		assertEquals("Trials may only have one method annotated with @AfterTrial.", failure.getMessage());
		Throwable exception = failure.getException();
		assertUniform(new IllegalArgumentException(
				"org.adligo.tests4j_tests.api_trials.mock_use_case_trials.MultipleAfterTrialTrial was not annotated correctly."), 
				exception);
	}
}
