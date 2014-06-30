package org.adligo.tests4j_tests.models.shared.asserts;

import org.adligo.tests4j.models.shared.asserts.ExpectedThrownData;
import org.adligo.tests4j.models.shared.asserts.common.I_Thrower;
import org.adligo.tests4j.models.shared.coverage.I_SourceFileCoverage;
import org.adligo.tests4j.models.shared.results.feedback.I_SourceFileTrial_TestsResults;
import org.adligo.tests4j.models.shared.trials.SourceFileScope;
import org.adligo.tests4j.models.shared.trials.SourceFileTrial;
import org.adligo.tests4j.models.shared.trials.Test;

@SourceFileScope (sourceClass=ExpectedThrownData.class)
public class ExpectedThrownDataTrial extends SourceFileTrial {

	@Test
	public void testConstructorExceptions() {
		assertThrown(new ExpectedThrownData(IllegalArgumentException.class,"ExpectedThrownData requires a non null throwable class."), 
			new I_Thrower() {
				@Override
				public void run() {
					new ExpectedThrownData(null, null);
				}
		});
		
		assertThrown(new ExpectedThrownData(IllegalArgumentException.class,"ExpectedThrownData requires a non null message."), 
			new I_Thrower() {
				@Override
				public void run() {
					new ExpectedThrownData(IllegalStateException.class, null);
				}
		});
	}
	
	@Test
	public void testConstructorAndGets() {
		ExpectedThrownData obj = new ExpectedThrownData(IllegalStateException.class, "Some error message.");
		assertEquals(IllegalStateException.class, obj.getThrowableClass());
		assertEquals("Some error message.", obj.getMessage());
		
	}
	
	@Override
	public void afterTrialTests(I_SourceFileTrial_TestsResults p) {
		assertGreaterThanOrEquals(4.0, p.getAssertions());
		assertGreaterThanOrEquals(4.0, p.getUniqueAssertions());
		
		if (p.hasRecordedCoverage()) {
			I_SourceFileCoverage coverage = p.getCoverage();
			assertGreaterThanOrEquals(100.0, coverage.getPercentageCoveredDouble());
		}
	}
}
