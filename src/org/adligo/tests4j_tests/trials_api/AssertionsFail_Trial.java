package org.adligo.tests4j_tests.trials_api;

import org.adligo.tests4j.models.shared.coverage.I_PackageCoverage;
import org.adligo.tests4j.models.shared.results.I_ApiTrialResult;
import org.adligo.tests4j.models.shared.trials.AdditionalInstrumentation;
import org.adligo.tests4j.models.shared.trials.PackageScope;
import org.adligo.tests4j.models.shared.trials.Test;
import org.adligo.tests4j_tests.base_trials.ApiCountingTrial;
import org.adligo.tests4j_tests.trials_api.assert_fails_trials.AssertContainsFailsTrialRunner;
import org.adligo.tests4j_tests.trials_api.assert_fails_trials.AssertContainsWithMessageFailsTrialRunner;
import org.adligo.tests4j_tests.trials_api.assert_fails_trials.AssertEqualsFailsTrialRunner;
import org.adligo.tests4j_tests.trials_api.assert_fails_trials.AssertEqualsStringFailsTrialRunner;
import org.adligo.tests4j_tests.trials_api.assert_fails_trials.AssertEqualsStringWithMessageFailsTrialRunner;
import org.adligo.tests4j_tests.trials_api.assert_fails_trials.AssertEqualsWithMessageFailsTrialRunner;
import org.adligo.tests4j_tests.trials_api.assert_fails_trials.AssertFalseFailsTrialRunner;
import org.adligo.tests4j_tests.trials_api.assert_fails_trials.AssertFalseWithMessageFailsTrialRunner;
import org.adligo.tests4j_tests.trials_api.assert_fails_trials.AssertGreaterThanOrEqualsDoubleDoubleFailsTrialRunner;
import org.adligo.tests4j_tests.trials_api.assert_fails_trials.AssertGreaterThanOrEqualsDoubleDoubleWithMessageFailsTrialRunner;
import org.adligo.tests4j_tests.trials_api.assert_fails_trials.AssertGreaterThanOrEqualsDoubleFloatFailsTrialRunner;
import org.adligo.tests4j_tests.trials_api.assert_fails_trials.AssertGreaterThanOrEqualsDoubleFloatWithMessageFailsTrialRunner;
import org.adligo.tests4j_tests.trials_api.assert_fails_trials.AssertGreaterThanOrEqualsDoubleIntFailsTrialRunner;
import org.adligo.tests4j_tests.trials_api.assert_fails_trials.AssertGreaterThanOrEqualsDoubleIntWithMessageFailsTrialRunner;
import org.adligo.tests4j_tests.trials_api.assert_fails_trials.AssertGreaterThanOrEqualsDoubleLongFailsTrialRunner;
import org.adligo.tests4j_tests.trials_api.assert_fails_trials.AssertGreaterThanOrEqualsDoubleLongWithMessageFailsTrialRunner;
import org.adligo.tests4j_tests.trials_api.assert_fails_trials.AssertGreaterThanOrEqualsDoubleShortFailsTrialRunner;
import org.adligo.tests4j_tests.trials_api.assert_fails_trials.AssertGreaterThanOrEqualsDoubleShortWithMessageFailsTrialRunner;
import org.adligo.tests4j_tests.trials_api.assert_fails_trials.AssertNotEqualsFailsTrialRunner;
import org.adligo.tests4j_tests.trials_api.assert_fails_trials.AssertNotEqualsStringFailsTrialRunner;
import org.adligo.tests4j_tests.trials_api.assert_fails_trials.AssertNotEqualsStringWithMessageFailsTrialRunner;
import org.adligo.tests4j_tests.trials_api.assert_fails_trials.AssertNotEqualsWithMessageFailsTrialRunner;
import org.adligo.tests4j_tests.trials_api.assert_fails_trials.AssertNotNullFailsTrialRunner;
import org.adligo.tests4j_tests.trials_api.assert_fails_trials.AssertNotNullWithMessageFailsTrialRunner;
import org.adligo.tests4j_tests.trials_api.assert_fails_trials.AssertNotSameFailsTrialRunner;
import org.adligo.tests4j_tests.trials_api.assert_fails_trials.AssertNotSameWithMessageFailsTrialRunner;
import org.adligo.tests4j_tests.trials_api.assert_fails_trials.AssertNotUniformFailsTrialRunner;
import org.adligo.tests4j_tests.trials_api.assert_fails_trials.AssertNotUniformNoEvaluatorFailsTrialRunner;
import org.adligo.tests4j_tests.trials_api.assert_fails_trials.AssertNotUniformNoEvaluatorWithMessageFailsTrialRunner;
import org.adligo.tests4j_tests.trials_api.assert_fails_trials.AssertNotUniformWithMessageFailsTrialRunner;
import org.adligo.tests4j_tests.trials_api.assert_fails_trials.AssertNullFailsTrialRunner;
import org.adligo.tests4j_tests.trials_api.assert_fails_trials.AssertNullWithMessageFailsTrialRunner;
import org.adligo.tests4j_tests.trials_api.assert_fails_trials.AssertSameFailsTrialRunner;
import org.adligo.tests4j_tests.trials_api.assert_fails_trials.AssertSameWithMessageFailsTrialRunner;
import org.adligo.tests4j_tests.trials_api.assert_fails_trials.AssertThrownFailsTrialRunner;
import org.adligo.tests4j_tests.trials_api.assert_fails_trials.AssertThrownUniformFailsTrialRunner;
import org.adligo.tests4j_tests.trials_api.assert_fails_trials.AssertThrownUniformWithMessageFailsTrialRunner;
import org.adligo.tests4j_tests.trials_api.assert_fails_trials.AssertThrownWithMessageFailsTrialRunner;
import org.adligo.tests4j_tests.trials_api.assert_fails_trials.AssertTrueFailsMessageTrialRunner;
import org.adligo.tests4j_tests.trials_api.assert_fails_trials.AssertTrueFailsTrialRunner;
import org.adligo.tests4j_tests.trials_api.assert_fails_trials.AssertUniformFailsTrialRunner;
import org.adligo.tests4j_tests.trials_api.assert_fails_trials.AssertUniformWithMessageFailsTrialRunner;

