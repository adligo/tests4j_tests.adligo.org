package org.adligo.tests4j_tests.trials_api;

import java.util.ArrayList;
import java.util.List;

import org.adligo.tests4j.models.shared.coverage.I_PackageCoverage;
import org.adligo.tests4j.models.shared.metadata.I_TrialMetadata;
import org.adligo.tests4j.models.shared.metadata.I_TrialRunMetadata;
import org.adligo.tests4j.models.shared.results.I_ApiTrialResult;
import org.adligo.tests4j.models.shared.results.I_TrialResult;
import org.adligo.tests4j.system.shared.trials.I_Trial;
import org.adligo.tests4j.system.shared.trials.PackageScope;
import org.adligo.tests4j.system.shared.trials.Test;
import org.adligo.tests4j_tests.base_trials.ApiCountingTrial;
import org.adligo.tests4j_tests.base_trials.I_CountType;
import org.adligo.tests4j_tests.trials_api.bad_mock_api_trials.AbstractTestTrial;
import org.adligo.tests4j_tests.trials_api.bad_mock_api_trials.AfterTrialHasParamsTrial;
import org.adligo.tests4j_tests.trials_api.bad_mock_api_trials.AfterTrialNotPublicTrial;
import org.adligo.tests4j_tests.trials_api.bad_mock_api_trials.AfterTrialNotStaticTrial;
import org.adligo.tests4j_tests.trials_api.bad_mock_api_trials.BadPackageConstructorTrial;
import org.adligo.tests4j_tests.trials_api.bad_mock_api_trials.BeforeTrialHasParamsTrial;
import org.adligo.tests4j_tests.trials_api.bad_mock_api_trials.BeforeTrialNotPublicTrial;
import org.adligo.tests4j_tests.trials_api.bad_mock_api_trials.BeforeTrialNotStaticTrial;
import org.adligo.tests4j_tests.trials_api.bad_mock_api_trials.MultipleAfterTrialTrial;
import org.adligo.tests4j_tests.trials_api.bad_mock_api_trials.MultipleBeforeTrialTrial;
import org.adligo.tests4j_tests.trials_api.bad_mock_api_trials.NoPackageScopeAnnotationTrial;
import org.adligo.tests4j_tests.trials_api.bad_mock_api_trials.NoTestsTrial;
import org.adligo.tests4j_tests.trials_api.bad_mock_api_trials.PackageScopeAnnotationNoNameTrial;
import org.adligo.tests4j_tests.trials_api.bad_mock_api_trials.ProtectedTestTrial;
import org.adligo.tests4j_tests.trials_api.bad_mock_api_trials.SimpleRerunTrial;
import org.adligo.tests4j_tests.trials_api.bad_mock_api_trials.StaticTestTrial;
import org.adligo.tests4j_tests.trials_api.bad_mock_api_trials.TestWithParamsTrial;
import org.adligo.tests4j_tests.trials_api.common.ExpectedPassRunner;

@PackageScope (packageName = "org.adligo.tests4j.run")
public class BadApiTrials_Trial extends ApiCountingTrial {

	@Test
	public void testAbstractTest() throws Exception {
		AbstractTestTrial.runTestDelegate(this);
	}
	
	@Test
	public void testAfterTrialHasParams() throws Exception {
		AfterTrialHasParamsTrial.runTestDelegate(this);
	}
	
	@Test
	public void testAfterTrialNotPublic() throws Exception {
		AfterTrialNotPublicTrial.runTestDelegate(this);
	}
	
	@Test
	public void testAfterTrialNotStatic() throws Exception {
		AfterTrialNotStaticTrial.runTestDelegate(this);
	}
	
	@Test
	public void testBadPackageConstructorTrail() throws Exception {
		BadPackageConstructorTrial.runTestDelegate(this);
	}
	
	@Test
	public void testBeforeTrialHasParams() throws Exception {
		BeforeTrialHasParamsTrial.runTestDelegate(this);
	}
	
	@Test
	public void testBeforeTrialNotPublic() throws Exception {
		BeforeTrialNotPublicTrial.runTestDelegate(this);
	}
	
	@Test
	public void testBeforeTrialNotStatic() throws Exception {
		BeforeTrialNotStaticTrial.runTestDelegate(this);
	}
	
