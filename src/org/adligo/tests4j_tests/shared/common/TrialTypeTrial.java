package org.adligo.tests4j_tests.shared.common;

import org.adligo.tests4j.shared.asserts.reference.AllowedReferences;
import org.adligo.tests4j.shared.common.TrialType;
import org.adligo.tests4j.system.shared.trials.SourceFileScope;
import org.adligo.tests4j.system.shared.trials.Test;
import org.adligo.tests4j_tests.base_trials.I_CountType;
import org.adligo.tests4j_tests.base_trials.SourceFileCountingTrial;
import org.adligo.tests4j_tests.references_groups.Tests4J_Common_ReferenceGroup;

@SourceFileScope (sourceClass=TrialType.class, minCoverage=94.0)
@AllowedReferences (groups=Tests4J_Common_ReferenceGroup.class)
public class TrialTypeTrial extends SourceFileCountingTrial {

	@Test
	public void testMethods() {
		assertEquals(5, TrialType.values().length);
		
		assertEquals("ApiTrial",  TrialType.ApiTrial.toString());
		assertEquals("MetaTrial",  TrialType.MetaTrial.toString());
		assertEquals("SourceFileTrial",  TrialType.SourceFileTrial.toString());
		assertEquals("UseCaseTrial",  TrialType.UseCaseTrial.toString());
		
		assertSame(TrialType.ApiTrial, TrialType.get(TrialType.ApiTrial.getId()));
		assertSame(TrialType.MetaTrial, TrialType.get(TrialType.MetaTrial.getId()));
		assertSame(TrialType.SourceFileTrial, TrialType.get(TrialType.SourceFileTrial.getId()));
		assertSame(TrialType.UseCaseTrial, TrialType.get(TrialType.UseCaseTrial.getId()));
		
		
		assertSame(TrialType.API_TRIAL_TYPE, TrialType.ApiTrial.getId());
		assertSame(TrialType.META_TRIAL_TYPE, TrialType.MetaTrial.getId());
		assertSame(TrialType.SOURCE_FILE_TRIAL_TYPE, TrialType.SourceFileTrial.getId());
		assertSame(TrialType.USE_CASE_TRIAL_TYPE, TrialType.UseCaseTrial.getId());
	}
	
	@Override
	public int getTests(I_CountType type) {
		return super.getTests(type, 1, true);
	}

	@Override
	public int getAsserts(I_CountType type) {
		if (type.isFromMetaWithCoverage()) {
			//code coverage and circular dependencies
			return super.getAsserts(type, 16);
		} else {
			return super.getAsserts(type, 13);
		}
	}

	@Override
	public int getUniqueAsserts(I_CountType type) {
		if (type.isFromMetaWithCoverage()) {
			return super.getUniqueAsserts(type, 16);
		} else {
			return super.getUniqueAsserts(type, 13);
		}
	}
}
