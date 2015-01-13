package org.adligo.tests4j_tests.shared.asserts.common;

import org.adligo.tests4j.shared.asserts.common.ExpectedThrowable;
import org.adligo.tests4j.shared.asserts.common.ThrownAssertionDataMutant;
import org.adligo.tests4j.shared.asserts.reference.AllowedReferences;
import org.adligo.tests4j.system.shared.trials.SourceFileScope;
import org.adligo.tests4j.system.shared.trials.Test;
import org.adligo.tests4j_tests.base_trials.I_CountType;
import org.adligo.tests4j_tests.base_trials.SourceFileCountingTrial;
import org.adligo.tests4j_tests.references_groups.Tests4J_AssertsCommon_GwtReferenceGroup;

@SourceFileScope (sourceClass=ThrownAssertionDataMutant.class, minCoverage=70.0)
@AllowedReferences (groups=Tests4J_AssertsCommon_GwtReferenceGroup.class)
public class ThrownAssertionDataMutantTrial extends SourceFileCountingTrial {
	
	@Test
	public void testEqualsHashCodeAndCopyConstructor() {
		ExpectedThrowable etd = mock(ExpectedThrowable.class);
		
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
	public int getTests(I_CountType type) {
		return super.getTests(type, 2, true);
	}

	@Override
	public int getAsserts(I_CountType type) {
		int asserts = 20;
		if (type.isFromMetaWithCoverage()) {
			//code coverage and circular dependencies
			return super.getAsserts(type, asserts + 3);
		} else {
			return super.getAsserts(type, asserts);
		}
	}

	@Override
	public int getUniqueAsserts(I_CountType type) {
		int uasserts = 13;
		if (type.isFromMetaWithCoverage()) {
			return super.getUniqueAsserts(type, uasserts + 3);
		} else {
			return super.getUniqueAsserts(type, uasserts);
		}
	}
}
