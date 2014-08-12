package org.adligo.tests4j_tests.run.helpers.class_loading_mocks;

/**
 * this whole line of MockWith classes
 * are classes so I can test my fast dependency tree
 * code that tries to cache class file bytes
 * in order of the dependency tree,
 * and then instrument the bytes in a way that
 * is fast and safe for consistent code coverage assertions. 
 * 
 * Note the System.out.printlns are just to keep the complier
 * from removing dead code, so that it shows up in the byte code.
 * 
 * @author scott
 *
 */
public abstract class MockWithEverything {
	private MockWithMethodReturn ret;
	private MockWithImportOnlyInMethod to;
	private MockWithAbstractMethodException a;
	private MockWithAbstractMethodReturn b;
	private MockWithAbstractMethodParam c;
	public MockWithBidirectionalA aa;
	public MockWithTriangleC cc;
	public MockWithString str;
	public MockWithExtensionB bme;
	public MockI_OtherStringAndLong fusbar;
	
	public MockWithEverything() {
		double d = Math.random();
		if (d >= 0.5) {
			MockWithStaticField.sys = new MockWithNothing();
		}
		if (MockWithStaticField.sys != null) {
			String hey = MockWithStaticInitalizer.class.getName();
			System.out.print( super.toString() + " hey " + hey);
			ret = new MockWithMethodReturn() {
				
				@Override
				public MockWithNothing getTrial() {
					try {
						MockWithMethodException mme = new MockWithMethodException();
						System.out.print( super.toString() + " hey " + mme.getTrial());
						MockWithMethodExceptionBlock mme2 = new MockWithMethodExceptionBlock();
						System.out.print( super.toString() + " hey " + mme2.toString() 
								+ a + b + c);
					} catch (MockException x) {
						//doNothing
					}
					return MockWithStaticField.sys;
				}
			};
			System.out.print( super.toString() + " hey " + ret +to
					+ MockWithField.class.toString() + MockWithArray.class.toString() +
					MockWithMethodParams.class);
		}
		
	}
	public abstract MockWithMethodParams get(MockWithField p);
	
}
