package org.adligo.tests4j_tests.jacoco.plugin.factories;

import org.adligo.tests4j.run.api.Tests4J;
import org.adligo.tests4j.run.helpers.AfterSourceFileTrialTestsProcessor;
import org.adligo.tests4j.system.shared.api.Tests4J_Params;
import org.adligo.tests4j.system.shared.report.summary.TestDisplay;
import org.adligo.tests4j.system.shared.report.summary.TrialDisplay;
import org.adligo.tests4j.system.shared.trials.I_MetaTrialParams;
import org.adligo.tests4j_4jacoco.plugin.Recorder;
import org.adligo.tests4j_4jacoco.plugin.data.coverage.LazyPackageCoverage;
import org.adligo.tests4j_4jacoco.plugin.factories.MockitoPluginFactory;
import org.adligo.tests4j_tests.base_trials.I_CountingPackageTrials;
import org.adligo.tests4j_tests.base_trials.SimpleMetaTrial;
import org.adligo.tests4j_tests.base_trials.SimplePackageTrials;

public class A_CocoPlugFactoriesPkgTrials extends SimplePackageTrials 
implements I_MetaTrialParams<A_CocoPlugFactoriesPkgTrials>, I_CountingPackageTrials {
	
	public static void main(String [] args) {
		try {
			Tests4J_Params params = new Tests4J_Params();
			params.setCoveragePluginFactoryClass(MockitoPluginFactory.class);
			params.setMetaTrialClass(SimpleMetaTrial.class);
			
			A_CocoPlugFactoriesPkgTrials me = new A_CocoPlugFactoriesPkgTrials();
			me.setParams(params);

			me.addTrials();
			
			params.setMetaTrialParams(me);
			params.addTrials(me);
			//params.setLogState(Tests4J_TrialsRunable.class, true);
			//params.setLogState(MultiProbesMap.class, true);
			params.setLogState(TrialDisplay.class, false);
			params.setLogState(TestDisplay.class, true);
			params.setLogState(LazyPackageCoverage.class, true);
			params.setLogState(AfterSourceFileTrialTestsProcessor.class, true);
			params.setLogState(Recorder.class, true);
			//params.setLogState(ClassInstrumenter.class, true);
			//params.setLogState(OrderedClassDiscovery.class, true);
			
			Tests4J.run(params);
		} catch (Exception x) {
			x.printStackTrace();
		}
	}

	public void addTrials() throws Exception{
		add(MockitoPluginFactoryTrial.class);
	}

	@Override
	public A_CocoPlugFactoriesPkgTrials getTrialParams() {
		return this;
	}

}
