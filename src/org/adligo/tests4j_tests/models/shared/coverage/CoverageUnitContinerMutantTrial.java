package org.adligo.tests4j_tests.models.shared.coverage;

import java.math.BigDecimal;

import org.adligo.tests4j.models.shared.coverage.CoverageUnitContinerMutant;
import org.adligo.tests4j.models.shared.coverage.CoverageUnits;
import org.adligo.tests4j.models.shared.coverage.I_CoverageUnits;
import org.adligo.tests4j.shared.asserts.common.ExpectedThrowable;
import org.adligo.tests4j.shared.asserts.common.I_Thrower;
import org.adligo.tests4j.shared.asserts.reference.AllowedReferences;
import org.adligo.tests4j.system.shared.trials.SourceFileScope;
import org.adligo.tests4j.system.shared.trials.Test;
import org.adligo.tests4j_tests.base_trials.I_CountType;
import org.adligo.tests4j_tests.base_trials.SourceFileCountingTrial;
import org.adligo.tests4j_tests.references_groups.Tests4J_Coverage_GwtReferenceGroup;

@SourceFileScope (sourceClass=CoverageUnitContinerMutant.class, minCoverage=70.0)
@AllowedReferences (groups=Tests4J_Coverage_GwtReferenceGroup.class)
public class CoverageUnitContinerMutantTrial extends SourceFileCountingTrial {

	@Test
	public void testConstructorExceptions() {
		assertThrown(new ExpectedThrowable(NullPointerException.class), 
			new I_Thrower() {
			
			@Override
			public void run() throws Throwable {
				new CoverageUnitContinerMutant(null);
			}
		});
	}
	
	@Test
	public void testCoverageMethods() {
		CoverageUnitContinerMutant cucm = new CoverageUnitContinerMutant();
		assertNull(cucm.getCoverageUnits());
		cucm.setCoverageUnits(new CoverageUnits(0));
		I_CoverageUnits cus = cucm.getCoverageUnits();
		assertNotNull(cus);
		assertEquals(0, cus.get());
		
		cucm.addCoverageUnits(new CoverageUnits(1));
		cus = cucm.getCoverageUnits();
		assertNotNull(cus);
		assertEquals(1, cus.get());
		
		cucm.addCoverageUnits(new CoverageUnits(2));
		cus = cucm.getCoverageUnits();
		assertNotNull(cus);
		assertEquals(3, cus.get());
		
		cucm.setCoverageUnits(new CoverageUnits(0));
		cus = cucm.getCoverageUnits();
		assertNotNull(cus);
		assertEquals(0, cus.get());
		
		cucm.setCoverageUnits(new CoverageUnits(3));
		cus = cucm.getCoverageUnits();
		assertNotNull(cus);
		assertEquals(3, cus.get());
		
		cucm.addCoverageUnits(new CoverageUnits(2));
		cus = cucm.getCoverageUnits();
		assertNotNull(cus);
		assertEquals(5, cus.get());
	}
	
	@Test
	public void testCoveredMethods() {
		CoverageUnitContinerMutant cucm = new CoverageUnitContinerMutant();
		assertNull(cucm.getCoveredCoverageUnits());
		cucm.setCoveredCoverageUnits(new CoverageUnits(0));
		I_CoverageUnits cus = cucm.getCoveredCoverageUnits();
		assertNotNull(cus);
		assertEquals(0, cus.get());
		
		cucm.addCoveredCoverageUnits(new CoverageUnits(1));
		cus = cucm.getCoveredCoverageUnits();
		assertNotNull(cus);
		assertEquals(1, cus.get());
		
		cucm.addCoveredCoverageUnits(new CoverageUnits(2));
		cus = cucm.getCoveredCoverageUnits();
		assertNotNull(cus);
		assertEquals(3, cus.get());
		
		cucm.setCoveredCoverageUnits(new CoverageUnits(0));
		cus = cucm.getCoveredCoverageUnits();
		assertNotNull(cus);
		assertEquals(0, cus.get());
		
		cucm.setCoveredCoverageUnits(new CoverageUnits(3));
		cus = cucm.getCoveredCoverageUnits();
		assertNotNull(cus);
		assertEquals(3, cus.get());
		
		cucm.addCoveredCoverageUnits(new CoverageUnits(2));
		cus = cucm.getCoveredCoverageUnits();
		assertNotNull(cus);
		assertEquals(5, cus.get());
	}
	
	@Test
	public void testPercentageMatrix() {
		CoverageUnitContinerMutant cucm = new CoverageUnitContinerMutant();
		//division by null
		assertEquals(new BigDecimal("100.00"),cucm.getPercentageCovered());
		assertEquals(100.0, cucm.getPercentageCoveredDouble());
		
		cucm.setCoverageUnits(new CoverageUnits(0));
		//division by zero 
		assertEquals(new BigDecimal("100.00"),cucm.getPercentageCovered());
		assertEquals(100.0, cucm.getPercentageCoveredDouble());
		
		cucm.setCoverageUnits(new CoverageUnits(1));
		assertEquals(new BigDecimal("0.00"),cucm.getPercentageCovered());
		assertEquals(0.0, cucm.getPercentageCoveredDouble());
		
		cucm.setCoveredCoverageUnits(new CoverageUnits(1));
		assertEquals(new BigDecimal("100.00"),cucm.getPercentageCovered());
		assertEquals(100.0, cucm.getPercentageCoveredDouble());
		
		cucm.setCoverageUnits(new CoverageUnits(2));
		assertEquals(new BigDecimal("50.00"),cucm.getPercentageCovered());
		assertEquals(50.0, cucm.getPercentageCoveredDouble());
		
		cucm.setCoverageUnits(new CoverageUnits(3));
		assertEquals(new BigDecimal("33.33"),cucm.getPercentageCovered());
		assertEquals(33.33, cucm.getPercentageCoveredDouble());
		
		cucm.setCoverageUnits(new CoverageUnits(4));
		assertEquals(new BigDecimal("25.00"),cucm.getPercentageCovered());
		assertEquals(25.0, cucm.getPercentageCoveredDouble());
		
		cucm.setCoverageUnits(new CoverageUnits(5));
		assertEquals(new BigDecimal("20.00"),cucm.getPercentageCovered());
		assertEquals(20.0, cucm.getPercentageCoveredDouble());
		
		cucm.setCoveredCoverageUnits(new CoverageUnits(2));
		assertEquals(new BigDecimal("40.00"),cucm.getPercentageCovered());
		assertEquals(40.0, cucm.getPercentageCoveredDouble());
		
		cucm.setCoveredCoverageUnits(new CoverageUnits(3));
		assertEquals(new BigDecimal("60.00"),cucm.getPercentageCovered());
		assertEquals(60.0, cucm.getPercentageCoveredDouble());
		
		cucm.setCoveredCoverageUnits(new CoverageUnits(4));
		assertEquals(new BigDecimal("80.00"),cucm.getPercentageCovered());
		assertEquals(80.0, cucm.getPercentageCoveredDouble());
		
		cucm.setCoveredCoverageUnits(new CoverageUnits(5));
		assertEquals(new BigDecimal("100.00"),cucm.getPercentageCovered());
		assertEquals(100.0, cucm.getPercentageCoveredDouble());
	}
	
	@Override
	public int getTests(I_CountType type) {
		return super.getTests(type, 4, true);
	}

	@Override
	public int getAsserts(I_CountType type) {
		int thisAsserts = 51;
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
		int thisUniqueAsserts = 37;
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
