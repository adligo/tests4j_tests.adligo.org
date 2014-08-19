package org.adligo.tests4j_tests.models.shared.asserts;

import java.util.ArrayList;
import java.util.List;

import org.adligo.tests4j.models.shared.system.I_Tests4J_TrialList;
import org.adligo.tests4j.models.shared.system.Tests4J_Params;
import org.adligo.tests4j.models.shared.trials.I_Trial;
import org.adligo.tests4j.run.Tests4J;
import org.adligo.tests4j.shared.report.summary.TestDisplay;
import org.adligo.tests4j.shared.report.summary.TrialDisplay;
import org.adligo.tests4j_4jacoco.plugin.CoveragePluginFactory;
import org.adligo.tests4j_4jacoco.plugin.discovery.OrderedClassDiscovery;
import org.adligo.tests4j_4jacoco.plugin.instrumentation.ClassInstrumenter;

public class RunPkgTrials implements I_Tests4J_TrialList {

	
	public static void main(String [] args) {
		Tests4J_Params params = new Tests4J_Params();
		params.addTrials(new RunPkgTrials());
		//params.setLogState(Tests4J_TrialsRunable.class, true);
		//params.setLogState(MultiProbesMap.class, true);
		params.setLogState(TrialDisplay.class, false);
		params.setLogState(TestDisplay.class, true);
		//params.setLogState(ClassReferencesDiscovery.class, true);
		params.setLogState(ClassInstrumenter.class, true);
		params.setLogState(OrderedClassDiscovery.class, true);
		params.setCoveragePluginFactoryClass(CoveragePluginFactory.class);
		
		Tests4J.run(params);
	}

	@Override
	public List<Class<? extends I_Trial>> getTrials() {
		List<Class<? extends I_Trial>> trials = new ArrayList<Class<? extends I_Trial>>();
		//dependency order is important
		trials.addAll(new org.adligo.tests4j_tests.models.shared.asserts.common.RunPkgTrials().getTrials());
		trials.addAll(new org.adligo.tests4j_tests.models.shared.asserts.line_text.RunPkgTrials().getTrials());
		trials.addAll(new org.adligo.tests4j_tests.models.shared.asserts.uniform.RunPkgTrials().getTrials());
		
		trials.add(AbstractAssertCommandTrial.class);
		trials.add(AbstractCompareAssertCommandTrial.class);
		trials.add(AssertionFailureLocationTrial.class);
		trials.add(AssertionProcessorTrial.class);
		trials.add(BooleanAssertCommandTrial.class);
		trials.add(ContainsAssertCommandTrial.class);
		trials.add(DoubleAssertCommandTrial.class);
		trials.add(IdenticalAssertCommandTrial.class);
		trials.add(IdenticalStringAssertCommandTrial.class);
		
		trials.add(ThrownAssertCommandTrial.class);
		trials.add(UniformAssertCommandTrial.class);
		trials.add(UniformThrownAssertCommandTrial.class);
		
		
		
		return trials;
	}
}
