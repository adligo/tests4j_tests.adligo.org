package org.adligo.tests4j_tests.trials_api;

import org.adligo.tests4j.models.shared.coverage.I_PackageCoverage;
import org.adligo.tests4j.models.shared.results.I_ApiTrialResult;
import org.adligo.tests4j.models.shared.trials.IgnoreTest;
import org.adligo.tests4j.models.shared.trials.PackageScope;
import org.adligo.tests4j.models.shared.trials.Test;
import org.adligo.tests4j_tests.base_trials.ApiCountingTrial;
import org.adligo.tests4j_tests.trials_api.asserts_null_expected_trials.AssertContainsNullFailsTrialRunner;
import org.adligo.tests4j_tests.trials_api.asserts_null_expected_trials.AssertContainsNullWithMessageFailsTrialRunner;
import org.adligo.tests4j_tests.trials_api.asserts_null_expected_trials.AssertEqualsNullFailsTrialRunner;
import org.adligo.tests4j_tests.trials_api.asserts_null_expected_trials.AssertEqualsNullStringFailsTrialRunner;
import org.adligo.tests4j_tests.trials_api.asserts_null_expected_trials.AssertEqualsNullStringWithMessageFailsTrialRunner;
import org.adligo.tests4j_tests.trials_api.asserts_null_expected_trials.AssertEqualsNullWithMessageFailsTrialRunner;
import org.adligo.tests4j_tests.trials_api.asserts_null_expected_trials.AssertNotEqualsNullFailsTrialRunner;
import org.adligo.tests4j_tests.trials_api.asserts_null_expected_trials.AssertNotEqualsNullStringFailsTrialRunner;
import org.adligo.tests4j_tests.trials_api.asserts_null_expected_trials.AssertNotEqualsNullStringWithMessageFailsTrialRunner;
import org.adligo.tests4j_tests.trials_api.asserts_null_expected_trials.AssertNotEqualsNullWithMessageFailsTrialRunner;
import org.adligo.tests4j_tests.trials_api.asserts_null_expected_trials.AssertNotSameNullFailsTrialRunner;
import org.adligo.tests4j_tests.trials_api.asserts_null_expected_trials.AssertNotSameNullWithMessageFailsTrialRunner;
import org.adligo.tests4j_tests.trials_api.asserts_null_expected_trials.AssertNotUniformNullFailsTrialRunner;
import org.adligo.tests4j_tests.trials_api.asserts_null_expected_trials.AssertNotUniformNullWithMessageFailsTrialRunner;
import org.adligo.tests4j_tests.trials_api.asserts_null_expected_trials.AssertSameNullFailsTrialRunner;
import org.adligo.tests4j_tests.trials_api.asserts_null_expected_trials.AssertSameNullWithMessageFailsTrialRunner;
import org.adligo.tests4j_tests.trials_api.asserts_null_expected_trials.AssertThrownNullFailsTrialRunner;
import org.adligo.tests4j_tests.trials_api.asserts_null_expected_trials.AssertThrownNullThrowerFailsTrialRunner;
import org.adligo.tests4j_tests.trials_api.asserts_null_expected_trials.AssertThrownNullThrowerWithMessageFailsTrialRunner;
import org.adligo.tests4j_tests.trials_api.asserts_null_expected_trials.AssertThrownNullWithMessageFailsTrialRunner;
import org.adligo.tests4j_tests.trials_api.asserts_null_expected_trials.AssertThrownUniformNullFailsTrialRunner;
import org.adligo.tests4j_tests.trials_api.asserts_null_expected_trials.AssertThrownUniformNullThrowerFailsTrialRunner;
import org.adligo.tests4j_tests.trials_api.asserts_null_expected_trials.AssertThrownUniformNullThrowerWithMessageFailsTrialRunner;
import org.adligo.tests4j_tests.trials_api.asserts_null_expected_trials.AssertThrownUniformNullWithMessageFailsTrialRunner;
import org.adligo.tests4j_tests.trials_api.asserts_null_expected_trials.AssertUniformNullFailsTrialRunner;
import org.adligo.tests4j_tests.trials_api.asserts_null_expected_trials.AssertUniformNullWithMessageFailsTrialRunner;

@PackageScope (packageName = "org.adligo.tests4j")
public class AssertionsWithNullExpectedFail_Trial extends ApiCountingTrial {
	
	@Test
	public void testAssertContainsNullFails() throws Exception {
		AssertContainsNullFailsTrialRunner.runTestDelegate(this);
	}
	
	@Test
	public void testAssertContainsNullWithMessageFails() throws Exception {
		AssertContainsNullWithMessageFailsTrialRunner.runTestDelegate(this);
	}
	
	@Test
	public void testAssertEqualsNullFails() throws Exception {
		AssertEqualsNullFailsTrialRunner.runTestDelegate(this);
	}

	@Test
	public void testAssertEqualsNullWithMessageFails() throws Exception {
		AssertEqualsNullWithMessageFailsTrialRunner.runTestDelegate(this);
	}
	
	@Test
	public void testAssertEqualsNullStringFails() throws Exception {
		AssertEqualsNullStringFailsTrialRunner.runTestDelegate(this);
	}

	@Test
	public void testAssertEqualsNullStringWithMessageFails() throws Exception {
		AssertEqualsNullStringWithMessageFailsTrialRunner.runTestDelegate(this);
	}
	
	@Test
	public void testAssertNotEqualsNullFails() throws Exception {
		AssertNotEqualsNullFailsTrialRunner.runTestDelegate(this);
	}
	
	@Test
	public void testAssertNotEqualsNullNullWithMessageFails() throws Exception {
		AssertNotEqualsNullWithMessageFailsTrialRunner.runTestDelegate(this);
	}
	
