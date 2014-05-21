package org.adligo.tests4j_tests.trials_api.mock_use_case_trials;

import org.adligo.tests4j.models.shared.BeforeTrial;
import org.adligo.tests4j.models.shared.Test;
import org.adligo.tests4j.models.shared.TrialRecursion;
import org.adligo.tests4j.models.shared.UseCaseScope;
import org.adligo.tests4j.models.shared.UseCaseTrial;

/**
 * note this trial is run by the Run_UseCaseTrial_Trial,
 * and is intended to fail.
 * 
 * @author scott
 *
 */
@UseCaseScope(system="tests4j.adligo.org",verb="reveal",nown="mistake")
@TrialRecursion
public class BeforeTrialHasParamsTrial extends UseCaseTrial {

	
	@BeforeTrial
	public static void beforeTrial(String p) {}
	
	@Test
	public void testFoo() {}

}
