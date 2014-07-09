package org.adligo.tests4j_tests.models.shared.asserts.uniform;

import org.adligo.tests4j.models.shared.asserts.uniform.Evaluation;
import org.adligo.tests4j.models.shared.asserts.uniform.EvaluationMutant;
import org.adligo.tests4j.models.shared.coverage.I_SourceFileCoverage;
import org.adligo.tests4j.models.shared.results.I_SourceFileTrialResult;
import org.adligo.tests4j.models.shared.trials.SourceFileScope;
import org.adligo.tests4j.models.shared.trials.Test;
import org.adligo.tests4j_tests.base_abstract_trials.SourceFileCountingTrial;

@SourceFileScope (sourceClass=Evaluation.class)
public class EvaluationTrial extends SourceFileCountingTrial {


	@Test
	public void testsGetsAndSets() {
		EvaluationMutant<String> em = new EvaluationMutant<>();
		Evaluation<String> copy = new Evaluation<>(em);
		assertFalse(copy.isSuccess());
		assertNull(copy.getFailureReason());
		assertNull(copy.getData());
		
		em.setSuccess(true);
		em.setFailureReason("failure reason");
		em.setData("hey data");
		
		copy = new Evaluation<>(em);
		assertTrue(copy.isSuccess());
		assertEquals("failure reason", copy.getFailureReason());
		assertEquals("hey data", copy.getData());
	}
	
	@Test
	public void testsConstructors() {
		Evaluation<String> em = new Evaluation<String>();
		assertFalse(em.isSuccess());
		assertNull(em.getFailureReason());
		assertNull(em.getData());
		
		EvaluationMutant<String> em2 = new EvaluationMutant<String>(em);
		em2.setSuccess(true);
		em2.setFailureReason("failure reason");
		em2.setData("hey data");
		Evaluation<String> e = new Evaluation<String>(em2);
		assertTrue(e.isSuccess());
		assertEquals("failure reason", e.getFailureReason());
		assertEquals("hey data", e.getData());
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
		return 12;
	}

	@Override
	public int getUniqueAsserts() {
		return 10;
	}
}
