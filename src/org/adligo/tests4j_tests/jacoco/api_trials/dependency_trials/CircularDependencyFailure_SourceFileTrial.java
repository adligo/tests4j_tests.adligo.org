package org.adligo.tests4j_tests.jacoco.api_trials.dependency_trials;

import org.adligo.tests4j.models.shared.trials.SourceFileScope;
import org.adligo.tests4j.models.shared.trials.SourceFileTrial;
import org.adligo.tests4j.models.shared.trials.Test;
import org.adligo.tests4j.models.shared.trials.TrialRecursion;
import org.adligo.tests4j_tests.run.helpers.class_loading_mocks.MockWithTriangleA;

@SourceFileScope (sourceClass=MockWithTriangleA.class)//not no cirucular dependency type setting
@TrialRecursion
public class CircularDependencyFailure_SourceFileTrial extends SourceFileTrial {
	public static final String TEST_METHOD_NAME = "test";
	
	public MockWithTriangleA bm_;
	
	@Test
	public void test() {
		bm_ = new MockWithTriangleA();
		assertNotNull(bm_);
	}
}
