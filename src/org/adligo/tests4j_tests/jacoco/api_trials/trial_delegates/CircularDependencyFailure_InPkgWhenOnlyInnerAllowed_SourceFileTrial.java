package org.adligo.tests4j_tests.jacoco.api_trials.trial_delegates;

import org.adligo.tests4j.shared.asserts.reference.CircularDependencies;
import org.adligo.tests4j.system.shared.trials.SourceFileScope;
import org.adligo.tests4j.system.shared.trials.SourceFileTrial;
import org.adligo.tests4j.system.shared.trials.Test;
import org.adligo.tests4j.system.shared.trials.TrialRecursion;
import org.adligo.tests4j_tests.run.helpers.class_loading_mocks.MockWithTriangleA;

@SourceFileScope (sourceClass=MockWithTriangleA.class,
	allowedCircularDependencies=CircularDependencies.AllowInnerOuterClasses)
	//note wrong cirucular dependency type setting
@TrialRecursion
public class CircularDependencyFailure_InPkgWhenOnlyInnerAllowed_SourceFileTrial extends SourceFileTrial {
	public static final String TEST_METHOD_NAME = "test";
	
	public MockWithTriangleA bm_;
	
	@Test
	public void test() {
		bm_ = new MockWithTriangleA();
		assertNotNull(bm_);
	}
}
