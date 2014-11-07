package org.adligo.tests4j_tests.jacoco.plugin.whitelists;

import org.adligo.tests4j.shared.asserts.common.ExpectedThrownData;
import org.adligo.tests4j.shared.asserts.common.I_Thrower;
import org.adligo.tests4j.system.shared.trials.SourceFileScope;
import org.adligo.tests4j.system.shared.trials.Test;
import org.adligo.tests4j_4jacoco.plugin.whitelists.BaseClassList;
import org.adligo.tests4j_tests.base_trials.I_CountType;
import org.adligo.tests4j_tests.base_trials.SourceFileCountingTrial;
import org.adligo.tests4j_tests.run.common.mocks.ClassesMock;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@SourceFileScope (sourceClass=BaseClassList.class, minCoverage=83.0)
public class BaseClassListTrial extends SourceFileCountingTrial {

	@SuppressWarnings("boxing")
  @Test 
	public void testSuccess() {
	  Map<String,Class<?>> classes = new HashMap<String,Class<?>>();
	  classes.put(String.class.getName(), String.class);
	  ClassesMock cm = new ClassesMock(classes);
	  
	  BaseClassList bcl = new BaseClassList(Collections.singleton(String.class.getName()), cm);
	  Set<String> whitelist = bcl.getWhitelist();
	  assertContains(whitelist, String.class.getName());
	  assertEquals(1, bcl.getWhitelist().size());
	  
	  assertEquals("forName(java.lang.String,false," + ClassLoader.getSystemClassLoader().toString() + 
	      ")", cm.pollCalls());
	}

	@Test 
  public void testFailure() {
	  Map<String,Class<?>> classes = new HashMap<String,Class<?>>();
	  Map<String,ClassNotFoundException> exceptions = new HashMap<String,ClassNotFoundException>();
	  exceptions.put("hmm", new ClassNotFoundException("hmm"));
    ClassesMock cm = new ClassesMock(classes, exceptions);
    
    assertThrown(new ExpectedThrownData(
        new RuntimeException(
        new ClassNotFoundException("hmm"))),
        new I_Thrower() {
          
          @SuppressWarnings("unused")
          @Override
          public void run() throws Throwable {
            new BaseClassList(Collections.singleton("hmm"), cm);
          }
        });
    
    
    assertEquals("forName(hmm,false," + ClassLoader.getSystemClassLoader().toString() + 
        ")", cm.pollCalls());
  }
	
	@Override
	public int getTests(I_CountType type) {
		return super.getTests(type, 2, false);
	}

	@Override
	public int getAsserts(I_CountType type) {
		int thisAsserts = 5;
		if (type.isFromMetaWithCoverage()) {
			//code coverage and circular dependencies +
			//custom afterTrialTests
			return super.getAsserts(type, thisAsserts + 2);
		} else {
			return super.getAsserts(type, thisAsserts);
		}
	}

	@Override
	public int getUniqueAsserts(I_CountType type) {
		int thisUniqueAsserts = 5;
		if (type.isFromMetaWithCoverage()) {
			//code coverage and circular dependencies +
			//custom afterTrialTests
			return super.getUniqueAsserts(type, thisUniqueAsserts + 2);
		}  else {
			return super.getAsserts(type, thisUniqueAsserts);
		}
	}

}
