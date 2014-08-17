package org.adligo.tests4j_tests.jacoco.api_trials;

import java.util.ArrayList;
import java.util.List;

import org.adligo.tests4j.models.shared.system.I_Tests4J_TrialList;
import org.adligo.tests4j.models.shared.system.Tests4J_Params;
import org.adligo.tests4j.models.shared.trials.I_Trial;
import org.adligo.tests4j.run.Tests4J;
import org.adligo.tests4j.shared.report.summary.SummaryReporter;
import org.adligo.tests4j_4jacoco.plugin.CoveragePluginFactory;

public class RunPkgTrials implements I_Tests4J_TrialList {

	
	public static void main(String [] args) {
		Tests4J_Params params = new Tests4J_Params();
		params.addTrials(new RunPkgTrials());
		SummaryReporter reporter = new SummaryReporter();
		
		//reporter.setLogOn(Tests4J_NotificationManager.class);
		//reporter.setLogOn(TrialInstancesProcessor.class);
		//reporter.setLogOn(Tests4J_Memory.class);
		
		
		params.setCoveragePluginFactoryClass(CoveragePluginFactory.class);
		Tests4J.run(params);
	}


	public int getMinAsserts() {
		return 4;
	}
	
	public int getMinUniqueAssertions() {
		return 4;
	}
	
	public int getMinTests(){
		return 2;
	}

	@Override
	public List<Class<? extends I_Trial>> getTrials() {
		List<Class<? extends I_Trial>> trials = new ArrayList<Class<? extends I_Trial>>();
		
		trials.add(MultiRecordingTrial.class);
		return trials;
	}
}
