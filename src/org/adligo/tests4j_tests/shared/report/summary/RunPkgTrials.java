package org.adligo.tests4j_tests.shared.report.summary;

import java.util.ArrayList;
import java.util.List;

import org.adligo.tests4j.models.shared.system.I_Tests4J_TrialList;
import org.adligo.tests4j.models.shared.system.Tests4J_Params;
import org.adligo.tests4j.models.shared.trials.I_Trial;
import org.adligo.tests4j.run.Tests4J;
import org.adligo.tests4j_4jacoco.plugin.ScopedJacocoPluginFactory;
import org.adligo.tests4j_4jacoco.plugin.TrialInstrumenter;
import org.adligo.tests4j_4jacoco.plugin.instrumentation.common.StrategySelectionInstrumenter;

public class RunPkgTrials implements I_Tests4J_TrialList {

	
	public static void main(String [] args) {
		Tests4J_Params params = new Tests4J_Params();
		params.addTrials(new RunPkgTrials());
		
		params.setLogState(TrialInstrumenter.class, true);
		
		params.setLogState(StrategySelectionInstrumenter.class, true);
		params.setCoveragePluginFactoryClass(ScopedJacocoPluginFactory.class);
		Tests4J.run(params);
	}

	@Override
	public List<Class<? extends I_Trial>> getTrials() {
		List<Class<? extends I_Trial>> trials = new ArrayList<Class<? extends I_Trial>>();
		
		trials.add(AbstractProgressDisplayTrial.class);
		trials.add(LineDiffTextDisplayTrial.class);
		
		trials.add(RemoteProgressDisplayTrial.class);
		trials.add(SetupProgressDisplayTrial.class);
		
		trials.add(TestDisplayTrial.class);
		trials.add(TestFailedDisplayTrial.class);
		
		trials.add(TestsProgressDisplayTrial.class);
		
		trials.add(TrialDisplayTrial.class);
		trials.add(TrialFailedDisplayTrial.class);
		trials.add(TrialFailedDetailDisplayTrial.class);
		trials.add(TrialsProgressDisplayTrial.class);
		return trials;
	}
}
