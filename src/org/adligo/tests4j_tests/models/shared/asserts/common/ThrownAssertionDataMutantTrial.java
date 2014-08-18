package org.adligo.tests4j_tests.models.shared.asserts.common;

import org.adligo.tests4j.models.shared.asserts.common.ExpectedThrownData;
import org.adligo.tests4j.models.shared.asserts.common.ThrownAssertionDataMutant;
import org.adligo.tests4j.models.shared.trials.SourceFileScope;
import org.adligo.tests4j.models.shared.trials.Test;
import org.adligo.tests4j_tests.base_trials.SourceFileCountingTrial;

@SourceFileScope (sourceClass=ThrownAssertionDataMutant.class, minCoverage=70.0)
public class ThrownAssertionDataMutantTrial extends SourceFileCountingTrial {
	
	@Test
	public void testEqualsHashCodeAndCopyConstructor() {
		ExpectedThrownData etd = new ExpectedThrownData();
		
		ThrownAssertionDataMutant a = new ThrownAssertionDataMutant();
		a.setExpected(etd);
		assertSame(etd, a.getExpected());
		
		Throwable t = new IllegalArgumentException("hmm");
		a.setActual(t);
		
		ThrownAssertionDataMutant b = new ThrownAssertionDataMutant(a);
		b.setActual(new IllegalArgumentException("hmm2"));
		
		ThrownAssertionDataMutant c = new ThrownAssertionDataMutant(a);
		
		ThrownAssertionDataMutant d = new ThrownAssertionDataMutant(a);
		d.setActual(new IllegalStateException("hmm2"));
		
		ThrownAssertionDataMutant e = new ThrownAssertionDataMutant(a);
		e.setFailureReason("failureReason");
		assertEquals("failureReason", e.getFailureReason());
		
		ThrownAssertionDataMutant f = new ThrownAssertionDataMutant(a);
		f.setFailureThrowable(1);
		assertEquals(1, f.getFailureThrowable());
		
		assertEquals(a, a);
		assertEquals(a.hashCode(), a.hashCode());
		
		assertNotEquals(a, b);
		assertNotEquals(a.hashCode(), b.hashCode());
		
		assertEquals(a, c);
		assertEquals(a.hashCode(), c.hashCode());
		
		assertNotEquals(a, d);
		assertNotEquals(a.hashCode(), d.hashCode());
		
		assertNotEquals(a, e);
		assertNotEquals(a.hashCode(), e.hashCode());
		
		assertNotEquals(a, f);
		assertNotEquals(a.hashCode(), f.hashCode());
	}
	
	@Test
	public void testGetsAndSetsToString() {
		
		ThrownAssertionDataMutant a = new ThrownAssertionDataMutant();
		assertEquals("ThrownAssertionDataMutant [failureReason=null, "
				+ "failureThrowable=0]", a.toString());
		
		a.setFailureReason("failedReason");
		assertEquals("failedReason", a.getFailureReason());
		assertEquals("ThrownAssertionDataMutant [failureReason=failedReason, "
				+ "failureThrowable=0]", a.toString());
		
		a.setFailureThrowable(1);
		assertEquals(1, a.getFailureThrowable());
		assertEquals("ThrownAssertionDataMutant [failureReason=failedReason, "
				+ "failureThrowable=1]", a.toString());
	}

	@Override
	public int getTests() {
		return 2;
	}

	@Override
	public int getAsserts() {
		return 20;
	}

	@Override
	public int getUniqueAsserts() {
		return 13;
	}
}
