package org.adligo.tests4j_tests.models.shared.common;

import org.adligo.tests4j.models.dependency_groups.adligo.AdligoGWT_DependencyGroup;
import org.adligo.tests4j.models.dependency_groups.adligo.Tests4J_Common_DependencyGroup;
import org.adligo.tests4j.models.shared.common.I_TrialType;
import org.adligo.tests4j.models.shared.trials.AllowedDependencies;
import org.adligo.tests4j.models.shared.trials.SourceFileScope;
import org.adligo.tests4j_tests.base_trials.I_CountType;
import org.adligo.tests4j_tests.base_trials.SourceFileCountingTrial;

@SourceFileScope (sourceClass=I_TrialType.class, minCoverage=0)
@AllowedDependencies (groups={
		AdligoGWT_DependencyGroup.class, 
		Tests4J_Common_DependencyGroup.class})
public class I_TrialTypeTrial extends SourceFileCountingTrial {

	@Override
	public int getTests(I_CountType type) {
		return super.getTests(type, 0);
	}


	@Override
	public int getAsserts(I_CountType type) {
		if (type.isFromMetaWithCoverage()) {
			//code coverage and circular dependencies
			return super.getAsserts(type,2);
		} else {
			return super.getAsserts(type, 0);
		}
	}

	@Override
	public int getUniqueAsserts(I_CountType type) {
		if (type.isFromMetaWithCoverage()) {
			return super.getUniqueAsserts(type, 2);
		} else {
			return super.getUniqueAsserts(type, 0);
		}
	}

}
