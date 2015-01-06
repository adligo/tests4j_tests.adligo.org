package org.adligo.tests4j_tests.jacoco.api_trials;

import org.adligo.tests4j.system.shared.trials.AdditionalInstrumentation;
import org.adligo.tests4j.system.shared.trials.IgnoreTrial;
import org.adligo.tests4j.system.shared.trials.PackageScope;
import org.adligo.tests4j.system.shared.trials.Test;
import org.adligo.tests4j_tests.base_trials.ApiCountingTrial;
import org.adligo.tests4j_tests.base_trials.I_CountType;
import org.adligo.tests4j_tests.jacoco.api_trials.trial_delegates.CalledBadMethod_SourceFileTrialRunner;

@PackageScope (packageName="org.adligo.tests4j_4jacoco")
@AdditionalInstrumentation (javaPackages="org.adligo.tests4j.shared.asserts.reference," +
		"org.adligo.tests4j.models.shared.i18n," +
		"org.adligo.tests4j.models.shared.en," +
		"org.adligo.tests4j.models.shared.common," +
		"org.adligo.tests4j.models.shared.association," +
		"org.adligo.gwt_refs," +
		"org.adligo.gwt_refs.v2_6," +
    "org.adligo.tests4j_tests.run.helpers.class_loading_mocks")
public class ReferenceAssertionFailuresTrial extends ApiCountingTrial {

	@Test
	public void testAssertionFailure_NotInDependencyGroup() throws Exception {
		CalledBadMethod_SourceFileTrialRunner.runTestDelegate(this);
	}
	
	@Override
	public int getTests(I_CountType type) {
		return super.getTests(type, 1);
	}

	@Override
	public int getAsserts(I_CountType type) {
		int thisAsserts = CalledBadMethod_SourceFileTrialRunner.getAsserts();
		return super.getAsserts(type, thisAsserts);
	}

	@Override
	public int getUniqueAsserts(I_CountType type) {
		int thisUniqueAsserts = 35;
		return super.getUniqueAsserts(type, thisUniqueAsserts);
	}
}
