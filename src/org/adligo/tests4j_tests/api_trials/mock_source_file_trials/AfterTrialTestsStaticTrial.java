package org.adligo.tests4j_tests.api_trials.mock_source_file_trials;

import org.adligo.tests4j.models.shared.AfterTrialTests;
import org.adligo.tests4j.models.shared.I_AfterSourceFileTrialCoverage;
import org.adligo.tests4j.models.shared.SourceFileScope;
import org.adligo.tests4j.models.shared.SourceFileTrial;
import org.adligo.tests4j.models.shared.Test;

/**
 * note this trial is run by the Run_UseCaseTrial_Trial,
 * and is intended to fail.
 * 
 * @author scott
 *
 */
@SourceFileScope (sourceClass = NoSourceFileScopeAnnotationTrial.class)
public class AfterTrialTestsStaticTrial extends SourceFileTrial {

	@Test
	public void testBar() {}
	
	@AfterTrialTests
	public static void afterTrialTests(I_AfterSourceFileTrialCoverage p) {}
}
