package org.adligo.tests4j_tests.api_trials.mock_source_file_trials;

import org.adligo.tests4j.models.shared.SourceFileScope;
import org.adligo.tests4j.models.shared.SourceFileTrial;
import org.adligo.tests4j.models.shared.Test;

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
@SourceFileScope (sourceClass = NoClassScopeAnnotationTrial.class)
public class BadConstructorTrial extends SourceFileTrial {

	public BadConstructorTrial(String p) {}
	
	@Test
	public void exhibitA() {}
}
