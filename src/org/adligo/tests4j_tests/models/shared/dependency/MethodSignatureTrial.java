package org.adligo.tests4j_tests.models.shared.dependency;

import org.adligo.tests4j.models.shared.asserts.common.ExpectedThrownData;
import org.adligo.tests4j.models.shared.asserts.common.I_Thrower;
import org.adligo.tests4j.models.shared.dependency.MethodSignature;
import org.adligo.tests4j.models.shared.trials.SourceFileScope;
import org.adligo.tests4j.models.shared.trials.Test;
import org.adligo.tests4j_tests.base_trials.SourceFileCountingTrial;

@SourceFileScope (sourceClass=MethodSignature.class, minCoverage=81.0)
public class MethodSignatureTrial extends SourceFileCountingTrial {

	@Test
	public void testConstructorExceptions() {
		assertThrown(new ExpectedThrownData(NullPointerException.class),
				new I_Thrower() {
					
					@Override
					public void run() {
						MethodSignature ms = null;
						new MethodSignature(ms);
					}
				});
		assertThrown(new ExpectedThrownData(new IllegalArgumentException(
				MethodSignature.REQUIRES_A_NON_EMPTY_METHOD_NAME_IN)),
				new I_Thrower() {
					
					@Override
					public void run() {
						new MethodSignature("", null, null);
					}
				});
		assertThrown(new ExpectedThrownData(new IllegalArgumentException(
				MethodSignature.REQUIRES_A_NON_EMPTY_METHOD_NAME_IN)),
				new I_Thrower() {
					
					@Override
					public void run() {
						new MethodSignature(null, null, null);
					}
				});
		
		assertThrown(new ExpectedThrownData(new IllegalArgumentException(
				MethodSignature.PARAMETERS_MAY_NOT_BE_EMPTY_STRINGS)),
				new I_Thrower() {
					
					@Override
					public void run() {
						new MethodSignature("hmm", new String[] {null}, null);
					}
				});
		assertThrown(new ExpectedThrownData(new IllegalArgumentException(
				MethodSignature.PARAMETERS_MAY_NOT_BE_EMPTY_STRINGS)),
				new I_Thrower() {
					
					@Override
					public void run() {
						new MethodSignature("hmm", new String[] {""}, null);
					}
				});
	}
	
	@Test
	public void testCopyConstructorAndGetters() {
		MethodSignature ms = new MethodSignature("foo", null, null);
		assertEquals("foo", ms.getMethodName());
		assertEquals(0, ms.getParameters());
		
		MethodSignature ms2 = new MethodSignature(ms);
		assertEquals("foo", ms2.getMethodName());
		assertEquals(0, ms2.getParameters());
		
		String[] sa = new String[] {"1","2"};
		MethodSignature msB = new MethodSignature("bar", sa, "hey");
		assertEquals("bar", msB.getMethodName());
		assertEquals("1", msB.getParameterClassName(0));
		assertEquals("2", msB.getParameterClassName(1));
		assertEquals(2, msB.getParameters());
		assertEquals("hey", msB.getReturnClassName());
		
		MethodSignature msB2 = new MethodSignature(msB);
		assertEquals("bar", msB2.getMethodName());
		assertEquals("1", msB2.getParameterClassName(0));
		assertEquals("2", msB2.getParameterClassName(1));
		assertEquals(2, msB2.getParameters());
		assertEquals("hey", msB2.getReturnClassName());
	}
	
	@Test
	public void testEqualsHashCode() {
		MethodSignature a = new MethodSignature("foo", null, null);
		MethodSignature b = new MethodSignature("bar", null, null);
		String[] sa = new String[] {"1","2"};
		MethodSignature c = new MethodSignature("foo", sa, null);
		MethodSignature d = new MethodSignature("foo", null, null);
		String[] sae = new String[] {"1","3"};
		MethodSignature e = new MethodSignature("foo", sae, null);
		MethodSignature f = new MethodSignature("foo", null, "bar");
		MethodSignature g = new MethodSignature("foo", sae, "bar");
		assertEquals(a, a);
		assertEquals(a.hashCode(), a.hashCode());
		
		assertNotEquals(a, b);
		assertNotEquals(a.hashCode(), b.hashCode());
		
		assertNotEquals(a, c);
		assertNotEquals(a.hashCode(), c.hashCode());
		
		assertEquals(a, d);
		assertEquals(a.hashCode(), d.hashCode());
		
		assertNotEquals(c, e);
		assertNotEquals(c.hashCode(), e.hashCode());
		
		assertNotEquals(e, f);
		assertNotEquals(e.hashCode(), f.hashCode());
		
		assertNotEquals(e, g);
		assertNotEquals(e.hashCode(), g.hashCode());
	}
	
	@Test
	public void testToString() {
		String[] sa = new String[] {"1","2"};
		MethodSignature c = new MethodSignature("foo", sa, null);
		assertEquals("void foo(1, 2)", c.toString());
		
		MethodSignature d = new MethodSignature("foo", null, null);
		assertEquals("void foo()", d.toString());
	}
	
	@Override
	public int getTests() {
		return 4;
	}

	@Override
	public int getAsserts() {
		return 35;
	}

	@Override
	public int getUniqueAsserts() {
		return 20;
	}

}
