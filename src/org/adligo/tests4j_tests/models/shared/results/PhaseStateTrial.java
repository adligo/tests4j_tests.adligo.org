package org.adligo.tests4j_tests.models.shared.results;

import org.adligo.tests4j.models.shared.results.PhaseState;
import org.adligo.tests4j.models.shared.results.PhaseStateMutant;
import org.adligo.tests4j.shared.asserts.reference.AllowedReferences;
import org.adligo.tests4j.system.shared.api.I_Tests4J_TrialProgress;
import org.adligo.tests4j.system.shared.api.Tests4J_TrialProgress;
import org.adligo.tests4j.system.shared.trials.SourceFileScope;
import org.adligo.tests4j.system.shared.trials.Test;
import org.adligo.tests4j_tests.base_trials.I_CountType;
import org.adligo.tests4j_tests.base_trials.SourceFileCountingTrial;
import org.adligo.tests4j_tests.references_groups.Tests4J_Results_GwtReferenceGroup;

import java.util.ArrayList;
import java.util.List;

@SourceFileScope (sourceClass=PhaseState.class, minCoverage=91.0)
@AllowedReferences (groups=Tests4J_Results_GwtReferenceGroup.class)
public class PhaseStateTrial extends SourceFileCountingTrial {


	
	@SuppressWarnings("boxing")
  @Test
	public void testCopyConstructorAndToString() {
    PhaseStateMutant psm = new PhaseStateMutant();
    psm.setCount(13);
    psm.setDoneCount(12);
    
    psm.setPercentDone(1.01);
    psm.setHasFinishedAll(true);
    psm.setHasStartedAll(true);
    
    psm.setProcessName("processName");
    psm.setRunnablesFinished(2);
    psm.setRunnablesStarted(1);
    
    psm.setThreadCount(5);
    List<I_Tests4J_TrialProgress> trials = new ArrayList<I_Tests4J_TrialProgress>();
    Tests4J_TrialProgress prog = new Tests4J_TrialProgress("trialName", 12.1, null);
    trials.add(prog);
    psm.setTrials(trials);
    
    PhaseState copy = new PhaseState(psm);
    assertEquals(13, copy.getCount());
    assertEquals(12, copy.getDoneCount());
    
    assertTrue(copy.hasFinishedAll());
    assertTrue(copy.hasStartedAll());
    
    assertEquals(1.01, copy.getPercentDone());
    assertEquals("processName", copy.getProcessName());
    assertEquals(2, copy.getRunnablesFinished());
    assertEquals(1, copy.getRunnablesStarted());
    assertEquals(5, copy.getThreadCount());
    
    List<I_Tests4J_TrialProgress> pt = psm.getTrials();
    assertNotNull(pt);
    assertEquals(1, pt.size());
    I_Tests4J_TrialProgress otherProg = pt.get(0);
    assertEquals("trialName", otherProg.getTrialName());
    assertEquals(12.1, otherProg.getPctDone());
	}
	
	@Override
	public int getTests(I_CountType type) {
		return super.getTests(type, 1, true);
	}

	@Override
	public int getAsserts(I_CountType type) {
		int thisAsserts = 13;
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
