package org.adligo.tests4j_tests.models.shared.dependency_groups.gwt.v2_6.lang;

import java.lang.Throwable;

/** autogenerated by org.adligo.tests4j.gen.dependency_groups.ClassUseGen*/
public class Throwable_2_6_MockUse {

	public Throwable obj = null;
	public Throwable_2_6_MockUse() {
		obj = new Throwable();
		obj = new Throwable(
			"string");
		obj = new Throwable(
			"string", new Throwable());
		obj = new Throwable(
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
		obj = new Throwable();
		obj.initCause(new Throwable("hmm"));
		obj = new Throwable();
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