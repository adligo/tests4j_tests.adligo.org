package org.adligo.tests4j_v1_tests.gwt_refs.v2_6.util;

import java.util.ConcurrentModificationException;

/** autogenerated by org.adligo.tests4j.gen.dependency_groups.ClassUseGen*/
public class ConcurrentModificationException_2_6_MockUse {

	public ConcurrentModificationException obj = null;
	public ConcurrentModificationException_2_6_MockUse() {
		obj = new ConcurrentModificationException();
		obj = new ConcurrentModificationException(
			"string");
		obj = new ConcurrentModificationException(
			"string", new Throwable());
		obj = new ConcurrentModificationException(
			new Throwable());
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
		obj.getStackTrace();
		obj.getSuppressed();
		obj.getLocalizedMessage();
		obj.getMessage();
		obj.toString();
		obj.fillInStackTrace();
		obj.getCause();
		
		obj = new ConcurrentModificationException();
		obj.initCause(new Throwable());
		obj = new ConcurrentModificationException();
		obj.addSuppressed(new RuntimeException());
		obj.printStackTrace();
		obj.printStackTrace(System.out);
		obj.setStackTrace(new StackTraceElement[] {});
	}
}