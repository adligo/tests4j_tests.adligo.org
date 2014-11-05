package org.adligo.tests4j_tests.models.shared.coverage;

import org.adligo.tests4j.models.shared.coverage.ClassProbes;
import org.adligo.tests4j.models.shared.coverage.ClassProbesMutant;
import org.adligo.tests4j.models.shared.coverage.ProbesMutant;
import org.adligo.tests4j.shared.asserts.reference.AllowedReferences;
import org.adligo.tests4j.system.shared.trials.SourceFileScope;
import org.adligo.tests4j.system.shared.trials.Test;
import org.adligo.tests4j_tests.base_trials.I_CountType;
import org.adligo.tests4j_tests.base_trials.SourceFileCountingTrial;
import org.adligo.tests4j_tests.references_groups.Tests4J_Coverage_GwtReferenceGroup;

@SourceFileScope (sourceClass=ClassProbes.class, minCoverage=83.0)
@AllowedReferences (groups=Tests4J_Coverage_GwtReferenceGroup.class)
public class ClassProbesTrial extends SourceFileCountingTrial {

	
	@SuppressWarnings("boxing")
  @Test
	public void testCopyConstructor() throws Exception {
	  ClassProbesMutant mut = new ClassProbesMutant();
	  mut.setClassId(73);
	  mut.setClassName("className");
	  
	 
	  ProbesMutant pm = new ProbesMutant(new boolean [] {true, false, true});
	  mut.setProbes(pm);
	  
	  ClassProbes cp = new ClassProbes(mut);
	  assertEquals(73L, cp.getClassId());
    assertEquals("className", cp.getClassName());
    assertEquals(pm, cp.getProbes());
    assertEquals(3, cp.getCoverageUnits());
    assertEquals(2, cp.getCoveredCoverageUnits());
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
