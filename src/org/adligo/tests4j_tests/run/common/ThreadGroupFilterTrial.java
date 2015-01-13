package org.adligo.tests4j_tests.run.common;

import org.adligo.tests4j.run.common.I_ThreadGroupFilter;
import org.adligo.tests4j.run.common.ThreadGroupFilter;
import org.adligo.tests4j.run.common.ThreadsDelegate;
import org.adligo.tests4j.shared.asserts.common.ExpectedThrowable;
import org.adligo.tests4j.shared.asserts.common.I_Thrower;
import org.adligo.tests4j.shared.asserts.reference.AllowedReferences;
import org.adligo.tests4j.system.shared.trials.SourceFileScope;
import org.adligo.tests4j.system.shared.trials.Test;
import org.adligo.tests4j_tests.base_trials.I_CountType;
import org.adligo.tests4j_tests.base_trials.SourceFileCountingTrial;
import org.adligo.tests4j_tests.references_groups.Tests4J_RunCommon_ReferenceGroup;
import org.adligo.tests4j_tests.run.common.mocks.ThreadsMock;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;
/**
 * 
 */
@SourceFileScope (sourceClass=ThreadGroupFilter.class, minCoverage=100.0)
@AllowedReferences (groups=Tests4J_RunCommon_ReferenceGroup.class)
public class ThreadGroupFilterTrial extends SourceFileCountingTrial {
  
  @Test 
  public void testDefault() throws Exception {
    I_ThreadGroupFilter tgf = new ThreadGroupFilter("hmm");
    assertEquals("hmm", tgf.getFilter());
    assertEquals(ThreadsDelegate.class.getName(), tgf.getThreads().getClass().getName());
  }
  
  @Test 
  public void testConstructorExceptions() throws Exception {
    assertThrown(new ExpectedThrowable(NullPointerException.class),
      new I_Thrower() {

        @SuppressWarnings("unused")
        @Override
        public void run() throws Throwable {
          new ThreadGroupFilter(null);
        }
    });
  }
  
  @Test 
  public void testMatchAndNoMatch() throws Exception {
    List<Thread> threadList = new ArrayList<Thread>();
    ThreadGroup tg = new ThreadGroup("hmm-1");
    Thread t = new Thread(tg, mock(Runnable.class), "ahha");
    threadList.add(t);
    
    ThreadGroup tg2 = new ThreadGroup("ahha-1");
    t = new Thread(tg2, mock(Runnable.class), "ahha");
    threadList.add(t);
    
    tg = new ThreadGroup(tg,"ahha-1");
    t = new Thread(tg, mock(Runnable.class), "ahha");
    threadList.add(t);
    
    ThreadsMock tm = new ThreadsMock(threadList);
    I_ThreadGroupFilter tgf = new ThreadGroupFilter("hmm", tm);
    assertEquals("hmm", tgf.getFilter());
    assertSame(tm, tgf.getThreads());
    
    String groupName = tgf.getThreadGroupNameMatchingFilter();
    assertEquals("hmm-1", groupName);
    
    assertNull(tgf.getThreadGroupNameMatchingFilter());
    
    groupName = tgf.getThreadGroupNameMatchingFilter();
    assertEquals("hmm-1", groupName);
  }
  
	@Override
	public int getTests(I_CountType type) {
		return super.getTests(type, 3, true);
	}
	@Override
	public int getAsserts(I_CountType type) {
	  int asserts = 8;
		if (type.isFromMetaWithCoverage()) {
			//code coverage and circular dependencies
			return super.getAsserts(type, asserts + 3);
		} else {
			return super.getAsserts(type, asserts);
		}
	}

	@Override
	public int getUniqueAsserts(I_CountType type) {
	  int uAsserts = 7;
		if (type.isFromMetaWithCoverage()) {
			return super.getUniqueAsserts(type, uAsserts+ 3);
		} else {
			return super.getUniqueAsserts(type, uAsserts);
		}
	}
}
