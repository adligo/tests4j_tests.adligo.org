package org.adligo.tests4j_tests.models.shared.asserts;

import java.lang.reflect.Method;

import org.adligo.tests4j.models.shared.asserts.common.I_Asserts;
import org.adligo.tests4j.models.shared.common.PlatformEnum;
import org.adligo.tests4j.run.helpers.TestRunable;

public class StackAssertions {

	public static void assertAssertionFailureLocation_StackWasFromTests4J(I_Asserts asserts, Throwable p) {
		StackTraceElement [] elements =  p.getStackTrace();
		StackTraceElement e = elements[0];
		
		if (asserts.getPlatform() == PlatformEnum.JSE) {
			int index = 1;
			//skip the sun package
			while (!Method.class.getName().equals(e.getClassName())) {
				e = elements[index++];
			}
			asserts.assertEquals(Method.class.getName(),  e.getClassName());
			asserts.assertEquals("invoke",  e.getMethodName());
			
			e = elements[index++];
			asserts.assertEquals(TestRunable.class.getName(),  e.getClassName());
			asserts.assertEquals("run",  e.getMethodName());
		}
	}
}
