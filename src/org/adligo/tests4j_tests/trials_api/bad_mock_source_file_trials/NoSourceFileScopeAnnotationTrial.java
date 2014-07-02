package org.adligo.tests4j_tests.trials_api.bad_mock_source_file_trials;

import org.adligo.tests4j.models.shared.trials.SourceFileTrial;
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
public class NoSourceFileScopeAnnotationTrial extends SourceFileTrial {

}
