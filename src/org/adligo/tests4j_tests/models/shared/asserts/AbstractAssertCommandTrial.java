package org.adligo.tests4j_tests.models.shared.asserts;

import org.adligo.tests4j.models.shared.asserts.AbstractAssertCommand;
import org.adligo.tests4j.models.shared.asserts.ExpectedThrownData;
import org.adligo.tests4j.models.shared.asserts.common.AssertType;
import org.adligo.tests4j.models.shared.asserts.common.I_Thrower;
import org.adligo.tests4j.models.shared.coverage.I_SourceFileCoverage;
import org.adligo.tests4j.models.shared.results.feedback.I_SourceFileTrial_TestsResults;
import org.adligo.tests4j.models.shared.trials.SourceFileScope;
import org.adligo.tests4j.models.shared.trials.SourceFileTrial;
import org.adligo.tests4j.models.shared.trials.Test;
import org.adligo.tests4j_tests.models.shared.asserts.mocks.ExtendedAssertCommand;

@SourceFileScope (sourceClass=AbstractAssertCommand.class)
public class AbstractAssertCommandTrial extends SourceFileTrial {

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
	public void testGettersAndHashCodes() {
		ExtendedAssertCommand eac = new ExtendedAssertCommand(AssertType.AssertFalse, "Some Failure Message");
		assertEquals(AssertType.AssertFalse, eac.getType());
		assertEquals("Some Failure Message", eac.getFailureMessage());
		assertNull(eac.getData());
	}
	
	@Override
	public void afterTrialTests(I_SourceFileTrial_TestsResults p) {
		assertGreaterThanOrEquals(7.0, p.getAssertions());
		assertGreaterThanOrEquals(7.0, p.getUniqueAssertions());
		
		if (p.hasRecordedCoverage()) {
			I_SourceFileCoverage coverage = p.getCoverage();
			assertGreaterThanOrEquals(100.0, coverage.getPercentageCoveredDouble());
		}
	}
}
