package org.adligo.tests4j_tests.run.common;

import org.adligo.tests4j.run.common.ClassesDelegate;
import org.adligo.tests4j.shared.asserts.common.ExpectedThrownData;
import org.adligo.tests4j.shared.asserts.common.I_Thrower;
import org.adligo.tests4j.shared.asserts.reference.AllowedReferences;
import org.adligo.tests4j.system.shared.trials.SourceFileScope;
import org.adligo.tests4j.system.shared.trials.SuppressOutput;
import org.adligo.tests4j.system.shared.trials.Test;
import org.adligo.tests4j_tests.base_trials.I_CountType;
import org.adligo.tests4j_tests.base_trials.SourceFileCountingTrial;
import org.adligo.tests4j_tests.references_groups.Tests4J_RunCommon_ReferenceGroup;

/**
 * @author scott
 * 
 */
@SourceFileScope (sourceClass=ClassesDelegate.class, minCoverage=100.0)
@SuppressOutput //there is a exception that shows up funny from this class
@AllowedReferences (groups=Tests4J_RunCommon_ReferenceGroup.class)
public class ClassesDelegateTrial extends SourceFileCountingTrial {
  
  @Test 
  public void testForName() throws Exception {
    ClassesDelegate cd = new ClassesDelegate();
    Class<?> string = cd.forName(String.class.getName());
    assertEquals(String.class.getName(), string.getName());
    
    assertThrown(new ExpectedThrownData(new ClassNotFoundException("hey")),
        new I_Thrower() {
          
          @Override
          public void run() throws Throwable {
            cd.forName("hey");
          }
        });
    
    Class<?> longClazz = cd.forName(Long.class.getName(), true, ClassLoader.getSystemClassLoader());
    assertEquals(Long.class.getName(), longClazz.getName());
    
    assertThrown(new ExpectedThrownData(new ClassNotFoundException("hmm")),
        new I_Thrower() {
          
          @Override
          public void run() throws Throwable {
            cd.forName("hmm", true, ClassLoader.getSystemClassLoader());
          }
        });
  }
  
	@Override
	public int getTests(I_CountType type) {
		return super.getTests(type, 1, true);
	}
	@Override
	public int getAsserts(I_CountType type) {
	  int asserts = 4;
		if (type.isFromMetaWithCoverage()) {
			//code coverage and circular dependencies
			return super.getAsserts(type, asserts + 3);
		} else {
			return super.getAsserts(type, asserts);
		}
	}

	@Override
	public int getUniqueAsserts(I_CountType type) {
	  int uAsserts = 4;
		if (type.isFromMetaWithCoverage()) {
			return super.getUniqueAsserts(type, uAsserts+ 3);
		} else {
			return super.getUniqueAsserts(type, uAsserts);
		}
	}
}
