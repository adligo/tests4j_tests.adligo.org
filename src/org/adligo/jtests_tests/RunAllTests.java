package org.adligo.jtests_tests;

import java.util.ArrayList;
import java.util.List;

import org.adligo.jtests.reports.console.ConsoleTestRunner;
import org.adligo.jtests.reports.console.I_RunList;

public class RunAllTests {

	
	public static void main(String [] args) {
		List<I_RunList> runLists = new ArrayList<I_RunList>();
		
		runLists.add(new org.adligo.jtests_tests.models.shared.system.RunPkgTrials());
		runLists.add(new org.adligo.jtests_tests.use_case_trials.RunPkgTrials());
		
		ConsoleTestRunner.run(runLists, true);
		
	}


}
