package org.adligo.tests4j_tests.models.shared.asserts;

import org.adligo.tests4j.models.shared.asserts.AbstractCompareAssertCommand;
import org.adligo.tests4j.models.shared.asserts.CompareAssertionData;
import org.adligo.tests4j.models.shared.asserts.ExpectedThrownData;
import org.adligo.tests4j.models.shared.asserts.common.AssertType;
import org.adligo.tests4j.models.shared.asserts.common.I_CompareAssertionData;
import org.adligo.tests4j.models.shared.asserts.common.I_Thrower;
import org.adligo.tests4j.models.shared.coverage.I_SourceFileCoverage;
import org.adligo.tests4j.models.shared.results.I_SourceFileTrialResult;
import org.adligo.tests4j.models.shared.trials.AdditionalInstrumentation;
import org.adligo.tests4j.models.shared.trials.SourceFileScope;
import org.adligo.tests4j.models.shared.trials.Test;
import org.adligo.tests4j_tests.base_abstract_trials.SourceFileCountingTrial;
import org.adligo.tests4j_tests.models.shared.asserts.mocks.ExtendedCompareAssertCommand;

@SourceFileScope (sourceClass=AbstractCompareAssertCommand.class)
@AdditionalInstrumentation (javaPackages="org.adligo.tests4j_tests.models.shared.asserts.mocks")
public class AbstractCompareAssertCommandTrial extends SourceFileCountingTrial {

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
	public void afterTrialTests(I_SourceFileTrialResult p) {
		assertCounts(p);
		
		if (p.hasRecordedCoverage()) {
			I_SourceFileCoverage coverage = p.getSourceFileCoverage();
			assertGreaterThanOrEquals(68.0, coverage.getPercentageCoveredDouble());
		}
	}

	@Override
	public int getTests() {
		return 2;
	}

	@Override
	public int getAsserts() {
		return 14;
	}

	@Override
	public int getUniqueAsserts() {
		return 7;
	}
}
