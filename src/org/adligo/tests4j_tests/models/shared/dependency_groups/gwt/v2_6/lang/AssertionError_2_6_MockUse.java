package org.adligo.tests4j_tests.models.shared.dependency_groups.gwt.v2_6.lang;

import java.lang.AssertionError;

/** autogenerated by org.adligo.tests4j.gen.dependency_groups.ClassUseGen*/
public class AssertionError_2_6_MockUse {

	public AssertionError obj = null;
	public AssertionError_2_6_MockUse() {
		obj = new AssertionError();
		obj = new AssertionError(
			true);
		obj = new AssertionError(
			'c');
		obj = new AssertionError(
			0.1);
		obj = new AssertionError(
				(float) 0.2);
		obj = new AssertionError(
			2);
		obj = new AssertionError(
			new Object());
		obj = new AssertionError(
			(long) 3);
		callObjectMethods();
		callThrowableMethods();
	}

	/**
	 * this needs to be generated each
	 * time so the instance getting methods called
	 * on it is the correct type.
	 */
	public void callObjectMethods() {
		obj.equals(null);
		obj.getClass();
		obj.hashCode();
		obj.toString();
	}
	/**
	 * this needs to be generated each
	 * time so the instance getting methods called
	 * on it is the correct type.
	 */
	public void callThrowableMethods() {
		obj = new AssertionError();
		obj.initCause(new AssertionError());
		obj.addSuppressed(new Throwable());
		
		obj.getStackTrace();
		obj.getSuppressed();
		obj.getLocalizedMessage();
		obj.getMessage();
		obj.toString();
		obj.fillInStackTrace();
		obj.getCause();
		
		obj.printStackTrace();
		obj.printStackTrace(System.out);
		obj.setStackTrace(new StackTraceElement[] {});
	}
}