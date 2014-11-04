package org.adligo.tests4j_tests.jacoco.plugin.data.multi;

import org.adligo.tests4j.run.common.I_Notifier;
import org.adligo.tests4j.run.common.NotifierDelegate;
import org.adligo.tests4j.system.shared.trials.SourceFileScope;
import org.adligo.tests4j.system.shared.trials.Test;
import org.adligo.tests4j_4jacoco.plugin.data.multi.ConcurrentQualifiedMap;
import org.adligo.tests4j_tests.base_trials.I_CountType;
import org.adligo.tests4j_tests.base_trials.SourceFileCountingTrial;
import org.adligo.tests4j_tests.run.common.mocks.NotifierMock;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

@SourceFileScope (sourceClass=ConcurrentQualifiedMap.class, minCoverage=100.0)
public class ConcurrentQualifiedMapTrial extends SourceFileCountingTrial {

  @Test
  public void testDefault() {
    ConcurrentHashMap<Integer,String> hash = new ConcurrentHashMap<Integer,String>();
    ConcurrentQualifiedMap<Integer,String> map = 
        new ConcurrentQualifiedMap<Integer,String>(hash);
    I_Notifier notifier = map.getNotifier();
    assertEquals(NotifierDelegate.class.getName(), notifier.getClass().getName());
    assertEquals(map, notifier.getInstance());
  }
  
  @SuppressWarnings("boxing")
  @Test
  public void testConcurrentMapMethods() {
    ConcurrentHashMap<Integer,String> hash = new ConcurrentHashMap<Integer,String>();
    ConcurrentQualifiedMap<Integer,String> map = 
        new ConcurrentQualifiedMap<Integer,String>(hash);
    assertEquals(0, map.size());
    assertTrue(map.isEmpty());
    map.put(1, "value");
    assertEquals("value", map.put(1, "value2"));
    assertEquals("value2", map.remove(1));
    assertEquals(0, map.size());
    assertTrue(map.isEmpty());
    map.put(1, "value");
    Map<Integer,String> twoo = new HashMap<Integer, String>();
    twoo.put(2,"two");
    twoo.put(3,"three");
    map.putAll(twoo);
    assertEquals(3, map.size());
    map.clear();
    assertTrue(map.isEmpty());
    
    map.put(1, "value");
    Set<Entry<Integer,String>> entries = map.entrySet();
    assertEquals(1, entries.size());
    Entry<Integer,String> e = entries.iterator().next();
    assertEquals(1,e.getKey());
    assertEquals("value",e.getValue());
    
    Set<Integer> keys =  map.keySet();
    assertEquals(1, keys.size());
    assertContains(keys, 1);
    
    Collection<String> values =  map.values();
    assertEquals(1, values.size());
    assertContains(values, "value");
    
    assertTrue(map.remove(1, "value"));
    assertTrue(map.isEmpty());
    
    map.put(1, "value");
    assertFalse(map.replace(1, "value2", "value3"));
    assertTrue(map.replace(1, "value", "value2"));
    assertTrue(map.containsKey(1));
    assertTrue(map.containsValue("value2"));
    assertNull(map.get(2));
    assertEquals("value2", map.get(1));
  }

  @SuppressWarnings("boxing")
  @Test
  public void testSpecialWaitNotifyMethods() {
    NotifierMock nMock = new NotifierMock();
    ConcurrentQualifiedMap<Integer,String> map = 
        new ConcurrentQualifiedMap<Integer,String>(
        new ConcurrentHashMap<Integer,String>(), nMock);
    
    map.await(12);
    List<String> calls = nMock.getCalls();
    assertEquals("wait(25)", calls.get(0));
    assertEquals("wait(25)", calls.get(1));
  }
  
  @Override
  public int getTests(I_CountType type) {
    return super.getTests(type, 1);
  }

  @Override
  public int getAsserts(I_CountType type) {
    int thisAsserts = 1;
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
    int thisUniqueAsserts = 1;
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
