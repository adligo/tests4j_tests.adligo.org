package org.adligo.tests4j_tests.trials_api;

import java.util.ArrayList;
import java.util.List;

import org.adligo.tests4j.models.shared.system.I_Tests4J_TrialList;
import org.adligo.tests4j.models.shared.system.Tests4J_Params;
import org.adligo.tests4j.models.shared.trials.I_Trial;
import org.adligo.tests4j.run.Tests4J;
import org.adligo.tests4j_4jacoco.plugin.ScopedJacocoPluginFactory;

public class RunPkgTrials implements I_Tests4J_TrialList {

	
	public static void main(String [] args) {
		Tests4J_Params params = new Tests4J_Params();
		params.addTrials(new RunPkgTrials());
		
		//Tests4J_Manager
		
		params.setCoveragePluginFactoryClass(ScopedJacocoPluginFactory.class);
		Tests4J.run(params);
	}


	public static int getAssertions() {
		return 92;
	}
	

	@Override
	public List<Class<? extends I_Trial>> getTrials() {
		List<Class<? extends I_Trial>> trials = new ArrayList<Class<? extends I_Trial>>();
		
		trials.add(AssertionsFail_Trial.class);
		trials.add(AssertionsPass_Trial.class);
		trials.add(AssertionsWithNullExpectedFail_Trial.class);
		trials.add(BadUseCaseTrials_Trial.class);
		
		trials.add(BadSourceFileTrials_Trial.class);
		trials.add(BadApiTrials_Trial.class);
	
		
		
		return trials;
	}

	public int getMinTests() {
		return 16;
	}

	public int getMinUniqueAssertions() {
		return 84;
	}

	public int getMinAsserts() {
		return 92;
	}
}
