package org.adligo.tests4j_tests.models.shared.asserts.uniform;

import java.util.Map;

import org.adligo.tests4j.models.shared.asserts.uniform.EvaluatorLookupMutant;
import org.adligo.tests4j.models.shared.asserts.uniform.I_UniformAssertionEvaluator;
import org.adligo.tests4j.models.shared.asserts.uniform.StringUniformEvaluator;
import org.adligo.tests4j.models.shared.trials.SourceFileScope;
import org.adligo.tests4j.models.shared.trials.Test;
import org.adligo.tests4j_tests.base_abstract_trials.SourceFileCountingTrial;

@SourceFileScope (sourceClass=EvaluatorLookupMutant.class, minCoverage=88.0)
public class EvaluatorLookupMutantTrial extends SourceFileCountingTrial {

	@Test
	public void testCopyConstructor() {
		EvaluatorLookupMutant elm = new EvaluatorLookupMutant();
		StringUniformEvaluator eval = new StringUniformEvaluator();
		elm.setEvaluator(String.class, eval);
		
		EvaluatorLookupMutant elmCopied = new EvaluatorLookupMutant(elm);
		Map<String, I_UniformAssertionEvaluator<?, ?>> data = elmCopied.getLookupData();
		assertNotNull(data);
		assertEquals(1, data.size());
		assertSame(eval, data.get(String.class.getName()));
	
		elmCopied.removeEvaluator(String.class.getName());
		assertNull(elmCopied.findEvaluator(String.class));
		data = elmCopied.getLookupData();
		assertNotNull(data);
		assertEquals(0, data.size());
	}
	
	@Test
	public void testGetsAndSets() {
		EvaluatorLookupMutant elm = new EvaluatorLookupMutant();
		StringUniformEvaluator eval = new StringUniformEvaluator();
		elm.setEvaluator(String.class, eval);
		
		assertSame(eval, elm.findEvaluator(String.class));
		Map<String, I_UniformAssertionEvaluator<?, ?>> data = elm.getLookupData();
		assertNotNull(data);
		assertEquals(1, data.size());
		assertSame(eval, data.get(String.class.getName()));
	
		elm.removeEvaluator(String.class.getName());
		assertNull(elm.findEvaluator(String.class));
		data = elm.getLookupData();
		assertNotNull(data);
		assertEquals(0, data.size());
	}


	@Override
	public int getTests() {
		return 2;
	}

	@Override
	public int getAsserts() {
		return 13;
	}

	@Override
	public int getUniqueAsserts() {
		return 12;
	}
}
