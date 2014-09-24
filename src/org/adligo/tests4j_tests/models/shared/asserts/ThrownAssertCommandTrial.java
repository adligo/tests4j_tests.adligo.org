package org.adligo.tests4j_tests.models.shared.asserts;

import org.adligo.tests4j.models.shared.asserts.ThrownAssertCommand;
import org.adligo.tests4j.models.shared.asserts.common.AssertType;
import org.adligo.tests4j.models.shared.asserts.common.ExpectedThrownData;
import org.adligo.tests4j.models.shared.asserts.common.I_AssertionData;
import org.adligo.tests4j.models.shared.asserts.common.I_ExpectedThrownData;
import org.adligo.tests4j.models.shared.asserts.common.I_Thrower;
import org.adligo.tests4j.models.shared.asserts.common.ThrownAssertionData;
import org.adligo.tests4j.models.shared.dependency_groups.adligo.Tests4J_Asserts_DependencyGroup;
import org.adligo.tests4j.models.shared.en.Tests4J_EnglishConstants;
import org.adligo.tests4j.models.shared.i18n.I_Tests4J_AssertionInputMessages;
import org.adligo.tests4j.models.shared.i18n.I_Tests4J_ResultMessages;
import org.adligo.tests4j.models.shared.trials.AllowedDependencies;
import org.adligo.tests4j.models.shared.trials.SourceFileScope;
import org.adligo.tests4j.models.shared.trials.Test;
import org.adligo.tests4j_tests.base_trials.I_CountType;
import org.adligo.tests4j_tests.base_trials.SourceFileCountingTrial;

@SourceFileScope (sourceClass=ThrownAssertCommand.class, minCoverage=76.0)
@AllowedDependencies (groups=Tests4J_Asserts_DependencyGroup.class)
public class ThrownAssertCommandTrial extends SourceFileCountingTrial {


	@Test
	public void testConstructorExceptions() {
		I_Tests4J_AssertionInputMessages messages =  Tests4J_EnglishConstants.ENGLISH.getAssertionInputMessages();
		assertThrown(new ExpectedThrownData(new IllegalArgumentException(
				messages.getTheExpectedValueShouldNeverBeNull())), 
				new I_Thrower() {
					
					@Override
					public void run() {
						new ThrownAssertCommand("failure message", null);
					}
				});
	}
	
	@Test
	public void testEqualsHashCode() {
		ThrownAssertCommand a =
				new ThrownAssertCommand("failure message", 
				new ExpectedThrownData(new IllegalArgumentException("hey")));
		ThrownAssertCommand b =
				new ThrownAssertCommand("failure message", 
				new ExpectedThrownData(new IllegalArgumentException("hey2")));
		ThrownAssertCommand c =
				new ThrownAssertCommand("failure message", 
				new ExpectedThrownData(new IllegalArgumentException("hey")));
		ThrownAssertCommand d =
				new ThrownAssertCommand("failure message2", 
				new ExpectedThrownData(new IllegalArgumentException("hey")));
		ThrownAssertCommand e =
				new ThrownAssertCommand("failure message", 
				new ExpectedThrownData(new IllegalStateException("hey")));
	
		assertEquals(a, a);
		assertEquals(a.hashCode(), a.hashCode());
		
		assertNotEquals(a, b);
		assertNotEquals(a.hashCode(), b.hashCode());
		
		assertEquals(a,  c);
		assertEquals(a.hashCode(), c.hashCode());
		
		assertNotEquals(a, d);
		assertNotEquals(a.hashCode(), d.hashCode());
		
		//IllegalStateException not IllegalArgumentException
		assertNotEquals(a, e);
		assertNotEquals(a.hashCode(), e.hashCode());
	}
	
