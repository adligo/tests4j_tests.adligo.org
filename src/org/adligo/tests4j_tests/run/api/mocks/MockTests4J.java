package org.adligo.tests4j_tests.run.api.mocks;

import org.adligo.tests4j.run.api.Tests4J;
import org.adligo.tests4j.run.common.I_JseSystem;
import org.adligo.tests4j.shared.common.I_System;
import org.adligo.tests4j.system.shared.api.I_Tests4J_Controls;
import org.adligo.tests4j.system.shared.api.I_Tests4J_DelegateFactory;
import org.adligo.tests4j.system.shared.api.I_Tests4J_Listener;
import org.adligo.tests4j.system.shared.api.I_Tests4J_Params;

public class MockTests4J extends Tests4J {

	public static synchronized void setFactory(I_Tests4J_DelegateFactory pFactory) {
		Tests4J.setFactory(pFactory);
	}
	
	public static synchronized I_Tests4J_DelegateFactory getFactory() {
		return Tests4J.getFactory();
	}

	public I_Tests4J_Controls instanceRunDelegate(I_Tests4J_Params params,
			I_Tests4J_Listener listener) {
	  super.setParams(params);
	  if (listener != null) {
	    super.setListener(listener);
	  }
		return super.instanceRun();
	}


	public I_System getSystemDelegate() {
		return super.getSystem();
	}


	public void setSystemDelegate(I_JseSystem system) {
		super.setSystem(system);
	}
}
