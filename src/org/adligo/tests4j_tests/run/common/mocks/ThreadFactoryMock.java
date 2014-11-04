package org.adligo.tests4j_tests.run.common.mocks;

import java.util.concurrent.ThreadFactory;

public class ThreadFactoryMock implements ThreadFactory {

  @Override
  public Thread newThread(Runnable r) {
    return new ThreadMock(r);
  }

}
