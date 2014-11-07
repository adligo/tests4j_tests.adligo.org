package org.adligo.tests4j_tests.trials_api.common;

import org.adligo.tests4j.run.api.Tests4J;
import org.adligo.tests4j.run.common.I_JseSystem;
import org.adligo.tests4j.system.shared.api.I_Tests4J_Controls;
import org.adligo.tests4j.system.shared.api.I_Tests4J_Listener;
import org.adligo.tests4j.system.shared.api.I_Tests4J_Params;

public class Tests4JRunnerMock extends Tests4J {

	protected Tests4JRunnerMock() {
		super();
	}

	protected  void setSystem(I_JseSystem system) {
	  super.setSystem(system);
	}
	
	protected I_Tests4J_Controls instanceRun(I_Tests4J_Params pParams, I_Tests4J_Listener pListener) {
		return super.instanceRun(pParams, pListener);
	}
	
}
