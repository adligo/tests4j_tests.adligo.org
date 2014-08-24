package org.adligo.tests4j_tests.models.shared.common;

import org.adligo.tests4j.models.shared.asserts.common.ExpectedThrownData;
import org.adligo.tests4j.models.shared.asserts.common.I_Thrower;
import org.adligo.tests4j.models.shared.common.StringRoutines;
import org.adligo.tests4j.models.shared.trials.SourceFileScope;
import org.adligo.tests4j.models.shared.trials.Test;
import org.adligo.tests4j_tests.base_trials.SourceFileCountingTrial;

@SourceFileScope (sourceClass=StringRoutines.class, minCoverage=95.0)
public class StringRoutinesTrial extends SourceFileCountingTrial {

	@Test
	public void testMethods() {
		assertTrue(StringRoutines.isEmpty(null));
		assertTrue(StringRoutines.isEmpty(""));
		assertTrue(StringRoutines.isEmpty("\t"));
		assertTrue(StringRoutines.isEmpty("\n"));
		assertFalse(StringRoutines.isEmpty("hey"));
		
		assertThrown(new ExpectedThrownData(new IllegalArgumentException("null message.")), new I_Thrower() {
			
			@Override
			public void run() {
				StringRoutines.isEmpty(null, "null message.");
			}
		});
		
		assertEquals(0, StringRoutines.indexBoundsFix("hey", -1));
		assertEquals(0, StringRoutines.indexBoundsFix("hey", 0));
		assertEquals(3, StringRoutines.indexBoundsFix("hey", 4));
		assertEquals(3, StringRoutines.indexBoundsFix("hey", 3));
		assertEquals(1, StringRoutines.indexBoundsFix("hey", 1));
		assertEquals(2, StringRoutines.indexBoundsFix("hey", 2));
		

	}
	
	@Override
	public int getTests() {
		return 1;
	}

	@Override
	public int getAsserts() {
		return 12;
	}

	@Override
	public int getUniqueAsserts() {
		return 7;
	}
}
