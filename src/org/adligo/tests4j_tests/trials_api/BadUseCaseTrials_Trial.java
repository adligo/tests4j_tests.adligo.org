package org.adligo.tests4j_tests.trials_api;

import org.adligo.tests4j.models.shared.coverage.I_PackageCoverageBrief;
import org.adligo.tests4j.models.shared.results.I_ApiTrialResult;
import org.adligo.tests4j.system.shared.trials.IgnoreTest;
import org.adligo.tests4j.system.shared.trials.Ignored;
import org.adligo.tests4j.system.shared.trials.PackageScope;
import org.adligo.tests4j.system.shared.trials.Test;
import org.adligo.tests4j_tests.base_trials.ApiCountingTrial;
import org.adligo.tests4j_tests.base_trials.I_CountType;
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
import org.adligo.tests4j_tests.trials_api.bad_mock_use_case_trials.UseCaseAnnotationEmptyUseCaseScope;
import org.adligo.tests4j_tests.trials_api.bad_mock_use_case_trials.UseCaseAnnotationNameUnknown;

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
	@IgnoreTest (values=@Ignored(ignoredBy = "scott", ignoredOn = "2015-02-23"))
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
	@IgnoreTest (values=@Ignored(ignoredBy = "scott", ignoredOn = "2015-02-23"))
	public void testUseCaseAnnotationEmptyUseCaseName()  throws Exception {
		UseCaseAnnotationEmptyUseCaseScope.runTestDelegate(this);
	}
	
	@Test
	@IgnoreTest (values=@Ignored(ignoredBy = "scott", ignoredOn = "2015-02-23"))
	public void testUseCaseAnnotationUnknownUseCaseName()  throws Exception {
		UseCaseAnnotationNameUnknown.runTestDelegate(this);
	}

	@Override
	public void afterTrialTests(I_ApiTrialResult p) {
		super.afterTrialTests(p);
		if (p.hasRecordedCoverage()) {
			I_PackageCoverageBrief coverage = p.getPackageCoverage();
			assertGreaterThanOrEquals(9.0, coverage.getPercentageCoveredDouble());
		}
	}
	
	@Override
	public int getTests(I_CountType type) {
		return super.getTests(type, 17);
	}

	
	@Override
	public int getAsserts(I_CountType type) {
		int asserts =  AbstractTestTrial.getAsserts() +
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
				//NoUseCaseAnnotationTrial.getAsserts() +
				ProtectedTestTrial.getAsserts() +
				StaticTestTrial.getAsserts() +
				TestWithParamsTrial.getAsserts() /* +
				UseCaseAnnotationEmptyUseCaseScope.getAsserts() +
				UseCaseAnnotationNameUnknown.getAsserts() */
				;
		//overrode afterTrialTests above
		if (type.isFromMetaWithCoverage()) {
			return super.getAsserts(type, asserts + 1);
		} else {
			return super.getAsserts(type, asserts);
		}
	}

	@Override
	public int getUniqueAsserts(I_CountType type) {
		//int uAsserts = 238;
	  int uAsserts = 199;
		//overrode afterTrialTests above
		if (type.isFromMetaWithCoverage()) {
			return super.getUniqueAsserts(type, uAsserts + 1);
		} else {
			return super.getUniqueAsserts(type, uAsserts);
		}
	}
}
