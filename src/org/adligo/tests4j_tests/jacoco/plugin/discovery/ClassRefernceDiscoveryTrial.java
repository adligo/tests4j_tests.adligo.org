package org.adligo.tests4j_tests.jacoco.plugin.discovery;

import org.adligo.tests4j.models.shared.trials.Test;
import org.adligo.tests4j_tests.base_abstract_trials.SourceFileCountingTrial;

public class ClassRefernceDiscoveryTrial extends SourceFileCountingTrial {

	@Test
	public void testReferenceCounting_05_MockStaticField() throws Exception {
		
	}
	

	@Override
	public int getTests() {
		// TODO Auto-generated method stub
		return 1;
	}

	@Override
	public int getAsserts() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getUniqueAsserts() {
		// TODO Auto-generated method stub
		return 0;
	}
}
