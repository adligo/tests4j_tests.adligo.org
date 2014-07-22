package org.adligo.tests4j_tests.models.shared.asserts.uniform;

import java.util.ArrayList;
import java.util.List;

import org.adligo.tests4j.models.shared.system.I_Tests4J_TrialList;
import org.adligo.tests4j.models.shared.system.Tests4J_Params;
import org.adligo.tests4j.models.shared.trials.AbstractTrial;
import org.adligo.tests4j.models.shared.trials.I_AbstractTrial;
import org.adligo.tests4j.models.shared.trials.I_Trial;
import org.adligo.tests4j.run.Tests4J;
import org.adligo.tests4j.run.helpers.Tests4J_ThreadFactory;
import org.adligo.tests4j.run.helpers.Tests4J_TrialsRunable;
import org.adligo.tests4j_4jacoco.plugin.ScopedJacocoPluginFactory;
import org.adligo.tests4j_4jacoco.plugin.data.multi.MultiProbeDataStore;
import org.adligo.tests4j_4jacoco.plugin.data.multi.MultiProbesMap;

public class RunPkgTrials implements I_Tests4J_TrialList {

	
	public static void main(String [] args) {
		Tests4J_Params params = new Tests4J_Params();
		params.addTrials(new RunPkgTrials());
		
		List<Class<?>> loggingClasses = new ArrayList<Class<?>>(params.getLoggingClasses());
		loggingClasses.add(Tests4J_ThreadFactory.class);
		loggingClasses.add(MultiProbeDataStore.class);
		loggingClasses.add(MultiProbesMap.class);
		loggingClasses.add(Tests4J_TrialsRunable.class);
		params.setLoggingClasses(loggingClasses);
		
		params.setCoveragePluginFactoryClass(ScopedJacocoPluginFactory.class);
		Tests4J.run(params);
	}

	@Override
	public List<Class<? extends I_Trial>> getTrials() {
		List<Class<? extends I_Trial>> trials = new ArrayList<Class<? extends I_Trial>>();
		
		trials.add(EvaluationMutantTrial.class);
		trials.add(EvaluationTrial.class);
		trials.add(EvaluatorLookupMutantTrial.class);
		trials.add(EvaluatorLookupTrial.class);
		trials.add(StringUniformEvaluatorTrial.class);
		trials.add(ThrowableUniformEvaluatorTrial.class);
		return trials;
	}
}
