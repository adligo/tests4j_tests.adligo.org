package org.adligo.jtests_tests.api_trials;

import java.util.ArrayList;
import java.util.List;

import org.adligo.jtests.models.shared.I_AbstractTrial;
import org.adligo.jtests.models.shared.system.I_TrialList;
import org.adligo.jtests.models.shared.system.JTestParameters;
import org.adligo.jtests.reports.console.ConsoleTestRunner;

public class RunPkgTrials implements I_TrialList {

	
	public static void main(String [] args) {
		JTestParameters params = new JTestParameters();
		params.addTrials(new RunPkgTrials());
		ConsoleTestRunner.run(params);
	}


	public static int getAssertions() {
		return 92;
	}
	

	@Override
	public List<Class<? extends I_AbstractTrial>> getTrials() {
		List<Class<? extends I_AbstractTrial>> trials = new ArrayList<Class<? extends I_AbstractTrial>>();
		
		trials.add(Run_UseCaseTrial_Trial.class);
		trials.add(Run_ClassTrial_Trial.class);
		trials.add(Run_ApiTrial_Trial.class);
	
		trials.add(Assert_PassConditions_Trial.class);
		return trials;
	}

	@Override
	public int getMinTests() {
		return 16;
	}

	@Override
	public int getMinUniqueAssertions() {
		return 84;
	}

	@Override
	public int getMinAsserts() {
		return 92;
	}
}
