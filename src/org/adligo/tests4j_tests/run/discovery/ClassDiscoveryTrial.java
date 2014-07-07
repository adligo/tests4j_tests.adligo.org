package org.adligo.tests4j_tests.run.discovery;

import java.util.List;

import org.adligo.tests4j.models.shared.coverage.I_SourceFileCoverage;
import org.adligo.tests4j.models.shared.results.I_SourceFileTrialResult;
import org.adligo.tests4j.models.shared.trials.SourceFileScope;
import org.adligo.tests4j.models.shared.trials.SourceFileTrial;
import org.adligo.tests4j.models.shared.trials.Test;
import org.adligo.tests4j.run.discovery.ClassDiscovery;
import org.adligo.tests4j_tests.base_abstract_trials.SourceFileCountingTrial;

@SourceFileScope (sourceClass=ClassDiscovery.class)
public class ClassDiscoveryTrial extends SourceFileCountingTrial {

	@Test
	public void testDiscoveryPackage() throws Exception {
		ClassDiscovery cd = new ClassDiscovery("org.adligo.tests4j.run.discovery");
		List<String> clazzNames = cd.getClassNames();
		assertNotNull(clazzNames);
		assertEquals(2, clazzNames.size());
		assertTrue(clazzNames.contains("org.adligo.tests4j.run.discovery.ClassDiscovery"));
		assertTrue(clazzNames.contains("org.adligo.tests4j.run.discovery.TopPackageSet"));
		List<ClassDiscovery>  subs = cd.getSubPackages();
		assertNotNull(subs);
		assertEquals(0, subs.size());
	}
	
	@Override
	public void afterTrialTests(I_SourceFileTrialResult p) {
		assertCounts(p);
		if (p.hasRecordedCoverage()) {
			I_SourceFileCoverage coverage = p.getSourceFileCoverage();
			assertGreaterThanOrEquals(22.00, coverage.getPercentageCoveredDouble());
		}
	}
	
	@Override
	public int getTests() {
		return 1;
	}

	@Override
	public int getAsserts() {
		return 6;
	}

	@Override
	public int getUniqueAsserts() {
		return 5;
	}
}
