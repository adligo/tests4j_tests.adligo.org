package org.adligo.tests4j_tests.models.shared.asserts;

import java.lang.reflect.Method;

import org.adligo.tests4j.models.shared.SourceFileScope;
import org.adligo.tests4j.models.shared.SourceFileTrial;
import org.adligo.tests4j.models.shared.Test;
import org.adligo.tests4j.models.shared.asserts.AssertType;
import org.adligo.tests4j.models.shared.asserts.AssertionProcessor;
import org.adligo.tests4j.models.shared.asserts.BooleanAssertCommand;
import org.adligo.tests4j.models.shared.asserts.I_AssertCommand;
import org.adligo.tests4j.models.shared.asserts.I_AssertionData;
import org.adligo.tests4j.models.shared.common.PlatformEnum;
import org.adligo.tests4j.models.shared.results.I_TestFailure;
import org.adligo.tests4j.models.shared.system.I_AssertListener;
import org.adligo.tests4j.run.helpers.TestRunable;

@SourceFileScope (sourceClass=AssertionProcessor.class)
public class AssertionProcessorTrial extends SourceFileTrial implements I_AssertListener {
	private I_AssertCommand lastAssertCommand;
	private I_TestFailure lastTestFailure;
	
	@Override
	public void beforeTests() {
		lastAssertCommand = null;
		lastTestFailure = null;
	}
	
	
	@Test
	public void testBasic() {
		assertNull(lastAssertCommand);
		assertNull(lastTestFailure);
		BooleanAssertCommand bac = new BooleanAssertCommand(AssertType.AssertTrue, "should be true", 
				true);
		AssertionProcessor.evaluate(this, bac);
		assertSame(bac, lastAssertCommand);
		
		lastAssertCommand = null;
		
		bac = new BooleanAssertCommand(AssertType.AssertTrue, "should be true", 
				false);
		AssertionProcessor.evaluate(this, bac);
		assertNull(lastAssertCommand);
		assertNotNull(lastTestFailure);
		assertEquals("should be true", lastTestFailure.getMessage());
		assertNull(lastTestFailure.getException());
		
		Throwable locationFailed = lastTestFailure.getLocationFailed();
		assertNotNull(locationFailed);
		StackTraceElement [] elements = locationFailed.getStackTrace();
		
		StackTraceElement e = elements[0];
		assertEquals(AssertionProcessorTrial.class.getName(),  e.getClassName());
		assertEquals("testBasic",  e.getMethodName());
		assertEquals(43,  e.getLineNumber());
		
		StackAssertions.assertAssertionFailureLocation_StackWasFromTests4J(this, locationFailed);
		
		I_AssertionData data =  lastTestFailure.getData();
		assertNotNull(data);
		assertFalse((Boolean) data.getData(BooleanAssertCommand.VALUE));
		assertTrue((Boolean) data.getData(BooleanAssertCommand.EXPECTED_VALUE));
	}
	
	@Test
	public void testThrown() {
		//AssertionProcessor.evaluate(this, cmd);
	}

	@Override
	public void assertCompleted(I_AssertCommand cmd) {
		lastAssertCommand = cmd;
	}

	@Override
	public void assertFailed(I_TestFailure failure) {
		lastTestFailure = failure;
	}

	
}
