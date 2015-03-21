package org.adligo.tests4j_tests.jacoco.plugin.runtime.simple;

import org.adligo.tests4j.shared.asserts.common.ExpectedThrowable;
import org.adligo.tests4j.shared.asserts.common.I_Thrower;
import org.adligo.tests4j.shared.asserts.reference.CircularDependencies;
import org.adligo.tests4j.system.shared.trials.SourceFileScope;
import org.adligo.tests4j.system.shared.trials.Test;
import org.adligo.tests4j_4jacoco.plugin.common.I_LoggerDataAccessorFactory;
import org.adligo.tests4j_4jacoco.plugin.data.multi.MultiProbesMap;
import org.adligo.tests4j_4jacoco.plugin.runtime.simple.SimpleLoggerRuntime;
import org.adligo.tests4j_tests.base_trials.I_CountType;
import org.adligo.tests4j_tests.base_trials.SourceFileCountingTrial;

import java.util.logging.Logger;

@SourceFileScope (sourceClass=SimpleLoggerRuntime.class,
  minCoverage=10.0,allowedCircularDependencies=CircularDependencies.AllowInPackage)
public class SimpleLoggerRuntimeTrial extends SourceFileCountingTrial {

  @Test
  public void testConstructorThreadGroupsToProbeModificationFilters() {
    I_LoggerDataAccessorFactory factory = mock(I_LoggerDataAccessorFactory.class);
    
    Logger logger = Logger.getLogger(SimpleLoggerRuntimeTrial.class.getName());
    assertNotNull(logger);
    when(factory.getChannel()).thenReturn(SimpleLoggerRuntimeTrial.class.getName());
    
    SimpleLoggerRuntime run = new SimpleLoggerRuntime(factory);
    
    run.putThreadGroupFilter("threadGroupName", null);
    assertEquals("", run.getThreadGroupFilter("threadGroupName"));
    
    run.putThreadGroupFilter("threadGroupName", "");
    assertEquals("", run.getThreadGroupFilter("threadGroupName"));
    
    run.putThreadGroupFilter("threadGroupName", "br");
    assertEquals("br", run.getThreadGroupFilter("threadGroupName"));
  }
  
  @Override
  public int getTests(I_CountType type) {
    return super.getTests(type, 1, false);
  }

  @Override
  public int getAsserts(I_CountType type) {
    int thisAsserts = 4;
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
    int thisUniqueAsserts = 3;
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
  
  private void assertMethodNotImplemented(I_Thrower thrower) {
    assertThrown(new ExpectedThrowable(new IllegalStateException(MultiProbesMap.METHOD_NOT_IMPLEMENTED)), thrower);
  }
}
