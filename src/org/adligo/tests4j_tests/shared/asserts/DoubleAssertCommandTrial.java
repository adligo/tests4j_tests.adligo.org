package org.adligo.tests4j_tests.shared.asserts;

import org.adligo.tests4j.shared.asserts.DoubleAssertCommand;
import org.adligo.tests4j.shared.asserts.common.AssertType;
import org.adligo.tests4j.shared.asserts.common.CompareAssertionData;
import org.adligo.tests4j.shared.asserts.common.ExpectedThrowable;
import org.adligo.tests4j.shared.asserts.common.I_Thrower;
import org.adligo.tests4j.shared.asserts.reference.AllowedReferences;
import org.adligo.tests4j.system.shared.trials.SourceFileScope;
import org.adligo.tests4j.system.shared.trials.Test;
import org.adligo.tests4j_tests.base_trials.I_CountType;
import org.adligo.tests4j_tests.base_trials.SourceFileCountingTrial;
import org.adligo.tests4j_tests.references_groups.Tests4J_Asserts_GwtReferenceGroup;
import org.adligo.tests4j_tests.references_groups.Tests4J_Asserts_ReferenceGroup;

@SourceFileScope (sourceClass=DoubleAssertCommand.class, minCoverage=80.0)
@AllowedReferences (groups=Tests4J_Asserts_GwtReferenceGroup.class)
public class DoubleAssertCommandTrial extends SourceFileCountingTrial {

	@Test
	public void testConstructorExeptions() {
		assertThrown(new ExpectedThrowable(new IllegalArgumentException(DoubleAssertCommand.BAD_TYPE)),
				new I_Thrower() {
					
					@Override
					public void run() {
						new DoubleAssertCommand("failureMessage", 
								new CompareAssertionData<Double>(0.0, 0.0, AssertType.AssertEquals));
					}
				});
	}
	
	@Test
	public void testEqualsHashCode() {
		DoubleAssertCommand a =  new DoubleAssertCommand("failureMessage", 
				new CompareAssertionData<Double>(0.0, 0.0, AssertType.AssertGreaterThanOrEquals));
		DoubleAssertCommand b =  new DoubleAssertCommand("failureMessage2", 
				new CompareAssertionData<Double>(0.0, 0.0, AssertType.AssertGreaterThanOrEquals));
		DoubleAssertCommand c =  new DoubleAssertCommand("failureMessage", 
				new CompareAssertionData<Double>(0.0, 0.0, AssertType.AssertGreaterThanOrEquals));
		DoubleAssertCommand d =  new DoubleAssertCommand("failureMessage", 
				new CompareAssertionData<Double>(0.0,1.0, AssertType.AssertGreaterThanOrEquals));
		DoubleAssertCommand e =  new DoubleAssertCommand("failureMessage", 
				new CompareAssertionData<Double>(1.0, 0.0, AssertType.AssertGreaterThanOrEquals));
		
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
		CompareAssertionData<Double> cad = new CompareAssertionData<Double>(1.0, 0.0, AssertType.AssertGreaterThanOrEquals);
		DoubleAssertCommand e =  new DoubleAssertCommand(
				"failureMessage",  cad);
		
		assertSame(cad, e.getData());
		assertEquals("failureMessage", e.getFailureMessage());
		assertEquals(AssertType.AssertGreaterThanOrEquals, e.getType());
		assertEquals(1.0, e.getExpected());
		assertEquals(0.0, e.getActual());
	}
	
	@Test
	public void testEvaluate()  {
		CompareAssertionData<Double> cad = new CompareAssertionData<Double>(1.0, 0.0, AssertType.AssertGreaterThanOrEquals);
		DoubleAssertCommand e =  new DoubleAssertCommand(
				"failureMessage",  cad);
		assertFalse(e.evaluate());
		
		assertFalse(new DoubleAssertCommand("failureMessage", 
				new CompareAssertionData<Double>(0.01, 0.0, AssertType.AssertGreaterThanOrEquals)).evaluate());
		
		assertTrue(new DoubleAssertCommand("failureMessage", 
				new CompareAssertionData<Double>(0.0, 0.0, AssertType.AssertGreaterThanOrEquals)).evaluate());
		
		assertTrue(new DoubleAssertCommand("failureMessage", 
				new CompareAssertionData<Double>(0.0, 0.01, AssertType.AssertGreaterThanOrEquals)).evaluate());
	}

	@Override
	public int getTests(I_CountType type) {
		return super.getTests(type, 4, true);
	}

	@Override
	public int getAsserts(I_CountType type) {
		int thisAsserts = 20;
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
		int thisUniqueAsserts = 12;
		if (type.isFromMetaWithCoverage()) {
			//code coverage and circular dependencies +
			//custom afterTrialTests
			return super.getUniqueAsserts(type, thisUniqueAsserts + 3);
		}  else {
			return super.getAsserts(type, thisUniqueAsserts);
		}
	}
}