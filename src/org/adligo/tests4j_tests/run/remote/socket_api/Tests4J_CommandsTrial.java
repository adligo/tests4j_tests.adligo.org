package org.adligo.tests4j_tests.run.remote.socket_api;

import org.adligo.tests4j.models.shared.trials.SourceFileScope;
import org.adligo.tests4j.models.shared.trials.Test;
import org.adligo.tests4j.run.remote.socket_api.Tests4J_Commands;
import org.adligo.tests4j_tests.base_trials.SourceFileCountingTrial;

@SourceFileScope (sourceClass=Tests4J_Commands.class, minCoverage=30.0)
public class Tests4J_CommandsTrial extends SourceFileCountingTrial {

	@Test
	public void testGetMinLength() {
		int minLength = Tests4J_Commands.getMinLength();
		assertEquals(3, minLength);
	}
	

	@Override
	public int getTests() {
		return 1;
	}

	@Override
	public int getAsserts() {
		return 1;
	}

	@Override
	public int getUniqueAsserts() {
		return 1;
	}
}
