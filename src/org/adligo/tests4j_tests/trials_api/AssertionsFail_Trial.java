package org.adligo.tests4j_tests.trials_api;

import org.adligo.tests4j.models.shared.coverage.I_PackageCoverage;
import org.adligo.tests4j.models.shared.results.I_ApiTrialResult;
import org.adligo.tests4j.models.shared.trials.ApiTrial;
import org.adligo.tests4j.models.shared.trials.IgnoreTest;
import org.adligo.tests4j.models.shared.trials.PackageScope;
import org.adligo.tests4j.models.shared.trials.Test;
import org.adligo.tests4j_tests.base_abstract_trials.ApiCountingTrial;
import org.adligo.tests4j_tests.trials_api.assert_fails_trials.AssertContainsFailsTrial;
import org.adligo.tests4j_tests.trials_api.assert_fails_trials.AssertContainsWithMessageFailsTrial;
import org.adligo.tests4j_tests.trials_api.assert_fails_trials.AssertEqualsFailsTrial;
import org.adligo.tests4j_tests.trials_api.assert_fails_trials.AssertEqualsWithMessageFailsTrial;
import org.adligo.tests4j_tests.trials_api.assert_fails_trials.AssertFalseFailsTrial;
import org.adligo.tests4j_tests.trials_api.assert_fails_trials.AssertFalseWithMessageFailsTrial;
import org.adligo.tests4j_tests.trials_api.assert_fails_trials.AssertGreaterThanOrEqualsDoubleDoubleFailsTrial;
import org.adligo.tests4j_tests.trials_api.assert_fails_trials.AssertGreaterThanOrEqualsDoubleDoubleWithMessageFailsTrial;
import org.adligo.tests4j_tests.trials_api.assert_fails_trials.AssertGreaterThanOrEqualsDoubleFloatFailsTrial;
import org.adligo.tests4j_tests.trials_api.assert_fails_trials.AssertGreaterThanOrEqualsDoubleFloatWithMessageFailsTrial;
import org.adligo.tests4j_tests.trials_api.assert_fails_trials.AssertGreaterThanOrEqualsDoubleIntFailsTrial;
import org.adligo.tests4j_tests.trials_api.assert_fails_trials.AssertGreaterThanOrEqualsDoubleIntWithMessageFailsTrial;
import org.adligo.tests4j_tests.trials_api.assert_fails_trials.AssertGreaterThanOrEqualsDoubleLongFailsTrial;
import org.adligo.tests4j_tests.trials_api.assert_fails_trials.AssertGreaterThanOrEqualsDoubleLongWithMessageFailsTrial;
import org.adligo.tests4j_tests.trials_api.assert_fails_trials.AssertGreaterThanOrEqualsDoubleShortFailsTrial;
import org.adligo.tests4j_tests.trials_api.assert_fails_trials.AssertGreaterThanOrEqualsDoubleShortWithMessageFailsTrial;
import org.adligo.tests4j_tests.trials_api.assert_fails_trials.AssertNotEqualsFailsTrial;
import org.adligo.tests4j_tests.trials_api.assert_fails_trials.AssertNotEqualsWithMessageFailsTrial;
import org.adligo.tests4j_tests.trials_api.assert_fails_trials.AssertNotNullFailsTrial;
import org.adligo.tests4j_tests.trials_api.assert_fails_trials.AssertNotNullWithMessageFailsTrial;
import org.adligo.tests4j_tests.trials_api.assert_fails_trials.AssertNotSameFailsTrial;
import org.adligo.tests4j_tests.trials_api.assert_fails_trials.AssertNotSameWithMessageFailsTrial;
import org.adligo.tests4j_tests.trials_api.assert_fails_trials.AssertNotUniformFailsTrial;
import org.adligo.tests4j_tests.trials_api.assert_fails_trials.AssertNotUniformNoEvaluatorFailsTrial;
import org.adligo.tests4j_tests.trials_api.assert_fails_trials.AssertNotUniformNoEvaluatorWithMessageFailsTrial;
import org.adligo.tests4j_tests.trials_api.assert_fails_trials.AssertNotUniformWithMessageFailsTrial;
import org.adligo.tests4j_tests.trials_api.assert_fails_trials.AssertNullFailsTrial;
import org.adligo.tests4j_tests.trials_api.assert_fails_trials.AssertNullWithMessageFailsTrial;
import org.adligo.tests4j_tests.trials_api.assert_fails_trials.AssertSameFailsTrial;
import org.adligo.tests4j_tests.trials_api.assert_fails_trials.AssertSameWithMessageFailsTrial;
import org.adligo.tests4j_tests.trials_api.assert_fails_trials.AssertThrownFailsTrial;
import org.adligo.tests4j_tests.trials_api.assert_fails_trials.AssertThrownUniformFailsTrial;
import org.adligo.tests4j_tests.trials_api.assert_fails_trials.AssertThrownUniformWithMessageFailsTrial;
import org.adligo.tests4j_tests.trials_api.assert_fails_trials.AssertThrownWithMessageFailsTrial;
import org.adligo.tests4j_tests.trials_api.assert_fails_trials.AssertTrueFailsMessageTrial;
import org.adligo.tests4j_tests.trials_api.assert_fails_trials.AssertTrueFailsTrial;
import org.adligo.tests4j_tests.trials_api.assert_fails_trials.AssertUniformFailsTrial;
import org.adligo.tests4j_tests.trials_api.assert_fails_trials.AssertUniformWithMessageFailsTrial;

