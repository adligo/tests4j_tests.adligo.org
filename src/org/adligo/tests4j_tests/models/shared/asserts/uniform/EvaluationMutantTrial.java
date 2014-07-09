package org.adligo.tests4j_tests.models.shared.asserts.uniform;

import org.adligo.tests4j.models.shared.asserts.uniform.EvaluationMutant;
import org.adligo.tests4j.models.shared.coverage.I_SourceFileCoverage;
import org.adligo.tests4j.models.shared.results.I_SourceFileTrialResult;
import org.adligo.tests4j.models.shared.trials.SourceFileScope;
import org.adligo.tests4j.models.shared.trials.Test;
import org.adligo.tests4j_tests.base_abstract_trials.SourceFileCountingTrial;

@SourceFileScope (sourceClass=EvaluationMutant.class)
public class EvaluationMutantTrial extends SourceFileCountingTrial {

	@Test
	public void testsGetsAndSets() {
		EvaluationMutant<String> em = new EvaluationMutant<>();
		assertFalse(em.isSuccess());
		assertNull(em.getFailureReason());
		assertNull(em.getData());
		
		em.setFailureReason("failure reason");
		assertEquals("failure reason", em.getFailureReason());
		em.setData("hey data");
		assertEquals("hey data", em.getData());
	}
	
	@Test
	public void testsCopyConstructor() {
		EvaluationMutant<String> em = new EvaluationMutant<>();
		em.setSuccess(true);
		assertTrue(em.isSuccess());
		em.setFailureReason("failure reason");
		assertEquals("failure reason", em.getFailureReason());
		em.setData("hey data");
		assertEquals("hey data", em.getData());
		
		EvaluationMutant<String> em2 = new EvaluationMutant<String>(em);
		assertTrue(em2.isSuccess());
		assertEquals("failure reason", em2.getFailureReason());
		assertEquals("hey data", em2.getData());
	}
	
	@Override
	public void afterTrialTests(I_SourceFileTrialResult p) {
		assertCounts(p);
		
		if (p.hasRecordedCoverage()) {
			I_SourceFileCoverage coverage = p.getSourceFileCoverage();
			//hmm this should be 95, looks like multithreading
			double pct = coverage.getPercentageCoveredDouble();
			assertGreaterThanOrEquals(95.0, pct);
		}
	}


	@Override
	public int getTests() {
		return 2;
	}

	@Override
	public int getAsserts() {
		return 11;
	}

	@Override
	public int getUniqueAsserts() {
		return 7;
	}
}
