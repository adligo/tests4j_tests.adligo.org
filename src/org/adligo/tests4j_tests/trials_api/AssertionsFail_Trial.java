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
	public void testAssertFalseIsTrue() {
		AssertFalseFailsTrial.runTestDelegate(this);
	}
	
	
	@Test
	public void testAssertFalseIsTrueWithMessage() {
		AssertFalseWithMessageFailsTrial.runTestDelegate(this);
	}
	
	@Test
	public void testAssertTrueIsFalse() {
		AssertTrueFailsTrial.runTestDelegate(this);
	}
	
	@Test
	public void testAssertTrueIsFalseWithMessage() {
		AssertTrueFailsMessageTrial.runTestDelegate(this);
	}


	@Override
	public void afterTrialTests(I_ApiTrial_TestsResults p) {
		assertGreaterThanOrEquals(0.0 + 
				AssertContainsFailsTrial.getAsserts() +
				AssertContainsWithMessageFailsTrial.getAsserts() + 
				AssertEqualsFailsTrial.getAsserts() +
				AssertEqualsWithMessageFailsTrial.getAsserts() +
				AssertGreaterThanOrEqualsDoubleDoubleFailsTrial.getAsserts() +
				AssertGreaterThanOrEqualsDoubleDoubleWithMessageFailsTrial.getAsserts() +
				AssertFalseFailsTrial.getAsserts() +
				AssertFalseWithMessageFailsTrial.getAsserts() +
				AssertTrueFailsTrial.getAsserts() +
				AssertTrueFailsMessageTrial.getAsserts(), 
				p.getAssertions());
		assertGreaterThanOrEquals(0.0 + 
				200.0, 
				p.getUniqueAssertions());
		
	}
}
