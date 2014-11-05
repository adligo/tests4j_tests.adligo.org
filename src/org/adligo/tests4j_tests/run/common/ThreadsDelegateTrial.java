package org.adligo.tests4j_tests.run.common;

import org.adligo.tests4j.run.common.ThreadsDelegate;
import org.adligo.tests4j.shared.asserts.reference.AllowedReferences;
import org.adligo.tests4j.system.shared.trials.SourceFileScope;
import org.adligo.tests4j.system.shared.trials.Test;
import org.adligo.tests4j_tests.base_trials.I_CountType;
import org.adligo.tests4j_tests.base_trials.SourceFileCountingTrial;
import org.adligo.tests4j_tests.references_groups.Tests4J_RunCommon_ReferenceGroup;

/**
 * Ok this is one of the strangest 
 * source trials I have ever written
 * it tests NotifierDelegate which calls
 * wait(), notify() exc.  
 * @author scott
 * TODO look at minCoverage I think it should be 100%
 * 
 */
@SourceFileScope (sourceClass=ThreadsDelegate.class, minCoverage=100.0)
@AllowedReferences (groups=Tests4J_RunCommon_ReferenceGroup.class)
public class ThreadsDelegateTrial extends SourceFileCountingTrial {
  
  @Test 
  public void testCurrentThread() throws Exception {
    Thread currentThread = Thread.currentThread();
    ThreadsDelegate td = new ThreadsDelegate();
    Thread tdt = td.currentThread();
    assertSame(currentThread, tdt);
  }
  
	@Override
	public int getTests(I_CountType type) {
		return super.getTests(type, 1, true);
	}
	@Override
	public int getAsserts(I_CountType type) {
	  int asserts = 1;
		if (type.isFromMetaWithCoverage()) {
			//code coverage and circular dependencies
			return super.getAsserts(type, asserts + 3);
		} else {
			return super.getAsserts(type, asserts);
		}
	}

	@Override
	public int getUniqueAsserts(I_CountType type) {
	  int uAsserts = 1;
		if (type.isFromMetaWithCoverage()) {
			return super.getUniqueAsserts(type, uAsserts+ 3);
		} else {
			return super.getUniqueAsserts(type, uAsserts);
		}
	}
}
