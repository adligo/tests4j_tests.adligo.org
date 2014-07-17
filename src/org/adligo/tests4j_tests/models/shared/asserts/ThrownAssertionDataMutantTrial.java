package org.adligo.tests4j_tests.models.shared.asserts;

import java.util.Set;

import org.adligo.tests4j.models.shared.asserts.ThrownAssertionDataMutant;
import org.adligo.tests4j.models.shared.trials.SourceFileScope;
import org.adligo.tests4j.models.shared.trials.Test;
import org.adligo.tests4j_tests.base_abstract_trials.SourceFileCountingTrial;

@SourceFileScope (sourceClass=ThrownAssertionDataMutant.class, minCoverage=70.0)
public class ThrownAssertionDataMutantTrial extends SourceFileCountingTrial {
	
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
