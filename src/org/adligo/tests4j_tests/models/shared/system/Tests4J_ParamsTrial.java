package org.adligo.tests4j_tests.models.shared.system;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.adligo.tests4j.models.shared.I_AbstractTrial;
import org.adligo.tests4j.models.shared.SourceFileScope;
import org.adligo.tests4j.models.shared.SourceFileTrial;
import org.adligo.tests4j.models.shared.Test;
import org.adligo.tests4j.models.shared.coverage.I_SourceFileCoverage;
import org.adligo.tests4j.models.shared.system.Tests4J_Params;
import org.adligo.tests4j_4jacoco.plugin.ScopedJacocoPlugin;


@SourceFileScope(sourceClass=Tests4J_Params.class)
public class Tests4J_ParamsTrial extends SourceFileTrial {

	
	@Test
	public void testDefaultParams() {
		Tests4J_Params params = new Tests4J_Params();
		List<Class<? extends I_AbstractTrial>> trials = params.getTrials();
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
		List<Class<? extends I_AbstractTrial>> trials = params.getTrials();
		assertNotNull(trials);
		assertEquals(1, trials.size());
		assertEquals(Tests4J_ParamsTrial.class, trials.get(0));
		assertEquals(1, params.getTrialThreadCount());
		
	}
	
	
	@Test
	public void testBasicToXml() {
		Tests4J_Params params = new Tests4J_Params();
		params.addTrial(Tests4J_ParamsTrial.class);
		params.setCoveragePluginClass(ScopedJacocoPlugin.class);
		String xml = params.toXmlString();
		assertUniform(
				"<Tests4J_Params trialThreadCount=\"32\" coveragePlugin=\"org.adligo.tests4j_4jacoco.plugin.ScopedJacocoPlugin\" >\n" +
				"\t<trials>\n" +
				"\t\t<trial>org.adligo.tests4j_tests.models.shared.system.Tests4J_ParamsTrial</trial>\n" +
				"\t</trials>\n" +
				"</Tests4J_Params>", xml);
	}
	@Override
	public void afterTrialTests(I_SourceFileCoverage p) {
		System.out.println("" + this.getClass().getName() + " covered " + p.getPercentageCoveredDouble());
		assertGreaterThanOrEquals(30.00,p.getPercentageCoveredDouble());
	}
}
