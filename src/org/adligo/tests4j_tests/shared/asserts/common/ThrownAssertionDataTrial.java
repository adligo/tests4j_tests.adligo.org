package org.adligo.tests4j_tests.shared.asserts.common;

import org.adligo.tests4j.shared.asserts.common.ExpectedThrownData;
import org.adligo.tests4j.shared.asserts.common.ThrownAssertionData;
import org.adligo.tests4j.shared.asserts.common.ThrownAssertionDataMutant;
import org.adligo.tests4j.shared.asserts.reference.AllowedReferences;
import org.adligo.tests4j.system.shared.trials.SourceFileScope;
import org.adligo.tests4j.system.shared.trials.Test;
import org.adligo.tests4j_tests.base_trials.I_CountType;
import org.adligo.tests4j_tests.base_trials.SourceFileCountingTrial;
import org.adligo.tests4j_tests.references_groups.Tests4J_AssertsCommon_GwtReferenceGroup;

@SourceFileScope (sourceClass=ThrownAssertionData.class, minCoverage=70.0)
@AllowedReferences (groups=Tests4J_AssertsCommon_GwtReferenceGroup.class)
public class ThrownAssertionDataTrial extends SourceFileCountingTrial {

	@Test
	public void testEqualsHashCodeAndCopyConstructor() {
		ExpectedThrownData etd = new ExpectedThrownData();
		
		ThrownAssertionDataMutant a = new ThrownAssertionDataMutant();
		a.setExpected(etd);
		assertSame(etd, a.getExpected());
		
		Throwable t = new IllegalArgumentException("hmm");
		a.setActual(t);
		ThrownAssertionData aPrime = new ThrownAssertionData(a);
		
		ThrownAssertionDataMutant b = new ThrownAssertionDataMutant(a);
		b.setActual(new IllegalArgumentException("hmm2"));
		ThrownAssertionData bPrime = new ThrownAssertionData(b);
		
		ThrownAssertionData cPrime = new ThrownAssertionData(a);
		
		ThrownAssertionDataMutant d = new ThrownAssertionDataMutant(a);
		d.setActual(new IllegalStateException("hmm2"));
		ThrownAssertionData dPrime = new ThrownAssertionData(d);
		
		ThrownAssertionDataMutant e = new ThrownAssertionDataMutant(a);
		e.setFailureReason("failureReason");
		assertEquals("failureReason", e.getFailureReason());
		ThrownAssertionData ePrime = new ThrownAssertionData(e);
		
		ThrownAssertionDataMutant f = new ThrownAssertionDataMutant(a);
		f.setFailureThrowable(1);
		assertEquals(1, f.getFailureThrowable());
		ThrownAssertionData fPrime = new ThrownAssertionData(f);
		
		assertEquals(aPrime, aPrime);
		assertEquals(aPrime.hashCode(), aPrime.hashCode());
		
		assertNotEquals(aPrime, bPrime);
		assertNotEquals(aPrime.hashCode(), bPrime.hashCode());
		
		assertEquals(aPrime, cPrime);
		assertEquals(aPrime.hashCode(), cPrime.hashCode());
		
		assertNotEquals(aPrime, dPrime);
		assertNotEquals(aPrime.hashCode(), dPrime.hashCode());
		
		assertNotEquals(aPrime, ePrime);
		assertNotEquals(aPrime.hashCode(), ePrime.hashCode());
		
		assertNotEquals(aPrime, fPrime);
		assertNotEquals(aPrime.hashCode(), fPrime.hashCode());
	}
	
	@Test
	public void testGetsAndSetsToString() {
		ThrownAssertionDataMutant mut = new ThrownAssertionDataMutant();
		ThrownAssertionData a = new ThrownAssertionData();
		assertEquals("ThrownAssertionData [failureReason=null, "
				+ "failureThrowable=0]", a.toString());
		
		mut.setFailureReason("failedReason");
		a = new ThrownAssertionData(mut);
		assertEquals("failedReason", a.getFailureReason());
		assertEquals("ThrownAssertionData [failureReason=failedReason, "
				+ "failureThrowable=0]", a.toString());
		
		mut.setFailureThrowable(1);
		a = new ThrownAssertionData(mut);
		assertEquals(1, a.getFailureThrowable());
		assertEquals("ThrownAssertionData [failureReason=failedReason, "
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
