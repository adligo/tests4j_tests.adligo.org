package org.adligo.tests4j_tests.jacoco.plugin;

import org.adligo.tests4j.models.shared.coverage.I_PackageCoverageBrief;
import org.adligo.tests4j.models.shared.coverage.I_Probes;
import org.adligo.tests4j.models.shared.coverage.I_SourceFileCoverageBrief;
import org.adligo.tests4j.run.discovery.I_PackageDiscovery;
import org.adligo.tests4j.run.helpers.I_CachedClassBytesClassLoader;
import org.adligo.tests4j.shared.output.I_Tests4J_Log;
import org.adligo.tests4j.system.shared.trials.SourceFileScope;
import org.adligo.tests4j.system.shared.trials.Test;
import org.adligo.tests4j_4jacoco.plugin.Recorder;
import org.adligo.tests4j_4jacoco.plugin.common.I_CoveragePluginMemory;
import org.adligo.tests4j_4jacoco.plugin.common.I_Runtime;
import org.adligo.tests4j_4jacoco.plugin.instrumentation.common.I_ClassInstrumentationMetadata;
import org.adligo.tests4j_4jacoco.plugin.instrumentation.common.I_ClassInstrumentationMetadataStoreMutant;
import org.adligo.tests4j_4mockito.ArgMap;
import org.adligo.tests4j_4mockito.I_ArgFactory;
import org.adligo.tests4j_4mockito.MockMethod;
import org.adligo.tests4j_tests.base_trials.I_CountType;
import org.adligo.tests4j_tests.base_trials.SourceFileCountingTrial;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@SourceFileScope (sourceClass=Recorder.class,minCoverage=0.0)
public class RecorderTrial extends SourceFileCountingTrial {

