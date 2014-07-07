package org.adligo.tests4j_tests.trials_api;

import java.util.List;

import org.adligo.tests4j.models.shared.coverage.I_PackageCoverage;
import org.adligo.tests4j.models.shared.metadata.I_TestMetadata;
import org.adligo.tests4j.models.shared.metadata.I_TrialMetadata;
import org.adligo.tests4j.models.shared.metadata.I_TrialRunMetadata;
import org.adligo.tests4j.models.shared.results.I_ApiTrialResult;
import org.adligo.tests4j.models.shared.results.I_TrialFailure;
import org.adligo.tests4j.models.shared.results.I_TrialResult;
import org.adligo.tests4j.models.shared.trials.ApiTrial;
import org.adligo.tests4j.models.shared.trials.IgnoreTest;
import org.adligo.tests4j.models.shared.trials.PackageScope;
import org.adligo.tests4j.models.shared.trials.Test;
import org.adligo.tests4j_tests.base_abstract_trials.ApiCountingTrial;
import org.adligo.tests4j_tests.trials_api.bad_mock_source_file_trials.NoSourceFileScopeAnnotationTrial;
import org.adligo.tests4j_tests.trials_api.bad_mock_use_case_trials.AbstractTestTrial;
import org.adligo.tests4j_tests.trials_api.bad_mock_use_case_trials.AfterTrialHasParamsTrial;
import org.adligo.tests4j_tests.trials_api.bad_mock_use_case_trials.AfterTrialNotPublicTrial;
import org.adligo.tests4j_tests.trials_api.bad_mock_use_case_trials.AfterTrialNotStaticTrial;
import org.adligo.tests4j_tests.trials_api.bad_mock_use_case_trials.BadConstructorTrial;
import org.adligo.tests4j_tests.trials_api.bad_mock_use_case_trials.BeforeTrialHasParamsTrial;
import org.adligo.tests4j_tests.trials_api.bad_mock_use_case_trials.BeforeTrialNotPublicTrial;
import org.adligo.tests4j_tests.trials_api.bad_mock_use_case_trials.BeforeTrialNotStaticTrial;
import org.adligo.tests4j_tests.trials_api.bad_mock_use_case_trials.CreateThreadInBeforeTests;
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
import org.adligo.tests4j_tests.trials_api.common.ExpectedFailureRunner;

@PackageScope (packageName = "org.adligo.tests4j")
public class BadUseCaseTrials_Trial extends ApiCountingTrial {

	@Test
	public void testAbstractTestTrialFails() {
		AbstractTestTrial.runTestDelegate(this);
	}
	
	@Test
	public void testAfterTrialHasParamsTrialFails() {
		AfterTrialHasParamsTrial.runTestDelegate(this);
	}
	
	@Test
	public void testAfterTrialNotPublicTrialFails() {
		AfterTrialNotPublicTrial.runTestDelegate(this);
	}
	
	@Test
	public void testAfterTrialNotStaticTrialFails() {
		AfterTrialNotStaticTrial.runTestDelegate(this);
	}
	
	@Test
	public void testBadConstructorTrialFails() {
		BadConstructorTrial.runTestDelegate(this);
	}
	
	@Test
	public void testBeforeTrialHasParamsTrialFails() {
		BeforeTrialHasParamsTrial.runTestDelegate(this);
	}
	
	@Test
	public void testBeforeTrialNotPublicTrialFails() {
		BeforeTrialNotPublicTrial.runTestDelegate(this);
	}
	
	@Test
	public void testBeforeTrialNotStaticTrialFails() {
		BeforeTrialNotStaticTrial.runTestDelegate(this);
	}
	
	@Test
	public void testMultipleAfterTrialTrialFails() {
		MultipleAfterTrialTrial.runTestDelegate(this);
	}
	
	@Test
	public void testMultipleBeforeTrialTrialFails() {
		MultipleBeforeTrialTrial.runTestDelegate(this);
	}
	
	@Test
	public void testNoTestsTrialFails() {
		NoTestsTrial.runTestDelegate(this);
	}
	
	@Test
	public void testNoUseCaseAnnotationTrialFails() {
		NoUseCaseAnnotationTrial.runTestDelegate(this);
	}
	
	@Test
	public void testProtectedTestTrialFails() {
		ProtectedTestTrial.runTestDelegate(this);
	}
	
	@Test
	public void testStaticTestTrialFails() {
		StaticTestTrial.runTestDelegate(this);
	}
	
	@Test
	public void testTestWithParamsTrialFails() {
		TestWithParamsTrial.runTestDelegate(this);
	}
	
	@Test
	public void testUseCaseAnnotationNoNownTrialFails() {
		UseCaseAnnotationNoNownTrial.runTestDelegate(this);
	}
	
	@Test
	public void testUseCaseAnnotationNoSystemTrialFails() {
		UseCaseAnnotationNoSystemTrial.runTestDelegate(this);
	}
	
	@Test
	public void testUseCaseAnnotationNoVerb() {
		UseCaseAnnotationNoVerbTrial.runTestDelegate(this);
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
				UseCaseAnnotationNoVerbTrial.getAsserts();
	}

	@Override
	public int getUniqueAsserts() {
		return 252;
	}
}