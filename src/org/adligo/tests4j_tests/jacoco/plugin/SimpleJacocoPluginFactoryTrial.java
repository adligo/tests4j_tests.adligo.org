package org.adligo.tests4j_tests.jacoco.plugin;

import org.adligo.tests4j.models.shared.system.I_CoveragePlugin;
import org.adligo.tests4j.models.shared.trials.SourceFileScope;
import org.adligo.tests4j.models.shared.trials.Test;
import org.adligo.tests4j.shared.report.summary.SummaryReporter;
import org.adligo.tests4j_4jacoco.plugin.ScopedJacocoPlugin;
import org.adligo.tests4j_4jacoco.plugin.ScopedJacocoPluginFactory;
import org.adligo.tests4j_4jacoco.plugin.SimpleJacocoPlugin;
import org.adligo.tests4j_4jacoco.plugin.SimpleJacocoPluginFactory;
import org.adligo.tests4j_tests.base_abstract_trials.SourceFileCountingTrial;

@SourceFileScope (sourceClass=SimpleJacocoPlugin.class, minCoverage=94.0)
public class SimpleJacocoPluginFactoryTrial extends SourceFileCountingTrial {

	@Test 
	public void testMethod() {
		SimpleJacocoPluginFactory factory = new SimpleJacocoPluginFactory();
		SummaryReporter reporter = new SummaryReporter();
		I_CoveragePlugin cp =  factory.create(reporter);
		assertTrue(cp instanceof SimpleJacocoPlugin);
		assertSame(reporter, ((SimpleJacocoPlugin) cp).getReporter());
		
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
