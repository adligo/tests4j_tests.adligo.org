package org.adligo.tests4j_tests.run.remote.nio;

import org.adligo.tests4j.run.remote.nio.BitReader;
import org.adligo.tests4j.run.remote.nio.ByteMutant;

/**
 * this class counts up using the UTF8 
 * code point bytes, converting to the actual utf 8 bytes along the way
 * 
 * @author scott
 *
 */
public class UTF8_Generator {
	public static final long ONE_BYTE_MAX_CODE_POINT_LONG = nToTheExp(2, 7);
	public static final long TWO_BYTE_MAX_CODE_POINT_LONG = nToTheExp(2,11);
	public static final long THREE_BYTE_MAX_CODE_POINT_LONG = nToTheExp(2,16);
	public static final long FOUR_BYTE_MAX_CODE_POINT_LONG = nToTheExp(2,21);
	public static final long FIVE_BYTE_MAX_CODE_POINT_LONG = nToTheExp(2,26);
	public static final long SIX_BYTE_MAX_CODE_POINT_LONG = nToTheExp(2,31);
	public static final long MAX_CODE_POINT_AS_LONG = SIX_BYTE_MAX_CODE_POINT_LONG;
	
	private long codePoint = 0;
	
	private static  long nToTheExp (long n, int exp){
		   long result = n;
		   for (int i = 1; i < exp; i++) {
			   result = result * n;
		   }
		   return result;
	}   
	
