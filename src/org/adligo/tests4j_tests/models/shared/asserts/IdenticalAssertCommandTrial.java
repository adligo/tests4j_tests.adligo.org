package org.adligo.tests4j_tests.models.shared.asserts;

import org.adligo.tests4j.models.shared.asserts.CompareAssertionData;
import org.adligo.tests4j.models.shared.asserts.ExpectedThrownData;
import org.adligo.tests4j.models.shared.asserts.IdenticalAssertCommand;
import org.adligo.tests4j.models.shared.asserts.common.AssertType;
import org.adligo.tests4j.models.shared.asserts.common.I_Thrower;
import org.adligo.tests4j.models.shared.coverage.I_SourceFileCoverage;
import org.adligo.tests4j.models.shared.en.asserts.Tests4J_AssertionResultMessages;
import org.adligo.tests4j.models.shared.results.I_SourceFileTrialResult;
import org.adligo.tests4j.models.shared.trials.SourceFileScope;
import org.adligo.tests4j.models.shared.trials.SourceFileTrial;
import org.adligo.tests4j.models.shared.trials.Test;

@SourceFileScope (sourceClass=IdenticalAssertCommand.class)
public class IdenticalAssertCommandTrial extends SourceFileTrial {

	@Test
	public void testConstructorExceptions() {
		assertThrown(new ExpectedThrownData(new IllegalArgumentException(IdenticalAssertCommand.BAD_TYPE)),
				new I_Thrower() {

					@Override
					public void run() {
						new IdenticalAssertCommand(AssertType.AssertFalse, "failureMessage", new CompareAssertionData<Double>(0.0, 0.0));
					}
			
		});
		
		assertThrown(new ExpectedThrownData(new IllegalArgumentException(
				new Tests4J_AssertionResultMessages().getTheExpectedValueShouldNeverBeNull())),
				new I_Thrower() {

					@Override
					public void run() {
						new IdenticalAssertCommand(AssertType.AssertFalse, "failureMessage", new CompareAssertionData<Double>(null, 0.0));
					}
			
		});
	}
	
	@Test
	public void testGetters() {
		CompareAssertionData<Double> cad = new CompareAssertionData<Double>(0.0, 1.0);
		IdenticalAssertCommand a = new IdenticalAssertCommand(AssertType.AssertEquals, 
				"failureMessage", cad);
		
		assertSame(cad, a.getData());
		assertEquals(1.0, a.getActual());
		assertEquals(0.0, a.getExpected());
		assertEquals("failureMessage", a.getFailureMessage());
		assertSame(AssertType.AssertEquals, a.getType());
	}
	
	@Test
	public void testEqualsHashCode() {
		IdenticalAssertCommand a = new IdenticalAssertCommand(AssertType.AssertEquals, 
				"failureMessage", new CompareAssertionData<Double>(0.0, 1.0));
		IdenticalAssertCommand b = new IdenticalAssertCommand(AssertType.AssertEquals, 
				"failureMessage", new CompareAssertionData<Double>(0.0, 0.0));
		IdenticalAssertCommand c = new IdenticalAssertCommand(AssertType.AssertEquals, 
				"failureMessage", new CompareAssertionData<Double>(0.0, 1.0));
		IdenticalAssertCommand d = new IdenticalAssertCommand(AssertType.AssertEquals, 
				"failureMessage", new CompareAssertionData<Double>(1.0, 1.0));
		IdenticalAssertCommand e = new IdenticalAssertCommand(AssertType.AssertEquals, 
				"failureMessage2", new CompareAssertionData<Double>(0.0, 1.0));
		
		
		
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
	
	@Test
	public void testEvaluate() {
		assertFalse(new IdenticalAssertCommand(AssertType.AssertEquals, 
				"failureMessage", new CompareAssertionData<Double>(0.0, 1.0)).evaluate());
		assertTrue(new IdenticalAssertCommand(AssertType.AssertEquals, 
				"failureMessage", new CompareAssertionData<Double>(0.0, 0.0)).evaluate());
		
		assertFalse(new IdenticalAssertCommand(AssertType.AssertNotEquals, 
				"failureMessage", new CompareAssertionData<Double>(0.0, 0.0)).evaluate());
		assertTrue(new IdenticalAssertCommand(AssertType.AssertNotEquals, 
				"failureMessage", new CompareAssertionData<Double>(1.0, 0.0)).evaluate());
		
		Object a = new Object();
		Object b = new Object();
		assertFalse(new IdenticalAssertCommand(AssertType.AssertSame, 
				"failureMessage", new CompareAssertionData<Object>(a, b)).evaluate());
		assertTrue(new IdenticalAssertCommand(AssertType.AssertSame, 
				"failureMessage", new CompareAssertionData<Object>(a, a)).evaluate());
		
		assertFalse(new IdenticalAssertCommand(AssertType.AssertNotSame, 
				"failureMessage", new CompareAssertionData<Object>(a, a)).evaluate());
		assertTrue(new IdenticalAssertCommand(AssertType.AssertNotSame, 
				"failureMessage", new CompareAssertionData<Object>(a, b)).evaluate());
	}
	
	@Override
	public void afterTrialTests(I_SourceFileTrialResult p) {
		assertEquals(4, p.getTestCount());
		assertGreaterThanOrEquals(25.0, p.getAssertionCount());
		assertGreaterThanOrEquals(13.0, p.getUniqueAssertionCount());
		
		if (p.hasRecordedCoverage()) {
			I_SourceFileCoverage coverage = p.getSourceFileCoverage();
			double pct = coverage.getPercentageCoveredDouble();
			assertGreaterThanOrEquals(70.0, pct);
		}
	}
}
