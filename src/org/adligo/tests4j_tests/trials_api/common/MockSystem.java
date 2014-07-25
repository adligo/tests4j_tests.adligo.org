package org.adligo.tests4j_tests.trials_api.common;

import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.atomic.AtomicLong;

import org.adligo.tests4j.models.shared.system.I_Tests4J_System;


/**
 * a dummy/mock implementation of I_SystemExit
 * mostly for mocking, but can be used to derail
 * the System.exit(0); at the end of a Tests4j trial run.
 * @author scott
 *
 */
public class MockSystem implements I_Tests4J_System {
	private final ArrayBlockingQueue<Integer> lastStatus = new ArrayBlockingQueue<>(10);
	private final AtomicLong time = new AtomicLong();
	
	
	public MockSystem() {

	}
	
	public MockSystem(List<Long> pTimes) {
	}
	
	@Override
	public void doSystemExit(final int p) {
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

}
