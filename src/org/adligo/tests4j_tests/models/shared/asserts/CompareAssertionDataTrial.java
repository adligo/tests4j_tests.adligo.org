package org.adligo.tests4j_tests.models.shared.asserts;

import org.adligo.tests4j.models.shared.asserts.CompareAssertionData;
import org.adligo.tests4j.models.shared.coverage.I_SourceFileCoverage;
import org.adligo.tests4j.models.shared.results.I_SourceFileTrialResult;
import org.adligo.tests4j.models.shared.trials.SourceFileScope;
import org.adligo.tests4j.models.shared.trials.SourceFileTrial;
import org.adligo.tests4j.models.shared.trials.Test;

@SourceFileScope (sourceClass=CompareAssertionData.class)
public class CompareAssertionDataTrial extends SourceFileTrial {

	@Test
	public void testEqualsHashCode() {
		CompareAssertionData<String> a = new CompareAssertionData<String>("a","a");
		CompareAssertionData<String> b = new CompareAssertionData<String>("a","b");
		CompareAssertionData<String> c = new CompareAssertionData<String>("a","a");
		CompareAssertionData<String> d = new CompareAssertionData<String>("b","b");
		CompareAssertionData<String> e = new CompareAssertionData<String>("b","a");
		
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
		
		assertNotEquals(a, new Object());
	}
	
	@Test
	public void testGetters() {
		CompareAssertionData<String> a = new CompareAssertionData<String>("a","b");
		assertEquals("a", a.getData(CompareAssertionData.EXPECTED));
		assertEquals("b", a.getData(CompareAssertionData.ACTUAL));
		assertNull(a.getData(null));
		
		assertEquals("a", a.getTypedData(CompareAssertionData.EXPECTED));
		assertEquals("b", a.getTypedData(CompareAssertionData.ACTUAL));
		assertNull(a.getTypedData(null));
	
		assertEquals("a", a.getExpected());
		assertEquals("b", a.getActual());
	}
	
	@Test
	public void testToString() {
		CompareAssertionData<String> a = new CompareAssertionData<String>("a","b");
		assertEquals("CompareAssertionData [expected=a, actual=b]", a.toString());
	}
	
	@Override
	public void afterTrialTests(I_SourceFileTrialResult p) {
		assertEquals(3, p.getTestCount());
		assertGreaterThanOrEquals(19.0, p.getAssertionCount());
		assertGreaterThanOrEquals(9.0, p.getUniqueAssertionCount());
		
		if (p.hasRecordedCoverage()) {
			I_SourceFileCoverage coverage = p.getSourceFileCoverage();
			assertGreaterThanOrEquals(70.0, coverage.getPercentageCoveredDouble());
		}
	}
}
