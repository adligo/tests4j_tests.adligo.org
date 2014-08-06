package org.adligo.tests4j_tests.models.shared.asserts;

import org.adligo.tests4j.models.shared.asserts.IdenticalAssertCommand;
import org.adligo.tests4j.models.shared.asserts.common.AssertType;
import org.adligo.tests4j.models.shared.asserts.common.CompareAssertionData;
import org.adligo.tests4j.models.shared.asserts.common.ExpectedThrownData;
import org.adligo.tests4j.models.shared.asserts.common.I_Thrower;
import org.adligo.tests4j.models.shared.en.Tests4J_ResultMessages;
import org.adligo.tests4j.models.shared.en.Tests4J_EnglishConstants;
import org.adligo.tests4j.models.shared.i18n.I_Tests4J_AssertionInputMessages;
import org.adligo.tests4j.models.shared.trials.SourceFileScope;
import org.adligo.tests4j.models.shared.trials.Test;
import org.adligo.tests4j_tests.base_abstract_trials.SourceFileCountingTrial;

@SourceFileScope (sourceClass=IdenticalAssertCommand.class, minCoverage=70.0)
public class IdenticalAssertCommandTrial extends SourceFileCountingTrial {

	@Test
	public void testConstructorExceptions() {
		assertThrown(new ExpectedThrownData(new IllegalArgumentException(IdenticalAssertCommand.BAD_TYPE)),
				new I_Thrower() {

					@Override
					public void run() {
						new IdenticalAssertCommand("failureMessage", new CompareAssertionData<Double>(0.0, 0.0, AssertType.AssertFalse));
					}
			
		});
		I_Tests4J_AssertionInputMessages messages =  Tests4J_EnglishConstants.ENGLISH.getAssertionInputMessages();
		
		assertThrown(new ExpectedThrownData(new IllegalArgumentException(
				messages.getTheExpectedValueShouldNeverBeNull())),
				new I_Thrower() {

					@Override
					public void run() {
						new IdenticalAssertCommand("failureMessage", new CompareAssertionData<Double>(null, 0.0, AssertType.AssertFalse));
					}
			
		});
	}
	
	@Test
	public void testGetters() {
		CompareAssertionData<Double> cad = new CompareAssertionData<Double>(0.0, 1.0, AssertType.AssertEquals);
		IdenticalAssertCommand a = new IdenticalAssertCommand("failureMessage", cad);
		
		assertSame(cad, a.getData());
		assertEquals(1.0, a.getActual());
		assertEquals(0.0, a.getExpected());
		assertEquals("failureMessage", a.getFailureMessage());
		assertSame(AssertType.AssertEquals, a.getType());
	}
	
	@Test
	public void testEqualsHashCode() {
		IdenticalAssertCommand a = new IdenticalAssertCommand(
				"failureMessage", new CompareAssertionData<Double>(0.0, 1.0, AssertType.AssertNotSame));
		IdenticalAssertCommand b = new IdenticalAssertCommand(
				"failureMessage", new CompareAssertionData<Double>(0.0, 0.0, AssertType.AssertNotSame));
		IdenticalAssertCommand c = new IdenticalAssertCommand(
				"failureMessage", new CompareAssertionData<Double>(0.0, 1.0, AssertType.AssertNotSame));
		IdenticalAssertCommand d = new IdenticalAssertCommand(
				"failureMessage", new CompareAssertionData<Double>(1.0, 1.0, AssertType.AssertNotSame));
		IdenticalAssertCommand e = new IdenticalAssertCommand(
				"failureMessage2", new CompareAssertionData<Double>(0.0, 1.0, AssertType.AssertNotSame));
		IdenticalAssertCommand f = new IdenticalAssertCommand(
				"failureMessage", new CompareAssertionData<Double>(0.0, 1.0, AssertType.AssertSame));
		
		
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
		
		assertNotEquals(a, f);
		assertNotEquals(a.hashCode(), f.hashCode());
	}
	
	@Test
	public void testEvaluate() {
		assertFalse(new IdenticalAssertCommand(
				"failureMessage", new CompareAssertionData<Double>(0.0, 1.0, AssertType.AssertEquals)).evaluate());
		assertTrue(new IdenticalAssertCommand(
				"failureMessage", new CompareAssertionData<Double>(0.0, 0.0, AssertType.AssertEquals)).evaluate());
		
		assertFalse(new IdenticalAssertCommand(
				"failureMessage", new CompareAssertionData<Double>(0.0, 0.0, AssertType.AssertNotEquals)).evaluate());
		assertTrue(new IdenticalAssertCommand(
				"failureMessage", new CompareAssertionData<Double>(1.0, 0.0, AssertType.AssertNotEquals)).evaluate());
		
		Object a = new Object();
		Object b = new Object();
		assertFalse(new IdenticalAssertCommand( 
				"failureMessage", new CompareAssertionData<Object>(a, b, AssertType.AssertSame)).evaluate());
		assertTrue(new IdenticalAssertCommand( 
				"failureMessage", new CompareAssertionData<Object>(a, a, AssertType.AssertSame)).evaluate());
		
		assertFalse(new IdenticalAssertCommand( 
				"failureMessage", new CompareAssertionData<Object>(a, a, AssertType.AssertNotSame)).evaluate());
		assertTrue(new IdenticalAssertCommand(
				"failureMessage", new CompareAssertionData<Object>(a, b, AssertType.AssertNotSame)).evaluate());
	}
	
	@Override
	public int getTests() {
		return 4;
	}

	@Override
	public int getAsserts() {
		return 27;
	}

	@Override
	public int getUniqueAsserts() {
		return 14;
	}
}
