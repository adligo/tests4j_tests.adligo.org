package org.adligo.tests4j_tests.models.shared.common;

import org.adligo.tests4j.models.shared.common.ClassUtils;
import org.adligo.tests4j.models.shared.coverage.I_SourceFileCoverage;
import org.adligo.tests4j.models.shared.results.I_SourceFileTrialResult;
import org.adligo.tests4j.models.shared.trials.SourceFileScope;
import org.adligo.tests4j.models.shared.trials.SourceFileTrial;
import org.adligo.tests4j.models.shared.trials.Test;
import org.adligo.tests4j_tests.base_abstract_trials.SourceFileCountingTrial;
import org.adligo.tests4j_tests.models.shared.common.mocks.BaseMockClass;
import org.adligo.tests4j_tests.models.shared.common.mocks.ChildMockClass;

@SourceFileScope (sourceClass=ClassUtils.class, minCoverage=89.0)
public class ClassUtilsTrial extends SourceFileCountingTrial {

	@Test
	public void testMethods() {
		assertTrue(ClassUtils.isSubType(ChildMockClass.class, BaseMockClass.class));
		assertFalse(ClassUtils.isSubType(BaseMockClass.class, ChildMockClass.class));
	}

	@Override
	public int getTests() {
		return 1;
	}

	@Override
	public int getAsserts() {
		return 2;
	}

	@Override
	public int getUniqueAsserts() {
		return 2;
	}
	
}
