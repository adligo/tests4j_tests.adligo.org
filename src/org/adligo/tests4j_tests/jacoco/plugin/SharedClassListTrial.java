package org.adligo.tests4j_tests.jacoco.plugin;

import java.util.HashSet;
import java.util.Set;

import org.adligo.tests4j.models.shared.trials.SourceFileScope;
import org.adligo.tests4j.models.shared.trials.Test;
import org.adligo.tests4j_4jacoco.plugin.SharedClassList;
import org.adligo.tests4j_tests.base_abstract_trials.SourceFileCountingTrial;

@SourceFileScope (sourceClass=SharedClassList.class, minCoverage=92.0)
public class SharedClassListTrial extends SourceFileCountingTrial {

	@Test 
	public void testSharedClassesOnlyInTests4J_ApprovedPackages() {
		Set<String> allowedPackages = new HashSet<String>();
		allowedPackages.add("org.adligo.tests4j.");
		allowedPackages.add("org.adligo.tests4j_4jacoco.");
		
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

	@Override
	public int getTests() {
		return 1;
	}

	@Override
	public int getAsserts() {
		return 101;
	}

	@Override
	public int getUniqueAsserts() {
		return 101;
	}

}
