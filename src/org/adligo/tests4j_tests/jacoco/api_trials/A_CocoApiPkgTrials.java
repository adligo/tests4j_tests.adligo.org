package org.adligo.tests4j_tests.jacoco.api_trials;

import java.util.ArrayList;
import java.util.List;

import org.adligo.tests4j.models.shared.system.I_Tests4J_TrialList;
import org.adligo.tests4j.models.shared.system.Tests4J_Params;
import org.adligo.tests4j.models.shared.trials.I_Trial;
import org.adligo.tests4j.models.shared.trials.I_TrialParams;
import org.adligo.tests4j.run.Tests4J;
import org.adligo.tests4j.shared.report.summary.SummaryReporter;
import org.adligo.tests4j.shared.report.summary.TestDisplay;
import org.adligo.tests4j.shared.report.summary.TrialDisplay;
import org.adligo.tests4j_4jacoco.plugin.CoveragePluginFactory;
import org.adligo.tests4j_tests.base_trials.I_CountingPackageTrials;
import org.adligo.tests4j_tests.base_trials.SimpleMetaTrial;
import org.adligo.tests4j_tests.base_trials.SimplePackageTrials;
import org.adligo.tests4j_tests.jacoco.plugin.A_CocoJavaVersionSpecificTrials;
import org.adligo.tests4j_tests.jacoco.plugin.A_CocoPlugPkgTrials;
import org.adligo.tests4j_tests.jacoco.plugin.data.common.A_CocoDataCmnPkgTrials;

public class A_CocoApiPkgTrials extends SimplePackageTrials 
implements I_TrialParams<A_CocoApiPkgTrials>, I_CountingPackageTrials {
	private A_CocoDataCmnPkgTrials dataCommon = new A_CocoDataCmnPkgTrials();
	private A_CocoJavaVersionSpecificTrials javaVersionTrials = new A_CocoJavaVersionSpecificTrials();
	
	public static void main(String [] args) {
		try {
			Tests4J_Params params = new Tests4J_Params();
			params.setCoveragePluginFactoryClass(CoveragePluginFactory.class);
			params.setMetaTrialClass(SimpleMetaTrial.class);
			
			A_CocoApiPkgTrials me = new A_CocoApiPkgTrials();
			me.setParams(params);

			me.addTrials();
			
			params.setMetaTrialParams(me);
			params.addTrials(me);
			//params.setLogState(Tests4J_TrialsRunable.class, true);
			//params.setLogState(MultiProbesMap.class, true);
			params.setLogState(TrialDisplay.class, false);
			params.setLogState(TestDisplay.class, true);
			//params.setLogState(ClassReferencesDiscovery.class, true);
			//params.setLogState(ClassInstrumenter.class, true);
			//params.setLogState(OrderedClassDiscovery.class, true);
			
			Tests4J.run(params);
		} catch (Exception x) {
			x.printStackTrace();
		}
	}

	public void addTrials() {
	}

	@Override
	public A_CocoApiPkgTrials getTrialParams() {
		return this;
	}
}
