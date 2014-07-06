package org.adligo.tests4j_tests.models.shared.system;

import java.io.IOException;

import org.adligo.tests4j.models.shared.coverage.I_SourceFileCoverage;
import org.adligo.tests4j.models.shared.results.I_SourceFileTrialResult;
import org.adligo.tests4j.models.shared.system.ByteListOutputStream;
import org.adligo.tests4j.models.shared.trials.SourceFileScope;
import org.adligo.tests4j.models.shared.trials.SourceFileTrial;
import org.adligo.tests4j.models.shared.trials.Test;

@SourceFileScope(sourceClass=ByteListOutputStream.class)
public class ByteListOutputStreamTrial extends SourceFileTrial {
	
	@SuppressWarnings("unused")
	@Test(timeout=600000)
	public void test10BytesTo2ByteChunksize() throws IOException {
		ByteListOutputStream blos = new ByteListOutputStream(2);
		String alpha10 = "0123456789";
		byte [] bytes = alpha10.getBytes();
		assertEquals(10, bytes.length);
		for (int i = 0; i < bytes.length; i++) {
			blos.write(bytes[i]);
		}
		String result = blos.toString();
		assertEquals(alpha10, result);
		blos.close();
	}
	
	@Test(timeout=6000000)
	public void test90BytesTo32ByteChunksize() throws IOException {
		ByteListOutputStream blos = new ByteListOutputStream(32);
		String alphabet90 = "abcdefghijklmnopqrstuvwxyz0123456789" +
				"ABCDEFGHIJKLMNOPQURSTUVWYXZ0123456789" +
				"abcdefghijklmnopq";
		byte [] bytes = alphabet90.getBytes();
		assertEquals(90, bytes.length);
		for (int i = 0; i < bytes.length; i++) {
			blos.write(bytes[i]);
		}
		assertEquals(alphabet90, blos.toString());
		blos.close();
	}

	@Override
	public void afterTrialTests(I_SourceFileTrialResult p) {
		assertEquals(2, p.getTestCount());
		if (p.hasRecordedCoverage()) {
			I_SourceFileCoverage coverage = p.getSourceFileCoverage();
			assertGreaterThanOrEquals(100.00, coverage.getPercentageCoveredDouble());
		}
		assertEquals(4, p.getAssertionCount());
		assertEquals(4, p.getUniqueAssertionCount());
	}
}
