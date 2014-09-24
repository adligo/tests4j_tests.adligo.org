package org.adligo.tests4j_tests.shared.asserts;

import org.adligo.tests4j.models.shared.dependency_groups.adligo.Tests4J_Asserts_DependencyGroup;
import org.adligo.tests4j.models.shared.trials.AllowedDependencies;
import org.adligo.tests4j.models.shared.trials.SourceFileScope;
import org.adligo.tests4j.models.shared.trials.Test;
import org.adligo.tests4j.shared.asserts.AssertionFailureLocation;
import org.adligo.tests4j.shared.asserts.line_text.TextLines;
import org.adligo.tests4j.shared.common.StackTraceBuilder;
import org.adligo.tests4j_tests.base_trials.I_CountType;
import org.adligo.tests4j_tests.base_trials.SourceFileCountingTrial;

//TODO look at the code coverage it should be 100.0
@SourceFileScope (sourceClass=AssertionFailureLocation.class, minCoverage=74.0)
@AllowedDependencies (groups=Tests4J_Asserts_DependencyGroup.class)
public class AssertionFailureLocationTrial extends SourceFileCountingTrial {

	
	@Test
	public void testAssertionStack() {
		AssertionFailureLocation afl = new AssertionFailureLocation();
		StackTraceElement [] elements =  afl.getStackTrace();
		assertGreaterThanOrEquals(10, elements.length);
		
		StackTraceElement e = elements[0];
		assertEquals(AssertionFailureLocationTrial.class.getName(),  e.getClassName());
		assertEquals("testAssertionStack",  e.getMethodName());
		assertEquals(21,  e.getLineNumber());
		
		TextLines lines = new TextLines(StackTraceBuilder.toString(afl, true), true);
		assertUniform("	org.adligo.tests4j.shared.asserts.AssertionFailureLocation", lines.getLine(0));
		assertUniform("\tat org.adligo.tests4j_tests.shared.asserts."
				+ "AssertionFailureLocationTrial.testAssertionStack("
				+ "AssertionFailureLocationTrial.java:21)", lines.getLine(1));
		
	}

	@Override
	public int getTests(I_CountType type) {
		return super.getTests(type, 1);
	}

	@Override
	public int getAsserts(I_CountType type) {
		int thisAsserts = 6;
		if (type.isFromMetaWithCoverage()) {
			//code coverage and circular dependencies +
			//custom afterTrialTests
			return super.getAsserts(type, thisAsserts + 3);
		} else {
			return super.getAsserts(type, thisAsserts);
		}
	}

	@Override
	public int getUniqueAsserts(I_CountType type) {
		int thisUniqueAsserts = 5;
		if (type.isFromMetaWithCoverage()) {
			//code coverage and circular dependencies +
			//custom afterTrialTests
			return super.getUniqueAsserts(type, thisUniqueAsserts + 3);
		}  else {
			return super.getAsserts(type, thisUniqueAsserts);
		}
	}
}
