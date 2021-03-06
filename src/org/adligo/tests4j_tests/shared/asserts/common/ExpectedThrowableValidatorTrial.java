package org.adligo.tests4j_tests.shared.asserts.common;

import org.adligo.tests4j.shared.asserts.common.ExpectedThrowable;
import org.adligo.tests4j.shared.asserts.common.ExpectedThrowableValidator;
import org.adligo.tests4j.shared.asserts.common.I_ExpectedThrowable;
import org.adligo.tests4j.shared.asserts.common.I_Thrower;
import org.adligo.tests4j.shared.asserts.common.MatchType;
import org.adligo.tests4j.shared.asserts.reference.AllowedReferences;
import org.adligo.tests4j.shared.en.Tests4J_EnglishConstants;
import org.adligo.tests4j.shared.i18n.I_Tests4J_AssertionInputMessages;
import org.adligo.tests4j.shared.i18n.I_Tests4J_Constants;
import org.adligo.tests4j.system.shared.trials.SourceFileScope;
import org.adligo.tests4j.system.shared.trials.Test;
import org.adligo.tests4j_tests.base_trials.I_CountType;
import org.adligo.tests4j_tests.base_trials.SourceFileCountingTrial;
import org.adligo.tests4j_tests.references_groups.Tests4J_AssertsCommon_GwtReferenceGroup;

@SourceFileScope (sourceClass=ExpectedThrowableValidator.class, minCoverage=54.0)
@AllowedReferences (groups=Tests4J_AssertsCommon_GwtReferenceGroup.class)
public class ExpectedThrowableValidatorTrial extends SourceFileCountingTrial {