	public byte[] next() {
		int slot = 0;
		String binString = Long.toBinaryString(codePoint);
		if (codePoint <= ONE_BYTE_MAX_CODE_POINT_LONG) {
			//1 byte
			ByteMutant bm = new ByteMutant("0" + binString);
			return new byte[] {bm.toByte()};
		} else if (codePoint <= TWO_BYTE_MAX_CODE_POINT_LONG) {
			BitReader br = new BitReader(binString);
			boolean [] codePoints = br.toBits(11);
			ByteMutant bm = new ByteMutant();
			bm.setSlotZero(true);
			bm.setSlotOne(true);
			bm.setSlotTwo(false);
			
			bm.setSlotThree(codePoints[slot++]);
			bm.setSlotFour(codePoints[slot++]);
			bm.setSlotFive(codePoints[slot++]);
			bm.setSlotSix(codePoints[slot++]);
			bm.setSlotSeven(codePoints[slot++]);
			
			ByteMutant bm2 = new ByteMutant();
			bm2.setSlotZero(true);
			bm2.setSlotOne(false);
			
			bm2.setSlotTwo(codePoints[slot++]);
			bm2.setSlotThree(codePoints[slot++]);
			bm2.setSlotFour(codePoints[slot++]);
			bm2.setSlotFive(codePoints[slot++]);
			bm2.setSlotSix(codePoints[slot++]);
			bm2.setSlotSeven(codePoints[slot++]);
			return new byte[] {bm.toByte(), bm2.toByte()};
		} else if (codePoint <= THREE_BYTE_MAX_CODE_POINT_LONG) {
			//3 bytes
			BitReader br = new BitReader(binString);
			boolean [] codePoints = br.toBits(16);
			ByteMutant bm = new ByteMutant();
			bm.setSlotZero(true);
			bm.setSlotOne(true);
			bm.setSlotTwo(true);
			bm.setSlotThree(false);
			
			bm.setSlotFour(codePoints[slot++]);
			bm.setSlotFive(codePoints[slot++]);
			bm.setSlotSix(codePoints[slot++]);
			bm.setSlotSeven(codePoints[slot++]);
			
			ByteMutant bm2 = new ByteMutant();
			bm2.setSlotZero(true);
			bm2.setSlotOne(false);
			
			bm2.setSlotTwo(codePoints[slot++]);
			bm2.setSlotThree(codePoints[slot++]);
			bm2.setSlotFour(codePoints[slot++]);
			bm2.setSlotFive(codePoints[slot++]);
			bm2.setSlotSix(codePoints[slot++]);
			bm2.setSlotSeven(codePoints[slot++]);
			
			ByteMutant bm3 = new ByteMutant();
			bm3.setSlotZero(true);
			bm3.setSlotOne(false);
		
			bm3.setSlotTwo(codePoints[slot++]);
			bm3.setSlotThree(codePoints[slot++]);
			bm3.setSlotFour(codePoints[slot++]);
			bm3.setSlotFive(codePoints[slot++]);
			bm3.setSlotSix(codePoints[slot++]);
			bm3.setSlotSeven(codePoints[slot++]);
			return new byte[] {bm.toByte(), bm2.toByte(), bm3.toByte()};
		} else if (codePoint <= FOUR_BYTE_MAX_CODE_POINT_LONG) {
			//4bytes
			BitReader br = new BitReader(binString);
			boolean [] codePoints = br.toBits(16);
			ByteMutant bm = new ByteMutant();
			bm.setSlotZero(true);
			bm.setSlotOne(true);
			bm.setSlotTwo(true);
			bm.setSlotThree(true);
			
			bm.setSlotFour(false);
			bm.setSlotFive(codePoints[slot++]);
			bm.setSlotSix(codePoints[slot++]);
			bm.setSlotSeven(codePoints[slot++]);
			
			ByteMutant bm2 = new ByteMutant();
			bm2.setSlotZero(true);
			bm2.setSlotOne(false);
			
			bm2.setSlotTwo(codePoints[slot++]);
			bm2.setSlotThree(codePoints[slot++]);
			bm2.setSlotFour(codePoints[slot++]);
			bm2.setSlotFive(codePoints[slot++]);
			bm2.setSlotSix(codePoints[slot++]);
			bm2.setSlotSeven(codePoints[slot++]);
			
			ByteMutant bm3 = new ByteMutant();
			bm3.setSlotZero(true);
			bm3.setSlotOne(false);
			
			bm3.setSlotTwo(codePoints[slot++]);
			bm3.setSlotThree(codePoints[slot++]);
			bm3.setSlotFour(codePoints[slot++]);
			bm3.setSlotFive(codePoints[slot++]);
			bm3.setSlotSix(codePoints[slot++]);
			bm3.setSlotSeven(codePoints[slot++]);
			
			ByteMutant bm4 = new ByteMutant();
			bm4.setSlotZero(true);
			bm4.setSlotOne(false);
		
			bm4.setSlotTwo(codePoints[slot++]);
			bm4.setSlotThree(codePoints[slot++]);
			bm4.setSlotFour(codePoints[slot++]);
			bm4.setSlotFive(codePoints[slot++]);
			bm4.setSlotSix(codePoints[slot++]);
			bm4.setSlotSeven(codePoints[slot++]);
			return new byte[] {bm.toByte(), bm2.toByte(), bm3.toByte(), bm4.toByte()};
		} else if (codePoint <= FIVE_BYTE_MAX_CODE_POINT_LONG) {
			//5bytes
			BitReader br = new BitReader(binString);
			boolean [] codePoints = br.toBits(16);
			ByteMutant bm = new ByteMutant();
			bm.setSlotZero(true);
			bm.setSlotOne(true);
			bm.setSlotTwo(true);
			bm.setSlotThree(true);
			
			bm.setSlotFour(true);
			bm.setSlotFive(false);
			bm.setSlotSix(codePoints[slot++]);
			bm.setSlotSeven(codePoints[slot++]);
			
			ByteMutant bm2 = new ByteMutant();
			bm2.setSlotZero(true);
			bm2.setSlotOne(false);
			
			bm2.setSlotTwo(codePoints[slot++]);
			bm2.setSlotThree(codePoints[slot++]);
			bm2.setSlotFour(codePoints[slot++]);
			bm2.setSlotFive(codePoints[slot++]);
			bm2.setSlotSix(codePoints[slot++]);
			bm2.setSlotSeven(codePoints[slot++]);
			
			ByteMutant bm3 = new ByteMutant();
			bm3.setSlotZero(true);
			bm3.setSlotOne(false);
			
			bm3.setSlotTwo(codePoints[slot++]);
			bm3.setSlotThree(codePoints[slot++]);
			bm3.setSlotFour(codePoints[slot++]);
			bm3.setSlotFive(codePoints[slot++]);
			bm3.setSlotSix(codePoints[slot++]);
			bm3.setSlotSeven(codePoints[slot++]);
			
			ByteMutant bm4 = new ByteMutant();
			bm4.setSlotZero(true);
			bm4.setSlotOne(false);
		
			bm4.setSlotTwo(codePoints[slot++]);
			bm4.setSlotThree(codePoints[slot++]);
			bm4.setSlotFour(codePoints[slot++]);
			bm4.setSlotFive(codePoints[slot++]);
			bm4.setSlotSix(codePoints[slot++]);
			bm4.setSlotSeven(codePoints[slot++]);
			
			ByteMutant bm5 = new ByteMutant();
			bm5.setSlotZero(true);
			bm5.setSlotOne(false);
		
			bm5.setSlotTwo(codePoints[slot++]);
			bm5.setSlotThree(codePoints[slot++]);
			bm5.setSlotFour(codePoints[slot++]);
			bm5.setSlotFive(codePoints[slot++]);
			bm5.setSlotSix(codePoints[slot++]);
			bm5.setSlotSeven(codePoints[slot++]);
			return new byte[] {bm.toByte(), bm2.toByte(), bm3.toByte(), bm4.toByte(), bm5.toByte()};
		} else if (codePoint <= SIX_BYTE_MAX_CODE_POINT_LONG){
			//6 bytes
			BitReader br = new BitReader(binString);
			boolean [] codePoints = br.toBits(16);
			ByteMutant bm = new ByteMutant();
			bm.setSlotZero(true);
			bm.setSlotOne(true);
			bm.setSlotTwo(true);
			bm.setSlotThree(true);
			
			bm.setSlotFour(true);
			bm.setSlotFive(true);
			bm.setSlotSix(false);
			bm.setSlotSeven(codePoints[slot++]);
			
			ByteMutant bm2 = new ByteMutant();
			bm2.setSlotZero(true);
			bm2.setSlotOne(false);
			
			bm2.setSlotTwo(codePoints[slot++]);
			bm2.setSlotThree(codePoints[slot++]);
			bm2.setSlotFour(codePoints[slot++]);
			bm2.setSlotFive(codePoints[slot++]);
			bm2.setSlotSix(codePoints[slot++]);
			bm2.setSlotSeven(codePoints[slot++]);
			
			ByteMutant bm3 = new ByteMutant();
			bm3.setSlotZero(true);
			bm3.setSlotOne(false);
			
			bm3.setSlotTwo(codePoints[slot++]);
			bm3.setSlotThree(codePoints[slot++]);
			bm3.setSlotFour(codePoints[slot++]);
			bm3.setSlotFive(codePoints[slot++]);
			bm3.setSlotSix(codePoints[slot++]);
			bm3.setSlotSeven(codePoints[slot++]);
			
			ByteMutant bm4 = new ByteMutant();
			bm4.setSlotZero(true);
			bm4.setSlotOne(false);
		
			bm4.setSlotTwo(codePoints[slot++]);
			bm4.setSlotThree(codePoints[slot++]);
			bm4.setSlotFour(codePoints[slot++]);
			bm4.setSlotFive(codePoints[slot++]);
			bm4.setSlotSix(codePoints[slot++]);
			bm4.setSlotSeven(codePoints[slot++]);
			
			ByteMutant bm5 = new ByteMutant();
			bm5.setSlotZero(true);
			bm5.setSlotOne(false);
		
			bm5.setSlotTwo(codePoints[slot++]);
			bm5.setSlotThree(codePoints[slot++]);
			bm5.setSlotFour(codePoints[slot++]);
			bm5.setSlotFive(codePoints[slot++]);
			bm5.setSlotSix(codePoints[slot++]);
			bm5.setSlotSeven(codePoints[slot++]);
			

			ByteMutant bm6 = new ByteMutant();
			bm6.setSlotZero(true);
			bm6.setSlotOne(false);
		
			bm6.setSlotTwo(codePoints[slot++]);
			bm6.setSlotThree(codePoints[slot++]);
			bm6.setSlotFour(codePoints[slot++]);
			bm6.setSlotFive(codePoints[slot++]);
			bm6.setSlotSix(codePoints[slot++]);
			bm6.setSlotSeven(codePoints[slot++]);
			
			return new byte[] {bm.toByte(), bm2.toByte(), bm3.toByte(), bm4.toByte(), bm5.toByte(), bm6.toByte()};
		}
		return null;
	}

}
