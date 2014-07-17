package org.adligo.tests4j_tests.models.shared.asserts;

import org.adligo.tests4j.models.shared.asserts.AbstractAssertCommand;
import org.adligo.tests4j.models.shared.asserts.ExpectedThrownData;
import org.adligo.tests4j.models.shared.asserts.common.AssertType;
import org.adligo.tests4j.models.shared.asserts.common.I_Thrower;
import org.adligo.tests4j.models.shared.coverage.I_SourceFileCoverage;
import org.adligo.tests4j.models.shared.results.I_SourceFileTrialResult;
import org.adligo.tests4j.models.shared.trials.AdditionalInstrumentation;
import org.adligo.tests4j.models.shared.trials.SourceFileScope;
import org.adligo.tests4j.models.shared.trials.Test;
import org.adligo.tests4j_tests.base_abstract_trials.SourceFileCountingTrial;
import org.adligo.tests4j_tests.models.shared.asserts.mocks.ExtendedAssertCommand;

@SourceFileScope (sourceClass=AbstractAssertCommand.class, minCoverage=78.0)
@AdditionalInstrumentation (javaPackages="org.adligo.tests4j_tests.models.shared.asserts.mocks")
public class AbstractAssertCommandTrial extends SourceFileCountingTrial {

	@Test
	public void testConstructorsExceptions() {
		assertEquals("AssertCommands requires a type.",AbstractAssertCommand.ASSERT_COMMANDS_REQUIRES_A_TYPE);
		assertThrown(new ExpectedThrownData(new IllegalArgumentException(
					AbstractAssertCommand.ASSERT_COMMANDS_REQUIRES_A_TYPE)), 
				new I_Thrower() {
					
					@Override
					public void run() {
						new ExtendedAssertCommand(null, null);
					}
				});
		
		assertEquals("AssertCommands requres a non empty failue message.",AbstractAssertCommand.ASSERT_COMMANDS_REQURES_A_NON_EMPTY_FAILUE_MESSAGE);
		assertThrown(new ExpectedThrownData(new IllegalArgumentException(
					AbstractAssertCommand.ASSERT_COMMANDS_REQURES_A_NON_EMPTY_FAILUE_MESSAGE)), 
				new I_Thrower() {
					
					@Override
					public void run() {
						new ExtendedAssertCommand(AssertType.AssertFalse, null);
					}
				});
		assertThrown(new ExpectedThrownData(new IllegalArgumentException(
					AbstractAssertCommand.ASSERT_COMMANDS_REQURES_A_NON_EMPTY_FAILUE_MESSAGE)), 
				new I_Thrower() {
					
					@Override
					public void run() {
						new ExtendedAssertCommand(AssertType.AssertFalse, "\t");
					}
				});
	}
	
	@Test
	public void testGetters() {
		ExtendedAssertCommand eac = new ExtendedAssertCommand(AssertType.AssertFalse, "Some Failure Message");
		assertEquals(AssertType.AssertFalse, eac.getType());
		assertEquals("Some Failure Message", eac.getFailureMessage());
		assertNull(eac.getData());
	}
	
	@Test
	public void testEqualsHashCode() {
		ExtendedAssertCommand a = new ExtendedAssertCommand(AssertType.AssertFalse, "Some Failure Message");
		ExtendedAssertCommand b = new ExtendedAssertCommand(AssertType.AssertFalse, "Some Failure Message2");
		ExtendedAssertCommand c = new ExtendedAssertCommand(AssertType.AssertFalse, "Some Failure Message");
		ExtendedAssertCommand d = new ExtendedAssertCommand(AssertType.AssertTrue, "Some Failure Message");
		
		assertEquals(a, a);
		assertEquals(a.hashCode(), a.hashCode());
		
		assertNotEquals(a, b);
		assertNotEquals(a.hashCode(), b.hashCode());
		
		assertEquals(a, c);
		assertEquals(a.hashCode(), c.hashCode());
		
		assertNotEquals(a, d);
		assertNotEquals(a.hashCode(), d.hashCode());
		
	}
	

	@Override
	public int getTests() {
		return 3;
	}

	@Override
	public int getAsserts() {
		return 16;
	}

	@Override
	public int getUniqueAsserts() {
		return 11;
	}
}
