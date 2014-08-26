package org.adligo.tests4j_tests.run.helpers.class_loading_mocks;

public class MockWithCallToArithmeticException_StringConstructor {
	public ArithmeticException x;
	
	public MockWithCallToArithmeticException_StringConstructor() {
		x = new ArithmeticException();
	}
}
