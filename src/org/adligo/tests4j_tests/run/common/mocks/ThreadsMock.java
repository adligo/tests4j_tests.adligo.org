package org.adligo.tests4j_tests.run.common.mocks;

import org.adligo.tests4j.run.common.I_Threads;

import java.util.LinkedList;
import java.util.List;

public class ThreadsMock implements I_Threads {
  public LinkedList<Thread> nextThreads_ = new LinkedList<Thread>();
  
  public ThreadsMock(List<Thread> t) {
    nextThreads_.addAll(t);
  }
  @Override
  public Thread currentThread() {
    return nextThreads_.poll();
  }

}
