package org.adligo.tests4j_tests.run.mocks;

import org.adligo.tests4j.run.Tests4J;
import org.adligo.tests4j.shared.common.I_System;
import org.adligo.tests4j.shared.output.I_Tests4J_Log;
import org.adligo.tests4j.system.shared.I_Tests4J_Controls;
import org.adligo.tests4j.system.shared.I_Tests4J_DelegateFactory;
import org.adligo.tests4j.system.shared.I_Tests4J_Listener;
import org.adligo.tests4j.system.shared.I_Tests4J_Params;

public class MockTests4J extends Tests4J {

	public static synchronized void setFactory(I_Tests4J_DelegateFactory pFactory) {
		Tests4J.setFactory(pFactory);
	}
	
	public static synchronized I_Tests4J_DelegateFactory getFactory() {
		return Tests4J.getFactory();
	}

	public I_Tests4J_Controls instanceRunDelegate(I_Tests4J_Params pParams,
			I_Tests4J_Listener pListener) {
		// TODO Auto-generated method stub
		return super.instanceRun(pParams, pListener);
	}


	public I_System getSystemDelegate() {
		// TODO Auto-generated method stub
		return super.getSystem();
	}


	public void setSystemDelegate(I_System system) {
		// TODO Auto-generated method stub
		super.setSystem(system);
	}
}
