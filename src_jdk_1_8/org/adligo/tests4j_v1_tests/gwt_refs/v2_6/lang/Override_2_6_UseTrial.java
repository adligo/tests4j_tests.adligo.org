package org.adligo.tests4j_v1_tests.gwt_refs.v2_6.lang;

import java.util.Set;

import org.adligo.tests4j.models.shared.association.I_ClassAssociations;
import org.adligo.tests4j.models.shared.results.I_SourceFileTrialResult;
import org.adligo.tests4j.shared.asserts.reference.I_ClassAttributes;
import org.adligo.tests4j.system.shared.trials.SourceFileScope;
import org.adligo.tests4j.system.shared.trials.Test;
import org.adligo.tests4j_tests.base_trials.I_CountType;
import org.adligo.tests4j_tests.base_trials.SourceFileCountingTrial;

@SourceFileScope (sourceClass=Override_2_6_MockUse.class)
public class Override_2_6_UseTrial extends SourceFileCountingTrial {


	@Test
	public void testMethods() throws Exception {
		Override_2_6_MockUse o = new Override_2_6_MockUse();
		assertEquals("Override_2_6_MockUse", o.toString());
	}


	@Override
	public void afterTrialTests(I_SourceFileTrialResult p) {
		super.afterTrialTests(p);
		I_ClassAttributes refs = p.getSourceClassAttributes();
		if (refs == null) {
			return;
		}
		assertEquals(Override_2_6_MockUse.class.getName(), refs.getName());
		I_ClassAssociations deps =  p.getDependencies();
		Set<String> depNames = deps.getDependencyNames();
		//the Override annotation is source retention,
		//so it is NOT available in the .class file
		assertFalse(depNames.contains("java.lang.Override"));
		
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
		int thisAfterAsserts = 4;
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
		int thisAfterUniqueAsserts = 4;
		if (type.isFromMetaWithCoverage()) {
			//code coverage and circular dependencies +
			//custom afterTrialTests
			return super.getUniqueAsserts(type, thisUniqueAsserts + thisAfterUniqueAsserts);
		} else {
			return super.getUniqueAsserts(type, thisUniqueAsserts);
		}
	}
}