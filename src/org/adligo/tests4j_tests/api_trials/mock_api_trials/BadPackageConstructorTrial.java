package org.adligo.tests4j_tests.api_trials.mock_api_trials;

import org.adligo.tests4j.models.shared.ApiTrial;
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
public class BadPackageConstructorTrial extends ApiTrial {

	public BadPackageConstructorTrial(String p) {}
	
	@Test
	public void exhibitB() {}
}
