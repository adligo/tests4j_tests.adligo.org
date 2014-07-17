package org.adligo.tests4j_tests.models.shared.asserts;

import org.adligo.tests4j.models.shared.asserts.ExpectedThrownData;
import org.adligo.tests4j.models.shared.asserts.common.I_Thrower;
import org.adligo.tests4j.models.shared.trials.SourceFileScope;
import org.adligo.tests4j.models.shared.trials.Test;
import org.adligo.tests4j_tests.base_abstract_trials.SourceFileCountingTrial;

@SourceFileScope (sourceClass=ExpectedThrownData.class, minCoverage=70.0)
public class ExpectedThrownDataTrial extends SourceFileCountingTrial {

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
	public int getTests() {
		return 3;
	}

	@Override
	public int getAsserts() {
		return 13;
	}

	@Override
	public int getUniqueAsserts() {
		return 7;
	}
}
