package org.adligo.jtests_tests;

import org.adligo.jacoco4jtests.run.JacocoRunner;
import org.adligo.jtests.models.shared.system.JTestParameters;
import org.adligo.jtests.reports.console.ConsoleTestRunner;

public class RunAllTests {

	
	public static void main(String [] args) {
		JTestParameters params = getTests();
		params.setCheckMins(true);
		params.setSilent(false);
		//ConsoleTestRunner.run(params);
		ConsoleTestRunner.run(params, new JacocoRunner());
		
	}

	private static JTestParameters getTests() {
		JTestParameters toRet = new JTestParameters();
		
		toRet.addTrials(new org.adligo.jtests_tests.models.shared.system.RunPkgTrials());
		toRet.addTrials(new org.adligo.jtests_tests.api_trials.RunPkgTrials());
		return toRet;
	}


}
