package org.adligo.tests4j_tests.trials_api;

import org.adligo.tests4j.models.shared.results.feedback.I_ApiTrial_TestsResults;
import org.adligo.tests4j.models.shared.trials.ApiTrial;
import org.adligo.tests4j.models.shared.trials.PackageScope;
import org.adligo.tests4j.models.shared.trials.Test;
import org.adligo.tests4j_tests.trials_api.asserts_null_expected_trials.AssertContainsNullFailsTrial;
import org.adligo.tests4j_tests.trials_api.asserts_null_expected_trials.AssertContainsNullWithMessageFailsTrial;
import org.adligo.tests4j_tests.trials_api.asserts_null_expected_trials.AssertEqualsNullFailsTrial;
import org.adligo.tests4j_tests.trials_api.asserts_null_expected_trials.AssertEqualsNullWithMessageFailsTrial;
import org.adligo.tests4j_tests.trials_api.asserts_null_expected_trials.AssertNotEqualsNullFailsTrial;
import org.adligo.tests4j_tests.trials_api.asserts_null_expected_trials.AssertNotEqualsNullWithMessageFailsTrial;
import org.adligo.tests4j_tests.trials_api.asserts_null_expected_trials.AssertNotSameNullFailsTrial;
import org.adligo.tests4j_tests.trials_api.asserts_null_expected_trials.AssertNotSameNullWithMessageFailsTrial;
import org.adligo.tests4j_tests.trials_api.asserts_null_expected_trials.AssertNotUniformNullFailsTrial;
import org.adligo.tests4j_tests.trials_api.asserts_null_expected_trials.AssertNotUniformNullWithMessageFailsTrial;
import org.adligo.tests4j_tests.trials_api.asserts_null_expected_trials.AssertSameNullFailsTrial;
import org.adligo.tests4j_tests.trials_api.asserts_null_expected_trials.AssertSameNullWithMessageFailsTrial;
import org.adligo.tests4j_tests.trials_api.asserts_null_expected_trials.AssertThrownNullFailsTrial;
import org.adligo.tests4j_tests.trials_api.asserts_null_expected_trials.AssertThrownNullThrowerFailsTrial;
import org.adligo.tests4j_tests.trials_api.asserts_null_expected_trials.AssertThrownNullThrowerWithMessageFailsTrial;
import org.adligo.tests4j_tests.trials_api.asserts_null_expected_trials.AssertThrownNullWithMessageFailsTrial;
import org.adligo.tests4j_tests.trials_api.asserts_null_expected_trials.AssertThrownUniformNullFailsTrial;
import org.adligo.tests4j_tests.trials_api.asserts_null_expected_trials.AssertThrownUniformNullThrowerFailsTrial;
import org.adligo.tests4j_tests.trials_api.asserts_null_expected_trials.AssertThrownUniformNullThrowerWithMessageFailsTrial;
import org.adligo.tests4j_tests.trials_api.asserts_null_expected_trials.AssertThrownUniformNullWithMessageFailsTrial;
import org.adligo.tests4j_tests.trials_api.asserts_null_expected_trials.AssertUniformNullFailsTrial;
import org.adligo.tests4j_tests.trials_api.asserts_null_expected_trials.AssertUniformNullWithMessageFailsTrial;

@PackageScope (packageName = "org.adligo.tests4j")
public class AssertionsWithNullExpectedFail_Trial extends ApiTrial {
	
	@Test
	public void testAssertContainsNullFails() {
		AssertContainsNullFailsTrial.runTestDelegate(this);
	}
	
	@Test
	public void testAssertContainsNullWithMessageFails() {
		AssertContainsNullWithMessageFailsTrial.runTestDelegate(this);
	}
	
	@Test
	public void testAssertEqualsNullFails() {
		AssertEqualsNullFailsTrial.runTestDelegate(this);
	}
	
	@Test
	public void testAssertEqualsNullWithMessageFails() {
		AssertEqualsNullWithMessageFailsTrial.runTestDelegate(this);
	}
	
	@Test
	public void testAssertNotEqualsNullFails() {
		AssertNotEqualsNullFailsTrial.runTestDelegate(this);
	}
	
	@Test
	public void testAssertNotEqualsNullNullWithMessageFails() {
		AssertNotEqualsNullWithMessageFailsTrial.runTestDelegate(this);
	}
	
