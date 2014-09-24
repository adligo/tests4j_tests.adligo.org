package org.adligo.tests4j_tests.shared.common.mocks;

public class MockExceptionWithNullStackTrace extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public StackTraceElement[] getStackTrace() {
		return null;
	}

}
