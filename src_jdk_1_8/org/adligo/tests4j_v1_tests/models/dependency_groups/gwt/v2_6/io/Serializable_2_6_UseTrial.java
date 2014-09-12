package org.adligo.tests4j_v1_tests.models.dependency_groups.gwt.v2_6.io;

import java.io.Serializable;
import java.util.Set;
import java.util.TreeSet;

import org.adligo.tests4j.models.dependency_groups.gwt.GWT_2_6_IO;
import org.adligo.tests4j.models.shared.dependency.I_ClassAttributes;
import org.adligo.tests4j.models.shared.dependency.I_ClassDependencies;
import org.adligo.tests4j.models.shared.dependency.I_FieldSignature;
import org.adligo.tests4j.models.shared.dependency.I_MethodSignature;
import org.adligo.tests4j.models.shared.results.I_SourceFileTrialResult;
import org.adligo.tests4j.models.shared.trials.SourceFileScope;
import org.adligo.tests4j.models.shared.trials.Test;
import org.adligo.tests4j_tests.base_trials.I_CountType;
import org.adligo.tests4j_tests.base_trials.SourceFileCountingTrial;

@SourceFileScope (sourceClass=Serializable_2_6_MockUse.class)
public class Serializable_2_6_UseTrial extends SourceFileCountingTrial 
  implements Serializable {

	private int methodsCalled = 0;


	@Test
	public void testMethods() throws Exception {
		new Serializable_2_6_MockUse();
		assertEquals(0, methodsCalled);
	}

@Override
	public void afterTrialTests(I_SourceFileTrialResult p) {
		super.afterTrialTests(p);
		I_ClassAttributes refs = p.getSourceClassAttributes();
		if (refs == null) {
			return;
		}
		assertEquals(Serializable_2_6_MockUse.class.getName(), refs.getName());
		I_ClassDependencies deps =  p.getDependencies();
		Set<String> depNames = deps.getDependencyNames();
		assertContains(depNames, Serializable.class.getName());
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
		int uAsserts = 1;
		//code coverage and circular dependencies +
		//custom afterTrialTests
		//+ see above
		int uAfterAsserts = 4;
		if (type.isFromMetaWithCoverage()) {
			return super.getAsserts(type, uAsserts + uAfterAsserts);
		} else {
			return super.getAsserts(type, uAsserts);
		}
	}
}
