package org.adligo.tests4j_tests;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import org.adligo.tests4j.models.shared.coverage.I_PackageCoverage;
import org.adligo.tests4j.models.shared.metadata.I_TrialMetadata;
import org.adligo.tests4j.models.shared.metadata.I_TrialRunMetadata;
import org.adligo.tests4j.models.shared.results.I_TrialRunResult;
import org.adligo.tests4j.models.shared.trials.AbstractTrial;
import org.adligo.tests4j.models.shared.trials.I_MetaTrial;
import org.adligo.tests4j.models.shared.trials.TrialTypeAnnotation;
import org.adligo.tests4j.run.discovery.ClassesWithSourceFileTrialsCalculator;
import org.adligo.tests4j.shared.common.TrialType;
import org.adligo.tests4j.shared.output.I_Tests4J_Log;

@TrialTypeAnnotation (type=TrialType.META_TRIAL_TYPE)
public class TheMetaTrial  extends AbstractTrial implements I_MetaTrial {
	private static final int TESTS = 1916;
	private static final int TRIALS = 354;
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
				100.0, 83.0);
		assertCoverageMatrix("org.adligo.tests4j.shared.xml",
				100.0, 92.0);
		assertCoverageMatrix("org.adligo.tests4j.shared.asserts.common",
				100.0, 85.0);
		assertCoverageMatrix("org.adligo.tests4j.shared.asserts.dependency",
				100.0, 47.0);
		assertCoverageMatrix("org.adligo.tests4j.shared.asserts.line_text",
				60.0, 88.0);
		assertCoverageMatrix("org.adligo.tests4j.shared.asserts.uniform",
				40.0, 93.0);
		
		assertCoverageMatrix("org.adligo.tests4j.shared.asserts",
				100.0, 83.0);
		assertCoverageMatrix("org.adligo.tests4j.shared.output",
				100.0, 66.0);
		assertCoverageMatrix("org.adligo.tests4j.models.shared.dependency",
				100.0, 47.0);
		/*
		if (results.hasCoverage()) {
			results.getCoverage();
			assertGreaterThanOrEquals(100.0, );
		}
		assertGreaterThanOrEquals(100.0, calculator.getPctWithTrials("org.adligo.tests4j.models.shared.en"));
		assertGreaterThanOrEquals(100.0, calculator.getPctWithTrials("org.adligo.tests4j.models.shared.asserts"));
		assertGreaterThanOrEquals(100.0, calculator.getPctWithTrials("org.adligo.tests4j.models.shared.asserts.common"));
		assertGreaterThanOrEquals(100.0, calculator.getPctWithTrials("org.adligo.tests4j.models.shared.asserts.line_text"));
		assertGreaterThanOrEquals(100.0, calculator.getPctWithTrials("org.adligo.tests4j.models.shared.common"));
		
		assertGreaterThanOrEquals(100.0, calculator.getPctWithTrials("org.adligo.tests4j.models.shared.metadata"));
		assertGreaterThanOrEquals(100.0, calculator.getPctWithTrials("org.adligo.tests4j.models.shared.xml"));
		*/
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
			I_PackageCoverage cover =  getCoverage(pkgName, results_.getCoverage());
			assertNotNull("The following package didn't have code coverage and should;" +
					System.lineSeparator() + pkgName,
					cover);
			assertGreaterThanOrEquals("The following package didn't have enough code coverage;" +
				System.lineSeparator() + pkgName, minPctCoverage, cover.getPercentageCoveredDouble());
			
			
		}
	}
	
	
	private I_PackageCoverage getCoverage(String packageName, List<I_PackageCoverage> coverages) {
		for (I_PackageCoverage pc: coverages) {
			if (packageName.equals(pc.getPackageName())) {
				return pc;
			}
		}
		for (I_PackageCoverage pc: coverages) {
			if (packageName.contains(pc.getPackageName())) {
				return getCoverage(packageName, pc.getChildPackageCoverage());
			} 
		}
		return null;
	}
	
	@Override
	public void afterNonMetaTrialsRun(I_TrialRunResult results) throws Exception {
		//this assert is also for the child-packages;
		results_ = results;
		assertCoverageMatrix();
		
		//allow to run with out coverage plugin,
		//you may want to require this for your project.
		if (results.hasCoverage()) {
			double actual = results.getCoveragePercentage();
			//assertGreaterThanOrEquals(60.0, actual);
			//coverage is bouncing around like a ping pong ball
			// it was at 76% ug, then I added some tests 
			// and it dropped to 62% hmm
			assertGreaterThanOrEquals(59.0, actual);
		}	
		//TODO
		//assertEquals(1,results.getTrialsIgnored());
		assertEquals(0,results.getTestsIgnored());
		assertGreaterThanOrEquals(TRIALS - 1, results.getTrialsPassed());
		assertGreaterThanOrEquals(TESTS - 2, results.getTestsPassed());
		
		//does not include assertions from this class yet
		//I think the single threaded count is off somewhere
		assertGreaterThanOrEquals(1314000,results.getAsserts());
		assertGreaterThanOrEquals(17000,results.getUniqueAsserts());
	}



}
