package org.adligo.tests4j_tests.models.shared.dependency_groups.gwt.v2_6.lang;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.adligo.tests4j.models.shared.dependency.I_ClassAttributes;
import org.adligo.tests4j.models.shared.dependency.I_FieldSignature;
import org.adligo.tests4j.models.shared.dependency.I_MethodSignature;
import org.adligo.tests4j.models.shared.dependency_groups.gwt.GWT_2_6_Lang;
import org.adligo.tests4j.models.shared.results.I_SourceFileTrialResult;
import org.adligo.tests4j.models.shared.trials.SourceFileScope;
import org.adligo.tests4j.models.shared.trials.SuppressOutput;
import org.adligo.tests4j.models.shared.trials.Test;
import org.adligo.tests4j_tests.base_trials.SourceFileCountingTrial;

@SourceFileScope (sourceClass=IllegalArgumentException_2_6_MockUse.class)
@SuppressOutput
public class IllegalArgumentException_2_6_UseTrial extends SourceFileCountingTrial {

	@Test
	public void testMethods() throws Exception {
		new IllegalArgumentException_2_6_MockUse();
		assertTrue("The trial should be able to create aIllegalArgumentException_MockUse.",true);
	}

	public void afterTrialTests(I_SourceFileTrialResult p) {
		I_ClassAttributes refs = p.getSourceClassAttributes();
		if (refs == null) {
			return;
		}
		assertEquals(IllegalArgumentException_2_6_MockUse.class.getName(), refs.getName());
		I_ClassAttributes result = p.getAttributes("java.lang.IllegalArgumentException");
		assertNotNull(result);
		Set<I_FieldSignature> fields = new TreeSet<I_FieldSignature>();
		fields.addAll(result.getFields());
		Set<I_MethodSignature> methods = new TreeSet<I_MethodSignature>();
		methods.addAll(result.getMethods());

		List<String> parents = new ArrayList<String>();
		parents.add("java.lang.Object");
		parents.add("java.lang.Throwable");
		parents.add("java.lang.Exception");
		parents.add("java.lang.RuntimeException");
		for(String parent: parents) {
			I_ClassAttributes ca = p.getAttributes(parent);
			if (ca != null) {
				fields.addAll(ca.getFields());
				methods.addAll(ca.getMethods());
			}
		}
		I_ClassAttributes example = GWT_2_6_Lang.getIllegalArgumentException();
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