package org.adligo.tests4j_tests.jacoco.plugin.data.multi;

import org.adligo.tests4j.shared.asserts.common.ExpectedThrowable;
import org.adligo.tests4j.shared.asserts.common.I_Thrower;
import org.adligo.tests4j.system.shared.trials.SourceFileScope;
import org.adligo.tests4j.system.shared.trials.Test;
import org.adligo.tests4j_4jacoco.plugin.data.multi.CascadingProbeMap;
import org.adligo.tests4j_tests.base_trials.I_CountType;
import org.adligo.tests4j_tests.base_trials.SourceFileCountingTrial;

import java.util.Collections;

@SourceFileScope (sourceClass=CascadingProbeMap.class)
public class CascadingProbeMapTrial extends SourceFileCountingTrial {

  @SuppressWarnings({"unused", "boxing"})
  @Test
  public void testConstructor() {
    assertThrown(new ExpectedThrowable(NullPointerException.class), new I_Thrower() {
      
      @Override
      public void run() throws Throwable {
        new CascadingProbeMap(null);
      }
    });
    CascadingProbeMap map = new CascadingProbeMap(new boolean [] {true, false, true});
    assertTrue(map.get(0));
    assertFalse(map.get(1));
    assertTrue(map.get(2));
  }
  
  @SuppressWarnings("boxing")
  @Test
  public void testMethods() {
    CascadingProbeMap empty = new CascadingProbeMap(new boolean [] {});
    assertTrue(empty.isEmpty());
    
    CascadingProbeMap map = new CascadingProbeMap(new boolean [] {true, false, true});
    assertTrue(map.get(0));
    assertFalse(map.get(1));
    assertTrue(map.get(2));
    assertFalse(map.isEmpty());
    
    assertFalse(map.put(0, false));
    assertFalse(map.put(1, false));
    assertTrue(map.put(1, true));
    assertFalse(map.put(2, false));
    boolean [] vals = map.get();
    assertEquals(3, vals.length);
    for (int i = 0; i < vals.length; i++) {
      assertTrue(vals[i]);
    }
    assertEquals(3, map.size());
  }
  
  @Test
  public void testUnimplementedMethods() {
    final CascadingProbeMap map = new CascadingProbeMap(new boolean [] {true, false, true});

    assertMethodNotImplemented(new I_Thrower() {
      @Override
      public void run() throws Throwable {
        map.containsKey("key");
      }
    });
    assertMethodNotImplemented(new I_Thrower() {
      @Override
      public void run() throws Throwable {
        map.containsValue("value");
      }
    });
    assertMethodNotImplemented(new I_Thrower() {
      @Override
      public void run() throws Throwable {
        map.remove("value");
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
    return super.getTests(type, 3, false);
  }

  @Override
  public int getAsserts(I_CountType type) {
    int thisAsserts = 26;
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
    int thisUniqueAsserts = 14;
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
    assertThrown(new ExpectedThrowable(new IllegalStateException(CascadingProbeMap.METHOD_NOT_IMPLEMENTED)), thrower);
  }
}
