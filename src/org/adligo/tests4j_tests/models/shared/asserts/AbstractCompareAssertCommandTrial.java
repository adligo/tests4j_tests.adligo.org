package org.adligo.tests4j_tests.models.shared.asserts;

import org.adligo.tests4j.models.shared.asserts.AbstractCompareAssertCommand;
import org.adligo.tests4j.models.shared.asserts.CompareAssertionData;
import org.adligo.tests4j.models.shared.asserts.ExpectedThrownData;
import org.adligo.tests4j.models.shared.asserts.common.AssertType;
import org.adligo.tests4j.models.shared.asserts.common.I_CompareAssertionData;
import org.adligo.tests4j.models.shared.asserts.common.I_Thrower;
import org.adligo.tests4j.models.shared.coverage.I_SourceFileCoverage;
import org.adligo.tests4j.models.shared.results.feedback.I_SourceFileTrial_TestsResults;
import org.adligo.tests4j.models.shared.trials.SourceFileScope;
import org.adligo.tests4j.models.shared.trials.SourceFileTrial;
import org.adligo.tests4j.models.shared.trials.Test;
import org.adligo.tests4j_tests.models.shared.asserts.mocks.ExtendedCompareAssertCommand;

@SourceFileScope (sourceClass=AbstractCompareAssertCommand.class)
public class AbstractCompareAssertCommandTrial extends SourceFileTrial {

	@Test
	public void testConstructorExceptions() {
		assertEquals("AbstractCompareAssertCommand requires non null data.", AbstractCompareAssertCommand.NULL_DATA);
		assertThrown(new ExpectedThrownData(new IllegalArgumentException(
					AbstractCompareAssertCommand.NULL_DATA)), 
			new I_Thrower() {
				@Override
				public void run() {
					new ExtendedCompareAssertCommand(AssertType.AssertEquals, "failed", 
							(I_CompareAssertionData<?>) null);
				}
		});
	}
	
	@Test
	public void testGettersAndEvaluate() {
		ExtendedCompareAssertCommand cac = new ExtendedCompareAssertCommand(AssertType.AssertEquals, "failed message", 
				new CompareAssertionData<Boolean>(true, false));
		
		assertTrue((Boolean) cac.getExpected());
		assertFalse((Boolean) cac.getActual());
		assertEquals("failed message", cac.getFailureMessage());
		assertFalse(cac.evaluate());
		
		cac = new ExtendedCompareAssertCommand(AssertType.AssertEquals, "failed message2", 
				new CompareAssertionData<Boolean>(false, true));
		
		assertFalse((Boolean) cac.getExpected());
		assertTrue((Boolean) cac.getActual());
		assertEquals("failed message2", cac.getFailureMessage());
		assertFalse(cac.evaluate());
		
		
		cac = new ExtendedCompareAssertCommand(AssertType.AssertEquals, "failed message3", 
				new CompareAssertionData<Boolean>(true, true));
		
		assertTrue((Boolean) cac.getExpected());
		assertTrue((Boolean) cac.getActual());
		assertEquals("failed message3", cac.getFailureMessage());
		assertTrue(cac.evaluate());
	}
	

	@Override
	public void afterTrialTests(I_SourceFileTrial_TestsResults p) {
		assertGreaterThanOrEquals(14.0, p.getAssertions());
		assertGreaterThanOrEquals(7.0, p.getUniqueAssertions());
		
		if (p.hasRecordedCoverage()) {
			I_SourceFileCoverage coverage = p.getCoverage();
			//there is some bug in the percentage coverage code currently
			// this should be 75% or so, this seems to have something to do with abstract classes...
			assertGreaterThanOrEquals(40.0, coverage.getPercentageCoveredDouble());
		}
	}
}
