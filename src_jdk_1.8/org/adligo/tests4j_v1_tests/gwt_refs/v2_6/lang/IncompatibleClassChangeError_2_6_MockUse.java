package org.adligo.tests4j_v1_tests.gwt_refs.v2_6.lang;

import java.lang.IndexOutOfBoundsException;

/** autogenerated by org.adligo.tests4j.gen.dependency_groups.ClassUseGen*/
public class IncompatibleClassChangeError_2_6_MockUse {

	public IncompatibleClassChangeError obj = null;
	public IncompatibleClassChangeError_2_6_MockUse() {
	  obj = new IncompatibleClassChangeError();
		obj = new IncompatibleClassChangeError(
			"string");
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
		obj = new IncompatibleClassChangeError();
		obj.initCause(new Throwable("hmm"));
		obj = new IncompatibleClassChangeError();
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