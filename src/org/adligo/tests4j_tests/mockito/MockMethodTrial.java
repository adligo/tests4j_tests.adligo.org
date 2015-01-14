package org.adligo.tests4j_tests.mockito;

import org.adligo.tests4j.system.shared.trials.SourceFileScope;
import org.adligo.tests4j.system.shared.trials.Test;
import org.adligo.tests4j_4mockito.ArgMap;
import org.adligo.tests4j_4mockito.I_ArgFactory;
import org.adligo.tests4j_4mockito.MockMethod;
import org.adligo.tests4j_tests.base_trials.I_CountType;
import org.adligo.tests4j_tests.base_trials.SourceFileCountingTrial;
import org.mockito.invocation.InvocationOnMock;

import java.util.List;

@SourceFileScope (sourceClass=MockMethod.class, minCoverage=22.0)
public class MockMethodTrial extends SourceFileCountingTrial {

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
  
  @SuppressWarnings({"boxing", "unchecked"})
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
    //ok you would probably never need to mock a list
    ArgMap<String> map = new ArgMap<String>(new I_ArgFactory<String>() {

      @Override
      public String create(Object[] keys) {
        return "" + keys[0];
      }
    });
    MockMethod<String> getMock = new MockMethod<String>(map);
    List<String> list = mock(List.class);
    when(list.get((anyInt()))).then(getMock);
    assertEquals("123", list.get(123));
    assertEquals("456", list.get(456));
    assertEquals("789", list.get(789));
    assertEquals("12", list.get(12));
  }
  @Override
  public int getTests(I_CountType type) {
    return super.getTests(type, 7, false);
  }

  @Override
  public int getAsserts(I_CountType type) {
    int thisAsserts = 23;
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
    int thisUniqueAsserts = 19;
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
