package org.adligo.tests4j_tests.run.memory;

import static org.mockito.Mockito.mock;

import org.adligo.tests4j.run.common.ThreadsDelegate;
import org.adligo.tests4j.run.memory.Tests4J_ThreadFactory;
import org.adligo.tests4j.shared.asserts.common.ExpectedThrownData;
import org.adligo.tests4j.shared.asserts.common.I_Thrower;
import org.adligo.tests4j.shared.output.DefaultLog;
import org.adligo.tests4j.system.shared.trials.SourceFileScope;
import org.adligo.tests4j.system.shared.trials.Test;
import org.adligo.tests4j_tests.base_trials.I_CountType;
import org.adligo.tests4j_tests.base_trials.SourceFileCountingTrial;
import org.adligo.tests4j_tests.run.common.mocks.ThreadsMock;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Ok this is one of the strangest 
 * source trials I have ever written
 * it tests NotifierDelegate which calls
 * wait(), notify() exc.  
 * @author scott
 * TODO look at minCoverage I think it should be 100%
 * 
 */
@SourceFileScope (sourceClass=Tests4J_ThreadFactory.class, minCoverage=89.0)
public class Tests4J_ThreadFactoryTrial extends SourceFileCountingTrial {
  
  @SuppressWarnings("unused")
  @Test 
  public void testConstructorExceptionsThread() throws Exception {
    assertThrown(new ExpectedThrownData(NullPointerException.class), 
        new I_Thrower() {

          
          @Override
          public void run() throws Throwable {
            new Tests4J_ThreadFactory(null);
          }
      
    });
    assertThrown(new ExpectedThrownData(NullPointerException.class), 
        new I_Thrower() {

          
          @Override
          public void run() throws Throwable {
            new Tests4J_ThreadFactory(null, new ThreadsDelegate());
          }
      
    });
    assertThrown(new ExpectedThrownData(NullPointerException.class), 
        new I_Thrower() {

          
          @Override
          public void run() throws Throwable {
            new Tests4J_ThreadFactory((Tests4J_ThreadFactory) null, Tests4J_ThreadFactory.SETUP_THREAD_NAME);
          }
      
    });
    assertThrown(new ExpectedThrownData(new IllegalArgumentException(Tests4J_ThreadFactory.NAME_NOT_ALLOWED)), 
        new I_Thrower() {

          
          @Override
          public void run() throws Throwable {
            new Tests4J_ThreadFactory(new Tests4J_ThreadFactory(new DefaultLog()), "hey");
          }
      
    });
    
    
    assertThrown(new ExpectedThrownData(NullPointerException.class), 
        new I_Thrower() {

          
          @Override
          public void run() throws Throwable {
            new Tests4J_ThreadFactory(new Tests4J_ThreadFactory(new DefaultLog()), null);
          }
      
    });
    
  }
  
  @Test 
  public void testMainThreadFactory() throws Exception {
    Tests4J_ThreadFactory factory = new Tests4J_ThreadFactory(new DefaultLog());
    assertSame(Thread.currentThread().getThreadGroup(),
        factory.getInstanceCreationThreadGroup());
    
    ThreadGroup tg = new ThreadGroup("mock-main-thread-group");
    Thread t = new Thread(tg, mock(Runnable.class),"mock-main");
    ThreadsMock tm = new ThreadsMock(Collections.singletonList(t));
    factory = new Tests4J_ThreadFactory(new DefaultLog(), tm);
    assertSame(tg,factory.getInstanceCreationThreadGroup());
    
    Runnable r = mock(Runnable.class);
    Thread created = factory.newThread(r);
    assertEquals(Tests4J_ThreadFactory.MAIN_THREAD_NAME, created.getName());
    //no good way to check the runnable so skipping it
    ThreadGroup createdGroup = created.getThreadGroup();
    assertSame(tg, createdGroup.getParent());
    assertEquals(Tests4J_ThreadFactory.MAIN_THREAD_GROUP, createdGroup.getName());
    
    List<Thread> threads = factory.getThreads();
    assertContains(threads, created);
    assertEquals(1, threads.size());
  }
  
  
  @Test 
  public void testSetupThreadFactory() throws Exception {
    assertSimpleParentChildThreadFactory(Tests4J_ThreadFactory.SETUP_THREAD_NAME);
  }

