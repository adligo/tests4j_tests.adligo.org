package org.adligo.tests4j_tests.trials_api.bad_mock_use_case_trials;

import org.adligo.tests4j.models.shared.trials.Test;
import org.adligo.tests4j.models.shared.trials.TrialRecursion;
import org.adligo.tests4j.models.shared.trials.UseCaseTrial;

/**
 * note this trial is run by the Run_UseCaseTrial_Trial,
 * and is intended to fail.
 * 
 * @author scott
 *
 */
@TrialRecursion
public class NoUseCaseAnnotationTrial extends UseCaseTrial {

	@Test
	public void testFoo() {}

}
