package org.adligo.tests4j_tests.run.remote.nio;

import java.util.HashSet;
import java.util.Set;

import org.adligo.tests4j.models.shared.SourceFileScope;
import org.adligo.tests4j.models.shared.SourceFileTrial;
import org.adligo.tests4j.models.shared.Test;
import org.adligo.tests4j.models.shared.coverage.I_SourceFileCoverage;
import org.adligo.tests4j.run.remote.nio.ByteMutant;
import org.adligo.tests4j.run.remote.nio.UTF8_CharacterReader;

@SourceFileScope (sourceClass=UTF8_CharacterReader.class)
public class UTF8_CharacterReaderTrial extends SourceFileTrial {

	@Test 
	public void testAll() throws Exception {
		UTF8_Generator gen = new UTF8_Generator();
		assertEquals(128L, UTF8_Generator.ONE_BYTE_MAX_CODE_POINT_LONG);
		assertEquals(2048L, UTF8_Generator.TWO_BYTE_MAX_CODE_POINT_LONG);
		assertEquals(65536L, UTF8_Generator.THREE_BYTE_MAX_CODE_POINT_LONG);
		assertEquals(2097152L, UTF8_Generator.FOUR_BYTE_MAX_CODE_POINT_LONG);
		assertEquals(67108864L, UTF8_Generator.FIVE_BYTE_MAX_CODE_POINT_LONG);
		assertEquals(2147483648L, UTF8_Generator.SIX_BYTE_MAX_CODE_POINT_LONG);
		
		
		
		byte []  bytes = gen.next();
		UTF8_CharacterReader reader = new UTF8_CharacterReader();
		int counter = 0;
		while (bytes != null) {
			reader.clear();
			assertTrue(reader.needsBytes());
			for (int i = 0; i < bytes.length; i++) {
				reader.addByte(i, bytes[i]);
			}
			assertFalse(reader.needsBytes());
			assertNotNull(reader.toCharacter());
			
			counter++;
			if (Math.IEEEremainder(counter, UTF8_Generator.TWO_BYTE_MAX_CODE_POINT_LONG * 4) == 0) {
				log(this.getClass().getName() +  " at " +counter + " / " + UTF8_Generator.SIX_BYTE_MAX_CODE_POINT_LONG + ";");
			}
		}
		
	}
	/*
	int subLength = 16 - binString.length();
	String firstBinString = binString.substring(0, subLength);
	String secondBinString = binString.substring(subLength, binString.length());
	assertEquals(binString, firstBinString + secondBinString);
	
	ByteMutant bm = new ByteMutant(firstBinString);
	reader.addByte(0, bm.toByte());
	bm = new ByteMutant(secondBinString);
	reader.addByte(1, bm.toByte());
	*/
	
	/**
	 * (non-Javadoc)
	 * @see org.adligo.tests4j.models.shared.SourceFileTrial#afterTrialTests(org.adligo.tests4j.models.shared.coverage.I_SourceFileCoverage)
	 */
	@Override
	public void afterTrialTests(I_SourceFileCoverage p) {
		//not sure what I am missing, I probably need 
		//to finish the eclipse plug-in coverage source-lighter
		
		assertGreaterThanOrEquals(22.0, p.getPercentageCoveredDouble());
	}
}
