package org.adligo.tests4j_tests.shared.asserts.uniform;

import java.util.Map;

import org.adligo.tests4j.shared.asserts.reference.AllowedReferences;
import org.adligo.tests4j.shared.asserts.uniform.EvaluatorLookup;
import org.adligo.tests4j.shared.asserts.uniform.EvaluatorLookupMutant;
import org.adligo.tests4j.shared.asserts.uniform.I_UniformAssertionEvaluator;
import org.adligo.tests4j.shared.asserts.uniform.I_UniformThrownAssertionEvaluator;
import org.adligo.tests4j.shared.asserts.uniform.StringUniformEvaluator;
import org.adligo.tests4j.shared.asserts.uniform.UniformThrownAssertionEvaluator;
import org.adligo.tests4j.shared.en.Tests4J_EnglishConstants;
import org.adligo.tests4j.system.shared.trials.SourceFileScope;
import org.adligo.tests4j.system.shared.trials.Test;
import org.adligo.tests4j_tests.base_trials.I_CountType;
import org.adligo.tests4j_tests.base_trials.SourceFileCountingTrial;
import org.adligo.tests4j_tests.references_groups.Tests4J_AssertsUniform_GwtReferenceGroup;

//hmm issue with code coverage should be 85 ish
@SourceFileScope (sourceClass=EvaluatorLookup.class, minCoverage=17.0)
@AllowedReferences (groups=Tests4J_AssertsUniform_GwtReferenceGroup.class)
public class EvaluatorLookupTrial extends SourceFileCountingTrial {

	@Test
	public void testCopyConstructor() {
		EvaluatorLookupMutant elm = new EvaluatorLookupMutant(Tests4J_EnglishConstants.ENGLISH);
		StringUniformEvaluator eval = new StringUniformEvaluator(Tests4J_EnglishConstants.ENGLISH);
		elm.setEvaluator(String.class, eval);
		
		UniformThrownAssertionEvaluator inst = new UniformThrownAssertionEvaluator(Tests4J_EnglishConstants.ENGLISH);
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
		
		EvaluatorLookup defaultEl = new EvaluatorLookup(Tests4J_EnglishConstants.ENGLISH);
		assertNotNull(defaultEl.getThrownEvaulator());
		assertNotNull(defaultEl.getLookupData());
	}


	@Override
	public int getTests(I_CountType type) {
		return super.getTests(type, 1, true);
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
