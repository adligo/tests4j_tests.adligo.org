package org.adligo.tests4j_tests.jacoco.plugin.data.multi;

import org.adligo.tests4j.models.shared.coverage.I_ClassProbes;
import org.adligo.tests4j.models.shared.coverage.I_Probes;
import org.adligo.tests4j.run.common.I_InitalValueFactory;
import org.adligo.tests4j.run.common.I_ThreadGroupFilter;
import org.adligo.tests4j.run.common.I_ThreadGroupLocal;
import org.adligo.tests4j.run.common.I_ThreadingFactory;
import org.adligo.tests4j.run.common.ThreadingFactory;
import org.adligo.tests4j.run.memory.Tests4J_ThreadFactory;
import org.adligo.tests4j.shared.asserts.common.ExpectedThrownData;
import org.adligo.tests4j.shared.asserts.common.I_Thrower;
import org.adligo.tests4j.shared.asserts.reference.CircularDependencies;
import org.adligo.tests4j.shared.output.I_Tests4J_Log;
import org.adligo.tests4j.system.shared.trials.SourceFileScope;
import org.adligo.tests4j.system.shared.trials.Test;
import org.adligo.tests4j_4jacoco.plugin.data.multi.CascadingProbeMap;
import org.adligo.tests4j_4jacoco.plugin.data.multi.MultiContext;
import org.adligo.tests4j_4jacoco.plugin.data.multi.MultiProbesMap;
import org.adligo.tests4j_4mockito.MethodRecorder;
import org.adligo.tests4j_tests.base_trials.I_CountType;
import org.adligo.tests4j_tests.base_trials.SourceFileCountingTrial;

import java.util.Collections;

@SourceFileScope (sourceClass=MultiProbesMap.class,
  minCoverage=0.0,allowedCircularDependencies=CircularDependencies.AllowInnerOuterClasses)
public class MultiProbesMapTrial extends SourceFileCountingTrial {

  @SuppressWarnings("unused")
  @Test
  public void testConstructorTwoArg() {
    assertThrown(new ExpectedThrownData(NullPointerException.class), new I_Thrower() {
      @Override
      public void run() throws Throwable {
        new MultiProbesMap(null, null);
      }
    });
    assertThrown(new ExpectedThrownData(NullPointerException.class), new I_Thrower() {
      @Override
      public void run() throws Throwable {
        new MultiProbesMap(mock(I_ClassProbes.class), null);
      }
    });
    assertThrown(new ExpectedThrownData(new NullPointerException(
        MultiProbesMap.THE_I_CLASS_PROBES_MUST_CONTAIN_THE_CLASS_NAME_OF_THE_COVERED_CLASS)), 
        new I_Thrower() {
      @Override
      public void run() throws Throwable {
        new MultiProbesMap(mock(I_ClassProbes.class), mock(MultiContext.class));
      }
    });
    I_ClassProbes classProbes = mock(I_ClassProbes.class);
    when(classProbes.getClassName()).thenReturn("cn");
    when(classProbes.getProbes()).thenReturn(mock(I_Probes.class));
    MultiProbesMap mpm = new MultiProbesMap(classProbes, mock(MultiContext.class));
    I_ThreadingFactory factory = mpm.getThreadingFactory();
    assertNotNull(factory);
    assertEquals(ThreadingFactory.INSTANCE.getClass().getName(), factory.getClass().getName());
  }

  @SuppressWarnings("unused")
  @Test
  public void testConstructorThreeArg() {
    assertThrown(new ExpectedThrownData(NullPointerException.class), new I_Thrower() {
      @Override
      public void run() throws Throwable {
        new MultiProbesMap(null, null, null);
      }
    });
    assertThrown(new ExpectedThrownData(NullPointerException.class), new I_Thrower() {
      @Override
      public void run() throws Throwable {
        new MultiProbesMap(mock(I_ClassProbes.class), null, null);
      }
    });
    assertThrown(new ExpectedThrownData(new NullPointerException(
        MultiProbesMap.THE_I_CLASS_PROBES_MUST_CONTAIN_THE_CLASS_NAME_OF_THE_COVERED_CLASS)), 
        new I_Thrower() {
      @Override
      public void run() throws Throwable {
        new MultiProbesMap(mock(I_ClassProbes.class), mock(MultiContext.class), null);
      }
    });
    I_ClassProbes classProbes = mock(I_ClassProbes.class);
    when(classProbes.getClassName()).thenReturn("cn");
    when(classProbes.getProbes()).thenReturn(mock(I_Probes.class));
    I_ThreadingFactory mockFactory = mock(I_ThreadingFactory.class);
    MultiProbesMap mpm = new MultiProbesMap(classProbes, mock(MultiContext.class), mockFactory);
    I_ThreadingFactory factory = mpm.getThreadingFactory();
    assertNotNull(factory);
    assertSame(mockFactory, factory);
  }
  
