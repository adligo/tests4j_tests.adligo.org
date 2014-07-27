package org.adligo.tests4j_tests.run.discovery.package_discovery_inner_mocks;

public class TwoNestedRunnables {

	public Runnable run() {
		Runnable r = new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				
			}
		};
		Runnable x = new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				
			}
		};
		return x;
	}
}
