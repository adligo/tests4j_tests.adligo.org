package org.adligo.tests4j_tests.run.remote.nio;

import java.util.HashSet;
import java.util.Set;

import org.adligo.tests4j.models.shared.SourceFileScope;
import org.adligo.tests4j.models.shared.SourceFileTrial;
import org.adligo.tests4j.models.shared.Test;
import org.adligo.tests4j.run.remote.nio.ByteMutant;
import org.adligo.tests4j.run.remote.nio.UTF8_CharacterReader;

@SourceFileScope (sourceClass=UTF8_CharacterReader.class)
public class UTF8_CharacterReaderTrial extends SourceFileTrial {

	@Test 
	public void testAll() throws Exception {
		Set<Integer> alwaysOne = new HashSet<Integer>();
		Set<Integer> alwaysZero = new HashSet<Integer>();
		
		//2nd byte
		alwaysOne.add(8);
		alwaysZero.add(9);
		
		//3rd byte
		alwaysOne.add(16);
		alwaysZero.add(17);
		
		//4th byte
		alwaysOne.add(24);
		alwaysZero.add(25);
		
		//5th byte
		alwaysOne.add(32);
		alwaysZero.add(33);
		
		//6th byte
		alwaysOne.add(40);
		alwaysZero.add(41);
		
		UTF8_CharacterReader reader = new UTF8_CharacterReader();
		assertTrue(reader.needsBytes());
		
		ByteMutant bm = new ByteMutant("1000000");
		reader.addByte(0, bm.toByte());
		assertFalse(reader.needsBytes());
		System.out.println(reader.toCharacter());
		/*
		for (long i = 0; i < 281474976710656L; i++) {
			String binString =  Long.toBinaryString(i);
			
			//160 is 128 + 32 for the first to bits = 1
			if (i <= 160) {
				System.out.println("sending " + binString);
				ByteMutant bm = new ByteMutant(binString);
				reader.addByte(0, bm.toByte());
				assertFalse(reader.needsBytes());
				System.out.println(reader.toCharacter());
			}
			
		}
		*/
	}
}
