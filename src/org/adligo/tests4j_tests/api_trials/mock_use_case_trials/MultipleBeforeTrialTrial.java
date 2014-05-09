package org.adligo.tests4j_tests.api_trials.mock_use_case_trials;

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
public class MultipleBeforeTrialTrial extends UseCaseTrial {

	
	@BeforeTrial
	public static void beforeTrial() {}

	@BeforeTrial
	public static void beforeTrial2() {}
	
	@Test
	public void testFoo() {}

}