package org.adligo.tests4j_v1_tests.models.shared.reference_groups.gwt.v2_6.lang;

import org.adligo.tests4j.models.shared.reference_groups.gwt.v2_6.GWT_2_6_Lang;
import org.adligo.tests4j.models.shared.results.I_SourceFileTrialResult;
import org.adligo.tests4j.shared.asserts.reference.I_ClassAttributes;
import org.adligo.tests4j.shared.asserts.reference.I_FieldSignature;
import org.adligo.tests4j.shared.asserts.reference.I_MethodSignature;
import org.adligo.tests4j.system.shared.trials.SourceFileScope;
import org.adligo.tests4j.system.shared.trials.SuppressOutput;
import org.adligo.tests4j.system.shared.trials.Test;
import org.adligo.tests4j_tests.base_trials.I_CountType;
import org.adligo.tests4j_tests.base_trials.SourceFileCountingTrial;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

@SourceFileScope (sourceClass=NoSuchFieldError_2_6_MockUse.class)
@SuppressOutput
public class NoSuchFieldError_2_6_UseTrial extends SourceFileCountingTrial {

	@Test
	public void testMethods() throws Exception {
		new NoSuchFieldError_2_6_MockUse();
		assertTrue("The trial should be able to create aError_MockUse.",true);
	}

	@Override
	public void afterTrialTests(I_SourceFileTrialResult p) {
		super.afterTrialTests(p);
		I_ClassAttributes refs = p.getSourceClassAttributes();
		if (refs == null) {
			return;
		}
		assertEquals(NoSuchFieldError_2_6_MockUse.class.getName(), refs.getName());
		I_ClassAttributes result = p.getReferences("java.lang.NoSuchFieldError");
		assertNotNull(result);
		Set<I_FieldSignature> fields = new TreeSet<I_FieldSignature>();
		fields.addAll(result.getFields());
		Set<I_MethodSignature> methods = new TreeSet<I_MethodSignature>();
		methods.addAll(result.getMethods());

		List<String> parents = new ArrayList<String>();
		parents.add("java.lang.Object");
		parents.add("java.lang.Throwable");
		for(String parent: parents) {
			I_ClassAttributes ca = p.getReferences(parent);
			if (ca != null) {
				fields.addAll(ca.getFields());
				methods.addAll(ca.getMethods());
			}
		}
		I_ClassAttributes example = GWT_2_6_Lang.getNoSuchFieldError();
		assertEquals(example.getName(), result.getName());
		Set<I_FieldSignature> exampleFields = example.getFields();
		for (I_FieldSignature sig: exampleFields) {
			assertContains(fields, sig);
		}
		assertEquals(exampleFields.size(), fields.size());

		Set<I_MethodSignature> exampleMethods = example.getMethods();
		for (I_MethodSignature method: exampleMethods) {
			assertContains(methods, method);
		}
		assertEquals(exampleMethods.size(), methods.size());
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
		int thisAfterAsserts = 24;
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
		int thisAfterUniqueAsserts = 24;
		if (type.isFromMetaWithCoverage()) {
			//code coverage and circular dependencies +
			//custom afterTrialTests
			return super.getUniqueAsserts(type, thisUniqueAsserts + thisAfterUniqueAsserts);
		} else {
			return super.getUniqueAsserts(type, thisUniqueAsserts);
		}
	}
}