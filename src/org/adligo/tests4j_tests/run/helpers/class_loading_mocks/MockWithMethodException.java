package org.adligo.tests4j_tests.run.helpers.class_loading_mocks;


public class MockWithMethodException {

	public MockWithNothing getTrial() throws MockException {
		throw new MockException();
	}
}
