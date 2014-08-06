package org.adligo.tests4j_tests.models.shared.asserts;

import org.adligo.tests4j.models.shared.asserts.UniformThrownAssertCommand;
import org.adligo.tests4j.models.shared.asserts.common.ExpectedThrownData;
import org.adligo.tests4j.models.shared.asserts.common.I_AssertionData;
import org.adligo.tests4j.models.shared.asserts.common.I_ExpectedThrownData;
import org.adligo.tests4j.models.shared.asserts.common.I_Thrower;
import org.adligo.tests4j.models.shared.asserts.common.I_ThrownAssertionData;
import org.adligo.tests4j.models.shared.asserts.common.ThrownAssertionData;
import org.adligo.tests4j.models.shared.asserts.uniform.I_Evaluation;
import org.adligo.tests4j.models.shared.asserts.uniform.UniformThrownAssertionEvaluator;
import org.adligo.tests4j.models.shared.en.Tests4J_EnglishConstants;
import org.adligo.tests4j.models.shared.i18n.I_Tests4J_AssertionInputMessages;
import org.adligo.tests4j.models.shared.i18n.I_Tests4J_ResultMessages;
import org.adligo.tests4j.models.shared.trials.SourceFileScope;
import org.adligo.tests4j.models.shared.trials.Test;
import org.adligo.tests4j_tests.base_abstract_trials.SourceFileCountingTrial;

@SourceFileScope (sourceClass=UniformThrownAssertCommand.class, minCoverage=77.0)
public class UniformThrownAssertCommandTrial extends SourceFileCountingTrial {

	@Test
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void test01_ConstructorExceptions() {
		I_Tests4J_AssertionInputMessages messages = Tests4J_EnglishConstants.ENGLISH.getAssertionInputMessages();
		
		assertThrown(new ExpectedThrownData(new IllegalArgumentException(
				messages.getExpectedThrownDataRequiresThrowable())),
				new I_Thrower() {
					
					@Override
					public void run() {
						new UniformThrownAssertCommand("failure message", null, null);
					}
				});
		assertThrown(new ExpectedThrownData(new IllegalArgumentException(
				UniformThrownAssertCommand.UNIFORM_THROWN_ASSERT_COMMAND_REQUIRES_A_EVALUATOR)),
				new I_Thrower() {
					
					
					@Override
					public void run() {
						new UniformThrownAssertCommand("failure message", 
								new ExpectedThrownData(new IllegalArgumentException("failure message")), null);
					}
				});
	}
	
	@Test
	public void test02_EqualsHashCode() {
		UniformThrownAssertionEvaluator tue = new UniformThrownAssertionEvaluator();
		UniformThrownAssertCommand a = 
				new UniformThrownAssertCommand("failure message", 
				new ExpectedThrownData(new IllegalArgumentException("expected exception messsage")), tue);
		UniformThrownAssertCommand b = 
				new UniformThrownAssertCommand("failure message 2", 
				new ExpectedThrownData(new IllegalArgumentException("expected exception messsage")), tue);
		UniformThrownAssertCommand c = 
				new UniformThrownAssertCommand("failure message", 
				new ExpectedThrownData(new IllegalArgumentException("expected exception messsage")), tue);
		UniformThrownAssertCommand d = 
				new UniformThrownAssertCommand("failure message", 
				new ExpectedThrownData(new IllegalStateException("expected exception messsage")), tue);
		UniformThrownAssertCommand e = 
				new UniformThrownAssertCommand("failure message", 
				new ExpectedThrownData(new IllegalStateException("expected exception messsage")), tue);
		
		assertEquals(a, a);
		assertEquals(a.hashCode(), a.hashCode());
		
		assertNotEquals(a, b);
		assertNotEquals(a.hashCode(), b.hashCode());
		
		assertEquals(a, c);
		assertEquals(a.hashCode(), c.hashCode());
		
		assertTrue(c.evaluate(new I_Thrower() {
			
			@Override
			public void run() {
				throw new IllegalArgumentException("expected exception messsage");
			}
		}));
		assertNotEquals(a, c);
		assertNotEquals(a.hashCode(), c.hashCode());
		
		assertNotEquals(a, d);
		assertNotEquals(a.hashCode(),d.hashCode());
		
		assertNotEquals(a, e);
		assertNotEquals(a.hashCode(), e.hashCode());
	}
	
	@Test
	public void test03_GettersBeforeEvaluate() {
		IllegalArgumentException iae = new IllegalArgumentException("expected exception messsage");
		ExpectedThrownData etd = new ExpectedThrownData(iae);
		final UniformThrownAssertCommand utac = new UniformThrownAssertCommand
				("failure message", etd, new UniformThrownAssertionEvaluator());
		assertEquals("failure message", utac.getFailureMessage());
		assertThrown(new ExpectedThrownData(NullPointerException.class),
				new I_Thrower() {
					
					
					@Override
					public void run() {
						utac.getData();
					}
				});
	}
	
