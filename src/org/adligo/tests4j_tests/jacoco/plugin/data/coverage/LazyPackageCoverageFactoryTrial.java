package org.adligo.tests4j_tests.jacoco.plugin.data.coverage;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.adligo.tests4j.models.shared.asserts.BooleanAssertCommand;
import org.adligo.tests4j.models.shared.asserts.line_text.TextLines;
import org.adligo.tests4j.models.shared.trials.SourceFileScope;
import org.adligo.tests4j.models.shared.trials.Test;
import org.adligo.tests4j_4jacoco.plugin.data.coverage.LazyPackageCoverageFactory;
import org.adligo.tests4j_tests.base_trials.I_CountType;
import org.adligo.tests4j_tests.base_trials.SourceFileCountingTrial;
import org.adligo.tests4j_tests.models.shared.system.mocks.Tests4J_LogMock;

@SourceFileScope (sourceClass=LazyPackageCoverageFactory.class, minCoverage=62.0)
public class LazyPackageCoverageFactoryTrial extends SourceFileCountingTrial {
	private static final Tests4J_LogMock log = new Tests4J_LogMock();
	
	@Test
	public void testGetAllPackages() {
		List<String> classNames = new ArrayList<String>();
		classNames.add(BooleanAssertCommand.class.getName());
		classNames.add(TextLines.class.getName());
		Set<String> pkgs = LazyPackageCoverageFactory.getAllPackages(classNames, log);
	
		assertContains(pkgs,"org.adligo.tests4j.models.shared.asserts");
		assertContains(pkgs,"org.adligo.tests4j.models.shared.asserts.line_text");
		assertEquals(2, pkgs.size());
	}
	
	@Test
	public void testGetTopPackages() {
		List<String> packageNames = new ArrayList<String>();
		packageNames.add("org.adligo.tests4j.models.shared.asserts");
		packageNames.add("org.adligo.tests4j.models.shared.asserts.line_text");
		Set<String> pkgs = LazyPackageCoverageFactory.getTopPackages(packageNames, log);
	
		assertContains(pkgs,"org.adligo.tests4j.models.shared.asserts");
		assertEquals(1, pkgs.size());
	}
	
	@Test
	public void testGetClasses() {
		List<String> classNames = new ArrayList<String>();
		classNames.add(BooleanAssertCommand.class.getName());
		classNames.add(TextLines.class.getName());
		
		List<String> packageNames = new ArrayList<String>();
		packageNames.add("org.adligo.tests4j.models.shared.asserts");
		packageNames.add("org.adligo.tests4j.models.shared.asserts.line_text");
		List<String> pkgs = LazyPackageCoverageFactory.getClasses(
				"org.adligo.tests4j.models.shared.asserts", classNames, log);
		
		assertContains(pkgs, BooleanAssertCommand.class.getName());
		assertContains(pkgs, TextLines.class.getName());
	}
	
	@Override
	public int getTests(I_CountType type) {
		return super.getTests(type, 3);
	}

	@Override
	public int getAsserts(I_CountType type) {
		int thisAsserts = 7;
		//code coverage and circular dependencies +
		//custom afterTrialTests
		//+ see above
		int thisAfterAsserts = 2;
		if (type.isFromMetaWithCoverage()) {
			return super.getAsserts(type, thisAsserts + thisAfterAsserts);
		} else {
			return super.getAsserts(type, thisAsserts);
		}
	}

	@Override
	public int getUniqueAsserts(I_CountType type) {
		int thisUniqueAsserts = 7;
		//code coverage and circular dependencies +
		//custom afterTrialTests
		//+ see above
		int thisAfterUniqueAsserts = 2;
		if (type.isFromMetaWithCoverage()) {
			//code coverage and circular dependencies +
			//custom afterTrialTests
			return super.getUniqueAsserts(type, thisUniqueAsserts + thisAfterUniqueAsserts);
		} else {
			return super.getUniqueAsserts(type, thisUniqueAsserts);
		}
	}
}