  @SuppressWarnings("boxing")
  @Test
  public void testMethodGetAllCoverage_PackageNormalization_3SourceFilesInDifferentPackages() {
    
    I_CachedClassBytesClassLoader classLoaderMock = mock(I_CachedClassBytesClassLoader.class);
    I_CoveragePluginMemory memory = mock(I_CoveragePluginMemory.class);
    Set<String> topPackages = new HashSet<String>();
    topPackages.add("com.example.foo");
    when(memory.getTopPackageNames()).thenReturn(topPackages);
    when(memory.isFiltered(any(String.class))).thenReturn(false);
    
    when(memory.getCachedClassLoader()).thenReturn(classLoaderMock);
    
    ArgMap<I_PackageDiscovery> argMap = new ArgMap<I_PackageDiscovery>();
    I_PackageDiscovery pkgFoo = mock(I_PackageDiscovery.class);
    when(pkgFoo.getPackageName()).thenReturn("com.example.foo");
    when(pkgFoo.getClassNames()).thenReturn(Collections.singletonList("com.example.foo.Bar"));
    argMap.putVal(pkgFoo, "com.example.foo");
    
    I_PackageDiscovery pkgA = mock(I_PackageDiscovery.class);
    when(pkgA.getPackageName()).thenReturn("com.example.foo.a");
    when(pkgA.getClassNames()).thenReturn(Collections.singletonList("com.example.foo.a.Aar"));
    
    I_PackageDiscovery pkgC = mock(I_PackageDiscovery.class);
    when(pkgC.getPackageName()).thenReturn("com.example.foo.c");
    when(pkgC.getClassNames()).thenReturn(Collections.singletonList("com.example.foo.c.Car"));
    
    List<I_PackageDiscovery> subs = new ArrayList<I_PackageDiscovery>();
    subs.add(pkgA);
    subs.add(pkgC);
    when(pkgFoo.getSubPackages()).thenReturn(subs);
    
    MockMethod<I_PackageDiscovery> pkgRecord = new MockMethod<I_PackageDiscovery>(argMap);
    when(memory.getPackage(any())).then(pkgRecord);
    
    I_Runtime runtime = mock(I_Runtime.class);
    MockMethod<Void> ensureProbesInitRecord = new MockMethod<Void>();
    doAnswer(ensureProbesInitRecord).when(runtime).ensureProbesInitialized(any(I_ClassInstrumentationMetadata.class));
    
    when(memory.getRuntime()).thenReturn(runtime);
    
    I_ClassInstrumentationMetadataStoreMutant store = mock(I_ClassInstrumentationMetadataStoreMutant.class);
    when(memory.getClassInstrumentationInfoStore()).thenReturn(store);
    ArgMap<I_ClassInstrumentationMetadata> metas = new ArgMap<I_ClassInstrumentationMetadata>(
        new I_ArgFactory<I_ClassInstrumentationMetadata>() {
          @Override
          public I_ClassInstrumentationMetadata create(Object [] args) {
            return mock(I_ClassInstrumentationMetadata.class);
          }
    });
    MockMethod<I_ClassInstrumentationMetadata> metaRecord = new MockMethod<I_ClassInstrumentationMetadata>(metas);
    when(store.getClassInstrumentation(any())).then(metaRecord);
    
    ArgMap<I_SourceFileCoverageBrief> briefs = new ArgMap<I_SourceFileCoverageBrief>(
          new I_ArgFactory<I_SourceFileCoverageBrief>() {
          @Override
          public I_SourceFileCoverageBrief create(Object [] args) {
            I_SourceFileCoverageBrief toRet = mock(I_SourceFileCoverageBrief.class);
            I_Probes probes = mock(I_Probes.class);
            when(toRet.getProbes()).thenReturn(probes);
            String className = (String) args[0];
            when(toRet.getClassName()).thenReturn(className);
            return toRet;
          }
        });
    MockMethod<I_SourceFileCoverageBrief> sourceCoverRecord= new MockMethod<I_SourceFileCoverageBrief>(briefs);
    when(runtime.getSourceFileCoverage(any(String.class))).thenAnswer(sourceCoverRecord);
    when(memory.isResultPackage(any())).thenReturn(true);
    
    I_Tests4J_Log log = mock(I_Tests4J_Log.class);
    Recorder recorder = new Recorder(memory, log);
    assertNotNull(recorder);
    List<I_PackageCoverageBrief> result = recorder.getAllCoverage(Collections.emptySet());
    assertNotNull(result);
    I_PackageCoverageBrief brief = result.get(0);
    assertNotNull(brief);
    assertEquals("com.example.foo", brief.getPackageName());
    Set<String> souceFileNames = brief.getSourceFileNames();
    assertContains(souceFileNames, "com.example.foo.Bar");
    assertEquals(1, souceFileNames.size());
    
    assertEquals(1, result.size());
    assertEquals(3, metaRecord.count());
    assertEquals("com.example.foo.Bar", metaRecord.getArg(0));
    assertEquals("com.example.foo.a.Aar", metaRecord.getArg(1));
    assertEquals("com.example.foo.c.Car", metaRecord.getArg(2));
    
    //it was passed from the memory, class loader to ensureProbesInitialized
    assertEquals(metas.getVar("com.example.foo.Bar"), ensureProbesInitRecord.getArg(0));
    assertEquals(metas.getVar("com.example.foo.a.Aar"), ensureProbesInitRecord.getArg(1));
    assertEquals(metas.getVar("com.example.foo.c.Car"), ensureProbesInitRecord.getArg(2));
    
    List<I_PackageCoverageBrief> children = brief.getChildPackageCoverage();
    assertNotNull(children);
    I_PackageCoverageBrief childA = children.get(0);
    assertEquals("com.example.foo.a", childA.getPackageName());
    souceFileNames = childA.getSourceFileNames();
    assertContains(souceFileNames, "com.example.foo.a.Aar");
    assertEquals(1, souceFileNames.size());
    
    I_PackageCoverageBrief childC = children.get(1);
    assertEquals("com.example.foo.c", childC.getPackageName());
    souceFileNames = childC.getSourceFileNames();
    assertContains(souceFileNames, "com.example.foo.c.Car");
    assertEquals(1, souceFileNames.size());

    assertEquals(2, children.size());
  }
  
