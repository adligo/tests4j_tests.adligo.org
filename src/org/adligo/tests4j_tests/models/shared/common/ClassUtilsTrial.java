package org.adligo.tests4j_tests.models.shared.common;

import org.adligo.tests4j.models.shared.common.ClassUtils;
import org.adligo.tests4j.models.shared.coverage.I_SourceFileCoverage;
import org.adligo.tests4j.models.shared.results.I_SourceFileTrialResult;
import org.adligo.tests4j.models.shared.trials.SourceFileScope;
import org.adligo.tests4j.models.shared.trials.SourceFileTrial;
import org.adligo.tests4j.models.shared.trials.Test;
import org.adligo.tests4j_tests.models.shared.common.mocks.BaseMockClass;
import org.adligo.tests4j_tests.models.shared.common.mocks.ChildMockClass;

@SourceFileScope (sourceClass=ClassUtils.class)
public class ClassUtilsTrial extends SourceFileTrial {

	@Test
	public void testMethods() {
		assertTrue(ClassUtils.isSubType(ChildMockClass.class, BaseMockClass.class));
		assertFalse(ClassUtils.isSubType(BaseMockClass.class, ChildMockClass.class));
	}

	@Override
	public void afterTrialTests(I_SourceFileTrialResult p) {
		assertEquals(1, p.getTestCount());
		assertGreaterThanOrEquals(2.0, p.getAssertionCount());
		assertGreaterThanOrEquals(2.0, p.getUniqueAssertionCount());
		
		if (p.hasRecordedCoverage()) {
			I_SourceFileCoverage coverage = p.getSourceFileCoverage();
			assertGreaterThanOrEquals(89.0, coverage.getPercentageCoveredDouble());
		}
	}
	
}
