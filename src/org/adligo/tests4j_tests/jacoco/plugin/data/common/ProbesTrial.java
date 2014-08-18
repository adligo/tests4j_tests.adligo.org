package org.adligo.tests4j_tests.jacoco.plugin.data.common;

import org.adligo.tests4j.models.shared.asserts.common.ExpectedThrownData;
import org.adligo.tests4j.models.shared.asserts.common.I_Thrower;
import org.adligo.tests4j.models.shared.trials.SourceFileScope;
import org.adligo.tests4j.models.shared.trials.Test;
import org.adligo.tests4j_4jacoco.plugin.data.common.Probes;
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
	public int getTests() {
		return 2;
	}

	@Override
	public int getAsserts() {
		return 14;
	}

	@Override
	public int getUniqueAsserts() {
		return 4;
	}


}
