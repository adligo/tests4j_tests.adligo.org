package org.adligo.tests4j_tests.api_trials.mock_source_file_trials;

import org.adligo.tests4j.models.shared.AfterTrial;
import org.adligo.tests4j.models.shared.SourceFileScope;
import org.adligo.tests4j.models.shared.SourceFileTrial;
import org.adligo.tests4j.models.shared.Test;
import org.adligo.tests4j.models.shared.TrialRecursion;

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
