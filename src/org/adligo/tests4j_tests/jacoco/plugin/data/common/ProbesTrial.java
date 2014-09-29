package org.adligo.tests4j_tests.jacoco.plugin.data.common;

import org.adligo.tests4j.shared.asserts.common.ExpectedThrownData;
import org.adligo.tests4j.shared.asserts.common.I_Thrower;
import org.adligo.tests4j.system.shared.trials.SourceFileScope;
import org.adligo.tests4j.system.shared.trials.Test;
import org.adligo.tests4j_4jacoco.plugin.data.common.Probes;
import org.adligo.tests4j_tests.base_trials.I_CountType;
import org.adligo.tests4j_tests.base_trials.SourceFileCountingTrial;

@SourceFileScope (sourceClass=Probes.class, minCoverage=95.0)
public class ProbesTrial extends SourceFileCountingTrial {

	
	@Test
	public void testCopyConstructor() throws Exception {
		boolean [] bools = new boolean[] {true, true, false, false, true};
		Probes probes = new Probes(bools);
		
		assertTrue(probes.get(0));
		assertTrue(probes.get(1));
		assertFalse(probes.get(2));
		assertFalse(probes.get(3));
		assertTrue(probes.get(0));
		
		assertEquals(5, probes.size());
		//assert no data linkage
		bools[0] = false;
		assertTrue(probes.get(0));
		
		Probes copy = new Probes(probes);
		
		assertTrue(copy.get(0));
		assertTrue(copy.get(1));
		assertFalse(copy.get(2));
		assertFalse(copy.get(3));
		assertTrue(copy.get(0));
		
		assertEquals(5, copy.size());
	}

	@Test
	public void testConstructorExceptions() throws Exception {
		assertThrown(new ExpectedThrownData(new NullPointerException(null)), 
				new I_Thrower() {
					
					@Override
					public void run() {
						new Probes((boolean []) null);
					}
				});
	}
	@Override
	public int getTests(I_CountType type) {
		return super.getTests(type, 2);
	}

	@Override
	public int getAsserts(I_CountType type) {
		int thisAsserts = 14;
		//code coverage and circular dependencies +
		//custom afterTrialTests
		//+ see above
		int thisAfterAsserts = 2;
		if (type.isFromMetaWithCoverage()) {
			return super.getAsserts(type, thisAsserts + thisAfterAsserts);
		} else {
			return super.getAsserts(type, thisAsserts);
		}
	}

	@Override
	public int getUniqueAsserts(I_CountType type) {
		int thisUniqueAsserts = 4;
		//code coverage and circular dependencies +
		//custom afterTrialTests
		//+ see above
		int thisAfterUniqueAsserts = 2;
		if (type.isFromMetaWithCoverage()) {
			//code coverage and circular dependencies +
			//custom afterTrialTests
			return super.getUniqueAsserts(type, thisUniqueAsserts + thisAfterUniqueAsserts);
		} else {
			return super.getUniqueAsserts(type, thisUniqueAsserts);
		}
	}

}
