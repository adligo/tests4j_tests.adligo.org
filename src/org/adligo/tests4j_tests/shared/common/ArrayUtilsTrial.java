package org.adligo.tests4j_tests.shared.common;

import org.adligo.tests4j.shared.asserts.reference.AllowedReferences;
import org.adligo.tests4j.shared.common.ArrayUtils;
import org.adligo.tests4j.system.shared.trials.SourceFileScope;
import org.adligo.tests4j.system.shared.trials.Test;
import org.adligo.tests4j_tests.base_trials.I_CountType;
import org.adligo.tests4j_tests.base_trials.SourceFileCountingTrial;
import org.adligo.tests4j_tests.references_groups.Tests4J_Common_ReferenceGroup;

import java.util.Arrays;

@SourceFileScope (sourceClass=ArrayUtils.class, minCoverage=60.0)
@AllowedReferences (groups=Tests4J_Common_ReferenceGroup.class)
public class ArrayUtilsTrial extends SourceFileCountingTrial {

	@Test
	public void testCopyGenericArrays() {
		String [] ints = new String[] {"1","2","3"};
		String [] oi = ArrayUtils.copyOf(ints);
		for (int i = 0; i < 3; i++) {
		  assertEquals(ints[i], oi[i]);
    }
	}
	
	@Test
  public void testCopyBooleanArrays() {
    boolean [] in = new boolean[] {true, false, true};
    boolean [] out = ArrayUtils.copyOf(in);
    assertTrue(Arrays.equals(in, out));
  }
	
	@Override
	public int getTests(I_CountType type) {
		return super.getTests(type, 2, true);
	}
	
	@Override
	public int getAsserts(I_CountType type) {
		int tests = 4;
		if (type.isFromMetaWithCoverage()) {
			//code coverage and circular dependencies
			return super.getAsserts(type,tests + 3);
		} else {
			return super.getAsserts(type, tests);
		}
	}

	@Override
	public int getUniqueAsserts(I_CountType type) {
		int utests = 4;
		if (type.isFromMetaWithCoverage()) {
			return super.getUniqueAsserts(type, utests + 3);
		} else {
			return super.getUniqueAsserts(type, utests);
		}
	}
}
