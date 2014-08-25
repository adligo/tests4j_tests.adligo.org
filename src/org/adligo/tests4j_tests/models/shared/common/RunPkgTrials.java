package org.adligo.tests4j_tests.models.shared.common;

import java.util.ArrayList;
import java.util.List;

import org.adligo.tests4j.models.shared.system.I_Tests4J_Controls;
import org.adligo.tests4j.models.shared.system.I_Tests4J_TrialList;
import org.adligo.tests4j.models.shared.system.Tests4J_Params;
import org.adligo.tests4j.models.shared.trials.I_Trial;
import org.adligo.tests4j.run.Tests4J;
import org.adligo.tests4j.run.helpers.Tests4J_Processor;
import org.adligo.tests4j.run.helpers.Tests4J_ThreadFactory;
import org.adligo.tests4j.run.helpers.Tests4J_TrialsRunnable;
import org.adligo.tests4j_4jacoco.plugin.CoveragePluginFactory;
import org.adligo.tests4j_4jacoco.plugin.data.multi.MultiProbeDataStore;
import org.adligo.tests4j_4jacoco.plugin.data.multi.MultiProbesMap;

public class RunPkgTrials implements I_Tests4J_TrialList {

	
	public static void main(String [] args) {
		Tests4J_Params params = new Tests4J_Params();
		params.addTrials(new RunPkgTrials());
		
		//params.setLogState(Tests4J_ThreadFactory.class, true);
		//params.setLogState(MultiProbeDataStore.class, true);
		//params.setLogState(MultiProbesMap.class, true);
		//params.setLogState(Tests4J_TrialsRunable.class, true);
		params.setLogState(Tests4J_Processor.class, true);
		
		params.setCoveragePluginFactoryClass(CoveragePluginFactory.class);
		I_Tests4J_Controls controls =  Tests4J.run(params);
		//controls.waitForResults();
	}

	@Override
	public List<Class<? extends I_Trial>> getTrials() {
		List<Class<? extends I_Trial>> trials = new ArrayList<Class<? extends I_Trial>>();
		
		trials.add(ClassRoutinesTrial.class);
		trials.add(DefaultSystemTrial.class);
		trials.add(I_ImmutableTrial.class);
		trials.add(I_PlatformContainerTrial.class);
		trials.add(I_PlatformTrial.class);
		trials.add(I_SystemTrial.class);
		trials.add(I_TrialTypeTrial.class);
		
		trials.add(MethodBlockerTrial.class);
		trials.add(PlatformTrial.class);
		trials.add(StringRoutinesTrial.class);
		trials.add(StackTraceBuilderTrial.class);
		trials.add(Tests4J_SystemTrial.class);
		trials.add(TrialTypeTrial.class);
		
		return trials;
	}
}
