package org.adligo.tests4j_tests.models.shared.asserts;

import java.lang.reflect.Method;

import org.adligo.tests4j.models.shared.SourceFileScope;
import org.adligo.tests4j.models.shared.SourceFileTrial;
import org.adligo.tests4j.models.shared.Test;
import org.adligo.tests4j.models.shared.asserts.AssertionFailureLocation;
import org.adligo.tests4j.models.shared.common.PlatformEnum;
import org.adligo.tests4j.run.helpers.TestRunable;

@SourceFileScope (sourceClass=AssertionFailureLocation.class)
public class AssertionFailureLocationTrial extends SourceFileTrial {

	
	@Test
	public void testAssertionStack() {
		AssertionFailureLocation afl = new AssertionFailureLocation();
		StackTraceElement [] elements =  afl.getStackTrace();
		assertGreaterThanOrEquals(10, elements.length);
		
		StackTraceElement e = elements[0];
		assertEquals(AssertionFailureLocationTrial.class.getName(),  e.getClassName());
		assertEquals("testAssertionStack",  e.getMethodName());
		assertEquals(18,  e.getLineNumber());
		
		if (super.getPlatform() == PlatformEnum.JSE) {
			int index = 1;
			//skip the sun package
			while (!Method.class.getName().equals(e.getClassName())) {
				e = elements[index++];
			}
			assertEquals(Method.class.getName(),  e.getClassName());
			assertEquals("invoke",  e.getMethodName());
			
			e = elements[index++];
			assertEquals(TestRunable.class.getName(),  e.getClassName());
			assertEquals("run",  e.getMethodName());
		}
	}
}
