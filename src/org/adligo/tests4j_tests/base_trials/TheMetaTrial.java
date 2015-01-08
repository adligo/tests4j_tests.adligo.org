package org.adligo.tests4j_tests.base_trials;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import org.adligo.tests4j.models.shared.coverage.I_PackageCoverageBrief;
import org.adligo.tests4j.models.shared.metadata.I_TrialMetadata;
import org.adligo.tests4j.models.shared.metadata.I_TrialRunMetadata;
import org.adligo.tests4j.models.shared.results.I_TrialRunResult;
import org.adligo.tests4j.run.discovery.ClassesWithSourceFileTrialsCalculator;
import org.adligo.tests4j.shared.common.TrialType;
import org.adligo.tests4j.shared.output.I_Tests4J_Log;
import org.adligo.tests4j.system.shared.trials.AbstractTrial;
import org.adligo.tests4j.system.shared.trials.I_MetaTrial;
import org.adligo.tests4j.system.shared.trials.TrialTypeAnnotation;

@TrialTypeAnnotation (type=TrialType.META_TRIAL_TYPE)
public class TheMetaTrial  extends AbstractTrial implements I_MetaTrial {
	private static final long TESTS = 3094;
	private static final int TRIALS = 571;
	
	private ClassesWithSourceFileTrialsCalculator calculator_;
	private I_TrialRunResult results_;
	private I_Tests4J_Log log_;
	//hmm package comparison data to include;
	// passing tests
	// relevant classes with trials %
	// minimum source file coverage %
	// minimum package coverage %
	
	@Override
	public void afterMetadataCalculated(I_TrialRunMetadata metadata) throws Exception {
		calculator_ = new ClassesWithSourceFileTrialsCalculator(metadata);
		
		log_ = super.getLog();
		if (calculator_.getPctWithTrialsDouble() <= 28.0) {
			Set<String> classes = calculator_.getClassesWithOutTrials();
			log_.log("The following source files do NOT have a associated SourceFileTrial.");
			for (String className: classes) {
				log_.log(className);
			}
		}
		assertGreaterThanOrEquals(28.0, calculator_.getPctWithTrialsDouble());
		
		// includes this
		List<? extends I_TrialMetadata> trialMetadata = metadata.getAllTrialMetadata();
		
		List<String> mdNames = new ArrayList<String>();
		
		for (I_TrialMetadata md: trialMetadata) {
			mdNames.add(md.getTrialName());
		}
		Collections.sort(mdNames);
		
		StringBuilder sb = new StringBuilder();
		for (String mdName: mdNames) {
			sb.append("'");
			sb.append(mdName);
			sb.append("'");
			sb.append(System.getProperty("line.seperator"));
		}
		assertEquals(sb.toString(), TRIALS, metadata.getAllTrialsCount());
		
		assertEquals(TESTS,  metadata.getAllTestsCount());
	}