@PackageScope (packageName = "org.adligo.tests4j.run")
public class AssertionsFail_Trial extends ApiCountingTrial {

	@Test
	public void testAssertContainsFails() throws Exception {
		AssertContainsFailsTrial.runTestDelegate(this);
	}
	
	@Test
	public void testAssertContainsFailsWithMessage() throws Exception {
		AssertContainsWithMessageFailsTrial.runTestDelegate(this);
	}
	
	@Test
	public void testAssertEqualsFails() throws Exception {
		AssertEqualsFailsTrial.runTestDelegate(this);
	}
	
	@Test
	public void testAssertEqualsFailsWithMessage() throws Exception {
		AssertEqualsWithMessageFailsTrial.runTestDelegate(this);
	}
	
	@Test
	public void testAssertFalseIsTrue() throws Exception {
		AssertFalseFailsTrial.runTestDelegate(this);
	}
	
	
	@Test
	public void testAssertFalseIsTrueWithMessage() throws Exception {
		AssertFalseWithMessageFailsTrial.runTestDelegate(this);
	}
	
	@Test
	public void testAssertGreaterThanOrEqualsDoubleDoubleFails() throws Exception {
		AssertGreaterThanOrEqualsDoubleDoubleFailsTrial.runTestDelegate(this);
	}
	
	@Test
	public void testAssertGreaterThanOrEqualsDoubleDoubleWithMessageFails() throws Exception {
		AssertGreaterThanOrEqualsDoubleDoubleWithMessageFailsTrial.runTestDelegate(this);
	}
	
	@Test
	public void testAssertGreaterThanOrEqualsDoubleFloatFails() throws Exception {
		AssertGreaterThanOrEqualsDoubleFloatFailsTrial.runTestDelegate(this);
	}
	
	@Test
	public void testAssertGreaterThanOrEqualsDoubleFloatWithMessageFails() throws Exception {
		AssertGreaterThanOrEqualsDoubleFloatWithMessageFailsTrial.runTestDelegate(this);
	}
	
	@Test
	public void testAssertGreaterThanOrEqualsDoubleIntFails() throws Exception {
		AssertGreaterThanOrEqualsDoubleIntFailsTrial.runTestDelegate(this);
	}
	
	@Test
	public void testAssertGreaterThanOrEqualsDoubleIntWithMessageFails() throws Exception {
		AssertGreaterThanOrEqualsDoubleIntWithMessageFailsTrial.runTestDelegate(this);
	}
	
