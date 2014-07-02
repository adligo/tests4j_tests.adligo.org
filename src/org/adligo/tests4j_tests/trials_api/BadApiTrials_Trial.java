package org.adligo.tests4j_tests.trials_api;

import java.util.ArrayList;
import java.util.List;

import org.adligo.tests4j.models.shared.metadata.I_TestMetadata;
import org.adligo.tests4j.models.shared.metadata.I_TrialMetadata;
import org.adligo.tests4j.models.shared.metadata.I_TrialRunMetadata;
import org.adligo.tests4j.models.shared.results.I_TrialFailure;
import org.adligo.tests4j.models.shared.results.I_TrialResult;
import org.adligo.tests4j.models.shared.trials.ApiTrial;
import org.adligo.tests4j.models.shared.trials.I_Trial;
import org.adligo.tests4j.models.shared.trials.PackageScope;
import org.adligo.tests4j.models.shared.trials.Test;
import org.adligo.tests4j_tests.trials_api.bad_mock_api_trials.AbstractTestTrial;
import org.adligo.tests4j_tests.trials_api.bad_mock_api_trials.AfterTrialHasParamsTrial;
import org.adligo.tests4j_tests.trials_api.bad_mock_api_trials.AfterTrialNotPublicTrial;
import org.adligo.tests4j_tests.trials_api.bad_mock_api_trials.AfterTrialNotStaticTrial;
import org.adligo.tests4j_tests.trials_api.bad_mock_api_trials.BadPackageConstructorTrial;
import org.adligo.tests4j_tests.trials_api.bad_mock_api_trials.BeforeTrialHasParamsTrial;
import org.adligo.tests4j_tests.trials_api.bad_mock_api_trials.BeforeTrialNotPublicTrial;
import org.adligo.tests4j_tests.trials_api.bad_mock_api_trials.BeforeTrialNotStaticTrial;
import org.adligo.tests4j_tests.trials_api.bad_mock_api_trials.MultipleAfterTrialTrial;
import org.adligo.tests4j_tests.trials_api.bad_mock_api_trials.MultipleBeforeTrialTrial;
import org.adligo.tests4j_tests.trials_api.bad_mock_api_trials.NoPackageScopeAnnotationTrial;
import org.adligo.tests4j_tests.trials_api.bad_mock_api_trials.NoTestsTrial;
import org.adligo.tests4j_tests.trials_api.bad_mock_api_trials.PackageScopeAnnotationNoNameTrial;
import org.adligo.tests4j_tests.trials_api.bad_mock_api_trials.ProtectedTestTrial;
import org.adligo.tests4j_tests.trials_api.bad_mock_api_trials.SimpleRerunTrial;
import org.adligo.tests4j_tests.trials_api.bad_mock_api_trials.StaticTestTrial;
import org.adligo.tests4j_tests.trials_api.bad_mock_api_trials.TestWithParamsTrial;

@PackageScope (packageName = "org.adligo.tests4j")
public class BadApiTrials_Trial extends ApiTrial {

