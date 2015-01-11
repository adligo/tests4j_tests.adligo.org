package org.adligo.tests4j_tests.references_groups;

import org.adligo.tests4j.shared.asserts.uniform.Evaluation;
import org.adligo.tests4j.shared.asserts.uniform.EvaluationMutant;
import org.adligo.tests4j.shared.asserts.uniform.EvaluatorLookup;
import org.adligo.tests4j.shared.asserts.uniform.EvaluatorLookupMutant;
import org.adligo.tests4j.shared.asserts.uniform.I_Evaluation;
import org.adligo.tests4j.shared.asserts.uniform.I_EvaluatorLookup;
import org.adligo.tests4j.shared.asserts.uniform.I_UniformAssertionCommand;
import org.adligo.tests4j.shared.asserts.uniform.I_UniformAssertionEvaluator;
import org.adligo.tests4j.shared.asserts.uniform.I_UniformThrownAssertionCommand;
import org.adligo.tests4j.shared.asserts.uniform.I_UniformThrownAssertionEvaluator;
import org.adligo.tests4j.shared.asserts.uniform.StringUniformEvaluator;
import org.adligo.tests4j.shared.asserts.uniform.ThrowableUniformEvaluator;
import org.adligo.tests4j.shared.asserts.uniform.UniformThrownAssertionEvaluator;
import org.adligo.tests4j.shared.asserts.uniform.UniformThrownAssertionEvaluatorUse;

import java.util.HashSet;
import java.util.Set;

/**
 * @diagram_sync with PackageDependencies.class on 10/1/1014
 * @author scott
 *
 */
public class Tests4J_AssertsUniform_ReferenceGroup extends Tests4J_ReferenceGroup {
	public static final Tests4J_AssertsUniform_ReferenceGroup INSTANCE = new Tests4J_AssertsUniform_ReferenceGroup();
	
	private Tests4J_AssertsUniform_ReferenceGroup() {
		Set<String> names = new HashSet<String>();
		
		add(names, Evaluation.class);
		add(names, EvaluationMutant.class);
		add(names, EvaluatorLookup.class);
		add(names, EvaluatorLookupMutant.class);
		
		add(names, I_Evaluation.class);
		add(names, I_EvaluatorLookup.class);
		
		add(names, I_UniformAssertionCommand.class);
		add(names, I_UniformAssertionEvaluator.class);
		add(names, I_UniformThrownAssertionCommand.class);
		add(names, I_UniformThrownAssertionEvaluator.class);
		
		add(names, StringUniformEvaluator.class);
		add(names, ThrowableUniformEvaluator.class);
		add(names, UniformThrownAssertionEvaluator.class);
		add(names, UniformThrownAssertionEvaluatorUse.class);
		
		names.addAll(Tests4J_AssertsLineText_ReferenceGroup.INSTANCE.getClassNames());
		
		setupDelegates(names);
	}
	
	private void add(Set<String> names, Class<?> c) {
		names.add(c.getName());
	}
}
