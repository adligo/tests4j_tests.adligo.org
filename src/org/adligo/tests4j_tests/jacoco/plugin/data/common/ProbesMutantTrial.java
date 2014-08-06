package org.adligo.tests4j_tests.jacoco.plugin.data.common;

import org.adligo.tests4j.models.shared.asserts.common.ExpectedThrownData;
import org.adligo.tests4j.models.shared.asserts.common.I_Thrower;
import org.adligo.tests4j.models.shared.trials.SourceFileScope;
import org.adligo.tests4j.models.shared.trials.Test;
import org.adligo.tests4j_4jacoco.plugin.data.common.Probes;
import org.adligo.tests4j_4jacoco.plugin.data.common.ProbesMutant;
import org.adligo.tests4j_tests.base_abstract_trials.SourceFileCountingTrial;

@SourceFileScope (sourceClass=ProbesMutant.class, minCoverage=95.0)
public class ProbesMutantTrial extends SourceFileCountingTrial {

	
	@Test
	public void testCopyConstructor() throws Exception {
		ProbesMutant probes = new ProbesMutant();
		assertEquals(0, probes.size());
		probes.set(0, true);
		assertFalse(probes.get(0));
		assertFalse(probes.get(-1));
		probes.set(-1, true);
		assertFalse(probes.get(-1));
		
		boolean [] bools = new boolean[] {true, true, false, false, true};
		probes = new ProbesMutant(bools);
		
		assertTrue(probes.get(0));
		assertTrue(probes.get(1));
		assertFalse(probes.get(2));
		assertFalse(probes.get(3));
		assertTrue(probes.get(4));
		
		assertEquals(5, probes.size());
		//assert no data linkage
		bools[0] = false;
		assertTrue(probes.get(0));
		
		probes.set(0, false);
		assertFalse(probes.get(0));
		probes.set(0, true);
		assertTrue(probes.get(0));
		
		ProbesMutant copy = new ProbesMutant(probes);
		
		assertTrue(copy.get(0));
		assertTrue(copy.get(1));
		assertFalse(copy.get(2));
		assertFalse(copy.get(3));
		assertTrue(copy.get(4));
		
		assertEquals(5, copy.size());
		
		boolean [] array = copy.getArray();
		
		assertTrue(array[0]);
		assertTrue(array[1]);
		assertFalse(array[2]);
		assertFalse(array[3]);
		assertTrue(array[4]);
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
		return 25;
	}

	@Override
	public int getUniqueAsserts() {
		return 5;
	}


}
