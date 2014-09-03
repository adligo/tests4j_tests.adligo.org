package org.adligo.tests4j_tests.trials_api.common;

import java.io.PrintStream;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.atomic.AtomicLong;

import org.adligo.tests4j.models.shared.common.DefaultSystem;
import org.adligo.tests4j.models.shared.common.I_System;


/**
 * a dummy/mock implementation of I_SystemExit
 * mostly for mocking, but can be used to derail
 * the System.exit(0); at the end of a Tests4j trial run.
 * @author scott
 *
 */
public class SystemRunnerMock implements I_System {
	private final ArrayBlockingQueue<Integer> lastStatus = new ArrayBlockingQueue<>(10);
	private final AtomicLong time = new AtomicLong();
	private String lineSeperator;
	
	public SystemRunnerMock() {

	}
	
	public SystemRunnerMock(String pLineSepearator) {
		lineSeperator = pLineSepearator;
	}
	
	public SystemRunnerMock(List<Long> pTimes) {
	}
	
	@Override
	public void exitJvm(final int p) {
		synchronized (lastStatus) {
			lastStatus.add(p);
		}
		
	}

	public int getLastStatus() throws InterruptedException {
		return lastStatus.take();
	}

	@Override
	public void println(String p) {
		//print nothing
	}

	@Override
	public long getTime() {
		return System.currentTimeMillis();
	}

	@Override
	public String lineSeperator() {
		return lineSeperator;
	}

	@Override
	public String getCurrentThreadName() {
		return "SystemRunnerMock_" + DefaultSystem.DEFAULT_THREAD_NAME;
	}

	@Override
	public PrintStream getOut() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getJseVersion() {
		return "";
	}

}