	@Test
	public void test04_GettersAfterEvaluateFailNothingThrown() {
		
		ExpectedThrownData etd = new ExpectedThrownData(new IllegalArgumentException("bad exeception message\n\r"
				+ "123"));
		UniformThrownAssertCommand utac = new UniformThrownAssertCommand
				("failure message",  etd, new UniformThrownAssertionEvaluator());
		assertEquals("failure message", utac.getFailureMessage());
		assertFalse(utac.evaluate(new I_Thrower() {
			
			@Override
			public void run() {
			}
		}));
		
		I_AssertionData data = utac.getData();
		assertNotNull(data);
		assertTrue(data instanceof ThrownAssertionData);
		ThrownAssertionData tad = (ThrownAssertionData) data;
		
		I_ExpectedThrownData expected = tad.getExpected();
		Throwable actual = tad.getActual();
		assertNull(actual);
		assertEquals(IllegalArgumentException.class, expected.getThrowableClass());
		assertEquals("bad exeception message\n\r123", expected.getMessage());
		
		I_Tests4J_ResultMessages messges = Tests4J_EnglishConstants.ENGLISH.getResultMessages();
		
		assertEquals(messges.getNothingWasThrown(), tad.getFailureReason());
		assertEquals(1, tad.getFailureThrowable());
	}
	
	@Test
	public void test05_EvaluatePass() {
		final IllegalArgumentException iae = new IllegalArgumentException("expected exception messsage");
		ExpectedThrownData etd = new ExpectedThrownData(iae);
		final UniformThrownAssertCommand utac = new UniformThrownAssertCommand
				
				("failure message", etd, new UniformThrownAssertionEvaluator());
		assertEquals("failure message", utac.getFailureMessage());
	
		assertThrown(new ExpectedThrownData(NullPointerException.class),
				new I_Thrower() {
					
					
					@Override
					public void run() {
						utac.getData();
					}
				});
		assertTrue(utac.evaluate(new I_Thrower() {
			
			@Override
			public void run() {
				throw iae;
			}
		}));
		I_Evaluation<I_ThrownAssertionData> eval =  utac.getEvaluation();
		assertTrue(eval.isSuccess());
		assertNull(eval.getData());
		assertNull(utac.getData());
		
		
	}
	
	@Test
	public void test06_GettersAfterEvaluateFailClassMismatch() {
		final IllegalStateException iae = new IllegalStateException("expected exception messsage\n"
				+ "123");
		ExpectedThrownData etd = new ExpectedThrownData(new IllegalArgumentException("expected exeception message\n\r"
				+ "123"));
		UniformThrownAssertCommand utac = new UniformThrownAssertCommand
				("failure message",  etd, new UniformThrownAssertionEvaluator());
		assertEquals("failure message", utac.getFailureMessage());
		assertFalse(utac.evaluate(new I_Thrower() {
			
			@Override
			public void run() {
				throw iae;
			}
		}));
		
		I_AssertionData data = utac.getData();
		assertNotNull(data);
		assertTrue(data instanceof ThrownAssertionData);
		ThrownAssertionData tad = (ThrownAssertionData) data;
		
		I_ExpectedThrownData expected = tad.getExpected();
		Throwable actual = tad.getActual();
		assertEquals(IllegalStateException.class, actual.getClass());
		assertEquals("expected exception messsage\n123", actual.getMessage());
		assertEquals(IllegalArgumentException.class, expected.getThrowableClass());
		assertEquals("expected exeception message\n\r123", expected.getMessage());
		
		I_Tests4J_ResultMessages messges = Tests4J_EnglishConstants.ENGLISH.getResultMessages();
		
		assertEquals(messges.getThrowableClassMismatch(), tad.getFailureReason());
		assertEquals(1, tad.getFailureThrowable());
	}
	
	
	@Test
	public void test07_GettersAfterEvaluateFailTextNotUniform() {
		final IllegalArgumentException iae = new IllegalArgumentException("expected exception messsage\n"
				+ "123");
		ExpectedThrownData etd = new ExpectedThrownData(new IllegalArgumentException("bad exeception message\n\r"
				+ "123"));
		UniformThrownAssertCommand utac = new UniformThrownAssertCommand
				("failure message",  etd, new UniformThrownAssertionEvaluator());
		assertEquals("failure message", utac.getFailureMessage());
		assertFalse(utac.evaluate(new I_Thrower() {
			
			@Override
			public void run() {
				throw iae;
			}
		}));
		
		I_AssertionData data = utac.getData();
		assertNotNull(data);
		assertTrue(data instanceof ThrownAssertionData);
		ThrownAssertionData tad = (ThrownAssertionData) data;
		
		I_ExpectedThrownData expected = tad.getExpected();
		Throwable actual = tad.getActual();
		assertEquals(IllegalArgumentException.class, actual.getClass());
		assertEquals("expected exception messsage\n123", actual.getMessage());
		assertEquals(IllegalArgumentException.class, expected.getThrowableClass());
		assertEquals("bad exeception message\n\r123", expected.getMessage());
		
		I_Tests4J_ResultMessages messges = Tests4J_EnglishConstants.ENGLISH.getResultMessages();
		
		assertEquals(messges.getThrowableMessageNotUniform(), tad.getFailureReason());
		assertEquals(1, tad.getFailureThrowable());
	}



