package org.adligo.tests4j_tests.models.shared.asserts;

import org.adligo.tests4j.models.shared.asserts.AssertionFailureLocation;
import org.adligo.tests4j.models.shared.asserts.line_text.TextLines;
import org.adligo.tests4j.models.shared.common.StackTraceBuilder;
import org.adligo.tests4j.models.shared.trials.SourceFileScope;
import org.adligo.tests4j.models.shared.trials.Test;
import org.adligo.tests4j_tests.base_trials.SourceFileCountingTrial;

@SourceFileScope (sourceClass=AssertionFailureLocation.class)
public class AssertionFailureLocationTrial extends SourceFileCountingTrial {

	
	@Test
	public void testAssertionStack() {
		AssertionFailureLocation afl = new AssertionFailureLocation();
		StackTraceElement [] elements =  afl.getStackTrace();
		assertGreaterThanOrEquals(10, elements.length);
		
		StackTraceElement e = elements[0];
		assertEquals(AssertionFailureLocationTrial.class.getName(),  e.getClassName());
		assertEquals("testAssertionStack",  e.getMethodName());
		assertEquals(16,  e.getLineNumber());
		
		TextLines lines = new TextLines(StackTraceBuilder.toString(afl, true), true);
		assertUniform("	org.adligo.tests4j.models.shared.asserts.AssertionFailureLocation", lines.getLine(0));
		assertUniform("\tat org.adligo.tests4j_tests.models.shared.asserts.AssertionFailureLocationTrial.testAssertionStack(AssertionFailureLocationTrial.java:16)", lines.getLine(1));
		
	}

	@Override
	public int getTests() {
		return 1;
	}

	@Override
	public int getAsserts() {
		return 6;
	}

	@Override
	public int getUniqueAsserts() {
		return 5;
	}
}
