package org.adligo.tests4j_tests.models.shared.asserts;

import org.adligo.tests4j.models.shared.asserts.AssertionFailureLocation;
import org.adligo.tests4j.models.shared.coverage.I_SourceFileCoverage;
import org.adligo.tests4j.models.shared.results.feedback.I_SourceFileTrial_TestsResults;
import org.adligo.tests4j.models.shared.trials.SourceFileScope;
import org.adligo.tests4j.models.shared.trials.SourceFileTrial;
import org.adligo.tests4j.models.shared.trials.Test;

@SourceFileScope (sourceClass=AssertionFailureLocation.class)
public class AssertionFailureLocationTrial extends SourceFileTrial {

	
	@Test
	public void testAssertionStack() {
		AssertionFailureLocation afl = new AssertionFailureLocation();
		StackTraceElement [] elements =  afl.getStackTrace();
		assertGreaterThanOrEquals(10, elements.length);
		
		StackTraceElement e = elements[0];
		assertEquals(AssertionFailureLocationTrial.class.getName(),  e.getClassName());
		assertEquals("testAssertionStack",  e.getMethodName());
		assertEquals(16,  e.getLineNumber());
		
		StackAssertions.assertAssertionFailureLocation_StackWasFromTests4J(this, afl);
	}
	
	@Override
	public void afterTrialTests(I_SourceFileTrial_TestsResults p) {
		assertGreaterThanOrEquals(7.0, p.getAssertions());
		assertGreaterThanOrEquals(7.0, p.getUniqueAssertions());
		
		if (p.hasRecordedCoverage()) {
			I_SourceFileCoverage coverage = p.getCoverage();
			assertGreaterThanOrEquals(100.0, coverage.getPercentageCoveredDouble());
		}
	}
}
