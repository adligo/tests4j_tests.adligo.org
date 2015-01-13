package org.adligo.tests4j_tests.shared.asserts;

import org.adligo.tests4j.shared.asserts.UniformThrownAssertCommand;
import org.adligo.tests4j.shared.asserts.common.ExpectedThrowable;
import org.adligo.tests4j.shared.asserts.common.I_AssertionData;
import org.adligo.tests4j.shared.asserts.common.I_ExpectedThrowable;
import org.adligo.tests4j.shared.asserts.common.I_Thrower;
import org.adligo.tests4j.shared.asserts.common.I_ThrownAssertionData;
import org.adligo.tests4j.shared.asserts.common.MatchType;
import org.adligo.tests4j.shared.asserts.common.ThrownAssertionData;
import org.adligo.tests4j.shared.asserts.reference.AllowedReferences;
import org.adligo.tests4j.shared.asserts.uniform.I_Evaluation;
import org.adligo.tests4j.shared.asserts.uniform.UniformThrownAssertionEvaluator;
import org.adligo.tests4j.shared.en.Tests4J_EnglishConstants;
import org.adligo.tests4j.shared.i18n.I_Tests4J_AssertionInputMessages;
import org.adligo.tests4j.shared.i18n.I_Tests4J_ResultMessages;
import org.adligo.tests4j.system.shared.trials.SourceFileScope;
import org.adligo.tests4j.system.shared.trials.Test;
import org.adligo.tests4j_tests.base_trials.I_CountType;
import org.adligo.tests4j_tests.base_trials.SourceFileCountingTrial;
import org.adligo.tests4j_tests.references_groups.Tests4J_Asserts_GwtReferenceGroup;

@SourceFileScope (sourceClass=UniformThrownAssertCommand.class, minCoverage=76.0)
@AllowedReferences (groups=Tests4J_Asserts_GwtReferenceGroup.class)
public class UniformThrownAssertCommandTrial extends SourceFileCountingTrial {

	@Test
	@SuppressWarnings("unused")
	public void test01_ConstructorExceptions() {
		I_Tests4J_AssertionInputMessages messages = Tests4J_EnglishConstants.ENGLISH.getAssertionInputMessages();
		
		assertThrown(new ExpectedThrowable(new IllegalArgumentException(
				messages.getExpectedThrownDataRequiresThrowable())),
				new I_Thrower() {
					
					
          @Override
					public void run() {
						new UniformThrownAssertCommand(Tests4J_EnglishConstants.ENGLISH, 
						    "failure message", null, null);
					}
				});
		assertThrown(new ExpectedThrowable(new IllegalArgumentException(
				UniformThrownAssertCommand.UNIFORM_THROWN_ASSERT_COMMAND_REQUIRES_A_EVALUATOR)),
				new I_Thrower() {
					
					
					@Override
					public void run() {
						new UniformThrownAssertCommand(
						    Tests4J_EnglishConstants.ENGLISH, "failure message", 
								new ExpectedThrowable(new IllegalArgumentException("failure message")), null);
					}
				});
		assertThrown(new ExpectedThrowable(new IllegalArgumentException(
        messages.getThrownUniformExpectedThrownDataMustBeMatchTypeAnyEqualsOrNull())),
        new I_Thrower() {
          
          
          @Override
          public void run() {
            new UniformThrownAssertCommand(Tests4J_EnglishConstants.ENGLISH, "failure message", 
                new ExpectedThrowable(new IllegalArgumentException("failure message"), 
                    new ExpectedThrowable(new IllegalArgumentException("mnn"), MatchType.CONTAINS)),
                new UniformThrownAssertionEvaluator(Tests4J_EnglishConstants.ENGLISH));
          }
        });
	}
	
