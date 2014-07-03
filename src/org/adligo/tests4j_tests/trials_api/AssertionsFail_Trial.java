package org.adligo.tests4j_tests.trials_api;

import org.adligo.tests4j.models.shared.results.feedback.I_ApiTrial_TestsResults;
import org.adligo.tests4j.models.shared.trials.ApiTrial;
import org.adligo.tests4j.models.shared.trials.PackageScope;
import org.adligo.tests4j.models.shared.trials.Test;
import org.adligo.tests4j_tests.trials_api.failing_trials.AssertContainsFailsTrial;
import org.adligo.tests4j_tests.trials_api.failing_trials.AssertContainsWithMessageFailsTrial;
import org.adligo.tests4j_tests.trials_api.failing_trials.AssertEqualsFailsTrial;
import org.adligo.tests4j_tests.trials_api.failing_trials.AssertEqualsWithMessageFailsTrial;
import org.adligo.tests4j_tests.trials_api.failing_trials.AssertFalseFailsTrial;
import org.adligo.tests4j_tests.trials_api.failing_trials.AssertFalseWithMessageFailsTrial;
import org.adligo.tests4j_tests.trials_api.failing_trials.AssertGreaterThanOrEqualsDoubleDoubleFailsTrial;
import org.adligo.tests4j_tests.trials_api.failing_trials.AssertGreaterThanOrEqualsDoubleDoubleWithMessageFailsTrial;
import org.adligo.tests4j_tests.trials_api.failing_trials.AssertGreaterThanOrEqualsDoubleFloatFailsTrial;
import org.adligo.tests4j_tests.trials_api.failing_trials.AssertGreaterThanOrEqualsDoubleFloatWithMessageFailsTrial;
import org.adligo.tests4j_tests.trials_api.failing_trials.AssertGreaterThanOrEqualsDoubleIntFailsTrial;
import org.adligo.tests4j_tests.trials_api.failing_trials.AssertGreaterThanOrEqualsDoubleIntWithMessageFailsTrial;
import org.adligo.tests4j_tests.trials_api.failing_trials.AssertGreaterThanOrEqualsDoubleLongFailsTrial;
import org.adligo.tests4j_tests.trials_api.failing_trials.AssertGreaterThanOrEqualsDoubleLongWithMessageFailsTrial;
import org.adligo.tests4j_tests.trials_api.failing_trials.AssertGreaterThanOrEqualsDoubleShortFailsTrial;
import org.adligo.tests4j_tests.trials_api.failing_trials.AssertGreaterThanOrEqualsDoubleShortWithMessageFailsTrial;
import org.adligo.tests4j_tests.trials_api.failing_trials.AssertNotEqualsFailsTrial;
import org.adligo.tests4j_tests.trials_api.failing_trials.AssertNotEqualsWithMessageFailsTrial;
import org.adligo.tests4j_tests.trials_api.failing_trials.AssertNotNullFailsTrial;
import org.adligo.tests4j_tests.trials_api.failing_trials.AssertNotNullWithMessageFailsTrial;
import org.adligo.tests4j_tests.trials_api.failing_trials.AssertNotSameFailsTrial;
import org.adligo.tests4j_tests.trials_api.failing_trials.AssertNotSameWithMessageFailsTrial;
import org.adligo.tests4j_tests.trials_api.failing_trials.AssertNotUniformFailsTrial;
import org.adligo.tests4j_tests.trials_api.failing_trials.AssertNotUniformNoEvaluatorFailsTrial;
import org.adligo.tests4j_tests.trials_api.failing_trials.AssertNotUniformNoEvaluatorWithMessageFailsTrial;
import org.adligo.tests4j_tests.trials_api.failing_trials.AssertNotUniformWithMessageFailsTrial;
import org.adligo.tests4j_tests.trials_api.failing_trials.AssertNullFailsTrial;
import org.adligo.tests4j_tests.trials_api.failing_trials.AssertNullWithMessageFailsTrial;
import org.adligo.tests4j_tests.trials_api.failing_trials.AssertSameFailsTrial;
import org.adligo.tests4j_tests.trials_api.failing_trials.AssertSameWithMessageFailsTrial;
import org.adligo.tests4j_tests.trials_api.failing_trials.AssertTrueFailsMessageTrial;
import org.adligo.tests4j_tests.trials_api.failing_trials.AssertTrueFailsTrial;

@PackageScope (packageName = "org.adligo.tests4j")
public class AssertionsFail_Trial extends ApiTrial {

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
	public void testAssertNullFails() {
		AssertNullFailsTrial.runTestDelegate(this);
	}
	
	
	@Test
	public void testAssertNullWithMessageFails() {
		AssertNullWithMessageFailsTrial.runTestDelegate(this);
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
	public void testAssertTrueIsFalse() {
		AssertTrueFailsTrial.runTestDelegate(this);
	}
	
	@Test
	public void testAssertTrueIsFalseWithMessage() {
		AssertTrueFailsMessageTrial.runTestDelegate(this);
	}

	@Test
	public void testAssertSameFails() {
		AssertSameFailsTrial.runTestDelegate(this);
	}
	
	
	@Test
	public void testAssertSameWithMessageFails() {
		AssertSameWithMessageFailsTrial.runTestDelegate(this);
	}
	
	@Override
	public void afterTrialTests(I_ApiTrial_TestsResults p) {
		assertGreaterThanOrEquals(0.0 + 
				AssertContainsFailsTrial.getAsserts() +
				AssertContainsWithMessageFailsTrial.getAsserts() + 
				AssertEqualsFailsTrial.getAsserts() +
				AssertEqualsWithMessageFailsTrial.getAsserts() +
				AssertFalseFailsTrial.getAsserts() +
				AssertFalseWithMessageFailsTrial.getAsserts() +
				AssertGreaterThanOrEqualsDoubleDoubleFailsTrial.getAsserts() +
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
				AssertTrueFailsTrial.getAsserts() +
				AssertTrueFailsMessageTrial.getAsserts() +
				AssertSameFailsTrial.getAsserts() +
				AssertSameWithMessageFailsTrial.getAsserts(),
				p.getAssertions());
		assertGreaterThanOrEquals(0.0 + 
				340.0, 
				p.getUniqueAssertions());
		
	}
}
