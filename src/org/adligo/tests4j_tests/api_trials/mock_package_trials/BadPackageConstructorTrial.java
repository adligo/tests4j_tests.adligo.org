package org.adligo.tests4j_tests.api_trials.mock_package_trials;

import org.adligo.tests4j.models.shared.API_Trial;
import org.adligo.tests4j.models.shared.PackageScope;
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
@PackageScope (packageName = "org.adligo.tests4j.foo")
public class BadPackageConstructorTrial extends API_Trial {

	public BadPackageConstructorTrial(String p) {}
	
	@Test
	public void exhibitB() {}
}
