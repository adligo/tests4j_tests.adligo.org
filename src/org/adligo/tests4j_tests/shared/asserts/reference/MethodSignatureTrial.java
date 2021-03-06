package org.adligo.tests4j_tests.shared.asserts.reference;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

import org.adligo.tests4j.models.shared.reference_groups.jse.JSE_Lang;
import org.adligo.tests4j.shared.asserts.common.ExpectedThrowable;
import org.adligo.tests4j.shared.asserts.common.I_Thrower;
import org.adligo.tests4j.shared.asserts.reference.AllowedReferences;
import org.adligo.tests4j.shared.asserts.reference.MethodSignature;
import org.adligo.tests4j.shared.common.ClassMethods;
import org.adligo.tests4j.system.shared.trials.SourceFileScope;
import org.adligo.tests4j.system.shared.trials.Test;
import org.adligo.tests4j_tests.base_trials.I_CountType;
import org.adligo.tests4j_tests.base_trials.SourceFileCountingTrial;
import org.adligo.tests4j_tests.references_groups.Tests4J_AssertsReference_GwtReferenceGroup;

@SourceFileScope (sourceClass=MethodSignature.class, minCoverage=81.0)
@AllowedReferences (groups=Tests4J_AssertsReference_GwtReferenceGroup.class)
public class MethodSignatureTrial extends SourceFileCountingTrial {

	@Test
	public void testConstructorExceptions() {
		assertThrown(new ExpectedThrowable(NullPointerException.class),
				new I_Thrower() {
					
					@Override
					public void run() {
						MethodSignature ms = null;
						new MethodSignature(ms);
					}
				});
		assertThrown(new ExpectedThrowable(new IllegalArgumentException(
				MethodSignature.REQUIRES_A_NON_EMPTY_METHOD_NAME_IN)),
				new I_Thrower() {
					
					@Override
					public void run() {
						new MethodSignature("", null, null);
					}
				});
		assertThrown(new ExpectedThrowable(new IllegalArgumentException(
				MethodSignature.REQUIRES_A_NON_EMPTY_METHOD_NAME_IN)),
				new I_Thrower() {
					
					@Override
					public void run() {
						new MethodSignature(null, null, null);
					}
				});
		
		assertThrown(new ExpectedThrowable(new IllegalArgumentException(
				MethodSignature.PARAMETERS_MAY_NOT_BE_EMPTY_STRINGS)),
				new I_Thrower() {
					
					@Override
					public void run() {
						new MethodSignature("hmm", new String[] {null}, null);
					}
				});
		assertThrown(new ExpectedThrowable(new IllegalArgumentException(
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
	public void testComparatorAlphaOrdering() {
		Set<MethodSignature> sigs = new TreeSet<MethodSignature>();
		sigs.add(new MethodSignature("<init>"));
		sigs.add(new MethodSignature("<init>", 
			new String[] {JSE_Lang.STRING}));
		sigs.add(new MethodSignature("<init>", 
			new String[] {JSE_Lang.STRING, JSE_Lang.THROWABLE}));
		sigs.add(new MethodSignature("<init>", 
			new String[] {JSE_Lang.STRING, JSE_Lang.THROWABLE, ClassMethods.BOOLEAN, ClassMethods.BOOLEAN}));
		sigs.add(new MethodSignature("<init>", 
			new String[] {JSE_Lang.THROWABLE}));
		
		assertEquals(5, sigs.size());
		Iterator<MethodSignature> it =  sigs.iterator();
		assertEquals(new MethodSignature("<init>"), it.next());
		assertEquals(new MethodSignature("<init>", 
				new String[] {JSE_Lang.STRING}), it.next());
		assertEquals(new MethodSignature("<init>", 
				new String[] {JSE_Lang.STRING, JSE_Lang.THROWABLE}), it.next());
		assertEquals(new MethodSignature("<init>", 
				new String[] {JSE_Lang.STRING, JSE_Lang.THROWABLE, ClassMethods.BOOLEAN, ClassMethods.BOOLEAN}), it.next());
		assertEquals(new MethodSignature("<init>", 
				new String[] {JSE_Lang.THROWABLE}), it.next());
		
		sigs.clear();
		sigs.add(new MethodSignature("<init>"));
		sigs.add(new MethodSignature("<init>", 
			new String[] {ClassMethods.BOOLEAN}));
		sigs.add(new MethodSignature("<init>", 
			new String[] {ClassMethods.CHAR}));
		sigs.add(new MethodSignature("<init>", 
			new String[] {ClassMethods.DOUBLE}));
		sigs.add(new MethodSignature("<init>", 
			new String[] {ClassMethods.FLOAT}));
		sigs.add(new MethodSignature("<init>", 
			new String[] {ClassMethods.INT}));
		sigs.add(new MethodSignature("<init>", 
			new String[] {JSE_Lang.OBJECT}));
		sigs.add(new MethodSignature("<init>", 
			new String[] {ClassMethods.LONG}));
		
		assertEquals(8, sigs.size());
		it =  sigs.iterator();
		assertEquals(new MethodSignature("<init>"), it.next());
		assertEquals(new MethodSignature("<init>", 
			new String[] {ClassMethods.BOOLEAN}), it.next());
		assertEquals(new MethodSignature("<init>", 
			new String[] {ClassMethods.CHAR}), it.next());
		assertEquals(new MethodSignature("<init>", 
			new String[] {ClassMethods.DOUBLE}), it.next());
		assertEquals(new MethodSignature("<init>", 
			new String[] {ClassMethods.FLOAT}), it.next());
		assertEquals(new MethodSignature("<init>", 
			new String[] {ClassMethods.INT}), it.next());
		assertEquals(new MethodSignature("<init>", 
			new String[] {JSE_Lang.OBJECT}), it.next());
		assertEquals(new MethodSignature("<init>", 
			new String[] {ClassMethods.LONG}), it.next());
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
	public int getTests(I_CountType type) {
		return super.getTests(type, 5, true);
	}

	@Override
	public int getAsserts(I_CountType type) {
		int thisAsserts = 50;
		//code coverage and circular dependencies +
		//custom afterTrialTests
		//+ see above
		int thisAfterAsserts = 3;
		if (type.isFromMetaWithCoverage()) {
			return super.getAsserts(type, thisAsserts + thisAfterAsserts);
		} else {
			return super.getAsserts(type, thisAsserts);
		}
	}

	@Override
	public int getUniqueAsserts(I_CountType type) {
		int thisUniqueAsserts = 34;
		//code coverage and circular dependencies +
		//custom afterTrialTests
		//+ see above
		int thisAfterUniqueAsserts = 3;
		if (type.isFromMetaWithCoverage()) {
			//code coverage and circular dependencies +
			//custom afterTrialTests
			return super.getUniqueAsserts(type, thisUniqueAsserts + thisAfterUniqueAsserts);
		} else {
			return super.getUniqueAsserts(type, thisUniqueAsserts);
		}
	}
}
