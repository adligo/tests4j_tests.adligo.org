package org.adligo.tests4j_tests.models.shared.en.trials.asserts;

import org.adligo.tests4j.models.shared.coverage.I_SourceFileCoverage;
import org.adligo.tests4j.models.shared.en.asserts.Tests4J_AssertionInputMessages;
import org.adligo.tests4j.models.shared.results.I_SourceFileTrialResult;
import org.adligo.tests4j.models.shared.trials.SourceFileScope;
import org.adligo.tests4j.models.shared.trials.SourceFileTrial;
import org.adligo.tests4j.models.shared.trials.Test;
import org.adligo.tests4j_tests.base_abstract_trials.SourceFileCountingTrial;
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

@SourceFileScope (sourceClass=Tests4J_AssertionInputMessages.class)
public class Tests4J_AssertionInputMessages_Trial extends SourceFileCountingTrial {

	@Test
	public void testMessages() {
		Tests4J_AssertionInputMessages messages = new Tests4J_AssertionInputMessages();
		assertEquals("ExpectedThrownData requires a non null message.",
				Tests4J_AssertionInputMessages.EXPECTED_THROWN_DATA_REQUIRES_A_NON_NULL_MESSAGE);
		assertEquals(Tests4J_AssertionInputMessages.EXPECTED_THROWN_DATA_REQUIRES_A_NON_NULL_MESSAGE,
				messages.getExpectedThrownDataRequiresMessage());
		
		
		assertEquals(Tests4J_AssertionInputMessages.EXPECTED_THROWN_DATA_REQUIRES_A_NON_NULL_THROWABLE_CLASS,
				messages.getExpectedThrownDataRequiresThrowable());
		assertEquals("ExpectedThrownData requires a non null throwable class.",
				Tests4J_AssertionInputMessages.EXPECTED_THROWN_DATA_REQUIRES_A_NON_NULL_THROWABLE_CLASS);
	}

	@Override
	public void afterTrialTests(I_SourceFileTrialResult p) {
		assertCounts(p);
		
		if (p.hasRecordedCoverage()) {
			I_SourceFileCoverage coverage = p.getSourceFileCoverage();
			assertGreaterThanOrEquals(100.0, coverage.getPercentageCoveredDouble());
		}
		super.afterTrialTests(p);
	}
	
	@Override
	public int getTests() {
		return 	1;
	}

	@Override
	public int getAsserts() {
		return 4;
	}

	@Override
	public int getUniqueAsserts() {
		return 2;
	}
}
