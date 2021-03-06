package org.adligo.tests4j_v1_tests.gwt_refs.v2_6.lang;


import java.util.Set;

import org.adligo.gwt_refs.v2_6.GWT_2_6_Lang;
import org.adligo.tests4j.models.shared.association.I_ClassAssociations;
import org.adligo.tests4j.models.shared.results.I_SourceFileTrialResult;
import org.adligo.tests4j.shared.asserts.reference.I_ClassAttributes;
import org.adligo.tests4j.shared.asserts.reference.I_FieldSignature;
import org.adligo.tests4j.shared.asserts.reference.I_MethodSignature;
import org.adligo.tests4j.system.shared.trials.SourceFileScope;
import org.adligo.tests4j.system.shared.trials.Test;
import org.adligo.tests4j_tests.base_trials.I_CountType;
import org.adligo.tests4j_tests.base_trials.SourceFileCountingTrial;

@SourceFileScope (sourceClass=Appendable_2_6_MockUse.class)
public class Appendable_2_6_UseTrial extends SourceFileCountingTrial 
  implements Appendable {

	private int methodsCalled = 0;

	public Appendable append(char p0) {
		methodsCalled++;
		return this;
	}
	public Appendable append(java.lang.CharSequence p0, int p1, int p2) {
		methodsCalled++;
		return this;
	}
	public Appendable append(java.lang.CharSequence p0) {
		methodsCalled++;
		return this;
	}

	@Test
	public void testMethods() throws Throwable {
		new Appendable_2_6_MockUse(this);
		assertEquals(3, methodsCalled);
	}

	@Override
	public void afterTrialTests(I_SourceFileTrialResult p) {
		super.afterTrialTests(p);
		I_ClassAssociations cRefs = p.getDependencies();
		if (cRefs == null) {
			return;
		}
		I_ClassAttributes ca = p.getSourceClassAttributes();
		
		assertNotNull(ca);
		assertEquals(Appendable_2_6_MockUse.class.getName(), ca.getName());
		
		I_ClassAttributes example = GWT_2_6_Lang.getAppendable();
		ca = p.getReferences(Appendable.class.getName());
		assertEquals(example.getName(), ca.getName());
		
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
	public int getTests(I_CountType type) {
		return super.getTests(type, 1);
	}

	@Override
	public int getAsserts(I_CountType type) {
		int thisAsserts = 1;
		//code coverage and circular dependencies +
		//custom afterTrialTests
		//+ see above
		int thisAfterAsserts = 10;
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
		int thisAfterUniqueAsserts = 10;
		if (type.isFromMetaWithCoverage()) {
			//code coverage and circular dependencies +
			//custom afterTrialTests
			return super.getUniqueAsserts(type, thisUniqueAsserts + thisAfterUniqueAsserts);
		} else {
			return super.getUniqueAsserts(type, thisUniqueAsserts);
		}
	}
}