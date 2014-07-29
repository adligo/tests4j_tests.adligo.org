package org.adligo.tests4j_tests.run.helpers.class_loading_mocks;


public class MockWithMethodExceptionBlock {

	public void foo() {
		try {
			MockWithMethodException foo = new MockWithMethodException();
			foo.getTrial();
		} catch (MockException x) {
			//do nothing
		}
	}
}
