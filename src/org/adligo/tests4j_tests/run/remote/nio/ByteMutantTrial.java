package org.adligo.tests4j_tests.run.remote.nio;

import org.adligo.tests4j.models.shared.SourceFileScope;
import org.adligo.tests4j.models.shared.SourceFileTrial;
import org.adligo.tests4j.models.shared.Test;
import org.adligo.tests4j.models.shared.coverage.I_SourceFileCoverage;
import org.adligo.tests4j.run.remote.nio.ByteMutant;


@SourceFileScope (sourceClass=ByteMutant.class)
public class ByteMutantTrial extends SourceFileTrial {
	
	@Test
	public void testByteMutantConstructorAndUnsignedValue() {
		int counter = 0;
		for (byte i = 0; i < Byte.MAX_VALUE; i++) {
			ByteMutant eb = new ByteMutant(i);
			assertEquals(counter, eb.unsigned());
			counter++;
		}
		for (int i = Byte.MAX_VALUE; i < 256; i++) {
			ByteMutant eb = new ByteMutant((byte) i);
			assertEquals(counter, eb.unsigned());
			counter++;
		}
		
		ByteMutant eb = new ByteMutant("0000");
		assertEquals(0, eb.unsigned());
		eb = new ByteMutant("0001");
		assertEquals(1, eb.unsigned());
		eb = new ByteMutant("0010");
		assertEquals(2, eb.unsigned());
		eb = new ByteMutant("0011");
		assertEquals(3, eb.unsigned());
	}
	
	@Test
	public void testByteMutantStringConstructorAndUnsignedValue() {
		int counter = 0;
		for (int i = 0; i < 2; i++) {
			
			String binString = Integer.toBinaryString(i);
			if (i <= 1) {
				binString = "0000000" + binString;
			} else if (i <= 3) {
				binString = "000000" + binString;
			} else if (i <= 7) {
				binString = "00000" + binString;
			} else if (i <= 15) {
				binString = "0000" + binString;
			} else if (i <= 15) {
				binString = "000" + binString;
			} else if (i <= 31) {
				binString = "00" + binString;
			} else if (i <= 63) {
				binString = "0" + binString;
			}
			assertEquals(8, binString.length());
			ByteMutant eb = new ByteMutant(binString);
			assertEquals(counter, eb.unsigned());
			assertEquals(binString, eb.toOnesAndZeros());
			counter++;
		}
	}
	
	@Test
	public void testByteMutantCopy() {
		
		int counter = 0;
		for (byte i = 0; i < Byte.MAX_VALUE; i++) {
			ByteMutant eb = new ByteMutant(0);
			
			eb.copy(counter, 8); 
			assertEquals(counter, eb.unsigned());
			counter++;
		}
		for (int i = Byte.MAX_VALUE; i < 256; i++) {
			ByteMutant eb = new ByteMutant(0);
			
			eb.copy(counter, 8); 
			assertEquals(counter, eb.unsigned());
			counter++;
		}
		
		int right = 1+2+4+8;
		ByteMutant eb = new ByteMutant(right);
		eb.copy(0, 4); 
		assertEquals(right, eb.unsigned());
		
		eb = new ByteMutant(right);
		eb.copy(1, 4); 
		assertEquals(right + 16, eb.unsigned());
		
		eb = new ByteMutant(right);
		eb.copy(2, 4); 
		assertEquals(right + 32, eb.unsigned());
	
		eb = new ByteMutant(right);
		eb.copy(3, 4); 
		assertEquals(right + 32 + 16, eb.unsigned());
		
		eb = new ByteMutant(right);
		eb.copy(4, 4); 
		assertEquals(right + 64, eb.unsigned());
		
		eb = new ByteMutant(right);
		eb.copy(5, 4); 
		assertEquals(right + 64 + 16, eb.unsigned());
		
		eb = new ByteMutant(right);
		eb.copy(6, 4); 
		assertEquals(right + 64 + 32, eb.unsigned());
		
		eb = new ByteMutant(right);
		eb.copy(7, 4); 
		assertEquals(right + 64 + 32 + 16, eb.unsigned());
	}
	
	@Test
	public void testToAscii() {
		int counter = 0;
		for (byte i = 0; i < Byte.MAX_VALUE; i++) {
			ByteMutant eb = new ByteMutant(i);
			assertEquals(counter, eb.unsigned());
			assertEquals(i, eb.toByte());
			
			counter++;
		}
	}

	@Test
	public void testUtf8() {
		
			ByteMutant eb = new ByteMutant();
			eb.setSlotZero(false);
			assertEquals(1, eb.getUTF8_BytesInSequence());
			eb.setSlotZero(true);
			assertEquals(1, eb.getUTF8_BytesInSequence());
			
			eb.setSlotOne(false);
			assertEquals(1, eb.getUTF8_BytesInSequence());
			
			eb.setSlotOne(true);
			assertEquals(2, eb.getUTF8_BytesInSequence());
			
			eb.setSlotTwo(true);
			assertEquals(3, eb.getUTF8_BytesInSequence());
			
			eb.setSlotThree(true);
			assertEquals(4, eb.getUTF8_BytesInSequence());
			
			eb.setSlotFour(true);
			assertEquals(5, eb.getUTF8_BytesInSequence());
			
			eb.setSlotFive(true);
			assertEquals(6, eb.getUTF8_BytesInSequence());
			
			eb.setSlotSix(true);
			assertEquals(6, eb.getUTF8_BytesInSequence());
			
			eb.setSlotSeven(true);
			assertEquals(6, eb.getUTF8_BytesInSequence());
	}
	
	@Override
	public void afterTrialTests(I_SourceFileCoverage p) {
		//not sure what I am missing, I probably need 
		//to finish the eclipse plug-in coverage source-lighter
		
		assertGreaterThanOrEquals(80.0, p.getPercentageCoveredDouble());
	}
}
