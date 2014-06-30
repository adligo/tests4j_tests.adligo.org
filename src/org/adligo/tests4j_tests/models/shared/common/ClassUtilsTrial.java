package org.adligo.tests4j_tests.models.shared.common;

import org.adligo.tests4j.models.shared.common.ClassUtils;
import org.adligo.tests4j.models.shared.coverage.I_SourceFileCoverage;
import org.adligo.tests4j.models.shared.results.feedback.I_SourceFileTrial_TestsResults;
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
	public void afterTrialTests(I_SourceFileTrial_TestsResults p) {
		assertGreaterThanOrEquals(2.0, p.getAssertions());
		assertGreaterThanOrEquals(2.0, p.getUniqueAssertions());
		
		if (p.hasRecordedCoverage()) {
			I_SourceFileCoverage coverage = p.getCoverage();
			assertGreaterThanOrEquals(100.0, coverage.getPercentageCoveredDouble());
		}
	}
	
}
