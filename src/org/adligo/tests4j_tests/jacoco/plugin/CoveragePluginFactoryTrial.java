package org.adligo.tests4j_tests.jacoco.plugin;

import org.adligo.tests4j.models.shared.system.DefaultLog;
import org.adligo.tests4j.models.shared.system.I_Tests4J_CoveragePlugin;
import org.adligo.tests4j.models.shared.system.Tests4J_CoveragePluginParams;
import org.adligo.tests4j.models.shared.trials.SourceFileScope;
import org.adligo.tests4j.models.shared.trials.Test;
import org.adligo.tests4j_4jacoco.plugin.CoveragePlugin;
import org.adligo.tests4j_4jacoco.plugin.CoveragePluginFactory;
import org.adligo.tests4j_tests.base_abstract_trials.SourceFileCountingTrial;

@SourceFileScope (sourceClass=CoveragePluginFactory.class, minCoverage=40.0)
public class CoveragePluginFactoryTrial extends SourceFileCountingTrial {

	@Test 
	public void testMethod() {
		CoveragePluginFactory factory = new CoveragePluginFactory();
		
		DefaultLog logger = new DefaultLog();
		Tests4J_CoveragePluginParams params = new Tests4J_CoveragePluginParams();
		I_Tests4J_CoveragePlugin cp =  factory.create(params, logger);
		assertNotNull(cp);
		assertEquals(CoveragePlugin.class.getName(), cp.getClass().getName());
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
