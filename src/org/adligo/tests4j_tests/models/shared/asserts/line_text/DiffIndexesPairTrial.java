package org.adligo.tests4j_tests.models.shared.asserts.line_text;

import org.adligo.tests4j.models.shared.asserts.line_text.Diffndexes;
import org.adligo.tests4j.models.shared.asserts.line_text.DiffIndexesPair;
import org.adligo.tests4j.models.shared.asserts.line_text.I_DiffIndexes;
import org.adligo.tests4j.models.shared.asserts.line_text.I_DiffIndexesPair;
import org.adligo.tests4j.models.shared.coverage.I_SourceFileCoverage;
import org.adligo.tests4j.models.shared.results.I_SourceFileTrialResult;
import org.adligo.tests4j.models.shared.trials.SourceFileScope;
import org.adligo.tests4j.models.shared.trials.Test;
import org.adligo.tests4j_tests.base_abstract_trials.SourceFileCountingTrial;

@SourceFileScope (sourceClass=DiffIndexesPair.class)
public class DiffIndexesPairTrial extends SourceFileCountingTrial {

	
	@Test
	public void testConstructorAndGetters() {
		I_DiffIndexes sed = new Diffndexes(0, 1);
		
		I_DiffIndexes sed2 = new Diffndexes(2, 3);
		
		I_DiffIndexesPair pair = new DiffIndexesPair(sed, sed2);
		assertSame(sed, pair.getExample());
		assertSame(sed2, pair.getActual());
	}
	
	@Test
	public void testCompareLinesEndMatch() throws Exception {
		DiffIndexesPair result = new DiffIndexesPair("cab", "dab");
		assertNotNull(result);
		I_DiffIndexes exampleIndexes = result.getExample();
		assertNotNull(exampleIndexes);
		I_DiffIndexes actualIndexes = result.getActual();
		assertNotNull(actualIndexes);
		assertEquals(0, exampleIndexes.getStart());
		assertEquals(0, exampleIndexes.getEnd());
		
		assertEquals(0, actualIndexes.getStart());
		assertEquals(0, actualIndexes.getEnd());
	}
	
	@Test
	public void testCompareLinesStartMatch() throws Exception {
		DiffIndexesPair result = new DiffIndexesPair("abc", "aba");
		assertNotNull(result);
		I_DiffIndexes exampleIndexes = result.getExample();
		assertNotNull(exampleIndexes);
		I_DiffIndexes actualIndexes = result.getActual();
		assertNotNull(actualIndexes);
		assertEquals(2, exampleIndexes.getStart());
		assertEquals(2, exampleIndexes.getEnd());
		
		assertEquals(2, actualIndexes.getStart());
		assertEquals(2, actualIndexes.getEnd());
	}
	
	
	@Test
	public void testCompareLinesMiddleMatch() throws Exception {
		DiffIndexesPair result = new DiffIndexesPair("abcbloffabc", "abcscoff234abc");
		assertNotNull(result);
		I_DiffIndexes exampleIndexes = result.getExample();
		assertNotNull(exampleIndexes);
		I_DiffIndexes actualIndexes = result.getActual();
		assertNotNull(actualIndexes);
		assertEquals(3, exampleIndexes.getStart());
		assertEquals(7, exampleIndexes.getEnd());
		
		assertEquals(3, actualIndexes.getStart());
		assertEquals(10, actualIndexes.getEnd());
	}
	
	@Override
	public void afterTrialTests(I_SourceFileTrialResult p) {
		assertCounts(p);
		
		if (p.hasRecordedCoverage()) {
			I_SourceFileCoverage coverage = p.getSourceFileCoverage();
			assertGreaterThanOrEquals(95.0, coverage.getPercentageCoveredDouble());
		}
	}

	
	@Override
	public int getTests() {
		return 4;
	}

	@Override
	public int getAsserts() {
		return 23;
	}

	@Override
	public int getUniqueAsserts() {
		return 16;
	}
}
