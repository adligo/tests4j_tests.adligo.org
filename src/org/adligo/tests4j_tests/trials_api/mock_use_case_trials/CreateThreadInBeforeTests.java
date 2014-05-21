package org.adligo.tests4j_tests.trials_api.mock_use_case_trials;

import org.adligo.tests4j.models.shared.Test;
import org.adligo.tests4j.models.shared.TrialRecursion;
import org.adligo.tests4j.models.shared.UseCaseScope;
import org.adligo.tests4j.models.shared.UseCaseTrial;

@UseCaseScope(system="tests4j.adligo.org",verb="reveal",nown="mistake")
public class CreateThreadInBeforeTests extends UseCaseTrial {

	public void beforeTests() {
		Thread t = new Thread();
	}
	
	@Test
	public void testNothing() {
		
	}
	
}
