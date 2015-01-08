package org.adligo.tests4j_tests.jacoco.plugin;

import org.adligo.tests4j.run.common.I_JseSystem;
import org.adligo.tests4j.shared.output.I_Tests4J_Log;
import org.adligo.tests4j.system.shared.api.I_Tests4J_CoveragePlugin;
import org.adligo.tests4j.system.shared.api.I_Tests4J_CoveragePluginFactory;
import org.adligo.tests4j.system.shared.api.I_Tests4J_CoveragePluginParams;
import org.adligo.tests4j.system.shared.api.I_Tests4J_Params;
import org.adligo.tests4j.system.shared.trials.SourceFileScope;
import org.adligo.tests4j.system.shared.trials.Test;
import org.adligo.tests4j_4jacoco.plugin.CoveragePlugin;
import org.adligo.tests4j_4jacoco.plugin.CoveragePluginMemory;
import org.adligo.tests4j_4jacoco.plugin.factories.DefaultPluginFactory;
import org.adligo.tests4j_tests.base_trials.I_CountType;
import org.adligo.tests4j_tests.base_trials.SourceFileCountingTrial;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@SourceFileScope (sourceClass=CoveragePluginMemory.class,minCoverage=5.0)
public class CoveragePluginMemoryTrial extends SourceFileCountingTrial {

  @SuppressWarnings("boxing")
  @Test
  public void testMethodsGetSetScopesAndGetTopPackageNames() {
    DefaultPluginFactory factory = new DefaultPluginFactory();
    I_Tests4J_Params params = mock(I_Tests4J_Params.class);
    I_Tests4J_CoveragePluginParams pluginParams = mock(I_Tests4J_CoveragePluginParams.class);
    Map<String,Object> runtimeParams = new HashMap<String,Object>();
    
    I_Tests4J_Log log = mock(I_Tests4J_Log.class);
    runtimeParams.put(I_Tests4J_CoveragePluginFactory.LOG, log);    
    
    I_JseSystem system = mock(I_JseSystem.class);
    runtimeParams.put(I_Tests4J_CoveragePluginFactory.SYSTEM, system);
    
    I_Tests4J_CoveragePlugin plugin = factory.create(params, pluginParams, runtimeParams);
    CoveragePlugin cp = (CoveragePlugin) plugin;
    CoveragePluginMemory memory = cp.getMemory();
    
    memory.addPackageScope("com.example.foo.bar");
    memory.addPackageScope("com.example.foo.net");
    memory.addPackageScope("com.example.foo");
    Set<String> pkgs = memory.getAllPackageScopes();
    assertContains(pkgs, "com.example.foo.bar");
    assertContains(pkgs, "com.example.foo.net");
    assertContains(pkgs, "com.example.foo");
    assertEquals(3, pkgs.size());
    
    memory.addSourceFileScope("com.example.bar2.Go");
    memory.addSourceFileScope("com.example.foo.net2.Go");
    memory.addSourceFileScope("com.example.net2.Go");
    Set<String> srcs = memory.getAllSourceFileScopes();
    assertContains(srcs, "com.example.bar2.Go");
    assertContains(srcs, "com.example.foo.net2.Go");
    assertContains(srcs, "com.example.net2.Go");
    assertEquals(3, srcs.size());
    
    Set<String> tops = memory.getTopPackageNames();
    assertContains(tops, "com.example.foo");
    assertContains(tops, "com.example.bar2");
    assertContains(tops, "com.example.net2");
    assertEquals(3, tops.size());
  }
  
  @Override
  public int getTests(I_CountType type) {
    return super.getTests(type, 1);
  }

  @Override
  public int getAsserts(I_CountType type) {
    int thisAsserts = 12;
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
    int thisUniqueAsserts = 10;
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