@PackageScope (packageName = "org.adligo.tests4j.run")
@AdditionalInstrumentation (javaPackages="org.adligo.tests4j_tests.trials_api.assert_fails_trials")
public class AssertionsFail_Trial extends ApiCountingTrial {

	@Test
	public void testAssertContainsFails() throws Exception {
		AssertContainsFailsTrialRunner.runTestDelegate(this);
	}
	
	@Test
	public void testAssertContainsFailsWithMessage() throws Exception {
		AssertContainsWithMessageFailsTrialRunner.runTestDelegate(this);
	}
	
	@Test
	public void testAssertEqualsFails() throws Exception {
		AssertEqualsFailsTrialRunner.runTestDelegate(this);
	}
	
	@Test
	public void testAssertEqualsFailsWithMessage() throws Exception {
		AssertEqualsWithMessageFailsTrialRunner.runTestDelegate(this);
	}
	
	@Test
	public void testAssertEqualsStringFails() throws Exception {
		AssertEqualsStringFailsTrialRunner.runTestDelegate(this);
	}
	
	@Test
	public void testAssertEqualsStringFailsWithMessage() throws Exception {
		AssertEqualsStringWithMessageFailsTrialRunner.runTestDelegate(this);
	}
	
	@Test
	public void testAssertFalseIsTrue() throws Exception {
		AssertFalseFailsTrialRunner.runTestDelegate(this);
	}
	
	
	@Test
	public void testAssertFalseIsTrueWithMessage() throws Exception {
		AssertFalseWithMessageFailsTrialRunner.runTestDelegate(this);
	}
	
	@Test
	public void testAssertGreaterThanOrEqualsDoubleDoubleFails() throws Exception {
		AssertGreaterThanOrEqualsDoubleDoubleFailsTrialRunner.runTestDelegate(this);
	}
	
	@Test
	public void testAssertGreaterThanOrEqualsDoubleDoubleWithMessageFails() throws Exception {
		AssertGreaterThanOrEqualsDoubleDoubleWithMessageFailsTrialRunner.runTestDelegate(this);
	}
	
	@Test
	public void testAssertGreaterThanOrEqualsDoubleFloatFails() throws Exception {
		AssertGreaterThanOrEqualsDoubleFloatFailsTrialRunner.runTestDelegate(this);
	}
	
	@Test
	public void testAssertGreaterThanOrEqualsDoubleFloatWithMessageFails() throws Exception {
		AssertGreaterThanOrEqualsDoubleFloatWithMessageFailsTrialRunner.runTestDelegate(this);
	}
	
	@Test
	public void testAssertGreaterThanOrEqualsDoubleIntFails() throws Exception {
		AssertGreaterThanOrEqualsDoubleIntFailsTrialRunner.runTestDelegate(this);
	}
	
