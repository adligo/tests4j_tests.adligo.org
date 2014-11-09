package org.adligo.tests4j_tests.models.shared.coverage;

import org.adligo.tests4j.models.shared.coverage.ClassProbesMutant;
import org.adligo.tests4j.models.shared.coverage.I_ClassProbes;
import org.adligo.tests4j.models.shared.coverage.Probes;
import org.adligo.tests4j.models.shared.coverage.ProbesMutant;
import org.adligo.tests4j.models.shared.coverage.SourceFileProbesMutant;
import org.adligo.tests4j.shared.asserts.reference.AllowedReferences;
import org.adligo.tests4j.system.shared.trials.SourceFileScope;
import org.adligo.tests4j.system.shared.trials.Test;
import org.adligo.tests4j_tests.base_trials.I_CountType;
import org.adligo.tests4j_tests.base_trials.SourceFileCountingTrial;
import org.adligo.tests4j_tests.references_groups.Tests4J_Coverage_GwtReferenceGroup;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@SourceFileScope (sourceClass=SourceFileProbesMutant.class, minCoverage=62.0)
@AllowedReferences (groups=Tests4J_Coverage_GwtReferenceGroup.class)
public class SourceFileProbesMutantTrial extends SourceFileCountingTrial {

	
	@SuppressWarnings("boxing")
  @Test
	public void testCopyConstructor() throws Exception {
	  SourceFileProbesMutant mut = new SourceFileProbesMutant();
	  mut.setClassName("className");
	  assertEquals("className", mut.getClassName());
	  
	  ProbesMutant pm = new ProbesMutant(new boolean [] {true, false, true});
	  mut.setProbes(pm);
	  assertSame(pm, mut.getProbes());
	  
	  List<ClassProbesMutant> listCps = new ArrayList<ClassProbesMutant>();
	  ClassProbesMutant cpm3 = new ClassProbesMutant();
    cpm3.setClassId(73);
    listCps.add(cpm3);
    
    ClassProbesMutant cpm4 = new ClassProbesMutant();
    cpm4.setClassId(74);
    listCps.add(cpm4);
    mut.setClassProbes(listCps);
    
    List<I_ClassProbes> fromMutCPs = mut.getClassProbes();
    assertContains(fromMutCPs,cpm3);
    assertContains(fromMutCPs,cpm4);
    assertEquals(2, fromMutCPs.size());
    
	  mut.setProbes(new Probes(pm));
	  assertEquals(pm, mut.getProbes());
	  
	  SourceFileProbesMutant mut2 = new SourceFileProbesMutant(mut);
	  assertEquals("className", mut2.getClassName());
    assertEquals(pm, mut2.getProbes());
    
    List<I_ClassProbes> fromMutCPs2 = mut2.getClassProbes();
    assertContains(fromMutCPs2,cpm3);
    assertContains(fromMutCPs2,cpm4);
    assertEquals(2, fromMutCPs2.size());
    

	}

	@SuppressWarnings("boxing")
  @Test
	public void testNonMutantSetters() {
	  SourceFileProbesMutant mut = new SourceFileProbesMutant();
    
    List<ClassProbesMutant> listCps3 = new ArrayList<ClassProbesMutant>();
    ClassProbesMutant cpm5 = new ClassProbesMutant();
    cpm5.setClassId(75);
    listCps3.add(cpm5);
    
    ClassProbesMutant cpm6 = new ClassProbesMutant();
    cpm6.setClassId(76);
    listCps3.add(cpm6);
    mut.setClassProbes(listCps3);
    
    List<I_ClassProbes> fromMutCPs4 = mut.getClassProbes();
    Set<Long> ids = new HashSet<Long>();
    for (I_ClassProbes cp: fromMutCPs4) {
      ids.add(cp.getClassId());
    }
    
    assertContains(ids,75L);
    assertContains(ids,76L);
    assertEquals(2, fromMutCPs4.size());
	}
	@Override
	public int getTests(I_CountType type) {
		return super.getTests(type, 2, true);
	}
	
	
	@Override
	public int getAsserts(I_CountType type) {
		int thisAsserts = 14;
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
		int thisUniqueAsserts = 9;
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
