package org.adligo.tests4j_v1_tests.models.shared.dependency_groups.gwt.v2_6.lang;

import java.util.Set;

import org.adligo.tests4j.models.shared.dependency_groups.gwt.v2_6.GWT_2_6_Lang;
import org.adligo.tests4j.models.shared.results.I_SourceFileTrialResult;
import org.adligo.tests4j.shared.asserts.common.I_Asserts;
import org.adligo.tests4j.shared.asserts.dependency.I_ClassAttributes;
import org.adligo.tests4j.shared.asserts.dependency.I_FieldSignature;
import org.adligo.tests4j.shared.asserts.dependency.I_MethodSignature;
import org.adligo.tests4j.system.shared.trials.SourceFileScope;
import org.adligo.tests4j.system.shared.trials.Test;
import org.adligo.tests4j_tests.base_trials.I_CountType;
import org.adligo.tests4j_tests.base_trials.SourceFileCountingTrial;

@SourceFileScope (sourceClass=Object_2_6_MockUse.class)
public class Object_2_6_UseTrial extends SourceFileCountingTrial {

	@Test
	public void testMethods() throws Exception {
		new Object_2_6_MockUse();
		assertTrue("The trial should be able to create aObject_MockUse.",true);
	}

	@Override
	public void afterTrialTests(I_SourceFileTrialResult p) {
		super.afterTrialTests(p);
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
	public int getTests(I_CountType type) {
		return super.getTests(type, 1);
	}

	@Override
	public int getAsserts(I_CountType type) {
		int thisAsserts = 1;
		//code coverage and circular dependencies +
		//custom afterTrialTests
		//+ see above
		int thisAfterAsserts = 13;
		if (type.isFromMetaWithCoverage()) {
			return super.getAsserts(type, thisAsserts + thisAfterAsserts);
		} else {
			return super.getAsserts(type, thisAsserts);
		}
	}

	@Override
	public int getUniqueAsserts(I_CountType type) {
		int thisUniqueAsserts = 1;
		//code coverage and circular dependencies +
		//custom afterTrialTests
		//+ see above
		int thisAfterUniqueAsserts = 13;
		if (type.isFromMetaWithCoverage()) {
			//code coverage and circular dependencies +
			//custom afterTrialTests
			return super.getUniqueAsserts(type, thisUniqueAsserts + thisAfterUniqueAsserts);
		} else {
			return super.getUniqueAsserts(type, thisUniqueAsserts);
		}
	}
}