	@Test
	public void testPackageTestWithBadConstructor() {
		ExpectedFailureRunner runner = new ExpectedFailureRunner();
		runner.run(BadPackageConstructorTrial.class);
		
		I_TrialRunMetadata metadata = runner.getMetadata();
		assertNotNull(metadata);
		List<? extends I_TrialMetadata> trialsMetadata = metadata.getAllTrialMetadata();
		assertNotNull(trialsMetadata);
		assertEquals("java.util.Collections$UnmodifiableRandomAccessList", 
				trialsMetadata.getClass().getName());
		assertEquals(1, trialsMetadata.size());
		I_TrialMetadata trialMeta = trialsMetadata.get(0);
		assertNotNull(trialMeta);
		assertEquals("org.adligo.tests4j_tests.trials_api.bad_mock_api_trials.BadPackageConstructorTrial", 
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
		assertEquals("exhibitB", testMeta.getTestName());
		assertEquals(0L, testMeta.getTimeout());
		
		List<I_TrialResult> results = runner.getResults();
		assertEquals(1, results.size());
		I_TrialResult result = results.get(0);
		assertNotNull(result);
		assertFalse(result.isPassed());
		I_TrialFailure failure = result.getFailure();
		assertNotNull(failure);
		assertEquals("Classes which implement I_AbstractTrial must have a zero argument constructor.", failure.getMessage());
		Throwable exception = failure.getException();
		assertUniform(new NoSuchMethodException(
				"org.adligo.tests4j_tests.trials_api.bad_mock_api_trials.BadPackageConstructorTrial.<init>()"), 
				exception);
	}
	
	@Test
	public void testPackageTestWithNoScopeAnnotation() {
		ExpectedFailureRunner runner = new ExpectedFailureRunner();
		runner.run(NoPackageScopeAnnotationTrial.class);
		
		I_TrialRunMetadata metadata = runner.getMetadata();
		assertNotNull(metadata);
		List<? extends I_TrialMetadata> trialsMetadata = metadata.getAllTrialMetadata();
		assertNotNull(trialsMetadata);
		assertEquals("java.util.Collections$UnmodifiableRandomAccessList", 
				trialsMetadata.getClass().getName());
		assertEquals(1, trialsMetadata.size());
		I_TrialMetadata trialMeta = trialsMetadata.get(0);
		assertNotNull(trialMeta);
		assertEquals("org.adligo.tests4j_tests.trials_api.bad_mock_api_trials.NoPackageScopeAnnotationTrial", 
				trialMeta.getTrialName());
		assertEquals(0L, trialMeta.getTimeout());
		assertFalse(trialMeta.isSkipped());
		
		List<? extends I_TestMetadata> testsMetadata = trialMeta.getTests();
		assertNotNull(testsMetadata);
		assertEquals("java.util.Collections$UnmodifiableRandomAccessList", 
				testsMetadata.getClass().getName());
		assertEquals(0, testsMetadata.size());
		
		List<I_TrialResult> results = runner.getResults();
		assertEquals(1, results.size());
		I_TrialResult result = results.get(0);
		assertNotNull(result);
		assertFalse(result.isPassed());
		I_TrialFailure failure = result.getFailure();
		assertNotNull(failure);
		assertEquals("ApiTrials must be annotated with a @PackageScope annotation.", failure.getMessage());
		Throwable exception = failure.getException();
		assertUniform(new IllegalArgumentException(
				"org.adligo.tests4j_tests.trials_api.bad_mock_api_trials.NoPackageScopeAnnotationTrial was not annotated correctly."), 
				exception);
	}
	
	@Test
	public void testPackageScopeNoNameAnnotation() {
		ExpectedFailureRunner runner = new ExpectedFailureRunner();
		runner.run(PackageScopeAnnotationNoNameTrial.class);
		
		I_TrialRunMetadata metadata = runner.getMetadata();
		assertNotNull(metadata);
		List<? extends I_TrialMetadata> trialsMetadata = metadata.getAllTrialMetadata();
		assertNotNull(trialsMetadata);
		assertEquals("java.util.Collections$UnmodifiableRandomAccessList", 
				trialsMetadata.getClass().getName());
		assertEquals(1, trialsMetadata.size());
		I_TrialMetadata trialMeta = trialsMetadata.get(0);
		assertNotNull(trialMeta);
		assertEquals("org.adligo.tests4j_tests.trials_api.bad_mock_api_trials.PackageScopeAnnotationNoNameTrial", 
				trialMeta.getTrialName());
		assertEquals(0L, trialMeta.getTimeout());
		assertFalse(trialMeta.isSkipped());
		
		List<? extends I_TestMetadata> testsMetadata = trialMeta.getTests();
		assertNotNull(testsMetadata);
		assertEquals("java.util.Collections$UnmodifiableRandomAccessList", 
				testsMetadata.getClass().getName());
		assertEquals(0, testsMetadata.size());
		
		List<I_TrialResult> results = runner.getResults();
		assertEquals(1, results.size());
		I_TrialResult result = results.get(0);
		assertNotNull(result);
		assertFalse(result.isPassed());
		I_TrialFailure failure = result.getFailure();
		assertNotNull(failure);
		assertEquals("@PackageScope annotations must contain a non empty packageName.", failure.getMessage());
		Throwable exception = failure.getException();
		assertUniform(new IllegalArgumentException(
				"org.adligo.tests4j_tests.trials_api.bad_mock_api_trials.PackageScopeAnnotationNoNameTrial was not annotated correctly."), 
				exception);
	}
	
	@Test
	public void testBeforeTrialNotStatic() {
		ExpectedFailureRunner runner = new ExpectedFailureRunner();
		runner.run(BeforeTrialNotStaticTrial.class);
		

		I_TrialRunMetadata metadata = runner.getMetadata();
		assertNotNull(metadata);
		List<? extends I_TrialMetadata> trialsMetadata = metadata.getAllTrialMetadata();
		assertNotNull(trialsMetadata);
		assertEquals("java.util.Collections$UnmodifiableRandomAccessList", 
				trialsMetadata.getClass().getName());
		assertEquals(1, trialsMetadata.size());
		I_TrialMetadata trialMeta = trialsMetadata.get(0);
		assertNotNull(trialMeta);
		assertEquals("org.adligo.tests4j_tests.trials_api.bad_mock_api_trials.BeforeTrialNotStaticTrial", 
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
		
		
		List<I_TrialResult> results = runner.getResults();
		assertEquals(1, results.size());
		I_TrialResult result = results.get(0);
		assertNotNull(result);
		assertFalse(result.isPassed());
		I_TrialFailure failure = result.getFailure();
		assertNotNull(failure);
		assertEquals("Methods Annotated with @BeforeTrial must be static.", failure.getMessage());
		Throwable exception = failure.getException();
		assertUniform(new IllegalArgumentException(
				"org.adligo.tests4j_tests.trials_api.bad_mock_api_trials.BeforeTrialNotStaticTrial was not annotated correctly."), 
				exception);
	}
	
	@Test
	public void testBeforeTrialHasParams() {
		ExpectedFailureRunner runner = new ExpectedFailureRunner();
		runner.run(BeforeTrialHasParamsTrial.class);
		
		I_TrialRunMetadata metadata = runner.getMetadata();
		assertNotNull(metadata);
		List<? extends I_TrialMetadata> trialsMetadata = metadata.getAllTrialMetadata();
		assertNotNull(trialsMetadata);
		assertEquals("java.util.Collections$UnmodifiableRandomAccessList", 
				trialsMetadata.getClass().getName());
		assertEquals(1, trialsMetadata.size());
		I_TrialMetadata trialMeta = trialsMetadata.get(0);
		assertNotNull(trialMeta);
		assertEquals("org.adligo.tests4j_tests.trials_api.bad_mock_api_trials.BeforeTrialHasParamsTrial", 
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
		
		List<I_TrialResult> results = runner.getResults();
		assertEquals(1, results.size());
		I_TrialResult result = results.get(0);
		assertNotNull(result);
		assertFalse(result.isPassed());
		I_TrialFailure failure = result.getFailure();
		assertNotNull(failure);
		assertEquals("Methods Annotated with @BeforeTrial must NOT take any parameters.", failure.getMessage());
		Throwable exception = failure.getException();
		assertUniform(new IllegalArgumentException(
				"org.adligo.tests4j_tests.trials_api.bad_mock_api_trials.BeforeTrialHasParamsTrial was not annotated correctly."), 
				exception);
	}
	
	@Test
	public void testBeforeTrialNotPublic() {
		ExpectedFailureRunner runner = new ExpectedFailureRunner();
		runner.run(BeforeTrialNotPublicTrial.class);
		
		I_TrialRunMetadata metadata = runner.getMetadata();
		assertNotNull(metadata);
		List<? extends I_TrialMetadata> trialsMetadata = metadata.getAllTrialMetadata();
		assertNotNull(trialsMetadata);
		assertEquals("java.util.Collections$UnmodifiableRandomAccessList", 
				trialsMetadata.getClass().getName());
		assertEquals(1, trialsMetadata.size());
		I_TrialMetadata trialMeta = trialsMetadata.get(0);
		assertNotNull(trialMeta);
		assertEquals("org.adligo.tests4j_tests.trials_api.bad_mock_api_trials.BeforeTrialNotPublicTrial", 
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
		
		List<I_TrialResult> results = runner.getResults();
		assertEquals(1, results.size());
		I_TrialResult result = results.get(0);
		assertNotNull(result);
		assertFalse(result.isPassed());
		I_TrialFailure failure = result.getFailure();
		assertNotNull(failure);
		assertEquals("Methods Annotated with @BeforeTrial must be public.", failure.getMessage());
		Throwable exception = failure.getException();
		assertUniform(new IllegalArgumentException(
				"org.adligo.tests4j_tests.trials_api.bad_mock_api_trials.BeforeTrialNotPublicTrial was not annotated correctly."), 
				exception);
	}
	
	@Test
	public void testMultipleBeforeTrial() {
		ExpectedFailureRunner runner = new ExpectedFailureRunner();
		runner.run(MultipleBeforeTrialTrial.class);
		
		I_TrialRunMetadata metadata = runner.getMetadata();
		assertNotNull(metadata);
		List<? extends I_TrialMetadata> trialsMetadata = metadata.getAllTrialMetadata();
		assertNotNull(trialsMetadata);
		assertEquals("java.util.Collections$UnmodifiableRandomAccessList", 
				trialsMetadata.getClass().getName());
		assertEquals(1, trialsMetadata.size());
		I_TrialMetadata trialMeta = trialsMetadata.get(0);
		assertNotNull(trialMeta);
		assertEquals("org.adligo.tests4j_tests.trials_api.bad_mock_api_trials.MultipleBeforeTrialTrial", 
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
		
		List<I_TrialResult> results = runner.getResults();
		assertEquals(1, results.size());
		I_TrialResult result = results.get(0);
		assertNotNull(result);
		assertFalse(result.isPassed());
		I_TrialFailure failure = result.getFailure();
		assertNotNull(failure);
		assertEquals("Trials may only have one method annotated with @BeforeTrial.", failure.getMessage());
		Throwable exception = failure.getException();
		assertUniform(new IllegalArgumentException(
				"org.adligo.tests4j_tests.trials_api.bad_mock_api_trials.MultipleBeforeTrialTrial was not annotated correctly."), 
				exception);
	}
	
	@Test
	public void testAbstractTest() {
		ExpectedFailureRunner runner = new ExpectedFailureRunner();
		runner.run(AbstractTestTrial.class);
		
		I_TrialRunMetadata metadata = runner.getMetadata();
		assertNotNull(metadata);
		List<? extends I_TrialMetadata> trialsMetadata = metadata.getAllTrialMetadata();
		assertNotNull(trialsMetadata);
		assertEquals("java.util.Collections$UnmodifiableRandomAccessList", 
				trialsMetadata.getClass().getName());
		assertEquals(1, trialsMetadata.size());
		I_TrialMetadata trialMeta = trialsMetadata.get(0);
		assertNotNull(trialMeta);
		assertEquals("org.adligo.tests4j_tests.trials_api.bad_mock_api_trials.AbstractTestTrial", 
				trialMeta.getTrialName());
		assertEquals(0L, trialMeta.getTimeout());
		assertFalse(trialMeta.isSkipped());
		
		List<? extends I_TestMetadata> testsMetadata = trialMeta.getTests();
		assertNotNull(testsMetadata);
		assertEquals("java.util.Collections$UnmodifiableRandomAccessList", 
				testsMetadata.getClass().getName());
		assertEquals(1, testsMetadata.size());
		
		List<I_TrialResult> results = runner.getResults();
		assertEquals(1, results.size());
		I_TrialResult result = results.get(0);
		assertNotNull(result);
		assertFalse(result.isPassed());
		I_TrialFailure failure = result.getFailure();
		assertNotNull(failure);
		assertEquals("Methods Annotated with @Test must NOT be abstract.", failure.getMessage());
		Throwable exception = failure.getException();
		assertUniform(new IllegalArgumentException(
				"org.adligo.tests4j_tests.trials_api.bad_mock_api_trials.AbstractTestTrial.testFoo was not annotated correctly."), 
				exception);
	}
	
	
	
	@Test
	public void testTestWithParams() {
		ExpectedFailureRunner runner = new ExpectedFailureRunner();
		runner.run(TestWithParamsTrial.class);
		
		I_TrialRunMetadata metadata = runner.getMetadata();
		assertNotNull(metadata);
		List<? extends I_TrialMetadata> trialsMetadata = metadata.getAllTrialMetadata();
		assertNotNull(trialsMetadata);
		assertEquals("java.util.Collections$UnmodifiableRandomAccessList", 
				trialsMetadata.getClass().getName());
		assertEquals(1, trialsMetadata.size());
		I_TrialMetadata trialMeta = trialsMetadata.get(0);
		assertNotNull(trialMeta);
		assertEquals("org.adligo.tests4j_tests.trials_api.bad_mock_api_trials.TestWithParamsTrial", 
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
		
		List<I_TrialResult> results = runner.getResults();
		assertEquals(1, results.size());
		I_TrialResult result = results.get(0);
		assertNotNull(result);
		assertFalse(result.isPassed());
		I_TrialFailure failure = result.getFailure();
		assertNotNull(failure);
		assertEquals("Methods Annotated with @Test must not take any parameters", failure.getMessage());
		Throwable exception = failure.getException();
		assertUniform(new IllegalArgumentException(
				"org.adligo.tests4j_tests.trials_api.bad_mock_api_trials.TestWithParamsTrial.testFoo was not annotated correctly."), 
				exception);
	}
	
	
	
	@Test
	public void testNoTests() {
		ExpectedFailureRunner runner = new ExpectedFailureRunner();
		runner.run(NoTestsTrial.class);
		List<I_TrialResult> results = runner.getResults();
		assertEquals(1, results.size());
		I_TrialResult result = results.get(0);
		
		I_TrialRunMetadata metadata = runner.getMetadata();
		assertNotNull(metadata);
		List<? extends I_TrialMetadata> trialsMetadata = metadata.getAllTrialMetadata();
		assertNotNull(trialsMetadata);
		assertEquals("java.util.Collections$UnmodifiableRandomAccessList", 
				trialsMetadata.getClass().getName());
		assertEquals(1, trialsMetadata.size());
		I_TrialMetadata trialMeta = trialsMetadata.get(0);
		assertNotNull(trialMeta);
		assertEquals("org.adligo.tests4j_tests.trials_api.bad_mock_api_trials.NoTestsTrial", 
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
				"org.adligo.tests4j_tests.trials_api.bad_mock_api_trials.NoTestsTrial was not annotated correctly."), 
				exception);
	}
	
	@Test
	public void testProtectedTest() {
		ExpectedFailureRunner runner = new ExpectedFailureRunner();
		runner.run(ProtectedTestTrial.class);
		
		I_TrialRunMetadata metadata = runner.getMetadata();
		assertNotNull(metadata);
		List<? extends I_TrialMetadata> trialsMetadata = metadata.getAllTrialMetadata();
		assertNotNull(trialsMetadata);
		assertEquals("java.util.Collections$UnmodifiableRandomAccessList", 
				trialsMetadata.getClass().getName());
		assertEquals(1, trialsMetadata.size());
		I_TrialMetadata trialMeta = trialsMetadata.get(0);
		assertNotNull(trialMeta);
		assertEquals("org.adligo.tests4j_tests.trials_api.bad_mock_api_trials.ProtectedTestTrial", 
				trialMeta.getTrialName());
		assertEquals(0L, trialMeta.getTimeout());
		assertFalse(trialMeta.isSkipped());
		
		List<I_TrialResult> results = runner.getResults();
		assertEquals(1, results.size());
		I_TrialResult result = results.get(0);
		assertNotNull(result);
		assertFalse(result.isPassed());
		I_TrialFailure failure = result.getFailure();
		assertNotNull(failure);
		assertEquals("Methods Annotated with @Test must be public.", failure.getMessage());
		Throwable exception = failure.getException();
		assertUniform(new IllegalArgumentException(
				"org.adligo.tests4j_tests.trials_api.bad_mock_api_trials.ProtectedTestTrial.testFoo was not annotated correctly."), 
				exception);
	}
	
	@Test
	public void testStaticTest() {
		ExpectedFailureRunner runner = new ExpectedFailureRunner();
		runner.run(StaticTestTrial.class);
		
		I_TrialRunMetadata metadata = runner.getMetadata();
		assertNotNull(metadata);
		List<? extends I_TrialMetadata> trialsMetadata = metadata.getAllTrialMetadata();
		assertNotNull(trialsMetadata);
		assertEquals("java.util.Collections$UnmodifiableRandomAccessList", 
				trialsMetadata.getClass().getName());
		assertEquals(1, trialsMetadata.size());
		I_TrialMetadata trialMeta = trialsMetadata.get(0);
		assertNotNull(trialMeta);
		assertEquals("org.adligo.tests4j_tests.trials_api.bad_mock_api_trials.StaticTestTrial", 
				trialMeta.getTrialName());
		assertEquals(0L, trialMeta.getTimeout());
		assertFalse(trialMeta.isSkipped());
		
		List<I_TrialResult> results = runner.getResults();
		assertEquals(1, results.size());
		I_TrialResult result = results.get(0);
		assertNotNull(result);
		assertFalse(result.isPassed());
		I_TrialFailure failure = result.getFailure();
		assertNotNull(failure);
		assertEquals("Methods Annotated with @Test must NOT be static.", failure.getMessage());
		Throwable exception = failure.getException();
		assertUniform(new IllegalArgumentException(
				"org.adligo.tests4j_tests.trials_api.bad_mock_api_trials.StaticTestTrial.testFoo was not annotated correctly."), 
				exception);
	}
	
	
	
	@Test
	public void testAfterTrialNotStatic() {
		ExpectedFailureRunner runner = new ExpectedFailureRunner();
		runner.run(AfterTrialNotStaticTrial.class);
		
		
		I_TrialRunMetadata metadata = runner.getMetadata();
		assertNotNull(metadata);
		List<? extends I_TrialMetadata> trialsMetadata = metadata.getAllTrialMetadata();
		assertNotNull(trialsMetadata);
		assertEquals("java.util.Collections$UnmodifiableRandomAccessList", 
				trialsMetadata.getClass().getName());
		assertEquals(1, trialsMetadata.size());
		I_TrialMetadata trialMeta = trialsMetadata.get(0);
		assertNotNull(trialMeta);
		assertEquals("org.adligo.tests4j_tests.trials_api.bad_mock_api_trials.AfterTrialNotStaticTrial", 
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
		
		
		List<I_TrialResult> results = runner.getResults();
		assertEquals(1, results.size());
		I_TrialResult result = results.get(0);
		assertNotNull(result);
		assertFalse(result.isPassed());
		I_TrialFailure failure = result.getFailure();
		assertNotNull(failure);
		assertEquals("Methods Annotated with @AfterTrial must be static.", failure.getMessage());
		Throwable exception = failure.getException();
		assertUniform(new IllegalArgumentException(
				"org.adligo.tests4j_tests.trials_api.bad_mock_api_trials.AfterTrialNotStaticTrial was not annotated correctly."), 
				exception);
	}
	
	@Test
	public void testAfterTrialNotPublic() {
		ExpectedFailureRunner runner = new ExpectedFailureRunner();
		runner.run(AfterTrialNotPublicTrial.class);
		
		
		I_TrialRunMetadata metadata = runner.getMetadata();
		assertNotNull(metadata);
		List<? extends I_TrialMetadata> trialsMetadata = metadata.getAllTrialMetadata();
		assertNotNull(trialsMetadata);
		assertEquals("java.util.Collections$UnmodifiableRandomAccessList", 
				trialsMetadata.getClass().getName());
		assertEquals(1, trialsMetadata.size());
		I_TrialMetadata trialMeta = trialsMetadata.get(0);
		assertNotNull(trialMeta);
		assertEquals("org.adligo.tests4j_tests.trials_api.bad_mock_api_trials.AfterTrialNotPublicTrial", 
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
		
		
		List<I_TrialResult> results = runner.getResults();
		assertEquals(1, results.size());
		I_TrialResult result = results.get(0);
		assertNotNull(result);
		assertFalse(result.isPassed());
		I_TrialFailure failure = result.getFailure();
		assertNotNull(failure);
		assertEquals("Methods Annotated with @AfterTrial must be public.", failure.getMessage());
		Throwable exception = failure.getException();
		assertUniform(new IllegalArgumentException(
				"org.adligo.tests4j_tests.trials_api.bad_mock_api_trials.AfterTrialNotPublicTrial was not annotated correctly."), 
				exception);
	}
	@Test
	public void testAfterTrialHasParams() {
		ExpectedFailureRunner runner = new ExpectedFailureRunner();
		runner.run(AfterTrialHasParamsTrial.class);
		
		
		I_TrialRunMetadata metadata = runner.getMetadata();
		assertNotNull(metadata);
		List<? extends I_TrialMetadata> trialsMetadata = metadata.getAllTrialMetadata();
		assertNotNull(trialsMetadata);
		assertEquals("java.util.Collections$UnmodifiableRandomAccessList", 
				trialsMetadata.getClass().getName());
		assertEquals(1, trialsMetadata.size());
		I_TrialMetadata trialMeta = trialsMetadata.get(0);
		assertNotNull(trialMeta);
		assertEquals("org.adligo.tests4j_tests.trials_api.bad_mock_api_trials.AfterTrialHasParamsTrial", 
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
		
		
		List<I_TrialResult> results = runner.getResults();
		assertEquals(1, results.size());
		I_TrialResult result = results.get(0);
		assertNotNull(result);
		assertFalse(result.isPassed());
		I_TrialFailure failure = result.getFailure();
		assertNotNull(failure);
		assertEquals("Methods Annotated with @AfterTrial must NOT take any parameters.", failure.getMessage());
		Throwable exception = failure.getException();
		assertUniform(new IllegalArgumentException(
				"org.adligo.tests4j_tests.trials_api.bad_mock_api_trials.AfterTrialHasParamsTrial was not annotated correctly."), 
				exception);
	}
	
	@Test
	public void testMultipleAfterTrial() {
		ExpectedFailureRunner runner = new ExpectedFailureRunner();
		runner.run(MultipleAfterTrialTrial.class);
		
		
		I_TrialRunMetadata metadata = runner.getMetadata();
		assertNotNull(metadata);
		List<? extends I_TrialMetadata> trialsMetadata = metadata.getAllTrialMetadata();
		assertNotNull(trialsMetadata);
		assertEquals("java.util.Collections$UnmodifiableRandomAccessList", 
				trialsMetadata.getClass().getName());
		assertEquals(1, trialsMetadata.size());
		I_TrialMetadata trialMeta = trialsMetadata.get(0);
		assertNotNull(trialMeta);
		assertEquals("org.adligo.tests4j_tests.trials_api.bad_mock_api_trials.MultipleAfterTrialTrial", 
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
		
		
		List<I_TrialResult> results = runner.getResults();
		assertEquals(1, results.size());
		I_TrialResult result = results.get(0);
		assertNotNull(result);
		assertFalse(result.isPassed());
		I_TrialFailure failure = result.getFailure();
		assertNotNull(failure);
		assertEquals("Trials may only have one method annotated with @AfterTrial.", failure.getMessage());
		Throwable exception = failure.getException();
		assertUniform(new IllegalArgumentException(
				"org.adligo.tests4j_tests.trials_api.bad_mock_api_trials.MultipleAfterTrialTrial was not annotated correctly."), 
				exception);
	}
	
	@Test
	public void testTrialRunOverlapPrevention() {
		ExpectedPassRunner runner = new ExpectedPassRunner();
		List<Class<? extends I_Trial>> trials = new ArrayList<>();
		for (int i = 0; i < 50; i++) {
			trials.add(SimpleRerunTrial.class);
		}
		runner.run(trials);
		
		I_TrialRunMetadata metadata = runner.getMetadata();
		assertNotNull(metadata);
		List<? extends I_TrialMetadata> trialsMetadata = metadata.getAllTrialMetadata();
		assertNotNull(trialsMetadata);
		assertEquals("java.util.Collections$UnmodifiableRandomAccessList", 
				trialsMetadata.getClass().getName());
		assertEquals(50, trialsMetadata.size());
		for (int i = 0; i < 50; i++) {
			I_TrialMetadata trialMeta = trialsMetadata.get(i);
			assertNotNull(trialMeta);
			assertEquals("org.adligo.tests4j_tests.trials_api.bad_mock_api_trials.SimpleRerunTrial", 
					trialMeta.getTrialName());
			assertEquals(0L, trialMeta.getTimeout());
			assertFalse(trialMeta.isSkipped());
		}
		
		List<I_TrialResult> results = runner.getResults();
		assertEquals(50, results.size());
		for (int i = 0; i < 50; i++) {
			I_TrialResult result = results.get(i);
			assertNotNull(result);
			assertTrue(result.isPassed());
		}
	}
}
