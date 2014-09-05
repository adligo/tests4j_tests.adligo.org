package org.adligo.tests4j_tests.jacoco.plugin.data.inst;

import org.adligo.tests4j.models.shared.system.I_Tests4J_CoverageTrialInstrumentation;
import org.adligo.tests4j.models.shared.trials.SourceFileScope;
import org.adligo.tests4j.models.shared.trials.Test;
import org.adligo.tests4j_4jacoco.plugin.instrumentation.TrialInstrumenter;
import org.adligo.tests4j_4jacoco.plugin.instrumentation.TrialInstrumenterSharedMemory;
import org.adligo.tests4j_tests.base_trials.I_CountType;
import org.adligo.tests4j_tests.base_trials.SourceFileCountingTrial;
import org.adligo.tests4j_tests.models.shared.system.mocks.Tests4J_LogMock;
import org.adligo.tests4j_tests.run.helpers.mock_trials.MockWithNothingTrial;

@SourceFileScope (sourceClass=TrialInstrumenter.class, minCoverage=1.0)
public class TrialInstrumenterTrial extends SourceFileCountingTrial {
	private static final Tests4J_LogMock log = new Tests4J_LogMock();
	private Tests4J_LogMock logMock_ = new Tests4J_LogMock();
	
	@Test
	public void testGetAllPackages() throws Exception {
		TrialInstrumenterSharedMemory tism = new TrialInstrumenterSharedMemory();
		TrialInstrumenter ti = new TrialInstrumenter(tism);
		
		ti.setLog(log);
		assertSame(log, ti.getLog());
		/*
		I_Tests4J_CoverageTrialInstrumentation cti =
				ti.instrument(MockWithNothingTrial.class);
				*/
	}
	
	
	@Override
	public int getTests(I_CountType type) {
		return super.getTests(type, 1);
	}

	@Override
	public int getAsserts(I_CountType type) {
		int thisAsserts = 1;
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
		int thisUniqueAsserts = 1;
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
