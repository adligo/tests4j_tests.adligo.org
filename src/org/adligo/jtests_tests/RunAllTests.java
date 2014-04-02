package org.adligo.jtests_tests;

import java.util.ArrayList;
import java.util.List;

import org.adligo.jtests.reports.console.ConsoleTestRunner;
import org.adligo.jtests.reports.console.I_RunList;

public class RunAllTests {

	
	public static void main(String [] args) {
		List<I_RunList> runLists = getTests();
		
		ConsoleTestRunner.run(runLists, true);
		
	}

	private static List<I_RunList> getTests() {
		List<I_RunList> runLists = new ArrayList<I_RunList>();
		
		runLists.add(new org.adligo.jtests_tests.models.shared.system.RunPkgTrials());
		runLists.add(new org.adligo.jtests_tests.api_trials.RunPkgTrials());
		return runLists;
	}


}
