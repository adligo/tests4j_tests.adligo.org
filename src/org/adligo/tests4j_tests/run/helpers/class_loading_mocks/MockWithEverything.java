package org.adligo.tests4j_tests.run.helpers.class_loading_mocks;

public abstract class MockWithEverything {
	private MockWithMethodReturn ret;
	private MockWithImportOnlyInMethod to;
	
	public abstract MockWithMethodParams get(MockWithField p);
}