  @SuppressWarnings("unused")
	@Test
	public void testConstructorExceptions() {
     I_Tests4J_AssertionInputMessages messages = Tests4J_EnglishConstants.ENGLISH.getAssertionInputMessages();
    
     assertThrown(new ExpectedThrowable(NullPointerException.class), 
       new I_Thrower() {
         @Override
         public void run() {
           new ExpectedThrowableValidator((I_Tests4J_Constants) null,(Throwable) null);
         }
     });
		assertThrown(new ExpectedThrowable(new IllegalArgumentException(
				"ExpectedThrownData requires a non null throwable class.")), 
			new I_Thrower() {
				@Override
				public void run() {
					new ExpectedThrowableValidator(Tests4J_EnglishConstants.ENGLISH, (Throwable) null);
				}
		});
		assertThrown(new ExpectedThrowable(NullPointerException.class), 
	      new I_Thrower() {
	        
	        @Override
	        public void run() {
	          new ExpectedThrowableValidator(null, 
	              new IllegalArgumentException("thisTestRocks"), (I_ExpectedThrowable) null);
	        }
	    });
		assertThrown(new ExpectedThrowable(NullPointerException.class), 
			new I_Thrower() {
				
        @Override
				public void run() {
					new ExpectedThrowableValidator(
					    Tests4J_EnglishConstants.ENGLISH, new IllegalArgumentException("thisTestRocks"),
					    (I_ExpectedThrowable) null);
				}
		});
		assertThrown(new ExpectedThrowable(NullPointerException.class),  
			new I_Thrower() {
				@Override
				public void run() {
					new ExpectedThrowableValidator(null, (Class<? extends Throwable>) null);
				}
		});
		assertThrown(new ExpectedThrowable(new IllegalArgumentException(
        "ExpectedThrownData requires a non null throwable class.")),  
      new I_Thrower() {
        @Override
        public void run() {
          new ExpectedThrowableValidator(Tests4J_EnglishConstants.ENGLISH,
              (Class<? extends Throwable>) null);
        }
    });

		assertThrown(new ExpectedThrowable(NullPointerException.class), 
        new I_Thrower() {
          @Override
          public void run() {
            new ExpectedThrowableValidator(null, NullPointerException.class, MatchType.EQUALS);
          }
      });
		assertThrown(new ExpectedThrowable(new IllegalArgumentException(
        messages.getExpectedThrownDataWithEqualsOrContainMatchTypesRequireAMessage())), 
        new I_Thrower() {
          @Override
          public void run() {
            new ExpectedThrowableValidator(Tests4J_EnglishConstants.ENGLISH, 
                NullPointerException.class, MatchType.EQUALS);
          }
      });

		assertThrown(new ExpectedThrowable(NullPointerException.class), 
        new I_Thrower() {
          @Override
          public void run() {
            new ExpectedThrowableValidator(null, NullPointerException.class, MatchType.CONTAINS);
          }
      });
		assertThrown(new ExpectedThrowable(new IllegalArgumentException(
        messages.getExpectedThrownDataWithEqualsOrContainMatchTypesRequireAMessage())), 
        new I_Thrower() {
          @Override
          public void run() {
            new ExpectedThrowableValidator(Tests4J_EnglishConstants.ENGLISH, 
                NullPointerException.class, MatchType.CONTAINS);
          }
      });

		assertThrown(new ExpectedThrowable(NullPointerException.class), 
	      new I_Thrower() {
	        @Override
	        public void run() {
	          new ExpectedThrowableValidator(null, (I_ExpectedThrowable) null);
	        }
	    });
		assertThrown(new ExpectedThrowable(NullPointerException.class), 
			new I_Thrower() {
				@Override
				public void run() {
					new ExpectedThrowableValidator(Tests4J_EnglishConstants.ENGLISH, 
					    (I_ExpectedThrowable) null);
				}
		});
	
	}
	
  
	@Test
	public void testConstructorAndGets() {
		//test pass through
	  ExpectedThrowableValidator obj = new ExpectedThrowableValidator(Tests4J_EnglishConstants.ENGLISH,
				new ExpectedThrowableValidator(Tests4J_EnglishConstants.ENGLISH, 
				    new IllegalStateException("Some error message.")));
		assertEquals(IllegalStateException.class, obj.getThrowableClass());
		assertEquals("Some error message.", obj.getMessage());
		assertSame(MatchType.EQUALS, obj.getMatchType());
		
		obj = new ExpectedThrowableValidator(Tests4J_EnglishConstants.ENGLISH,
				new ExpectedThrowableValidator(Tests4J_EnglishConstants.ENGLISH, NullPointerException.class));
		assertEquals(NullPointerException.class, obj.getThrowableClass());
		
		obj = new ExpectedThrowableValidator(Tests4J_EnglishConstants.ENGLISH,
		    new IllegalStateException("Some error message."),
				new ExpectedThrowableValidator(Tests4J_EnglishConstants.ENGLISH, NullPointerException.class));
		assertEquals(IllegalStateException.class, obj.getThrowableClass());
		assertEquals("Some error message.", obj.getMessage());
		assertSame(MatchType.EQUALS, obj.getMatchType());
    
		
		I_ExpectedThrowable expCause = obj.getExpectedCause();
		assertNotNull(expCause);
		assertEquals(NullPointerException.class, expCause.getThrowableClass());
		assertSame(MatchType.ANY, expCause.getMatchType());
    
		obj = new ExpectedThrowableValidator(Tests4J_EnglishConstants.ENGLISH, 
		    NullPointerException.class, MatchType.NULL,
				new ExpectedThrowableValidator(Tests4J_EnglishConstants.ENGLISH, 
				    new IllegalStateException("Some error message.")));
		assertEquals(NullPointerException.class, obj.getThrowableClass());
		expCause = obj.getExpectedCause();
		assertSame(MatchType.NULL, obj.getMatchType());
		
		assertNotNull(expCause);
		assertEquals(IllegalStateException.class, expCause.getThrowableClass());
		assertEquals("Some error message.", expCause.getMessage());
		assertSame(MatchType.EQUALS, expCause.getMatchType());
		
	}
	
