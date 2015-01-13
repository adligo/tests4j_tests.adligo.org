package org.adligo.tests4j_tests.run.discovery;

import org.adligo.tests4j.run.discovery.Tests4J_ParamsReader;
import org.adligo.tests4j.shared.en.Tests4J_EnglishConstants;
import org.adligo.tests4j.shared.output.I_Tests4J_Log;
import org.adligo.tests4j.system.shared.api.Tests4J_Params;
import org.adligo.tests4j.system.shared.api.Tests4J_Selection;
import org.adligo.tests4j.system.shared.trials.SourceFileScope;
import org.adligo.tests4j.system.shared.trials.Test;
import org.adligo.tests4j_tests.base_trials.I_CountType;
import org.adligo.tests4j_tests.base_trials.SourceFileCountingTrial;
import org.adligo.tests4j_tests.run.helpers.mock_trials.MockWithArrayTrial;
import org.adligo.tests4j_tests.run.helpers.mock_trials.MockWithNothingTrial;
import org.adligo.tests4j_tests.trials_api.common.SystemRunnerMock;

@SourceFileScope (sourceClass=Tests4J_ParamsReader.class, minCoverage=20.0)
public class Tests4J_ParamReaderTrial extends SourceFileCountingTrial {
	private SystemRunnerMock ms = new SystemRunnerMock("\n");
	

	@Test
	public void testTestsTrialMismatch() {
		Tests4J_Params params = new Tests4J_Params();
		params.addTrial(MockWithNothingTrial.class);
		
		Tests4J_Selection sel = new Tests4J_Selection(MockWithArrayTrial.class, "testMockWithArray");
		params.addTest(sel);
		params.setConstants(Tests4J_EnglishConstants.ENGLISH);
		
		Tests4J_ParamsReader t4jpr = new Tests4J_ParamsReader(ms, params);
		I_Tests4J_Log logMock = mock(I_Tests4J_Log.class);
		when(logMock.getLineSeperator()).thenReturn("\n");
		t4jpr.read(logMock);
		assertFalse(t4jpr.isRunnable());
		Throwable runFailed = t4jpr.getRunFalseReason();
		assertNotNull(runFailed);
		assertUniform("Test seletions passed to tests4j MUST have a corresponding trial.\n" +
				"class org.adligo.tests4j_tests.run.helpers.mock_trials.MockWithArrayTrial", runFailed.getMessage());
	}
	@Override
	public int getTests(I_CountType type) {
		return super.getTests(type, 1);
	}

	@Override
	public int getAsserts(I_CountType type) {
		int thisAsserts = 3;
		//code coverage and circular dependencies +
		//custom afterTrialTests
		//+ see above
		int thisAfterAsserts = 2;
		if (type.isFromMetaWithCoverage()) {
			return super.getAsserts(type, thisAsserts + thisAfterAsserts);
		} else {
			return super.getAsserts(type, thisAsserts);
		}
	}

	@Override
	public int getUniqueAsserts(I_CountType type) {
		int thisUniqueAsserts = 3;
		//code coverage and circular dependencies +
		//custom afterTrialTests
		//+ see above
		int thisAfterUniqueAsserts = 2;
		if (type.isFromMetaWithCoverage()) {
			//code coverage and circular dependencies +
			//custom afterTrialTests
			return super.getUniqueAsserts(type, thisUniqueAsserts + thisAfterUniqueAsserts);
		} else {
			return super.getUniqueAsserts(type, thisUniqueAsserts);
		}
	}
}
