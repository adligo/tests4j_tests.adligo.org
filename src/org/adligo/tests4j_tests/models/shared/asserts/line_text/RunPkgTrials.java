package org.adligo.tests4j_tests.models.shared.asserts.line_text;

import java.util.ArrayList;
import java.util.List;

import org.adligo.tests4j.models.shared.system.I_Tests4J_TrialList;
import org.adligo.tests4j.models.shared.system.Tests4J_Params;
import org.adligo.tests4j.models.shared.trials.I_Trial;
import org.adligo.tests4j.run.Tests4J;
import org.adligo.tests4j.run.helpers.Tests4J_ThreadFactory;
import org.adligo.tests4j.run.helpers.Tests4J_TrialsRunnable;
import org.adligo.tests4j_4jacoco.plugin.CoveragePluginFactory;
import org.adligo.tests4j_4jacoco.plugin.data.multi.MultiProbeDataStore;
import org.adligo.tests4j_4jacoco.plugin.data.multi.MultiProbesMap;
import org.adligo.tests4j_4jacoco.plugin.data.multi.ThreadGroupLocal;

public class RunPkgTrials implements I_Tests4J_TrialList {

	
	public static void main(String [] args) {
		Tests4J_Params params = new Tests4J_Params();
		params.addTrials(new RunPkgTrials());
		
		params.setLogState(Tests4J_ThreadFactory.class, true);
		params.setLogState(MultiProbeDataStore.class, true);
		params.setLogState(MultiProbesMap.class, true);
		params.setLogState(Tests4J_TrialsRunnable.class, true);
		params.setLogState(ThreadGroupLocal.class, true);
		
		params.setCoveragePluginFactoryClass(CoveragePluginFactory.class);
		Tests4J.run(params);
	}

	@Override
	public List<Class<? extends I_Trial>> getTrials() {
		List<Class<? extends I_Trial>> trials = new ArrayList<Class<? extends I_Trial>>();
		
		trials.add(DiffIndexesTrial.class);
		trials.add(DiffIndexesMutantTrial.class);
		trials.add(DiffIndexesPairTrial.class);
		
		trials.add(LineDiffMutantTrial.class);
		trials.add(LineDiffTrial.class);
		trials.add(LineDiffTypeTrial.class);
		trials.add(LineSplitterTrial.class);
		
		trials.add(TextLinesCompareResultTrial.class);
		trials.add(TextLinesCompareTrial.class);
		trials.add(TextLinesTrial.class);
		
		return trials;
	}
}
