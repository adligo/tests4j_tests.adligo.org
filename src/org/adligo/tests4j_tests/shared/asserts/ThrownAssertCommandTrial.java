package org.adligo.tests4j_tests.shared.asserts;

import org.adligo.tests4j.shared.asserts.ThrownAssertCommand;
import org.adligo.tests4j.shared.asserts.common.AssertType;
import org.adligo.tests4j.shared.asserts.common.ExpectedThrowable;
import org.adligo.tests4j.shared.asserts.common.I_AssertionData;
import org.adligo.tests4j.shared.asserts.common.I_ExpectedThrowable;
import org.adligo.tests4j.shared.asserts.common.I_Thrower;
import org.adligo.tests4j.shared.asserts.common.MatchType;
import org.adligo.tests4j.shared.asserts.common.ThrownAssertionData;
import org.adligo.tests4j.shared.asserts.reference.AllowedReferences;
import org.adligo.tests4j.shared.en.Tests4J_EnglishConstants;
import org.adligo.tests4j.shared.i18n.I_Tests4J_AssertionInputMessages;
import org.adligo.tests4j.shared.i18n.I_Tests4J_ResultMessages;
import org.adligo.tests4j.system.shared.trials.SourceFileScope;
import org.adligo.tests4j.system.shared.trials.Test;
import org.adligo.tests4j_tests.base_trials.I_CountType;
import org.adligo.tests4j_tests.base_trials.SourceFileCountingTrial;
import org.adligo.tests4j_tests.references_groups.Tests4J_Asserts_GwtReferenceGroup;

@SourceFileScope (sourceClass=ThrownAssertCommand.class, minCoverage=73.0)
@AllowedReferences (groups=Tests4J_Asserts_GwtReferenceGroup.class)
public class ThrownAssertCommandTrial extends SourceFileCountingTrial {


  @SuppressWarnings("unused")
	@Test
	public void testConstructorExceptions() {
		I_Tests4J_AssertionInputMessages messages =  Tests4J_EnglishConstants.ENGLISH.getAssertionInputMessages();
		assertThrown(new ExpectedThrowable(new IllegalArgumentException(
				messages.getTheExpectedValueShouldNeverBeNull())), 
				new I_Thrower() {
					
					
          @Override
					public void run() {
						new ThrownAssertCommand(Tests4J_EnglishConstants.ENGLISH, "failure message", null);
					}
				});
	}
	
	@SuppressWarnings("boxing")
  @Test
	public void testEqualsHashCode() {
		ThrownAssertCommand a =
				new ThrownAssertCommand(Tests4J_EnglishConstants.ENGLISH, "failure message", 
				new ExpectedThrowable(new IllegalArgumentException("hey")));
		ThrownAssertCommand b =
				new ThrownAssertCommand(Tests4J_EnglishConstants.ENGLISH, "failure message", 
				new ExpectedThrowable(new IllegalArgumentException("hey2")));
		ThrownAssertCommand c =
				new ThrownAssertCommand(Tests4J_EnglishConstants.ENGLISH, "failure message", 
				new ExpectedThrowable(new IllegalArgumentException("hey")));
		ThrownAssertCommand d =
				new ThrownAssertCommand(Tests4J_EnglishConstants.ENGLISH, "failure message2", 
				new ExpectedThrowable(new IllegalArgumentException("hey")));
		ThrownAssertCommand e =
				new ThrownAssertCommand(Tests4J_EnglishConstants.ENGLISH, "failure message", 
				new ExpectedThrowable(new IllegalStateException("hey")));
		ThrownAssertCommand f =
        new ThrownAssertCommand(Tests4J_EnglishConstants.ENGLISH, "failure message", 
        new ExpectedThrowable(new IllegalArgumentException("hey"), MatchType.CONTAINS));
		
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
		
		//match type
		assertNotEquals(a, f);
    assertNotEquals(a.hashCode(), f.hashCode());
	}
	
