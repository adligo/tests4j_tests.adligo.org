package org.adligo.tests4j_tests.models.shared.asserts.uniform;

import org.adligo.tests4j.models.shared.asserts.uniform.Evaluation;
import org.adligo.tests4j.models.shared.asserts.uniform.EvaluationMutant;
import org.adligo.tests4j.models.shared.trials.SourceFileScope;
import org.adligo.tests4j.models.shared.trials.Test;
import org.adligo.tests4j_tests.base_trials.I_CountType;
import org.adligo.tests4j_tests.base_trials.SourceFileCountingTrial;

@SourceFileScope (sourceClass=Evaluation.class, minCoverage=95.0)
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
	public int getTests(I_CountType type) {
		return super.getTests(type, 2);
	}


	@Override
	public int getAsserts(I_CountType type) {
		if (type.isFromMetaWithCoverage()) {
			//code coverage and circular dependencies
			return super.getAsserts(type,14);
		} else {
			return super.getAsserts(type, 12);
		}
	}

	@Override
	public int getUniqueAsserts(I_CountType type) {
		if (type.isFromMetaWithCoverage()) {
			return super.getUniqueAsserts(type, 12);
		} else {
			return super.getUniqueAsserts(type, 10);
		}
	}
}
