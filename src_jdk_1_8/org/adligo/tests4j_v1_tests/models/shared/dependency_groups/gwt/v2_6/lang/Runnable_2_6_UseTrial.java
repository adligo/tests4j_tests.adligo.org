package org.adligo.tests4j_v1_tests.models.shared.dependency_groups.gwt.v2_6.lang;

import java.util.Set;

import org.adligo.tests4j.models.shared.dependency_groups.gwt.v2_6.GWT_2_6_Lang;
import org.adligo.tests4j.models.shared.results.I_SourceFileTrialResult;
import org.adligo.tests4j.shared.asserts.dependency.I_ClassAttributes;
import org.adligo.tests4j.shared.asserts.dependency.I_FieldSignature;
import org.adligo.tests4j.shared.asserts.dependency.I_MethodSignature;
import org.adligo.tests4j.system.shared.trials.SourceFileScope;
import org.adligo.tests4j.system.shared.trials.SuppressOutput;
import org.adligo.tests4j.system.shared.trials.Test;
import org.adligo.tests4j_tests.base_trials.I_CountType;
import org.adligo.tests4j_tests.base_trials.SourceFileCountingTrial;

@SourceFileScope (sourceClass=Runnable_2_6_MockUse.class)
@SuppressOutput
public class Runnable_2_6_UseTrial extends SourceFileCountingTrial 
  implements Runnable {

	private int methodsCalled = 0;

	public void run() {
		methodsCalled++;
	}

	@Test
	public void testMethods() throws Exception {
		new Runnable_2_6_MockUse(this);
		assertEquals(1, methodsCalled);
	}

	@Override
	public void afterTrialTests(I_SourceFileTrialResult p) {
		super.afterTrialTests(p);
		I_ClassAttributes refs = p.getSourceClassAttributes();
		if (refs == null) {
			return;
		}
		I_ClassAttributes example = GWT_2_6_Lang.getRunnable();
		assertNotNull(refs);
		assertEquals(Runnable_2_6_MockUse.class.getName(), refs.getName());
		
		refs = p.getAttributes(Runnable.class.getName());
		
		assertEquals(example.getName(), refs.getName());
		Set<I_FieldSignature> exampleFields = example.getFields();
		Set<I_FieldSignature> fields = refs.getFields();
		for (I_FieldSignature sig: exampleFields) {
			assertContains(fields, sig);
		}
		assertEquals(exampleFields.size(), fields.size());
		Set<I_MethodSignature> exampleMethods = example.getMethods();
		Set<I_MethodSignature> methods = refs.getMethods();
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
		int thisAfterAsserts = 8;
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
		int thisAfterUniqueAsserts = 8;
		if (type.isFromMetaWithCoverage()) {
			//code coverage and circular dependencies +
			//custom afterTrialTests
			return super.getUniqueAsserts(type, thisUniqueAsserts + thisAfterUniqueAsserts);
		} else {
			return super.getUniqueAsserts(type, thisUniqueAsserts);
		}
	}
}