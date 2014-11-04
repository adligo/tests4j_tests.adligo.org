package org.adligo.tests4j_tests.run.common.mocks;

import org.adligo.tests4j.run.common.I_Notifier;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * This is a non concurrent implementation
 * to be used to redirect calls to
 * wait, notify, interrupt
 * 
 * @author scott
 *
 */
public class NotifierMock implements I_Notifier {
  private List<String> methodCalls_ = new ArrayList<String>();
  private Object instance_ = new Object();
  /**
   * if nothing is in the value, then no exceptions are thrown
   * if there is a queue which has a null no exception is thrown
   * if a actual exception is in the list then it is thrown.
   */
  private Map<String,LinkedList<IllegalMonitorStateException>> monitorExceptions_ = 
      new HashMap<String,LinkedList<IllegalMonitorStateException>>();
  private Map<String,LinkedList<InterruptedException>> interruptedExceptions_ = 
      new HashMap<String,LinkedList<InterruptedException>>();
  
  public NotifierMock() { }
  
  public NotifierMock(Map<String,LinkedList<IllegalMonitorStateException>> monitors,
      Map<String,LinkedList<InterruptedException>> interrupts) {
    if (monitors != null) {
      monitorExceptions_.putAll(monitors);
    }
    if (interrupts != null) {
      interruptedExceptions_.putAll(interrupts);
    }
  }
  
  public List<String> getCalls() {
    return methodCalls_;
  }
  
  @Override
  public Object getInstance() {
    methodCalls_.add("getInstance()");
    return instance_;
  }

  @Override
  public void interrupt() {
    methodCalls_.add("interrupt()");
    throw new InterruptedThreadExceptionMock();
  }

  @Override
  public void notifyDelegate() throws IllegalMonitorStateException {
    methodCalls_.add("notifyDelegate()");
    checkThrowMonitor("notifyDelegate()");
  }
  

  @Override
  public void notifyAllDelegate() throws IllegalMonitorStateException {
    methodCalls_.add("notifyAllDelegate()");
    checkThrowMonitor("notifyAllDelegate()");
  }

  @Override
  public void waitDelegate() throws InterruptedException {
    methodCalls_.add("waitDelegate()");
    checkThrowInterrupted("waitDelegate()");
  }

  @Override
  public void waitDelegate(long timeout) throws InterruptedException {
    String name = "waitDelegate(" + timeout + ")";
    methodCalls_.add(name);
    checkThrowInterrupted(name);
  }

  @Override
  public void waitDelegate(long timeout, int nanos) throws InterruptedException {
    String name = "waitDelegate(" + timeout + "," + nanos + ")";
    methodCalls_.add(name);
    checkThrowInterrupted(name);
  }

  private void checkThrowMonitor(String methodName) throws IllegalMonitorStateException {
    LinkedList<IllegalMonitorStateException> exs = 
        monitorExceptions_.get(methodName);
    if (exs != null) {
      IllegalMonitorStateException x = exs.poll();
      if (x != null) {
        throw x;
      }
    }
  }
  
  private void checkThrowInterrupted(String methodName) throws InterruptedException {
    LinkedList<InterruptedException> exs = 
        interruptedExceptions_.get(methodName);
    if (exs != null) {
      InterruptedException x = exs.poll();
      if (x != null) {
        throw x;
      }
    }
  }
}
