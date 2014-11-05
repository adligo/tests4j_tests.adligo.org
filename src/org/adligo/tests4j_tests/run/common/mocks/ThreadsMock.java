package org.adligo.tests4j_tests.run.common.mocks;

import org.adligo.tests4j.run.common.I_Threads;

public class ThreadsMock implements I_Threads {
  public Thread currnetThread_;
  
  public ThreadsMock(Thread t) {
    currnetThread_ = t;
  }
  @Override
  public Thread currentThread() {
    return currnetThread_;
  }

}
