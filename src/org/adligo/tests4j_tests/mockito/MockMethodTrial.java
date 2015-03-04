package org.adligo.tests4j_tests.mockito;

import org.adligo.tests4j.shared.asserts.common.ExpectedThrowable;
import org.adligo.tests4j.shared.asserts.common.I_Thrower;
import org.adligo.tests4j.system.shared.trials.SourceFileScope;
import org.adligo.tests4j.system.shared.trials.Test;
import org.adligo.tests4j_4mockito.ArgMap;
import org.adligo.tests4j_4mockito.I_ReturnFactory;
import org.adligo.tests4j_4mockito.MockMethod;
import org.adligo.tests4j_tests.base_trials.I_CountType;
import org.adligo.tests4j_tests.base_trials.SourceFileCountingTrial;
import org.mockito.invocation.InvocationOnMock;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@SourceFileScope (sourceClass=MockMethod.class, minCoverage=85.0)
public class MockMethodTrial extends SourceFileCountingTrial {

  @SuppressWarnings({"boxing"})
  @Test
  public void testClear() throws Throwable {
    //ok you would probably never need to mock a list
    MockMethod<String> getMock = new MockMethod<String>();
    getMock.push("11");
    getMock.push("22");
    getMock.push("33");
    getMock.push("44");
    
    InvocationOnMock mock = mock(InvocationOnMock.class);
    when(mock.getArguments()).thenReturn(new Object[] {"in1"});
    getMock.answer(mock);
    
    assertEquals("in1", getMock.getArg(0));
    assertEquals(1, getMock.count());
    getMock.clear();
    assertThrown(new ExpectedThrowable(new IndexOutOfBoundsException("Index: 0, Size: 0")),
        new I_Thrower() {

          @Override
          public void run() throws Throwable {
            getMock.getArg(0);
          }});
    assertEquals(0, getMock.count());
    
    getMock.answer(mock);
    assertEquals("in1", getMock.getArg(0));
    assertEquals(1, getMock.count());
  }
  
  @Test
  public void testGetArgumentsSingle() throws Exception {
    MockMethod<String> rec = new MockMethod<String>("hey");
    InvocationOnMock mock = mock(InvocationOnMock.class);
    
    when(mock.getArguments()).thenReturn(new Object[] {});
    try {
      assertEquals("hey", rec.answer(mock));
    } catch (Throwable e) {
      throw new IllegalStateException(e);
    }
  }
  
  @Test
  public void testGetArgumentsVariable() throws Exception {
    MockMethod<String> rec = new MockMethod<String>("hey","hey2");
    InvocationOnMock mock = mock(InvocationOnMock.class);
    
    when(mock.getArguments()).thenReturn(new Object[] {});
    try {
      assertEquals("hey", rec.answer(mock));
      assertEquals("hey2", rec.answer(mock));
    } catch (Throwable e) {
      throw new IllegalStateException(e);
    }
  }
  
  @Test
  public void testGetArgumentsDefault() throws Exception {
    MockMethod<String> rec = new MockMethod<String>("hey",true);
    InvocationOnMock mock = mock(InvocationOnMock.class);
    
    when(mock.getArguments()).thenReturn(new Object[] {});
    try {
      assertEquals("hey", rec.answer(mock));
      assertEquals("hey", rec.answer(mock));
      assertEquals("hey", rec.answer(mock));
      assertEquals("hey", rec.answer(mock));
    } catch (Throwable e) {
      throw new IllegalStateException(e);
    }
  }
  
  
  @SuppressWarnings("boxing")
  @Test
  public void testGetArgumentsMap() throws Exception {
    ArgMap<String> argMap = new ArgMap<String>();
    argMap.putVal("hey12", 1, 2);
    argMap.putVal("hey13", 1, 3);
    argMap.putVal("hey14", 1, 4);
    MockMethod<String> rec = new MockMethod<String>(argMap);
    InvocationOnMock mock = mock(InvocationOnMock.class);
    
    
    try {
      when(mock.getArguments()).thenReturn(new Object[] {1, 2});
      assertEquals("hey12", rec.answer(mock));
    } catch (Throwable e) {
      throw new IllegalStateException(e);
    } 
    try {
      when(mock.getArguments()).thenReturn(new Object[] {1, 3});
      assertEquals("hey13", rec.answer(mock));
    } catch (Throwable e) {
      throw new IllegalStateException(e);
    } 
    try {  
      when(mock.getArguments()).thenReturn(new Object[] {1, 4});
      assertEquals("hey14", rec.answer(mock));
    } catch (Throwable e) {
      throw new IllegalStateException(e);
    } 
  }
  
