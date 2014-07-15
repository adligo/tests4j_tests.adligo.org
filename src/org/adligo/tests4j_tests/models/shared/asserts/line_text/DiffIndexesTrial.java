package org.adligo.tests4j_tests.models.shared.asserts.line_text;

import org.adligo.tests4j.models.shared.asserts.ExpectedThrownData;
import org.adligo.tests4j.models.shared.asserts.common.I_Thrower;
import org.adligo.tests4j.models.shared.asserts.line_text.I_DiffIndexes;
import org.adligo.tests4j.models.shared.asserts.line_text.Diffndexes;
import org.adligo.tests4j.models.shared.coverage.I_SourceFileCoverage;
import org.adligo.tests4j.models.shared.results.I_SourceFileTrialResult;
import org.adligo.tests4j.models.shared.trials.SourceFileScope;
import org.adligo.tests4j.models.shared.trials.Test;
import org.adligo.tests4j_tests.base_abstract_trials.SourceFileCountingTrial;

@SourceFileScope (sourceClass=Diffndexes.class)
public class DiffIndexesTrial extends SourceFileCountingTrial {

	@Test
	public void testConstructorExceptions() {
		assertThrown(new ExpectedThrownData(new IllegalArgumentException(
				Diffndexes.START_END_DIFF_REQUIRES_POSITIVE_INDEXES)),
				new I_Thrower() {
					
					@Override
					public void run() {
						new Diffndexes(-1, 0);
					}
				});
		assertThrown(new ExpectedThrownData(new IllegalArgumentException(
				Diffndexes.START_END_DIFF_REQUIRES_POSITIVE_INDEXES)),
				new I_Thrower() {
					
					@Override
					public void run() {
						new Diffndexes(0, -1);
					}
				});
		
		assertThrown(new ExpectedThrownData(new IllegalArgumentException(
				Diffndexes.START_END_DIFF_REQUIRES_THE_START_TO_BE_BEFORE_THE_END)),
				new I_Thrower() {
					
					@Override
					public void run() {
						new Diffndexes(2, 1);
					}
				});
	}
	
	@Test
	public void testConstructorAndGetters() {
		I_DiffIndexes sed = new Diffndexes(0, 1);
		assertEquals(0, sed.getStart());
		assertEquals(1, sed.getEnd());
		
		sed = new Diffndexes(2, 3);
		assertEquals(2, sed.getStart());
		assertEquals(3, sed.getEnd());
	}
	
	@Override
	public void afterTrialTests(I_SourceFileTrialResult p) {
		assertCounts(p);
		
		if (p.hasRecordedCoverage()) {
			I_SourceFileCoverage coverage = p.getSourceFileCoverage();
			assertGreaterThanOrEquals(100.0, coverage.getPercentageCoveredDouble());
		}
	}

	
	@Override
	public int getTests() {
		return 2;
	}

	@Override
	public int getAsserts() {
		return 7;
	}

	@Override
	public int getUniqueAsserts() {
		return 7;
	}
}
