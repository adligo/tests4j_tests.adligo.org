package org.adligo.tests4j_tests.models.shared.asserts.uniform;

import java.util.Map;

import org.adligo.tests4j.models.shared.asserts.uniform.EvaluatorLookupMutant;
import org.adligo.tests4j.models.shared.asserts.uniform.I_UniformAssertionEvaluator;
import org.adligo.tests4j.models.shared.asserts.uniform.I_UniformThrownAssertionEvaluator;
import org.adligo.tests4j.models.shared.asserts.uniform.StringUniformEvaluator;
import org.adligo.tests4j.models.shared.asserts.uniform.UniformThrownAssertionEvaluator;
import org.adligo.tests4j.models.shared.trials.SourceFileScope;
import org.adligo.tests4j.models.shared.trials.Test;
import org.adligo.tests4j_tests.base_trials.I_CountType;
import org.adligo.tests4j_tests.base_trials.SourceFileCountingTrial;

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
		
		I_UniformThrownAssertionEvaluator<?> tevall =  elm.getThrownEvaulator();
		assertNotNull(tevall);
		
		UniformThrownAssertionEvaluator inst = new UniformThrownAssertionEvaluator();
		elm.setThrownEvaulator(inst);
		assertSame(inst, elm.getThrownEvaulator());
		
	}


	@Override
	public int getTests(I_CountType type) {
		return super.getTests(type, 2);
	}

	@Override
	public int getAsserts(I_CountType type) {
		if (type.isFromMetaWithCoverage()) {
			//code coverage and circular dependencies
			return super.getAsserts(type,17);
		} else {
			return super.getAsserts(type, 15);
		}
	}

	@Override
	public int getUniqueAsserts(I_CountType type) {
		if (type.isFromMetaWithCoverage()) {
			return super.getUniqueAsserts(type, 16);
		} else {
			return super.getUniqueAsserts(type, 14);
		}
	}
}
