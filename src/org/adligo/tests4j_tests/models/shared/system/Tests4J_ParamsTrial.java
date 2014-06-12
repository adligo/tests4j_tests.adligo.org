package org.adligo.tests4j_tests.models.shared.system;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.adligo.tests4j.models.shared.I_Trial;
import org.adligo.tests4j.models.shared.SourceFileScope;
import org.adligo.tests4j.models.shared.SourceFileTrial;
import org.adligo.tests4j.models.shared.Test;
import org.adligo.tests4j.models.shared.coverage.I_SourceFileCoverage;
import org.adligo.tests4j.models.shared.results.feedback.I_SourceFileTrial_TestsResults;
import org.adligo.tests4j.models.shared.system.I_CoveragePlugin;
import org.adligo.tests4j.models.shared.system.I_ThreadCount;
import org.adligo.tests4j.models.shared.system.Tests4J_Params;
import org.adligo.tests4j_4jacoco.plugin.ScopedJacocoPlugin;


@SourceFileScope(sourceClass=Tests4J_Params.class)
public class Tests4J_ParamsTrial extends SourceFileTrial {

	
	@Test
	public void testDefaultParams() {
		Tests4J_Params params = new Tests4J_Params();
		List<Class<? extends I_Trial>> trials = params.getTrials();
		assertNotNull(trials);
		assertEquals(0, trials.size());
		assertEquals(0, params.getTrialThreadCount());
		
		for (int i = 0; i < 32; i++) {
			params.addTrial(Tests4J_ParamsTrial.class);
		}
		assertEquals(32, params.getTrialThreadCount());
	}
	
	@Test
	public void testOneTrialRunParams() {
		Tests4J_Params params = new Tests4J_Params();
		params.addTrial(Tests4J_ParamsTrial.class);
		List<Class<? extends I_Trial>> trials = params.getTrials();
		assertNotNull(trials);
		assertEquals(1, trials.size());
		assertEquals(Tests4J_ParamsTrial.class, trials.get(0));
		assertEquals(1, params.getTrialThreadCount());
		
	}
	
	
	@Test
	public void testBasicToFromXml() {
		Tests4J_Params params = new Tests4J_Params();
		params.addTrial(Tests4J_ParamsTrial.class);
		params.setCoveragePluginClass(ScopedJacocoPlugin.class);
		String xml = params.toXmlString();
		assertUniform(
				"<Tests4J_Params threadCount=\"org.adligo.tests4j.models.shared.system.SimpleThreadCount\" coveragePlugin=\"org.adligo.tests4j_4jacoco.plugin.ScopedJacocoPlugin\" >\n" +
				"\t<SimpleThreadCount count=\"32\"/>\n" +
				"\t<trials>\n" +
				"\t\t<trial>org.adligo.tests4j_tests.models.shared.system.Tests4J_ParamsTrial</trial>\n" +
				"\t</trials>\n" +
				"</Tests4J_Params>", xml);
		
		 params = new Tests4J_Params(xml);
		 I_ThreadCount tc = params.getThreadCount();
		 assertNotNull(tc);
		 assertEquals(32, tc.getThreadCount());
		 assertEquals(ScopedJacocoPlugin.class, params.getCoveragePluginClass());
		 assertTrue(params.getCoveragePlugin() instanceof I_CoveragePlugin);
		 List<Class<? extends I_Trial>> trials = params.getTrials();
		 assertEquals(1, trials.size());
		 assertEquals(Tests4J_ParamsTrial.class, trials.get(0));
		 
	}
	@Override
	public void afterTrialTests(I_SourceFileTrial_TestsResults  p) {
		if (p.hasRecordedCoverage()) {
			I_SourceFileCoverage coverage = p.getCoverage();
			assertGreaterThanOrEquals(100.00, coverage.getPercentageCoveredDouble());
		}
	}
}
