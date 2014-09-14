package org.adligo.tests4j_tests.models.shared.common;

import org.adligo.tests4j.models.shared.asserts.common.ExpectedThrownData;
import org.adligo.tests4j.models.shared.asserts.common.I_Thrower;
import org.adligo.tests4j.models.shared.common.StringMethods;
import org.adligo.tests4j.models.shared.dependency_groups.adligo.Tests4J_Common_DependencyGroup;
import org.adligo.tests4j.models.shared.trials.AllowedDependencies;
import org.adligo.tests4j.models.shared.trials.SourceFileScope;
import org.adligo.tests4j.models.shared.trials.Test;
import org.adligo.tests4j_tests.base_trials.I_CountType;
import org.adligo.tests4j_tests.base_trials.SourceFileCountingTrial;

@SourceFileScope (sourceClass=StringMethods.class, minCoverage=95.0)
@AllowedDependencies (groups=Tests4J_Common_DependencyGroup.class)
public class StringMethodsTrial extends SourceFileCountingTrial {

	@Test
	public void testMethods() {
		assertTrue(StringMethods.isEmpty(null));
		assertTrue(StringMethods.isEmpty(""));
		assertTrue(StringMethods.isEmpty("\t"));
		assertTrue(StringMethods.isEmpty("\n"));
		assertFalse(StringMethods.isEmpty("hey"));
		
		assertThrown(new ExpectedThrownData(new IllegalArgumentException("null message.")), new I_Thrower() {
			
			@Override
			public void run() {
				StringMethods.isEmpty(null, "null message.");
			}
		});
		
		assertEquals(0, StringMethods.indexBoundsFix("hey", -1));
		assertEquals(0, StringMethods.indexBoundsFix("hey", 0));
		assertEquals(3, StringMethods.indexBoundsFix("hey", 4));
		assertEquals(3, StringMethods.indexBoundsFix("hey", 3));
		assertEquals(1, StringMethods.indexBoundsFix("hey", 1));
		assertEquals(2, StringMethods.indexBoundsFix("hey", 2));
		

	}
	
	@Override
	public int getTests(I_CountType type) {
		return super.getTests(type, 1);
	}

	@Override
	public int getAsserts(I_CountType type) {
		if (type.isFromMetaWithCoverage()) {
			//code coverage and circular dependencies
			return super.getAsserts(type,15);
		} else {
			return super.getAsserts(type, 12);
		}
	}

	@Override
	public int getUniqueAsserts(I_CountType type) {
		if (type.isFromMetaWithCoverage()) {
			return super.getUniqueAsserts(type, 10);
		} else {
			return super.getUniqueAsserts(type, 7);
		}
	}
}