	@Test
	public void testAssertGreaterThanOrEqualsDoubleLongFails() throws Exception {
		AssertGreaterThanOrEqualsDoubleLongFailsTrial.runTestDelegate(this);
	}
	
	@Test
	public void testAssertGreaterThanOrEqualsDoubleLongWithMessageFails() throws Exception {
		AssertGreaterThanOrEqualsDoubleLongWithMessageFailsTrial.runTestDelegate(this);
	}
	
	@Test
	public void testAssertGreaterThanOrEqualsShortFloatFails() throws Exception {
		AssertGreaterThanOrEqualsDoubleShortFailsTrial.runTestDelegate(this);
	}
	
	@Test
	public void testAssertGreaterThanOrEqualsDoubleShortWithMessageFails() throws Exception {
		AssertGreaterThanOrEqualsDoubleShortWithMessageFailsTrial.runTestDelegate(this);
	}
	
	@Test
	public void testAssertNotEqualsFails() throws Exception {
		AssertNotEqualsFailsTrial.runTestDelegate(this);
	}
	
	@Test
	public void testAssertNotEqualsWithMessageFails() throws Exception {
		AssertNotEqualsWithMessageFailsTrial.runTestDelegate(this);
	}
	
	@Test
	public void testAssertNotNullFails() throws Exception {
		AssertNotNullFailsTrial.runTestDelegate(this);
	}
	
	
	@Test
	public void testAssertNotNullWithMessageFails() throws Exception {
		AssertNotNullWithMessageFailsTrial.runTestDelegate(this);
	}
	
	@Test
	public void testAssertNotSameFails() throws Exception {
		AssertNotSameFailsTrial.runTestDelegate(this);
	}
	
	
	@Test
	public void testAssertNotSameWithMessageFails() throws Exception {
		AssertNotSameWithMessageFailsTrial.runTestDelegate(this);
	}
	
	@Test
	public void testAssertNotUniformFails() throws Exception {
		AssertNotUniformFailsTrial.runTestDelegate(this);
	}
	
	@Test
	public void testAssertNotUniformWithMessageFails() throws Exception {
		AssertNotUniformWithMessageFailsTrial.runTestDelegate(this);
	}
	
	@Test
	public void testAssertNotUniformNoEvaluatorFails() throws Exception {
		AssertNotUniformNoEvaluatorFailsTrial.runTestDelegate(this);
	}
	
	@Test
	public void testAssertNotUniformNoEvaluatorWithMessageFails() throws Exception {
		AssertNotUniformNoEvaluatorWithMessageFailsTrial.runTestDelegate(this);
	}
	
	@Test
	public void testAssertNullFails() throws Exception {
		AssertNullFailsTrial.runTestDelegate(this);
	}
	
	
	@Test
	public void testAssertNullWithMessageFails() throws Exception {
		AssertNullWithMessageFailsTrial.runTestDelegate(this);
	}
	
	@Test
	public void testAssertSameFails() throws Exception {
		AssertSameFailsTrial.runTestDelegate(this);
	}
	
	@Test
	public void testAssertSameWithMessageFails() throws Exception {
		AssertSameWithMessageFailsTrial.runTestDelegate(this);
	}
	
	@Test
	public void testAssertThrownFails() throws Exception {
		AssertThrownFailsTrial.runTestDelegate(this);
	}
	
	@Test
	public void testAssertThrownWithMessageFails() throws Exception {
		AssertThrownWithMessageFailsTrial.runTestDelegate(this);
	}
	
	@Test
	public void testAssertTrueIsFalse() throws Exception {
		AssertTrueFailsTrial.runTestDelegate(this);
	}
	
	@Test
	public void testAssertTrueIsFalseWithMessage() throws Exception {
		AssertTrueFailsMessageTrial.runTestDelegate(this);
	}
	@Test
	public void testAssertThrownUniformFails() throws Exception {
		AssertThrownUniformFailsTrial.runTestDelegate(this);
	}
	
