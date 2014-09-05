package org.adligo.tests4j_tests.run;

import org.adligo.tests4j.models.shared.asserts.common.ExpectedThrownData;
import org.adligo.tests4j.models.shared.asserts.common.I_Thrower;
import org.adligo.tests4j.models.shared.trials.AdditionalInstrumentation;
import org.adligo.tests4j.models.shared.trials.AfterTrial;
import org.adligo.tests4j.models.shared.trials.SourceFileScope;
import org.adligo.tests4j.models.shared.trials.Test;
import org.adligo.tests4j.shared.output.DefaultLog;
import org.adligo.tests4j.shared.output.I_Tests4J_Log;
import org.adligo.tests4j_tests.base_trials.I_CountType;
import org.adligo.tests4j_tests.base_trials.SourceFileCountingTrial;
import org.adligo.tests4j_tests.run.mocks.BadMockTests4J_UncaughtExceptionHandler;
import org.adligo.tests4j_tests.run.mocks.MockTests4J_UncaughtExceptionHandler;

//yet another minCoverage mystery why is cc 47 and not 70
@SourceFileScope (sourceClass=Tests4J_UncaughtExceptionHandlerTrial.class, minCoverage=46.0)
@AdditionalInstrumentation (javaPackages="org.adligo.tests4j_tests.run.mocks")
public class Tests4J_UncaughtExceptionHandlerTrial extends SourceFileCountingTrial implements I_Tests4J_Log {
	private String lastLog;
	private Throwable lastThrowable;
	
	public void beforeTests() {
		//TODO make a threadlocal logger for testing
		//lets hope no uncaught exceptions occur, which overlap with this test
		//in the multiple trial/test threads
		MockTests4J_UncaughtExceptionHandler.setStaticLogger(this);
	}
	@Test
	public void testUncaughtException() throws Exception {
		MockTests4J_UncaughtExceptionHandler handler = new MockTests4J_UncaughtExceptionHandler();
		IllegalArgumentException iae = new IllegalArgumentException("hey");
		handler.uncaughtException(new Thread("ThreadName"), iae);
		assertEquals("uncaughtException on thread ThreadName", lastLog);
		assertSame(iae, lastThrowable);
		assertSame(this, MockTests4J_UncaughtExceptionHandler.getStaticLogger());
	}
	
	@Test
	public void testSetLogFailure() throws Exception {
		assertThrown(new ExpectedThrownData(new IllegalStateException(
				"The Method class org.adligo.tests4j.run.Tests4J_UncaughtExceptionHandler.setLogger "
				+ "may only be called by [org.adligo.tests4j_tests.run.mocks.MockTests4J_UncaughtExceptionHandler]")),
				new I_Thrower() {
					
					@Override
					public void run() {
						BadMockTests4J_UncaughtExceptionHandler.setStaticLogger(Tests4J_UncaughtExceptionHandlerTrial.this);
					}
				});
	}
	
	@AfterTrial
	public static void afterTrial() {
		DefaultLog defaultLogger = new DefaultLog();
		MockTests4J_UncaughtExceptionHandler.setStaticLogger(defaultLogger);
	}
	
	@Override
	public void log(String p) {
		lastLog = p;
	}
	
	@Override
	public void onThrowable(Throwable p) {
		lastThrowable = p;
	}
	@Override
	public boolean isMainLog() {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public String getLineSeperator() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public boolean isLogEnabled(Class<?> clazz) {
		// TODO Auto-generated method stub
		return false;
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
	@Override
	public String getCurrentThreadName() {
		// TODO Auto-generated method stub
		return null;
	}
}
