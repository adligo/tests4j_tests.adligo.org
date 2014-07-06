package org.adligo.tests4j_tests.models.shared.asserts;

import java.util.Set;

import org.adligo.tests4j.models.shared.asserts.ThrownAssertionDataMutant;
import org.adligo.tests4j.models.shared.coverage.I_SourceFileCoverage;
import org.adligo.tests4j.models.shared.results.I_SourceFileTrialResult;
import org.adligo.tests4j.models.shared.trials.SourceFileScope;
import org.adligo.tests4j.models.shared.trials.SourceFileTrial;
import org.adligo.tests4j.models.shared.trials.Test;

@SourceFileScope (sourceClass=ThrownAssertionDataMutant.class)
public class ThrownAssertionDataMutantTrial extends SourceFileTrial {
	
	@Test
	public void testEqualsHashCodeAndCopyConstructor() {
		
		ThrownAssertionDataMutant a = new ThrownAssertionDataMutant();
		a.setActualMessage("actual");
		a.setActualThrowable(Throwable.class);
		a.setExpectedMessage("expected");
		a.setExpectedThrowable(Throwable.class);
		
		ThrownAssertionDataMutant b = new ThrownAssertionDataMutant(a);
		b.setExpectedMessage("expectedB");
		
		ThrownAssertionDataMutant c = new ThrownAssertionDataMutant(a);
		
		ThrownAssertionDataMutant d = new ThrownAssertionDataMutant(a);
		d.setActualMessage("actualD");
		
		ThrownAssertionDataMutant e = new ThrownAssertionDataMutant(a);
		e.setActualThrowable(IllegalStateException.class);
		
		ThrownAssertionDataMutant f = new ThrownAssertionDataMutant(a);
		f.setExpectedThrowable(IllegalStateException.class);
		
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
	public void testGetsAndSets() {
		
		ThrownAssertionDataMutant a = new ThrownAssertionDataMutant();
		a.setActualMessage("actual");
		assertEquals("actual", a.getActualMessage());
		
		a.setActualThrowable(Throwable.class);
		assertEquals(Throwable.class, a.getActualThrowable());
		
		a.setExpectedMessage("expected");
		assertEquals("expected", a.getExpectedMessage());
		
		a.setExpectedThrowable(IllegalArgumentException.class);
		assertEquals(IllegalArgumentException.class, a.getExpectedThrowable());
		
		Set<String> keys = a.getKeys();
		assertEquals(4, keys.size());
		assertContains(keys, ThrownAssertionDataMutant.ACTUAL_MESSAGE);
		assertContains(keys, ThrownAssertionDataMutant.ACTUAL_THROWABLE_CLASS);
		assertContains(keys, ThrownAssertionDataMutant.EXPECTED_MESSAGE);
		assertContains(keys, ThrownAssertionDataMutant.EXPECTED_THROWABLE_CLASS);
		
		assertEquals("actual", 
				a.getData(ThrownAssertionDataMutant.ACTUAL_MESSAGE));
		assertEquals(Throwable.class, 
				a.getData(ThrownAssertionDataMutant.ACTUAL_THROWABLE_CLASS));
		
		assertEquals("expected", 
				a.getData(ThrownAssertionDataMutant.EXPECTED_MESSAGE));
		assertEquals(IllegalArgumentException.class, 
				a.getData(ThrownAssertionDataMutant.EXPECTED_THROWABLE_CLASS));
	}
	
	@Override
	public void afterTrialTests(I_SourceFileTrialResult p) {
		assertEquals(2, p.getTestCount());
		assertGreaterThanOrEquals(25.0, p.getAssertionCount());
		assertGreaterThanOrEquals(13.0, p.getUniqueAssertionCount());
		
		if (p.hasRecordedCoverage()) {
			I_SourceFileCoverage coverage = p.getSourceFileCoverage();
			assertGreaterThanOrEquals(70.0, coverage.getPercentageCoveredDouble());
		}
	}
}
