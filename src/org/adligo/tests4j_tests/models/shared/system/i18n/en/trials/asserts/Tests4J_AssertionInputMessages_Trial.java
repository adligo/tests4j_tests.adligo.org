package org.adligo.tests4j_tests.models.shared.system.i18n.en.trials.asserts;

import org.adligo.tests4j.models.shared.SourceFileScope;
import org.adligo.tests4j.models.shared.SourceFileTrial;
import org.adligo.tests4j.models.shared.Test;
import org.adligo.tests4j.models.shared.coverage.I_SourceFileCoverage;
import org.adligo.tests4j.models.shared.results.feedback.I_SourceFileTrial_TestsResults;
import org.adligo.tests4j.models.shared.system.i18n.en.trials.asserts.Tests4J_AssertionInputMessages;

@SourceFileScope (sourceClass=Tests4J_AssertionInputMessages.class)
public class Tests4J_AssertionInputMessages_Trial extends SourceFileTrial {

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
	public void afterTrialTests(I_SourceFileTrial_TestsResults p) {
		assertGreaterThanOrEquals(4.0, p.getAssertions());
		assertGreaterThanOrEquals(2.0, p.getUniqueAssertions());
		
		if (p.hasRecordedCoverage()) {
			I_SourceFileCoverage coverage = p.getCoverage();
			assertGreaterThanOrEquals(100.0, coverage.getPercentageCoveredDouble());
		}
		super.afterTrialTests(p);
	}
}