	public void assertCoverageMatrix() {
		assertCoverageMatrix("org.adligo.tests4j.shared.i18n",
				100.0, 100.0);
		assertCoverageMatrix("org.adligo.tests4j.shared.en",
				100.0, 100.0);
		assertCoverageMatrix("org.adligo.tests4j.shared.common",
				100.0, 62.0);
		assertCoverageMatrix("org.adligo.tests4j.shared.xml",
				100.0, 82.0);
		assertCoverageMatrix("org.adligo.tests4j.shared.asserts.common",
				100.0, 75.0);
		assertCoverageMatrix("org.adligo.tests4j.shared.asserts.reference",
				100.0, 47.0);
		assertCoverageMatrix("org.adligo.tests4j.shared.asserts.line_text",
				60.0, 78.0);
		assertCoverageMatrix("org.adligo.tests4j.shared.asserts.uniform",
				40.0, 89.0);
		assertCoverageMatrix("org.adligo.tests4j.shared.asserts",
        100.0, 75.0);
		
		
		assertCoverageMatrix("org.adligo.tests4j.shared.output",
				100.0, 44.0);
		assertCoverageMatrix("org.adligo.tests4j.models.shared.reference_groups.jse.v1_6",
				100.0, 52.0);
		assertCoverageMatrix("org.adligo.tests4j.models.shared.reference_groups.jse.v1_7",
				100.0, 100.0);
		assertCoverageMatrix("org.adligo.tests4j.models.shared.reference_groups.jse.v1_8",
				100.0, 100.0);
		assertCoverageMatrix("org.adligo.tests4j.models.shared.reference_groups.jse",
				100.0, 61.0);
		assertCoverageMatrix("org.adligo.gwt_refs.v2_6",
				100.0, 97.0);
		assertCoverageMatrix("org.adligo.gwt_refs",
				100.0, 97.0);
		assertCoverageMatrix("org.adligo.tests4j.models.shared.metadata",
				100.0, 58.0);
		
		assertCoverageMatrix("org.adligo.tests4j.models.shared.coverage",
				50.0, 16.0);
		assertCoverageMatrix("org.adligo.tests4j.models.shared.results",
				100.0, 65.0);
		assertCoverageMatrix("org.adligo.tests4j.system.shared.trials",
				100.0, 35.0);
		assertCoverageMatrix("org.adligo.tests4j.system.shared.api",
				100.0, 49.0);
		assertCoverageMatrix("org.adligo.tests4j.system.shared.report.summary",
				100.0, 61.0);
		assertCoverageMatrix("org.adligo.tests4j.run.common",
        66.0, 50.0);
		assertCoverageMatrix("org.adligo.tests4j.run.xml.io.use_cases.v1_0",
        100.0, 0.0);
		
		assertCoverageMatrix("org.adligo.tests4j_4jacoco.plugin.data.multi",
        0.0, 0.0);
	}

	private void assertCoverageMatrix(String pkgName, double minPctSourceTrials, double minPctCoverage) {
		double pctWithTrials = calculator_.getPctWithTrialsDouble(pkgName);
		if (pctWithTrials < minPctSourceTrials) {
			
			StringBuilder sb = new StringBuilder("The following package;" + System.lineSeparator() + 
					pkgName + System.lineSeparator() + 
					" is missing the following source file trials " + 
					System.lineSeparator());
			Set<String> sfns = calculator_.getClassesWithOutTrials(pkgName);
			for (String sfn: sfns) {
				sb.append(sfn);
				sb.append(System.lineSeparator());
			}
			assertGreaterThanOrEquals(sb.toString(), minPctSourceTrials, 
					pctWithTrials);
				
		}
		
		if (results_.hasCoverage()) {
			I_PackageCoverageBrief cover =  getCoverage(pkgName, results_.getCoverage());
			assertNotNull("The following package didn't have code coverage and should;" +
					System.lineSeparator() + pkgName,
					cover);
			assertGreaterThanOrEquals("The following package didn't have enough code coverage;" +
				System.lineSeparator() + pkgName, minPctCoverage, cover.getPercentageCoveredDouble());
			
			
		}
	}
	
	
	private I_PackageCoverageBrief getCoverage(String packageName, List<I_PackageCoverageBrief> coverages) {
		for (I_PackageCoverageBrief pc: coverages) {
			if (packageName.equals(pc.getPackageName())) {
				return pc;
			}
		}
		for (I_PackageCoverageBrief pc: coverages) {
			if (packageName.contains(pc.getPackageName())) {
				return getCoverage(packageName, pc.getChildPackageCoverage());
			} 
		}
		return null;
	}
	
	@SuppressWarnings("boxing")
  @Override
	public void afterNonMetaTrialsRun(I_TrialRunResult results) throws Exception {
		//this assert is also for the child-packages;
		results_ = results;
		assertCoverageMatrix();
		
		//allow to run with out coverage plugin,
		//you may want to require this for your project.
		if (results.hasCoverage()) {
			double actual = results.getCoveragePercentage();
			assertGreaterThanOrEquals(57.0, actual);
		}	
		//TODO
		//assertEquals(1,results.getTrialsIgnored());
		//assertEquals(1,results.getTestsIgnored());
		assertGreaterThanOrEquals(TRIALS - 2, results.getTrialsPassed());
		//usually -2, ignored several tests
		assertGreaterThanOrEquals(TESTS - 10, results.getTestsPassed());
		
		//does not include assertions from this class yet
		//I think the single threaded count is off somewhere
		assertGreaterThanOrEquals(1316000L,results.getAsserts().longValue());
		assertGreaterThanOrEquals(18000L,results.getUniqueAsserts().longValue());
	}



}
