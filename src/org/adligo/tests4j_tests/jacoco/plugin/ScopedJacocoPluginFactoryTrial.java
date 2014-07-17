package org.adligo.tests4j_tests.jacoco.plugin;

import org.adligo.tests4j.models.shared.system.I_CoveragePlugin;
import org.adligo.tests4j.models.shared.trials.SourceFileScope;
import org.adligo.tests4j.models.shared.trials.Test;
import org.adligo.tests4j.shared.report.summary.SummaryReporter;
import org.adligo.tests4j_4jacoco.plugin.ScopedJacocoPlugin;
import org.adligo.tests4j_4jacoco.plugin.ScopedJacocoPluginFactory;
import org.adligo.tests4j_tests.base_abstract_trials.SourceFileCountingTrial;

@SourceFileScope (sourceClass=ScopedJacocoPluginFactory.class, minCoverage=100.0)
public class ScopedJacocoPluginFactoryTrial extends SourceFileCountingTrial {

	@Test 
	public void testMethod() {
		ScopedJacocoPluginFactory factory = new ScopedJacocoPluginFactory();
		SummaryReporter reporter = new SummaryReporter();
		I_CoveragePlugin cp =  factory.create(reporter);
		assertTrue(cp instanceof ScopedJacocoPlugin);
		assertSame(reporter, ((ScopedJacocoPlugin) cp).getReporter());
		
	}

	@Override
	public int getTests() {
		return 1;
	}

	@Override
	public int getAsserts() {
		return 2;
	}

	@Override
	public int getUniqueAsserts() {
		return 2;
	}

}
