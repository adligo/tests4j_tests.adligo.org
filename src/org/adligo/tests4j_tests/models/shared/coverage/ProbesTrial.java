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

@SourceFileScope (sourceClass=Probes.class, minCoverage=92.0)
@AllowedReferences (groups=Tests4J_Coverage_GwtReferenceGroup.class)
public class ProbesTrial extends SourceFileCountingTrial {

	
	@SuppressWarnings("boxing")
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
		assertThrown(new ExpectedThrownData(NullPointerException.class), 
				new I_Thrower() {
					
					@Override
					public void run() {
						new Probes((boolean []) null);
					}
				});
	}
	
	 @SuppressWarnings("boxing")
	  @Test
	  public void testEqualsHashCodeToString() throws Exception {
	    Probes pm = new Probes(new boolean[] {true});
	    Probes pm1 = new Probes(new boolean[] {true});
	    Probes pmb = new Probes(new boolean[] {false});
	    
	    
	    assertEquals(pm, pm1);
	    assertEquals(pm.hashCode(), pm1.hashCode());
	    assertEquals("Probes [t]", pm.toString());
	    
	    assertNotEquals(pm, pmb);
	    assertNotEquals(pm.hashCode(), pmb.hashCode());
	    
	    Probes pmc = new Probes(new boolean[] {false,true, true});
	    Probes pmd = new Probes(new boolean[] {false, true, true});
	    Probes pme = new Probes(new boolean[] {false, true, false});
	    
	    assertEquals(pmc, pmd);
	    assertEquals(pmc.hashCode(), pmd.hashCode());
	    assertEquals("Probes [ftt]", pmc.toString());
	    
	    assertNotEquals(pmc, pme);
	    assertNotEquals(pmc.hashCode(), pme.hashCode());
	    
	    assertEquals("Probes [ftf,fft]", new Probes(new boolean[] {false, true, false,
	        false, false, true}).toString());
	    
	  }
	@Override
	public int getTests(I_CountType type) {
		return super.getTests(type, 3, true);
	}

	@Override
	public int getAsserts(I_CountType type) {
		int thisAsserts = 25;
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
		int thisUniqueAsserts = 11;
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
