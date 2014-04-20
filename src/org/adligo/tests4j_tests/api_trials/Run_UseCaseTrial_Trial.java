package org.adligo.tests4j_tests.api_trials;

import org.adligo.tests4j.models.shared.ApiTrial;
import org.adligo.tests4j.models.shared.PackageScope;
import org.adligo.tests4j.models.shared.Test;
import org.adligo.tests4j.models.shared.results.I_TrialFailure;
import org.adligo.tests4j.models.shared.results.I_TrialResult;
import org.adligo.tests4j_tests.api_trials.mock_functional_trials.AbstractTestTrial;
import org.adligo.tests4j_tests.api_trials.mock_functional_trials.AfterTrialHasParamsTrial;
import org.adligo.tests4j_tests.api_trials.mock_functional_trials.AfterTrialNotStaticTrial;
import org.adligo.tests4j_tests.api_trials.mock_functional_trials.BeforeTrialHasParamsTrial;
import org.adligo.tests4j_tests.api_trials.mock_functional_trials.BeforeTrialNotStaticTrial;
import org.adligo.tests4j_tests.api_trials.mock_functional_trials.FunctionalBadConstructorTrial;
import org.adligo.tests4j_tests.api_trials.mock_functional_trials.NoTestsTrial;
import org.adligo.tests4j_tests.api_trials.mock_functional_trials.ProtectedTestTrial;
import org.adligo.tests4j_tests.api_trials.mock_functional_trials.StaticTestTrial;
import org.adligo.tests4j_tests.api_trials.mock_functional_trials.TestWithParamsTrial;

@PackageScope (packageName = "org.adligo.tests4j")
public class Run_UseCaseTrial_Trial extends ApiTrial {

	@Test
	public void exhibitAbstractExhibit() {
		ExpectedFailureRunner runner = new ExpectedFailureRunner();
		runner.runExpectedFailure(AbstractTestTrial.class);
		I_TrialResult result = runner.getResult();
		assertNotNull(result);
		assertFalse(result.isPassed());
		I_TrialFailure failure = result.getFailure();
		assertNotNull(failure);
		assertEquals("Methods Annotated with @Test must NOT be abstract.", failure.getMessage());
		Throwable exception = failure.getException();
		assertUniform(new IllegalArgumentException(
				"org.adligo.tests4j_tests.api_trials.mock_functional_trials.AbstractTestTrial.exhibitFoo was not annotated correctly."), 
				exception);
	}
	
	@Test
	public void exhibitBadConstructor() {
		ExpectedFailureRunner runner = new ExpectedFailureRunner();
		runner.runExpectedFailure(FunctionalBadConstructorTrial.class);
		I_TrialResult result = runner.getResult();
		assertNotNull(result);
		assertFalse(result.isPassed());
		I_TrialFailure failure = result.getFailure();
		assertNotNull(failure);
		assertEquals("Classes which implement I_AbstractTrial must have a zero argument constructor.", 
				failure.getMessage());
		Throwable exception = failure.getException();
		assertUniform(new NoSuchMethodException(
				"org.adligo.tests4j_tests.api_trials.mock_functional_trials.FunctionalBadConstructorTrial.<init>()"), 
				exception);
		
	}
	
	@Test
	public void exhibitBeforeTestNotStatic() {
		ExpectedFailureRunner runner = new ExpectedFailureRunner();
		runner.runExpectedFailure(BeforeTrialNotStaticTrial.class);
		I_TrialResult result = runner.getResult();
		assertNotNull(result);
		assertFalse(result.isPassed());
		I_TrialFailure failure = result.getFailure();
		assertNotNull(failure);
		assertEquals("Methods Annotated with @BeforeTrial must be static.", failure.getMessage());
		Throwable exception = failure.getException();
		assertUniform(new IllegalArgumentException(
				"org.adligo.tests4j_tests.api_trials.mock_functional_trials.BeforeTrialNotStaticTrial was not annotated correctly."), 
				exception);
	}
	
	@Test
	public void exhibitBeforeTestHasParams() {
		ExpectedFailureRunner runner = new ExpectedFailureRunner();
		runner.runExpectedFailure(BeforeTrialHasParamsTrial.class);
		I_TrialResult result = runner.getResult();
		assertNotNull(result);
		assertFalse(result.isPassed());
		I_TrialFailure failure = result.getFailure();
		assertNotNull(failure);
		assertEquals("Methods Annotated with @BeforeTrial must not take any parameters.", failure.getMessage());
		Throwable exception = failure.getException();
		assertUniform(new IllegalArgumentException(
				"org.adligo.tests4j_tests.api_trials.mock_functional_trials.BeforeTrialHasParamsTrial was not annotated correctly."), 
				exception);
	}
	
	@Test
	public void exhibitAfterTestNotStatic() {
		ExpectedFailureRunner runner = new ExpectedFailureRunner();
		runner.runExpectedFailure(AfterTrialNotStaticTrial.class);
		I_TrialResult result = runner.getResult();
		assertNotNull(result);
		assertFalse(result.isPassed());
		I_TrialFailure failure = result.getFailure();
		assertNotNull(failure);
		assertEquals("Methods Annotated with @AfterTrial must be static.", failure.getMessage());
		Throwable exception = failure.getException();
		assertUniform(new IllegalArgumentException(
				"org.adligo.tests4j_tests.api_trials.mock_functional_trials.AfterTrialNotStaticTrial was not annotated correctly."), 
				exception);
	}
	
	@Test
	public void exhibitAfterTestHasParams() {
		ExpectedFailureRunner runner = new ExpectedFailureRunner();
		runner.runExpectedFailure(AfterTrialHasParamsTrial.class);
		I_TrialResult result = runner.getResult();
		assertNotNull(result);
		assertFalse(result.isPassed());
		I_TrialFailure failure = result.getFailure();
		assertNotNull(failure);
		assertEquals("Use Case Trial Methods Annotated with @AfterTrial must not take any parameters.", failure.getMessage());
		Throwable exception = failure.getException();
		assertUniform(new IllegalArgumentException(
				"org.adligo.tests4j_tests.api_trials.mock_functional_trials.AfterTrialHasParamsTrial was not annotated correctly."), 
				exception);
	}
	
	@Test
	public void exhibitExhibitWithParams() {
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
				"org.adligo.tests4j_tests.api_trials.mock_functional_trials.TestWithParamsTrial.exhibitFoo was not annotated correctly."), 
				exception);
	}
	
	
	
	@Test
	public void exhibitNoExhibits() {
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
				"org.adligo.tests4j_tests.api_trials.mock_functional_trials.NoTestsTrial was not annotated correctly."), 
				exception);
	}
	
	@Test
	public void exhibitProtectedExhibit() {
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
				"org.adligo.tests4j_tests.api_trials.mock_functional_trials.ProtectedTestTrial was not annotated correctly."), 
				exception);
	}
	
	@Test
	public void exhibitStaticExhibit() {
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
				"org.adligo.tests4j_tests.api_trials.mock_functional_trials.StaticTestTrial.exhibitFoo was not annotated correctly."), 
				exception);
	}
	
}
