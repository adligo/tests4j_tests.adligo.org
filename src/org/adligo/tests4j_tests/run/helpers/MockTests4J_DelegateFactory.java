package org.adligo.tests4j_tests.run.helpers;

import org.adligo.tests4j.models.shared.system.I_Tests4J_Delegate;
import org.adligo.tests4j.models.shared.system.I_Tests4J_DelegateFactory;

public class MockTests4J_DelegateFactory implements I_Tests4J_DelegateFactory {
	private final I_Tests4J_Delegate delegate;
	
	public MockTests4J_DelegateFactory(I_Tests4J_Delegate pDelegate) {
		delegate = pDelegate;
	}

	@Override
	public I_Tests4J_Delegate create() {
		return delegate;
	}
	
}
