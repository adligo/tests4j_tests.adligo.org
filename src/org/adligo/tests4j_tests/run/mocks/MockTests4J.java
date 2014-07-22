package org.adligo.tests4j_tests.run.mocks;

import org.adligo.tests4j.models.shared.system.I_Tests4J_System;
import org.adligo.tests4j.models.shared.system.I_Tests4J_Controls;
import org.adligo.tests4j.models.shared.system.I_Tests4J_DelegateFactory;
import org.adligo.tests4j.models.shared.system.I_Tests4J_Logger;
import org.adligo.tests4j.models.shared.system.I_Tests4J_Params;
import org.adligo.tests4j.models.shared.system.I_Tests4J_Listener;
import org.adligo.tests4j.run.Tests4J;

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

	public I_Tests4J_Logger getLoggerDelegate() {
		// TODO Auto-generated method stub
		return super.getLogger();
	}

	public I_Tests4J_System getSystemDelegate() {
		// TODO Auto-generated method stub
		return super.getSystem();
	}

	public void setLoggerDelegate(I_Tests4J_Logger logger) {
		// TODO Auto-generated method stub
		super.setLogger(logger);
	}

	public void setSystemDelegate(I_Tests4J_System system) {
		// TODO Auto-generated method stub
		super.setSystem(system);
	}
}
