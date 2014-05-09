package org.adligo.tests4j_tests.jacoco.api_trials.mocks;

public class MockRunnable implements Runnable {
	private boolean a;
	private boolean b;
	int i = 0;
	int j = 0;
	
	public MockRunnable(boolean pa, boolean pb) {
		a = pa;
		b = pb;
	}
	public void run() {
		
		if (a) {
			i++;
			j++;
		}
		if (b) {
			i++;
			j++;
		}
		if (a && b) {
			i++;
			j++;
			i++;
			j++;
		}
	}
	public int getI() {
		return i;
	}
	public int getJ() {
		return j;
	}
	
	
}
