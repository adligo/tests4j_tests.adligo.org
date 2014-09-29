package org.adligo.tests4j_tests.jacoco.plugin.data.coverage;

import java.util.Collections;
import java.util.List;

import org.adligo.tests4j.shared.i18n.I_Tests4J_Constants;
import org.adligo.tests4j.system.shared.trials.SourceFileScope;
import org.adligo.tests4j.system.shared.trials.Test;
import org.adligo.tests4j_4jacoco.plugin.data.coverage.LazyPackageCoverageFactory;
import org.adligo.tests4j_tests.base_trials.I_CountType;
import org.adligo.tests4j_tests.base_trials.SourceFileCountingTrial;

@SourceFileScope (sourceClass=LazyPackageCoverageFactory.class, minCoverage=13.0)
public class LazyPackageCoverageFactoryTrial extends SourceFileCountingTrial {

	@Test
	public void testGetClasses() {
		List<String> list = LazyPackageCoverageFactory.getClasses("org.adligo.tests4j.shared.i18n", 
				Collections.singleton(I_Tests4J_Constants.class.getName()));
		assertNotNull(list);
		assertContains(list, I_Tests4J_Constants.class.getName());
		assertEquals(1, list.size());
		
	}
	
	@Override
	public int getTests(I_CountType type) {
		return super.getTests(type, 1);
	}

	@Override
	public int getAsserts(I_CountType type) {
		int thisAsserts = 3;
		//code coverage and circular dependencies +
		//custom afterTrialTests
		//+ see above
		int thisAfterAsserts = 2;
		if (type.isFromMetaWithCoverage()) {
			return super.getAsserts(type, thisAsserts + thisAfterAsserts);
		} else {
			return super.getAsserts(type, thisAsserts);
		}
	}

	@Override
	public int getUniqueAsserts(I_CountType type) {
		int thisUniqueAsserts = 3;
		//code coverage and circular dependencies +
		//custom afterTrialTests
		//+ see above
		int thisAfterUniqueAsserts = 2;
		if (type.isFromMetaWithCoverage()) {
			//code coverage and circular dependencies +
			//custom afterTrialTests
			return super.getUniqueAsserts(type, thisUniqueAsserts + thisAfterUniqueAsserts);
		} else {
			return super.getUniqueAsserts(type, thisUniqueAsserts);
		}
	}
}