	@Test
	public void testAssertNotSameNullFails() {
		AssertNotSameNullFailsTrial.runTestDelegate(this);
	}
	
	@Test
	public void testAssertNotSameNullNullWithMessageFails() {
		AssertNotSameNullWithMessageFailsTrial.runTestDelegate(this);
	}
	
	@Test
	public void testAssertNotUniformNullFails() {
		AssertNotUniformNullFailsTrial.runTestDelegate(this);
	}
	
	@Test
	public void testAssertNotUniformNullNullWithMessageFails() {
		AssertNotUniformNullWithMessageFailsTrial.runTestDelegate(this);
	}
	
	@Test
	public void testAssertSameNullFails() {
		AssertSameNullFailsTrial.runTestDelegate(this);
	}
	
	@Test
	public void testAssertSameNullNullWithMessageFails() {
		AssertSameNullWithMessageFailsTrial.runTestDelegate(this);
	}
	
	@Test
	public void testAssertThrownNullFails() {
		AssertThrownNullFailsTrial.runTestDelegate(this);
	}
	
	@Test
	public void testAssertThrownNullThrowerFails() {
		AssertThrownNullThrowerFailsTrial.runTestDelegate(this);
	}
	
	@Test
	public void testAssertThrownNullThrowerWithMessageFails() {
		AssertThrownNullThrowerWithMessageFailsTrial.runTestDelegate(this);
	}
	
	@Test
	public void testAssertThrownNullWithMessageFails() {
		AssertThrownNullWithMessageFailsTrial.runTestDelegate(this);
	}
	
	@Test
	public void testAssertThrownUniformNullFails() {
		AssertThrownUniformNullFailsTrial.runTestDelegate(this);
	}
	
	@Test
	public void testAssertThrownUniformNullWithMessageFails() {
		AssertThrownUniformNullWithMessageFailsTrial.runTestDelegate(this);
	}
	
	@Test
	public void testAssertThrownUniformNullThrowerFails() {
		AssertThrownUniformNullThrowerFailsTrial.runTestDelegate(this);
	}
	
	@Test
	public void testAssertThrownUniformNullThrowerWithMessageFails() {
		AssertThrownUniformNullThrowerWithMessageFailsTrial.runTestDelegate(this);
	}
	
	@Test
	public void testAssertUniformNullFails() {
		AssertUniformNullFailsTrial.runTestDelegate(this);
	}
	
	@Test
	public void testThrownUniformNullWithMessageFails() {
		AssertUniformNullWithMessageFailsTrial.runTestDelegate(this);
	}
	
	@Override
	public void afterTrialTests(I_ApiTrial_TestsResults p) {
		assertGreaterThanOrEquals(0.0 + 
				AssertContainsNullFailsTrial.getAsserts() +
				AssertContainsNullWithMessageFailsTrial.getAsserts() +
				AssertEqualsNullFailsTrial.getAsserts() +
				AssertEqualsNullWithMessageFailsTrial.getAsserts() +
				AssertNotEqualsNullFailsTrial.getAsserts() +
				AssertNotEqualsNullWithMessageFailsTrial.getAsserts() +
				AssertNotSameNullFailsTrial.getAsserts() +
				AssertNotSameNullWithMessageFailsTrial.getAsserts() +
				AssertNotUniformNullFailsTrial.getAsserts() +
				AssertNotUniformNullWithMessageFailsTrial.getAsserts() +
				AssertSameNullFailsTrial.getAsserts() +
				AssertSameNullWithMessageFailsTrial.getAsserts() +
				AssertThrownNullFailsTrial.getAsserts() + 
				AssertThrownNullThrowerFailsTrial.getAsserts() + 
				AssertThrownNullThrowerWithMessageFailsTrial.getAsserts() +
				AssertThrownNullWithMessageFailsTrial.getAsserts() +
				AssertThrownUniformNullFailsTrial.getAsserts() + 
				AssertThrownUniformNullWithMessageFailsTrial.getAsserts() +
				AssertUniformNullFailsTrial.getAsserts() + 
				AssertUniformNullWithMessageFailsTrial.getAsserts() +
				AssertThrownUniformNullThrowerFailsTrial.getAsserts() + 
				AssertThrownUniformNullThrowerWithMessageFailsTrial.getAsserts() 
				,
				
				p.getAssertions());
		assertGreaterThanOrEquals(0.0 + 
				60.0, 
				p.getUniqueAssertions());
		
	}
}
