package org.adligo.tests4j_tests.jacoco.plugin.data.multi;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.adligo.tests4j.run.common.I_Notifier;
import org.adligo.tests4j.run.common.NotifierDelegate;
import org.adligo.tests4j.shared.asserts.common.ExpectedThrownData;
import org.adligo.tests4j.shared.asserts.common.I_Thrower;
import org.adligo.tests4j.system.shared.trials.IgnoreTest;
import org.adligo.tests4j.system.shared.trials.SourceFileScope;
import org.adligo.tests4j.system.shared.trials.Test;
import org.adligo.tests4j_4jacoco.plugin.data.multi.ConcurrentQualifiedMap;
import org.adligo.tests4j_tests.base_trials.I_CountType;
import org.adligo.tests4j_tests.base_trials.SourceFileCountingTrial;
import org.adligo.tests4j_tests.run.common.mocks.InterruptedThreadExceptionMock;
import org.adligo.tests4j_tests.run.common.mocks.NotifierMock;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

@SourceFileScope (sourceClass=ConcurrentQualifiedMap.class, minCoverage=77.0)
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
    
    ConcurrentMap<Integer,String> mapMock_ = mock(ConcurrentMap.class);
    ConcurrentQualifiedMap<Integer,String> map = 
        new ConcurrentQualifiedMap<Integer,String>(
        mapMock_, nMock);
    when(mapMock_.containsKey(12)).thenReturn(false).thenReturn(true);
    when(mapMock_.get(12)).thenReturn(null).thenReturn("hey");
    
    map.await(12);
    List<String> calls = nMock.getCalls();
    assertEquals("waitDelegate(26)", calls.get(0));
    assertEquals("waitDelegate(25)", calls.get(1));
  }
  
  @SuppressWarnings("boxing")
  @Test
  public void testSpecialWaitInterruptedWhenNoKey() {
    LinkedList<InterruptedException> exeptions = new LinkedList<InterruptedException>();
    exeptions.add(new InterruptedException("MockException testSpecialWaitInterruptedWhenNoKey"));
    NotifierMock nMock = new NotifierMock(null,
        Collections.singletonMap("waitDelegate(26)", exeptions));
    
    ConcurrentMap<Integer,String> mapMock_ = mock(ConcurrentMap.class);
    ConcurrentQualifiedMap<Integer,String> map = 
        new ConcurrentQualifiedMap<Integer,String>(
        mapMock_, nMock);
    when(mapMock_.containsKey(12)).thenReturn(false);
    
    assertThrown(new ExpectedThrownData(InterruptedThreadExceptionMock.class),
        new I_Thrower() {
          
          @Override
          public void run() throws Throwable {
            map.await(12);
          }
        });
    
    List<String> calls = nMock.getCalls();
    assertEquals("waitDelegate(26)", calls.get(0));
    assertEquals("interrupt()", calls.get(1));
    assertEquals(2, calls.size());
  }
  
  @SuppressWarnings("boxing")
  @Test
  public void testSpecialWaitInterruptedWhenNullValue() {
    LinkedList<InterruptedException> exeptions = new LinkedList<InterruptedException>();
    exeptions.add(new InterruptedException("MockException testSpecialWaitInterruptedWhenNullValue"));
    NotifierMock nMock = new NotifierMock(null,
        Collections.singletonMap("waitDelegate(25)", exeptions));
    
    ConcurrentMap<Integer,String> mapMock_ = mock(ConcurrentMap.class);
    ConcurrentQualifiedMap<Integer,String> map = 
        new ConcurrentQualifiedMap<Integer,String>(
        mapMock_, nMock);
    when(mapMock_.containsKey(12)).thenReturn(true);
    when(mapMock_.get(12)).thenReturn(null).thenReturn("value");
    
    assertThrown(new ExpectedThrownData(InterruptedThreadExceptionMock.class),
        new I_Thrower() {
          
          @Override
          public void run() throws Throwable {
            map.await(12);
          }
        });
    
    List<String> calls = nMock.getCalls();
    assertEquals("waitDelegate(25)", calls.get(0));
    assertEquals("interrupt()", calls.get(1));
    assertEquals(2, calls.size());
  }
  
  @Override
  public int getTests(I_CountType type) {
    return super.getTests(type, 5);
  }

  @Override
  public int getAsserts(I_CountType type) {
    int thisAsserts = 35;
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
    int thisUniqueAsserts = 22;
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
