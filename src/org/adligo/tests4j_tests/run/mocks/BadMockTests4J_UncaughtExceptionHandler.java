package org.adligo.tests4j_tests.run.mocks;

import org.adligo.tests4j.models.shared.system.I_Tests4J_Logger;
import org.adligo.tests4j.run.Tests4J_UncaughtExceptionHandler;

public class BadMockTests4J_UncaughtExceptionHandler extends Tests4J_UncaughtExceptionHandler {

	public BadMockTests4J_UncaughtExceptionHandler() {
		super();
	}
	
	public static void setStaticLogger(I_Tests4J_Logger logger) {
		Tests4J_UncaughtExceptionHandler.setLogger(logger);
	}
}
