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
import org.adligo.tests4j_4jacoco.plugin.common.I_Runtime;
import org.adligo.tests4j_4jacoco.plugin.data.multi.CascadingProbeMap;
import org.adligo.tests4j_4jacoco.plugin.data.multi.MultiContext;
import org.adligo.tests4j_4jacoco.plugin.data.multi.MultiProbesMap;
import org.adligo.tests4j_4mockito.MockMethod;
import org.adligo.tests4j_tests.base_trials.I_CountType;
import org.adligo.tests4j_tests.base_trials.SourceFileCountingTrial;

import java.util.Collections;

@SourceFileScope (sourceClass=MultiProbesMap.class,
  minCoverage=96.0,allowedCircularDependencies=CircularDependencies.AllowInnerOuterClasses)
public class MultiProbesMapTrial extends SourceFileCountingTrial {

  @SuppressWarnings({"unused", "boxing"})
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
    assertEquals(0, mpm.size());
    assertTrue(mpm.isEmpty());
    assertEquals("cn", mpm.getClassCovered());
    boolean [] probes = mpm.getProbes();
    assertNotNull(probes);
    assertEquals(0, probes.length);
    assertEquals(0L, mpm.getClassId());
    
  }

  @SuppressWarnings({"unused", "boxing"})
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
    when(classProbes.getClassId()).thenReturn(13L);
    when(classProbes.getClassName()).thenReturn("cn");
    I_Probes probesMock = mock(I_Probes.class);
    when(probesMock.size()).thenReturn(5);
    when(classProbes.getProbes()).thenReturn(probesMock);
    I_ThreadingFactory mockFactory = mock(I_ThreadingFactory.class);
    MultiProbesMap mpm = new MultiProbesMap(classProbes, mock(MultiContext.class), mockFactory);
    I_ThreadingFactory factory = mpm.getThreadingFactory();
    assertNotNull(factory);
    assertSame(mockFactory, factory);
    assertEquals(5, mpm.size());
    assertFalse(mpm.isEmpty());
    assertEquals("cn", mpm.getClassCovered());
    boolean [] probes = mpm.getProbes();
    assertNotNull(probes);
    assertEquals(5, probes.length);
    for (int i = 0; i < probes.length; i++) {
      assertFalse(probes[i]);
    }
    assertEquals(13L, mpm.getClassId());
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
    
    MockMethod<I_ThreadGroupLocal<CascadingProbeMap>> threadGroupLocalRecord = 
        new MockMethod<I_ThreadGroupLocal<CascadingProbeMap>>();
    I_ThreadGroupFilter filterMock = mock(I_ThreadGroupFilter.class);
    when(mockFactory.createThreadGroupFilter(Tests4J_ThreadFactory.TRIAL_THREAD_GROUP_PREFIX)).thenReturn(filterMock);
    when(mockFactory.createThreadGroupLocal(any(), any())).then(threadGroupLocalRecord);
    MultiContext ctx = mock(MultiContext.class);
    
    I_Tests4J_Log logMock = mock(I_Tests4J_Log.class);
    MockMethod<Void> logRecord = new MockMethod<Void>();
    doAnswer(logRecord).when(logMock).log(any());
    when(logMock.getThreadWithGroupNameMessage()).thenReturn("MockThread/MockThreadGroup");
    when(logMock.isLogEnabled(any())).thenReturn(true);
    when(logMock.getLineSeperator()).thenReturn("\nlineSeperator");
    
    when(ctx.getLog()).thenReturn(logMock);
    new MultiProbesMap(classProbes, ctx, mockFactory);
    
    assertEquals(1, threadGroupLocalRecord.count());
    Object[] args = threadGroupLocalRecord.getArgs(0);
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
    assertEquals(1, logRecord.count());
    String logMessage = (String) logRecord.getArg(0);
    assertEquals("MultiProbesMap MockThread/MockThreadGroup\nlineSeperator" +
        "\tis creating new probes for the following class;\nlineSeperator" +
        "\tcn", logMessage);
    
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
    assertEquals(1, logRecord.count());
    
    CascadingProbeMap cpmCascadeTwo = valueFactory.createNew();
    assertNotNull(cpmCascadeTwo);
    assertEquals(5, cpmCascadeTwo.size());
    assertTrue(cpmCascadeTwo.get(0));
    assertTrue(cpmCascadeTwo.get(0));
    for (int i = 2; i < 5; i++) {
      assertFalse(cpmCascade.get(i));
    }
  }
  
  /**
   * The inner InitalValueFactory
   * creates the cascaded probes 
   * from 
   */
  @SuppressWarnings({"unchecked", "boxing", "unused"})
  @Test
  public void testConstructorThreeArgValueInitalValueFactoryInnerClassNoLogging() {
    I_ClassProbes classProbes = mock(I_ClassProbes.class);
    when(classProbes.getClassName()).thenReturn("cn");
    I_Probes probesMock = mock(I_Probes.class);
    when(probesMock.size()).thenReturn(5);
    when(classProbes.getProbes()).thenReturn(probesMock);
    I_ThreadingFactory mockFactory = mock(I_ThreadingFactory.class);
    
    MockMethod<I_ThreadGroupLocal<CascadingProbeMap>> threadGroupLocalRecord = 
        new MockMethod<I_ThreadGroupLocal<CascadingProbeMap>>();
    I_ThreadGroupFilter filterMock = mock(I_ThreadGroupFilter.class);
    when(mockFactory.createThreadGroupFilter(Tests4J_ThreadFactory.TRIAL_THREAD_GROUP_PREFIX)).thenReturn(filterMock);
    when(mockFactory.createThreadGroupLocal(any(), any())).then(threadGroupLocalRecord);
    MultiContext ctx = mock(MultiContext.class);
    
    I_Tests4J_Log logMock = mock(I_Tests4J_Log.class);
    MockMethod<Void> logRecord = new MockMethod<Void>();
    doAnswer(logRecord).when(logMock).log(any());
    
    when(ctx.getLog()).thenReturn(logMock);
    new MultiProbesMap(classProbes, ctx, mockFactory);
    
    assertEquals(1, threadGroupLocalRecord.count());
    Object[] args = threadGroupLocalRecord.getArgs(0);
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
    assertEquals(0, logRecord.count());
    
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
    assertEquals(0, logRecord.count());
    
    CascadingProbeMap cpmCascadeTwo = valueFactory.createNew();
    assertNotNull(cpmCascadeTwo);
    assertEquals(5, cpmCascadeTwo.size());
    assertTrue(cpmCascadeTwo.get(0));
    assertTrue(cpmCascadeTwo.get(0));
    for (int i = 2; i < 5; i++) {
      assertFalse(cpmCascade.get(i));
    }
  }
  
  
  @SuppressWarnings("boxing")
  @Test
  public void testMethodPutBadParams() {
    I_ClassProbes classProbes = mock(I_ClassProbes.class);
    when(classProbes.getClassName()).thenReturn("cn");
    I_Probes probesMock = mock(I_Probes.class);
    when(probesMock.size()).thenReturn(5);
    when(classProbes.getProbes()).thenReturn(probesMock);
    I_ThreadingFactory mockFactory = mock(I_ThreadingFactory.class);
    
    MockMethod<I_ThreadGroupLocal<CascadingProbeMap>> threadGroupLocalRecord = 
        new MockMethod<I_ThreadGroupLocal<CascadingProbeMap>>();
    I_ThreadGroupFilter filterMock = mock(I_ThreadGroupFilter.class);
    when(mockFactory.createThreadGroupFilter(Tests4J_ThreadFactory.TRIAL_THREAD_GROUP_PREFIX)).thenReturn(filterMock);
    when(mockFactory.createThreadGroupLocal(any(), any())).then(threadGroupLocalRecord);
    MultiContext ctx = mock(MultiContext.class);
    
    I_Tests4J_Log logMock = mock(I_Tests4J_Log.class);
    MockMethod<Void> logRecord = new MockMethod<Void>();
    doAnswer(logRecord).when(logMock).log(any());
    
    when(ctx.getLog()).thenReturn(logMock);
    MultiProbesMap map = new MultiProbesMap(classProbes, ctx, mockFactory);
    
    assertFalse(map.put(null, null));
    assertFalse(map.put(1, null));
    assertFalse(map.put(1, false));
    assertFalse(map.put(6, true));
    assertFalse(map.put(-1, true));
    
  }
  
  @SuppressWarnings("boxing")
  @Test
  public void testMethodPut() {
    
    I_ClassProbes classProbes = mock(I_ClassProbes.class);
    when(classProbes.getClassName()).thenReturn("cn");
    I_Probes probesMock = mock(I_Probes.class);
    when(probesMock.size()).thenReturn(5);
    when(classProbes.getProbes()).thenReturn(probesMock);
    I_ThreadingFactory mockFactory = mock(I_ThreadingFactory.class);
    
    MockMethod<I_ThreadGroupLocal<CascadingProbeMap>> threadGroupLocalRecord = 
        new MockMethod<I_ThreadGroupLocal<CascadingProbeMap>>();
    I_ThreadGroupFilter filterMock = mock(I_ThreadGroupFilter.class);
    when(filterMock.getThreadGroupNameMatchingFilter()).thenReturn("hmm");
    when(mockFactory.createThreadGroupFilter(Tests4J_ThreadFactory.TRIAL_THREAD_GROUP_PREFIX)).thenReturn(filterMock);
    when(mockFactory.createThreadGroupLocal(any(), any())).then(threadGroupLocalRecord);
    MultiContext ctx = mock(MultiContext.class);
    
    I_Tests4J_Log logMock = mock(I_Tests4J_Log.class);
    MockMethod<Void> logRecord = new MockMethod<Void>();
    doAnswer(logRecord).when(logMock).log(any());
    when(logMock.isLogEnabled(any())).thenReturn(true);
    when(logMock.getLineSeperator()).thenReturn("\nls");
    when(logMock.getThreadWithGroupNameMessage()).thenReturn("MockThread/MockThreadGroup");
    
    I_Runtime runtimeMock = mock(I_Runtime.class);
    when(runtimeMock.getThreadGroupFilter("hmm")).thenReturn("filter");
    when(ctx.getRuntime()).thenReturn(runtimeMock);
    
    when(ctx.getLog()).thenReturn(logMock);
    MultiProbesMap map = new MultiProbesMap(classProbes, ctx, mockFactory);
    
    map.put(0, true);
    boolean [] probes = map.getProbes();
    assertEquals(5, probes.length);
    assertTrue(probes[0]);
    for (int i = 1; i < probes.length; i++) {
      assertFalse(probes[i]);
    }
    assertEquals(1, logRecord.count());
    String logMessage = (String) logRecord.getArg(0);
    assertEquals("MultiProbesMap MockThread/MockThreadGroup\nls"
        + "\tdetected the following probe hit;\nls"
        + "\tcn\nls"
        + "\tprobes 1/5", logMessage);
  }
  
  @SuppressWarnings("boxing")
  @Test
  public void testMethodPutNoLog() {
    I_ClassProbes classProbes = mock(I_ClassProbes.class);
    when(classProbes.getClassName()).thenReturn("cn");
    I_Probes probesMock = mock(I_Probes.class);
    when(probesMock.size()).thenReturn(5);
    when(classProbes.getProbes()).thenReturn(probesMock);
    I_ThreadingFactory mockFactory = mock(I_ThreadingFactory.class);
    
    MockMethod<I_ThreadGroupLocal<CascadingProbeMap>> threadGroupLocalRecord = 
        new MockMethod<I_ThreadGroupLocal<CascadingProbeMap>>();
    I_ThreadGroupFilter filterMock = mock(I_ThreadGroupFilter.class);
    when(filterMock.getThreadGroupNameMatchingFilter()).thenReturn("hmm");
    when(mockFactory.createThreadGroupFilter(Tests4J_ThreadFactory.TRIAL_THREAD_GROUP_PREFIX)).thenReturn(filterMock);
    when(mockFactory.createThreadGroupLocal(any(), any())).then(threadGroupLocalRecord);
    MultiContext ctx = mock(MultiContext.class);
    
    I_Tests4J_Log logMock = mock(I_Tests4J_Log.class);
    MockMethod<Void> logRecord = new MockMethod<Void>();
    doAnswer(logRecord).when(logMock).log(any());
    
    I_Runtime runtimeMock = mock(I_Runtime.class);
    when(runtimeMock.getThreadGroupFilter("hmm")).thenReturn("filter");
    when(ctx.getRuntime()).thenReturn(runtimeMock);
    
    when(ctx.getLog()).thenReturn(logMock);
    MultiProbesMap map = new MultiProbesMap(classProbes, ctx, mockFactory);
    
    map.put(0, true);
    boolean [] probes = map.getProbes();
    assertEquals(5, probes.length);
    assertTrue(probes[0]);
    for (int i = 1; i < probes.length; i++) {
      assertFalse(probes[i]);
    }
    assertEquals(0, logRecord.count());
  }
  
  @SuppressWarnings({"boxing", "unchecked"})
  @Test
  public void testMethodPutThreadLocal() {
    I_ClassProbes classProbes = mock(I_ClassProbes.class);
    when(classProbes.getClassName()).thenReturn("cn");
    I_Probes probesMock = mock(I_Probes.class);
    when(probesMock.size()).thenReturn(5);
    when(classProbes.getProbes()).thenReturn(probesMock);
    I_ThreadingFactory mockFactory = mock(I_ThreadingFactory.class);
    
    CascadingProbeMap cascadingProbeMap = new CascadingProbeMap(new boolean[5]);
    I_ThreadGroupLocal<CascadingProbeMap> threadGroupLocalMock = mock(I_ThreadGroupLocal.class);
    when(threadGroupLocalMock.getValue()).thenReturn(cascadingProbeMap);
    
    MockMethod<I_ThreadGroupLocal<CascadingProbeMap>> threadGroupLocalRecord = 
        new MockMethod<I_ThreadGroupLocal<CascadingProbeMap>>(threadGroupLocalMock, true);
    I_ThreadGroupFilter filterMock = mock(I_ThreadGroupFilter.class);
    when(filterMock.getThreadGroupNameMatchingFilter()).thenReturn("hmm");
    when(mockFactory.createThreadGroupFilter(Tests4J_ThreadFactory.TRIAL_THREAD_GROUP_PREFIX)).thenReturn(filterMock);
    when(mockFactory.createThreadGroupLocal(any(), any())).then(threadGroupLocalRecord);
    MultiContext ctx = mock(MultiContext.class);
    
    I_Tests4J_Log logMock = mock(I_Tests4J_Log.class);
    MockMethod<Void> logRecord = new MockMethod<Void>();
    doAnswer(logRecord).when(logMock).log(any());
    when(logMock.isLogEnabled(any())).thenReturn(true);
    when(logMock.getLineSeperator()).thenReturn("\nls");
    when(logMock.getThreadWithGroupNameMessage()).thenReturn("MockThread/MockThreadGroup");
    
    I_Runtime runtimeMock = mock(I_Runtime.class);
    when(runtimeMock.getThreadGroupFilter("hmm")).thenReturn("filter");
    when(ctx.getRuntime()).thenReturn(runtimeMock);
    
    when(ctx.getLog()).thenReturn(logMock);
    MultiProbesMap map = new MultiProbesMap(classProbes, ctx, mockFactory);
    
    //have to set the regular probe first
    map.put(0, true);
    boolean [] probes = map.getProbes();
    assertEquals(5, probes.length);
    assertTrue(probes[0]);
    for (int i = 1; i < probes.length; i++) {
      assertFalse(probes[i]);
    }
    assertEquals(1, logRecord.count());
    String logMessage = (String) logRecord.getArg(0);
    assertEquals("MultiProbesMap MockThread/MockThreadGroup\nls"
        + "\tdetected the following probe hit;\nls"
        + "\tcn\nls"
        + "\tprobes 1/5", logMessage);
    
    assertFalse(cascadingProbeMap.get(0));
    when(runtimeMock.getThreadGroupFilter("hmm")).thenReturn("cn");
    map.put(0, true);
    
    assertEquals(5, probes.length);
    assertTrue(probes[0]);
    assertTrue(cascadingProbeMap.get(0));
    for (int i = 1; i < probes.length; i++) {
      assertFalse(probes[i]);
      assertFalse(cascadingProbeMap.get(i));
    }
    assertEquals(2, logRecord.count());
    logMessage = (String) logRecord.getArg(1);
    assertEquals("MultiProbesMap MockThread/MockThreadGroup\nls"
        + "\tdetected the following probe hit;\nls"
        + "\tcn\nls"
        + "\tthreadGroupLocalProbes 1/5", logMessage);
  }
  
  @SuppressWarnings({"boxing", "unchecked"})
  @Test
  public void testMethodPutThreadLocalNoLog() {
    I_ClassProbes classProbes = mock(I_ClassProbes.class);
    when(classProbes.getClassName()).thenReturn("cn");
    I_Probes probesMock = mock(I_Probes.class);
    when(probesMock.size()).thenReturn(5);
    when(classProbes.getProbes()).thenReturn(probesMock);
    I_ThreadingFactory mockFactory = mock(I_ThreadingFactory.class);
    
    CascadingProbeMap cascadingProbeMap = new CascadingProbeMap(new boolean[5]);
    I_ThreadGroupLocal<CascadingProbeMap> threadGroupLocalMock = mock(I_ThreadGroupLocal.class);
    when(threadGroupLocalMock.getValue()).thenReturn(cascadingProbeMap);
    
    MockMethod<I_ThreadGroupLocal<CascadingProbeMap>> threadGroupLocalRecord = 
        new MockMethod<I_ThreadGroupLocal<CascadingProbeMap>>(threadGroupLocalMock, true);
    I_ThreadGroupFilter filterMock = mock(I_ThreadGroupFilter.class);
    when(filterMock.getThreadGroupNameMatchingFilter()).thenReturn("hmm");
    when(mockFactory.createThreadGroupFilter(Tests4J_ThreadFactory.TRIAL_THREAD_GROUP_PREFIX)).thenReturn(filterMock);
    when(mockFactory.createThreadGroupLocal(any(), any())).then(threadGroupLocalRecord);
    MultiContext ctx = mock(MultiContext.class);
    
    I_Tests4J_Log logMock = mock(I_Tests4J_Log.class);
    MockMethod<Void> logRecord = new MockMethod<Void>();
    doAnswer(logRecord).when(logMock).log(any());
    
    I_Runtime runtimeMock = mock(I_Runtime.class);
    when(runtimeMock.getThreadGroupFilter("hmm")).thenReturn("filter");
    when(ctx.getRuntime()).thenReturn(runtimeMock);
    
    when(ctx.getLog()).thenReturn(logMock);
    MultiProbesMap map = new MultiProbesMap(classProbes, ctx, mockFactory);
    
    //have to set the regular probe first
    map.put(0, true);
    boolean [] probes = map.getProbes();
    assertEquals(5, probes.length);
    assertTrue(probes[0]);
    for (int i = 1; i < probes.length; i++) {
      assertFalse(probes[i]);
    }
    assertEquals(0, logRecord.count());
    
    assertFalse(cascadingProbeMap.get(0));
    //ok now set the threadLocalProbe only
    when(runtimeMock.getThreadGroupFilter("hmm")).thenReturn("cn");
    map.put(0, true);
    
    assertEquals(5, probes.length);
    assertTrue(probes[0]);
    assertTrue(cascadingProbeMap.get(0));
    for (int i = 1; i < probes.length; i++) {
      assertFalse(probes[i]);
      assertFalse(cascadingProbeMap.get(i));
    }
    assertEquals(0, logRecord.count());
  }
  
  @SuppressWarnings({"boxing", "unchecked"})
  @Test
  public void testMethodPutGlobalAndThreadLocal() {
    I_ClassProbes classProbes = mock(I_ClassProbes.class);
    when(classProbes.getClassName()).thenReturn("cn");
    I_Probes probesMock = mock(I_Probes.class);
    when(probesMock.size()).thenReturn(5);
    when(classProbes.getProbes()).thenReturn(probesMock);
    I_ThreadingFactory mockFactory = mock(I_ThreadingFactory.class);
    
    CascadingProbeMap cascadingProbeMap = new CascadingProbeMap(new boolean[5]);
    I_ThreadGroupLocal<CascadingProbeMap> threadGroupLocalMock = mock(I_ThreadGroupLocal.class);
    when(threadGroupLocalMock.getValue()).thenReturn(cascadingProbeMap);
    
    MockMethod<I_ThreadGroupLocal<CascadingProbeMap>> threadGroupLocalRecord = 
        new MockMethod<I_ThreadGroupLocal<CascadingProbeMap>>(threadGroupLocalMock, true);
    I_ThreadGroupFilter filterMock = mock(I_ThreadGroupFilter.class);
    when(filterMock.getThreadGroupNameMatchingFilter()).thenReturn("hmm");
    when(mockFactory.createThreadGroupFilter(Tests4J_ThreadFactory.TRIAL_THREAD_GROUP_PREFIX)).thenReturn(filterMock);
    when(mockFactory.createThreadGroupLocal(any(), any())).then(threadGroupLocalRecord);
    MultiContext ctx = mock(MultiContext.class);
    
    I_Tests4J_Log logMock = mock(I_Tests4J_Log.class);
    MockMethod<Void> logRecord = new MockMethod<Void>();
    doAnswer(logRecord).when(logMock).log(any());
    when(logMock.isLogEnabled(any())).thenReturn(true);
    when(logMock.getLineSeperator()).thenReturn("\nls");
    when(logMock.getThreadWithGroupNameMessage()).thenReturn("MockThread/MockThreadGroup");
    
    I_Runtime runtimeMock = mock(I_Runtime.class);
    when(runtimeMock.getThreadGroupFilter("hmm")).thenReturn("cn");
    when(ctx.getRuntime()).thenReturn(runtimeMock);
    
    when(ctx.getLog()).thenReturn(logMock);
    MultiProbesMap map = new MultiProbesMap(classProbes, ctx, mockFactory);
    
    //have to set the regular probe first
    map.put(0, true);
    boolean [] probes = map.getProbes();
    assertEquals(5, probes.length);
    assertTrue(probes[0]);
    for (int i = 1; i < probes.length; i++) {
      assertFalse(probes[i]);
    }
    assertEquals(1, logRecord.count());
    String logMessage = (String) logRecord.getArg(0);
    assertEquals("MultiProbesMap MockThread/MockThreadGroup\nls"
        + "\tdetected the following probe hit;\nls"
        + "\tcn\nls"
        + "\tprobes threadGroupLocalProbes 1/5", logMessage);
    
  }
  
  @SuppressWarnings({"boxing", "unchecked"})
  @Test
  public void testMethodPutGlobalAndThreadLocalNoLog() {
    I_ClassProbes classProbes = mock(I_ClassProbes.class);
    when(classProbes.getClassName()).thenReturn("cn");
    I_Probes probesMock = mock(I_Probes.class);
    when(probesMock.size()).thenReturn(5);
    when(classProbes.getProbes()).thenReturn(probesMock);
    I_ThreadingFactory mockFactory = mock(I_ThreadingFactory.class);
    
    CascadingProbeMap cascadingProbeMap = new CascadingProbeMap(new boolean[5]);
    I_ThreadGroupLocal<CascadingProbeMap> threadGroupLocalMock = mock(I_ThreadGroupLocal.class);
    when(threadGroupLocalMock.getValue()).thenReturn(cascadingProbeMap);
    
    MockMethod<I_ThreadGroupLocal<CascadingProbeMap>> threadGroupLocalRecord = 
        new MockMethod<I_ThreadGroupLocal<CascadingProbeMap>>(threadGroupLocalMock, true);
    I_ThreadGroupFilter filterMock = mock(I_ThreadGroupFilter.class);
    when(filterMock.getThreadGroupNameMatchingFilter()).thenReturn("hmm");
    when(mockFactory.createThreadGroupFilter(Tests4J_ThreadFactory.TRIAL_THREAD_GROUP_PREFIX)).thenReturn(filterMock);
    when(mockFactory.createThreadGroupLocal(any(), any())).then(threadGroupLocalRecord);
    MultiContext ctx = mock(MultiContext.class);
    
    I_Tests4J_Log logMock = mock(I_Tests4J_Log.class);
    MockMethod<Void> logRecord = new MockMethod<Void>();
    doAnswer(logRecord).when(logMock).log(any());
    
    I_Runtime runtimeMock = mock(I_Runtime.class);
    when(runtimeMock.getThreadGroupFilter("hmm")).thenReturn("cn");
    when(ctx.getRuntime()).thenReturn(runtimeMock);
    
    when(ctx.getLog()).thenReturn(logMock);
    MultiProbesMap map = new MultiProbesMap(classProbes, ctx, mockFactory);
    
    //have to set the regular probe first
    map.put(0, true);
    boolean [] probes = map.getProbes();
    assertEquals(5, probes.length);
    assertTrue(probes[0]);
    for (int i = 1; i < probes.length; i++) {
      assertFalse(probes[i]);
    }
    assertEquals(0, logRecord.count());
  }
  
  @SuppressWarnings({"boxing", "unchecked"})
  @Test
  public void testGetThreadGroupProbes() {
    I_ClassProbes classProbes = mock(I_ClassProbes.class);
    when(classProbes.getClassName()).thenReturn("cn");
    I_Probes probesMock = mock(I_Probes.class);
    when(probesMock.size()).thenReturn(5);
    when(classProbes.getProbes()).thenReturn(probesMock);
    I_ThreadingFactory mockFactory = mock(I_ThreadingFactory.class);
    
    CascadingProbeMap cascadingProbeMap = new CascadingProbeMap(new boolean[5]);
    I_ThreadGroupLocal<CascadingProbeMap> threadGroupLocalMock = mock(I_ThreadGroupLocal.class);
    when(threadGroupLocalMock.getValue()).thenReturn(cascadingProbeMap);
    
    MockMethod<I_ThreadGroupLocal<CascadingProbeMap>> threadGroupLocalRecord = 
        new MockMethod<I_ThreadGroupLocal<CascadingProbeMap>>(threadGroupLocalMock, true);
    I_ThreadGroupFilter filterMock = mock(I_ThreadGroupFilter.class);
    when(filterMock.getThreadGroupNameMatchingFilter()).thenReturn("hmm");
    when(mockFactory.createThreadGroupFilter(Tests4J_ThreadFactory.TRIAL_THREAD_GROUP_PREFIX)).thenReturn(filterMock);
    when(mockFactory.createThreadGroupLocal(any(), any())).then(threadGroupLocalRecord);
    MultiContext ctx = mock(MultiContext.class);
    
    I_Tests4J_Log logMock = mock(I_Tests4J_Log.class);
    MockMethod<Void> logRecord = new MockMethod<Void>();
    doAnswer(logRecord).when(logMock).log(any());
    when(logMock.isLogEnabled(any())).thenReturn(true);
    when(logMock.getLineSeperator()).thenReturn("\nls");
    when(logMock.getThreadWithGroupNameMessage()).thenReturn("MockThread/MockThreadGroup");
    
    I_Runtime runtimeMock = mock(I_Runtime.class);
    when(runtimeMock.getThreadGroupFilter("hmm")).thenReturn("cn");
    when(ctx.getRuntime()).thenReturn(runtimeMock);
    
    when(ctx.getLog()).thenReturn(logMock);
    MultiProbesMap map = new MultiProbesMap(classProbes, ctx, mockFactory);
    
    //set both probes
    map.put(0, true);
    boolean [] probes = map.getThreadGroupProbes();
    assertTrue(probes[0]);
    assertTrue(cascadingProbeMap.get(0));
    for (int i = 1; i < probes.length; i++) {
      assertFalse(probes[i]);
      assertFalse(cascadingProbeMap.get(i));
    }
    
    assertEquals(2, logRecord.count());
    String logMessage = (String) logRecord.getArg(1);
    assertEquals("MultiProbesMap MockThread/MockThreadGroup\nls"
        + "\tis getting the following probes;\nls"
        + "\t[t,f,f,f,f]\nls"
        + "\tfor the following class;\nls"
        + "\tcn", logMessage);
  }
  
  @SuppressWarnings({"boxing", "unchecked"})
  @Test
  public void testGetThreadGroupProbesNoLog() {
    I_ClassProbes classProbes = mock(I_ClassProbes.class);
    when(classProbes.getClassName()).thenReturn("cn");
    I_Probes probesMock = mock(I_Probes.class);
    when(probesMock.size()).thenReturn(5);
    when(classProbes.getProbes()).thenReturn(probesMock);
    I_ThreadingFactory mockFactory = mock(I_ThreadingFactory.class);
    
    CascadingProbeMap cascadingProbeMap = new CascadingProbeMap(new boolean[5]);
    I_ThreadGroupLocal<CascadingProbeMap> threadGroupLocalMock = mock(I_ThreadGroupLocal.class);
    when(threadGroupLocalMock.getValue()).thenReturn(cascadingProbeMap);
    
    MockMethod<I_ThreadGroupLocal<CascadingProbeMap>> threadGroupLocalRecord = 
        new MockMethod<I_ThreadGroupLocal<CascadingProbeMap>>(threadGroupLocalMock, true);
    I_ThreadGroupFilter filterMock = mock(I_ThreadGroupFilter.class);
    when(filterMock.getThreadGroupNameMatchingFilter()).thenReturn("hmm");
    when(mockFactory.createThreadGroupFilter(Tests4J_ThreadFactory.TRIAL_THREAD_GROUP_PREFIX)).thenReturn(filterMock);
    when(mockFactory.createThreadGroupLocal(any(), any())).then(threadGroupLocalRecord);
    MultiContext ctx = mock(MultiContext.class);
    
    I_Tests4J_Log logMock = mock(I_Tests4J_Log.class);
    MockMethod<Void> logRecord = new MockMethod<Void>();
    doAnswer(logRecord).when(logMock).log(any());
    
    I_Runtime runtimeMock = mock(I_Runtime.class);
    when(runtimeMock.getThreadGroupFilter("hmm")).thenReturn("cn");
    when(ctx.getRuntime()).thenReturn(runtimeMock);
    
    when(ctx.getLog()).thenReturn(logMock);
    MultiProbesMap map = new MultiProbesMap(classProbes, ctx, mockFactory);
    
    //set both probes
    map.put(0, true);
    boolean [] probes = map.getThreadGroupProbes();
    assertTrue(probes[0]);
    assertTrue(cascadingProbeMap.get(0));
    for (int i = 1; i < probes.length; i++) {
      assertFalse(probes[i]);
      assertFalse(cascadingProbeMap.get(i));
    }
    
    assertEquals(0, logRecord.count());
  }
  
  @SuppressWarnings({"rawtypes", "boxing", "unchecked"})
  @Test
  public void testMethodToString() {
    I_ClassProbes classProbes = mock(I_ClassProbes.class);
    when(classProbes.getClassName()).thenReturn("cn");
    I_Probes probesMock = mock(I_Probes.class);
    when(probesMock.size()).thenReturn(5);
    when(classProbes.getProbes()).thenReturn(probesMock);
    I_ThreadingFactory mockFactory = mock(I_ThreadingFactory.class);
    
    CascadingProbeMap cpm = new CascadingProbeMap(new boolean[] {false, false, false, false, false});
   
    I_ThreadGroupLocal mockThreadGroupLocal = mock(I_ThreadGroupLocal.class);
    when(mockThreadGroupLocal.getValue()).thenReturn(cpm);
    MockMethod<I_ThreadGroupLocal<CascadingProbeMap>> threadGroupLocalRecord = 
        new MockMethod<I_ThreadGroupLocal<CascadingProbeMap>>(mockThreadGroupLocal, true);
    I_ThreadGroupFilter filterMock = mock(I_ThreadGroupFilter.class);
    when(mockFactory.createThreadGroupFilter(Tests4J_ThreadFactory.TRIAL_THREAD_GROUP_PREFIX)).thenReturn(filterMock);
    when(mockFactory.createThreadGroupLocal(any(), any())).then(threadGroupLocalRecord);
    MultiContext ctx = mock(MultiContext.class);
    
    I_Tests4J_Log logMock = mock(I_Tests4J_Log.class);
    
    when(ctx.getLog()).thenReturn(logMock);
    MultiProbesMap map = new MultiProbesMap(classProbes, ctx, mockFactory);
    assertEquals("MultiProbesMap [classCovered=cn, probes=[f,f,f,f,f],threadGroupLocalProbes=[f,f,f,f,f]]", map.toString());
    cpm.put(0, true);
    cpm.put(2, true);
    cpm.put(4, true);
    assertEquals("MultiProbesMap [classCovered=cn, probes=[f,f,f,f,f],threadGroupLocalProbes=[t,f,t,f,t]]", map.toString());
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
    return super.getTests(type, 15, false);
  }

  @Override
  public int getAsserts(I_CountType type) {
    int thisAsserts = 201;
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
    int thisUniqueAsserts = 87;
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
