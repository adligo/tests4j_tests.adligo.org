package org.adligo.tests4j_tests.run.common;

import static org.mockito.Mockito.mock;

import org.adligo.tests4j.run.common.Holder;
import org.adligo.tests4j.run.common.I_InitalValueFactory;
import org.adligo.tests4j.run.common.I_ThreadGroupFilter;
import org.adligo.tests4j.run.common.ThreadGroupFilter;
import org.adligo.tests4j.shared.asserts.reference.AllowedReferences;
import org.adligo.tests4j.system.shared.trials.SourceFileScope;
import org.adligo.tests4j.system.shared.trials.Test;
import org.adligo.tests4j_tests.base_trials.I_CountType;
import org.adligo.tests4j_tests.base_trials.SourceFileCountingTrial;
import org.adligo.tests4j_tests.references_groups.Tests4J_RunCommon_ReferenceGroup;
import org.adligo.tests4j_tests.run.common.mocks.ThreadGroupLocalMock;
import org.adligo.tests4j_tests.run.common.mocks.ThreadsMock;

import java.util.ArrayList;
import java.util.List;
/**
 * 
 */
@SourceFileScope (sourceClass=ThreadGroupFilter.class, minCoverage=81.0)
@AllowedReferences (groups=Tests4J_RunCommon_ReferenceGroup.class)
public class ThreadGroupLocalTrial extends SourceFileCountingTrial {
  
  @Test 
  public void testMethods() throws Exception {
    
    List<Thread> threadList = new ArrayList<Thread>();
    ThreadGroup tg = new ThreadGroup("ahha-1");
    Thread t = new Thread(tg, mock(Runnable.class), "ahha");
    threadList.add(t);
    
    ThreadGroup tg1 = new ThreadGroup("hmm1");
    t = new Thread(tg1, mock(Runnable.class), "ahha");
    threadList.add(t);
    
    tg = new ThreadGroup(tg1,"ahha-1");
    Thread t2 = new Thread(tg, mock(Runnable.class), "ahha");
    threadList.add(t2);
    
    ThreadGroup tg2 = new ThreadGroup("hmm2");
    t = new Thread(tg2, mock(Runnable.class), "ahha");
    threadList.add(t);
    
    ThreadsMock tm = new ThreadsMock(threadList);
    I_ThreadGroupFilter tgf = new ThreadGroupFilter("hmm", tm);
    assertEquals("hmm", tgf.getFilter());
    assertSame(tm, tgf.getThreads());
    
    ThreadGroupLocalMock childMock = new ThreadGroupLocalMock(new ThreadGroupFilter("hmm",tm),
        new I_InitalValueFactory<String>() {
          int counter = 0;
          @Override
          public String createNew() {
            
            return "new-" + counter++;
          }
        });
    
    assertNull(childMock.getValue());
    
    Holder<String> h = childMock.initialValue();
    assertNotNull(h);
    assertEquals("new-0", h.getHeld());
    
    
    h = childMock.initialValue();
    assertNotNull(h);
    assertEquals("new-0", h.getHeld());
    
    assertNull(childMock.getValue());
  }
  
  @Test 
  public void testGet() throws Exception {
    
    List<Thread> threadList = new ArrayList<Thread>();
    ThreadGroup tg = new ThreadGroup("hmm1");
    Thread t = new Thread(tg, mock(Runnable.class), "ahha");
    threadList.add(t);
    
    
    ThreadsMock tm = new ThreadsMock(threadList);
    I_ThreadGroupFilter tgf = new ThreadGroupFilter("hmm", tm);
    assertEquals("hmm", tgf.getFilter());
    assertSame(tm, tgf.getThreads());
    
    ThreadGroupLocalMock childMock = new ThreadGroupLocalMock(new ThreadGroupFilter("hmm",tm),
        new I_InitalValueFactory<String>() {
          @Override
          public String createNew() {
            
            return "new-special";
          }
        });
    Holder<String> value = childMock.get();
    assertNotNull(value);
    assertEquals("new-special", value.getHeld());
    assertSame(value, childMock.get());
    
  }
	@Override
	public int getTests(I_CountType type) {
		return super.getTests(type, 2, true);
	}
	
	@Override
	public int getAsserts(I_CountType type) {
	  int asserts = 13;
		if (type.isFromMetaWithCoverage()) {
			//code coverage and circular dependencies
			return super.getAsserts(type, asserts + 3);
		} else {
			return super.getAsserts(type, asserts);
		}
	}

	@Override
	public int getUniqueAsserts(I_CountType type) {
	  int uAsserts = 10;
		if (type.isFromMetaWithCoverage()) {
			return super.getUniqueAsserts(type, uAsserts+ 3);
		} else {
			return super.getUniqueAsserts(type, uAsserts);
		}
	}
}
