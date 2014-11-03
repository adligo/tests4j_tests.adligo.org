package org.adligo.tests4j_tests.run.helpers.class_loading_mocks;



public class MockWithImportOnlyInMethod {

	public void foo(Object p) {
	  I_FieldMock sys = (I_FieldMock) p;
	  sys.println("hey");
	}
}
