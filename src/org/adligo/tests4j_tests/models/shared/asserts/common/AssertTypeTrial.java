package org.adligo.tests4j_tests.models.shared.asserts.common;

import java.util.Set;

import org.adligo.tests4j.models.shared.asserts.common.AssertType;
import org.adligo.tests4j.models.shared.coverage.I_SourceFileCoverage;
import org.adligo.tests4j.models.shared.results.I_SourceFileTrialResult;
import org.adligo.tests4j.models.shared.trials.SourceFileScope;
import org.adligo.tests4j.models.shared.trials.SourceFileTrial;
import org.adligo.tests4j.models.shared.trials.Test;
import org.adligo.tests4j_tests.base_abstract_trials.SourceFileCountingTrial;

@SourceFileScope (sourceClass=AssertType.class)
public class AssertTypeTrial extends SourceFileCountingTrial {

	@Test
	public void testSingleTypes() {
		assertEquals(14, AssertType.values().length);
		assertEquals(0, AssertType.AssertTrue.getId());
		assertEquals(1, AssertType.AssertFalse.getId());
		assertEquals(2, AssertType.AssertNull.getId());
		assertEquals(3, AssertType.AssertNotNull.getId());
		
		assertEquals(4, AssertType.AssertEquals.getId());
		assertEquals(5, AssertType.AssertNotEquals.getId());
		assertEquals(6, AssertType.AssertSame.getId());
		assertEquals(7, AssertType.AssertNotSame.getId());
		
		assertEquals(8, AssertType.AssertThrown.getId());
		assertEquals(9, AssertType.AssertThrownUniform.getId());
		
		assertEquals(10, AssertType.AssertUniform.getId());
		assertEquals(11, AssertType.AssertNotUniform.getId());
		assertEquals(12, AssertType.AssertContains.getId());
		assertEquals(13, AssertType.AssertGreaterThanOrEquals.getId());
	}
	

	@Test
	public void testBooleanTypesGroup() {
		Set<AssertType> booleanTypes =  AssertType.BOOLEAN_TYPES;
		assertEquals(4, booleanTypes.size());
		assertContains(booleanTypes, AssertType.AssertTrue);
		assertContains(booleanTypes, AssertType.AssertFalse);
		assertContains(booleanTypes, AssertType.AssertNull);
		assertContains(booleanTypes, AssertType.AssertNotNull);
		
	}
	
	@Test
	public void testEqualsTypesGroup() {
		Set<AssertType> booleanTypes =  AssertType.EQUAL_TYPES;
		assertEquals(2, booleanTypes.size());
		assertContains(booleanTypes, AssertType.AssertEquals);
		assertContains(booleanTypes, AssertType.AssertNotEquals);
		
	}
	
	@Test
	public void testIdenticalTypesGroup() {
		Set<AssertType> booleanTypes =  AssertType.IDENTICAL_TYPES;
		assertEquals(4, booleanTypes.size());
		assertContains(booleanTypes, AssertType.AssertEquals);
		assertContains(booleanTypes, AssertType.AssertNotEquals);
		
		assertContains(booleanTypes, AssertType.AssertSame);
		assertContains(booleanTypes, AssertType.AssertNotSame);
	}
	
	@Test
	public void testUniformTypesGroup() {
		Set<AssertType> booleanTypes =  AssertType.UNIFORM_TYPES;
		assertEquals(2, booleanTypes.size());
		assertContains(booleanTypes, AssertType.AssertUniform);
		assertContains(booleanTypes, AssertType.AssertNotUniform);
		
	}
	
	@Override
	public void afterTrialTests(I_SourceFileTrialResult p) {
		assertCounts(p);
		
		if (p.hasRecordedCoverage()) {
			I_SourceFileCoverage coverage = p.getSourceFileCoverage();
			//hmm this should be 95, looks like multithreading
			double pct = coverage.getPercentageCoveredDouble();
			if (pct < 90.0) {
				System.out.println("wtf");
			}
			assertGreaterThanOrEquals(95.0, pct);
		}
	}


	@Override
	public int getTests() {
		return 5;
	}

	@Override
	public int getAsserts() {
		return 31;
	}

	@Override
	public int getUniqueAsserts() {
		return 31;
	}
	
}
