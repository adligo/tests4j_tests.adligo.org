package org.adligo.tests4j_tests.models.shared.common;

import org.adligo.tests4j.models.shared.common.TrialType;
import org.adligo.tests4j.models.shared.trials.SourceFileScope;
import org.adligo.tests4j.models.shared.trials.Test;
import org.adligo.tests4j_tests.base_trials.SourceFileCountingTrial;

@SourceFileScope (sourceClass=TrialType.class, minCoverage=95.0)
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
	public int getTests() {
		return 1;
	}

	@Override
	public int getAsserts() {
		return 13;
	}

	@Override
	public int getUniqueAsserts() {
		return 13;
	}
}
