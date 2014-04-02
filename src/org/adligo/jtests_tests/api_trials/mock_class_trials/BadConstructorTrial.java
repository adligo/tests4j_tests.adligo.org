package org.adligo.jtests_tests.api_trials.mock_class_trials;

import org.adligo.jtests.models.shared.ClassTrial;
import org.adligo.jtests.models.shared.ClassScope;
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
@ClassScope (testedClass = NoClassScopeAnnotationTrial.class)
public class BadConstructorTrial extends ClassTrial {

	public BadConstructorTrial(String p) {}
	
	@Test
	public void exhibitA() {}
}
