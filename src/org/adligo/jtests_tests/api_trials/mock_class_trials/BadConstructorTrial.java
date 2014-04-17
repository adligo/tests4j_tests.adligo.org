package org.adligo.jtests_tests.api_trials.mock_class_trials;

import org.adligo.jtests.models.shared.SourceFileTrial;
import org.adligo.jtests.models.shared.SourceFileScope;
import org.adligo.jtests.models.shared.Test;

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
@SourceFileScope (testedClass = NoClassScopeAnnotationTrial.class)
public class BadConstructorTrial extends SourceFileTrial {

	public BadConstructorTrial(String p) {}
	
	@Test
	public void exhibitA() {}
}
