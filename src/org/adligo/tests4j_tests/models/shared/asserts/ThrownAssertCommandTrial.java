package org.adligo.tests4j_tests.models.shared.asserts;

import org.adligo.tests4j.models.shared.asserts.ExpectedThrownData;
import org.adligo.tests4j.models.shared.asserts.ThrownAssertCommand;
import org.adligo.tests4j.models.shared.asserts.ThrownAssertionData;
import org.adligo.tests4j.models.shared.asserts.common.AssertType;
import org.adligo.tests4j.models.shared.asserts.common.I_AssertionData;
import org.adligo.tests4j.models.shared.asserts.common.I_Thrower;
import org.adligo.tests4j.models.shared.coverage.I_SourceFileCoverage;
import org.adligo.tests4j.models.shared.en.asserts.Tests4J_AssertionResultMessages;
import org.adligo.tests4j.models.shared.results.I_SourceFileTrialResult;
import org.adligo.tests4j.models.shared.trials.SourceFileScope;
import org.adligo.tests4j.models.shared.trials.SourceFileTrial;
import org.adligo.tests4j.models.shared.trials.Test;

@SourceFileScope (sourceClass=ThrownAssertCommand.class)
public class ThrownAssertCommandTrial extends SourceFileTrial {

	@Test
	public void testConstructorExceptions() {
		assertThrown(new ExpectedThrownData(new IllegalArgumentException(
				new Tests4J_AssertionResultMessages().getTheExpectedValueShouldNeverBeNull())), 
				new I_Thrower() {
					
					@Override
					public void run() {
						new ThrownAssertCommand("failure message", null);
					}
				});
	}
	
	@Test
	public void testEqualsHashCode() {
		ThrownAssertCommand a =
				new ThrownAssertCommand("failure message", 
				new ExpectedThrownData(new IllegalArgumentException("hey")));
		ThrownAssertCommand b =
				new ThrownAssertCommand("failure message", 
				new ExpectedThrownData(new IllegalArgumentException("hey2")));
		ThrownAssertCommand c =
				new ThrownAssertCommand("failure message", 
				new ExpectedThrownData(new IllegalArgumentException("hey")));
		ThrownAssertCommand d =
				new ThrownAssertCommand("failure message2", 
				new ExpectedThrownData(new IllegalArgumentException("hey")));
		ThrownAssertCommand e =
				new ThrownAssertCommand("failure message", 
				new ExpectedThrownData(new IllegalStateException("hey")));
	
		assertEquals(a, a);
		assertEquals(a.hashCode(), a.hashCode());
		
		assertNotEquals(a, b);
		assertNotEquals(a.hashCode(), b.hashCode());
		
		assertEquals(a,  c);
		assertEquals(a.hashCode(), c.hashCode());
		
		assertNotEquals(a, d);
		assertNotEquals(a.hashCode(), d.hashCode());
		
		//IllegalStateException not IllegalArgumentException
		assertNotEquals(a, e);
		assertNotEquals(a.hashCode(), e.hashCode());
	}
	
	@Test
	public void testEvaluateSlashGetData() {
		ThrownAssertCommand a =
				new ThrownAssertCommand("failure message", 
						new ExpectedThrownData(new IllegalArgumentException("hey")));
		I_AssertionData data = a.getData();
		assertNotNull(data);
		assertTrue(data instanceof ThrownAssertionData);
		ThrownAssertionData tad = (ThrownAssertionData) data;
		assertNull(tad.getActualMessage());
		assertNull(tad.getActualThrowable());
		assertEquals(IllegalArgumentException.class, tad.getExpectedThrowable());
		assertEquals("hey", tad.getExpectedMessage());
		assertEquals("failure message", a.getFailureMessage());
		assertEquals(AssertType.AssertThrown, a.getType());
		
		a.evaluate(new I_Thrower() {
			
			@Override
			public void run() {
				throw new IllegalStateException("...");
			}
		});
		
		I_AssertionData dataAfterEvaluate = a.getData();
		assertNotNull(dataAfterEvaluate);
		assertTrue(dataAfterEvaluate instanceof ThrownAssertionData);
		ThrownAssertionData tad_AfterEvaluate = (ThrownAssertionData) data;
		assertNull(tad_AfterEvaluate.getActualMessage());
		assertNull(tad_AfterEvaluate.getActualThrowable());
		assertEquals(IllegalArgumentException.class, tad_AfterEvaluate.getExpectedThrowable());
		assertEquals("hey", tad_AfterEvaluate.getExpectedMessage());
		
	}
	
	@Override
	public void afterTrialTests(I_SourceFileTrialResult p) {
		assertEquals(3, p.getTestCount());
		assertGreaterThanOrEquals(25.0, p.getAssertionCount());
		assertGreaterThanOrEquals(13.0, p.getUniqueAssertionCount());
		
		if (p.hasRecordedCoverage()) {
			I_SourceFileCoverage coverage = p.getSourceFileCoverage();
			assertGreaterThanOrEquals(69.0, coverage.getPercentageCoveredDouble());
		}
	}
}