	@Test
	public void testAssertGreaterThanOrEqualsDoubleIntWithMessageFails() throws Exception {
		AssertGreaterThanOrEqualsDoubleIntWithMessageFailsTrialRunner.runTestDelegate(this);
	}
	
	@Test
	public void testAssertGreaterThanOrEqualsDoubleLongFails() throws Exception {
		AssertGreaterThanOrEqualsDoubleLongFailsTrialRunner.runTestDelegate(this);
	}
	
	@Test
	public void testAssertGreaterThanOrEqualsDoubleLongWithMessageFails() throws Exception {
		AssertGreaterThanOrEqualsDoubleLongWithMessageFailsTrialRunner.runTestDelegate(this);
	}
	
	@Test
	public void testAssertGreaterThanOrEqualsShortFloatFails() throws Exception {
		AssertGreaterThanOrEqualsDoubleShortFailsTrialRunner.runTestDelegate(this);
	}
	
	@Test
	public void testAssertGreaterThanOrEqualsDoubleShortWithMessageFails() throws Exception {
		AssertGreaterThanOrEqualsDoubleShortWithMessageFailsTrialRunner.runTestDelegate(this);
	}
	
	@Test
	public void testAssertNotEqualsFails() throws Exception {
		AssertNotEqualsFailsTrialRunner.runTestDelegate(this);
	}
	
	@Test
	public void testAssertNotEqualsWithMessageFails() throws Exception {
		AssertNotEqualsWithMessageFailsTrialRunner.runTestDelegate(this);
	}
	
	@Test
	public void testAssertNotEqualsStringFails() throws Exception {
		AssertNotEqualsStringFailsTrialRunner.runTestDelegate(this);
	}
	
	@Test
	public void testAssertNotEqualsStringWithMessageFails() throws Exception {
		AssertNotEqualsStringWithMessageFailsTrialRunner.runTestDelegate(this);
	}
	
	@Test
	public void testAssertNotNullFails() throws Exception {
		AssertNotNullFailsTrialRunner.runTestDelegate(this);
	}
	
	
	@Test
	public void testAssertNotNullWithMessageFails() throws Exception {
		AssertNotNullWithMessageFailsTrialRunner.runTestDelegate(this);
	}
	
	@Test
	public void testAssertNotSameFails() throws Exception {
		AssertNotSameFailsTrialRunner.runTestDelegate(this);
	}
	
	
	@Test
	public void testAssertNotSameWithMessageFails() throws Exception {
		AssertNotSameWithMessageFailsTrialRunner.runTestDelegate(this);
	}
	
	@Test
	public void testAssertNotUniformFails() throws Exception {
		AssertNotUniformFailsTrialRunner.runTestDelegate(this);
	}
	
	@Test
	public void testAssertNotUniformWithMessageFails() throws Exception {
		AssertNotUniformWithMessageFailsTrialRunner.runTestDelegate(this);
	}
	
	@Test
	public void testAssertNotUniformNoEvaluatorFails() throws Exception {
		AssertNotUniformNoEvaluatorFailsTrialRunner.runTestDelegate(this);
	}
	
	@Test
	public void testAssertNotUniformNoEvaluatorWithMessageFails() throws Exception {
		AssertNotUniformNoEvaluatorWithMessageFailsTrialRunner.runTestDelegate(this);
	}
	
	@Test
	public void testAssertNullFails() throws Exception {
		AssertNullFailsTrialRunner.runTestDelegate(this);
	}
	
	
	@Test
	public void testAssertNullWithMessageFails() throws Exception {
		AssertNullWithMessageFailsTrialRunner.runTestDelegate(this);
	}
	
	@Test
	public void testAssertSameFails() throws Exception {
		AssertSameFailsTrialRunner.runTestDelegate(this);
	}
	
	@Test
	public void testAssertSameWithMessageFails() throws Exception {
		AssertSameWithMessageFailsTrialRunner.runTestDelegate(this);
	}
	
	@Test
	public void testAssertThrownFails() throws Exception {
		AssertThrownFailsTrialRunner.runTestDelegate(this);
	}
	
	@Test
	public void testAssertThrownWithMessageFails() throws Exception {
		AssertThrownWithMessageFailsTrialRunner.runTestDelegate(this);
	}
	
	@Test
	public void testAssertTrueIsFalse() throws Exception {
		AssertTrueFailsTrialRunner.runTestDelegate(this);
	}
	
	@Test
	public void testAssertTrueIsFalseWithMessage() throws Exception {
		AssertTrueFailsMessageTrialRunner.runTestDelegate(this);
	}
	@Test
	public void testAssertThrownUniformFails() throws Exception {
		AssertThrownUniformFailsTrialRunner.runTestDelegate(this);
	}
	
