package org.adligo.tests4j_tests.shared.common;

import org.adligo.tests4j.shared.asserts.common.ExpectedThrownData;
import org.adligo.tests4j.shared.asserts.common.I_Thrower;
import org.adligo.tests4j.shared.asserts.reference.AllowedReferences;
import org.adligo.tests4j.shared.common.ArrayUtils;
import org.adligo.tests4j.shared.common.ClassMethods;
import org.adligo.tests4j.system.shared.trials.SourceFileScope;
import org.adligo.tests4j.system.shared.trials.Test;
import org.adligo.tests4j_tests.base_trials.I_CountType;
import org.adligo.tests4j_tests.base_trials.SourceFileCountingTrial;
import org.adligo.tests4j_tests.references_groups.Tests4J_Common_ReferenceGroup;
import org.adligo.tests4j_tests.shared.common.mocks.BaseMockClass;
import org.adligo.tests4j_tests.shared.common.mocks.ChildMockClass;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@SourceFileScope (sourceClass=ArrayUtils.class, minCoverage=60.0)
@AllowedReferences (groups=Tests4J_Common_ReferenceGroup.class)
public class ArrayUtilsTrial extends SourceFileCountingTrial {

	@Test
	public void testCreateArrays() {
		String [] ints = new String[] {"1","2","3"};
		String [] oi = ArrayUtils.copyOf(ints);
		for (int i = 0; i < 3; i++) {
		  assertEquals(ints[i], oi[i]);
    }
	}
	
	
	@Override
	public int getTests(I_CountType type) {
		return super.getTests(type, 1, true);
	}
	
	@Override
	public int getAsserts(I_CountType type) {
		int tests = 3;
		if (type.isFromMetaWithCoverage()) {
			//code coverage and circular dependencies
			return super.getAsserts(type,tests + 3);
		} else {
			return super.getAsserts(type, tests);
		}
	}

	@Override
	public int getUniqueAsserts(I_CountType type) {
		int utests = 3;
		if (type.isFromMetaWithCoverage()) {
			return super.getUniqueAsserts(type, utests + 3);
		} else {
			return super.getUniqueAsserts(type, utests);
		}
	}
}