  @Test 
  public void testRemoteThreadFactory() throws Exception {
    assertSimpleParentChildThreadFactory(Tests4J_ThreadFactory.REMOTE_THREAD_NAME);
  }
  
  @Test 
  public void testServerThreadFactory() throws Exception {
    assertSimpleParentChildThreadFactory(Tests4J_ThreadFactory.SERVER_THREAD_NAME);
  }
  
  @Test 
  public void testTrialThreadFactory() throws Exception {
    assertSimpleParentChildThreadFactory(Tests4J_ThreadFactory.TRIAL_THREAD_NAME);
  }
  
  @SuppressWarnings("boxing")
  private void assertSimpleParentChildThreadFactory(String name) {
    Tests4J_ThreadFactory factory = new Tests4J_ThreadFactory(new DefaultLog());
    assertSame(Thread.currentThread().getThreadGroup(),
        factory.getInstanceCreationThreadGroup());
    
    ThreadGroup tg = new ThreadGroup("mock-main-thread-group");
    List<Thread> mockThreads = new ArrayList<Thread>();
    for (int i = 0; i < 4; i++) {
      mockThreads.add(new Thread(tg, mock(Runnable.class),"mock-main"));
    }
    
    ThreadsMock tm = new ThreadsMock(mockThreads);
    //1
    factory = new Tests4J_ThreadFactory(new DefaultLog(), tm);
    
    Runnable r = mock(Runnable.class);
    
    //2
    Thread top = factory.newThread(r);
    ThreadGroup topGroup = top.getThreadGroup();
    assertSame(tg, topGroup.getParent());
    //3
    Tests4J_ThreadFactory childFactory = new Tests4J_ThreadFactory(factory, name, tm);
    
    //4
    Thread created = childFactory.newThread(r);
    assertEquals("tests4j-" + name + "-1", created.getName());
    //no good way to check the runnable so skipping it
    ThreadGroup createdGroup = created.getThreadGroup();
    assertSame(topGroup, createdGroup.getParent());
    if (Tests4J_ThreadFactory.TRIAL_THREAD_NAME.equals(name)) {
      assertEquals("tests4j-" + name + "-1-group", createdGroup.getName());
    } else {
      assertEquals("tests4j-" + name + "-group", createdGroup.getName());
    }
    List<Thread> threads = childFactory.getThreads();
    assertContains(threads, created);
    assertEquals(1, threads.size());
    
    Thread created2 = childFactory.newThread(r);
    assertEquals("tests4j-" + name + "-2", created2.getName());
    //no good way to check the runnable so skipping it
    ThreadGroup createdGroup2 = created2.getThreadGroup();
    assertSame(topGroup, createdGroup2.getParent());
    if (Tests4J_ThreadFactory.TRIAL_THREAD_NAME.equals(name)) {
      assertEquals("tests4j-" + name + "-1-group", createdGroup.getName());
    } else {
      assertEquals("tests4j-" + name + "-group", createdGroup.getName());
    }
    
    List<Thread> threads2 = childFactory.getThreads();
    assertContains(threads2, created);
    assertContains(threads2, created2);
    assertEquals(2, threads2.size());
  }
  
  @Test 
  public void testTestThreadFactory() throws Exception {
    assertComplexParentChildThreadFactory(Tests4J_ThreadFactory.TEST_THREAD_NAME);
  }
  
  @Test 
  public void testCustomThreadFactory() throws Exception {
    assertComplexParentChildThreadFactory(Tests4J_ThreadFactory.CUSTOM_THREAD_NAME);
  }
  
