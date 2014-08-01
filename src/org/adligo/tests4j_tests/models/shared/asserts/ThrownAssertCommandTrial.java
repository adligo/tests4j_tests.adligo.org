package org.adligo.tests4j_tests.models.shared.asserts;

import org.adligo.tests4j.models.shared.asserts.ExpectedThrownData;
import org.adligo.tests4j.models.shared.asserts.ThrownAssertCommand;
import org.adligo.tests4j.models.shared.asserts.ThrownAssertionData;
import org.adligo.tests4j.models.shared.asserts.common.AssertType;
import org.adligo.tests4j.models.shared.asserts.common.I_AssertionData;
import org.adligo.tests4j.models.shared.asserts.common.I_Thrower;
import org.adligo.tests4j.models.shared.en.Tests4J_EnglishConstants;
import org.adligo.tests4j.models.shared.i18n.I_Tests4J_AssertionInputMessages;
import org.adligo.tests4j.models.shared.trials.SourceFileScope;
import org.adligo.tests4j.models.shared.trials.Test;
import org.adligo.tests4j_tests.base_abstract_trials.SourceFileCountingTrial;

@SourceFileScope (sourceClass=ThrownAssertCommand.class, minCoverage=65.0)
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
		assertNull(tad.getActualMessage());
		assertNull(tad.getActualThrowable());
		assertEquals(IllegalArgumentException.class, tad.getExpectedThrowable());
		assertEquals("hey", tad.getExpectedMessage());
		assertEquals("failure message", a.getFailureMessage());
		assertEquals(AssertType.AssertThrown, a.getType());
		
		assertFalse(a.evaluate(new I_Thrower() {
			
			@Override
			public void run() {
				throw new IllegalStateException("...");
			}
		}));
		
		I_AssertionData dataAfterEvaluate = a.getData();
		assertNotNull(dataAfterEvaluate);
		assertTrue(dataAfterEvaluate instanceof ThrownAssertionData);
		ThrownAssertionData tad_AfterEvaluate = (ThrownAssertionData) data;
		assertNull(tad_AfterEvaluate.getActualMessage());
		assertNull(tad_AfterEvaluate.getActualThrowable());
		assertEquals(IllegalArgumentException.class, tad_AfterEvaluate.getExpectedThrowable());
		assertEquals("hey", tad_AfterEvaluate.getExpectedMessage());
		
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
		assertFalse(a.evaluate(new I_Thrower() {
					
					@Override
					public void run() {
						throw new IllegalArgumentException("...");
					}
				}));
		assertFalse(a.evaluate(new I_Thrower() {
			
			@Override
			public void run() {
				throw new IllegalArgumentException("hey");
			}
		}));

		assertFalse(a.evaluate(new I_Thrower() {
			
			@Override
			public void run() {
				IllegalArgumentException top = new IllegalArgumentException("hey");
				top.initCause(new IllegalArgumentException());
				throw top;
			}
		}));
		
		assertFalse(a.evaluate(new I_Thrower() {
			
			@Override
			public void run() {
				IllegalArgumentException top = new IllegalArgumentException("hey");
				top.initCause(new IllegalArgumentException("pinch"));
				throw top;
			}
		}));
		
		assertFalse(a.evaluate(new I_Thrower() {
			
			@Override
			public void run() {
				IllegalArgumentException top = new IllegalArgumentException("hey");
				top.initCause(new IllegalStateException());
				throw top;
			}
		}));
		
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
	public int getTests() {
		return 4;
	}

	@Override
	public int getAsserts() {
		return 36;
	}

	@Override
	public int getUniqueAsserts() {
		return 16;
	}
}
