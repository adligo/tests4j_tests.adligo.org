package org.adligo.tests4j_tests.jacoco.api_trials.dependency_trials;

import org.adligo.tests4j.models.shared.dependency_groups.gwt.GWT_DependencyGroup;
import org.adligo.tests4j.shared.asserts.dependency.AllowedDependencies;
import org.adligo.tests4j.system.shared.trials.SourceFileScope;
import org.adligo.tests4j.system.shared.trials.SourceFileTrial;
import org.adligo.tests4j.system.shared.trials.Test;
import org.adligo.tests4j.system.shared.trials.TrialRecursion;

@SourceFileScope (sourceClass=BadMethodCallMock.class)
@AllowedDependencies (groups=GWT_DependencyGroup.class)
@TrialRecursion
public class CalledBadMethod_SourceFileTrial extends SourceFileTrial {
	public static final String TEST_METHOD_NAME = "test";
	
	public BadMethodCallMock bm_;
	
	@Test
	public void test() {
		bm_ = new BadMethodCallMock();
		assertNotNull(bm_);
	}
}
