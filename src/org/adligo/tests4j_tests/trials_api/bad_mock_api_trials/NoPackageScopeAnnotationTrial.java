package org.adligo.tests4j_tests.trials_api.bad_mock_api_trials;

import org.adligo.tests4j.models.shared.trials.ApiTrial;
import org.adligo.tests4j.models.shared.trials.TrialRecursion;

/**
 * note this test NOT RUN DIRECTLY 
 * as it is suppose to fail!
 * 
 * is run by another test 
 * @see RunClassTestUseCase
 * 
 * @author scott
 *
 */
@TrialRecursion
public class NoPackageScopeAnnotationTrial extends ApiTrial {

}
