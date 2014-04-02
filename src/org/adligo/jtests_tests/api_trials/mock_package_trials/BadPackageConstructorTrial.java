package org.adligo.jtests_tests.api_trials.mock_package_trials;

import org.adligo.jtests.models.shared.Test;
import org.adligo.jtests.models.shared.API_Trial;
import org.adligo.jtests.models.shared.PackageScope;

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
@PackageScope (packageName = "org.adligo.jtests.foo")
public class BadPackageConstructorTrial extends API_Trial {

	public BadPackageConstructorTrial(String p) {}
	
	@Test
	public void exhibitB() {}
}
