package org.adligo.tests4j_tests.models.shared.asserts.common;

import java.util.Set;

import org.adligo.tests4j.models.shared.asserts.common.AssertType;
import org.adligo.tests4j.models.shared.coverage.I_SourceFileCoverage;
import org.adligo.tests4j.models.shared.results.I_SourceFileTrialResult;
import org.adligo.tests4j.models.shared.trials.SourceFileScope;
import org.adligo.tests4j.models.shared.trials.Test;
import org.adligo.tests4j_tests.base_trials.I_CountType;
import org.adligo.tests4j_tests.base_trials.SourceFileCountingTrial;
//TODO look at minCoverage should be 95.0
@SourceFileScope (sourceClass=AssertType.class, minCoverage=8.0)
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
	
	@Test
	public void testGetByIAssertType() {
		AssertTypeMock mock = new AssertTypeMock();
		assertAType(mock, AssertType.AssertContains);
		
		assertAType(mock, AssertType.AssertEquals);
		assertAType(mock, AssertType.AssertFalse);
		assertAType(mock, AssertType.AssertGreaterThanOrEquals);
		
		assertAType(mock, AssertType.AssertNotEquals);
		assertAType(mock, AssertType.AssertNotNull);
		assertAType(mock, AssertType.AssertNotSame);
		assertAType(mock, AssertType.AssertNotUniform);
		
		
		assertAType(mock, AssertType.AssertNull);
		assertAType(mock, AssertType.AssertSame);
		assertAType(mock, AssertType.AssertThrown);
		assertAType(mock, AssertType.AssertThrownUniform);
		assertAType(mock, AssertType.AssertTrue);
		assertAType(mock, AssertType.AssertUniform);
		
	}


	private void assertAType(AssertTypeMock mock, AssertType type) {
		mock.setId(type.getId());
		assertSame(type, AssertType.getType(mock));
	}

	@Override
	public int getTests(I_CountType type) {
		return super.getTests(type, 6);
	}

	@Override
	public int getAsserts(I_CountType type) {
		if (type.isFromMetaWithCoverage()) {
			//code coverage and circular dependencies +
			//custom afterTrialTests
			return super.getAsserts(type,49);
		} else {
			return super.getAsserts(type, 45);
		}
	}

	@Override
	public int getUniqueAsserts(I_CountType type) {
		if (type.isFromMetaWithCoverage()) {
			return super.getUniqueAsserts(type, 49);
		}  else {
			return super.getAsserts(type, 45);
		}
	}

	@Override
	public void afterTrialTests(I_SourceFileTrialResult p) {
		super.afterTrialTests(p);
		if (p.hasRecordedCoverage()) {
			I_SourceFileCoverage sfc =  p.getSourceFileCoverage();
			//assertEquals("org.adligo.tests4j.models.shared.asserts.common.AssertType",sfc.getClassName());
			assertEquals(273, sfc.getCoverageUnits().get());
			assertEquals(269, sfc.getCoveredCoverageUnits().get());
		}
	}
	
}
