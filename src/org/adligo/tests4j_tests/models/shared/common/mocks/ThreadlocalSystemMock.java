package org.adligo.tests4j_tests.models.shared.common.mocks;

import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

import org.adligo.tests4j.models.shared.common.DefaultSystem;
import org.adligo.tests4j.models.shared.common.DelegateSystem;
import org.adligo.tests4j.models.shared.common.I_System;
import org.adligo.tests4j.models.shared.common.Tests4J_System;

/**
 * this class allows a single trial to 
 * manipulate a thread local that backs 
 * Tests4J_System.SYSTEM so that only the trial's
 * threads (and test thread) can see the system set with 
 * setSystem(I_System);
 * @author scott
 *
 */
public class ThreadlocalSystemMock extends DelegateSystem implements I_System {
	private InheritableThreadLocal<I_System> ith = new InheritableThreadLocal<>();
	private static final I_System DEFAULT = new DefaultSystem();
	private static final Set<String> callers = new CopyOnWriteArraySet<String>();
	private static final ThreadlocalSystemMock INSTANCE = new ThreadlocalSystemMock();
	
	ThreadlocalSystemMock() {
		super.setDelegate(this);
	}
	
	public static void setConstantToMock() {
		Exception x = new Exception();
		x.fillInStackTrace();
		StackTraceElement caller = x.getStackTrace()[1];
		String callerName = caller.getClassName();
		callers.add(callerName);
		
		if (INSTANCE != ((DelegateSystem) Tests4J_System.SYSTEM).getDelegate()) {
			((DelegateSystem) Tests4J_System.SYSTEM).setDelegate(INSTANCE);
		}
	}
	public static void markDone() {
		Exception x = new Exception();
		x.fillInStackTrace();
		StackTraceElement caller = x.getStackTrace()[1];
		String callerName = caller.getClassName();
		callers.remove(callerName);
		
		if (callers.isEmpty()) {
			((DelegateSystem) Tests4J_System.SYSTEM).setDelegate(DEFAULT);
		}
	}

	public static void setSystem(I_System p) {
		INSTANCE.ith.set(p);
	}
	
	private I_System getSystem() {
		I_System toRet = ith.get();
		if (toRet == null) {
			ith.set(new DefaultSystem());
			toRet = ith.get();
		}
		return toRet;
	}
	
	
	@Override
	public void println(String p) {
		getSystem().println(p);
	}

	@Override
	public void doSystemExit(int p) {
		getSystem().doSystemExit(p);
	}

	@Override
	public long getTime() {
		return getSystem().getTime();
	}

	@Override
	public String getLineSeperator() {
		return getSystem().getLineSeperator();
	}

}
