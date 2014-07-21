package org.adligo.tests4j_tests.trials_api.common;

import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;

import org.adligo.tests4j.models.shared.system.I_System;


/**
 * a dummy/mock implementation of I_SystemExit
 * mostly for mocking, but can be used to derail
 * the System.exit(0); at the end of a Tests4j trial run.
 * @author scott
 *
 */
public class MockSystem implements I_System {
	private final ArrayBlockingQueue<Integer> lastStatus = new ArrayBlockingQueue<>(10);
	private final ArrayBlockingQueue<Long> times;
	
	
	public MockSystem() {
		times = new ArrayBlockingQueue<Long>(4);
		times.add(1L);
		times.add(2L);
		times.add(3L);
		times.add(4L);
	}
	
	public MockSystem(List<Long> pTimes) {
		times = new ArrayBlockingQueue<Long>(pTimes.size());
		times.addAll(pTimes);
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
		return times.poll();
	}

}
