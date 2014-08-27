package org.adligo.tests4j_tests.models.shared.dependency_groups.gwt;


import java.util.List;
import java.util.Set;

import org.adligo.tests4j.models.shared.dependency.I_ClassAttributes;
import org.adligo.tests4j.models.shared.dependency.I_ClassDependencies;
import org.adligo.tests4j.models.shared.dependency.I_FieldSignature;
import org.adligo.tests4j.models.shared.dependency.I_MethodSignature;
import org.adligo.tests4j.models.shared.dependency_groups.gwt.GWT_2_6_Lang;
import org.adligo.tests4j.models.shared.results.I_SourceFileTrialResult;
import org.adligo.tests4j.models.shared.trials.SourceFileScope;
import org.adligo.tests4j.models.shared.trials.Test;
import org.adligo.tests4j_tests.base_trials.SourceFileCountingTrial;

@SourceFileScope (sourceClass=Appendable_2_6_MockUse.class)
public class Appendable_2_6_ClassAttributeUseTrial extends SourceFileCountingTrial 
  implements Appendable {

	private int methodsCalled = 0;

	public java.lang.Appendable append(char p0) {
		methodsCalled++;
		return this;
	}
	public java.lang.Appendable append(java.lang.CharSequence p0, int p1, int p2) {
		methodsCalled++;
		return this;
	}
	public java.lang.Appendable append(java.lang.CharSequence p0) {
		methodsCalled++;
		return this;
	}

	@Test
	public void testMethods() throws Throwable {
		new Appendable_2_6_MockUse(this);
		assertEquals(3, methodsCalled);
	}

	public void afterTrialTests(I_SourceFileTrialResult p) {
		super.afterTrialTests(p);
		I_ClassDependencies cRefs = p.getDependencies();
		if (cRefs == null) {
			return;
		}
		List<I_ClassAttributes> refs = cRefs.getReferences();
		I_ClassAttributes example = GWT_2_6_Lang.getAppendable();
		I_ClassAttributes ca = refs.get(0);
		assertNotNull(ca);
		assertEquals(example.getClassName(), ca.getClassName());
		Set<I_FieldSignature> exampleFields = example.getFields();
		Set<I_FieldSignature> fields = ca.getFields();
		for (I_FieldSignature sig: exampleFields) {
			assertContains(fields, sig);
		}
		assertEquals(exampleFields.size(), fields.size());
		Set<I_MethodSignature> exampleMethods = example.getMethods();
		Set<I_MethodSignature> methods = ca.getMethods();
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