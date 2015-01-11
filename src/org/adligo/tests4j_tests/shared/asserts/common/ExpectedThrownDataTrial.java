package org.adligo.tests4j_tests.shared.asserts.common;

import org.adligo.tests4j.shared.asserts.common.ExpectedThrownData;
import org.adligo.tests4j.shared.asserts.common.I_ExpectedThrownData;
import org.adligo.tests4j.shared.asserts.common.I_Thrower;
import org.adligo.tests4j.shared.asserts.common.MatchType;
import org.adligo.tests4j.shared.asserts.reference.AllowedReferences;
import org.adligo.tests4j.shared.en.Tests4J_EnglishConstants;
import org.adligo.tests4j.shared.i18n.I_Tests4J_AssertionInputMessages;
import org.adligo.tests4j.system.shared.trials.SourceFileScope;
import org.adligo.tests4j.system.shared.trials.Test;
import org.adligo.tests4j_tests.base_trials.I_CountType;
import org.adligo.tests4j_tests.base_trials.SourceFileCountingTrial;
import org.adligo.tests4j_tests.references_groups.Tests4J_AssertsCommon_GwtReferenceGroup;
import org.adligo.tests4j_tests.references_groups.Tests4J_AssertsCommon_ReferenceGroup;

@SourceFileScope (sourceClass=ExpectedThrownData.class, minCoverage=70.0)
@AllowedReferences (groups=Tests4J_AssertsCommon_GwtReferenceGroup.class)
public class ExpectedThrownDataTrial extends SourceFileCountingTrial {

  @SuppressWarnings("unused")
	@Test
	public void testConstructorExceptions() {
     I_Tests4J_AssertionInputMessages messages = Tests4J_EnglishConstants.ENGLISH.getAssertionInputMessages();
     
		assertThrown(new ExpectedThrownData(new IllegalArgumentException(
				"ExpectedThrownData requires a non null throwable class.")), 
			new I_Thrower() {
				@Override
				public void run() {
					new ExpectedThrownData((Throwable) null);
				}
		});
		assertThrown(new ExpectedThrownData(NullPointerException.class), 
			new I_Thrower() {
				
        @Override
				public void run() {
					new ExpectedThrownData(new IllegalArgumentException("thisTestRocks"), (I_ExpectedThrownData) null);
				}
		});
		assertThrown(new ExpectedThrownData(new IllegalArgumentException(
				"ExpectedThrownData requires a non null throwable class.")),  
			new I_Thrower() {
				@Override
				public void run() {
					new ExpectedThrownData((Class<? extends Throwable>) null);
				}
		});
		assertThrown(new ExpectedThrownData(NullPointerException.class), 
				new I_Thrower() {
					@Override
					public void run() {
						new ExpectedThrownData(IllegalArgumentException.class, (I_ExpectedThrownData) null);
					}
			});
		assertThrown(new ExpectedThrownData(new IllegalArgumentException(
        messages.getExpectedThrownDataWithEqualsOrContainMatchTypesRequireAMessage())), 
        new I_Thrower() {
          @Override
          public void run() {
            new ExpectedThrownData(NullPointerException.class, MatchType.EQUALS);
          }
      });
		assertThrown(new ExpectedThrownData(new IllegalArgumentException(
        messages.getExpectedThrownDataWithEqualsOrContainMatchTypesRequireAMessage())), 
        new I_Thrower() {
          @Override
          public void run() {
            new ExpectedThrownData(new NullPointerException(null), MatchType.EQUALS);
          }
      });
		assertThrown(new ExpectedThrownData(new IllegalArgumentException(
        messages.getExpectedThrownDataWithEqualsOrContainMatchTypesRequireAMessage())), 
        new I_Thrower() {
          @Override
          public void run() {
            new ExpectedThrownData(NullPointerException.class, MatchType.CONTAINS);
          }
      });
		assertThrown(new ExpectedThrownData(new IllegalArgumentException(
		    messages.getExpectedThrownDataWithEqualsOrContainMatchTypesRequireAMessage())), 
        new I_Thrower() {
          @Override
          public void run() {
            new ExpectedThrownData(new NullPointerException(null), MatchType.CONTAINS);
          }
      });
		assertThrown(new ExpectedThrownData(NullPointerException.class), 
			new I_Thrower() {
				@Override
				public void run() {
					new ExpectedThrownData((I_ExpectedThrownData) null);
				}
		});
	
	}
	