	@SuppressWarnings("boxing")
  @Test
	public void test02_EqualsHashCode() {
		UniformThrownAssertionEvaluator tue = new UniformThrownAssertionEvaluator(
		    Tests4J_EnglishConstants.ENGLISH);
		UniformThrownAssertCommand a = 
				new UniformThrownAssertCommand(Tests4J_EnglishConstants.ENGLISH, "failure message", 
				new ExpectedThrowable(new IllegalArgumentException("expected exception messsage")), tue);
		UniformThrownAssertCommand b = 
				new UniformThrownAssertCommand(Tests4J_EnglishConstants.ENGLISH, "failure message 2", 
				new ExpectedThrowable(new IllegalArgumentException("expected exception messsage")), tue);
		UniformThrownAssertCommand c = 
				new UniformThrownAssertCommand(Tests4J_EnglishConstants.ENGLISH, "failure message", 
				new ExpectedThrowable(new IllegalArgumentException("expected exception messsage")), tue);
		UniformThrownAssertCommand d = 
				new UniformThrownAssertCommand(Tests4J_EnglishConstants.ENGLISH, "failure message", 
				new ExpectedThrowable(new IllegalStateException("expected exception messsage")), tue);
		UniformThrownAssertCommand e = 
				new UniformThrownAssertCommand(Tests4J_EnglishConstants.ENGLISH, "failure message", 
				new ExpectedThrowable(new IllegalStateException("expected exception messsage")), tue);
		
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
		ExpectedThrowable etd = new ExpectedThrowable(iae);
		final UniformThrownAssertCommand utac = new UniformThrownAssertCommand
				(Tests4J_EnglishConstants.ENGLISH,  
				    "failure message", etd, new UniformThrownAssertionEvaluator(Tests4J_EnglishConstants.ENGLISH));
		assertEquals("failure message", utac.getFailureMessage());
		assertThrown(new ExpectedThrowable(NullPointerException.class),
				new I_Thrower() {
					
					
					@Override
					public void run() {
						utac.getData();
					}
				});
	}
	
	@SuppressWarnings("boxing")
  @Test
	public void test04_GettersAfterEvaluateFailNothingThrown() {
		
		ExpectedThrowable etd = new ExpectedThrowable(new IllegalArgumentException("bad exeception message\n\r"
				+ "123"));
		UniformThrownAssertCommand utac = new UniformThrownAssertCommand
				(Tests4J_EnglishConstants.ENGLISH, 
				    "failure message",  etd, 
				    new UniformThrownAssertionEvaluator(Tests4J_EnglishConstants.ENGLISH));
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
		
		I_ExpectedThrowable expected = tad.getExpected();
		Throwable actual = tad.getActual();
		assertNull(actual);
		assertEquals(IllegalArgumentException.class, expected.getThrowableClass());
		assertEquals("bad exeception message\n\r123", expected.getMessage());
		
		I_Tests4J_ResultMessages messges = Tests4J_EnglishConstants.ENGLISH.getResultMessages();
		
		assertEquals(messges.getNothingWasThrown(), tad.getFailureReason());
		assertEquals(1, tad.getFailureThrowable());
	}
	
