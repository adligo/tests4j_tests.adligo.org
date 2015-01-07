package org.adligo.tests4j_tests.jacoco.plugin.whitelists;

import org.adligo.tests4j.system.shared.trials.SourceFileScope;
import org.adligo.tests4j.system.shared.trials.Test;
import org.adligo.tests4j_4jacoco.plugin.whitelists.RequiredList;
import org.adligo.tests4j_tests.base_trials.I_CountType;
import org.adligo.tests4j_tests.base_trials.SourceFileCountingTrial;
import org.adligo.tests4j_tests.run.common.mocks.ClassesMock;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

//TODO investigate minCoverage
@SourceFileScope (sourceClass=RequiredList.class, minCoverage=99.0)
public class RequiredListTrial extends SourceFileCountingTrial {

	private static final int ASSERTS = 368;


	@SuppressWarnings({"unused", "boxing"})
  @Test 
	public void testSharedClassesOnlyInTests4J_ApprovedPackages() throws Exception {
	  RequiredList list = new RequiredList();
	  
	  Set<String> nip = list.getNonInstrumentedPackages();
	  assertContains(nip, "java.");
	  assertContains(nip, "javax.");
	  assertContains(nip, "sun.");
	  assertContains(nip, "org.jacoco.");
	  assertContains(nip, "org.objectweb.");
	  assertContains(nip, "org.w3c.");
	  assertContains(nip, "org.xml.");
	  assertEquals(7, nip.size());
	  
		Set<String> allowedPackages = new HashSet<String>();
		allowedPackages.add("org.adligo.tests4j.");
		allowedPackages.add("org.adligo.tests4j_4jacoco.");
		allowedPackages.add("org.objectweb.asm.");
		
		
		Map<String,Class<?>> classesMap = new HashMap<String,Class<?>>();
		
		
		Set<String>  classes = list.getWhitelist();
		for (String clazz: classes) {
			boolean inPkg = false;
			for (String pkg: allowedPackages) {
				if (clazz.indexOf(pkg) == 0) {
					inPkg = true;
					classesMap.put(clazz, Class.forName(clazz));
				}
			}
			assertTrue("The class " + clazz + " must be in one of the packages " +
					System.getProperty("line.seperator") + allowedPackages, inPkg);
		}
		
		ClassesMock cm = new ClassesMock(classesMap);
		new RequiredList(cm);
		for (String clazz: classes) {
		  assertEquals("forName(" + clazz + ",false," + ClassLoader.getSystemClassLoader().toString() +
          ")", cm.pollCalls());
    }
	}

	@Override
	public int getTests(I_CountType type) {
		return super.getTests(type, 1, false);
	}

	@Override
	public int getAsserts(I_CountType type) {
		int thisAsserts = ASSERTS;
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
		int thisUniqueAsserts = ASSERTS;
		if (type.isFromMetaWithCoverage()) {
			//code coverage and circular dependencies +
			//custom afterTrialTests
			return super.getUniqueAsserts(type, thisUniqueAsserts + 2);
		}  else {
			return super.getAsserts(type, thisUniqueAsserts);
		}
	}

}
