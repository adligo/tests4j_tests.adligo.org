package org.adligo.tests4j_tests.models.shared.coverage;

import org.adligo.tests4j.models.shared.coverage.ClassProbesMutant;
import org.adligo.tests4j.models.shared.coverage.ProbesMutant;
import org.adligo.tests4j.shared.asserts.reference.AllowedReferences;
import org.adligo.tests4j.system.shared.trials.SourceFileScope;
import org.adligo.tests4j.system.shared.trials.Test;
import org.adligo.tests4j_tests.base_trials.I_CountType;
import org.adligo.tests4j_tests.base_trials.SourceFileCountingTrial;
import org.adligo.tests4j_tests.references_groups.Tests4J_Coverage_GwtReferenceGroup;

@SourceFileScope (sourceClass=ClassProbesMutant.class, minCoverage=80.0)
@AllowedReferences (groups=Tests4J_Coverage_GwtReferenceGroup.class)
public class ClassProbesMutantTrial extends SourceFileCountingTrial {

	
	@SuppressWarnings("boxing")
  @Test
	public void testCopyConstructor() throws Exception {
	  ClassProbesMutant mut = new ClassProbesMutant();
	  mut.setClassId(73);
	  assertEquals(73L, mut.getClassId());
	  mut.setClassName("className");
	  assertEquals("className", mut.getClassName());
	  
	 
	  ProbesMutant pm = new ProbesMutant(new boolean [] {true, false, true});
	  mut.setProbes(pm);
	  assertSame(pm, mut.getProbes());
	  
	  ClassProbesMutant mut2 = new ClassProbesMutant(mut);
	  assertEquals(73L, mut2.getClassId());
    assertEquals("className", mut2.getClassName());
    assertEquals(pm, mut2.getProbes());
	}

	@Override
	public int getTests(I_CountType type) {
		return super.getTests(type, 1, true);
	}
	
	
	@Override
	public int getAsserts(I_CountType type) {
		int thisAsserts = 6;
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
		int thisUniqueAsserts = 4;
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