  @SuppressWarnings("boxing")
  @Test
  public void testMethodGetAllCoverage_2PackagesOneIsTrialPackages() {
    
    I_CachedClassBytesClassLoader classLoaderMock = mock(I_CachedClassBytesClassLoader.class);
    I_CoveragePluginMemory memory = mock(I_CoveragePluginMemory.class);
    Set<String> topPackages = new HashSet<String>();
    topPackages.add("com.example.foo");
    topPackages.add("com.example.foo_tests");
    when(memory.getTopPackageNames()).thenReturn(topPackages);
    when(memory.isFiltered(any(String.class))).thenReturn(false);
    
    when(memory.getCachedClassLoader()).thenReturn(classLoaderMock);
    
    ArgMap<I_PackageDiscovery> argMap = new ArgMap<I_PackageDiscovery>();
    I_PackageDiscovery pkgFoo = mock(I_PackageDiscovery.class);
    when(pkgFoo.getPackageName()).thenReturn("com.example.foo");
    when(pkgFoo.getClassNames()).thenReturn(Collections.singletonList("com.example.foo.Bar"));
    argMap.putVal(pkgFoo, "com.example.foo");
    
    I_PackageDiscovery pkgA = mock(I_PackageDiscovery.class);
    when(pkgA.getPackageName()).thenReturn("com.example.foo_tests");
    when(pkgA.getClassNames()).thenReturn(Collections.singletonList("com.example.foo_tests.BarTrial"));
    argMap.putVal(pkgA, "com.example.foo_tests");
    
    MockMethod<I_PackageDiscovery> pkgRecord = new MockMethod<I_PackageDiscovery>(argMap);
    when(memory.getPackage(any())).then(pkgRecord);
    
    I_Runtime runtime = mock(I_Runtime.class);
    MockMethod<Void> ensureProbesInitRecord = new MockMethod<Void>();
    doAnswer(ensureProbesInitRecord).when(runtime).ensureProbesInitialized(any(I_ClassInstrumentationMetadata.class));
    
    when(memory.getRuntime()).thenReturn(runtime);
    
    I_ClassInstrumentationMetadataStoreMutant store = mock(I_ClassInstrumentationMetadataStoreMutant.class);
    when(memory.getClassInstrumentationInfoStore()).thenReturn(store);
    ArgMap<I_ClassInstrumentationMetadata> metas = new ArgMap<I_ClassInstrumentationMetadata>(
        new I_ArgFactory<I_ClassInstrumentationMetadata>() {
          @Override
          public I_ClassInstrumentationMetadata create(Object [] args) {
            return mock(I_ClassInstrumentationMetadata.class);
          }
    });
    MockMethod<I_ClassInstrumentationMetadata> metaRecord = new MockMethod<I_ClassInstrumentationMetadata>(metas);
    when(store.getClassInstrumentation(any())).then(metaRecord);
    
    ArgMap<I_SourceFileCoverageBrief> briefs = new ArgMap<I_SourceFileCoverageBrief>(
          new I_ArgFactory<I_SourceFileCoverageBrief>() {
          @Override
          public I_SourceFileCoverageBrief create(Object [] args) {
            I_SourceFileCoverageBrief toRet = mock(I_SourceFileCoverageBrief.class);
            I_Probes probes = mock(I_Probes.class);
            when(toRet.getProbes()).thenReturn(probes);
            String className = (String) args[0];
            when(toRet.getClassName()).thenReturn(className);
            return toRet;
          }
        });
    MockMethod<I_SourceFileCoverageBrief> sourceCoverRecord= new MockMethod<I_SourceFileCoverageBrief>(briefs);
    when(runtime.getSourceFileCoverage(any(String.class))).thenAnswer(sourceCoverRecord);
    when(memory.isResultPackage(any())).thenReturn(true);
    
    I_Tests4J_Log log = mock(I_Tests4J_Log.class);
    Recorder recorder = new Recorder(memory, log);
    assertNotNull(recorder);
    List<I_PackageCoverageBrief> result = recorder.getAllCoverage(Collections.singleton("com.example.foo_tests"));
    assertNotNull(result);
    I_PackageCoverageBrief brief = result.get(0);
    assertNotNull(brief);
    assertEquals("com.example.foo", brief.getPackageName());
    Set<String> souceFileNames = brief.getSourceFileNames();
    assertContains(souceFileNames, "com.example.foo.Bar");
    assertEquals(1, souceFileNames.size());
    
    assertEquals(1, result.size());
  }
  @Override
  public int getTests(I_CountType type) {
    return super.getTests(type, 2, false);
  }

  @Override
  public int getAsserts(I_CountType type) {
    int thisAsserts = 29;
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
    int thisUniqueAsserts = 25;
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
