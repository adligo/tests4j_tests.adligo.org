package org.adligo.tests4j_tests.models.shared.asserts;

import java.lang.reflect.Method;

import org.adligo.tests4j.models.shared.SourceFileScope;
import org.adligo.tests4j.models.shared.SourceFileTrial;
import org.adligo.tests4j.models.shared.Test;
import org.adligo.tests4j.models.shared.asserts.AssertionProcessor;
import org.adligo.tests4j.models.shared.asserts.BooleanAssertCommand;
import org.adligo.tests4j.models.shared.asserts.ExpectedThrownData;
import org.adligo.tests4j.models.shared.asserts.ThrownAssertCommand;
import org.adligo.tests4j.models.shared.asserts.ThrownAssertionData;
import org.adligo.tests4j.models.shared.asserts.common.AssertType;
import org.adligo.tests4j.models.shared.asserts.common.I_AssertCommand;
import org.adligo.tests4j.models.shared.asserts.common.I_AssertionData;
import org.adligo.tests4j.models.shared.asserts.common.I_Thrower;
import org.adligo.tests4j.models.shared.common.PlatformEnum;
import org.adligo.tests4j.models.shared.coverage.I_SourceFileCoverage;
import org.adligo.tests4j.models.shared.results.I_TestFailure;
import org.adligo.tests4j.models.shared.results.feedback.I_SourceFileTrial_TestsResults;
import org.adligo.tests4j.models.shared.system.I_AssertListener;
import org.adligo.tests4j.run.helpers.TestRunable;

@SourceFileScope (sourceClass=AssertionProcessor.class)
public class AssertionProcessorTrial extends SourceFileTrial implements I_AssertListener, I_Thrower {
	private I_AssertCommand lastAssertCommand;
	private I_TestFailure lastTestFailure;
	private RuntimeException throwable;
	
	@Override
	public void beforeTests() {
		lastAssertCommand = null;
		lastTestFailure = null;
		throwable = null;
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
		I_AssertionData data =  lastTestFailure.getData();
		assertNotNull(data);
		
		StackTraceElement [] elements = locationFailed.getStackTrace();
		
		StackTraceElement e = elements[0];
		assertEquals(AssertionProcessorTrial.class.getName(),  e.getClassName());
		assertEquals("testBasic",  e.getMethodName());
		assertEquals(51,  e.getLineNumber());
		
		StackAssertions.assertAssertionFailureLocation_StackWasFromTests4J(this, locationFailed);
		
		
		
		assertFalse((Boolean) data.getData(BooleanAssertCommand.VALUE));
		assertTrue((Boolean) data.getData(BooleanAssertCommand.EXPECTED_VALUE));
	}
	
	@Test
	public void testThrown() {
		assertNull(lastAssertCommand);
		assertNull(lastTestFailure);
		ThrownAssertCommand tac = new ThrownAssertCommand(AssertType.AssertThrown, "should be true", 
				new ExpectedThrownData(RuntimeException.class, "thrown message"));
		AssertionProcessor.evaluate(this, tac, this);
		assertNull(lastAssertCommand);
		
		assertNotNull(lastTestFailure);
		assertEquals("should be true", lastTestFailure.getMessage());
		assertNull(lastTestFailure.getException());
		
		Throwable locationFailed = lastTestFailure.getLocationFailed();
		assertNotNull(locationFailed);
		StackTraceElement [] elements = locationFailed.getStackTrace();
		
		StackTraceElement e = elements[0];
		assertEquals(AssertionProcessorTrial.class.getName(),  e.getClassName());
		assertEquals("testThrown",  e.getMethodName());
		assertEquals(83,  e.getLineNumber());
		
		StackAssertions.assertAssertionFailureLocation_StackWasFromTests4J(this, locationFailed);
		
		I_AssertionData data =  lastTestFailure.getData();
		assertNotNull(data);
		assertNull(data.getData(ThrownAssertionData.ACTUAL_MESSAGE));
		assertNull( data.getData(ThrownAssertionData.ACTUAL_THROWABLE_CLASS));
		assertEquals("thrown message", data.getData(ThrownAssertionData.EXPECTED_MESSAGE));
		assertEquals(RuntimeException.class, data.getData(ThrownAssertionData.EXPECTED_THROWABLE_CLASS));
		
		lastTestFailure = null;
		throwable = new RuntimeException("thrown message");
		
		AssertionProcessor.evaluate(this, tac, this);
		assertNotNull(lastAssertCommand);
		assertSame(tac, lastAssertCommand);
		assertNull(lastTestFailure);
	}

	@Override
	public void assertCompleted(I_AssertCommand cmd) {
		lastAssertCommand = cmd;
	}

	@Override
	public void assertFailed(I_TestFailure failure) {
		lastTestFailure = failure;
	}


	@Override
	public void run() {
		if (throwable != null) {
			throw throwable;
		}
	}

	@Override
	public void afterTrialTests(I_SourceFileTrial_TestsResults p) {
		assertGreaterThanOrEquals(14.0, p.getAssertions());
		assertGreaterThanOrEquals(14.0, p.getUniqueAssertions());
		
		if (p.hasRecordedCoverage()) {
			I_SourceFileCoverage coverage = p.getCoverage();
			assertGreaterThanOrEquals(100.0, coverage.getPercentageCoveredDouble());
		}
	}
	
}
