package org.adligo.tests4j_tests.models.shared.asserts.uniform;

import org.adligo.tests4j.models.shared.asserts.uniform.EvaluationMutant;
import org.adligo.tests4j.models.shared.trials.SourceFileScope;
import org.adligo.tests4j.models.shared.trials.Test;
import org.adligo.tests4j_tests.base_trials.SourceFileCountingTrial;

@SourceFileScope (sourceClass=EvaluationMutant.class, minCoverage=95.0)
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
