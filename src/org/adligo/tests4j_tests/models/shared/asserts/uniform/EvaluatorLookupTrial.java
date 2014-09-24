package org.adligo.tests4j_tests.models.shared.asserts.uniform;

import java.util.Map;

import org.adligo.tests4j.models.shared.asserts.uniform.EvaluatorLookup;
import org.adligo.tests4j.models.shared.asserts.uniform.EvaluatorLookupMutant;
import org.adligo.tests4j.models.shared.asserts.uniform.I_UniformAssertionEvaluator;
import org.adligo.tests4j.models.shared.asserts.uniform.I_UniformThrownAssertionEvaluator;
import org.adligo.tests4j.models.shared.asserts.uniform.StringUniformEvaluator;
import org.adligo.tests4j.models.shared.asserts.uniform.UniformThrownAssertionEvaluator;
import org.adligo.tests4j.models.shared.dependency_groups.adligo.Tests4J_AssertsUniform_DependencyGroup;
import org.adligo.tests4j.models.shared.trials.AllowedDependencies;
import org.adligo.tests4j.models.shared.trials.SourceFileScope;
import org.adligo.tests4j.models.shared.trials.Test;
import org.adligo.tests4j_tests.base_trials.I_CountType;
import org.adligo.tests4j_tests.base_trials.SourceFileCountingTrial;

@SourceFileScope (sourceClass=EvaluatorLookup.class, minCoverage=85.0)
@AllowedDependencies (groups=Tests4J_AssertsUniform_DependencyGroup.class)
public class EvaluatorLookupTrial extends SourceFileCountingTrial {

	@Test
	public void testCopyConstructor() {
		EvaluatorLookupMutant elm = new EvaluatorLookupMutant();
		StringUniformEvaluator eval = new StringUniformEvaluator();
		elm.setEvaluator(String.class, eval);
		
		UniformThrownAssertionEvaluator inst = new UniformThrownAssertionEvaluator();
		elm.setThrownEvaulator(inst);
		assertSame(inst, elm.getThrownEvaulator());
		
		EvaluatorLookup elmCopied = new EvaluatorLookup(elm);
		Map<String, I_UniformAssertionEvaluator<?, ?>> data = elmCopied.getLookupData();
		assertNotNull(data);
		assertEquals("java.util.Collections$UnmodifiableMap", data.getClass().getName());
		assertEquals(1, data.size());
		assertSame(eval, data.get(String.class.getName()));
	
		I_UniformThrownAssertionEvaluator<?> tevall =  elm.getThrownEvaulator();
		assertSame(inst, tevall);
		
		EvaluatorLookup defaultEl = new EvaluatorLookup();
		assertNotNull(defaultEl.getThrownEvaulator());
		assertNotNull(defaultEl.getLookupData());
	}


	@Override
	public int getTests(I_CountType type) {
		return super.getTests(type, 1);
	}

	@Override
	public int getAsserts(I_CountType type) {
		int asserts = 8;
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
