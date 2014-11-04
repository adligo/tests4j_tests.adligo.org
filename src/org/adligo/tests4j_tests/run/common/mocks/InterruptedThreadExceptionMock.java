package org.adligo.tests4j_tests.run.common.mocks;

/**
 * this is thrown to
 * stub out the call 
 * to Thread.currentThread.interrupt();
 * in NotifierMock
 * 
 * @author scott
 *
 */
public class InterruptedThreadExceptionMock extends RuntimeException {

  /**
   * 
   */
  private static final long serialVersionUID = 1L;

}
