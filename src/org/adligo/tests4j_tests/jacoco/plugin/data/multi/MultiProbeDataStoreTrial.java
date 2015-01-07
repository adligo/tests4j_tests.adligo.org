package org.adligo.tests4j_tests.jacoco.plugin.data.multi;

import org.adligo.tests4j.shared.asserts.reference.CircularDependencies;
import org.adligo.tests4j.system.shared.trials.SourceFileScope;
import org.adligo.tests4j.system.shared.trials.Test;
import org.adligo.tests4j_4jacoco.plugin.data.multi.MultiProbeDataStore;
import org.adligo.tests4j_tests.base_trials.I_CountType;
import org.adligo.tests4j_tests.base_trials.SourceFileCountingTrial;

@SourceFileScope (sourceClass=MultiProbeDataStore.class,
  minCoverage=0.0,allowedCircularDependencies=CircularDependencies.AllowInnerOuterClasses)
public class MultiProbeDataStoreTrial extends SourceFileCountingTrial {

  @Test
  public void testGetSourceFileCoverage() {
    
  }
  

  @Override
  public int getTests(I_CountType type) {
    return super.getTests(type, 1);
  }

  @Override
  public int getAsserts(I_CountType type) {
    int thisAsserts = 0;
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
    int thisUniqueAsserts = 0;
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
