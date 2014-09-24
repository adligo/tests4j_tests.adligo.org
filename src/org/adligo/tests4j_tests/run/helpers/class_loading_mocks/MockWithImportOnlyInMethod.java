package org.adligo.tests4j_tests.run.helpers.class_loading_mocks;

import org.adligo.tests4j.shared.common.I_System;


public class MockWithImportOnlyInMethod {

	public void foo() {
		@SuppressWarnings("unused")
		I_System sys = null;
	}
}
