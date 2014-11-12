package org.adligo.tests4j_tests.trials_api.bad_mock_use_case_trials;

import org.adligo.tests4j.shared.asserts.common.I_Asserts;
import org.adligo.tests4j.system.shared.trials.Test;
import org.adligo.tests4j.system.shared.trials.TrialRecursion;
import org.adligo.tests4j.system.shared.trials.UseCaseScope;
import org.adligo.tests4j.system.shared.trials.UseCaseTrial;

@UseCaseScope(verb="reveal",nown="mistake")
public class CreateThreadInBeforeTests extends UseCaseTrial {

	public void beforeTests() {
		Thread t = new Thread();
	}
	
	@Test
	public void testNothing() {
		
	}
	
	public static void runTestDelegate(I_Asserts asserts) {

	}
	
	public static int getAsserts() {
		return 0;
	}
}
