package org.adligo.tests4j_tests.run.common;

import org.adligo.tests4j.run.common.Holder;
import org.adligo.tests4j.shared.asserts.reference.AllowedReferences;
import org.adligo.tests4j.system.shared.trials.SourceFileScope;
import org.adligo.tests4j.system.shared.trials.Test;
import org.adligo.tests4j_tests.base_trials.I_CountType;
import org.adligo.tests4j_tests.base_trials.SourceFileCountingTrial;
import org.adligo.tests4j_tests.references_groups.Tests4J_RunCommon_ReferenceGroup;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

@SourceFileScope (sourceClass=Holder.class, minCoverage=100.0)
@AllowedReferences (groups=Tests4J_RunCommon_ReferenceGroup.class)
public class HolderTrial extends SourceFileCountingTrial {

  @Test
  public void testGetsAndSets() throws Exception {
    
    
    Method [] decMethods =  Holder.class.getDeclaredMethods();
    for (int i = 0; i < decMethods.length; i++) {
      Method m = decMethods[i];
      String methodName = m.getName();
      if (!"$jacocoInit".equals(methodName)) {
        assertTrue("method " + m.getName(), Modifier.isSynchronized(m.getModifiers()));
      }
    }
    
    Holder<String> hold = new Holder<String>();
    hold.setHeld("held");
    assertEquals("held", hold.getHeld());
  }
  

  @Override
  public int getTests(I_CountType type) {
    return super.getTests(type, 1, true);
  }

  @Override
  public int getAsserts(I_CountType type) {
    int thisAsserts = 3;
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
    int thisUniqueAsserts = 3;
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
