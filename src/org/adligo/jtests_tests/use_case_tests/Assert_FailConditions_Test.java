package org.adligo.jtests_tests.use_case_tests;

import org.adligo.jtests.models.shared.Exhibit;
import org.adligo.jtests.models.shared.FunctionalTest;

public class Assert_FailConditions_Test extends FunctionalTest {

	@Exhibit
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
