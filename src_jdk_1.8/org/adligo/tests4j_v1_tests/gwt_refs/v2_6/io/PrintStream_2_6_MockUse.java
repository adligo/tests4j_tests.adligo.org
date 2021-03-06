
package org.adligo.tests4j_v1_tests.gwt_refs.v2_6.io;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;

/** autogenerated by org.adligo.tests4j.gen.dependency_groups.ClassUseGen*/
public class PrintStream_2_6_MockUse {

	public PrintStream obj = null;
	public PrintStream_2_6_MockUse() throws Exception {
		
		
		obj = new PrintStream(
				new OutputStream() {
					
					@Override
					public void write(int b) throws IOException {
						// TODO Auto-generated method stub
						
					}
				});
		callPrintStreamMethods();
		callObjectMethods();
		callOutputStreamMethods();
		callFilterOutputStreamMethods();
	}

	public void callPrintStreamMethods() {
	
		obj.print("abc".toCharArray());
		obj.print(true);
		obj.print('c');
		obj.print(0.1);
		obj.print((float) 0.2);
		obj.print(2);
		obj.print(new Object());
		obj.print("string");
		obj.print(3L);
		obj.println();
		obj.println("abc".toCharArray());
		obj.println(true);
		obj.println('c');
		obj.println(0.1);
		obj.println((float) 0.2);
		obj.println(2);
		obj.println(new Object());
		obj.println("string");
		obj.println(3L);
	}
	public void callObjectMethods() {
		obj.equals(new Object());
		obj.hashCode();
		obj.getClass();
		obj.toString();
	}
	public void callOutputStreamMethods() {
	}
	public void callFilterOutputStreamMethods() {
	}
}
