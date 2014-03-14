package org.adligo.jtests_tests.use_case_tests;

import org.adligo.jtests.models.shared.Exhibit;
import org.adligo.jtests.models.shared.FunctionalTest;
import org.adligo.jtests.models.shared.results.I_TestFailure;
import org.adligo.jtests.models.shared.results.I_TestResult;
import org.adligo.jtests_tests.use_case_tests.mock_functional.AbstractExhibit;
import org.adligo.jtests_tests.use_case_tests.mock_functional.AfterTestHasParams;
import org.adligo.jtests_tests.use_case_tests.mock_functional.AfterTestNotStatic;
import org.adligo.jtests_tests.use_case_tests.mock_functional.BadConstructor;
import org.adligo.jtests_tests.use_case_tests.mock_functional.BeforeTestHasParams;
import org.adligo.jtests_tests.use_case_tests.mock_functional.BeforeTestNotStatic;
import org.adligo.jtests_tests.use_case_tests.mock_functional.ExhibitWithParams;
import org.adligo.jtests_tests.use_case_tests.mock_functional.NoExhibits;
import org.adligo.jtests_tests.use_case_tests.mock_functional.ProtectedExhibit;
import org.adligo.jtests_tests.use_case_tests.mock_functional.StaticExhibit;

public class Run_FunctionalTest_Test extends FunctionalTest {

	@Exhibit
	public void exhibitAbstractExhibit() {
		ExpectedFailureRunner runner = new ExpectedFailureRunner();
		runner.runExpectedFailure(AbstractExhibit.class);
		I_TestResult result = runner.getResult();
		assertNotNull(result);
		assertFalse(result.isPassed());
		I_TestFailure failure = result.getFailure();
		assertNotNull(failure);
		assertEquals("Methods Annotated with @Exhibit must NOT be abstract.", failure.getMessage());
		Throwable exception = failure.getException();
		assertUniform(new IllegalArgumentException(
				"class org.adligo.jtests_tests.use_case_tests.mock_functional.AbstractExhibit.exhibitFoo was not annotated correctly."), 
				exception);
	}
	
	@Exhibit
	public void exhibitBadConstructor() {
		ExpectedFailureRunner runner = new ExpectedFailureRunner();
		runner.runExpectedFailure(BadConstructor.class);
		I_TestResult result = runner.getResult();
		assertNotNull(result);
		assertFalse(result.isPassed());
		I_TestFailure failure = result.getFailure();
		assertNotNull(failure);
		assertEquals("Classes which implement I_AbstractTest must have a zero argument constructor.", 
				failure.getMessage());
		Throwable exception = failure.getException();
		assertUniform(new NoSuchMethodException(
				"org.adligo.jtests_tests.use_case_tests.mock_functional.BadConstructor.<init>()"), 
				exception);
		
	}
	
	@Exhibit
	public void exhibitBeforeTestNotStatic() {
		ExpectedFailureRunner runner = new ExpectedFailureRunner();
		runner.runExpectedFailure(BeforeTestNotStatic.class);
		I_TestResult result = runner.getResult();
		assertNotNull(result);
		assertFalse(result.isPassed());
		I_TestFailure failure = result.getFailure();
		assertNotNull(failure);
		assertEquals("Methods Annotated with @BeforeTest must be static.", failure.getMessage());
		Throwable exception = failure.getException();
		assertUniform(new IllegalArgumentException(
				"class org.adligo.jtests_tests.use_case_tests.mock_functional.BeforeTestNotStatic was not annotated correctly."), 
				exception);
	}
	
	@Exhibit
	public void exhibitBeforeTestHasParams() {
		ExpectedFailureRunner runner = new ExpectedFailureRunner();
		runner.runExpectedFailure(BeforeTestHasParams.class);
		I_TestResult result = runner.getResult();
		assertNotNull(result);
		assertFalse(result.isPassed());
		I_TestFailure failure = result.getFailure();
		assertNotNull(failure);
		assertEquals("Methods Annotated with @BeforeTest must not take any parameters.", failure.getMessage());
		Throwable exception = failure.getException();
		assertUniform(new IllegalArgumentException(
				"class org.adligo.jtests_tests.use_case_tests.mock_functional.BeforeTestHasParams was not annotated correctly."), 
				exception);
	}
	
