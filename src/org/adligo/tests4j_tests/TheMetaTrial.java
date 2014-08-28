package org.adligo.tests4j_tests;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.adligo.tests4j.models.shared.common.TrialType;
import org.adligo.tests4j.models.shared.metadata.I_TrialMetadata;
import org.adligo.tests4j.models.shared.metadata.I_TrialRunMetadata;
import org.adligo.tests4j.models.shared.results.I_TrialRunResult;
import org.adligo.tests4j.models.shared.trials.AbstractTrial;
import org.adligo.tests4j.models.shared.trials.I_MetaTrial;
import org.adligo.tests4j.models.shared.trials.TrialTypeAnnotation;
import org.adligo.tests4j.run.discovery.RelevantClassesWithTrialsCalculator;

@TrialTypeAnnotation (type=TrialType.META_TRIAL_TYPE)
public class TheMetaTrial  extends AbstractTrial implements I_MetaTrial {
	private RelevantClassesWithTrialsCalculator calculator;
	
	//hmm package comparison data to include;
	// passing tests
	// relevant classes with trials %
	// minimum source file coverage %
	// minimum package coverage %
	
	

	@Override
	public void afterMetadataCalculated(I_TrialRunMetadata metadata) throws Exception {
		calculator = new RelevantClassesWithTrialsCalculator(metadata);
		
		assertGreaterThanOrEquals(30.0, calculator.getPct());
		//this assert is also for the child-packages;
		assertGreaterThanOrEquals(100.0, calculator.getPct("org.adligo.tests4j.models.shared.asserts"));
		assertGreaterThanOrEquals(100.0, calculator.getPct("org.adligo.tests4j.models.shared.asserts.common"));
		assertGreaterThanOrEquals(100.0, calculator.getPct("org.adligo.tests4j.models.shared.asserts.line_text"));
		assertGreaterThanOrEquals(100.0, calculator.getPct("org.adligo.tests4j.models.shared.common"));
		assertGreaterThanOrEquals(100.0, calculator.getPct("org.adligo.tests4j.models.shared.en"));
		assertGreaterThanOrEquals(100.0, calculator.getPct("org.adligo.tests4j.models.shared.metadata"));
		assertGreaterThanOrEquals(100.0, calculator.getPct("org.adligo.tests4j.models.shared.xml"));
		
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
			sb.append(System.lineSeparator());
		}
		assertEquals(sb.toString(), 133, metadata.getAllTrialsCount());
		
		assertEquals(609,  metadata.getAllTestsCount());
	}

	@Override
	public void afterNonMetaTrialsRun(I_TrialRunResult results) throws Exception {
		//allow to run with out coverage plugin,
		//you may want to require this for your project.
		if (results.hasCoverage()) {
			double actual = results.getCoveragePercentage();
			//assertGreaterThanOrEquals(60.0, actual);
			assertGreaterThanOrEquals(55.0, actual);
		}
		//TODO
		//assertEquals(1,results.getTrialsIgnored());
		assertEquals(0,results.getTestsIgnored());
		//this does not include this test method
		// does include afterMetadataCalculated(I_TrialRunMetadata metadata)
		// - 4 ignored tests in
		// MultiRecordingTrial
		assertGreaterThanOrEquals(601, results.getTestsPassed());
		
		//does not include assertions from this class yet
		//I think the single threaded count is off somewhere
		assertGreaterThanOrEquals(130000,results.getAsserts());
		assertGreaterThanOrEquals(9600,results.getUniqueAsserts());
	}



}
