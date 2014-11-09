package org.adligo.tests4j_tests.models.shared.coverage;

import org.adligo.tests4j.models.shared.coverage.ClassProbes;
import org.adligo.tests4j.models.shared.coverage.ClassProbesMutant;
import org.adligo.tests4j.models.shared.coverage.I_ClassProbes;
import org.adligo.tests4j.models.shared.coverage.Probes;
import org.adligo.tests4j.models.shared.coverage.ProbesMutant;
import org.adligo.tests4j.models.shared.coverage.SourceFileProbes;
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

@SourceFileScope (sourceClass=SourceFileProbes.class, minCoverage=56.0)
@AllowedReferences (groups=Tests4J_Coverage_GwtReferenceGroup.class)
public class SourceFileProbesTrial extends SourceFileCountingTrial {

	
	@SuppressWarnings("boxing")
  @Test
	public void testCopyConstructor() throws Exception {
	  SourceFileProbesMutant mut = new SourceFileProbesMutant();
	  mut.setClassName("className");
	 
	  ProbesMutant pm = new ProbesMutant(new boolean [] {true, false, true});
	  mut.setProbes(pm);
	 
	  List<ClassProbes> listCps = new ArrayList<ClassProbes>();
	  ClassProbesMutant cpm3 = new ClassProbesMutant();
    cpm3.setClassId(73);
    cpm3.setClassName("cn");
    cpm3.setProbes(new Probes(new boolean[] {true}));
    listCps.add(new ClassProbes(cpm3));
    
    ClassProbesMutant cpm4 = new ClassProbesMutant();
    cpm4.setClassId(74);
    cpm4.setClassName("cn");
    cpm4.setProbes(new Probes(new boolean[] {true}));
    listCps.add(new ClassProbes(cpm4));
    mut.setClassProbes(listCps);
    
	  SourceFileProbes mut2 = new SourceFileProbes(mut);
	  assertEquals("className", mut2.getClassName());
    assertEquals(pm, mut2.getProbes());
    
    List<I_ClassProbes> fromMutCPs4 = mut2.getClassProbes();
    Set<Long> ids = new HashSet<Long>();
    for (I_ClassProbes cp: fromMutCPs4) {
      ids.add(cp.getClassId());
    }
    
    assertContains(ids,73L);
    assertContains(ids,74L);
    assertEquals(2, fromMutCPs4.size());

	}

	@Override
	public int getTests(I_CountType type) {
		return super.getTests(type, 1, true);
	}
	
	
	@Override
	public int getAsserts(I_CountType type) {
		int thisAsserts = 5;
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
		int thisUniqueAsserts = 5;
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
