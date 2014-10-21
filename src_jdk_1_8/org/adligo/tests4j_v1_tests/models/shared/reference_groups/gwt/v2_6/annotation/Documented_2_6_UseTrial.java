package org.adligo.tests4j_v1_tests.models.shared.reference_groups.gwt.v2_6.annotation;

import java.util.Set;

import org.adligo.tests4j.models.shared.association.I_ClassAssociations;
import org.adligo.tests4j.models.shared.results.I_SourceFileTrialResult;
import org.adligo.tests4j.shared.asserts.reference.I_ClassAttributes;
import org.adligo.tests4j.system.shared.trials.SourceFileScope;
import org.adligo.tests4j.system.shared.trials.Test;
import org.adligo.tests4j_tests.base_trials.I_CountType;
import org.adligo.tests4j_tests.base_trials.SourceFileCountingTrial;

@SourceFileScope (sourceClass=Documented_2_6_MockUse.class)
public class Documented_2_6_UseTrial extends SourceFileCountingTrial {

	private int methodsCalled = 0;


	@Test
	public void testMethods() throws Exception {
		new Documented_2_6_MockUse();
		assertEquals(0, methodsCalled);
	}


	@Override
	public void afterTrialTests(I_SourceFileTrialResult p) {
		super.afterTrialTests(p);
		I_ClassAttributes refs = p.getSourceClassAttributes();
		if (refs == null) {
			return;
		}
		assertEquals(Documented_2_6_MockUse.class.getName(), refs.getName());
		I_ClassAssociations deps =  p.getDependencies();
		Set<String> depNames = deps.getDependencyNames();
		assertContains(depNames,Documented_2_6_Annotation.class.getName());
		assertContains(depNames,"java.lang.annotation.Documented");
		
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
		int thisAfterAsserts = 5;
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
		int thisAfterUniqueAsserts = 5;
		if (type.isFromMetaWithCoverage()) {
			//code coverage and circular dependencies +
			//custom afterTrialTests
			return super.getUniqueAsserts(type, thisUniqueAsserts + thisAfterUniqueAsserts);
		} else {
			return super.getUniqueAsserts(type, thisUniqueAsserts);
		}
	}
}