	@Test
	public void testMultipleAfterTrial() throws Exception {
		MultipleAfterTrialTrial.runTestDelegate(this);
	}
	
	@Test
	public void testMultipleBeforeTrial() throws Exception {
		MultipleBeforeTrialTrial.runTestDelegate(this);
	}
	
	@Test
	public void testNoTests() throws Exception {
		NoTestsTrial.runTestDelegate(this);
	}
	
	@Test
	public void testPackageScopeAnnotationNoNameTrial() throws Exception {
		PackageScopeAnnotationNoNameTrial.runTestDelegate(this);
	}
	
	@Test
	public void testNoPackageScopeAnnotationTrial() throws Exception {
		NoPackageScopeAnnotationTrial.runTestDelegate(this);
	}
	
	@Test
	public void testProtectedTestTrial() throws Exception {
		ProtectedTestTrial.runTestDelegate(this);
	}
	
	@Test
	public void testStaticTestTrial() throws Exception {
		StaticTestTrial.runTestDelegate(this);
	}
	
	@Test
	public void testTestWithParams() throws Exception {
		TestWithParamsTrial.runTestDelegate(this);
	}
	
	@Test
	public void testTrialRunOverlapPrevention() throws Exception {
		ExpectedPassRunner runner = new ExpectedPassRunner();
		List<Class<? extends I_Trial>> trials = new ArrayList<>();
		for (int i = 0; i < 50; i++) {
			trials.add(SimpleRerunTrial.class);
		}
		runner.run(trials);
		
		I_TrialRunMetadata metadata = runner.getMetadata();
		assertNotNull(metadata);
		List<? extends I_TrialMetadata> trialsMetadata = metadata.getAllTrialMetadata();
		assertNotNull(trialsMetadata);
		assertEquals("java.util.Collections$UnmodifiableRandomAccessList", 
				trialsMetadata.getClass().getName());
		assertEquals(50, trialsMetadata.size());
		for (int i = 0; i < 50; i++) {
			I_TrialMetadata trialMeta = trialsMetadata.get(i);
			assertNotNull(trialMeta);
			assertEquals("org.adligo.tests4j_tests.trials_api.bad_mock_api_trials.SimpleRerunTrial", 
					trialMeta.getTrialName());
			assertEquals(0L, trialMeta.getTimeout());
			assertFalse(trialMeta.isIgnored());
		}
		
		List<I_TrialResult> results = runner.getResults();
		assertEquals(50, results.size());
		for (int i = 0; i < 50; i++) {
			I_TrialResult result = results.get(i);
			assertNotNull(result);
			assertTrue(result.isPassed());
		}
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
	public int getTests(I_CountType type) {
		return super.getTests(type, 17);
	}

	@Override
	public int getAsserts(I_CountType type) {
		int asserts = AbstractTestTrial.getAsserts() +
				AfterTrialHasParamsTrial.getAsserts() +
				AfterTrialNotPublicTrial.getAsserts() + 
				AfterTrialNotStaticTrial.getAsserts()  +
				BadPackageConstructorTrial.getAsserts() +
				BeforeTrialHasParamsTrial.getAsserts() +
				BeforeTrialNotPublicTrial.getAsserts() +
				BeforeTrialNotStaticTrial.getAsserts()+
				MultipleAfterTrialTrial.getAsserts() +
				MultipleBeforeTrialTrial.getAsserts() +
				NoTestsTrial.getAsserts() +
				PackageScopeAnnotationNoNameTrial.getAsserts() +
				NoPackageScopeAnnotationTrial.getAsserts()+
				ProtectedTestTrial.getAsserts()+
				StaticTestTrial.getAsserts()   +
				TestWithParamsTrial.getAsserts()+
				305;//305 is from testTrialRunOverlapPrevention
		//overrode afterTrialTests above
		if (type.isFromMetaWithCoverage()) {
			return super.getAsserts(type, asserts + 1);
		} else {
			return super.getAsserts(type, asserts);
		}
	}

	@Override
	public int getUniqueAsserts(I_CountType type) {
		int uAsserts = 333;
		//overrode afterTrialTests above
		if (type.isFromMetaWithCoverage()) {
			return super.getUniqueAsserts(type, uAsserts + 1);
		} else {
			return super.getUniqueAsserts(type, uAsserts);
		}
	}
}
