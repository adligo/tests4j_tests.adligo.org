package org.adligo.tests4j_tests.jacoco.plugin.data.inst;

import org.adligo.tests4j.shared.output.I_Tests4J_Log;
import org.adligo.tests4j.system.shared.trials.SourceFileScope;
import org.adligo.tests4j.system.shared.trials.Test;
import org.adligo.tests4j_4jacoco.plugin.common.I_CoveragePluginMemory;
import org.adligo.tests4j_4jacoco.plugin.instrumentation.ClassInstrumenterSharedMemory;
import org.adligo.tests4j_4jacoco.plugin.instrumentation.TrialInstrumenter;
import org.adligo.tests4j_tests.base_trials.I_CountType;
import org.adligo.tests4j_tests.base_trials.SourceFileCountingTrial;

@SourceFileScope (sourceClass=TrialInstrumenter.class, minCoverage=1.0)
public class TrialInstrumenterTrial extends SourceFileCountingTrial {
	
	@Test
	public void testGetAllPackages() throws Exception {
	  I_Tests4J_Log log = mock(I_Tests4J_Log.class);
		ClassInstrumenterSharedMemory tism = new ClassInstrumenterSharedMemory();
		I_CoveragePluginMemory memory = mock(I_CoveragePluginMemory.class);
		TrialInstrumenter ti = new TrialInstrumenter(tism, memory);
		
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
