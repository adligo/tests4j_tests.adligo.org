package org.adligo.tests4j_tests.run.common.mocks;

import java.util.concurrent.ThreadFactory;

public class MockThreadFactory implements ThreadFactory {

  @Override
  public Thread newThread(Runnable r) {
    return new MockThread(r);
  }

}
