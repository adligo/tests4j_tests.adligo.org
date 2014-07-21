package org.adligo.tests4j_tests.jacoco.plugin;

import org.adligo.tests4j.models.shared.system.DefaultLogger;
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
		
		DefaultLogger logger = new DefaultLogger();
		I_CoveragePlugin cp =  factory.create(logger);
		assertTrue(cp instanceof ScopedJacocoPlugin);
		assertSame(logger, ((ScopedJacocoPlugin) cp).getTests4jLogger());
		
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
