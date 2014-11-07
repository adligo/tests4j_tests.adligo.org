package org.adligo.tests4j_tests.run.common.mocks;

import org.adligo.tests4j.run.common.I_Classes;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

public class ClassesMock implements I_Classes {
  private ConcurrentHashMap<String,Class<?>> classes_ = new ConcurrentHashMap<String,Class<?>>();
  private ConcurrentHashMap<String,ClassNotFoundException> exceptions_ = 
      new ConcurrentHashMap<String,ClassNotFoundException>();
  private ConcurrentLinkedQueue<String> calls_ = new ConcurrentLinkedQueue<String>();
  
  public ClassesMock(Map<String,Class<?>> classes, 
    Map<String,ClassNotFoundException> exceptions) {
    
    classes_.putAll(classes);
    exceptions_.putAll(exceptions);
  }
  
  public ClassesMock(Map<String,Class<?>> classes) {
    classes_.putAll(classes);
  }
  
  @Override
  public Class<?> forName(String name) throws ClassNotFoundException {
    calls_.add("forName(" + name  + ")");
    ClassNotFoundException x = exceptions_.get(name);
    if (x != null) {
      throw x;
    }
    return classes_.get(name);
  }

  public String pollCalls() {
    return calls_.poll();
  }

  @Override
  public Class<?> forName(String name, boolean initialize, ClassLoader loader)
      throws ClassNotFoundException {
    
    calls_.add("forName(" + name  + "," + initialize +"," + loader + ")");
    ClassNotFoundException x = exceptions_.get(name);
    if (x != null) {
      throw x;
    }
    return classes_.get(name);
  }
}
