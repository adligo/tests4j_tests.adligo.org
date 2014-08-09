package org.adligo.tests4j_tests.models.shared.common;

import java.util.Collections;

import org.adligo.tests4j.models.shared.asserts.common.ExpectedThrownData;
import org.adligo.tests4j.models.shared.asserts.common.I_Thrower;
import org.adligo.tests4j.models.shared.common.MethodBlocker;
import org.adligo.tests4j.models.shared.en.Tests4J_EnglishConstants;
import org.adligo.tests4j.models.shared.i18n.I_Tests4J_Constants;
import org.adligo.tests4j.models.shared.system.Tests4J_Constants;
import org.adligo.tests4j.models.shared.trials.AdditionalInstrumentation;
import org.adligo.tests4j.models.shared.trials.BeforeTrial;
import org.adligo.tests4j.models.shared.trials.SourceFileScope;
import org.adligo.tests4j.models.shared.trials.Test;
import org.adligo.tests4j_tests.base_abstract_trials.SourceFileCountingTrial;
import org.adligo.tests4j_tests.models.shared.common.mocks.MockWithMethodBlocker;

@SourceFileScope (sourceClass=MethodBlocker.class, minCoverage=100.0)
@AdditionalInstrumentation (javaPackages="org.adligo.tests4j_tests.models.shared.common.mocks")
public class MethodBlockerTrial extends SourceFileCountingTrial {
	
	
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
		//first call allows from anywhere
		mockWithMethodBlocker.doF();
		final Runnable recurseMethodCallFailureRunnable = new Runnable() {
			
			@Override
			public void run() {
				mockWithMethodBlocker.doF();
			}
		};
		assertThrown(new ExpectedThrownData(new IllegalStateException(DO_D_EXCEPTION_MESSAGE)), 
			new I_Thrower() {
			
			@Override
			public void run() {
				recurseMethodCallFailureRunnable.run();
			}
		});
	}
	
	
	@Test
	public void testConstructorException() {
		I_Tests4J_Constants constants =  Tests4J_EnglishConstants.ENGLISH;
		
		assertThrown(new ExpectedThrownData(new IllegalArgumentException( 
				constants.getMethodBlockerRequiresABlockingClass())), 
			new I_Thrower() {
			
			@Override
			public void run() {
				new MethodBlocker(null, 
						"run", 
						Collections.<String> emptyList());
				
			}
		});
		assertThrown(new ExpectedThrownData(new IllegalArgumentException( 
				constants.getMethodBlockerRequiresABlockingMethod())), 
			new I_Thrower() {
			
			@Override
			public void run() {
				new MethodBlocker(this.getClass(), 
						null, 
						Collections.<String> emptyList());
				
			}
		});
		
		assertThrown(new ExpectedThrownData(new IllegalArgumentException( 
				constants.getMethodBlockerRequiresAtLeastOneAllowedCallerClassNames())), 
			new I_Thrower() {
			
			@Override
			public void run() {
				new MethodBlocker(this.getClass(), 
						"run", 
						Collections.<String> emptyList());
				
			}
		});
		assertThrown(new ExpectedThrownData(new IllegalArgumentException( 
				constants.getMethodBlockerRequiresAtLeastOneAllowedCallerClassNames())), 
			new I_Thrower() {
			
			@Override
			public void run() {
				new MethodBlocker(this.getClass(), 
						"run", null);
				
			}
		});
	}
	
	@Test
	public void testMethodWithBlockThrowsException() {
		
		String message = Tests4J_Constants.CONSTANTS.getTheMethodCanOnlyBeCalledBy_PartOne() +
				"class org.adligo.tests4j_tests.models.shared.common.mocks.MockWithMethodBlocker.doA" +
				Tests4J_Constants.CONSTANTS.getTheMethodCanOnlyBeCalledBy_PartTwo() +
				"[org.adligo.tests4j_tests.models.shared.common.MethodBlockerTrial]";
		final MockWithMethodBlocker mockWithMethodBlocker = new MockWithMethodBlocker();
		//first call allows anyone to call
		mockWithMethodBlocker.doA();
		assertThrown(new ExpectedThrownData(new IllegalStateException(message)), 
			new I_Thrower() {
			
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
		
		message = Tests4J_Constants.CONSTANTS.getTheMethodCanOnlyBeCalledBy_PartOne() +
				"class org.adligo.tests4j_tests.models.shared.common.mocks.MockWithMethodBlocker.doB" +
				Tests4J_Constants.CONSTANTS.getTheMethodCanOnlyBeCalledBy_PartTwo() +
				"[org.adligo.tests4j_tests.models.shared.common.mocks.MockWithMethodBlocker]";
		
		//first call allows anyone to call
		mockWithMethodBlocker.doB();
		assertThrown(new ExpectedThrownData(new IllegalStateException(message)), 
			new I_Thrower() {
				
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
		assertThrown(new ExpectedThrownData(new IllegalStateException(
				DO_D_EXCEPTION_MESSAGE)), 
				new I_Thrower() {
					
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
	public int getTests() {
		return 3;
	}

	@Override
	public int getAsserts() {
		return 8;
	}

	@Override
	public int getUniqueAsserts() {
		return 8;
	}
}
