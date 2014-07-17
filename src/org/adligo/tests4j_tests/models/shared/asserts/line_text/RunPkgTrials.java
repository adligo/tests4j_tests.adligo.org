package org.adligo.tests4j_tests.models.shared.asserts.line_text;

import java.util.ArrayList;
import java.util.List;

import org.adligo.tests4j.models.shared.system.I_TrialList;
import org.adligo.tests4j.models.shared.system.Tests4J_Params;
import org.adligo.tests4j.models.shared.trials.AbstractTrial;
import org.adligo.tests4j.run.Tests4J;
import org.adligo.tests4j.run.helpers.Tests4J_ThreadFactory;
import org.adligo.tests4j.run.helpers.TrialInstancesProcessor;
import org.adligo.tests4j_4jacoco.plugin.ScopedJacocoPlugin;
import org.adligo.tests4j_4jacoco.plugin.data.multi.MultiProbeDataStore;
import org.adligo.tests4j_4jacoco.plugin.data.multi.MultiProbesMap;
import org.adligo.tests4j_4jacoco.plugin.data.multi.ThreadGroupLocal;

public class RunPkgTrials implements I_TrialList {

	
	public static void main(String [] args) {
		Tests4J_Params params = new Tests4J_Params();
		params.addTrials(new RunPkgTrials());
		
		List<Class<?>> loggingClasses = new ArrayList<Class<?>>(params.getLoggingClasses());
		loggingClasses.add(Tests4J_ThreadFactory.class);
		loggingClasses.add(MultiProbeDataStore.class);
		loggingClasses.add(MultiProbesMap.class);
		loggingClasses.add(TrialInstancesProcessor.class);
		loggingClasses.add(ThreadGroupLocal.class);
		params.setLoggingClasses(loggingClasses);
		
		params.setCoveragePluginClass(ScopedJacocoPlugin.class);
		Tests4J.run(params);
	}

	@Override
	public List<Class<? extends AbstractTrial>> getTrials() {
		List<Class<? extends AbstractTrial>> trials = new ArrayList<Class<? extends AbstractTrial>>();
		
		trials.add(DiffIndexesTrial.class);
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