	@SuppressWarnings("boxing")
  @Test
	public void testEvaluateSlashGetData() {
		ThrownAssertCommand a =
				new ThrownAssertCommand(Tests4J_EnglishConstants.ENGLISH, "failure message", 
						new ExpectedThrowable(new IllegalArgumentException("hey")));
		I_AssertionData data = a.getData();
		assertNotNull(data);
		assertTrue(data instanceof ThrownAssertionData);
		ThrownAssertionData tad = (ThrownAssertionData) data;
		I_ExpectedThrowable expected =  tad.getExpected();
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
	
	
	@SuppressWarnings("boxing")
  @Test
	public void testDeepEvaluateDefaults() {
		ThrownAssertCommand a =
				new ThrownAssertCommand(Tests4J_EnglishConstants.ENGLISH, "failure message", 
						new ExpectedThrowable(new IllegalArgumentException("hey"),
						new ExpectedThrowable(IllegalStateException.class,
						new ExpectedThrowable(new IllegalStateException("zzz")))));
		
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
		assertEquals(messages.getThrowableMessagesMismatch(), a.getFailureReason());
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
		assertEquals(messages.getThrowableMessagesMismatch(), a.getFailureReason());
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
		assertEquals(messages.getThrowableMessagesMismatch(), a.getFailureReason());
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
	
	@SuppressWarnings("boxing")
  @Test
  public void testDeepEvaluateAny() {
    ThrownAssertCommand a =
        new ThrownAssertCommand(Tests4J_EnglishConstants.ENGLISH, "failure message", 
            new ExpectedThrowable(IllegalArgumentException.class, MatchType.ANY,
            new ExpectedThrowable(IllegalStateException.class, MatchType.ANY,
            new ExpectedThrowable(IllegalArgumentException.class, MatchType.ANY))));
    
    assertFalse(a.evaluate(new I_Thrower() {
      
      @Override
      public void run() {
        throw new IllegalArgumentException("...");
      }
    }));
    I_Tests4J_ResultMessages messages =  Tests4J_EnglishConstants.ENGLISH.getResultMessages();

    assertEquals(messages.getThrowableClassMismatch(), a.getFailureReason());
    assertEquals(2, a.getFailureThrowable());
    
    assertFalse(a.evaluate(new I_Thrower() {
          
          @Override
          public void run() {
            IllegalArgumentException top = new IllegalArgumentException("...");
            IllegalStateException second = new IllegalStateException("...");
            top.initCause(second);
            throw top;
          }
        }));
    assertEquals(messages.getThrowableClassMismatch(), a.getFailureReason());
    assertEquals(3, a.getFailureThrowable());
    
    assertTrue(a.evaluate(new I_Thrower() {
      
      @Override
      public void run() {
        IllegalArgumentException top = new IllegalArgumentException("...");
        IllegalStateException second = new IllegalStateException("...");
        top.initCause(second);
        
        IllegalArgumentException third = new IllegalArgumentException("...");
        second.initCause(third);
        throw top;
      }
    }));
	}
	
	@SuppressWarnings("boxing")
  @Test
  public void testDeepEvaluateContains() {
    ThrownAssertCommand a =
        new ThrownAssertCommand(Tests4J_EnglishConstants.ENGLISH, "failure message", 
            new ExpectedThrowable(new IllegalArgumentException("hey"), MatchType.CONTAINS,
            new ExpectedThrowable(new IllegalStateException("hmm"),MatchType.CONTAINS,
            new ExpectedThrowable(new IllegalArgumentException("zzz"),MatchType.CONTAINS))));
    
    assertFalse(a.evaluate(new I_Thrower() {
      
      @Override
      public void run() {
        throw new IllegalStateException("aheya");
      }
    }));
    I_Tests4J_ResultMessages messages =  Tests4J_EnglishConstants.ENGLISH.getResultMessages();

    assertEquals(messages.getThrowableClassMismatch(), a.getFailureReason());
    assertEquals(1, a.getFailureThrowable());
    
    assertFalse(a.evaluate(new I_Thrower() {
      
      @Override
      public void run() {
        IllegalArgumentException top = new IllegalArgumentException("...");
        IllegalStateException second = new IllegalStateException("...");
        top.initCause(second);
        throw top;
      }
    }));
    assertEquals(messages.getThrowableMessagesMismatch(), a.getFailureReason());
    assertEquals(1, a.getFailureThrowable());
    
    assertTrue(a.evaluate(new I_Thrower() {
      
      @Override
      public void run() {
        IllegalArgumentException top = new IllegalArgumentException("ahey.");
        IllegalStateException second = new IllegalStateException("ahmma");
        top.initCause(second);
        
        IllegalArgumentException third = new IllegalArgumentException("azzz");
        second.initCause(third);
        throw top;
      }
    }));

  }
	
	@Override
	public int getTests(I_CountType type) {
		return super.getTests(type, 6, true);
	}

	@Override
	public int getAsserts(I_CountType type) {
		int thisAsserts = 73;
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
		int thisUniqueAsserts = 36;
		if (type.isFromMetaWithCoverage()) {
			//code coverage and circular dependencies +
			//custom afterTrialTests
			return super.getUniqueAsserts(type, thisUniqueAsserts + 3);
		}  else {
			return super.getAsserts(type, thisUniqueAsserts);
		}
	}

}
