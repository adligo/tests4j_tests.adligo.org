package org.adligo.tests4j_tests.run.common;

import org.adligo.tests4j.run.common.NotifierDelegate;
import org.adligo.tests4j.shared.asserts.common.ExpectedThrowable;
import org.adligo.tests4j.shared.asserts.common.I_Thrower;
import org.adligo.tests4j.shared.asserts.reference.AllowedReferences;
import org.adligo.tests4j.system.shared.trials.SourceFileScope;
import org.adligo.tests4j.system.shared.trials.Test;
import org.adligo.tests4j_tests.base_trials.I_CountType;
import org.adligo.tests4j_tests.base_trials.SourceFileCountingTrial;
import org.adligo.tests4j_tests.references_groups.Tests4J_RunCommon_ReferenceGroup;
import org.adligo.tests4j_tests.run.common.mocks.ThreadMock;
import org.adligo.tests4j_tests.run.common.mocks.ThreadFactoryMock;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Ok this is one of the strangest 
 * source trials I have ever written
 * it tests NotifierDelegate which calls
 * wait(), notify() exc.  
 * @author scott
 * TODO look at minCoverage I think it should be 100%
 * 
 */
@SourceFileScope (sourceClass=NotifierDelegate.class, minCoverage=35.0)
@AllowedReferences (groups=Tests4J_RunCommon_ReferenceGroup.class)
public class NotifierDelegateTrial extends SourceFileCountingTrial {
  private static final ArrayBlockingQueue<Integer> WAITS = new ArrayBlockingQueue<Integer>(10);
  
  private static final ArrayBlockingQueue<Integer> COMPLETED_WAITS = new ArrayBlockingQueue<Integer>(10);
  private static final ArrayBlockingQueue<Integer> COMPLETED_NOTIFYS = new ArrayBlockingQueue<Integer>(10);

  private static final ExecutorService SERVICE = Executors.newFixedThreadPool(
      2, new ThreadFactoryMock());
  private volatile ThreadMock notificationThread_;
  
  @Test 
  public void testNullDelegate() throws Exception {
    assertThrown(new ExpectedThrowable(NullPointerException.class),
      new I_Thrower() {
        
        @SuppressWarnings("unused")
        @Override
        public void run() throws Throwable {
          NotifierDelegate nd = new NotifierDelegate(null);
        }
      });
  }
  @SuppressWarnings("boxing")
  @Test 
  public void testDelegate() throws Exception {
    final NotifierDelegate nd = new NotifierDelegate(new Object());
    
    SERVICE.submit(new Runnable() {
      
      @Override
      public void run() {
        try {
          WAITS.put(0);
          synchronized (nd.getInstance()) {
            nd.waitDelegate();
          }
          COMPLETED_WAITS.put(0);
          WAITS.put(1);
          synchronized (nd.getInstance()) {
            nd.waitDelegate(10000);
          }
          COMPLETED_WAITS.put(1);
          WAITS.put(2);
          synchronized (nd.getInstance()) {
            nd.waitDelegate(10000, 100);
          }
          COMPLETED_WAITS.put(2);
          WAITS.put(3);
          synchronized (nd.getInstance()) {
            nd.waitDelegate();
          }
          COMPLETED_WAITS.put(3);
        } catch (Exception x) {
          NotifierDelegateTrial.this.log(x);
        }
      }
    });
    SERVICE.submit(new Runnable() {
      
      @Override
      public void run() {
        notificationThread_ = (ThreadMock) Thread.currentThread();
        try {
          Integer step = WAITS.take();
          while (step != null) {
            switch (step) {
              case 0:
                synchronized (nd.getInstance()) {
                  nd.notifyDelegate();
                }
                break;
              case 1:
                synchronized (nd.getInstance()) {
                  nd.notifyDelegate();
                }
                break;
              case 2:
                synchronized (nd.getInstance()) {
                  nd.notifyDelegate();
                }
                break;
              case 3:
                synchronized (nd.getInstance()) {
                  nd.notifyAllDelegate();
                }
                break;
            }
            
            COMPLETED_NOTIFYS.put(step);
            step = WAITS.poll(500, TimeUnit.MILLISECONDS);
          }
        } catch (Exception x) {
          NotifierDelegateTrial.this.log(x);
        }
        nd.interrupt();
      }
    });
    
    Integer next = COMPLETED_WAITS.take();
    String waitMessage = "The <X/> wait should have been called";
    String notifyMessage = "The <X/> notify should have been called";
    assertEquals(waitMessage.replaceAll("<X/>", "first"), 0, next);
    next = COMPLETED_NOTIFYS.take();
    assertEquals(notifyMessage.replaceAll("<X/>", "first"), 0, next);
    
    next = COMPLETED_WAITS.take();
    assertEquals(waitMessage.replaceAll("<X/>", "second"), 1, next);
    next = COMPLETED_NOTIFYS.take();
    assertEquals(notifyMessage.replaceAll("<X/>", "second"), 1, next);
    
    
    next = COMPLETED_WAITS.take();
    assertEquals(waitMessage.replaceAll("<X/>", "third"), 2, next);
    next = COMPLETED_NOTIFYS.take();
    assertEquals(notifyMessage.replaceAll("<X/>", "third"), 2, next);
    
    
    next = COMPLETED_WAITS.take();
    assertEquals(waitMessage.replaceAll("<X/>", "fourth"), 3, next);
    next = COMPLETED_NOTIFYS.take();
    assertEquals(notifyMessage.replaceAll("<X/>", "fourth"), 3, next);
    
    assertNotNull(notificationThread_);
    assertTrue(notificationThread_.wasInterrupted());
  }
  
	@Override
	public int getTests(I_CountType type) {
		return super.getTests(type, 2, true);
	}
	@Override
	public int getAsserts(I_CountType type) {
	  int asserts = 11;
		if (type.isFromMetaWithCoverage()) {
			//code coverage and circular dependencies
			return super.getAsserts(type, asserts + 3);
		} else {
			return super.getAsserts(type, asserts);
		}
	}

	@Override
	public int getUniqueAsserts(I_CountType type) {
	  int uAsserts = 11;
		if (type.isFromMetaWithCoverage()) {
			return super.getUniqueAsserts(type, uAsserts+ 3);
		} else {
			return super.getUniqueAsserts(type, uAsserts);
		}
	}
}
