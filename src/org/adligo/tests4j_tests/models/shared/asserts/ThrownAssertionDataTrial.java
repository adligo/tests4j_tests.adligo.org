package org.adligo.tests4j_tests.models.shared.asserts;

import java.util.Set;

import org.adligo.tests4j.models.shared.asserts.ThrownAssertionData;
import org.adligo.tests4j.models.shared.asserts.ThrownAssertionDataMutant;
import org.adligo.tests4j.models.shared.coverage.I_SourceFileCoverage;
import org.adligo.tests4j.models.shared.results.I_SourceFileTrialResult;
import org.adligo.tests4j.models.shared.trials.SourceFileScope;
import org.adligo.tests4j.models.shared.trials.SourceFileTrial;
import org.adligo.tests4j.models.shared.trials.Test;
import org.adligo.tests4j_tests.base_abstract_trials.SourceFileCountingTrial;

@SourceFileScope (sourceClass=ThrownAssertionData.class)
public class ThrownAssertionDataTrial extends SourceFileCountingTrial {
	@Test
	public void testEqualsHashCodeAndCopyConstructor() {
		
		ThrownAssertionDataMutant a = new ThrownAssertionDataMutant();
		a.setActualMessage("actual");
		a.setActualThrowable(Throwable.class);
		a.setExpectedMessage("expected");
		a.setExpectedThrowable(Throwable.class);
		ThrownAssertionData aPrime = new ThrownAssertionData(a);
		
		ThrownAssertionDataMutant b = new ThrownAssertionDataMutant(aPrime);
		b.setExpectedMessage("expectedB");
		ThrownAssertionData bPrime = new ThrownAssertionData(b);
		
		ThrownAssertionData cPrime = new ThrownAssertionData(aPrime);
		
		ThrownAssertionDataMutant d = new ThrownAssertionDataMutant(a);
		d.setActualMessage("actualD");
		ThrownAssertionData dPrime = new ThrownAssertionData(d);
		
		ThrownAssertionDataMutant e = new ThrownAssertionDataMutant(a);
		e.setActualThrowable(IllegalStateException.class);
		ThrownAssertionData ePrime = new ThrownAssertionData(e);
		
		ThrownAssertionDataMutant f = new ThrownAssertionDataMutant(a);
		f.setExpectedThrowable(IllegalStateException.class);
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
	public void testGetsAndSets() {
		
		ThrownAssertionDataMutant a = new ThrownAssertionDataMutant();
		a.setActualMessage("actual");
		a.setActualThrowable(Throwable.class);
		a.setExpectedMessage("expected");
		a.setExpectedThrowable(IllegalArgumentException.class);
		ThrownAssertionData aPrime = new ThrownAssertionData(a);
		
		
		assertEquals("actual", aPrime.getActualMessage());
		assertEquals(Throwable.class, aPrime.getActualThrowable());
		assertEquals("expected", aPrime.getExpectedMessage());
		assertEquals(IllegalArgumentException.class, aPrime.getExpectedThrowable());
		
		Set<String> keys = aPrime.getKeys();
		assertEquals(4, keys.size());
		assertContains(keys, ThrownAssertionDataMutant.ACTUAL_MESSAGE);
		assertContains(keys, ThrownAssertionDataMutant.ACTUAL_THROWABLE_CLASS);
		assertContains(keys, ThrownAssertionDataMutant.EXPECTED_MESSAGE);
		assertContains(keys, ThrownAssertionDataMutant.EXPECTED_THROWABLE_CLASS);
		
		assertEquals("actual", 
				aPrime.getData(ThrownAssertionDataMutant.ACTUAL_MESSAGE));
		assertEquals(Throwable.class, 
				aPrime.getData(ThrownAssertionDataMutant.ACTUAL_THROWABLE_CLASS));
		
		assertEquals("expected", 
				aPrime.getData(ThrownAssertionDataMutant.EXPECTED_MESSAGE));
		assertEquals(IllegalArgumentException.class, 
				aPrime.getData(ThrownAssertionDataMutant.EXPECTED_THROWABLE_CLASS));
	}
	
	@Override
	public void afterTrialTests(I_SourceFileTrialResult p) {
		assertCounts(p);
		
		if (p.hasRecordedCoverage()) {
			I_SourceFileCoverage coverage = p.getSourceFileCoverage();
			assertGreaterThanOrEquals(70.0, coverage.getPercentageCoveredDouble());
		}
	}
	

	@Override
	public int getTests() {
		return 2;
	}

	@Override
	public int getAsserts() {
		return 25;
	}

	@Override
	public int getUniqueAsserts() {
		return 14;
	}
}
