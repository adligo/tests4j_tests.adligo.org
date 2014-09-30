package org.adligo.tests4j_tests.run.helpers;

import org.adligo.tests4j.shared.common.I_System;
import org.adligo.tests4j.system.shared.api.I_Tests4J_Delegate;
import org.adligo.tests4j.system.shared.api.I_Tests4J_DelegateFactory;

public class MockTests4J_DelegateFactory implements I_Tests4J_DelegateFactory {
	private final I_Tests4J_Delegate delegate;
	private I_System lastSystem;
	
	public MockTests4J_DelegateFactory(I_Tests4J_Delegate pDelegate) {
		delegate = pDelegate;
	}

	@Override
	public I_Tests4J_Delegate create(I_System system) {
		lastSystem = system;
		return delegate;
	}

	public I_System getLastSystem() {
		return lastSystem;
	}
	
	public void clear() {
		lastSystem = null;
	}
}
