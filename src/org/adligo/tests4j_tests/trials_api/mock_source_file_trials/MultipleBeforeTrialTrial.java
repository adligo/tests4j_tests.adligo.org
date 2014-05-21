package org.adligo.tests4j_tests.trials_api.mock_source_file_trials;

import org.adligo.tests4j.models.shared.BeforeTrial;
import org.adligo.tests4j.models.shared.SourceFileScope;
import org.adligo.tests4j.models.shared.SourceFileTrial;
import org.adligo.tests4j.models.shared.Test;
import org.adligo.tests4j.models.shared.TrialRecursion;

/**
 * note this trial is run by the Run_SourceFileTrial_Trial,
 * and is intended to fail.
 * 
 * @author scott
 *
 */
@SourceFileScope (sourceClass = NoSourceFileScopeAnnotationTrial.class)
@TrialRecursion
public class MultipleBeforeTrialTrial extends SourceFileTrial {

	@BeforeTrial
	public static void beforeTrial() {}

	@BeforeTrial
	public static void beforeTrial2() {}
	
	@Test
	public void testFoo() {}

}
