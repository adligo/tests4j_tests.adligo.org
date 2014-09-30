package org.adligo.tests4j_tests.run.api.mocks;

import org.adligo.tests4j.run.api.Tests4J_UncaughtExceptionHandler;
import org.adligo.tests4j.shared.output.I_Tests4J_Log;

public class MockTests4J_UncaughtExceptionHandler extends Tests4J_UncaughtExceptionHandler {

	public MockTests4J_UncaughtExceptionHandler() {
		super();
	}
	
	public static void setStaticLogger(I_Tests4J_Log logger) {
		Tests4J_UncaughtExceptionHandler.setLog(logger);
	}
	
	public static I_Tests4J_Log getStaticLogger() {
		return Tests4J_UncaughtExceptionHandler.getLog();
	}
}
