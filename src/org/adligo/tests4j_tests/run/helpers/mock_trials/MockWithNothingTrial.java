package org.adligo.tests4j_tests.run.helpers.mock_trials;

import org.adligo.tests4j.models.shared.trials.SourceFileScope;
import org.adligo.tests4j.models.shared.trials.SourceFileTrial;
import org.adligo.tests4j.models.shared.trials.Test;
import org.adligo.tests4j.models.shared.trials.TrialRecursion;
import org.adligo.tests4j_tests.run.helpers.class_loading_mocks.MockWithNothing;

@SourceFileScope (sourceClass=MockWithNothing.class)
@TrialRecursion
public class MockWithNothingTrial extends SourceFileTrial  {

	@Test
	public void testMockWithNothing() {
		//100% code coverage
		MockWithNothing mwn = new MockWithNothing();
		mwn.foo();
	}
	
}
