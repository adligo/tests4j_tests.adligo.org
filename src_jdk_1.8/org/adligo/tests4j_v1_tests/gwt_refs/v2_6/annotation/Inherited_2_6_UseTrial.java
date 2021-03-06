package org.adligo.tests4j_v1_tests.gwt_refs.v2_6.annotation;

import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.util.Set;
import java.util.TreeSet;

import org.adligo.gwt_refs.v2_6.GWT_2_6_Annot;
import org.adligo.tests4j.models.shared.association.I_ClassAssociations;
import org.adligo.tests4j.models.shared.results.I_SourceFileTrialResult;
import org.adligo.tests4j.shared.asserts.reference.I_ClassAttributes;
import org.adligo.tests4j.shared.asserts.reference.I_FieldSignature;
import org.adligo.tests4j.shared.asserts.reference.I_MethodSignature;
import org.adligo.tests4j.system.shared.trials.SourceFileScope;
import org.adligo.tests4j.system.shared.trials.Test;
import org.adligo.tests4j_tests.base_trials.I_CountType;
import org.adligo.tests4j_tests.base_trials.SourceFileCountingTrial;
import org.adligo.tests4j_v1_tests.gwt_refs.v2_6.lang.Deprecated_2_6_MockUse;

@SourceFileScope (sourceClass=Inherited_2_6_MockUse.class)
public class Inherited_2_6_UseTrial extends SourceFileCountingTrial {

	private int methodsCalled = 0;


	@Test
	public void testMethods() throws Exception {
		Inherited_2_6_MockUse ihm = new Inherited_2_6_MockUse();
		assertEquals(0, methodsCalled);
	}

@Override
	public void afterTrialTests(I_SourceFileTrialResult p) {
		super.afterTrialTests(p);
		I_ClassAttributes refs = p.getSourceClassAttributes();
		if (refs == null) {
			return;
		}
		assertEquals(Inherited_2_6_MockUse.class.getName(), refs.getName());
		I_ClassAssociations deps =  p.getDependencies();
		Set<String> depNames = deps.getDependencyNames();
		assertContains(depNames,Object.class.getName());
		assertContains(depNames,Inherited_2_6_MockUse.class.getName());
		
		assertContains(depNames,Inherited_2_6_Annotation.class.getName());
		assertContains(depNames,Inherited.class.getName());
		assertContains(depNames,Retention.class.getName());
		assertEquals(10, depNames.size());
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
		int thisAfterAsserts = 9;
		if (type.isFromMetaWithCoverage()) {
			return super.getAsserts(type, thisAsserts + thisAfterAsserts);
		} else {
			return super.getAsserts(type, thisAsserts);
		}
	}

	@Override
	public int getUniqueAsserts(I_CountType type) {
		int uAsserts = 1;
		//code coverage and circular dependencies +
		//custom afterTrialTests
		//+ see above
		int uAfterAsserts = 9;
		if (type.isFromMetaWithCoverage()) {
			return super.getAsserts(type, uAsserts + uAfterAsserts);
		} else {
			return super.getAsserts(type, uAsserts);
		}
	}
}