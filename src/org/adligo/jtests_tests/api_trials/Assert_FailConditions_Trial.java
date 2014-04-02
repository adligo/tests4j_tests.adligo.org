package org.adligo.jtests_tests.api_trials;

import org.adligo.jtests.models.shared.API_Trial;
import org.adligo.jtests.models.shared.PackageScope;
import org.adligo.jtests.models.shared.Test;

@PackageScope (packageName = "org.adligo.jtests")
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
