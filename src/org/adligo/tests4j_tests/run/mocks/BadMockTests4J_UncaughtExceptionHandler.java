package org.adligo.tests4j_tests.run.mocks;

import org.adligo.tests4j.run.Tests4J_UncaughtExceptionHandler;
import org.adligo.tests4j.shared.output.I_Tests4J_Log;

public class BadMockTests4J_UncaughtExceptionHandler extends Tests4J_UncaughtExceptionHandler {

	public BadMockTests4J_UncaughtExceptionHandler() {
		super();
	}
	
	public static void setStaticLogger(I_Tests4J_Log logger) {
		Tests4J_UncaughtExceptionHandler.setLog(logger);
	}
}
