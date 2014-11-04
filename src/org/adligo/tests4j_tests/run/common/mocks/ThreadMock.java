package org.adligo.tests4j_tests.run.common.mocks;

import java.util.concurrent.ArrayBlockingQueue;

public class ThreadMock extends Thread {
  private final ArrayBlockingQueue<Boolean> interrupted_ = new ArrayBlockingQueue<Boolean>(1);
  
  public ThreadMock(Runnable r) {
    super(r);
  }
  
  @Override
  public void interrupt() {
    try {
      interrupted_.put(true);
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
    super.interrupt();
    
  }

  public  boolean wasInterrupted() throws InterruptedException {
    return interrupted_.take();
  }
}