	@SuppressWarnings("boxing")
  @Test
	public void test05_EvaluatePass() {
		final IllegalArgumentException iae = new IllegalArgumentException("expected exception messsage");
		ExpectedThrowable etd = new ExpectedThrowable(iae);
		final UniformThrownAssertCommand utac = new UniformThrownAssertCommand(
		    Tests4J_EnglishConstants.ENGLISH, "failure message", etd,
		    new UniformThrownAssertionEvaluator(Tests4J_EnglishConstants.ENGLISH));
		assertEquals("failure message", utac.getFailureMessage());
	
		assertThrown(new ExpectedThrowable(NullPointerException.class),
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
		I_ThrownAssertionData data = eval.getData();
		assertNotNull(data);
		assertNull(data.getFailureReason());
		assertEquals(0, data.getFailureThrowable());
		Throwable actual = data.getActual();
		assertNotNull(actual);
		assertEquals(IllegalArgumentException.class.getName(), actual.getClass().getName());
		assertSame(etd, data.getExpected());
		assertSame(data, utac.getData());
		
		
	}
	
	@SuppressWarnings("boxing")
  @Test
	public void test06_GettersAfterEvaluateFailClassMismatch() {
		final IllegalStateException iae = new IllegalStateException("expected exception messsage\n"
				+ "123");
		ExpectedThrowable etd = new ExpectedThrowable(new IllegalArgumentException("expected exeception message\n\r"
				+ "123"));
		UniformThrownAssertCommand utac = new UniformThrownAssertCommand
				(Tests4J_EnglishConstants.ENGLISH, "failure message",  etd, 
				    new UniformThrownAssertionEvaluator(Tests4J_EnglishConstants.ENGLISH));
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
		
		I_ExpectedThrowable expected = tad.getExpected();
		Throwable actual = tad.getActual();
		assertEquals(IllegalStateException.class, actual.getClass());
		assertEquals("expected exception messsage\n123", actual.getMessage());
		assertEquals(IllegalArgumentException.class, expected.getThrowableClass());
		assertEquals("expected exeception message\n\r123", expected.getMessage());
		
		I_Tests4J_ResultMessages messges = Tests4J_EnglishConstants.ENGLISH.getResultMessages();
		
		assertEquals(messges.getThrowableClassMismatch(), tad.getFailureReason());
		assertEquals(1, tad.getFailureThrowable());
	}
	
	
	@SuppressWarnings("boxing")
  @Test
	public void test07_GettersAfterEvaluateFailTextNotUniform() {
		final IllegalArgumentException iae = new IllegalArgumentException("expected exception messsage\n"
				+ "123");
		ExpectedThrowable etd = new ExpectedThrowable(new IllegalArgumentException("bad exeception message\n\r"
				+ "123"));
		UniformThrownAssertCommand utac = new UniformThrownAssertCommand
				(Tests4J_EnglishConstants.ENGLISH, "failure message",  etd, 
				    new UniformThrownAssertionEvaluator(Tests4J_EnglishConstants.ENGLISH));
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
		
		I_ExpectedThrowable expected = tad.getExpected();
		Throwable actual = tad.getActual();
		assertEquals(IllegalArgumentException.class, actual.getClass());
		assertEquals("expected exception messsage\n123", actual.getMessage());
		assertEquals(IllegalArgumentException.class, expected.getThrowableClass());
		assertEquals("bad exeception message\n\r123", expected.getMessage());
		
		I_Tests4J_ResultMessages messges = Tests4J_EnglishConstants.ENGLISH.getResultMessages();
		
		assertEquals(messges.getThrowableMessageNotUniform(), tad.getFailureReason());
		assertEquals(1, tad.getFailureThrowable());
	}



	@SuppressWarnings("boxing")
  @Test
	public void test08_GettersAfterEvaluateFailClassMismatchDeep() {
		final IllegalArgumentException iae = new IllegalArgumentException("message");
		iae.initCause(new NullPointerException());
		ExpectedThrowable etd = new ExpectedThrowable(new IllegalArgumentException("message"),
				new ExpectedThrowable(IllegalStateException.class));
		UniformThrownAssertCommand utac = new UniformThrownAssertCommand
				(Tests4J_EnglishConstants.ENGLISH, "failure message",  etd,
				    new UniformThrownAssertionEvaluator(Tests4J_EnglishConstants.ENGLISH));
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
		etd = new ExpectedThrowable(new IllegalArgumentException("message"),
				new ExpectedThrowable(IllegalStateException.class,
				new ExpectedThrowable(IllegalArgumentException.class)));
		utac = new UniformThrownAssertCommand
				(Tests4J_EnglishConstants.ENGLISH, "failure message",  etd, 
				    new UniformThrownAssertionEvaluator(Tests4J_EnglishConstants.ENGLISH));
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
	
	@SuppressWarnings("boxing")
  @Test
	public void test09_GettersAfterEvaluateFailTextNotUniformDeep() {
		final IllegalArgumentException iae = new IllegalArgumentException("message");
		iae.initCause(new NullPointerException("npe\n2"));
		ExpectedThrowable etd = new ExpectedThrowable(new IllegalArgumentException("message"),
				new ExpectedThrowable(new NullPointerException("npe\n1")));
		UniformThrownAssertCommand utac = new UniformThrownAssertCommand
				(Tests4J_EnglishConstants.ENGLISH,  "failure message",  etd,
				    new UniformThrownAssertionEvaluator(Tests4J_EnglishConstants.ENGLISH));
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
		etd = new ExpectedThrowable(new IllegalArgumentException("message"),
				new ExpectedThrowable(new IllegalStateException("state message"),
				new ExpectedThrowable(new NullPointerException("npe"))));
		utac = new UniformThrownAssertCommand
				(Tests4J_EnglishConstants.ENGLISH, "failure message",  etd, 
				    new UniformThrownAssertionEvaluator(Tests4J_EnglishConstants.ENGLISH));
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
	public int getTests(I_CountType type) {
		return super.getTests(type, 9, true);
	}

	@Override
	public int getAsserts(I_CountType type) {
		int thisAsserts = 82;
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
		int thisUniqueAsserts = 64;
		if (type.isFromMetaWithCoverage()) {
			return super.getUniqueAsserts(type, thisUniqueAsserts + 3);
		}  else {
			return super.getAsserts(type, thisUniqueAsserts);
		}
	}
}
