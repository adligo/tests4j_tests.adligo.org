package org.adligo.tests4j_tests.jacoco.plugin;

import java.util.HashSet;
import java.util.Set;

import org.adligo.tests4j.shared.asserts.common.ExpectedThrownData;
import org.adligo.tests4j.shared.asserts.common.I_Thrower;
import org.adligo.tests4j.system.shared.trials.SourceFileScope;
import org.adligo.tests4j.system.shared.trials.Test;
import org.adligo.tests4j_4jacoco.plugin.SharedClassList;
import org.adligo.tests4j_tests.base_trials.I_CountType;
import org.adligo.tests4j_tests.base_trials.SourceFileCountingTrial;

//TODO investigate minCoverage
@SourceFileScope (sourceClass=SharedClassList.class, minCoverage=0.0)
public class SharedClassListTrial extends SourceFileCountingTrial {

	private static final int CLASSES_IN_WHITELIST = 169;

	@Test 
	public void testSharedClassesOnlyInTests4J_ApprovedPackages() {
		Set<String> allowedPackages = new HashSet<String>();
		allowedPackages.add("org.adligo.tests4j.");
		allowedPackages.add("org.adligo.tests4j_4jacoco.");
		allowedPackages.add("org.objectweb.asm.");
		allowedPackages.add("org.mockito.");
		
		Set<String>  classes = SharedClassList.WHITELIST;
		for (String clazz: classes) {
			boolean inPkg = false;
			for (String pkg: allowedPackages) {
				if (clazz.indexOf(pkg) == 0) {
					inPkg = true;
				}
			}
			assertTrue("The class " + clazz + " must be in one of the packages " +
					System.getProperty("line.seperator") + allowedPackages, inPkg);
		}
	}


	@Test 
	public void testRuntimeException() {
		assertThrown(new ExpectedThrownData(new RuntimeException("java.lang.ClassNotFoundException: hey"),
				new ExpectedThrownData(new ClassNotFoundException("hey"))), 
				new I_Thrower() {
					
					@Override
					public void run() throws Throwable {
						SharedClassList.checkClass("hey");
					}
				});
	}

	@Override
	public int getTests(I_CountType type) {
		return super.getTests(type, 2);
	}

	@Override
	public int getAsserts(I_CountType type) {
		int thisAsserts = CLASSES_IN_WHITELIST;
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
		int thisUniqueAsserts = CLASSES_IN_WHITELIST;
		if (type.isFromMetaWithCoverage()) {
			//code coverage and circular dependencies +
			//custom afterTrialTests
			return super.getUniqueAsserts(type, thisUniqueAsserts + 2);
		}  else {
			return super.getAsserts(type, thisUniqueAsserts);
		}
	}

}
