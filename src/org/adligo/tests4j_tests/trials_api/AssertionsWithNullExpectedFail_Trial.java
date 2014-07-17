package org.adligo.tests4j_tests.trials_api;

import org.adligo.tests4j.models.shared.coverage.I_PackageCoverage;
import org.adligo.tests4j.models.shared.results.I_ApiTrialResult;
import org.adligo.tests4j.models.shared.trials.ApiTrial;
import org.adligo.tests4j.models.shared.trials.IgnoreTest;
import org.adligo.tests4j.models.shared.trials.PackageScope;
import org.adligo.tests4j.models.shared.trials.Test;
import org.adligo.tests4j_tests.base_abstract_trials.ApiCountingTrial;
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
public class AssertionsWithNullExpectedFail_Trial extends ApiCountingTrial {
	
	@Test
	public void testAssertContainsNullFails() throws Exception {
		AssertContainsNullFailsTrial.runTestDelegate(this);
	}
	
	@Test
	public void testAssertContainsNullWithMessageFails() throws Exception {
		AssertContainsNullWithMessageFailsTrial.runTestDelegate(this);
	}
	
	@Test
	public void testAssertEqualsNullFails() throws Exception {
		AssertEqualsNullFailsTrial.runTestDelegate(this);
	}

	@Test
	public void testAssertEqualsNullWithMessageFails() throws Exception {
		AssertEqualsNullWithMessageFailsTrial.runTestDelegate(this);
	}
	
	@Test
	public void testAssertNotEqualsNullFails() throws Exception {
		AssertNotEqualsNullFailsTrial.runTestDelegate(this);
	}
	
	@Test
	public void testAssertNotEqualsNullNullWithMessageFails() throws Exception {
		AssertNotEqualsNullWithMessageFailsTrial.runTestDelegate(this);
	}
	
	@Test
	public void testAssertNotSameNullFails() throws Exception {
		AssertNotSameNullFailsTrial.runTestDelegate(this);
	}
	
	@Test
	public void testAssertNotSameNullWithMessageFails() throws Exception {
		AssertNotSameNullWithMessageFailsTrial.runTestDelegate(this);
	}
	
	@Test
	public void testAssertNotUniformNullFails() throws Exception {
		AssertNotUniformNullFailsTrial.runTestDelegate(this);
	}
	
	@Test
	public void testAssertNotUniformNullNullWithMessageFails() throws Exception {
		AssertNotUniformNullWithMessageFailsTrial.runTestDelegate(this);
	}
	
	@Test
	public void testAssertSameNullFails() throws Exception {
		AssertSameNullFailsTrial.runTestDelegate(this);
	}
	
	@Test
	public void testAssertSameNullNullWithMessageFails() throws Exception {
		AssertSameNullWithMessageFailsTrial.runTestDelegate(this);
	}
	
	@Test
	public void testAssertThrownNullFails() throws Exception {
		AssertThrownNullFailsTrial.runTestDelegate(this);
	}
	
	@Test
	public void testAssertThrownNullThrowerFails() throws Exception {
		AssertThrownNullThrowerFailsTrial.runTestDelegate(this);
	}
	
	@Test
	public void testAssertThrownNullThrowerWithMessageFails() throws Exception {
		AssertThrownNullThrowerWithMessageFailsTrial.runTestDelegate(this);
	}
	
	@Test
	public void testAssertThrownNullWithMessageFails() throws Exception {
		AssertThrownNullWithMessageFailsTrial.runTestDelegate(this);
	}
	
	@Test
	public void testAssertThrownUniformNullFails() throws Exception {
		AssertThrownUniformNullFailsTrial.runTestDelegate(this);
	}
	
	@Test
	public void testAssertThrownUniformNullWithMessageFails() throws Exception {
		AssertThrownUniformNullWithMessageFailsTrial.runTestDelegate(this);
	}
	
	@Test
	public void testAssertThrownUniformNullThrowerFailsTrialFails() throws Exception {
		AssertThrownUniformNullThrowerFailsTrial.runTestDelegate(this);
	}
	
	@Test
	public void testAssertUniformNullWithMessageFailsTrialFails() throws Exception {
		AssertUniformNullWithMessageFailsTrial.runTestDelegate(this);
	}
	
	@Test
	public void testAssertThrownUniformNullThrowerWithMessageFailsTrialFails() throws Exception {
		AssertThrownUniformNullThrowerWithMessageFailsTrial.runTestDelegate(this);
	}
	
	@Test
	public void testAssertUniformNullFailsTrialFails() throws Exception {
		AssertUniformNullFailsTrial.runTestDelegate(this);
	}
	
	
	
	@Override
	public void afterTrialTests(I_ApiTrialResult p) {
		assertCounts(p);
		if (p.hasRecordedCoverage()) {
			I_PackageCoverage coverage = p.getPackageCoverage();
			//TODO this should be something not zero
			assertGreaterThanOrEquals(0.0, coverage.getPercentageCoveredDouble());
		}
	}

	@Override
	public int getTests() {
		return 22;
	}

	@Override
	public int getAsserts() {
		return AssertContainsNullFailsTrial.getAsserts() +
				AssertContainsNullWithMessageFailsTrial.getAsserts() +
				AssertEqualsNullFailsTrial.getAsserts() +
				AssertEqualsNullWithMessageFailsTrial.getAsserts() +
				AssertNotEqualsNullFailsTrial.getAsserts()+
				AssertNotEqualsNullWithMessageFailsTrial.getAsserts() +
				AssertNotSameNullFailsTrial.getAsserts()+
				AssertNotSameNullWithMessageFailsTrial.getAsserts()   +
				AssertNotUniformNullFailsTrial.getAsserts() +
				AssertNotUniformNullWithMessageFailsTrial.getAsserts()+
				AssertSameNullFailsTrial.getAsserts()  +
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
				AssertThrownUniformNullThrowerWithMessageFailsTrial.getAsserts();
	}

	@Override
	public int getUniqueAsserts() {
		return 474;
	}
}
