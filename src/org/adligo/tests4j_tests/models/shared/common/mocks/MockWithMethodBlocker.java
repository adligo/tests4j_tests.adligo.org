package org.adligo.tests4j_tests.models.shared.common.mocks;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.adligo.tests4j.models.shared.common.MethodBlocker;


public class MockWithMethodBlocker {

	public void doA() {
		List<String> allowedCallersClassNames = new ArrayList<String>();
		allowedCallersClassNames.add("org.adligo.tests4j_tests.models.shared.common.MethodBlockerTrial");
		new MethodBlocker(MockWithMethodBlocker.class, "doA", allowedCallersClassNames);
	}
	
	public void doB() {
		List<String> allowedCallersClassNames = new ArrayList<String>();
		allowedCallersClassNames.add("org.adligo.tests4j_tests.models.shared.common.mocks.MockWithMethodBlocker");
		new MethodBlocker(MockWithMethodBlocker.class, "doB", allowedCallersClassNames);
	}
	
	public void doC() {
		doB();
	}
	
	public void doD() {
		List<String> allowedCallersClassNames = new ArrayList<String>();
		allowedCallersClassNames.add("org.adligo.tests4j_tests.models.shared.common.MethodBlockerTrial");
		allowedCallersClassNames.add("org.adligo.tests4j_tests.models.shared.common.mocks.MockWithMethodBlocker");
		new MethodBlocker(MockWithMethodBlocker.class, "doD", allowedCallersClassNames);
	}
	
	public void doE() {
		doD();
	}
	
	/**
	 * This always throw the method block exception
	 * for method b as this method calls doD
	 * from something like MockWithMethodBlocker$1 which is 
	 * not a MockWithMethodBlocker
	 */
	public void doF() {
		Runnable r = new Runnable() {
			
			@Override
			public void run() {
				doD();
			}
		};
		r.run();
	}
	
}
