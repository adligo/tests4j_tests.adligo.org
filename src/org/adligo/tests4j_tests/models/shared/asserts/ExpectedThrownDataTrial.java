package org.adligo.tests4j_tests.models.shared.asserts;

import org.adligo.tests4j.models.shared.asserts.ExpectedThrownData;
import org.adligo.tests4j.models.shared.asserts.common.I_Thrower;
import org.adligo.tests4j.models.shared.coverage.I_SourceFileCoverage;
import org.adligo.tests4j.models.shared.results.I_SourceFileTrialResult;
import org.adligo.tests4j.models.shared.trials.SourceFileScope;
import org.adligo.tests4j.models.shared.trials.SourceFileTrial;
import org.adligo.tests4j.models.shared.trials.Test;

@SourceFileScope (sourceClass=ExpectedThrownData.class)
public class ExpectedThrownDataTrial extends SourceFileTrial {

	@Test
	public void testConstructorExceptions() {
		assertThrown(new ExpectedThrownData(new IllegalArgumentException(
				"ExpectedThrownData requires a non null throwable class.")), 
			new I_Thrower() {
				@Override
				public void run() {
					new ExpectedThrownData((Throwable) null);
				}
		});
		
		assertThrown(new ExpectedThrownData(new IllegalArgumentException(
				"ExpectedThrownData requires a non null message.")), 
			new I_Thrower() {
				@Override
				public void run() {
					new ExpectedThrownData(new IllegalStateException());
				}
		});
	}
	
	@Test
	public void testConstructorAndGets() {
		ExpectedThrownData obj = new ExpectedThrownData(
				new ExpectedThrownData(new IllegalStateException("Some error message.")));
		assertEquals(IllegalStateException.class, obj.getThrowableClass());
		assertEquals("Some error message.", obj.getMessage());
		
	}
	
	@Test
	public void testEqualsHashCode() {
		ExpectedThrownData a = new ExpectedThrownData(
				new ExpectedThrownData(new IllegalStateException("Some error message.")));
		ExpectedThrownData b = new ExpectedThrownData(new IllegalStateException("Some error message2."));
		ExpectedThrownData c = new ExpectedThrownData(new IllegalStateException("Some error message."));
		ExpectedThrownData d = new ExpectedThrownData(new IllegalArgumentException("Some error message."));
		ExpectedThrownData e = new ExpectedThrownData(new IllegalArgumentException("Some error message2."));
		
		assertEquals(a, a);
		assertEquals(a.hashCode(), a.hashCode());
		
		assertNotEquals(a, b);
		assertNotEquals(a.hashCode(), b.hashCode());
		
		assertEquals(a,  c);
		assertEquals(a.hashCode(), c.hashCode());
		
		assertNotEquals(a, d);
		assertNotEquals(a.hashCode(), d.hashCode());
		
		assertNotEquals(a, e);
		assertNotEquals(a.hashCode(), e.hashCode());
	}
	
	@Override
	public void afterTrialTests(I_SourceFileTrialResult p) {
		assertEquals(3, p.getTestCount());
		assertGreaterThanOrEquals(4.0, p.getAssertionCount());
		assertGreaterThanOrEquals(4.0, p.getUniqueAssertionCount());
		
		if (p.hasRecordedCoverage()) {
			I_SourceFileCoverage coverage = p.getSourceFileCoverage();
			//hmm this should be 70ish
			assertGreaterThanOrEquals(70.0, coverage.getPercentageCoveredDouble());
		}
	}
}
