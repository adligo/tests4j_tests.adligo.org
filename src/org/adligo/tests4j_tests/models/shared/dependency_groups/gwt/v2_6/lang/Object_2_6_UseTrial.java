package org.adligo.tests4j_tests.models.shared.dependency_groups.gwt.v2_6.lang;

import java.util.Set;

import org.adligo.tests4j.models.shared.asserts.common.I_Asserts;
import org.adligo.tests4j.models.shared.dependency.I_ClassAttributes;
import org.adligo.tests4j.models.shared.dependency.I_FieldSignature;
import org.adligo.tests4j.models.shared.dependency.I_MethodSignature;
import org.adligo.tests4j.models.shared.dependency_groups.gwt.GWT_2_6_Lang;
import org.adligo.tests4j.models.shared.results.I_SourceFileTrialResult;
import org.adligo.tests4j.models.shared.trials.SourceFileScope;
import org.adligo.tests4j.models.shared.trials.Test;
import org.adligo.tests4j_tests.base_trials.SourceFileCountingTrial;

@SourceFileScope (sourceClass=Object_2_6_MockUse.class)
public class Object_2_6_UseTrial extends SourceFileCountingTrial {

	@Test
	public void testMethods() throws Exception {
		new Object_2_6_MockUse();
		assertTrue("The trial should be able to create aObject_MockUse.",true);
	}

	public void afterTrialTests(I_SourceFileTrialResult p) {
		I_ClassAttributes refs = p.getSourceClassAttributes();
		if (refs == null) {
			return;
		}
		assertEquals(Object_2_6_MockUse.class.getName(), refs.getName());
		I_ClassAttributes result = p.getAttributes("java.lang.Object");
		I_ClassAttributes example = GWT_2_6_Lang.getObject();
		assertObjectMembers(this, result, example);
	}

	public static void assertObjectMembers(I_Asserts trial, I_ClassAttributes result,
			I_ClassAttributes example) {
		trial.assertNotNull(result);
		trial.assertNotNull(example);
		trial.assertEquals(example.getName(), result.getName());
		Set<I_FieldSignature> exampleFields = example.getFields();
		Set<I_FieldSignature> fields = result.getFields();
		for (I_FieldSignature sig: exampleFields) {
			trial.assertContains(fields, sig);
		}
		trial.assertEquals(exampleFields.size(), fields.size());

		Set<I_MethodSignature> exampleMethods = example.getMethods();
		Set<I_MethodSignature> methods = result.getMethods();
		for (I_MethodSignature method: exampleMethods) {
			trial.assertContains(methods, method);
		}
		trial.assertEquals(exampleMethods.size(), methods.size());
	}
	

	@Override
	public int getTests() {
		return 1;
	}

	@Override
	public int getAsserts() {
		return 1;
	}

	@Override
	public int getUniqueAsserts() {
		return 1;
	}
}
