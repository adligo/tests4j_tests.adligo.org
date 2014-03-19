package org.adligo.jtests_tests.use_case_trials;

import org.adligo.jtests.models.shared.Test;
import org.adligo.jtests.models.shared.FunctionalTrial;

public class Assert_FailConditions_Trial extends FunctionalTrial {

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
