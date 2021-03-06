package org.adligo.tests4j_tests.shared.common;

import org.adligo.tests4j.shared.asserts.common.ExpectedThrowable;
import org.adligo.tests4j.shared.asserts.common.I_Thrower;
import org.adligo.tests4j.shared.asserts.reference.AllowedReferences;
import org.adligo.tests4j.shared.asserts.reference.CircularDependencies;
import org.adligo.tests4j.shared.common.MethodBlocker;
import org.adligo.tests4j.shared.en.Tests4J_EnglishConstants;
import org.adligo.tests4j.shared.i18n.I_Tests4J_Constants;
import org.adligo.tests4j.system.shared.trials.AdditionalInstrumentation;
import org.adligo.tests4j.system.shared.trials.SourceFileScope;
import org.adligo.tests4j.system.shared.trials.Test;
import org.adligo.tests4j_tests.base_trials.I_CountType;
import org.adligo.tests4j_tests.base_trials.SourceFileCountingTrial;
import org.adligo.tests4j_tests.references_groups.Tests4J_Common_ReferenceGroup;
import org.adligo.tests4j_tests.shared.common.mocks.MockWithMethodBlocker;

import java.util.Collections;

@SourceFileScope (sourceClass=MethodBlocker.class, 
  minCoverage=97.0, allowedCircularDependencies=CircularDependencies.AllowInPackage)
@AdditionalInstrumentation (javaPackages="org.adligo.tests4j_tests.shared.common.mocks")
@AllowedReferences (groups=Tests4J_Common_ReferenceGroup.class)
public class MethodBlockerTrial extends SourceFileCountingTrial {
	
	
	private static final String DO_D_EXCEPTION_MESSAGE = "The Method class org.adligo.tests4j_tests.shared.common.mocks.MockWithMethodBlocker.doD "
	+ "may only be called by " +
	"[org.adligo.tests4j_tests.shared.common.MethodBlockerTrial,"
	+ " org.adligo.tests4j_tests.shared.common.mocks.MockWithMethodBlocker]";

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
		assertThrown(new ExpectedThrowable(new IllegalStateException(DO_D_EXCEPTION_MESSAGE)), 
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
		
		assertThrown(new ExpectedThrowable(NullPointerException.class), 
      new I_Thrower() {
      
      @Override
      public void run() {
        new MethodBlocker(null, null, 
            "run", 
            Collections.<String> emptyList());
        
      }
    });
		
		assertThrown(new ExpectedThrowable(new IllegalArgumentException( 
				constants.getMethodBlockerRequiresABlockingClass())), 
			new I_Thrower() {
			
			@Override
			public void run() {
				new MethodBlocker(Tests4J_EnglishConstants.ENGLISH, null, 
						"run", 
						Collections.<String> emptyList());
				
			}
		});
		assertThrown(new ExpectedThrowable(new IllegalArgumentException( 
				constants.getMethodBlockerRequiresABlockingMethod())), 
			new I_Thrower() {
			
			@Override
			public void run() {
				new MethodBlocker(Tests4J_EnglishConstants.ENGLISH, this.getClass(), 
						null, 
						Collections.<String> emptyList());
				
			}
		});
		
		assertThrown(new ExpectedThrowable(new IllegalArgumentException( 
				constants.getMethodBlockerRequiresAtLeastOneAllowedCallerClassNames())), 
			new I_Thrower() {
			
			@Override
			public void run() {
				new MethodBlocker(Tests4J_EnglishConstants.ENGLISH,  this.getClass(), 
						"run", 
						Collections.<String> emptyList());
				
			}
		});
		assertThrown(new ExpectedThrowable(new IllegalArgumentException( 
				constants.getMethodBlockerRequiresAtLeastOneAllowedCallerClassNames())), 
			new I_Thrower() {
			
			@Override
			public void run() {
				new MethodBlocker(Tests4J_EnglishConstants.ENGLISH,  this.getClass(), 
						"run", null);
				
			}
		});
	}
	
	@Test
	public void testMethodWithBlockThrowsException() {
		
		String message = Tests4J_EnglishConstants.ENGLISH.getTheMethodCanOnlyBeCalledBy_PartOne() +
				"class org.adligo.tests4j_tests.shared.common.mocks.MockWithMethodBlocker.doA" +
				Tests4J_EnglishConstants.ENGLISH.getTheMethodCanOnlyBeCalledBy_PartTwo() +
				"[org.adligo.tests4j_tests.shared.common.MethodBlockerTrial]";
		final MockWithMethodBlocker mockWithMethodBlocker = new MockWithMethodBlocker();
		//first call allows anyone to call
		mockWithMethodBlocker.doA();
		assertThrown(new ExpectedThrowable(new IllegalStateException(message)), 
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
		
		message = Tests4J_EnglishConstants.ENGLISH.getTheMethodCanOnlyBeCalledBy_PartOne() +
				"class org.adligo.tests4j_tests.shared.common.mocks.MockWithMethodBlocker.doB" +
				Tests4J_EnglishConstants.ENGLISH.getTheMethodCanOnlyBeCalledBy_PartTwo() +
				"[org.adligo.tests4j_tests.shared.common.mocks.MockWithMethodBlocker]";
		
		//first call allows anyone to call
		mockWithMethodBlocker.doB();
		assertThrown(new ExpectedThrowable(new IllegalStateException(message)), 
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
		assertThrown(new ExpectedThrowable(new IllegalStateException(
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
	public int getTests(I_CountType type) {
		return super.getTests(type, 3, true);
	}


	
	@Override
	public int getAsserts(I_CountType type) {
	  int asserts = 9;
		if (type.isFromMetaWithCoverage()) {
			//code coverage and circular dependencies
			return super.getAsserts(type, asserts + 3);
		} else {
			return super.getAsserts(type, asserts);
		}
	}

	@Override
	public int getUniqueAsserts(I_CountType type) {
	  int uAsserts = 9;
		if (type.isFromMetaWithCoverage()) {
			return super.getUniqueAsserts(type, uAsserts + 3);
		} else {
			return super.getUniqueAsserts(type, uAsserts);
		}
	}
}
