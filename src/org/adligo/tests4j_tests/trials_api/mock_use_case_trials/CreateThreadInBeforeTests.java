package org.adligo.tests4j_tests.trials_api.mock_use_case_trials;

import org.adligo.tests4j.models.shared.trials.Test;
import org.adligo.tests4j.models.shared.trials.TrialRecursion;
import org.adligo.tests4j.models.shared.trials.UseCaseScope;
import org.adligo.tests4j.models.shared.trials.UseCaseTrial;

@UseCaseScope(system="tests4j.adligo.org",verb="reveal",nown="mistake")
public class CreateThreadInBeforeTests extends UseCaseTrial {

	public void beforeTests() {
		Thread t = new Thread();
	}
	
	@Test
	public void testNothing() {
		
	}
	
}