	@Test
  public void testConstructorCopiesAndGets() {
	  ExpectedThrowableValidator obj = new ExpectedThrowableValidator(Tests4J_EnglishConstants.ENGLISH,
        new ExpectedThrowableValidator(Tests4J_EnglishConstants.ENGLISH, 
            new IllegalStateException("Some error message.")));
	  
	  ExpectedThrowableValidator obj2 = new ExpectedThrowableValidator(Tests4J_EnglishConstants.ENGLISH,
        obj);
    assertSame(IllegalStateException.class, obj2.getThrowableClass());
    assertEquals("Some error message.", obj2.getMessage());
    assertSame(MatchType.EQUALS, obj2.getMatchType());
    assertNull(obj2.getExpectedCause());
    
    //test pass through
    obj = new ExpectedThrowableValidator(Tests4J_EnglishConstants.ENGLISH,
        new ExpectedThrowableValidator(Tests4J_EnglishConstants.ENGLISH, 
            new IllegalStateException("Some error message."),
            new ExpectedThrowableValidator(Tests4J_EnglishConstants.ENGLISH, 
                new NullPointerException("Somes null."), MatchType.CONTAINS)));
    
    obj2 = new ExpectedThrowableValidator(Tests4J_EnglishConstants.ENGLISH,
        obj);
    assertSame(IllegalStateException.class, obj2.getThrowableClass());
    assertEquals("Some error message.", obj2.getMessage());
    assertSame(MatchType.EQUALS, obj2.getMatchType());
    
    I_ExpectedThrowable cause = obj2.getExpectedCause();
    assertNotNull(cause);
    assertSame(NullPointerException.class, cause.getThrowableClass());
    assertEquals("Somes null.", cause.getMessage());
    assertSame(MatchType.CONTAINS, cause.getMatchType());
    
	}
	@SuppressWarnings("boxing")
  @Test
	public void testEqualsHashCode() {
	  ExpectedThrowableValidator a = new ExpectedThrowableValidator(Tests4J_EnglishConstants.ENGLISH, 
				new ExpectedThrowableValidator(
				    Tests4J_EnglishConstants.ENGLISH, new IllegalStateException("Some error message.")));
	  ExpectedThrowableValidator b = new ExpectedThrowableValidator(
	      Tests4J_EnglishConstants.ENGLISH, new IllegalStateException("Some error message2."));
	  ExpectedThrowableValidator c = new ExpectedThrowableValidator(
	      Tests4J_EnglishConstants.ENGLISH, new IllegalStateException("Some error message."));
	  ExpectedThrowableValidator d = new ExpectedThrowableValidator(
	      Tests4J_EnglishConstants.ENGLISH, new IllegalArgumentException("Some error message."));
	  ExpectedThrowableValidator e = new ExpectedThrowableValidator(
	      Tests4J_EnglishConstants.ENGLISH, new IllegalArgumentException("Some error message2."));
	  ExpectedThrowableValidator f = new ExpectedThrowableValidator(
	      Tests4J_EnglishConstants.ENGLISH, new IllegalStateException("Some error message."),
				new ExpectedThrowableValidator(Tests4J_EnglishConstants.ENGLISH, NullPointerException.class));
	  ExpectedThrowableValidator g = new ExpectedThrowableValidator(
	      Tests4J_EnglishConstants.ENGLISH, new IllegalArgumentException("Some error message."),
				new ExpectedThrowableValidator(
				    Tests4J_EnglishConstants.ENGLISH, IllegalArgumentException.class));
	  ExpectedThrowableValidator h = new ExpectedThrowableValidator(
	      Tests4J_EnglishConstants.ENGLISH, new IllegalStateException("Some error message."),
				new ExpectedThrowableValidator(
				    Tests4J_EnglishConstants.ENGLISH, new IllegalArgumentException("iae")));
	  ExpectedThrowableValidator i = new ExpectedThrowableValidator(
	      Tests4J_EnglishConstants.ENGLISH, new IllegalArgumentException("Some error message."),
				new ExpectedThrowableValidator(
				    Tests4J_EnglishConstants.ENGLISH, new IllegalArgumentException("iae2")));
	  ExpectedThrowableValidator j = new ExpectedThrowableValidator(Tests4J_EnglishConstants.ENGLISH, 
        new ExpectedThrowableValidator(Tests4J_EnglishConstants.ENGLISH, IllegalStateException.class));

		assertEquals(a, a);
		assertEquals(a.hashCode(), a.hashCode());
		
		assertNotEquals(a, b);
		assertNotEquals(a.hashCode(), b.hashCode());
		
		assertEquals(a,  c);
		assertEquals(a.hashCode(), c.hashCode());
		
		assertNotEquals(a, d);
		assertNotEquals(a.hashCode(), d.hashCode());
		
		assertNotEquals(a, e);
		assertNotEquals(a.hashCode(), e.hashCode());
		
		assertNotEquals(a, f);
		assertNotEquals(a.hashCode(), f.hashCode());
		
		assertNotEquals(a, g);
		assertNotEquals(a.hashCode(), g.hashCode());
		
		assertNotEquals(a, h);
		assertNotEquals(a.hashCode(), h.hashCode());
		
		assertNotEquals(a, i);
		assertNotEquals(a.hashCode(), i.hashCode());
		
		assertNotEquals(a, j);
    assertNotEquals(a.hashCode(), j.hashCode());
    
	}
	
	@Override
	public int getTests(I_CountType type) {
		return super.getTests(type, 4, true);
	}

	@Override
	public int getAsserts(I_CountType type) {
		int asserts = 59;
		if (type.isFromMetaWithCoverage()) {
			//code coverage and circular dependencies
			return super.getAsserts(type,asserts + 3);
		} else {
			return super.getAsserts(type, asserts);
		}
	}

	@Override
	public int getUniqueAsserts(I_CountType type) {
		int uasserts = 37;
		if (type.isFromMetaWithCoverage()) {
			return super.getUniqueAsserts(type, uasserts + 3);
		} else {
			return super.getUniqueAsserts(type, uasserts);
		}
	}
}
