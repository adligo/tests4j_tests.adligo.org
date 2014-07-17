package org.adligo.tests4j_tests.models.shared.asserts;

import org.adligo.tests4j.models.shared.asserts.CompareAssertionData;
import org.adligo.tests4j.models.shared.asserts.DoubleAssertCommand;
import org.adligo.tests4j.models.shared.asserts.ExpectedThrownData;
import org.adligo.tests4j.models.shared.asserts.common.AssertType;
import org.adligo.tests4j.models.shared.asserts.common.I_Thrower;
import org.adligo.tests4j.models.shared.trials.SourceFileScope;
import org.adligo.tests4j.models.shared.trials.Test;
import org.adligo.tests4j_tests.base_abstract_trials.SourceFileCountingTrial;

@SourceFileScope (sourceClass=DoubleAssertCommand.class, minCoverage=80.0)
public class DoubleAssertCommandTrial extends SourceFileCountingTrial {

	@Test
	public void testConstructorExeptions() {
		assertThrown(new ExpectedThrownData(new IllegalArgumentException(DoubleAssertCommand.BAD_TYPE)),
				new I_Thrower() {
					
					@Override
					public void run() {
						new DoubleAssertCommand(AssertType.AssertEquals, "failureMessage", 
								new CompareAssertionData<Double>(0.0, 0.0));
					}
				});
	}
	
	@Test
	public void testEqualsHashCode() {
		DoubleAssertCommand a =  new DoubleAssertCommand(AssertType.AssertGreaterThanOrEquals, "failureMessage", 
				new CompareAssertionData<Double>(0.0, 0.0));
		DoubleAssertCommand b =  new DoubleAssertCommand(AssertType.AssertGreaterThanOrEquals, "failureMessage2", 
				new CompareAssertionData<Double>(0.0, 0.0));
		DoubleAssertCommand c =  new DoubleAssertCommand(AssertType.AssertGreaterThanOrEquals, "failureMessage", 
				new CompareAssertionData<Double>(0.0, 0.0));
		DoubleAssertCommand d =  new DoubleAssertCommand(AssertType.AssertGreaterThanOrEquals, "failureMessage", 
				new CompareAssertionData<Double>(0.0,1.0));
		DoubleAssertCommand e =  new DoubleAssertCommand(AssertType.AssertGreaterThanOrEquals, "failureMessage", 
				new CompareAssertionData<Double>(1.0, 0.0));
		
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
	public void testGetters()  {
		CompareAssertionData<Double> cad = new CompareAssertionData<Double>(1.0, 0.0);
		DoubleAssertCommand e =  new DoubleAssertCommand(AssertType.AssertGreaterThanOrEquals, 
				"failureMessage",  cad);
		
		assertSame(cad, e.getData());
		assertEquals("failureMessage", e.getFailureMessage());
		assertEquals(AssertType.AssertGreaterThanOrEquals, e.getType());
		assertEquals(1.0, e.getExpected());
		assertEquals(0.0, e.getActual());
	}
	
	@Test
	public void testEvaluate()  {
		CompareAssertionData<Double> cad = new CompareAssertionData<Double>(1.0, 0.0);
		DoubleAssertCommand e =  new DoubleAssertCommand(AssertType.AssertGreaterThanOrEquals, 
				"failureMessage",  cad);
		assertFalse(e.evaluate());
		
		assertFalse(new DoubleAssertCommand(AssertType.AssertGreaterThanOrEquals, "failureMessage", 
				new CompareAssertionData<Double>(0.01, 0.0)).evaluate());
		
		assertTrue(new DoubleAssertCommand(AssertType.AssertGreaterThanOrEquals, "failureMessage", 
				new CompareAssertionData<Double>(0.0, 0.0)).evaluate());
		
		assertTrue(new DoubleAssertCommand(AssertType.AssertGreaterThanOrEquals, "failureMessage", 
				new CompareAssertionData<Double>(0.0, 0.01)).evaluate());
	}
	
	@Override
	public int getTests() {
		return 4;
	}

	@Override
	public int getAsserts() {
		return 20;
	}

	@Override
	public int getUniqueAsserts() {
		return 12;
	}
}