	@Test
	public void testAssertThrownUniformWithMessageFails() throws Exception {
		AssertThrownUniformWithMessageFailsTrialRunner.runTestDelegate(this);
	}
	
	@Test
	public void testAssertUniformFails() throws Exception {
		AssertUniformFailsTrialRunner.runTestDelegate(this);
	}
	
	@Test
	public void testAssertUniformWithMessageFails() throws Exception {
		AssertUniformWithMessageFailsTrialRunner.runTestDelegate(this);
	}
	
	@Override
	public void afterTrialTests(I_ApiTrialResult p) {
		super.afterTrialTests(p);
		if (p.hasRecordedCoverage()) {
			I_PackageCoverage coverage = p.getPackageCoverage();
			assertGreaterThanOrEquals(10.0, coverage.getPercentageCoveredDouble());
		}
	}
	

	@Override
	public int getTests() {
		return 42;
	}

	@Override
	public int getAsserts() {
		return AssertContainsFailsTrialRunner.getAsserts() +
				AssertContainsWithMessageFailsTrialRunner.getAsserts() + 
				AssertEqualsFailsTrialRunner.getAsserts() +
				AssertEqualsWithMessageFailsTrialRunner.getAsserts() +
				AssertEqualsStringFailsTrialRunner.getAsserts() +
				AssertEqualsStringWithMessageFailsTrialRunner.getAsserts() +
				AssertFalseFailsTrialRunner.getAsserts() +
				AssertFalseWithMessageFailsTrialRunner.getAsserts()  +
				AssertGreaterThanOrEqualsDoubleDoubleFailsTrialRunner.getAsserts()  +
				AssertGreaterThanOrEqualsDoubleDoubleWithMessageFailsTrialRunner.getAsserts() +
				AssertGreaterThanOrEqualsDoubleFloatFailsTrialRunner.getAsserts() +
				AssertGreaterThanOrEqualsDoubleFloatWithMessageFailsTrialRunner.getAsserts() +
				AssertGreaterThanOrEqualsDoubleIntFailsTrialRunner.getAsserts() +
				AssertGreaterThanOrEqualsDoubleIntWithMessageFailsTrialRunner.getAsserts() + 
				AssertGreaterThanOrEqualsDoubleLongFailsTrialRunner.getAsserts() +
				AssertGreaterThanOrEqualsDoubleLongWithMessageFailsTrialRunner.getAsserts() + 
				AssertGreaterThanOrEqualsDoubleShortFailsTrialRunner.getAsserts() +
				AssertGreaterThanOrEqualsDoubleShortWithMessageFailsTrialRunner.getAsserts() + 
				AssertNotEqualsFailsTrialRunner.getAsserts() +
				AssertNotEqualsWithMessageFailsTrialRunner.getAsserts() + 
				AssertNotEqualsStringFailsTrialRunner.getAsserts() +
				AssertNotEqualsStringWithMessageFailsTrialRunner.getAsserts() + 
				AssertNotNullFailsTrialRunner.getAsserts() +
				AssertNotNullWithMessageFailsTrialRunner.getAsserts() + 
				AssertNotSameFailsTrialRunner.getAsserts() +
				AssertNotSameWithMessageFailsTrialRunner.getAsserts() + 
				AssertNotUniformFailsTrialRunner.getAsserts() +
				AssertNotUniformWithMessageFailsTrialRunner.getAsserts() + 
				AssertNotUniformNoEvaluatorFailsTrialRunner.getAsserts() +
				AssertNotUniformNoEvaluatorWithMessageFailsTrialRunner.getAsserts() +
				AssertNullFailsTrialRunner.getAsserts() +
				AssertNullWithMessageFailsTrialRunner.getAsserts() + 
				AssertSameFailsTrialRunner.getAsserts() +
				AssertSameWithMessageFailsTrialRunner.getAsserts()  +
				AssertThrownFailsTrialRunner.getAsserts() +
				AssertThrownWithMessageFailsTrialRunner.getAsserts() +
				AssertThrownUniformFailsTrialRunner.getAsserts() + 
				AssertThrownUniformWithMessageFailsTrialRunner.getAsserts() +
				AssertTrueFailsTrialRunner.getAsserts() +
				AssertTrueFailsMessageTrialRunner.getAsserts() +
				AssertUniformFailsTrialRunner.getAsserts() + 
				AssertUniformWithMessageFailsTrialRunner.getAsserts();
	}

	@Override
	public int getUniqueAsserts() {
		return 840;
	}
}
