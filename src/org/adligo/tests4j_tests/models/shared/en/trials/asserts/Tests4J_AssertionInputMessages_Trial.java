package org.adligo.tests4j_tests.models.shared.en.trials.asserts;

import org.adligo.tests4j.models.shared.en.Tests4J_AssertionInputMessages;
import org.adligo.tests4j.models.shared.trials.SourceFileScope;
import org.adligo.tests4j.models.shared.trials.Test;
import org.adligo.tests4j_tests.base_abstract_trials.SourceFileCountingTrial;

@SourceFileScope (sourceClass=Tests4J_AssertionInputMessages.class)
public class Tests4J_AssertionInputMessages_Trial extends SourceFileCountingTrial {

	@Test
	public void testMessages() {
		Tests4J_AssertionInputMessages messages = new Tests4J_AssertionInputMessages();
		
		
		assertEquals(Tests4J_AssertionInputMessages.EXPECTED_THROWN_DATA_REQUIRES_A_NON_NULL_THROWABLE_CLASS,
				messages.getExpectedThrownDataRequiresThrowable());
		assertEquals("ExpectedThrownData requires a non null throwable class.",
				Tests4J_AssertionInputMessages.EXPECTED_THROWN_DATA_REQUIRES_A_NON_NULL_THROWABLE_CLASS);
	}
	
	@Override
	public int getTests() {
		return 	1;
	}

	@Override
	public int getAsserts() {
		return 2;
	}

	@Override
	public int getUniqueAsserts() {
		return 1;
	}
}
