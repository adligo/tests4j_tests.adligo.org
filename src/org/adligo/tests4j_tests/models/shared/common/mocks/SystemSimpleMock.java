package org.adligo.tests4j_tests.models.shared.common.mocks;

import org.adligo.tests4j.models.shared.common.I_System;

public class SystemSimpleMock implements I_System {
	private String lastPrintln;
	private int lastSystemExit;
	private long nextTime;
	private String nextLineSeperator;
	
	@Override
	public void println(String p) {
		lastPrintln = p;
	}

	@Override
	public void exitJvm(int p) {
		lastSystemExit = p;
	}

	@Override
	public long getTime() {
		return nextTime;
	}

	@Override
	public String getLineSeperator() {
		return nextLineSeperator;
	}

	public String getLastPrintln() {
		return lastPrintln;
	}

	public int getLastSystemExit() {
		return lastSystemExit;
	}

	public void setNextTime(long nextTime) {
		this.nextTime = nextTime;
	}

	public void setNextLineSeperator(String nextLineSeperator) {
		this.nextLineSeperator = nextLineSeperator;
	}

}
