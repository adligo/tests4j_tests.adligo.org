package org.adligo.tests4j_tests.run.helpers.class_loading_mocks;

import org.adligo.tests4j.models.shared.system.I_Tests4J_System;


public class MockWithImportOnlyInMethod {

	public void foo() {
		@SuppressWarnings("unused")
		I_Tests4J_System sys = null;
	}
}