	@Test
	public void testAssertNotEqualsNullStringFails() throws Exception {
		AssertNotEqualsNullStringFailsTrialRunner.runTestDelegate(this);
	}
	
	@Test
	public void testAssertNotEqualsNullNullStringWithMessageFails() throws Exception {
		AssertNotEqualsNullStringWithMessageFailsTrialRunner.runTestDelegate(this);
	}
	
	@Test
	public void testAssertNotSameNullFails() throws Exception {
		AssertNotSameNullFailsTrialRunner.runTestDelegate(this);
	}
	
	@Test
	public void testAssertNotSameNullWithMessageFails() throws Exception {
		AssertNotSameNullWithMessageFailsTrialRunner.runTestDelegate(this);
	}
	
	@Test
	public void testAssertNotUniformNullFails() throws Exception {
		AssertNotUniformNullFailsTrialRunner.runTestDelegate(this);
	}
	
	@Test
	public void testAssertNotUniformNullNullWithMessageFails() throws Exception {
		AssertNotUniformNullWithMessageFailsTrialRunner.runTestDelegate(this);
	}
	
	@Test
	public void testAssertSameNullFails() throws Exception {
		AssertSameNullFailsTrialRunner.runTestDelegate(this);
	}
	
	@Test
	public void testAssertSameNullNullWithMessageFails() throws Exception {
		AssertSameNullWithMessageFailsTrialRunner.runTestDelegate(this);
	}
	
	@Test
	public void testAssertThrownNullFails() throws Exception {
		AssertThrownNullFailsTrialRunner.runTestDelegate(this);
	}
	
	@Test
	public void testAssertThrownNullThrowerFails() throws Exception {
		AssertThrownNullThrowerFailsTrialRunner.runTestDelegate(this);
	}
	
	@Test
	public void testAssertThrownNullThrowerWithMessageFails() throws Exception {
		AssertThrownNullThrowerWithMessageFailsTrialRunner.runTestDelegate(this);
	}
	
	@Test
	public void testAssertThrownNullWithMessageFails() throws Exception {
		AssertThrownNullWithMessageFailsTrialRunner.runTestDelegate(this);
	}
	
	@Test
	public void testAssertThrownUniformNullFails() throws Exception {
		AssertThrownUniformNullFailsTrialRunner.runTestDelegate(this);
	}
	
	@Test
	public void testAssertThrownUniformNullWithMessageFails() throws Exception {
		AssertThrownUniformNullWithMessageFailsTrialRunner.runTestDelegate(this);
	}
	
	@Test
	public void testAssertThrownUniformNullThrowerFailsTrialFails() throws Exception {
		AssertThrownUniformNullThrowerFailsTrialRunner.runTestDelegate(this);
	}
	
	@Test
	public void testAssertThrownUniformNullThrowerWithMessageFailsTrialFails() throws Exception {
		AssertThrownUniformNullThrowerWithMessageFailsTrialRunner.runTestDelegate(this);
	}
	
	@Test
	public void testAssertUniformNullWithMessageFailsTrialFails() throws Exception {
		AssertUniformNullWithMessageFailsTrialRunner.runTestDelegate(this);
	}
	
	
	
	@Test
	public void testAssertUniformNullFailsTrialFails() throws Exception {
		AssertUniformNullFailsTrialRunner.runTestDelegate(this);
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
		return 26;
	}

	@Override
	public int getAsserts() {
		return AssertContainsNullFailsTrialRunner.getAsserts()+
				AssertContainsNullWithMessageFailsTrialRunner.getAsserts()  +
				AssertEqualsNullFailsTrialRunner.getAsserts() +
				AssertEqualsNullWithMessageFailsTrialRunner.getAsserts() +
				AssertEqualsNullStringFailsTrialRunner.getAsserts() +
				AssertEqualsNullStringWithMessageFailsTrialRunner.getAsserts() +
				AssertNotEqualsNullFailsTrialRunner.getAsserts()+
				AssertNotEqualsNullWithMessageFailsTrialRunner.getAsserts() +
				AssertNotEqualsNullStringFailsTrialRunner.getAsserts()+
				AssertNotEqualsNullStringWithMessageFailsTrialRunner.getAsserts() +
				AssertNotSameNullFailsTrialRunner.getAsserts()+
				AssertNotSameNullWithMessageFailsTrialRunner.getAsserts()   +
				AssertNotUniformNullFailsTrialRunner.getAsserts() +
				AssertNotUniformNullWithMessageFailsTrialRunner.getAsserts()+
				AssertSameNullFailsTrialRunner.getAsserts()  +
				AssertSameNullWithMessageFailsTrialRunner.getAsserts() +
				AssertThrownNullFailsTrialRunner.getAsserts() + 
				AssertThrownNullThrowerFailsTrialRunner.getAsserts() + 
				AssertThrownNullThrowerWithMessageFailsTrialRunner.getAsserts() +
				AssertThrownNullWithMessageFailsTrialRunner.getAsserts() +
				AssertThrownUniformNullFailsTrialRunner.getAsserts() + 
				AssertThrownUniformNullWithMessageFailsTrialRunner.getAsserts() +
				AssertThrownUniformNullThrowerFailsTrialRunner.getAsserts() +
				AssertThrownUniformNullThrowerWithMessageFailsTrialRunner.getAsserts() +
				AssertUniformNullFailsTrialRunner.getAsserts()+ 
				AssertUniformNullWithMessageFailsTrialRunner.getAsserts();
	}

	@Override
	public int getUniqueAsserts() {
		return 520;
	}
}
