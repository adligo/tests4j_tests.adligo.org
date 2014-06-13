package org.adligo.tests4j_tests.models.shared.system.i18n.en.trials.asserts;

import org.adligo.tests4j.models.shared.SourceFileScope;
import org.adligo.tests4j.models.shared.SourceFileTrial;
import org.adligo.tests4j.models.shared.Test;
import org.adligo.tests4j.models.shared.coverage.I_SourceFileCoverage;
import org.adligo.tests4j.models.shared.results.feedback.I_SourceFileTrial_TestsResults;
import org.adligo.tests4j.models.shared.system.i18n.en.trials.asserts.Tests4J_AssertionResultMessages;

@SourceFileScope (sourceClass=Tests4J_AssertionResultMessages.class)
public class Tests4J_AssertionResultMessages_Trial extends SourceFileTrial {

	@Test
	public void testMessages() {
		Tests4J_AssertionResultMessages messages = new Tests4J_AssertionResultMessages();
		
		assertEquals("The actual Value should be greater than OR equal to the expected Value.",
				Tests4J_AssertionResultMessages.THE_ACTUAL_SHOULD_BE_GREATER_THAN_OR_EQUAL_TO_THE_EXPECTED_VALUE);
		assertEquals(Tests4J_AssertionResultMessages.THE_ACTUAL_SHOULD_BE_GREATER_THAN_OR_EQUAL_TO_THE_EXPECTED_VALUE,
				messages.getTheActualShouldBeGreaterThanOrEqualToTheExpected());
		
		assertEquals("The Collection should contain the Value.",
				Tests4J_AssertionResultMessages.THE_COLLECTION_SHOULD_CONTAIN_THE_VALUE);
		assertEquals(Tests4J_AssertionResultMessages.THE_COLLECTION_SHOULD_CONTAIN_THE_VALUE,
				messages.getTheCollectionShouldContainTheValue());
		
		assertEquals("Either no Throwable was thrown or the expected Throwable was NOT uniform with the actual Throwable.",
				Tests4J_AssertionResultMessages.THE_EXPECTED_THROWABLE_DATA_DID_NOT_MATCH_THE_ACTUAL);
		assertEquals(Tests4J_AssertionResultMessages.THE_EXPECTED_THROWABLE_DATA_DID_NOT_MATCH_THE_ACTUAL,
				messages.getTheExpectedThrowableDataDidNotMatchTheActual());
		
		assertEquals("The Objects should be the same.",
				Tests4J_AssertionResultMessages.THE_OBJECTS_SHOULD_BE_THE_SAME);
		assertEquals(Tests4J_AssertionResultMessages.THE_OBJECTS_SHOULD_BE_THE_SAME,
				messages.getTheObjectsShouldBeTheSame());
		
		assertEquals("The Objects should be uniform.",
				Tests4J_AssertionResultMessages.THE_OBJECTS_SHOULD_BE_UNIFORM);
		assertEquals(Tests4J_AssertionResultMessages.THE_OBJECTS_SHOULD_BE_UNIFORM,
				messages.getTheObjectsShouldBeUniform());
		
		assertEquals("The Objects should NOT be equal.",
				Tests4J_AssertionResultMessages.THE_OBJECTS_SHOULD_NOT_BE_EQUAL);
		assertEquals(Tests4J_AssertionResultMessages.THE_OBJECTS_SHOULD_NOT_BE_EQUAL,
				messages.getTheObjectsShould_NOT_BeEqual());
		
		assertEquals("The Objects should NOT be the same.",
				Tests4J_AssertionResultMessages.THE_OBJECTS_SHOULD_NOT_BE_THE_SAME);
		assertEquals(Tests4J_AssertionResultMessages.THE_OBJECTS_SHOULD_NOT_BE_THE_SAME,
				messages.getTheObjectsShould_NOT_BeTheSame());
		
		assertEquals("The Objects should NOT be uniform.",
				Tests4J_AssertionResultMessages.THE_OBJECTS_SHOULD_NOT_BE_UNIFORM);
		assertEquals(Tests4J_AssertionResultMessages.THE_OBJECTS_SHOULD_NOT_BE_UNIFORM,
				messages.getTheObjectsShould_NOT_BeUniform());
		
		assertEquals("The Value should be false.",
				Tests4J_AssertionResultMessages.THE_VALUE_SHOULD_BE_FALSE);
		assertEquals(Tests4J_AssertionResultMessages.THE_VALUE_SHOULD_BE_FALSE,
				messages.getTheValueShouldBeFalse());
		
		assertEquals("The Value should be true.",
				Tests4J_AssertionResultMessages.THE_VALUE_SHOULD_BE_TRUE);
		assertEquals(Tests4J_AssertionResultMessages.THE_VALUE_SHOULD_BE_TRUE,
				messages.getTheValueShouldBeTrue());
		
		
		assertEquals("The Value should be null.",
				Tests4J_AssertionResultMessages.THE_VALUE_SHOULD_BE_NULL);
		assertEquals(Tests4J_AssertionResultMessages.THE_VALUE_SHOULD_BE_NULL,
				messages.getTheValueShouldBeNull());
		
		assertEquals("The Value should NOT be null.",
				Tests4J_AssertionResultMessages.THE_VALUE_SHOULD_NOT_BE_NULL);
		assertEquals(Tests4J_AssertionResultMessages.THE_VALUE_SHOULD_NOT_BE_NULL,
				messages.getTheValueShould_NOT_BeNull());
		
		assertEquals("The Objects should be equal.",
				Tests4J_AssertionResultMessages.THE_OBJECTS_SHOULD_BE_EQUAL);
		assertEquals(Tests4J_AssertionResultMessages.THE_OBJECTS_SHOULD_BE_EQUAL,
				messages.getTheObjectsShouldBeEqual());
	}

	@Override
	public void afterTrialTests(I_SourceFileTrial_TestsResults p) {
		assertGreaterThanOrEquals(26.0, p.getAssertions());
		assertGreaterThanOrEquals(13.0, p.getUniqueAssertions());
		
		if (p.hasRecordedCoverage()) {
			I_SourceFileCoverage coverage = p.getCoverage();
			assertGreaterThanOrEquals(100.0, coverage.getPercentageCoveredDouble());
		}
		super.afterTrialTests(p);
	}
}
