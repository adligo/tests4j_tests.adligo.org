package org.adligo.tests4j_tests.run.helpers.mock_trials;

import org.adligo.tests4j.models.shared.trials.SourceFileScope;
import org.adligo.tests4j.models.shared.trials.SourceFileTrial;
import org.adligo.tests4j.models.shared.trials.Test;
import org.adligo.tests4j.models.shared.trials.TrialRecursion;
import org.adligo.tests4j_tests.run.helpers.class_loading_mocks.MockWithArray;

@SourceFileScope (sourceClass=MockWithArray.class)
@TrialRecursion
public class MockWithArrayTrial extends SourceFileTrial {

	@Test
	public void testMockWithArray() {
		//100% code coverage
		new MockWithArray();
	}
	
}
