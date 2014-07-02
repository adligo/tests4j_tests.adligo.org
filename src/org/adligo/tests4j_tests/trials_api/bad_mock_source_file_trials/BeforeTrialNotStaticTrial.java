package org.adligo.tests4j_tests.trials_api.bad_mock_source_file_trials;

import org.adligo.tests4j.models.shared.trials.BeforeTrial;
import org.adligo.tests4j.models.shared.trials.SourceFileScope;
import org.adligo.tests4j.models.shared.trials.SourceFileTrial;
import org.adligo.tests4j.models.shared.trials.Test;
import org.adligo.tests4j.models.shared.trials.TrialRecursion;

/**
 * note this trial is run by the Run_SourceFileTrial_Trial,
 * and is intended to fail.
 * 
 * @author scott
 *
 */
@SourceFileScope (sourceClass = NoSourceFileScopeAnnotationTrial.class)
@TrialRecursion
public class BeforeTrialNotStaticTrial extends SourceFileTrial {

	
	@BeforeTrial
	public void beforeTrial() {}
	
	@Test
	public void testFoo() {}

}