	@Test
	public void test08_GettersAfterEvaluateFailClassMismatchDeep() {
		final IllegalArgumentException iae = new IllegalArgumentException("message");
		iae.initCause(new NullPointerException());
		ExpectedThrownData etd = new ExpectedThrownData(new IllegalArgumentException("message"),
				new ExpectedThrownData(IllegalStateException.class));
		UniformThrownAssertCommand utac = new UniformThrownAssertCommand
				("failure message",  etd, new UniformThrownAssertionEvaluator());
		assertEquals("failure message", utac.getFailureMessage());
		assertFalse(utac.evaluate(new I_Thrower() {
			
			@Override
			public void run() {
				throw iae;
			}
		}));
		
		I_AssertionData data = utac.getData();
		assertNotNull(data);
		assertTrue(data instanceof ThrownAssertionData);
		ThrownAssertionData tad = (ThrownAssertionData) data;
		I_Tests4J_ResultMessages messges = Tests4J_EnglishConstants.ENGLISH.getResultMessages();
		
		assertEquals(messges.getThrowableClassMismatch(), tad.getFailureReason());
		assertEquals(2, tad.getFailureThrowable());
		
		final IllegalArgumentException iae2 = new IllegalArgumentException("message");
		IllegalStateException x = new IllegalStateException();
		x.initCause(new NullPointerException());
		iae2.initCause(x);
		etd = new ExpectedThrownData(new IllegalArgumentException("message"),
				new ExpectedThrownData(IllegalStateException.class,
				new ExpectedThrownData(IllegalArgumentException.class)));
		utac = new UniformThrownAssertCommand
				("failure message",  etd, new UniformThrownAssertionEvaluator());
		assertEquals("failure message", utac.getFailureMessage());
		assertFalse(utac.evaluate(new I_Thrower() {
			
			@Override
			public void run() {
				throw iae2;
			}
		}));
		
		data = utac.getData();
		assertNotNull(data);
		assertTrue(data instanceof ThrownAssertionData);
		tad = (ThrownAssertionData) data;
		assertEquals(messges.getThrowableClassMismatch(), tad.getFailureReason());
		assertEquals(3, tad.getFailureThrowable());
	}
	
	@Test
	public void test08_GettersAfterEvaluateFailTextNotUniformDeep() {
		final IllegalArgumentException iae = new IllegalArgumentException("message");
		iae.initCause(new NullPointerException("npe\n2"));
		ExpectedThrownData etd = new ExpectedThrownData(new IllegalArgumentException("message"),
				new ExpectedThrownData(new NullPointerException("npe\n1")));
		UniformThrownAssertCommand utac = new UniformThrownAssertCommand
				("failure message",  etd, new UniformThrownAssertionEvaluator());
		assertEquals("failure message", utac.getFailureMessage());
		assertFalse(utac.evaluate(new I_Thrower() {
			
			@Override
			public void run() {
				throw iae;
			}
		}));
		
		I_AssertionData data = utac.getData();
		assertNotNull(data);
		assertTrue(data instanceof ThrownAssertionData);
		ThrownAssertionData tad = (ThrownAssertionData) data;
		I_Tests4J_ResultMessages messges = Tests4J_EnglishConstants.ENGLISH.getResultMessages();
		
		assertEquals(messges.getThrowableMessageNotUniform(), tad.getFailureReason());
		assertEquals(2, tad.getFailureThrowable());
		
		final IllegalArgumentException iae2 = new IllegalArgumentException("message");
		IllegalStateException x = new IllegalStateException("state message");
		x.initCause(new NullPointerException("neo"));
		iae2.initCause(x);
		etd = new ExpectedThrownData(new IllegalArgumentException("message"),
				new ExpectedThrownData(new IllegalStateException("state message"),
				new ExpectedThrownData(new NullPointerException("npe"))));
		utac = new UniformThrownAssertCommand
				("failure message",  etd, new UniformThrownAssertionEvaluator());
		assertEquals("failure message", utac.getFailureMessage());
		assertFalse(utac.evaluate(new I_Thrower() {
			
			@Override
			public void run() {
				throw iae2;
			}
		}));
		
		data = utac.getData();
		assertNotNull(data);
		assertTrue(data instanceof ThrownAssertionData);
		tad = (ThrownAssertionData) data;
		assertEquals(messges.getThrowableMessageNotUniform(), tad.getFailureReason());
		assertEquals(3, tad.getFailureThrowable());
	}
	
	@Override
	public int getTests() {
		return 9;
	}

	@Override
	public int getAsserts() {
		return 76;
	}

	@Override
	public int getUniqueAsserts() {
		return 57;
	}
}
