package org.adligo.tests4j_v1_tests.models.shared.reference_groups.gwt.v2_6.logging;

import java.util.logging.LogManager;
import java.util.logging.Logger;

/** autogenerated by org.adligo.tests4j.gen.dependency_groups.ClassUseGen*/
public class LogManager_2_6_MockUse {

	public LogManager obj = LogManager.getLogManager();
	public java.lang.String obj0 = LogManager.LOGGING_MXBEAN_NAME;
	public LogManager_2_6_MockUse() {
		callLogManagerMethods();
		callObjectMethods();
	}

	@SuppressWarnings("static-access")
	public void callLogManagerMethods() {
		obj.addLogger(Logger.getLogger("hey"));
		obj.getLoggerNames();
		obj.getLogManager();
		obj.getLogger("string");
	}
	public void callObjectMethods() {
		obj.equals(new Object());
		obj.hashCode();
		obj.getClass();
		obj.toString();
	}
}