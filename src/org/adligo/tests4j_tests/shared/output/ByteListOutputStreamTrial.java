package org.adligo.tests4j_tests.shared.output;

import java.io.IOException;

import org.adligo.tests4j.models.shared.trials.SourceFileScope;
import org.adligo.tests4j.models.shared.trials.Test;
import org.adligo.tests4j.shared.output.ByteListOutputStream;
import org.adligo.tests4j_tests.base_trials.I_CountType;
import org.adligo.tests4j_tests.base_trials.SourceFileCountingTrial;

@SourceFileScope(sourceClass=ByteListOutputStream.class)
public class ByteListOutputStreamTrial extends SourceFileCountingTrial {
	
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
		String result = blos.flushString();
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
		assertEquals(alphabet90, blos.flushString());
		blos.close();
	}

	
	@Override
	public int getTests(I_CountType type) {
		return super.getTests(type, 2);
	}

	@Override
	public int getAsserts(I_CountType type) {
		int thisAsserts = 4;
		//code coverage and circular dependencies +
		//custom afterTrialTests
		//+ see above
		int thisAfterAsserts = 2;
		if (type.isFromMetaWithCoverage()) {
			return super.getAsserts(type, thisAsserts + thisAfterAsserts);
		} else {
			return super.getAsserts(type, thisAsserts);
		}
	}

	@Override
	public int getUniqueAsserts(I_CountType type) {
		int thisUniqueAsserts = 4;
		//code coverage and circular dependencies +
		//custom afterTrialTests
		//+ see above
		int thisAfterUniqueAsserts = 2;
		if (type.isFromMetaWithCoverage()) {
			//code coverage and circular dependencies +
			//custom afterTrialTests
			return super.getUniqueAsserts(type, thisUniqueAsserts + thisAfterUniqueAsserts);
		} else {
			return super.getUniqueAsserts(type, thisUniqueAsserts);
		}
	}
}
