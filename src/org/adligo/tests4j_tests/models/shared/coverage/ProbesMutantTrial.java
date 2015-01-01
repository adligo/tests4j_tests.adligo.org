package org.adligo.tests4j_tests.models.shared.coverage;

import org.adligo.tests4j.models.shared.coverage.Probes;
import org.adligo.tests4j.models.shared.coverage.ProbesMutant;
import org.adligo.tests4j.shared.asserts.common.ExpectedThrownData;
import org.adligo.tests4j.shared.asserts.common.I_Thrower;
import org.adligo.tests4j.shared.asserts.reference.AllowedReferences;
import org.adligo.tests4j.system.shared.trials.SourceFileScope;
import org.adligo.tests4j.system.shared.trials.Test;
import org.adligo.tests4j_tests.base_trials.I_CountType;
import org.adligo.tests4j_tests.base_trials.SourceFileCountingTrial;
import org.adligo.tests4j_tests.references_groups.Tests4J_Coverage_GwtReferenceGroup;

@SourceFileScope (sourceClass=ProbesMutant.class, minCoverage=77.0)
@AllowedReferences (groups=Tests4J_Coverage_GwtReferenceGroup.class)
public class ProbesMutantTrial extends SourceFileCountingTrial {

	
	@SuppressWarnings("boxing")
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

	@SuppressWarnings("boxing")
  @Test
  public void testEqualsHashCodeToString() throws Exception {
	  ProbesMutant pm = new ProbesMutant(new boolean[] {true});
	  ProbesMutant pm1 = new ProbesMutant(new boolean[] {true});
	  ProbesMutant pmb = new ProbesMutant(new boolean[] {false});
	  
	  
	  assertEquals(pm, pm1);
	  assertEquals(pm.hashCode(), pm1.hashCode());
	  assertEquals("ProbesMutant [t]", pm.toString());
	  
	  assertNotEquals(pm, pmb);
    assertNotEquals(pm.hashCode(), pmb.hashCode());
    
    ProbesMutant pmc = new ProbesMutant(new boolean[] {false,true, true});
    ProbesMutant pmd = new ProbesMutant(new boolean[] {false, true, true});
    ProbesMutant pme = new ProbesMutant(new boolean[] {false, true, false});
    
    assertEquals(pmc, pmd);
    assertEquals(pmc.hashCode(), pmd.hashCode());
    assertEquals("ProbesMutant [ftt]", pmc.toString());
    
    assertNotEquals(pmc, pme);
    assertNotEquals(pmc.hashCode(), pme.hashCode());
    
    assertEquals("ProbesMutant [ftf,fft]", new ProbesMutant(new boolean[] {false, true, false,
        false, false, true}).toString());
    
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
		return super.getTests(type, 3, true);
	}
	
	
	@Override
	public int getAsserts(I_CountType type) {
		int thisAsserts = 36;
		//code coverage and circular dependencies +
		//custom afterTrialTests
		//+ see above
		int thisAfterAsserts = 3;
		if (type.isFromMetaWithCoverage()) {
			return super.getAsserts(type, thisAsserts + thisAfterAsserts);
		} else {
			return super.getAsserts(type, thisAsserts);
		}
	}

	@Override
	public int getUniqueAsserts(I_CountType type) {
		int thisUniqueAsserts = 12;
		//code coverage and circular dependencies +
		//custom afterTrialTests
		//+ see above
		int thisAfterUniqueAsserts = 3;
		if (type.isFromMetaWithCoverage()) {
			//code coverage and circular dependencies +
			//custom afterTrialTests
			return super.getUniqueAsserts(type, thisUniqueAsserts + thisAfterUniqueAsserts);
		} else {
			return super.getUniqueAsserts(type, thisUniqueAsserts);
		}
	}


}
