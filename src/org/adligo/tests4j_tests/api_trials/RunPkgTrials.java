package org.adligo.tests4j_tests.api_trials;

import java.util.ArrayList;
import java.util.List;

import org.adligo.tests4j.models.shared.I_AbstractTrial;
import org.adligo.tests4j.models.shared.system.I_TrialList;
import org.adligo.tests4j.models.shared.system.Tests4J_Params;
import org.adligo.tests4j.run.Tests4J;
import org.adligo.tests4j_4jacoco.plugin.SimpleJacocoPlugin;

public class RunPkgTrials implements I_TrialList {

	
	public static void main(String [] args) {
		Tests4J_Params params = new Tests4J_Params();
		params.setCoveragePlugin(new SimpleJacocoPlugin());
		params.addTrials(new RunPkgTrials());
		Tests4J.run(params);
	}


	public static int getAssertions() {
		return 92;
	}
	

	@Override
	public List<Class<? extends I_AbstractTrial>> getTrials() {
		List<Class<? extends I_AbstractTrial>> trials = new ArrayList<Class<? extends I_AbstractTrial>>();
		
		trials.add(Run_UseCaseTrial_Trial.class);
		
		trials.add(Run_SourceFileTrial_Trial.class);
		trials.add(Run_ApiTrial_Trial.class);
	
		trials.add(Assert_PassConditions_Trial.class);
		
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
