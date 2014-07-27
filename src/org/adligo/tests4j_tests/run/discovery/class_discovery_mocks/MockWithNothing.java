package org.adligo.tests4j_tests.run.discovery.class_discovery_mocks;

import org.adligo.tests4j.models.shared.system.I_Tests4J_System;

/**
 * this class should only 
 * discover it depends on itself
 * @author scott
 *
 */
public class MockWithNothing {

	public void foo() {
		//it doesn't notice this, since it isn't a field, method attribute
		@SuppressWarnings("unused")
		I_Tests4J_System sys = null;
	}
}
