package org.adligo.tests4j_tests.trials_api.common;

import org.adligo.tests4j.models.shared.common.I_System;
import org.adligo.tests4j.models.shared.system.I_Tests4J_Controls;
import org.adligo.tests4j.models.shared.system.I_Tests4J_Log;
import org.adligo.tests4j.models.shared.system.I_Tests4J_Params;
import org.adligo.tests4j.models.shared.system.I_Tests4J_Listener;
import org.adligo.tests4j.run.Tests4J;

public class Tests4JRunnerMock extends Tests4J {

	protected Tests4JRunnerMock() {
		super();
	}

	protected void setSystem(I_System system) {
		super.setSystem(system);
	}
	
	protected I_Tests4J_Controls instanceRun(I_Tests4J_Params pParams, I_Tests4J_Listener pListener) {
		return super.instanceRun(pParams, pListener);
	}
}
