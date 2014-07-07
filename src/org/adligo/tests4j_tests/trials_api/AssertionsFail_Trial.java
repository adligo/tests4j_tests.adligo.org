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
	public void testAssertContainsFails() {
		AssertContainsFailsTrial.runTestDelegate(this);
	}
	
	@Test
	public void testAssertContainsFailsWithMessage() {
		AssertContainsWithMessageFailsTrial.runTestDelegate(this);
	}
	
	@Test
	public void testAssertEqualsFails() {
		AssertEqualsFailsTrial.runTestDelegate(this);
	}
	
	@Test
	public void testAssertEqualsFailsWithMessage() {
		AssertEqualsWithMessageFailsTrial.runTestDelegate(this);
	}
	
	@Test
	public void testAssertFalseIsTrue() {
		AssertFalseFailsTrial.runTestDelegate(this);
	}
	
	
	@Test
	public void testAssertFalseIsTrueWithMessage() {
		AssertFalseWithMessageFailsTrial.runTestDelegate(this);
	}
	
	@Test
	public void testAssertGreaterThanOrEqualsDoubleDoubleFails() {
		AssertGreaterThanOrEqualsDoubleDoubleFailsTrial.runTestDelegate(this);
	}
	
	@Test
	public void testAssertGreaterThanOrEqualsDoubleDoubleWithMessageFails() {
		AssertGreaterThanOrEqualsDoubleDoubleWithMessageFailsTrial.runTestDelegate(this);
	}
	
	@Test
	public void testAssertGreaterThanOrEqualsDoubleFloatFails() {
		AssertGreaterThanOrEqualsDoubleFloatFailsTrial.runTestDelegate(this);
	}
	
	@Test
	public void testAssertGreaterThanOrEqualsDoubleFloatWithMessageFails() {
		AssertGreaterThanOrEqualsDoubleFloatWithMessageFailsTrial.runTestDelegate(this);
	}
	
	@Test
	public void testAssertGreaterThanOrEqualsDoubleIntFails() {
		AssertGreaterThanOrEqualsDoubleIntFailsTrial.runTestDelegate(this);
	}
	
	@Test
	public void testAssertGreaterThanOrEqualsDoubleIntWithMessageFails() {
		AssertGreaterThanOrEqualsDoubleIntWithMessageFailsTrial.runTestDelegate(this);
	}
	
	@Test
	public void testAssertGreaterThanOrEqualsDoubleLongFails() {
		AssertGreaterThanOrEqualsDoubleLongFailsTrial.runTestDelegate(this);
	}
	
	@Test
	public void testAssertGreaterThanOrEqualsDoubleLongWithMessageFails() {
		AssertGreaterThanOrEqualsDoubleLongWithMessageFailsTrial.runTestDelegate(this);
	}
	
	@Test
	public void testAssertGreaterThanOrEqualsShortFloatFails() {
		AssertGreaterThanOrEqualsDoubleShortFailsTrial.runTestDelegate(this);
	}
	
	@Test
	public void testAssertGreaterThanOrEqualsDoubleShortWithMessageFails() {
		AssertGreaterThanOrEqualsDoubleShortWithMessageFailsTrial.runTestDelegate(this);
	}

	@Test
	public void testAssertNotEqualsFails() {
		AssertNotEqualsFailsTrial.runTestDelegate(this);
	}
	
	@Test
	public void testAssertNotEqualsWithMessageFails() {
		AssertNotEqualsWithMessageFailsTrial.runTestDelegate(this);
	}
	
	@Test
	public void testAssertNotNullFails() {
		AssertNotNullFailsTrial.runTestDelegate(this);
	}
	
	
	@Test
	public void testAssertNotNullWithMessageFails() {
		AssertNotNullWithMessageFailsTrial.runTestDelegate(this);
	}
	
	@Test
	public void testAssertNotSameFails() {
		AssertNotSameFailsTrial.runTestDelegate(this);
	}
	
	
	@Test
	public void testAssertNotSameWithMessageFails() {
		AssertNotSameWithMessageFailsTrial.runTestDelegate(this);
	}
	
	@Test
	public void testAssertNotUniformFails() {
		AssertNotUniformFailsTrial.runTestDelegate(this);
	}
	
	@Test
	public void testAssertNotUniformWithMessageFails() {
		AssertNotUniformWithMessageFailsTrial.runTestDelegate(this);
	}
	
	@Test
	public void testAssertNotUniformNoEvaluatorFails() {
		AssertNotUniformNoEvaluatorFailsTrial.runTestDelegate(this);
	}
	
	@Test
	public void testAssertNotUniformNoEvaluatorWithMessageFails() {
		AssertNotUniformNoEvaluatorWithMessageFailsTrial.runTestDelegate(this);
	}
	
	@Test
	public void testAssertNullFails() {
		AssertNullFailsTrial.runTestDelegate(this);
	}
	
	
	@Test
	public void testAssertNullWithMessageFails() {
		AssertNullWithMessageFailsTrial.runTestDelegate(this);
	}
	
	@Test
	public void testAssertSameFails() {
		AssertSameFailsTrial.runTestDelegate(this);
	}
	
	@Test
	public void testAssertSameWithMessageFails() {
		AssertSameWithMessageFailsTrial.runTestDelegate(this);
	}
	
	@Test
	public void testAssertThrownFails() {
		AssertThrownFailsTrial.runTestDelegate(this);
	}
	
	@Test
	public void testAssertThrownWithMessageFails() {
		AssertThrownWithMessageFailsTrial.runTestDelegate(this);
	}
	
	@Test
	public void testAssertTrueIsFalse() {
		AssertTrueFailsTrial.runTestDelegate(this);
	}
	
	@Test
	public void testAssertTrueIsFalseWithMessage() {
		AssertTrueFailsMessageTrial.runTestDelegate(this);
	}
	@Test
	public void testAssertThrownUniformFails() {
		AssertThrownUniformFailsTrial.runTestDelegate(this);
	}
	
	@Test
	public void testAssertThrownUniformWithMessageFails() {
		AssertThrownUniformWithMessageFailsTrial.runTestDelegate(this);
	}
	
	@Test
	public void testAssertUniformFails() {
		AssertUniformFailsTrial.runTestDelegate(this);
	}
	
	@Test
	public void testAssertUniformWithMessageFails() {
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
				AssertNullWithMessageFailsTrial.getAsserts()+ 
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
		return 768;
	}
}
