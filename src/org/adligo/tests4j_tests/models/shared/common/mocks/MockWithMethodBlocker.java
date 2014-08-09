package org.adligo.tests4j_tests.models.shared.common.mocks;

import java.util.ArrayList;
import java.util.List;

import org.adligo.tests4j.models.shared.common.MethodBlocker;


public class MockWithMethodBlocker {
	private MethodBlocker aBlock = getABlock();
	private MethodBlocker bBlock = getBBlock();
	private MethodBlocker dBlock = getDBlock();
	
	public void doA() {
		aBlock.checkAllowed();
	}

	private MethodBlocker getABlock() {
		List<String> allowedCallersClassNames = new ArrayList<String>();
		allowedCallersClassNames.add("org.adligo.tests4j_tests.models.shared.common.MethodBlockerTrial");
		MethodBlocker mb = new MethodBlocker(MockWithMethodBlocker.class, "doA", allowedCallersClassNames);
		return mb;
	}
	
	public void doB() {
		bBlock.checkAllowed();
	}

	private MethodBlocker getBBlock() {
		List<String> allowedCallersClassNames = new ArrayList<String>();
		allowedCallersClassNames.add("org.adligo.tests4j_tests.models.shared.common.mocks.MockWithMethodBlocker");
		MethodBlocker mb = new MethodBlocker(MockWithMethodBlocker.class, "doB", allowedCallersClassNames);
		return mb;
	}
	
	public void doC() {
		doB();
	}
	
	public void doD() {
		dBlock.checkAllowed();
	}

	private MethodBlocker getDBlock() {
		List<String> allowedCallersClassNames = new ArrayList<String>();
		allowedCallersClassNames.add("org.adligo.tests4j_tests.models.shared.common.MethodBlockerTrial");
		allowedCallersClassNames.add("org.adligo.tests4j_tests.models.shared.common.mocks.MockWithMethodBlocker");
		MethodBlocker mb = new MethodBlocker(MockWithMethodBlocker.class, "doD", allowedCallersClassNames);
		return mb;
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