	@Test
	public void testEvaluateSlashGetData() {
		ThrownAssertCommand a =
				new ThrownAssertCommand("failure message", 
						new ExpectedThrownData(new IllegalArgumentException("hey")));
		I_AssertionData data = a.getData();
		assertNotNull(data);
		assertTrue(data instanceof ThrownAssertionData);
		ThrownAssertionData tad = (ThrownAssertionData) data;
		I_ExpectedThrownData expected =  tad.getExpected();
		Throwable actual = tad.getActual();
		
		assertNull(actual);
		assertEquals(IllegalArgumentException.class, expected.getThrowableClass());
		assertEquals("hey", expected.getMessage());
		assertEquals("failure message", a.getFailureMessage());
		assertEquals(AssertType.AssertThrown, a.getType());
		
		assertFalse(a.evaluate(new I_Thrower() {
			
			@Override
			public void run() {
				throw new IllegalStateException("...");
			}
		}));
		
		I_Tests4J_ResultMessages messages =  Tests4J_EnglishConstants.ENGLISH.getResultMessages();
		assertEquals(messages.getThrowableClassMismatch(), a.getFailureReason());
		assertEquals(1, a.getFailureThrowable());
		
		I_AssertionData dataAfterEvaluate = a.getData();
		assertNotNull(dataAfterEvaluate);
		assertTrue(dataAfterEvaluate instanceof ThrownAssertionData);
		ThrownAssertionData tad_AfterEvaluate = (ThrownAssertionData) dataAfterEvaluate;
		
		expected = tad_AfterEvaluate.getExpected();
		actual = tad_AfterEvaluate.getActual();
		assertEquals("...",actual.getMessage());
		assertEquals(IllegalStateException.class ,actual.getClass());
		assertEquals(IllegalArgumentException.class, expected.getThrowableClass());
		assertEquals("hey", expected.getMessage());
		
		assertEquals(messages.getThrowableClassMismatch(), tad_AfterEvaluate.getFailureReason());
		assertEquals(1, tad_AfterEvaluate.getFailureThrowable());
		
		
	}
	
	
	@Test
	public void testDeepEvaluate() {
		ThrownAssertCommand a =
				new ThrownAssertCommand("failure message", 
						new ExpectedThrownData(new IllegalArgumentException("hey"),
						new ExpectedThrownData(IllegalStateException.class,
						new ExpectedThrownData(new IllegalStateException("zzz")))));
		
		assertFalse(a.evaluate(new I_Thrower() {
			
			@Override
			public void run() {
				throw new IllegalStateException("...");
			}
		}));
		I_Tests4J_ResultMessages messages =  Tests4J_EnglishConstants.ENGLISH.getResultMessages();

		assertEquals(messages.getThrowableClassMismatch(), a.getFailureReason());
		assertEquals(1, a.getFailureThrowable());
		
		assertFalse(a.evaluate(new I_Thrower() {
					
					@Override
					public void run() {
						throw new IllegalArgumentException("...");
					}
				}));
		assertEquals(messages.getThrowableMessageNotEquals(), a.getFailureReason());
		assertEquals(1, a.getFailureThrowable());
		
		assertFalse(a.evaluate(new I_Thrower() {
			
			@Override
			public void run() {
				throw new IllegalArgumentException("hey");
			}
		}));
		assertEquals(messages.getThrowableClassMismatch(), a.getFailureReason());
		assertEquals(2, a.getFailureThrowable());
		
		assertFalse(a.evaluate(new I_Thrower() {
			
			@Override
			public void run() {
				IllegalArgumentException top = new IllegalArgumentException("hey");
				top.initCause(new IllegalArgumentException());
				throw top;
			}
		}));
		
		assertEquals(messages.getThrowableClassMismatch(), a.getFailureReason());
		assertEquals(2, a.getFailureThrowable());
		
		assertFalse(a.evaluate(new I_Thrower() {
			
			@Override
			public void run() {
				IllegalArgumentException top = new IllegalArgumentException("hey");
				top.initCause(new IllegalArgumentException("pinch"));
				throw top;
			}
		}));
		assertEquals(messages.getThrowableClassMismatch(), a.getFailureReason());
		assertEquals(2, a.getFailureThrowable());
		
		assertFalse(a.evaluate(new I_Thrower() {
			
			@Override
			public void run() {
				IllegalArgumentException top = new IllegalArgumentException("hey");
				top.initCause(new IllegalStateException());
				throw top;
			}
		}));
		assertEquals(messages.getThrowableClassMismatch(), a.getFailureReason());
		assertEquals(3, a.getFailureThrowable());
		
		assertFalse(a.evaluate(new I_Thrower() {
			
			@Override
			public void run() {
				IllegalArgumentException top = new IllegalArgumentException("hey");
				IllegalStateException second = new IllegalStateException();
				
				top.initCause(second);
				second.initCause(new IllegalArgumentException());
				throw top;
			}
		}));
		assertEquals(messages.getThrowableClassMismatch(), a.getFailureReason());
		assertEquals(3, a.getFailureThrowable());
		
		assertFalse(a.evaluate(new I_Thrower() {
			
			@Override
			public void run() {
				IllegalArgumentException top = new IllegalArgumentException("hey");
				IllegalStateException second = new IllegalStateException();
				
				top.initCause(second);
				second.initCause(new IllegalStateException());
				throw top;
			}
		}));
		assertEquals(messages.getThrowableMessageNotEquals(), a.getFailureReason());
		assertEquals(3, a.getFailureThrowable());
		
		assertFalse(a.evaluate(new I_Thrower() {
			
			@Override
			public void run() {
				IllegalArgumentException top = new IllegalArgumentException("hey");
				IllegalStateException second = new IllegalStateException();
				
				top.initCause(second);
				second.initCause(new IllegalStateException("z"));
				throw top;
			}
		}));
		assertEquals(messages.getThrowableMessageNotEquals(), a.getFailureReason());
		assertEquals(3, a.getFailureThrowable());
		
		assertTrue(a.evaluate(new I_Thrower() {
			
			@Override
			public void run() {
				IllegalArgumentException top = new IllegalArgumentException("hey");
				IllegalStateException second = new IllegalStateException();
				
				top.initCause(second);
				second.initCause(new IllegalStateException("zzz"));
				throw top;
			}
		}));
	}
	

	@Override
	public int getTests(I_CountType type) {
		return super.getTests(type, 4);
	}

	@Override
	public int getAsserts(I_CountType type) {
		int thisAsserts = 57;
		if (type.isFromMetaWithCoverage()) {
			//code coverage and circular dependencies +
			//custom afterTrialTests
			return super.getAsserts(type, thisAsserts + 3);
		} else {
			return super.getAsserts(type, thisAsserts);
		}
	}

	@Override
	public int getUniqueAsserts(I_CountType type) {
		int thisUniqueAsserts = 25;
		if (type.isFromMetaWithCoverage()) {
			//code coverage and circular dependencies +
			//custom afterTrialTests
			return super.getUniqueAsserts(type, thisUniqueAsserts + 3);
		}  else {
			return super.getAsserts(type, thisUniqueAsserts);
		}
	}

}
