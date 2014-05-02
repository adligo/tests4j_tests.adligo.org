package org.adligo.tests4j_tests.api_trials.mock_source_file_trials;

import org.adligo.tests4j.models.shared.AfterTrial;
import org.adligo.tests4j.models.shared.SourceFileScope;
import org.adligo.tests4j.models.shared.SourceFileTrial;
import org.adligo.tests4j.models.shared.Test;

/**
 * note this trial is run by the Run_SourceFileTrial_Trial,
 * and is intended to fail.
 * 
 * @author scott
 *
 */
@SourceFileScope (sourceClass = NoSourceFileScopeAnnotationTrial.class)
public class MultipleAfterTrialTrial extends SourceFileTrial {

	@AfterTrial
	public static void afterTrial() {}

	@AfterTrial
	public static void afterTrial2() {}
	
	@Test
	public void testFoo() {}

}
