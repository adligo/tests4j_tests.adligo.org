package org.adligo.tests4j_tests.jacoco.api_trials.dependency_trials;

import org.adligo.tests4j.models.shared.dependency_groups.gwt.GWT_DependencyGroup;
import org.adligo.tests4j.models.shared.trials.AllowedDependencies;
import org.adligo.tests4j.models.shared.trials.SourceFileScope;
import org.adligo.tests4j.models.shared.trials.SourceFileTrial;
import org.adligo.tests4j.models.shared.trials.Test;

@SourceFileScope (sourceClass=BadMethod.class)
@AllowedDependencies (groups=GWT_DependencyGroup.class)
public class CalledBadMethod_SourceFileTrial extends SourceFileTrial {
	private BadMethod bm_;
	
	@Test
	public void test() {
		bm_ = new BadMethod();
	}
}
