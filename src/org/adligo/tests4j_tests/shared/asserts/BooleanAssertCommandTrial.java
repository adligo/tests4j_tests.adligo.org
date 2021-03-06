package org.adligo.tests4j_tests.shared.asserts;

import org.adligo.tests4j.shared.asserts.BooleanAssertCommand;
import org.adligo.tests4j.shared.asserts.common.AssertType;
import org.adligo.tests4j.shared.asserts.common.ExpectedThrowable;
import org.adligo.tests4j.shared.asserts.common.I_Thrower;
import org.adligo.tests4j.shared.asserts.reference.AllowedReferences;
import org.adligo.tests4j.system.shared.trials.SourceFileScope;
import org.adligo.tests4j.system.shared.trials.Test;
import org.adligo.tests4j_tests.base_trials.I_CountType;
import org.adligo.tests4j_tests.base_trials.SourceFileCountingTrial;
import org.adligo.tests4j_tests.references_groups.Tests4J_Asserts_GwtReferenceGroup;
import org.adligo.tests4j_tests.references_groups.Tests4J_Asserts_ReferenceGroup;
import org.adligo.tests4j_tests.shared.asserts.mocks.ExtendedAssertCommand;

@SourceFileScope (sourceClass=BooleanAssertCommand.class, minCoverage=60.0)
@AllowedReferences (groups=Tests4J_Asserts_GwtReferenceGroup.class)
public class BooleanAssertCommandTrial extends SourceFileCountingTrial {

	@Test
	public void testConstructorExceptions() {
		assertThrown(new ExpectedThrowable(new IllegalArgumentException(BooleanAssertCommand.BOOLEAN_ASSERT_COMMAND_REQUIRES_A_BOOLEAN_TYPE)),
				new I_Thrower() {
					
					@SuppressWarnings({"unused", "boxing"})
          @Override
					public void run() {
						new BooleanAssertCommand(AssertType.AssertEquals, "some failure message", true);
					}
				});
	}

	@SuppressWarnings("boxing")
  @Test
	public void testEqualsHashCode() {
		BooleanAssertCommand a = new BooleanAssertCommand(AssertType.AssertTrue, "some failure message", true);
		BooleanAssertCommand b = new BooleanAssertCommand(AssertType.AssertFalse, "some failure message", true);
		BooleanAssertCommand c = new BooleanAssertCommand(AssertType.AssertTrue, "some failure message", true);
		BooleanAssertCommand d = new BooleanAssertCommand(AssertType.AssertTrue, "some failure message2", true);
		BooleanAssertCommand e = new BooleanAssertCommand(AssertType.AssertTrue, "some failure message", false);
		
		assertNotEquals(a, b);
		assertNotEquals(a.hashCode(), b.hashCode());
		assertEquals(a, c);
		assertEquals(a.hashCode(), c.hashCode());
		
		assertNotEquals(a, d);
		assertNotEquals(a.hashCode(), d.hashCode());
		
		assertNotEquals(a, e);
		assertNotEquals(a.hashCode(), e.hashCode());
		
		assertNotEquals(a, new ExtendedAssertCommand(AssertType.AssertTrue, "some failure message"));
		assertNotEquals(a, new Object());
	}
	
	@SuppressWarnings("boxing")
  @Test
	public void testEvaluate() {
		assertTrue(new BooleanAssertCommand(AssertType.AssertTrue, "some failure message", true).evaluate());
		assertFalse(new BooleanAssertCommand(AssertType.AssertTrue, "some failure message", false).evaluate());
		
		assertFalse(new BooleanAssertCommand(AssertType.AssertFalse, "some failure message", true).evaluate());
		assertTrue(new BooleanAssertCommand(AssertType.AssertFalse, "some failure message", false).evaluate());
		
		assertTrue(new BooleanAssertCommand(AssertType.AssertNull, "some failure message", null).evaluate());
		assertFalse(new BooleanAssertCommand(AssertType.AssertNull, "some failure message", true).evaluate());
		assertTrue(new BooleanAssertCommand(AssertType.AssertNotNull, "some failure message", false).evaluate());
		assertFalse(new BooleanAssertCommand(AssertType.AssertNotNull, "some failure message", null).evaluate());
		
	}
	
	@SuppressWarnings("boxing")
  @Test
	public void testData() {
		BooleanAssertCommand bac = new BooleanAssertCommand(AssertType.AssertTrue, "some failure message", true);
		assertSame(bac, bac.getData());
		assertTrue((Boolean) bac.getExpected());
		assertTrue((Boolean) bac.getActual());
		
		bac = new BooleanAssertCommand(AssertType.AssertTrue, "some failure message", false);
    assertSame(bac, bac.getData());
    assertTrue((Boolean) bac.getExpected());
    assertFalse((Boolean) bac.getActual());
    
    bac = new BooleanAssertCommand(AssertType.AssertFalse, "some failure message", false);
    assertSame(bac, bac.getData());
    assertFalse((Boolean) bac.getExpected());
    assertFalse((Boolean) bac.getActual());
    
    bac = new BooleanAssertCommand(AssertType.AssertFalse, "some failure message", true);
    assertSame(bac, bac.getData());
    assertFalse((Boolean) bac.getExpected());
    assertTrue((Boolean) bac.getActual());
    
    bac = new BooleanAssertCommand(AssertType.AssertNull, "some failure message", true);
    assertSame(bac, bac.getData());
    assertNull(bac.getExpected());
    assertTrue((Boolean) bac.getActual());
    
    bac = new BooleanAssertCommand(AssertType.AssertNull, "some failure message", null);
    assertSame(bac, bac.getData());
    assertNull(bac.getExpected());
    assertNull(bac.getActual());
    
    bac = new BooleanAssertCommand(AssertType.AssertNotNull, "some failure message", null);
    assertSame(bac, bac.getData());
    assertEquals("", bac.getExpected());
    assertNull(bac.getActual());
    
    bac = new BooleanAssertCommand(AssertType.AssertNotNull, "some failure message", true);
    assertSame(bac, bac.getData());
    assertEquals("", bac.getExpected());
    assertTrue((Boolean) bac.getActual());
	}

	@Override
	public int getTests(I_CountType type) {
		return super.getTests(type, 4, true);
	}

	@Override
	public int getAsserts(I_CountType type) {
		int thisAsserts = 43;
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
		int thisUniqueAsserts = 21;
		if (type.isFromMetaWithCoverage()) {
			//code coverage and circular dependencies +
			//custom afterTrialTests
			return super.getUniqueAsserts(type, thisUniqueAsserts + 3);
		}  else {
			return super.getAsserts(type, thisUniqueAsserts);
		}
	}
}
