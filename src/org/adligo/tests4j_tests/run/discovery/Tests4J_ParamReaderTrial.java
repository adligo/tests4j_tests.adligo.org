package org.adligo.tests4j_tests.run.discovery;

import org.adligo.tests4j.models.shared.asserts.common.ExpectedThrownData;
import org.adligo.tests4j.models.shared.asserts.common.I_Thrower;
import org.adligo.tests4j.models.shared.system.Tests4J_Params;
import org.adligo.tests4j.models.shared.system.Tests4J_Selection;
import org.adligo.tests4j.models.shared.trials.SourceFileScope;
import org.adligo.tests4j.models.shared.trials.Test;
import org.adligo.tests4j.run.discovery.Tests4J_ParamsReader;
import org.adligo.tests4j_tests.base_abstract_trials.SourceFileCountingTrial;
import org.adligo.tests4j_tests.run.helpers.mock_trials.MockWithArrayTrial;
import org.adligo.tests4j_tests.run.helpers.mock_trials.MockWithNothingTrial;
import org.adligo.tests4j_tests.trials_api.common.MockSystem;

@SourceFileScope (sourceClass=Tests4J_ParamsReader.class, minCoverage=20.0)
public class Tests4J_ParamReaderTrial extends SourceFileCountingTrial {
	private MockSystem ms = new MockSystem("\n");
	

	@Test
	public void testTestsTrialMismatch() {
		Tests4J_Params params = new Tests4J_Params();
		params.addTrial(MockWithNothingTrial.class);
		
		Tests4J_Selection sel = new Tests4J_Selection(MockWithArrayTrial.class, "testMockWithArray");
		params.addTest(sel);
		
		Tests4J_ParamsReader t4jpr = new Tests4J_ParamsReader(ms, params);
		assertFalse(t4jpr.isRunnable());
		Throwable runFailed = t4jpr.getRunFalseReason();
		assertNotNull(runFailed);
		assertUniform("Test seletions passed to tests4j MUST have a corresponding trial.\n" +
				"class org.adligo.tests4j_tests.run.helpers.mock_trials.MockWithArrayTrial", runFailed.getMessage());
	}
	
	@Override
	public int getTests() {
		return 1;
	}

	@Override
	public int getAsserts() {
		return 3;
	}

	@Override
	public int getUniqueAsserts() {
		return 3;
	}
}
