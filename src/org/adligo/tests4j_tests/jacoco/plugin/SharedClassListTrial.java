package org.adligo.tests4j_tests.jacoco.plugin;

import java.util.HashSet;
import java.util.Set;

import org.adligo.tests4j.models.shared.asserts.common.ExpectedThrownData;
import org.adligo.tests4j.models.shared.asserts.common.I_Thrower;
import org.adligo.tests4j.models.shared.trials.SourceFileScope;
import org.adligo.tests4j.models.shared.trials.Test;
import org.adligo.tests4j_4jacoco.plugin.SharedClassList;
import org.adligo.tests4j_tests.base_trials.SourceFileCountingTrial;

@SourceFileScope (sourceClass=SharedClassList.class, minCoverage=92.0)
public class SharedClassListTrial extends SourceFileCountingTrial {

	private static final int CLASSES_IN_WHITELIST = 152;

	@Test 
	public void testSharedClassesOnlyInTests4J_ApprovedPackages() {
		Set<String> allowedPackages = new HashSet<String>();
		allowedPackages.add("org.adligo.tests4j.");
		allowedPackages.add("org.adligo.tests4j_4jacoco.");
		allowedPackages.add("org.objectweb.asm.");
		
		Set<String>  classes = SharedClassList.WHITELIST;
		for (String clazz: classes) {
			boolean inPkg = false;
			for (String pkg: allowedPackages) {
				if (clazz.indexOf(pkg) == 0) {
					inPkg = true;
				}
			}
			assertTrue("The class " + clazz + " must be in one of the packages " +
					System.lineSeparator() + allowedPackages, inPkg);
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
	public int getTests() {
		return 2;
	}

	@Override
	public int getAsserts() {
		return CLASSES_IN_WHITELIST;
	}

	@Override
	public int getUniqueAsserts() {
		return CLASSES_IN_WHITELIST;
	}

}
