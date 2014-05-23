package org.adligo.tests4j_tests.run.remote.nio;

import org.adligo.tests4j.models.shared.SourceFileScope;
import org.adligo.tests4j.models.shared.SourceFileTrial;
import org.adligo.tests4j.models.shared.Test;
import org.adligo.tests4j.models.shared.coverage.I_SourceFileCoverage;
import org.adligo.tests4j.models.shared.metadata.I_SourceFileTrial_TestRunInfo;
import org.adligo.tests4j.run.remote.nio.Bits;

@SourceFileScope (sourceClass=Bits.class)
public class BitReaderTrial extends SourceFileTrial {

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
	public void afterTrialTests(I_SourceFileTrial_TestRunInfo p) {
		if (p.hasRecordedCoverage()) {
			I_SourceFileCoverage coverage = p.getCoverage();
			assertGreaterThanOrEquals(100.00, coverage.getPercentageCoveredDouble());
		}
	}
}
