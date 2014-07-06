package org.adligo.tests4j_tests.models.shared.asserts;

import org.adligo.tests4j.models.shared.asserts.BooleanAssertCommand;
import org.adligo.tests4j.models.shared.asserts.ExpectedThrownData;
import org.adligo.tests4j.models.shared.asserts.common.AssertType;
import org.adligo.tests4j.models.shared.asserts.common.I_Thrower;
import org.adligo.tests4j.models.shared.coverage.I_SourceFileCoverage;
import org.adligo.tests4j.models.shared.results.I_SourceFileTrialResult;
import org.adligo.tests4j.models.shared.trials.SourceFileScope;
import org.adligo.tests4j.models.shared.trials.SourceFileTrial;
import org.adligo.tests4j.models.shared.trials.Test;
import org.adligo.tests4j_tests.models.shared.asserts.mocks.ExtendedAssertCommand;

@SourceFileScope (sourceClass=BooleanAssertCommand.class)
public class BooleanAssertCommandTrial extends SourceFileTrial {

	@Test
	public void testConstructorExceptions() {
		assertThrown(new ExpectedThrownData(new IllegalArgumentException(BooleanAssertCommand.BOOLEAN_ASSERT_COMMAND_REQUIRES_A_BOOLEAN_TYPE)),
				new I_Thrower() {
					
					@Override
					public void run() {
						new BooleanAssertCommand(AssertType.AssertEquals, "some failure message", true);
					}
				});
	}

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
	
	@Test
	public void testData() {
		BooleanAssertCommand bac = new BooleanAssertCommand(AssertType.AssertTrue, "some failure message", true);
		assertSame(bac, bac.getData());
		assertTrue((Boolean) bac.getData(BooleanAssertCommand.EXPECTED_VALUE));
		assertTrue((Boolean) bac.getData(BooleanAssertCommand.VALUE));
	}
	
	@Override
	public void afterTrialTests(I_SourceFileTrialResult p) {
		assertEquals(4, p.getTestCount());
		assertGreaterThanOrEquals(20.0, p.getAssertionCount());
		assertGreaterThanOrEquals(9.0, p.getUniqueAssertionCount());
		
		if (p.hasRecordedCoverage()) {
			I_SourceFileCoverage coverage = p.getSourceFileCoverage();
			assertGreaterThanOrEquals(60.0, coverage.getPercentageCoveredDouble());
		}
	}
}