  @SuppressWarnings("boxing")
  private void assertComplexParentChildThreadFactory(String name) {
    Tests4J_ThreadFactory factory = new Tests4J_ThreadFactory(new DefaultLog());
    assertSame(Thread.currentThread().getThreadGroup(),
        factory.getInstanceCreationThreadGroup());
    
    List<Thread> threadMocks = new ArrayList<Thread>();
    
    ThreadGroup tg = new ThreadGroup("main-mock-group");
    Thread t = new Thread(tg, mock(Runnable.class),"main-mock");
    threadMocks.add(t);
    
    t = new Thread(tg, mock(Runnable.class),"main-mock");
    threadMocks.add(t);
    
    tg = new ThreadGroup("tests4j-main-mock-group");
    threadMocks.add(new Thread(tg, mock(Runnable.class),"tests4j-main-mock"));
    threadMocks.add(new Thread(tg, mock(Runnable.class),"tests4j-main-mock"));
    
    tg = new ThreadGroup("tests4j-trial-1-mock-group");
    threadMocks.add(new Thread(tg, mock(Runnable.class),"tests4j-trial-1"));
    threadMocks.add(new Thread(tg, mock(Runnable.class),"tests4j-trial-1"));
    threadMocks.add(new Thread(tg, mock(Runnable.class),"tests4j-trial-1"));

    
    ThreadsMock tm = new ThreadsMock(threadMocks);
    //call 1
    factory = new Tests4J_ThreadFactory(new DefaultLog(), tm);
    
    Runnable r = mock(Runnable.class);
    //call 2
    factory.newThread(r);
    //call 3
    Tests4J_ThreadFactory childFactory = new Tests4J_ThreadFactory(
        factory, Tests4J_ThreadFactory.TRIAL_THREAD_NAME,tm);
    //call 4
    Thread second = childFactory.newThread(r);
    ThreadGroup secondGroup = second.getThreadGroup();
    
    //5
    Tests4J_ThreadFactory grandFactory = new Tests4J_ThreadFactory(childFactory, name,tm);
    Thread third = grandFactory.newThread(r);
    
    String baseGroup = "tests4j-" + Tests4J_ThreadFactory.TRIAL_THREAD_NAME ;
    
    assertEquals("tests4j-trial-1-" + name + "-1" , third.getName());
    //no good way to check the runnable so skipping it
    //6
    ThreadGroup createdGroup = third.getThreadGroup();
    //these should both be the trial thread group
    assertSame(secondGroup, createdGroup);
    assertEquals(baseGroup + "-1-group", createdGroup.getName());
    
    List<Thread> threads = grandFactory.getThreads();
    assertContains(threads, third);
    assertEquals(1, threads.size());
    
    //7
    Thread created2 = grandFactory.newThread(r);
    assertEquals("tests4j-trial-1-" + name + "-2", created2.getName());
    //no good way to check the runnable so skipping it
    ThreadGroup createdGroup2 = created2.getThreadGroup();
    //these should both be the trial thread group
    assertSame(secondGroup, createdGroup2);
    assertEquals(baseGroup + "-1-group", createdGroup2.getName());
    
    List<Thread> threads2 = grandFactory.getThreads();
    assertContains(threads2, third);
    assertContains(threads2, created2);
    assertEquals(2, threads2.size());
  }
	@Override
	public int getTests(I_CountType type) {
		return super.getTests(type, 8, false);
	}
	@Override
	public int getAsserts(I_CountType type) {
	  int asserts = 88;
		if (type.isFromMetaWithCoverage()) {
			//code coverage and circular dependencies
			return super.getAsserts(type, asserts + 2);
		} else {
			return super.getAsserts(type, asserts);
		}
	}

	@Override
	public int getUniqueAsserts(I_CountType type) {
	  int uAsserts = 75;
		if (type.isFromMetaWithCoverage()) {
			return super.getUniqueAsserts(type, uAsserts+ 2);
		} else {
			return super.getUniqueAsserts(type, uAsserts);
		}
	}
}
