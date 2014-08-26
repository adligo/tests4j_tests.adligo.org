package org.adligo.tests4j_tests.run.helpers.class_loading_mocks;

public class MockWithCallToArithmeticException_Constructor {
	public static final String GADZOOKS = "gadzooks";
	public ArithmeticException x;
	
	public MockWithCallToArithmeticException_Constructor() {
		x = new ArithmeticException(GADZOOKS);
	}
}
