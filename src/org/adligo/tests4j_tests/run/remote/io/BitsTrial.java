package org.adligo.tests4j_tests.run.remote.io;

import org.adligo.tests4j.models.shared.coverage.I_SourceFileCoverage;
import org.adligo.tests4j.models.shared.results.I_SourceFileTrialResult;
import org.adligo.tests4j.models.shared.trials.SourceFileScope;
import org.adligo.tests4j.models.shared.trials.SourceFileTrial;
import org.adligo.tests4j.models.shared.trials.Test;
import org.adligo.tests4j.run.remote.io.Bits;

@SourceFileScope (sourceClass=Bits.class)
public class BitsTrial extends SourceFileTrial {

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
		if (p.hasRecordedCoverage()) {
			I_SourceFileCoverage coverage = p.getSourceFileCoverage();
			assertGreaterThanOrEquals(100.00, coverage.getPercentageCoveredDouble());
		}
	}
}
