package org.adligo.tests4j_tests.jacoco.api_trials;

import org.adligo.tests4j.system.shared.trials.AdditionalInstrumentation;
import org.adligo.tests4j.system.shared.trials.PackageScope;
import org.adligo.tests4j.system.shared.trials.Test;
import org.adligo.tests4j_tests.base_trials.ApiCountingTrial;
import org.adligo.tests4j_tests.base_trials.I_CountType;
import org.adligo.tests4j_tests.jacoco.api_trials.dependency_trials.CalledBadMethod_SourceFileTrialRunner;
import org.adligo.tests4j_tests.jacoco.api_trials.dependency_trials.CircularDependencyFailure_InPkgWhenOnlyInnerAllowed_SourceFileTrialRunner;
import org.adligo.tests4j_tests.jacoco.api_trials.dependency_trials.CircularDependencyFailure_SourceFileTrialRunner;

@PackageScope (packageName="org.adligo.tests4j_tests.jacoco.api_trials.dependency_trials")
@AdditionalInstrumentation (javaPackages="org.adligo.tests4j.models.shared.dependency," +
		"org.adligo.tests4j.models.shared.i18n," +
		"org.adligo.tests4j.models.shared.en," +
		"org.adligo.tests4j.models.shared.common," +
		"org.adligo.tests4j.models.shared.dependency," +
		"org.adligo.tests4j.models.shared.dependency_groups.gwt," +
		"org.adligo.tests4j_tests.run.helpers.class_loading_mocks")
public class DependencyAssertionFailuresTrial extends ApiCountingTrial {

	@Test
	public void testAssertionFailure_NotInDependencyGroup() throws Exception {
		CalledBadMethod_SourceFileTrialRunner.runTestDelegate(this);
	}
	
	@Test
	public void testAssertionFailure_CircularDependency() throws Exception {
		CircularDependencyFailure_SourceFileTrialRunner.runTestDelegate(this);
	}
	
	@Test
	public void testAssertionFailure_InPkgWhenOnlyInnerAllowed_CircularDependency() throws Exception {
		CircularDependencyFailure_InPkgWhenOnlyInnerAllowed_SourceFileTrialRunner.runTestDelegate(this);
	}
	
	@Override
	public int getTests(I_CountType type) {
		return super.getTests(type, 3);
	}

	@Override
	public int getAsserts(I_CountType type) {
		int thisAsserts = CalledBadMethod_SourceFileTrialRunner.getAsserts() +
				CircularDependencyFailure_SourceFileTrialRunner.getAsserts() +
				CircularDependencyFailure_InPkgWhenOnlyInnerAllowed_SourceFileTrialRunner.getAsserts();
		return super.getAsserts(type, thisAsserts);
	}

	@Override
	public int getUniqueAsserts(I_CountType type) {
		int thisUniqueAsserts = 97;
		return super.getUniqueAsserts(type, thisUniqueAsserts);
	}
}
