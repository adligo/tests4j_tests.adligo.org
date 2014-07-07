package org.adligo.tests4j_tests.models.shared.common;

import org.adligo.tests4j.models.shared.asserts.ExpectedThrownData;
import org.adligo.tests4j.models.shared.asserts.common.I_Thrower;
import org.adligo.tests4j.models.shared.common.StringMethods;
import org.adligo.tests4j.models.shared.coverage.I_SourceFileCoverage;
import org.adligo.tests4j.models.shared.results.I_SourceFileTrialResult;
import org.adligo.tests4j.models.shared.trials.SourceFileScope;
import org.adligo.tests4j.models.shared.trials.SourceFileTrial;
import org.adligo.tests4j.models.shared.trials.Test;
import org.adligo.tests4j_tests.base_abstract_trials.SourceFileCountingTrial;

@SourceFileScope (sourceClass=StringMethods.class)
public class StringMethodsTrial extends SourceFileCountingTrial {

	@Test
	public void testMethods() {
		assertTrue(StringMethods.isEmpty(null));
		assertTrue(StringMethods.isEmpty(""));
		assertTrue(StringMethods.isEmpty("\t"));
		assertTrue(StringMethods.isEmpty("\n"));
		assertFalse(StringMethods.isEmpty("hey"));
		
		assertThrown(new ExpectedThrownData(new IllegalArgumentException("null message.")), new I_Thrower() {
			
			@Override
			public void run() {
				StringMethods.isEmpty(null, "null message.");
			}
		});
		
	}
	

	@Override
	public void afterTrialTests(I_SourceFileTrialResult p) {
		assertCounts(p);
		
		if (p.hasRecordedCoverage()) {
			I_SourceFileCoverage coverage = p.getSourceFileCoverage();
			assertGreaterThanOrEquals(79.0, coverage.getPercentageCoveredDouble());
		}
	}
	
	@Override
	public int getTests() {
		return 1;
	}

	@Override
	public int getAsserts() {
		return 6;
	}

	@Override
	public int getUniqueAsserts() {
		return 3;
	}
}
