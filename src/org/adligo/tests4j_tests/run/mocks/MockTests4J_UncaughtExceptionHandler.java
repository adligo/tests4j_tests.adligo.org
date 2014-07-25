package org.adligo.tests4j_tests.run.mocks;

import org.adligo.tests4j.models.shared.system.I_Tests4J_Log;
import org.adligo.tests4j.run.Tests4J_UncaughtExceptionHandler;

public class MockTests4J_UncaughtExceptionHandler extends Tests4J_UncaughtExceptionHandler {

	public MockTests4J_UncaughtExceptionHandler() {
		super();
	}
	
	public static void setStaticLogger(I_Tests4J_Log logger) {
		Tests4J_UncaughtExceptionHandler.setLogger(logger);
	}
	
	public static I_Tests4J_Log getStaticLogger() {
		return Tests4J_UncaughtExceptionHandler.getLogger();
	}
}
