package org.adligo.tests4j_tests.run.common;

import org.adligo.tests4j.run.common.I_InitalValueFactory;
import org.adligo.tests4j.shared.asserts.reference.AllowedReferences;
import org.adligo.tests4j.system.shared.trials.SourceFileScope;
import org.adligo.tests4j_tests.base_trials.I_CountType;
import org.adligo.tests4j_tests.base_trials.SourceFileCountingTrial;
import org.adligo.tests4j_tests.references_groups.Tests4J_RunCommon_ReferenceGroup;

/**
 * @author scott
 *
 */
@SourceFileScope (sourceClass=I_InitalValueFactory.class)
@AllowedReferences (groups=Tests4J_RunCommon_ReferenceGroup.class)
public class I_InitialValueFactoryTrial extends SourceFileCountingTrial {

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
			return super.getUniqueAsserts(type,3);
		} else {
			return super.getUniqueAsserts(type, 0);
		}
	}

}
