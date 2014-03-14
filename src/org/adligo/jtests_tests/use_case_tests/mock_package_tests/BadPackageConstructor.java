package org.adligo.jtests_tests.use_case_tests.mock_package_tests;

import org.adligo.jtests.models.shared.Exhibit;
import org.adligo.jtests.models.shared.PackageTest;
import org.adligo.jtests.models.shared.PackageTestScope;

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
@PackageTestScope (testedPackageName = "org.adligo.jtests.foo")
public class BadPackageConstructor extends PackageTest {

	public BadPackageConstructor(String p) {}
	
	@Exhibit
	public void exhibitB() {}
}
