package org.adligo.tests4j_tests.models.shared.coverage;

import java.math.BigInteger;

import org.adligo.tests4j.models.shared.coverage.CoverageUnits;
import org.adligo.tests4j.shared.asserts.common.ExpectedThrownData;
import org.adligo.tests4j.shared.asserts.common.I_Thrower;
import org.adligo.tests4j.shared.asserts.dependency.AllowedDependencies;
import org.adligo.tests4j.system.shared.trials.SourceFileScope;
import org.adligo.tests4j.system.shared.trials.Test;
import org.adligo.tests4j_tests.base_trials.I_CountType;
import org.adligo.tests4j_tests.base_trials.SourceFileCountingTrial;
import org.adligo.tests4j_tests.dependency_groups.Tests4J_Coverage_DependencyGroup;

@SourceFileScope (sourceClass=CoverageUnits.class, minCoverage=66.0)
@AllowedDependencies (groups=Tests4J_Coverage_DependencyGroup.class)
public class CoverageUnitsTrial extends SourceFileCountingTrial {

	@Test
	public void testConstructorExceptions() {
		assertThrown(new ExpectedThrownData(new IllegalArgumentException(
				CoverageUnits.COVERAGE_UNITS_MUST_BE_GREATER_THAN_OR_EQUAL_TO_ZERO)), new I_Thrower() {
			
			@Override
			public void run() throws Throwable {
				new CoverageUnits(-1);
			}
		});
		assertThrown(new ExpectedThrownData(new IllegalArgumentException(
				CoverageUnits.COVERAGE_UNITS_MUST_BE_GREATER_THAN_OR_EQUAL_TO_ZERO)), new I_Thrower() {
			
			@Override
			public void run() throws Throwable {
				new CoverageUnits(new BigInteger("-1"));
			}
		});
	}
	
	@Test
	public void testConstructorsAndMethods() {
		CoverageUnits cu = new CoverageUnits(0);
		
		assertTrue(cu.isInt());
		
		assertEquals(0, cu.get());
		assertEquals(new BigInteger("0"), cu.getBig());
		assertEquals("CoverageUnits [0]", cu.toString());
		
		assertEquals(cu, new CoverageUnits(0));
		assertEquals(cu.hashCode(), new CoverageUnits(0).hashCode());
		
		assertTrue(new CoverageUnits(new BigInteger("0")).isInt());
		assertEquals(cu, new CoverageUnits(new BigInteger("0")));
		assertEquals(cu.hashCode(), new CoverageUnits(new BigInteger("0")).hashCode());
	
		assertNotEquals(cu, new CoverageUnits(1));
		assertNotEquals(cu.hashCode(), new CoverageUnits(1).hashCode());
		
		assertNotEquals(cu, new CoverageUnits(new BigInteger("1")));
		assertNotEquals(cu.hashCode(), new CoverageUnits(new BigInteger("1")).hashCode());
	
	}
	
	@Override
	public int getTests(I_CountType type) {
		return super.getTests(type, 2);
	}

	@Override
	public int getAsserts(I_CountType type) {
		int thisAsserts = 15;
		//code coverage and circular dependencies +
		//custom afterTrialTests
		//+ see above
		int thisAfterAsserts = 3;
		if (type.isFromMetaWithCoverage()) {
			return super.getAsserts(type, thisAsserts + thisAfterAsserts);
		} else {
			return super.getAsserts(type, thisAsserts);
		}
	}

	@Override
	public int getUniqueAsserts(I_CountType type) {
		int thisUniqueAsserts = 7;
		//code coverage and circular dependencies +
		//custom afterTrialTests
		//+ see above
		int thisAfterUniqueAsserts = 3;
		if (type.isFromMetaWithCoverage()) {
			//code coverage and circular dependencies +
			//custom afterTrialTests
			return super.getUniqueAsserts(type, thisUniqueAsserts + thisAfterUniqueAsserts);
		} else {
			return super.getUniqueAsserts(type, thisUniqueAsserts);
		}
	}

}
