package org.adligo.tests4j_tests.mockito;

import org.adligo.tests4j.shared.asserts.common.AssertionFailedException;
import org.adligo.tests4j.system.shared.trials.SourceFileScope;
import org.adligo.tests4j.system.shared.trials.Test;
import org.adligo.tests4j_4mockito.ArgMap;
import org.adligo.tests4j_4mockito.MockMethod;
import org.adligo.tests4j_tests.base_trials.I_CountType;
import org.adligo.tests4j_tests.base_trials.SourceFileCountingTrial;
import org.mockito.invocation.InvocationOnMock;

@SourceFileScope (sourceClass=MockMethod.class, minCoverage=22.0)
public class MethodRecorderTrial extends SourceFileCountingTrial {

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
  
  
  @Test
  public void testGetArgumentsMap() throws Exception {
    ArgMap<String> argMap = new ArgMap<String>();
    argMap.putVar("hey12", 1, 2);
    argMap.putVar("hey13", 1, 3);
    argMap.putVar("hey14", 1, 4);
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
  
  @Test
  public void testGetArgumentsMapAndDefault() throws Exception {
    ArgMap<String> argMap = new ArgMap<String>();
    argMap.putVar("hey12", 1, 2);
    argMap.putVar("hey13", 1, 3);
    argMap.putVar("hey14", 1, 4);
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
  
  @Override
  public int getTests(I_CountType type) {
    return super.getTests(type, 5, false);
  }

  @Override
  public int getAsserts(I_CountType type) {
    int thisAsserts =15;
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
    int thisUniqueAsserts = 11;
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
