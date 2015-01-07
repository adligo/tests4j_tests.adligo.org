package org.adligo.tests4j_tests.run.common;

import org.adligo.tests4j.run.common.I_InitalValueFactory;
import org.adligo.tests4j.run.common.I_ThreadGroupFilter;
import org.adligo.tests4j.run.common.I_ThreadGroupLocal;
import org.adligo.tests4j.run.common.I_Threads;
import org.adligo.tests4j.run.common.ThreadGroupFilter;
import org.adligo.tests4j.run.common.ThreadGroupLocal;
import org.adligo.tests4j.run.common.ThreadingFactory;
import org.adligo.tests4j.shared.asserts.reference.AllowedReferences;
import org.adligo.tests4j.system.shared.trials.SourceFileScope;
import org.adligo.tests4j.system.shared.trials.Test;
import org.adligo.tests4j_tests.base_trials.I_CountType;
import org.adligo.tests4j_tests.base_trials.SourceFileCountingTrial;
import org.adligo.tests4j_tests.references_groups.Tests4J_RunCommon_ReferenceGroup;
/**
 * 
 */
@SourceFileScope (sourceClass=ThreadingFactory.class)
@AllowedReferences (groups=Tests4J_RunCommon_ReferenceGroup.class)
public class ThreadingFactoryTrial extends SourceFileCountingTrial {
  
  @SuppressWarnings("unchecked")
  @Test 
  public void testMethods() throws Exception {
    ThreadingFactory tf = ThreadingFactory.INSTANCE;
    I_ThreadGroupFilter tgf = tf.createThreadGroupFilter("filter");
    assertNotNull(tgf);
    assertEquals(ThreadGroupFilter.class.getName(), tgf.getClass().getName());
   
    tgf = tf.createThreadGroupFilter("filter", mock(I_Threads.class));
    assertNotNull(tgf);
    assertEquals(ThreadGroupFilter.class.getName(), tgf.getClass().getName());
    
    I_InitalValueFactory<String> ivf = mock(I_InitalValueFactory.class);
    I_ThreadGroupLocal<String> tgl = tf.createThreadGroupLocal(tgf,ivf);
    assertNotNull(tgl);
    assertEquals(ThreadGroupLocal.class.getName(), tgl.getClass().getName());
  }
  
	@Override
	public int getTests(I_CountType type) {
		return super.getTests(type, 1, true);
	}
	
	@Override
	public int getAsserts(I_CountType type) {
	  int asserts = 6;
		if (type.isFromMetaWithCoverage()) {
			//code coverage and circular dependencies
			return super.getAsserts(type, asserts + 3);
		} else {
			return super.getAsserts(type, asserts);
		}
	}

	@Override
	public int getUniqueAsserts(I_CountType type) {
	  int uAsserts = 5;
		if (type.isFromMetaWithCoverage()) {
			return super.getUniqueAsserts(type, uAsserts+ 3);
		} else {
			return super.getUniqueAsserts(type, uAsserts);
		}
	}
}