  @SuppressWarnings("boxing")
  @Test
  public void testGetArgumentsMapAndDefault() throws Exception {
    ArgMap<String> argMap = new ArgMap<String>();
    argMap.putVal("hey12", 1, 2);
    argMap.putVal("hey13", 1, 3);
    argMap.putVal("hey14", 1, 4);
    MockMethod<String> rec = new MockMethod<String>(argMap, "hey");
    InvocationOnMock mock = mock(InvocationOnMock.class);
    
    
    try {
      when(mock.getArguments()).thenReturn(new Object[] {1});
      assertEquals("hey", rec.answer(mock));
    } catch (Throwable e) {
      throw new IllegalStateException(e);
    }
    try {
      when(mock.getArguments()).thenReturn(new Object[] {1, 2});
      assertEquals("hey12", rec.answer(mock));
    } catch (Throwable e) {
      throw new IllegalStateException(e);
    }
    try { 
      when(mock.getArguments()).thenReturn(new Object[] {1, 3});
      assertEquals("hey13", rec.answer(mock));
    } catch (Throwable e) {
      throw new IllegalStateException(e);
    }
    try { 
      when(mock.getArguments()).thenReturn(new Object[] {1});
      assertEquals("hey", rec.answer(mock));
    } catch (Throwable e) {
      throw new IllegalStateException(e);
    }
    try {  
      when(mock.getArguments()).thenReturn(new Object[] {1, 4});
      assertEquals("hey14", rec.answer(mock));
    } catch (Throwable e) {
      throw new IllegalStateException(e);
    }
  }
  
  @SuppressWarnings({"unchecked"})
  @Test
  public void testPush() throws Exception {
    //ok you would probably never need to mock a list
    MockMethod<String> getMock = new MockMethod<String>();
    getMock.push("11");
    getMock.push("22");
    getMock.push("33");
    getMock.push("44");
    List<String> list = mock(List.class);
    when(list.get((anyInt()))).then(getMock);
    assertEquals("11", list.get(123));
    assertEquals("22", list.get(456));
    assertEquals("33", list.get(789));
    assertEquals("44", list.get(012));
  }
  
  @SuppressWarnings({"boxing", "unchecked"})
  @Test
  public void testConstructorFactory() throws Exception {
    //ok you would probably never need to mock a list, but it is
    //a easy class to work with for proving the ArgMapWorks
    final AtomicInteger callCounter = new AtomicInteger(); 
    MockMethod<String> getMock = new MockMethod<String>(new I_ReturnFactory<String>() {

      @Override
      public String create(Object[] keys) {
        callCounter.incrementAndGet();
        return "" + keys[0];
      }
    });
    List<String> list = mock(List.class);
    when(list.get((anyInt()))).then(getMock);
    String val = list.get(123);
    assertEquals(1, callCounter.get());
    assertEquals("123", val);
    assertSame(val, list.get(123));
    
    val = list.get(456);
    assertEquals(2, callCounter.get());
    assertEquals("456", val);
    assertSame(val, list.get(456));
    
    val = list.get(789);
    assertEquals(3, callCounter.get());
    assertEquals("789", val);
    assertSame(val, list.get(789));
    
    val = list.get(12);
    assertEquals(4, callCounter.get());
    assertEquals("12", val);
    assertSame(val, list.get(12));
    
    callCounter.set(0);
    MockMethod<String> getMockNoCache = new MockMethod<String>(new I_ReturnFactory<String>() {

      @Override
      public String create(Object[] keys) {
        callCounter.incrementAndGet();
        return "" + keys[0];
      }
    }, false);
    list = mock(List.class);
    when(list.get((anyInt()))).then(getMockNoCache);
    val = list.get(123);
    assertEquals(1, callCounter.get());
    assertEquals("123", val);
    String nextVal = list.get(123);
    assertNotSame(val, nextVal);
    assertEquals(val, nextVal);
    assertEquals(2, callCounter.get());
    
    val = list.get(456);
    assertEquals(3, callCounter.get());
    assertEquals("456", val);
    nextVal = list.get(456);
    assertNotSame(val, nextVal);
    assertEquals(val, nextVal);
    assertEquals(4, callCounter.get());
    
    val = list.get(789);
    
    assertEquals(5, callCounter.get());
    assertEquals("789", val);
    nextVal = list.get(789);
    assertNotSame(val, nextVal);
    assertEquals(val, nextVal);
    assertEquals(6, callCounter.get());
    
    val = list.get(12);
    assertEquals(7, callCounter.get());
    assertEquals("12", val);
    nextVal = list.get(12);
    assertNotSame(val, nextVal);
    assertEquals(val, nextVal);
    assertEquals(8, callCounter.get());
  }
  @Override
  public int getTests(I_CountType type) {
    return super.getTests(type, 8, false);
  }

  @Override
  public int getAsserts(I_CountType type) {
    int thisAsserts = 57;
    //code coverage and circular dependencies 
    int thisAfterAsserts = 2;
    if (type.isFromMetaWithCoverage()) {
      return super.getAsserts(type, thisAsserts + thisAfterAsserts);
    } else {
      return super.getAsserts(type, thisAsserts);
    }
  }

  @Override
  public int getUniqueAsserts(I_CountType type) {
    int thisUniqueAsserts = 39;
    //code coverage and circular dependencies 
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
