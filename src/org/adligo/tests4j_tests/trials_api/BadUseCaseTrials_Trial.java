package org.adligo.tests4j_tests.trials_api;

import org.adligo.tests4j.models.shared.coverage.I_PackageCoverage;
import org.adligo.tests4j.models.shared.results.I_ApiTrialResult;
import org.adligo.tests4j.models.shared.trials.PackageScope;
import org.adligo.tests4j.models.shared.trials.Test;
import org.adligo.tests4j_tests.base_trials.ApiCountingTrial;
import org.adligo.tests4j_tests.trials_api.bad_mock_use_case_trials.AbstractTestTrial;
import org.adligo.tests4j_tests.trials_api.bad_mock_use_case_trials.AfterTrialHasParamsTrial;
import org.adligo.tests4j_tests.trials_api.bad_mock_use_case_trials.AfterTrialNotPublicTrial;
import org.adligo.tests4j_tests.trials_api.bad_mock_use_case_trials.AfterTrialNotStaticTrial;
import org.adligo.tests4j_tests.trials_api.bad_mock_use_case_trials.BadConstructorTrial;
import org.adligo.tests4j_tests.trials_api.bad_mock_use_case_trials.BeforeTrialHasParamsTrial;
import org.adligo.tests4j_tests.trials_api.bad_mock_use_case_trials.BeforeTrialNotPublicTrial;
import org.adligo.tests4j_tests.trials_api.bad_mock_use_case_trials.BeforeTrialNotStaticTrial;
import org.adligo.tests4j_tests.trials_api.bad_mock_use_case_trials.MultipleAfterTrialTrial;
import org.adligo.tests4j_tests.trials_api.bad_mock_use_case_trials.MultipleBeforeTrialTrial;
import org.adligo.tests4j_tests.trials_api.bad_mock_use_case_trials.NoTestsTrial;
import org.adligo.tests4j_tests.trials_api.bad_mock_use_case_trials.NoUseCaseAnnotationTrial;
import org.adligo.tests4j_tests.trials_api.bad_mock_use_case_trials.ProtectedTestTrial;
import org.adligo.tests4j_tests.trials_api.bad_mock_use_case_trials.StaticTestTrial;
import org.adligo.tests4j_tests.trials_api.bad_mock_use_case_trials.TestWithParamsTrial;
import org.adligo.tests4j_tests.trials_api.bad_mock_use_case_trials.UseCaseAnnotationNoNownTrial;
import org.adligo.tests4j_tests.trials_api.bad_mock_use_case_trials.UseCaseAnnotationNoSystemTrial;
import org.adligo.tests4j_tests.trials_api.bad_mock_use_case_trials.UseCaseAnnotationNoVerbTrial;

@PackageScope (packageName = "org.adligo.tests4j")
public class BadUseCaseTrials_Trial extends ApiCountingTrial {

	@Test
	public void testAbstractTestTrialFails()  throws Exception {
		AbstractTestTrial.runTestDelegate(this);
	}
	
	@Test
	public void testAfterTrialHasParamsTrialFails()  throws Exception {
		AfterTrialHasParamsTrial.runTestDelegate(this);
	}
	
	@Test
	public void testAfterTrialNotPublicTrialFails()  throws Exception {
		AfterTrialNotPublicTrial.runTestDelegate(this);
	}
	
	@Test
	public void testAfterTrialNotStaticTrialFails()  throws Exception {
		AfterTrialNotStaticTrial.runTestDelegate(this);
	}
	
	@Test
	public void testBadConstructorTrialFails()  throws Exception {
		BadConstructorTrial.runTestDelegate(this);
	}
	
	@Test
	public void testBeforeTrialHasParamsTrialFails()  throws Exception {
		BeforeTrialHasParamsTrial.runTestDelegate(this);
	}
	
	@Test
	public void testBeforeTrialNotPublicTrialFails()  throws Exception {
		BeforeTrialNotPublicTrial.runTestDelegate(this);
	}
	
	@Test
	public void testBeforeTrialNotStaticTrialFails()  throws Exception {
		BeforeTrialNotStaticTrial.runTestDelegate(this);
	}
	
	@Test
	public void testMultipleAfterTrialTrialFails()  throws Exception  {
		MultipleAfterTrialTrial.runTestDelegate(this);
	}
	
	@Test
	public void testMultipleBeforeTrialTrialFails()  throws Exception {
		MultipleBeforeTrialTrial.runTestDelegate(this);
	}
	
	@Test
	public void testNoTestsTrialFails()  throws Exception {
		NoTestsTrial.runTestDelegate(this);
	}
	
	@Test
	public void testNoUseCaseAnnotationTrialFails()  throws Exception {
		NoUseCaseAnnotationTrial.runTestDelegate(this);
	}
	
	@Test
	public void testProtectedTestTrialFails()  throws Exception {
		ProtectedTestTrial.runTestDelegate(this);
	}
	
	@Test
	public void testStaticTestTrialFails()  throws Exception {
		StaticTestTrial.runTestDelegate(this);
	}
	
	@Test
	public void testTestWithParamsTrialFails()  throws Exception  {
		TestWithParamsTrial.runTestDelegate(this);
	}
	
	@Test
	public void testUseCaseAnnotationNoNownTrialFails()  throws Exception {
		UseCaseAnnotationNoNownTrial.runTestDelegate(this);
	}
	
	@Test
	public void testUseCaseAnnotationNoSystemTrialFails()  throws Exception {
		UseCaseAnnotationNoSystemTrial.runTestDelegate(this);
	}
	
	@Test
	public void testUseCaseAnnotationNoVerb()  throws Exception {
		UseCaseAnnotationNoVerbTrial.runTestDelegate(this);
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
		return 	18;
	}

	@Override
	public int getAsserts() {
		// TODO Auto-generated method stub
		return AbstractTestTrial.getAsserts() +
				AfterTrialHasParamsTrial.getAsserts() +
				AfterTrialNotPublicTrial.getAsserts() +
				AfterTrialNotStaticTrial.getAsserts() +
				BadConstructorTrial.getAsserts() +
				BeforeTrialHasParamsTrial.getAsserts() +
				BeforeTrialNotPublicTrial.getAsserts() +
				BeforeTrialNotStaticTrial.getAsserts() +
				MultipleAfterTrialTrial.getAsserts() +
				MultipleBeforeTrialTrial.getAsserts() +
				NoTestsTrial.getAsserts() +
				NoUseCaseAnnotationTrial.getAsserts() +
				ProtectedTestTrial.getAsserts() +
				StaticTestTrial.getAsserts() +
				TestWithParamsTrial.getAsserts() +
				UseCaseAnnotationNoNownTrial.getAsserts() +
				UseCaseAnnotationNoSystemTrial.getAsserts() +
				UseCaseAnnotationNoVerbTrial.getAsserts() ;
	}

	@Override
	public int getUniqueAsserts() {
		return 251;
	}
}
