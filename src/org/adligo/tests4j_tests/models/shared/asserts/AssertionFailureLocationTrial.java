package org.adligo.tests4j_tests.models.shared.asserts;

import org.adligo.tests4j.models.shared.asserts.AssertionFailureLocation;
import org.adligo.tests4j.models.shared.coverage.I_SourceFileCoverage;
import org.adligo.tests4j.models.shared.results.I_SourceFileTrialResult;
import org.adligo.tests4j.models.shared.trials.SourceFileScope;
import org.adligo.tests4j.models.shared.trials.Test;
import org.adligo.tests4j_tests.base_abstract_trials.SourceFileCountingTrial;

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
		
		StackAssertions.assertAssertionFailureLocation_StackWasFromTests4J(this, afl);
	}
	
	@Override
	public void afterTrialTests(I_SourceFileTrialResult p) {
		assertCounts(p);
		
		if (p.hasRecordedCoverage()) {
			I_SourceFileCoverage coverage = p.getSourceFileCoverage();
			double pct = coverage.getPercentageCoveredDouble();
			if (pct < 90.0) {
				System.out.println("wtf");
			}
			assertGreaterThanOrEquals(100.0, pct);
		}
	}

	@Override
	public int getTests() {
		return 1;
	}

	@Override
	public int getAsserts() {
		return 8;
	}

	@Override
	public int getUniqueAsserts() {
		return 8;
	}
}