	@Test
	public void testAssertThrownUniformWithMessageFails() throws Exception {
		AssertThrownUniformWithMessageFailsTrial.runTestDelegate(this);
	}
	
	@Test
	public void testAssertUniformFails() throws Exception {
		AssertUniformFailsTrial.runTestDelegate(this);
	}
	
	@Test
	public void testAssertUniformWithMessageFails() throws Exception {
		AssertUniformWithMessageFailsTrial.runTestDelegate(this);
	}
	
	@Override
	public void afterTrialTests(I_ApiTrialResult p) {
		assertCounts(p);
		if (p.hasRecordedCoverage()) {
			I_PackageCoverage coverage = p.getPackageCoverage();
			//TODO this is not feeding correclty yet
			assertGreaterThanOrEquals(0.0, coverage.getPercentageCoveredDouble());
		}
	}
	

	@Override
	public int getTests() {
		return 38;
	}

	@Override
	public int getAsserts() {
		return AssertContainsFailsTrial.getAsserts() +
				AssertContainsWithMessageFailsTrial.getAsserts() + 
				AssertEqualsFailsTrial.getAsserts() +
				AssertEqualsWithMessageFailsTrial.getAsserts() +
				AssertFalseFailsTrial.getAsserts() +
				AssertFalseWithMessageFailsTrial.getAsserts()  +
				AssertGreaterThanOrEqualsDoubleDoubleFailsTrial.getAsserts()  +
				AssertGreaterThanOrEqualsDoubleDoubleWithMessageFailsTrial.getAsserts() +
				AssertGreaterThanOrEqualsDoubleFloatFailsTrial.getAsserts() +
				AssertGreaterThanOrEqualsDoubleFloatWithMessageFailsTrial.getAsserts() +
				AssertGreaterThanOrEqualsDoubleIntFailsTrial.getAsserts() +
				AssertGreaterThanOrEqualsDoubleIntWithMessageFailsTrial.getAsserts() + 
				AssertGreaterThanOrEqualsDoubleLongFailsTrial.getAsserts() +
				AssertGreaterThanOrEqualsDoubleLongWithMessageFailsTrial.getAsserts() + 
				AssertGreaterThanOrEqualsDoubleShortFailsTrial.getAsserts() +
				AssertGreaterThanOrEqualsDoubleShortWithMessageFailsTrial.getAsserts() + 
				AssertNotEqualsFailsTrial.getAsserts() +
				AssertNotEqualsWithMessageFailsTrial.getAsserts() + 
				AssertNotNullFailsTrial.getAsserts() +
				AssertNotNullWithMessageFailsTrial.getAsserts() + 
				AssertNotSameFailsTrial.getAsserts() +
				AssertNotSameWithMessageFailsTrial.getAsserts() + 
				AssertNotUniformFailsTrial.getAsserts() +
				AssertNotUniformWithMessageFailsTrial.getAsserts() + 
				AssertNotUniformNoEvaluatorFailsTrial.getAsserts() +
				AssertNotUniformNoEvaluatorWithMessageFailsTrial.getAsserts() +
				AssertNullFailsTrial.getAsserts() +
				AssertNullWithMessageFailsTrial.getAsserts() + 
				AssertSameFailsTrial.getAsserts() +
				AssertSameWithMessageFailsTrial.getAsserts()  +
				AssertThrownFailsTrial.getAsserts() +
				AssertThrownWithMessageFailsTrial.getAsserts() +
				AssertThrownUniformFailsTrial.getAsserts() + 
				AssertThrownUniformWithMessageFailsTrial.getAsserts() +
				AssertTrueFailsTrial.getAsserts() +
				AssertTrueFailsMessageTrial.getAsserts() +
				AssertUniformFailsTrial.getAsserts() + 
				AssertUniformWithMessageFailsTrial.getAsserts();
	}

	@Override
	public int getUniqueAsserts() {
		return 762;
	}
}