  /**
   * The inner InitalValueFactory
   * creates the cascaded probes 
   * from 
   */
  @SuppressWarnings({"unchecked", "boxing", "unused"})
  @Test
  public void testConstructorThreeArgValueInitalValueFactoryInnerClass() {
    I_ClassProbes classProbes = mock(I_ClassProbes.class);
    when(classProbes.getClassName()).thenReturn("cn");
    I_Probes probesMock = mock(I_Probes.class);
    when(probesMock.size()).thenReturn(5);
    when(classProbes.getProbes()).thenReturn(probesMock);
    I_ThreadingFactory mockFactory = mock(I_ThreadingFactory.class);
    
    MethodRecorder<I_ThreadGroupLocal<CascadingProbeMap>> threadGroupLocalRecord = 
        new MethodRecorder<I_ThreadGroupLocal<CascadingProbeMap>>();
    I_ThreadGroupFilter filterMock = mock(I_ThreadGroupFilter.class);
    when(mockFactory.createThreadGroupFilter(Tests4J_ThreadFactory.TRIAL_THREAD_GROUP_PREFIX)).thenReturn(filterMock);
    when(mockFactory.createThreadGroupLocal(any(), any())).then(threadGroupLocalRecord);
    MultiContext ctx = mock(MultiContext.class);
    when(ctx.getLog()).thenReturn(mock(I_Tests4J_Log.class));
    new MultiProbesMap(classProbes, ctx, mockFactory);
    
    assertEquals(1, threadGroupLocalRecord.count());
    Object[] args = threadGroupLocalRecord.getArguments(0);
    assertEquals(2, args.length);
    assertSame(filterMock, args[0]);
    I_InitalValueFactory<CascadingProbeMap> valueFactory = (I_InitalValueFactory<CascadingProbeMap>) args[1];
    CascadingProbeMap cpm = valueFactory.createNew();
    assertNotNull(cpm);
    assertEquals(5, cpm.size());
    for (int i = 0; i < 5; i++) {
      assertFalse(cpm.get(i));
    }
    cpm.put(0, true);
    CascadingProbeMap cpmCascade = valueFactory.createNew();
    assertNotNull(cpmCascade);
    assertEquals(5, cpmCascade.size());
    assertTrue(cpmCascade.get(0));
    for (int i = 1; i < 5; i++) {
      assertFalse(cpmCascade.get(i));
    }
    cpm.put(1, true);
    assertTrue(cpmCascade.get(0));
    for (int i = 1; i < 5; i++) {
      assertFalse(cpmCascade.get(i));
    }
    CascadingProbeMap cpmCascadeTwo = valueFactory.createNew();
    assertNotNull(cpmCascadeTwo);
    assertEquals(5, cpmCascadeTwo.size());
    assertTrue(cpmCascadeTwo.get(0));
    assertTrue(cpmCascadeTwo.get(0));
    for (int i = 2; i < 5; i++) {
      assertFalse(cpmCascade.get(i));
    }
  }
  
  @Test
  public void testMethodThreadGroupProbes() {
  }
  
  @Test
  public void testMethodToString() {
  }
  
  @Test
  public void testUnimplementedMethodExceptions() {
    I_ClassProbes classProbes = mock(I_ClassProbes.class);
    when(classProbes.getClassName()).thenReturn("cn");
    when(classProbes.getProbes()).thenReturn(mock(I_Probes.class));
    I_ThreadingFactory mockFactory = mock(I_ThreadingFactory.class);
    MultiProbesMap map = new MultiProbesMap(classProbes, mock(MultiContext.class), mockFactory);
    assertMethodNotImplemented(new I_Thrower() {
      @Override
      public void run() throws Throwable {
        map.containsKey("key");
      }
    });
    assertMethodNotImplemented(new I_Thrower() {
      @Override
      public void run() throws Throwable {
        map.containsValue("key");
      }
    });
    assertMethodNotImplemented(new I_Thrower() {
      @Override
      public void run() throws Throwable {
        map.get("key");
      }
    });
    assertMethodNotImplemented(new I_Thrower() {
      @Override
      public void run() throws Throwable {
        map.remove("key");
      }
    });
    assertMethodNotImplemented(new I_Thrower() {
      @Override
      public void run() throws Throwable {
        map.putAll(Collections.emptyMap());
      }
    });
    assertMethodNotImplemented(new I_Thrower() {
      @Override
      public void run() throws Throwable {
        map.clear();
      }
    });
    assertMethodNotImplemented(new I_Thrower() {
      @Override
      public void run() throws Throwable {
        map.keySet();
      }
    });
    assertMethodNotImplemented(new I_Thrower() {
      @Override
      public void run() throws Throwable {
        map.values();
      }
    });
    assertMethodNotImplemented(new I_Thrower() {
      @Override
      public void run() throws Throwable {
        map.entrySet();
      }
    });
  }
  
  @Override
  public int getTests(I_CountType type) {
    return super.getTests(type, 6, false);
  }

  @Override
  public int getAsserts(I_CountType type) {
    int thisAsserts = 48;
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
    int thisUniqueAsserts = 28;
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
    assertThrown(new ExpectedThrownData(new IllegalStateException(MultiProbesMap.METHOD_NOT_IMPLEMENTED)), thrower);
  }
}
