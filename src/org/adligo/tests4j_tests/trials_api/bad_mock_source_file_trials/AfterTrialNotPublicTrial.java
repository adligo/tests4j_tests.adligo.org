package org.adligo.tests4j_tests.trials_api.bad_mock_source_file_trials;

import org.adligo.tests4j.models.shared.trials.AfterTrial;
import org.adligo.tests4j.models.shared.trials.SourceFileScope;
import org.adligo.tests4j.models.shared.trials.SourceFileTrial;
import org.adligo.tests4j.models.shared.trials.Test;
import org.adligo.tests4j.models.shared.trials.TrialRecursion;

/**
 * note this trial is run by the Run_UseCaseTrial_Trial,
 * and is intended to fail.
 * 
 * @author scott
 *
 */
@SourceFileScope (sourceClass = NoSourceFileScopeAnnotationTrial.class)
@TrialRecursion
public class AfterTrialNotPublicTrial extends SourceFileTrial {

	@AfterTrial
	protected static void afterTrial() {}
	
	@Test
	public void testFoo() {}

}
