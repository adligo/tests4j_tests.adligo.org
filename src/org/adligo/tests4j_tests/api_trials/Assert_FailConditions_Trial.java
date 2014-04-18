package org.adligo.tests4j_tests.api_trials;

import org.adligo.tests4j.models.shared.API_Trial;
import org.adligo.tests4j.models.shared.PackageScope;
import org.adligo.tests4j.models.shared.Test;

@PackageScope (packageName = "org.adligo.tests4j")
public class Assert_FailConditions_Trial extends API_Trial {

	@Test
	public void exhibitAbstractExhibit() {
		assertEquals("a", "a");
		assertEquals("hey","a","a");
		assertEquals((byte) 1, (byte) 1);
		assertEquals("hey", (byte) 1, (byte) 1);
		
		
		assertNotEquals("a", "b");
		assertNotEquals("hey","a","b");
		assertNotEquals((byte) 1, (byte) 2);
		assertNotEquals("hey", (byte) 1, (byte) 2);
		
	}
	
}
