package org.adligo.jtests_tests;

import org.adligo.jacoco4jtests.run.JacocoRunner;
import org.adligo.jtests.models.shared.system.RunParameters;
import org.adligo.jtests.reports.console.ConsoleTestRunner;

public class RunAllTests {

	
	public static void main(String [] args) {
		RunParameters params = getTests();
		params.setCheckMins(true);
		params.setSilent(false);
		//ConsoleTestRunner.run(params);
		ConsoleTestRunner.run(params, new JacocoRunner());
		
	}

	private static RunParameters getTests() {
		RunParameters toRet = new RunParameters();
		
		toRet.addTrials(new org.adligo.jtests_tests.models.shared.system.RunPkgTrials());
		toRet.addTrials(new org.adligo.jtests_tests.api_trials.RunPkgTrials());
		return toRet;
	}


}
