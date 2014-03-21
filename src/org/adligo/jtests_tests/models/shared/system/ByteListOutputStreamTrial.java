package org.adligo.jtests_tests.models.shared.system;

import java.io.IOException;

import org.adligo.jtests.models.shared.ClassScope;
import org.adligo.jtests.models.shared.ClassTrial;
import org.adligo.jtests.models.shared.IgnoreTest;
import org.adligo.jtests.models.shared.Test;
import org.adligo.jtests.models.shared.system.ByteListOutputStream;

@ClassScope(testedClass=ByteListOutputStream.class)
public class ByteListOutputStreamTrial extends ClassTrial {

	
	@Test(timout=600000)
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
	
	@Test(timout=6000000)
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
}
