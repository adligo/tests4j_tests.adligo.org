package org.adligo.tests4j_tests.api_trials.mock_api_trials;

import org.adligo.tests4j.models.shared.AfterTrialTests;
import org.adligo.tests4j.models.shared.ApiTrial;
import org.adligo.tests4j.models.shared.I_AfterApiTrialCoverage;
import org.adligo.tests4j.models.shared.PackageScope;
import org.adligo.tests4j.models.shared.Test;
import org.adligo.tests4j.models.shared.coverage.I_SourceFileCoverage;

/**
 * note this trial is run by the Run_UseCaseTrial_Trial,
 * and is intended to fail.
 * 
 * @author scott
 *
 */
@PackageScope (packageName = "org.adligo.tests4j.foo")
public class AfterTrialTestsStaticTrial extends ApiTrial {

	@Test
	public void testBar() {}
	
	@AfterTrialTests
	public static void afterTrialTests(I_AfterApiTrialCoverage p) {}
}
