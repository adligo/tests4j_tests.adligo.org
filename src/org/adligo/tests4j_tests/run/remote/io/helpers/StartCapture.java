package org.adligo.tests4j_tests.run.remote.io.helpers;

public class StartCapture {
	private long start;
	private long capture;
	
	
	public StartCapture(long pStart, long pCapture) {
		start = pStart;
		capture = pCapture;
	}
	
	public long getStart() {
		return start;
	}
	public long getCapture() {
		return capture;
	}
}