	@Exhibit
	public void exhibitAfterTestNotStatic() {
		ExpectedFailureRunner runner = new ExpectedFailureRunner();
		runner.runExpectedFailure(AfterTestNotStatic.class);
		I_TestResult result = runner.getResult();
		assertNotNull(result);
		assertFalse(result.isPassed());
		I_TestFailure failure = result.getFailure();
		assertNotNull(failure);
		assertEquals("Methods Annotated with @AfterTest must be static.", failure.getMessage());
		Throwable exception = failure.getException();
		assertUniform(new IllegalArgumentException(
				"class org.adligo.jtests_tests.use_case_tests.mock_functional.AfterTestNotStatic was not annotated correctly."), 
				exception);
	}
	
	@Exhibit
	public void exhibitAfterTestHasParams() {
		ExpectedFailureRunner runner = new ExpectedFailureRunner();
		runner.runExpectedFailure(AfterTestHasParams.class);
		I_TestResult result = runner.getResult();
		assertNotNull(result);
		assertFalse(result.isPassed());
		I_TestFailure failure = result.getFailure();
		assertNotNull(failure);
		assertEquals("Methods Annotated with @AfterTest must not take any parameters.", failure.getMessage());
		Throwable exception = failure.getException();
		assertUniform(new IllegalArgumentException(
				"class org.adligo.jtests_tests.use_case_tests.mock_functional.AfterTestHasParams was not annotated correctly."), 
				exception);
	}
	
	@Exhibit
	public void exhibitExhibitWithParams() {
		ExpectedFailureRunner runner = new ExpectedFailureRunner();
		runner.runExpectedFailure(ExhibitWithParams.class);
		I_TestResult result = runner.getResult();
		assertNotNull(result);
		assertFalse(result.isPassed());
		I_TestFailure failure = result.getFailure();
		assertNotNull(failure);
		assertEquals("Methods Annotated with @Exhibit must not take any parameters", failure.getMessage());
		Throwable exception = failure.getException();
		assertUniform(new IllegalArgumentException(
				"class org.adligo.jtests_tests.use_case_tests.mock_functional.ExhibitWithParams.exhibitFoo was not annotated correctly."), 
				exception);
	}
	
	
	
	@Exhibit
	public void exhibitNoExhibits() {
		ExpectedFailureRunner runner = new ExpectedFailureRunner();
		runner.runExpectedFailure(NoExhibits.class);
		I_TestResult result = runner.getResult();
		assertNotNull(result);
		assertFalse(result.isPassed());
		I_TestFailure failure = result.getFailure();
		assertNotNull(failure);
		assertEquals("Test Classes must have at least one method annotated with @Exhibit.", failure.getMessage());
		Throwable exception = failure.getException();
		assertUniform(new IllegalArgumentException(
				"class org.adligo.jtests_tests.use_case_tests.mock_functional.NoExhibits was not annotated correctly."), 
				exception);
	}
	
	@Exhibit
	public void exhibitProtectedExhibit() {
		ExpectedFailureRunner runner = new ExpectedFailureRunner();
		runner.runExpectedFailure(ProtectedExhibit.class);
		I_TestResult result = runner.getResult();
		assertNotNull(result);
		assertFalse(result.isPassed());
		I_TestFailure failure = result.getFailure();
		assertNotNull(failure);
		assertEquals("Test Classes must have at least one method annotated with @Exhibit.", failure.getMessage());
		Throwable exception = failure.getException();
		assertUniform(new IllegalArgumentException(
				"class org.adligo.jtests_tests.use_case_tests.mock_functional.ProtectedExhibit was not annotated correctly."), 
				exception);
	}
	
	@Exhibit
	public void exhibitStaticExhibit() {
		ExpectedFailureRunner runner = new ExpectedFailureRunner();
		runner.runExpectedFailure(StaticExhibit.class);
		I_TestResult result = runner.getResult();
		assertNotNull(result);
		assertFalse(result.isPassed());
		I_TestFailure failure = result.getFailure();
		assertNotNull(failure);
		assertEquals("Methods Annotated with @Exhibit must NOT be static.", failure.getMessage());
		Throwable exception = failure.getException();
		assertUniform(new IllegalArgumentException(
				"class org.adligo.jtests_tests.use_case_tests.mock_functional.StaticExhibit.exhibitFoo was not annotated correctly."), 
				exception);
	}
	
}
