package org.adligo.tests4j_tests.models.shared.asserts;

import org.adligo.tests4j.models.shared.asserts.AbstractCompareAssertCommand;
import org.adligo.tests4j.models.shared.asserts.common.AssertType;
import org.adligo.tests4j.models.shared.asserts.common.CompareAssertionData;
import org.adligo.tests4j.models.shared.asserts.common.ExpectedThrownData;
import org.adligo.tests4j.models.shared.asserts.common.I_CompareAssertionData;
import org.adligo.tests4j.models.shared.asserts.common.I_Thrower;
import org.adligo.tests4j.models.shared.dependency_groups.adligo.Tests4J_Asserts_DependencyGroup;
import org.adligo.tests4j.models.shared.trials.AllowedDependencies;
import org.adligo.tests4j.models.shared.trials.SourceFileScope;
import org.adligo.tests4j.models.shared.trials.Test;
import org.adligo.tests4j_tests.base_trials.I_CountType;
import org.adligo.tests4j_tests.base_trials.SourceFileCountingTrial;
import org.adligo.tests4j_tests.models.shared.asserts.mocks.ExtendedCompareAssertCommand;

@SourceFileScope (sourceClass=AbstractCompareAssertCommand.class, minCoverage=0.0)
@AllowedDependencies (groups=Tests4J_Asserts_DependencyGroup.class)
public class AbstractCompareAssertCommandTrial extends SourceFileCountingTrial {

	
	@Test
	public void testConstructorExceptions() {
		assertThrown(new ExpectedThrownData(NullPointerException.class), 
			new I_Thrower() {
				@Override
				public void run() {
					new ExtendedCompareAssertCommand("failed", 
							(I_CompareAssertionData<?>) null);
				}
		});
	}
	
	@Test
	public void testGettersAndEvaluate() {
		ExtendedCompareAssertCommand cac = new ExtendedCompareAssertCommand("failed message", 
				new CompareAssertionData<Boolean>(true, false, AssertType.AssertEquals));
		
		assertTrue((Boolean) cac.getExpected());
		assertFalse((Boolean) cac.getActual());
		assertEquals("failed message", cac.getFailureMessage());
		assertFalse(cac.evaluate());
		
		cac = new ExtendedCompareAssertCommand( "failed message2", 
				new CompareAssertionData<Boolean>(false, true, AssertType.AssertEquals));
		
		assertFalse((Boolean) cac.getExpected());
		assertTrue((Boolean) cac.getActual());
		assertEquals("failed message2", cac.getFailureMessage());
		assertFalse(cac.evaluate());
		
		
		cac = new ExtendedCompareAssertCommand( "failed message3", 
				new CompareAssertionData<Boolean>(true, true, AssertType.AssertEquals));
		
		assertTrue((Boolean) cac.getExpected());
		assertTrue((Boolean) cac.getActual());
		assertEquals("failed message3", cac.getFailureMessage());
		assertTrue(cac.evaluate());
	}
	
	@Override
	public int getTests(I_CountType type) {
		return super.getTests(type, 2);
	}

	@Override
	public int getAsserts(I_CountType type) {
		int thisAsserts = 13;
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
		int thisUniqueAsserts = 6;
		if (type.isFromMetaWithCoverage()) {
			//code coverage and circular dependencies +
			//custom afterTrialTests
			return super.getUniqueAsserts(type, thisUniqueAsserts + 3);
		}  else {
			return super.getAsserts(type, thisUniqueAsserts);
		}
	}
}
