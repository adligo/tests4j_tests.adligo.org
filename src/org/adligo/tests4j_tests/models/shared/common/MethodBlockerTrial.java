package org.adligo.tests4j_tests.models.shared.common;

import java.util.Collections;

import org.adligo.tests4j.models.shared.SourceFileScope;
import org.adligo.tests4j.models.shared.SourceFileTrial;
import org.adligo.tests4j.models.shared.Test;
import org.adligo.tests4j.models.shared.asserts.ExpectedThrownData;
import org.adligo.tests4j.models.shared.asserts.I_Thrower;
import org.adligo.tests4j.models.shared.common.MethodBlocker;
import org.adligo.tests4j.models.shared.coverage.I_SourceFileCoverage;
import org.adligo.tests4j.models.shared.results.feedback.I_SourceFileTrial_TestsResults;
import org.adligo.tests4j_tests.models.shared.common.mocks.MockWithMethodBlocker;

@SourceFileScope (sourceClass=MethodBlocker.class)
public class MethodBlockerTrial extends SourceFileTrial {
	
	
	private static final String DO_D_EXCEPTION_MESSAGE = "The Method class org.adligo.tests4j_tests.models.shared.common.mocks.MockWithMethodBlocker.doD "
	+ "may only be called by " +
	"[org.adligo.tests4j_tests.models.shared.common.MethodBlockerTrial,"
	+ " org.adligo.tests4j_tests.models.shared.common.mocks.MockWithMethodBlocker]";



	/**
	 * note this test must run first to 
	 * trick the class loader
	 * 
	 */
	@Test
	public void testNullStackTraceException() {
		final MockWithMethodBlocker mockWithMethodBlocker = new MockWithMethodBlocker();
		
		final Runnable recurseMethodCallFailureRunnable = new Runnable() {
			
			@Override
			public void run() {
				mockWithMethodBlocker.doF();
			}
		};
		assertThrown(new ExpectedThrownData(IllegalStateException.class,DO_D_EXCEPTION_MESSAGE), new I_Thrower() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				recurseMethodCallFailureRunnable.run();
			}
		});
	}
	
	
	@Test
	public void testConstructorException() {
		assertThrown(new ExpectedThrownData(IllegalArgumentException.class, 
				"MethodBlocker requires at least one Allowed Caller Class Name."), new I_Thrower() {
			
			@Override
			public void run() {
				new MethodBlocker(this.getClass(), 
						"run", 
						Collections.<String> emptyList());
				
			}
		});
	}
	
	@Test
	public void testMethodWithBlockThrowsException() {
		final MockWithMethodBlocker mockWithMethodBlocker = new MockWithMethodBlocker();
		assertThrown(new ExpectedThrownData(IllegalStateException.class, 
		"The Method class org.adligo.tests4j_tests.models.shared.common.mocks.MockWithMethodBlocker.doA"
		+ " may only be called by [org.adligo.tests4j_tests.models.shared.common.MethodBlockerTrial]"
				), new I_Thrower() {
			
			@Override
			public void run() {
				//note this fails from here as the class name is something like
				// MethodBlockerTrial$1, which is intended
				//this test is a bit confusing
				mockWithMethodBlocker.doA();
			}
		});
		// note this passes here because the class name is MethodBlockerTrial
		// which is intended
		// this test is a bit confusing
		mockWithMethodBlocker.doA();
		
		assertThrown(new ExpectedThrownData(IllegalStateException.class, 
		"The Method class org.adligo.tests4j_tests.models.shared.common.mocks.MockWithMethodBlocker.doB "
		+ "may only be called by [org.adligo.tests4j_tests.models.shared.common.mocks.MockWithMethodBlocker]"), new I_Thrower() {
			
			@Override
			public void run() {
				//note this fails from here as the class name is something like
				// MethodBlockerTrial$1, which is intended
				//this test is a bit confusing
				mockWithMethodBlocker.doB();
			}
		});
		
		// note this passes here because the class name is MockWithMethodBlock
		// which is intended
		// this test is a bit confusing
		mockWithMethodBlocker.doC();
		// note this passes here because the class name is MethodBlockerTrial
		// which is intended
		// this test is a bit confusing
		mockWithMethodBlocker.doD();
		
		// note this passes here because the class name is MockWithMethodBlock
		// which is intended
		// this test is a bit confusing
		mockWithMethodBlocker.doE();
		
		//note it is doB here 
		// and not doF, because doB is the method with the MethodBlocker
		assertThrown(new ExpectedThrownData(IllegalStateException.class, 
				DO_D_EXCEPTION_MESSAGE
			), new I_Thrower() {
					
					@Override
					public void run() {
						//note this fails from here as the class name is something like
						// MockWithMethodBlocker$1, which is intended
						//this test is a bit confusing
						mockWithMethodBlocker.doF();
					}
				});
		
	}
	
	
	
	@Override
	public void afterTrialTests(I_SourceFileTrial_TestsResults p) {
		assertGreaterThanOrEquals(4.0, p.getAssertions());
		assertGreaterThanOrEquals(4.0, p.getUniqueAssertions());
		
		if (p.hasRecordedCoverage()) {
			I_SourceFileCoverage coverage = p.getCoverage();
			assertGreaterThanOrEquals(100.0, coverage.getPercentageCoveredDouble());
		}
	}
}
