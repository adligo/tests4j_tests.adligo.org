package org.adligo.tests4j_tests.run.remote.io;

import org.adligo.tests4j.models.shared.coverage.I_SourceFileCoverage;
import org.adligo.tests4j.models.shared.results.I_SourceFileTrialResult;
import org.adligo.tests4j.models.shared.trials.SourceFileScope;
import org.adligo.tests4j.models.shared.trials.SourceFileTrial;
import org.adligo.tests4j.models.shared.trials.Test;
import org.adligo.tests4j.run.remote.io.Bits;
import org.adligo.tests4j_tests.base_trials.I_CountType;
import org.adligo.tests4j_tests.base_trials.SourceFileCountingTrial;

@SourceFileScope (sourceClass=Bits.class)
public class BitsTrial extends SourceFileCountingTrial {

	@Test
	public void testToBitsSimple() {
		Bits br = new Bits("001");
		boolean [] bits = br.toBits();
		assertEquals(3, bits.length);
		assertFalse(bits[0]);
		assertFalse(bits[1]);
		assertTrue(bits[2]);
	}
	
	@Test
	public void testToBitsPad() {
		Bits br = new Bits("001");
		boolean [] bits = br.toBits(3);
		assertEquals(6, bits.length);
		assertFalse(bits[0]);
		assertFalse(bits[1]);
		assertFalse(bits[2]);
		
		assertFalse(bits[3]);
		assertFalse(bits[4]);
		assertTrue(bits[5]);
	}
	
	@Override
	public void afterTrialTests(I_SourceFileTrialResult p) {
		super.afterTrialTests(p);
		if (p.hasRecordedCoverage()) {
			I_SourceFileCoverage coverage = p.getSourceFileCoverage();
			assertGreaterThanOrEquals(100.00, coverage.getPercentageCoveredDouble());
		}
	}
	

	public int getTests(I_CountType type) {
		return super.getTests(type, 2);
	}

	@Override
	public int getAsserts(I_CountType type) {
		int thisAsserts = 11;
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
		int thisUniqueAsserts = 6;
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
