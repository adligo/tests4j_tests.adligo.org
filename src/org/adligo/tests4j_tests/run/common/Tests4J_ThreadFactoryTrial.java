package org.adligo.tests4j_tests.run.common;

import org.adligo.tests4j.run.memory.Tests4J_ThreadFactory;
import org.adligo.tests4j.shared.asserts.reference.AllowedReferences;
import org.adligo.tests4j.shared.output.I_Tests4J_Log;
import org.adligo.tests4j.system.shared.trials.SourceFileScope;
import org.adligo.tests4j.system.shared.trials.Test;
import org.adligo.tests4j_tests.base_trials.I_CountType;
import org.adligo.tests4j_tests.base_trials.SourceFileCountingTrial;
import org.adligo.tests4j_tests.references_groups.Tests4J_RunCommon_ReferenceGroup;

/**
 * @author scott
 * 
 */
@SourceFileScope (sourceClass=Tests4J_ThreadFactory.class, minCoverage=1.0)
@AllowedReferences (groups=Tests4J_RunCommon_ReferenceGroup.class)
public class Tests4J_ThreadFactoryTrial extends SourceFileCountingTrial {
  
  @Test
  public void testConstructorLogOnly() {
    I_Tests4J_Log log = mock(I_Tests4J_Log.class);
    Tests4J_ThreadFactory factory = new Tests4J_ThreadFactory(log);
    
    Runnable run = mock(Runnable.class);
    Thread t = factory.newThread(run);
    assertEquals("tests4j-main", t.getName());
  }

  @Override
  public int getTests(I_CountType type) {
    return super.getTests(type, 1, true);
  }
  @Override
  public int getAsserts(I_CountType type) {
    int asserts = 1;
    if (type.isFromMetaWithCoverage()) {
      //code coverage and circular dependencies
      return super.getAsserts(type, asserts + 3);
    } else {
      return super.getAsserts(type, asserts);
    }
  }

  @Override
  public int getUniqueAsserts(I_CountType type) {
    int uAsserts = 1;
    if (type.isFromMetaWithCoverage()) {
      return super.getUniqueAsserts(type, uAsserts+ 3);
    } else {
      return super.getUniqueAsserts(type, uAsserts);
    }
  }
}
