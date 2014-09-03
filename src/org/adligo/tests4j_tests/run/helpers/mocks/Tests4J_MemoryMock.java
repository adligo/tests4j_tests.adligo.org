package org.adligo.tests4j_tests.run.helpers.mocks;

import org.adligo.tests4j.models.shared.asserts.uniform.I_EvaluatorLookup;
import org.adligo.tests4j.models.shared.results.I_TrialResult;
import org.adligo.tests4j.models.shared.system.I_Tests4J_CoveragePlugin;
import org.adligo.tests4j.run.helpers.I_Tests4J_Memory;
import org.adligo.tests4j.shared.output.I_Tests4J_Log;
import org.adligo.tests4j_tests.models.shared.system.mocks.Tests4J_LogMock;

public class Tests4J_MemoryMock implements I_Tests4J_Memory {
	Tests4J_LogMock log = new Tests4J_LogMock();
	
	@Override
	public I_Tests4J_Log getLog() {
		return log;
	}

	@Override
	public I_EvaluatorLookup getEvaluationLookup() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean hasCoveragePlugin() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public I_Tests4J_CoveragePlugin getCoveragePlugin() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addResultBeforeMetadata(I_TrialResult p) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public I_TrialResult pollFailureResults() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getFailureResultsSize() {
		// TODO Auto-generated method stub
		return 0;
	}


}