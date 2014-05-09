package org.adligo.tests4j_tests.api_trials.mock_use_case_trials;

import org.adligo.tests4j.models.shared.Test;
import org.adligo.tests4j.models.shared.TrialRecursion;
import org.adligo.tests4j.models.shared.UseCaseTrial;

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
