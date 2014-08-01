package org.adligo.tests4j_tests.models.shared.asserts;

import org.adligo.tests4j.models.shared.asserts.ExpectedThrownData;
import org.adligo.tests4j.models.shared.asserts.common.I_ExpectedThrownData;
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
		assertThrown(new ExpectedThrownData(NullPointerException.class), 
			new I_Thrower() {
				@Override
				public void run() {
					new ExpectedThrownData(new IllegalArgumentException("thisTestRocks"), null);
				}
		});
		assertThrown(new ExpectedThrownData(new IllegalArgumentException(
				"ExpectedThrownData requires a non null throwable class.")),  
			new I_Thrower() {
				@Override
				public void run() {
					new ExpectedThrownData((Class<? extends Throwable>) null);
				}
		});
		assertThrown(new ExpectedThrownData(NullPointerException.class), 
				new I_Thrower() {
					@Override
					public void run() {
						new ExpectedThrownData(IllegalArgumentException.class, null);
					}
			});
		assertThrown(new ExpectedThrownData(NullPointerException.class), 
			new I_Thrower() {
				@Override
				public void run() {
					new ExpectedThrownData((I_ExpectedThrownData) null);
				}
		});
	
	}
	
	@Test
	public void testConstructorAndGets() {
		//test pass through
		ExpectedThrownData obj = new ExpectedThrownData(
				new ExpectedThrownData(new IllegalStateException("Some error message.")));
		assertEquals(IllegalStateException.class, obj.getThrowableClass());
		assertEquals("Some error message.", obj.getMessage());
		
		obj = new ExpectedThrownData(
				new ExpectedThrownData(NullPointerException.class));
		assertEquals(NullPointerException.class, obj.getThrowableClass());
		
		obj = new ExpectedThrownData(new IllegalStateException("Some error message."),
				new ExpectedThrownData(NullPointerException.class));
		assertEquals(IllegalStateException.class, obj.getThrowableClass());
		assertEquals("Some error message.", obj.getMessage());
		I_ExpectedThrownData expCause = obj.getExpectedCause();
		assertNotNull(expCause);
		assertEquals(NullPointerException.class, expCause.getThrowableClass());
		
		obj = new ExpectedThrownData(NullPointerException.class,
				new ExpectedThrownData(new IllegalStateException("Some error message.")));
		assertEquals(NullPointerException.class, obj.getThrowableClass());
		expCause = obj.getExpectedCause();
		assertNotNull(expCause);
		assertEquals(IllegalStateException.class, expCause.getThrowableClass());
		assertEquals("Some error message.", expCause.getMessage());
	
		obj = new ExpectedThrownData(NullPointerException.class,
				new ExpectedThrownData(new IllegalStateException("Some error message.")));
		assertEquals(NullPointerException.class, obj.getThrowableClass());
		expCause = obj.getExpectedCause();
		assertNotNull(expCause);
		assertEquals(IllegalStateException.class, expCause.getThrowableClass());
		assertEquals("Some error message.", expCause.getMessage());
		
		
		ExpectedThrownData threePete = new ExpectedThrownData(RuntimeException.class,
				new ExpectedThrownData(NullPointerException.class,
				new ExpectedThrownData(new IllegalStateException("Some error message."))));
		assertEquals(RuntimeException.class, threePete.getThrowableClass());
		expCause = threePete.getExpectedCause();
		assertNotNull(expCause);
		assertEquals(NullPointerException.class, expCause.getThrowableClass());
		expCause = expCause.getExpectedCause();
		assertNotNull(expCause);
		assertEquals(IllegalStateException.class, expCause.getThrowableClass());
		assertEquals("Some error message.", expCause.getMessage());
	}
	
	@Test
	public void testEqualsHashCode() {
		ExpectedThrownData a = new ExpectedThrownData(
				new ExpectedThrownData(new IllegalStateException("Some error message.")));
		ExpectedThrownData b = new ExpectedThrownData(new IllegalStateException("Some error message2."));
		ExpectedThrownData c = new ExpectedThrownData(new IllegalStateException("Some error message."));
		ExpectedThrownData d = new ExpectedThrownData(new IllegalArgumentException("Some error message."));
		ExpectedThrownData e = new ExpectedThrownData(new IllegalArgumentException("Some error message2."));
		ExpectedThrownData f = new ExpectedThrownData(new IllegalStateException("Some error message."),
				new ExpectedThrownData(NullPointerException.class));
		ExpectedThrownData g = new ExpectedThrownData(new IllegalArgumentException("Some error message."),
				new ExpectedThrownData(IllegalArgumentException.class));
		ExpectedThrownData h = new ExpectedThrownData(new IllegalStateException("Some error message."),
				new ExpectedThrownData(new IllegalArgumentException("iae")));
		ExpectedThrownData i = new ExpectedThrownData(new IllegalArgumentException("Some error message."),
				new ExpectedThrownData(new IllegalArgumentException("iae2")));
		
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
		
		assertNotEquals(a, g);
		assertNotEquals(a.hashCode(), g.hashCode());
		
		assertNotEquals(a, h);
		assertNotEquals(a.hashCode(), h.hashCode());
		
		assertNotEquals(a, i);
		assertNotEquals(a.hashCode(), i.hashCode());
	}
	
	@Override
	public int getTests() {
		return 3;
	}

	@Override
	public int getAsserts() {
		return 44;
	}

	@Override
	public int getUniqueAsserts() {
		return 20;
	}
}
