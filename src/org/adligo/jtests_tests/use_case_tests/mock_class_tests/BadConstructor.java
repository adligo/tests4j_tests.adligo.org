package org.adligo.jtests_tests.use_case_tests.mock_class_tests;

import org.adligo.jtests.models.shared.ClassTest;
import org.adligo.jtests.models.shared.ClassTestScope;
import org.adligo.jtests.models.shared.Exhibit;

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
@ClassTestScope (testedClass = NoClassScopeAnnotation.class)
public class BadConstructor extends ClassTest {

	public BadConstructor(String p) {}
	
	@Exhibit
	public void exhibitA() {}
}
