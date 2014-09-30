package org.adligo.tests4j_tests.system.shared.api;

import java.util.List;
import java.util.logging.LogManager;
import java.util.logging.Logger;

import org.adligo.tests4j.system.shared.api.Tests4J_Params;
import org.adligo.tests4j.system.shared.trials.I_Trial;
import org.adligo.tests4j.system.shared.trials.SourceFileScope;
import org.adligo.tests4j.system.shared.trials.Test;
import org.adligo.tests4j_tests.base_trials.I_CountType;
import org.adligo.tests4j_tests.base_trials.SourceFileCountingTrial;


@SourceFileScope(sourceClass=Tests4J_Params.class,minCoverage=6.0)
public class Tests4J_ParamsTrial extends SourceFileCountingTrial {
	
	@SuppressWarnings("unused") //this fixes a issue 
	// in our security manager which blocks thread creation during tests
	private static final Logger log = LogManager.getLogManager().getLogger(Tests4J_ParamsTrial.class.getName());
	
	@Test
	public void testDefaultParams() {
		Tests4J_Params params = new Tests4J_Params();
		List<Class<? extends I_Trial>> trials = params.getTrials();
		assertNotNull(trials);
		assertEquals(0, trials.size());
		assertNull( params.getRecommendedTrialThreadCount());
		
	}
	
	@Test
	public void testOneTrialRunParams() {
		Tests4J_Params params = new Tests4J_Params();
		params.addTrial(Tests4J_ParamsTrial.class);
		List<Class<? extends I_Trial>> trials = params.getTrials();
		assertNotNull(trials);
		assertEquals(1, trials.size());
		assertEquals(Tests4J_ParamsTrial.class, trials.get(0));
		
	}
	
	
	/*
	@Test
	public void testBasicToFromXml() {
		Tests4J_Params params = new Tests4J_Params();
		params.addTrial(Tests4J_ParamsTrial.class);
		params.setCoveragePluginClass(ScopedJacocoPlugin.class);
		String xml = params.toXml();
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
	public void afterTrialTests(I_SourceFileTrialResult p) {
		assertCounts(p);
		if (p.hasRecordedCoverage()) {
			I_SourceFileCoverage coverage = p.getSourceFileCoverage();
			assertGreaterThanOrEquals(46.00, coverage.getPercentageCoveredDouble());
		}
	}
	*/
	
	@Override
	public int getTests(I_CountType type) {
		return super.getTests(type, 2);
	}

	@Override
	public int getAsserts(I_CountType type) {
		int thisAsserts = 6;
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
		int thisUniqueAsserts = 6;
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