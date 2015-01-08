package org.adligo.tests4j_tests.run.api;

import org.adligo.tests4j.shared.asserts.common.ExpectedThrownData;
import org.adligo.tests4j.shared.asserts.common.I_Thrower;
import org.adligo.tests4j.shared.asserts.reference.CircularDependencies;
import org.adligo.tests4j.shared.output.DefaultLog;
import org.adligo.tests4j.shared.output.I_Tests4J_Log;
import org.adligo.tests4j.system.shared.trials.AdditionalInstrumentation;
import org.adligo.tests4j.system.shared.trials.AfterTrial;
import org.adligo.tests4j.system.shared.trials.SourceFileScope;
import org.adligo.tests4j.system.shared.trials.Test;
import org.adligo.tests4j_4mockito.MethodRecorder;
import org.adligo.tests4j_tests.base_trials.I_CountType;
import org.adligo.tests4j_tests.base_trials.SourceFileCountingTrial;
import org.adligo.tests4j_tests.run.api.mocks.BadMockTests4J_UncaughtExceptionHandler;
import org.adligo.tests4j_tests.run.api.mocks.MockTests4J_UncaughtExceptionHandler;

//yet another minCoverage mystery why is cc 47 and not 70
@SourceFileScope (sourceClass=Tests4J_UncaughtExceptionHandlerTrial.class, minCoverage=44.0,
	allowedCircularDependencies=CircularDependencies.AllowInnerOuterClasses)
@AdditionalInstrumentation (javaPackages="org.adligo.tests4j_tests.run.mocks")
public class Tests4J_UncaughtExceptionHandlerTrial extends SourceFileCountingTrial {
  private I_Tests4J_Log mockLog;
  private MethodRecorder<Void> logRecord = new MethodRecorder<Void>();
  private MethodRecorder<Void> onThrowableRecord = new MethodRecorder<Void>();
  
  @Override
	public void beforeTests() {
		//TODO make a threadlocal logger for testing
		//lets hope no uncaught exceptions occur, which overlap with this test
		//in the multiple trial/test threads
    mockLog = mock(I_Tests4J_Log.class);
    logRecord = new MethodRecorder<Void>();
    onThrowableRecord = new MethodRecorder<Void>();
    
    doAnswer(logRecord).when(mockLog).log(any());
    doAnswer(onThrowableRecord).when(mockLog).onThrowable(any());
		MockTests4J_UncaughtExceptionHandler.setStaticLogger(mockLog);
	}
  
	@Test
	public void testUncaughtException() throws Exception {
		MockTests4J_UncaughtExceptionHandler handler = new MockTests4J_UncaughtExceptionHandler();
		IllegalArgumentException iae = new IllegalArgumentException("hey");
		handler.uncaughtException(new Thread("ThreadName"), iae);
		assertEquals("uncaughtException on thread ThreadName", logRecord.getArgument(0));
		assertSame(iae, onThrowableRecord.getArgument(0));
		assertSame(mockLog, MockTests4J_UncaughtExceptionHandler.getStaticLogger());
	}
	
	@Test
	public void testSetLogFailure() throws Exception {
		assertThrown(new ExpectedThrownData(new IllegalStateException(
				"The Method class org.adligo.tests4j.run.api.Tests4J_UncaughtExceptionHandler.setLogger "
				+ "may only be called by [org.adligo.tests4j_tests.run.api.mocks.MockTests4J_UncaughtExceptionHandler]")),
				new I_Thrower() {
					
					@Override
					public void run() {
						BadMockTests4J_UncaughtExceptionHandler.setStaticLogger(mockLog);
					}
				});
	}
	
	@AfterTrial
	public static void afterTrial() {
		DefaultLog defaultLogger = new DefaultLog();
		MockTests4J_UncaughtExceptionHandler.setStaticLogger(defaultLogger);
	}
	
	@Override
	public int getTests(I_CountType type) {
		return super.getTests(type, 2);
	}

	@Override
	public int getAsserts(I_CountType type) {
		int thisAsserts = 4;
		//code coverage and circular dependencies +
		//custom afterTrialTests
		//+ see above
		int thisAfterAsserts = 2;
		if (type.isFromMetaWithCoverage()) {
			return super.getAsserts(type, thisAsserts + thisAfterAsserts);
		} else {
			return super.getAsserts(type, thisAsserts);
		}
	}

	@Override
	public int getUniqueAsserts(I_CountType type) {
		int thisUniqueAsserts = 4;
		//code coverage and circular dependencies +
		//custom afterTrialTests
		//+ see above
		int thisAfterUniqueAsserts = 2;
		if (type.isFromMetaWithCoverage()) {
			//code coverage and circular dependencies +
			//custom afterTrialTests
			return super.getUniqueAsserts(type, thisUniqueAsserts + thisAfterUniqueAsserts);
		} else {
			return super.getUniqueAsserts(type, thisUniqueAsserts);
		}
	}
}
