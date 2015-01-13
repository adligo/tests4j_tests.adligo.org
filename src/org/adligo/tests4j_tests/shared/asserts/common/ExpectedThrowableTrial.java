package org.adligo.tests4j_tests.shared.asserts.common;

import org.adligo.tests4j.shared.asserts.common.ExpectedThrowable;
import org.adligo.tests4j.shared.asserts.common.I_ExpectedThrowable;
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

@SourceFileScope (sourceClass=ExpectedThrowable.class, minCoverage=70.0)
@AllowedReferences (groups=Tests4J_AssertsCommon_GwtReferenceGroup.class)
public class ExpectedThrowableTrial extends SourceFileCountingTrial {

	@Test
	public void testConstructorAndGets() {
		//test pass through
		ExpectedThrowable obj = new ExpectedThrowable(
				new ExpectedThrowable(new IllegalStateException("Some error message.")));
		assertEquals(IllegalStateException.class, obj.getThrowableClass());
		assertEquals("Some error message.", obj.getMessage());
		assertSame(MatchType.EQUALS, obj.getMatchType());
		
		obj = new ExpectedThrowable(
				new ExpectedThrowable(NullPointerException.class));
		assertEquals(NullPointerException.class, obj.getThrowableClass());
		
		obj = new ExpectedThrowable(new IllegalStateException("Some error message."),
				new ExpectedThrowable(NullPointerException.class));
		assertEquals(IllegalStateException.class, obj.getThrowableClass());
		assertEquals("Some error message.", obj.getMessage());
		assertSame(MatchType.EQUALS, obj.getMatchType());
    
		
		I_ExpectedThrowable expCause = obj.getExpectedCause();
		assertNotNull(expCause);
		assertEquals(NullPointerException.class, expCause.getThrowableClass());
		assertSame(MatchType.ANY, expCause.getMatchType());
    
		
		obj = new ExpectedThrowable(NullPointerException.class,
				new ExpectedThrowable(new IllegalStateException("Some error message."), MatchType.CONTAINS));
		assertEquals(NullPointerException.class, obj.getThrowableClass());
		expCause = obj.getExpectedCause();
		assertSame(MatchType.ANY, obj.getMatchType());
		
		assertNotNull(expCause);
		assertEquals(IllegalStateException.class, expCause.getThrowableClass());
		assertEquals("Some error message.", expCause.getMessage());
		assertSame(MatchType.CONTAINS, expCause.getMatchType());
		
		obj = new ExpectedThrowable(NullPointerException.class, MatchType.NULL,
				new ExpectedThrowable(new IllegalStateException("Some error message.")));
		assertEquals(NullPointerException.class, obj.getThrowableClass());
		expCause = obj.getExpectedCause();
		assertSame(MatchType.NULL, obj.getMatchType());
		
		assertNotNull(expCause);
		assertEquals(IllegalStateException.class, expCause.getThrowableClass());
		assertEquals("Some error message.", expCause.getMessage());
		assertSame(MatchType.EQUALS, expCause.getMatchType());
		
		ExpectedThrowable threePete = new ExpectedThrowable(RuntimeException.class, MatchType.NULL,
				new ExpectedThrowable(NullPointerException.class,
				new ExpectedThrowable(new IllegalStateException("Some error message."))));
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
		ExpectedThrowable a = new ExpectedThrowable(
				new ExpectedThrowable(new IllegalStateException("Some error message.")));
		ExpectedThrowable b = new ExpectedThrowable(new IllegalStateException("Some error message2."));
		ExpectedThrowable c = new ExpectedThrowable(new IllegalStateException("Some error message."));
		ExpectedThrowable d = new ExpectedThrowable(new IllegalArgumentException("Some error message."));
		ExpectedThrowable e = new ExpectedThrowable(new IllegalArgumentException("Some error message2."));
		ExpectedThrowable f = new ExpectedThrowable(new IllegalStateException("Some error message."),
				new ExpectedThrowable(NullPointerException.class));
		ExpectedThrowable g = new ExpectedThrowable(new IllegalArgumentException("Some error message."),
				new ExpectedThrowable(IllegalArgumentException.class));
		ExpectedThrowable h = new ExpectedThrowable(new IllegalStateException("Some error message."),
				new ExpectedThrowable(new IllegalArgumentException("iae")));
		ExpectedThrowable i = new ExpectedThrowable(new IllegalArgumentException("Some error message."),
				new ExpectedThrowable(new IllegalArgumentException("iae2")));
		ExpectedThrowable j = new ExpectedThrowable(
        new ExpectedThrowable(IllegalStateException.class));
		ExpectedThrowable k = new ExpectedThrowable(
        new ExpectedThrowable(new IllegalStateException("Some error message."), MatchType.CONTAINS));
		ExpectedThrowable l = new ExpectedThrowable(
        new ExpectedThrowable(new IllegalStateException("Some error message."), MatchType.NULL));
		
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
		return super.getTests(type, 2, true);
	}

	@Override
	public int getAsserts(I_CountType type) {
		int asserts = 55;
		if (type.isFromMetaWithCoverage()) {
			//code coverage and circular dependencies
			return super.getAsserts(type,asserts + 3);
		} else {
			return super.getAsserts(type, asserts);
		}
	}

	@Override
	public int getUniqueAsserts(I_CountType type) {
		int uasserts = 26;
		if (type.isFromMetaWithCoverage()) {
			return super.getUniqueAsserts(type, uasserts + 3);
		} else {
			return super.getUniqueAsserts(type, uasserts);
		}
	}
}
