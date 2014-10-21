package org.adligo.tests4j_tests.shared.asserts.uniform;

import org.adligo.tests4j.shared.asserts.reference.AllowedReferences;
import org.adligo.tests4j.shared.asserts.uniform.EvaluationMutant;
import org.adligo.tests4j.system.shared.trials.SourceFileScope;
import org.adligo.tests4j.system.shared.trials.Test;
import org.adligo.tests4j_tests.base_trials.I_CountType;
import org.adligo.tests4j_tests.base_trials.SourceFileCountingTrial;
import org.adligo.tests4j_tests.references_groups.Tests4J_AssertsUniform_GwtReferenceGroup;
import org.adligo.tests4j_tests.references_groups.Tests4J_AssertsUniform_ReferenceGroup;

@SourceFileScope (sourceClass=EvaluationMutant.class, minCoverage=95.0)
@AllowedReferences (groups=Tests4J_AssertsUniform_GwtReferenceGroup.class)
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
	public int getTests(I_CountType type) {
		return super.getTests(type, 2, true);
	}

	@Override
	public int getAsserts(I_CountType type) {
		int asserts = 11;
		if (type.isFromMetaWithCoverage()) {
			//code coverage and circular dependencies
			return super.getAsserts(type, asserts + 3);
		} else {
			return super.getAsserts(type, asserts);
		}
	}

	@Override
	public int getUniqueAsserts(I_CountType type) {
		int uasserts = 7;
		if (type.isFromMetaWithCoverage()) {
			return super.getUniqueAsserts(type, uasserts + 3);
		} else {
			return super.getUniqueAsserts(type, uasserts);
		}
	}
}