	@Test
	public void testConstructorAndGets() {
		//test pass through
		ExpectedThrownData obj = new ExpectedThrownData(
				new ExpectedThrownData(new IllegalStateException("Some error message.")));
		assertEquals(IllegalStateException.class, obj.getThrowableClass());
		assertEquals("Some error message.", obj.getMessage());
		assertSame(MatchType.EQUALS, obj.getMatchType());
		
		obj = new ExpectedThrownData(
				new ExpectedThrownData(NullPointerException.class));
		assertEquals(NullPointerException.class, obj.getThrowableClass());
		
		obj = new ExpectedThrownData(new IllegalStateException("Some error message."),
				new ExpectedThrownData(NullPointerException.class));
		assertEquals(IllegalStateException.class, obj.getThrowableClass());
		assertEquals("Some error message.", obj.getMessage());
		assertSame(MatchType.EQUALS, obj.getMatchType());
    
		
		I_ExpectedThrownData expCause = obj.getExpectedCause();
		assertNotNull(expCause);
		assertEquals(NullPointerException.class, expCause.getThrowableClass());
		assertSame(MatchType.ANY, expCause.getMatchType());
    
		
		obj = new ExpectedThrownData(NullPointerException.class,
				new ExpectedThrownData(new IllegalStateException("Some error message."), MatchType.CONTAINS));
		assertEquals(NullPointerException.class, obj.getThrowableClass());
		expCause = obj.getExpectedCause();
		assertSame(MatchType.ANY, obj.getMatchType());
		
		assertNotNull(expCause);
		assertEquals(IllegalStateException.class, expCause.getThrowableClass());
		assertEquals("Some error message.", expCause.getMessage());
		assertSame(MatchType.CONTAINS, expCause.getMatchType());
		
		obj = new ExpectedThrownData(NullPointerException.class, MatchType.NULL,
				new ExpectedThrownData(new IllegalStateException("Some error message.")));
		assertEquals(NullPointerException.class, obj.getThrowableClass());
		expCause = obj.getExpectedCause();
		assertSame(MatchType.NULL, obj.getMatchType());
		
		assertNotNull(expCause);
		assertEquals(IllegalStateException.class, expCause.getThrowableClass());
		assertEquals("Some error message.", expCause.getMessage());
		assertSame(MatchType.EQUALS, expCause.getMatchType());
		
		ExpectedThrownData threePete = new ExpectedThrownData(RuntimeException.class, MatchType.NULL,
				new ExpectedThrownData(NullPointerException.class,
				new ExpectedThrownData(new IllegalStateException("Some error message."))));
		assertEquals(RuntimeException.class, threePete.getThrowableClass());
		assertEquals(MatchType.NULL, threePete.getMatchType());
		
		expCause = threePete.getExpectedCause();
		assertNotNull(expCause);
		assertEquals(NullPointerException.class, expCause.getThrowableClass());
		assertEquals(MatchType.ANY, expCause.getMatchType());
		
		expCause = expCause.getExpectedCause();
		assertNotNull(expCause);
		assertEquals(IllegalStateException.class, expCause.getThrowableClass());
		assertEquals("Some error message.", expCause.getMessage());
		assertEquals(MatchType.EQUALS, expCause.getMatchType());
	}
	
	@SuppressWarnings("boxing")
  @Test
	public void testEqualsHashCode() {
		ExpectedThrownData a = new ExpectedThrownData(
				new ExpectedThrownData(new IllegalStateException("Some error message.")));
		ExpectedThrownData b = new ExpectedThrownData(new IllegalStateException("Some error message2."));
		ExpectedThrownData c = new ExpectedThrownData(new IllegalStateException("Some error message."));
		ExpectedThrownData d = new ExpectedThrownData(new IllegalArgumentException("Some error message."));
		ExpectedThrownData e = new ExpectedThrownData(new IllegalArgumentException("Some error message2."));
		ExpectedThrownData f = new ExpectedThrownData(new IllegalStateException("Some error message."),
				new ExpectedThrownData(NullPointerException.class));
		ExpectedThrownData g = new ExpectedThrownData(new IllegalArgumentException("Some error message."),
				new ExpectedThrownData(IllegalArgumentException.class));
		ExpectedThrownData h = new ExpectedThrownData(new IllegalStateException("Some error message."),
				new ExpectedThrownData(new IllegalArgumentException("iae")));
		ExpectedThrownData i = new ExpectedThrownData(new IllegalArgumentException("Some error message."),
				new ExpectedThrownData(new IllegalArgumentException("iae2")));
		ExpectedThrownData j = new ExpectedThrownData(
        new ExpectedThrownData(IllegalStateException.class));
		ExpectedThrownData k = new ExpectedThrownData(
        new ExpectedThrownData(new IllegalStateException("Some error message."), MatchType.CONTAINS));
		ExpectedThrownData l = new ExpectedThrownData(
        new ExpectedThrownData(new IllegalStateException("Some error message."), MatchType.NULL));
		
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
    
    assertNotEquals(a,k);
    assertNotEquals(a.hashCode(), k.hashCode());
    
    assertNotEquals(a, l);
    assertNotEquals(a.hashCode(), l.hashCode());
	}
	
	@Override
	public int getTests(I_CountType type) {
		return super.getTests(type, 3, true);
	}

	@Override
	public int getAsserts(I_CountType type) {
		int asserts = 64;
		if (type.isFromMetaWithCoverage()) {
			//code coverage and circular dependencies
			return super.getAsserts(type,asserts + 3);
		} else {
			return super.getAsserts(type, asserts);
		}
	}

	@Override
	public int getUniqueAsserts(I_CountType type) {
		int uasserts = 35;
		if (type.isFromMetaWithCoverage()) {
			return super.getUniqueAsserts(type, uasserts + 3);
		} else {
			return super.getUniqueAsserts(type, uasserts);
		}
	}
}
