package org.adligo.tests4j_tests.shared.common;

import org.adligo.tests4j.shared.asserts.reference.AllowedReferences;
import org.adligo.tests4j.shared.common.DelegateSystem;
import org.adligo.tests4j.system.shared.trials.SourceFileScope;
import org.adligo.tests4j_tests.base_trials.I_CountType;
import org.adligo.tests4j_tests.base_trials.SourceFileCountingTrial;
import org.adligo.tests4j_tests.references_groups.Tests4J_Common_ReferenceGroup;

@SourceFileScope (sourceClass=DelegateSystem.class, minCoverage=0)
@AllowedReferences (groups=Tests4J_Common_ReferenceGroup.class)
public class DelegateSystemTrial extends SourceFileCountingTrial {

	@Override
	public int getTests(I_CountType type) {
		return super.getTests(type, 0, true);
	}


	@Override
	public int getAsserts(I_CountType type) {
		if (type.isFromMetaWithCoverage()) {
			//code coverage and circular dependencies
			return super.getAsserts(type,3);
		} else {
			return super.getAsserts(type, 0);
		}
	}

	@Override
	public int getUniqueAsserts(I_CountType type) {
		if (type.isFromMetaWithCoverage()) {
			return super.getUniqueAsserts(type, 3);
		} else {
			return super.getUniqueAsserts(type, 0);
		}
	}

}
