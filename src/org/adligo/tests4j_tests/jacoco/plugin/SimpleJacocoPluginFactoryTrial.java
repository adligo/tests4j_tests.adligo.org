package org.adligo.tests4j_tests.jacoco.plugin;

import org.adligo.tests4j.models.shared.system.DefaultLog;
import org.adligo.tests4j.models.shared.system.I_Tests4J_CoveragePlugin;
import org.adligo.tests4j.models.shared.trials.SourceFileScope;
import org.adligo.tests4j.models.shared.trials.Test;
import org.adligo.tests4j_4jacoco.plugin.SimpleJacocoPlugin;
import org.adligo.tests4j_4jacoco.plugin.SimpleJacocoPluginFactory;
import org.adligo.tests4j_tests.base_abstract_trials.SourceFileCountingTrial;

@SourceFileScope (sourceClass=SimpleJacocoPlugin.class, minCoverage=92.0)
public class SimpleJacocoPluginFactoryTrial extends SourceFileCountingTrial {

	@Test 
	public void testMethod() {
		SimpleJacocoPluginFactory factory = new SimpleJacocoPluginFactory();
	
		DefaultLog logger = new DefaultLog();
		I_Tests4J_CoveragePlugin cp =  factory.create(logger);
		assertTrue(cp instanceof SimpleJacocoPlugin);
		assertSame(logger, ((SimpleJacocoPlugin) cp).getTests4jLogger());
		
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
