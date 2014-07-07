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
import org.adligo.tests4j.models.shared.trials.PackageScope;
import org.adligo.tests4j.models.shared.trials.Test;
import org.adligo.tests4j_tests.base_abstract_trials.ApiCountingTrial;
import org.adligo.tests4j_tests.trials_api.bad_mock_api_trials.BadPackageConstructorTrial;
import org.adligo.tests4j_tests.trials_api.bad_mock_api_trials.NoPackageScopeAnnotationTrial;
import org.adligo.tests4j_tests.trials_api.bad_mock_api_trials.PackageScopeAnnotationNoNameTrial;
import org.adligo.tests4j_tests.trials_api.bad_mock_source_file_trials.AbstractTestTrial;
import org.adligo.tests4j_tests.trials_api.bad_mock_source_file_trials.AfterTrialHasParamsTrial;
import org.adligo.tests4j_tests.trials_api.bad_mock_source_file_trials.AfterTrialNotPublicTrial;
import org.adligo.tests4j_tests.trials_api.bad_mock_source_file_trials.AfterTrialNotStaticTrial;
import org.adligo.tests4j_tests.trials_api.bad_mock_source_file_trials.BadConstructorTrial;
import org.adligo.tests4j_tests.trials_api.bad_mock_source_file_trials.BeforeTrialHasParamsTrial;
import org.adligo.tests4j_tests.trials_api.bad_mock_source_file_trials.BeforeTrialNotPublicTrial;
import org.adligo.tests4j_tests.trials_api.bad_mock_source_file_trials.BeforeTrialNotStaticTrial;
import org.adligo.tests4j_tests.trials_api.bad_mock_source_file_trials.MultipleAfterTrialTrial;
import org.adligo.tests4j_tests.trials_api.bad_mock_source_file_trials.MultipleBeforeTrialTrial;
import org.adligo.tests4j_tests.trials_api.bad_mock_source_file_trials.NoSourceFileScopeAnnotationTrial;
import org.adligo.tests4j_tests.trials_api.bad_mock_source_file_trials.NoTestsTrial;
import org.adligo.tests4j_tests.trials_api.bad_mock_source_file_trials.ProtectedTestTrial;
import org.adligo.tests4j_tests.trials_api.bad_mock_source_file_trials.StaticTestTrial;
import org.adligo.tests4j_tests.trials_api.bad_mock_source_file_trials.TestWithParamsTrial;
import org.adligo.tests4j_tests.trials_api.common.ExpectedFailureRunner;

@PackageScope (packageName = "org.adligo.tests4j")
public class BadSourceFileTrials_Trial extends ApiCountingTrial {

	@Test
	public void testAbstractTestTrialFails() {
		AbstractTestTrial.runTestDelegate(this);
	}
	
	@Test
	public void testAfterTrialHasParams() {
		AfterTrialHasParamsTrial.runTestDelegate(this);
	}
	
	@Test
	public void testAfterTrialNotPublic() {
		AfterTrialNotPublicTrial.runTestDelegate(this);
	}
	
	@Test
	public void testAfterTrialNotStatic() {
		AfterTrialNotStaticTrial.runTestDelegate(this);
	}
	
	@Test
	public void testBadConstructorTrialFails() {
		BadConstructorTrial.runTestDelegate(this);
	}
	
	@Test
	public void testBeforeTrialHasParams() {
		BeforeTrialHasParamsTrial.runTestDelegate(this);
	}
	
	@Test
	public void testBeforeTrialNotPublic() {
		BeforeTrialNotPublicTrial.runTestDelegate(this);
	}
	
	@Test
	public void testBeforeTrialNotStaticFails() {
		BeforeTrialNotStaticTrial.runTestDelegate(this);
	}
	
	@Test
	public void testMultipleAfterTrial() {
		MultipleAfterTrialTrial.runTestDelegate(this);
	}
	
	@Test
	public void testMultipleBeforeTrial() {
		MultipleBeforeTrialTrial.runTestDelegate(this);
	}
	
	@Test
	public void testNoSourceFileScopeAnnotation() {
		NoSourceFileScopeAnnotationTrial.runTestDelegate(this);
	}

	@Test
	public void testNoTestsTrialFails() {
		NoTestsTrial.runTestDelegate(this);
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
	public void testTestWithParams() {
		TestWithParamsTrial.runTestDelegate(this);
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
		return 	15;
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
		NoSourceFileScopeAnnotationTrial.getAsserts() +
		NoTestsTrial.getAsserts() +
		ProtectedTestTrial.getAsserts() +
		StaticTestTrial.getAsserts() +
		TestWithParamsTrial.getAsserts();
	}

	@Override
	public int getUniqueAsserts() {
		// TODO Auto-generated method stub
		return 213;
	}
}
