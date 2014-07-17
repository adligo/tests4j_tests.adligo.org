package org.adligo.tests4j_tests.models.shared.asserts.uniform;

import java.util.Map;

import org.adligo.tests4j.models.shared.asserts.uniform.EvaluatorLookup;
import org.adligo.tests4j.models.shared.asserts.uniform.EvaluatorLookupMutant;
import org.adligo.tests4j.models.shared.asserts.uniform.I_UniformAssertionEvaluator;
import org.adligo.tests4j.models.shared.asserts.uniform.StringUniformEvaluator;
import org.adligo.tests4j.models.shared.trials.SourceFileScope;
import org.adligo.tests4j.models.shared.trials.Test;
import org.adligo.tests4j_tests.base_abstract_trials.SourceFileCountingTrial;

@SourceFileScope (sourceClass=EvaluatorLookup.class, minCoverage=88.0)
public class EvaluatorLookupTrial extends SourceFileCountingTrial {

	@Test
	public void testCopyConstructor() {
		EvaluatorLookupMutant elm = new EvaluatorLookupMutant();
		StringUniformEvaluator eval = new StringUniformEvaluator();
		elm.setEvaluator(String.class, eval);
		
		EvaluatorLookup elmCopied = new EvaluatorLookup(elm);
		Map<String, I_UniformAssertionEvaluator<?, ?>> data = elmCopied.getLookupData();
		assertNotNull(data);
		assertEquals("java.util.Collections$UnmodifiableMap", data.getClass().getName());
		assertEquals(1, data.size());
		assertSame(eval, data.get(String.class.getName()));
	
	}


	@Override
	public int getTests() {
		return 1;
	}

	@Override
	public int getAsserts() {
		return 4;
	}

	@Override
	public int getUniqueAsserts() {
		return 4;
	}
}
