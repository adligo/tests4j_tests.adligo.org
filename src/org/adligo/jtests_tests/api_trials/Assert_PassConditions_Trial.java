package org.adligo.jtests_tests.api_trials;

import java.math.BigDecimal;
import java.math.BigInteger;

import org.adligo.jtests.models.shared.API_Trial;
import org.adligo.jtests.models.shared.PackageScope;
import org.adligo.jtests.models.shared.Test;

@PackageScope (packageName = "org.adligo.jtests")
public class Assert_PassConditions_Trial extends API_Trial {

	@Test
	public void exhibitEquals() {
		assertEquals(new BigDecimal("0.00"), new BigDecimal("0.00"));
		
		assertEquals(new BigInteger("0"), new BigInteger("0"));
		assertEquals(1, 1);
		assertEquals(1L, 1L);
		assertEquals((short) 1,(short) 1);
		assertEquals(0.1, 0.1);
		assertEquals((float) 0.1,(float) 0.1);
		
		assertEquals("a", "a");
		assertEquals("hey","a","a");
		assertEquals((byte) 1, (byte) 1);
		assertEquals("hey", (byte) 1, (byte) 1);
		
	}
	
	@Test
	public void exhibitNotEquals() {
		assertNotEquals(new BigDecimal("0.00"), new BigDecimal("0.01"));
		
		assertNotEquals(new BigInteger("0"), new BigInteger("2"));
		assertNotEquals(1, 2);
		assertNotEquals(1L, 2L);
		assertNotEquals((short) 1,(short) 2);
		assertNotEquals(0.1, 1.1);
		assertNotEquals((float) 0.1,(float) 0.2);
		
		assertNotEquals("a", "b");
		assertNotEquals("hey","a","b");
		assertNotEquals((byte) 1, (byte)2);
		assertNotEquals("hey", (byte) 1, (byte) 2);
	}
}